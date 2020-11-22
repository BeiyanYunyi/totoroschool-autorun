package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class h
  extends Thread
{
  h(Context paramContext, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    bt localbt = bt.a();
    localbt.a(this.a);
    boolean bool;
    if (localbt.b()) {
      bool = localbt.c().a(this.a, this.b);
    } else {
      bool = false;
    }
    new Handler(Looper.getMainLooper()).post(new i(this, bool));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */