package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

public abstract interface TraceStatusListener
{
  public abstract void onTraceStatus(List<TraceLocation> paramList, List<LatLng> paramList1, String paramString);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\TraceStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */