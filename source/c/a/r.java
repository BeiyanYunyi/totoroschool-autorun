package c.a;

import c.b.c;

public class r
{
  private static c a = c.a(r.class);
  private static int b = 1;
  private static int c = 2;
  private static int d = 4;
  private boolean e;
  private boolean f;
  private boolean g;
  private int h;
  private int i;
  
  public r(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.h = paramInt2;
    this.g = true;
  }
  
  public r(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int j = ag.a(paramArrayOfByte[0], paramArrayOfByte[1]);
    if ((b & j) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if ((c & j) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    boolean bool1 = bool2;
    if ((j & d) != 0) {
      bool1 = true;
    }
    this.g = bool1;
    this.i = ag.a(paramArrayOfByte[10], paramArrayOfByte[11], paramArrayOfByte[12], paramArrayOfByte[13]);
    this.h = ag.a(paramArrayOfByte[14], paramArrayOfByte[15], paramArrayOfByte[16], paramArrayOfByte[17]);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[18];
    if (this.e) {
      k = b | 0x0;
    } else {
      k = 0;
    }
    int j = k;
    if (this.f) {
      j = k | c;
    }
    int k = j;
    if (this.g) {
      k = j | d;
    }
    ag.a(k, arrayOfByte, 0);
    ag.b(this.i, arrayOfByte, 10);
    ag.b(this.h, arrayOfByte, 14);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.h -= 1;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public void d()
  {
    this.h += 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */