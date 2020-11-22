package f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c
  implements d, e, Cloneable, ByteChannel
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  @Nullable
  o a;
  long b;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    u.a(paramArrayOfByte.length, paramInt1, paramInt2);
    o localo = this.a;
    if (localo == null) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localo.c - localo.b);
    System.arraycopy(localo.a, localo.b, paramArrayOfByte, paramInt1, paramInt2);
    localo.b += paramInt2;
    this.b -= paramInt2;
    if (localo.b == localo.c)
    {
      this.a = localo.b();
      p.a(localo);
    }
    return paramInt2;
  }
  
  public final long a()
  {
    return this.b;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
    {
      long l2 = paramLong2;
      if (paramLong2 > this.b) {
        l2 = this.b;
      }
      if (paramLong1 == l2) {
        return -1L;
      }
      Object localObject1 = this.a;
      if (localObject1 == null) {
        return -1L;
      }
      paramLong2 = l1;
      Object localObject2 = localObject1;
      long l3;
      if (this.b - paramLong1 < paramLong1)
      {
        l1 = this.b;
        localObject2 = localObject1;
        for (;;)
        {
          paramLong2 = l1;
          localObject1 = localObject2;
          l3 = paramLong1;
          if (l1 <= paramLong1) {
            break;
          }
          localObject2 = ((o)localObject2).g;
          l1 -= ((o)localObject2).c - ((o)localObject2).b;
        }
      }
      for (;;)
      {
        l1 = ((o)localObject2).c - ((o)localObject2).b + paramLong2;
        localObject1 = localObject2;
        l3 = paramLong1;
        if (l1 >= paramLong1) {
          break;
        }
        localObject2 = ((o)localObject2).f;
        paramLong2 = l1;
      }
      while (paramLong2 < l2)
      {
        localObject2 = ((o)localObject1).a;
        int j = (int)Math.min(((o)localObject1).c, ((o)localObject1).b + l2 - paramLong2);
        int i = (int)(((o)localObject1).b + l3 - paramLong2);
        while (i < j)
        {
          if (localObject2[i] == paramByte) {
            return i - ((o)localObject1).b + paramLong2;
          }
          i += 1;
        }
        l3 = ((o)localObject1).c - ((o)localObject1).b + paramLong2;
        localObject1 = ((o)localObject1).f;
        paramLong2 = l3;
      }
      return -1L;
    }
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public long a(r paramr)
    throws IOException
  {
    long l = this.b;
    if (l > 0L) {
      paramr.a(this, l);
    }
    return l;
  }
  
  public long a(s params)
    throws IOException
  {
    if (params != null)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        l2 = params.read(this, 8192L);
        if (l2 == -1L) {
          break;
        }
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public c a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        b(63);
        return this;
      }
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected code point: ");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final c a(c paramc, long paramLong1, long paramLong2)
  {
    if (paramc != null)
    {
      u.a(this.b, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      paramc.b += paramLong2;
      o localo2;
      long l1;
      long l2;
      for (o localo1 = this.a;; localo1 = localo1.f)
      {
        localo2 = localo1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localo1.c - localo1.b) {
          break;
        }
        paramLong1 -= localo1.c - localo1.b;
      }
      while (l2 > 0L)
      {
        localo1 = localo2.a();
        localo1.b = ((int)(localo1.b + l1));
        localo1.c = Math.min(localo1.b + (int)l2, localo1.c);
        if (paramc.a == null)
        {
          localo1.g = localo1;
          localo1.f = localo1;
          paramc.a = localo1;
        }
        else
        {
          paramc.a.g.a(localo1);
        }
        l2 -= localo1.c - localo1.b;
        localo2 = localo2.f;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public c a(f paramf)
  {
    if (paramf != null)
    {
      paramf.write(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public c a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public c a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            while (paramInt1 < paramInt2)
            {
              int k = paramString.charAt(paramInt1);
              int j;
              int i;
              if (k < 128)
              {
                localObject = e(1);
                byte[] arrayOfByte = ((o)localObject).a;
                j = ((o)localObject).c - paramInt1;
                int m = Math.min(paramInt2, 8192 - j);
                i = paramInt1 + 1;
                arrayOfByte[(paramInt1 + j)] = ((byte)k);
                paramInt1 = i;
                while (paramInt1 < m)
                {
                  i = paramString.charAt(paramInt1);
                  if (i >= 128) {
                    break;
                  }
                  arrayOfByte[(paramInt1 + j)] = ((byte)i);
                  paramInt1 += 1;
                }
                i = j + paramInt1 - ((o)localObject).c;
                ((o)localObject).c += i;
                this.b += i;
              }
              else if (k < 2048)
              {
                b(k >> 6 | 0xC0);
                b(k & 0x3F | 0x80);
                paramInt1 += 1;
              }
              else if ((k >= 55296) && (k <= 57343))
              {
                j = paramInt1 + 1;
                if (j < paramInt2) {
                  i = paramString.charAt(j);
                } else {
                  i = 0;
                }
                if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                {
                  i = ((k & 0xFFFF27FF) << 10 | 0xFFFF23FF & i) + 65536;
                  b(i >> 18 | 0xF0);
                  b(i >> 12 & 0x3F | 0x80);
                  b(i >> 6 & 0x3F | 0x80);
                  b(i & 0x3F | 0x80);
                  paramInt1 += 2;
                }
                else
                {
                  b(63);
                  paramInt1 = j;
                }
              }
              else
              {
                b(k >> 12 | 0xE0);
                b(k >> 6 & 0x3F | 0x80);
                b(k & 0x3F | 0x80);
                paramInt1 += 1;
              }
            }
            return this;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("endIndex > string.length: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(paramString.length());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public c a(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            if (paramCharset != null)
            {
              if (paramCharset.equals(u.a)) {
                return a(paramString, paramInt1, paramInt2);
              }
              paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return b(paramString, 0, paramString.length);
            }
            throw new IllegalArgumentException("charset == null");
          }
          paramCharset = new StringBuilder();
          paramCharset.append("endIndex > string.length: ");
          paramCharset.append(paramInt2);
          paramCharset.append(" > ");
          paramCharset.append(paramString.length());
          throw new IllegalArgumentException(paramCharset.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalAccessError(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public c a(String paramString, Charset paramCharset)
  {
    return a(paramString, 0, paramString.length(), paramCharset);
  }
  
  public String a(long paramLong, Charset paramCharset)
    throws EOFException
  {
    u.a(this.b, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        o localo = this.a;
        if (localo.b + paramLong > localo.c) {
          return new String(h(paramLong), paramCharset);
        }
        paramCharset = new String(localo.a, localo.b, (int)paramLong, paramCharset);
        localo.b = ((int)(localo.b + paramLong));
        this.b -= paramLong;
        if (localo.b == localo.c)
        {
          this.a = localo.b();
          p.a(localo);
        }
        return paramCharset;
      }
      paramCharset = new StringBuilder();
      paramCharset.append("byteCount > Integer.MAX_VALUE: ");
      paramCharset.append(paramLong);
      throw new IllegalArgumentException(paramCharset.toString());
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public String a(Charset paramCharset)
  {
    try
    {
      paramCharset = a(this.b, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public void a(long paramLong)
    throws EOFException
  {
    if (this.b >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  public void a(c paramc, long paramLong)
  {
    if (paramc != null)
    {
      if (paramc != this)
      {
        u.a(paramc.b, 0L, paramLong);
        while (paramLong > 0L)
        {
          if (paramLong < paramc.a.c - paramc.a.b)
          {
            if (this.a != null) {
              localo1 = this.a.g;
            } else {
              localo1 = null;
            }
            if ((localo1 != null) && (localo1.e))
            {
              l = localo1.c;
              int i;
              if (localo1.d) {
                i = 0;
              } else {
                i = localo1.b;
              }
              if (l + paramLong - i <= 8192L)
              {
                paramc.a.a(localo1, (int)paramLong);
                paramc.b -= paramLong;
                this.b += paramLong;
                return;
              }
            }
            paramc.a = paramc.a.a((int)paramLong);
          }
          o localo1 = paramc.a;
          long l = localo1.c - localo1.b;
          paramc.a = localo1.b();
          if (this.a == null)
          {
            this.a = localo1;
            localo1 = this.a;
            o localo2 = this.a;
            o localo3 = this.a;
            localo2.g = localo3;
            localo1.f = localo3;
          }
          else
          {
            this.a.g.a(localo1).c();
          }
          paramc.b -= l;
          this.b += l;
          paramLong -= l;
        }
        return;
      }
      throw new IllegalArgumentException("source == this");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public void a(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  public boolean a(long paramLong, f paramf)
  {
    return a(paramLong, paramf, 0, paramf.size());
  }
  
  public boolean a(long paramLong, f paramf, int paramInt1, int paramInt2)
  {
    if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0) && (this.b - paramLong >= paramInt2))
    {
      if (paramf.size() - paramInt1 < paramInt2) {
        return false;
      }
      int i = 0;
      while (i < paramInt2)
      {
        if (c(i + paramLong) != paramf.getByte(paramInt1 + i)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public c b()
  {
    return this;
  }
  
  public c b(int paramInt)
  {
    o localo = e(1);
    byte[] arrayOfByte = localo.a;
    int i = localo.c;
    localo.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public c b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public c b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      u.a(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        o localo = e(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localo.c);
        System.arraycopy(paramArrayOfByte, paramInt1, localo.a, localo.c, i);
        paramInt1 += i;
        localo.c += i;
      }
      this.b += l3;
      return this;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public boolean b(long paramLong)
  {
    return this.b >= paramLong;
  }
  
  public final byte c(long paramLong)
  {
    u.a(this.b, paramLong, 1L);
    long l;
    if (this.b - paramLong > paramLong) {
      for (localObject = this.a;; localObject = ((o)localObject).f)
      {
        l = ((o)localObject).c - ((o)localObject).b;
        if (paramLong < l) {
          return localObject.a[(localObject.b + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= this.b;
    Object localObject = this.a;
    o localo;
    do
    {
      localo = ((o)localObject).g;
      l = paramLong + (localo.c - localo.b);
      localObject = localo;
      paramLong = l;
    } while (l < 0L);
    return localo.a[(localo.b + (int)l)];
  }
  
  public c c(int paramInt)
  {
    o localo = e(2);
    byte[] arrayOfByte = localo.a;
    int i = localo.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localo.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public OutputStream c()
  {
    new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(c.this);
        localStringBuilder.append(".outputStream()");
        return localStringBuilder.toString();
      }
      
      public void write(int paramAnonymousInt)
      {
        c.this.b((byte)paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        c.this.b(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public void close() {}
  
  public c d()
  {
    return this;
  }
  
  public c d(int paramInt)
  {
    o localo = e(4);
    byte[] arrayOfByte = localo.a;
    int j = localo.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localo.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public f d(long paramLong)
    throws EOFException
  {
    return new f(h(paramLong));
  }
  
  o e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 8192))
    {
      Object localObject;
      if (this.a == null)
      {
        this.a = p.a();
        localObject = this.a;
        localo1 = this.a;
        o localo2 = this.a;
        localo1.g = localo2;
        ((o)localObject).f = localo2;
        return localo2;
      }
      o localo1 = this.a.g;
      if (localo1.c + paramInt <= 8192)
      {
        localObject = localo1;
        if (localo1.e) {}
      }
      else
      {
        localObject = localo1.a(p.a());
      }
      return (o)localObject;
    }
    throw new IllegalArgumentException();
  }
  
  public String e(long paramLong)
    throws EOFException
  {
    return a(paramLong, u.a);
  }
  
  public boolean e()
  {
    return this.b == 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    if (this.b != ((c)paramObject).b) {
      return false;
    }
    long l2 = this.b;
    long l1 = 0L;
    if (l2 == 0L) {
      return true;
    }
    o localo = this.a;
    paramObject = ((c)paramObject).a;
    int j = localo.b;
    int i = ((o)paramObject).b;
    while (l1 < this.b)
    {
      l2 = Math.min(localo.c - j, ((o)paramObject).c - i);
      int k = 0;
      while (k < l2)
      {
        if (localo.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        j += 1;
        i += 1;
      }
      if (j == localo.c)
      {
        localo = localo.f;
        j = localo.b;
      }
      if (i == ((o)paramObject).c)
      {
        paramObject = ((o)paramObject).f;
        i = ((o)paramObject).b;
      }
      l1 += l2;
    }
    return true;
  }
  
  public final f f(int paramInt)
  {
    if (paramInt == 0) {
      return f.EMPTY;
    }
    return new q(this, paramInt);
  }
  
  public InputStream f()
  {
    new InputStream()
    {
      public int available()
      {
        return (int)Math.min(c.this.b, 2147483647L);
      }
      
      public void close() {}
      
      public int read()
      {
        if (c.this.b > 0L) {
          return c.this.h() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return c.this.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(c.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public String f(long paramLong)
    throws EOFException
  {
    if (paramLong >= 0L)
    {
      long l1 = Long.MAX_VALUE;
      if (paramLong != Long.MAX_VALUE) {
        l1 = paramLong + 1L;
      }
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L) {
        return g(l2);
      }
      if ((l1 < a()) && (c(l1 - 1L) == 13) && (c(l1) == 10)) {
        return g(l1);
      }
      localObject = new c();
      a((c)localObject, 0L, Math.min(32L, a()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(a(), paramLong));
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
  
  public void flush() {}
  
  public final long g()
  {
    long l2 = this.b;
    if (l2 == 0L) {
      return 0L;
    }
    o localo = this.a.g;
    long l1 = l2;
    if (localo.c < 8192)
    {
      l1 = l2;
      if (localo.e) {
        l1 = l2 - (localo.c - localo.b);
      }
    }
    return l1;
  }
  
  String g(long paramLong)
    throws EOFException
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (c(l) == 13)
      {
        str = e(l);
        i(2L);
        return str;
      }
    }
    String str = e(paramLong);
    i(1L);
    return str;
  }
  
  public byte h()
  {
    if (this.b != 0L)
    {
      o localo = this.a;
      int i = localo.b;
      int j = localo.c;
      byte[] arrayOfByte = localo.a;
      int k = i + 1;
      byte b1 = arrayOfByte[i];
      this.b -= 1L;
      if (k == j)
      {
        this.a = localo.b();
        p.a(localo);
        return b1;
      }
      localo.b = k;
      return b1;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public byte[] h(long paramLong)
    throws EOFException
  {
    u.a(this.b, 0L, paramLong);
    if (paramLong <= 2147483647L)
    {
      localObject = new byte[(int)paramLong];
      a((byte[])localObject);
      return (byte[])localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount > Integer.MAX_VALUE: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int j;
    o localo;
    do
    {
      int k = ((o)localObject).b;
      int m = ((o)localObject).c;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.a[k];
        k += 1;
      }
      localo = ((o)localObject).f;
      localObject = localo;
      i = j;
    } while (localo != this.a);
    return j;
  }
  
  public short i()
  {
    if (this.b >= 2L)
    {
      localObject = this.a;
      int k = ((o)localObject).b;
      int i = ((o)localObject).c;
      if (i - k < 2) {
        return (short)((h() & 0xFF) << 8 | h() & 0xFF);
      }
      byte[] arrayOfByte = ((o)localObject).a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.b -= 2L;
      if (m == i)
      {
        this.a = ((o)localObject).b();
        p.a((o)localObject);
      }
      else
      {
        ((o)localObject).b = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 2: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void i(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L) {
      if (this.a != null)
      {
        int i = (int)Math.min(paramLong, this.a.c - this.a.b);
        long l1 = this.b;
        long l2 = i;
        this.b = (l1 - l2);
        l1 = paramLong - l2;
        o localo = this.a;
        localo.b += i;
        paramLong = l1;
        if (this.a.b == this.a.c)
        {
          localo = this.a;
          this.a = localo.b();
          p.a(localo);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public int j()
  {
    if (this.b >= 4L)
    {
      localObject = this.a;
      int j = ((o)localObject).b;
      int i = ((o)localObject).c;
      if (i - j < 4) {
        return (h() & 0xFF) << 24 | (h() & 0xFF) << 16 | (h() & 0xFF) << 8 | h() & 0xFF;
      }
      byte[] arrayOfByte = ((o)localObject).a;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      int i1 = arrayOfByte[n];
      n = m + 1;
      j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
      this.b -= 4L;
      if (n == i)
      {
        this.a = ((o)localObject).b();
        p.a((o)localObject);
        return j;
      }
      ((o)localObject).b = n;
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 4: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public c j(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return a("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    int k = i;
    if (j != 0) {
      k = i + 1;
    }
    o localo = e(k);
    byte[] arrayOfByte = localo.a;
    i = localo.c + k;
    while (l != 0L)
    {
      int m = (int)(l % 10L);
      i -= 1;
      arrayOfByte[i] = c[m];
      l /= 10L;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = 45;
    }
    localo.c += k;
    this.b += k;
    return this;
  }
  
  public c k(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    o localo = e(j);
    byte[] arrayOfByte = localo.a;
    int i = localo.c + j - 1;
    int k = localo.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localo.c += j;
    this.b += j;
    return this;
  }
  
  public short k()
  {
    return u.a(i());
  }
  
  public int l()
  {
    return u.a(j());
  }
  
  public long m()
  {
    if (this.b != 0L)
    {
      int i = 0;
      long l1 = 0L;
      int j = 0;
      long l2;
      int k;
      label232:
      label284:
      do
      {
        Object localObject1 = this.a;
        Object localObject2 = ((o)localObject1).a;
        int m = ((o)localObject1).b;
        int i1 = ((o)localObject1).c;
        l2 = l1;
        k = i;
        int n;
        for (;;)
        {
          n = j;
          if (m >= i1) {
            break label284;
          }
          n = localObject2[m];
          if ((n >= 48) && (n <= 57))
          {
            i = n - 48;
          }
          else if ((n >= 97) && (n <= 102))
          {
            i = n - 97 + 10;
          }
          else
          {
            if ((n < 65) || (n > 70)) {
              break label232;
            }
            i = n - 65 + 10;
          }
          if ((0xF000000000000000 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | i;
          m += 1;
          k += 1;
        }
        localObject1 = new c().k(l2).b(n);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((c)localObject1).o());
        throw new NumberFormatException(((StringBuilder)localObject2).toString());
        if (k != 0)
        {
          n = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(n));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (m == i1)
        {
          this.a = ((o)localObject1).b();
          p.a((o)localObject1);
        }
        else
        {
          ((o)localObject1).b = m;
        }
        if (n != 0) {
          break;
        }
        i = k;
        j = n;
        l1 = l2;
      } while (this.a != null);
      this.b -= k;
      return l2;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public f n()
  {
    return new f(r());
  }
  
  public String o()
  {
    try
    {
      String str = a(this.b, u.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String p()
    throws EOFException
  {
    return f(Long.MAX_VALUE);
  }
  
  public int q()
    throws EOFException
  {
    if (this.b != 0L)
    {
      int n = c(0L);
      int m = 1;
      int i;
      int j;
      int k;
      if ((n & 0x80) == 0)
      {
        i = n & 0x7F;
        j = 1;
        k = 0;
      }
      else if ((n & 0xE0) == 192)
      {
        i = n & 0x1F;
        j = 2;
        k = 128;
      }
      else if ((n & 0xF0) == 224)
      {
        i = n & 0xF;
        j = 3;
        k = 2048;
      }
      else
      {
        if ((n & 0xF8) != 240) {
          break label326;
        }
        i = n & 0x7;
        j = 4;
        k = 65536;
      }
      long l2 = this.b;
      long l1 = j;
      if (l2 >= l1)
      {
        while (m < j)
        {
          l2 = m;
          n = c(l2);
          if ((n & 0xC0) == 128)
          {
            i = i << 6 | n & 0x3F;
            m += 1;
          }
          else
          {
            i(l2);
            return 65533;
          }
        }
        i(l1);
        if (i > 1114111) {
          return 65533;
        }
        if ((i >= 55296) && (i <= 57343)) {
          return 65533;
        }
        if (i < k) {
          return 65533;
        }
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(j);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(Integer.toHexString(n));
      localStringBuilder.append(")");
      throw new EOFException(localStringBuilder.toString());
      label326:
      i(1L);
      return 65533;
    }
    throw new EOFException();
  }
  
  public byte[] r()
  {
    try
    {
      byte[] arrayOfByte = h(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    o localo = this.a;
    if (localo == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localo.c - localo.b);
    paramByteBuffer.put(localo.a, localo.b, i);
    localo.b += i;
    this.b -= i;
    if (localo.b == localo.c)
    {
      this.a = localo.b();
      p.a(localo);
    }
    return i;
  }
  
  public long read(c paramc, long paramLong)
  {
    if (paramc != null)
    {
      if (paramLong >= 0L)
      {
        if (this.b == 0L) {
          return -1L;
        }
        long l = paramLong;
        if (paramLong > this.b) {
          l = this.b;
        }
        paramc.a(this, l);
        return l;
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public final void s()
  {
    try
    {
      i(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public c t()
  {
    c localc = new c();
    if (this.b == 0L) {
      return localc;
    }
    localc.a = this.a.a();
    o localo1 = localc.a;
    o localo2 = localc.a;
    o localo3 = localc.a;
    localo2.g = localo3;
    localo1.f = localo3;
    localo1 = this.a;
    for (;;)
    {
      localo1 = localo1.f;
      if (localo1 == this.a) {
        break;
      }
      localc.a.g.a(localo1.a());
    }
    localc.b = this.b;
    return localc;
  }
  
  public t timeout()
  {
    return t.c;
  }
  
  public String toString()
  {
    return u().toString();
  }
  
  public final f u()
  {
    if (this.b <= 2147483647L) {
      return f((int)this.b);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Integer.MAX_VALUE: ");
    localStringBuilder.append(this.b);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer != null)
    {
      int j = paramByteBuffer.remaining();
      int i = j;
      while (i > 0)
      {
        o localo = e(1);
        int k = Math.min(i, 8192 - localo.c);
        paramByteBuffer.get(localo.a, localo.c, k);
        i -= k;
        localo.c += k;
      }
      this.b += j;
      return j;
    }
    throw new IllegalArgumentException("source == null");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */