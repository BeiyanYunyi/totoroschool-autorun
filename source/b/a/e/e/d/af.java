package b.a.e.e.d;

import b.a.b.b;
import b.a.e.a.d;
import b.a.g.e;
import b.a.q;
import b.a.s;
import b.a.t;
import b.a.t.c;
import java.util.concurrent.TimeUnit;

public final class af<T>
  extends a<T, T>
{
  final long b;
  final TimeUnit c;
  final t d;
  final boolean e;
  
  public af(q<T> paramq, long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    super(paramq);
    this.b = paramLong;
    this.c = paramTimeUnit;
    this.d = paramt;
    this.e = paramBoolean;
  }
  
  public void subscribeActual(s<? super T> params)
  {
    if (!this.e) {
      params = new e(params);
    }
    t.c localc = this.d.a();
    this.a.subscribe(new a(params, this.b, this.c, localc, this.e));
  }
  
  static final class a<T>
    implements b, s<T>
  {
    final s<? super T> a;
    final long b;
    final TimeUnit c;
    final t.c d;
    final boolean e;
    b f;
    
    a(s<? super T> params, long paramLong, TimeUnit paramTimeUnit, t.c paramc, boolean paramBoolean)
    {
      this.a = params;
      this.b = paramLong;
      this.c = paramTimeUnit;
      this.d = paramc;
      this.e = paramBoolean;
    }
    
    public void dispose()
    {
      this.f.dispose();
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      this.d.a(new a(), this.b, this.c);
    }
    
    public void onError(Throwable paramThrowable)
    {
      t.c localc = this.d;
      paramThrowable = new b(paramThrowable);
      long l;
      if (this.e) {
        l = this.b;
      } else {
        l = 0L;
      }
      localc.a(paramThrowable, l, this.c);
    }
    
    public void onNext(T paramT)
    {
      this.d.a(new c(paramT), this.b, this.c);
    }
    
    public void onSubscribe(b paramb)
    {
      if (d.validate(this.f, paramb))
      {
        this.f = paramb;
        this.a.onSubscribe(this);
      }
    }
    
    final class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        try
        {
          af.a.this.a.onComplete();
          return;
        }
        finally
        {
          af.a.this.d.dispose();
        }
      }
    }
    
    final class b
      implements Runnable
    {
      private final Throwable b;
      
      b(Throwable paramThrowable)
      {
        this.b = paramThrowable;
      }
      
      public void run()
      {
        try
        {
          af.a.this.a.onError(this.b);
          return;
        }
        finally
        {
          af.a.this.d.dispose();
        }
      }
    }
    
    final class c
      implements Runnable
    {
      private final T b;
      
      c()
      {
        Object localObject;
        this.b = localObject;
      }
      
      public void run()
      {
        af.a.this.a.onNext(this.b);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */