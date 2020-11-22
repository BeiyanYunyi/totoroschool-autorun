package com.pgyersdk.b.c;

import android.app.Activity;
import android.os.Handler;
import android.view.View;

public final class g
{
  public static void a(Activity paramActivity, View[] paramArrayOfView, Handler paramHandler)
  {
    paramActivity.runOnUiThread(new f(paramActivity, paramArrayOfView, paramHandler));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */