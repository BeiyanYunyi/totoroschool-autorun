package com.amap.api.mapcore.util;

import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

public class g
  extends AbstractCameraUpdateMessage
{
  public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage) {}
  
  public void runCameraUpdate(IGLMapState paramIGLMapState)
  {
    Pair localPair = dx.a(this, paramIGLMapState, this.mapConfig);
    if (localPair == null) {
      return;
    }
    paramIGLMapState.setMapZoomer(((Float)localPair.first).floatValue());
    paramIGLMapState.setMapGeoCenter(((IPoint)localPair.second).x, ((IPoint)localPair.second).y);
    paramIGLMapState.setCameraDegree(0.0F);
    paramIGLMapState.setMapAngle(0.0F);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */