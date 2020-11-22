package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class dm
{
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramContext.putInt(paramString2, paramInt);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "setPrefsInt");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramContext.putLong(paramString2, paramLong);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "setPrefsLong");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramContext.putString(paramString2, paramString3);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "setPrefsStr");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramContext.putBoolean(paramString2, paramBoolean);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "updatePrefsBoolean");
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (paramEditor == null) {
      return;
    }
    paramEditor.apply();
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      int i = paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, paramInt);
      return i;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "getPrefsInt");
    }
    return paramInt;
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l = paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, paramLong);
      return l;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "getPrefsLong");
    }
    return paramLong;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "getPrefsInt");
    }
    return paramString3;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      boolean bool = paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, paramBoolean);
      return bool;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "SpUtil", "getPrefsBoolean");
    }
    return paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */