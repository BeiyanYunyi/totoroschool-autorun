package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  private static int mNextId = 1;
  private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = new SparseArray();
  
  public static boolean completeWakefulIntent(Intent arg0)
  {
    int i = ???.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0) {
      return false;
    }
    synchronized (sActiveWakeLocks)
    {
      Object localObject1 = (PowerManager.WakeLock)sActiveWakeLocks.get(i);
      if (localObject1 != null)
      {
        ((PowerManager.WakeLock)localObject1).release();
        sActiveWakeLocks.remove(i);
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No active wake lock id #");
      ((StringBuilder)localObject1).append(i);
      Log.w("WakefulBroadcastReceiv.", ((StringBuilder)localObject1).toString());
      return true;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (sActiveWakeLocks)
    {
      int i = mNextId;
      mNextId += 1;
      if (mNextId <= 0) {
        mNextId = 1;
      }
      paramIntent.putExtra("android.support.content.wakelockid", i);
      paramIntent = paramContext.startService(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      paramContext = (PowerManager)paramContext.getSystemService("power");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("androidx.core:wake:");
      localStringBuilder.append(paramIntent.flattenToShortString());
      paramContext = paramContext.newWakeLock(1, localStringBuilder.toString());
      paramContext.setReferenceCounted(false);
      paramContext.acquire(60000L);
      sActiveWakeLocks.put(i, paramContext);
      return paramIntent;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */