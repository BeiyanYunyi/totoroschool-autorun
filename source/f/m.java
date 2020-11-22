package f;

import java.io.IOException;
import java.nio.ByteBuffer;

final class m
  implements d
{
  public final c a = new c();
  public final r b;
  boolean c;
  
  m(r paramr)
  {
    if (paramr != null)
    {
      this.b = paramr;
      return;
    }
    throw new NullPointerException("sink == null");
  }
  
  public long a(s params)
    throws IOException
  {
    if (params != null)
    {
      long l1 = 0L;
      for (;;)
      {
        long l2 = params.read(this.a, 8192L);
        if (l2 == -1L) {
          break;
        }
        l1 += l2;
        v();
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public void a(c paramc, long paramLong)
    throws IOException
  {
    if (!this.c)
    {
      this.a.a(paramc, paramLong);
      v();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public c b()
  {
    return this.a;
  }
  
  public d b(f paramf)
    throws IOException
  {
    if (!this.c)
    {
      this.a.a(paramf);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d b(String paramString)
    throws IOException
  {
    if (!this.c)
    {
      this.a.a(paramString);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d c(byte[] paramArrayOfByte)
    throws IOException
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.c)
    {
      this.a.b(paramArrayOfByte, paramInt1, paramInt2);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public void close()
    throws IOException
  {
    if (this.c) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (this.a.b > 0L)
      {
        this.b.a(this.a, this.a.b);
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable1) {}
    try
    {
      this.b.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    this.c = true;
    if (localObject2 != null) {
      u.a((Throwable)localObject2);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (!this.c)
    {
      if (this.a.b > 0L) {
        this.b.a(this.a, this.a.b);
      }
      this.b.flush();
      return;
    }
    throw new IllegalStateException("closed");
  }
  
  public d g(int paramInt)
    throws IOException
  {
    if (!this.c)
    {
      this.a.d(paramInt);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d h(int paramInt)
    throws IOException
  {
    if (!this.c)
    {
      this.a.c(paramInt);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d i(int paramInt)
    throws IOException
  {
    if (!this.c)
    {
      this.a.b(paramInt);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public boolean isOpen()
  {
    return this.c ^ true;
  }
  
  public d l(long paramLong)
    throws IOException
  {
    if (!this.c)
    {
      this.a.k(paramLong);
      return v();
    }
    throw new IllegalStateException("closed");
  }
  
  public d m(long paramLong)
    throws IOException
  {
    if (!this.c)
    {
      this.a.j(paramLong);
      return v();
    }
    throw new IllegalStateException("closed");
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
  
  public d v()
    throws IOException
  {
    if (!this.c)
    {
      long l = this.a.g();
      if (l > 0L) {
        this.b.a(this.a, l);
      }
      return this;
    }
    throw new IllegalStateException("closed");
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!this.c)
    {
      int i = this.a.write(paramByteBuffer);
      v();
      return i;
    }
    throw new IllegalStateException("closed");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */