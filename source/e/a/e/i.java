package e.a.e;

import f.a;
import f.e;
import f.r;
import f.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public final class i
{
  long a = 0L;
  long b;
  final int c;
  final g d;
  final a e;
  final c f = new c();
  final c g = new c();
  b h = null;
  private final Deque<e.s> j = new ArrayDeque();
  private c.a k;
  private boolean l;
  private final b m;
  
  i(int paramInt, g paramg, boolean paramBoolean1, boolean paramBoolean2, @Nullable e.s params)
  {
    if (paramg != null)
    {
      this.c = paramInt;
      this.d = paramg;
      this.b = paramg.l.d();
      this.m = new b(paramg.k.d());
      this.e = new a();
      this.m.b = paramBoolean2;
      this.e.b = paramBoolean1;
      if (params != null) {
        this.j.add(params);
      }
      if ((c()) && (params != null)) {
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
      }
      if (!c())
      {
        if (params != null) {
          return;
        }
        throw new IllegalStateException("remotely-initiated streams should have headers");
      }
      return;
    }
    throw new NullPointerException("connection == null");
  }
  
  private boolean d(b paramb)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.h != null) {
        return false;
      }
      if ((this.m.b) && (this.e.b)) {
        return false;
      }
      this.h = paramb;
      notifyAll();
      this.d.b(this.c);
      return true;
    }
    finally {}
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void a(b paramb)
    throws IOException
  {
    if (!d(paramb)) {
      return;
    }
    this.d.b(this.c, paramb);
  }
  
  void a(e parame, int paramInt)
    throws IOException
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.m.a(parame, paramInt);
  }
  
  void a(List<c> paramList)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.l = true;
      this.j.add(e.a.c.b(paramList));
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  public void b(b paramb)
  {
    if (!d(paramb)) {
      return;
    }
    this.d.a(this.c, paramb);
  }
  
  public boolean b()
  {
    try
    {
      b localb = this.h;
      if (localb != null) {
        return false;
      }
      if (((this.m.b) || (this.m.a)) && ((this.e.b) || (this.e.a)))
      {
        boolean bool = this.l;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  void c(b paramb)
  {
    try
    {
      if (this.h == null)
      {
        this.h = paramb;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public boolean c()
  {
    int n;
    if ((this.c & 0x1) == 1) {
      n = 1;
    } else {
      n = 0;
    }
    return this.d.a == n;
  }
  
  /* Error */
  public e.s d()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	e/a/e/i:f	Le/a/e/i$c;
    //   6: invokevirtual 172	e/a/e/i$c:c	()V
    //   9: aload_0
    //   10: getfield 57	e/a/e/i:j	Ljava/util/Deque;
    //   13: invokeinterface 175 1 0
    //   18: ifeq +17 -> 35
    //   21: aload_0
    //   22: getfield 66	e/a/e/i:h	Le/a/e/b;
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: invokevirtual 177	e/a/e/i:l	()V
    //   32: goto -23 -> 9
    //   35: aload_0
    //   36: getfield 62	e/a/e/i:f	Le/a/e/i$c;
    //   39: invokevirtual 179	e/a/e/i$c:b	()V
    //   42: aload_0
    //   43: getfield 57	e/a/e/i:j	Ljava/util/Deque;
    //   46: invokeinterface 175 1 0
    //   51: ifne +20 -> 71
    //   54: aload_0
    //   55: getfield 57	e/a/e/i:j	Ljava/util/Deque;
    //   58: invokeinterface 183 1 0
    //   63: checkcast 185	e/s
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: new 187	e/a/e/n
    //   74: dup
    //   75: aload_0
    //   76: getfield 66	e/a/e/i:h	Le/a/e/b;
    //   79: invokespecial 189	e/a/e/n:<init>	(Le/a/e/b;)V
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 62	e/a/e/i:f	Le/a/e/i$c;
    //   88: invokevirtual 179	e/a/e/i$c:b	()V
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	i
    //   66	4	1	locals	e.s
    //   83	9	1	localObject1	Object
    //   93	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	32	83	finally
    //   2	9	93	finally
    //   35	67	93	finally
    //   71	83	93	finally
    //   84	93	93	finally
  }
  
  public t e()
  {
    return this.f;
  }
  
  public t f()
  {
    return this.g;
  }
  
  public f.s g()
  {
    return this.m;
  }
  
  public r h()
  {
    try
    {
      if ((!this.l) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
      return this.e;
    }
    finally {}
  }
  
  void i()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.m.b = true;
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  void j()
    throws IOException
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        if ((this.m.b) || (!this.m.a)) {
          break label115;
        }
        if (this.e.b) {
          break label110;
        }
        if (!this.e.a) {
          break label115;
        }
      }
      finally {}
      boolean bool = b();
      if (n != 0)
      {
        a(b.CANCEL);
        return;
      }
      if (!bool) {
        this.d.b(this.c);
      }
      return;
      label110:
      int n = 1;
      continue;
      label115:
      n = 0;
    }
  }
  
  void k()
    throws IOException
  {
    if (!this.e.a)
    {
      if (!this.e.b)
      {
        if (this.h == null) {
          return;
        }
        throw new n(this.h);
      }
      throw new IOException("stream finished");
    }
    throw new IOException("stream closed");
  }
  
  void l()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException();
  }
  
  final class a
    implements r
  {
    boolean a;
    boolean b;
    private final f.c e = new f.c();
    
    a() {}
    
    private void a(boolean paramBoolean)
      throws IOException
    {
      for (;;)
      {
        synchronized (i.this)
        {
          i.this.g.c();
          try
          {
            if ((i.this.b <= 0L) && (!this.b) && (!this.a) && (i.this.h == null))
            {
              i.this.l();
              continue;
            }
            i.this.g.b();
            i.this.k();
            long l = Math.min(i.this.b, this.e.a());
            i locali = i.this;
            locali.b -= l;
            i.this.g.c();
            try
            {
              ??? = i.this.d;
              int i = i.this.c;
              if ((!paramBoolean) || (l != this.e.a())) {
                break label230;
              }
              paramBoolean = true;
              ((g)???).a(i, paramBoolean, this.e, l);
              return;
            }
            finally
            {
              i.this.g.b();
            }
            localObject4 = finally;
          }
          finally
          {
            i.this.g.b();
          }
        }
        label230:
        paramBoolean = false;
      }
    }
    
    public void a(f.c paramc, long paramLong)
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      this.e.a(paramc, paramLong);
      while (this.e.a() >= 16384L) {
        a(false);
      }
    }
    
    public void close()
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      synchronized (i.this)
      {
        if (this.a) {
          return;
        }
        if (!i.this.e.b)
        {
          if (this.e.a() > 0L) {
            while (this.e.a() > 0L) {
              a(true);
            }
          }
          i.this.d.a(i.this.c, true, null, 0L);
        }
        synchronized (i.this)
        {
          this.a = true;
          i.this.d.b();
          i.this.j();
          return;
        }
      }
    }
    
    public void flush()
      throws IOException
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      synchronized (i.this)
      {
        i.this.k();
        while (this.e.a() > 0L)
        {
          a(false);
          i.this.d.b();
        }
        return;
      }
    }
    
    public t timeout()
    {
      return i.this.g;
    }
  }
  
  private final class b
    implements f.s
  {
    boolean a;
    boolean b;
    private final f.c e = new f.c();
    private final f.c f = new f.c();
    private final long g;
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(i.this))) {
        throw new AssertionError();
      }
      i.this.d.a(paramLong);
    }
    
    void a(e parame, long paramLong)
      throws IOException
    {
      long l1 = paramLong;
      if (!c) {
        if (!Thread.holdsLock(i.this)) {
          l1 = paramLong;
        } else {
          throw new AssertionError();
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (i.this)
        {
          boolean bool = this.b;
          paramLong = this.f.a();
          long l2 = this.g;
          int j = 0;
          if (paramLong + l1 <= l2) {
            break label235;
          }
          i = 1;
          if (i != 0)
          {
            parame.i(l1);
            i.this.b(b.FLOW_CONTROL_ERROR);
            return;
          }
          if (bool)
          {
            parame.i(l1);
            return;
          }
          paramLong = parame.read(this.e, l1);
          if (paramLong != -1L)
          {
            l1 -= paramLong;
            ??? = i.this;
            i = j;
            try
            {
              if (this.f.a() == 0L) {
                i = 1;
              }
              this.f.a(this.e);
              if (i != 0) {
                i.this.notifyAll();
              }
              break;
            }
            finally {}
          }
          throw new EOFException();
        }
        return;
        label235:
        int i = 0;
      }
    }
    
    public void close()
      throws IOException
    {
      for (;;)
      {
        synchronized (i.this)
        {
          this.a = true;
          long l = this.f.a();
          this.f.s();
          boolean bool = i.a(i.this).isEmpty();
          Object localObject3 = null;
          if ((!bool) && (i.b(i.this) != null))
          {
            localObject3 = new ArrayList(i.a(i.this));
            i.a(i.this).clear();
            c.a locala = i.b(i.this);
            i.this.notifyAll();
            if (l > 0L) {
              a(l);
            }
            i.this.j();
            if (locala != null)
            {
              localObject3 = ((List)localObject3).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                locala.a((e.s)((Iterator)localObject3).next());
                continue;
              }
            }
            return;
          }
        }
        Object localObject2 = null;
      }
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L) {}
      for (;;)
      {
        synchronized (i.this)
        {
          i.this.f.c();
          try
          {
            if (i.this.h == null) {
              break label413;
            }
            localb = i.this.h;
            if (!this.a)
            {
              if ((!i.a(i.this).isEmpty()) && (i.b(i.this) != null))
              {
                localObject = (e.s)i.a(i.this).removeFirst();
                locala = i.b(i.this);
                l1 = -1L;
              }
              else
              {
                if (this.f.a() > 0L)
                {
                  long l2 = this.f.read(paramc, Math.min(paramLong, this.f.a()));
                  localObject = i.this;
                  ((i)localObject).a += l2;
                  l1 = l2;
                  if (localb != null) {
                    break label424;
                  }
                  l1 = l2;
                  if (i.this.a < i.this.d.k.d() / 2) {
                    break label424;
                  }
                  i.this.d.a(i.this.c, i.this.a);
                  i.this.a = 0L;
                  l1 = l2;
                  break label424;
                }
                if ((this.b) || (localb != null)) {
                  break label419;
                }
                i.this.l();
                i.this.f.b();
                continue;
              }
              i.this.f.b();
              if ((localObject != null) && (locala != null))
              {
                locala.a((e.s)localObject);
                continue;
              }
              if (l1 != -1L)
              {
                a(l1);
                return l1;
              }
              if (localb == null) {
                return -1L;
              }
              throw new n(localb);
            }
            throw new IOException("stream closed");
          }
          finally
          {
            i.this.f.b();
          }
        }
        paramc = new StringBuilder();
        paramc.append("byteCount < 0: ");
        paramc.append(paramLong);
        throw new IllegalArgumentException(paramc.toString());
        label413:
        b localb = null;
        continue;
        label419:
        long l1 = -1L;
        label424:
        Object localObject = null;
        c.a locala = null;
      }
    }
    
    public t timeout()
    {
      return i.this.f;
    }
  }
  
  class c
    extends a
  {
    c() {}
    
    protected IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void a()
    {
      i.this.b(b.CANCEL);
    }
    
    public void b()
      throws IOException
    {
      if (!m_()) {
        return;
      }
      throw a(null);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */