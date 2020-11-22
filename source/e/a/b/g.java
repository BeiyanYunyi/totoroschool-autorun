package e.a.b;

import e.a.e.b;
import e.a.e.n;
import e.ae;
import e.e;
import e.i;
import e.j;
import e.p;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class g
{
  public final e.a a;
  public final e b;
  public final p c;
  private f.a e;
  private ae f;
  private final j g;
  private final Object h;
  private final f i;
  private int j;
  private c k;
  private boolean l;
  private boolean m;
  private boolean n;
  private e.a.c.c o;
  
  public g(j paramj, e.a parama, e parame, p paramp, Object paramObject)
  {
    this.g = paramj;
    this.a = parama;
    this.b = parame;
    this.c = paramp;
    this.i = new f(parama, i(), parame, paramp);
    this.h = paramObject;
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      int i3;
      synchronized (this.g)
      {
        if (!this.m)
        {
          if (this.o == null)
          {
            if (!this.n)
            {
              localObject6 = this.k;
              Object localObject11 = h();
              Object localObject1 = this.k;
              Object localObject9 = null;
              if (localObject1 != null)
              {
                localObject1 = this.k;
                localObject6 = null;
                ??? = localObject6;
                if (!this.l) {
                  ??? = null;
                }
                if (localObject1 != null) {
                  break label626;
                }
                e.a.a.a.a(this.g, this.a, this, null);
                if (this.k != null)
                {
                  localObject6 = this.k;
                  localObject1 = null;
                  i1 = 1;
                }
                else
                {
                  localObject7 = this.f;
                  break label629;
                }
                e.a.c.a((Socket)localObject11);
                if (??? != null) {
                  this.c.b(this.b, (i)???);
                }
                if (i1 != 0) {
                  this.c.a(this.b, (i)localObject6);
                }
                if (localObject6 != null) {
                  return (c)localObject6;
                }
                if ((localObject1 == null) && ((this.e == null) || (!this.e.a())))
                {
                  this.e = this.i.b();
                  i3 = 1;
                }
                else
                {
                  i3 = 0;
                }
                synchronized (this.g)
                {
                  if (!this.n)
                  {
                    int i2 = i1;
                    localObject7 = localObject6;
                    if (i3 != 0)
                    {
                      ??? = this.e.c();
                      int i4 = ((List)???).size();
                      i3 = 0;
                      i2 = i1;
                      localObject7 = localObject6;
                      if (i3 < i4)
                      {
                        localObject11 = (ae)((List)???).get(i3);
                        e.a.a.a.a(this.g, this.a, this, (ae)localObject11);
                        if (this.k == null) {
                          break label643;
                        }
                        localObject7 = this.k;
                        this.f = ((ae)localObject11);
                        i2 = 1;
                      }
                    }
                    localObject6 = localObject7;
                    if (i2 == 0)
                    {
                      localObject6 = localObject1;
                      if (localObject1 == null) {
                        localObject6 = this.e.b();
                      }
                      this.f = ((ae)localObject6);
                      this.j = 0;
                      localObject6 = new c(this.g, (ae)localObject6);
                      a((c)localObject6, false);
                    }
                    if (i2 != 0)
                    {
                      this.c.a(this.b, (i)localObject6);
                      return (c)localObject6;
                    }
                    ((c)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.b, this.c);
                    i().b(((c)localObject6).b());
                    synchronized (this.g)
                    {
                      this.l = true;
                      e.a.a.a.b(this.g, (c)localObject6);
                      localObject7 = localObject9;
                      localObject1 = localObject6;
                      if (((c)localObject6).f())
                      {
                        localObject7 = e.a.a.a.a(this.g, this.a, this);
                        localObject1 = this.k;
                      }
                      e.a.c.a((Socket)localObject7);
                      this.c.a(this.b, (i)localObject1);
                      return (c)localObject1;
                    }
                  }
                  throw new IOException("Canceled");
                }
              }
            }
            else
            {
              throw new IOException("Canceled");
            }
          }
          else {
            throw new IllegalStateException("codec != null");
          }
        }
        else {
          throw new IllegalStateException("released");
        }
      }
      Object localObject5 = null;
      continue;
      label626:
      Object localObject7 = null;
      label629:
      int i1 = 0;
      Object localObject6 = localObject5;
      localObject5 = localObject7;
      continue;
      label643:
      i3 += 1;
    }
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    for (;;)
    {
      c localc = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.g)
      {
        if (localc.b == 0) {
          return localc;
        }
        if (!localc.a(paramBoolean2))
        {
          e();
          continue;
        }
        return localc;
      }
    }
  }
  
  private Socket a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (paramBoolean3) {
      this.o = null;
    }
    if (paramBoolean2) {
      this.m = true;
    }
    if (this.k != null)
    {
      if (paramBoolean1) {
        this.k.a = true;
      }
      if ((this.o == null) && ((this.m) || (this.k.a)))
      {
        b(this.k);
        if (this.k.d.isEmpty())
        {
          this.k.e = System.nanoTime();
          if (e.a.a.a.a(this.g, this.k))
          {
            localSocket = this.k.d();
            break label153;
          }
        }
        Socket localSocket = null;
        label153:
        this.k = null;
        return localSocket;
      }
    }
    return null;
  }
  
  private void b(c paramc)
  {
    int i2 = paramc.d.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Reference)paramc.d.get(i1)).get() == this)
      {
        paramc.d.remove(i1);
        return;
      }
      i1 += 1;
    }
    throw new IllegalStateException();
  }
  
  private Socket h()
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    c localc = this.k;
    if ((localc != null) && (localc.a)) {
      return a(false, false, true);
    }
    return null;
  }
  
  private d i()
  {
    return e.a.a.a.a(this.g);
  }
  
  public e.a.c.c a()
  {
    synchronized (this.g)
    {
      e.a.c.c localc = this.o;
      return localc;
    }
  }
  
  /* Error */
  public e.a.c.c a(e.x arg1, e.u.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 238 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 240 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 242 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 245	e/x:e	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 248	e/x:t	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 250	e/a/b/g:a	(IIIIZZ)Le/a/b/c;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 253	e/a/b/c:a	(Le/x;Le/u$a;Le/a/b/g;)Le/a/c/c;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 50	e/a/b/g:g	Le/j;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 75	e/a/b/g:o	Le/a/c/c;
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: new 255	e/a/b/e
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 258	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	g
    //   0	89	2	parama	e.u.a
    //   0	89	3	paramBoolean	boolean
    //   6	32	4	i1	int
    //   14	26	5	i2	int
    //   22	20	6	i3	int
    //   28	16	7	i4	int
    //   34	12	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	72	74	finally
    //   75	77	74	finally
    //   36	65	79	java/io/IOException
    //   77	79	79	java/io/IOException
  }
  
  public Socket a(c paramc)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if ((this.o == null) && (this.k.d.size() == 1))
    {
      Reference localReference = (Reference)this.k.d.get(0);
      Socket localSocket = a(true, false, false);
      this.k = paramc;
      paramc.d.add(localReference);
      return localSocket;
    }
    throw new IllegalStateException();
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (this.k == null)
    {
      this.k = paramc;
      this.l = paramBoolean;
      paramc.d.add(new a(this, this.h));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(IOException paramIOException)
  {
    for (;;)
    {
      synchronized (this.g)
      {
        if ((paramIOException instanceof n))
        {
          paramIOException = ((n)paramIOException).errorCode;
          if (paramIOException == b.REFUSED_STREAM)
          {
            this.j += 1;
            if (this.j <= 1) {
              break label200;
            }
            this.f = null;
          }
          else
          {
            if (paramIOException == b.CANCEL) {
              break label200;
            }
            this.f = null;
          }
        }
        else
        {
          if ((this.k == null) || ((this.k.f()) && (!(paramIOException instanceof e.a.e.a)))) {
            break label200;
          }
          if (this.k.b == 0)
          {
            if ((this.f != null) && (paramIOException != null)) {
              this.i.a(this.f, paramIOException);
            }
            this.f = null;
            break label195;
            paramIOException = this.k;
            Socket localSocket = a(bool, false, true);
            if ((this.k != null) || (!this.l)) {
              break label205;
            }
            e.a.c.a(localSocket);
            if (paramIOException != null) {
              this.c.b(this.b, paramIOException);
            }
            return;
          }
        }
      }
      label195:
      boolean bool = true;
      continue;
      label200:
      bool = false;
      continue;
      label205:
      paramIOException = null;
    }
  }
  
  public void a(boolean paramBoolean, e.a.c.c paramc, long paramLong, IOException paramIOException)
  {
    this.c.b(this.b, paramLong);
    j localj = this.g;
    if (paramc != null) {
      try
      {
        if (paramc == this.o)
        {
          if (!paramBoolean)
          {
            paramc = this.k;
            paramc.b += 1;
          }
          paramc = this.k;
          Socket localSocket = a(paramBoolean, false, true);
          if (this.k != null) {
            paramc = null;
          }
          paramBoolean = this.m;
          e.a.c.a(localSocket);
          if (paramc != null) {
            this.c.b(this.b, paramc);
          }
          if (paramIOException != null)
          {
            paramc = e.a.a.a.a(this.b, paramIOException);
            this.c.a(this.b, paramc);
            return;
          }
          if (paramBoolean)
          {
            e.a.a.a.a(this.b, null);
            this.c.g(this.b);
          }
          return;
        }
      }
      finally
      {
        break label224;
      }
    }
    paramIOException = new StringBuilder();
    paramIOException.append("expected ");
    paramIOException.append(this.o);
    paramIOException.append(" but was ");
    paramIOException.append(paramc);
    throw new IllegalStateException(paramIOException.toString());
    label224:
    throw paramc;
  }
  
  public ae b()
  {
    return this.f;
  }
  
  public c c()
  {
    try
    {
      c localc = this.k;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    synchronized (this.g)
    {
      c localc = this.k;
      Socket localSocket = a(false, true, false);
      if (this.k != null) {
        localc = null;
      }
      e.a.c.a(localSocket);
      if (localc != null)
      {
        e.a.a.a.a(this.b, null);
        this.c.b(this.b, localc);
        this.c.g(this.b);
      }
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.g)
    {
      c localc = this.k;
      Socket localSocket = a(true, false, false);
      if (this.k != null) {
        localc = null;
      }
      e.a.c.a(localSocket);
      if (localc != null) {
        this.c.b(this.b, localc);
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.g)
    {
      this.n = true;
      e.a.c.c localc = this.o;
      c localc1 = this.k;
      if (localc != null)
      {
        localc.c();
        return;
      }
      if (localc1 != null) {
        localc1.c();
      }
      return;
    }
  }
  
  public boolean g()
  {
    return (this.f != null) || ((this.e != null) && (this.e.a())) || (this.i.a());
  }
  
  public String toString()
  {
    c localc = c();
    if (localc != null) {
      return localc.toString();
    }
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<g>
  {
    public final Object a;
    
    a(g paramg, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */