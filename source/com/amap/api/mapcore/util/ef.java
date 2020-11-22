package com.amap.api.mapcore.util;

public class ef<T extends ef<T>>
{
  public T f;
  
  public static <T extends ef<?>> T a(T paramT1, T paramT2)
  {
    if (paramT2.f == null)
    {
      paramT2.f = paramT1;
      return paramT2;
    }
    throw new IllegalArgumentException("'item' is a list");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */