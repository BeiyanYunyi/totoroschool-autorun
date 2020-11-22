package f;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class q
  extends f
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  q(c paramc, int paramInt)
  {
    super(null);
    u.a(paramc.b, 0L, paramInt);
    o localo = paramc.a;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (localo.c != localo.b)
      {
        j += localo.c - localo.b;
        i += 1;
        localo = localo.f;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramc = paramc.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramc.a;
      k = i + (paramc.c - paramc.b);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      this.directory[j] = i;
      this.directory[(this.segments.length + j)] = paramc.b;
      paramc.d = true;
      j += 1;
      paramc = paramc.f;
    }
  }
  
  private int a(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private f a()
  {
    return new f(toByteArray());
  }
  
  private Object writeReplace()
  {
    return a();
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return a().base64();
  }
  
  public String base64Url()
  {
    return a().base64Url();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((((f)paramObject).size() == size()) && (rangeEquals(0, (f)paramObject, 0, size()))) {
        return true;
      }
    }
    return false;
  }
  
  public byte getByte(int paramInt)
  {
    u.a(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = a(paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = this.directory[(j - 1)];
    }
    int k = this.directory[(this.segments.length + j)];
    return this.segments[j][(paramInt - i + k)];
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    int i2 = this.segments.length;
    int j = 0;
    int k = 0;
    int m = 1;
    while (j < i2)
    {
      byte[] arrayOfByte = this.segments[j];
      int i1 = this.directory[(i2 + j)];
      int n = this.directory[j];
      i = i1;
      while (i < n - k + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      j += 1;
      k = n;
    }
    this.hashCode = m;
    return m;
  }
  
  public String hex()
  {
    return a().hex();
  }
  
  public f hmacSha1(f paramf)
  {
    return a().hmacSha1(paramf);
  }
  
  public f hmacSha256(f paramf)
  {
    return a().hmacSha256(paramf);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return a().indexOf(paramArrayOfByte, paramInt);
  }
  
  byte[] internalArray()
  {
    return toByteArray();
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    return a().lastIndexOf(paramArrayOfByte, paramInt);
  }
  
  public f md5()
  {
    return a().md5();
  }
  
  public boolean rangeEquals(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 > size() - paramInt3) {
        return false;
      }
      int j = a(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!paramf.rangeEquals(paramInt2, this.segments[paramInt1], i - j + m, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= size() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = a(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!u.a(this.segments[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public f sha1()
  {
    return a().sha1();
  }
  
  public f sha256()
  {
    return a().sha256();
  }
  
  public int size()
  {
    return this.directory[(this.segments.length - 1)];
  }
  
  public String string(Charset paramCharset)
  {
    return a().string(paramCharset);
  }
  
  public f substring(int paramInt)
  {
    return a().substring(paramInt);
  }
  
  public f substring(int paramInt1, int paramInt2)
  {
    return a().substring(paramInt1, paramInt2);
  }
  
  public f toAsciiLowercase()
  {
    return a().toAsciiLowercase();
  }
  
  public f toAsciiUppercase()
  {
    return a().toAsciiUppercase();
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.directory[(this.segments.length - 1)]];
    int m = this.segments.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.directory[(m + i)];
      k = this.directory[i];
      System.arraycopy(this.segments[i], n, arrayOfByte, j, k - j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public String toString()
  {
    return a().toString();
  }
  
  public String utf8()
  {
    return a().utf8();
  }
  
  void write(c paramc)
  {
    int m = this.segments.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.directory[(m + i)];
      k = this.directory[i];
      o localo = new o(this.segments[i], n, n + k - j, true, false);
      if (paramc.a == null)
      {
        localo.g = localo;
        localo.f = localo;
        paramc.a = localo;
      }
      else
      {
        paramc.a.g.a(localo);
      }
      i += 1;
    }
    paramc.b += j;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      int m = this.segments.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        int n = this.directory[(m + i)];
        k = this.directory[i];
        paramOutputStream.write(this.segments[i], n, k - j);
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("out == null");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */