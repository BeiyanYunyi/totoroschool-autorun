package c.a.b;

import c.a.w;
import c.b.c;

class q
  extends am
{
  private static c a = c.a(q.class);
  private double b;
  
  public q() {}
  
  q(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public q(String paramString)
  {
    try
    {
      this.b = Double.parseDouble(paramString);
      return;
    }
    catch (NumberFormatException paramString)
    {
      a.a(paramString, paramString);
      this.b = 0.0D;
    }
  }
  
  public double a()
  {
    return this.b;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = w.a(paramArrayOfByte, paramInt);
    return 8;
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = bh.i.a();
    w.a(this.b, arrayOfByte, 1);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */