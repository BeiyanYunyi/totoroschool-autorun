package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.litepal.exceptions.LitePalSupportException;

class DynamicExecutor
{
  static Object getField(Object paramObject, String paramString, Class<?> paramClass)
    throws IllegalArgumentException, IllegalAccessException
  {
    if ((paramClass != LitePalSupport.class) && (paramClass != Object.class)) {}
    try
    {
      Object localObject = paramClass.getDeclaredField(paramString);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramObject);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    return getField(paramObject, paramString, paramClass.getSuperclass());
    throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(paramClass.getSimpleName(), paramString));
  }
  
  static Object send(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?> paramClass, Class<?>[] paramArrayOfClass)
    throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {}
    try
    {
      arrayOfObject = new Object[0];
      paramArrayOfObject = paramArrayOfClass;
      if (paramArrayOfClass == null) {
        paramArrayOfObject = new Class[0];
      }
      paramArrayOfObject = paramClass.getDeclaredMethod(paramString, paramArrayOfObject);
      paramArrayOfObject.setAccessible(true);
      paramObject = paramArrayOfObject.invoke(paramObject, arrayOfObject);
      return paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      for (;;) {}
    }
    throw new LitePalSupportException(LitePalSupportException.noSuchMethodException(paramClass.getSimpleName(), paramString), (Throwable)paramObject);
  }
  
  static void set(Object paramObject1, String paramString, Object paramObject2, Class<?> paramClass)
    throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException
  {
    paramString = paramClass.getDeclaredField(paramString);
    paramString.setAccessible(true);
    paramString.set(paramObject1, paramObject2);
  }
  
  static void setField(Object paramObject1, String paramString, Object paramObject2, Class<?> paramClass)
    throws SecurityException, IllegalArgumentException, IllegalAccessException
  {
    if ((paramClass != LitePalSupport.class) && (paramClass != Object.class)) {}
    try
    {
      set(paramObject1, paramString, paramObject2, paramClass);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    setField(paramObject1, paramString, paramObject2, paramClass.getSuperclass());
    return;
    throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(paramClass.getSimpleName(), paramString));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\DynamicExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */