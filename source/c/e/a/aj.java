package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class aj
  extends aq
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public aj()
  {
    super(an.al);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.b = (paramInt * 14 + 1);
  }
  
  public byte[] a()
  {
    this.a = new byte[8];
    ag.a(this.b, this.a, 0);
    ag.a(this.c, this.a, 2);
    ag.a(this.d, this.a, 4);
    ag.a(this.e, this.a, 6);
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
    this.c = (paramInt * 14 + 1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */