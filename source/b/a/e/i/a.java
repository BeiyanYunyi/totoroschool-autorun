package b.a.e.i;

import b.a.e.c.d;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<T>
  extends AtomicInteger
  implements d<T>
{
  private static final long serialVersionUID = -6671519529404341862L;
  
  public final boolean offer(T paramT)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(T paramT1, T paramT2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */