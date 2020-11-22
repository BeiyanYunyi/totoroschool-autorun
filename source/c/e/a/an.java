package c.e.a;

import c.a.ag;
import c.a.aq;

class an
  extends aq
{
  private int[] a;
  
  public an(int[] paramArrayOfInt)
  {
    super(c.a.an.aL);
    this.a = paramArrayOfInt;
  }
  
  public byte[] a()
  {
    int i = this.a.length;
    int j = 2;
    byte[] arrayOfByte = new byte[i * 6 + 2];
    int k = this.a.length;
    i = 0;
    ag.a(k, arrayOfByte, 0);
    while (i < this.a.length)
    {
      ag.a(this.a[i], arrayOfByte, j);
      ag.a(255, arrayOfByte, j + 4);
      j += 6;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */