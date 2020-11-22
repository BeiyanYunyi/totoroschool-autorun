package c.a;

import c.b.a;
import c.b.c;

public abstract class e
{
  protected static final byte[] a = { -48, -49, 17, -32, -95, -79, 26, -31 };
  public static final String[] b = { "Root Entry", "Workbook", "\005SummaryInformation", "\005DocumentSummaryInformation" };
  private static c c = c.a(e.class);
  
  public class a
  {
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public byte[] i = new byte[''];
    
    public a(String paramString)
    {
      int m = paramString.length();
      int k = 0;
      boolean bool;
      if (m < 32) {
        bool = true;
      } else {
        bool = false;
      }
      a.a(bool);
      ag.a((paramString.length() + 1) * 2, this.i, 64);
      while (k < paramString.length())
      {
        this.i[(k * 2)] = ((byte)paramString.charAt(k));
        k += 1;
      }
    }
    
    public void a(int paramInt)
    {
      this.b = paramInt;
      this.i[66] = ((byte)paramInt);
    }
    
    public void b(int paramInt)
    {
      this.d = paramInt;
      ag.b(paramInt, this.i, 116);
    }
    
    public void c(int paramInt)
    {
      this.e = paramInt;
      ag.b(paramInt, this.i, 120);
    }
    
    public void d(int paramInt)
    {
      this.f = paramInt;
      ag.b(paramInt, this.i, 68);
    }
    
    public void e(int paramInt)
    {
      this.g = paramInt;
      ag.b(this.g, this.i, 72);
    }
    
    public void f(int paramInt)
    {
      this.h = paramInt;
      ag.b(this.h, this.i, 76);
    }
    
    public void g(int paramInt)
    {
      if (paramInt == 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      this.c = paramInt;
      this.i[67] = ((byte)this.c);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */