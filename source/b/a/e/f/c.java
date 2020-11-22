package b.a.e.f;

import b.a.e.c.f;
import b.a.e.j.q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c<T>
  implements f<T>
{
  static final int a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
  private static final Object j = new Object();
  final AtomicLong b = new AtomicLong();
  int c;
  long d;
  final int e;
  AtomicReferenceArray<Object> f;
  final int g;
  AtomicReferenceArray<Object> h;
  final AtomicLong i = new AtomicLong();
  
  public c(int paramInt)
  {
    paramInt = q.a(Math.max(8, paramInt));
    int k = paramInt - 1;
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramInt + 1);
    this.f = localAtomicReferenceArray;
    this.e = k;
    a(paramInt);
    this.h = localAtomicReferenceArray;
    this.g = k;
    this.d = (k - 1);
    a(0L);
  }
  
  private static int a(long paramLong, int paramInt)
  {
    return b((int)paramLong & paramInt);
  }
  
  private T a(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.h = paramAtomicReferenceArray;
    paramInt = a(paramLong, paramInt);
    Object localObject = b(paramAtomicReferenceArray, paramInt);
    if (localObject != null)
    {
      a(paramAtomicReferenceArray, paramInt, null);
      b(paramLong + 1L);
    }
    return (T)localObject;
  }
  
  private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    paramInt = b(paramInt);
    AtomicReferenceArray localAtomicReferenceArray = (AtomicReferenceArray)b(paramAtomicReferenceArray, paramInt);
    a(paramAtomicReferenceArray, paramInt, null);
    return localAtomicReferenceArray;
  }
  
  private void a(int paramInt)
  {
    this.c = Math.min(paramInt / 4, a);
  }
  
  private void a(long paramLong)
  {
    this.b.lazySet(paramLong);
  }
  
  private static void a(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt, Object paramObject)
  {
    paramAtomicReferenceArray.lazySet(paramInt, paramObject);
  }
  
  private void a(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong1, int paramInt, T paramT, long paramLong2)
  {
    AtomicReferenceArray localAtomicReferenceArray = new AtomicReferenceArray(paramAtomicReferenceArray.length());
    this.f = localAtomicReferenceArray;
    this.d = (paramLong2 + paramLong1 - 1L);
    a(localAtomicReferenceArray, paramInt, paramT);
    a(paramAtomicReferenceArray, localAtomicReferenceArray);
    a(paramAtomicReferenceArray, paramInt, j);
    a(paramLong1 + 1L);
  }
  
  private void a(AtomicReferenceArray<Object> paramAtomicReferenceArray1, AtomicReferenceArray<Object> paramAtomicReferenceArray2)
  {
    a(paramAtomicReferenceArray1, b(paramAtomicReferenceArray1.length() - 1), paramAtomicReferenceArray2);
  }
  
  private boolean a(AtomicReferenceArray<Object> paramAtomicReferenceArray, T paramT, long paramLong, int paramInt)
  {
    a(paramAtomicReferenceArray, paramInt, paramT);
    a(paramLong + 1L);
    return true;
  }
  
  private static int b(int paramInt)
  {
    return paramInt;
  }
  
  private static <E> Object b(AtomicReferenceArray<Object> paramAtomicReferenceArray, int paramInt)
  {
    return paramAtomicReferenceArray.get(paramInt);
  }
  
  private T b(AtomicReferenceArray<Object> paramAtomicReferenceArray, long paramLong, int paramInt)
  {
    this.h = paramAtomicReferenceArray;
    return (T)b(paramAtomicReferenceArray, a(paramLong, paramInt));
  }
  
  private void b(long paramLong)
  {
    this.i.lazySet(paramLong);
  }
  
  private long c()
  {
    return this.b.get();
  }
  
  private long d()
  {
    return this.i.get();
  }
  
  private long e()
  {
    return this.b.get();
  }
  
  private long f()
  {
    return this.i.get();
  }
  
  public T a()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.h;
    long l = f();
    int k = this.g;
    Object localObject = b(localAtomicReferenceArray, a(l, k));
    if (localObject == j) {
      return (T)b(a(localAtomicReferenceArray, k + 1), l, k);
    }
    return (T)localObject;
  }
  
  public boolean a(T paramT1, T paramT2)
  {
    AtomicReferenceArray localAtomicReferenceArray1 = this.f;
    long l1 = c();
    int k = this.e;
    long l2 = 2L + l1;
    if (b(localAtomicReferenceArray1, a(l2, k)) == null)
    {
      k = a(l1, k);
      a(localAtomicReferenceArray1, k + 1, paramT2);
      a(localAtomicReferenceArray1, k, paramT1);
      a(l2);
    }
    else
    {
      AtomicReferenceArray localAtomicReferenceArray2 = new AtomicReferenceArray(localAtomicReferenceArray1.length());
      this.f = localAtomicReferenceArray2;
      k = a(l1, k);
      a(localAtomicReferenceArray2, k + 1, paramT2);
      a(localAtomicReferenceArray2, k, paramT1);
      a(localAtomicReferenceArray1, localAtomicReferenceArray2);
      a(localAtomicReferenceArray1, k, j);
      a(l2);
    }
    return true;
  }
  
  public int b()
  {
    long l2;
    for (long l1 = d();; l1 = l2)
    {
      long l3 = c();
      l2 = d();
      if (l1 == l2) {
        return (int)(l3 - l2);
      }
    }
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public boolean isEmpty()
  {
    return c() == d();
  }
  
  public boolean offer(T paramT)
  {
    if (paramT != null)
    {
      AtomicReferenceArray localAtomicReferenceArray = this.f;
      long l1 = e();
      int k = this.e;
      int m = a(l1, k);
      if (l1 < this.d) {
        return a(localAtomicReferenceArray, paramT, l1, m);
      }
      long l2 = this.c + l1;
      if (b(localAtomicReferenceArray, a(l2, k)) == null)
      {
        this.d = (l2 - 1L);
        return a(localAtomicReferenceArray, paramT, l1, m);
      }
      if (b(localAtomicReferenceArray, a(1L + l1, k)) == null) {
        return a(localAtomicReferenceArray, paramT, l1, m);
      }
      a(localAtomicReferenceArray, l1, m, paramT, k);
      return true;
    }
    throw new NullPointerException("Null is not a valid element");
  }
  
  public T poll()
  {
    AtomicReferenceArray localAtomicReferenceArray = this.h;
    long l = f();
    int m = this.g;
    int n = a(l, m);
    Object localObject = b(localAtomicReferenceArray, n);
    int k;
    if (localObject == j) {
      k = 1;
    } else {
      k = 0;
    }
    if ((localObject != null) && (k == 0))
    {
      a(localAtomicReferenceArray, n, null);
      b(l + 1L);
      return (T)localObject;
    }
    if (k != 0) {
      return (T)a(a(localAtomicReferenceArray, m + 1), l, m);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */