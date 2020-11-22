package com.amap.api.maps.model;

public class NaviPara
{
  @Deprecated
  public static final int DRIVING_AVOID_CONGESTION = 4;
  @Deprecated
  public static final int DRIVING_DEFAULT = 0;
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY = 3;
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
  @Deprecated
  public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
  @Deprecated
  public static final int DRIVING_SAVE_MONEY = 1;
  @Deprecated
  public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
  @Deprecated
  public static final int DRIVING_SHORT_DISTANCE = 2;
  private LatLng latLng;
  private int naviStyle = 0;
  
  public int getNaviStyle()
  {
    return this.naviStyle;
  }
  
  public LatLng getTargetPoint()
  {
    return this.latLng;
  }
  
  public void setNaviStyle(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 9)) {
      this.naviStyle = paramInt;
    }
  }
  
  public void setTargetPoint(LatLng paramLatLng)
  {
    this.latLng = paramLatLng;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\NaviPara.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */