package com.pgyersdk.b.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.pgyersdk.b.a.c;

final class f
  implements Runnable
{
  f(Activity paramActivity, View[] paramArrayOfView, Handler paramHandler) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = e.a(this.a, this.b);
      if (localBitmap != null)
      {
        Message localMessage = new Message();
        localMessage.obj = localBitmap;
        localMessage.what = 0;
        this.c.sendMessage(localMessage);
        return;
      }
      throw new c();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
      com.pgyersdk.f.f.b("PgyerSDK", "Get screen shot failed");
      return;
    }
    catch (c localc)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */