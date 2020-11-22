package c.a.b;

import c.a.ag;
import c.a.ah;
import c.b.a;
import c.b.c;

class ak
  extends ao
{
  private static c a = c.a(ak.class);
  private c.a.ao b;
  private String c;
  private int d;
  
  public ak(c.a.ao paramao)
  {
    this.b = paramao;
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
  }
  
  public ak(String paramString, c.a.ao paramao)
    throws v
  {
    this.c = paramString;
    this.b = paramao;
    this.d = this.b.a(this.c);
    if (this.d >= 0)
    {
      this.d += 1;
      return;
    }
    throw new v(v.CELL_NAME_NOT_FOUND, this.c);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
    throws v
  {
    try
    {
      this.d = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
      this.c = this.b.a(this.d - 1);
      return 4;
    }
    catch (ah paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new v(v.CELL_NAME_NOT_FOUND, "");
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.c);
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = bh.o.d();
    if (k() == ar.b) {
      arrayOfByte[0] = bh.o.b();
    }
    ag.a(this.d, arrayOfByte, 1);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */