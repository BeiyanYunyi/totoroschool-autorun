package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class hr
{
  private String a;
  
  public hr(String paramString)
  {
    String str = paramString;
    if (TextUtils.isDigitsOnly(paramString)) {
      str = "SPUtil";
    }
    this.a = fs.b(str);
  }
  
  private void a(SharedPreferences.Editor paramEditor)
  {
    if (paramEditor == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(this.a, 0).edit();
      paramContext.putBoolean(paramString, paramBoolean);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = paramContext.getSharedPreferences(this.a, 0).getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    return paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */