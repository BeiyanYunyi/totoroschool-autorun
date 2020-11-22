package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class he
{
  private static Pattern a;
  
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
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */