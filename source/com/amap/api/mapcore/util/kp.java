package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

public final class kp
  extends Handler
{
  ko a = null;
  
  public kp() {}
  
  public kp(Looper paramLooper, ko paramko)
  {
    super(paramLooper);
    this.a = paramko;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1007: 
      try
      {
        this.a.d();
        return;
      }
      catch (Throwable paramMessage)
      {
        lf.a(paramMessage, "ClientActionHandler", "ACTION_DESTROY");
        return;
      }
    case 1006: 
      try
      {
        this.a.c();
        return;
      }
      catch (Throwable localThrowable1)
      {
        paramMessage = "ACTION_STOP_LOCATION";
      }
    }
    for (;;)
    {
      lf.a(localThrowable1, "ClientActionHandler", paramMessage);
      return;
      try
      {
        this.a.b();
        return;
      }
      catch (Throwable localThrowable2)
      {
        paramMessage = "ACTION_GET_LOCATION";
      }
      continue;
      try
      {
        this.a.a();
        return;
      }
      catch (Throwable localThrowable3)
      {
        paramMessage = "ACTION_START_LOCATION";
      }
      continue;
      try
      {
        paramMessage = (Inner_3dMap_locationListener)paramMessage.obj;
        this.a.b(paramMessage);
        return;
      }
      catch (Throwable localThrowable4)
      {
        paramMessage = "ACTION_REMOVE_LISTENER";
      }
      continue;
      try
      {
        paramMessage = (Inner_3dMap_locationListener)paramMessage.obj;
        this.a.a(paramMessage);
        return;
      }
      catch (Throwable localThrowable5)
      {
        paramMessage = "ACTION_SET_LISTENER";
      }
      continue;
      try
      {
        paramMessage = (Inner_3dMap_locationOption)paramMessage.obj;
        this.a.a(paramMessage);
        return;
      }
      catch (Throwable localThrowable6)
      {
        paramMessage = "ACTION_SET_OPTION";
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */