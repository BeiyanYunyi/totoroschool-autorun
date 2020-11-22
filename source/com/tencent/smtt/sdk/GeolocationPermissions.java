package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions a;
  
  private static GeolocationPermissions a()
  {
    try
    {
      if (a == null) {
        a = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = a;
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    return a();
  }
  
  public void allow(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().g(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
  }
  
  public void clear(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().f(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
  }
  
  public void clearAll()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().o();
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().c(paramString, paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b(paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\GeolocationPermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */