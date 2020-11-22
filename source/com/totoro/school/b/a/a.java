package com.totoro.school.b.a;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public final class a
{
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      b.a(paramActivity, paramString);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, Class<? extends Service> paramClass)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext.startForegroundService(new Intent(paramContext, paramClass));
        return;
      }
      paramContext.startService(new Intent(paramContext, paramClass));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */