package com.amap.api.maps;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.ha;
import com.amap.api.mapcore.util.hi;
import com.amap.api.mapcore.util.lq;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

@TargetApi(20)
public class WearMapView
  extends ViewGroup
{
  private static int f;
  private static int g;
  private final String a = WearMapView.class.getSimpleName();
  private IMapFragmentDelegate b;
  private AMap c;
  private View d;
  private SwipeDismissView e;
  private int h = 0;
  
  public WearMapView(Context paramContext)
  {
    super(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
    a(paramContext);
    b(paramContext);
    c(paramContext);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.h = paramAttributeSet.getAttributeIntValue(16842972, 0);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setVisibility(this.h);
    b(paramContext);
    c(paramContext);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.h = paramAttributeSet.getAttributeIntValue(16842972, 0);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setVisibility(this.h);
    b(paramContext);
    c(paramContext);
  }
  
  public WearMapView(Context paramContext, AMapOptions paramAMapOptions)
  {
    super(paramContext);
    a(paramContext);
    getMapFragmentDelegate().setContext(paramContext);
    getMapFragmentDelegate().setOptions(paramAMapOptions);
    b(paramContext);
    c(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null) {
      hi.a(dx.e()).c(paramContext.getApplicationContext());
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
    }
    int i = localLayoutParams1.width;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    int j = localLayoutParams1.height;
    if (j > 0) {
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    } else {
      j = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i, j);
  }
  
  private void b(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      Point localPoint = new Point();
      if (paramContext != null) {
        paramContext.getSize(localPoint);
      }
      f = localPoint.x;
      g = localPoint.y;
    }
  }
  
  private void c(Context paramContext)
  {
    this.e = new SwipeDismissView(paramContext, this);
    paramContext = new ViewGroup.LayoutParams((int)(paramContext.getResources().getDisplayMetrics().density * 30.0F + 0.5F), g);
    this.e.setBackgroundColor(Color.argb(0, 0, 0, 0));
    setBackgroundColor(Color.argb(0, 0, 0, 0));
    addView(this.e, paramContext);
  }
  
  public AMap getMap()
  {
    Object localObject = getMapFragmentDelegate();
    try
    {
      localObject = ((IMapFragmentDelegate)localObject).getMap();
      if (localObject == null) {
        return null;
      }
      if (this.c == null) {
        this.c = new AMap((IAMap)localObject);
      }
      return this.c;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  protected IMapFragmentDelegate getMapFragmentDelegate()
  {
    if (this.b == null) {}
    try
    {
      this.b = ((IMapFragmentDelegate)hi.a(dx.e()).a(getContext(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) }));
      if (this.b == null) {
        this.b = ((IMapFragmentDelegate)ha.a(getContext(), dx.e(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", lq.class, new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) }));
      }
      if (this.b == null) {
        this.b = new lq(1);
      }
      return this.b;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    try
    {
      this.d = getMapFragmentDelegate().onCreateView(null, null, paramBundle);
      paramBundle = new ViewGroup.LayoutParams(-1, -1);
      addView(this.d, 0, paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public final void onDestroy()
  {
    try
    {
      getMapFragmentDelegate().onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onDismiss()
  {
    removeAllViews();
  }
  
  public void onEnterAmbient(Bundle paramBundle)
  {
    onResume();
  }
  
  public void onExitAmbient()
  {
    onPause();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView == this.d)
      {
        localView.layout(0, 0, getWidth(), getHeight());
      }
      else if (localView == this.e)
      {
        a(this.e);
        paramInt4 = this.e.getMeasuredWidth();
        this.e.layout(0, 0, paramInt4, paramInt3);
      }
      paramInt1 += 1;
    }
  }
  
  public final void onLowMemory()
  {
    try
    {
      getMapFragmentDelegate().onLowMemory();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof SwipeDismissView))
      {
        SwipeDismissView localSwipeDismissView = (SwipeDismissView)localView;
        localView.measure(localSwipeDismissView.getLayoutParams().width, localSwipeDismissView.getLayoutParams().height);
      }
      else
      {
        localView.measure(paramInt1, paramInt2);
      }
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void onPause()
  {
    try
    {
      getMapFragmentDelegate().onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void onResume()
  {
    try
    {
      getMapFragmentDelegate().onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      getMapFragmentDelegate().onSaveInstanceState(paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setOnDismissCallbackListener(OnDismissCallback paramOnDismissCallback)
  {
    if (this.e != null) {
      this.e.setCallback(paramOnDismissCallback);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    getMapFragmentDelegate().setVisibility(paramInt);
  }
  
  public static abstract interface OnDismissCallback
  {
    public abstract void onDismiss();
    
    public abstract void onNotifySwipe();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\WearMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */