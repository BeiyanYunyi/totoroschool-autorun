package b.a.e.e.d;

import b.a.d.c;
import b.a.d.g;
import b.a.d.h;
import b.a.e;
import b.a.l;
import b.a.q;
import b.a.s;
import b.a.t;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class bn
{
  public static <T, S> c<S, e<T>, S> a(b.a.d.b<S, e<T>> paramb)
  {
    return new l(paramb);
  }
  
  public static <T, S> c<S, e<T>, S> a(g<e<T>> paramg)
  {
    return new m(paramg);
  }
  
  public static <T> g<T> a(s<T> params)
  {
    return new i(params);
  }
  
  public static <T, U> h<T, q<T>> a(h<? super T, ? extends q<U>> paramh)
  {
    return new f(paramh);
  }
  
  public static <T, U, R> h<T, q<R>> a(h<? super T, ? extends q<? extends U>> paramh, c<? super T, ? super U, ? extends R> paramc)
  {
    return new e(paramc, paramh);
  }
  
  public static <T, R> h<l<T>, q<R>> a(h<? super l<T>, ? extends q<R>> paramh, t paramt)
  {
    return new k(paramh, paramt);
  }
  
  public static <T> Callable<b.a.f.a<T>> a(l<T> paraml)
  {
    return new j(paraml);
  }
  
  public static <T> Callable<b.a.f.a<T>> a(l<T> paraml, int paramInt)
  {
    return new a(paraml, paramInt);
  }
  
  public static <T> Callable<b.a.f.a<T>> a(l<T> paraml, int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return new b(paraml, paramInt, paramLong, paramTimeUnit, paramt);
  }
  
  public static <T> Callable<b.a.f.a<T>> a(l<T> paraml, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return new n(paraml, paramLong, paramTimeUnit, paramt);
  }
  
  public static <T> g<Throwable> b(s<T> params)
  {
    return new h(params);
  }
  
  public static <T, U> h<T, q<U>> b(h<? super T, ? extends Iterable<? extends U>> paramh)
  {
    return new c(paramh);
  }
  
  public static <T> b.a.d.a c(s<T> params)
  {
    return new g(params);
  }
  
  public static <T, R> h<List<q<? extends T>>, q<? extends R>> c(h<? super Object[], ? extends R> paramh)
  {
    return new o(paramh);
  }
  
  static final class a<T>
    implements Callable<b.a.f.a<T>>
  {
    private final l<T> a;
    private final int b;
    
    a(l<T> paraml, int paramInt)
    {
      this.a = paraml;
      this.b = paramInt;
    }
    
    public b.a.f.a<T> a()
    {
      return this.a.replay(this.b);
    }
  }
  
  static final class b<T>
    implements Callable<b.a.f.a<T>>
  {
    private final l<T> a;
    private final int b;
    private final long c;
    private final TimeUnit d;
    private final t e;
    
    b(l<T> paraml, int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      this.a = paraml;
      this.b = paramInt;
      this.c = paramLong;
      this.d = paramTimeUnit;
      this.e = paramt;
    }
    
    public b.a.f.a<T> a()
    {
      return this.a.replay(this.b, this.c, this.d, this.e);
    }
  }
  
  static final class c<T, U>
    implements h<T, q<U>>
  {
    private final h<? super T, ? extends Iterable<? extends U>> a;
    
    c(h<? super T, ? extends Iterable<? extends U>> paramh)
    {
      this.a = paramh;
    }
    
    public q<U> a(T paramT)
      throws Exception
    {
      return new be((Iterable)b.a.e.b.b.a(this.a.apply(paramT), "The mapper returned a null Iterable"));
    }
  }
  
  static final class d<U, R, T>
    implements h<U, R>
  {
    private final c<? super T, ? super U, ? extends R> a;
    private final T b;
    
    d(c<? super T, ? super U, ? extends R> paramc, T paramT)
    {
      this.a = paramc;
      this.b = paramT;
    }
    
    public R apply(U paramU)
      throws Exception
    {
      return (R)this.a.a(this.b, paramU);
    }
  }
  
  static final class e<T, R, U>
    implements h<T, q<R>>
  {
    private final c<? super T, ? super U, ? extends R> a;
    private final h<? super T, ? extends q<? extends U>> b;
    
    e(c<? super T, ? super U, ? extends R> paramc, h<? super T, ? extends q<? extends U>> paramh)
    {
      this.a = paramc;
      this.b = paramh;
    }
    
    public q<R> a(T paramT)
      throws Exception
    {
      return new bv((q)b.a.e.b.b.a(this.b.apply(paramT), "The mapper returned a null ObservableSource"), new bn.d(this.a, paramT));
    }
  }
  
  static final class f<T, U>
    implements h<T, q<T>>
  {
    final h<? super T, ? extends q<U>> a;
    
    f(h<? super T, ? extends q<U>> paramh)
    {
      this.a = paramh;
    }
    
    public q<T> a(T paramT)
      throws Exception
    {
      return new dm((q)b.a.e.b.b.a(this.a.apply(paramT), "The itemDelay returned a null ObservableSource"), 1L).map(b.a.e.b.a.b(paramT)).defaultIfEmpty(paramT);
    }
  }
  
  static final class g<T>
    implements b.a.d.a
  {
    final s<T> a;
    
    g(s<T> params)
    {
      this.a = params;
    }
    
    public void a()
      throws Exception
    {
      this.a.onComplete();
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    final s<T> a;
    
    h(s<T> params)
    {
      this.a = params;
    }
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      this.a.onError(paramThrowable);
    }
  }
  
  static final class i<T>
    implements g<T>
  {
    final s<T> a;
    
    i(s<T> params)
    {
      this.a = params;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.a.onNext(paramT);
    }
  }
  
  static final class j<T>
    implements Callable<b.a.f.a<T>>
  {
    private final l<T> a;
    
    j(l<T> paraml)
    {
      this.a = paraml;
    }
    
    public b.a.f.a<T> a()
    {
      return this.a.replay();
    }
  }
  
  static final class k<T, R>
    implements h<l<T>, q<R>>
  {
    private final h<? super l<T>, ? extends q<R>> a;
    private final t b;
    
    k(h<? super l<T>, ? extends q<R>> paramh, t paramt)
    {
      this.a = paramh;
      this.b = paramt;
    }
    
    public q<R> a(l<T> paraml)
      throws Exception
    {
      return l.wrap((q)b.a.e.b.b.a(this.a.apply(paraml), "The selector returned a null ObservableSource")).observeOn(this.b);
    }
  }
  
  static final class l<T, S>
    implements c<S, e<T>, S>
  {
    final b.a.d.b<S, e<T>> a;
    
    l(b.a.d.b<S, e<T>> paramb)
    {
      this.a = paramb;
    }
    
    public S a(S paramS, e<T> parame)
      throws Exception
    {
      this.a.a(paramS, parame);
      return paramS;
    }
  }
  
  static final class m<T, S>
    implements c<S, e<T>, S>
  {
    final g<e<T>> a;
    
    m(g<e<T>> paramg)
    {
      this.a = paramg;
    }
    
    public S a(S paramS, e<T> parame)
      throws Exception
    {
      this.a.accept(parame);
      return paramS;
    }
  }
  
  static final class n<T>
    implements Callable<b.a.f.a<T>>
  {
    private final l<T> a;
    private final long b;
    private final TimeUnit c;
    private final t d;
    
    n(l<T> paraml, long paramLong, TimeUnit paramTimeUnit, t paramt)
    {
      this.a = paraml;
      this.b = paramLong;
      this.c = paramTimeUnit;
      this.d = paramt;
    }
    
    public b.a.f.a<T> a()
    {
      return this.a.replay(this.b, this.c, this.d);
    }
  }
  
  static final class o<T, R>
    implements h<List<q<? extends T>>, q<? extends R>>
  {
    private final h<? super Object[], ? extends R> a;
    
    o(h<? super Object[], ? extends R> paramh)
    {
      this.a = paramh;
    }
    
    public q<? extends R> a(List<q<? extends T>> paramList)
    {
      return l.zipIterable(paramList, this.a, false, l.bufferSize());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */