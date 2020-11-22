package com.pgyersdk.e.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;

public class b
{
  private static String a = null;
  private final a b;
  private boolean c;
  private boolean d;
  private boolean e;
  private View f;
  private View g;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = ((Class)localObject).getDeclaredMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      a = (String)((Method)localObject).invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  @TargetApi(19)
  public b(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    ViewGroup localViewGroup = (ViewGroup)localWindow.getDecorView();
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = paramActivity.obtainStyledAttributes(new int[] { 16843759, 16843760 });
    }
    try
    {
      this.c = ((TypedArray)localObject).getBoolean(0, false);
      this.d = ((TypedArray)localObject).getBoolean(1, false);
      ((TypedArray)localObject).recycle();
      localObject = localWindow.getAttributes();
      if ((((WindowManager.LayoutParams)localObject).flags & 0x4000000) != 0) {
        this.c = true;
      }
      if ((((WindowManager.LayoutParams)localObject).flags & 0x8000000) != 0) {
        this.d = true;
      }
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
    if (!this.b.d()) {
      this.d = false;
    }
    if (this.c) {
      b(paramActivity, localViewGroup);
    }
    if (this.d) {
      a(paramActivity, localViewGroup);
    }
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.g = new View(paramContext);
    if (this.b.e())
    {
      paramContext = new FrameLayout.LayoutParams(-1, this.b.a());
      paramContext.gravity = 80;
    }
    else
    {
      paramContext = new FrameLayout.LayoutParams(this.b.b(), -1);
      paramContext.gravity = 5;
    }
    this.g.setLayoutParams(paramContext);
    this.g.setBackgroundColor(-1728053248);
    this.g.setVisibility(8);
    paramViewGroup.addView(this.g);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    this.f = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, this.b.c());
    paramContext.gravity = 48;
    if ((this.d) && (!this.b.e())) {
      paramContext.rightMargin = this.b.b();
    }
    this.f.setLayoutParams(paramContext);
    this.f.setBackgroundColor(-1728053248);
    this.f.setVisibility(8);
    paramViewGroup.addView(this.f);
  }
  
  public void a(int paramInt)
  {
    if (this.c) {
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.c)
    {
      View localView = this.f;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public static class a
  {
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final float i;
    
    private a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
    {
      Resources localResources = paramActivity.getResources();
      int j = localResources.getConfiguration().orientation;
      boolean bool2 = false;
      if (j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.h = bool1;
      this.i = a(paramActivity);
      this.c = a(localResources, "status_bar_height");
      this.d = a(paramActivity);
      this.f = b(paramActivity);
      this.g = c(paramActivity);
      boolean bool1 = bool2;
      if (this.f > 0) {
        bool1 = true;
      }
      this.e = bool1;
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }
    
    @SuppressLint({"NewApi"})
    private float a(Activity paramActivity)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 16) {
        paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      } else {
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
      float f1 = localDisplayMetrics.widthPixels;
      float f2 = localDisplayMetrics.density;
      return Math.min(f1 / f2, localDisplayMetrics.heightPixels / f2);
    }
    
    @TargetApi(14)
    private int a(Context paramContext)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        TypedValue localTypedValue = new TypedValue();
        paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
        return TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      }
      return 0;
    }
    
    private int a(Resources paramResources, String paramString)
    {
      int j = paramResources.getIdentifier(paramString, "dimen", "android");
      if (j > 0) {
        return paramResources.getDimensionPixelSize(j);
      }
      return 0;
    }
    
    @TargetApi(14)
    private int b(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      if ((Build.VERSION.SDK_INT >= 14) && (d(paramContext)))
      {
        if (this.h) {
          paramContext = "navigation_bar_height";
        } else {
          paramContext = "navigation_bar_height_landscape";
        }
        return a(localResources, paramContext);
      }
      return 0;
    }
    
    @TargetApi(14)
    private int c(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      if ((Build.VERSION.SDK_INT >= 14) && (d(paramContext))) {
        return a(localResources, "navigation_bar_width");
      }
      return 0;
    }
    
    @TargetApi(14)
    private boolean d(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      int j = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
      if (j != 0)
      {
        boolean bool = localResources.getBoolean(j);
        if ("1".equals(b.a())) {
          return false;
        }
        if ("0".equals(b.a())) {
          return true;
        }
        return bool;
      }
      return ViewConfiguration.get(paramContext).hasPermanentMenuKey() ^ true;
    }
    
    public int a()
    {
      return this.f;
    }
    
    public int b()
    {
      return this.g;
    }
    
    public int c()
    {
      return this.c;
    }
    
    public boolean d()
    {
      return this.e;
    }
    
    public boolean e()
    {
      return (this.i >= 600.0F) || (this.h);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */