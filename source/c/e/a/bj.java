package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class bj
  extends aq
{
  private String a;
  private byte[] b;
  
  public bj(int paramInt)
  {
    super(an.ap);
    this.b = new byte[2];
    ag.a(paramInt, this.b, 0);
  }
  
  public bj(String paramString)
  {
    super(an.ap);
    this.a = paramString;
    if (paramString == null)
    {
      this.b = new byte[2];
      ag.a(0, this.b, 0);
      return;
    }
    paramString = paramString.getBytes();
    int j = 0;
    int i = 0;
    while (j < paramString.length)
    {
      int k = paramString[j];
      j += 1;
      i ^= a(k, j);
    }
    j = paramString.length;
    this.b = new byte[2];
    ag.a(j ^ i ^ 0xCE4B, this.b, 0);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    paramInt1 &= 0x7FFF;
    while (paramInt2 > 0)
    {
      if ((paramInt1 & 0x4000) != 0) {
        paramInt1 = (paramInt1 << 1 & 0x7FFF) + 1;
      } else {
        paramInt1 = paramInt1 << 1 & 0x7FFF;
      }
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public byte[] a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */