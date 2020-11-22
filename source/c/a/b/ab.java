package c.a.b;

import c.a.ag;
import c.b.c;

class ab
  extends am
{
  private static c a = c.a(ab.class);
  private double b;
  private boolean c;
  
  public ab()
  {
    this.c = false;
  }
  
  public ab(String paramString)
  {
    try
    {
      this.b = Integer.parseInt(paramString);
    }
    catch (NumberFormatException paramString)
    {
      a.a(paramString, paramString);
      this.b = 0.0D;
    }
    int i = (short)(int)this.b;
    boolean bool;
    if (this.b != i) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
  }
  
  public double a()
  {
    return this.b;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    return 2;
  }
  
  boolean b()
  {
    return this.c;
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = bh.h.a();
    ag.a((int)this.b, arrayOfByte, 1);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */