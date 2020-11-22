package c.e.a;

import c.a.af;
import c.a.ag;
import c.a.an;
import c.a.aq;
import c.a.q;
import c.b.c;
import c.d;
import c.e.e;
import c.e.h;
import c.e.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class bt
  extends aq
{
  private static final c a = c.a(bt.class);
  private static int j = 255;
  private static int k = 256;
  private j[] b;
  private int c;
  private boolean d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private boolean i;
  private int l;
  private boolean m;
  private l n;
  
  public bt(int paramInt, l paraml)
  {
    super(an.j);
    this.e = paramInt;
    this.b = new j[0];
    this.f = 0;
    this.c = j;
    this.d = false;
    this.i = true;
    this.n = paraml;
  }
  
  private void a(ArrayList paramArrayList, ae paramae)
    throws IOException
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    if (paramArrayList.size() >= 3)
    {
      paramae.a(new bb(paramArrayList));
    }
    else
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramae.a((j)localIterator.next());
      }
    }
    paramArrayList.clear();
  }
  
  public j a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f)) {
      return this.b[paramInt];
    }
    return null;
  }
  
  void a(af paramaf)
  {
    if (this.h) {
      this.g = paramaf.a(this.g);
    }
  }
  
  public void a(ae paramae)
    throws IOException
  {
    paramae.a(this);
  }
  
  public void a(j paramj)
  {
    int i1 = paramj.b();
    Object localObject;
    if (i1 >= k)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not add cell at ");
      localStringBuilder.append(c.a.k.a(paramj.j_(), paramj.b()));
      localStringBuilder.append(" because it exceeds the maximum column limit");
      ((c)localObject).b(localStringBuilder.toString());
      return;
    }
    if (i1 >= this.b.length)
    {
      localObject = this.b;
      this.b = new j[Math.max(localObject.length + 10, i1 + 1)];
      System.arraycopy(localObject, 0, this.b, 0, localObject.length);
    }
    if (this.b[i1] != null)
    {
      localObject = this.b[i1].k_();
      if (localObject != null)
      {
        ((h)localObject).d();
        if ((((h)localObject).h() != null) && (!((h)localObject).h().f())) {
          ((h)localObject).e();
        }
      }
    }
    this.b[i1] = paramj;
    this.f = Math.max(i1 + 1, this.f);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[16];
    int i2 = this.c;
    int i1 = i2;
    if (this.n.d().y() != 255)
    {
      i1 = i2;
      if (i2 == j) {
        i1 = this.n.d().y();
      }
    }
    ag.a(this.e, arrayOfByte, 0);
    ag.a(this.f, arrayOfByte, 4);
    ag.a(i1, arrayOfByte, 6);
    i2 = this.l + 256;
    i1 = i2;
    if (this.m) {
      i1 = i2 | 0x10;
    }
    i2 = i1;
    if (this.d) {
      i2 = i1 | 0x20;
    }
    i1 = i2;
    if (!this.i) {
      i1 = i2 | 0x40;
    }
    i2 = i1;
    if (this.h) {
      i2 = i1 | 0x80 | this.g << 16;
    }
    ag.b(i2, arrayOfByte, 12);
    return arrayOfByte;
  }
  
  public void b(ae paramae)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.f)
    {
      if (this.b[i1] != null)
      {
        if (this.b[i1].c() == d.c)
        {
          e locale = (e)this.b[i1];
          if ((locale.l() == (int)locale.l()) && (locale.l() < 5.36870911E8D) && (locale.l() > -5.36870912E8D) && (locale.f() == null))
          {
            i2 = 1;
            break label109;
          }
        }
        int i2 = 0;
        label109:
        if (i2 != 0)
        {
          localArrayList.add(this.b[i1]);
        }
        else
        {
          a(localArrayList, paramae);
          paramae.a(this.b[i1]);
          if (this.b[i1].c() == d.h) {
            paramae.a(new ce(this.b[i1].d()));
          }
        }
      }
      else
      {
        a(localArrayList, paramae);
      }
      i1 += 1;
    }
    a(localArrayList, paramae);
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */