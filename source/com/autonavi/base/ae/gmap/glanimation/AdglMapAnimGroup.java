package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimGroup
  extends AbstractAdglAnimation
{
  public static final int CAMERA_MAX_DEGREE = 60;
  public static final int CAMERA_MIN_DEGREE = 0;
  public static final int MAXMAPLEVEL = 20;
  public static final int MINMAPLEVEL = 3;
  int endZoomDuration;
  boolean hasCheckParams;
  boolean hasMidZoom;
  int midZoomDuration;
  AbstractAdglAnimationParam2V moveParam = null;
  public boolean needMove;
  boolean needRotateCamera;
  boolean needRotateMap;
  boolean needZoom;
  AbstractAdglAnimationParam1V rotateCameraParam = null;
  AbstractAdglAnimationParam1V rotateMapParam = null;
  int startZoomDuration;
  AbstractAdglAnimationParam1V zoomEndParam = null;
  AbstractAdglAnimationParam1V zoomStartParam = null;
  
  public AdglMapAnimGroup(int paramInt)
  {
    reset();
    this.duration = paramInt;
  }
  
  public static boolean checkLevel(float paramFloat)
  {
    return (paramFloat >= 3.0F) && (paramFloat <= 20.0F);
  }
  
  private void initZoomEndParam(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (this.zoomEndParam == null) {
      this.zoomEndParam = new AbstractAdglAnimationParam1V();
    }
    this.zoomEndParam.reset();
    this.zoomEndParam.setInterpolatorType(paramInt, 1.0F);
    this.zoomEndParam.setToValue(paramFloat2);
    this.zoomEndParam.setFromValue(paramFloat1);
  }
  
  private void initZoomStartParam(float paramFloat, int paramInt)
  {
    if (this.zoomStartParam == null) {
      this.zoomStartParam = new AbstractAdglAnimationParam1V();
    }
    this.zoomStartParam.reset();
    this.zoomStartParam.setInterpolatorType(paramInt, 1.0F);
    this.zoomStartParam.setToValue(paramFloat);
  }
  
  public void commitAnimation(Object paramObject)
  {
    this.isOver = true;
    this.hasCheckParams = false;
    paramObject = (GLMapState)paramObject;
    if (paramObject == null) {
      return;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.needZoom)
    {
      if (this.zoomStartParam == null)
      {
        this.hasCheckParams = true;
        return;
      }
      f1 = ((GLMapState)paramObject).getMapZoomer();
      this.zoomStartParam.setFromValue(f1);
      if (this.hasMidZoom)
      {
        f2 = this.zoomStartParam.getToValue();
        f3 = this.zoomEndParam.getFromValue();
        f4 = this.zoomEndParam.getToValue();
        if ((Math.abs(f2 - f1) >= 1.0E-6D) && (Math.abs(f3 - f4) >= 1.0E-6D))
        {
          this.zoomStartParam.needToCaculate();
          this.zoomEndParam.needToCaculate();
        }
        else
        {
          this.hasMidZoom = false;
          this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
          this.zoomStartParam.needToCaculate();
          this.zoomEndParam = null;
        }
      }
      if ((!this.hasMidZoom) && (Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6D)) {
        this.needZoom = false;
      }
      if (this.needZoom) {
        if (this.hasMidZoom)
        {
          this.startZoomDuration = (this.duration - this.midZoomDuration >> 1);
          this.endZoomDuration = this.startZoomDuration;
        }
        else
        {
          this.startZoomDuration = this.duration;
        }
      }
    }
    if ((this.needMove) && (this.moveParam != null))
    {
      IPoint localIPoint = IPoint.obtain();
      ((GLMapState)paramObject).getMapGeoCenter(localIPoint);
      int i = localIPoint.x;
      int j = localIPoint.y;
      localIPoint.recycle();
      this.moveParam.setFromValue(i, j);
      this.needMove = this.moveParam.needToCaculate();
    }
    if ((this.needRotateMap) && (this.rotateMapParam != null))
    {
      f3 = ((GLMapState)paramObject).getMapAngle();
      f2 = this.rotateMapParam.getToValue();
      f1 = f2;
      if (f3 > 180.0F)
      {
        f1 = f2;
        if (f2 == 0.0F) {
          f1 = 360.0F;
        }
      }
      f4 = (int)f1 - (int)f3;
      if (f4 > 180.0F)
      {
        f2 = f1 - 360.0F;
      }
      else
      {
        f2 = f1;
        if (f4 < -180.0F) {
          f2 = f1 + 360.0F;
        }
      }
      this.rotateMapParam.setFromValue(f3);
      this.rotateMapParam.setToValue(f2);
      this.needRotateMap = this.rotateMapParam.needToCaculate();
    }
    if ((this.needRotateCamera) && (this.rotateCameraParam != null))
    {
      f1 = ((GLMapState)paramObject).getCameraDegree();
      this.rotateCameraParam.setFromValue(f1);
      this.needRotateCamera = this.rotateCameraParam.needToCaculate();
    }
    if ((!this.needMove) && (!this.needZoom) && (!this.needRotateMap) && (!this.needRotateCamera)) {
      this.isOver = true;
    } else {
      this.isOver = false;
    }
    this.hasCheckParams = true;
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
    if (this.duration == 0.0F)
    {
      this.isOver = true;
      return;
    }
    float f1 = (float)this.offsetTime / this.duration;
    float f2;
    if (f1 > 1.0F)
    {
      this.isOver = true;
      f2 = 1.0F;
    }
    else
    {
      f2 = f1;
      if (f1 < 0.0F)
      {
        this.isOver = true;
        return;
      }
    }
    if (this.needZoom)
    {
      localGLMapState.getMapZoomer();
      if (this.hasMidZoom)
      {
        if (this.offsetTime <= this.startZoomDuration)
        {
          f1 = (float)this.offsetTime / this.startZoomDuration;
          this.zoomStartParam.setNormalizedTime(f1);
          f1 = this.zoomStartParam.getCurValue();
        }
        else if (this.offsetTime <= this.startZoomDuration + this.midZoomDuration)
        {
          f1 = this.zoomStartParam.getToValue();
        }
        else
        {
          f1 = (float)(this.offsetTime - this.startZoomDuration - this.midZoomDuration) / this.endZoomDuration;
          this.zoomEndParam.setNormalizedTime(f1);
          f1 = this.zoomEndParam.getCurValue();
        }
        if (this.isOver) {
          f1 = this.zoomEndParam.getToValue();
        }
      }
      else
      {
        this.zoomStartParam.setNormalizedTime(f2);
        f1 = this.zoomStartParam.getCurValue();
      }
      localGLMapState.setMapZoomer(f1);
    }
    if ((this.moveParam != null) && (this.needMove))
    {
      this.moveParam.setNormalizedTime(f2);
      int i = (int)this.moveParam.getFromXValue();
      int j = (int)this.moveParam.getFromYValue();
      int m = (int)this.moveParam.getToXValue();
      int k = (int)this.moveParam.getToYValue();
      f1 = this.moveParam.getCurMult();
      m = (int)((m - i) * f1);
      k = (int)((k - j) * f1);
      localGLMapState.setMapGeoCenter(i + m, j + k);
    }
    if ((this.rotateMapParam != null) && (this.needRotateMap))
    {
      this.rotateMapParam.setNormalizedTime(f2);
      localGLMapState.setMapAngle((int)this.rotateMapParam.getCurValue());
    }
    if ((this.rotateCameraParam != null) && (this.needRotateCamera))
    {
      this.rotateCameraParam.setNormalizedTime(f2);
      localGLMapState.setCameraDegree((int)this.rotateCameraParam.getCurValue());
    }
  }
  
  public boolean isValid()
  {
    return (this.needRotateCamera) || (this.needRotateMap) || (this.needMove) || (this.needZoom);
  }
  
  public void reset()
  {
    this.isOver = false;
    this.hasCheckParams = false;
    this.needZoom = false;
    this.needMove = false;
    this.moveParam = null;
    this.needRotateMap = false;
    this.rotateMapParam = null;
    this.hasMidZoom = false;
    this.duration = 0;
    if (this.rotateMapParam != null) {
      this.rotateMapParam.reset();
    }
    if (this.moveParam != null) {
      this.moveParam.reset();
    }
    if (this.zoomStartParam != null) {
      this.zoomStartParam.reset();
    }
    if (this.zoomEndParam != null) {
      this.zoomEndParam.reset();
    }
    if (this.rotateCameraParam != null) {
      this.rotateCameraParam.reset();
    }
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setToCameraDegree(float paramFloat, int paramInt)
  {
    this.needRotateCamera = false;
    if ((paramFloat <= 60.0F) && (paramFloat >= 0.0F))
    {
      this.needRotateCamera = true;
      if (this.rotateCameraParam == null) {
        this.rotateCameraParam = new AbstractAdglAnimationParam1V();
      }
      this.rotateCameraParam.reset();
      this.rotateCameraParam.setInterpolatorType(paramInt, 1.0F);
      this.rotateCameraParam.setToValue(paramFloat);
    }
  }
  
  public void setToMapAngle(float paramFloat, int paramInt)
  {
    this.needRotateMap = true;
    if (this.rotateMapParam == null) {
      this.rotateMapParam = new AbstractAdglAnimationParam1V();
    }
    this.rotateMapParam.reset();
    this.rotateMapParam.setInterpolatorType(paramInt, 1.0F);
    this.rotateMapParam.setToValue(paramFloat % 360.0F);
  }
  
  public void setToMapCenterGeo(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.needMove = true;
      if (this.moveParam == null) {
        this.moveParam = new AbstractAdglAnimationParam2V();
      }
      this.moveParam.reset();
      this.moveParam.setInterpolatorType(paramInt3, 1.0F);
      this.moveParam.setToValue(paramInt1, paramInt2);
    }
  }
  
  public void setToMapLevel(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.needZoom = true;
    this.midZoomDuration = 0;
    this.hasMidZoom = false;
    if ((paramInt > 0) && (paramInt < this.duration)) {
      this.midZoomDuration = paramInt;
    }
    if ((checkLevel(paramFloat1)) && (checkLevel(paramFloat2)))
    {
      this.hasMidZoom = true;
      initZoomStartParam(paramFloat2, 0);
      initZoomEndParam(paramFloat2, paramFloat1, 0);
      return;
    }
    if (checkLevel(paramFloat1))
    {
      this.hasMidZoom = false;
      initZoomStartParam(paramFloat1, 0);
      return;
    }
    if (checkLevel(paramFloat2))
    {
      this.hasMidZoom = false;
      initZoomStartParam(paramFloat2, 0);
      return;
    }
    this.needZoom = false;
  }
  
  public void setToMapLevel(float paramFloat, int paramInt)
  {
    this.needZoom = true;
    this.midZoomDuration = 0;
    this.hasMidZoom = false;
    if (checkLevel(paramFloat))
    {
      initZoomStartParam(paramFloat, paramInt);
      return;
    }
    this.needZoom = false;
  }
  
  public boolean typeEqueal(AdglMapAnimGroup paramAdglMapAnimGroup)
  {
    return (this.needRotateCamera == paramAdglMapAnimGroup.needRotateCamera) && (this.needRotateMap == paramAdglMapAnimGroup.needRotateMap) && (this.needZoom == paramAdglMapAnimGroup.needZoom) && (this.needMove == paramAdglMapAnimGroup.needMove);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglMapAnimGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */