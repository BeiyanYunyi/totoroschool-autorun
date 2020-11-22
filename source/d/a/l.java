package d.a;

import d.c.b.h;
import d.g.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class l
  extends k
{
  public static final <T, A extends Appendable> A a(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, d.c.a.b<? super T, ? extends CharSequence> paramb)
  {
    h.b(paramIterable, "$this$joinTo");
    h.b(paramA, "buffer");
    h.b(paramCharSequence1, "separator");
    h.b(paramCharSequence2, "prefix");
    h.b(paramCharSequence3, "postfix");
    h.b(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramCharSequence2 = paramIterable.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      m.a(paramA, paramCharSequence2, paramb);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final <T> T a(Iterable<? extends T> paramIterable)
  {
    h.b(paramIterable, "$this$first");
    if ((paramIterable instanceof List)) {
      return (T)b.b((List)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext()) {
      return (T)paramIterable.next();
    }
    throw ((Throwable)new NoSuchElementException("Collection is empty."));
  }
  
  public static final <T> String a(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, d.c.a.b<? super T, ? extends CharSequence> paramb)
  {
    h.b(paramIterable, "$this$joinToString");
    h.b(paramCharSequence1, "separator");
    h.b(paramCharSequence2, "prefix");
    h.b(paramCharSequence3, "postfix");
    h.b(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)b.a(paramIterable, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    h.a(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramIterable;
  }
  
  public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> paramIterable, C paramC)
  {
    h.b(paramIterable, "$this$toCollection");
    h.b(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    return paramC;
  }
  
  public static final <T> List<T> a(Iterable<? extends T> paramIterable, int paramInt)
  {
    h.b(paramIterable, "$this$take");
    int j = 0;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt == 0) {
        return b.a();
      }
      if ((paramIterable instanceof Collection))
      {
        if (paramInt >= ((Collection)paramIterable).size()) {
          return b.b(paramIterable);
        }
        if (paramInt == 1) {
          return b.a(b.a(paramIterable));
        }
      }
      ArrayList localArrayList = new ArrayList(paramInt);
      paramIterable = paramIterable.iterator();
      i = j;
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (i == paramInt) {
          break;
        }
        localArrayList.add(localObject);
        i += 1;
      }
      return b.a((List)localArrayList);
    }
    paramIterable = new StringBuilder();
    paramIterable.append("Requested element count ");
    paramIterable.append(paramInt);
    paramIterable.append(" is less than zero.");
    throw ((Throwable)new IllegalArgumentException(paramIterable.toString().toString()));
  }
  
  public static final <T> T b(List<? extends T> paramList)
  {
    h.b(paramList, "$this$first");
    if (!paramList.isEmpty()) {
      return (T)paramList.get(0);
    }
    throw ((Throwable)new NoSuchElementException("List is empty."));
  }
  
  public static final <T> List<T> b(Iterable<? extends T> paramIterable)
  {
    h.b(paramIterable, "$this$toList");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      switch (localCollection.size())
      {
      default: 
        return b.b(localCollection);
      case 1: 
        if ((paramIterable instanceof List)) {
          paramIterable = ((List)paramIterable).get(0);
        } else {
          paramIterable = paramIterable.iterator().next();
        }
        return b.a(paramIterable);
      }
      return b.a();
    }
    return b.a(b.c(paramIterable));
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection)
  {
    h.b(paramCollection, "$this$toMutableList");
    return (List)new ArrayList(paramCollection);
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable)
  {
    h.b(paramIterable, "$this$toMutableList");
    if ((paramIterable instanceof Collection)) {
      return b.b((Collection)paramIterable);
    }
    return (List)b.a(paramIterable, (Collection)new ArrayList());
  }
  
  public static final <T> d.f.b<T> d(Iterable<? extends T> paramIterable)
  {
    h.b(paramIterable, "$this$asSequence");
    return (d.f.b)new a(paramIterable);
  }
  
  public static final class a
    implements d.f.b<T>
  {
    public a(Iterable paramIterable) {}
    
    public Iterator<T> a()
    {
      return this.a.iterator();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */