package com.amap.api.trace;

import java.util.List;

public abstract interface LBSTraceBase
{
  public abstract void destroy();
  
  public abstract void queryProcessedTrace(int paramInt1, List<TraceLocation> paramList, int paramInt2, TraceListener paramTraceListener);
  
  public abstract void setLocationInterval(long paramLong);
  
  public abstract void setTraceStatusInterval(int paramInt);
  
  public abstract void startTrace(TraceStatusListener paramTraceStatusListener);
  
  public abstract void stopTrace();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\LBSTraceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */