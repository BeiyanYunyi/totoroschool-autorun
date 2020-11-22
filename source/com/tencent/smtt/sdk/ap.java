package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

class ap
  extends Handler
{
  ap(am paramam, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QbSdk.setTBSInstallingStatus(true);
    Object[] arrayOfObject;
    switch (paramMessage.what)
    {
    default: 
      break;
    case 3: 
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
      arrayOfObject = (Object[])paramMessage.obj;
      this.a.b((Context)arrayOfObject[0], (Bundle)arrayOfObject[1]);
      break;
    case 2: 
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
      arrayOfObject = (Object[])paramMessage.obj;
      am.a(this.a, (Context)arrayOfObject[0], (Context)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
      break;
    case 1: 
      TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
      arrayOfObject = (Object[])paramMessage.obj;
      am.a(this.a, (Context)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
    }
    QbSdk.setTBSInstallingStatus(false);
    super.handleMessage(paramMessage);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */