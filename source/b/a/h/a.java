package b.a.h;

import b.a.c.d;
import b.a.d.e;
import b.a.d.g;
import b.a.e.j.j;
import b.a.i;
import b.a.l;
import b.a.s;
import b.a.t;
import b.a.u;
import b.a.v;
import java.util.concurrent.Callable;

public final class a
{
  static volatile g<? super Throwable> a;
  static volatile b.a.d.h<? super Runnable, ? extends Runnable> b;
  static volatile b.a.d.h<? super Callable<t>, ? extends t> c;
  static volatile b.a.d.h<? super Callable<t>, ? extends t> d;
  static volatile b.a.d.h<? super Callable<t>, ? extends t> e;
  static volatile b.a.d.h<? super Callable<t>, ? extends t> f;
  static volatile b.a.d.h<? super t, ? extends t> g;
  static volatile b.a.d.h<? super t, ? extends t> h;
  static volatile b.a.d.h<? super b.a.f, ? extends b.a.f> i;
  static volatile b.a.d.h<? super l, ? extends l> j;
  static volatile b.a.d.h<? super b.a.f.a, ? extends b.a.f.a> k;
  static volatile b.a.d.h<? super b.a.h, ? extends b.a.h> l;
  static volatile b.a.d.h<? super u, ? extends u> m;
  static volatile b.a.d.h<? super b.a.b, ? extends b.a.b> n;
  static volatile b.a.d.c<? super b.a.f, ? super org.a.b, ? extends org.a.b> o;
  static volatile b.a.d.c<? super b.a.h, ? super i, ? extends i> p;
  static volatile b.a.d.c<? super l, ? super s, ? extends s> q;
  static volatile b.a.d.c<? super u, ? super v, ? extends v> r;
  static volatile b.a.d.c<? super b.a.b, ? super b.a.c, ? extends b.a.c> s;
  static volatile e t;
  static volatile boolean u;
  
  public static b.a.b a(b.a.b paramb)
  {
    b.a.d.h localh = n;
    if (localh != null) {
      return (b.a.b)a(localh, paramb);
    }
    return paramb;
  }
  
  public static b.a.c a(b.a.b paramb, b.a.c paramc)
  {
    b.a.d.c localc = s;
    if (localc != null) {
      return (b.a.c)a(localc, paramb, paramc);
    }
    return paramc;
  }
  
  public static <T> b.a.f.a<T> a(b.a.f.a<T> parama)
  {
    b.a.d.h localh = k;
    if (localh != null) {
      return (b.a.f.a)a(localh, parama);
    }
    return parama;
  }
  
  public static <T> b.a.f<T> a(b.a.f<T> paramf)
  {
    b.a.d.h localh = i;
    if (localh != null) {
      return (b.a.f)a(localh, paramf);
    }
    return paramf;
  }
  
  public static <T> b.a.h<T> a(b.a.h<T> paramh)
  {
    b.a.d.h localh = l;
    if (localh != null) {
      return (b.a.h)a(localh, paramh);
    }
    return paramh;
  }
  
  public static <T> i<? super T> a(b.a.h<T> paramh, i<? super T> parami)
  {
    b.a.d.c localc = p;
    if (localc != null) {
      return (i)a(localc, paramh, parami);
    }
    return parami;
  }
  
  public static <T> l<T> a(l<T> paraml)
  {
    b.a.d.h localh = j;
    if (localh != null) {
      return (l)a(localh, paraml);
    }
    return paraml;
  }
  
  public static <T> s<? super T> a(l<T> paraml, s<? super T> params)
  {
    b.a.d.c localc = q;
    if (localc != null) {
      return (s)a(localc, paraml, params);
    }
    return params;
  }
  
  static t a(b.a.d.h<? super Callable<t>, ? extends t> paramh, Callable<t> paramCallable)
  {
    return (t)b.a.e.b.b.a(a(paramh, paramCallable), "Scheduler Callable result can't be null");
  }
  
  public static t a(t paramt)
  {
    b.a.d.h localh = g;
    if (localh == null) {
      return paramt;
    }
    return (t)a(localh, paramt);
  }
  
  public static t a(Callable<t> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "Scheduler Callable can't be null");
    b.a.d.h localh = c;
    if (localh == null) {
      return e(paramCallable);
    }
    return a(localh, paramCallable);
  }
  
  public static <T> u<T> a(u<T> paramu)
  {
    b.a.d.h localh = m;
    if (localh != null) {
      return (u)a(localh, paramu);
    }
    return paramu;
  }
  
  public static <T> v<? super T> a(u<T> paramu, v<? super T> paramv)
  {
    b.a.d.c localc = r;
    if (localc != null) {
      return (v)a(localc, paramu, paramv);
    }
    return paramv;
  }
  
  static <T, U, R> R a(b.a.d.c<T, U, R> paramc, T paramT, U paramU)
  {
    try
    {
      paramc = paramc.a(paramT, paramU);
      return paramc;
    }
    catch (Throwable paramc)
    {
      throw j.a(paramc);
    }
  }
  
  static <T, R> R a(b.a.d.h<T, R> paramh, T paramT)
  {
    try
    {
      paramh = paramh.apply(paramT);
      return paramh;
    }
    catch (Throwable paramh)
    {
      throw j.a(paramh);
    }
  }
  
  public static Runnable a(Runnable paramRunnable)
  {
    b.a.e.b.b.a(paramRunnable, "run is null");
    b.a.d.h localh = b;
    if (localh == null) {
      return paramRunnable;
    }
    return (Runnable)a(localh, paramRunnable);
  }
  
  public static <T> org.a.b<? super T> a(b.a.f<T> paramf, org.a.b<? super T> paramb)
  {
    b.a.d.c localc = o;
    if (localc != null) {
      return (org.a.b)a(localc, paramf, paramb);
    }
    return paramb;
  }
  
  public static void a(Throwable paramThrowable)
  {
    g localg = a;
    Object localObject;
    if (paramThrowable == null)
    {
      localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }
    else
    {
      localObject = paramThrowable;
      if (!b(paramThrowable)) {
        localObject = new b.a.c.f(paramThrowable);
      }
    }
    if (localg != null) {
      try
      {
        localg.accept(localObject);
        return;
      }
      catch (Throwable paramThrowable)
      {
        paramThrowable.printStackTrace();
        c(paramThrowable);
      }
    }
    ((Throwable)localObject).printStackTrace();
    c((Throwable)localObject);
  }
  
  public static boolean a()
  {
    return u;
  }
  
  public static t b(t paramt)
  {
    b.a.d.h localh = h;
    if (localh == null) {
      return paramt;
    }
    return (t)a(localh, paramt);
  }
  
  public static t b(Callable<t> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "Scheduler Callable can't be null");
    b.a.d.h localh = e;
    if (localh == null) {
      return e(paramCallable);
    }
    return a(localh, paramCallable);
  }
  
  public static boolean b()
  {
    e locale = t;
    if (locale != null) {
      try
      {
        boolean bool = locale.a();
        return bool;
      }
      catch (Throwable localThrowable)
      {
        throw j.a(localThrowable);
      }
    }
    return false;
  }
  
  static boolean b(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof d)) {
      return true;
    }
    if ((paramThrowable instanceof b.a.c.c)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalStateException)) {
      return true;
    }
    if ((paramThrowable instanceof NullPointerException)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalArgumentException)) {
      return true;
    }
    return (paramThrowable instanceof b.a.c.a);
  }
  
  public static t c(Callable<t> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "Scheduler Callable can't be null");
    b.a.d.h localh = f;
    if (localh == null) {
      return e(paramCallable);
    }
    return a(localh, paramCallable);
  }
  
  static void c(Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
  }
  
  public static t d(Callable<t> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "Scheduler Callable can't be null");
    b.a.d.h localh = d;
    if (localh == null) {
      return e(paramCallable);
    }
    return a(localh, paramCallable);
  }
  
  static t e(Callable<t> paramCallable)
  {
    try
    {
      paramCallable = (t)b.a.e.b.b.a(paramCallable.call(), "Scheduler Callable result can't be null");
      return paramCallable;
    }
    catch (Throwable paramCallable)
    {
      throw j.a(paramCallable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */