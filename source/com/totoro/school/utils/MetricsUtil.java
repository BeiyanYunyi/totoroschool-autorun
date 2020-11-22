package com.totoro.school.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

public class MetricsUtil
  extends Activity
{
  public static double a = 1080.0D;
  public static double b = 1920.0D;
  public static double c = 1080.0D;
  public static double d = 1920.0D;
  public static double e = 160.0D;
  public static double f = c / a;
  public static double g = d / b;
  public static double h = e / 160.0D;
  
  public static float a(int paramInt)
  {
    double d1 = paramInt;
    double d2 = f;
    Double.isNaN(d1);
    return (float)(d1 * d2 * h);
  }
  
  public static void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    c = localDisplayMetrics.widthPixels;
    d = localDisplayMetrics.heightPixels;
    e = localDisplayMetrics.densityDpi;
    f = c / a;
    g = d / b;
    h = 160.0D / e;
  }
  
  public static void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    double d1 = a(paramInt);
    double d2 = e;
    Double.isNaN(d1);
    localLayoutParams.width = ((int)(d1 * d2 / 160.0D));
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static float b(int paramInt)
  {
    double d1 = paramInt;
    double d2 = g;
    Double.isNaN(d1);
    return (float)(d1 * d2 * h);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\MetricsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */