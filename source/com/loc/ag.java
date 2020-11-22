package com.loc;

import android.content.Context;

public class ag
{
  protected static ag a;
  protected Thread.UncaughtExceptionHandler b;
  protected boolean c = true;
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if (a != null) {
      a.a(paramThrowable, 1, paramString1, paramString2);
    }
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, v paramv, boolean paramBoolean) {}
  
  protected void a(v paramv, String paramString1, String paramString2) {}
  
  protected void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */