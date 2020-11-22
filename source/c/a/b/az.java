package c.a.b;

import c.a;
import c.a.ag;
import c.a.k;
import c.b.c;

class az
  extends ao
{
  private static c a = c.a(az.class);
  private boolean b;
  private boolean c;
  private int d;
  private int e;
  private a f;
  
  public az(a parama)
  {
    this.f = parama;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.e = ag.b(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    paramInt = ag.a(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    this.d = ((byte)(paramInt & 0xFF));
    boolean bool2 = false;
    if ((paramInt & 0x4000) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x8000) != 0) {
      bool1 = true;
    }
    this.c = bool1;
    if ((this.b) && (this.f != null)) {
      this.d = (this.f.b() + this.d);
    }
    if ((this.c) && (this.f != null)) {
      this.e = (this.f.j_() + this.e);
    }
    return 4;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.d, this.e, paramStringBuffer);
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = bh.b.a();
    ag.a(this.e, arrayOfByte, 1);
    int j = this.d;
    int i = j;
    if (this.b) {
      i = j | 0x4000;
    }
    j = i;
    if (this.c) {
      j = i | 0x8000;
    }
    ag.a(j, arrayOfByte, 3);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */