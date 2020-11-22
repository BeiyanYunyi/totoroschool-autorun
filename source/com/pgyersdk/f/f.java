package com.pgyersdk.f;

import android.util.Log;

public class f
{
  public static boolean a = true;
  
  public static void a(String paramString1, String paramString2)
  {
    if ((a) && (paramString1 != null) && (paramString2 != null)) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a) && (paramString1 != null) && (paramString2 != null)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((a) && (paramString1 != null) && (paramString2 != null)) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((a) && (paramString1 != null) && (paramString2 != null)) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((a) && (paramString1 != null) && (paramString2 != null)) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */