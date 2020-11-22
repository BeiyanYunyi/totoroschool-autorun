package c.e.a;

import c.a.am;
import c.a.an;
import c.a.aq;
import c.l;

class cx
  extends aq
{
  private byte[] a = new byte[112];
  
  public cx(String paramString)
  {
    super(an.Q);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Java Excel API v");
      paramString.append(l.a());
      paramString = paramString.toString();
    }
    am.a(paramString, this.a, 0);
    int i = paramString.length();
    while (i < this.a.length)
    {
      this.a[i] = 32;
      i += 1;
    }
  }
  
  public byte[] a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */