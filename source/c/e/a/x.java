package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class x
  extends aq
{
  private int a;
  private int b;
  private byte[] c;
  
  public x(int paramInt1, int paramInt2)
  {
    super(an.g);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = new byte[14];
    ag.b(this.a, this.c, 4);
    ag.a(this.b, this.c, 10);
  }
  
  protected byte[] a()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */