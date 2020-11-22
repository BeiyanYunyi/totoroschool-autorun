package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

public final class UiSettings
{
  private final IUiSettings a;
  
  public UiSettings(IUiSettings paramIUiSettings)
  {
    this.a = paramIUiSettings;
  }
  
  public float getLogoMarginRate(int paramInt)
  {
    try
    {
      float f = this.a.getLogoMarginRate(paramInt);
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public int getLogoPosition()
  {
    try
    {
      int i = this.a.getLogoPosition();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getZoomPosition()
  {
    try
    {
      int i = this.a.getZoomPosition();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 2;
  }
  
  public boolean isCompassEnabled()
  {
    try
    {
      boolean bool = this.a.isCompassEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isGestureScaleByMapCenter()
  {
    try
    {
      boolean bool = this.a.isGestureScaleByMapCenter();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isIndoorSwitchEnabled()
  {
    try
    {
      boolean bool = this.a.isIndoorSwitchEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isMyLocationButtonEnabled()
  {
    try
    {
      boolean bool = this.a.isMyLocationButtonEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    try
    {
      boolean bool = this.a.isRotateGesturesEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public boolean isScaleControlsEnabled()
  {
    try
    {
      boolean bool = this.a.isScaleControlsEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isScrollGesturesEnabled()
  {
    try
    {
      boolean bool = this.a.isScrollGesturesEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    try
    {
      boolean bool = this.a.isTiltGesturesEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public boolean isZoomControlsEnabled()
  {
    try
    {
      boolean bool = this.a.isZoomControlsEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.a.isZoomGesturesEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setAllGesturesEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setCompassEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setGestureScaleByMapCenter(boolean paramBoolean)
  {
    try
    {
      this.a.setGestureScaleByMapCenter(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setIndoorSwitchEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setIndoorSwitchEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setLogoBottomMargin(int paramInt)
  {
    try
    {
      this.a.setLogoBottomMargin(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void setLogoEnable(boolean paramBoolean)
  {
    try
    {
      this.a.setLogoEnable(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setLogoLeftMargin(int paramInt)
  {
    try
    {
      this.a.setLogoLeftMargin(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setLogoMarginRate(int paramInt, float paramFloat)
  {
    try
    {
      this.a.setLogoMarginRate(paramInt, paramFloat);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setLogoPosition(int paramInt)
  {
    try
    {
      this.a.setLogoPosition(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setMyLocationButtonEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setRotateGesturesEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setScaleControlsEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setScrollGesturesEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setTiltGesturesEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setZoomControlsEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setZoomGesturesEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZoomInByScreenCenter(boolean paramBoolean)
  {
    try
    {
      this.a.setZoomInByScreenCenter(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZoomPosition(int paramInt)
  {
    try
    {
      this.a.setZoomPosition(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */