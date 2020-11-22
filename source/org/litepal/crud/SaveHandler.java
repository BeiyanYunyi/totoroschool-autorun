package org.litepal.crud;

import android.content.ContentValues;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.annotation.Encrypt;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class SaveHandler
  extends DataHandler
{
  private ContentValues values = new ContentValues();
  
  public SaveHandler(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  private void afterSave(LitePalSupport paramLitePalSupport, List<Field> paramList1, List<Field> paramList2, long paramLong)
    throws IllegalAccessException, InvocationTargetException
  {
    throwIfSaveFailed(paramLong);
    assignIdValue(paramLitePalSupport, getIdField(paramList1), paramLong);
    updateGenericTables(paramLitePalSupport, paramList2, paramLong);
    updateAssociatedTableWithFK(paramLitePalSupport);
    insertIntermediateJoinTableValue(paramLitePalSupport, false);
  }
  
  private void afterUpdate(LitePalSupport paramLitePalSupport, List<Field> paramList)
    throws InvocationTargetException, IllegalAccessException
  {
    updateGenericTables(paramLitePalSupport, paramList, paramLitePalSupport.getBaseObjId());
    updateAssociatedTableWithFK(paramLitePalSupport);
    insertIntermediateJoinTableValue(paramLitePalSupport, true);
    clearFKValueInAssociatedTable(paramLitePalSupport);
  }
  
  private void assignIdValue(LitePalSupport paramLitePalSupport, Field paramField, long paramLong)
  {
    try
    {
      giveBaseObjIdValue(paramLitePalSupport, paramLong);
      if (paramField != null) {
        giveModelIdValue(paramLitePalSupport, paramField.getName(), paramField.getType(), paramLong);
      }
      return;
    }
    catch (Exception paramLitePalSupport)
    {
      throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
    }
  }
  
  private void beforeSave(LitePalSupport paramLitePalSupport, List<Field> paramList, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    putFieldsValue(paramLitePalSupport, paramList, paramContentValues);
    putForeignKeyValue(paramContentValues, paramLitePalSupport);
  }
  
  private void beforeUpdate(LitePalSupport paramLitePalSupport, List<Field> paramList, ContentValues paramContentValues)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    putFieldsValue(paramLitePalSupport, paramList, paramContentValues);
    putForeignKeyValue(paramContentValues, paramLitePalSupport);
    paramLitePalSupport = paramLitePalSupport.getListToClearSelfFK().iterator();
    while (paramLitePalSupport.hasNext()) {
      paramContentValues.putNull((String)paramLitePalSupport.next());
    }
  }
  
  private void clearFKValueInAssociatedTable(LitePalSupport paramLitePalSupport)
  {
    Iterator localIterator = paramLitePalSupport.getListToClearAssociatedFK().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = getForeignKeyColumnName(paramLitePalSupport.getTableName());
      ContentValues localContentValues = new ContentValues();
      localContentValues.putNull(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramLitePalSupport.getBaseObjId());
      str2 = localStringBuilder.toString();
      this.mDatabase.update(str1, localContentValues, str2, null);
    }
  }
  
  private void doSaveAction(LitePalSupport paramLitePalSupport, List<Field> paramList1, List<Field> paramList2)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    this.values.clear();
    beforeSave(paramLitePalSupport, paramList1, this.values);
    afterSave(paramLitePalSupport, paramList1, paramList2, saving(paramLitePalSupport, this.values));
  }
  
  private void doUpdateAction(LitePalSupport paramLitePalSupport, List<Field> paramList1, List<Field> paramList2)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    this.values.clear();
    beforeUpdate(paramLitePalSupport, paramList1, this.values);
    updating(paramLitePalSupport, this.values);
    afterUpdate(paramLitePalSupport, paramList2);
  }
  
  private Field getIdField(List<Field> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Field localField = (Field)paramList.next();
      if (isIdColumn(localField.getName())) {
        return localField;
      }
    }
    return null;
  }
  
  private String getWhereForJoinTableToDelete(LitePalSupport paramLitePalSupport)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getForeignKeyColumnName(paramLitePalSupport.getTableName()));
    localStringBuilder.append(" = ?");
    return localStringBuilder.toString();
  }
  
  private void giveModelIdValue(LitePalSupport paramLitePalSupport, String paramString, Class<?> paramClass, long paramLong)
    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    if (shouldGiveModelIdValue(paramString, paramClass, paramLong))
    {
      if ((paramClass != Integer.TYPE) && (paramClass != Integer.class))
      {
        if ((paramClass != Long.TYPE) && (paramClass != Long.class)) {
          throw new LitePalSupportException("id type is not supported. Only int or long is acceptable for id");
        }
        paramClass = Long.valueOf(paramLong);
      }
      else
      {
        paramClass = Integer.valueOf((int)paramLong);
      }
      DynamicExecutor.setField(paramLitePalSupport, paramString, paramClass, paramLitePalSupport.getClass());
    }
  }
  
  private void insertIntermediateJoinTableValue(LitePalSupport paramLitePalSupport, boolean paramBoolean)
  {
    Map localMap = paramLitePalSupport.getAssociatedModelsMapForJoinTable();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator1 = localMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      String str2 = getIntermediateTableName(paramLitePalSupport, str1);
      if (paramBoolean) {
        this.mDatabase.delete(str2, getWhereForJoinTableToDelete(paramLitePalSupport), new String[] { String.valueOf(paramLitePalSupport.getBaseObjId()) });
      }
      Iterator localIterator2 = ((List)localMap.get(str1)).iterator();
      while (localIterator2.hasNext())
      {
        long l = ((Long)localIterator2.next()).longValue();
        localContentValues.clear();
        localContentValues.put(getForeignKeyColumnName(paramLitePalSupport.getTableName()), Long.valueOf(paramLitePalSupport.getBaseObjId()));
        localContentValues.put(getForeignKeyColumnName(str1), Long.valueOf(l));
        this.mDatabase.insert(str2, null, localContentValues);
      }
    }
  }
  
  private void putForeignKeyValue(ContentValues paramContentValues, LitePalSupport paramLitePalSupport)
  {
    paramLitePalSupport = paramLitePalSupport.getAssociatedModelsMapWithoutFK();
    Iterator localIterator = paramLitePalSupport.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramContentValues.put(getForeignKeyColumnName(str), (Long)paramLitePalSupport.get(str));
    }
  }
  
  private long saving(LitePalSupport paramLitePalSupport, ContentValues paramContentValues)
  {
    if (paramContentValues.size() == 0) {
      paramContentValues.putNull("id");
    }
    return this.mDatabase.insert(paramLitePalSupport.getTableName(), null, paramContentValues);
  }
  
  private boolean shouldGiveModelIdValue(String paramString, Class<?> paramClass, long paramLong)
  {
    return (paramString != null) && (paramClass != null) && (paramLong > 0L);
  }
  
  private void throwIfSaveFailed(long paramLong)
  {
    if (paramLong != -1L) {
      return;
    }
    throw new LitePalSupportException("Save current model failed.");
  }
  
  private void updateAssociatedTableWithFK(LitePalSupport paramLitePalSupport)
  {
    Map localMap = paramLitePalSupport.getAssociatedModelsMapWithFK();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localContentValues.clear();
      localContentValues.put(getForeignKeyColumnName(paramLitePalSupport.getTableName()), Long.valueOf(paramLitePalSupport.getBaseObjId()));
      Set localSet = (Set)localMap.get(str);
      if ((localSet != null) && (!localSet.isEmpty())) {
        this.mDatabase.update(str, localContentValues, getWhereOfIdsWithOr(localSet), null);
      }
    }
  }
  
  private void updateGenericTables(LitePalSupport paramLitePalSupport, List<Field> paramList, long paramLong)
    throws IllegalAccessException, InvocationTargetException
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      paramList = (Encrypt)localField.getAnnotation(Encrypt.class);
      String str1 = getGenericTypeName(localField);
      if ((paramList != null) && ("java.lang.String".equals(str1))) {
        paramList = paramList.algorithm();
      } else {
        paramList = null;
      }
      localField.setAccessible(true);
      Object localObject2 = (Collection)localField.get(paramLitePalSupport);
      if (localObject2 != null)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateGenericTables: class name is ");
        ((StringBuilder)localObject1).append(paramLitePalSupport.getClassName());
        ((StringBuilder)localObject1).append(" , field name is ");
        ((StringBuilder)localObject1).append(localField.getName());
        Log.d("DataHandler", ((StringBuilder)localObject1).toString());
        localObject1 = DBUtility.getGenericTableName(paramLitePalSupport.getClassName(), localField.getName());
        String str2 = DBUtility.getGenericValueIdColumnName(paramLitePalSupport.getClassName());
        Object localObject3 = this.mDatabase;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append(" = ?");
        ((SQLiteDatabase)localObject3).delete((String)localObject1, ((StringBuilder)localObject4).toString(), new String[] { String.valueOf(paramLong) });
        localObject2 = ((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          localObject3 = new ContentValues();
          ((ContentValues)localObject3).put(str2, Long.valueOf(paramLong));
          localObject4 = encryptValue(paramList, localObject4);
          if (paramLitePalSupport.getClassName().equals(str1))
          {
            localObject4 = (LitePalSupport)localObject4;
            if (localObject4 == null) {
              continue;
            }
            long l = ((LitePalSupport)localObject4).getBaseObjId();
            if (l <= 0L) {
              continue;
            }
            ((ContentValues)localObject3).put(DBUtility.getM2MSelfRefColumnName(localField), Long.valueOf(l));
          }
          else
          {
            String str3 = BaseUtility.changeCase(DBUtility.convertToValidColumnName(localField.getName()));
            Class localClass1 = getGenericTypeClass(localField);
            Class localClass2 = localObject3.getClass();
            DynamicExecutor.send(localObject3, "put", new Object[] { str3, localObject4 }, localClass2, new Class[] { String.class, localClass1 });
          }
          this.mDatabase.insert((String)localObject1, null, (ContentValues)localObject3);
        }
      }
    }
  }
  
  private void updating(LitePalSupport paramLitePalSupport, ContentValues paramContentValues)
  {
    if (paramContentValues.size() > 0) {
      this.mDatabase.update(paramLitePalSupport.getTableName(), paramContentValues, "id = ?", new String[] { String.valueOf(paramLitePalSupport.getBaseObjId()) });
    }
  }
  
  void onSave(LitePalSupport paramLitePalSupport)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = paramLitePalSupport.getClassName();
    List localList1 = getSupportedFields((String)localObject);
    List localList2 = getSupportedGenericFields((String)localObject);
    localObject = getAssociationInfo((String)localObject);
    if (!paramLitePalSupport.isSaved())
    {
      analyzeAssociatedModels(paramLitePalSupport, (Collection)localObject);
      doSaveAction(paramLitePalSupport, localList1, localList2);
      analyzeAssociatedModels(paramLitePalSupport, (Collection)localObject);
      return;
    }
    analyzeAssociatedModels(paramLitePalSupport, (Collection)localObject);
    doUpdateAction(paramLitePalSupport, localList1, localList2);
  }
  
  public <T extends LitePalSupport> void onSaveAll(Collection<T> paramCollection)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      int i = 0;
      paramCollection = (LitePalSupport[])paramCollection.toArray(new LitePalSupport[0]);
      Object localObject = paramCollection[0].getClassName();
      List localList1 = getSupportedFields((String)localObject);
      List localList2 = getSupportedGenericFields((String)localObject);
      localObject = getAssociationInfo((String)localObject);
      int j = paramCollection.length;
      while (i < j)
      {
        LitePalSupport localLitePalSupport = paramCollection[i];
        if (!localLitePalSupport.isSaved())
        {
          analyzeAssociatedModels(localLitePalSupport, (Collection)localObject);
          doSaveAction(localLitePalSupport, localList1, localList2);
          analyzeAssociatedModels(localLitePalSupport, (Collection)localObject);
        }
        else
        {
          analyzeAssociatedModels(localLitePalSupport, (Collection)localObject);
          doUpdateAction(localLitePalSupport, localList1, localList2);
        }
        localLitePalSupport.clearAssociatedData();
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\SaveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */