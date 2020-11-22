package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.loc.az;
import com.loc.dg;
import com.loc.dk;
import com.loc.dl;
import com.loc.e;
import com.loc.p;
import com.loc.v;
import com.loc.w;
import org.json.JSONObject;

public class AMapLocationClient
{
  Context a;
  LocationManagerBase b;
  
  public AMapLocationClient(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      this.a = paramContext.getApplicationContext();
      this.b = a(this.a, null);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "AMapLocationClient", "AMapLocationClient 1");
    }
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  public AMapLocationClient(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null) {}
    try
    {
      this.a = paramContext.getApplicationContext();
      this.b = a(this.a, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "AMapLocationClient", "AMapLocationClient 2");
    }
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private static LocationManagerBase a(Context paramContext, Intent paramIntent)
  {
    try
    {
      localObject1 = dg.b();
      dl.a(paramContext, (v)localObject1);
      boolean bool = dl.c(paramContext);
      dl.a(paramContext);
      if (bool) {
        localObject1 = (LocationManagerBase)az.a(paramContext, (v)localObject1, w.c("IY29tLmFtYXAuYXBpLmxvY2F0aW9uLkxvY2F0aW9uTWFuYWdlcldyYXBwZXI="), e.class, new Class[] { Context.class, Intent.class }, new Object[] { paramContext, paramIntent });
      } else {
        localObject1 = new e(paramContext, paramIntent);
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = new e(paramContext, paramIntent);
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new e(paramContext, paramIntent);
    }
    return (LocationManagerBase)localObject2;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    return p.x(paramContext);
  }
  
  public static void setApiKey(String paramString)
  {
    try
    {
      AMapLocationClientOption.a = paramString;
      return;
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "AMapLocationClient", "setApiKey");
    }
  }
  
  public void disableBackgroundLocation(boolean paramBoolean)
  {
    try
    {
      if (this.b != null) {
        this.b.disableBackgroundLocation(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "disableBackgroundLocation");
    }
  }
  
  public void enableBackgroundLocation(int paramInt, Notification paramNotification)
  {
    try
    {
      if (this.b != null) {
        this.b.enableBackgroundLocation(paramInt, paramNotification);
      }
      return;
    }
    catch (Throwable paramNotification)
    {
      dg.a(paramNotification, "AMapLocationClient", "enableBackgroundLocation");
    }
  }
  
  public AMapLocation getLastKnownLocation()
  {
    try
    {
      if (this.b != null)
      {
        AMapLocation localAMapLocation = this.b.getLastKnownLocation();
        return localAMapLocation;
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "getLastKnownLocation");
    }
    return null;
  }
  
  public String getVersion()
  {
    return "4.8.0";
  }
  
  public boolean isStarted()
  {
    try
    {
      if (this.b != null)
      {
        boolean bool = this.b.isStarted();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "isStarted");
    }
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.b != null) {
        this.b.onDestroy();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "onDestroy");
    }
  }
  
  public void setLocationListener(AMapLocationListener paramAMapLocationListener)
  {
    if (paramAMapLocationListener != null) {}
    try
    {
      if (this.b == null) {
        return;
      }
      this.b.setLocationListener(paramAMapLocationListener);
      return;
    }
    catch (Throwable paramAMapLocationListener)
    {
      dg.a(paramAMapLocationListener, "AMapLocationClient", "setLocationListener");
      return;
    }
    throw new IllegalArgumentException("listener参数不能为null");
  }
  
  public void setLocationOption(AMapLocationClientOption paramAMapLocationClientOption)
  {
    if (paramAMapLocationClientOption != null) {}
    try
    {
      if (this.b != null) {
        this.b.setLocationOption(paramAMapLocationClientOption);
      }
      if (!paramAMapLocationClientOption.b) {
        return;
      }
      paramAMapLocationClientOption.b = false;
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAMapLocationClientOption.c)) {
        localJSONObject.put("amap_loc_scenes_type", paramAMapLocationClientOption.c);
      }
      dk.a(this.a, "O019", localJSONObject);
      return;
    }
    catch (Throwable paramAMapLocationClientOption)
    {
      dg.a(paramAMapLocationClientOption, "AMapLocationClient", "setLocationOption");
      return;
    }
    throw new IllegalArgumentException("LocationManagerOption参数不能为null");
  }
  
  public void startAssistantLocation()
  {
    try
    {
      if (this.b != null) {
        this.b.startAssistantLocation();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "startAssistantLocation");
    }
  }
  
  public void startAssistantLocation(WebView paramWebView)
  {
    try
    {
      if (this.b != null) {
        this.b.startAssistantLocation(paramWebView);
      }
      return;
    }
    catch (Throwable paramWebView)
    {
      dg.a(paramWebView, "AMapLocationClient", "startAssistantLocation1");
    }
  }
  
  public void startLocation()
  {
    try
    {
      if (this.b != null) {
        this.b.startLocation();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "startLocation");
    }
  }
  
  public void stopAssistantLocation()
  {
    try
    {
      if (this.b != null) {
        this.b.stopAssistantLocation();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "stopAssistantLocation");
    }
  }
  
  public void stopLocation()
  {
    try
    {
      if (this.b != null) {
        this.b.stopLocation();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "AMapLocationClient", "stopLocation");
    }
  }
  
  public void unRegisterLocationListener(AMapLocationListener paramAMapLocationListener)
  {
    try
    {
      if (this.b != null) {
        this.b.unRegisterLocationListener(paramAMapLocationListener);
      }
      return;
    }
    catch (Throwable paramAMapLocationListener)
    {
      dg.a(paramAMapLocationListener, "AMapLocationClient", "unRegisterLocationListener");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\AMapLocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */