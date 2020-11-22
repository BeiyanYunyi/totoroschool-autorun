package c.e.a;

import c.a.am;
import c.a.an;
import c.a.aq;

class f
  extends aq
{
  private boolean a;
  private boolean b;
  private String c;
  private byte[] d;
  
  public f(String paramString)
  {
    super(an.d);
    this.c = paramString;
    this.a = false;
    this.b = false;
  }
  
  public byte[] a()
  {
    this.d = new byte[this.c.length() * 2 + 8];
    if (this.b) {
      this.d[5] = 2;
    } else {
      this.d[5] = 0;
    }
    if (this.a)
    {
      this.d[4] = 1;
      this.d[5] = 0;
    }
    this.d[6] = ((byte)this.c.length());
    this.d[7] = 1;
    am.b(this.c, this.d, 8);
    return this.d;
  }
  
  void c()
  {
    this.a = true;
  }
  
  void d()
  {
    this.b = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */