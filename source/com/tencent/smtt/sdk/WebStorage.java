package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return a();
  }
  
  public void deleteAllData()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().n();
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().e(paramString);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().a(paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().a(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().a(paramString, paramLong);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
  }
  
  @Deprecated
  public static abstract interface QuotaUpdater
  {
    public abstract void updateQuota(long paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\WebStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */