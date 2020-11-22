package com.amap.api.fence;

import android.app.PendingIntent;
import com.amap.api.location.DPoint;
import java.util.List;

public abstract interface GeoFenceManagerBase
{
  public abstract void addDistrictGeoFence(String paramString1, String paramString2);
  
  public abstract void addKeywordGeoFence(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  
  public abstract void addNearbyGeoFence(String paramString1, String paramString2, DPoint paramDPoint, float paramFloat, int paramInt, String paramString3);
  
  public abstract void addPolygonGeoFence(List<DPoint> paramList, String paramString);
  
  public abstract void addRoundGeoFence(DPoint paramDPoint, float paramFloat, String paramString);
  
  public abstract PendingIntent createPendingIntent(String paramString);
  
  public abstract List<GeoFence> getAllGeoFence();
  
  public abstract boolean isPause();
  
  public abstract void pauseGeoFence();
  
  public abstract void removeGeoFence();
  
  public abstract boolean removeGeoFence(GeoFence paramGeoFence);
  
  public abstract void resumeGeoFence();
  
  public abstract void setActivateAction(int paramInt);
  
  public abstract void setGeoFenceAble(String paramString, boolean paramBoolean);
  
  public abstract void setGeoFenceListener(GeoFenceListener paramGeoFenceListener);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\GeoFenceManagerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */