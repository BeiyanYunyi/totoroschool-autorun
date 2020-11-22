package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

final class j
  extends Handler
{
  j(Looper paramLooper, QbSdk.PreInitCallback paramPreInitCallback, Context paramContext)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = false;
    switch (i)
    {
    default: 
      return;
    case 3: 
      if (this.a == null) {
        return;
      }
      this.a.onCoreInitFinished();
      return;
    case 2: 
      if (this.a != null) {
        paramMessage = this.a;
      }
      break;
    }
    for (;;)
    {
      paramMessage.onViewInitFinished(bool);
      do
      {
        TbsLog.writeLogToDisk();
        return;
        if (("com.tencent.mm".equals(QbSdk.getCurrentProcessName(this.b))) && (!QbSdk.c())) {
          QbSdk.j = false;
        }
        if (QbSdk.j)
        {
          paramMessage = bt.a().c();
          if (paramMessage != null) {
            paramMessage.a(this.b);
          }
        }
      } while (this.a == null);
      paramMessage = this.a;
      bool = true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */