package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

public class CookieSyncManager
{
  private static android.webkit.CookieSyncManager a;
  private static CookieSyncManager b;
  private static boolean c = false;
  
  private CookieSyncManager(Context paramContext)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      c = true;
    }
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      a = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((b == null) || (!c)) {
        b = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      if (b != null)
      {
        CookieSyncManager localCookieSyncManager = b;
        return localCookieSyncManager;
      }
      throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
    }
    finally {}
  }
  
  public void startSync()
  {
    Object localObject = bt.a();
    if ((localObject != null) && (((bt)localObject).b()))
    {
      ((bt)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      return;
    }
    a.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(a)).setUncaughtExceptionHandler(new p());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopSync()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      return;
    }
    a.stopSync();
  }
  
  public void sync()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      return;
    }
    a.sync();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\CookieSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */