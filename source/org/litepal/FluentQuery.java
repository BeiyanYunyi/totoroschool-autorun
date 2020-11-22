package org.litepal;

import android.os.Handler;
import java.util.List;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.callback.AverageCallback;
import org.litepal.crud.callback.CountCallback;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class FluentQuery
{
  public String[] mColumns;
  public String[] mConditions;
  public String mLimit;
  public String mOffset;
  public String mOrderBy;
  
  public double average(Class<?> paramClass, String paramString)
  {
    return average(BaseUtility.changeCase(paramClass.getSimpleName()), paramString);
  }
  
  public double average(String paramString1, String paramString2)
  {
    try
    {
      double d = new QueryHandler(Connector.getDatabase()).onAverage(paramString1, paramString2, this.mConditions);
      return d;
    }
    finally {}
  }
  
  public AverageExecutor averageAsync(Class<?> paramClass, String paramString)
  {
    return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString);
  }
  
  public AverageExecutor averageAsync(final String paramString1, final String paramString2)
  {
    final AverageExecutor localAverageExecutor = new AverageExecutor();
    localAverageExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final double d = FluentQuery.this.average(paramString1, paramString2);
          if (localAverageExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.5.this.val$executor.getListener().onFinish(d);
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
  
  public int count(Class<?> paramClass)
  {
    return count(BaseUtility.changeCase(paramClass.getSimpleName()));
  }
  
  public int count(String paramString)
  {
    try
    {
      int i = new QueryHandler(Connector.getDatabase()).onCount(paramString, this.mConditions);
      return i;
    }
    finally {}
  }
  
  public CountExecutor countAsync(Class<?> paramClass)
  {
    return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())));
  }
  
  public CountExecutor countAsync(final String paramString)
  {
    final CountExecutor localCountExecutor = new CountExecutor();
    localCountExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = FluentQuery.this.count(paramString);
          if (localCountExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.4.this.val$executor.getListener().onFinish(i);
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
  
  public <T> List<T> find(Class<T> paramClass)
  {
    return find(paramClass, false);
  }
  
  public <T> List<T> find(Class<T> paramClass, boolean paramBoolean)
  {
    for (;;)
    {
      QueryHandler localQueryHandler;
      Object localObject;
      try
      {
        localQueryHandler = new QueryHandler(Connector.getDatabase());
        if (this.mOffset == null)
        {
          localObject = this.mLimit;
        }
        else
        {
          if (this.mLimit == null) {
            this.mLimit = "0";
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.mOffset);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.mLimit);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      finally {}
      paramClass = localQueryHandler.onFind(paramClass, this.mColumns, this.mConditions, this.mOrderBy, (String)localObject, paramBoolean);
      return paramClass;
    }
  }
  
  public <T> FindMultiExecutor<T> findAsync(Class<T> paramClass)
  {
    return findAsync(paramClass, false);
  }
  
  public <T> FindMultiExecutor<T> findAsync(final Class<T> paramClass, final boolean paramBoolean)
  {
    final FindMultiExecutor localFindMultiExecutor = new FindMultiExecutor();
    localFindMultiExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final List localList = FluentQuery.this.find(paramClass, paramBoolean);
          if (localFindMultiExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.1.this.val$executor.getListener().onFinish(localList);
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
  
  public <T> T findFirst(Class<T> paramClass)
  {
    return (T)findFirst(paramClass, false);
  }
  
  public <T> T findFirst(Class<T> paramClass, boolean paramBoolean)
  {
    try
    {
      paramClass = find(paramClass, paramBoolean);
      if (paramClass.size() > 0)
      {
        paramClass = paramClass.get(0);
        return paramClass;
      }
      return null;
    }
    finally {}
  }
  
  public <T> FindExecutor<T> findFirstAsync(Class<T> paramClass)
  {
    return findFirstAsync(paramClass, false);
  }
  
  public <T> FindExecutor<T> findFirstAsync(final Class<T> paramClass, final boolean paramBoolean)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = FluentQuery.this.findFirst(paramClass, paramBoolean);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.2.this.val$executor.getListener().onFinish(localObject1);
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
  
  public <T> T findLast(Class<T> paramClass)
  {
    return (T)findLast(paramClass, false);
  }
  
  public <T> T findLast(Class<T> paramClass, boolean paramBoolean)
  {
    try
    {
      paramClass = find(paramClass, paramBoolean);
      int i = paramClass.size();
      if (i > 0)
      {
        paramClass = paramClass.get(i - 1);
        return paramClass;
      }
      return null;
    }
    finally {}
  }
  
  public <T> FindExecutor<T> findLastAsync(Class<T> paramClass)
  {
    return findLastAsync(paramClass, false);
  }
  
  public <T> FindExecutor<T> findLastAsync(final Class<T> paramClass, final boolean paramBoolean)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = FluentQuery.this.findLast(paramClass, paramBoolean);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.3.this.val$executor.getListener().onFinish(localObject1);
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
  
  public FluentQuery limit(int paramInt)
  {
    this.mLimit = String.valueOf(paramInt);
    return this;
  }
  
  public <T> T max(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)max(BaseUtility.changeCase(paramClass.getSimpleName()), paramString, paramClass1);
  }
  
  public <T> T max(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new QueryHandler(Connector.getDatabase()).onMax(paramString1, paramString2, this.mConditions, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public <T> FindExecutor<T> maxAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public <T> FindExecutor<T> maxAsync(final String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = FluentQuery.this.max(paramString1, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.6.this.val$executor.getListener().onFinish(localObject1);
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
  
  public <T> T min(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)min(BaseUtility.changeCase(paramClass.getSimpleName()), paramString, paramClass1);
  }
  
  public <T> T min(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new QueryHandler(Connector.getDatabase()).onMin(paramString1, paramString2, this.mConditions, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public <T> FindExecutor<T> minAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public <T> FindExecutor<T> minAsync(final String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = FluentQuery.this.min(paramString1, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.7.this.val$executor.getListener().onFinish(localObject1);
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
  
  public FluentQuery offset(int paramInt)
  {
    this.mOffset = String.valueOf(paramInt);
    return this;
  }
  
  public FluentQuery order(String paramString)
  {
    this.mOrderBy = paramString;
    return this;
  }
  
  public FluentQuery select(String... paramVarArgs)
  {
    this.mColumns = paramVarArgs;
    return this;
  }
  
  public <T> T sum(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return (T)sum(BaseUtility.changeCase(paramClass.getSimpleName()), paramString, paramClass1);
  }
  
  public <T> T sum(String paramString1, String paramString2, Class<T> paramClass)
  {
    try
    {
      paramString1 = new QueryHandler(Connector.getDatabase()).onSum(paramString1, paramString2, this.mConditions, paramClass);
      return paramString1;
    }
    finally {}
  }
  
  public <T> FindExecutor<T> sumAsync(Class<?> paramClass, String paramString, Class<T> paramClass1)
  {
    return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(paramClass.getName())), paramString, paramClass1);
  }
  
  public <T> FindExecutor<T> sumAsync(final String paramString1, final String paramString2, final Class<T> paramClass)
  {
    final FindExecutor localFindExecutor = new FindExecutor();
    localFindExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final Object localObject1 = FluentQuery.this.sum(paramString1, paramString2, paramClass);
          if (localFindExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                FluentQuery.8.this.val$executor.getListener().onFinish(localObject1);
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
  
  public FluentQuery where(String... paramVarArgs)
  {
    this.mConditions = paramVarArgs;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\FluentQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */