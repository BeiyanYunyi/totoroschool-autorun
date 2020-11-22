package com.amap.api.mapcore.util;

import android.content.Context;

public class gg
{
  protected static gg a;
  protected Thread.UncaughtExceptionHandler b;
  protected boolean c = true;
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if (a != null) {
      a.a(paramThrowable, 1, paramString1, paramString2);
    }
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, fv paramfv, boolean paramBoolean) {}
  
  protected void a(fv paramfv, String paramString1, String paramString2) {}
  
  protected void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */