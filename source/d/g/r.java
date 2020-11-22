package d.g;

import d.c.a.b;
import d.c.b.h;

class r
  extends q
{
  public static final <T> void a(Appendable paramAppendable, T paramT, b<? super T, ? extends CharSequence> paramb)
  {
    h.b(paramAppendable, "$this$appendElement");
    if (paramb != null)
    {
      paramAppendable.append((CharSequence)paramb.invoke(paramT));
      return;
    }
    boolean bool;
    if (paramT != null) {
      bool = paramT instanceof CharSequence;
    } else {
      bool = true;
    }
    if (bool)
    {
      paramAppendable.append((CharSequence)paramT);
      return;
    }
    if ((paramT instanceof Character))
    {
      paramAppendable.append(((Character)paramT).charValue());
      return;
    }
    paramAppendable.append((CharSequence)String.valueOf(paramT));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */