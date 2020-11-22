package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.an;
import c.a.aq;
import c.a.y;
import c.b.a;
import c.b.c;
import c.m;

class ch
  extends aq
{
  public static final a a = new a(null);
  public static final a b = new a(null);
  public static final a c = new a(null);
  public static final a d = new a(null);
  public static final a e = new a(null);
  private static c f = c.a(ch.class);
  private a g;
  private byte[] h;
  private int i;
  private String j;
  private String[] k;
  private m l;
  
  public ch()
  {
    super(an.e);
    this.g = c;
  }
  
  public ch(int paramInt, m paramm)
  {
    super(an.e);
    this.i = paramInt;
    this.g = a;
    this.l = paramm;
  }
  
  public ch(String paramString, m paramm)
  {
    super(an.e);
    this.j = paramString;
    this.i = 1;
    this.k = new String[0];
    this.l = paramm;
    this.g = b;
  }
  
  private void f()
  {
    this.h = new byte[4];
    ag.a(this.i, this.h, 0);
    this.h[2] = 1;
    this.h[3] = 4;
    this.g = a;
  }
  
  private void h()
  {
    int i1 = 0;
    int m = 0;
    int n = 0;
    while (m < this.i)
    {
      n += this.k[m].length();
      m += 1;
    }
    byte[] arrayOfByte = y.a(this.j, this.l);
    this.h = new byte[arrayOfByte.length + 6 + this.i * 3 + n * 2];
    ag.a(this.i, this.h, 0);
    ag.a(arrayOfByte.length + 1, this.h, 2);
    this.h[4] = 0;
    this.h[5] = 1;
    System.arraycopy(arrayOfByte, 0, this.h, 6, arrayOfByte.length);
    n = arrayOfByte.length + 4 + 2;
    m = i1;
    while (m < this.k.length)
    {
      ag.a(this.k[m].length(), this.h, n);
      this.h[(n + 2)] = 1;
      am.b(this.k[m], this.h, n + 3);
      n += this.k[m].length() * 2 + 3;
      m += 1;
    }
  }
  
  private void i()
  {
    this.h = new byte[] { 1, 0, 1, 58 };
  }
  
  public int a(String paramString)
  {
    int m = 0;
    int n = 0;
    while ((m < this.k.length) && (n == 0))
    {
      if (this.k[m].equals(paramString)) {
        n = 1;
      }
      m += 1;
    }
    if (n != 0) {
      return 0;
    }
    String[] arrayOfString = new String[this.k.length + 1];
    System.arraycopy(this.k, 0, arrayOfString, 0, this.k.length);
    arrayOfString[this.k.length] = paramString;
    this.k = arrayOfString;
    return this.k.length - 1;
  }
  
  void a(int paramInt)
  {
    boolean bool;
    if (this.g == a) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    this.i = paramInt;
    f();
  }
  
  public byte[] a()
  {
    if (this.g == a)
    {
      f();
    }
    else if (this.g == b)
    {
      h();
    }
    else if (this.g == c)
    {
      i();
    }
    else
    {
      f.b("unsupported supbook type - defaulting to internal");
      f();
    }
    return this.h;
  }
  
  public String b(int paramInt)
  {
    return this.k[paramInt];
  }
  
  public a c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.i;
  }
  
  public String e()
  {
    return this.j;
  }
  
  private static class a {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */