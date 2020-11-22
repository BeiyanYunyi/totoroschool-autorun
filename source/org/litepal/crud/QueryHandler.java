package org.litepal.crud;

import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class QueryHandler
  extends DataHandler
{
  public QueryHandler(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  public double onAverage(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      paramArrayOfString[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString[0]);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avg(");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(")");
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = Double.TYPE;
    return ((Double)mathQuery(paramString1, new String[] { paramString2 }, paramArrayOfString, (Class)localObject)).doubleValue();
  }
  
  public int onCount(String paramString, String[] paramArrayOfString)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      paramArrayOfString[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString[0]);
    }
    Class localClass = Integer.TYPE;
    return ((Integer)mathQuery(paramString, new String[] { "count(1)" }, paramArrayOfString, localClass)).intValue();
  }
  
  public <T> T onFind(Class<T> paramClass, long paramLong, boolean paramBoolean)
  {
    List localList = getForeignKeyAssociations(paramClass.getName(), paramBoolean);
    paramClass = query(paramClass, null, "id = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null, localList);
    if (paramClass.size() > 0) {
      return (T)paramClass.get(0);
    }
    return null;
  }
  
  public <T> List<T> onFind(Class<T> paramClass, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, boolean paramBoolean)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString2);
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
      paramArrayOfString2[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString2[0]);
    }
    paramString1 = DBUtility.convertOrderByClauseToValidName(paramString1);
    return query(paramClass, paramArrayOfString1, getWhereClause(paramArrayOfString2), getWhereArgs(paramArrayOfString2), null, null, paramString1, paramString2, getForeignKeyAssociations(paramClass.getName(), paramBoolean));
  }
  
  public <T> List<T> onFindAll(Class<T> paramClass, boolean paramBoolean, long... paramVarArgs)
  {
    if (isAffectAllLines(new Object[] { paramVarArgs })) {
      return query(paramClass, null, null, null, null, null, "id", null, getForeignKeyAssociations(paramClass.getName(), paramBoolean));
    }
    return query(paramClass, null, getWhereOfIdsWithOr(paramVarArgs), null, null, null, "id", null, getForeignKeyAssociations(paramClass.getName(), paramBoolean));
  }
  
  public <T> T onFindFirst(Class<T> paramClass, boolean paramBoolean)
  {
    paramClass = query(paramClass, null, null, null, null, null, "id", "1", getForeignKeyAssociations(paramClass.getName(), paramBoolean));
    if (paramClass.size() > 0) {
      return (T)paramClass.get(0);
    }
    return null;
  }
  
  public <T> T onFindLast(Class<T> paramClass, boolean paramBoolean)
  {
    paramClass = query(paramClass, null, null, null, null, null, "id desc", "1", getForeignKeyAssociations(paramClass.getName(), paramBoolean));
    if (paramClass.size() > 0) {
      return (T)paramClass.get(0);
    }
    return null;
  }
  
  public <T> T onMax(String paramString1, String paramString2, String[] paramArrayOfString, Class<T> paramClass)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      paramArrayOfString[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("max(");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return (T)mathQuery(paramString1, new String[] { localStringBuilder.toString() }, paramArrayOfString, paramClass);
  }
  
  public <T> T onMin(String paramString1, String paramString2, String[] paramArrayOfString, Class<T> paramClass)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      paramArrayOfString[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("min(");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return (T)mathQuery(paramString1, new String[] { localStringBuilder.toString() }, paramArrayOfString, paramClass);
  }
  
  public <T> T onSum(String paramString1, String paramString2, String[] paramArrayOfString, Class<T> paramClass)
  {
    BaseUtility.checkConditionsCorrect(paramArrayOfString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      paramArrayOfString[0] = DBUtility.convertWhereClauseToColumnName(paramArrayOfString[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sum(");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return (T)mathQuery(paramString1, new String[] { localStringBuilder.toString() }, paramArrayOfString, paramClass);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\QueryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */