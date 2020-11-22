package c.a;

import c.c.m;
import c.d.a.e;

public class aj
  extends aq
{
  private m[] a;
  private boolean b;
  private boolean c;
  
  public byte[] a()
  {
    if ((this.c) && (!this.b)) {
      return l_().a();
    }
    byte[] arrayOfByte = new byte['â'];
    int i = 0;
    ag.a(56, arrayOfByte, 0);
    while (i < 56)
    {
      int j = i * 4 + 2;
      arrayOfByte[j] = ((byte)this.a[i].a());
      arrayOfByte[(j + 1)] = ((byte)this.a[i].b());
      arrayOfByte[(j + 2)] = ((byte)this.a[i].c());
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */