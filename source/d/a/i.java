package d.a;

import d.c.a.b;
import java.util.Iterator;

class i
  extends h
{
  public static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    d.c.b.h.b(paramIterable, "$this$retainAll");
    d.c.b.h.b(paramb, "predicate");
    return a(paramIterable, paramb, false);
  }
  
  private static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    while (paramIterable.hasNext()) {
      if (((Boolean)paramb.invoke(paramIterable.next())).booleanValue() == paramBoolean)
      {
        paramIterable.remove();
        bool = true;
      }
    }
    return bool;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */