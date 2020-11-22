package com.totoro.school.view.wheelview;

import android.os.Handler;
import java.util.TimerTask;

final class e
  extends TimerTask
{
  int a;
  int b;
  int c;
  final WheelView d;
  
  e(WheelView paramWheelView, int paramInt)
  {
    this.d = paramWheelView;
    this.c = paramInt;
    this.a = Integer.MAX_VALUE;
    this.b = 0;
  }
  
  public final void run()
  {
    if (this.a == Integer.MAX_VALUE) {
      this.a = this.c;
    }
    this.b = ((int)(this.a * 0.1F));
    if (this.b == 0) {
      if (this.a < 0) {
        this.b = -1;
      } else {
        this.b = 1;
      }
    }
    if (Math.abs(this.a) <= 0)
    {
      this.d.b();
      this.d.e.sendEmptyMessage(3000);
      return;
    }
    this.d.y += this.b;
    this.d.e.sendEmptyMessage(1000);
    this.a -= this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */