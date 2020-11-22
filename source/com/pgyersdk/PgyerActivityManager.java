package com.pgyersdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class PgyerActivityManager
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile PgyerActivityManager a;
  private Activity b;
  private a c = new a(null);
  
  private PgyerActivityManager(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(this.c);
  }
  
  static void a(Application paramApplication)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PgyerActivityManager(paramApplication);
        }
        return;
      }
      finally {}
    }
  }
  
  public static PgyerActivityManager getInstance()
  {
    if (a != null) {
      return a;
    }
    throw new Error("PGER SDK init PgyerActivityManager is error.");
  }
  
  public static boolean isSuccessSetInstance()
  {
    return a != null;
  }
  
  public static void set(Application paramApplication)
  {
    try
    {
      if (a != null)
      {
        a.b = null;
        a.c = null;
      }
      a = new PgyerActivityManager(paramApplication);
      return;
    }
    finally {}
  }
  
  public Activity getCurrentActivity()
  {
    return this.b;
  }
  
  private class a
    implements Application.ActivityLifecycleCallbacks
  {
    private a() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity)
    {
      PgyerActivityManager.a(PgyerActivityManager.this, null);
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      PgyerActivityManager.a(PgyerActivityManager.this, paramActivity);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\PgyerActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */