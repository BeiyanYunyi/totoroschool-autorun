package com.pgyersdk.f;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

public class g
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
      {
      default: 
        return;
      case 3: 
        if (Build.VERSION.SDK_INT < 8)
        {
          paramActivity.setRequestedOrientation(0);
          return;
        }
        i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
        if ((i != 0) && (i != 1))
        {
          paramActivity.setRequestedOrientation(8);
          return;
        }
        paramActivity.setRequestedOrientation(0);
        return;
      case 2: 
        if (Build.VERSION.SDK_INT < 8)
        {
          paramActivity.setRequestedOrientation(0);
          return;
        }
        i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
        if ((i != 0) && (i != 1))
        {
          paramActivity.setRequestedOrientation(8);
          return;
        }
        paramActivity.setRequestedOrientation(0);
        return;
      case 1: 
        if (Build.VERSION.SDK_INT < 8)
        {
          paramActivity.setRequestedOrientation(1);
          return;
        }
        i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
        if ((i != 1) && (i != 2))
        {
          paramActivity.setRequestedOrientation(1);
          return;
        }
        paramActivity.setRequestedOrientation(9);
        return;
      }
      if (Build.VERSION.SDK_INT < 8)
      {
        paramActivity.setRequestedOrientation(1);
        return;
      }
      int i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
      if ((i != 1) && (i != 2))
      {
        paramActivity.setRequestedOrientation(1);
        return;
      }
      paramActivity.setRequestedOrientation(9);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */