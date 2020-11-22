package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ExpandableListView;
import android.widget.LinearLayout.LayoutParams;

public class DownLoadExpandListView
  extends ExpandableListView
{
  public DownLoadExpandListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DownLoadExpandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\DownLoadExpandListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */