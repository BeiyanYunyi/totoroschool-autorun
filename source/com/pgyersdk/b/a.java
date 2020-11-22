package com.pgyersdk.b;

import android.app.Activity;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class a
{
  private WeakReference<Activity> a;
  
  private boolean b(Activity paramActivity)
  {
    boolean bool2 = false;
    if (paramActivity == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      boolean bool1 = bool2;
      if (!paramActivity.isFinishing())
      {
        bool1 = bool2;
        if (!paramActivity.isDestroyed()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return paramActivity.isFinishing() ^ true;
  }
  
  public Activity a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = (Activity)((WeakReference)localObject).get();
    if (!b((Activity)localObject)) {
      return null;
    }
    return (Activity)localObject;
  }
  
  public void a(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */