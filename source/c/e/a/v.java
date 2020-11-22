package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class v
  extends aq
{
  private byte[] a = new byte[4];
  private int b;
  private boolean c;
  
  public v(int paramInt, boolean paramBoolean)
  {
    super(an.P);
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public byte[] a()
  {
    if (this.c)
    {
      byte[] arrayOfByte = this.a;
      arrayOfByte[0] = ((byte)(arrayOfByte[0] | 0x1));
    }
    ag.a(this.b, this.a, 2);
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */