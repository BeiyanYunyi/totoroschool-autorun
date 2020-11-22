package com.amap.api.mapcore.util;

public abstract class jf
  implements Runnable
{
  a d;
  
  public final void cancelTask()
  {
    try
    {
      if (this.d != null)
      {
        this.d.c(this);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ThreadTask", "cancelTask");
      localThrowable.printStackTrace();
    }
  }
  
  public final void run()
  {
    try
    {
      if (this.d != null) {
        this.d.a(this);
      }
      if (Thread.interrupted()) {
        return;
      }
      runTask();
      if (Thread.interrupted()) {
        return;
      }
      if (this.d != null)
      {
        this.d.b(this);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ThreadTask", "run");
      localThrowable.printStackTrace();
    }
  }
  
  public abstract void runTask();
  
  static abstract interface a
  {
    public abstract void a(jf paramjf);
    
    public abstract void b(jf paramjf);
    
    public abstract void c(jf paramjf);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */