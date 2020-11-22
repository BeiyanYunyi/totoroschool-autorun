package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;

public class DefaultYearView
  extends YearView
{
  private int z;
  
  public DefaultYearView(Context paramContext)
  {
    super(paramContext);
    this.z = c.a(paramContext, 3.0F);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramCanvas.drawText(getContext().getResources().getStringArray(2130903050)[paramInt1], paramInt2 + paramInt4 / 2, paramInt3 + this.u, this.o);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramCanvas.drawText(getContext().getResources().getStringArray(2130903043)[(paramInt2 - 1)], paramInt3 + this.r / 2 - this.z, paramInt4 + this.t, this.n);
  }
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2) {}
  
  protected void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = this.s + paramInt2;
    paramInt1 += this.r / 2;
    if (paramBoolean2)
    {
      paramInt2 = paramb.getDay();
      f2 = paramInt1;
      if (paramBoolean1) {
        paramb = this.j;
      } else {
        paramb = this.k;
      }
      paramCanvas.drawText(String.valueOf(paramInt2), f2, f1, paramb);
      return;
    }
    if (paramBoolean1)
    {
      paramInt2 = paramb.getDay();
      f2 = paramInt1;
      if (paramb.isCurrentDay()) {
        paramb = this.l;
      } else if (paramb.isCurrentMonth()) {
        paramb = this.j;
      } else {
        paramb = this.c;
      }
      paramCanvas.drawText(String.valueOf(paramInt2), f2, f1, paramb);
      return;
    }
    paramInt2 = paramb.getDay();
    float f2 = paramInt1;
    if (paramb.isCurrentDay()) {
      paramb = this.l;
    } else if (paramb.isCurrentMonth()) {
      paramb = this.b;
    } else {
      paramb = this.c;
    }
    paramCanvas.drawText(String.valueOf(paramInt2), f2, f1, paramb);
  }
  
  protected boolean a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\DefaultYearView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */