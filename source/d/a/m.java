package d.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class m
  implements ListIterator
{
  public static final m a = new m();
  
  public Void a()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public Void b()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */