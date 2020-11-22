package android.support.v4.app;

import android.app.Service;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat
{
  public static final int START_STICKY = 1;
  public static final int STOP_FOREGROUND_DETACH = 2;
  public static final int STOP_FOREGROUND_REMOVE = 1;
  
  public static void stopForeground(@NonNull Service paramService, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramService.stopForeground(paramInt);
      return;
    }
    boolean bool = true;
    if ((paramInt & 0x1) == 0) {
      bool = false;
    }
    paramService.stopForeground(bool);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface StopForegroundFlags {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\ServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */