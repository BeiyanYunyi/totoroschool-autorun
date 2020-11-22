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
import java.util.concurrent.atomic.AtomicReference;

public final class n<T, U extends Collection<? super T>, B>
  extends a<T, U>
{
  final Callable<? extends q<B>> b;
  final Callable<U> c;
  
  public n(q<T> paramq, Callable<? extends q<B>> paramCallable, Callable<U> paramCallable1)
  {
    super(paramq);
    this.b = paramCallable;
    this.c = paramCallable1;
  }
  
  protected void subscribeActual(s<? super U> params)
  {
    this.a.subscribe(new b(new b.a.g.e(params), this.c, this.b));
  }
  
  static final class a<T, U extends Collection<? super T>, B>
    extends c<B>
  {
    final n.b<T, U, B> a;
    boolean b;
    
    a(n.b<T, U, B> paramb)
    {
      this.a = paramb;
    }
    
    public void onComplete()
    {
      if (this.b) {
        return;
      }
      this.b = true;
      this.a.g();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.b)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.b = true;
      this.a.onError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      dispose();
      this.a.g();
    }
  }
  
  static final class b<T, U extends Collection<? super T>, B>
    extends p<T, U, U>
    implements b.a.b.b, s<T>
  {
    final Callable<U> g;
    final Callable<? extends q<B>> h;
    b.a.b.b i;
    final AtomicReference<b.a.b.b> j = new AtomicReference();
    U k;
    
    b(s<? super U> params, Callable<U> paramCallable, Callable<? extends q<B>> paramCallable1)
    {
      super(new b.a.e.f.a());
      this.g = paramCallable;
      this.h = paramCallable1;
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
        this.i.dispose();
        f();
        if (c()) {
          this.b.clear();
        }
      }
    }
    
    void f()
    {
      d.dispose(this.j);
    }
    
    void g()
    {
      try
      {
        Collection localCollection1 = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
        try
        {
          q localq = (q)b.a.e.b.b.a(this.h.call(), "The boundary ObservableSource supplied is null");
          n.a locala = new n.a(this);
          if (d.replace(this.j, locala)) {
            try
            {
              Collection localCollection2 = this.k;
              if (localCollection2 == null) {
                return;
              }
              this.k = localCollection1;
              localq.subscribe(locala);
              a(localCollection2, false, this);
              return;
            }
            finally {}
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          b.a.c.b.b(localThrowable1);
          this.c = true;
          this.i.dispose();
          this.a.onError(localThrowable1);
          return;
        }
        return;
      }
      catch (Throwable localThrowable2)
      {
        b.a.c.b.b(localThrowable2);
        dispose();
        this.a.onError(localThrowable2);
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
        s locals = this.a;
        try
        {
          Object localObject = (Collection)b.a.e.b.b.a(this.g.call(), "The buffer supplied is null");
          this.k = ((Collection)localObject);
          try
          {
            localObject = (q)b.a.e.b.b.a(this.h.call(), "The boundary ObservableSource supplied is null");
            paramb = new n.a(this);
            this.j.set(paramb);
            locals.onSubscribe(this);
            if (!this.c)
            {
              ((q)localObject).subscribe(paramb);
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            b.a.c.b.b(localThrowable1);
            this.c = true;
            paramb.dispose();
            b.a.e.a.e.error(localThrowable1, locals);
            return;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          b.a.c.b.b(localThrowable2);
          this.c = true;
          paramb.dispose();
          b.a.e.a.e.error(localThrowable2, locals);
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */