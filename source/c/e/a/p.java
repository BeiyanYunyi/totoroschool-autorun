package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class p
  extends aq
{
  private int a;
  private int b;
  
  public p(c.a.p paramp1, c.a.p paramp2)
  {
    super(an.Y);
    this.a = paramp1.a();
    this.b = paramp2.a();
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[4];
    ag.a(this.a, arrayOfByte, 0);
    ag.a(this.b, arrayOfByte, 2);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */