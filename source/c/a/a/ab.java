package c.a.a;

import c.a.ag;
import c.a.an;
import c.a.aq;
import c.b.a;
import c.b.c;
import c.d.a.e;

public class ab
  extends aq
{
  public static final a a = new a(0, "Group");
  public static final a b = new a(1, "Line");
  public static final a c = new a(2, "Rectangle");
  public static final a d = new a(3, "Oval");
  public static final a e = new a(4, "Arc");
  public static final a f = new a(5, "Chart");
  public static final a g = new a(6, "Text");
  public static final a h = new a(7, "Button");
  public static final a i = new a(8, "Picture");
  public static final a j = new a(9, "Polygon");
  public static final a k = new a(11, "Checkbox");
  public static final a l = new a(12, "Option");
  public static final a m = new a(13, "Edit Box");
  public static final a n = new a(14, "Label");
  public static final a o = new a(15, "Dialogue Box");
  public static final a p = new a(16, "Spin Box");
  public static final a q = new a(17, "Scrollbar");
  public static final a r = new a(18, "List Box");
  public static final a s = new a(19, "Group Box");
  public static final a t = new a(20, "Combo Box");
  public static final a u = new a(30, "MS Office Drawing");
  public static final a v = new a(20, "Form Combo Box");
  public static final a w = new a(25, "Excel Note");
  public static final a x = new a(255, "Unknown");
  private static final c y = c.a(ab.class);
  private boolean A;
  private int B;
  private a z;
  
  ab(int paramInt, a parama)
  {
    super(an.aO);
    this.B = paramInt;
    this.z = parama;
  }
  
  private byte[] d()
  {
    byte[] arrayOfByte = new byte[38];
    ag.a(21, arrayOfByte, 0);
    ag.a(18, arrayOfByte, 2);
    ag.a(this.z.a, arrayOfByte, 4);
    ag.a(this.B, arrayOfByte, 6);
    ag.a(24593, arrayOfByte, 8);
    ag.a(7, arrayOfByte, 22);
    ag.a(2, arrayOfByte, 24);
    ag.a(65535, arrayOfByte, 26);
    ag.a(8, arrayOfByte, 28);
    ag.a(2, arrayOfByte, 30);
    ag.a(1, arrayOfByte, 32);
    ag.a(0, arrayOfByte, 34);
    ag.a(0, arrayOfByte, 36);
    return arrayOfByte;
  }
  
  private byte[] e()
  {
    byte[] arrayOfByte = new byte[52];
    ag.a(21, arrayOfByte, 0);
    ag.a(18, arrayOfByte, 2);
    ag.a(this.z.a, arrayOfByte, 4);
    ag.a(this.B, arrayOfByte, 6);
    ag.a(16401, arrayOfByte, 8);
    ag.a(13, arrayOfByte, 22);
    ag.a(22, arrayOfByte, 24);
    ag.a(0, arrayOfByte, 48);
    ag.a(0, arrayOfByte, 50);
    return arrayOfByte;
  }
  
  private byte[] f()
  {
    byte[] arrayOfByte = new byte[70];
    ag.a(21, arrayOfByte, 0);
    ag.a(18, arrayOfByte, 2);
    ag.a(this.z.a, arrayOfByte, 4);
    ag.a(this.B, arrayOfByte, 6);
    ag.a(0, arrayOfByte, 8);
    ag.a(12, arrayOfByte, 22);
    ag.a(20, arrayOfByte, 24);
    arrayOfByte[36] = 1;
    arrayOfByte[38] = 4;
    arrayOfByte[42] = 16;
    arrayOfByte[46] = 19;
    arrayOfByte[48] = -18;
    arrayOfByte[49] = 31;
    arrayOfByte[52] = 4;
    arrayOfByte[56] = 1;
    arrayOfByte[57] = 6;
    arrayOfByte[60] = 2;
    arrayOfByte[62] = 8;
    arrayOfByte[64] = 64;
    ag.a(0, arrayOfByte, 66);
    ag.a(0, arrayOfByte, 68);
    return arrayOfByte;
  }
  
  public byte[] a()
  {
    if (this.A) {
      return l_().a();
    }
    if ((this.z != i) && (this.z != f))
    {
      if (this.z == w) {
        return e();
      }
      if (this.z == t) {
        return f();
      }
      a.a(false);
      return null;
    }
    return d();
  }
  
  public int c()
  {
    return this.B;
  }
  
  public e l_()
  {
    return super.l_();
  }
  
  private static final class a
  {
    private static a[] c = new a[0];
    public int a;
    public String b;
    
    a(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
      paramString = c;
      c = new a[c.length + 1];
      System.arraycopy(paramString, 0, c, 0, paramString.length);
      c[paramString.length] = this;
    }
    
    public String toString()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */