package d.a;

import d.c.b.d;
import d.c.b.h;
import d.c.b.i;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<E>
  implements Collection<E>
{
  public abstract int a();
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool1 = this instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)this).isEmpty())) {
      return false;
    }
    Iterator localIterator = iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!h.a(localIterator.next(), paramObject));
    bool1 = true;
    return bool1;
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    h.b(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    boolean bool1 = ((Collection)paramCollection).isEmpty();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    paramCollection = paramCollection.iterator();
    do
    {
      bool1 = bool2;
      if (!paramCollection.hasNext()) {
        break;
      }
    } while (contains(paramCollection.next()));
    bool1 = false;
    return bool1;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return a();
  }
  
  public Object[] toArray()
  {
    return d.a((Collection)this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    h.b(paramArrayOfT, "array");
    paramArrayOfT = d.a((Collection)this, paramArrayOfT);
    if (paramArrayOfT != null) {
      return paramArrayOfT;
    }
    throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public String toString()
  {
    return b.a(this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, (d.c.a.b)new a(this), 24, null);
  }
  
  static final class a
    extends i
    implements d.c.a.b<E, CharSequence>
  {
    a(a parama)
    {
      super();
    }
    
    public final CharSequence invoke(E paramE)
    {
      if (paramE == this.this$0) {}
      for (paramE = "(this Collection)";; paramE = String.valueOf(paramE)) {
        return (CharSequence)paramE;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */