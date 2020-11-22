package com.totoro.school.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class MyViewPager
  extends ViewPager
{
  public MyViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    int j;
    for (int i = 0; paramInt2 < getChildCount(); i = j)
    {
      View localView = getChildAt(paramInt2);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = localView.getMeasuredHeight();
      j = i;
      if (k > i) {
        j = k;
      }
      paramInt2 += 1;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\MyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */