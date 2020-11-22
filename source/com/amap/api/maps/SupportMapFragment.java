package com.amap.api.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.ha;
import com.amap.api.mapcore.util.hi;
import com.amap.api.mapcore.util.lq;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

public class SupportMapFragment
  extends Fragment
{
  private AMap a;
  private IMapFragmentDelegate b;
  
  public SupportMapFragment()
  {
    a(getActivity());
  }
  
  private IMapFragmentDelegate a()
  {
    return getMapFragmentDelegate(getActivity());
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      hi.a(dx.e()).c(paramContext.getApplicationContext());
    }
  }
  
  public static SupportMapFragment newInstance()
  {
    return newInstance(new AMapOptions());
  }
  
  public static SupportMapFragment newInstance(AMapOptions paramAMapOptions)
  {
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    Bundle localBundle = new Bundle();
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramAMapOptions.writeToParcel(localParcel, 0);
      localBundle.putByteArray("MAP_OPTIONS", localParcel.marshall());
    }
    catch (Throwable paramAMapOptions)
    {
      paramAMapOptions.printStackTrace();
    }
    localSupportMapFragment.setArguments(localBundle);
    return localSupportMapFragment;
  }
  
  public AMap getMap()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((IMapFragmentDelegate)localObject).getMap();
      if (localObject == null) {
        return null;
      }
      if (this.a == null) {
        this.a = new AMap((IAMap)localObject);
      }
      return this.a;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  protected IMapFragmentDelegate getMapFragmentDelegate(Context paramContext)
  {
    if (this.b == null) {}
    try
    {
      this.b = ((IMapFragmentDelegate)hi.a(dx.e()).a(paramContext, "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) }));
      if (this.b == null) {
        this.b = ((IMapFragmentDelegate)ha.a(paramContext, dx.e(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) }));
      }
      if (this.b == null)
      {
        this.b = new lq(0);
        this.b.setContext(paramContext);
      }
      return this.b;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = getArguments();
      paramLayoutInflater = a().onCreateView(paramLayoutInflater, paramViewGroup, localBundle);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      for (;;) {}
    }
    paramLayoutInflater.printStackTrace();
    return null;
  }
  
  public void onDestroy()
  {
    try
    {
      a().onDestroy();
      this.a = null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    try
    {
      a().onDestroyView();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    try
    {
      getMapFragmentDelegate(paramActivity).onInflate(paramActivity, new AMapOptions(), paramBundle);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    try
    {
      a().onLowMemory();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      a().onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      a().onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      a().onSaveInstanceState(paramBundle);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      a().setVisibility(0);
      return;
    }
    a().setVisibility(8);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\SupportMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */