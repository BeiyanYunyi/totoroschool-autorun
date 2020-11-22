package c.e.a;

import c.a.am;
import c.a.an;
import c.a.aq;
import c.b.c;

class ac
  extends aq
{
  c a = c.a(ac.class);
  private String b;
  
  public ac(String paramString)
  {
    super(an.aV);
    this.b = paramString;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.b.length() * 2 + 12];
    arrayOfByte[6] = ((byte)this.b.length());
    arrayOfByte[7] = 1;
    am.b(this.b, arrayOfByte, 8);
    int i = this.b.length() * 2 + 8;
    arrayOfByte[i] = 2;
    arrayOfByte[(i + 1)] = 0;
    arrayOfByte[(i + 2)] = 28;
    arrayOfByte[(i + 3)] = 23;
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */