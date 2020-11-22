package com.amap.api.maps;

import android.view.View;

public class SwipeDismissCallBack
  implements SwipeDismissTouchListener.DismissCallbacks
{
  SwipeDismissView a;
  
  public SwipeDismissCallBack(SwipeDismissView paramSwipeDismissView)
  {
    this.a = paramSwipeDismissView;
  }
  
  public boolean canDismiss(Object paramObject)
  {
    return true;
  }
  
  public void onDismiss(View paramView, Object paramObject)
  {
    if (this.a.onDismissCallback != null) {
      this.a.onDismissCallback.onDismiss();
    }
  }
  
  public void onNotifySwipe()
  {
    if (this.a.onDismissCallback != null) {
      this.a.onDismissCallback.onNotifySwipe();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\SwipeDismissCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */