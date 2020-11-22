package b.a;

import b.a.e.e.d.aa;
import b.a.e.e.d.ab;
import b.a.e.e.d.ac;
import b.a.e.e.d.ad;
import b.a.e.e.d.ae;
import b.a.e.e.d.af;
import b.a.e.e.d.ag;
import b.a.e.e.d.ah;
import b.a.e.e.d.ai;
import b.a.e.e.d.aj;
import b.a.e.e.d.ak;
import b.a.e.e.d.al;
import b.a.e.e.d.am;
import b.a.e.e.d.an;
import b.a.e.e.d.ao;
import b.a.e.e.d.aq;
import b.a.e.e.d.ar;
import b.a.e.e.d.as;
import b.a.e.e.d.at;
import b.a.e.e.d.au;
import b.a.e.e.d.av;
import b.a.e.e.d.ax;
import b.a.e.e.d.ay;
import b.a.e.e.d.az;
import b.a.e.e.d.ba;
import b.a.e.e.d.bb;
import b.a.e.e.d.bc;
import b.a.e.e.d.bd;
import b.a.e.e.d.be;
import b.a.e.e.d.bf;
import b.a.e.e.d.bg;
import b.a.e.e.d.bh;
import b.a.e.e.d.bi;
import b.a.e.e.d.bj;
import b.a.e.e.d.bk;
import b.a.e.e.d.bl;
import b.a.e.e.d.bm;
import b.a.e.e.d.bn;
import b.a.e.e.d.bo;
import b.a.e.e.d.bp;
import b.a.e.e.d.bq;
import b.a.e.e.d.br;
import b.a.e.e.d.bs;
import b.a.e.e.d.bt;
import b.a.e.e.d.bu;
import b.a.e.e.d.bv;
import b.a.e.e.d.bw;
import b.a.e.e.d.bx;
import b.a.e.e.d.by;
import b.a.e.e.d.bz;
import b.a.e.e.d.ca;
import b.a.e.e.d.cb;
import b.a.e.e.d.cc;
import b.a.e.e.d.cd;
import b.a.e.e.d.ce;
import b.a.e.e.d.cf;
import b.a.e.e.d.cg;
import b.a.e.e.d.ch;
import b.a.e.e.d.ci;
import b.a.e.e.d.cj;
import b.a.e.e.d.ck;
import b.a.e.e.d.cl;
import b.a.e.e.d.cn;
import b.a.e.e.d.co;
import b.a.e.e.d.cp;
import b.a.e.e.d.cq;
import b.a.e.e.d.cr;
import b.a.e.e.d.cs;
import b.a.e.e.d.ct;
import b.a.e.e.d.cu;
import b.a.e.e.d.cv;
import b.a.e.e.d.cw;
import b.a.e.e.d.cx;
import b.a.e.e.d.cy;
import b.a.e.e.d.da;
import b.a.e.e.d.db;
import b.a.e.e.d.dc;
import b.a.e.e.d.dd;
import b.a.e.e.d.de;
import b.a.e.e.d.df;
import b.a.e.e.d.dg;
import b.a.e.e.d.dh;
import b.a.e.e.d.di;
import b.a.e.e.d.dj;
import b.a.e.e.d.dk;
import b.a.e.e.d.dl;
import b.a.e.e.d.dm;
import b.a.e.e.d.dn;
import b.a.e.e.d.do;
import b.a.e.e.d.dp;
import b.a.e.e.d.dq;
import b.a.e.e.d.dr;
import b.a.e.e.d.ds;
import b.a.e.e.d.dt;
import b.a.e.e.d.du;
import b.a.e.e.d.dv;
import b.a.e.e.d.dw;
import b.a.e.e.d.dx;
import b.a.e.e.d.dy;
import b.a.e.e.d.dz;
import b.a.e.e.d.ea;
import b.a.e.e.d.eb;
import b.a.e.e.d.ec;
import b.a.e.e.d.ed;
import b.a.e.e.d.ee;
import b.a.e.e.d.ef;
import b.a.e.e.d.eg;
import b.a.e.e.d.eh;
import b.a.e.e.d.ei;
import b.a.e.e.d.ej;
import b.a.e.e.d.ek;
import b.a.e.e.d.el;
import b.a.e.e.d.v;
import b.a.e.e.d.x;
import b.a.e.e.d.y;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class l<T>
  implements q<T>
{
  public static <T> l<T> amb(Iterable<? extends q<? extends T>> paramIterable)
  {
    b.a.e.b.b.a(paramIterable, "sources is null");
    return b.a.h.a.a(new b.a.e.e.d.h(null, paramIterable));
  }
  
  public static <T> l<T> ambArray(q<? extends T>... paramVarArgs)
  {
    b.a.e.b.b.a(paramVarArgs, "sources is null");
    int i = paramVarArgs.length;
    if (i == 0) {
      return empty();
    }
    if (i == 1) {
      return wrap(paramVarArgs[0]);
    }
    return b.a.h.a.a(new b.a.e.e.d.h(paramVarArgs, null));
  }
  
  public static int bufferSize()
  {
    return f.a();
  }
  
  public static <T, R> l<R> combineLatest(b.a.d.h<? super Object[], ? extends R> paramh, int paramInt, q<? extends T>... paramVarArgs)
  {
    return combineLatest(paramVarArgs, paramh, paramInt);
  }
  
  public static <T1, T2, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, b.a.d.c<? super T1, ? super T2, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    return combineLatest(b.a.e.b.a.a(paramc), bufferSize(), new q[] { paramq, paramq1 });
  }
  
  public static <T1, T2, T3, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, b.a.d.i<? super T1, ? super T2, ? super T3, ? extends R> parami)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    return combineLatest(b.a.e.b.a.a(parami), bufferSize(), new q[] { paramq, paramq1, paramq2 });
  }
  
  public static <T1, T2, T3, T4, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, b.a.d.j<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramj)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    return combineLatest(b.a.e.b.a.a(paramj), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3 });
  }
  
  public static <T1, T2, T3, T4, T5, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, b.a.d.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramk)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    return combineLatest(b.a.e.b.a.a(paramk), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, b.a.d.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paraml)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    return combineLatest(b.a.e.b.a.a(paraml), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, b.a.d.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramm)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    return combineLatest(b.a.e.b.a.a(paramm), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, q<? extends T8> paramq7, b.a.d.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramn)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    b.a.e.b.b.a(paramq7, "source8 is null");
    return combineLatest(b.a.e.b.a.a(paramn), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6, paramq7 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> combineLatest(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, q<? extends T8> paramq7, q<? extends T9> paramq8, b.a.d.o<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramo)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    b.a.e.b.b.a(paramq7, "source8 is null");
    b.a.e.b.b.a(paramq8, "source9 is null");
    return combineLatest(b.a.e.b.a.a(paramo), bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6, paramq7, paramq8 });
  }
  
  public static <T, R> l<R> combineLatest(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    return combineLatest(paramIterable, paramh, bufferSize());
  }
  
  public static <T, R> l<R> combineLatest(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramIterable, "sources is null");
    b.a.e.b.b.a(paramh, "combiner is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new b.a.e.e.d.t(null, paramIterable, paramh, paramInt << 1, false));
  }
  
  public static <T, R> l<R> combineLatest(q<? extends T>[] paramArrayOfq, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    return combineLatest(paramArrayOfq, paramh, bufferSize());
  }
  
  public static <T, R> l<R> combineLatest(q<? extends T>[] paramArrayOfq, b.a.d.h<? super Object[], ? extends R> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramArrayOfq, "sources is null");
    if (paramArrayOfq.length == 0) {
      return empty();
    }
    b.a.e.b.b.a(paramh, "combiner is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new b.a.e.e.d.t(paramArrayOfq, null, paramh, paramInt << 1, false));
  }
  
  public static <T, R> l<R> combineLatestDelayError(b.a.d.h<? super Object[], ? extends R> paramh, int paramInt, q<? extends T>... paramVarArgs)
  {
    return combineLatestDelayError(paramVarArgs, paramh, paramInt);
  }
  
  public static <T, R> l<R> combineLatestDelayError(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    return combineLatestDelayError(paramIterable, paramh, bufferSize());
  }
  
  public static <T, R> l<R> combineLatestDelayError(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramIterable, "sources is null");
    b.a.e.b.b.a(paramh, "combiner is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new b.a.e.e.d.t(null, paramIterable, paramh, paramInt << 1, true));
  }
  
  public static <T, R> l<R> combineLatestDelayError(q<? extends T>[] paramArrayOfq, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    return combineLatestDelayError(paramArrayOfq, paramh, bufferSize());
  }
  
  public static <T, R> l<R> combineLatestDelayError(q<? extends T>[] paramArrayOfq, b.a.d.h<? super Object[], ? extends R> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    b.a.e.b.b.a(paramh, "combiner is null");
    if (paramArrayOfq.length == 0) {
      return empty();
    }
    return b.a.h.a.a(new b.a.e.e.d.t(paramArrayOfq, null, paramh, paramInt << 1, true));
  }
  
  public static <T> l<T> concat(q<? extends q<? extends T>> paramq)
  {
    return concat(paramq, bufferSize());
  }
  
  public static <T> l<T> concat(q<? extends q<? extends T>> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    return b.a.h.a.a(new b.a.e.e.d.u(paramq, b.a.e.b.a.a(), paramInt, b.a.e.j.i.IMMEDIATE));
  }
  
  public static <T> l<T> concat(q<? extends T> paramq1, q<? extends T> paramq2)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    return concatArray(new q[] { paramq1, paramq2 });
  }
  
  public static <T> l<T> concat(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    return concatArray(new q[] { paramq1, paramq2, paramq3 });
  }
  
  public static <T> l<T> concat(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3, q<? extends T> paramq4)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    b.a.e.b.b.a(paramq4, "source4 is null");
    return concatArray(new q[] { paramq1, paramq2, paramq3, paramq4 });
  }
  
  public static <T> l<T> concat(Iterable<? extends q<? extends T>> paramIterable)
  {
    b.a.e.b.b.a(paramIterable, "sources is null");
    return fromIterable(paramIterable).concatMapDelayError(b.a.e.b.a.a(), bufferSize(), false);
  }
  
  public static <T> l<T> concatArray(q<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return b.a.h.a.a(new b.a.e.e.d.u(fromArray(paramVarArgs), b.a.e.b.a.a(), bufferSize(), b.a.e.j.i.BOUNDARY));
  }
  
  public static <T> l<T> concatArrayDelayError(q<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return concatDelayError(fromArray(paramVarArgs));
  }
  
  public static <T> l<T> concatArrayEager(int paramInt1, int paramInt2, q<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).concatMapEagerDelayError(b.a.e.b.a.a(), paramInt1, paramInt2, false);
  }
  
  public static <T> l<T> concatArrayEager(q<? extends T>... paramVarArgs)
  {
    return concatArrayEager(bufferSize(), bufferSize(), paramVarArgs);
  }
  
  public static <T> l<T> concatDelayError(q<? extends q<? extends T>> paramq)
  {
    return concatDelayError(paramq, bufferSize(), true);
  }
  
  public static <T> l<T> concatDelayError(q<? extends q<? extends T>> paramq, int paramInt, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "prefetch is null");
    b.a.d.h localh = b.a.e.b.a.a();
    b.a.e.j.i locali;
    if (paramBoolean) {
      locali = b.a.e.j.i.END;
    } else {
      locali = b.a.e.j.i.BOUNDARY;
    }
    return b.a.h.a.a(new b.a.e.e.d.u(paramq, localh, paramInt, locali));
  }
  
  public static <T> l<T> concatDelayError(Iterable<? extends q<? extends T>> paramIterable)
  {
    b.a.e.b.b.a(paramIterable, "sources is null");
    return concatDelayError(fromIterable(paramIterable));
  }
  
  public static <T> l<T> concatEager(q<? extends q<? extends T>> paramq)
  {
    return concatEager(paramq, bufferSize(), bufferSize());
  }
  
  public static <T> l<T> concatEager(q<? extends q<? extends T>> paramq, int paramInt1, int paramInt2)
  {
    return wrap(paramq).concatMapEager(b.a.e.b.a.a(), paramInt1, paramInt2);
  }
  
  public static <T> l<T> concatEager(Iterable<? extends q<? extends T>> paramIterable)
  {
    return concatEager(paramIterable, bufferSize(), bufferSize());
  }
  
  public static <T> l<T> concatEager(Iterable<? extends q<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).concatMapEagerDelayError(b.a.e.b.a.a(), paramInt1, paramInt2, false);
  }
  
  public static <T> l<T> create(o<T> paramo)
  {
    b.a.e.b.b.a(paramo, "source is null");
    return b.a.h.a.a(new ab(paramo));
  }
  
  public static <T> l<T> defer(Callable<? extends q<? extends T>> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "supplier is null");
    return b.a.h.a.a(new ae(paramCallable));
  }
  
  private l<T> doOnEach(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1, b.a.d.a parama1, b.a.d.a parama2)
  {
    b.a.e.b.b.a(paramg, "onNext is null");
    b.a.e.b.b.a(paramg1, "onError is null");
    b.a.e.b.b.a(parama1, "onComplete is null");
    b.a.e.b.b.a(parama2, "onAfterTerminate is null");
    return b.a.h.a.a(new an(this, paramg, paramg1, parama1, parama2));
  }
  
  public static <T> l<T> empty()
  {
    return b.a.h.a.a(as.a);
  }
  
  public static <T> l<T> error(Throwable paramThrowable)
  {
    b.a.e.b.b.a(paramThrowable, "e is null");
    return error(b.a.e.b.a.a(paramThrowable));
  }
  
  public static <T> l<T> error(Callable<? extends Throwable> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "errorSupplier is null");
    return b.a.h.a.a(new at(paramCallable));
  }
  
  public static <T> l<T> fromArray(T... paramVarArgs)
  {
    b.a.e.b.b.a(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return empty();
    }
    if (paramVarArgs.length == 1) {
      return just(paramVarArgs[0]);
    }
    return b.a.h.a.a(new bb(paramVarArgs));
  }
  
  public static <T> l<T> fromCallable(Callable<? extends T> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "supplier is null");
    return b.a.h.a.a(new bc(paramCallable));
  }
  
  public static <T> l<T> fromFuture(Future<? extends T> paramFuture)
  {
    b.a.e.b.b.a(paramFuture, "future is null");
    return b.a.h.a.a(new bd(paramFuture, 0L, null));
  }
  
  public static <T> l<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    b.a.e.b.b.a(paramFuture, "future is null");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    return b.a.h.a.a(new bd(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static <T> l<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    return fromFuture(paramFuture, paramLong, paramTimeUnit).subscribeOn(paramt);
  }
  
  public static <T> l<T> fromFuture(Future<? extends T> paramFuture, t paramt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    return fromFuture(paramFuture).subscribeOn(paramt);
  }
  
  public static <T> l<T> fromIterable(Iterable<? extends T> paramIterable)
  {
    b.a.e.b.b.a(paramIterable, "source is null");
    return b.a.h.a.a(new be(paramIterable));
  }
  
  public static <T> l<T> fromPublisher(org.a.a<? extends T> parama)
  {
    b.a.e.b.b.a(parama, "publisher is null");
    return b.a.h.a.a(new bf(parama));
  }
  
  public static <T> l<T> generate(b.a.d.g<e<T>> paramg)
  {
    b.a.e.b.b.a(paramg, "generator  is null");
    return generate(b.a.e.b.a.e(), bn.a(paramg), b.a.e.b.a.b());
  }
  
  public static <T, S> l<T> generate(Callable<S> paramCallable, b.a.d.b<S, e<T>> paramb)
  {
    b.a.e.b.b.a(paramb, "generator  is null");
    return generate(paramCallable, bn.a(paramb), b.a.e.b.a.b());
  }
  
  public static <T, S> l<T> generate(Callable<S> paramCallable, b.a.d.b<S, e<T>> paramb, b.a.d.g<? super S> paramg)
  {
    b.a.e.b.b.a(paramb, "generator  is null");
    return generate(paramCallable, bn.a(paramb), paramg);
  }
  
  public static <T, S> l<T> generate(Callable<S> paramCallable, b.a.d.c<S, e<T>, S> paramc)
  {
    return generate(paramCallable, paramc, b.a.e.b.a.b());
  }
  
  public static <T, S> l<T> generate(Callable<S> paramCallable, b.a.d.c<S, e<T>, S> paramc, b.a.d.g<? super S> paramg)
  {
    b.a.e.b.b.a(paramCallable, "initialState is null");
    b.a.e.b.b.a(paramc, "generator  is null");
    b.a.e.b.b.a(paramg, "disposeState is null");
    return b.a.h.a.a(new bh(paramCallable, paramc, paramg));
  }
  
  public static l<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return interval(paramLong1, paramLong2, paramTimeUnit, b.a.i.a.a());
  }
  
  public static l<Long> interval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new bo(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramt));
  }
  
  public static l<Long> interval(long paramLong, TimeUnit paramTimeUnit)
  {
    return interval(paramLong, paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public static l<Long> interval(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return interval(paramLong, paramLong, paramTimeUnit, paramt);
  }
  
  public static l<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return intervalRange(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, b.a.i.a.a());
  }
  
  public static l<Long> intervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, t paramt)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return empty().delay(paramLong3, paramTimeUnit, paramt);
      }
      paramLong2 = paramLong2 - 1L + paramLong1;
      if ((paramLong1 > 0L) && (paramLong2 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      b.a.e.b.b.a(paramTimeUnit, "unit is null");
      b.a.e.b.b.a(paramt, "scheduler is null");
      return b.a.h.a.a(new bp(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramt));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("count >= 0 required but it was ");
    paramTimeUnit.append(paramLong2);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public static <T> l<T> just(T paramT)
  {
    b.a.e.b.b.a(paramT, "The item is null");
    return b.a.h.a.a(new br(paramT));
  }
  
  public static <T> l<T> just(T paramT1, T paramT2)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    return fromArray(new Object[] { paramT1, paramT2 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    b.a.e.b.b.a(paramT6, "The sixth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    b.a.e.b.b.a(paramT6, "The sixth item is null");
    b.a.e.b.b.a(paramT7, "The seventh item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    b.a.e.b.b.a(paramT6, "The sixth item is null");
    b.a.e.b.b.a(paramT7, "The seventh item is null");
    b.a.e.b.b.a(paramT8, "The eighth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    b.a.e.b.b.a(paramT6, "The sixth item is null");
    b.a.e.b.b.a(paramT7, "The seventh item is null");
    b.a.e.b.b.a(paramT8, "The eighth item is null");
    b.a.e.b.b.a(paramT9, "The ninth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9 });
  }
  
  public static <T> l<T> just(T paramT1, T paramT2, T paramT3, T paramT4, T paramT5, T paramT6, T paramT7, T paramT8, T paramT9, T paramT10)
  {
    b.a.e.b.b.a(paramT1, "The first item is null");
    b.a.e.b.b.a(paramT2, "The second item is null");
    b.a.e.b.b.a(paramT3, "The third item is null");
    b.a.e.b.b.a(paramT4, "The fourth item is null");
    b.a.e.b.b.a(paramT5, "The fifth item is null");
    b.a.e.b.b.a(paramT6, "The sixth item is null");
    b.a.e.b.b.a(paramT7, "The seventh item is null");
    b.a.e.b.b.a(paramT8, "The eighth item is null");
    b.a.e.b.b.a(paramT9, "The ninth item is null");
    b.a.e.b.b.a(paramT10, "The tenth item is null");
    return fromArray(new Object[] { paramT1, paramT2, paramT3, paramT4, paramT5, paramT6, paramT7, paramT8, paramT9, paramT10 });
  }
  
  public static <T> l<T> merge(q<? extends q<? extends T>> paramq)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    return b.a.h.a.a(new av(paramq, b.a.e.b.a.a(), false, Integer.MAX_VALUE, bufferSize()));
  }
  
  public static <T> l<T> merge(q<? extends q<? extends T>> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "maxConcurrency");
    return b.a.h.a.a(new av(paramq, b.a.e.b.a.a(), false, paramInt, bufferSize()));
  }
  
  public static <T> l<T> merge(q<? extends T> paramq1, q<? extends T> paramq2)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    return fromArray(new q[] { paramq1, paramq2 }).flatMap(b.a.e.b.a.a(), false, 2);
  }
  
  public static <T> l<T> merge(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    return fromArray(new q[] { paramq1, paramq2, paramq3 }).flatMap(b.a.e.b.a.a(), false, 3);
  }
  
  public static <T> l<T> merge(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3, q<? extends T> paramq4)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    b.a.e.b.b.a(paramq4, "source4 is null");
    return fromArray(new q[] { paramq1, paramq2, paramq3, paramq4 }).flatMap(b.a.e.b.a.a(), false, 4);
  }
  
  public static <T> l<T> merge(Iterable<? extends q<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a());
  }
  
  public static <T> l<T> merge(Iterable<? extends q<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a(), paramInt);
  }
  
  public static <T> l<T> merge(Iterable<? extends q<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a(), false, paramInt1, paramInt2);
  }
  
  public static <T> l<T> mergeArray(int paramInt1, int paramInt2, q<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(b.a.e.b.a.a(), false, paramInt1, paramInt2);
  }
  
  public static <T> l<T> mergeArray(q<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(b.a.e.b.a.a(), paramVarArgs.length);
  }
  
  public static <T> l<T> mergeArrayDelayError(int paramInt1, int paramInt2, q<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(b.a.e.b.a.a(), true, paramInt1, paramInt2);
  }
  
  public static <T> l<T> mergeArrayDelayError(q<? extends T>... paramVarArgs)
  {
    return fromArray(paramVarArgs).flatMap(b.a.e.b.a.a(), true, paramVarArgs.length);
  }
  
  public static <T> l<T> mergeDelayError(q<? extends q<? extends T>> paramq)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    return b.a.h.a.a(new av(paramq, b.a.e.b.a.a(), true, Integer.MAX_VALUE, bufferSize()));
  }
  
  public static <T> l<T> mergeDelayError(q<? extends q<? extends T>> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "maxConcurrency");
    return b.a.h.a.a(new av(paramq, b.a.e.b.a.a(), true, paramInt, bufferSize()));
  }
  
  public static <T> l<T> mergeDelayError(q<? extends T> paramq1, q<? extends T> paramq2)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    return fromArray(new q[] { paramq1, paramq2 }).flatMap(b.a.e.b.a.a(), true, 2);
  }
  
  public static <T> l<T> mergeDelayError(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    return fromArray(new q[] { paramq1, paramq2, paramq3 }).flatMap(b.a.e.b.a.a(), true, 3);
  }
  
  public static <T> l<T> mergeDelayError(q<? extends T> paramq1, q<? extends T> paramq2, q<? extends T> paramq3, q<? extends T> paramq4)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramq3, "source3 is null");
    b.a.e.b.b.a(paramq4, "source4 is null");
    return fromArray(new q[] { paramq1, paramq2, paramq3, paramq4 }).flatMap(b.a.e.b.a.a(), true, 4);
  }
  
  public static <T> l<T> mergeDelayError(Iterable<? extends q<? extends T>> paramIterable)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a(), true);
  }
  
  public static <T> l<T> mergeDelayError(Iterable<? extends q<? extends T>> paramIterable, int paramInt)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a(), true, paramInt);
  }
  
  public static <T> l<T> mergeDelayError(Iterable<? extends q<? extends T>> paramIterable, int paramInt1, int paramInt2)
  {
    return fromIterable(paramIterable).flatMap(b.a.e.b.a.a(), true, paramInt1, paramInt2);
  }
  
  public static <T> l<T> never()
  {
    return b.a.h.a.a(cb.a);
  }
  
  public static l<Integer> range(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        return empty();
      }
      if (paramInt2 == 1) {
        return just(Integer.valueOf(paramInt1));
      }
      if (paramInt1 + (paramInt2 - 1) <= 2147483647L) {
        return b.a.h.a.a(new ch(paramInt1, paramInt2));
      }
      throw new IllegalArgumentException("Integer overflow");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static l<Long> rangeLong(long paramLong1, long paramLong2)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return empty();
      }
      if (paramLong2 == 1L) {
        return just(Long.valueOf(paramLong1));
      }
      if ((paramLong1 > 0L) && (paramLong2 - 1L + paramLong1 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      return b.a.h.a.a(new ci(paramLong1, paramLong2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramLong2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <T> u<Boolean> sequenceEqual(q<? extends T> paramq1, q<? extends T> paramq2)
  {
    return sequenceEqual(paramq1, paramq2, b.a.e.b.b.a(), bufferSize());
  }
  
  public static <T> u<Boolean> sequenceEqual(q<? extends T> paramq1, q<? extends T> paramq2, int paramInt)
  {
    return sequenceEqual(paramq1, paramq2, b.a.e.b.b.a(), paramInt);
  }
  
  public static <T> u<Boolean> sequenceEqual(q<? extends T> paramq1, q<? extends T> paramq2, b.a.d.d<? super T, ? super T> paramd)
  {
    return sequenceEqual(paramq1, paramq2, paramd, bufferSize());
  }
  
  public static <T> u<Boolean> sequenceEqual(q<? extends T> paramq1, q<? extends T> paramq2, b.a.d.d<? super T, ? super T> paramd, int paramInt)
  {
    b.a.e.b.b.a(paramq1, "source1 is null");
    b.a.e.b.b.a(paramq2, "source2 is null");
    b.a.e.b.b.a(paramd, "isEqual is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new da(paramq1, paramq2, paramd, paramInt));
  }
  
  public static <T> l<T> switchOnNext(q<? extends q<? extends T>> paramq)
  {
    return switchOnNext(paramq, bufferSize());
  }
  
  public static <T> l<T> switchOnNext(q<? extends q<? extends T>> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new dl(paramq, b.a.e.b.a.a(), paramInt, false));
  }
  
  public static <T> l<T> switchOnNextDelayError(q<? extends q<? extends T>> paramq)
  {
    return switchOnNextDelayError(paramq, bufferSize());
  }
  
  public static <T> l<T> switchOnNextDelayError(q<? extends q<? extends T>> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "sources is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    return b.a.h.a.a(new dl(paramq, b.a.e.b.a.a(), paramInt, true));
  }
  
  private l<T> timeout0(long paramLong, TimeUnit paramTimeUnit, q<? extends T> paramq, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "timeUnit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new dx(this, paramLong, paramTimeUnit, paramt, paramq));
  }
  
  private <U, V> l<T> timeout0(q<U> paramq, b.a.d.h<? super T, ? extends q<V>> paramh, q<? extends T> paramq1)
  {
    b.a.e.b.b.a(paramh, "itemTimeoutIndicator is null");
    return b.a.h.a.a(new dw(this, paramq, paramh, paramq1));
  }
  
  public static l<Long> timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public static l<Long> timer(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new dy(Math.max(paramLong, 0L), paramTimeUnit, paramt));
  }
  
  public static <T> l<T> unsafeCreate(q<T> paramq)
  {
    b.a.e.b.b.a(paramq, "source is null");
    b.a.e.b.b.a(paramq, "onSubscribe is null");
    if (!(paramq instanceof l)) {
      return b.a.h.a.a(new bg(paramq));
    }
    throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
  }
  
  public static <T, D> l<T> using(Callable<? extends D> paramCallable, b.a.d.h<? super D, ? extends q<? extends T>> paramh, b.a.d.g<? super D> paramg)
  {
    return using(paramCallable, paramh, paramg, true);
  }
  
  public static <T, D> l<T> using(Callable<? extends D> paramCallable, b.a.d.h<? super D, ? extends q<? extends T>> paramh, b.a.d.g<? super D> paramg, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramCallable, "resourceSupplier is null");
    b.a.e.b.b.a(paramh, "sourceSupplier is null");
    b.a.e.b.b.a(paramg, "disposer is null");
    return b.a.h.a.a(new ec(paramCallable, paramh, paramg, paramBoolean));
  }
  
  public static <T> l<T> wrap(q<T> paramq)
  {
    b.a.e.b.b.a(paramq, "source is null");
    if ((paramq instanceof l)) {
      return b.a.h.a.a((l)paramq);
    }
    return b.a.h.a.a(new bg(paramq));
  }
  
  public static <T, R> l<R> zip(q<? extends q<? extends T>> paramq, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    b.a.e.b.b.a(paramh, "zipper is null");
    b.a.e.b.b.a(paramq, "sources is null");
    return b.a.h.a.a(new dz(paramq, 16).flatMap(bn.c(paramh)));
  }
  
  public static <T1, T2, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, b.a.d.c<? super T1, ? super T2, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    return zipArray(b.a.e.b.a.a(paramc), false, bufferSize(), new q[] { paramq, paramq1 });
  }
  
  public static <T1, T2, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, b.a.d.c<? super T1, ? super T2, ? extends R> paramc, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    return zipArray(b.a.e.b.a.a(paramc), paramBoolean, bufferSize(), new q[] { paramq, paramq1 });
  }
  
  public static <T1, T2, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, b.a.d.c<? super T1, ? super T2, ? extends R> paramc, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    return zipArray(b.a.e.b.a.a(paramc), paramBoolean, paramInt, new q[] { paramq, paramq1 });
  }
  
  public static <T1, T2, T3, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, b.a.d.i<? super T1, ? super T2, ? super T3, ? extends R> parami)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    return zipArray(b.a.e.b.a.a(parami), false, bufferSize(), new q[] { paramq, paramq1, paramq2 });
  }
  
  public static <T1, T2, T3, T4, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, b.a.d.j<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramj)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    return zipArray(b.a.e.b.a.a(paramj), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3 });
  }
  
  public static <T1, T2, T3, T4, T5, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, b.a.d.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramk)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    return zipArray(b.a.e.b.a.a(paramk), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, b.a.d.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paraml)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    return zipArray(b.a.e.b.a.a(paraml), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, b.a.d.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramm)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    return zipArray(b.a.e.b.a.a(paramm), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, q<? extends T8> paramq7, b.a.d.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramn)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    b.a.e.b.b.a(paramq7, "source8 is null");
    return zipArray(b.a.e.b.a.a(paramn), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6, paramq7 });
  }
  
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> l<R> zip(q<? extends T1> paramq, q<? extends T2> paramq1, q<? extends T3> paramq2, q<? extends T4> paramq3, q<? extends T5> paramq4, q<? extends T6> paramq5, q<? extends T7> paramq6, q<? extends T8> paramq7, q<? extends T9> paramq8, b.a.d.o<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramo)
  {
    b.a.e.b.b.a(paramq, "source1 is null");
    b.a.e.b.b.a(paramq1, "source2 is null");
    b.a.e.b.b.a(paramq2, "source3 is null");
    b.a.e.b.b.a(paramq3, "source4 is null");
    b.a.e.b.b.a(paramq4, "source5 is null");
    b.a.e.b.b.a(paramq5, "source6 is null");
    b.a.e.b.b.a(paramq6, "source7 is null");
    b.a.e.b.b.a(paramq7, "source8 is null");
    b.a.e.b.b.a(paramq8, "source9 is null");
    return zipArray(b.a.e.b.a.a(paramo), false, bufferSize(), new q[] { paramq, paramq1, paramq2, paramq3, paramq4, paramq5, paramq6, paramq7, paramq8 });
  }
  
  public static <T, R> l<R> zip(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh)
  {
    b.a.e.b.b.a(paramh, "zipper is null");
    b.a.e.b.b.a(paramIterable, "sources is null");
    return b.a.h.a.a(new ek(null, paramIterable, paramh, bufferSize(), false));
  }
  
  public static <T, R> l<R> zipArray(b.a.d.h<? super Object[], ? extends R> paramh, boolean paramBoolean, int paramInt, q<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return empty();
    }
    b.a.e.b.b.a(paramh, "zipper is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new ek(paramVarArgs, null, paramh, paramInt, paramBoolean));
  }
  
  public static <T, R> l<R> zipIterable(Iterable<? extends q<? extends T>> paramIterable, b.a.d.h<? super Object[], ? extends R> paramh, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramh, "zipper is null");
    b.a.e.b.b.a(paramIterable, "sources is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new ek(null, paramIterable, paramh, paramInt, paramBoolean));
  }
  
  public final u<Boolean> all(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new b.a.e.e.d.g(this, paramq));
  }
  
  public final l<T> ambWith(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return ambArray(new q[] { this, paramq });
  }
  
  public final u<Boolean> any(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new b.a.e.e.d.j(this, paramq));
  }
  
  public final <R> R as(m<T, ? extends R> paramm)
  {
    return (R)((m)b.a.e.b.b.a(paramm, "converter is null")).a(this);
  }
  
  public final T blockingFirst()
  {
    Object localObject = new b.a.e.d.e();
    subscribe((s)localObject);
    localObject = ((b.a.e.d.e)localObject).a();
    if (localObject != null) {
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final T blockingFirst(T paramT)
  {
    Object localObject = new b.a.e.d.e();
    subscribe((s)localObject);
    localObject = ((b.a.e.d.e)localObject).a();
    if (localObject != null) {
      paramT = (T)localObject;
    }
    return paramT;
  }
  
  public final void blockingForEach(b.a.d.g<? super T> paramg)
  {
    Iterator localIterator = blockingIterable().iterator();
    while (localIterator.hasNext()) {
      try
      {
        paramg.accept(localIterator.next());
      }
      catch (Throwable paramg)
      {
        b.a.c.b.b(paramg);
        ((b.a.b.b)localIterator).dispose();
        throw b.a.e.j.j.a(paramg);
      }
    }
  }
  
  public final Iterable<T> blockingIterable()
  {
    return blockingIterable(bufferSize());
  }
  
  public final Iterable<T> blockingIterable(int paramInt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    return new b.a.e.e.d.b(this, paramInt);
  }
  
  public final T blockingLast()
  {
    Object localObject = new b.a.e.d.f();
    subscribe((s)localObject);
    localObject = ((b.a.e.d.f)localObject).a();
    if (localObject != null) {
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final T blockingLast(T paramT)
  {
    Object localObject = new b.a.e.d.f();
    subscribe((s)localObject);
    localObject = ((b.a.e.d.f)localObject).a();
    if (localObject != null) {
      paramT = (T)localObject;
    }
    return paramT;
  }
  
  public final Iterable<T> blockingLatest()
  {
    return new b.a.e.e.d.c(this);
  }
  
  public final Iterable<T> blockingMostRecent(T paramT)
  {
    return new b.a.e.e.d.d(this, paramT);
  }
  
  public final Iterable<T> blockingNext()
  {
    return new b.a.e.e.d.e(this);
  }
  
  public final T blockingSingle()
  {
    Object localObject = singleElement().a();
    if (localObject != null) {
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final T blockingSingle(T paramT)
  {
    return (T)single(paramT).a();
  }
  
  public final void blockingSubscribe()
  {
    b.a.e.e.d.k.a(this);
  }
  
  public final void blockingSubscribe(b.a.d.g<? super T> paramg)
  {
    b.a.e.e.d.k.a(this, paramg, b.a.e.b.a.f, b.a.e.b.a.c);
  }
  
  public final void blockingSubscribe(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1)
  {
    b.a.e.e.d.k.a(this, paramg, paramg1, b.a.e.b.a.c);
  }
  
  public final void blockingSubscribe(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1, b.a.d.a parama)
  {
    b.a.e.e.d.k.a(this, paramg, paramg1, parama);
  }
  
  public final void blockingSubscribe(s<? super T> params)
  {
    b.a.e.e.d.k.a(this, params);
  }
  
  public final l<List<T>> buffer(int paramInt)
  {
    return buffer(paramInt, paramInt);
  }
  
  public final l<List<T>> buffer(int paramInt1, int paramInt2)
  {
    return buffer(paramInt1, paramInt2, b.a.e.j.b.asCallable());
  }
  
  public final <U extends Collection<? super T>> l<U> buffer(int paramInt1, int paramInt2, Callable<U> paramCallable)
  {
    b.a.e.b.b.a(paramInt1, "count");
    b.a.e.b.b.a(paramInt2, "skip");
    b.a.e.b.b.a(paramCallable, "bufferSupplier is null");
    return b.a.h.a.a(new b.a.e.e.d.l(this, paramInt1, paramInt2, paramCallable));
  }
  
  public final <U extends Collection<? super T>> l<U> buffer(int paramInt, Callable<U> paramCallable)
  {
    return buffer(paramInt, paramInt, paramCallable);
  }
  
  public final l<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return buffer(paramLong1, paramLong2, paramTimeUnit, b.a.i.a.a(), b.a.e.j.b.asCallable());
  }
  
  public final l<List<T>> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt)
  {
    return buffer(paramLong1, paramLong2, paramTimeUnit, paramt, b.a.e.j.b.asCallable());
  }
  
  public final <U extends Collection<? super T>> l<U> buffer(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, Callable<U> paramCallable)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramCallable, "bufferSupplier is null");
    return b.a.h.a.a(new b.a.e.e.d.p(this, paramLong1, paramLong2, paramTimeUnit, paramt, paramCallable, Integer.MAX_VALUE, false));
  }
  
  public final l<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit)
  {
    return buffer(paramLong, paramTimeUnit, b.a.i.a.a(), Integer.MAX_VALUE);
  }
  
  public final l<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return buffer(paramLong, paramTimeUnit, b.a.i.a.a(), paramInt);
  }
  
  public final l<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return buffer(paramLong, paramTimeUnit, paramt, Integer.MAX_VALUE, b.a.e.j.b.asCallable(), false);
  }
  
  public final l<List<T>> buffer(long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt)
  {
    return buffer(paramLong, paramTimeUnit, paramt, paramInt, b.a.e.j.b.asCallable(), false);
  }
  
  public final <U extends Collection<? super T>> l<U> buffer(long paramLong, TimeUnit paramTimeUnit, t paramt, int paramInt, Callable<U> paramCallable, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramCallable, "bufferSupplier is null");
    b.a.e.b.b.a(paramInt, "count");
    return b.a.h.a.a(new b.a.e.e.d.p(this, paramLong, paramLong, paramTimeUnit, paramt, paramCallable, paramInt, paramBoolean));
  }
  
  public final <B> l<List<T>> buffer(q<B> paramq)
  {
    return buffer(paramq, b.a.e.j.b.asCallable());
  }
  
  public final <B> l<List<T>> buffer(q<B> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramInt, "initialCapacity");
    return buffer(paramq, b.a.e.b.a.a(paramInt));
  }
  
  public final <TOpening, TClosing> l<List<T>> buffer(q<? extends TOpening> paramq, b.a.d.h<? super TOpening, ? extends q<? extends TClosing>> paramh)
  {
    return buffer(paramq, paramh, b.a.e.j.b.asCallable());
  }
  
  public final <TOpening, TClosing, U extends Collection<? super T>> l<U> buffer(q<? extends TOpening> paramq, b.a.d.h<? super TOpening, ? extends q<? extends TClosing>> paramh, Callable<U> paramCallable)
  {
    b.a.e.b.b.a(paramq, "openingIndicator is null");
    b.a.e.b.b.a(paramh, "closingIndicator is null");
    b.a.e.b.b.a(paramCallable, "bufferSupplier is null");
    return b.a.h.a.a(new b.a.e.e.d.m(this, paramq, paramh, paramCallable));
  }
  
  public final <B, U extends Collection<? super T>> l<U> buffer(q<B> paramq, Callable<U> paramCallable)
  {
    b.a.e.b.b.a(paramq, "boundary is null");
    b.a.e.b.b.a(paramCallable, "bufferSupplier is null");
    return b.a.h.a.a(new b.a.e.e.d.o(this, paramq, paramCallable));
  }
  
  public final <B> l<List<T>> buffer(Callable<? extends q<B>> paramCallable)
  {
    return buffer(paramCallable, b.a.e.j.b.asCallable());
  }
  
  public final <B, U extends Collection<? super T>> l<U> buffer(Callable<? extends q<B>> paramCallable, Callable<U> paramCallable1)
  {
    b.a.e.b.b.a(paramCallable, "boundarySupplier is null");
    b.a.e.b.b.a(paramCallable1, "bufferSupplier is null");
    return b.a.h.a.a(new b.a.e.e.d.n(this, paramCallable, paramCallable1));
  }
  
  public final l<T> cache()
  {
    return b.a.e.e.d.q.a(this);
  }
  
  public final l<T> cacheWithInitialCapacity(int paramInt)
  {
    return b.a.e.e.d.q.a(this, paramInt);
  }
  
  public final <U> l<U> cast(Class<U> paramClass)
  {
    b.a.e.b.b.a(paramClass, "clazz is null");
    return map(b.a.e.b.a.a(paramClass));
  }
  
  public final <U> u<U> collect(Callable<? extends U> paramCallable, b.a.d.b<? super U, ? super T> paramb)
  {
    b.a.e.b.b.a(paramCallable, "initialValueSupplier is null");
    b.a.e.b.b.a(paramb, "collector is null");
    return b.a.h.a.a(new b.a.e.e.d.s(this, paramCallable, paramb));
  }
  
  public final <U> u<U> collectInto(U paramU, b.a.d.b<? super U, ? super T> paramb)
  {
    b.a.e.b.b.a(paramU, "initialValue is null");
    return collect(b.a.e.b.a.a(paramU), paramb);
  }
  
  public final <R> l<R> compose(r<? super T, ? extends R> paramr)
  {
    return wrap(((r)b.a.e.b.b.a(paramr, "composer is null")).a(this));
  }
  
  public final <R> l<R> concatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return concatMap(paramh, 2);
  }
  
  public final <R> l<R> concatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    if ((this instanceof b.a.e.c.e))
    {
      Object localObject = ((b.a.e.c.e)this).call();
      if (localObject == null) {
        return empty();
      }
      return cw.a(localObject, paramh);
    }
    return b.a.h.a.a(new b.a.e.e.d.u(this, paramh, paramInt, b.a.e.j.i.IMMEDIATE));
  }
  
  public final b concatMapCompletable(b.a.d.h<? super T, ? extends d> paramh)
  {
    return concatMapCompletable(paramh, 2);
  }
  
  public final b concatMapCompletable(b.a.d.h<? super T, ? extends d> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "capacityHint");
    return b.a.h.a.a(new b.a.e.e.c.a(this, paramh, b.a.e.j.i.IMMEDIATE, paramInt));
  }
  
  public final b concatMapCompletableDelayError(b.a.d.h<? super T, ? extends d> paramh)
  {
    return concatMapCompletableDelayError(paramh, true, 2);
  }
  
  public final b concatMapCompletableDelayError(b.a.d.h<? super T, ? extends d> paramh, boolean paramBoolean)
  {
    return concatMapCompletableDelayError(paramh, paramBoolean, 2);
  }
  
  public final b concatMapCompletableDelayError(b.a.d.h<? super T, ? extends d> paramh, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    b.a.e.j.i locali;
    if (paramBoolean) {
      locali = b.a.e.j.i.END;
    } else {
      locali = b.a.e.j.i.BOUNDARY;
    }
    return b.a.h.a.a(new b.a.e.e.c.a(this, paramh, locali, paramInt));
  }
  
  public final <R> l<R> concatMapDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return concatMapDelayError(paramh, bufferSize(), true);
  }
  
  public final <R> l<R> concatMapDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    Object localObject;
    if ((this instanceof b.a.e.c.e))
    {
      localObject = ((b.a.e.c.e)this).call();
      if (localObject == null) {
        return empty();
      }
      return cw.a(localObject, paramh);
    }
    if (paramBoolean) {
      localObject = b.a.e.j.i.END;
    } else {
      localObject = b.a.e.j.i.BOUNDARY;
    }
    return b.a.h.a.a(new b.a.e.e.d.u(this, paramh, paramInt, (b.a.e.j.i)localObject));
  }
  
  public final <R> l<R> concatMapEager(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return concatMapEager(paramh, Integer.MAX_VALUE, bufferSize());
  }
  
  public final <R> l<R> concatMapEager(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt1, int paramInt2)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt1, "maxConcurrency");
    b.a.e.b.b.a(paramInt2, "prefetch");
    return b.a.h.a.a(new v(this, paramh, b.a.e.j.i.IMMEDIATE, paramInt1, paramInt2));
  }
  
  public final <R> l<R> concatMapEagerDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt1, "maxConcurrency");
    b.a.e.b.b.a(paramInt2, "prefetch");
    if (paramBoolean) {}
    for (b.a.e.j.i locali = b.a.e.j.i.END;; locali = b.a.e.j.i.BOUNDARY) {
      break;
    }
    return b.a.h.a.a(new v(this, paramh, locali, paramInt1, paramInt2));
  }
  
  public final <R> l<R> concatMapEagerDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh, boolean paramBoolean)
  {
    return concatMapEagerDelayError(paramh, Integer.MAX_VALUE, bufferSize(), paramBoolean);
  }
  
  public final <U> l<U> concatMapIterable(b.a.d.h<? super T, ? extends Iterable<? extends U>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new ba(this, paramh));
  }
  
  public final <U> l<U> concatMapIterable(b.a.d.h<? super T, ? extends Iterable<? extends U>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    return concatMap(bn.b(paramh), paramInt);
  }
  
  public final <R> l<R> concatMapMaybe(b.a.d.h<? super T, ? extends j<? extends R>> paramh)
  {
    return concatMapMaybe(paramh, 2);
  }
  
  public final <R> l<R> concatMapMaybe(b.a.d.h<? super T, ? extends j<? extends R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    return b.a.h.a.a(new b.a.e.e.c.b(this, paramh, b.a.e.j.i.IMMEDIATE, paramInt));
  }
  
  public final <R> l<R> concatMapMaybeDelayError(b.a.d.h<? super T, ? extends j<? extends R>> paramh)
  {
    return concatMapMaybeDelayError(paramh, true, 2);
  }
  
  public final <R> l<R> concatMapMaybeDelayError(b.a.d.h<? super T, ? extends j<? extends R>> paramh, boolean paramBoolean)
  {
    return concatMapMaybeDelayError(paramh, paramBoolean, 2);
  }
  
  public final <R> l<R> concatMapMaybeDelayError(b.a.d.h<? super T, ? extends j<? extends R>> paramh, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    b.a.e.j.i locali;
    if (paramBoolean) {
      locali = b.a.e.j.i.END;
    } else {
      locali = b.a.e.j.i.BOUNDARY;
    }
    return b.a.h.a.a(new b.a.e.e.c.b(this, paramh, locali, paramInt));
  }
  
  public final <R> l<R> concatMapSingle(b.a.d.h<? super T, ? extends w<? extends R>> paramh)
  {
    return concatMapSingle(paramh, 2);
  }
  
  public final <R> l<R> concatMapSingle(b.a.d.h<? super T, ? extends w<? extends R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    return b.a.h.a.a(new b.a.e.e.c.c(this, paramh, b.a.e.j.i.IMMEDIATE, paramInt));
  }
  
  public final <R> l<R> concatMapSingleDelayError(b.a.d.h<? super T, ? extends w<? extends R>> paramh)
  {
    return concatMapSingleDelayError(paramh, true, 2);
  }
  
  public final <R> l<R> concatMapSingleDelayError(b.a.d.h<? super T, ? extends w<? extends R>> paramh, boolean paramBoolean)
  {
    return concatMapSingleDelayError(paramh, paramBoolean, 2);
  }
  
  public final <R> l<R> concatMapSingleDelayError(b.a.d.h<? super T, ? extends w<? extends R>> paramh, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "prefetch");
    b.a.e.j.i locali;
    if (paramBoolean) {
      locali = b.a.e.j.i.END;
    } else {
      locali = b.a.e.j.i.BOUNDARY;
    }
    return b.a.h.a.a(new b.a.e.e.c.c(this, paramh, locali, paramInt));
  }
  
  public final l<T> concatWith(d paramd)
  {
    b.a.e.b.b.a(paramd, "other is null");
    return b.a.h.a.a(new b.a.e.e.d.w(this, paramd));
  }
  
  public final l<T> concatWith(j<? extends T> paramj)
  {
    b.a.e.b.b.a(paramj, "other is null");
    return b.a.h.a.a(new x(this, paramj));
  }
  
  public final l<T> concatWith(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return concat(this, paramq);
  }
  
  public final l<T> concatWith(w<? extends T> paramw)
  {
    b.a.e.b.b.a(paramw, "other is null");
    return b.a.h.a.a(new y(this, paramw));
  }
  
  public final u<Boolean> contains(Object paramObject)
  {
    b.a.e.b.b.a(paramObject, "element is null");
    return any(b.a.e.b.a.c(paramObject));
  }
  
  public final u<Long> count()
  {
    return b.a.h.a.a(new aa(this));
  }
  
  public final l<T> debounce(long paramLong, TimeUnit paramTimeUnit)
  {
    return debounce(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<T> debounce(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new ad(this, paramLong, paramTimeUnit, paramt));
  }
  
  public final <U> l<T> debounce(b.a.d.h<? super T, ? extends q<U>> paramh)
  {
    b.a.e.b.b.a(paramh, "debounceSelector is null");
    return b.a.h.a.a(new ac(this, paramh));
  }
  
  public final l<T> defaultIfEmpty(T paramT)
  {
    b.a.e.b.b.a(paramT, "defaultItem is null");
    return switchIfEmpty(just(paramT));
  }
  
  public final l<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return delay(paramLong, paramTimeUnit, b.a.i.a.a(), false);
  }
  
  public final l<T> delay(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return delay(paramLong, paramTimeUnit, paramt, false);
  }
  
  public final l<T> delay(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new af(this, paramLong, paramTimeUnit, paramt, paramBoolean));
  }
  
  public final l<T> delay(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return delay(paramLong, paramTimeUnit, b.a.i.a.a(), paramBoolean);
  }
  
  public final <U> l<T> delay(b.a.d.h<? super T, ? extends q<U>> paramh)
  {
    b.a.e.b.b.a(paramh, "itemDelay is null");
    return flatMap(bn.a(paramh));
  }
  
  public final <U, V> l<T> delay(q<U> paramq, b.a.d.h<? super T, ? extends q<V>> paramh)
  {
    return delaySubscription(paramq).delay(paramh);
  }
  
  public final l<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return delaySubscription(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return delaySubscription(timer(paramLong, paramTimeUnit, paramt));
  }
  
  public final <U> l<T> delaySubscription(q<U> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return b.a.h.a.a(new ag(this, paramq));
  }
  
  public final <T2> l<T2> dematerialize()
  {
    return b.a.h.a.a(new ah(this));
  }
  
  public final l<T> distinct()
  {
    return distinct(b.a.e.b.a.a(), b.a.e.b.a.g());
  }
  
  public final <K> l<T> distinct(b.a.d.h<? super T, K> paramh)
  {
    return distinct(paramh, b.a.e.b.a.g());
  }
  
  public final <K> l<T> distinct(b.a.d.h<? super T, K> paramh, Callable<? extends Collection<? super K>> paramCallable)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    b.a.e.b.b.a(paramCallable, "collectionSupplier is null");
    return b.a.h.a.a(new aj(this, paramh, paramCallable));
  }
  
  public final l<T> distinctUntilChanged()
  {
    return distinctUntilChanged(b.a.e.b.a.a());
  }
  
  public final l<T> distinctUntilChanged(b.a.d.d<? super T, ? super T> paramd)
  {
    b.a.e.b.b.a(paramd, "comparer is null");
    return b.a.h.a.a(new ak(this, b.a.e.b.a.a(), paramd));
  }
  
  public final <K> l<T> distinctUntilChanged(b.a.d.h<? super T, K> paramh)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    return b.a.h.a.a(new ak(this, paramh, b.a.e.b.b.a()));
  }
  
  public final l<T> doAfterNext(b.a.d.g<? super T> paramg)
  {
    b.a.e.b.b.a(paramg, "onAfterNext is null");
    return b.a.h.a.a(new al(this, paramg));
  }
  
  public final l<T> doAfterTerminate(b.a.d.a parama)
  {
    b.a.e.b.b.a(parama, "onFinally is null");
    return doOnEach(b.a.e.b.a.b(), b.a.e.b.a.b(), b.a.e.b.a.c, parama);
  }
  
  public final l<T> doFinally(b.a.d.a parama)
  {
    b.a.e.b.b.a(parama, "onFinally is null");
    return b.a.h.a.a(new am(this, parama));
  }
  
  public final l<T> doOnComplete(b.a.d.a parama)
  {
    return doOnEach(b.a.e.b.a.b(), b.a.e.b.a.b(), parama, b.a.e.b.a.c);
  }
  
  public final l<T> doOnDispose(b.a.d.a parama)
  {
    return doOnLifecycle(b.a.e.b.a.b(), parama);
  }
  
  public final l<T> doOnEach(b.a.d.g<? super k<T>> paramg)
  {
    b.a.e.b.b.a(paramg, "consumer is null");
    return doOnEach(b.a.e.b.a.a(paramg), b.a.e.b.a.b(paramg), b.a.e.b.a.c(paramg), b.a.e.b.a.c);
  }
  
  public final l<T> doOnEach(s<? super T> params)
  {
    b.a.e.b.b.a(params, "observer is null");
    return doOnEach(bn.a(params), bn.b(params), bn.c(params), b.a.e.b.a.c);
  }
  
  public final l<T> doOnError(b.a.d.g<? super Throwable> paramg)
  {
    return doOnEach(b.a.e.b.a.b(), paramg, b.a.e.b.a.c, b.a.e.b.a.c);
  }
  
  public final l<T> doOnLifecycle(b.a.d.g<? super b.a.b.b> paramg, b.a.d.a parama)
  {
    b.a.e.b.b.a(paramg, "onSubscribe is null");
    b.a.e.b.b.a(parama, "onDispose is null");
    return b.a.h.a.a(new ao(this, paramg, parama));
  }
  
  public final l<T> doOnNext(b.a.d.g<? super T> paramg)
  {
    return doOnEach(paramg, b.a.e.b.a.b(), b.a.e.b.a.c, b.a.e.b.a.c);
  }
  
  public final l<T> doOnSubscribe(b.a.d.g<? super b.a.b.b> paramg)
  {
    return doOnLifecycle(paramg, b.a.e.b.a.c);
  }
  
  public final l<T> doOnTerminate(b.a.d.a parama)
  {
    b.a.e.b.b.a(parama, "onTerminate is null");
    return doOnEach(b.a.e.b.a.b(), b.a.e.b.a.a(parama), parama, b.a.e.b.a.c);
  }
  
  public final h<T> elementAt(long paramLong)
  {
    if (paramLong >= 0L) {
      return b.a.h.a.a(new aq(this, paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final u<T> elementAt(long paramLong, T paramT)
  {
    if (paramLong >= 0L)
    {
      b.a.e.b.b.a(paramT, "defaultItem is null");
      return b.a.h.a.a(new ar(this, paramLong, paramT));
    }
    paramT = new StringBuilder();
    paramT.append("index >= 0 required but it was ");
    paramT.append(paramLong);
    throw new IndexOutOfBoundsException(paramT.toString());
  }
  
  public final u<T> elementAtOrError(long paramLong)
  {
    if (paramLong >= 0L) {
      return b.a.h.a.a(new ar(this, paramLong, null));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final l<T> filter(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new au(this, paramq));
  }
  
  public final u<T> first(T paramT)
  {
    return elementAt(0L, paramT);
  }
  
  public final h<T> firstElement()
  {
    return elementAt(0L);
  }
  
  public final u<T> firstOrError()
  {
    return elementAtOrError(0L);
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return flatMap(paramh, false);
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt)
  {
    return flatMap(paramh, false, paramInt, bufferSize());
  }
  
  public final <U, R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends R> paramc)
  {
    return flatMap(paramh, paramc, false, bufferSize(), bufferSize());
  }
  
  public final <U, R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends R> paramc, int paramInt)
  {
    return flatMap(paramh, paramc, false, paramInt, bufferSize());
  }
  
  public final <U, R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends R> paramc, boolean paramBoolean)
  {
    return flatMap(paramh, paramc, paramBoolean, bufferSize(), bufferSize());
  }
  
  public final <U, R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends R> paramc, boolean paramBoolean, int paramInt)
  {
    return flatMap(paramh, paramc, paramBoolean, paramInt, bufferSize());
  }
  
  public final <U, R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends R> paramc, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramc, "combiner is null");
    return flatMap(bn.a(paramh, paramc), paramBoolean, paramInt1, paramInt2);
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, b.a.d.h<? super Throwable, ? extends q<? extends R>> paramh1, Callable<? extends q<? extends R>> paramCallable)
  {
    b.a.e.b.b.a(paramh, "onNextMapper is null");
    b.a.e.b.b.a(paramh1, "onErrorMapper is null");
    b.a.e.b.b.a(paramCallable, "onCompleteSupplier is null");
    return merge(new bw(this, paramh, paramh1, paramCallable));
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, b.a.d.h<Throwable, ? extends q<? extends R>> paramh1, Callable<? extends q<? extends R>> paramCallable, int paramInt)
  {
    b.a.e.b.b.a(paramh, "onNextMapper is null");
    b.a.e.b.b.a(paramh1, "onErrorMapper is null");
    b.a.e.b.b.a(paramCallable, "onCompleteSupplier is null");
    return merge(new bw(this, paramh, paramh1, paramCallable), paramInt);
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, boolean paramBoolean)
  {
    return flatMap(paramh, paramBoolean, Integer.MAX_VALUE);
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, boolean paramBoolean, int paramInt)
  {
    return flatMap(paramh, paramBoolean, paramInt, bufferSize());
  }
  
  public final <R> l<R> flatMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt1, "maxConcurrency");
    b.a.e.b.b.a(paramInt2, "bufferSize");
    if ((this instanceof b.a.e.c.e))
    {
      Object localObject = ((b.a.e.c.e)this).call();
      if (localObject == null) {
        return empty();
      }
      return cw.a(localObject, paramh);
    }
    return b.a.h.a.a(new av(this, paramh, paramBoolean, paramInt1, paramInt2));
  }
  
  public final b flatMapCompletable(b.a.d.h<? super T, ? extends d> paramh)
  {
    return flatMapCompletable(paramh, false);
  }
  
  public final b flatMapCompletable(b.a.d.h<? super T, ? extends d> paramh, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new ax(this, paramh, paramBoolean));
  }
  
  public final <U> l<U> flatMapIterable(b.a.d.h<? super T, ? extends Iterable<? extends U>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new ba(this, paramh));
  }
  
  public final <U, V> l<V> flatMapIterable(b.a.d.h<? super T, ? extends Iterable<? extends U>> paramh, b.a.d.c<? super T, ? super U, ? extends V> paramc)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramc, "resultSelector is null");
    return flatMap(bn.b(paramh), paramc, false, bufferSize(), bufferSize());
  }
  
  public final <R> l<R> flatMapMaybe(b.a.d.h<? super T, ? extends j<? extends R>> paramh)
  {
    return flatMapMaybe(paramh, false);
  }
  
  public final <R> l<R> flatMapMaybe(b.a.d.h<? super T, ? extends j<? extends R>> paramh, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new ay(this, paramh, paramBoolean));
  }
  
  public final <R> l<R> flatMapSingle(b.a.d.h<? super T, ? extends w<? extends R>> paramh)
  {
    return flatMapSingle(paramh, false);
  }
  
  public final <R> l<R> flatMapSingle(b.a.d.h<? super T, ? extends w<? extends R>> paramh, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new az(this, paramh, paramBoolean));
  }
  
  public final b.a.b.b forEach(b.a.d.g<? super T> paramg)
  {
    return subscribe(paramg);
  }
  
  public final b.a.b.b forEachWhile(b.a.d.q<? super T> paramq)
  {
    return forEachWhile(paramq, b.a.e.b.a.f, b.a.e.b.a.c);
  }
  
  public final b.a.b.b forEachWhile(b.a.d.q<? super T> paramq, b.a.d.g<? super Throwable> paramg)
  {
    return forEachWhile(paramq, paramg, b.a.e.b.a.c);
  }
  
  public final b.a.b.b forEachWhile(b.a.d.q<? super T> paramq, b.a.d.g<? super Throwable> paramg, b.a.d.a parama)
  {
    b.a.e.b.b.a(paramq, "onNext is null");
    b.a.e.b.b.a(paramg, "onError is null");
    b.a.e.b.b.a(parama, "onComplete is null");
    paramq = new b.a.e.d.k(paramq, paramg, parama);
    subscribe(paramq);
    return paramq;
  }
  
  public final <K> l<b.a.f.b<K, T>> groupBy(b.a.d.h<? super T, ? extends K> paramh)
  {
    return groupBy(paramh, b.a.e.b.a.a(), false, bufferSize());
  }
  
  public final <K, V> l<b.a.f.b<K, V>> groupBy(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1)
  {
    return groupBy(paramh, paramh1, false, bufferSize());
  }
  
  public final <K, V> l<b.a.f.b<K, V>> groupBy(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1, boolean paramBoolean)
  {
    return groupBy(paramh, paramh1, paramBoolean, bufferSize());
  }
  
  public final <K, V> l<b.a.f.b<K, V>> groupBy(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    b.a.e.b.b.a(paramh1, "valueSelector is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new bi(this, paramh, paramh1, paramInt, paramBoolean));
  }
  
  public final <K> l<b.a.f.b<K, T>> groupBy(b.a.d.h<? super T, ? extends K> paramh, boolean paramBoolean)
  {
    return groupBy(paramh, b.a.e.b.a.a(), paramBoolean, bufferSize());
  }
  
  public final <TRight, TLeftEnd, TRightEnd, R> l<R> groupJoin(q<? extends TRight> paramq, b.a.d.h<? super T, ? extends q<TLeftEnd>> paramh, b.a.d.h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super T, ? super l<TRight>, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "other is null");
    b.a.e.b.b.a(paramh, "leftEnd is null");
    b.a.e.b.b.a(paramh1, "rightEnd is null");
    b.a.e.b.b.a(paramc, "resultSelector is null");
    return b.a.h.a.a(new bj(this, paramq, paramh, paramh1, paramc));
  }
  
  public final l<T> hide()
  {
    return b.a.h.a.a(new bk(this));
  }
  
  public final b ignoreElements()
  {
    return b.a.h.a.a(new bm(this));
  }
  
  public final u<Boolean> isEmpty()
  {
    return all(b.a.e.b.a.d());
  }
  
  public final <TRight, TLeftEnd, TRightEnd, R> l<R> join(q<? extends TRight> paramq, b.a.d.h<? super T, ? extends q<TLeftEnd>> paramh, b.a.d.h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super T, ? super TRight, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "other is null");
    b.a.e.b.b.a(paramh, "leftEnd is null");
    b.a.e.b.b.a(paramh1, "rightEnd is null");
    b.a.e.b.b.a(paramc, "resultSelector is null");
    return b.a.h.a.a(new bq(this, paramq, paramh, paramh1, paramc));
  }
  
  public final u<T> last(T paramT)
  {
    b.a.e.b.b.a(paramT, "defaultItem is null");
    return b.a.h.a.a(new bt(this, paramT));
  }
  
  public final h<T> lastElement()
  {
    return b.a.h.a.a(new bs(this));
  }
  
  public final u<T> lastOrError()
  {
    return b.a.h.a.a(new bt(this, null));
  }
  
  public final <R> l<R> lift(p<? extends R, ? super T> paramp)
  {
    b.a.e.b.b.a(paramp, "onLift is null");
    return b.a.h.a.a(new bu(this, paramp));
  }
  
  public final <R> l<R> map(b.a.d.h<? super T, ? extends R> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new bv(this, paramh));
  }
  
  public final l<k<T>> materialize()
  {
    return b.a.h.a.a(new bx(this));
  }
  
  public final l<T> mergeWith(d paramd)
  {
    b.a.e.b.b.a(paramd, "other is null");
    return b.a.h.a.a(new by(this, paramd));
  }
  
  public final l<T> mergeWith(j<? extends T> paramj)
  {
    b.a.e.b.b.a(paramj, "other is null");
    return b.a.h.a.a(new bz(this, paramj));
  }
  
  public final l<T> mergeWith(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return merge(this, paramq);
  }
  
  public final l<T> mergeWith(w<? extends T> paramw)
  {
    b.a.e.b.b.a(paramw, "other is null");
    return b.a.h.a.a(new ca(this, paramw));
  }
  
  public final l<T> observeOn(t paramt)
  {
    return observeOn(paramt, false, bufferSize());
  }
  
  public final l<T> observeOn(t paramt, boolean paramBoolean)
  {
    return observeOn(paramt, paramBoolean, bufferSize());
  }
  
  public final l<T> observeOn(t paramt, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new cc(this, paramt, paramBoolean, paramInt));
  }
  
  public final <U> l<U> ofType(Class<U> paramClass)
  {
    b.a.e.b.b.a(paramClass, "clazz is null");
    return filter(b.a.e.b.a.b(paramClass)).cast(paramClass);
  }
  
  public final l<T> onErrorResumeNext(b.a.d.h<? super Throwable, ? extends q<? extends T>> paramh)
  {
    b.a.e.b.b.a(paramh, "resumeFunction is null");
    return b.a.h.a.a(new cd(this, paramh, false));
  }
  
  public final l<T> onErrorResumeNext(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "next is null");
    return onErrorResumeNext(b.a.e.b.a.b(paramq));
  }
  
  public final l<T> onErrorReturn(b.a.d.h<? super Throwable, ? extends T> paramh)
  {
    b.a.e.b.b.a(paramh, "valueSupplier is null");
    return b.a.h.a.a(new ce(this, paramh));
  }
  
  public final l<T> onErrorReturnItem(T paramT)
  {
    b.a.e.b.b.a(paramT, "item is null");
    return onErrorReturn(b.a.e.b.a.b(paramT));
  }
  
  public final l<T> onExceptionResumeNext(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "next is null");
    return b.a.h.a.a(new cd(this, b.a.e.b.a.b(paramq), true));
  }
  
  public final l<T> onTerminateDetach()
  {
    return b.a.h.a.a(new ai(this));
  }
  
  public final b.a.f.a<T> publish()
  {
    return cf.a(this);
  }
  
  public final <R> l<R> publish(b.a.d.h<? super l<T>, ? extends q<R>> paramh)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    return b.a.h.a.a(new cg(this, paramh));
  }
  
  public final h<T> reduce(b.a.d.c<T, T, T> paramc)
  {
    b.a.e.b.b.a(paramc, "reducer is null");
    return b.a.h.a.a(new cj(this, paramc));
  }
  
  public final <R> u<R> reduce(R paramR, b.a.d.c<R, ? super T, R> paramc)
  {
    b.a.e.b.b.a(paramR, "seed is null");
    b.a.e.b.b.a(paramc, "reducer is null");
    return b.a.h.a.a(new ck(this, paramR, paramc));
  }
  
  public final <R> u<R> reduceWith(Callable<R> paramCallable, b.a.d.c<R, ? super T, R> paramc)
  {
    b.a.e.b.b.a(paramCallable, "seedSupplier is null");
    b.a.e.b.b.a(paramc, "reducer is null");
    return b.a.h.a.a(new cl(this, paramCallable, paramc));
  }
  
  public final l<T> repeat()
  {
    return repeat(Long.MAX_VALUE);
  }
  
  public final l<T> repeat(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return empty();
      }
      return b.a.h.a.a(new cn(this, paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("times >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final l<T> repeatUntil(b.a.d.e parame)
  {
    b.a.e.b.b.a(parame, "stop is null");
    return b.a.h.a.a(new co(this, parame));
  }
  
  public final l<T> repeatWhen(b.a.d.h<? super l<Object>, ? extends q<?>> paramh)
  {
    b.a.e.b.b.a(paramh, "handler is null");
    return b.a.h.a.a(new cp(this, paramh));
  }
  
  public final b.a.f.a<T> replay()
  {
    return cq.a(this);
  }
  
  public final b.a.f.a<T> replay(int paramInt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    return cq.a(this, paramInt);
  }
  
  public final b.a.f.a<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return replay(paramInt, paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final b.a.f.a<T> replay(int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(this, paramLong, paramTimeUnit, paramt, paramInt);
  }
  
  public final b.a.f.a<T> replay(int paramInt, t paramt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    return cq.a(replay(paramInt), paramt);
  }
  
  public final b.a.f.a<T> replay(long paramLong, TimeUnit paramTimeUnit)
  {
    return replay(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final b.a.f.a<T> replay(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(this, paramLong, paramTimeUnit, paramt);
  }
  
  public final b.a.f.a<T> replay(t paramt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(replay(), paramt);
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    return cq.a(bn.a(this), paramh);
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return cq.a(bn.a(this, paramInt), paramh);
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return replay(paramh, paramInt, paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, int paramInt, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(bn.a(this, paramInt, paramLong, paramTimeUnit, paramt), paramh);
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, int paramInt, t paramt)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return cq.a(bn.a(this, paramInt), bn.a(paramh, paramt));
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, long paramLong, TimeUnit paramTimeUnit)
  {
    return replay(paramh, paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(bn.a(this, paramLong, paramTimeUnit, paramt), paramh);
  }
  
  public final <R> l<R> replay(b.a.d.h<? super l<T>, ? extends q<R>> paramh, t paramt)
  {
    b.a.e.b.b.a(paramh, "selector is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return cq.a(bn.a(this), bn.a(paramh, paramt));
  }
  
  public final l<T> retry()
  {
    return retry(Long.MAX_VALUE, b.a.e.b.a.c());
  }
  
  public final l<T> retry(long paramLong)
  {
    return retry(paramLong, b.a.e.b.a.c());
  }
  
  public final l<T> retry(long paramLong, b.a.d.q<? super Throwable> paramq)
  {
    if (paramLong >= 0L)
    {
      b.a.e.b.b.a(paramq, "predicate is null");
      return b.a.h.a.a(new cs(this, paramLong, paramq));
    }
    paramq = new StringBuilder();
    paramq.append("times >= 0 required but it was ");
    paramq.append(paramLong);
    throw new IllegalArgumentException(paramq.toString());
  }
  
  public final l<T> retry(b.a.d.d<? super Integer, ? super Throwable> paramd)
  {
    b.a.e.b.b.a(paramd, "predicate is null");
    return b.a.h.a.a(new cr(this, paramd));
  }
  
  public final l<T> retry(b.a.d.q<? super Throwable> paramq)
  {
    return retry(Long.MAX_VALUE, paramq);
  }
  
  public final l<T> retryUntil(b.a.d.e parame)
  {
    b.a.e.b.b.a(parame, "stop is null");
    return retry(Long.MAX_VALUE, b.a.e.b.a.a(parame));
  }
  
  public final l<T> retryWhen(b.a.d.h<? super l<Throwable>, ? extends q<?>> paramh)
  {
    b.a.e.b.b.a(paramh, "handler is null");
    return b.a.h.a.a(new ct(this, paramh));
  }
  
  public final void safeSubscribe(s<? super T> params)
  {
    b.a.e.b.b.a(params, "s is null");
    if ((params instanceof b.a.g.d))
    {
      subscribe(params);
      return;
    }
    subscribe(new b.a.g.d(params));
  }
  
  public final l<T> sample(long paramLong, TimeUnit paramTimeUnit)
  {
    return sample(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<T> sample(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new cu(this, paramLong, paramTimeUnit, paramt, false));
  }
  
  public final l<T> sample(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new cu(this, paramLong, paramTimeUnit, paramt, paramBoolean));
  }
  
  public final l<T> sample(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return sample(paramLong, paramTimeUnit, b.a.i.a.a(), paramBoolean);
  }
  
  public final <U> l<T> sample(q<U> paramq)
  {
    b.a.e.b.b.a(paramq, "sampler is null");
    return b.a.h.a.a(new cv(this, paramq, false));
  }
  
  public final <U> l<T> sample(q<U> paramq, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramq, "sampler is null");
    return b.a.h.a.a(new cv(this, paramq, paramBoolean));
  }
  
  public final l<T> scan(b.a.d.c<T, T, T> paramc)
  {
    b.a.e.b.b.a(paramc, "accumulator is null");
    return b.a.h.a.a(new cx(this, paramc));
  }
  
  public final <R> l<R> scan(R paramR, b.a.d.c<R, ? super T, R> paramc)
  {
    b.a.e.b.b.a(paramR, "seed is null");
    return scanWith(b.a.e.b.a.a(paramR), paramc);
  }
  
  public final <R> l<R> scanWith(Callable<R> paramCallable, b.a.d.c<R, ? super T, R> paramc)
  {
    b.a.e.b.b.a(paramCallable, "seedSupplier is null");
    b.a.e.b.b.a(paramc, "accumulator is null");
    return b.a.h.a.a(new cy(this, paramCallable, paramc));
  }
  
  public final l<T> serialize()
  {
    return b.a.h.a.a(new db(this));
  }
  
  public final l<T> share()
  {
    return publish().a();
  }
  
  public final u<T> single(T paramT)
  {
    b.a.e.b.b.a(paramT, "defaultItem is null");
    return b.a.h.a.a(new dd(this, paramT));
  }
  
  public final h<T> singleElement()
  {
    return b.a.h.a.a(new dc(this));
  }
  
  public final u<T> singleOrError()
  {
    return b.a.h.a.a(new dd(this, null));
  }
  
  public final l<T> skip(long paramLong)
  {
    if (paramLong <= 0L) {
      return b.a.h.a.a(this);
    }
    return b.a.h.a.a(new de(this, paramLong));
  }
  
  public final l<T> skip(long paramLong, TimeUnit paramTimeUnit)
  {
    return skipUntil(timer(paramLong, paramTimeUnit));
  }
  
  public final l<T> skip(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return skipUntil(timer(paramLong, paramTimeUnit, paramt));
  }
  
  public final l<T> skipLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return b.a.h.a.a(this);
      }
      return b.a.h.a.a(new df(this, paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final l<T> skipLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return skipLast(paramLong, paramTimeUnit, b.a.i.a.c(), false, bufferSize());
  }
  
  public final l<T> skipLast(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return skipLast(paramLong, paramTimeUnit, paramt, false, bufferSize());
  }
  
  public final l<T> skipLast(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    return skipLast(paramLong, paramTimeUnit, paramt, paramBoolean, bufferSize());
  }
  
  public final l<T> skipLast(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new dg(this, paramLong, paramTimeUnit, paramt, paramInt << 1, paramBoolean));
  }
  
  public final l<T> skipLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return skipLast(paramLong, paramTimeUnit, b.a.i.a.c(), paramBoolean, bufferSize());
  }
  
  public final <U> l<T> skipUntil(q<U> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return b.a.h.a.a(new dh(this, paramq));
  }
  
  public final l<T> skipWhile(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new di(this, paramq));
  }
  
  public final l<T> sorted()
  {
    return toList().b().map(b.a.e.b.a.a(b.a.e.b.a.h())).flatMapIterable(b.a.e.b.a.a());
  }
  
  public final l<T> sorted(Comparator<? super T> paramComparator)
  {
    b.a.e.b.b.a(paramComparator, "sortFunction is null");
    return toList().b().map(b.a.e.b.a.a(paramComparator)).flatMapIterable(b.a.e.b.a.a());
  }
  
  public final l<T> startWith(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return concatArray(new q[] { paramq, this });
  }
  
  public final l<T> startWith(Iterable<? extends T> paramIterable)
  {
    return concatArray(new q[] { fromIterable(paramIterable), this });
  }
  
  public final l<T> startWith(T paramT)
  {
    b.a.e.b.b.a(paramT, "item is null");
    return concatArray(new q[] { just(paramT), this });
  }
  
  public final l<T> startWithArray(T... paramVarArgs)
  {
    paramVarArgs = fromArray(paramVarArgs);
    if (paramVarArgs == empty()) {
      return b.a.h.a.a(this);
    }
    return concatArray(new q[] { paramVarArgs, this });
  }
  
  public final b.a.b.b subscribe()
  {
    return subscribe(b.a.e.b.a.b(), b.a.e.b.a.f, b.a.e.b.a.c, b.a.e.b.a.b());
  }
  
  public final b.a.b.b subscribe(b.a.d.g<? super T> paramg)
  {
    return subscribe(paramg, b.a.e.b.a.f, b.a.e.b.a.c, b.a.e.b.a.b());
  }
  
  public final b.a.b.b subscribe(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1)
  {
    return subscribe(paramg, paramg1, b.a.e.b.a.c, b.a.e.b.a.b());
  }
  
  public final b.a.b.b subscribe(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1, b.a.d.a parama)
  {
    return subscribe(paramg, paramg1, parama, b.a.e.b.a.b());
  }
  
  public final b.a.b.b subscribe(b.a.d.g<? super T> paramg, b.a.d.g<? super Throwable> paramg1, b.a.d.a parama, b.a.d.g<? super b.a.b.b> paramg2)
  {
    b.a.e.b.b.a(paramg, "onNext is null");
    b.a.e.b.b.a(paramg1, "onError is null");
    b.a.e.b.b.a(parama, "onComplete is null");
    b.a.e.b.b.a(paramg2, "onSubscribe is null");
    paramg = new b.a.e.d.o(paramg, paramg1, parama, paramg2);
    subscribe(paramg);
    return paramg;
  }
  
  public final void subscribe(s<? super T> params)
  {
    b.a.e.b.b.a(params, "observer is null");
    try
    {
      params = b.a.h.a.a(this, params);
      b.a.e.b.b.a(params, "Plugin returned null Observer");
      subscribeActual(params);
      return;
    }
    catch (Throwable params)
    {
      b.a.c.b.b(params);
      b.a.h.a.a(params);
      NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      localNullPointerException.initCause(params);
      throw localNullPointerException;
    }
    catch (NullPointerException params)
    {
      throw params;
    }
  }
  
  protected abstract void subscribeActual(s<? super T> params);
  
  public final l<T> subscribeOn(t paramt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new dj(this, paramt));
  }
  
  public final <E extends s<? super T>> E subscribeWith(E paramE)
  {
    subscribe(paramE);
    return paramE;
  }
  
  public final l<T> switchIfEmpty(q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return b.a.h.a.a(new dk(this, paramq));
  }
  
  public final <R> l<R> switchMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return switchMap(paramh, bufferSize());
  }
  
  public final <R> l<R> switchMap(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    if ((this instanceof b.a.e.c.e))
    {
      Object localObject = ((b.a.e.c.e)this).call();
      if (localObject == null) {
        return empty();
      }
      return cw.a(localObject, paramh);
    }
    return b.a.h.a.a(new dl(this, paramh, paramInt, false));
  }
  
  public final b switchMapCompletable(b.a.d.h<? super T, ? extends d> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.d(this, paramh, false));
  }
  
  public final b switchMapCompletableDelayError(b.a.d.h<? super T, ? extends d> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.d(this, paramh, true));
  }
  
  public final <R> l<R> switchMapDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh)
  {
    return switchMapDelayError(paramh, bufferSize());
  }
  
  public final <R> l<R> switchMapDelayError(b.a.d.h<? super T, ? extends q<? extends R>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    if ((this instanceof b.a.e.c.e))
    {
      Object localObject = ((b.a.e.c.e)this).call();
      if (localObject == null) {
        return empty();
      }
      return cw.a(localObject, paramh);
    }
    return b.a.h.a.a(new dl(this, paramh, paramInt, true));
  }
  
  public final <R> l<R> switchMapMaybe(b.a.d.h<? super T, ? extends j<? extends R>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.e(this, paramh, false));
  }
  
  public final <R> l<R> switchMapMaybeDelayError(b.a.d.h<? super T, ? extends j<? extends R>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.e(this, paramh, true));
  }
  
  public final <R> l<R> switchMapSingle(b.a.d.h<? super T, ? extends w<? extends R>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.f(this, paramh, false));
  }
  
  public final <R> l<R> switchMapSingleDelayError(b.a.d.h<? super T, ? extends w<? extends R>> paramh)
  {
    b.a.e.b.b.a(paramh, "mapper is null");
    return b.a.h.a.a(new b.a.e.e.c.f(this, paramh, true));
  }
  
  public final l<T> take(long paramLong)
  {
    if (paramLong >= 0L) {
      return b.a.h.a.a(new dm(this, paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final l<T> take(long paramLong, TimeUnit paramTimeUnit)
  {
    return takeUntil(timer(paramLong, paramTimeUnit));
  }
  
  public final l<T> take(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return takeUntil(timer(paramLong, paramTimeUnit, paramt));
  }
  
  public final l<T> takeLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return b.a.h.a.a(new bl(this));
      }
      if (paramInt == 1) {
        return b.a.h.a.a(new do(this));
      }
      return b.a.h.a.a(new dn(this, paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final l<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return takeLast(paramLong1, paramLong2, paramTimeUnit, b.a.i.a.c(), false, bufferSize());
  }
  
  public final l<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt)
  {
    return takeLast(paramLong1, paramLong2, paramTimeUnit, paramt, false, bufferSize());
  }
  
  public final l<T> takeLast(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    if (paramLong1 >= 0L) {
      return b.a.h.a.a(new dp(this, paramLong1, paramLong2, paramTimeUnit, paramt, paramInt, paramBoolean));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("count >= 0 required but it was ");
    paramTimeUnit.append(paramLong1);
    throw new IndexOutOfBoundsException(paramTimeUnit.toString());
  }
  
  public final l<T> takeLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return takeLast(paramLong, paramTimeUnit, b.a.i.a.c(), false, bufferSize());
  }
  
  public final l<T> takeLast(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return takeLast(paramLong, paramTimeUnit, paramt, false, bufferSize());
  }
  
  public final l<T> takeLast(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    return takeLast(paramLong, paramTimeUnit, paramt, paramBoolean, bufferSize());
  }
  
  public final l<T> takeLast(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean, int paramInt)
  {
    return takeLast(Long.MAX_VALUE, paramLong, paramTimeUnit, paramt, paramBoolean, paramInt);
  }
  
  public final l<T> takeLast(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return takeLast(paramLong, paramTimeUnit, b.a.i.a.c(), paramBoolean, bufferSize());
  }
  
  public final l<T> takeUntil(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new dr(this, paramq));
  }
  
  public final <U> l<T> takeUntil(q<U> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return b.a.h.a.a(new dq(this, paramq));
  }
  
  public final l<T> takeWhile(b.a.d.q<? super T> paramq)
  {
    b.a.e.b.b.a(paramq, "predicate is null");
    return b.a.h.a.a(new ds(this, paramq));
  }
  
  public final b.a.g.f<T> test()
  {
    b.a.g.f localf = new b.a.g.f();
    subscribe(localf);
    return localf;
  }
  
  public final b.a.g.f<T> test(boolean paramBoolean)
  {
    b.a.g.f localf = new b.a.g.f();
    if (paramBoolean) {
      localf.dispose();
    }
    subscribe(localf);
    return localf;
  }
  
  public final l<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    return throttleFirst(paramLong, paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<T> throttleFirst(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new dt(this, paramLong, paramTimeUnit, paramt));
  }
  
  public final l<T> throttleLast(long paramLong, TimeUnit paramTimeUnit)
  {
    return sample(paramLong, paramTimeUnit);
  }
  
  public final l<T> throttleLast(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return sample(paramLong, paramTimeUnit, paramt);
  }
  
  public final l<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit)
  {
    return throttleLatest(paramLong, paramTimeUnit, b.a.i.a.a(), false);
  }
  
  public final l<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return throttleLatest(paramLong, paramTimeUnit, paramt, false);
  }
  
  public final l<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, t paramt, boolean paramBoolean)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new du(this, paramLong, paramTimeUnit, paramt, paramBoolean));
  }
  
  public final l<T> throttleLatest(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return throttleLatest(paramLong, paramTimeUnit, b.a.i.a.a(), paramBoolean);
  }
  
  public final l<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return debounce(paramLong, paramTimeUnit);
  }
  
  public final l<T> throttleWithTimeout(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return debounce(paramLong, paramTimeUnit, paramt);
  }
  
  public final l<b.a.i.b<T>> timeInterval()
  {
    return timeInterval(TimeUnit.MILLISECONDS, b.a.i.a.a());
  }
  
  public final l<b.a.i.b<T>> timeInterval(t paramt)
  {
    return timeInterval(TimeUnit.MILLISECONDS, paramt);
  }
  
  public final l<b.a.i.b<T>> timeInterval(TimeUnit paramTimeUnit)
  {
    return timeInterval(paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<b.a.i.b<T>> timeInterval(TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new dv(this, paramTimeUnit, paramt));
  }
  
  public final l<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return timeout0(paramLong, paramTimeUnit, null, b.a.i.a.a());
  }
  
  public final l<T> timeout(long paramLong, TimeUnit paramTimeUnit, q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return timeout0(paramLong, paramTimeUnit, paramq, b.a.i.a.a());
  }
  
  public final l<T> timeout(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return timeout0(paramLong, paramTimeUnit, null, paramt);
  }
  
  public final l<T> timeout(long paramLong, TimeUnit paramTimeUnit, t paramt, q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return timeout0(paramLong, paramTimeUnit, paramq, paramt);
  }
  
  public final <V> l<T> timeout(b.a.d.h<? super T, ? extends q<V>> paramh)
  {
    return timeout0(null, paramh, null);
  }
  
  public final <V> l<T> timeout(b.a.d.h<? super T, ? extends q<V>> paramh, q<? extends T> paramq)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return timeout0(null, paramh, paramq);
  }
  
  public final <U, V> l<T> timeout(q<U> paramq, b.a.d.h<? super T, ? extends q<V>> paramh)
  {
    b.a.e.b.b.a(paramq, "firstTimeoutIndicator is null");
    return timeout0(paramq, paramh, null);
  }
  
  public final <U, V> l<T> timeout(q<U> paramq, b.a.d.h<? super T, ? extends q<V>> paramh, q<? extends T> paramq1)
  {
    b.a.e.b.b.a(paramq, "firstTimeoutIndicator is null");
    b.a.e.b.b.a(paramq1, "other is null");
    return timeout0(paramq, paramh, paramq1);
  }
  
  public final l<b.a.i.b<T>> timestamp()
  {
    return timestamp(TimeUnit.MILLISECONDS, b.a.i.a.a());
  }
  
  public final l<b.a.i.b<T>> timestamp(t paramt)
  {
    return timestamp(TimeUnit.MILLISECONDS, paramt);
  }
  
  public final l<b.a.i.b<T>> timestamp(TimeUnit paramTimeUnit)
  {
    return timestamp(paramTimeUnit, b.a.i.a.a());
  }
  
  public final l<b.a.i.b<T>> timestamp(TimeUnit paramTimeUnit, t paramt)
  {
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramt, "scheduler is null");
    return map(b.a.e.b.a.a(paramTimeUnit, paramt));
  }
  
  public final <R> R to(b.a.d.h<? super l<T>, R> paramh)
  {
    try
    {
      paramh = ((b.a.d.h)b.a.e.b.b.a(paramh, "converter is null")).apply(this);
      return paramh;
    }
    catch (Throwable paramh)
    {
      b.a.c.b.b(paramh);
      throw b.a.e.j.j.a(paramh);
    }
  }
  
  public final f<T> toFlowable(a parama)
  {
    b.a.e.e.a.b localb = new b.a.e.e.a.b(this);
    switch (1.a[parama.ordinal()])
    {
    default: 
      return localb.b();
    case 4: 
      return b.a.h.a.a(new b.a.e.e.a.e(localb));
    case 3: 
      return localb;
    case 2: 
      return localb.d();
    }
    return localb.c();
  }
  
  public final Future<T> toFuture()
  {
    return (Future)subscribeWith(new b.a.e.d.l());
  }
  
  public final u<List<T>> toList()
  {
    return toList(16);
  }
  
  public final u<List<T>> toList(int paramInt)
  {
    b.a.e.b.b.a(paramInt, "capacityHint");
    return b.a.h.a.a(new ea(this, paramInt));
  }
  
  public final <U extends Collection<? super T>> u<U> toList(Callable<U> paramCallable)
  {
    b.a.e.b.b.a(paramCallable, "collectionSupplier is null");
    return b.a.h.a.a(new ea(this, paramCallable));
  }
  
  public final <K> u<Map<K, T>> toMap(b.a.d.h<? super T, ? extends K> paramh)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    return collect(b.a.e.j.l.asCallable(), b.a.e.b.a.a(paramh));
  }
  
  public final <K, V> u<Map<K, V>> toMap(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    b.a.e.b.b.a(paramh1, "valueSelector is null");
    return collect(b.a.e.j.l.asCallable(), b.a.e.b.a.a(paramh, paramh1));
  }
  
  public final <K, V> u<Map<K, V>> toMap(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1, Callable<? extends Map<K, V>> paramCallable)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    b.a.e.b.b.a(paramh1, "valueSelector is null");
    b.a.e.b.b.a(paramCallable, "mapSupplier is null");
    return collect(paramCallable, b.a.e.b.a.a(paramh, paramh1));
  }
  
  public final <K> u<Map<K, Collection<T>>> toMultimap(b.a.d.h<? super T, ? extends K> paramh)
  {
    return toMultimap(paramh, b.a.e.b.a.a(), b.a.e.j.l.asCallable(), b.a.e.j.b.asFunction());
  }
  
  public final <K, V> u<Map<K, Collection<V>>> toMultimap(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1)
  {
    return toMultimap(paramh, paramh1, b.a.e.j.l.asCallable(), b.a.e.j.b.asFunction());
  }
  
  public final <K, V> u<Map<K, Collection<V>>> toMultimap(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1, Callable<Map<K, Collection<V>>> paramCallable)
  {
    return toMultimap(paramh, paramh1, paramCallable, b.a.e.j.b.asFunction());
  }
  
  public final <K, V> u<Map<K, Collection<V>>> toMultimap(b.a.d.h<? super T, ? extends K> paramh, b.a.d.h<? super T, ? extends V> paramh1, Callable<? extends Map<K, Collection<V>>> paramCallable, b.a.d.h<? super K, ? extends Collection<? super V>> paramh2)
  {
    b.a.e.b.b.a(paramh, "keySelector is null");
    b.a.e.b.b.a(paramh1, "valueSelector is null");
    b.a.e.b.b.a(paramCallable, "mapSupplier is null");
    b.a.e.b.b.a(paramh2, "collectionFactory is null");
    return collect(paramCallable, b.a.e.b.a.a(paramh, paramh1, paramh2));
  }
  
  public final u<List<T>> toSortedList()
  {
    return toSortedList(b.a.e.b.a.f());
  }
  
  public final u<List<T>> toSortedList(int paramInt)
  {
    return toSortedList(b.a.e.b.a.f(), paramInt);
  }
  
  public final u<List<T>> toSortedList(Comparator<? super T> paramComparator)
  {
    b.a.e.b.b.a(paramComparator, "comparator is null");
    return toList().a(b.a.e.b.a.a(paramComparator));
  }
  
  public final u<List<T>> toSortedList(Comparator<? super T> paramComparator, int paramInt)
  {
    b.a.e.b.b.a(paramComparator, "comparator is null");
    return toList(paramInt).a(b.a.e.b.a.a(paramComparator));
  }
  
  public final l<T> unsubscribeOn(t paramt)
  {
    b.a.e.b.b.a(paramt, "scheduler is null");
    return b.a.h.a.a(new eb(this, paramt));
  }
  
  public final l<l<T>> window(long paramLong)
  {
    return window(paramLong, paramLong, bufferSize());
  }
  
  public final l<l<T>> window(long paramLong1, long paramLong2)
  {
    return window(paramLong1, paramLong2, bufferSize());
  }
  
  public final l<l<T>> window(long paramLong1, long paramLong2, int paramInt)
  {
    b.a.e.b.b.a(paramLong1, "count");
    b.a.e.b.b.a(paramLong2, "skip");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new ed(this, paramLong1, paramLong2, paramInt));
  }
  
  public final l<l<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return window(paramLong1, paramLong2, paramTimeUnit, b.a.i.a.a(), bufferSize());
  }
  
  public final l<l<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt)
  {
    return window(paramLong1, paramLong2, paramTimeUnit, paramt, bufferSize());
  }
  
  public final l<l<T>> window(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, t paramt, int paramInt)
  {
    b.a.e.b.b.a(paramLong1, "timespan");
    b.a.e.b.b.a(paramLong2, "timeskip");
    b.a.e.b.b.a(paramInt, "bufferSize");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    return b.a.h.a.a(new eh(this, paramLong1, paramLong2, paramTimeUnit, paramt, Long.MAX_VALUE, paramInt, false));
  }
  
  public final l<l<T>> window(long paramLong, TimeUnit paramTimeUnit)
  {
    return window(paramLong, paramTimeUnit, b.a.i.a.a(), Long.MAX_VALUE, false);
  }
  
  public final l<l<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2)
  {
    return window(paramLong1, paramTimeUnit, b.a.i.a.a(), paramLong2, false);
  }
  
  public final l<l<T>> window(long paramLong1, TimeUnit paramTimeUnit, long paramLong2, boolean paramBoolean)
  {
    return window(paramLong1, paramTimeUnit, b.a.i.a.a(), paramLong2, paramBoolean);
  }
  
  public final l<l<T>> window(long paramLong, TimeUnit paramTimeUnit, t paramt)
  {
    return window(paramLong, paramTimeUnit, paramt, Long.MAX_VALUE, false);
  }
  
  public final l<l<T>> window(long paramLong1, TimeUnit paramTimeUnit, t paramt, long paramLong2)
  {
    return window(paramLong1, paramTimeUnit, paramt, paramLong2, false);
  }
  
  public final l<l<T>> window(long paramLong1, TimeUnit paramTimeUnit, t paramt, long paramLong2, boolean paramBoolean)
  {
    return window(paramLong1, paramTimeUnit, paramt, paramLong2, paramBoolean, bufferSize());
  }
  
  public final l<l<T>> window(long paramLong1, TimeUnit paramTimeUnit, t paramt, long paramLong2, boolean paramBoolean, int paramInt)
  {
    b.a.e.b.b.a(paramInt, "bufferSize");
    b.a.e.b.b.a(paramt, "scheduler is null");
    b.a.e.b.b.a(paramTimeUnit, "unit is null");
    b.a.e.b.b.a(paramLong2, "count");
    return b.a.h.a.a(new eh(this, paramLong1, paramLong1, paramTimeUnit, paramt, paramLong2, paramInt, paramBoolean));
  }
  
  public final <B> l<l<T>> window(q<B> paramq)
  {
    return window(paramq, bufferSize());
  }
  
  public final <B> l<l<T>> window(q<B> paramq, int paramInt)
  {
    b.a.e.b.b.a(paramq, "boundary is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new ee(this, paramq, paramInt));
  }
  
  public final <U, V> l<l<T>> window(q<U> paramq, b.a.d.h<? super U, ? extends q<V>> paramh)
  {
    return window(paramq, paramh, bufferSize());
  }
  
  public final <U, V> l<l<T>> window(q<U> paramq, b.a.d.h<? super U, ? extends q<V>> paramh, int paramInt)
  {
    b.a.e.b.b.a(paramq, "openingIndicator is null");
    b.a.e.b.b.a(paramh, "closingIndicator is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new ef(this, paramq, paramh, paramInt));
  }
  
  public final <B> l<l<T>> window(Callable<? extends q<B>> paramCallable)
  {
    return window(paramCallable, bufferSize());
  }
  
  public final <B> l<l<T>> window(Callable<? extends q<B>> paramCallable, int paramInt)
  {
    b.a.e.b.b.a(paramCallable, "boundary is null");
    b.a.e.b.b.a(paramInt, "bufferSize");
    return b.a.h.a.a(new eg(this, paramCallable, paramInt));
  }
  
  public final <U, R> l<R> withLatestFrom(q<? extends U> paramq, b.a.d.c<? super T, ? super U, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "other is null");
    b.a.e.b.b.a(paramc, "combiner is null");
    return b.a.h.a.a(new ei(this, paramc, paramq));
  }
  
  public final <T1, T2, R> l<R> withLatestFrom(q<T1> paramq, q<T2> paramq1, b.a.d.i<? super T, ? super T1, ? super T2, R> parami)
  {
    b.a.e.b.b.a(paramq, "o1 is null");
    b.a.e.b.b.a(paramq1, "o2 is null");
    b.a.e.b.b.a(parami, "combiner is null");
    parami = b.a.e.b.a.a(parami);
    return withLatestFrom(new q[] { paramq, paramq1 }, parami);
  }
  
  public final <T1, T2, T3, R> l<R> withLatestFrom(q<T1> paramq, q<T2> paramq1, q<T3> paramq2, b.a.d.j<? super T, ? super T1, ? super T2, ? super T3, R> paramj)
  {
    b.a.e.b.b.a(paramq, "o1 is null");
    b.a.e.b.b.a(paramq1, "o2 is null");
    b.a.e.b.b.a(paramq2, "o3 is null");
    b.a.e.b.b.a(paramj, "combiner is null");
    paramj = b.a.e.b.a.a(paramj);
    return withLatestFrom(new q[] { paramq, paramq1, paramq2 }, paramj);
  }
  
  public final <T1, T2, T3, T4, R> l<R> withLatestFrom(q<T1> paramq, q<T2> paramq1, q<T3> paramq2, q<T4> paramq3, b.a.d.k<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> paramk)
  {
    b.a.e.b.b.a(paramq, "o1 is null");
    b.a.e.b.b.a(paramq1, "o2 is null");
    b.a.e.b.b.a(paramq2, "o3 is null");
    b.a.e.b.b.a(paramq3, "o4 is null");
    b.a.e.b.b.a(paramk, "combiner is null");
    paramk = b.a.e.b.a.a(paramk);
    return withLatestFrom(new q[] { paramq, paramq1, paramq2, paramq3 }, paramk);
  }
  
  public final <R> l<R> withLatestFrom(Iterable<? extends q<?>> paramIterable, b.a.d.h<? super Object[], R> paramh)
  {
    b.a.e.b.b.a(paramIterable, "others is null");
    b.a.e.b.b.a(paramh, "combiner is null");
    return b.a.h.a.a(new ej(this, paramIterable, paramh));
  }
  
  public final <R> l<R> withLatestFrom(q<?>[] paramArrayOfq, b.a.d.h<? super Object[], R> paramh)
  {
    b.a.e.b.b.a(paramArrayOfq, "others is null");
    b.a.e.b.b.a(paramh, "combiner is null");
    return b.a.h.a.a(new ej(this, paramArrayOfq, paramh));
  }
  
  public final <U, R> l<R> zipWith(q<? extends U> paramq, b.a.d.c<? super T, ? super U, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramq, "other is null");
    return zip(this, paramq, paramc);
  }
  
  public final <U, R> l<R> zipWith(q<? extends U> paramq, b.a.d.c<? super T, ? super U, ? extends R> paramc, boolean paramBoolean)
  {
    return zip(this, paramq, paramc, paramBoolean);
  }
  
  public final <U, R> l<R> zipWith(q<? extends U> paramq, b.a.d.c<? super T, ? super U, ? extends R> paramc, boolean paramBoolean, int paramInt)
  {
    return zip(this, paramq, paramc, paramBoolean, paramInt);
  }
  
  public final <U, R> l<R> zipWith(Iterable<U> paramIterable, b.a.d.c<? super T, ? super U, ? extends R> paramc)
  {
    b.a.e.b.b.a(paramIterable, "other is null");
    b.a.e.b.b.a(paramc, "zipper is null");
    return b.a.h.a.a(new el(this, paramIterable, paramc));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */