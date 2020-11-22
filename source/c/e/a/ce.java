package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;

class ce
  extends aq
{
  private String a;
  
  public ce(String paramString)
  {
    super(an.C);
    this.a = paramString;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.a.length() * 2 + 3];
    ag.a(this.a.length(), arrayOfByte, 0);
    arrayOfByte[2] = 1;
    am.b(this.a, arrayOfByte, 3);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */