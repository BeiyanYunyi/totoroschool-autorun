package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class al
{
  private String a;
  
  public al(String paramString)
  {
    String str = paramString;
    if (TextUtils.isDigitsOnly(paramString)) {
      str = "SPUtil";
    }
    this.a = s.b(str);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(this.a, 0).edit();
      paramContext.putBoolean(paramString, paramBoolean);
      if (paramContext != null)
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          paramContext.apply();
          return;
        }
        paramContext.commit();
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public final boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return true;
    }
    try
    {
      boolean bool = paramContext.getSharedPreferences(this.a, 0).getBoolean(paramString, true);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */