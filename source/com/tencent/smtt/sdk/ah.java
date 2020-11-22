package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ah
  extends Handler
{
  ah(ag paramag, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 150) {
      ag.a(this.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */