package c.a;

import c.b.c;

public class ap
  extends aq
{
  private static c a = c.a(ap.class);
  private int b = 1217;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ap()
  {
    super(an.R);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[2];
    if (this.e) {
      this.b |= 0x100;
    }
    if (this.c) {
      this.b |= 0x400;
    }
    if (this.d) {
      this.b |= 0x800;
    }
    ag.a(this.b, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */