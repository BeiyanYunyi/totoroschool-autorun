package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class HandlerCompat
{
  public static boolean postDelayed(@NonNull Handler paramHandler, @NonNull Runnable paramRunnable, @Nullable Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    }
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\HandlerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */