package com.totoro.school.view.calendar.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import com.totoro.school.view.calendar.base.MonthView;
import com.totoro.school.view.calendar.base.b;

public class IndexMonthView
  extends MonthView
{
  private Paint C = new Paint();
  private int D;
  private int E;
  private int F;
  
  public IndexMonthView(Context paramContext)
  {
    super(paramContext);
    this.C.setAntiAlias(true);
    this.C.setStyle(Paint.Style.FILL);
    this.C.setTextAlign(Paint.Align.CENTER);
    this.C.setColor(-13421773);
    this.C.setFakeBoldText(true);
    this.D = a(getContext(), 4.0F);
    this.E = a(getContext(), 2.0F);
    this.F = a(getContext(), 8.0F);
  }
  
  private static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2)
  {
    this.C.setColor(paramb.getSchemeColor());
    paramCanvas.drawRect(this.w / 2 + paramInt1 - this.F / 2, this.v + paramInt2 - this.E * 2 - this.D, paramInt1 + this.w / 2 + this.F / 2, paramInt2 + this.v - this.E - this.D, this.C);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 += this.w / 2;
    int i = paramInt2 - this.v / 6;
    Object localObject;
    if (paramBoolean1)
    {
      j = paramb.getDay();
      f1 = paramInt1;
      f2 = this.x;
      f3 = i;
      if (paramb.isCurrentDay()) {
        localObject = this.r;
      } else if (paramb.isCurrentMonth()) {
        localObject = this.p;
      } else {
        localObject = this.i;
      }
      paramCanvas.drawText(String.valueOf(j), f1, f2 + f3, (Paint)localObject);
      localObject = paramb.getLunar();
      f2 = this.x;
      f3 = paramInt2;
      float f4 = this.v / 10;
      if (paramb.isCurrentDay()) {
        paramb = this.s;
      } else {
        paramb = this.j;
      }
      paramCanvas.drawText((String)localObject, f1, f2 + f3 + f4, paramb);
      return;
    }
    int j = paramb.getDay();
    float f1 = paramInt1;
    float f2 = this.x;
    float f3 = i;
    if (paramb.isCurrentDay()) {
      localObject = this.r;
    } else if (paramb.isCurrentMonth()) {
      localObject = this.h;
    } else {
      localObject = this.i;
    }
    paramCanvas.drawText(String.valueOf(j), f1, f2 + f3, (Paint)localObject);
    paramCanvas.drawText(paramb.getLunar(), f1, this.x + paramInt2 + this.v / 10, this.j);
  }
  
  protected boolean a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.o.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.D + paramInt1, this.D + paramInt2, paramInt1 + this.w - this.D, paramInt2 + this.v - this.D, this.o);
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\custom\IndexMonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */