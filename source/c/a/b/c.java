package c.a.b;

import c.a.ag;
import c.a.k;
import c.b.a;

class c
  extends ao
{
  private static c.b.c a = c.b.c.a(c.class);
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private t k;
  
  c(t paramt)
  {
    this.k = paramt;
  }
  
  c(String paramString, t paramt)
    throws v
  {
    this.k = paramt;
    int m = paramString.lastIndexOf(":");
    boolean bool;
    if (m != -1) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    String str2 = paramString.substring(m + 1);
    int n = paramString.indexOf('!');
    String str1 = paramString.substring(n + 1, m);
    this.c = k.a(str1);
    this.d = k.b(str1);
    str1 = paramString.substring(0, n);
    paramString = str1;
    if (str1.charAt(0) == '\'')
    {
      paramString = str1;
      if (str1.charAt(str1.length() - 1) == '\'') {
        paramString = str1.substring(1, str1.length() - 1);
      }
    }
    this.b = paramt.b(paramString);
    if (this.b >= 0)
    {
      this.e = k.a(str2);
      this.f = k.b(str2);
      this.g = true;
      this.h = true;
      this.i = true;
      this.j = true;
      return;
    }
    throw new v(v.SHEET_REF_NOT_FOUND, paramString);
  }
  
  int a()
  {
    return this.c;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    this.d = ag.a(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    this.f = ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)]);
    int m = ag.a(paramArrayOfByte[(paramInt + 6)], paramArrayOfByte[(paramInt + 7)]);
    this.c = (m & 0xFF);
    boolean bool2 = false;
    if ((m & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if ((m & 0x8000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    paramInt = ag.a(paramArrayOfByte[(paramInt + 8)], paramArrayOfByte[(paramInt + 9)]);
    this.e = (paramInt & 0xFF);
    if ((paramInt & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x8000) != 0) {
      bool1 = true;
    }
    this.j = bool1;
    return 10;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = paramInt3;
    this.d = paramInt4;
    this.f = paramInt5;
    this.g = paramBoolean1;
    this.i = paramBoolean2;
    this.h = paramBoolean3;
    this.j = paramBoolean4;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.b, this.c, this.d, this.k, paramStringBuffer);
    paramStringBuffer.append(':');
    k.a(this.e, this.f, paramStringBuffer);
  }
  
  int b()
  {
    return this.e;
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[11];
    arrayOfByte[0] = bh.q.a();
    ag.a(this.b, arrayOfByte, 1);
    ag.a(this.d, arrayOfByte, 3);
    ag.a(this.f, arrayOfByte, 5);
    int n = this.c;
    int m = n;
    if (this.h) {
      m = n | 0x8000;
    }
    n = m;
    if (this.g) {
      n = m | 0x4000;
    }
    ag.a(n, arrayOfByte, 7);
    n = this.e;
    m = n;
    if (this.j) {
      m = n | 0x8000;
    }
    n = m;
    if (this.i) {
      n = m | 0x4000;
    }
    ag.a(n, arrayOfByte, 9);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */