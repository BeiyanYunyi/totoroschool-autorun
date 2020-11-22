package c.e.a;

import c.a.ag;
import c.a.e;
import c.a.e.a;
import c.b.a;
import c.d.a.b;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

final class n
  extends e
{
  private static c.b.c c = c.b.c.a(n.class);
  private OutputStream d;
  private aa e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private ArrayList w;
  private HashMap x;
  private int y;
  private byte[] z;
  
  public n(aa paramaa, int paramInt, OutputStream paramOutputStream, c.d.a.c paramc)
    throws o, IOException
  {
    this.f = paramInt;
    this.e = paramaa;
    a(paramc);
    this.v = 1;
    if (this.w != null) {
      i1 = this.w.size();
    } else {
      i1 = 0;
    }
    this.u = (i1 + 4);
    if (this.w != null)
    {
      this.i = a(this.t * 4);
      this.j = a(this.t * 64);
      this.v += a(this.w.size() * 128);
    }
    int i1 = a(paramInt);
    if (paramInt < 4096) {
      this.g = 4096;
    } else {
      this.g = (i1 * 512);
    }
    this.d = paramOutputStream;
    this.m = (this.g / 512);
    this.h = 1;
    i1 = this.m + 8 + 8 + this.s + this.j + this.i + this.v;
    double d1 = this.h + i1;
    Double.isNaN(d1);
    this.h = ((int)Math.ceil(d1 / 128.0D));
    d1 = this.h + i1;
    Double.isNaN(d1);
    this.h = ((int)Math.ceil(d1 / 128.0D));
    paramInt = this.h + i1;
    if (this.h > 108)
    {
      this.l = 0;
      d1 = this.h - 109 + 1;
      Double.isNaN(d1);
      this.k = ((int)Math.ceil(d1 / 127.0D));
      d1 = this.k + i1 + this.h;
      Double.isNaN(d1);
      this.h = ((int)Math.ceil(d1 / 128.0D));
      paramInt = i1 + this.k + this.h;
    }
    else
    {
      this.l = -2;
      this.k = 0;
    }
    this.o = this.k;
    this.r = -2;
    if ((this.w != null) && (this.j != 0)) {
      this.r = (this.o + this.m + this.s + 16);
    }
    this.q = -2;
    if (this.r != -2) {
      this.q = (this.r + this.j);
    }
    if (this.q != -2) {
      this.p = (this.q + this.i);
    } else {
      this.p = (this.o + this.m + this.s + 16);
    }
    this.n = (this.p + this.h);
    if (paramInt != this.n + this.v)
    {
      c.b("Root start block and total blocks are inconsistent  generated file may be corrupt");
      paramaa = c;
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("RootStartBlock ");
      paramOutputStream.append(this.n);
      paramOutputStream.append(" totalBlocks ");
      paramOutputStream.append(paramInt);
      paramaa.b(paramOutputStream.toString());
    }
  }
  
  private int a(int paramInt)
  {
    int i2 = paramInt / 512;
    int i1 = i2;
    if (paramInt % 512 > 0) {
      i1 = i2 + 1;
    }
    return i1;
  }
  
  private void a(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 -= 1;
    int i1 = paramInt1 + 1;
    paramInt1 = paramInt2;
    paramInt2 = i1;
    while (paramInt1 > 0)
    {
      int i2 = Math.min(paramInt1, (512 - this.y) / 4);
      i1 = 0;
      while (i1 < i2)
      {
        ag.b(paramInt2, this.z, this.y);
        this.y += 4;
        paramInt2 += 1;
        i1 += 1;
      }
      paramInt1 -= i2;
      g();
    }
    ag.b(-2, this.z, this.y);
    this.y += 4;
    g();
  }
  
  private void a(c.d.a.c paramc)
    throws o, IOException
  {
    if (paramc == null) {
      return;
    }
    this.w = new ArrayList();
    this.x = new HashMap();
    int i6 = paramc.a();
    int i2 = 0;
    int i4;
    for (int i3 = 0; i2 < i6; i3 = i4)
    {
      Object localObject2 = paramc.b(i2);
      Object localObject1;
      int i1;
      if (((e.a)localObject2).a.equalsIgnoreCase("Root Entry"))
      {
        localObject1 = new a((e.a)localObject2, null, i2);
        this.x.put("Root Entry", localObject1);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      i4 = 0;
      while ((i4 < b.length) && (i1 == 0))
      {
        int i5 = i1;
        if (((e.a)localObject2).a.equalsIgnoreCase(b[i4]))
        {
          localObject1 = paramc.a(((e.a)localObject2).a);
          boolean bool;
          if (localObject1 != null) {
            bool = true;
          } else {
            bool = false;
          }
          a.a(bool);
          i5 = i1;
          if (localObject1 == localObject2)
          {
            localObject1 = new a((e.a)localObject2, null, i2);
            this.x.put(b[i4], localObject1);
            i5 = 1;
          }
        }
        i4 += 1;
        i1 = i5;
      }
      i4 = i3;
      if (i1 == 0) {
        try
        {
          if (((e.a)localObject2).e > 0) {
            localObject1 = paramc.a(i2);
          } else {
            localObject1 = new byte[0];
          }
          localObject2 = new a((e.a)localObject2, (byte[])localObject1, i2);
          this.w.add(localObject2);
          if (localObject1.length > 4096)
          {
            i4 = i3 + a(localObject1.length);
          }
          else
          {
            i1 = b(localObject1.length);
            this.t += i1;
            i4 = i3;
          }
        }
        catch (b paramc)
        {
          c.a(paramc);
          throw new o();
        }
      }
      i2 += 1;
    }
    this.s = i3;
  }
  
  private int b(int paramInt)
  {
    int i2 = paramInt / 64;
    int i1 = i2;
    if (paramInt % 64 > 0) {
      i1 = i2 + 1;
    }
    return i1;
  }
  
  private void b()
    throws IOException
  {
    if (this.w == null) {
      return;
    }
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = ((a)localIterator.next()).b;
      if (arrayOfByte.length > 4096)
      {
        int i1 = a(arrayOfByte.length);
        this.d.write(arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = new byte[i1 * 512 - arrayOfByte.length];
        this.d.write(arrayOfByte, 0, arrayOfByte.length);
      }
    }
  }
  
  private void c()
    throws IOException
  {
    this.e.a(this.d);
    byte[] arrayOfByte = new byte[this.g - this.f];
    this.d.write(arrayOfByte);
  }
  
  private void d()
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    this.d.write(arrayOfByte);
  }
  
  private void e()
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    this.d.write(arrayOfByte);
  }
  
  private void f()
    throws IOException
  {
    byte[] arrayOfByte1 = new byte['Ȁ'];
    byte[] arrayOfByte2 = new byte[this.k * 512];
    System.arraycopy(a, 0, arrayOfByte1, 0, a.length);
    arrayOfByte1[24] = 62;
    arrayOfByte1[26] = 3;
    arrayOfByte1[28] = -2;
    arrayOfByte1[29] = -1;
    arrayOfByte1[30] = 9;
    arrayOfByte1[32] = 6;
    arrayOfByte1[57] = 16;
    ag.b(this.h, arrayOfByte1, 44);
    ag.b(this.q, arrayOfByte1, 60);
    ag.b(this.i, arrayOfByte1, 64);
    ag.b(this.l, arrayOfByte1, 68);
    ag.b(this.k, arrayOfByte1, 72);
    ag.b(this.n, arrayOfByte1, 48);
    int i5 = Math.min(this.h, 109);
    int i3 = 0;
    int i2 = 76;
    int i1 = 0;
    for (;;)
    {
      i4 = i2;
      if (i3 >= i5) {
        break;
      }
      ag.b(this.p + i3, arrayOfByte1, i2);
      i2 += 4;
      i1 += 1;
      i3 += 1;
    }
    while (i4 < 512)
    {
      arrayOfByte1[i4] = -1;
      i4 += 1;
    }
    this.d.write(arrayOfByte1);
    i2 = 0;
    int i4 = 0;
    i3 = i1;
    i1 = i4;
    while (i2 < this.k)
    {
      i5 = Math.min(this.h - i3, 127);
      i4 = 0;
      while (i4 < i5)
      {
        ag.b(this.p + i3 + i4, arrayOfByte2, i1);
        i1 += 4;
        i4 += 1;
      }
      i4 = i3 + i5;
      if (i4 == this.h) {
        i3 = -2;
      } else {
        i3 = i2 + 1;
      }
      ag.b(i3, arrayOfByte2, i1);
      i1 += 4;
      i2 += 1;
      i3 = i4;
    }
    if (this.k > 0)
    {
      while (i1 < arrayOfByte2.length)
      {
        arrayOfByte2[i1] = -1;
        i1 += 1;
      }
      this.d.write(arrayOfByte2);
    }
  }
  
  private void g()
    throws IOException
  {
    if (this.y >= 512)
    {
      this.d.write(this.z);
      this.z = new byte['Ȁ'];
      this.y = 0;
    }
  }
  
  private void h()
    throws IOException
  {
    if (this.w == null) {
      return;
    }
    int i1 = this.o + this.m + 16;
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.length > 4096)
      {
        int i2 = a(locala.b.length);
        a(i1, i2);
        i1 += i2;
      }
    }
  }
  
  private void i()
    throws IOException
  {
    if (this.q == -2) {
      return;
    }
    byte[] arrayOfByte = new byte[this.i * 512];
    Iterator localIterator = this.w.iterator();
    int i2 = 0;
    int i1 = 1;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala.b.length <= 4096) && (locala.b.length != 0))
      {
        int i5 = b(locala.b.length);
        int i4 = 0;
        int i3 = i1;
        i1 = i4;
        while (i1 < i5 - 1)
        {
          ag.b(i3, arrayOfByte, i2);
          i2 += 4;
          i3 += 1;
          i1 += 1;
        }
        ag.b(-2, arrayOfByte, i2);
        i1 = i3 + 1;
        i2 += 4;
      }
    }
    this.d.write(arrayOfByte);
  }
  
  private void j()
    throws IOException
  {
    if (this.w == null) {
      return;
    }
    byte[] arrayOfByte = new byte[this.j * 512];
    Iterator localIterator = this.w.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.length <= 4096)
      {
        int i2 = b(locala.b.length);
        System.arraycopy(locala.b, 0, arrayOfByte, i1, locala.b.length);
        i1 += i2 * 64;
      }
    }
    this.d.write(arrayOfByte);
  }
  
  private void k()
    throws IOException
  {
    this.z = new byte['Ȁ'];
    int i2 = 0;
    this.y = 0;
    int i1 = 0;
    while (i1 < this.k)
    {
      ag.b(-3, this.z, this.y);
      this.y += 4;
      g();
      i1 += 1;
    }
    a(this.o, this.m);
    int i3 = this.o + this.m + this.s;
    i1 = i3;
    while (i1 < i3 + 7)
    {
      i1 += 1;
      ag.b(i1, this.z, this.y);
      this.y += 4;
      g();
    }
    ag.b(-2, this.z, this.y);
    this.y += 4;
    g();
    i1 = i3 + 8;
    while (i1 < i3 + 15)
    {
      i1 += 1;
      ag.b(i1, this.z, this.y);
      this.y += 4;
      g();
    }
    ag.b(-2, this.z, this.y);
    this.y += 4;
    g();
    h();
    i1 = i2;
    if (this.r != -2)
    {
      a(this.r, this.j);
      a(this.q, this.i);
      i1 = i2;
    }
    while (i1 < this.h)
    {
      ag.b(-3, this.z, this.y);
      this.y += 4;
      g();
      i1 += 1;
    }
    a(this.n, this.v);
    if (this.y != 0)
    {
      i1 = this.y;
      while (i1 < 512)
      {
        this.z[i1] = -1;
        i1 += 1;
      }
      this.d.write(this.z);
    }
  }
  
  private void l()
    throws IOException
  {
    byte[] arrayOfByte = new byte[this.v * 512];
    Object localObject1 = this.w;
    int i3 = 1;
    if (localObject1 != null)
    {
      localObject2 = new int[this.u];
      i1 = 0;
      while (i1 < b.length)
      {
        localObject1 = (a)this.x.get(b[i1]);
        if (localObject1 != null)
        {
          localObject2[localObject1.c] = i1;
        }
        else
        {
          localObject1 = c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Standard property set ");
          ((StringBuilder)localObject3).append(b[i1]);
          ((StringBuilder)localObject3).append(" not present in source file");
          ((c.b.c)localObject1).b(((StringBuilder)localObject3).toString());
        }
        i1 += 1;
      }
      i1 = b.length;
      localObject3 = this.w.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2[((a)localObject3.next()).c] = i1;
        i1 += 1;
      }
    }
    localObject1 = null;
    if (this.w != null)
    {
      i1 = a(this.g) * 512 + 0 + a(4096) * 512 + a(4096) * 512;
      localObject2 = this.w.iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (a)((Iterator)localObject2).next();
        if (((a)localObject3).a.b != 1) {
          if (((a)localObject3).a.e >= 4096) {
            i1 += a(((a)localObject3).a.e) * 512;
          } else {
            i1 += b(((a)localObject3).a.e) * 64;
          }
        }
      }
    }
    int i2 = 0;
    Object localObject2 = new e.a(this, "Root Entry");
    ((e.a)localObject2).a(5);
    ((e.a)localObject2).b(this.r);
    ((e.a)localObject2).c(i2);
    ((e.a)localObject2).d(-1);
    ((e.a)localObject2).e(-1);
    ((e.a)localObject2).g(0);
    if (this.w != null) {
      i1 = localObject1[((a)this.x.get("Root Entry")).a.h];
    } else {
      i1 = 1;
    }
    ((e.a)localObject2).f(i1);
    System.arraycopy(((e.a)localObject2).i, 0, arrayOfByte, 0, 128);
    localObject2 = new e.a(this, "Workbook");
    ((e.a)localObject2).a(2);
    ((e.a)localObject2).b(this.o);
    ((e.a)localObject2).c(this.g);
    Object localObject3 = this.w;
    int i4 = 3;
    if (localObject3 != null)
    {
      localObject3 = (a)this.x.get("Workbook");
      if (((a)localObject3).a.f != -1) {
        i1 = localObject1[localObject3.a.f];
      } else {
        i1 = -1;
      }
      if (((a)localObject3).a.g != -1) {
        i2 = localObject1[localObject3.a.g];
      } else {
        i2 = -1;
      }
    }
    else
    {
      i2 = -1;
      i1 = 3;
    }
    ((e.a)localObject2).d(i1);
    ((e.a)localObject2).e(i2);
    ((e.a)localObject2).f(-1);
    System.arraycopy(((e.a)localObject2).i, 0, arrayOfByte, 128, 128);
    localObject2 = new e.a(this, "\005SummaryInformation");
    ((e.a)localObject2).a(2);
    ((e.a)localObject2).b(this.o + this.m);
    ((e.a)localObject2).c(4096);
    i2 = i3;
    int i1 = i4;
    if (this.w != null)
    {
      localObject3 = (a)this.x.get("\005SummaryInformation");
      i2 = i3;
      i1 = i4;
      if (localObject3 != null)
      {
        if (((a)localObject3).a.f != -1) {
          i2 = localObject1[localObject3.a.f];
        } else {
          i2 = -1;
        }
        if (((a)localObject3).a.g != -1) {
          i1 = localObject1[localObject3.a.g];
        } else {
          i1 = -1;
        }
      }
    }
    ((e.a)localObject2).d(i2);
    ((e.a)localObject2).e(i1);
    ((e.a)localObject2).f(-1);
    System.arraycopy(((e.a)localObject2).i, 0, arrayOfByte, 256, 128);
    localObject2 = new e.a(this, "\005DocumentSummaryInformation");
    ((e.a)localObject2).a(2);
    ((e.a)localObject2).b(this.o + this.m + 8);
    ((e.a)localObject2).c(4096);
    ((e.a)localObject2).d(-1);
    ((e.a)localObject2).e(-1);
    ((e.a)localObject2).f(-1);
    System.arraycopy(((e.a)localObject2).i, 0, arrayOfByte, 384, 128);
    if (this.w == null)
    {
      this.d.write(arrayOfByte);
      return;
    }
    i1 = this.o + this.m + 16;
    localObject2 = this.w.iterator();
    i2 = 0;
    i3 = 512;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (((a)localObject3).b.length > 4096) {
        i4 = i1;
      } else {
        i4 = i2;
      }
      e.a locala = new e.a(this, ((a)localObject3).a.a);
      locala.a(((a)localObject3).a.b);
      locala.b(i4);
      locala.c(((a)localObject3).a.e);
      if (((a)localObject3).a.f != -1) {
        i4 = localObject1[localObject3.a.f];
      } else {
        i4 = -1;
      }
      int i5;
      if (((a)localObject3).a.g != -1) {
        i5 = localObject1[localObject3.a.g];
      } else {
        i5 = -1;
      }
      int i6;
      if (((a)localObject3).a.h != -1) {
        i6 = localObject1[localObject3.a.h];
      } else {
        i6 = -1;
      }
      locala.d(i4);
      locala.e(i5);
      locala.f(i6);
      System.arraycopy(locala.i, 0, arrayOfByte, i3, 128);
      i3 += 128;
      if (((a)localObject3).b.length > 4096) {
        i1 += a(((a)localObject3).b.length);
      } else {
        i2 += b(((a)localObject3).b.length);
      }
    }
    this.d.write(arrayOfByte);
  }
  
  public void a()
    throws IOException
  {
    f();
    c();
    d();
    e();
    b();
    j();
    i();
    k();
    l();
  }
  
  private static final class a
  {
    e.a a;
    byte[] b;
    int c;
    
    a(e.a parama, byte[] paramArrayOfByte, int paramInt)
    {
      this.a = parama;
      this.b = paramArrayOfByte;
      this.c = paramInt;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */