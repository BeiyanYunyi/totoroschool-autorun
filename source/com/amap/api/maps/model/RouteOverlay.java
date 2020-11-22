package com.amap.api.maps.model;

import com.autonavi.ae.gmap.gloverlay.BaseRouteOverlay;
import com.autonavi.ae.gmap.gloverlay.GLRouteProperty;

public class RouteOverlay
{
  BaseRouteOverlay a = null;
  
  public RouteOverlay(BaseRouteOverlay paramBaseRouteOverlay)
  {
    this.a = paramBaseRouteOverlay;
  }
  
  public void addRouteItem(int paramInt1, GLRouteProperty[] paramArrayOfGLRouteProperty, boolean paramBoolean, long paramLong, int paramInt2)
  {
    paramArrayOfGLRouteProperty = this.a;
  }
  
  public void remove()
  {
    BaseRouteOverlay localBaseRouteOverlay = this.a;
  }
  
  public void removeRouteName()
  {
    BaseRouteOverlay localBaseRouteOverlay = this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\RouteOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */