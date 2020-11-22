package org.litepal.crud;

import android.content.ContentValues;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.FluentQuery;
import org.litepal.Operator;
import org.litepal.annotation.Encrypt;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class UpdateHandler
  extends DataHandler
{
  public UpdateHandler(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  private void analyzeAssociations(LitePalSupport paramLitePalSupport)
  {
    try
    {
      analyzeAssociatedModels(paramLitePalSupport, getAssociationInfo(paramLitePalSupport.getClassName()));
      return;
    }
    catch (Exception paramLitePalSupport)
    {
      throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
    }
  }
  
  private void convertContentValues(ContentValues paramContentValues)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Object localObject1 = new HashMap();
      Object localObject2 = paramContentValues.keySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (DBUtility.isFieldNameConflictWithSQLiteKeywords((String)localObject3)) {
          ((Map)localObject1).put(localObject3, paramContentValues.get((String)localObject3));
        }
      }
      localObject1 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        localObject2 = DBUtility.convertToValidColumnName(str);
        localObject3 = paramContentValues.get(str);
        paramContentValues.remove(str);
        if (localObject3 == null)
        {
          paramContentValues.putNull((String)localObject2);
        }
        else
        {
          str = localObject3.getClass().getName();
          if ("java.lang.Byte".equals(str)) {
            paramContentValues.put((String)localObject2, (Byte)localObject3);
          } else if ("[B".equals(str)) {
            paramContentValues.put((String)localObject2, (byte[])localObject3);
          } else if ("java.lang.Boolean".equals(str)) {
            paramContentValues.put((String)localObject2, (Boolean)localObject3);
          } else if ("java.lang.String".equals(str)) {
            paramContentValues.put((String)localObject2, (String)localObject3);
          } else if ("java.lang.Float".equals(str)) {
            paramContentValues.put((String)localObject2, (Float)localObject3);
          } else if ("java.lang.Long".equals(str)) {
            paramContentValues.put((String)localObject2, (Long)localObject3);
          } else if ("java.lang.Integer".equals(str)) {
            paramContentValues.put((String)localObject2, (Integer)localObject3);
          } else if ("java.lang.Short".equals(str)) {
            paramContentValues.put((String)localObject2, (Short)localObject3);
          } else if ("java.lang.Double".equals(str)) {
            paramContentValues.put((String)localObject2, (Double)localObject3);
          }
        }
      }
    }
  }
  
  private int doUpdateAllAction(String paramString, ContentValues paramContentValues, String... paramVarArgs)
  {
    BaseUtility.checkConditionsCorrect(paramVarArgs);
    if (paramContentValues.size() > 0) {
      return this.mDatabase.update(paramString, paramContentValues, getWhereClause(paramVarArgs), getWhereArgs(paramVarArgs));
    }
    return 0;
  }
  
  private int doUpdateAssociations(LitePalSupport paramLitePalSupport, long paramLong, ContentValues paramContentValues)
  {
    analyzeAssociations(paramLitePalSupport);
    updateSelfTableForeignKey(paramLitePalSupport, paramContentValues);
    return updateAssociatedTableForeignKey(paramLitePalSupport, paramLong) + 0;
  }
  
  private void putFieldsToDefaultValue(LitePalSupport paramLitePalSupport, ContentValues paramContentValues, long... paramVarArgs)
  {
    label281:
    label298:
    for (;;)
    {
      try
      {
        LitePalSupport localLitePalSupport = getEmptyModel(paramLitePalSupport);
        Class localClass = localLitePalSupport.getClass();
        Iterator localIterator = paramLitePalSupport.getFieldsToSetToDefault().iterator();
        Object localObject = null;
        try
        {
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            boolean bool = isIdColumn(str1);
            if (!bool) {
              try
              {
                localObject = localClass.getDeclaredField(str1);
                if (isCollection(((Field)localObject).getType()))
                {
                  if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (!BaseUtility.isGenericTypeSupported(getGenericTypeName((Field)localObject)))) {
                    break label298;
                  }
                  localObject = DBUtility.getGenericTableName(paramLitePalSupport.getClassName(), ((Field)localObject).getName());
                  String str2 = DBUtility.getGenericValueIdColumnName(paramLitePalSupport.getClassName());
                  StringBuilder localStringBuilder = new StringBuilder();
                  int k = paramVarArgs.length;
                  int i = 0;
                  int j = 0;
                  if (i < k)
                  {
                    long l = paramVarArgs[i];
                    if (j != 0) {
                      localStringBuilder.append(" or ");
                    }
                    localStringBuilder.append(str2);
                    localStringBuilder.append(" = ");
                    localStringBuilder.append(l);
                    i += 1;
                    j = 1;
                    continue;
                  }
                  this.mDatabase.delete((String)localObject, localStringBuilder.toString(), null);
                  break label298;
                }
                putContentValuesForUpdate(localLitePalSupport, (Field)localObject, paramContentValues);
                localObject = str1;
              }
              catch (NoSuchFieldException paramContentValues)
              {
                paramVarArgs = str1;
                break label281;
              }
            }
            continue;
          }
          return;
        }
        catch (NoSuchFieldException paramContentValues)
        {
          paramVarArgs = (long[])localObject;
        }
        throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(paramLitePalSupport.getClassName(), paramVarArgs), paramContentValues);
      }
      catch (Exception paramLitePalSupport)
      {
        throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
      }
      catch (NoSuchFieldException paramContentValues)
      {
        paramVarArgs = null;
      }
    }
  }
  
  private int updateAssociatedTableForeignKey(LitePalSupport paramLitePalSupport, long paramLong)
  {
    Map localMap = paramLitePalSupport.getAssociatedModelsMapWithFK();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localContentValues.clear();
      localContentValues.put(getForeignKeyColumnName(paramLitePalSupport.getTableName()), Long.valueOf(paramLong));
      Set localSet = (Set)localMap.get(str);
      if ((localSet != null) && (!localSet.isEmpty())) {
        return this.mDatabase.update(str, localContentValues, getWhereOfIdsWithOr(localSet), null);
      }
    }
    return 0;
  }
  
  private void updateGenericTables(LitePalSupport paramLitePalSupport, List<Field> paramList, long... paramVarArgs)
    throws IllegalAccessException, InvocationTargetException
  {
    Object localObject1 = paramVarArgs;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      for (paramList = paramList.iterator(); paramList.hasNext(); paramList = (List<Field>)localObject1)
      {
        Field localField = (Field)paramList.next();
        localObject1 = (Encrypt)localField.getAnnotation(Encrypt.class);
        String str2 = getGenericTypeName(localField);
        String str1;
        if ((localObject1 != null) && ("java.lang.String".equals(str2))) {
          str1 = ((Encrypt)localObject1).algorithm();
        } else {
          str1 = null;
        }
        localField.setAccessible(true);
        Collection localCollection = (Collection)localField.get(paramLitePalSupport);
        localObject1 = paramList;
        if (localCollection != null)
        {
          localObject1 = paramList;
          if (!localCollection.isEmpty())
          {
            String str3 = DBUtility.getGenericTableName(paramLitePalSupport.getClassName(), localField.getName());
            String str4 = DBUtility.getGenericValueIdColumnName(paramLitePalSupport.getClassName());
            int j = paramVarArgs.length;
            int i = 0;
            for (;;)
            {
              localObject1 = paramList;
              if (i >= j) {
                break;
              }
              long l1 = paramVarArgs[i];
              localObject1 = this.mDatabase;
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(str4);
              ((StringBuilder)localObject2).append(" = ?");
              ((SQLiteDatabase)localObject1).delete(str3, ((StringBuilder)localObject2).toString(), new String[] { String.valueOf(l1) });
              localObject1 = localCollection.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject3 = ((Iterator)localObject1).next();
                localObject2 = new ContentValues();
                ((ContentValues)localObject2).put(str4, Long.valueOf(l1));
                localObject3 = encryptValue(str1, localObject3);
                if (paramLitePalSupport.getClassName().equals(str2))
                {
                  localObject3 = (LitePalSupport)localObject3;
                  if (localObject3 == null) {
                    continue;
                  }
                  long l2 = ((LitePalSupport)localObject3).getBaseObjId();
                  if (l2 <= 0L) {
                    continue;
                  }
                  ((ContentValues)localObject2).put(DBUtility.getM2MSelfRefColumnName(localField), Long.valueOf(l2));
                }
                else
                {
                  String str5 = DBUtility.convertToValidColumnName(BaseUtility.changeCase(localField.getName()));
                  Class localClass1 = getGenericTypeClass(localField);
                  Class localClass2 = localObject2.getClass();
                  DynamicExecutor.send(localObject2, "put", new Object[] { str5, localObject3 }, localClass2, new Class[] { String.class, localClass1 });
                }
                this.mDatabase.insert(str3, null, (ContentValues)localObject2);
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void updateSelfTableForeignKey(LitePalSupport paramLitePalSupport, ContentValues paramContentValues)
  {
    paramLitePalSupport = paramLitePalSupport.getAssociatedModelsMapWithoutFK();
    Iterator localIterator = paramLitePalSupport.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramContentValues.put(getForeignKeyColumnName(str), (Long)paramLitePalSupport.get(str));
    }
  }
  
  public int onUpdate(Class<?> paramClass, long paramLong, ContentValues paramContentValues)
  {
    if (paramContentValues.size() > 0)
    {
      convertContentValues(paramContentValues);
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      paramClass = getTableName(paramClass);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id = ");
      localStringBuilder.append(paramLong);
      return localSQLiteDatabase.update(paramClass, paramContentValues, localStringBuilder.toString(), null);
    }
    return 0;
  }
  
  int onUpdate(LitePalSupport paramLitePalSupport, long paramLong)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = getSupportedFields(paramLitePalSupport.getClassName());
    updateGenericTables(paramLitePalSupport, getSupportedGenericFields(paramLitePalSupport.getClassName()), new long[] { paramLong });
    ContentValues localContentValues = new ContentValues();
    putFieldsValue(paramLitePalSupport, (List)localObject, localContentValues);
    putFieldsToDefaultValue(paramLitePalSupport, localContentValues, new long[] { paramLong });
    if (localContentValues.size() > 0)
    {
      localObject = this.mDatabase;
      paramLitePalSupport = paramLitePalSupport.getTableName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id = ");
      localStringBuilder.append(paramLong);
      return ((SQLiteDatabase)localObject).update(paramLitePalSupport, localContentValues, localStringBuilder.toString(), null);
    }
    return 0;
  }
  
  public int onUpdateAll(String paramString, ContentValues paramContentValues, String... paramVarArgs)
  {
    BaseUtility.checkConditionsCorrect(paramVarArgs);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      paramVarArgs[0] = DBUtility.convertWhereClauseToColumnName(paramVarArgs[0]);
    }
    convertContentValues(paramContentValues);
    return doUpdateAllAction(paramString, paramContentValues, paramVarArgs);
  }
  
  int onUpdateAll(LitePalSupport paramLitePalSupport, String... paramVarArgs)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    BaseUtility.checkConditionsCorrect(paramVarArgs);
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      paramVarArgs[0] = DBUtility.convertWhereClauseToColumnName(paramVarArgs[0]);
    }
    List localList1 = getSupportedFields(paramLitePalSupport.getClassName());
    List localList2 = getSupportedGenericFields(paramLitePalSupport.getClassName());
    ContentValues localContentValues = null;
    Object localObject = localContentValues;
    if (!localList2.isEmpty())
    {
      List localList3 = Operator.select(new String[] { "id" }).where(paramVarArgs).find(paramLitePalSupport.getClass());
      localObject = localContentValues;
      if (localList3.size() > 0)
      {
        localObject = new long[localList3.size()];
        while (i < localObject.length)
        {
          localObject[i] = ((LitePalSupport)localList3.get(i)).getBaseObjId();
          i += 1;
        }
        updateGenericTables(paramLitePalSupport, localList2, (long[])localObject);
      }
    }
    localContentValues = new ContentValues();
    putFieldsValue(paramLitePalSupport, localList1, localContentValues);
    putFieldsToDefaultValue(paramLitePalSupport, localContentValues, (long[])localObject);
    return doUpdateAllAction(paramLitePalSupport.getTableName(), localContentValues, paramVarArgs);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\UpdateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */