package c.a;

import c.b.c;

public class m
  extends aq
{
  private static c a = c.a(m.class);
  private a b;
  private a[] c;
  private int d;
  private boolean e;
  private byte[] f;
  
  public byte[] a()
  {
    if (!this.e) {
      return this.f;
    }
    int i = this.c.length;
    int j = 14;
    byte[] arrayOfByte1 = new byte[i * 8 + 14];
    byte[] arrayOfByte2 = this.f;
    i = 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    ag.a(this.b.a, arrayOfByte1, 4);
    ag.a(this.b.c, arrayOfByte1, 6);
    ag.a(this.b.b, arrayOfByte1, 8);
    ag.a(this.b.d, arrayOfByte1, 10);
    ag.a(this.d, arrayOfByte1, 12);
    while (i < this.c.length)
    {
      ag.a(this.c[i].a, arrayOfByte1, j);
      ag.a(this.c[i].c, arrayOfByte1, j + 2);
      ag.a(this.c[i].b, arrayOfByte1, j + 4);
      ag.a(this.c[i].d, arrayOfByte1, j + 6);
      j += 8;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  private static class a
  {
    public int a;
    public int b;
    public int c;
    public int d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */