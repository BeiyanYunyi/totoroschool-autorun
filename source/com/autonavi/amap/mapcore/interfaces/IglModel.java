package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;

public abstract interface IglModel
{
  public abstract void destroy();
  
  public abstract String getId();
  
  public abstract Object getObject();
  
  public abstract LatLng getPosition();
  
  public abstract float getRotateAngle();
  
  public abstract String getSnippet();
  
  public abstract String getTitle();
  
  public abstract boolean isVisible();
  
  public abstract boolean remove();
  
  public abstract void setAnimation(Animation paramAnimation);
  
  public abstract void setGeoPoint(IPoint paramIPoint);
  
  public abstract void setModelFixedLength(int paramInt);
  
  public abstract void setObject(Object paramObject);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setRotateAngle(float paramFloat);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZoomLimit(float paramFloat);
  
  public abstract void showInfoWindow();
  
  public abstract boolean startAnimation();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IglModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */