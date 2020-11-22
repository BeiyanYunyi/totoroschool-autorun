package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;
import c.a.g;
import c.b.c;

class bc
  extends aq
{
  private static c a = c.a(bc.class);
  private static final a i = new a(0, 0, 0, 0, 0);
  private byte[] b;
  private String c;
  private g d;
  private int e;
  private int f = 0;
  private boolean g;
  private a[] h;
  
  bc(g paramg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean)
  {
    super(an.z);
    this.d = paramg;
    this.e = paramInt1;
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.e + 1;
    }
    this.f = paramInt1;
    this.h = new a[2];
    this.h[0] = new a(paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.h[1] = new a(paramInt2, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  bc(g paramg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    super(an.z);
    this.d = paramg;
    this.e = paramInt1;
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = this.e + 1;
    }
    this.f = paramInt1;
    this.h = new a[1];
    this.h[0] = new a(paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public byte[] a()
  {
    if ((this.b != null) && (!this.g)) {
      return this.b;
    }
    int k = this.h.length;
    int j = 11;
    if (k > 1) {
      j = this.h.length * 11 + 4;
    }
    if (this.d != null) {
      k = 1;
    } else {
      k = this.c.length();
    }
    this.b = new byte[j + 15 + k];
    if (this.d != null) {
      k = 32;
    } else {
      k = 0;
    }
    ag.a(k, this.b, 0);
    this.b[2] = 0;
    if (this.d != null) {
      this.b[3] = 1;
    } else {
      this.b[3] = ((byte)this.c.length());
    }
    ag.a(j, this.b, 4);
    ag.a(this.f, this.b, 6);
    ag.a(this.f, this.b, 8);
    if (this.d != null) {
      this.b[15] = ((byte)this.d.a());
    } else {
      am.a(this.c, this.b, 15);
    }
    if (this.d != null) {
      k = 16;
    } else {
      k = this.c.length() + 15;
    }
    byte[] arrayOfByte;
    if (this.h.length > 1)
    {
      arrayOfByte = this.b;
      int m = k + 1;
      arrayOfByte[k] = 41;
      ag.a(j - 3, this.b, m);
      k = m + 2;
      j = 0;
      while (j < this.h.length)
      {
        arrayOfByte = this.b;
        m = k + 1;
        arrayOfByte[k] = 59;
        arrayOfByte = this.h[j].a();
        System.arraycopy(arrayOfByte, 0, this.b, m, arrayOfByte.length);
        k = m + arrayOfByte.length;
        j += 1;
      }
      this.b[k] = 16;
    }
    else
    {
      this.b[k] = 59;
      arrayOfByte = this.h[0].a();
      System.arraycopy(arrayOfByte, 0, this.b, k + 1, arrayOfByte.length);
    }
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.e;
  }
  
  static class a
  {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    
    a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramInt4;
      this.b = paramInt2;
      this.c = paramInt5;
      this.d = paramInt3;
      this.e = paramInt1;
    }
    
    byte[] a()
    {
      byte[] arrayOfByte = new byte[10];
      ag.a(this.e, arrayOfByte, 0);
      ag.a(this.b, arrayOfByte, 2);
      ag.a(this.d, arrayOfByte, 4);
      ag.a(this.a & 0xFF, arrayOfByte, 6);
      ag.a(this.c & 0xFF, arrayOfByte, 8);
      return arrayOfByte;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */