package org.litepal.crud;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class Many2ManyAnalyzer
  extends AssociationsAnalyzer
{
  private void addNewModelForAssociatedModel(Collection<LitePalSupport> paramCollection, LitePalSupport paramLitePalSupport)
  {
    if (!paramCollection.contains(paramLitePalSupport)) {
      paramCollection.add(paramLitePalSupport);
    }
  }
  
  private void dealAssociatedModel(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    if (paramLitePalSupport2.isSaved()) {
      paramLitePalSupport1.addAssociatedModelForJoinTable(paramLitePalSupport2.getTableName(), paramLitePalSupport2.getBaseObjId());
    }
  }
  
  private void declareAssociations(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
  {
    paramLitePalSupport.addEmptyModelForJoinTable(getAssociatedTableName(paramAssociationsInfo));
  }
  
  private String getAssociatedTableName(AssociationsInfo paramAssociationsInfo)
  {
    return BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramAssociationsInfo.getAssociatedClassName()));
  }
  
  private String getJoinTableName(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    return getIntermediateTableName(paramLitePalSupport1, paramLitePalSupport2.getTableName());
  }
  
  private String getSelection(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getForeignKeyColumnName(paramLitePalSupport1.getTableName()));
    localStringBuilder.append(" = ? and ");
    localStringBuilder.append(getForeignKeyColumnName(paramLitePalSupport2.getTableName()));
    localStringBuilder.append(" = ?");
    return localStringBuilder.toString();
  }
  
  private String[] getSelectionArgs(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    return new String[] { String.valueOf(paramLitePalSupport1.getBaseObjId()), String.valueOf(paramLitePalSupport2.getBaseObjId()) };
  }
  
  /* Error */
  @Deprecated
  private boolean isDataExists(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    // Byte code:
    //   0: invokestatic 111	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   3: astore 7
    //   5: iconst_1
    //   6: istore 4
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 7
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokespecial 113	org/litepal/crud/Many2ManyAnalyzer:getJoinTableName	(Lorg/litepal/crud/LitePalSupport;Lorg/litepal/crud/LitePalSupport;)Ljava/lang/String;
    //   22: aconst_null
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: invokespecial 115	org/litepal/crud/Many2ManyAnalyzer:getSelection	(Lorg/litepal/crud/LitePalSupport;Lorg/litepal/crud/LitePalSupport;)Ljava/lang/String;
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: invokespecial 117	org/litepal/crud/Many2ManyAnalyzer:getSelectionArgs	(Lorg/litepal/crud/LitePalSupport;Lorg/litepal/crud/LitePalSupport;)[Ljava/lang/String;
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 123	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface 129 1 0
    //   48: istore_3
    //   49: iload_3
    //   50: ifle +6 -> 56
    //   53: goto +6 -> 59
    //   56: iconst_0
    //   57: istore 4
    //   59: aload_1
    //   60: invokeinterface 132 1 0
    //   65: iload 4
    //   67: ireturn
    //   68: astore_2
    //   69: aload_1
    //   70: astore 5
    //   72: aload_2
    //   73: astore_1
    //   74: goto +30 -> 104
    //   77: astore_2
    //   78: goto +11 -> 89
    //   81: astore_1
    //   82: goto +22 -> 104
    //   85: astore_2
    //   86: aload 6
    //   88: astore_1
    //   89: aload_1
    //   90: astore 5
    //   92: aload_2
    //   93: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   96: aload_1
    //   97: invokeinterface 132 1 0
    //   102: iconst_1
    //   103: ireturn
    //   104: aload 5
    //   106: invokeinterface 132 1 0
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	Many2ManyAnalyzer
    //   0	113	1	paramLitePalSupport1	LitePalSupport
    //   0	113	2	paramLitePalSupport2	LitePalSupport
    //   48	2	3	i	int
    //   6	60	4	bool	boolean
    //   12	93	5	localLitePalSupport	LitePalSupport
    //   9	78	6	localObject	Object
    //   3	12	7	localSQLiteDatabase	net.sqlcipher.database.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   42	49	68	finally
    //   42	49	77	java/lang/Exception
    //   14	42	81	finally
    //   92	96	81	finally
    //   14	42	85	java/lang/Exception
  }
  
  void analyze(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = getAssociatedModels(paramLitePalSupport, paramAssociationsInfo);
    declareAssociations(paramLitePalSupport, paramAssociationsInfo);
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LitePalSupport localLitePalSupport = (LitePalSupport)((Iterator)localObject).next();
        Collection localCollection = checkAssociatedModelCollection(getReverseAssociatedModels(localLitePalSupport, paramAssociationsInfo), paramAssociationsInfo.getAssociateSelfFromOtherModel());
        addNewModelForAssociatedModel(localCollection, paramLitePalSupport);
        setReverseAssociatedModels(localLitePalSupport, paramAssociationsInfo, localCollection);
        dealAssociatedModel(paramLitePalSupport, localLitePalSupport);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\Many2ManyAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */