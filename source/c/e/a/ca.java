package c.e.a;

import c.a.ag;
import c.a.an;
import c.a.aq;

class ca
  extends aq
{
  public static final a a = new a(0);
  public static final a b = new a(1);
  public static final a c = new a(2);
  public static final a d = new a(3);
  private a e;
  private int f;
  private int g;
  
  public ca(a parama, int paramInt1, int paramInt2)
  {
    super(an.aM);
    this.f = paramInt1;
    this.g = paramInt2;
    this.e = parama;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[15];
    arrayOfByte[0] = ((byte)this.e.a);
    ag.a(this.g, arrayOfByte, 1);
    ag.a(this.f, arrayOfByte, 3);
    arrayOfByte[7] = 1;
    ag.a(this.g, arrayOfByte, 9);
    ag.a(this.g, arrayOfByte, 11);
    arrayOfByte[13] = ((byte)this.f);
    arrayOfByte[14] = ((byte)this.f);
    return arrayOfByte;
  }
  
  private static class a
  {
    int a;
    
    a(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */