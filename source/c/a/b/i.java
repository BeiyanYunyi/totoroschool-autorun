package c.a.b;

import c.a;
import c.a.ag;
import c.a.k;
import c.b.c;

class i
  extends ao
{
  private static c a = c.a(i.class);
  private boolean b;
  private boolean c;
  private int d;
  private int e;
  private a f;
  
  public i() {}
  
  public i(a parama)
  {
    this.f = parama;
  }
  
  public i(String paramString)
  {
    this.d = k.a(paramString);
    this.e = k.b(paramString);
    this.b = k.c(paramString);
    this.c = k.d(paramString);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.e = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    paramInt = ag.a(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    this.d = (paramInt & 0xFF);
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
    return 4;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.d, this.b ^ true, this.e, this.c ^ true, paramStringBuffer);
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[5];
    int i;
    if (!j()) {
      i = bh.b.a();
    } else {
      i = bh.b.c();
    }
    arrayOfByte[0] = i;
    ag.a(this.e, arrayOfByte, 1);
    int k = this.d;
    int j = k;
    if (this.c) {
      j = k | 0x8000;
    }
    k = j;
    if (this.b) {
      k = j | 0x4000;
    }
    ag.a(k, arrayOfByte, 3);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */