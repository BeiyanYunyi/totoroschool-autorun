package c.e.a;

import c.a.as;
import c.a.w;
import c.d;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class be
  extends j
{
  private static DecimalFormat c = new DecimalFormat("#.###");
  private double a;
  private NumberFormat b;
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = super.a();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 8];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    w.a(this.a, arrayOfByte2, arrayOfByte1.length);
    return arrayOfByte2;
  }
  
  public d c()
  {
    return d.c;
  }
  
  public String d()
  {
    if (this.b == null)
    {
      this.b = ((as)e()).c();
      if (this.b == null) {
        this.b = c;
      }
    }
    return this.b.format(this.a);
  }
  
  public double l()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */