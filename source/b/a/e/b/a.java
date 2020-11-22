package b.a.e.b;

import b.a.c.d;
import b.a.d.e;
import b.a.d.g;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import b.a.d.l;
import b.a.d.m;
import b.a.d.n;
import b.a.d.o;
import b.a.d.p;
import b.a.d.q;
import b.a.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class a
{
  static final h<Object, Object> a = new v();
  public static final Runnable b = new q();
  public static final b.a.d.a c = new n();
  static final g<Object> d = new o();
  public static final g<Throwable> e = new s();
  public static final g<Throwable> f = new af();
  public static final p g = new p();
  static final q<Object> h = new ak();
  static final q<Object> i = new t();
  static final Callable<Object> j = new ae();
  static final Comparator<Object> k = new aa();
  public static final g<org.a.c> l = new y();
  
  public static <T, K> b.a.d.b<Map<K, T>, T> a(h<? super T, ? extends K> paramh)
  {
    return new ah(paramh);
  }
  
  public static <T, K, V> b.a.d.b<Map<K, V>, T> a(h<? super T, ? extends K> paramh, h<? super T, ? extends V> paramh1)
  {
    return new ai(paramh1, paramh);
  }
  
  public static <T, K, V> b.a.d.b<Map<K, Collection<V>>, T> a(h<? super T, ? extends K> paramh, h<? super T, ? extends V> paramh1, h<? super K, ? extends Collection<? super V>> paramh2)
  {
    return new aj(paramh2, paramh1, paramh);
  }
  
  public static <T> g<T> a(b.a.d.a parama)
  {
    return new a(parama);
  }
  
  public static <T> g<T> a(g<? super b.a.k<T>> paramg)
  {
    return new ad(paramg);
  }
  
  public static <T> h<T, T> a()
  {
    return a;
  }
  
  public static <T1, T2, R> h<Object[], R> a(b.a.d.c<? super T1, ? super T2, ? extends R> paramc)
  {
    b.a(paramc, "f is null");
    return new b(paramc);
  }
  
  public static <T1, T2, T3, R> h<Object[], R> a(i<T1, T2, T3, R> parami)
  {
    b.a(parami, "f is null");
    return new c(parami);
  }
  
  public static <T1, T2, T3, T4, R> h<Object[], R> a(j<T1, T2, T3, T4, R> paramj)
  {
    b.a(paramj, "f is null");
    return new d(paramj);
  }
  
  public static <T1, T2, T3, T4, T5, R> h<Object[], R> a(b.a.d.k<T1, T2, T3, T4, T5, R> paramk)
  {
    b.a(paramk, "f is null");
    return new e(paramk);
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> h<Object[], R> a(l<T1, T2, T3, T4, T5, T6, R> paraml)
  {
    b.a(paraml, "f is null");
    return new f(paraml);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> h<Object[], R> a(m<T1, T2, T3, T4, T5, T6, T7, R> paramm)
  {
    b.a(paramm, "f is null");
    return new g(paramm);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> h<Object[], R> a(n<T1, T2, T3, T4, T5, T6, T7, T8, R> paramn)
  {
    b.a(paramn, "f is null");
    return new h(paramn);
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h<Object[], R> a(o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> paramo)
  {
    b.a(paramo, "f is null");
    return new i(paramo);
  }
  
  public static <T, U> h<T, U> a(Class<U> paramClass)
  {
    return new l(paramClass);
  }
  
  public static <T> h<List<T>, List<T>> a(Comparator<? super T> paramComparator)
  {
    return new x(paramComparator);
  }
  
  public static <T> h<T, b.a.i.b<T>> a(TimeUnit paramTimeUnit, t paramt)
  {
    return new ag(paramTimeUnit, paramt);
  }
  
  public static <T> q<T> a(e parame)
  {
    return new k(parame);
  }
  
  public static <T> Callable<List<T>> a(int paramInt)
  {
    return new j(paramInt);
  }
  
  public static <T> Callable<T> a(T paramT)
  {
    return new w(paramT);
  }
  
  public static <T> g<T> b()
  {
    return d;
  }
  
  public static <T> g<Throwable> b(g<? super b.a.k<T>> paramg)
  {
    return new ac(paramg);
  }
  
  public static <T, U> h<T, U> b(U paramU)
  {
    return new w(paramU);
  }
  
  public static <T, U> q<T> b(Class<U> paramClass)
  {
    return new m(paramClass);
  }
  
  public static <T> b.a.d.a c(g<? super b.a.k<T>> paramg)
  {
    return new ab(paramg);
  }
  
  public static <T> q<T> c()
  {
    return h;
  }
  
  public static <T> q<T> c(T paramT)
  {
    return new r(paramT);
  }
  
  public static <T> q<T> d()
  {
    return i;
  }
  
  public static <T> Callable<T> e()
  {
    return j;
  }
  
  public static <T> Comparator<T> f()
  {
    return k;
  }
  
  public static <T> Callable<Set<T>> g()
  {
    return u.INSTANCE;
  }
  
  public static <T> Comparator<T> h()
  {
    return z.INSTANCE;
  }
  
  static final class a<T>
    implements g<T>
  {
    final b.a.d.a a;
    
    a(b.a.d.a parama)
    {
      this.a = parama;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.a.a();
    }
  }
  
  static final class aa
    implements Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
  
  static final class ab<T>
    implements b.a.d.a
  {
    final g<? super b.a.k<T>> a;
    
    ab(g<? super b.a.k<T>> paramg)
    {
      this.a = paramg;
    }
    
    public void a()
      throws Exception
    {
      this.a.accept(b.a.k.f());
    }
  }
  
  static final class ac<T>
    implements g<Throwable>
  {
    final g<? super b.a.k<T>> a;
    
    ac(g<? super b.a.k<T>> paramg)
    {
      this.a = paramg;
    }
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      this.a.accept(b.a.k.a(paramThrowable));
    }
  }
  
  static final class ad<T>
    implements g<T>
  {
    final g<? super b.a.k<T>> a;
    
    ad(g<? super b.a.k<T>> paramg)
    {
      this.a = paramg;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.a.accept(b.a.k.a(paramT));
    }
  }
  
  static final class ae
    implements Callable<Object>
  {
    public Object call()
    {
      return null;
    }
  }
  
  static final class af
    implements g<Throwable>
  {
    public void a(Throwable paramThrowable)
    {
      b.a.h.a.a(new d(paramThrowable));
    }
  }
  
  static final class ag<T>
    implements h<T, b.a.i.b<T>>
  {
    final TimeUnit a;
    final t b;
    
    ag(TimeUnit paramTimeUnit, t paramt)
    {
      this.a = paramTimeUnit;
      this.b = paramt;
    }
    
    public b.a.i.b<T> a(T paramT)
      throws Exception
    {
      return new b.a.i.b(paramT, this.b.a(this.a), this.a);
    }
  }
  
  static final class ah<K, T>
    implements b.a.d.b<Map<K, T>, T>
  {
    private final h<? super T, ? extends K> a;
    
    ah(h<? super T, ? extends K> paramh)
    {
      this.a = paramh;
    }
    
    public void a(Map<K, T> paramMap, T paramT)
      throws Exception
    {
      paramMap.put(this.a.apply(paramT), paramT);
    }
  }
  
  static final class ai<K, V, T>
    implements b.a.d.b<Map<K, V>, T>
  {
    private final h<? super T, ? extends V> a;
    private final h<? super T, ? extends K> b;
    
    ai(h<? super T, ? extends V> paramh, h<? super T, ? extends K> paramh1)
    {
      this.a = paramh;
      this.b = paramh1;
    }
    
    public void a(Map<K, V> paramMap, T paramT)
      throws Exception
    {
      paramMap.put(this.b.apply(paramT), this.a.apply(paramT));
    }
  }
  
  static final class aj<K, V, T>
    implements b.a.d.b<Map<K, Collection<V>>, T>
  {
    private final h<? super K, ? extends Collection<? super V>> a;
    private final h<? super T, ? extends V> b;
    private final h<? super T, ? extends K> c;
    
    aj(h<? super K, ? extends Collection<? super V>> paramh, h<? super T, ? extends V> paramh1, h<? super T, ? extends K> paramh2)
    {
      this.a = paramh;
      this.b = paramh1;
      this.c = paramh2;
    }
    
    public void a(Map<K, Collection<V>> paramMap, T paramT)
      throws Exception
    {
      Object localObject = this.c.apply(paramT);
      Collection localCollection2 = (Collection)paramMap.get(localObject);
      Collection localCollection1 = localCollection2;
      if (localCollection2 == null)
      {
        localCollection1 = (Collection)this.a.apply(localObject);
        paramMap.put(localObject, localCollection1);
      }
      localCollection1.add(this.b.apply(paramT));
    }
  }
  
  static final class ak
    implements q<Object>
  {
    public boolean a(Object paramObject)
    {
      return true;
    }
  }
  
  static final class b<T1, T2, R>
    implements h<Object[], R>
  {
    final b.a.d.c<? super T1, ? super T2, ? extends R> a;
    
    b(b.a.d.c<? super T1, ? super T2, ? extends R> paramc)
    {
      this.a = paramc;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 2) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 2 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class c<T1, T2, T3, R>
    implements h<Object[], R>
  {
    final i<T1, T2, T3, R> a;
    
    c(i<T1, T2, T3, R> parami)
    {
      this.a = parami;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 3) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 3 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class d<T1, T2, T3, T4, R>
    implements h<Object[], R>
  {
    final j<T1, T2, T3, T4, R> a;
    
    d(j<T1, T2, T3, T4, R> paramj)
    {
      this.a = paramj;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 4) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 4 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class e<T1, T2, T3, T4, T5, R>
    implements h<Object[], R>
  {
    private final b.a.d.k<T1, T2, T3, T4, T5, R> a;
    
    e(b.a.d.k<T1, T2, T3, T4, T5, R> paramk)
    {
      this.a = paramk;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 5) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 5 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class f<T1, T2, T3, T4, T5, T6, R>
    implements h<Object[], R>
  {
    final l<T1, T2, T3, T4, T5, T6, R> a;
    
    f(l<T1, T2, T3, T4, T5, T6, R> paraml)
    {
      this.a = paraml;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 6) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 6 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class g<T1, T2, T3, T4, T5, T6, T7, R>
    implements h<Object[], R>
  {
    final m<T1, T2, T3, T4, T5, T6, T7, R> a;
    
    g(m<T1, T2, T3, T4, T5, T6, T7, R> paramm)
    {
      this.a = paramm;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 7) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 7 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R>
    implements h<Object[], R>
  {
    final n<T1, T2, T3, T4, T5, T6, T7, T8, R> a;
    
    h(n<T1, T2, T3, T4, T5, T6, T7, T8, R> paramn)
    {
      this.a = paramn;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 8) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6], paramArrayOfObject[7]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 8 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
    implements h<Object[], R>
  {
    final o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;
    
    i(o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> paramo)
    {
      this.a = paramo;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 9) {
        return (R)this.a.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6], paramArrayOfObject[7], paramArrayOfObject[8]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 9 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class j<T>
    implements Callable<List<T>>
  {
    final int a;
    
    j(int paramInt)
    {
      this.a = paramInt;
    }
    
    public List<T> a()
      throws Exception
    {
      return new ArrayList(this.a);
    }
  }
  
  static final class k<T>
    implements q<T>
  {
    final e a;
    
    k(e parame)
    {
      this.a = parame;
    }
    
    public boolean a(T paramT)
      throws Exception
    {
      return this.a.a() ^ true;
    }
  }
  
  static final class l<T, U>
    implements h<T, U>
  {
    final Class<U> a;
    
    l(Class<U> paramClass)
    {
      this.a = paramClass;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.a.cast(paramT);
    }
  }
  
  static final class m<T, U>
    implements q<T>
  {
    final Class<U> a;
    
    m(Class<U> paramClass)
    {
      this.a = paramClass;
    }
    
    public boolean a(T paramT)
      throws Exception
    {
      return this.a.isInstance(paramT);
    }
  }
  
  static final class n
    implements b.a.d.a
  {
    public void a() {}
    
    public String toString()
    {
      return "EmptyAction";
    }
  }
  
  static final class o
    implements g<Object>
  {
    public void accept(Object paramObject) {}
    
    public String toString()
    {
      return "EmptyConsumer";
    }
  }
  
  static final class p
    implements p
  {}
  
  static final class q
    implements Runnable
  {
    public void run() {}
    
    public String toString()
    {
      return "EmptyRunnable";
    }
  }
  
  static final class r<T>
    implements q<T>
  {
    final T a;
    
    r(T paramT)
    {
      this.a = paramT;
    }
    
    public boolean a(T paramT)
      throws Exception
    {
      return b.a(paramT, this.a);
    }
  }
  
  static final class s
    implements g<Throwable>
  {
    public void a(Throwable paramThrowable)
    {
      b.a.h.a.a(paramThrowable);
    }
  }
  
  static final class t
    implements q<Object>
  {
    public boolean a(Object paramObject)
    {
      return false;
    }
  }
  
  static enum u
    implements Callable<Set<Object>>
  {
    private u() {}
    
    public Set<Object> call()
      throws Exception
    {
      return new HashSet();
    }
  }
  
  static final class v
    implements h<Object, Object>
  {
    public Object apply(Object paramObject)
    {
      return paramObject;
    }
    
    public String toString()
    {
      return "IdentityFunction";
    }
  }
  
  static final class w<T, U>
    implements h<T, U>, Callable<U>
  {
    final U a;
    
    w(U paramU)
    {
      this.a = paramU;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.a;
    }
    
    public U call()
      throws Exception
    {
      return (U)this.a;
    }
  }
  
  static final class x<T>
    implements h<List<T>, List<T>>
  {
    final Comparator<? super T> a;
    
    x(Comparator<? super T> paramComparator)
    {
      this.a = paramComparator;
    }
    
    public List<T> a(List<T> paramList)
    {
      Collections.sort(paramList, this.a);
      return paramList;
    }
  }
  
  static final class y
    implements g<org.a.c>
  {
    public void a(org.a.c paramc)
      throws Exception
    {
      paramc.request(Long.MAX_VALUE);
    }
  }
  
  static enum z
    implements Comparator<Object>
  {
    private z() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */