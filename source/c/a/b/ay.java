package c.a.b;

import c.a;
import c.a.ag;
import c.a.k;

class ay
  extends ao
{
  private int a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private a i;
  
  public ay(a parama)
  {
    this.i = parama;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ag.b(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    this.d = ag.b(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    int j = ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)]);
    this.a = (j & 0xFF);
    boolean bool2 = false;
    if ((j & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if ((j & 0x8000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if (this.e) {
      this.a = (this.i.b() + this.a);
    }
    if (this.f) {
      this.b = (this.i.j_() + this.b);
    }
    paramInt = ag.a(paramArrayOfByte[(paramInt + 6)], paramArrayOfByte[(paramInt + 7)]);
    this.c = (paramInt & 0xFF);
    if ((paramInt & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x8000) != 0) {
      bool1 = true;
    }
    this.h = bool1;
    if (this.g) {
      this.c = (this.i.b() + this.c);
    }
    if (this.h) {
      this.d = (this.i.j_() + this.d);
    }
    return 8;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.a, this.b, paramStringBuffer);
    paramStringBuffer.append(':');
    k.a(this.c, this.d, paramStringBuffer);
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = bh.n.a();
    ag.a(this.b, arrayOfByte, 1);
    ag.a(this.d, arrayOfByte, 3);
    ag.a(this.a, arrayOfByte, 5);
    ag.a(this.c, arrayOfByte, 7);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */