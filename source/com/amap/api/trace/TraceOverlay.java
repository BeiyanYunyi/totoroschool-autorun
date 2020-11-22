package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraceOverlay
{
  public static final int TRACE_STATUS_FAILURE = 3;
  public static final int TRACE_STATUS_FINISH = 2;
  public static final int TRACE_STATUS_PREPARE = 4;
  public static final int TRACE_STATUS_PROCESSING = 1;
  private Polyline a;
  private PolylineOptions b;
  private AMap c;
  private List<LatLng> d = new ArrayList();
  private int e = 4;
  private int f;
  private int g;
  
  public TraceOverlay(AMap paramAMap)
  {
    this.c = paramAMap;
    a();
  }
  
  public TraceOverlay(AMap paramAMap, List<LatLng> paramList)
  {
    this.c = paramAMap;
    a();
    this.d = paramList;
    this.b.addAll(paramList);
    this.a = paramAMap.addPolyline(this.b);
  }
  
  private PolylineOptions a()
  {
    if (this.b == null)
    {
      this.b = new PolylineOptions();
      this.b.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
      this.b.width(40.0F);
    }
    return this.b;
  }
  
  public void add(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.d.addAll(paramList);
      a();
      if (this.a == null) {
        this.a = this.c.addPolyline(this.b);
      }
      if (this.a != null) {
        this.a.setPoints(this.d);
      }
      return;
    }
  }
  
  public int getDistance()
  {
    return this.f;
  }
  
  public int getTraceStatus()
  {
    return this.e;
  }
  
  public int getWaitTime()
  {
    return this.g;
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.remove();
    }
  }
  
  public void setDistance(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setProperCamera(List<LatLng> paramList)
  {
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localBuilder.include((LatLng)paramList.next());
      }
      try
      {
        paramList = localBuilder.build();
        this.c.moveCamera(CameraUpdateFactory.newLatLngBounds(paramList, 20));
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
  }
  
  public void setTraceStatus(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setWaitTime(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void zoopToSpan()
  {
    setProperCamera(this.b.getPoints());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\TraceOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */