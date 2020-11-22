package com.totoro.school.zxing.a;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class d
{
  private static final String a = "d";
  private static final Object b = ;
  private static final Method c = a(b);
  
  static
  {
    if (b == null)
    {
      Log.v(a, "This device does supports control of a flashlight");
      return;
    }
    Log.v(a, "This device does not support control of a flashlight");
  }
  
  private static Class<?> a(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while finding class ");
      localStringBuilder.append(paramString);
      Log.w(str, localStringBuilder.toString(), localRuntimeException);
      return null;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  private static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      paramVarArgs = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while invoking ");
      localStringBuilder.append(paramMethod);
      Log.w(paramVarArgs, localStringBuilder.toString(), (Throwable)paramObject);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      paramVarArgs = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while invoking ");
      localStringBuilder.append(paramMethod);
      Log.w(paramVarArgs, localStringBuilder.toString(), ((InvocationTargetException)paramObject).getCause());
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramVarArgs = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while invoking ");
      localStringBuilder.append(paramMethod);
      Log.w(paramVarArgs, localStringBuilder.toString(), (Throwable)paramObject);
    }
    return null;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramVarArgs);
      return paramClass;
    }
    catch (RuntimeException paramClass)
    {
      paramVarArgs = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected error while finding method ");
      localStringBuilder.append(paramString);
      Log.w(paramVarArgs, localStringBuilder.toString(), paramClass);
      return null;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private static Method a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return a(paramObject.getClass(), "setFlashlightEnabled", new Class[] { Boolean.TYPE });
  }
  
  static void a()
  {
    a(false);
  }
  
  private static void a(boolean paramBoolean)
  {
    if (b != null) {
      a(c, b, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  static void b()
  {
    a(false);
  }
  
  private static Object c()
  {
    Object localObject1 = a("android.os.ServiceManager");
    if (localObject1 == null) {
      return null;
    }
    localObject1 = a((Class)localObject1, "getService", new Class[] { String.class });
    if (localObject1 == null) {
      return null;
    }
    localObject1 = a((Method)localObject1, null, new Object[] { "hardware" });
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = a("android.os.IHardwareService$Stub");
    if (localObject2 == null) {
      return null;
    }
    localObject2 = a((Class)localObject2, "asInterface", new Class[] { IBinder.class });
    if (localObject2 == null) {
      return null;
    }
    return a((Method)localObject2, null, new Object[] { localObject1 });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */