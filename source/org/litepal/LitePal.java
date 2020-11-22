package org.litepal;

import android.content.ContentValues;
import android.content.Context;
import java.util.Collection;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.tablemanager.callback.DatabaseListener;

public class LitePal
{
  public static void aesKey(String paramString)
  {
    Operator.aesKey(paramString);
  }
  
  public static double average(Class<?> paramClass, String paramString)
  {
    return Operator.average(paramClass, paramString);
  }
  
  public static double average(String paramString1, String paramString2)
  {
    return Operator.average(paramString1, paramString2);
  }
  
  public static AverageExecutor averageAsync(Class<?> paramClass, String paramString)
  {
    return Operator.averageAsync(paramClass, paramString);
  }
  
  public static AverageExecutor averageAsync(String paramString1, String paramString2)
  {
    return Operator.averageAsync(paramString1, paramString2);
  }
  
  public static int count(Class<?> paramClass)
  {
    return Operator.count(paramClass);
  }
  
  public static int count(String paramString)
  {
    return Operator.count(paramString);
  }
  
  public static CountExecutor countAsync(Class<?> paramClass)
  {
    return Operator.countAsync(paramClass);
  }
  
  public static CountExecutor countAsync(String paramString)
  {
    return Operator.countAsync(paramString);
  }
  
  public static int delete(Class<?> paramClass, long paramLong)
  {
    return Operator.delete(paramClass, paramLong);
  }
  
  public static int deleteAll(Class<?> paramClass, String... paramVarArgs)
  {
    return Operator.deleteAll(paramClass, paramVarArgs);
  }
  
  public static int deleteAll(String paramString, String... paramVarArgs)
  {
    return Operator.deleteAll(paramString, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor deleteAllAsync(Class<?> paramClass, String... paramVarArgs)
  {
    return Operator.deleteAllAsync(paramClass, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor deleteAllAsync(String paramString, String... paramVarArgs)
  {
    return Operator.deleteAllAsync(paramString, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor deleteAsync(Class<?> paramClass, long paramLong)
  {
    return Operator.deleteAsync(paramClass, paramLong);
  }
  
  public static boolean deleteDatabase(String paramString)
  {
    return Operator.deleteDatabase(paramString);
  }
  
  public static <T> T find(Class<T> paramClass, long paramLong)
  {
    return (T)Operator.find(paramClass, paramLong);
  }
  
  public static <T> T find(Class<T> paramClass, long paramLong, boolean paramBoolean)
  {
    return (T)Operator.find(paramClass, paramLong, paramBoolean);
  }
  
  public static <T> List<T> findAll(Class<T> paramClass, boolean paramBoolean, long... paramVarArgs)
  {
    return Operator.findAll(paramClass, paramBoolean, paramVarArgs);
  }
  
  public static <T> List<T> findAll(Class<T> paramClass, long... paramVarArgs)
  {
    return Operator.findAll(paramClass, paramVarArgs);
  }
  
  public static <T> FindMultiExecutor<T> findAllAsync(Class<T> paramClass, boolean paramBoolean, long... paramVarArgs)
  {
    return Operator.findAllAsync(paramClass, paramBoolean, paramVarArgs);
  }
  
  public static <T> FindMultiExecutor<T> findAllAsync(Class<T> paramClass, long... paramVarArgs)
  {
    return Operator.findAllAsync(paramClass, paramVarArgs);
  }
  
  public static <T> FindExecutor<T> findAsync(Class<T> paramClass, long paramLong)
  {
    return Operator.findAsync(paramClass, paramLong);
  }
  
  public static <T> FindExecutor<T> findAsync(Class<T> paramClass, long paramLong, boolean paramBoolean)
  {
    return Operator.findAsync(paramClass, paramLong, paramBoolean);
  }
  
  public static Cursor findBySQL(String... paramVarArgs)
  {
    return Operator.findBySQL(paramVarArgs);
  }
  
  public static <T> T findFirst(Class<T> paramClass)
  {
    return (T)Operator.findFirst(paramClass);
  }
  
  public static <T> T findFirst(Class<T> paramClass, boolean paramBoolean)
  {
    return (T)Operator.findFirst(paramClass, paramBoolean);
  }
  
  public static <T> FindExecutor<T> findFirstAsync(Class<T> paramClass)
  {
    return Operator.findFirstAsync(paramClass);
  }
  
  public static <T> FindExecutor<T> findFirstAsync(Class<T> paramClass, boolean paramBoolean)
  {
    return Operator.findFirstAsync(paramClass, paramBoolean);
  }
  
  public static <T> T findLast(Class<T> paramClass)
  {
    return (T)Operator.findLast(paramClass);
  }
  
  public static <T> T findLast(Class<T> paramClass, boolean paramBoolean)
  {
    return (T)Operator.findLast(paramClass, paramBoolean);
  }
  
  public static <T> FindExecutor<T> findLastAsync(Class<T> paramClass)
  {
    return Operator.findLastAsync(paramClass);
  }
  
  public static <T> FindExecutor<T> findLastAsync(Class<T> paramClass, boolean paramBoolean)
  {
    return Operator.findLastAsync(paramClass, paramBoolean);
  }
  
  public static SQLiteDatabase getDatabase()
  {
    return Operator.getDatabase();
  }
  
  public static void initialize(Context paramContext)
  {
    Operator.initialize(paramContext);
  }
  
  public static <T> boolean isExist(Class<T> paramClass, String... paramVarArgs)
  {
    return Operator.isExist(paramClass, paramVarArgs);
  }
  
  public static FluentQuery limit(int paramInt)
  {
    return Operator.limit(paramInt);
  }
  
  public static <T extends LitePalSupport> void markAsDeleted(Collection<T> paramCollection)
  {
    Operator.markAsDeleted(paramCollection);
  }
  
  public static <T> T max(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)Operator.max(paramClass, paramString, paramClass1);
  }
  
  public static <T> T max(String paramString1, String paramString2, Class<T> paramClass)
  {
    return (T)Operator.max(paramString1, paramString2, paramClass);
  }
  
  public static <T> FindExecutor<T> maxAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return Operator.maxAsync(paramClass, paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> maxAsync(String paramString1, String paramString2, Class<T> paramClass)
  {
    return Operator.maxAsync(paramString1, paramString2, paramClass);
  }
  
  public static <T> T min(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)Operator.min(paramClass, paramString, paramClass1);
  }
  
  public static <T> T min(String paramString1, String paramString2, Class<T> paramClass)
  {
    return (T)Operator.min(paramString1, paramString2, paramClass);
  }
  
  public static <T> FindExecutor<T> minAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return Operator.minAsync(paramClass, paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> minAsync(String paramString1, String paramString2, Class<T> paramClass)
  {
    return Operator.minAsync(paramString1, paramString2, paramClass);
  }
  
  public static FluentQuery offset(int paramInt)
  {
    return Operator.offset(paramInt);
  }
  
  public static FluentQuery order(String paramString)
  {
    return Operator.order(paramString);
  }
  
  public static void registerDatabaseListener(DatabaseListener paramDatabaseListener)
  {
    Operator.registerDatabaseListener(paramDatabaseListener);
  }
  
  public static <T extends LitePalSupport> void saveAll(Collection<T> paramCollection)
  {
    Operator.saveAll(paramCollection);
  }
  
  public static <T extends LitePalSupport> SaveExecutor saveAllAsync(Collection<T> paramCollection)
  {
    return Operator.saveAllAsync(paramCollection);
  }
  
  public static FluentQuery select(String... paramVarArgs)
  {
    return Operator.select(paramVarArgs);
  }
  
  public static <T> T sum(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)Operator.sum(paramClass, paramString, paramClass1);
  }
  
  public static <T> T sum(String paramString1, String paramString2, Class<T> paramClass)
  {
    return (T)Operator.sum(paramString1, paramString2, paramClass);
  }
  
  public static <T> FindExecutor<T> sumAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return Operator.sumAsync(paramClass, paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> sumAsync(String paramString1, String paramString2, Class<T> paramClass)
  {
    return Operator.sumAsync(paramString1, paramString2, paramClass);
  }
  
  public static int update(Class<?> paramClass, ContentValues paramContentValues, long paramLong)
  {
    return Operator.update(paramClass, paramContentValues, paramLong);
  }
  
  public static int updateAll(Class<?> paramClass, ContentValues paramContentValues, String... paramVarArgs)
  {
    return Operator.updateAll(paramClass, paramContentValues, paramVarArgs);
  }
  
  public static int updateAll(String paramString, ContentValues paramContentValues, String... paramVarArgs)
  {
    return Operator.updateAll(paramString, paramContentValues, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor updateAllAsync(Class<?> paramClass, ContentValues paramContentValues, String... paramVarArgs)
  {
    return Operator.updateAllAsync(paramClass, paramContentValues, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor updateAllAsync(String paramString, ContentValues paramContentValues, String... paramVarArgs)
  {
    return Operator.updateAllAsync(paramString, paramContentValues, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor updateAsync(Class<?> paramClass, ContentValues paramContentValues, long paramLong)
  {
    return Operator.updateAsync(paramClass, paramContentValues, paramLong);
  }
  
  public static void use(LitePalDB paramLitePalDB)
  {
    Operator.use(paramLitePalDB);
  }
  
  public static void useDefault() {}
  
  public static FluentQuery where(String... paramVarArgs)
  {
    return Operator.where(paramVarArgs);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\LitePal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */