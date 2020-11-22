package com.amap.api.maps;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
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

public class TextureMapFragment
  extends Fragment
{
  private AMap a;
  private IMapFragmentDelegate b;
  
  public TextureMapFragment()
  {
    a(getActivity());
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      hi.a(dx.e()).c(paramContext.getApplicationContext());
    }
  }
  
  public static TextureMapFragment newInstance()
  {
    return newInstance(new AMapOptions());
  }
  
  public static TextureMapFragment newInstance(AMapOptions paramAMapOptions)
  {
    TextureMapFragment localTextureMapFragment = new TextureMapFragment();
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
    localTextureMapFragment.setArguments(localBundle);
    return localTextureMapFragment;
  }
  
  public AMap getMap()
  {
    Object localObject = getMapFragmentDelegate();
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
  
  protected IMapFragmentDelegate getMapFragmentDelegate()
  {
    if (this.b == null) {}
    try
    {
      this.b = ((IMapFragmentDelegate)hi.a(dx.e()).a(getActivity(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) }));
      if (this.b == null) {
        this.b = ((IMapFragmentDelegate)ha.a(getActivity(), dx.e(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) }));
      }
      if (this.b == null)
      {
        this.b = new lq(1);
        this.b.setContext(getActivity());
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
    try
    {
      getMapFragmentDelegate().onCreate(paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = getArguments();
      paramLayoutInflater = getMapFragmentDelegate().onCreateView(paramLayoutInflater, paramViewGroup, localBundle);
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
      getMapFragmentDelegate().onDestroy();
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
      getMapFragmentDelegate().onDestroyView();
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
      getMapFragmentDelegate().onInflate(paramActivity, new AMapOptions(), paramBundle);
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
      getMapFragmentDelegate().onLowMemory();
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
      getMapFragmentDelegate().onPause();
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
      getMapFragmentDelegate().onResume();
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
      getMapFragmentDelegate().onSaveInstanceState(paramBundle);
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
    if (paramBoolean)
    {
      getMapFragmentDelegate().setVisibility(0);
      return;
    }
    getMapFragmentDelegate().setVisibility(8);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\TextureMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */