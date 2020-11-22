package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public class i
  extends AbstractCameraUpdateMessage
{
  public void a(IGLMapState paramIGLMapState, int paramInt1, int paramInt2, Point paramPoint)
  {
    paramIGLMapState.screenToP20Point(paramInt1, paramInt2, paramPoint);
  }
  
  public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage) {}
  
  public void runCameraUpdate(IGLMapState paramIGLMapState)
  {
    float f1 = this.xPixel;
    float f2 = this.yPixel;
    float f3 = this.width / 2.0F;
    float f4 = this.height / 2.0F;
    Point localPoint = new Point();
    a(paramIGLMapState, (int)(f3 + f1), (int)(f4 + f2), localPoint);
    paramIGLMapState.setMapGeoCenter(localPoint.x, localPoint.y);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */