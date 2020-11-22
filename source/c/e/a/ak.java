package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;

class ak
  extends aq
{
  private byte[] a;
  private String b;
  
  public ak(String paramString)
  {
    super(an.ad);
    this.b = paramString;
  }
  
  public byte[] a()
  {
    if ((this.b != null) && (this.b.length() != 0))
    {
      this.a = new byte[this.b.length() * 2 + 3];
      ag.a(this.b.length(), this.a, 0);
      this.a[2] = 1;
      am.b(this.b, this.a, 3);
      return this.a;
    }
    this.a = new byte[0];
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */