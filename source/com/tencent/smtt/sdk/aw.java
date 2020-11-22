package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aw
  extends Handler
{
  aw(TbsLogReport paramTbsLogReport, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 600)
    {
      if ((paramMessage.obj instanceof TbsLogReport.TbsLogInfo))
      {
        TbsLogReport.TbsLogInfo localTbsLogInfo = (TbsLogReport.TbsLogInfo)paramMessage.obj;
        int i = paramMessage.arg1;
        TbsLogReport.a(this.a, i, localTbsLogInfo);
      }
    }
    else if (paramMessage.what == 601) {
      TbsLogReport.a(this.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */