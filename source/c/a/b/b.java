package c.a.b;

import c.a.ag;
import c.a.k;
import c.b.a;
import c.b.c;

class b
  extends ao
{
  private static c a = c.a(b.class);
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  b() {}
  
  b(String paramString)
  {
    int j = paramString.indexOf(":");
    boolean bool;
    if (j != -1) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    String str = paramString.substring(0, j);
    paramString = paramString.substring(j + 1);
    this.b = k.a(str);
    this.c = k.b(str);
    this.d = k.a(paramString);
    this.e = k.b(paramString);
    this.f = k.c(str);
    this.g = k.d(str);
    this.h = k.c(paramString);
    this.i = k.d(paramString);
  }
  
  int a()
  {
    return this.b;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.c = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    this.e = ag.a(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    int j = ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)]);
    this.b = (j & 0xFF);
    boolean bool2 = false;
    if ((j & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if ((j & 0x8000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    paramInt = ag.a(paramArrayOfByte[(paramInt + 6)], paramArrayOfByte[(paramInt + 7)]);
    this.d = (paramInt & 0xFF);
    if ((paramInt & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x8000) != 0) {
      bool1 = true;
    }
    this.i = bool1;
    return 8;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.b = paramInt1;
    this.d = paramInt2;
    this.c = paramInt3;
    this.e = paramInt4;
    this.f = paramBoolean1;
    this.h = paramBoolean2;
    this.g = paramBoolean3;
    this.i = paramBoolean4;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.b, this.c, paramStringBuffer);
    paramStringBuffer.append(':');
    k.a(this.d, this.e, paramStringBuffer);
  }
  
  int b()
  {
    return this.d;
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[9];
    int j;
    if (!j()) {
      j = bh.n.a();
    } else {
      j = bh.n.c();
    }
    arrayOfByte[0] = j;
    ag.a(this.c, arrayOfByte, 1);
    ag.a(this.e, arrayOfByte, 3);
    int m = this.b;
    int k = m;
    if (this.g) {
      k = m | 0x8000;
    }
    m = k;
    if (this.f) {
      m = k | 0x4000;
    }
    ag.a(m, arrayOfByte, 5);
    m = this.d;
    k = m;
    if (this.i) {
      k = m | 0x8000;
    }
    m = k;
    if (this.h) {
      m = k | 0x4000;
    }
    ag.a(m, arrayOfByte, 7);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */