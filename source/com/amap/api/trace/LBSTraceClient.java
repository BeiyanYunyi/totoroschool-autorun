package com.amap.api.trace;

import android.content.Context;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.ey;
import com.amap.api.mapcore.util.fv;
import com.amap.api.mapcore.util.ha;
import java.util.List;

public class LBSTraceClient
{
  public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
  public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
  public static final String TRACE_SUCCESS = "纠偏成功";
  public static final int TYPE_AMAP = 1;
  public static final int TYPE_BAIDU = 3;
  public static final int TYPE_GPS = 2;
  private static LBSTraceBase a;
  private static volatile LBSTraceClient b;
  
  private LBSTraceClient() {}
  
  public LBSTraceClient(Context paramContext)
  {
    a(paramContext);
  }
  
  private static void a()
  {
    a = null;
    b = null;
  }
  
  private static void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      fv localfv = dx.e();
      Context localContext1 = paramContext.getApplicationContext();
      Context localContext2 = paramContext.getApplicationContext();
      a = (LBSTraceBase)ha.a(localContext1, localfv, "com.amap.api.wrapper.LBSTraceClientWrapper", ey.class, new Class[] { Context.class }, new Object[] { localContext2 });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    a = new ey(paramContext.getApplicationContext());
  }
  
  public static LBSTraceClient getInstance(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          a(paramContext);
          b = new LBSTraceClient();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void destroy()
  {
    if (a != null)
    {
      a.destroy();
      a();
    }
  }
  
  public void queryProcessedTrace(int paramInt1, List<TraceLocation> paramList, int paramInt2, TraceListener paramTraceListener)
  {
    if (a != null) {
      a.queryProcessedTrace(paramInt1, paramList, paramInt2, paramTraceListener);
    }
  }
  
  public void startTrace(TraceStatusListener paramTraceStatusListener)
  {
    if (a != null) {
      a.startTrace(paramTraceStatusListener);
    }
  }
  
  public void stopTrace()
  {
    if (a != null) {
      a.stopTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\trace\LBSTraceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */