package c.a;

import c.a;
import c.i;
import c.j;

public class al
  implements i
{
  private j a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public a a()
  {
    if ((this.b < this.a.b()) && (this.c < this.a.a())) {
      return this.a.a(this.b, this.c);
    }
    return new x(this.b, this.c);
  }
  
  public boolean a(al paramal)
  {
    if (paramal == this) {
      return true;
    }
    return (this.e >= paramal.c) && (this.c <= paramal.e) && (this.d >= paramal.b) && (this.b <= paramal.d);
  }
  
  public a b()
  {
    if ((this.d < this.a.b()) && (this.e < this.a.a())) {
      return this.a.a(this.d, this.e);
    }
    return new x(this.d, this.e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof al)) {
      return false;
    }
    paramObject = (al)paramObject;
    return (this.b == ((al)paramObject).b) && (this.d == ((al)paramObject).d) && (this.c == ((al)paramObject).c) && (this.e == ((al)paramObject).e);
  }
  
  public int hashCode()
  {
    return this.c ^ 0xFFFF ^ this.e ^ this.b ^ this.d;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    k.a(this.b, this.c, localStringBuffer);
    localStringBuffer.append('-');
    k.a(this.d, this.e, localStringBuffer);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */