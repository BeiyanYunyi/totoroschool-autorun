package d.a;

import d.c.b.h;
import java.util.Collections;
import java.util.List;

class c
{
  public static final <T> List<T> a(T paramT)
  {
    paramT = Collections.singletonList(paramT);
    h.a(paramT, "java.util.Collections.singletonList(element)");
    return paramT;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */