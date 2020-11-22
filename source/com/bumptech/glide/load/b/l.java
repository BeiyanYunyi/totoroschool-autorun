package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.h.h;

class l
{
  private boolean a;
  private final Handler b = new Handler(Looper.getMainLooper(), new a(null));
  
  public void a(k<?> paramk)
  {
    
    if (this.a)
    {
      this.b.obtainMessage(1, paramk).sendToTarget();
      return;
    }
    this.a = true;
    paramk.d();
    this.a = false;
  }
  
  private static class a
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        ((k)paramMessage.obj).d();
        return true;
      }
      return false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */