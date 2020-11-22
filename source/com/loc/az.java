package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;

public final class az
{
  public static Class a(Context paramContext, v paramv, String paramString)
  {
    paramContext = c(paramContext, paramv);
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
      ag.a(paramContext, "InstanceFactory", "loadpn");
    }
    return null;
  }
  
  public static <T> T a(Context paramContext, v paramv, String paramString, Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws k
  {
    paramContext = a(c(paramContext, paramv), paramString, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = a(paramClass, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null) {
      return paramContext;
    }
    throw new k("获取对象错误");
  }
  
  private static <T> T a(bc parambc, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      if (a(parambc))
      {
        parambc = parambc.loadClass(paramString);
        if (parambc != null)
        {
          parambc = parambc.getDeclaredConstructor(paramArrayOfClass);
          parambc.setAccessible(true);
          parambc = parambc.newInstance(paramArrayOfObject);
          return parambc;
        }
      }
    }
    catch (Throwable parambc)
    {
      ag.a(parambc, "IFactory", "getWrap");
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
      ag.a(paramClass, "IFactory", "gIns2()");
    }
    return null;
  }
  
  public static String a(Context paramContext, v paramv)
  {
    try
    {
      if (!new File(av.a(paramContext)).exists()) {
        return null;
      }
      File localFile = new File(av.b(paramContext, paramv.a(), paramv.b()));
      if (localFile.exists()) {
        return localFile.getAbsolutePath();
      }
      av.a(paramContext, localFile, paramv);
      return null;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "IFactory", "isdowned");
    }
    return null;
  }
  
  public static void a(Context paramContext, final String paramString)
  {
    try
    {
      ba.b().a().submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            av.a(new an(this.a, ax.b()), this.a, paramString);
            return;
          }
          catch (Throwable localThrowable)
          {
            ag.a(localThrowable, "InstanceFactory", "rollBack");
          }
        }
      });
      return;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "InstanceFactory", "rollBack");
    }
  }
  
  public static boolean a(Context paramContext, au paramau, v paramv)
  {
    boolean bool = paramau.c();
    try
    {
      if ((bb.a(paramv, paramau)) && (bb.a(paramau)) && (bb.a(paramContext, bool)) && (!bb.a(paramContext, paramau, paramv)))
      {
        av.b(paramContext, paramv.a());
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "dDownLoad", "isNeedDownload()");
    }
    return false;
  }
  
  private static boolean a(bc parambc)
  {
    return (parambc != null) && (parambc.a()) && (parambc.d);
  }
  
  public static void b(Context paramContext, au paramau, v paramv)
  {
    if (paramau == null) {
      return;
    }
    try
    {
      if ((!TextUtils.isEmpty(paramau.a())) && (!TextUtils.isEmpty(paramau.b())))
      {
        if (TextUtils.isEmpty(paramau.d)) {
          return;
        }
        new at(paramContext, paramau, paramv).a();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "IFactory", "dDownload()");
    }
  }
  
  public static boolean b(Context paramContext, v paramv)
  {
    try
    {
      if (!new File(av.a(paramContext)).exists()) {
        return false;
      }
      File localFile = new File(av.b(paramContext, paramv.a(), paramv.b()));
      if (localFile.exists()) {
        return true;
      }
      av.a(paramContext, localFile, paramv);
      return false;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "IFactory", "isdowned");
    }
    return false;
  }
  
  private static bc c(Context paramContext, v paramv)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (b(paramContext, paramv))
      {
        paramContext = ba.b().a(paramContext, paramv);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "IFactory", "gIns1");
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */