package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class ActivityManagerCompat
{
  public static boolean isLowRamDevice(@NonNull ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramActivityManager.isLowRamDevice();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\ActivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */