package b.a.a.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import b.a.b.c;
import b.a.h.a;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;

final class b
  extends t
{
  private final Handler b;
  private final boolean c;
  
  b(Handler paramHandler, boolean paramBoolean)
  {
    this.b = paramHandler;
    this.c = paramBoolean;
  }
  
  public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramRunnable != null)
    {
      if (paramTimeUnit != null)
      {
        paramRunnable = a.a(paramRunnable);
        paramRunnable = new b(this.b, paramRunnable);
        this.b.postDelayed(paramRunnable, paramTimeUnit.toMillis(paramLong));
        return paramRunnable;
      }
      throw new NullPointerException("unit == null");
    }
    throw new NullPointerException("run == null");
  }
  
  public t.c a()
  {
    return new a(this.b, this.c);
  }
  
  private static final class a
    extends t.c
  {
    private final Handler a;
    private final boolean b;
    private volatile boolean c;
    
    a(Handler paramHandler, boolean paramBoolean)
    {
      this.a = paramHandler;
      this.b = paramBoolean;
    }
    
    @SuppressLint({"NewApi"})
    public b.a.b.b a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramRunnable != null)
      {
        if (paramTimeUnit != null)
        {
          if (this.c) {
            return c.a();
          }
          paramRunnable = a.a(paramRunnable);
          paramRunnable = new b.b(this.a, paramRunnable);
          Message localMessage = Message.obtain(this.a, paramRunnable);
          localMessage.obj = this;
          if (this.b) {
            localMessage.setAsynchronous(true);
          }
          this.a.sendMessageDelayed(localMessage, paramTimeUnit.toMillis(paramLong));
          if (this.c)
          {
            this.a.removeCallbacks(paramRunnable);
            return c.a();
          }
          return paramRunnable;
        }
        throw new NullPointerException("unit == null");
      }
      throw new NullPointerException("run == null");
    }
    
    public void dispose()
    {
      this.c = true;
      this.a.removeCallbacksAndMessages(this);
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
  }
  
  private static final class b
    implements b.a.b.b, Runnable
  {
    private final Handler a;
    private final Runnable b;
    private volatile boolean c;
    
    b(Handler paramHandler, Runnable paramRunnable)
    {
      this.a = paramHandler;
      this.b = paramRunnable;
    }
    
    public void dispose()
    {
      this.a.removeCallbacks(this);
      this.c = true;
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void run()
    {
      try
      {
        this.b.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        a.a(localThrowable);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */