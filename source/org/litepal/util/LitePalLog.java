package org.litepal.util;

import android.util.Log;

public final class LitePalLog
{
  public static final int DEBUG = 2;
  public static final int ERROR = 5;
  public static int level = 5;
  
  public static void d(String paramString1, String paramString2)
  {
    if (level <= 2) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, Exception paramException)
  {
    if (level <= 5) {
      Log.e(paramString, paramException.getMessage(), paramException);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\LitePalLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */