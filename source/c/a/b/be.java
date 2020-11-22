package c.a.b;

import c.a.am;
import c.b.c;
import c.m;

class be
  extends ao
{
  private static final c a = c.a(be.class);
  private String b;
  private m c;
  
  public be(m paramm)
  {
    this.c = paramm;
  }
  
  public be(String paramString)
  {
    this.b = paramString;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    if ((paramArrayOfByte[(paramInt + 1)] & 0x1) == 0)
    {
      this.b = am.a(paramArrayOfByte, i, paramInt + 2, this.c);
      return i + 2;
    }
    this.b = am.a(paramArrayOfByte, i, paramInt + 2);
    return i * 2 + 2;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("\"");
    paramStringBuffer.append(this.b);
    paramStringBuffer.append("\"");
  }
  
  byte[] c()
  {
    byte[] arrayOfByte = new byte[this.b.length() * 2 + 3];
    arrayOfByte[0] = bh.e.a();
    arrayOfByte[1] = ((byte)this.b.length());
    arrayOfByte[2] = 1;
    am.b(this.b, arrayOfByte, 3);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */