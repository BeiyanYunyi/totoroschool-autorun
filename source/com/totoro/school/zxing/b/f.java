package com.totoro.school.zxing.b;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class f
{
  private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new a(null));
  private final Activity b;
  private ScheduledFuture<?> c = null;
  
  public f(Activity paramActivity)
  {
    this.b = paramActivity;
    a();
  }
  
  private void c()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }
  
  public void a()
  {
    c();
    this.c = this.a.schedule(new e(this.b), 300L, TimeUnit.SECONDS);
  }
  
  public void b()
  {
    c();
    this.a.shutdown();
  }
  
  private static final class a
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setDaemon(true);
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */