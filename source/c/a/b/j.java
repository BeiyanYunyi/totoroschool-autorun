package c.a.b;

import c.a;
import c.a.ag;
import c.a.k;
import c.b.c;

class j
  extends ao
{
  private static c a = c.a(j.class);
  private boolean b;
  private boolean c;
  private int d;
  private int e;
  private a f;
  private int g;
  private t h;
  
  public j(a parama, t paramt)
  {
    this.f = parama;
    this.h = paramt;
  }
  
  public j(String paramString, t paramt)
    throws v
  {
    this.h = paramt;
    this.b = true;
    this.c = true;
    int i = paramString.indexOf('!');
    String str = paramString.substring(i + 1);
    this.d = k.a(str);
    this.e = k.b(str);
    str = paramString.substring(0, i);
    paramString = str;
    if (str.charAt(0) == '\'')
    {
      paramString = str;
      if (str.charAt(str.length() - 1) == '\'') {
        paramString = str.substring(1, str.length() - 1);
      }
    }
    this.g = paramt.b(paramString);
    if (this.g >= 0) {
      return;
    }
    throw new v(v.SHEET_REF_NOT_FOUND, paramString);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.g = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    this.e = ag.a(paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    paramInt = ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)]);
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
    return 6;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    k.a(this.g, this.d, this.b ^ true, this.e, this.c ^ true, this.h, paramStringBuffer);
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = bh.c.a();
    ag.a(this.g, arrayOfByte, 1);
    ag.a(this.e, arrayOfByte, 3);
    int j = this.d;
    int i = j;
    if (this.c) {
      i = j | 0x8000;
    }
    j = i;
    if (this.b) {
      j = i | 0x4000;
    }
    ag.a(j, arrayOfByte, 5);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */