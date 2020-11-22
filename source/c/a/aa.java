package c.a;

import c.b.a;
import c.b.c;
import c.c.e;
import c.c.f;
import c.c.n;
import c.c.o;

public class aa
  extends aq
  implements f
{
  public static final a a = new a(null);
  private static c b = c.a(aa.class);
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private byte h;
  private byte i;
  private boolean j;
  private boolean k;
  private String l;
  private boolean m;
  private int n;
  
  protected aa(f paramf)
  {
    super(an.ay);
    boolean bool;
    if (paramf != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    this.c = paramf.f();
    this.d = paramf.k().a();
    this.e = paramf.h();
    this.f = paramf.l().a();
    this.g = paramf.j().a();
    this.j = paramf.i();
    this.l = paramf.m();
    this.k = paramf.n();
    this.m = false;
  }
  
  protected aa(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    super(an.ay);
    this.e = paramInt2;
    this.g = paramInt3;
    this.l = paramString;
    this.c = paramInt1;
    this.j = paramBoolean;
    this.f = paramInt5;
    this.d = paramInt4;
    this.m = false;
    this.k = false;
  }
  
  public final void a(int paramInt)
  {
    this.n = paramInt;
    this.m = true;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.l.length() * 2 + 16];
    ag.a(this.c * 20, arrayOfByte, 0);
    if (this.j) {
      arrayOfByte[2] = ((byte)(arrayOfByte[2] | 0x2));
    }
    if (this.k) {
      arrayOfByte[2] = ((byte)(arrayOfByte[2] | 0x8));
    }
    ag.a(this.d, arrayOfByte, 4);
    ag.a(this.e, arrayOfByte, 6);
    ag.a(this.f, arrayOfByte, 8);
    arrayOfByte[10] = ((byte)this.g);
    arrayOfByte[11] = this.h;
    arrayOfByte[12] = this.i;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = ((byte)this.l.length());
    arrayOfByte[15] = 1;
    am.b(this.l, arrayOfByte, 16);
    return arrayOfByte;
  }
  
  public final boolean c()
  {
    return this.m;
  }
  
  public final void d()
  {
    this.m = false;
  }
  
  public final int e()
  {
    return this.n;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof aa)) {
      return false;
    }
    paramObject = (aa)paramObject;
    return (this.c == ((aa)paramObject).c) && (this.d == ((aa)paramObject).d) && (this.e == ((aa)paramObject).e) && (this.f == ((aa)paramObject).f) && (this.g == ((aa)paramObject).g) && (this.j == ((aa)paramObject).j) && (this.k == ((aa)paramObject).k) && (this.h == ((aa)paramObject).h) && (this.i == ((aa)paramObject).i) && (this.l.equals(((aa)paramObject).l));
  }
  
  public int f()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return this.l.hashCode();
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public o j()
  {
    return o.a(this.g);
  }
  
  public e k()
  {
    return e.a(this.d);
  }
  
  public n l()
  {
    return n.a(this.f);
  }
  
  public String m()
  {
    return this.l;
  }
  
  public boolean n()
  {
    return this.k;
  }
  
  private static class a {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */