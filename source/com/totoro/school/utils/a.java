package com.totoro.school.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import java.util.List;

public class a
{
  public static boolean a(Activity paramActivity)
  {
    return a(paramActivity, paramActivity.getClass().getName());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      return (paramContext != null) && (paramContext.size() > 0) && (paramString.equals(((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName()));
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */