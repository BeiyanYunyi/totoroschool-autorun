package org.litepal;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.crud.DeleteHandler;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.UpdateHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.crud.callback.AverageCallback;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import org.litepal.parser.LitePalAttr;
import org.litepal.parser.LitePalConfig;
import org.litepal.parser.LitePalParser;
import org.litepal.tablemanager.Connector;
import org.litepal.tablemanager.callback.DatabaseListener;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.SharedUtil;

public class Operator
{
  private static DatabaseListener dbListener = null;
  private static Handler handler = new Handler(Looper.getMainLooper());
  
  public static void aesKey(String paramString)
  {
    org.litepal.util.cipher.CipherUtil.aesKey = paramString;
  }
  
  public static double average(Class<?> paramClass, String paramString)
  {
    return average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString);
  }
  
  public static double average(String paramString1, String paramString2)
  {
    try
    {
      double d = new FluentQuery().average(paramString1, paramString2);
      return d;
    }
    finally {}
  }
  
  public static AverageExecutor averageAsync(Class<?> paramClass, String paramString)
  {
    return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString);
  }
  
  public static AverageExecutor averageAsync(String paramString1, final String paramString2)
  {
    final AverageExecutor localAverageExecutor = new AverageExecutor();
    localAverageExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final double d = Operator.average(this.val$tableName, paramString2);
          if (localAverageExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.2.this.val$executor.getListener().onFinish(d);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localAverageExecutor;
  }
  
  public static int count(Class<?> paramClass)
  {
    return count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())));
  }
  
  public static int count(String paramString)
  {
    try
    {
      int i = new FluentQuery().count(paramString);
      return i;
    }
    finally {}
  }
  
  public static CountExecutor countAsync(Class<?> paramClass)
  {
    return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())));
  }
  
  public static CountExecutor countAsync(String paramString)
  {
    final CountExecutor localCountExecutor = new CountExecutor();
    localCountExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.count(this.val$tableName);
          if (localCountExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.1.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localCountExecutor;
  }
  
  /* Error */
  public static int delete(Class<?> paramClass, long paramLong)
  {
    // Byte code:
    //   0: ldc 122
    //   2: monitorenter
    //   3: invokestatic 170	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: astore 4
    //   8: aload 4
    //   10: invokevirtual 175	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   13: new 177	org/litepal/crud/DeleteHandler
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 180	org/litepal/crud/DeleteHandler:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   22: aload_0
    //   23: lload_1
    //   24: invokevirtual 183	org/litepal/crud/DeleteHandler:onDelete	(Ljava/lang/Class;J)I
    //   27: istore_3
    //   28: aload 4
    //   30: invokevirtual 186	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   33: aload 4
    //   35: invokevirtual 189	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   38: ldc 122
    //   40: monitorexit
    //   41: iload_3
    //   42: ireturn
    //   43: astore_0
    //   44: aload 4
    //   46: invokevirtual 189	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: ldc 122
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramClass	Class<?>
    //   0	57	1	paramLong	long
    //   27	15	3	i	int
    //   6	39	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	33	43	finally
    //   3	13	51	finally
    //   33	41	51	finally
    //   44	51	51	finally
    //   52	55	51	finally
  }
  
  public static int deleteAll(Class<?> paramClass, String... paramVarArgs)
  {
    try
    {
      int i = new DeleteHandler(Connector.getDatabase()).onDeleteAll(paramClass, paramVarArgs);
      return i;
    }
    finally {}
  }
  
  public static int deleteAll(String paramString, String... paramVarArgs)
  {
    try
    {
      int i = new DeleteHandler(Connector.getDatabase()).onDeleteAll(paramString, paramVarArgs);
      return i;
    }
    finally {}
  }
  
  public static UpdateOrDeleteExecutor deleteAllAsync(Class<?> paramClass, final String... paramVarArgs)
  {
    final UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.deleteAll(this.val$modelClass, paramVarArgs);
          if (localUpdateOrDeleteExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.11.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public static UpdateOrDeleteExecutor deleteAllAsync(String paramString, final String... paramVarArgs)
  {
    final UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.deleteAll(this.val$tableName, paramVarArgs);
          if (localUpdateOrDeleteExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.12.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public static UpdateOrDeleteExecutor deleteAsync(Class<?> paramClass, final long paramLong)
  {
    UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.delete(this.val$modelClass, paramLong);
          if (this.val$executor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.10.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public static boolean deleteDatabase(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = paramString;
        if (!paramString.endsWith(".db"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(".db");
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString = LitePalApplication.getContext().getDatabasePath((String)localObject);
        if (paramString.exists())
        {
          bool = paramString.delete();
          if (bool)
          {
            removeVersionInSharedPreferences((String)localObject);
            Connector.clearLitePalOpenHelperInstance();
          }
          return bool;
        }
        paramString = new StringBuilder();
        paramString.append(LitePalApplication.getContext().getExternalFilesDir(""));
        paramString.append("/databases/");
        paramString = paramString.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        boolean bool = new File(localStringBuilder.toString()).delete();
        if (bool)
        {
          removeVersionInSharedPreferences((String)localObject);
          Connector.clearLitePalOpenHelperInstance();
        }
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public static <T> T find(Class<T> paramClass, long paramLong)
  {
    return (T)find(paramClass, paramLong, false);
  }
  
  public static <T> T find(Class<T> paramClass, long paramLong, boolean paramBoolean)
  {
    try
    {
      paramClass = new QueryHandler(Connector.getDatabase()).onFind(paramClass, paramLong, paramBoolean);
      return paramClass;
    }
    finally {}
  }
  
  public static <T> List<T> findAll(Class<T> paramClass, boolean paramBoolean, long... paramVarArgs)
  {
    try
    {
      paramClass = new QueryHandler(Connector.getDatabase()).onFindAll(paramClass, paramBoolean, paramVarArgs);
      return paramClass;
    }
    finally {}
  }
  
  public static <T> List<T> findAll(Class<T> paramClass, long... paramVarArgs)
  {
    return findAll(paramClass, false, paramVarArgs);
  }
  
  public static <T> FindMultiExecutor<T> findAllAsync(Class<T> paramClass, final boolean paramBoolean, final long... paramVarArgs)
  {
    final FindMultiExecutor localFindMultiExecutor = new FindMultiExecutor();
    localFindMultiExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final List localList = Operator.findAll(this.val$modelClass, paramBoolean, paramVarArgs);
          if (localFindMultiExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.9.this.val$executor.getListener().onFinish(localList);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindMultiExecutor;
  }
  
  public static <T> FindMultiExecutor<T> findAllAsync(Class<T> paramClass, long... paramVarArgs)
  {
    return findAllAsync(paramClass, false, paramVarArgs);
  }
  
  public static <T> FindExecutor<T> findAsync(Class<T> paramClass, long paramLong)
  {
    return findAsync(paramClass, paramLong, false);
  }
  
  public static <T> FindExecutor<T> findAsync(Class<T> paramClass, final long paramLong, boolean paramBoolean)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.find(this.val$modelClass, paramLong, localFindExecutor);
          if (this.val$executor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.6.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static Cursor findBySQL(String... paramVarArgs)
  {
    try
    {
      BaseUtility.checkConditionsCorrect(paramVarArgs);
      String[] arrayOfString = null;
      if (paramVarArgs == null) {
        return null;
      }
      if (paramVarArgs.length <= 0) {
        return null;
      }
      if (paramVarArgs.length != 1)
      {
        arrayOfString = new String[paramVarArgs.length - 1];
        System.arraycopy(paramVarArgs, 1, arrayOfString, 0, paramVarArgs.length - 1);
      }
      paramVarArgs = Connector.getDatabase().rawQuery(paramVarArgs[0], arrayOfString);
      return paramVarArgs;
    }
    finally {}
  }
  
  public static <T> T findFirst(Class<T> paramClass)
  {
    return (T)findFirst(paramClass, false);
  }
  
  public static <T> T findFirst(Class<T> paramClass, boolean paramBoolean)
  {
    try
    {
      paramClass = new QueryHandler(Connector.getDatabase()).onFindFirst(paramClass, paramBoolean);
      return paramClass;
    }
    finally {}
  }
  
  public static <T> FindExecutor<T> findFirstAsync(Class<T> paramClass)
  {
    return findFirstAsync(paramClass, false);
  }
  
  public static <T> FindExecutor<T> findFirstAsync(Class<T> paramClass, final boolean paramBoolean)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.findFirst(this.val$modelClass, paramBoolean);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.7.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static <T> T findLast(Class<T> paramClass)
  {
    return (T)findLast(paramClass, false);
  }
  
  public static <T> T findLast(Class<T> paramClass, boolean paramBoolean)
  {
    try
    {
      paramClass = new QueryHandler(Connector.getDatabase()).onFindLast(paramClass, paramBoolean);
      return paramClass;
    }
    finally {}
  }
  
  public static <T> FindExecutor<T> findLastAsync(Class<T> paramClass)
  {
    return findLastAsync(paramClass, false);
  }
  
  public static <T> FindExecutor<T> findLastAsync(Class<T> paramClass, final boolean paramBoolean)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.findLast(this.val$modelClass, paramBoolean);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.8.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static DatabaseListener getDBListener()
  {
    return dbListener;
  }
  
  public static SQLiteDatabase getDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = Connector.getDatabase();
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public static Handler getHandler()
  {
    return handler;
  }
  
  public static void initialize(Context paramContext)
  {
    LitePalApplication.sContext = paramContext;
  }
  
  private static boolean isDefaultDatabase(String paramString)
  {
    if (BaseUtility.isLitePalXMLExists())
    {
      Object localObject = paramString;
      if (!paramString.endsWith(".db"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".db");
        localObject = ((StringBuilder)localObject).toString();
      }
      String str = LitePalParser.parseLitePalConfiguration().getDbName();
      paramString = str;
      if (!str.endsWith(".db"))
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append(".db");
        paramString = paramString.toString();
      }
      return ((String)localObject).equalsIgnoreCase(paramString);
    }
    return false;
  }
  
  public static <T> boolean isExist(Class<T> paramClass, String... paramVarArgs)
  {
    return (paramVarArgs != null) && (where(paramVarArgs).count(paramClass) > 0);
  }
  
  public static FluentQuery limit(int paramInt)
  {
    FluentQuery localFluentQuery = new FluentQuery();
    localFluentQuery.mLimit = String.valueOf(paramInt);
    return localFluentQuery;
  }
  
  public static <T extends LitePalSupport> void markAsDeleted(Collection<T> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((LitePalSupport)paramCollection.next()).clearSavedState();
    }
  }
  
  public static <T> T max(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> T max(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new FluentQuery().max(paramString1, paramString2, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public static <T> FindExecutor<T> maxAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> maxAsync(String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.max(this.val$tableName, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.3.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static <T> T min(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> T min(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new FluentQuery().min(paramString1, paramString2, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public static <T> FindExecutor<T> minAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> minAsync(String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.min(this.val$tableName, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.4.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static FluentQuery offset(int paramInt)
  {
    FluentQuery localFluentQuery = new FluentQuery();
    localFluentQuery.mOffset = String.valueOf(paramInt);
    return localFluentQuery;
  }
  
  public static FluentQuery order(String paramString)
  {
    FluentQuery localFluentQuery = new FluentQuery();
    localFluentQuery.mOrderBy = paramString;
    return localFluentQuery;
  }
  
  public static void registerDatabaseListener(DatabaseListener paramDatabaseListener)
  {
    dbListener = paramDatabaseListener;
  }
  
  private static void removeVersionInSharedPreferences(String paramString)
  {
    if (isDefaultDatabase(paramString))
    {
      SharedUtil.removeVersion(null);
      return;
    }
    SharedUtil.removeVersion(paramString);
  }
  
  /* Error */
  public static <T extends LitePalSupport> void saveAll(Collection<T> paramCollection)
  {
    // Byte code:
    //   0: ldc 122
    //   2: monitorenter
    //   3: invokestatic 170	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 175	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   11: new 495	org/litepal/crud/SaveHandler
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 496	org/litepal/crud/SaveHandler:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   19: aload_0
    //   20: invokevirtual 499	org/litepal/crud/SaveHandler:onSaveAll	(Ljava/util/Collection;)V
    //   23: aload_1
    //   24: invokevirtual 186	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   27: aload_1
    //   28: invokevirtual 189	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   31: ldc 122
    //   33: monitorexit
    //   34: return
    //   35: astore_0
    //   36: goto +17 -> 53
    //   39: astore_0
    //   40: new 501	org/litepal/exceptions/LitePalSupportException
    //   43: dup
    //   44: aload_0
    //   45: invokevirtual 504	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   48: aload_0
    //   49: invokespecial 507	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: aload_1
    //   54: invokevirtual 189	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: ldc 122
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramCollection	Collection<T>
    //   6	48	1	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	27	35	finally
    //   40	53	35	finally
    //   11	27	39	java/lang/Exception
    //   3	11	59	finally
    //   27	34	59	finally
    //   53	59	59	finally
    //   60	63	59	finally
  }
  
  public static <T extends LitePalSupport> SaveExecutor saveAllAsync(Collection<T> paramCollection)
  {
    final SaveExecutor localSaveExecutor = new SaveExecutor();
    localSaveExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          try
          {
            Operator.saveAll(this.val$collection);
            bool = true;
          }
          finally
          {
            break label51;
          }
        }
        catch (Exception localException)
        {
          final boolean bool;
          label51:
          for (;;) {}
        }
        bool = false;
        if (localSaveExecutor.getListener() != null) {
          Operator.getHandler().post(new Runnable()
          {
            public void run()
            {
              Operator.15.this.val$executor.getListener().onFinish(bool);
            }
          });
        }
        return;
        throw ((Throwable)localObject);
      }
    });
    return localSaveExecutor;
  }
  
  public static FluentQuery select(String... paramVarArgs)
  {
    FluentQuery localFluentQuery = new FluentQuery();
    localFluentQuery.mColumns = paramVarArgs;
    return localFluentQuery;
  }
  
  public static <T> T sum(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> T sum(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new FluentQuery().sum(paramString1, paramString2, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public static <T> FindExecutor<T> sumAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public static <T> FindExecutor<T> sumAsync(String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = Operator.sum(this.val$tableName, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.5.this.val$executor.getListener().onFinish(localObject1);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localFindExecutor;
  }
  
  public static int update(Class<?> paramClass, ContentValues paramContentValues, long paramLong)
  {
    try
    {
      int i = new UpdateHandler(Connector.getDatabase()).onUpdate(paramClass, paramLong, paramContentValues);
      return i;
    }
    finally {}
  }
  
  public static int updateAll(Class<?> paramClass, ContentValues paramContentValues, String... paramVarArgs)
  {
    return updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramContentValues, paramVarArgs);
  }
  
  public static int updateAll(String paramString, ContentValues paramContentValues, String... paramVarArgs)
  {
    try
    {
      int i = new UpdateHandler(Connector.getDatabase()).onUpdateAll(paramString, paramContentValues, paramVarArgs);
      return i;
    }
    finally {}
  }
  
  public static UpdateOrDeleteExecutor updateAllAsync(Class<?> paramClass, ContentValues paramContentValues, String... paramVarArgs)
  {
    return updateAllAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramContentValues, paramVarArgs);
  }
  
  public static UpdateOrDeleteExecutor updateAllAsync(String paramString, final ContentValues paramContentValues, final String... paramVarArgs)
  {
    final UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.updateAll(this.val$tableName, paramContentValues, paramVarArgs);
          if (localUpdateOrDeleteExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.14.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public static UpdateOrDeleteExecutor updateAsync(Class<?> paramClass, final ContentValues paramContentValues, final long paramLong)
  {
    UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = Operator.update(this.val$modelClass, paramContentValues, paramLong);
          if (this.val$executor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                Operator.13.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public static void use(LitePalDB paramLitePalDB)
  {
    try
    {
      LitePalAttr localLitePalAttr = LitePalAttr.getInstance();
      localLitePalAttr.setDbName(paramLitePalDB.getDbName());
      localLitePalAttr.setVersion(paramLitePalDB.getVersion());
      localLitePalAttr.setStorage(paramLitePalDB.getStorage());
      localLitePalAttr.setClassNames(paramLitePalDB.getClassNames());
      if (!isDefaultDatabase(paramLitePalDB.getDbName()))
      {
        localLitePalAttr.setExtraKeyName(paramLitePalDB.getDbName());
        localLitePalAttr.setCases("lower");
      }
      Connector.clearLitePalOpenHelperInstance();
      return;
    }
    finally {}
  }
  
  public static void useDefault()
  {
    try
    {
      LitePalAttr.clearInstance();
      Connector.clearLitePalOpenHelperInstance();
      return;
    }
    finally {}
  }
  
  public static FluentQuery where(String... paramVarArgs)
  {
    FluentQuery localFluentQuery = new FluentQuery();
    localFluentQuery.mConditions = paramVarArgs;
    return localFluentQuery;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */