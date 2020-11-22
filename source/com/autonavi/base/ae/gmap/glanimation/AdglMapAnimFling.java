package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

public class AdglMapAnimFling
  extends AbstractAdglAnimation
{
  private IPoint fromCenter;
  private boolean hasCheckParams;
  private int lastMoveX;
  private int lastMoveY;
  private AbstractAdglAnimationParam2V moveParam;
  private boolean needMove;
  private int screenCenterX;
  private int screenCenterY;
  private float velocityX;
  private float velocityY;
  
  public AdglMapAnimFling(int paramInt1, int paramInt2, int paramInt3)
  {
    this.screenCenterX = paramInt2;
    this.screenCenterY = paramInt3;
    this.lastMoveX = paramInt2;
    this.lastMoveY = paramInt3;
    this.moveParam = null;
    reset();
    this.duration = paramInt1;
  }
  
  public void commitAnimation(Object paramObject)
  {
    paramObject = (GLMapState)paramObject;
    if (paramObject == null) {
      return;
    }
    this.hasCheckParams = false;
    this.isOver = true;
    int i = (int)(this.velocityX * this.duration / 2000.0F);
    int j = (int)(this.velocityY * this.duration / 2000.0F);
    if ((Math.abs(i) != 0) && (Math.abs(j) != 0))
    {
      if (this.fromCenter == null) {
        this.fromCenter = IPoint.obtain();
      }
      ((GLMapState)paramObject).getMapGeoCenter(this.fromCenter);
      this.isOver = false;
      this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
      this.moveParam.setToValue(this.screenCenterX - i, this.screenCenterY - j);
      this.needMove = this.moveParam.needToCaculate();
    }
    boolean bool = this.needMove;
    this.hasCheckParams = true;
    this.startTime = SystemClock.uptimeMillis();
  }
  
  public void commitAnimationold(Object paramObject)
  {
    paramObject = (GLMapState)paramObject;
    if (paramObject == null) {
      return;
    }
    this.hasCheckParams = false;
    this.isOver = true;
    float f = (float)Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY) / 1000.0F;
    if (f >= 0.1F)
    {
      f *= 0.02F;
      if (this.fromCenter == null) {
        this.fromCenter = IPoint.obtain();
      }
      ((GLMapState)paramObject).getMapGeoCenter(this.fromCenter);
      this.isOver = false;
      this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
      this.moveParam.setToValue(this.screenCenterX - this.velocityX * f, this.screenCenterY - this.velocityY * f);
      this.needMove = this.moveParam.needToCaculate();
    }
    boolean bool = this.needMove;
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
    float f2 = (float)this.offsetTime / this.duration;
    float f1 = f2;
    if (f2 > 1.0F)
    {
      this.isOver = true;
      f1 = 1.0F;
    }
    if ((f1 >= 0.0F) && (f1 <= 1.0F) && (this.needMove))
    {
      this.moveParam.setNormalizedTime(f1);
      int i = (int)this.moveParam.getCurXValue();
      int j = (int)this.moveParam.getCurYValue();
      paramObject = IPoint.obtain();
      localGLMapState.screenToP20Point(this.screenCenterX + i - this.lastMoveX, this.screenCenterY + j - this.lastMoveY, (Point)paramObject);
      localGLMapState.setMapGeoCenter(((IPoint)paramObject).x, ((IPoint)paramObject).y);
      this.lastMoveX = i;
      this.lastMoveY = j;
      ((IPoint)paramObject).recycle();
    }
  }
  
  public void reset()
  {
    if (this.moveParam != null) {
      this.moveParam.reset();
    }
    this.velocityX = 0.0F;
    this.velocityY = 0.0F;
    this.needMove = false;
    this.hasCheckParams = false;
  }
  
  public void setPositionAndVelocity(float paramFloat1, float paramFloat2)
  {
    this.moveParam = null;
    this.velocityX = paramFloat1;
    this.velocityY = paramFloat2;
    this.moveParam = new AbstractAdglAnimationParam2V();
    this.moveParam.setInterpolatorType(2, 1.2F);
    this.needMove = false;
    this.hasCheckParams = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\glanimation\AdglMapAnimFling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */