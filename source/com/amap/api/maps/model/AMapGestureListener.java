package com.amap.api.maps.model;

public abstract interface AMapGestureListener
{
  public abstract void onDoubleTap(float paramFloat1, float paramFloat2);
  
  public abstract void onDown(float paramFloat1, float paramFloat2);
  
  public abstract void onFling(float paramFloat1, float paramFloat2);
  
  public abstract void onLongPress(float paramFloat1, float paramFloat2);
  
  public abstract void onMapStable();
  
  public abstract void onScroll(float paramFloat1, float paramFloat2);
  
  public abstract void onSingleTap(float paramFloat1, float paramFloat2);
  
  public abstract void onUp(float paramFloat1, float paramFloat2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\AMapGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */