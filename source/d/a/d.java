package d.a;

import d.c.b.h;
import java.util.Collection;
import java.util.List;

class d
  extends c
{
  public static final d.d.c a(Collection<?> paramCollection)
  {
    h.b(paramCollection, "$this$indices");
    return new d.d.c(0, paramCollection.size() - 1);
  }
  
  public static final <T> List<T> a()
  {
    return (List)n.INSTANCE;
  }
  
  public static final <T> List<T> a(List<? extends T> paramList)
  {
    h.b(paramList, "$this$optimizeReadOnlyList");
    switch (paramList.size())
    {
    default: 
      return paramList;
    case 1: 
      return b.a(paramList.get(0));
    }
    return b.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */