package b.a.e.e.d;

import b.a.e.a.d;
import b.a.e.c.f;
import b.a.e.d.p;
import b.a.e.j.r;
import b.a.g.c;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class o<T, U extends Collection<? super T>, B>
  extends a<T, U>
{
  final q<B> b;
  final Callable<U> c;
  
  public o(q<T> paramq, q<B> paramq1, Callable<U> paramCallable)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramCallable;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    this.a.subscribe(new b(new b.a.g.e(params), this.c, this.b));
  }
  
  static final class a<T, U extends Collection<? super T>, B>
    extends c<B>
  {
    final o.b<T, U, B> a;
    
    a(o.b<T, U, B> paramb)
    {
      this.a = paramb;
    }
    
    public void onComplete()
    {
      this.a.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.onError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.a.f();
    }
  }
  
  static final class b<T, U extends Collection<? super T>, B>
    extends p<T, U, U>
    implements b.a.b.b, s<T>
  {
    final Callable<U> g;
    final q<B> h;
    b.a.b.b i;
    b.a.b.b j;
    U k;
    
    b(s<? super U> params, Callable<U> paramCallable, q<B> paramq)
    {
      super(new b.a.e.f.a());
      this.g = paramCallable;
      this.h = paramq;
    }
    
    public void a(s<? super U> params, U paramU)
    {
      this.a.onNext(paramU);
    }
    
    public void dispose()
    {
      if (!this.c)
      {
        this.c = true;
        this.j.dispose();
        this.i.dispose();
        if (c()) {
          this.b.clear();
        }
      }
    }
    
    void f()
    {
      try
      {
        Collection localCollection1 = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
        try
        {
          Collection localCollection2 = this.k;
          if (localCollection2 == null) {
            return;
          }
          this.k = localCollection1;
          a(localCollection2, false, this);
          return;
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        b.a.c.b.b(localThrowable);
        dispose();
        this.a.onError(localThrowable);
      }
    }
    
    public boolean isDisposed()
    {
      return this.c;
    }
    
    public void onComplete()
    {
      try
      {
        Collection localCollection = this.k;
        if (localCollection == null) {
          return;
        }
        this.k = null;
        this.b.offer(localCollection);
        this.d = true;
        if (c()) {
          r.a(this.b, this.a, false, this, this);
        }
        return;
      }
      finally {}
    }
    
    public void onError(Throwable paramThrowable)
    {
      dispose();
      this.a.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      try
      {
        Collection localCollection = this.k;
        if (localCollection == null) {
          return;
        }
        localCollection.add(paramT);
        return;
      }
      finally {}
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (d.validate(this.i, paramb))
      {
        this.i = paramb;
        try
        {
          Collection localCollection = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
          this.k = localCollection;
          paramb = new o.a(this);
          this.j = paramb;
          this.a.onSubscribe(this);
          if (!this.c)
          {
            this.h.subscribe(paramb);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          b.a.c.b.b(localThrowable);
          this.c = true;
          paramb.dispose();
          b.a.e.a.e.error(localThrowable, this.a);
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */