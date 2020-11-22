package c.e.a;

import c.a.ad;
import c.a.ag;
import c.a.an;
import c.b.c;
import c.d;

public abstract class au
  extends j
{
  private static c a = c.a(au.class);
  private String b;
  private cc c;
  private int d;
  
  protected au(int paramInt1, int paramInt2, String paramString)
  {
    super(an.x, paramInt1, paramInt2);
    this.b = paramString;
    if (this.b == null) {
      this.b = "";
    }
  }
  
  void a(ad paramad, cc paramcc, cv paramcv)
  {
    super.a(paramad, paramcc, paramcv);
    this.c = paramcc;
    this.d = this.c.a(this.b);
    this.b = this.c.a(this.d);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = super.a();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    ag.b(this.d, arrayOfByte2, arrayOfByte1.length);
    return arrayOfByte2;
  }
  
  public d c()
  {
    return d.b;
  }
  
  public String d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */