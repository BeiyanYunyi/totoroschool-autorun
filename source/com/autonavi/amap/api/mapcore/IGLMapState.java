package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

public abstract interface IGLMapState
{
  public abstract float getCameraDegree();
  
  public abstract float getMapAngle();
  
  public abstract DPoint getMapGeoCenter();
  
  public abstract void getMapGeoCenter(IPoint paramIPoint);
  
  public abstract float getMapZoomer();
  
  public abstract void recalculate();
  
  public abstract void recycle();
  
  public abstract void screenToP20Point(int paramInt1, int paramInt2, Point paramPoint);
  
  public abstract void setCameraDegree(float paramFloat);
  
  public abstract void setMapAngle(float paramFloat);
  
  public abstract void setMapGeoCenter(double paramDouble1, double paramDouble2);
  
  public abstract void setMapZoomer(float paramFloat);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\api\mapcore\IGLMapState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */