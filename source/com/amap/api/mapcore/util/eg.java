package com.amap.api.mapcore.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class eg
{
  ArrayList<a> a = new ArrayList();
  private boolean b = false;
  
  public void a()
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        boolean bool = this.b;
        if (bool == true) {
          return;
        }
        this.b = true;
        i = 0;
        if (i < this.a.size())
        {
          a locala = (a)this.a.get(i);
          try
          {
            if (a.a(locala) == null) {
              break label290;
            }
            localClass = a.a(locala).getClass();
            if (localClass == null) {
              break label290;
            }
            localObject1 = null;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Class localClass;
            Object localObject1;
            Method localMethod;
            localInvocationTargetException.printStackTrace();
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
          catch (SecurityException localSecurityException)
          {
            localSecurityException.printStackTrace();
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            localNoSuchMethodException1.printStackTrace();
          }
        }
      }
      finally {}
      try
      {
        localMethod = localClass.getDeclaredMethod(a.b(locala), a.c(locala));
        localObject1 = localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        continue;
        j += 1;
        continue;
      }
      if (a.c(locala).length > 0)
      {
        localObject1 = new Class[a.c(locala).length];
        j = 0;
        if (j < a.c(locala).length)
        {
          if (a.c(locala)[j].getInterfaces().length > 0) {
            localObject1[j] = a.c(locala)[j].getInterfaces()[0];
          }
        }
        else {
          localObject1 = localClass.getDeclaredMethod(a.b(locala), (Class[])localObject1);
        }
      }
      else
      {
        if (localObject1 == null) {
          break label290;
        }
        ((Method)localObject1).setAccessible(true);
        ((Method)localObject1).invoke(a.a(locala), a.d(locala));
        break label290;
        this.a.clear();
        return;
      }
      label290:
      i += 1;
    }
  }
  
  public void a(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length >= 3))
        {
          paramObject = new a(paramObject, arrayOfStackTraceElement[3].getMethodName(), paramVarArgs);
          this.a.add(paramObject);
        }
      }
      finally
      {
        break label59;
      }
    }
    catch (Throwable paramObject)
    {
      label59:
      for (;;) {}
    }
    this.b = false;
    return;
    throw ((Throwable)paramObject);
  }
  
  public static class a
  {
    private String a;
    private Object b;
    private Class<?>[] c;
    private Object[] d;
    
    public a(Object paramObject, String paramString, Object... paramVarArgs)
    {
      this.b = paramObject;
      this.a = paramString;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        this.c = new Class[paramVarArgs.length];
        int j = 0;
        int i = 0;
        while (i < paramVarArgs.length)
        {
          this.c[i] = paramVarArgs[i].getClass();
          i += 1;
        }
        this.d = new Object[paramVarArgs.length];
        i = j;
        while (i < paramVarArgs.length)
        {
          this.d[i] = paramVarArgs[i];
          i += 1;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */