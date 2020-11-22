package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jh
{
  private static Pattern a;
  
  public static int a(String paramString1, String paramString2)
  {
    int i;
    do
    {
      try
      {
        paramString1 = paramString1.split("\\.");
        paramString2 = paramString2.split("\\.");
        int m = Math.min(paramString1.length, paramString2.length);
        int j = 0;
        i = 0;
        while (j < m)
        {
          int k = paramString1[j].length() - paramString2[j].length();
          i = k;
          if (k == 0)
          {
            k = paramString1[j].compareTo(paramString2[j]);
            i = k;
            if (k == 0)
            {
              j += 1;
              i = k;
              continue;
              i = paramString1.length;
              j = paramString2.length;
              return i - j;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        gg.a(paramString1, "Utils", "compareVersion");
        return -1;
      }
    } while (i == 0);
    return i;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (a == null) {
      a = Pattern.compile("[\\d+\\.]+");
    }
    return a.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (a(paramString1))
    {
      if (!a(paramString2)) {
        return false;
      }
      return a(paramString1, paramString2) == 0;
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */