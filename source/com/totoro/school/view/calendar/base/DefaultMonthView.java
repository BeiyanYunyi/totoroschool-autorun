package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;

public final class DefaultMonthView
  extends MonthView
{
  private Paint C = new Paint();
  private Paint D = new Paint();
  private float E;
  private int F;
  private float G;
  
  public DefaultMonthView(Context paramContext)
  {
    super(paramContext);
    this.C.setTextSize(c.a(paramContext, 8.0F));
    this.C.setColor(-1);
    this.C.setAntiAlias(true);
    this.C.setFakeBoldText(true);
    this.D.setAntiAlias(true);
    this.D.setStyle(Paint.Style.FILL);
    this.D.setTextAlign(Paint.Align.CENTER);
    this.D.setColor(-1223853);
    this.D.setFakeBoldText(true);
    this.E = c.a(getContext(), 7.0F);
    this.F = c.a(getContext(), 4.0F);
    paramContext = this.D.getFontMetrics();
    this.G = (this.E - paramContext.descent + (paramContext.bottom - paramContext.top) / 2.0F + c.a(getContext(), 1.0F));
  }
  
  private float a(String paramString)
  {
    return this.C.measureText(paramString);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2)
  {
    this.D.setColor(paramb.getSchemeColor());
    paramCanvas.drawCircle(this.w + paramInt1 - this.F - this.E / 2.0F, this.F + paramInt2 + this.E, this.E, this.D);
    paramCanvas.drawText(paramb.getScheme(), paramInt1 + this.w - this.F - this.E / 2.0F - a(paramb.getScheme()) / 2.0F, paramInt2 + this.F + this.G, this.C);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 += this.w / 2;
    int i = paramInt2 - this.v / 6;
    if (paramBoolean2)
    {
      j = paramb.getDay();
      f1 = paramInt1;
      paramCanvas.drawText(String.valueOf(j), f1, this.x + i, this.q);
      paramCanvas.drawText(paramb.getLunar(), f1, this.x + paramInt2 + this.v / 10, this.k);
      return;
    }
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
      f4 = this.v / 10;
      if (paramb.isCurrentDay()) {
        paramb = this.s;
      } else {
        paramb = this.m;
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
    Object localObject = paramb.getLunar();
    f2 = this.x;
    f3 = paramInt2;
    float f4 = this.v / 10;
    if (paramb.isCurrentDay()) {
      paramb = this.s;
    } else if (paramb.isCurrentMonth()) {
      paramb = this.j;
    } else {
      paramb = this.l;
    }
    paramCanvas.drawText((String)localObject, f1, f2 + f3 + f4, paramb);
  }
  
  protected boolean a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.o.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.F + paramInt1, this.F + paramInt2, paramInt1 + this.w - this.F, paramInt2 + this.v - this.F, this.o);
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\DefaultMonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */