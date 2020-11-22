package d.c.b;

import d.e.c;
import d.e.e;

public class j
{
  private static final k a;
  private static final c[] b = new c[0];
  
  static
  {
    Object localObject = null;
    try
    {
      k localk = (k)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      localObject = localk;
    }
    catch (ClassCastException|ClassNotFoundException|InstantiationException|IllegalAccessException localClassCastException)
    {
      for (;;) {}
    }
    if (localObject == null) {
      localObject = new k();
    }
    a = (k)localObject;
  }
  
  public static c a(Class paramClass)
  {
    return a.a(paramClass);
  }
  
  public static e a(g paramg)
  {
    return a.a(paramg);
  }
  
  public static String a(i parami)
  {
    return a.a(parami);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */