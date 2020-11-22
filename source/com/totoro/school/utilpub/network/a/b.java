package com.totoro.school.utilpub.network.a;

public class b
{
  public static <T> T a(Object paramObject, Class<T> paramClass)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramObject = paramClass.cast(paramObject);
      return (T)paramObject;
    }
    catch (ClassCastException paramObject)
    {
      ((ClassCastException)paramObject).printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */