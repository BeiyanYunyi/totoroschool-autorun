package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class k
  implements Handler.Callback
{
  private static final k c = new k();
  final Map<android.app.FragmentManager, j> a = new HashMap();
  final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> b = new HashMap();
  private volatile com.bumptech.glide.h d;
  private final Handler e = new Handler(Looper.getMainLooper(), this);
  
  public static k a()
  {
    return c;
  }
  
  private com.bumptech.glide.h b(Context paramContext)
  {
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = new com.bumptech.glide.h(paramContext.getApplicationContext(), new b(), new f());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  @TargetApi(17)
  private static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!paramActivity.isDestroyed()) {
        return;
      }
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
  }
  
  @TargetApi(11)
  public com.bumptech.glide.h a(Activity paramActivity)
  {
    if ((!com.bumptech.glide.h.h.c()) && (Build.VERSION.SDK_INT >= 11))
    {
      b(paramActivity);
      return a(paramActivity, paramActivity.getFragmentManager());
    }
    return a(paramActivity.getApplicationContext());
  }
  
  public com.bumptech.glide.h a(Context paramContext)
  {
    if (paramContext != null)
    {
      if ((com.bumptech.glide.h.h.b()) && (!(paramContext instanceof Application)))
      {
        if ((paramContext instanceof FragmentActivity)) {
          return a((FragmentActivity)paramContext);
        }
        if ((paramContext instanceof Activity)) {
          return a((Activity)paramContext);
        }
        if ((paramContext instanceof ContextWrapper)) {
          return a(((ContextWrapper)paramContext).getBaseContext());
        }
      }
      return b(paramContext);
    }
    throw new IllegalArgumentException("You cannot start a load on a null Context");
  }
  
  @TargetApi(11)
  com.bumptech.glide.h a(Context paramContext, android.app.FragmentManager paramFragmentManager)
  {
    j localj = a(paramFragmentManager);
    com.bumptech.glide.h localh = localj.b();
    paramFragmentManager = localh;
    if (localh == null)
    {
      paramFragmentManager = new com.bumptech.glide.h(paramContext, localj.a(), localj.c());
      localj.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  com.bumptech.glide.h a(Context paramContext, android.support.v4.app.FragmentManager paramFragmentManager)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment = a(paramFragmentManager);
    com.bumptech.glide.h localh = localSupportRequestManagerFragment.b();
    paramFragmentManager = localh;
    if (localh == null)
    {
      paramFragmentManager = new com.bumptech.glide.h(paramContext, localSupportRequestManagerFragment.a(), localSupportRequestManagerFragment.c());
      localSupportRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  public com.bumptech.glide.h a(FragmentActivity paramFragmentActivity)
  {
    if (com.bumptech.glide.h.h.c()) {
      return a(paramFragmentActivity.getApplicationContext());
    }
    b(paramFragmentActivity);
    return a(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager());
  }
  
  SupportRequestManagerFragment a(android.support.v4.app.FragmentManager paramFragmentManager)
  {
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
    if (localSupportRequestManagerFragment2 == null)
    {
      localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)this.b.get(paramFragmentManager);
      localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
      if (localSupportRequestManagerFragment2 == null)
      {
        localSupportRequestManagerFragment1 = new SupportRequestManagerFragment();
        this.b.put(paramFragmentManager, localSupportRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localSupportRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return localSupportRequestManagerFragment1;
  }
  
  @TargetApi(17)
  j a(android.app.FragmentManager paramFragmentManager)
  {
    j localj2 = (j)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    j localj1 = localj2;
    if (localj2 == null)
    {
      localj2 = (j)this.a.get(paramFragmentManager);
      localj1 = localj2;
      if (localj2 == null)
      {
        localj1 = new j();
        this.a.put(paramFragmentManager, localj1);
        paramFragmentManager.beginTransaction().add(localj1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localj1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1 = null;
    boolean bool = true;
    switch (i)
    {
    default: 
      bool = false;
      Object localObject2 = null;
      paramMessage = (Message)localObject1;
      localObject1 = localObject2;
      break;
    case 2: 
      paramMessage = (android.support.v4.app.FragmentManager)paramMessage.obj;
      localObject1 = this.b.remove(paramMessage);
      break;
    case 1: 
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      localObject1 = this.a.remove(paramMessage);
    }
    if ((bool) && (localObject1 == null) && (Log.isLoggable("RMRetriever", 5)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to remove expected request manager fragment, manager: ");
      ((StringBuilder)localObject1).append(paramMessage);
      Log.w("RMRetriever", ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */