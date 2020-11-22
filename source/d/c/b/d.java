package d.c.b;

import d.b;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<*>;
import java.util.Iterator;

public final class d
{
  private static final Object[] a = new Object[0];
  
  public static final Object[] a(Collection<?> paramCollection)
  {
    h.b(paramCollection, "collection");
    int i = paramCollection.size();
    if (i == 0) {}
    Iterator localIterator;
    do
    {
      return a;
      localIterator = paramCollection.iterator();
    } while (!localIterator.hasNext());
    paramCollection = new Object[i];
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      Object localObject;
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j) {
          if (j < 2147483645) {
            i = 2147483645;
          } else {
            throw ((Throwable)new OutOfMemoryError());
          }
        }
        localObject = Arrays.copyOf(paramCollection, i);
        h.a(localObject, "Arrays.copyOf(result, newSize)");
      }
      else
      {
        localObject = paramCollection;
        if (!localIterator.hasNext())
        {
          paramCollection = Arrays.copyOf(paramCollection, j);
          h.a(paramCollection, "Arrays.copyOf(result, size)");
          return paramCollection;
        }
      }
      i = j;
      paramCollection = (Collection<?>)localObject;
    }
  }
  
  public static final Object[] a(Collection<?> paramCollection, Object[] paramArrayOfObject)
  {
    h.b(paramCollection, "collection");
    if (paramArrayOfObject != null)
    {
      int j = paramCollection.size();
      int i = 0;
      Iterator localIterator;
      if (j == 0)
      {
        paramCollection = paramArrayOfObject;
        if (paramArrayOfObject.length > 0)
        {
          paramArrayOfObject[0] = null;
          return paramArrayOfObject;
        }
      }
      else
      {
        localIterator = paramCollection.iterator();
        if (!localIterator.hasNext())
        {
          paramCollection = paramArrayOfObject;
          if (paramArrayOfObject.length > 0)
          {
            paramArrayOfObject[0] = null;
            return paramArrayOfObject;
          }
        }
        else if (j <= paramArrayOfObject.length)
        {
          paramCollection = paramArrayOfObject;
        }
        else
        {
          paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
          if (paramCollection == null) {
            break label235;
          }
        }
      }
      Object localObject;
      for (paramCollection = (Object[])paramCollection;; paramCollection = (Collection<?>)localObject)
      {
        j = i + 1;
        paramCollection[i] = localIterator.next();
        if (j >= paramCollection.length)
        {
          if (!localIterator.hasNext()) {
            return paramCollection;
          }
          int k = j * 3 + 1 >>> 1;
          i = k;
          if (k <= j) {
            if (j < 2147483645) {
              i = 2147483645;
            } else {
              throw ((Throwable)new OutOfMemoryError());
            }
          }
          localObject = Arrays.copyOf(paramCollection, i);
          h.a(localObject, "Arrays.copyOf(result, newSize)");
        }
        else
        {
          localObject = paramCollection;
          if (!localIterator.hasNext())
          {
            if (paramCollection == paramArrayOfObject)
            {
              paramArrayOfObject[j] = null;
              return paramArrayOfObject;
            }
            paramCollection = Arrays.copyOf(paramCollection, j);
            h.a(paramCollection, "Arrays.copyOf(result, size)");
            return paramCollection;
          }
        }
        i = j;
      }
      label235:
      throw new b("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    throw ((Throwable)new NullPointerException());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */