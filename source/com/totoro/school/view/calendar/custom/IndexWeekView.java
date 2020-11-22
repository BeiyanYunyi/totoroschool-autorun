package com.totoro.school.view.calendar.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import com.totoro.school.view.calendar.base.WeekView;
import com.totoro.school.view.calendar.base.b;

public class IndexWeekView
  extends WeekView
{
  private Paint a = new Paint();
  private int b;
  private int c;
  private int d;
  
  public IndexWeekView(Context paramContext)
  {
    super(paramContext);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setTextAlign(Paint.Align.CENTER);
    this.a.setColor(-13421773);
    this.a.setFakeBoldText(true);
    this.b = a(getContext(), 4.0F);
    this.c = a(getContext(), 2.0F);
    this.d = a(getContext(), 8.0F);
  }
  
  private static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt)
  {
    this.a.setColor(paramb.getSchemeColor());
    paramCanvas.drawRect(this.w / 2 + paramInt - this.d / 2, this.v - this.c * 2 - this.b, paramInt + this.w / 2 + this.d / 2, this.v - this.c - this.b, this.a);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt += this.w / 2;
    int i = -this.v / 6;
    if (paramBoolean1)
    {
      j = paramb.getDay();
      f1 = paramInt;
      f2 = this.x;
      f3 = i;
      if (paramb.isCurrentDay()) {
        localObject = this.r;
      } else if (paramb.isCurrentMonth()) {
        localObject = this.p;
      } else {
        localObject = this.h;
      }
      paramCanvas.drawText(String.valueOf(j), f1, f2 + f3, (Paint)localObject);
      localObject = paramb.getLunar();
      f2 = this.x;
      f3 = this.v / 10;
      if (paramb.isCurrentDay()) {
        paramb = this.s;
      } else {
        paramb = this.j;
      }
      paramCanvas.drawText((String)localObject, f1, f2 + f3, paramb);
      return;
    }
    int j = paramb.getDay();
    float f1 = paramInt;
    float f2 = this.x;
    float f3 = i;
    if (paramb.isCurrentDay())
    {
      localObject = this.r;
    }
    else
    {
      paramb.isCurrentMonth();
      localObject = this.h;
    }
    paramCanvas.drawText(String.valueOf(j), f1, f2 + f3, (Paint)localObject);
    Object localObject = paramb.getLunar();
    f2 = this.x;
    f3 = this.v / 10;
    if (paramb.isCurrentDay()) {
      paramb = this.s;
    } else {
      paramb = this.j;
    }
    paramCanvas.drawText((String)localObject, f1, f2 + f3, paramb);
  }
  
  protected boolean a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean)
  {
    this.o.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.b + paramInt, this.b, paramInt + this.w - this.b, this.v - this.b, this.o);
    return true;
  }
  
  protected void d() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\custom\IndexWeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */