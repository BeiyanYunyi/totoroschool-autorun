package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;
import java.util.ArrayList;
import java.util.Iterator;

class bw
  extends aq
{
  private static int h = 8224;
  private String a;
  private boolean b;
  private int c;
  private ArrayList d = new ArrayList(50);
  private ArrayList e = new ArrayList(50);
  private byte[] f;
  private int g = 0;
  
  public bw()
  {
    super(an.u);
  }
  
  public int a(String paramString)
  {
    int i = paramString.length() * 2 + 3;
    if (this.g >= h - 5) {
      return paramString.length();
    }
    this.e.add(new Integer(paramString.length()));
    if (this.g + i < h)
    {
      this.d.add(paramString);
      this.g += i;
      return 0;
    }
    i = h - 3 - this.g;
    if (i % 2 == 0) {}
    for (;;)
    {
      i /= 2;
      break;
      i -= 1;
    }
    this.d.add(paramString.substring(0, i));
    this.g += i * 2 + 3;
    return paramString.length() - i;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c = paramString.length();
    if (!this.b) {
      i = paramString.length() * 2 + 1;
    } else {
      i = paramString.length() * 2 + 3;
    }
    if (i <= h)
    {
      this.a = paramString;
      this.g += i;
      return 0;
    }
    if (this.b) {}
    for (int i = h - 4;; i = h - 2)
    {
      i /= 2;
      break;
    }
    this.a = paramString.substring(0, i);
    this.g = (h - 1);
    return paramString.length() - i;
  }
  
  public byte[] a()
  {
    this.f = new byte[this.g];
    boolean bool = this.b;
    int j = 0;
    if (bool)
    {
      ag.a(this.c, this.f, 0);
      this.f[2] = 1;
      i = 3;
    }
    else
    {
      this.f[0] = 1;
      i = 1;
    }
    am.b(this.a, this.f, i);
    int k = i + this.a.length() * 2;
    Iterator localIterator = this.d.iterator();
    int i = j;
    j = k;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ag.a(((Integer)this.e.get(i)).intValue(), this.f, j);
      this.f[(j + 2)] = 1;
      am.b(str, this.f, j + 3);
      j += str.length() * 2 + 3;
      i += 1;
    }
    return this.f;
  }
  
  public int c()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */