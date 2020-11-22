package com.loc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class dj
{
  private static Object a(Object paramObject, Class<?> paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      if (!paramArrayOfClass.isAccessible()) {
        paramArrayOfClass.setAccessible(true);
      }
      paramObject = paramArrayOfClass.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Throwable paramObject) {}
    try
    {
      if ((paramObject instanceof InvocationTargetException))
      {
        paramObject = ((InvocationTargetException)paramObject).getTargetException();
        paramClass = paramClass.getName();
        paramArrayOfClass = new StringBuilder("invokeMethod ");
        paramArrayOfClass.append(paramString);
        dg.a((Throwable)paramObject, paramClass, paramArrayOfClass.toString());
      }
      return null;
    }
    catch (Throwable paramObject)
    {
      for (;;) {}
    }
  }
  
  public static Object a(Object paramObject, Class<?> paramClass, String paramString, Object... paramVarArgs)
    throws Exception
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      if (arrayOfClass[i] == Integer.class) {
        arrayOfClass[i] = Integer.TYPE;
      }
      if (arrayOfClass[i] == Boolean.class) {
        arrayOfClass[i] = Boolean.TYPE;
      }
      if (arrayOfClass[i] == Double.class) {
        arrayOfClass[i] = Double.TYPE;
      }
      i += 1;
    }
    paramClass = paramClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!paramClass.isAccessible()) {
      paramClass.setAccessible(true);
    }
    try
    {
      paramObject = paramClass.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject) {}
    try
    {
      if ((paramObject instanceof InvocationTargetException))
      {
        paramObject = ((InvocationTargetException)paramObject).getTargetException();
        paramClass = new StringBuilder("invokeMethod ");
        paramClass.append(paramString);
        dg.a((Throwable)paramObject, "Reflect", paramClass.toString());
      }
      return null;
    }
    catch (Throwable paramObject)
    {
      for (;;) {}
    }
  }
  
  public static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = a(paramObject, paramObject.getClass(), paramString, paramArrayOfClass, paramArrayOfObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      ((Throwable)paramObject).printStackTrace();
    }
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramObject = a(paramObject, paramObject.getClass(), paramString, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2)
    throws Exception
  {
    paramString1 = Class.forName(paramString1);
    paramString2 = paramString1.getField(paramString2);
    paramString2.setAccessible(true);
    return paramString2.get(paramString1);
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
    if (!paramString1.isAccessible()) {
      paramString1.setAccessible(true);
    }
    return paramString1.invoke(null, paramArrayOfObject);
  }
  
  public static int b(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    return ((Integer)a(paramObject, paramString, paramVarArgs)).intValue();
  }
  
  public static int b(String paramString1, String paramString2)
    throws Exception
  {
    return ((Integer)a(paramString1, paramString2)).intValue();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */