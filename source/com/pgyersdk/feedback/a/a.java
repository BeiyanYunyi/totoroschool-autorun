package com.pgyersdk.feedback.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;

public class a
  extends ImageButton
{
  public static String a = "#383737";
  private Context b;
  private String c = "#ffffff";
  private ColorDrawable d;
  private ColorDrawable e;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    a();
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
  
  private void a()
  {
    this.d = new ColorDrawable(0);
    this.e = new ColorDrawable(Color.parseColor(a));
    Context localContext = this.b;
    ColorDrawable localColorDrawable1 = this.d;
    ColorDrawable localColorDrawable2 = this.e;
    setBackgroundDrawable(a(localContext, localColorDrawable1, localColorDrawable2, localColorDrawable2, localColorDrawable1));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */