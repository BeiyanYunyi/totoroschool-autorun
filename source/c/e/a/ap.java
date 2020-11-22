package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class ap
  extends aq
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public ap(int paramInt1, int paramInt2, int paramInt3)
  {
    super(an.p);
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = paramInt3;
    this.a = new byte[this.d * 4 + 16];
    this.e = 16;
  }
  
  void a(int paramInt)
  {
    ag.b(paramInt - this.c, this.a, this.e);
    this.e += 4;
  }
  
  protected byte[] a()
  {
    ag.b(this.b, this.a, 8);
    return this.a;
  }
  
  void b(int paramInt)
  {
    ag.b(paramInt - this.c, this.a, 12);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */