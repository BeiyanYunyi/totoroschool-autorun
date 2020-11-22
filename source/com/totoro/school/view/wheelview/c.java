package com.totoro.school.view.wheelview;

import android.os.Handler;
import android.os.Message;

final class c
  extends Handler
{
  final WheelView a;
  
  c(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i != 2000)
      {
        if (i != 3000) {
          return;
        }
        this.a.c();
        return;
      }
      this.a.a(WheelView.a.FLING);
      return;
    }
    this.a.invalidate();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */