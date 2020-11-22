package b.a.e.e.d;

import b.a.d.g;
import b.a.e.a.d;
import b.a.e.j.j;
import b.a.q;
import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class cf<T>
  extends b.a.f.a<T>
{
  final q<T> a;
  final AtomicReference<b<T>> b;
  final q<T> c;
  
  private cf(q<T> paramq1, q<T> paramq2, AtomicReference<b<T>> paramAtomicReference)
  {
    this.c = paramq1;
    this.a = paramq2;
    this.b = paramAtomicReference;
  }
  
  public static <T> b.a.f.a<T> a(q<T> paramq)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return b.a.h.a.a(new cf(new c(localAtomicReference), paramq, localAtomicReference));
  }
  
  public void a(g<? super b.a.b.b> paramg)
  {
    b localb2;
    b localb1;
    do
    {
      localb2 = (b)this.b.get();
      if (localb2 != null)
      {
        localb1 = localb2;
        if (!localb2.isDisposed()) {
          break;
        }
      }
      localb1 = new b(this.b);
    } while (!this.b.compareAndSet(localb2, localb1));
    boolean bool = localb1.e.get();
    int i = 1;
    if ((bool) || (!localb1.e.compareAndSet(false, true))) {
      i = 0;
    }
    try
    {
      paramg.accept(localb1);
      if (i != 0) {
        this.a.subscribe(localb1);
      }
      return;
    }
    catch (Throwable paramg)
    {
      b.a.c.b.b(paramg);
      throw j.a(paramg);
    }
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.c.subscribe(params);
  }
  
  static final class a<T>
    extends AtomicReference<Object>
    implements b.a.b.b
  {
    private static final long serialVersionUID = -1100270633763673112L;
    final s<? super T> child;
    
    a(s<? super T> params)
    {
      this.child = params;
    }
    
    public void dispose()
    {
      Object localObject = getAndSet(this);
      if ((localObject != null) && (localObject != this)) {
        ((cf.b)localObject).b(this);
      }
    }
    
    public boolean isDisposed()
    {
      return get() == this;
    }
    
    void setParent(cf.b<T> paramb)
    {
      if (!compareAndSet(null, paramb)) {
        paramb.b(this);
      }
    }
  }
  
  static final class b<T>
    implements b.a.b.b, s<T>
  {
    static final cf.a[] b = new cf.a[0];
    static final cf.a[] c = new cf.a[0];
    final AtomicReference<b<T>> a;
    final AtomicReference<cf.a<T>[]> d = new AtomicReference(b);
    final AtomicBoolean e;
    final AtomicReference<b.a.b.b> f = new AtomicReference();
    
    b(AtomicReference<b<T>> paramAtomicReference)
    {
      this.a = paramAtomicReference;
      this.e = new AtomicBoolean();
    }
    
    boolean a(cf.a<T> parama)
    {
      cf.a[] arrayOfa1;
      cf.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (cf.a[])this.d.get();
        if (arrayOfa1 == c) {
          return false;
        }
        int i = arrayOfa1.length;
        arrayOfa2 = new cf.a[i + 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
        arrayOfa2[i] = parama;
      } while (!this.d.compareAndSet(arrayOfa1, arrayOfa2));
      return true;
    }
    
    void b(cf.a<T> parama)
    {
      cf.a[] arrayOfa2;
      cf.a[] arrayOfa1;
      do
      {
        arrayOfa2 = (cf.a[])this.d.get();
        int m = arrayOfa2.length;
        if (m == 0) {
          return;
        }
        int k = -1;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          if (arrayOfa2[i].equals(parama))
          {
            j = i;
            break;
          }
          i += 1;
        }
        if (j < 0) {
          return;
        }
        if (m == 1)
        {
          arrayOfa1 = b;
        }
        else
        {
          arrayOfa1 = new cf.a[m - 1];
          System.arraycopy(arrayOfa2, 0, arrayOfa1, 0, j);
          System.arraycopy(arrayOfa2, j + 1, arrayOfa1, j, m - j - 1);
        }
      } while (!this.d.compareAndSet(arrayOfa2, arrayOfa1));
    }
    
    public void dispose()
    {
      if ((cf.a[])this.d.getAndSet(c) != c)
      {
        this.a.compareAndSet(this, null);
        d.dispose(this.f);
      }
    }
    
    public boolean isDisposed()
    {
      return this.d.get() == c;
    }
    
    public void onComplete()
    {
      this.a.compareAndSet(this, null);
      cf.a[] arrayOfa = (cf.a[])this.d.getAndSet(c);
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].child.onComplete();
        i += 1;
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.a.compareAndSet(this, null);
      cf.a[] arrayOfa = (cf.a[])this.d.getAndSet(c);
      if (arrayOfa.length != 0)
      {
        int j = arrayOfa.length;
        int i = 0;
        while (i < j)
        {
          arrayOfa[i].child.onError(paramThrowable);
          i += 1;
        }
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      cf.a[] arrayOfa = (cf.a[])this.d.get();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].child.onNext(paramT);
        i += 1;
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      d.setOnce(this.f, paramb);
    }
  }
  
  static final class c<T>
    implements q<T>
  {
    private final AtomicReference<cf.b<T>> a;
    
    c(AtomicReference<cf.b<T>> paramAtomicReference)
    {
      this.a = paramAtomicReference;
    }
    
    public void subscribe(s<? super T> params)
    {
      cf.a locala = new cf.a(params);
      params.onSubscribe(locala);
      do
      {
        cf.b localb;
        do
        {
          localb = (cf.b)this.a.get();
          if (localb != null)
          {
            params = localb;
            if (!localb.isDisposed()) {
              break;
            }
          }
          params = new cf.b(this.a);
        } while (!this.a.compareAndSet(localb, params));
      } while (!params.a(locala));
      locala.setParent(params);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */