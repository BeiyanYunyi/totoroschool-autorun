package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class bi
  extends aq
{
  private int a;
  private int b;
  
  public bi(int paramInt1, int paramInt2)
  {
    super(an.aZ);
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[10];
    int j = this.b;
    int i = 0;
    ag.a(j, arrayOfByte, 0);
    ag.a(this.a, arrayOfByte, 2);
    if (this.a > 0) {
      ag.a(this.a, arrayOfByte, 4);
    }
    if (this.b > 0) {
      ag.a(this.b, arrayOfByte, 6);
    }
    if ((this.a > 0) && (this.b == 0)) {
      i = 2;
    } else if ((this.a == 0) && (this.b > 0)) {
      i = 1;
    } else if ((this.a <= 0) || (this.b <= 0)) {
      i = 3;
    }
    ag.a(i, arrayOfByte, 8);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */