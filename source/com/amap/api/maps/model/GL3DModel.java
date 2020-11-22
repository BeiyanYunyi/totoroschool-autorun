package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IglModel;

public class GL3DModel
  extends BasePointOverlay
{
  private final IglModel mModel;
  
  public GL3DModel(IglModel paramIglModel)
  {
    this.mModel = paramIglModel;
  }
  
  public void destroy()
  {
    if (this.mModel != null) {
      this.mModel.destroy();
    }
  }
  
  public float getAngle()
  {
    try
    {
      float f = this.mModel.getRotateAngle();
      return f;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0.0F;
  }
  
  public String getId()
  {
    try
    {
      String str = this.mModel.getId();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public Object getObject()
  {
    if (this.mModel != null) {
      return this.mModel.getObject();
    }
    return null;
  }
  
  public LatLng getPosition()
  {
    try
    {
      LatLng localLatLng = this.mModel.getPosition();
      return localLatLng;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public float getRotateAngle()
  {
    try
    {
      float f = this.mModel.getRotateAngle();
      return f;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0.0F;
  }
  
  public String getSnippet()
  {
    try
    {
      String str = this.mModel.getSnippet();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public String getTitle()
  {
    try
    {
      String str = this.mModel.getTitle();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public boolean isVisible()
  {
    try
    {
      boolean bool = this.mModel.isVisible();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void remove()
  {
    try
    {
      this.mModel.remove();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setAngle(float paramFloat)
  {
    try
    {
      this.mModel.setRotateAngle(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    try
    {
      this.mModel.setAnimation(paramAnimation);
      return;
    }
    catch (Throwable paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void setGeoPoint(IPoint paramIPoint)
  {
    if (this.mModel != null) {
      this.mModel.setGeoPoint(paramIPoint);
    }
  }
  
  public void setModelFixedLength(int paramInt)
  {
    try
    {
      this.mModel.setModelFixedLength(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setObject(Object paramObject)
  {
    try
    {
      this.mModel.setObject(paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.mModel.setPosition(paramLatLng);
      return;
    }
    catch (Exception paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setRotateAngle(float paramFloat)
  {
    try
    {
      this.mModel.setRotateAngle(paramFloat);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setSnippet(String paramString)
  {
    if (this.mModel != null) {
      this.mModel.setSnippet(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.mModel != null) {
      this.mModel.setTitle(paramString);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.mModel.setVisible(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setZoomLimit(float paramFloat)
  {
    if (this.mModel != null) {
      this.mModel.setZoomLimit(paramFloat);
    }
  }
  
  public void showInfoWindow()
  {
    try
    {
      this.mModel.showInfoWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean startAnimation()
  {
    try
    {
      boolean bool = this.mModel.startAnimation();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\GL3DModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */