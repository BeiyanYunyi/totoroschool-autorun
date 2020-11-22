package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static bf a;
  
  private static void a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        o.a(true).b(paramContext, false, false);
        bh localbh = o.a(true).b();
        paramContext = null;
        if (localbh != null) {
          paramContext = localbh.b();
        }
        if (paramContext != null) {
          a = new bf(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    a(paramContext);
    if (a != null) {
      return a.a(paramContext);
    }
    return "";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsVideoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */