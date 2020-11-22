package com.pgyersdk.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.pgyersdk.b.a.b;
import com.pgyersdk.b.b.a;

class f
  extends Handler
{
  f(g paramg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (Bitmap)paramMessage.obj;
    if (paramMessage != null)
    {
      a locala = this.a.f;
      if (locala != null) {
        locala.a(paramMessage);
      }
    }
    else
    {
      paramMessage = this.a.f;
      if (paramMessage != null) {
        paramMessage.a(new b("Sorry,Capture is failed."));
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */