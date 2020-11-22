package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import org.json.JSONObject;

public final class i
{
  Object a = new Object();
  AMapLocationClientOption b = null;
  a c = null;
  private Context d;
  private AMapLocationClient e = null;
  private WebView f = null;
  private String g = "AMap.Geolocation.cbk";
  private volatile boolean h = false;
  
  public i(Context paramContext, WebView paramWebView)
  {
    this.d = paramContext.getApplicationContext();
    this.f = paramWebView;
    this.c = new a();
  }
  
  private static String b(AMapLocation paramAMapLocation)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAMapLocation == null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("errorCode", -1);
        localObject = "errorInfo";
        paramAMapLocation = "unknownError";
        localJSONObject.put((String)localObject, paramAMapLocation);
      }
      catch (Throwable paramAMapLocation)
      {
        Object localObject;
        String str;
        continue;
      }
      if (paramAMapLocation.getErrorCode() == 0)
      {
        localJSONObject.put("errorCode", 0);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("x", paramAMapLocation.getLongitude());
        ((JSONObject)localObject).put("y", paramAMapLocation.getLatitude());
        ((JSONObject)localObject).put("precision", paramAMapLocation.getAccuracy());
        ((JSONObject)localObject).put("type", paramAMapLocation.getLocationType());
        ((JSONObject)localObject).put("country", paramAMapLocation.getCountry());
        ((JSONObject)localObject).put("province", paramAMapLocation.getProvince());
        ((JSONObject)localObject).put("city", paramAMapLocation.getCity());
        ((JSONObject)localObject).put("cityCode", paramAMapLocation.getCityCode());
        ((JSONObject)localObject).put("district", paramAMapLocation.getDistrict());
        ((JSONObject)localObject).put("adCode", paramAMapLocation.getAdCode());
        ((JSONObject)localObject).put("street", paramAMapLocation.getStreet());
        ((JSONObject)localObject).put("streetNum", paramAMapLocation.getStreetNum());
        ((JSONObject)localObject).put("floor", paramAMapLocation.getFloor());
        ((JSONObject)localObject).put("address", paramAMapLocation.getAddress());
        str = "result";
        paramAMapLocation = (AMapLocation)localObject;
        localObject = str;
      }
      else
      {
        localJSONObject.put("errorCode", paramAMapLocation.getErrorCode());
        localJSONObject.put("errorInfo", paramAMapLocation.getErrorInfo());
        localJSONObject.put("locationDetail", paramAMapLocation.getLocationDetail());
      }
    }
    return localJSONObject.toString();
  }
  
  public final void a()
  {
    if (this.f != null)
    {
      if (this.d == null) {
        return;
      }
      if (Build.VERSION.SDK_INT < 17) {
        return;
      }
      if (this.h) {
        return;
      }
    }
    try
    {
      this.f.getSettings().setJavaScriptEnabled(true);
      this.f.addJavascriptInterface(this, "AMapAndroidLoc");
      if (!TextUtils.isEmpty(this.f.getUrl())) {
        this.f.reload();
      }
      if (this.e == null)
      {
        this.e = new AMapLocationClient(this.d);
        this.e.setLocationListener(this.c);
      }
      this.h = true;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final void b()
  {
    synchronized (this.a)
    {
      this.h = false;
      if (this.e != null)
      {
        this.e.unRegisterLocationListener(this.c);
        this.e.stopLocation();
        this.e.onDestroy();
        this.e = null;
      }
      this.b = null;
      return;
    }
  }
  
  @JavascriptInterface
  public final void getLocation(String paramString)
  {
    synchronized (this.a)
    {
      if (!this.h) {
        return;
      }
      if (this.b == null) {
        this.b = new AMapLocationClientOption();
      }
      m = 0;
      k = 0;
      j = 0;
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          l = paramString.optLong("to", 30000L);
        }
        catch (Throwable paramString)
        {
          long l;
          int i;
          AMapLocationClientOption localAMapLocationClientOption;
          continue;
        }
        try
        {
          i = paramString.optInt("useGPS", 1);
          if (i == 1) {
            i = 1;
          } else {
            i = 0;
          }
        }
        catch (Throwable paramString)
        {
          continue;
        }
        try
        {
          if (paramString.optInt("watch", 0) == 1) {
            j = 1;
          }
          k = j;
          m = paramString.optInt("interval", 5);
        }
        catch (Throwable paramString)
        {
          j = k;
          continue;
        }
        try
        {
          paramString = paramString.optString("callback", null);
          if (!TextUtils.isEmpty(paramString))
          {
            this.g = paramString;
            k = m;
          }
          else
          {
            paramString = "AMap.Geolocation.cbk";
            continue;
            l = 30000L;
            i = 0;
            j = m;
            k = 5;
          }
        }
        catch (Throwable paramString)
        {
          k = m;
          continue;
        }
        try
        {
          this.b.setHttpTimeOut(l);
          if (i != 0)
          {
            localAMapLocationClientOption = this.b;
            paramString = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
            localAMapLocationClientOption.setLocationMode(paramString);
          }
          else
          {
            localAMapLocationClientOption = this.b;
            paramString = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
            continue;
          }
          this.b.setOnceLocation(j ^ 0x1);
          if (j != 0) {
            this.b.setInterval(k * 1000);
          }
        }
        catch (Throwable paramString) {}
      }
      if (this.e != null)
      {
        this.e.setLocationOption(this.b);
        this.e.stopLocation();
        this.e.startLocation();
      }
      return;
    }
  }
  
  @JavascriptInterface
  public final void stopLocation()
  {
    if (!this.h) {
      return;
    }
    if (this.e != null) {
      this.e.stopLocation();
    }
  }
  
  final class a
    implements AMapLocationListener
  {
    a() {}
    
    public final void onLocationChanged(AMapLocation paramAMapLocation)
    {
      if (i.c(i.this)) {
        i.a(i.this, i.a(paramAMapLocation));
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */