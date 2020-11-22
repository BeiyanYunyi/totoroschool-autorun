package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T>
  extends AbstractList<T>
  implements RandomAccess
{
  private final T[] views;
  
  ImmutableList(T[] paramArrayOfT)
  {
    this.views = paramArrayOfT;
  }
  
  public boolean contains(Object paramObject)
  {
    Object[] arrayOfObject = this.views;
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfObject[i] == paramObject) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public T get(int paramInt)
  {
    return (T)this.views[paramInt];
  }
  
  public int size()
  {
    return this.views.length;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\internal\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */