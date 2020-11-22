package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class ab
  extends aq
{
  private int a;
  private int[] b;
  private int[] c;
  private int d = 0;
  
  public ab(int paramInt)
  {
    super(an.t);
    this.a = paramInt;
    paramInt = c();
    this.b = new int[paramInt];
    this.c = new int[paramInt];
    this.d = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b[this.d] = (paramInt1 + paramInt2);
    this.c[this.d] = paramInt2;
    this.d += 1;
  }
  
  public byte[] a()
  {
    int j = c();
    byte[] arrayOfByte = new byte[j * 8 + 2];
    int k = d();
    int i = 0;
    ag.a(k, arrayOfByte, 0);
    while (i < j)
    {
      k = this.b[i];
      int m = i * 8;
      ag.b(k, arrayOfByte, m + 2);
      ag.a(this.c[i], arrayOfByte, m + 6);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int c()
  {
    int i = d();
    if (i != 0) {
      return (this.a + i - 1) / i;
    }
    return 0;
  }
  
  public int d()
  {
    return (this.a + 128 - 1) / 128;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */