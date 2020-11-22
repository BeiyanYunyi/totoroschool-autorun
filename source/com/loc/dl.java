package com.loc;

import android.content.Context;

public final class dl
{
  static boolean a = false;
  static boolean b = false;
  static boolean c = false;
  static boolean d = false;
  static int e = 0;
  static int f = 0;
  static boolean g = true;
  static boolean h = false;
  
  public static void a(Context paramContext)
  {
    try
    {
      if (!e(paramContext)) {
        return;
      }
      if (a) {
        return;
      }
      dm.a(paramContext, "loc", "startMark", dm.b(paramContext, "loc", "startMark", 0) + 1);
      a = true;
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "AddStartMark");
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    try
    {
      if (!e(paramContext)) {
        return;
      }
      dm.a(paramContext, "loc", "endMark", paramInt);
      dm.a(paramContext, "loc", "startMark", paramInt);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "resetMark");
    }
  }
  
  public static void a(Context paramContext, v paramv)
  {
    if (!d)
    {
      c = az.b(paramContext, paramv);
      d = true;
      if ((!c) && (dg.d()))
      {
        az.a(paramContext, "loc");
        dk.a("dexrollbackstatistics", "RollBack because of version error");
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      az.a(paramContext, paramString1);
      paramContext = new StringBuilder("RollBack because of ");
      paramContext.append(paramString2);
      dk.a("dexrollbackstatistics", paramContext.toString());
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "rollBackDynamicFile");
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (!e(paramContext)) {
        return;
      }
      if (b) {
        return;
      }
      dm.a(paramContext, "loc", "endMark", dm.b(paramContext, "loc", "endMark", 0) + 1);
      b = true;
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "AddEndMark");
    }
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      if (!e(paramContext)) {
        return false;
      }
      if (h) {
        return g;
      }
      if (e == 0) {
        e = dm.b(paramContext, "loc", "startMark", 0);
      }
      if (f == 0) {
        f = dm.b(paramContext, "loc", "endMark", 0);
      }
      if ((!a) && (!b))
      {
        if (e < f)
        {
          a(paramContext, 0);
          g = true;
        }
        if ((e - f > 0) && (e > 99))
        {
          a(paramContext, 0);
          g = true;
        }
        if ((e - f > 0) && (e < 99))
        {
          a(paramContext, -2);
          g = false;
        }
        if ((e - f > 0) && (f < 0))
        {
          a(paramContext, "loc", "checkMark");
          g = false;
        }
      }
      dm.a(paramContext, "loc", "isload", g);
      h = true;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "checkMark");
    }
    return g;
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      if (!e(paramContext)) {
        return false;
      }
      boolean bool = dm.b(paramContext, "loc", "isload", false);
      return bool;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "RollBackDynamic", "isLoad");
    }
    return true;
  }
  
  private static boolean e(Context paramContext)
  {
    if (!d) {
      a(paramContext, dg.b());
    }
    return c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */