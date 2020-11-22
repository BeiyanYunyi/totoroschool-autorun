package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.f.e;
import com.bumptech.glide.g;
import com.bumptech.glide.load.b.c.b;

class i
  implements b, Runnable
{
  private final g a;
  private final a b;
  private final a<?, ?, ?> c;
  private b d;
  private volatile boolean e;
  
  public i(a parama, a<?, ?, ?> parama1, g paramg)
  {
    this.b = parama;
    this.c = parama1;
    this.d = b.CACHE;
    this.a = paramg;
  }
  
  private void a(k paramk)
  {
    this.b.a(paramk);
  }
  
  private void a(Exception paramException)
  {
    if (c())
    {
      this.d = b.SOURCE;
      this.b.b(this);
      return;
    }
    this.b.a(paramException);
  }
  
  private boolean c()
  {
    return this.d == b.CACHE;
  }
  
  private k<?> d()
    throws Exception
  {
    if (c()) {
      return e();
    }
    return f();
  }
  
  private k<?> e()
    throws Exception
  {
    Object localObject1;
    try
    {
      k localk = this.c.a();
    }
    catch (Exception localException)
    {
      if (Log.isLoggable("EngineRunnable", 3))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception decoding result from cache: ");
        ((StringBuilder)localObject2).append(localException);
        Log.d("EngineRunnable", ((StringBuilder)localObject2).toString());
      }
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.c.b();
    }
    return (k<?>)localObject2;
  }
  
  private k<?> f()
    throws Exception
  {
    return this.c.c();
  }
  
  public void a()
  {
    this.e = true;
    this.c.d();
  }
  
  public int b()
  {
    return this.a.ordinal();
  }
  
  public void run()
  {
    if (this.e) {
      return;
    }
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = d();
      localObject2 = null;
    }
    catch (Exception localException)
    {
      localObject1 = localObject3;
      localObject2 = localException;
      if (Log.isLoggable("EngineRunnable", 2))
      {
        Log.v("EngineRunnable", "Exception decoding", localException);
        localObject2 = localException;
        localObject1 = localObject3;
      }
    }
    if (this.e)
    {
      if (localObject1 != null) {
        ((k)localObject1).d();
      }
      return;
    }
    if (localObject1 == null)
    {
      a((Exception)localObject2);
      return;
    }
    a((k)localObject1);
  }
  
  static abstract interface a
    extends e
  {
    public abstract void b(i parami);
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */