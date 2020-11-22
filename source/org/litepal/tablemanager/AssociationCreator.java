package org.litepal.tablemanager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

public abstract class AssociationCreator
  extends Generator
{
  private void addAssociations(Collection<AssociationsModel> paramCollection, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      AssociationsModel localAssociationsModel = (AssociationsModel)paramCollection.next();
      if ((2 != localAssociationsModel.getAssociationType()) && (1 != localAssociationsModel.getAssociationType()))
      {
        if (3 == localAssociationsModel.getAssociationType()) {
          createIntermediateTable(localAssociationsModel.getTableName(), localAssociationsModel.getAssociatedTableName(), paramSQLiteDatabase, paramBoolean);
        }
      }
      else {
        addForeignKeyColumn(localAssociationsModel.getTableName(), localAssociationsModel.getAssociatedTableName(), localAssociationsModel.getTableHoldsForeignKey(), paramSQLiteDatabase);
      }
    }
    paramCollection = getGenericModels().iterator();
    while (paramCollection.hasNext()) {
      createGenericTable((GenericModel)paramCollection.next(), paramSQLiteDatabase, paramBoolean);
    }
  }
  
  private void createGenericTable(GenericModel paramGenericModel, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    String str1 = paramGenericModel.getTableName();
    Object localObject = paramGenericModel.getValueColumnName();
    String str2 = paramGenericModel.getValueColumnType();
    String str3 = paramGenericModel.getValueIdColumnName();
    paramGenericModel = new ArrayList();
    ColumnModel localColumnModel = new ColumnModel();
    localColumnModel.setColumnName((String)localObject);
    localColumnModel.setColumnType(str2);
    localObject = new ColumnModel();
    ((ColumnModel)localObject).setColumnName(str3);
    ((ColumnModel)localObject).setColumnType("integer");
    paramGenericModel.add(localColumnModel);
    paramGenericModel.add(localObject);
    localObject = new ArrayList();
    if (DBUtility.isTableExists(str1, paramSQLiteDatabase))
    {
      if (paramBoolean)
      {
        ((List)localObject).add(generateDropTableSQL(str1));
        ((List)localObject).add(generateCreateTableSQL(str1, paramGenericModel, false));
      }
    }
    else {
      ((List)localObject).add(generateCreateTableSQL(str1, paramGenericModel, false));
    }
    execute((List)localObject, paramSQLiteDatabase);
    giveTableSchemaACopy(str1, 2, paramSQLiteDatabase);
  }
  
  private void createIntermediateTable(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    ColumnModel localColumnModel = new ColumnModel();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_id");
    localColumnModel.setColumnName(((StringBuilder)localObject).toString());
    localColumnModel.setColumnType("integer");
    localObject = new ColumnModel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_id");
    ((ColumnModel)localObject).setColumnName(localStringBuilder.toString());
    ((ColumnModel)localObject).setColumnType("integer");
    localArrayList.add(localColumnModel);
    localArrayList.add(localObject);
    paramString1 = DBUtility.getIntermediateTableName(paramString1, paramString2);
    paramString2 = new ArrayList();
    if (DBUtility.isTableExists(paramString1, paramSQLiteDatabase))
    {
      if (paramBoolean)
      {
        paramString2.add(generateDropTableSQL(paramString1));
        paramString2.add(generateCreateTableSQL(paramString1, localArrayList, false));
      }
    }
    else {
      paramString2.add(generateCreateTableSQL(paramString1, localArrayList, false));
    }
    execute(paramString2, paramSQLiteDatabase);
    giveTableSchemaACopy(paramString1, 1, paramSQLiteDatabase);
  }
  
  private boolean isContainsOnlyIdField(List<ColumnModel> paramList)
  {
    int i = paramList.size();
    boolean bool2 = false;
    boolean bool1;
    if ((i != 0) && ((paramList.size() != 1) || (!isIdColumn(((ColumnModel)paramList.get(0)).getColumnName()))))
    {
      bool1 = bool2;
      if (paramList.size() == 2)
      {
        bool1 = bool2;
        if (isIdColumn(((ColumnModel)paramList.get(0)).getColumnName()))
        {
          bool1 = bool2;
          if (!isIdColumn(((ColumnModel)paramList.get(1)).getColumnName())) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean isNeedtoGiveACopy(Cursor paramCursor, String paramString)
  {
    return (!isValueExists(paramCursor, paramString)) && (!isSpecialTable(paramString));
  }
  
  private boolean isSpecialTable(String paramString)
  {
    return "table_schema".equalsIgnoreCase(paramString);
  }
  
  private boolean isValueExists(Cursor paramCursor, String paramString)
  {
    if (paramCursor.moveToFirst()) {
      do
      {
        if (paramCursor.getString(paramCursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(paramString)) {
          return true;
        }
      } while (paramCursor.moveToNext());
    }
    return false;
  }
  
  protected void addForeignKeyColumn(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    if (DBUtility.isTableExists(paramString1, paramSQLiteDatabase))
    {
      if (DBUtility.isTableExists(paramString2, paramSQLiteDatabase))
      {
        String str = null;
        if (paramString1.equals(paramString3)) {
          str = getForeignKeyColumnName(paramString2);
        } else if (paramString2.equals(paramString3)) {
          str = getForeignKeyColumnName(paramString1);
        }
        if (!DBUtility.isColumnExists(str, paramString3, paramSQLiteDatabase))
        {
          paramString1 = new ColumnModel();
          paramString1.setColumnName(str);
          paramString1.setColumnType("integer");
          paramString2 = new ArrayList();
          paramString2.add(generateAddColumnSQL(paramString3, paramString1));
          execute(paramString2, paramSQLiteDatabase);
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("column ");
        paramString1.append(str);
        paramString1.append(" is already exist, no need to add one");
        LitePalLog.d("Generator", paramString1.toString());
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Table doesn't exist with the name of ");
      paramString1.append(paramString2);
      throw new DatabaseGenerateException(paramString1.toString());
    }
    paramString2 = new StringBuilder();
    paramString2.append("Table doesn't exist with the name of ");
    paramString2.append(paramString1);
    throw new DatabaseGenerateException(paramString2.toString());
  }
  
  protected void addOrUpdateAssociation(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    addAssociations(getAllAssociations(), paramSQLiteDatabase, paramBoolean);
  }
  
  protected abstract void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean);
  
  protected String generateAddColumnSQL(String paramString, ColumnModel paramColumnModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alter table ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" add column ");
    localStringBuilder.append(paramColumnModel.getColumnName());
    localStringBuilder.append(" ");
    localStringBuilder.append(paramColumnModel.getColumnType());
    if (!paramColumnModel.isNullable()) {
      localStringBuilder.append(" not null");
    }
    if (paramColumnModel.isUnique()) {
      localStringBuilder.append(" unique");
    }
    paramString = paramColumnModel.getDefaultValue();
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append(" default ");
      localStringBuilder.append(paramString);
    }
    else if (!paramColumnModel.isNullable())
    {
      if ("integer".equalsIgnoreCase(paramColumnModel.getColumnType())) {
        paramString = "0";
      } else if ("text".equalsIgnoreCase(paramColumnModel.getColumnType())) {
        paramString = "''";
      } else if ("real".equalsIgnoreCase(paramColumnModel.getColumnType())) {
        paramString = "0.0";
      }
      localStringBuilder.append(" default ");
      localStringBuilder.append(paramString);
    }
    paramString = new StringBuilder();
    paramString.append("add column sql is >> ");
    paramString.append(localStringBuilder);
    LitePalLog.d("Generator", paramString.toString());
    return localStringBuilder.toString();
  }
  
  protected String generateCreateTableSQL(String paramString, List<ColumnModel> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("create table ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    if (paramBoolean) {
      localStringBuilder.append("id integer primary key autoincrement,");
    }
    if (isContainsOnlyIdField(paramList)) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    int i = 0;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ColumnModel)paramString.next();
      if (!paramList.isIdColumn())
      {
        if (i != 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(paramList.getColumnName());
        localStringBuilder.append(" ");
        localStringBuilder.append(paramList.getColumnType());
        if (!paramList.isNullable()) {
          localStringBuilder.append(" not null");
        }
        if (paramList.isUnique()) {
          localStringBuilder.append(" unique");
        }
        paramList = paramList.getDefaultValue();
        if (!TextUtils.isEmpty(paramList))
        {
          localStringBuilder.append(" default ");
          localStringBuilder.append(paramList);
        }
        i = 1;
      }
    }
    localStringBuilder.append(")");
    paramString = new StringBuilder();
    paramString.append("create table sql is >> ");
    paramString.append(localStringBuilder);
    LitePalLog.d("Generator", paramString.toString());
    return localStringBuilder.toString();
  }
  
  protected String generateDropTableSQL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drop table if exists ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  protected void giveTableSchemaACopy(String paramString, int paramInt, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 118	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 299
    //   7: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload 5
    //   14: ldc -97
    //   16: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: new 118	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc_w 301
    //   34: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload 5
    //   42: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc -54
    //   48: aload 4
    //   50: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 208	org/litepal/util/LitePalLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 4
    //   62: aload_3
    //   63: aload 5
    //   65: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aconst_null
    //   69: invokevirtual 307	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   72: astore 5
    //   74: aload_0
    //   75: aload 5
    //   77: aload_1
    //   78: invokespecial 309	org/litepal/tablemanager/AssociationCreator:isNeedtoGiveACopy	(Lnet/sqlcipher/Cursor;Ljava/lang/String;)Z
    //   81: ifeq +45 -> 126
    //   84: new 311	android/content/ContentValues
    //   87: dup
    //   88: invokespecial 312	android/content/ContentValues:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc -85
    //   97: aload_1
    //   98: invokestatic 317	org/litepal/util/BaseUtility:changeCase	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual 320	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload 4
    //   106: ldc_w 322
    //   109: iload_2
    //   110: invokestatic 328	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: invokevirtual 331	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   116: aload_3
    //   117: ldc -97
    //   119: aconst_null
    //   120: aload 4
    //   122: invokevirtual 335	net/sqlcipher/database/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   125: pop2
    //   126: aload 5
    //   128: ifnull +51 -> 179
    //   131: aload 5
    //   133: invokeinterface 338 1 0
    //   138: return
    //   139: astore_1
    //   140: goto +40 -> 180
    //   143: astore_3
    //   144: aload 5
    //   146: astore_1
    //   147: goto +15 -> 162
    //   150: astore_1
    //   151: aload 4
    //   153: astore 5
    //   155: goto +25 -> 180
    //   158: astore_3
    //   159: aload 6
    //   161: astore_1
    //   162: aload_1
    //   163: astore 4
    //   165: aload_3
    //   166: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 338 1 0
    //   179: return
    //   180: aload 5
    //   182: ifnull +10 -> 192
    //   185: aload 5
    //   187: invokeinterface 338 1 0
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	AssociationCreator
    //   0	194	1	paramString	String
    //   0	194	2	paramInt	int
    //   0	194	3	paramSQLiteDatabase	SQLiteDatabase
    //   27	137	4	localObject1	Object
    //   10	176	5	localObject2	Object
    //   57	103	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	126	139	finally
    //   74	126	143	java/lang/Exception
    //   62	74	150	finally
    //   165	169	150	finally
    //   62	74	158	java/lang/Exception
  }
  
  protected boolean isForeignKeyColumnFormat(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (paramString.toLowerCase(Locale.US).endsWith("_id"))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("_id")) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\AssociationCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */