package e.a.e;

import f.d;
import f.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g
  implements Closeable
{
  private static final ExecutorService s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), e.a.c.a("OkHttp Http2Connection", true));
  final boolean a;
  final b b;
  final Map<Integer, i> c = new LinkedHashMap();
  final String d;
  int e;
  int f;
  boolean g;
  final l h;
  long i = 0L;
  long j;
  m k = new m();
  final m l = new m();
  boolean m = false;
  final Socket n;
  final j o;
  final d p;
  final Set<Integer> q = new LinkedHashSet();
  private final ScheduledExecutorService t;
  private final ExecutorService u;
  private boolean v;
  
  g(a parama)
  {
    this.h = parama.f;
    this.a = parama.g;
    this.b = parama.e;
    int i1;
    if (parama.g) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.f = i1;
    if (parama.g) {
      this.f += 2;
    }
    if (parama.g) {
      this.k.a(7, 16777216);
    }
    this.d = parama.b;
    this.t = new ScheduledThreadPoolExecutor(1, e.a.c.a(e.a.c.a("OkHttp %s Writer", new Object[] { this.d }), false));
    if (parama.h != 0) {
      this.t.scheduleAtFixedRate(new c(false, 0, 0), parama.h, parama.h, TimeUnit.MILLISECONDS);
    }
    this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.a.c.a(e.a.c.a("OkHttp %s Push Observer", new Object[] { this.d }), true));
    this.l.a(7, 65535);
    this.l.a(5, 16384);
    this.j = this.l.d();
    this.n = parama.a;
    this.o = new j(parama.d, this.a);
    this.p = new d(new h(parama.c, this.a));
  }
  
  private void a(e.a.b paramb)
  {
    try
    {
      if (!d()) {
        this.u.execute(paramb);
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private i b(int paramInt, List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.o)
      {
        try
        {
          if (this.f > 1073741823) {
            a(b.REFUSED_STREAM);
          }
          if (!this.g)
          {
            int i2 = this.f;
            this.f += 2;
            i locali = new i(i2, this, bool, false, null);
            if ((!paramBoolean) || (this.j == 0L)) {
              break label216;
            }
            if (locali.b == 0L)
            {
              break label216;
              if (locali.b()) {
                this.c.put(Integer.valueOf(i2), locali);
              }
              if (paramInt == 0)
              {
                this.o.a(bool, i2, paramInt, paramList);
              }
              else
              {
                if (this.a) {
                  continue;
                }
                this.o.a(paramInt, i2, paramList);
              }
              if (i1 != 0) {
                this.o.b();
              }
              return locali;
              throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
          }
          else
          {
            throw new a();
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label216:
      i1 = 1;
    }
  }
  
  private void f()
  {
    try
    {
      a(b.PROTOCOL_ERROR, b.PROTOCOL_ERROR);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public int a()
  {
    try
    {
      int i1 = this.l.c(Integer.MAX_VALUE);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  i a(int paramInt)
  {
    try
    {
      i locali = (i)this.c.get(Integer.valueOf(paramInt));
      return locali;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public i a(List<c> paramList, boolean paramBoolean)
    throws IOException
  {
    return b(0, paramList, paramBoolean);
  }
  
  void a(final int paramInt, final long paramLong)
  {
    try
    {
      this.t.execute(new e.a.b("OkHttp Window Update %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          try
          {
            g.this.o.a(paramInt, paramLong);
            return;
          }
          catch (IOException localIOException)
          {
            for (;;) {}
          }
          g.a(g.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  void a(final int paramInt, final b paramb)
  {
    try
    {
      this.t.execute(new e.a.b("OkHttp %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          try
          {
            g.this.b(paramInt, paramb);
            return;
          }
          catch (IOException localIOException)
          {
            for (;;) {}
          }
          g.a(g.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException paramb) {}
  }
  
  void a(final int paramInt1, e parame, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final f.c localc = new f.c();
    long l1 = paramInt2;
    parame.a(l1);
    parame.read(localc, l1);
    if (localc.a() == l1)
    {
      a(new e.a.b("OkHttp %s Push Data[%s]", new Object[] { this.d, Integer.valueOf(paramInt1) })
      {
        public void c()
        {
          try
          {
            boolean bool = g.this.h.a(paramInt1, localc, paramInt2, paramBoolean);
            if (bool) {
              g.this.o.a(paramInt1, b.CANCEL);
            }
            if ((bool) || (paramBoolean)) {
              synchronized (g.this)
              {
                g.this.q.remove(Integer.valueOf(paramInt1));
                return;
              }
            }
            return;
          }
          catch (IOException localIOException) {}
        }
      });
      return;
    }
    parame = new StringBuilder();
    parame.append(localc.a());
    parame.append(" != ");
    parame.append(paramInt2);
    throw new IOException(parame.toString());
  }
  
  void a(final int paramInt, final List<c> paramList)
  {
    try
    {
      if (this.q.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, b.PROTOCOL_ERROR);
        return;
      }
      this.q.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      try
      {
        a(new e.a.b("OkHttp %s Push Request[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
        {
          public void c()
          {
            if (g.this.h.a(paramInt, paramList)) {}
            try
            {
              g.this.o.a(paramInt, b.CANCEL);
              synchronized (g.this)
              {
                g.this.q.remove(Integer.valueOf(paramInt));
                return;
              }
              return;
            }
            catch (IOException localIOException) {}
          }
        });
        return;
      }
      catch (RejectedExecutionException paramList) {}
      paramList = finally;
    }
  }
  
  void a(final int paramInt, final List<c> paramList, final boolean paramBoolean)
  {
    try
    {
      a(new e.a.b("OkHttp %s Push Headers[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          boolean bool = g.this.h.a(paramInt, paramList, paramBoolean);
          if (bool) {}
          try
          {
            g.this.o.a(paramInt, b.CANCEL);
            if ((bool) || (paramBoolean)) {
              synchronized (g.this)
              {
                g.this.q.remove(Integer.valueOf(paramInt));
                return;
              }
            }
            return;
          }
          catch (IOException localIOException) {}
        }
      });
      return;
    }
    catch (RejectedExecutionException paramList) {}
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean, f.c paramc, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 8
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 209	e/a/e/g:o	Le/a/e/j;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 402	e/a/e/j:a	(ZILf/c;I)V
    //   22: return
    //   23: lload 8
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +161 -> 188
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 195	e/a/e/g:j	J
    //   36: lconst_0
    //   37: lcmp
    //   38: ifgt +37 -> 75
    //   41: aload_0
    //   42: getfield 118	e/a/e/g:c	Ljava/util/Map;
    //   45: iload_1
    //   46: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokeinterface 405 2 0
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: invokevirtual 408	java/lang/Object:wait	()V
    //   61: goto -29 -> 32
    //   64: new 240	java/io/IOException
    //   67: dup
    //   68: ldc_w 410
    //   71: invokespecial 371	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: lload 8
    //   77: aload_0
    //   78: getfield 195	e/a/e/g:j	J
    //   81: invokestatic 416	java/lang/Math:min	(JJ)J
    //   84: l2i
    //   85: aload_0
    //   86: getfield 209	e/a/e/g:o	Le/a/e/j;
    //   89: invokevirtual 418	e/a/e/j:c	()I
    //   92: invokestatic 421	java/lang/Math:min	(II)I
    //   95: istore 6
    //   97: aload_0
    //   98: getfield 195	e/a/e/g:j	J
    //   101: lstore 4
    //   103: iload 6
    //   105: i2l
    //   106: lstore 10
    //   108: aload_0
    //   109: lload 4
    //   111: lload 10
    //   113: lsub
    //   114: putfield 195	e/a/e/g:j	J
    //   117: aload_0
    //   118: monitorexit
    //   119: lload 8
    //   121: lload 10
    //   123: lsub
    //   124: lstore 8
    //   126: aload_0
    //   127: getfield 209	e/a/e/g:o	Le/a/e/j;
    //   130: astore 12
    //   132: iload_2
    //   133: ifeq +16 -> 149
    //   136: lload 8
    //   138: lconst_0
    //   139: lcmp
    //   140: ifne +9 -> 149
    //   143: iconst_1
    //   144: istore 7
    //   146: goto +6 -> 152
    //   149: iconst_0
    //   150: istore 7
    //   152: aload 12
    //   154: iload 7
    //   156: iload_1
    //   157: aload_3
    //   158: iload 6
    //   160: invokevirtual 402	e/a/e/j:a	(ZILf/c;I)V
    //   163: goto -140 -> 23
    //   166: astore_3
    //   167: goto +17 -> 184
    //   170: invokestatic 427	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   173: invokevirtual 430	java/lang/Thread:interrupt	()V
    //   176: new 432	java/io/InterruptedIOException
    //   179: dup
    //   180: invokespecial 433	java/io/InterruptedIOException:<init>	()V
    //   183: athrow
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_3
    //   187: athrow
    //   188: return
    //   189: astore_3
    //   190: goto -20 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	g
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   0	193	3	paramc	f.c
    //   0	193	4	paramLong	long
    //   95	64	6	i1	int
    //   144	11	7	bool	boolean
    //   2	135	8	l1	long
    //   106	16	10	l2	long
    //   130	23	12	localj	j
    // Exception table:
    //   from	to	target	type
    //   32	61	166	finally
    //   64	75	166	finally
    //   75	103	166	finally
    //   108	119	166	finally
    //   170	184	166	finally
    //   184	186	166	finally
    //   32	61	189	java/lang/InterruptedException
    //   64	75	189	java/lang/InterruptedException
  }
  
  void a(long paramLong)
  {
    try
    {
      this.i += paramLong;
      if (this.i >= this.k.d() / 2)
      {
        a(0, this.i);
        this.i = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(b paramb)
    throws IOException
  {
    synchronized (this.o)
    {
      try
      {
        if (this.g) {
          return;
        }
        this.g = true;
        int i1 = this.e;
        this.o.a(i1, paramb, e.a.c.a);
        return;
      }
      finally {}
    }
  }
  
  void a(b paramb1, b paramb2)
    throws IOException
  {
    if ((!r) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    i[] arrayOfi = null;
    try
    {
      a(paramb1);
      paramb1 = null;
    }
    catch (IOException paramb1) {}
    try
    {
      if (!this.c.isEmpty())
      {
        arrayOfi = (i[])this.c.values().toArray(new i[this.c.size()]);
        this.c.clear();
      }
      Object localObject = paramb1;
      if (arrayOfi != null)
      {
        int i2 = arrayOfi.length;
        int i1 = 0;
        for (;;)
        {
          localObject = paramb1;
          if (i1 >= i2) {
            break;
          }
          localObject = arrayOfi[i1];
          try
          {
            ((i)localObject).a(paramb2);
            localObject = paramb1;
          }
          catch (IOException localIOException)
          {
            localObject = paramb1;
            if (paramb1 != null) {
              localObject = localIOException;
            }
          }
          i1 += 1;
          paramb1 = (b)localObject;
        }
      }
      try
      {
        this.o.close();
        paramb1 = (b)localObject;
      }
      catch (IOException paramb2)
      {
        paramb1 = (b)localObject;
        if (localObject == null) {
          paramb1 = paramb2;
        }
      }
      try
      {
        this.n.close();
      }
      catch (IOException paramb1) {}
      this.t.shutdown();
      this.u.shutdown();
      if (paramb1 == null) {
        return;
      }
      throw paramb1;
    }
    finally {}
  }
  
  void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.o.a();
      this.o.b(this.k);
      int i1 = this.k.d();
      if (i1 != 65535) {
        this.o.a(0, i1 - 65535);
      }
    }
    new Thread(this.p).start();
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      try
      {
        boolean bool = this.v;
        this.v = true;
        if (bool)
        {
          f();
          return;
        }
      }
      finally {}
    }
    try
    {
      this.o.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    f();
  }
  
  i b(int paramInt)
  {
    try
    {
      i locali = (i)this.c.remove(Integer.valueOf(paramInt));
      notifyAll();
      return locali;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
    throws IOException
  {
    this.o.b();
  }
  
  void b(int paramInt, b paramb)
    throws IOException
  {
    this.o.a(paramInt, paramb);
  }
  
  public void c()
    throws IOException
  {
    a(true);
  }
  
  void c(final int paramInt, final b paramb)
  {
    a(new e.a.b("OkHttp %s Push Reset[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
    {
      public void c()
      {
        g.this.h.a(paramInt, paramb);
        synchronized (g.this)
        {
          g.this.q.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  boolean c(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public void close()
    throws IOException
  {
    a(b.NO_ERROR, b.CANCEL);
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class a
  {
    Socket a;
    String b;
    e c;
    d d;
    g.b e = g.b.f;
    l f = l.a;
    boolean g;
    int h;
    
    public a(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }
    
    public a a(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
    
    public a a(g.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public a a(Socket paramSocket, String paramString, e parame, d paramd)
    {
      this.a = paramSocket;
      this.b = paramString;
      this.c = parame;
      this.d = paramd;
      return this;
    }
    
    public g a()
    {
      return new g(this);
    }
  }
  
  public static abstract class b
  {
    public static final b f = new b()
    {
      public void a(i paramAnonymousi)
        throws IOException
      {
        paramAnonymousi.a(b.REFUSED_STREAM);
      }
    };
    
    public void a(g paramg) {}
    
    public abstract void a(i parami)
      throws IOException;
  }
  
  final class c
    extends e.a.b
  {
    final boolean a;
    final int b;
    final int d;
    
    c(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      super(new Object[] { g.this.d, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.a = paramBoolean;
      this.b = paramInt1;
      this.d = paramInt2;
    }
    
    public void c()
    {
      g.this.a(this.a, this.b, this.d);
    }
  }
  
  class d
    extends e.a.b
    implements h.b
  {
    final h a;
    
    d(h paramh)
    {
      super(new Object[] { g.this.d });
      this.a = paramh;
    }
    
    private void a(final m paramm)
    {
      try
      {
        g.b(g.this).execute(new e.a.b("OkHttp %s ACK Settings", new Object[] { g.this.d })
        {
          public void c()
          {
            try
            {
              g.this.o.a(paramm);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;) {}
            }
            g.a(g.this);
          }
        });
        return;
      }
      catch (RejectedExecutionException paramm) {}
    }
    
    public void a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void a(int paramInt1, int paramInt2, List<c> paramList)
    {
      g.this.a(paramInt2, paramList);
    }
    
    public void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (g.this)
        {
          g localg = g.this;
          localg.j += paramLong;
          g.this.notifyAll();
          return;
        }
      }
      ??? = g.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((i)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public void a(int paramInt, b paramb)
    {
      if (g.this.c(paramInt))
      {
        g.this.c(paramInt, paramb);
        return;
      }
      i locali = g.this.b(paramInt);
      if (locali != null) {
        locali.c(paramb);
      }
    }
    
    public void a(int paramInt, b arg2, f.f paramf)
    {
      paramf.size();
      synchronized (g.this)
      {
        paramf = (i[])g.this.c.values().toArray(new i[g.this.c.size()]);
        g.this.g = true;
        int j = paramf.length;
        int i = 0;
        while (i < j)
        {
          ??? = paramf[i];
          if ((???.a() > paramInt) && (???.c()))
          {
            ???.c(b.REFUSED_STREAM);
            g.this.b(???.a());
          }
          i += 1;
        }
        return;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean) {
        synchronized (g.this)
        {
          g.a(g.this, false);
          g.this.notifyAll();
          return;
        }
      }
      try
      {
        g.b(g.this).execute(new g.c(g.this, true, paramInt1, paramInt2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException) {}
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, final List<c> paramList)
    {
      if (g.this.c(paramInt1))
      {
        g.this.a(paramInt1, paramList, paramBoolean);
        return;
      }
      synchronized (g.this)
      {
        i locali = g.this.a(paramInt1);
        if (locali == null)
        {
          if (g.this.g) {
            return;
          }
          if (paramInt1 <= g.this.e) {
            return;
          }
          if (paramInt1 % 2 == g.this.f % 2) {
            return;
          }
          paramList = e.a.c.b(paramList);
          paramList = new i(paramInt1, g.this, false, paramBoolean, paramList);
          g.this.e = paramInt1;
          g.this.c.put(Integer.valueOf(paramInt1), paramList);
          g.e().execute(new e.a.b("OkHttp %s stream %d", new Object[] { g.this.d, Integer.valueOf(paramInt1) })
          {
            public void c()
            {
              try
              {
                g.this.b.a(paramList);
                return;
              }
              catch (IOException localIOException1)
              {
                e.a.g.f localf = e.a.g.f.c();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Http2Connection.Listener failure for ");
                localStringBuilder.append(g.this.d);
                localf.a(4, localStringBuilder.toString(), localIOException1);
                try
                {
                  paramList.a(b.PROTOCOL_ERROR);
                  return;
                }
                catch (IOException localIOException2) {}
              }
            }
          });
          return;
        }
        locali.a(paramList);
        if (paramBoolean) {
          locali.i();
        }
        return;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, e parame, int paramInt2)
      throws IOException
    {
      if (g.this.c(paramInt1))
      {
        g.this.a(paramInt1, parame, paramInt2, paramBoolean);
        return;
      }
      Object localObject = g.this.a(paramInt1);
      if (localObject == null)
      {
        g.this.a(paramInt1, b.PROTOCOL_ERROR);
        localObject = g.this;
        long l = paramInt2;
        ((g)localObject).a(l);
        parame.i(l);
        return;
      }
      ((i)localObject).a(parame, paramInt2);
      if (paramBoolean) {
        ((i)localObject).i();
      }
    }
    
    public void a(boolean paramBoolean, m paramm)
    {
      for (;;)
      {
        synchronized (g.this)
        {
          int i = g.this.l.d();
          if (paramBoolean) {
            g.this.l.a();
          }
          g.this.l.a(paramm);
          a(paramm);
          int j = g.this.l.d();
          paramm = null;
          if ((j != -1) && (j != i))
          {
            long l2 = j - i;
            if (!g.this.m) {
              g.this.m = true;
            }
            l1 = l2;
            if (!g.this.c.isEmpty())
            {
              paramm = (i[])g.this.c.values().toArray(new i[g.this.c.size()]);
              l1 = l2;
            }
            ExecutorService localExecutorService = g.e();
            String str = g.this.d;
            i = 0;
            localExecutorService.execute(new e.a.b("OkHttp %s settings", new Object[] { str })
            {
              public void c()
              {
                g.this.b.a(g.this);
              }
            });
            if ((paramm != null) && (l1 != 0L))
            {
              j = paramm.length;
              if (i < j) {
                synchronized (paramm[i])
                {
                  ???.a(l1);
                  i += 1;
                }
              }
            }
            return;
          }
        }
        long l1 = 0L;
      }
    }
    
    /* Error */
    protected void c()
    {
      // Byte code:
      //   0: getstatic 233	e/a/e/b:INTERNAL_ERROR	Le/a/e/b;
      //   3: astore_3
      //   4: getstatic 233	e/a/e/b:INTERNAL_ERROR	Le/a/e/b;
      //   7: astore 5
      //   9: aload_3
      //   10: astore_2
      //   11: aload_0
      //   12: getfield 35	e/a/e/g$d:a	Le/a/e/h;
      //   15: aload_0
      //   16: invokevirtual 238	e/a/e/h:a	(Le/a/e/h$b;)V
      //   19: aload_3
      //   20: astore_2
      //   21: aload_0
      //   22: getfield 35	e/a/e/g$d:a	Le/a/e/h;
      //   25: iconst_0
      //   26: aload_0
      //   27: invokevirtual 241	e/a/e/h:a	(ZLe/a/e/h$b;)Z
      //   30: ifeq +6 -> 36
      //   33: goto -14 -> 19
      //   36: aload_3
      //   37: astore_2
      //   38: getstatic 244	e/a/e/b:NO_ERROR	Le/a/e/b;
      //   41: astore_1
      //   42: aload_1
      //   43: astore_2
      //   44: getstatic 247	e/a/e/b:CANCEL	Le/a/e/b;
      //   47: astore_3
      //   48: aload_0
      //   49: getfield 23	e/a/e/g$d:b	Le/a/e/g;
      //   52: astore 4
      //   54: aload_3
      //   55: astore_2
      //   56: aload 4
      //   58: astore_3
      //   59: goto +31 -> 90
      //   62: aload_1
      //   63: astore_2
      //   64: goto +7 -> 71
      //   67: astore_1
      //   68: goto +37 -> 105
      //   71: getstatic 194	e/a/e/b:PROTOCOL_ERROR	Le/a/e/b;
      //   74: astore_1
      //   75: aload_1
      //   76: astore_2
      //   77: getstatic 194	e/a/e/b:PROTOCOL_ERROR	Le/a/e/b;
      //   80: astore 4
      //   82: aload_0
      //   83: getfield 23	e/a/e/g$d:b	Le/a/e/g;
      //   86: astore_3
      //   87: aload 4
      //   89: astore_2
      //   90: aload_3
      //   91: aload_1
      //   92: aload_2
      //   93: invokevirtual 250	e/a/e/g:a	(Le/a/e/b;Le/a/e/b;)V
      //   96: aload_0
      //   97: getfield 35	e/a/e/g$d:a	Le/a/e/h;
      //   100: invokestatic 253	e/a/c:a	(Ljava/io/Closeable;)V
      //   103: return
      //   104: astore_1
      //   105: aload_0
      //   106: getfield 23	e/a/e/g$d:b	Le/a/e/g;
      //   109: aload_2
      //   110: aload 5
      //   112: invokevirtual 250	e/a/e/g:a	(Le/a/e/b;Le/a/e/b;)V
      //   115: aload_0
      //   116: getfield 35	e/a/e/g$d:a	Le/a/e/h;
      //   119: invokestatic 253	e/a/c:a	(Ljava/io/Closeable;)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_3
      //   126: astore_2
      //   127: goto -56 -> 71
      //   130: astore_2
      //   131: goto -69 -> 62
      //   134: astore_1
      //   135: goto -39 -> 96
      //   138: astore_2
      //   139: goto -24 -> 115
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	this	d
      //   41	22	1	localb1	b
      //   67	1	1	localObject1	Object
      //   74	18	1	localb2	b
      //   104	19	1	localObject2	Object
      //   124	1	1	localIOException1	IOException
      //   134	1	1	localIOException2	IOException
      //   10	117	2	localObject3	Object
      //   130	1	2	localIOException3	IOException
      //   138	1	2	localIOException4	IOException
      //   3	123	3	localObject4	Object
      //   52	36	4	localObject5	Object
      //   7	104	5	localb3	b
      // Exception table:
      //   from	to	target	type
      //   11	19	67	finally
      //   21	33	67	finally
      //   38	42	67	finally
      //   71	75	67	finally
      //   44	48	104	finally
      //   77	82	104	finally
      //   11	19	124	java/io/IOException
      //   21	33	124	java/io/IOException
      //   38	42	124	java/io/IOException
      //   44	48	130	java/io/IOException
      //   48	54	134	java/io/IOException
      //   82	87	134	java/io/IOException
      //   90	96	134	java/io/IOException
      //   105	115	138	java/io/IOException
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */