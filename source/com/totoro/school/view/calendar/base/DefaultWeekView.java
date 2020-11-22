package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;

public final class DefaultWeekView
  extends WeekView
{
  private Paint a = new Paint();
  private Paint b = new Paint();
  private float c;
  private int d;
  private float e;
  
  public DefaultWeekView(Context paramContext)
  {
    super(paramContext);
    this.a.setTextSize(c.a(paramContext, 8.0F));
    this.a.setColor(-1);
    this.a.setAntiAlias(true);
    this.a.setFakeBoldText(true);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setColor(-1223853);
    this.b.setFakeBoldText(true);
    this.c = c.a(getContext(), 7.0F);
    this.d = c.a(getContext(), 4.0F);
    paramContext = this.b.getFontMetrics();
    this.e = (this.c - paramContext.descent + (paramContext.bottom - paramContext.top) / 2.0F + c.a(getContext(), 1.0F));
  }
  
  private float a(String paramString)
  {
    return this.a.measureText(paramString);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt)
  {
    this.b.setColor(paramb.getSchemeColor());
    paramCanvas.drawCircle(this.w + paramInt - this.d - this.c / 2.0F, this.d + this.c, this.c, this.b);
    paramCanvas.drawText(paramb.getScheme(), paramInt + this.w - this.d - this.c / 2.0F - a(paramb.getScheme()) / 2.0F, this.d + this.e, this.a);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt += this.w / 2;
    int i = -this.v / 6;
    if (paramBoolean2)
    {
      j = paramb.getDay();
      f1 = paramInt;
      paramCanvas.drawText(String.valueOf(j), f1, this.x + i, this.q);
      paramCanvas.drawText(paramb.getLunar(), f1, this.x + this.v / 10, this.k);
      return;
    }
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
        localObject = this.i;
      }
      paramCanvas.drawText(String.valueOf(j), f1, f2 + f3, (Paint)localObject);
      localObject = paramb.getLunar();
      f2 = this.x;
      f3 = this.v / 10;
      if (paramb.isCurrentDay()) {
        paramb = this.s;
      } else {
        paramb = this.m;
      }
      paramCanvas.drawText((String)localObject, f1, f2 + f3, paramb);
      return;
    }
    int j = paramb.getDay();
    float f1 = paramInt;
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
    Object localObject = paramb.getLunar();
    f2 = this.x;
    f3 = this.v / 10;
    if (paramb.isCurrentDay()) {
      paramb = this.s;
    } else if (paramb.isCurrentMonth()) {
      paramb = this.j;
    } else {
      paramb = this.l;
    }
    paramCanvas.drawText((String)localObject, f1, f2 + f3, paramb);
  }
  
  protected boolean a(Canvas paramCanvas, b paramb, int paramInt, boolean paramBoolean)
  {
    this.o.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.d + paramInt, this.d, paramInt + this.w - this.d, this.v - this.d, this.o);
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\DefaultWeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */