package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.AMapOptionsCreator;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

public class lq
  implements IMapFragmentDelegate
{
  public static volatile Context a;
  private static String e;
  public int b = 0;
  private IAMap c;
  private int d = 0;
  private AMapOptions f;
  
  public lq(int paramInt)
  {
    this.d = (paramInt % 3);
    b();
  }
  
  private void a()
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        j = 0;
        m = 0;
        n = 0;
        int i = 0;
        if (j < arrayOfStackTraceElement.length)
        {
          k = n;
          if (arrayOfStackTraceElement[j].getClassName() != null)
          {
            k = n;
            if (arrayOfStackTraceElement[j].getClassName().endsWith("TextureMapView")) {
              k = 1;
            }
          }
          n = m;
          if (arrayOfStackTraceElement[j].getClassName() != null)
          {
            n = m;
            if (arrayOfStackTraceElement[j].getClassName().endsWith("Fragment")) {
              n = 1;
            }
          }
          if ("OnDestroyView".equalsIgnoreCase(arrayOfStackTraceElement[j].getMethodName())) {
            i = 1;
          }
        }
        else
        {
          if ((m != 0) && (n != 0) && (i == 0)) {
            c();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      j += 1;
      int m = n;
      int n = k;
    }
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      a = paramContext.getApplicationContext();
    }
  }
  
  private void b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < 80)
      {
        localStringBuilder.append("=");
        i += 1;
      }
      e = localStringBuilder.toString();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void c()
  {
    Log.i("errorLog", e);
    Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
    Log.i("errorLog", e);
  }
  
  void a(AMapOptions paramAMapOptions)
    throws RemoteException
  {
    if ((paramAMapOptions != null) && (this.c != null))
    {
      Object localObject = paramAMapOptions.getCamera();
      if (localObject != null) {
        this.c.moveCamera(CameraUpdateFactory.newCameraPosition((CameraPosition)localObject));
      }
      localObject = this.c.getAMapUiSettings();
      ((UiSettings)localObject).setRotateGesturesEnabled(paramAMapOptions.getRotateGesturesEnabled());
      ((UiSettings)localObject).setScrollGesturesEnabled(paramAMapOptions.getScrollGesturesEnabled());
      ((UiSettings)localObject).setTiltGesturesEnabled(paramAMapOptions.getTiltGesturesEnabled());
      ((UiSettings)localObject).setZoomControlsEnabled(paramAMapOptions.getZoomControlsEnabled());
      ((UiSettings)localObject).setZoomGesturesEnabled(paramAMapOptions.getZoomGesturesEnabled());
      ((UiSettings)localObject).setCompassEnabled(paramAMapOptions.getCompassEnabled());
      ((UiSettings)localObject).setScaleControlsEnabled(paramAMapOptions.getScaleControlsEnabled());
      ((UiSettings)localObject).setLogoPosition(paramAMapOptions.getLogoPosition());
      this.c.setMapType(paramAMapOptions.getMapType());
      this.c.setZOrderOnTop(paramAMapOptions.getZOrderOnTop());
    }
  }
  
  public IAMap getMap()
    throws RemoteException
  {
    if (this.c == null)
    {
      if (a == null)
      {
        Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
        return null;
      }
      int i = a.getResources().getDisplayMetrics().densityDpi;
      if (i <= 120) {
        lk.a = 0.5F;
      } else if (i <= 160) {
        lk.a = 0.8F;
      } else if (i <= 240) {
        lk.a = 0.87F;
      } else if (i <= 320) {
        lk.a = 1.0F;
      } else if (i <= 480) {
        lk.a = 1.5F;
      } else if (i <= 640) {
        lk.a = 1.8F;
      } else {
        lk.a = 0.9F;
      }
      if (this.d == 0) {
        this.c = new e(a).a();
      } else if (this.d == 1) {
        this.c = new f(a).a();
      } else {
        this.c = new cg(a).a();
      }
    }
    return this.c;
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
    throws RemoteException
  {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    throws RemoteException
  {
    if ((a == null) && (paramLayoutInflater != null)) {
      setContext(paramLayoutInflater.getContext().getApplicationContext());
    }
    try
    {
      this.c = getMap();
      this.c.setVisibilityEx(this.b);
      if ((this.f == null) && (paramBundle != null))
      {
        paramLayoutInflater = paramBundle.getByteArray("MAP_OPTIONS");
        if (paramLayoutInflater != null)
        {
          paramViewGroup = Parcel.obtain();
          paramViewGroup.unmarshall(paramLayoutInflater, 0, paramLayoutInflater.length);
          paramViewGroup.setDataPosition(0);
          this.f = AMapOptions.CREATOR.createFromParcel(paramViewGroup);
        }
      }
      a(this.f);
    }
    catch (Throwable paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
    }
    return this.c.getView();
  }
  
  public void onDestroy()
    throws RemoteException
  {
    a();
    if (this.c != null)
    {
      this.c.clear();
      this.c.destroy();
      this.c = null;
    }
  }
  
  public void onDestroyView()
    throws RemoteException
  {}
  
  public void onInflate(Activity paramActivity, AMapOptions paramAMapOptions, Bundle paramBundle)
    throws RemoteException
  {
    setContext(paramActivity.getApplicationContext());
    this.f = paramAMapOptions;
  }
  
  public void onLowMemory()
    throws RemoteException
  {
    Log.d("onLowMemory", "onLowMemory run");
  }
  
  public void onPause()
    throws RemoteException
  {
    if (this.c != null) {
      this.c.onActivityPause();
    }
  }
  
  public void onResume()
    throws RemoteException
  {
    if (this.c != null) {
      this.c.onActivityResume();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException
  {
    if (this.c != null) {
      if (this.f == null) {
        this.f = new AMapOptions();
      }
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      this.f = this.f.camera(getMap().getCameraPosition());
      this.f.writeToParcel(localParcel, 0);
      paramBundle.putByteArray("MAP_OPTIONS", localParcel.marshall());
      return;
    }
    catch (Throwable paramBundle) {}
  }
  
  public void setContext(Context paramContext)
  {
    a(paramContext);
  }
  
  public void setOptions(AMapOptions paramAMapOptions)
  {
    this.f = paramAMapOptions;
  }
  
  public void setVisibility(int paramInt)
  {
    this.b = paramInt;
    if (this.c != null) {
      this.c.setVisibilityEx(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */