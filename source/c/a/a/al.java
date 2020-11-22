package c.a.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.b.c;

public class al
  extends aq
{
  private static c a = c.a(al.class);
  private byte[] b;
  private int c;
  
  al(String paramString)
  {
    super(an.l);
    this.c = paramString.length();
  }
  
  public byte[] a()
  {
    if (this.b != null) {
      return this.b;
    }
    this.b = new byte[18];
    ag.a(530, this.b, 0);
    ag.a(this.c, this.b, 10);
    ag.a(16, this.b, 12);
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */