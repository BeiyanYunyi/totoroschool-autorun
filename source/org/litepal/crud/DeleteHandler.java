package org.litepal.crud;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.FluentQuery;
import org.litepal.Operator;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class DeleteHandler
  extends DataHandler
{
  private List<String> foreignKeyTableToDelete;
  
  public DeleteHandler(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  private Collection<AssociationsInfo> analyzeAssociations(LitePalSupport paramLitePalSupport)
  {
    try
    {
      Collection localCollection = getAssociationInfo(paramLitePalSupport.getClassName());
      analyzeAssociatedModels(paramLitePalSupport, localCollection);
      return localCollection;
    }
    catch (Exception paramLitePalSupport)
    {
      throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
    }
  }
  
  private void analyzeAssociations(Class<?> paramClass)
  {
    Iterator localIterator = getAssociationInfo(paramClass.getName()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AssociationsInfo)localIterator.next();
      String str = DBUtility.getTableNameByClassName(((AssociationsInfo)localObject).getAssociatedClassName());
      if ((((AssociationsInfo)localObject).getAssociationType() != 2) && (((AssociationsInfo)localObject).getAssociationType() != 1))
      {
        if (((AssociationsInfo)localObject).getAssociationType() == 3)
        {
          str = BaseUtility.changeCase(DBUtility.getIntermediateTableName(getTableName(paramClass), str));
          getForeignKeyTableToDelete().add(str);
        }
      }
      else
      {
        localObject = ((AssociationsInfo)localObject).getClassHoldsForeignKey();
        if (!paramClass.getName().equals(localObject)) {
          getForeignKeyTableToDelete().add(str);
        }
      }
    }
  }
  
  private String buildConditionString(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    StringBuilder localStringBuilder;
    for (String str = paramVarArgs[0]; i < j - 1; str = str.replaceFirst("\\?", localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      i += 1;
      localStringBuilder.append(paramVarArgs[i]);
      localStringBuilder.append("'");
    }
    return str;
  }
  
  private void clearAssociatedModelSaveState(LitePalSupport paramLitePalSupport, Collection<AssociationsInfo> paramCollection)
  {
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = (AssociationsInfo)paramCollection.next();
        if ((((AssociationsInfo)localObject).getAssociationType() == 2) && (!paramLitePalSupport.getClassName().equals(((AssociationsInfo)localObject).getClassHoldsForeignKey())))
        {
          localObject = getAssociatedModels(paramLitePalSupport, (AssociationsInfo)localObject);
          if ((localObject != null) && (!((Collection)localObject).isEmpty()))
          {
            localObject = ((Collection)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              LitePalSupport localLitePalSupport = (LitePalSupport)((Iterator)localObject).next();
              if (localLitePalSupport != null) {
                localLitePalSupport.clearSavedState();
              }
            }
          }
        }
        else if (((AssociationsInfo)localObject).getAssociationType() == 1)
        {
          localObject = getAssociatedModel(paramLitePalSupport, (AssociationsInfo)localObject);
          if (localObject != null) {
            ((LitePalSupport)localObject).clearSavedState();
          }
        }
      }
      return;
    }
    catch (Exception paramLitePalSupport)
    {
      throw new LitePalSupportException(paramLitePalSupport.getMessage(), paramLitePalSupport);
    }
  }
  
  private int deleteAllCascade(Class<?> paramClass, String... paramVarArgs)
  {
    Iterator localIterator = getForeignKeyTableToDelete().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = getTableName(paramClass);
      String str3 = getForeignKeyColumnName(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str3);
      localStringBuilder.append(" in (select id from ");
      localStringBuilder.append(str2);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localStringBuilder.append(" where ");
        localStringBuilder.append(buildConditionString(paramVarArgs));
      }
      localStringBuilder.append(")");
      i += this.mDatabase.delete(str1, BaseUtility.changeCase(localStringBuilder.toString()), null);
    }
    return i;
  }
  
  private int deleteAssociatedForeignKeyRows(LitePalSupport paramLitePalSupport)
  {
    Iterator localIterator = paramLitePalSupport.getAssociatedModelsMapWithFK().keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = getForeignKeyColumnName(paramLitePalSupport.getTableName());
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramLitePalSupport.getBaseObjId());
      i += localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
    }
    return i;
  }
  
  private int deleteAssociatedJoinTableRows(LitePalSupport paramLitePalSupport)
  {
    Iterator localIterator = paramLitePalSupport.getAssociatedModelsMapForJoinTable().keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      str1 = DBUtility.getIntermediateTableName(paramLitePalSupport.getTableName(), str1);
      String str2 = getForeignKeyColumnName(paramLitePalSupport.getTableName());
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramLitePalSupport.getBaseObjId());
      i += localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
    }
    return i;
  }
  
  private int deleteCascade(Class<?> paramClass, long paramLong)
  {
    Iterator localIterator = getForeignKeyTableToDelete().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = getForeignKeyColumnName(getTableName(paramClass));
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramLong);
      i += localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
    }
    return i;
  }
  
  private int deleteCascade(LitePalSupport paramLitePalSupport)
  {
    return deleteAssociatedForeignKeyRows(paramLitePalSupport) + deleteAssociatedJoinTableRows(paramLitePalSupport);
  }
  
  private void deleteGenericData(Class<?> paramClass, List<Field> paramList, long... paramVarArgs)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Field)paramList.next();
      localObject = DBUtility.getGenericTableName(paramClass.getName(), ((Field)localObject).getName());
      String str = DBUtility.getGenericValueIdColumnName(paramClass.getName());
      int n = paramVarArgs.length;
      int i1 = (n - 1) / 500;
      int m;
      for (int i = 0; i <= i1; i = m)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = 500 * i;
        for (int k = 0;; k = 1)
        {
          m = i + 1;
          if ((j >= 500 * m) || (j >= n)) {
            break;
          }
          long l = paramVarArgs[j];
          if (k != 0) {
            localStringBuilder.append(" or ");
          }
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(l);
          j += 1;
        }
        if (!TextUtils.isEmpty(localStringBuilder.toString())) {
          this.mDatabase.delete((String)localObject, localStringBuilder.toString(), null);
        }
      }
    }
  }
  
  private List<String> getForeignKeyTableToDelete()
  {
    if (this.foreignKeyTableToDelete == null) {
      this.foreignKeyTableToDelete = new ArrayList();
    }
    return this.foreignKeyTableToDelete;
  }
  
  public int onDelete(Class<?> paramClass, long paramLong)
  {
    deleteGenericData(paramClass, getSupportedGenericFields(paramClass.getName()), new long[] { paramLong });
    analyzeAssociations(paramClass);
    int i = deleteCascade(paramClass, paramLong);
    SQLiteDatabase localSQLiteDatabase = this.mDatabase;
    paramClass = getTableName(paramClass);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id = ");
    localStringBuilder.append(paramLong);
    int j = localSQLiteDatabase.delete(paramClass, localStringBuilder.toString(), null);
    getForeignKeyTableToDelete().clear();
    return i + j;
  }
  
  int onDelete(LitePalSupport paramLitePalSupport)
  {
    if (paramLitePalSupport.isSaved())
    {
      Object localObject = getSupportedGenericFields(paramLitePalSupport.getClassName());
      deleteGenericData(paramLitePalSupport.getClass(), (List)localObject, new long[] { paramLitePalSupport.getBaseObjId() });
      localObject = analyzeAssociations(paramLitePalSupport);
      int i = deleteCascade(paramLitePalSupport);
      SQLiteDatabase localSQLiteDatabase = this.mDatabase;
      String str = paramLitePalSupport.getTableName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id = ");
      localStringBuilder.append(paramLitePalSupport.getBaseObjId());
      int j = localSQLiteDatabase.delete(str, localStringBuilder.toString(), null);
      clearAssociatedModelSaveState(paramLitePalSupport, (Collection)localObject);
      return i + j;
    }
    return 0;
  }
  
  public int onDeleteAll(Class<?> paramClass, String... paramVarArgs)
  {
    BaseUtility.checkConditionsCorrect(paramVarArgs);
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      paramVarArgs[0] = DBUtility.convertWhereClauseToColumnName(paramVarArgs[0]);
    }
    List localList1 = getSupportedGenericFields(paramClass.getName());
    if (!localList1.isEmpty())
    {
      List localList2 = Operator.select(new String[] { "id" }).where(paramVarArgs).find(paramClass);
      if (localList2.size() > 0)
      {
        long[] arrayOfLong = new long[localList2.size()];
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((LitePalSupport)localList2.get(i)).getBaseObjId();
          i += 1;
        }
        deleteGenericData(paramClass, localList1, arrayOfLong);
      }
    }
    analyzeAssociations(paramClass);
    i = deleteAllCascade(paramClass, paramVarArgs);
    int j = this.mDatabase.delete(getTableName(paramClass), getWhereClause(paramVarArgs), getWhereArgs(paramVarArgs));
    getForeignKeyTableToDelete().clear();
    return i + j;
  }
  
  public int onDeleteAll(String paramString, String... paramVarArgs)
  {
    BaseUtility.checkConditionsCorrect(paramVarArgs);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      paramVarArgs[0] = DBUtility.convertWhereClauseToColumnName(paramVarArgs[0]);
    }
    return this.mDatabase.delete(paramString, getWhereClause(paramVarArgs), getWhereArgs(paramVarArgs));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\DeleteHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */