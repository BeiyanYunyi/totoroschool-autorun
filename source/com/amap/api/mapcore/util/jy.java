package com.amap.api.mapcore.util;

import java.util.List;

public abstract class jy
{
  private int a(List<a> paramList)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label69;
      }
      a locala = (a)paramList.get(i);
      if (locala == null) {
        return a(paramList, i);
      }
      try
      {
        if (locala.a() != 1000)
        {
          int j = a(paramList, i);
          return j;
        }
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        label69:
        for (;;) {}
      }
    }
    return a(paramList, i);
    return 1000;
  }
  
  private static int a(List<a> paramList, int paramInt)
  {
    int i = 0;
    while ((i < paramList.size()) && (i <= paramInt))
    {
      a locala = (a)paramList.get(i);
      if (locala != null) {
        try
        {
          locala.b();
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "po", "s0");
        }
      }
      i += 1;
    }
    return 1003;
  }
  
  protected abstract List<a> a();
  
  protected abstract boolean b();
  
  public final int c()
  {
    if (!b()) {
      return 1004;
    }
    List localList = a();
    if ((localList != null) && (localList.size() != 0)) {
      return a(localList);
    }
    return 1001;
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */