package f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class n
  implements e
{
  public final c a = new c();
  public final s b;
  boolean c;
  
  n(s params)
  {
    if (params != null)
    {
      this.b = params;
      return;
    }
    throw new NullPointerException("source == null");
  }
  
  public long a(byte paramByte)
    throws IOException
  {
    return a(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
    throws IOException
  {
    if (!this.c)
    {
      if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
      {
        while (paramLong1 < paramLong2)
        {
          long l = this.a.a(paramByte, paramLong1, paramLong2);
          if (l != -1L) {
            return l;
          }
          l = this.a.b;
          if (l < paramLong2)
          {
            if (this.b.read(this.a, 8192L) == -1L) {
              return -1L;
            }
            paramLong1 = Math.max(paramLong1, l);
          }
          else
          {
            return -1L;
          }
        }
        return -1L;
      }
      throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    throw new IllegalStateException("closed");
  }
  
  public long a(r paramr)
    throws IOException
  {
    if (paramr != null)
    {
      long l1 = 0L;
      while (this.b.read(this.a, 8192L) != -1L)
      {
        l2 = this.a.g();
        if (l2 > 0L)
        {
          l1 += l2;
          paramr.a(this.a, l2);
        }
      }
      long l2 = l1;
      if (this.a.a() > 0L)
      {
        l2 = l1 + this.a.a();
        paramr.a(this.a, this.a.a());
      }
      return l2;
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public String a(Charset paramCharset)
    throws IOException
  {
    if (paramCharset != null)
    {
      this.a.a(this.b);
      return this.a.a(paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public void a(long paramLong)
    throws IOException
  {
    if (b(paramLong)) {
      return;
    }
    throw new EOFException();
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      a(paramArrayOfByte.length);
      this.a.a(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.a.b > 0L)
      {
        int j = this.a.a(paramArrayOfByte, i, (int)this.a.b);
        if (j != -1) {
          i += j;
        } else {
          throw new AssertionError();
        }
      }
      throw localEOFException;
    }
  }
  
  public boolean a(long paramLong, f paramf)
    throws IOException
  {
    return a(paramLong, paramf, 0, paramf.size());
  }
  
  public boolean a(long paramLong, f paramf, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.c)
    {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0))
      {
        if (paramf.size() - paramInt1 < paramInt2) {
          return false;
        }
        int i = 0;
        while (i < paramInt2)
        {
          long l = i + paramLong;
          if (!b(1L + l)) {
            return false;
          }
          if (this.a.c(l) != paramf.getByte(paramInt1 + i)) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    throw new IllegalStateException("closed");
  }
  
  public c b()
  {
    return this.a;
  }
  
  public boolean b(long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      if (!this.c)
      {
        while (this.a.b < paramLong) {
          if (this.b.read(this.a, 8192L) == -1L) {
            return false;
          }
        }
        return true;
      }
      throw new IllegalStateException("closed");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("byteCount < 0: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    if (this.c) {
      return;
    }
    this.c = true;
    this.b.close();
    this.a.s();
  }
  
  public f d(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.d(paramLong);
  }
  
  public boolean e()
    throws IOException
  {
    if (!this.c) {
      return (this.a.e()) && (this.b.read(this.a, 8192L) == -1L);
    }
    throw new IllegalStateException("closed");
  }
  
  public InputStream f()
  {
    new InputStream()
    {
      public int available()
        throws IOException
      {
        if (!n.this.c) {
          return (int)Math.min(n.this.a.b, 2147483647L);
        }
        throw new IOException("closed");
      }
      
      public void close()
        throws IOException
      {
        n.this.close();
      }
      
      public int read()
        throws IOException
      {
        if (!n.this.c)
        {
          if ((n.this.a.b == 0L) && (n.this.b.read(n.this.a, 8192L) == -1L)) {
            return -1;
          }
          return n.this.a.h() & 0xFF;
        }
        throw new IOException("closed");
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (!n.this.c)
        {
          u.a(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
          if ((n.this.a.b == 0L) && (n.this.b.read(n.this.a, 8192L) == -1L)) {
            return -1;
          }
          return n.this.a.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
        throw new IOException("closed");
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(n.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public String f(long paramLong)
    throws IOException
  {
    if (paramLong >= 0L)
    {
      long l1;
      if (paramLong == Long.MAX_VALUE) {
        l1 = Long.MAX_VALUE;
      } else {
        l1 = paramLong + 1L;
      }
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L) {
        return this.a.g(l2);
      }
      if ((l1 < Long.MAX_VALUE) && (b(l1)) && (this.a.c(l1 - 1L) == 13) && (b(1L + l1)) && (this.a.c(l1) == 10)) {
        return this.a.g(l1);
      }
      localObject = new c();
      this.a.a((c)localObject, 0L, Math.min(32L, this.a.a()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(this.a.a(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(((c)localObject).n().hex());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public byte h()
    throws IOException
  {
    a(1L);
    return this.a.h();
  }
  
  public byte[] h(long paramLong)
    throws IOException
  {
    a(paramLong);
    return this.a.h(paramLong);
  }
  
  public short i()
    throws IOException
  {
    a(2L);
    return this.a.i();
  }
  
  public void i(long paramLong)
    throws IOException
  {
    if (!this.c)
    {
      while (paramLong > 0L)
      {
        if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
          throw new EOFException();
        }
        long l = Math.min(paramLong, this.a.a());
        this.a.i(l);
        paramLong -= l;
      }
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
  }
  
  public int j()
    throws IOException
  {
    a(4L);
    return this.a.j();
  }
  
  public short k()
    throws IOException
  {
    a(2L);
    return this.a.k();
  }
  
  public int l()
    throws IOException
  {
    a(4L);
    return this.a.l();
  }
  
  public long m()
    throws IOException
  {
    a(1L);
    int j;
    byte b1;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!b(j)) {
        break label105;
      }
      b1 = this.a.c(i);
      if (((b1 < 48) || (b1 > 57)) && ((b1 < 97) || (b1 > 102)) && ((b1 < 65) || (b1 > 70))) {
        break;
      }
    }
    if (i == 0) {
      throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) }));
    }
    label105:
    return this.a.m();
  }
  
  public String p()
    throws IOException
  {
    return f(Long.MAX_VALUE);
  }
  
  public byte[] r()
    throws IOException
  {
    this.a.a(this.b);
    return this.a.r();
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
      return -1;
    }
    return this.a.read(paramByteBuffer);
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramc != null)
    {
      if (paramLong >= 0L)
      {
        if (!this.c)
        {
          if ((this.a.b == 0L) && (this.b.read(this.a, 8192L) == -1L)) {
            return -1L;
          }
          paramLong = Math.min(paramLong, this.a.b);
          return this.a.read(paramc, paramLong);
        }
        throw new IllegalStateException("closed");
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public t timeout()
  {
    return this.b.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */