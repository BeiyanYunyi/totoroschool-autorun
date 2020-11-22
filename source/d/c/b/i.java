package d.c.b;

import java.io.Serializable;

public abstract class i<R>
  implements f<R>, Serializable
{
  private final int arity;
  
  public i(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str = j.a(this);
    h.a(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */