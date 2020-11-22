package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

public abstract interface TraceListener
{
  public abstract void onFinished(int paramInt1, List<LatLng> paramList, int paramInt2, int paramInt3);
  
  public abstract void onRequestFailed(int paramInt, String paramString);
  
  public abstract void onTraceProcessing(int paramInt1, int paramInt2, List<LatLng> paramList);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\TraceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */