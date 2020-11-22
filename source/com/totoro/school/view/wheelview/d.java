package com.totoro.school.view.wheelview;

final class d
  implements Runnable
{
  final WheelView a;
  public int b = -1;
  
  d(WheelView paramWheelView)
  {
    this.a = paramWheelView;
  }
  
  public final void run()
  {
    if (this.a.getSelectedPosition() < 0) {
      return;
    }
    if (this.a.getSelectedPosition() == this.b) {
      return;
    }
    this.b = this.a.getSelectedPosition();
    this.a.f.a(this.a.getSelectedPosition(), this.a.getSelectedItem());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */