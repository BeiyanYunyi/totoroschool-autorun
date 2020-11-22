package e.a.e;

import f.e;
import f.f;
import f.l;
import f.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class d
{
  static final c[] a = { new c(c.f, ""), new c(c.c, "GET"), new c(c.c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.b, "200"), new c(c.b, "204"), new c(c.b, "206"), new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "") };
  static final Map<f, Integer> b = a();
  
  static f a(f paramf)
    throws IOException
  {
    int j = paramf.size();
    int i = 0;
    while (i < j)
    {
      int k = paramf.getByte(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramf.utf8());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramf;
  }
  
  private static Map<f, Integer> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    int i = 0;
    while (i < a.length)
    {
      if (!localLinkedHashMap.containsKey(a[i].g)) {
        localLinkedHashMap.put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class a
  {
    c[] a = new c[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<c> e = new ArrayList();
    private final e f;
    private final int g;
    private int h;
    
    a(int paramInt1, int paramInt2, s params)
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.f = l.a(params);
    }
    
    a(int paramInt, s params)
    {
      this(paramInt, paramInt, params);
    }
    
    private int a(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.a.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.b) && (j > 0))
        {
          j -= this.a[i].i;
          this.d -= this.a[i].i;
          this.c -= 1;
          paramInt += 1;
          i -= 1;
        }
        System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + paramInt, this.c);
        this.b += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private void a(int paramInt, c paramc)
    {
      this.e.add(paramc);
      int j = paramc.i;
      int i = j;
      if (paramInt != -1) {
        i = j - this.a[c(paramInt)].i;
      }
      if (i > this.h)
      {
        e();
        return;
      }
      j = a(this.d + i - this.h);
      if (paramInt == -1)
      {
        if (this.c + 1 > this.a.length)
        {
          c[] arrayOfc = new c[this.a.length * 2];
          System.arraycopy(this.a, 0, arrayOfc, this.a.length, this.a.length);
          this.b = (this.a.length - 1);
          this.a = arrayOfc;
        }
        paramInt = this.b;
        this.b = (paramInt - 1);
        this.a[paramInt] = paramc;
        this.c += 1;
      }
      else
      {
        int k = c(paramInt);
        this.a[(paramInt + (k + j))] = paramc;
      }
      this.d += i;
    }
    
    private void b(int paramInt)
      throws IOException
    {
      if (g(paramInt))
      {
        localObject = d.a[paramInt];
        this.e.add(localObject);
        return;
      }
      int i = c(paramInt - d.a.length);
      if ((i >= 0) && (i < this.a.length))
      {
        this.e.add(this.a[i]);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Header index too large ");
      ((StringBuilder)localObject).append(paramInt + 1);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    private int c(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private void d()
    {
      if (this.h < this.d)
      {
        if (this.h == 0)
        {
          e();
          return;
        }
        a(this.d - this.h);
      }
    }
    
    private void d(int paramInt)
      throws IOException
    {
      f localf1 = f(paramInt);
      f localf2 = c();
      this.e.add(new c(localf1, localf2));
    }
    
    private void e()
    {
      Arrays.fill(this.a, null);
      this.b = (this.a.length - 1);
      this.c = 0;
      this.d = 0;
    }
    
    private void e(int paramInt)
      throws IOException
    {
      a(-1, new c(f(paramInt), c()));
    }
    
    private f f(int paramInt)
      throws IOException
    {
      if (g(paramInt)) {
        return d.a[paramInt].g;
      }
      int i = c(paramInt - d.a.length);
      if ((i >= 0) && (i < this.a.length)) {
        return this.a[i].g;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Header index too large ");
      localStringBuilder.append(paramInt + 1);
      throw new IOException(localStringBuilder.toString());
    }
    
    private void f()
      throws IOException
    {
      f localf1 = d.a(c());
      f localf2 = c();
      this.e.add(new c(localf1, localf2));
    }
    
    private void g()
      throws IOException
    {
      a(-1, new c(d.a(c()), c()));
    }
    
    private boolean g(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= d.a.length - 1);
    }
    
    private int h()
      throws IOException
    {
      return this.f.h() & 0xFF;
    }
    
    int a(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = h();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
    
    void a()
      throws IOException
    {
      while (!this.f.e())
      {
        int i = this.f.h() & 0xFF;
        if (i != 128)
        {
          if ((i & 0x80) == 128)
          {
            b(a(i, 127) - 1);
          }
          else if (i == 64)
          {
            g();
          }
          else if ((i & 0x40) == 64)
          {
            e(a(i, 63) - 1);
          }
          else if ((i & 0x20) == 32)
          {
            this.h = a(i, 31);
            if ((this.h >= 0) && (this.h <= this.g))
            {
              d();
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Invalid dynamic table size update ");
              localStringBuilder.append(this.h);
              throw new IOException(localStringBuilder.toString());
            }
          }
          else if ((i != 16) && (i != 0))
          {
            d(a(i, 15) - 1);
          }
          else
          {
            f();
          }
        }
        else {
          throw new IOException("index == 0");
        }
      }
    }
    
    public List<c> b()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
    
    f c()
      throws IOException
    {
      int j = h();
      int i;
      if ((j & 0x80) == 128) {
        i = 1;
      } else {
        i = 0;
      }
      j = a(j, 127);
      if (i != 0) {
        return f.of(k.a().a(this.f.h(j)));
      }
      return this.f.d(j);
    }
  }
  
  static final class b
  {
    int a;
    int b;
    c[] c = new c[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final f.c g;
    private final boolean h;
    private int i = Integer.MAX_VALUE;
    private boolean j;
    
    b(int paramInt, boolean paramBoolean, f.c paramc)
    {
      this.a = paramInt;
      this.b = paramInt;
      this.h = paramBoolean;
      this.g = paramc;
    }
    
    b(f.c paramc)
    {
      this(4096, true, paramc);
    }
    
    private void a()
    {
      Arrays.fill(this.c, null);
      this.d = (this.c.length - 1);
      this.e = 0;
      this.f = 0;
    }
    
    private void a(c paramc)
    {
      int k = paramc.i;
      if (k > this.b)
      {
        a();
        return;
      }
      b(this.f + k - this.b);
      if (this.e + 1 > this.c.length)
      {
        c[] arrayOfc = new c[this.c.length * 2];
        System.arraycopy(this.c, 0, arrayOfc, this.c.length, this.c.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfc;
      }
      int m = this.d;
      this.d = (m - 1);
      this.c[m] = paramc;
      this.e += 1;
      this.f += k;
    }
    
    private int b(int paramInt)
    {
      int k = 0;
      int n = 0;
      if (paramInt > 0)
      {
        k = this.c.length - 1;
        int m = paramInt;
        paramInt = n;
        while ((k >= this.d) && (m > 0))
        {
          m -= this.c[k].i;
          this.f -= this.c[k].i;
          this.e -= 1;
          paramInt += 1;
          k -= 1;
        }
        System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + paramInt, this.e);
        Arrays.fill(this.c, this.d + 1, this.d + 1 + paramInt, null);
        this.d += paramInt;
        k = paramInt;
      }
      return k;
    }
    
    private void b()
    {
      if (this.b < this.f)
      {
        if (this.b == 0)
        {
          a();
          return;
        }
        b(this.f - this.b);
      }
    }
    
    void a(int paramInt)
    {
      this.a = paramInt;
      paramInt = Math.min(paramInt, 16384);
      if (this.b == paramInt) {
        return;
      }
      if (paramInt < this.b) {
        this.i = Math.min(this.i, paramInt);
      }
      this.j = true;
      this.b = paramInt;
      b();
    }
    
    void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.g.b(paramInt1 | paramInt3);
        return;
      }
      this.g.b(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.g.b(0x80 | paramInt1 & 0x7F);
        paramInt1 >>>= 7;
      }
      this.g.b(paramInt1);
    }
    
    void a(f paramf)
      throws IOException
    {
      if ((this.h) && (k.a().a(paramf) < paramf.size()))
      {
        f.c localc = new f.c();
        k.a().a(paramf, localc);
        paramf = localc.n();
        a(paramf.size(), 127, 128);
        this.g.a(paramf);
        return;
      }
      a(paramf.size(), 127, 0);
      this.g.a(paramf);
    }
    
    void a(List<c> paramList)
      throws IOException
    {
      if (this.j)
      {
        if (this.i < this.b) {
          a(this.i, 31, 32);
        }
        this.j = false;
        this.i = Integer.MAX_VALUE;
        a(this.b, 31, 32);
      }
      int i4 = paramList.size();
      int n = 0;
      while (n < i4)
      {
        c localc = (c)paramList.get(n);
        f localf1 = localc.g.toAsciiLowercase();
        f localf2 = localc.h;
        Integer localInteger = (Integer)d.b.get(localf1);
        int m;
        int k;
        if (localInteger != null)
        {
          m = localInteger.intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            if (e.a.c.a(d.a[(m - 1)].h, localf2))
            {
              k = m;
              break label199;
            }
            if (e.a.c.a(d.a[m].h, localf2))
            {
              k = m;
              m += 1;
              break label199;
            }
          }
          k = m;
          m = -1;
        }
        else
        {
          m = -1;
          k = -1;
        }
        label199:
        int i2 = m;
        int i3 = k;
        if (m == -1)
        {
          int i1 = this.d + 1;
          int i5 = this.c.length;
          for (;;)
          {
            i2 = m;
            i3 = k;
            if (i1 >= i5) {
              break;
            }
            i2 = k;
            if (e.a.c.a(this.c[i1].g, localf1))
            {
              if (e.a.c.a(this.c[i1].h, localf2))
              {
                m = this.d;
                i2 = d.a.length + (i1 - m);
                i3 = k;
                break;
              }
              i2 = k;
              if (k == -1) {
                i2 = i1 - this.d + d.a.length;
              }
            }
            i1 += 1;
            k = i2;
          }
        }
        if (i2 != -1)
        {
          a(i2, 127, 128);
        }
        else if (i3 == -1)
        {
          this.g.b(64);
          a(localf1);
          a(localf2);
          a(localc);
        }
        else if ((localf1.startsWith(c.a)) && (!c.f.equals(localf1)))
        {
          a(i3, 15, 0);
          a(localf2);
        }
        else
        {
          a(i3, 63, 64);
          a(localf2);
          a(localc);
        }
        n += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */