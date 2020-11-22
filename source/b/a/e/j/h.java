package b.a.e.j;

import b.a.c.e;
import b.a.e.a.d;
import b.a.h.a;
import java.util.concurrent.atomic.AtomicReference;

public final class h
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("It is not allowed to subscribe with a(n) ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" multiple times. Please create a fresh instance of ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" and subscribe that to the target source instead.");
    return localStringBuilder.toString();
  }
  
  public static void a(Class<?> paramClass)
  {
    a.a(new e(a(paramClass.getName())));
  }
  
  public static boolean a(b.a.b.b paramb1, b.a.b.b paramb2, Class<?> paramClass)
  {
    b.a.e.b.b.a(paramb2, "next is null");
    if (paramb1 != null)
    {
      paramb2.dispose();
      if (paramb1 != d.DISPOSED) {
        a(paramClass);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(AtomicReference<b.a.b.b> paramAtomicReference, b.a.b.b paramb, Class<?> paramClass)
  {
    b.a.e.b.b.a(paramb, "next is null");
    if (!paramAtomicReference.compareAndSet(null, paramb))
    {
      paramb.dispose();
      if (paramAtomicReference.get() != d.DISPOSED) {
        a(paramClass);
      }
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */