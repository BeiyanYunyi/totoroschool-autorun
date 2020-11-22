package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class r
{
  public static Object a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      TbsLog.addLog(997, String.valueOf(paramClass), new Object[0]);
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, paramString, null, new Object[0]);
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Object localObject = paramObject.getClass();
      if (Build.VERSION.SDK_INT > 10) {
        paramArrayOfClass = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      } else {
        paramArrayOfClass = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
      }
      paramArrayOfClass.setAccessible(true);
      localObject = paramVarArgs;
      if (paramVarArgs.length == 0) {
        localObject = null;
      }
      paramObject = paramArrayOfClass.invoke(paramObject, (Object[])localObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      TbsLog.addLog(997, String.valueOf(paramObject), new Object[0]);
      if ((((Throwable)paramObject).getCause() != null) && (((Throwable)paramObject).getCause().toString().contains("AuthenticationFail"))) {
        return new String("AuthenticationFail");
      }
      if ((paramString != null) && ((paramString.equalsIgnoreCase("canLoadX5Core")) || (paramString.equalsIgnoreCase("initTesRuntimeEnvironment")))) {
        return null;
      }
      paramString = new StringWriter();
      ((Throwable)paramObject).printStackTrace(new PrintWriter(paramString));
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("invokeInstance -- exceptions:");
      ((StringBuilder)paramObject).append(paramString.toString());
      Log.e("ReflectionUtils", ((StringBuilder)paramObject).toString());
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      TbsLog.addLog(997, String.valueOf(paramString1), new Object[0]);
    }
    return null;
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    for (paramObject = paramObject.getClass(); paramObject != Object.class; paramObject = ((Class)paramObject).getSuperclass())
    {
      if (paramObject == null) {
        return null;
      }
      try
      {
        Method localMethod = ((Class)paramObject).getDeclaredMethod(paramString, paramVarArgs);
        return localMethod;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */