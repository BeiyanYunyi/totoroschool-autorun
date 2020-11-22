package b.a.e.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class l
{
  public static final boolean a;
  public static final int b;
  static final AtomicReference<ScheduledExecutorService> c = new AtomicReference();
  static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();
  
  static
  {
    Properties localProperties = System.getProperties();
    a locala = new a();
    locala.a(localProperties);
    a = locala.a;
    b = locala.b;
    a();
  }
  
  public static ScheduledExecutorService a(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    a(a, paramThreadFactory);
    return paramThreadFactory;
  }
  
  public static void a()
  {
    a(a);
  }
  
  static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      for (;;)
      {
        ScheduledExecutorService localScheduledExecutorService1 = (ScheduledExecutorService)c.get();
        if (localScheduledExecutorService1 != null) {
          return;
        }
        ScheduledExecutorService localScheduledExecutorService2 = Executors.newScheduledThreadPool(1, new h("RxSchedulerPurge"));
        if (c.compareAndSet(localScheduledExecutorService1, localScheduledExecutorService2))
        {
          localScheduledExecutorService2.scheduleAtFixedRate(new b(), b, b, TimeUnit.SECONDS);
          return;
        }
        localScheduledExecutorService2.shutdownNow();
      }
    }
  }
  
  static void a(boolean paramBoolean, ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramBoolean) && ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor)))
    {
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)paramScheduledExecutorService;
      d.put(localScheduledThreadPoolExecutor, paramScheduledExecutorService);
    }
  }
  
  static final class a
  {
    boolean a;
    int b;
    
    void a(Properties paramProperties)
    {
      if (paramProperties.containsKey("rx2.purge-enabled")) {
        this.a = Boolean.parseBoolean(paramProperties.getProperty("rx2.purge-enabled"));
      } else {
        this.a = true;
      }
      if ((this.a) && (paramProperties.containsKey("rx2.purge-period-seconds"))) {}
      try
      {
        this.b = Integer.parseInt(paramProperties.getProperty("rx2.purge-period-seconds"));
        return;
      }
      catch (NumberFormatException paramProperties)
      {
        for (;;) {}
      }
      this.b = 1;
      return;
      this.b = 1;
    }
  }
  
  static final class b
    implements Runnable
  {
    public void run()
    {
      Iterator localIterator = new ArrayList(l.d.keySet()).iterator();
      while (localIterator.hasNext())
      {
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)localIterator.next();
        if (localScheduledThreadPoolExecutor.isShutdown()) {
          l.d.remove(localScheduledThreadPoolExecutor);
        } else {
          localScheduledThreadPoolExecutor.purge();
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\g\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */