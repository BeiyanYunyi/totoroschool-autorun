package com.pgyersdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class h
{
  private static SharedPreferences a;
  
  public static String a(Context paramContext, String paramString)
  {
    if (a == null) {
      a = paramContext.getSharedPreferences("pgyersdk", 0);
    }
    return a.getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a == null) {
      a = paramContext.getSharedPreferences("pgyersdk", 0);
    }
    a.edit().putString(paramString1, paramString2).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */