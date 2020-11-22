package com.pgyersdk.feedback;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import com.pgyersdk.f.b;

class a
  extends Shape
{
  a(d paramd, Paint paramPaint, Context paramContext, int paramInt) {}
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    this.a.setAntiAlias(true);
    int i = b.a(this.b, 1.0F);
    float f1 = i;
    float f2 = this.c - i;
    paramCanvas.drawArc(new RectF(f1, f1, f2, f2), 0.0F, 360.0F, true, this.a);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */