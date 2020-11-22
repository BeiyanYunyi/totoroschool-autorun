package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class li
{
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      int i = paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 200);
      return i;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "SpUtil", "getPrefsInt");
    }
    return 200;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "00:00:00:00:00:00";
    }
    return b(paramContext, "pref", "smac", "00:00:00:00:00:00");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramContext, "pref", "smac", paramString);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
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
      lf.a(paramContext, "SpUtil", "setPrefsStr");
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (paramEditor == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramEditor.apply();
      return;
    }
    b(paramEditor);
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "SpUtil", "getPrefsInt");
    }
    return paramString3;
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    try
    {
      new AsyncTask()
      {
        private Void a()
        {
          try
          {
            if (this.a != null) {
              this.a.commit();
            }
          }
          catch (Throwable localThrowable)
          {
            lf.a(localThrowable, "SpUtil", "commit");
          }
          return null;
        }
      }.execute(new Void[] { null, null, null });
      return;
    }
    catch (Throwable paramEditor)
    {
      lf.a(paramEditor, "SpUtil", "commit1");
    }
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, true);
      return bool;
    }
    catch (Throwable paramContext)
    {
      lf.a(paramContext, "SpUtil", "getPrefsBoolean");
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */