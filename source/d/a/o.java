package d.a;

import java.util.Iterator;

public abstract class o
  implements Iterator<Integer>
{
  public final Integer a()
  {
    return Integer.valueOf(b());
  }
  
  public abstract int b();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */