package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class ci
  extends aq
{
  private byte[] a;
  
  public ci(int paramInt)
  {
    super(an.A);
    this.a = new byte[paramInt * 2];
    int j;
    for (int i = 0; i < paramInt; i = j)
    {
      j = i + 1;
      ag.a(j, this.a, i * 2);
    }
  }
  
  public byte[] a()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */