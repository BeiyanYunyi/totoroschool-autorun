package com.amap.api.maps;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.ha;
import com.amap.api.mapcore.util.hi;
import com.amap.api.mapcore.util.lq;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

public class MapView
  extends FrameLayout
{
  private IMapFragmentDelegate a;
  private AMap b;
  private int c = 0;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.c = paramAttributeSet.getAttributeIntValue(16842972, 0);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setVisibility(this.c);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.c = paramAttributeSet.getAttributeIntValue(16842972, 0);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setVisibility(this.c);
  }
  
  public MapView(Context paramContext, AMapOptions paramAMapOptions)
  {
    super(paramContext);
    a(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setOptions(paramAMapOptions);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      hi.a(dx.e()).c(paramContext.getApplicationContext());
    }
  }
  
  public AMap getMap()
  {
    Object localObject = getMapFragmentDelegate();
    try
    {
      localObject = ((IMapFragmentDelegate)localObject).getMap();
      if (localObject == null) {
        return null;
      }
      if (this.b == null) {
        this.b = new AMap((IAMap)localObject);
      }
      return this.b;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  protected IMapFragmentDelegate getMapFragmentDelegate()
  {
    if (this.a == null)
    {
      try
      {
        this.a = ((IMapFragmentDelegate)hi.a(dx.e()).a(getContext(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) }));
        if (this.a == null) {
          this.a = ((IMapFragmentDelegate)ha.a(getContext(), dx.e(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) }));
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (this.a == null) {
        this.a = new lq(0);
      }
    }
    return this.a;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    try
    {
      addView(getMapFragmentDelegate().onCreateView(null, null, paramBundle), new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public final void onDestroy()
  {
    try
    {
      getMapFragmentDelegate().onDestroy();
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void onLowMemory()
  {
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
  
  public final void onPause()
  {
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
  
  public final void onResume()
  {
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
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      getMapFragmentDelegate().onSaveInstanceState(paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    getMapFragmentDelegate().setVisibility(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */