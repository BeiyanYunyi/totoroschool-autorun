package com.amap.api.location;

import android.app.Notification;
import android.webkit.WebView;

public abstract interface LocationManagerBase
{
  public abstract void disableBackgroundLocation(boolean paramBoolean);
  
  public abstract void enableBackgroundLocation(int paramInt, Notification paramNotification);
  
  public abstract AMapLocation getLastKnownLocation();
  
  public abstract boolean isStarted();
  
  public abstract void onDestroy();
  
  public abstract void setLocationListener(AMapLocationListener paramAMapLocationListener);
  
  public abstract void setLocationOption(AMapLocationClientOption paramAMapLocationClientOption);
  
  public abstract void startAssistantLocation();
  
  public abstract void startAssistantLocation(WebView paramWebView);
  
  public abstract void startLocation();
  
  public abstract void stopAssistantLocation();
  
  public abstract void stopLocation();
  
  public abstract void unRegisterLocationListener(AMapLocationListener paramAMapLocationListener);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\LocationManagerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */