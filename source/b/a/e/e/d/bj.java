package b.a.e.e.d;

import b.a.d.h;
import b.a.e.j.j;
import b.a.l;
import b.a.q;
import b.a.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bj<TLeft, TRight, TLeftEnd, TRightEnd, R>
  extends a<TLeft, R>
{
  final q<? extends TRight> b;
  final h<? super TLeft, ? extends q<TLeftEnd>> c;
  final h<? super TRight, ? extends q<TRightEnd>> d;
  final b.a.d.c<? super TLeft, ? super l<TRight>, ? extends R> e;
  
  public bj(q<TLeft> paramq, q<? extends TRight> paramq1, h<? super TLeft, ? extends q<TLeftEnd>> paramh, h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super TLeft, ? super l<TRight>, ? extends R> paramc)
  {
    super(paramq);
    this.b = paramq1;
    this.c = paramh;
    this.d = paramh1;
    this.e = paramc;
  }
  
  protected void subscribeActual(s<? super R> params)
  {
    a locala = new a(params, this.c, this.d, this.e);
    params.onSubscribe(locala);
    params = new d(locala, true);
    locala.disposables.a(params);
    d locald = new d(locala, false);
    locala.disposables.a(locald);
    this.a.subscribe(params);
    this.b.subscribe(locald);
  }
  
  static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R>
    extends AtomicInteger
    implements b.a.b.b, bj.b
  {
    static final Integer LEFT_CLOSE = Integer.valueOf(3);
    static final Integer LEFT_VALUE = Integer.valueOf(1);
    static final Integer RIGHT_CLOSE = Integer.valueOf(4);
    static final Integer RIGHT_VALUE = Integer.valueOf(2);
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    final s<? super R> actual;
    volatile boolean cancelled;
    final b.a.b.a disposables;
    final AtomicReference<Throwable> error;
    final h<? super TLeft, ? extends q<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, b.a.j.d<TRight>> lefts;
    final b.a.e.f.c<Object> queue;
    final b.a.d.c<? super TLeft, ? super l<TRight>, ? extends R> resultSelector;
    final h<? super TRight, ? extends q<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;
    
    a(s<? super R> params, h<? super TLeft, ? extends q<TLeftEnd>> paramh, h<? super TRight, ? extends q<TRightEnd>> paramh1, b.a.d.c<? super TLeft, ? super l<TRight>, ? extends R> paramc)
    {
      this.actual = params;
      this.disposables = new b.a.b.a();
      this.queue = new b.a.e.f.c(l.bufferSize());
      this.lefts = new LinkedHashMap();
      this.rights = new LinkedHashMap();
      this.error = new AtomicReference();
      this.leftEnd = paramh;
      this.rightEnd = paramh1;
      this.resultSelector = paramc;
      this.active = new AtomicInteger(2);
    }
    
    void cancelAll()
    {
      this.disposables.dispose();
    }
    
    public void dispose()
    {
      if (this.cancelled) {
        return;
      }
      this.cancelled = true;
      cancelAll();
      if (getAndIncrement() == 0) {
        this.queue.clear();
      }
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 127	b/a/e/e/d/bj$a:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 93	b/a/e/e/d/bj$a:queue	Lb/a/e/f/c;
      //   12: astore 5
      //   14: aload_0
      //   15: getfield 75	b/a/e/e/d/bj$a:actual	Lb/a/s;
      //   18: astore 4
      //   20: iconst_1
      //   21: istore_1
      //   22: aload_0
      //   23: getfield 122	b/a/e/e/d/bj$a:cancelled	Z
      //   26: ifeq +9 -> 35
      //   29: aload 5
      //   31: invokevirtual 130	b/a/e/f/c:clear	()V
      //   34: return
      //   35: aload_0
      //   36: getfield 105	b/a/e/e/d/bj$a:error	Ljava/util/concurrent/atomic/AtomicReference;
      //   39: invokevirtual 137	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   42: checkcast 133	java/lang/Throwable
      //   45: ifnull +19 -> 64
      //   48: aload 5
      //   50: invokevirtual 130	b/a/e/f/c:clear	()V
      //   53: aload_0
      //   54: invokevirtual 124	b/a/e/e/d/bj$a:cancelAll	()V
      //   57: aload_0
      //   58: aload 4
      //   60: invokevirtual 141	b/a/e/e/d/bj$a:errorAll	(Lb/a/s;)V
      //   63: return
      //   64: aload_0
      //   65: getfield 114	b/a/e/e/d/bj$a:active	Ljava/util/concurrent/atomic/AtomicInteger;
      //   68: invokevirtual 143	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   71: ifne +8 -> 79
      //   74: iconst_1
      //   75: istore_2
      //   76: goto +5 -> 81
      //   79: iconst_0
      //   80: istore_2
      //   81: aload 5
      //   83: invokevirtual 146	b/a/e/f/c:poll	()Ljava/lang/Object;
      //   86: checkcast 56	java/lang/Integer
      //   89: astore 7
      //   91: aload 7
      //   93: ifnonnull +8 -> 101
      //   96: iconst_1
      //   97: istore_3
      //   98: goto +5 -> 103
      //   101: iconst_0
      //   102: istore_3
      //   103: iload_2
      //   104: ifeq +82 -> 186
      //   107: iload_3
      //   108: ifeq +78 -> 186
      //   111: aload_0
      //   112: getfield 98	b/a/e/e/d/bj$a:lefts	Ljava/util/Map;
      //   115: invokeinterface 152 1 0
      //   120: invokeinterface 158 1 0
      //   125: astore 5
      //   127: aload 5
      //   129: invokeinterface 164 1 0
      //   134: ifeq +19 -> 153
      //   137: aload 5
      //   139: invokeinterface 167 1 0
      //   144: checkcast 169	b/a/j/d
      //   147: invokevirtual 172	b/a/j/d:onComplete	()V
      //   150: goto -23 -> 127
      //   153: aload_0
      //   154: getfield 98	b/a/e/e/d/bj$a:lefts	Ljava/util/Map;
      //   157: invokeinterface 173 1 0
      //   162: aload_0
      //   163: getfield 100	b/a/e/e/d/bj$a:rights	Ljava/util/Map;
      //   166: invokeinterface 173 1 0
      //   171: aload_0
      //   172: getfield 80	b/a/e/e/d/bj$a:disposables	Lb/a/b/a;
      //   175: invokevirtual 120	b/a/b/a:dispose	()V
      //   178: aload 4
      //   180: invokeinterface 176 1 0
      //   185: return
      //   186: iload_3
      //   187: ifeq +17 -> 204
      //   190: aload_0
      //   191: iload_1
      //   192: ineg
      //   193: invokevirtual 180	b/a/e/e/d/bj$a:addAndGet	(I)I
      //   196: istore_2
      //   197: iload_2
      //   198: istore_1
      //   199: iload_2
      //   200: ifne -178 -> 22
      //   203: return
      //   204: aload 5
      //   206: invokevirtual 146	b/a/e/f/c:poll	()Ljava/lang/Object;
      //   209: astore 6
      //   211: aload 7
      //   213: getstatic 62	b/a/e/e/d/bj$a:LEFT_VALUE	Ljava/lang/Integer;
      //   216: if_acmpne +213 -> 429
      //   219: invokestatic 183	b/a/j/d:a	()Lb/a/j/d;
      //   222: astore 7
      //   224: aload_0
      //   225: getfield 185	b/a/e/e/d/bj$a:leftIndex	I
      //   228: istore_2
      //   229: aload_0
      //   230: iload_2
      //   231: iconst_1
      //   232: iadd
      //   233: putfield 185	b/a/e/e/d/bj$a:leftIndex	I
      //   236: aload_0
      //   237: getfield 98	b/a/e/e/d/bj$a:lefts	Ljava/util/Map;
      //   240: iload_2
      //   241: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   244: aload 7
      //   246: invokeinterface 189 3 0
      //   251: pop
      //   252: aload_0
      //   253: getfield 107	b/a/e/e/d/bj$a:leftEnd	Lb/a/d/h;
      //   256: aload 6
      //   258: invokeinterface 195 2 0
      //   263: ldc -59
      //   265: invokestatic 202	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   268: checkcast 204	b/a/q
      //   271: astore 8
      //   273: new 206	b/a/e/e/d/bj$c
      //   276: dup
      //   277: aload_0
      //   278: iconst_1
      //   279: iload_2
      //   280: invokespecial 209	b/a/e/e/d/bj$c:<init>	(Lb/a/e/e/d/bj$b;ZI)V
      //   283: astore 9
      //   285: aload_0
      //   286: getfield 80	b/a/e/e/d/bj$a:disposables	Lb/a/b/a;
      //   289: aload 9
      //   291: invokevirtual 212	b/a/b/a:a	(Lb/a/b/b;)Z
      //   294: pop
      //   295: aload 8
      //   297: aload 9
      //   299: invokeinterface 215 2 0
      //   304: aload_0
      //   305: getfield 105	b/a/e/e/d/bj$a:error	Ljava/util/concurrent/atomic/AtomicReference;
      //   308: invokevirtual 137	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   311: checkcast 133	java/lang/Throwable
      //   314: ifnull +19 -> 333
      //   317: aload 5
      //   319: invokevirtual 130	b/a/e/f/c:clear	()V
      //   322: aload_0
      //   323: invokevirtual 124	b/a/e/e/d/bj$a:cancelAll	()V
      //   326: aload_0
      //   327: aload 4
      //   329: invokevirtual 141	b/a/e/e/d/bj$a:errorAll	(Lb/a/s;)V
      //   332: return
      //   333: aload_0
      //   334: getfield 111	b/a/e/e/d/bj$a:resultSelector	Lb/a/d/c;
      //   337: aload 6
      //   339: aload 7
      //   341: invokeinterface 219 3 0
      //   346: ldc -35
      //   348: invokestatic 202	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   351: astore 6
      //   353: aload 4
      //   355: aload 6
      //   357: invokeinterface 225 2 0
      //   362: aload_0
      //   363: getfield 100	b/a/e/e/d/bj$a:rights	Ljava/util/Map;
      //   366: invokeinterface 152 1 0
      //   371: invokeinterface 158 1 0
      //   376: astore 6
      //   378: aload 6
      //   380: invokeinterface 164 1 0
      //   385: ifeq -363 -> 22
      //   388: aload 7
      //   390: aload 6
      //   392: invokeinterface 167 1 0
      //   397: invokevirtual 226	b/a/j/d:onNext	(Ljava/lang/Object;)V
      //   400: goto -22 -> 378
      //   403: astore 6
      //   405: aload_0
      //   406: aload 6
      //   408: aload 4
      //   410: aload 5
      //   412: invokevirtual 230	b/a/e/e/d/bj$a:fail	(Ljava/lang/Throwable;Lb/a/s;Lb/a/e/f/c;)V
      //   415: return
      //   416: astore 6
      //   418: aload_0
      //   419: aload 6
      //   421: aload 4
      //   423: aload 5
      //   425: invokevirtual 230	b/a/e/e/d/bj$a:fail	(Ljava/lang/Throwable;Lb/a/s;Lb/a/e/f/c;)V
      //   428: return
      //   429: aload 7
      //   431: getstatic 64	b/a/e/e/d/bj$a:RIGHT_VALUE	Ljava/lang/Integer;
      //   434: if_acmpne +169 -> 603
      //   437: aload_0
      //   438: getfield 232	b/a/e/e/d/bj$a:rightIndex	I
      //   441: istore_2
      //   442: aload_0
      //   443: iload_2
      //   444: iconst_1
      //   445: iadd
      //   446: putfield 232	b/a/e/e/d/bj$a:rightIndex	I
      //   449: aload_0
      //   450: getfield 100	b/a/e/e/d/bj$a:rights	Ljava/util/Map;
      //   453: iload_2
      //   454: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   457: aload 6
      //   459: invokeinterface 189 3 0
      //   464: pop
      //   465: aload_0
      //   466: getfield 109	b/a/e/e/d/bj$a:rightEnd	Lb/a/d/h;
      //   469: aload 6
      //   471: invokeinterface 195 2 0
      //   476: ldc -22
      //   478: invokestatic 202	b/a/e/b/b:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   481: checkcast 204	b/a/q
      //   484: astore 7
      //   486: new 206	b/a/e/e/d/bj$c
      //   489: dup
      //   490: aload_0
      //   491: iconst_0
      //   492: iload_2
      //   493: invokespecial 209	b/a/e/e/d/bj$c:<init>	(Lb/a/e/e/d/bj$b;ZI)V
      //   496: astore 8
      //   498: aload_0
      //   499: getfield 80	b/a/e/e/d/bj$a:disposables	Lb/a/b/a;
      //   502: aload 8
      //   504: invokevirtual 212	b/a/b/a:a	(Lb/a/b/b;)Z
      //   507: pop
      //   508: aload 7
      //   510: aload 8
      //   512: invokeinterface 215 2 0
      //   517: aload_0
      //   518: getfield 105	b/a/e/e/d/bj$a:error	Ljava/util/concurrent/atomic/AtomicReference;
      //   521: invokevirtual 137	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   524: checkcast 133	java/lang/Throwable
      //   527: ifnull +19 -> 546
      //   530: aload 5
      //   532: invokevirtual 130	b/a/e/f/c:clear	()V
      //   535: aload_0
      //   536: invokevirtual 124	b/a/e/e/d/bj$a:cancelAll	()V
      //   539: aload_0
      //   540: aload 4
      //   542: invokevirtual 141	b/a/e/e/d/bj$a:errorAll	(Lb/a/s;)V
      //   545: return
      //   546: aload_0
      //   547: getfield 98	b/a/e/e/d/bj$a:lefts	Ljava/util/Map;
      //   550: invokeinterface 152 1 0
      //   555: invokeinterface 158 1 0
      //   560: astore 7
      //   562: aload 7
      //   564: invokeinterface 164 1 0
      //   569: ifeq -547 -> 22
      //   572: aload 7
      //   574: invokeinterface 167 1 0
      //   579: checkcast 169	b/a/j/d
      //   582: aload 6
      //   584: invokevirtual 226	b/a/j/d:onNext	(Ljava/lang/Object;)V
      //   587: goto -25 -> 562
      //   590: astore 6
      //   592: aload_0
      //   593: aload 6
      //   595: aload 4
      //   597: aload 5
      //   599: invokevirtual 230	b/a/e/e/d/bj$a:fail	(Ljava/lang/Throwable;Lb/a/s;Lb/a/e/f/c;)V
      //   602: return
      //   603: aload 7
      //   605: getstatic 66	b/a/e/e/d/bj$a:LEFT_CLOSE	Ljava/lang/Integer;
      //   608: if_acmpne +55 -> 663
      //   611: aload 6
      //   613: checkcast 206	b/a/e/e/d/bj$c
      //   616: astore 6
      //   618: aload_0
      //   619: getfield 98	b/a/e/e/d/bj$a:lefts	Ljava/util/Map;
      //   622: aload 6
      //   624: getfield 237	b/a/e/e/d/bj$c:index	I
      //   627: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   630: invokeinterface 240 2 0
      //   635: checkcast 169	b/a/j/d
      //   638: astore 7
      //   640: aload_0
      //   641: getfield 80	b/a/e/e/d/bj$a:disposables	Lb/a/b/a;
      //   644: aload 6
      //   646: invokevirtual 243	b/a/b/a:b	(Lb/a/b/b;)Z
      //   649: pop
      //   650: aload 7
      //   652: ifnull -630 -> 22
      //   655: aload 7
      //   657: invokevirtual 172	b/a/j/d:onComplete	()V
      //   660: goto -638 -> 22
      //   663: aload 7
      //   665: getstatic 68	b/a/e/e/d/bj$a:RIGHT_CLOSE	Ljava/lang/Integer;
      //   668: if_acmpne -646 -> 22
      //   671: aload 6
      //   673: checkcast 206	b/a/e/e/d/bj$c
      //   676: astore 6
      //   678: aload_0
      //   679: getfield 100	b/a/e/e/d/bj$a:rights	Ljava/util/Map;
      //   682: aload 6
      //   684: getfield 237	b/a/e/e/d/bj$c:index	I
      //   687: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   690: invokeinterface 240 2 0
      //   695: pop
      //   696: aload_0
      //   697: getfield 80	b/a/e/e/d/bj$a:disposables	Lb/a/b/a;
      //   700: aload 6
      //   702: invokevirtual 243	b/a/b/a:b	(Lb/a/b/b;)Z
      //   705: pop
      //   706: goto -684 -> 22
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	709	0	this	a
      //   21	178	1	i	int
      //   75	418	2	j	int
      //   97	90	3	k	int
      //   18	578	4	locals	s
      //   12	586	5	localObject1	Object
      //   209	182	6	localObject2	Object
      //   403	4	6	localThrowable1	Throwable
      //   416	167	6	localThrowable2	Throwable
      //   590	22	6	localThrowable3	Throwable
      //   616	85	6	localc1	bj.c
      //   89	575	7	localObject3	Object
      //   271	240	8	localObject4	Object
      //   283	15	9	localc2	bj.c
      // Exception table:
      //   from	to	target	type
      //   333	353	403	java/lang/Throwable
      //   252	273	416	java/lang/Throwable
      //   465	486	590	java/lang/Throwable
    }
    
    void errorAll(s<?> params)
    {
      Throwable localThrowable = j.a(this.error);
      Iterator localIterator = this.lefts.values().iterator();
      while (localIterator.hasNext()) {
        ((b.a.j.d)localIterator.next()).onError(localThrowable);
      }
      this.lefts.clear();
      this.rights.clear();
      params.onError(localThrowable);
    }
    
    void fail(Throwable paramThrowable, s<?> params, b.a.e.f.c<?> paramc)
    {
      b.a.c.b.b(paramThrowable);
      j.a(this.error, paramThrowable);
      paramc.clear();
      cancelAll();
      errorAll(params);
    }
    
    public void innerClose(boolean paramBoolean, bj.c paramc)
    {
      try
      {
        b.a.e.f.c localc = this.queue;
        Integer localInteger;
        if (paramBoolean) {
          localInteger = LEFT_CLOSE;
        } else {
          localInteger = RIGHT_CLOSE;
        }
        localc.a(localInteger, paramc);
        drain();
        return;
      }
      finally {}
    }
    
    public void innerCloseError(Throwable paramThrowable)
    {
      if (j.a(this.error, paramThrowable))
      {
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void innerComplete(bj.d paramd)
    {
      this.disposables.c(paramd);
      this.active.decrementAndGet();
      drain();
    }
    
    public void innerError(Throwable paramThrowable)
    {
      if (j.a(this.error, paramThrowable))
      {
        this.active.decrementAndGet();
        drain();
        return;
      }
      b.a.h.a.a(paramThrowable);
    }
    
    public void innerValue(boolean paramBoolean, Object paramObject)
    {
      try
      {
        b.a.e.f.c localc = this.queue;
        Integer localInteger;
        if (paramBoolean) {
          localInteger = LEFT_VALUE;
        } else {
          localInteger = RIGHT_VALUE;
        }
        localc.a(localInteger, paramObject);
        drain();
        return;
      }
      finally {}
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
  }
  
  static abstract interface b
  {
    public abstract void innerClose(boolean paramBoolean, bj.c paramc);
    
    public abstract void innerCloseError(Throwable paramThrowable);
    
    public abstract void innerComplete(bj.d paramd);
    
    public abstract void innerError(Throwable paramThrowable);
    
    public abstract void innerValue(boolean paramBoolean, Object paramObject);
  }
  
  static final class c
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<Object>
  {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final bj.b parent;
    
    c(bj.b paramb, boolean paramBoolean, int paramInt)
    {
      this.parent = paramb;
      this.isLeft = paramBoolean;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      b.a.e.a.d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return b.a.e.a.d.isDisposed((b.a.b.b)get());
    }
    
    public void onComplete()
    {
      this.parent.innerClose(this.isLeft, this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerCloseError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      if (b.a.e.a.d.dispose(this)) {
        this.parent.innerClose(this.isLeft, this);
      }
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      b.a.e.a.d.setOnce(this, paramb);
    }
  }
  
  static final class d
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b, s<Object>
  {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final bj.b parent;
    
    d(bj.b paramb, boolean paramBoolean)
    {
      this.parent = paramb;
      this.isLeft = paramBoolean;
    }
    
    public void dispose()
    {
      b.a.e.a.d.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return b.a.e.a.d.isDisposed((b.a.b.b)get());
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.parent.innerValue(this.isLeft, paramObject);
    }
    
    public void onSubscribe(b.a.b.b paramb)
    {
      b.a.e.a.d.setOnce(this, paramb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */