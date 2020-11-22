package com.amap.api.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

@SuppressLint({"ViewConstructor"})
public class SwipeDismissView
  extends RelativeLayout
{
  protected WearMapView.OnDismissCallback onDismissCallback = null;
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, View paramView)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener(paramView);
  }
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, View paramView)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener(paramView);
  }
  
  public SwipeDismissView(Context paramContext, View paramView)
  {
    super(paramContext);
    setOnTouchListener(paramView);
  }
  
  public void setCallback(WearMapView.OnDismissCallback paramOnDismissCallback)
  {
    this.onDismissCallback = paramOnDismissCallback;
  }
  
  protected void setOnTouchListener(View paramView)
  {
    setOnTouchListener(new SwipeDismissTouchListener(paramView, new Object(), new SwipeDismissCallBack(this)));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\SwipeDismissView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */