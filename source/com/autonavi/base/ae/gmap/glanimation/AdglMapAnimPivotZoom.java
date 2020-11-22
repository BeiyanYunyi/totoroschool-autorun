package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimPivotZoom
  extends AbstractAdglAnimation
{
  private int beginCenterGeoX;
  private int beginCenterGeoY;
  private boolean hasCheckParams;
  private float mapLevelTo;
  private int pivotGeoX;
  private int pivotGeoY;
  private float winPivotX;
  private float winPivotY;
  private boolean zoomCenter;
  AbstractAdglAnimationParam1V zoomParam = null;
  
  public AdglMapAnimPivotZoom(int paramInt)
  {
    reset();
    this.duration = paramInt;
  }
  
  public void commitAnimation(Object paramObject)
  {
    this.isOver = true;
    this.hasCheckParams = false;
    paramObject = (GLMapState)paramObject;
    if (paramObject == null) {
      return;
    }
    float f = ((GLMapState)paramObject).getMapZoomer();
    if (Math.abs(this.mapLevelTo - f) < 1.0E-6D)
    {
      this.isOver = true;
      this.hasCheckParams = true;
      return;
    }
    this.zoomParam.setFromValue(f);
    this.zoomParam.setToValue(this.mapLevelTo);
    if (!this.zoomCenter)
    {
      IPoint localIPoint1 = IPoint.obtain();
      ((GLMapState)paramObject).getMapGeoCenter(localIPoint1);
      this.beginCenterGeoX = localIPoint1.x;
      this.beginCenterGeoY = localIPoint1.y;
      IPoint localIPoint2 = IPoint.obtain();
      ((GLMapState)paramObject).screenToP20Point((int)this.winPivotX, (int)this.winPivotY, localIPoint2);
      this.pivotGeoX = localIPoint2.x;
      this.pivotGeoY = localIPoint2.y;
      localIPoint1.recycle();
      localIPoint2.recycle();
    }
    this.hasCheckParams = true;
    this.isOver = false;
    this.startTime = SystemClock.uptimeMillis();
  }
  
  public void doAnimation(Object paramObject)
  {
    GLMapState localGLMapState = (GLMapState)paramObject;
    if (localGLMapState == null) {
      return;
    }
    if (!this.hasCheckParams) {
      commitAnimation(paramObject);
    }
    if (this.isOver) {
      return;
    }
    this.offsetTime = (SystemClock.uptimeMillis() - this.startTime);
    float f2 = (float)this.offsetTime / this.duration;
    float f1 = f2;
    if (f2 > 1.0F)
    {
      this.isOver = true;
      f1 = 1.0F;
    }
    if ((f1 >= 0.0F) && (f1 <= 1.0F))
    {
      this.zoomParam.setNormalizedTime(f1);
      f2 = this.zoomParam.getCurValue();
      f1 = f2;
      if (f2 > 20.0F)
      {
        this.isOver = true;
        f1 = 20.0F;
      }
      f2 = f1;
      if (f1 < 3.0F)
      {
        this.isOver = true;
        f2 = 3.0F;
      }
      if (!this.zoomCenter)
      {
        float f3 = (float)Math.pow(2.0D, f2 - this.zoomParam.getFromValue());
        f1 = this.pivotGeoX - this.beginCenterGeoX;
        f3 = 1.0F - 1.0F / f3;
        int i = (int)(f1 * f3);
        int j = (int)((this.pivotGeoY - this.beginCenterGeoY) * f3);
        localGLMapState.setMapGeoCenter(this.beginCenterGeoX + i, this.beginCenterGeoY + j);
      }
      localGLMapState.setMapZoomer(f2);
    }
  }
  
  public void reset()
  {
    this.isOver = false;
    this.hasCheckParams = false;
    this.zoomCenter = true;
    this.mapLevelTo = 0.0F;
    this.beginCenterGeoX = 0;
    this.beginCenterGeoY = 0;
    this.pivotGeoX = 0;
    this.pivotGeoY = 0;
    this.winPivotX = 0.0F;
    this.winPivotY = 0.0F;
    if (this.zoomParam != null) {
      this.zoomParam.reset();
    }
  }
  
  public void setToMapZoomAndPivot(float paramFloat, int paramInt, Point paramPoint)
  {
    this.zoomParam = new AbstractAdglAnimationParam1V();
    this.zoomParam.setInterpolatorType(paramInt, 1.0F);
    float f = paramFloat;
    if (paramFloat > 20.0F) {
      f = 20.0F;
    }
    paramFloat = f;
    if (f < 3.0F) {
      paramFloat = 3.0F;
    }
    this.mapLevelTo = paramFloat;
    if (paramPoint != null)
    {
      this.winPivotX = paramPoint.x;
      this.winPivotY = paramPoint.y;
      this.zoomCenter = false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglMapAnimPivotZoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */