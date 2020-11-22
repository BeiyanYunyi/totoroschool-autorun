package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

public final class kq
  extends Handler
{
  ko a = null;
  
  public kq(Looper paramLooper, ko paramko)
  {
    super(paramLooper);
    this.a = paramko;
  }
  
  public kq(ko paramko)
  {
    this.a = paramko;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    try
    {
      if (this.a != null) {
        this.a.a((Inner_3dMap_location)paramMessage.obj);
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      lf.a(paramMessage, "ClientResultHandler", "RESULT_LOCATION_FINISH");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */