package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;
import java.util.ArrayList;
import java.util.Iterator;

class bx
  extends aq
{
  private static int g = 8216;
  private int a;
  private int b;
  private ArrayList c;
  private ArrayList d;
  private byte[] e;
  private int f;
  
  public bx(int paramInt1, int paramInt2)
  {
    super(an.r);
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = 0;
    this.c = new ArrayList(50);
    this.d = new ArrayList(50);
  }
  
  public int a(String paramString)
  {
    int i = paramString.length() * 2 + 3;
    if (this.f >= g - 5)
    {
      if (paramString.length() > 0) {
        return paramString.length();
      }
      return -1;
    }
    this.d.add(new Integer(paramString.length()));
    if (this.f + i < g)
    {
      this.c.add(paramString);
      this.f += i;
      return 0;
    }
    i = g - 3 - this.f;
    if (i % 2 == 0) {}
    for (;;)
    {
      i /= 2;
      break;
      i -= 1;
    }
    this.c.add(paramString.substring(0, i));
    this.f += i * 2 + 3;
    return paramString.length() - i;
  }
  
  public byte[] a()
  {
    int i = this.f;
    int j = 8;
    this.e = new byte[i + 8];
    int k = this.a;
    Object localObject = this.e;
    i = 0;
    ag.b(k, (byte[])localObject, 0);
    ag.b(this.b, this.e, 4);
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ag.a(((Integer)this.d.get(i)).intValue(), this.e, j);
      this.e[(j + 2)] = 1;
      am.b(str, this.e, j + 3);
      j += str.length() * 2 + 3;
      i += 1;
    }
    return this.e;
  }
  
  public int c()
  {
    return this.f + 8;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */