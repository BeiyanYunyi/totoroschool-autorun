package com.pgyersdk.feedback.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import android.widget.Button;

public class c
  extends Button
{
  public c(Context paramContext)
  {
    super(paramContext);
    int i = (int)TypedValue.applyDimension(1, 5.0F, paramContext.getResources().getDisplayMetrics());
    Object localObject = new float[8];
    float f = i;
    localObject[0] = f;
    localObject[1] = f;
    localObject[2] = f;
    localObject[3] = f;
    localObject[4] = f;
    localObject[5] = f;
    localObject[6] = f;
    localObject[7] = f;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape((float[])localObject, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#f2f2f2"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(Color.parseColor("#e0e0e0"));
    ((ShapeDrawable)localObject).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    setBackgroundDrawable(a(paramContext, localShapeDrawable, (Drawable)localObject, (Drawable)localObject, localShapeDrawable));
    setTextSize(16.0F);
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramDrawable2);
    paramContext.addState(new int[] { 16842908 }, paramDrawable3);
    paramContext.addState(new int[0], paramDrawable1);
    return paramContext;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */