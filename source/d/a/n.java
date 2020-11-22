package d.a;

import d.c.b.d;
import d.c.b.h;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class n
  implements Serializable, List, RandomAccess
{
  public static final n INSTANCE = new n();
  private static final long serialVersionUID = -7390468764508069838L;
  
  private final Object readResolve()
  {
    return INSTANCE;
  }
  
  public void add(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Void paramVoid)
  {
    h.b(paramVoid, "element");
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    h.b(paramCollection, "elements");
    return paramCollection.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof List)) && (((List)paramObject).isEmpty());
  }
  
  public Void get(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty list doesn't contain element at index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('.');
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(Void paramVoid)
  {
    h.b(paramVoid, "element");
    return -1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return (Iterator)m.a;
  }
  
  public int lastIndexOf(Void paramVoid)
  {
    h.b(paramVoid, "element");
    return -1;
  }
  
  public ListIterator listIterator()
  {
    return (ListIterator)m.a;
  }
  
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt == 0) {
      return (ListIterator)m.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index: ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public Void remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public Void set(int paramInt, Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return (List)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public Object[] toArray()
  {
    return d.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return d.a(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */