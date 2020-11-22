package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
  implements s
{
  private int a = 0;
  private final e b;
  private final Inflater c;
  private final k d;
  private final CRC32 e = new CRC32();
  
  public j(s params)
  {
    if (params != null)
    {
      this.c = new Inflater(true);
      this.b = l.a(params);
      this.d = new k(this.b, this.c);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void a()
    throws IOException
  {
    this.b.a(10L);
    int j = this.b.b().c(3L);
    int i;
    if ((j >> 1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      a(this.b.b(), 0L, 10L);
    }
    a("ID1ID2", 8075, this.b.i());
    this.b.i(8L);
    long l;
    if ((j >> 2 & 0x1) == 1)
    {
      this.b.a(2L);
      if (i != 0) {
        a(this.b.b(), 0L, 2L);
      }
      int k = this.b.b().k();
      e locale = this.b;
      l = k;
      locale.a(l);
      if (i != 0) {
        a(this.b.b(), 0L, l);
      }
      this.b.i(l);
    }
    if ((j >> 3 & 0x1) == 1)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          a(this.b.b(), 0L, l + 1L);
        }
        this.b.i(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          a(this.b.b(), 0L, l + 1L);
        }
        this.b.i(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if (i != 0)
    {
      a("FHCRC", this.b.k(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }
  
  private void a(c paramc, long paramLong1, long paramLong2)
  {
    for (paramc = paramc.a; paramLong1 >= paramc.c - paramc.b; paramc = paramc.f) {
      paramLong1 -= paramc.c - paramc.b;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramc.b + paramLong1);
      int j = (int)Math.min(paramc.c - i, paramLong2);
      this.e.update(paramc.a, i, j);
      paramLong2 -= j;
      paramc = paramc.f;
      paramLong1 = 0L;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  private void b()
    throws IOException
  {
    a("CRC", this.b.l(), (int)this.e.getValue());
    a("ISIZE", this.b.l(), (int)this.c.getBytesWritten());
  }
  
  public void close()
    throws IOException
  {
    this.d.close();
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return 0L;
      }
      if (this.a == 0)
      {
        a();
        this.a = 1;
      }
      if (this.a == 1)
      {
        long l = paramc.b;
        paramLong = this.d.read(paramc, paramLong);
        if (paramLong != -1L)
        {
          a(paramc, l, paramLong);
          return paramLong;
        }
        this.a = 2;
      }
      if (this.a == 2)
      {
        b();
        this.a = 3;
        if (this.b.e()) {
          return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
      }
      return -1L;
    }
    paramc = new StringBuilder();
    paramc.append("byteCount < 0: ");
    paramc.append(paramLong);
    throw new IllegalArgumentException(paramc.toString());
  }
  
  public t timeout()
  {
    return this.b.timeout();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */