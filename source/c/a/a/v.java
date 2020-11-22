package c.a.a;

import c.a.ag;
import c.b.c;

final class v
{
  private static c a = c.a(v.class);
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private w i;
  private x j;
  
  public v(w paramw)
  {
    this.i = paramw;
    this.e = this.i.a();
  }
  
  public v(x paramx, int paramInt)
  {
    this.j = paramx;
    this.b = paramInt;
    paramx = this.j.a();
    this.g = paramx.length;
    paramInt = ag.a(paramx[this.b], paramx[(this.b + 1)]);
    this.c = ((0xFFF0 & paramInt) >> 4);
    this.d = (paramInt & 0xF);
    this.e = ag.a(paramx[(this.b + 2)], paramx[(this.b + 3)]);
    this.f = ag.a(paramx[(this.b + 4)], paramx[(this.b + 5)], paramx[(this.b + 6)], paramx[(this.b + 7)]);
    if (this.d == 15)
    {
      this.h = true;
      return;
    }
    this.h = false;
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 8, paramArrayOfByte.length);
    if (this.h) {
      this.d = 15;
    }
    ag.a(this.c << 4 | this.d, arrayOfByte, 0);
    ag.a(this.e, arrayOfByte, 2);
    ag.b(paramArrayOfByte.length, arrayOfByte, 4);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.f;
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  int c()
  {
    return this.b;
  }
  
  w d()
  {
    if (this.i == null) {
      this.i = w.a(this.e);
    }
    return this.i;
  }
  
  int e()
  {
    return this.c;
  }
  
  x f()
  {
    return this.j;
  }
  
  byte[] g()
  {
    byte[] arrayOfByte = new byte[this.f];
    System.arraycopy(this.j.a(), this.b + 8, arrayOfByte, 0, this.f);
    return arrayOfByte;
  }
  
  int h()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */