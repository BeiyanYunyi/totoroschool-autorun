package com.pgyersdk.feedback.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.pgyersdk.d.a;

public class n
  extends View
{
  private Context a;
  private int b = 0;
  private int c = 10;
  private String d;
  
  public n(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.d = a.b(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject2 = new Paint();
    ((Paint)localObject2).setColor(Color.parseColor("#5f000000"));
    Object localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Paint)localObject1).setStyle(Paint.Style.STROKE);
    ((Paint)localObject1).setStrokeWidth(2.0F);
    ((Paint)localObject1).setAntiAlias(true);
    int i = com.pgyersdk.f.b.a(this.a, 15.0F);
    int j = com.pgyersdk.f.b.a(this.a, 18.0F);
    int k = com.pgyersdk.f.b.a(this.a, 13.0F);
    Object localObject3 = this.a;
    float f1 = j;
    float f2 = -com.pgyersdk.f.b.a((Context)localObject3, f1);
    float f3 = i;
    new RectF(f2, f3, getHeight() - i * 2 - j, getHeight() - i);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), com.pgyersdk.f.b.a(this.a, 10.0F), com.pgyersdk.f.b.a(this.a, 10.0F), (Paint)localObject2);
    if (this.b != -1)
    {
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStyle(Paint.Style.FILL_AND_STROKE);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      ((Paint)localObject2).setAntiAlias(true);
      paramCanvas.drawRoundRect(new RectF(f1, f3, com.pgyersdk.f.b.a(this.a, 10.0F) + j, com.pgyersdk.f.b.a(this.a, 24.0F) + i), com.pgyersdk.f.b.a(this.a, 5.0F), com.pgyersdk.f.b.a(this.a, 5.0F), (Paint)localObject2);
      paramCanvas.drawArc(new RectF(k, com.pgyersdk.f.b.a(this.a, 25.0F), k + com.pgyersdk.f.b.a(this.a, 20.0F), com.pgyersdk.f.b.a(this.a, 45.0F)), 0.0F, 180.0F, false, (Paint)localObject1);
      paramCanvas.drawLine(com.pgyersdk.f.b.a(this.a, 23.0F), com.pgyersdk.f.b.a(this.a, 45.0F), com.pgyersdk.f.b.a(this.a, 23.0F), com.pgyersdk.f.b.a(this.a, 53.0F), (Paint)localObject1);
      paramCanvas.drawLine(com.pgyersdk.f.b.a(this.a, 18.0F), com.pgyersdk.f.b.a(this.a, 53.0F), com.pgyersdk.f.b.a(this.a, 28.0F), com.pgyersdk.f.b.a(this.a, 53.0F), (Paint)localObject1);
      k = com.pgyersdk.f.b.a(this.a, 6.0F);
      i = com.pgyersdk.f.b.a(this.a, 2.5F);
      j = com.pgyersdk.f.b.a(this.a, 5.0F);
      if (this.b >= 1) {
        paramCanvas.drawLine(com.pgyersdk.f.b.a(this.a, 35.0F) + j, com.pgyersdk.f.b.a(this.a, 53.0F), com.pgyersdk.f.b.a(this.a, 40.0F) + j, com.pgyersdk.f.b.a(this.a, 53.0F), (Paint)localObject1);
      }
      if (this.b >= 2) {
        paramCanvas.drawLine(com.pgyersdk.f.b.a(this.a, 35.0F) + j, com.pgyersdk.f.b.a(this.a, 53.0F) - k, com.pgyersdk.f.b.a(this.a, 40.0F) + j + i, com.pgyersdk.f.b.a(this.a, 53.0F) - k, (Paint)localObject1);
      }
      int m;
      int n;
      if (this.b >= 3)
      {
        f1 = com.pgyersdk.f.b.a(this.a, 35.0F) + j;
        m = com.pgyersdk.f.b.a(this.a, 53.0F);
        n = k * 2;
        paramCanvas.drawLine(f1, m - n, com.pgyersdk.f.b.a(this.a, 40.0F) + j + i * 2, com.pgyersdk.f.b.a(this.a, 53.0F) - n, (Paint)localObject1);
      }
      if (this.b >= 4)
      {
        f1 = com.pgyersdk.f.b.a(this.a, 35.0F) + j;
        m = com.pgyersdk.f.b.a(this.a, 53.0F);
        n = k * 3;
        paramCanvas.drawLine(f1, m - n, com.pgyersdk.f.b.a(this.a, 40.0F) + j + i * 3, com.pgyersdk.f.b.a(this.a, 53.0F) - n, (Paint)localObject1);
      }
      if (this.b >= 5)
      {
        f1 = com.pgyersdk.f.b.a(this.a, 35.0F) + j;
        m = com.pgyersdk.f.b.a(this.a, 53.0F);
        n = k * 4;
        paramCanvas.drawLine(f1, m - n, com.pgyersdk.f.b.a(this.a, 40.0F) + j + i * 4, com.pgyersdk.f.b.a(this.a, 53.0F) - n, (Paint)localObject1);
      }
      if (this.b >= 6)
      {
        f1 = com.pgyersdk.f.b.a(this.a, 35.0F) + j;
        m = com.pgyersdk.f.b.a(this.a, 53.0F);
        n = k * 5;
        paramCanvas.drawLine(f1, m - n, com.pgyersdk.f.b.a(this.a, 40.0F) + j + i * 5, com.pgyersdk.f.b.a(this.a, 53.0F) - n, (Paint)localObject1);
      }
      if (this.b >= 7)
      {
        f1 = com.pgyersdk.f.b.a(this.a, 35.0F) + j;
        m = com.pgyersdk.f.b.a(this.a, 53.0F);
        k *= 6;
        paramCanvas.drawLine(f1, m - k, j + com.pgyersdk.f.b.a(this.a, 40.0F) + i * 6, com.pgyersdk.f.b.a(this.a, 53.0F) - k, (Paint)localObject1);
      }
    }
    else
    {
      localObject2 = new Paint();
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setTextSize(80.0F);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.c <= 0)
      {
        this.c = 0;
        localObject1 = "0";
      }
      f1 = ((Paint)localObject2).measureText((String)localObject1);
      localObject3 = ((Paint)localObject2).getFontMetrics();
      f3 = ((Paint.FontMetrics)localObject3).bottom;
      f4 = ((Paint.FontMetrics)localObject3).top;
      f2 = getHeight();
      f3 = (getHeight() - (f3 - f4)) / 2.0F;
      f4 = ((Paint.FontMetrics)localObject3).bottom;
      f5 = com.pgyersdk.f.b.a(this.a, 5.0F);
      paramCanvas.drawText((String)localObject1, (getWidth() - f1) / 2.0F, f2 - f3 - f4 - f5, (Paint)localObject2);
    }
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    if ("mdpi".equals(this.d)) {
      ((Paint)localObject1).setTextSize(13.0F);
    } else if ("hdpi".equals(this.d)) {
      ((Paint)localObject1).setTextSize(14.0F);
    } else {
      ((Paint)localObject1).setTextSize(17.0F);
    }
    localObject2 = com.pgyersdk.c.b.a(1076);
    f1 = ((Paint)localObject1).measureText((String)localObject2);
    localObject3 = ((Paint)localObject1).getFontMetrics();
    f2 = ((Paint.FontMetrics)localObject3).bottom;
    f3 = ((Paint.FontMetrics)localObject3).top;
    float f4 = getHeight();
    float f5 = com.pgyersdk.f.b.a(this.a, 2.0F);
    paramCanvas.drawText((String)localObject2, (getWidth() - f1) / 2.0F, f4 - (f2 - f3) + f5, (Paint)localObject1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */