package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import java.util.ArrayList;

public final class Marker
  extends BasePointOverlay
{
  private IMarker markerDelegate;
  
  public Marker(IMarker paramIMarker)
  {
    this.markerDelegate = paramIMarker;
  }
  
  public void destroy()
  {
    try
    {
      if (this.markerDelegate != null)
      {
        this.markerDelegate.destroy(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        if (!(paramObject instanceof Marker)) {
          return false;
        }
        boolean bool = this.markerDelegate.equalsRemote(((Marker)paramObject).markerDelegate);
        return bool;
      }
      catch (Throwable paramObject)
      {
        ((Throwable)paramObject).printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public float getAlpha()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.getAlpha();
    }
    return 1.0F;
  }
  
  public float getAnchorU()
  {
    return this.markerDelegate.getAnchorU();
  }
  
  public float getAnchorV()
  {
    return this.markerDelegate.getAnchorV();
  }
  
  public int getDisplayLevel()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.getDisplayLevel();
    }
    return 5;
  }
  
  public IPoint getGeoPoint()
  {
    return this.markerDelegate.getGeoPoint();
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    try
    {
      ArrayList localArrayList = this.markerDelegate.getIcons();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public String getId()
  {
    try
    {
      String str = this.markerDelegate.getId();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public Object getObject()
  {
    return this.markerDelegate.getObject();
  }
  
  public MarkerOptions getOptions()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.getOptions();
    }
    return null;
  }
  
  public int getPeriod()
  {
    try
    {
      int i = this.markerDelegate.getPeriod();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public LatLng getPosition()
  {
    try
    {
      LatLng localLatLng = this.markerDelegate.getPosition();
      return localLatLng;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getRotateAngle()
  {
    return this.markerDelegate.getRotateAngle();
  }
  
  public String getSnippet()
  {
    try
    {
      String str = this.markerDelegate.getSnippet();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public String getTitle()
  {
    try
    {
      String str = this.markerDelegate.getTitle();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getZIndex()
  {
    return this.markerDelegate.getZIndex();
  }
  
  public int hashCode()
  {
    return this.markerDelegate.hashCodeRemote();
  }
  
  public void hideInfoWindow()
  {
    try
    {
      this.markerDelegate.hideInfoWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean isClickable()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.isClickable();
    }
    return false;
  }
  
  public boolean isDraggable()
  {
    return this.markerDelegate.isDraggable();
  }
  
  public boolean isFlat()
  {
    return this.markerDelegate.isFlat();
  }
  
  public boolean isInfoWindowAutoOverturn()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.isInfoWindowAutoOverturn();
    }
    return false;
  }
  
  public boolean isInfoWindowEnable()
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      return localIMarkerAction.isInfoWindowEnable();
    }
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    return this.markerDelegate.isInfoWindowShown();
  }
  
  public boolean isPerspective()
  {
    try
    {
      boolean bool = this.markerDelegate.isPerspective();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isRemoved()
  {
    if (this.markerDelegate != null) {
      return this.markerDelegate.isRemoved();
    }
    return false;
  }
  
  public boolean isVisible()
  {
    try
    {
      boolean bool = this.markerDelegate.isVisible();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public void remove()
  {
    try
    {
      this.markerDelegate.remove();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setAlpha(paramFloat);
    }
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.markerDelegate.setAnchor(paramFloat1, paramFloat2);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    try
    {
      this.markerDelegate.setAnimation(paramAnimation);
      return;
    }
    catch (Throwable paramAnimation) {}
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.markerDelegate.setAnimationListener(paramAnimationListener);
  }
  
  public void setAutoOverturnInfoWindow(boolean paramBoolean)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setAutoOverturnInfoWindow(paramBoolean);
    }
  }
  
  public void setBelowMaskLayer(boolean paramBoolean)
  {
    this.markerDelegate.setBelowMaskLayer(paramBoolean);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setClickable(paramBoolean);
    }
  }
  
  public void setDisplayLevel(int paramInt)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setDisplayLevel(paramInt);
    }
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    try
    {
      this.markerDelegate.setDraggable(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setFixingPointEnable(boolean paramBoolean)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setFixingPointEnable(paramBoolean);
    }
  }
  
  public void setFlat(boolean paramBoolean)
  {
    try
    {
      this.markerDelegate.setFlat(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setGeoPoint(IPoint paramIPoint)
  {
    this.markerDelegate.setGeoPoint(paramIPoint);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null) {
      try
      {
        this.markerDelegate.setIcon(paramBitmapDescriptor);
        return;
      }
      catch (Throwable paramBitmapDescriptor)
      {
        paramBitmapDescriptor.printStackTrace();
      }
    }
  }
  
  public void setIcons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    try
    {
      this.markerDelegate.setIcons(paramArrayList);
      return;
    }
    catch (Throwable paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void setInfoWindowEnable(boolean paramBoolean)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setInfoWindowEnable(paramBoolean);
    }
  }
  
  public void setMarkerOptions(MarkerOptions paramMarkerOptions)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setMarkerOptions(paramMarkerOptions);
    }
  }
  
  public void setObject(Object paramObject)
  {
    this.markerDelegate.setObject(paramObject);
  }
  
  public void setPeriod(int paramInt)
  {
    try
    {
      this.markerDelegate.setPeriod(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setPerspective(boolean paramBoolean)
  {
    try
    {
      this.markerDelegate.setPerspective(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.markerDelegate.setPosition(paramLatLng);
      return;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setPositionByPixels(int paramInt1, int paramInt2)
  {
    this.markerDelegate.setPositionByPixels(paramInt1, paramInt2);
  }
  
  public void setPositionNotUpdate(LatLng paramLatLng)
  {
    setPosition(paramLatLng);
  }
  
  public void setRotateAngle(float paramFloat)
  {
    try
    {
      this.markerDelegate.setRotateAngle(paramFloat);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setRotateAngleNotUpdate(float paramFloat)
  {
    IMarkerAction localIMarkerAction = this.markerDelegate.getIMarkerAction();
    if (localIMarkerAction != null) {
      localIMarkerAction.setRotateAngleNotUpdate(paramFloat);
    }
  }
  
  public void setSnippet(String paramString)
  {
    try
    {
      this.markerDelegate.setSnippet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTitle(String paramString)
  {
    try
    {
      this.markerDelegate.setTitle(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setToTop()
  {
    try
    {
      this.markerDelegate.set2Top();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.markerDelegate.setVisible(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    this.markerDelegate.setZIndex(paramFloat);
  }
  
  public void showInfoWindow()
  {
    try
    {
      this.markerDelegate.showInfoWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean startAnimation()
  {
    return this.markerDelegate.startAnimation();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */