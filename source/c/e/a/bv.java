package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class bv
  extends aq
{
  private int a;
  
  public bv(int paramInt)
  {
    super(an.aY);
    this.a = paramInt;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[4];
    ag.a(this.a, arrayOfByte, 0);
    ag.a(100, arrayOfByte, 2);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */