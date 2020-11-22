package b.a.g;

import b.a.e.a.e;
import b.a.s;

public final class d<T>
  implements b.a.b.b, s<T>
{
  final s<? super T> a;
  b.a.b.b b;
  boolean c;
  
  public d(s<? super T> params)
  {
    this.a = params;
  }
  
  void a()
  {
    this.c = true;
    NullPointerException localNullPointerException = new NullPointerException("Subscription not set!");
    try
    {
      this.a.onSubscribe(e.INSTANCE);
      try
      {
        this.a.onError(localNullPointerException);
        return;
      }
      catch (Throwable localThrowable1)
      {
        b.a.c.b.b(localThrowable1);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { localNullPointerException, localThrowable1 }));
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
      b.a.h.a.a(new b.a.c.a(new Throwable[] { localNullPointerException, localThrowable2 }));
    }
  }
  
  void b()
  {
    NullPointerException localNullPointerException = new NullPointerException("Subscription not set!");
    try
    {
      this.a.onSubscribe(e.INSTANCE);
      try
      {
        this.a.onError(localNullPointerException);
        return;
      }
      catch (Throwable localThrowable1)
      {
        b.a.c.b.b(localThrowable1);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { localNullPointerException, localThrowable1 }));
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      b.a.c.b.b(localThrowable2);
      b.a.h.a.a(new b.a.c.a(new Throwable[] { localNullPointerException, localThrowable2 }));
    }
  }
  
  public void dispose()
  {
    this.b.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.b.isDisposed();
  }
  
  public void onComplete()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.b == null)
    {
      b();
      return;
    }
    try
    {
      this.a.onComplete();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a.c.b.b(localThrowable);
      b.a.h.a.a(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.c)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    this.c = true;
    Object localObject;
    if (this.b == null)
    {
      localObject = new NullPointerException("Subscription not set!");
      try
      {
        this.a.onSubscribe(e.INSTANCE);
        try
        {
          this.a.onError(new b.a.c.a(new Throwable[] { paramThrowable, localObject }));
          return;
        }
        catch (Throwable localThrowable1)
        {
          b.a.c.b.b(localThrowable1);
          b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, localObject, localThrowable1 }));
          return;
        }
        localObject = paramThrowable;
      }
      catch (Throwable localThrowable2)
      {
        b.a.c.b.b(localThrowable2);
        b.a.h.a.a(new b.a.c.a(new Throwable[] { paramThrowable, localObject, localThrowable2 }));
        return;
      }
    }
    if (paramThrowable == null) {
      localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }
    try
    {
      this.a.onError((Throwable)localObject);
      return;
    }
    catch (Throwable paramThrowable)
    {
      b.a.c.b.b(paramThrowable);
      b.a.h.a.a(new b.a.c.a(new Throwable[] { localObject, paramThrowable }));
    }
  }
  
  public void onNext(T paramT)
  {
    if (this.c) {
      return;
    }
    if (this.b == null)
    {
      a();
      return;
    }
    if (paramT == null)
    {
      paramT = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
      try
      {
        this.b.dispose();
        onError(paramT);
        return;
      }
      catch (Throwable localThrowable1)
      {
        b.a.c.b.b(localThrowable1);
        onError(new b.a.c.a(new Throwable[] { paramT, localThrowable1 }));
        return;
      }
    }
    try
    {
      this.a.onNext(paramT);
      return;
    }
    catch (Throwable paramT)
    {
      b.a.c.b.b(paramT);
      try
      {
        this.b.dispose();
        onError(paramT);
        return;
      }
      catch (Throwable localThrowable2)
      {
        b.a.c.b.b(localThrowable2);
        onError(new b.a.c.a(new Throwable[] { paramT, localThrowable2 }));
      }
    }
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    if (b.a.e.a.d.validate(this.b, paramb))
    {
      this.b = paramb;
      try
      {
        this.a.onSubscribe(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        this.c = true;
        try
        {
          paramb.dispose();
          b.a.h.a.a(localThrowable);
          return;
        }
        catch (Throwable paramb)
        {
          b.a.c.b.b(paramb);
          b.a.h.a.a(new b.a.c.a(new Throwable[] { localThrowable, paramb }));
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */