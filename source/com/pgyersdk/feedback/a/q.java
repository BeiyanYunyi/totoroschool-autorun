package com.pgyersdk.feedback.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.Shape;
import android.widget.Button;
import com.pgyersdk.f.b;

public class q
  extends Button
{
  private String a = "#f2f2f2";
  private String b = "#e0e0e0";
  private Context c;
  private ShapeDrawable d;
  private ShapeDrawable e;
  private Shape f;
  private Shape g;
  
  public q(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    setPadding(b.a(paramContext, 20.0F), 0, 0, 0);
    setBackground(3);
    setTextSize(16.0F);
    setPadding(0, 0, b.a(paramContext, 10.0F), 0);
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919, 16842910 }, paramDrawable2);
    paramContext.addState(new int[] { 16842910, 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842910 }, paramDrawable1);
    paramContext.addState(new int[] { 16842908 }, paramDrawable3);
    paramContext.addState(new int[] { 16842909 }, paramDrawable4);
    paramContext.addState(new int[0], paramDrawable1);
    return paramContext;
  }
  
  private void a(Context paramContext, Canvas paramCanvas, String paramString, int paramInt)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    localPath.moveTo(0.0F, getHeight() / 2);
    localPath.lineTo(b.a(paramContext, 10.0F), getHeight() / 2 - b.a(paramContext, 4.0F));
    localPath.lineTo(b.a(paramContext, 10.0F), getHeight() / 2 + b.a(paramContext, 4.0F));
    localPath.lineTo(0.0F, getHeight() / 2);
    localPath.close();
    localPaint.setColor(Color.parseColor(paramString));
    paramCanvas.drawPath(localPath, localPaint);
    paramCanvas.drawRoundRect(new RectF(b.a(paramContext, 10.0F), 0.0F, getWidth(), getHeight()), b.a(paramContext, 5.0F), b.a(paramContext, 5.0F), localPaint);
    paramString = new Paint();
    paramString.setAntiAlias(true);
    paramString.setStyle(Paint.Style.STROKE);
    paramString.setStrokeWidth(2.0F);
    paramString.setColor(-7829368);
    int i = b.a(paramContext, 5.0F);
    if (paramInt >= 1) {
      paramCanvas.drawArc(new RectF(b.a(paramContext, 8.0F), b.a(paramContext, 8.0F) + i, getHeight() - i * 2 - b.a(paramContext, 8.0F), getHeight() - i - b.a(paramContext, 8.0F)), -30.0F, 60.0F, false, paramString);
    }
    if (paramInt >= 2) {
      paramCanvas.drawArc(new RectF(b.a(paramContext, 4.0F), b.a(paramContext, 4.0F) + i, getHeight() - i * 2 - b.a(paramContext, 4.0F), getHeight() - i - b.a(paramContext, 4.0F)), -30.0F, 60.0F, false, paramString);
    }
    if (paramInt >= 3) {
      paramCanvas.drawArc(new RectF(0.0F, i, getHeight() - i * 2, getHeight() - i), -30.0F, 60.0F, false, paramString);
    }
  }
  
  private void setBackground(int paramInt)
  {
    this.f = new o(this, paramInt);
    this.d = new ShapeDrawable(this.f);
    this.d.getPaint().setColor(Color.parseColor(this.a));
    this.d.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    this.g = new p(this, paramInt);
    this.e = new ShapeDrawable(this.g);
    this.e.getPaint().setColor(Color.parseColor(this.b));
    this.e.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    Context localContext = this.c;
    ShapeDrawable localShapeDrawable1 = this.d;
    ShapeDrawable localShapeDrawable2 = this.e;
    setBackgroundDrawable(a(localContext, localShapeDrawable1, localShapeDrawable2, localShapeDrawable2, localShapeDrawable1));
  }
  
  public void a(int paramInt)
  {
    setBackground(paramInt);
    postInvalidate();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */