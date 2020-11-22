package b.a.j;

import b.a.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  extends c<T>
{
  static final a[] a = new a[0];
  static final a[] b = new a[0];
  final AtomicReference<a<T>[]> c = new AtomicReference(b);
  Throwable d;
  
  public static <T> a<T> a()
  {
    return new a();
  }
  
  boolean a(a<T> parama)
  {
    a[] arrayOfa1;
    a[] arrayOfa2;
    do
    {
      arrayOfa1 = (a[])this.c.get();
      if (arrayOfa1 == a) {
        return false;
      }
      int i = arrayOfa1.length;
      arrayOfa2 = new a[i + 1];
      System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
      arrayOfa2[i] = parama;
    } while (!this.c.compareAndSet(arrayOfa1, arrayOfa2));
    return true;
  }
  
  void b(a<T> parama)
  {
    a[] arrayOfa2;
    a[] arrayOfa1;
    do
    {
      arrayOfa2 = (a[])this.c.get();
      if (arrayOfa2 == a) {
        break;
      }
      if (arrayOfa2 == b) {
        return;
      }
      int m = arrayOfa2.length;
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (arrayOfa2[i] == parama)
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
        arrayOfa1 = new a[m - 1];
        System.arraycopy(arrayOfa2, 0, arrayOfa1, 0, j);
        System.arraycopy(arrayOfa2, j + 1, arrayOfa1, j, m - j - 1);
      }
    } while (!this.c.compareAndSet(arrayOfa2, arrayOfa1));
    return;
  }
  
  public void onComplete()
  {
    if (this.c.get() == a) {
      return;
    }
    a[] arrayOfa = (a[])this.c.getAndSet(a);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].onComplete();
      i += 1;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.a.e.b.b.a(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.c.get() == a)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    this.d = paramThrowable;
    a[] arrayOfa = (a[])this.c.getAndSet(a);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].onError(paramThrowable);
      i += 1;
    }
  }
  
  public void onNext(T paramT)
  {
    b.a.e.b.b.a(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    a[] arrayOfa = (a[])this.c.get();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].onNext(paramT);
      i += 1;
    }
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    if (this.c.get() == a) {
      paramb.dispose();
    }
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    Object localObject = new a(params, this);
    params.onSubscribe((b.a.b.b)localObject);
    if (a((a)localObject))
    {
      if (((a)localObject).isDisposed()) {
        b((a)localObject);
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null)
      {
        params.onError((Throwable)localObject);
        return;
      }
      params.onComplete();
    }
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements b.a.b.b
  {
    private static final long serialVersionUID = 3562861878281475070L;
    final s<? super T> actual;
    final a<T> parent;
    
    a(s<? super T> params, a<T> parama)
    {
      this.actual = params;
      this.parent = parama;
    }
    
    public void dispose()
    {
      if (compareAndSet(false, true)) {
        this.parent.b(this);
      }
    }
    
    public boolean isDisposed()
    {
      return get();
    }
    
    public void onComplete()
    {
      if (!get()) {
        this.actual.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (get())
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!get()) {
        this.actual.onNext(paramT);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */