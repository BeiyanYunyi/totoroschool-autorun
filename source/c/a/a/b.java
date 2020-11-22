package c.a.a;

import c.a.ag;
import java.io.IOException;

class b
  extends s
{
  private static c.b.c a = c.b.c.a(b.class);
  private c b;
  private byte[] c;
  private int d;
  private int e;
  private boolean f;
  
  public b(n paramn)
    throws IOException
  {
    super(w.h);
    this.b = c.g;
    c(2);
    b(this.b.a());
    byte[] arrayOfByte = paramn.l();
    this.d = arrayOfByte.length;
    this.c = new byte[this.d + 61];
    System.arraycopy(arrayOfByte, 0, this.c, 61, this.d);
    this.e = paramn.j();
    this.f = true;
  }
  
  public b(v paramv)
  {
    super(paramv);
    this.b = c.a(j());
    this.f = false;
    paramv = l();
    this.e = ag.a(paramv[24], paramv[25], paramv[26], paramv[27]);
  }
  
  public byte[] a()
  {
    if (this.f)
    {
      this.c[0] = ((byte)this.b.a());
      this.c[1] = ((byte)this.b.a());
      ag.b(this.d + 8 + 17, this.c, 20);
      ag.b(this.e, this.c, 24);
      ag.b(0, this.c, 28);
      this.c[32] = 0;
      this.c[33] = 0;
      this.c[34] = 126;
      this.c[35] = 1;
      this.c[36] = 0;
      this.c[37] = 110;
      ag.a(61470, this.c, 38);
      ag.b(this.d + 17, this.c, 40);
    }
    else
    {
      this.c = l();
    }
    return a(this.c);
  }
  
  byte[] b()
  {
    byte[] arrayOfByte1 = l();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 61];
    System.arraycopy(arrayOfByte1, 61, arrayOfByte2, 0, arrayOfByte2.length);
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */