package com.totoro.school.view.wheelview;

import android.os.Handler;
import java.util.List;
import java.util.TimerTask;

final class b
  extends TimerTask
{
  float a;
  final float b;
  final WheelView c;
  
  b(WheelView paramWheelView, float paramFloat)
  {
    this.c = paramWheelView;
    this.b = paramFloat;
    this.a = 2.14748365E9F;
  }
  
  public final void run()
  {
    if (this.a == 2.14748365E9F) {
      if (Math.abs(this.b) > 2000.0F)
      {
        if (this.b > 0.0F) {
          this.a = 2000.0F;
        } else {
          this.a = -2000.0F;
        }
      }
      else {
        this.a = this.b;
      }
    }
    if ((Math.abs(this.a) >= 0.0F) && (Math.abs(this.a) <= 20.0F))
    {
      this.c.b();
      this.c.e.sendEmptyMessage(2000);
      return;
    }
    int i = (int)(this.a * 10.0F / 1000.0F);
    WheelView localWheelView = this.c;
    localWheelView.y -= i;
    if (!this.c.r)
    {
      float f = this.c.b;
      if (this.c.y <= (int)(-this.c.z * f))
      {
        this.a = 40.0F;
        this.c.y = ((int)(-this.c.z * f));
      }
      else if (this.c.y >= (int)((this.c.k.size() - 1 - this.c.z) * f))
      {
        this.c.y = ((int)((this.c.k.size() - 1 - this.c.z) * f));
        this.a = -40.0F;
      }
    }
    if (this.a < 0.0F) {
      this.a += 20.0F;
    } else {
      this.a -= 20.0F;
    }
    this.c.e.sendEmptyMessage(1000);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */