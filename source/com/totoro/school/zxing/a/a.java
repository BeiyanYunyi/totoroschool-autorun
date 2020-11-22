package com.totoro.school.zxing.a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.util.Log;

final class a
  implements Camera.AutoFocusCallback
{
  private static final String a = "a";
  private Handler b;
  private int c;
  
  void a(Handler paramHandler, int paramInt)
  {
    this.b = paramHandler;
    this.c = paramInt;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (this.b != null)
    {
      paramCamera = this.b.obtainMessage(this.c, Boolean.valueOf(paramBoolean));
      this.b.sendMessageDelayed(paramCamera, 1500L);
      this.b = null;
      return;
    }
    Log.d(a, "Got auto-focus callback, but no handler for it");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */