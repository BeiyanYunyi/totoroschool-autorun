package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class i
  extends aq
{
  static a a = new a(0);
  static a b = new a(1);
  static a c = new a(-1);
  private a d;
  
  public i(a parama)
  {
    super(an.aA);
    this.d = parama;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[2];
    ag.a(this.d.a, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private static class a
  {
    int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */