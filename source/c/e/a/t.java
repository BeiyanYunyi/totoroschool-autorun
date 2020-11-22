package c.e.a;

import c.a.w;
import c.d;
import c.e.i;
import java.util.Date;

public abstract class t
  extends j
{
  static final i a = new i(c.e.c.b);
  private static c.b.c b = c.b.c.a(t.class);
  private double c;
  private Date d;
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = super.a();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 8];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    w.a(this.c, arrayOfByte2, arrayOfByte1.length);
    return arrayOfByte2;
  }
  
  public d c()
  {
    return d.k;
  }
  
  public String d()
  {
    return this.d.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */