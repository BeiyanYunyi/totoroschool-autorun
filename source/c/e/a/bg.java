package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class bg
  extends aq
{
  private boolean a;
  private byte[] b;
  
  public bg(boolean paramBoolean)
  {
    super(an.ab);
    this.a = paramBoolean;
    this.b = new byte[2];
    if (this.a) {
      ag.a(1, this.b, 0);
    }
  }
  
  public byte[] a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */