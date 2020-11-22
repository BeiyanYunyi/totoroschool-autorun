package com.pgyersdk.feedback.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.pgyersdk.f.b;

public class e
  extends LinearLayout
{
  private Context a;
  private Paint b;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = new Paint();
    setBottomBarColor(paramInt);
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramDrawable2);
    localStateListDrawable.addState(new int[] { 16842910, 16842908 }, paramDrawable3);
    localStateListDrawable.addState(new int[] { 16842910 }, paramDrawable1);
    localStateListDrawable.addState(new int[] { 16842908 }, paramDrawable3);
    localStateListDrawable.addState(new int[] { 16842909 }, paramDrawable4);
    localStateListDrawable.addState(new int[0], paramDrawable1);
    return localStateListDrawable;
  }
  
  private void a(Context paramContext, Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(getWidth(), 0.0F);
    localPath.lineTo(getWidth(), getHeight() - b.a(this.a, 5.0F));
    localPath.lineTo(0.0F, getHeight() - b.a(this.a, 5.0F));
    paramCanvas.drawPath(localPath, this.b);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels / 6 - b.a(paramContext, 10.0F);
    paramContext = new Path();
    float f = i;
    paramContext.moveTo(f, getHeight() - b.a(this.a, 5.0F));
    paramContext.lineTo(b.a(this.a, 5.0F) + i, getHeight());
    paramContext.lineTo(i + b.a(this.a, 10.0F), getHeight() - b.a(this.a, 5.0F));
    paramContext.lineTo(f, getHeight() - b.a(this.a, 5.0F));
    paramCanvas.drawPath(paramContext, this.b);
  }
  
  public void setBottomBarColor(int paramInt)
  {
    this.b.setColor(paramInt);
    this.b.setStyle(Paint.Style.FILL);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new d(this));
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    setBackgroundDrawable(a(localShapeDrawable, localShapeDrawable, localShapeDrawable, localShapeDrawable));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */