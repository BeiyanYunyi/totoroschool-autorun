package e.a.d;

import e.a.b.g;
import e.a.c.h;
import e.a.c.k;
import e.aa;
import e.ac;
import e.ac.a;
import e.ad;
import e.ae;
import e.p;
import e.s.a;
import e.x;
import f.d;
import f.l;
import f.r;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class a
  implements e.a.c.c
{
  final x a;
  final g b;
  final f.e c;
  final d d;
  int e = 0;
  private long f = 262144L;
  
  public a(x paramx, g paramg, f.e parame, d paramd)
  {
    this.a = paramx;
    this.b = paramg;
    this.c = parame;
    this.d = paramd;
  }
  
  private String g()
    throws IOException
  {
    String str = this.c.f(this.f);
    this.f -= str.length();
    return str;
  }
  
  public ac.a a(boolean paramBoolean)
    throws IOException
  {
    Object localObject1;
    if ((this.e != 1) && (this.e != 3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("state: ");
      ((StringBuilder)localObject1).append(this.e);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = k.a(g());
      localObject2 = new ac.a().a(((k)localObject1).a).a(((k)localObject1).b).a(((k)localObject1).c).a(d());
      if ((paramBoolean) && (((k)localObject1).b == 100)) {
        return null;
      }
      if (((k)localObject1).b == 100)
      {
        this.e = 3;
        return (ac.a)localObject2;
      }
      this.e = 4;
      return (ac.a)localObject2;
    }
    catch (EOFException localEOFException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unexpected end of stream on ");
      ((StringBuilder)localObject2).append(this.b);
      localObject2 = new IOException(((StringBuilder)localObject2).toString());
      ((IOException)localObject2).initCause(localEOFException);
      throw ((Throwable)localObject2);
    }
  }
  
  public ad a(ac paramac)
    throws IOException
  {
    this.b.c.f(this.b.b);
    String str = paramac.a("Content-Type");
    if (!e.a.c.e.b(paramac)) {
      return new h(str, 0L, l.a(b(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramac.a("Transfer-Encoding"))) {
      return new h(str, -1L, l.a(a(paramac.a().a())));
    }
    long l = e.a.c.e.a(paramac);
    if (l != -1L) {
      return new h(str, l, l.a(b(l)));
    }
    return new h(str, -1L, l.a(f()));
  }
  
  public r a(long paramLong)
  {
    if (this.e == 1)
    {
      this.e = 2;
      return new d(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public r a(aa paramaa, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramaa.a("Transfer-Encoding"))) {
      return e();
    }
    if (paramLong != -1L) {
      return a(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public f.s a(e.t paramt)
    throws IOException
  {
    if (this.e == 4)
    {
      this.e = 5;
      return new c(paramt);
    }
    paramt = new StringBuilder();
    paramt.append("state: ");
    paramt.append(this.e);
    throw new IllegalStateException(paramt.toString());
  }
  
  public void a()
    throws IOException
  {
    this.d.flush();
  }
  
  public void a(aa paramaa)
    throws IOException
  {
    String str = e.a.c.i.a(paramaa, this.b.c().b().b().type());
    a(paramaa.c(), str);
  }
  
  public void a(e.s params, String paramString)
    throws IOException
  {
    if (this.e == 0)
    {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = params.a();
      while (i < j)
      {
        this.d.b(params.a(i)).b(": ").b(params.b(i)).b("\r\n");
        i += 1;
      }
      this.d.b("\r\n");
      this.e = 1;
      return;
    }
    params = new StringBuilder();
    params.append("state: ");
    params.append(this.e);
    throw new IllegalStateException(params.toString());
  }
  
  void a(f.i parami)
  {
    f.t localt = parami.a();
    parami.a(f.t.c);
    localt.f();
    localt.o_();
  }
  
  public f.s b(long paramLong)
    throws IOException
  {
    if (this.e == 4)
    {
      this.e = 5;
      return new e(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void b()
    throws IOException
  {
    this.d.flush();
  }
  
  public void c()
  {
    e.a.b.c localc = this.b.c();
    if (localc != null) {
      localc.c();
    }
  }
  
  public e.s d()
    throws IOException
  {
    s.a locala = new s.a();
    for (;;)
    {
      String str = g();
      if (str.length() == 0) {
        break;
      }
      e.a.a.a.a(locala, str);
    }
    return locala.a();
  }
  
  public r e()
  {
    if (this.e == 1)
    {
      this.e = 2;
      return new b();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public f.s f()
    throws IOException
  {
    if (this.e == 4)
    {
      if (this.b != null)
      {
        this.e = 5;
        this.b.e();
        return new f();
      }
      throw new IllegalStateException("streamAllocation == null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.e);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private abstract class a
    implements f.s
  {
    protected final f.i a = new f.i(a.this.c.timeout());
    protected boolean b;
    protected long c = 0L;
    
    private a() {}
    
    protected final void a(boolean paramBoolean, IOException paramIOException)
      throws IOException
    {
      if (a.this.e == 6) {
        return;
      }
      if (a.this.e == 5)
      {
        a.this.a(this.a);
        a.this.e = 6;
        if (a.this.b != null) {
          a.this.b.a(paramBoolean ^ true, a.this, this.c, paramIOException);
        }
        return;
      }
      paramIOException = new StringBuilder();
      paramIOException.append("state: ");
      paramIOException.append(a.this.e);
      throw new IllegalStateException(paramIOException.toString());
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      try
      {
        paramLong = a.this.c.read(paramc, paramLong);
        if (paramLong > 0L) {
          this.c += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramc)
      {
        a(false, paramc);
        throw paramc;
      }
    }
    
    public f.t timeout()
    {
      return this.a;
    }
  }
  
  private final class b
    implements r
  {
    private final f.i b = new f.i(a.this.d.timeout());
    private boolean c;
    
    b() {}
    
    public void a(f.c paramc, long paramLong)
      throws IOException
    {
      if (!this.c)
      {
        if (paramLong == 0L) {
          return;
        }
        a.this.d.l(paramLong);
        a.this.d.b("\r\n");
        a.this.d.a(paramc, paramLong);
        a.this.d.b("\r\n");
        return;
      }
      throw new IllegalStateException("closed");
    }
    
    public void close()
      throws IOException
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        this.c = true;
        a.this.d.b("0\r\n\r\n");
        a.this.a(this.b);
        a.this.e = 3;
        return;
      }
      finally {}
    }
    
    public void flush()
      throws IOException
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        a.this.d.flush();
        return;
      }
      finally {}
    }
    
    public f.t timeout()
    {
      return this.b;
    }
  }
  
  private class c
    extends a.a
  {
    private final e.t f;
    private long g = -1L;
    private boolean h = true;
    
    c(e.t paramt)
    {
      super(null);
      this.f = paramt;
    }
    
    private void a()
      throws IOException
    {
      if (this.g != -1L) {
        a.this.c.p();
      }
      try
      {
        this.g = a.this.c.m();
        String str = a.this.c.p().trim();
        if (this.g >= 0L) {
          if (!str.isEmpty())
          {
            boolean bool = str.startsWith(";");
            if (!bool) {}
          }
          else
          {
            if (this.g == 0L)
            {
              this.h = false;
              e.a.c.e.a(a.this.a.h(), this.f, a.this.d());
              a(true, null);
            }
            return;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("expected chunk size and optional extensions but was \"");
        localStringBuilder.append(this.g);
        localStringBuilder.append(str);
        localStringBuilder.append("\"");
        throw new ProtocolException(localStringBuilder.toString());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.h) && (!e.a.c.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (!this.h) {
            return -1L;
          }
          if ((this.g == 0L) || (this.g == -1L))
          {
            a();
            if (!this.h) {
              return -1L;
            }
          }
          paramLong = super.read(paramc, Math.min(paramLong, this.g));
          if (paramLong != -1L)
          {
            this.g -= paramLong;
            return paramLong;
          }
          paramc = new ProtocolException("unexpected end of stream");
          a(false, paramc);
          throw paramc;
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
  }
  
  private final class d
    implements r
  {
    private final f.i b = new f.i(a.this.d.timeout());
    private boolean c;
    private long d;
    
    d(long paramLong)
    {
      this.d = paramLong;
    }
    
    public void a(f.c paramc, long paramLong)
      throws IOException
    {
      if (!this.c)
      {
        e.a.c.a(paramc.a(), 0L, paramLong);
        if (paramLong <= this.d)
        {
          a.this.d.a(paramc, paramLong);
          this.d -= paramLong;
          return;
        }
        paramc = new StringBuilder();
        paramc.append("expected ");
        paramc.append(this.d);
        paramc.append(" bytes but received ");
        paramc.append(paramLong);
        throw new ProtocolException(paramc.toString());
      }
      throw new IllegalStateException("closed");
    }
    
    public void close()
      throws IOException
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.d <= 0L)
      {
        a.this.a(this.b);
        a.this.e = 3;
        return;
      }
      throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush()
      throws IOException
    {
      if (this.c) {
        return;
      }
      a.this.d.flush();
    }
    
    public f.t timeout()
    {
      return this.b;
    }
  }
  
  private class e
    extends a.a
  {
    private long f;
    
    e(long paramLong)
      throws IOException
    {
      super(null);
      this.f = paramLong;
      if (this.f == 0L) {
        a(true, null);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if ((this.f != 0L) && (!e.a.c.a(this, 100, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.b = true;
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f == 0L) {
            return -1L;
          }
          paramLong = super.read(paramc, Math.min(this.f, paramLong));
          if (paramLong != -1L)
          {
            this.f -= paramLong;
            if (this.f == 0L) {
              a(true, null);
            }
            return paramLong;
          }
          paramc = new ProtocolException("unexpected end of stream");
          a(false, paramc);
          throw paramc;
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
  }
  
  private class f
    extends a.a
  {
    private boolean f;
    
    f()
    {
      super(null);
    }
    
    public void close()
      throws IOException
    {
      if (this.b) {
        return;
      }
      if (!this.f) {
        a(false, null);
      }
      this.b = true;
    }
    
    public long read(f.c paramc, long paramLong)
      throws IOException
    {
      if (paramLong >= 0L)
      {
        if (!this.b)
        {
          if (this.f) {
            return -1L;
          }
          paramLong = super.read(paramc, paramLong);
          if (paramLong == -1L)
          {
            this.f = true;
            a(true, null);
            return -1L;
          }
          return paramLong;
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */