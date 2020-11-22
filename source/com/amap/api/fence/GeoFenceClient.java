package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.loc.a;
import com.loc.az;
import com.loc.dg;
import com.loc.w;
import java.util.ArrayList;
import java.util.List;

public class GeoFenceClient
{
  public static final int GEOFENCE_IN = 1;
  public static final int GEOFENCE_OUT = 2;
  public static final int GEOFENCE_STAYED = 4;
  Context a = null;
  GeoFenceManagerBase b = null;
  
  public GeoFenceClient(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      this.a = paramContext.getApplicationContext();
      this.b = a(this.a);
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "GeoFenceClient", "<init>");
    }
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  private static GeoFenceManagerBase a(Context paramContext)
  {
    try
    {
      localObject1 = (GeoFenceManagerBase)az.a(paramContext, dg.b(), w.c("EY29tLmFtYXAuYXBpLmZlbmNlLkdlb0ZlbmNlTWFuYWdlcldyYXBwZXI="), a.class, new Class[] { Context.class }, new Object[] { paramContext });
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = new a(paramContext);
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new a(paramContext);
    }
    return (GeoFenceManagerBase)localObject2;
  }
  
  public void addGeoFence(DPoint paramDPoint, float paramFloat, String paramString)
  {
    try
    {
      this.b.addRoundGeoFence(paramDPoint, paramFloat, paramString);
      return;
    }
    catch (Throwable paramDPoint)
    {
      dg.a(paramDPoint, "GeoFenceClient", "addGeoFence round");
    }
  }
  
  public void addGeoFence(String paramString1, String paramString2)
  {
    try
    {
      this.b.addDistrictGeoFence(paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "GeoFenceClient", "addGeoFence district");
    }
  }
  
  public void addGeoFence(String paramString1, String paramString2, DPoint paramDPoint, float paramFloat, int paramInt, String paramString3)
  {
    try
    {
      this.b.addNearbyGeoFence(paramString1, paramString2, paramDPoint, paramFloat, paramInt, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "GeoFenceClient", "addGeoFence searche");
    }
  }
  
  public void addGeoFence(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    try
    {
      this.b.addKeywordGeoFence(paramString1, paramString2, paramString3, paramInt, paramString4);
      return;
    }
    catch (Throwable paramString1)
    {
      dg.a(paramString1, "GeoFenceClient", "addGeoFence searche");
    }
  }
  
  public void addGeoFence(List<DPoint> paramList, String paramString)
  {
    try
    {
      this.b.addPolygonGeoFence(paramList, paramString);
      return;
    }
    catch (Throwable paramList)
    {
      dg.a(paramList, "GeoFenceClient", "addGeoFence polygon");
    }
  }
  
  public PendingIntent createPendingIntent(String paramString)
  {
    try
    {
      paramString = this.b.createPendingIntent(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "GeoFenceClient", "creatPendingIntent");
    }
    return null;
  }
  
  public List<GeoFence> getAllGeoFence()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      List localList = this.b.getAllGeoFence();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "getGeoFenceList");
    }
    return localArrayList;
  }
  
  public boolean isPause()
  {
    try
    {
      boolean bool = this.b.isPause();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "isPause");
    }
    return true;
  }
  
  public void pauseGeoFence()
  {
    try
    {
      this.b.pauseGeoFence();
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "pauseGeoFence");
    }
  }
  
  public void removeGeoFence()
  {
    try
    {
      this.b.removeGeoFence();
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "removeGeoFence");
    }
  }
  
  public boolean removeGeoFence(GeoFence paramGeoFence)
  {
    try
    {
      boolean bool = this.b.removeGeoFence(paramGeoFence);
      return bool;
    }
    catch (Throwable paramGeoFence)
    {
      dg.a(paramGeoFence, "GeoFenceClient", "removeGeoFence1");
    }
    return false;
  }
  
  public void resumeGeoFence()
  {
    try
    {
      this.b.resumeGeoFence();
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "resumeGeoFence");
    }
  }
  
  public void setActivateAction(int paramInt)
  {
    try
    {
      this.b.setActivateAction(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "GeoFenceClient", "setActivatesAction");
    }
  }
  
  public void setGeoFenceAble(String paramString, boolean paramBoolean)
  {
    try
    {
      this.b.setGeoFenceAble(paramString, paramBoolean);
      return;
    }
    catch (Throwable paramString)
    {
      dg.a(paramString, "GeoFenceClient", "setGeoFenceAble");
    }
  }
  
  public void setGeoFenceListener(GeoFenceListener paramGeoFenceListener)
  {
    try
    {
      this.b.setGeoFenceListener(paramGeoFenceListener);
      return;
    }
    catch (Throwable paramGeoFenceListener)
    {
      dg.a(paramGeoFenceListener, "GeoFenceClient", "setGeoFenceListener");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\fence\GeoFenceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */