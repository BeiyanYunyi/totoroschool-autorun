package b.a.e.e.c;

import b.a.d.h;
import b.a.e.j.j;
import b.a.h.a;
import b.a.l;
import b.a.s;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T>
  extends b.a.b
{
  final l<T> a;
  final h<? super T, ? extends b.a.d> b;
  final boolean c;
  
  public d(l<T> paraml, h<? super T, ? extends b.a.d> paramh, boolean paramBoolean)
  {
    this.a = paraml;
    this.b = paramh;
    this.c = paramBoolean;
  }
  
  protected void b(b.a.c paramc)
  {
    if (!g.a(this.a, this.b, paramc)) {
      this.a.subscribe(new a(paramc, this.b, this.c));
    }
  }
  
  static final class a<T>
    implements b.a.b.b, s<T>
  {
    static final a f = new a(null);
    final b.a.c a;
    final h<? super T, ? extends b.a.d> b;
    final boolean c;
    final b.a.e.j.c d;
    final AtomicReference<a> e;
    volatile boolean g;
    b.a.b.b h;
    
    a(b.a.c paramc, h<? super T, ? extends b.a.d> paramh, boolean paramBoolean)
    {
      this.a = paramc;
      this.b = paramh;
      this.c = paramBoolean;
      this.d = new b.a.e.j.c();
      this.e = new AtomicReference();
    }
    
    void a()
    {
      a locala = (a)this.e.getAndSet(f);
      if ((locala != null) && (locala != f)) {
        locala.dispose();
      }
    }
    
    void a(a parama)
    {
      if ((this.e.compareAndSet(parama, null)) && (this.g))
      {
        parama = this.d.terminate();
        if (parama == null)
        {
          this.a.onComplete();
          return;
        }
        this.a.onError(parama);
      }
    }
    
    void a(a parama, Throwable paramThrowable)
    {
      if ((this.e.compareAndSet(parama, null)) && (this.d.addThrowable(paramThrowable)))
      {
        if (this.c)
        {
          if (this.g)
          {
            parama = this.d.terminate();
            this.a.onError(parama);
          }
        }
        else
        {
          dispose();
          parama = this.d.terminate();
          if (parama != j.a) {
            this.a.onError(parama);
          }
        }
        return;
      }
      a.a(paramThrowable);
    }
    
    public void dispose()
    {
      this.h.dispose();
      a();
    }
    
    public boolean isDisposed()
    {
      return this.e.get() == f;
    }
    
    public void onComplete()
    {
      this.g = true;
      if (this.e.get() == null)
      {
        Throwable localThrowable = this.d.terminate();
        if (localThrowable == null)
        {
          this.a.onComplete();
          return;
        }
        this.a.onError(localThrowable);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d.addThrowable(paramThrowable))
      {
        if (this.c)
        {
          onComplete();
          return;
        }
        a();
        paramThrowable = this.d.terminate();
        if (paramThrowable != j.a) {
          this.a.onError(paramThrowable);
        }
      }
      else
      {
        a.a(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      try
      {
        paramT = (b.a.d)b.a.e.b.b.a(this.b.apply(paramT), "The mapper returned a null CompletableSource");
        a locala1 = new a(this);
        a locala2;
        do
        {
          locala2 = (a)this.e.get();
          if (locala2 == f) {
            return;
          }
        } while (!this.e.compareAndSet(locala2, locala1));
        if (locala2 != null) {
          locala2.dispose();
        }
        paramT.a(locala1);
        return;
      }
      catch (Throwable paramT)
      {
        b.a.c.b.b(paramT);
        this.h.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      if (b.a.e.a.d.validate(this.h, paramb))
      {
        this.h = paramb;
        this.a.onSubscribe(this);
      }
    }
    
    static final class a
      extends AtomicReference<b.a.b.b>
      implements b.a.c
    {
      private static final long serialVersionUID = -8003404460084760287L;
      final d.a<?> parent;
      
      a(d.a<?> parama)
      {
        this.parent = parama;
      }
      
      void dispose()
      {
        b.a.e.a.d.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.a(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.a(this, paramThrowable);
      }
      
      public void onSubscribe(b.a.b.b paramb)
      {
        b.a.e.a.d.setOnce(this, paramb);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */