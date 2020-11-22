package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;

public class ha
{
  public static Class a(Context paramContext, fv paramfv, String paramString)
  {
    paramContext = b(paramContext, paramfv);
    try
    {
      if (a(paramContext))
      {
        paramContext = paramContext.loadClass(paramString);
        return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "InstanceFactory", "loadpn");
    }
    return null;
  }
  
  public static <T> T a(Context paramContext, fv paramfv, String paramString, Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws fj
  {
    paramContext = a(b(paramContext, paramfv), paramString, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = a(paramClass, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null) {
      return paramContext;
    }
    throw new fj("获取对象错误");
  }
  
  private static <T> T a(hf paramhf, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      if (a(paramhf))
      {
        paramhf = paramhf.loadClass(paramString);
        if (paramhf != null)
        {
          paramhf = paramhf.getDeclaredConstructor(paramArrayOfClass);
          paramhf.setAccessible(true);
          paramhf = paramhf.newInstance(paramArrayOfObject);
          return paramhf;
        }
      }
    }
    catch (Throwable paramhf)
    {
      hd.a(paramhf, "IFactory", "getWrap");
    }
    return null;
  }
  
  private static <T> T a(Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramArrayOfClass);
      paramClass.setAccessible(true);
      paramClass = paramClass.newInstance(paramArrayOfObject);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      hd.a(paramClass, "IFactory", "gIns2()");
    }
    return null;
  }
  
  public static void a(Context paramContext, final String paramString)
  {
    try
    {
      hb.b().a().submit(new Runnable()
      {
        public void run()
        {
          try
          {
            gw.a(new go(this.a, gy.a()), this.a, paramString);
            return;
          }
          catch (Throwable localThrowable)
          {
            hd.a(localThrowable, "InstanceFactory", "rollBack");
          }
        }
      });
      return;
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "InstanceFactory", "rollBack");
    }
  }
  
  public static boolean a(Context paramContext, fv paramfv)
  {
    try
    {
      if (!new File(gw.a(paramContext)).exists()) {
        return false;
      }
      File localFile = new File(gw.b(paramContext, paramfv.a(), paramfv.b()));
      if (localFile.exists()) {
        return true;
      }
      gw.a(paramContext, localFile, paramfv);
      return false;
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "IFactory", "isdowned");
    }
    return false;
  }
  
  private static boolean a(hf paramhf)
  {
    return (paramhf != null) && (paramhf.a()) && (paramhf.d);
  }
  
  private static hf b(Context paramContext, fv paramfv)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (a(paramContext, paramfv))
      {
        paramContext = hb.b().a(paramContext, paramfv);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "IFactory", "gIns1");
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */