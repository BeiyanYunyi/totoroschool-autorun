package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeekBar
  extends LinearLayout
{
  private d a;
  
  public WeekBar(Context paramContext)
  {
    super(paramContext);
    if ("com.totoro.school.view.calendar.base.WeekBar".equals(getClass().getName())) {
      LayoutInflater.from(paramContext).inflate(2131492924, this, true);
    }
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = getContext().getResources().getStringArray(2130903049);
    if (paramInt2 == 1) {
      return arrayOfString[paramInt1];
    }
    int i = 6;
    if (paramInt2 == 2)
    {
      if (paramInt1 == 6) {
        paramInt1 = 0;
      } else {
        paramInt1 += 1;
      }
      return arrayOfString[paramInt1];
    }
    if (paramInt1 == 0) {
      paramInt1 = i;
    } else {
      paramInt1 -= 1;
    }
    return arrayOfString[paramInt1];
  }
  
  protected void a(int paramInt)
  {
    if (!"com.totoro.school.view.calendar.base.WeekBar".equalsIgnoreCase(getClass().getName())) {
      return;
    }
    int i = 0;
    while (i < getChildCount())
    {
      ((TextView)getChildAt(i)).setText(a(i, paramInt));
      i += 1;
    }
  }
  
  protected void a(b paramb, int paramInt, boolean paramBoolean) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.a.x(), 1073741824);
    } else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(c.a(getContext(), 40.0F), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void setTextColor(int paramInt)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((TextView)getChildAt(i)).setTextColor(paramInt);
      i += 1;
    }
  }
  
  protected void setTextSize(int paramInt)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((TextView)getChildAt(i)).setTextSize(0, paramInt);
      i += 1;
    }
  }
  
  void setup(d paramd)
  {
    this.a = paramd;
    if ("com.totoro.school.view.calendar.base.WeekBar".equalsIgnoreCase(getClass().getName()))
    {
      setTextSize(this.a.Z());
      setTextColor(paramd.d());
      setBackgroundColor(paramd.o());
      setPadding(paramd.af(), 0, paramd.af(), 0);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\WeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */