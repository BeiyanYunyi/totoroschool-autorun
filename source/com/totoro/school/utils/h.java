package com.totoro.school.utils;

import android.util.Log;

public class h
{
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      String str = paramString2;
      if (paramString2.length() <= 'ఀ')
      {
        Log.e(paramString1, paramString2);
        return;
      }
      while (str.length() > 3072)
      {
        paramString2 = str.substring(0, 3072);
        str = str.replace(paramString2, "");
        Log.e(paramString1, paramString2);
      }
      Log.e(paramString1, str);
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */