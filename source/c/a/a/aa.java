package c.a.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.b.c;

public class aa
  extends aq
{
  private static c a = c.a(aa.class);
  private byte[] b;
  private int c;
  private int d;
  private int e;
  
  public aa(int paramInt1, int paramInt2, int paramInt3)
  {
    super(an.k);
    this.c = paramInt2;
    this.d = paramInt1;
    this.e = paramInt3;
  }
  
  public byte[] a()
  {
    if (this.b != null) {
      return this.b;
    }
    this.b = new byte["".length() + 8 + 4];
    ag.a(this.c, this.b, 0);
    ag.a(this.d, this.b, 2);
    ag.a(this.e, this.b, 6);
    ag.a("".length(), this.b, 8);
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */