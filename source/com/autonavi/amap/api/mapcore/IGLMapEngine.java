package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap.CancelableCallback;

public abstract interface IGLMapEngine
{
  public abstract void addGroupAnimation(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, AMap.CancelableCallback paramCancelableCallback);
  
  public abstract IGLMapState getNewMapState(int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\api\mapcore\IGLMapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */