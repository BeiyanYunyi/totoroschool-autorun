package com.bumptech.glide.load.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class i
{
  private final int a;
  private final int b;
  private final Context c;
  
  public i(Context paramContext)
  {
    this(paramContext, (ActivityManager)paramContext.getSystemService("activity"), new a(paramContext.getResources().getDisplayMetrics()));
  }
  
  i(Context paramContext, ActivityManager paramActivityManager, b paramb)
  {
    this.c = paramContext;
    int i = a(paramActivityManager);
    int k = paramb.a() * paramb.b() * 4;
    int j = k * 4;
    int m = k * 2;
    k = m + j;
    if (k <= i)
    {
      this.b = m;
      this.a = j;
    }
    else
    {
      j = Math.round(i / 6.0F);
      this.b = (j * 2);
      this.a = (j * 4);
    }
    if (Log.isLoggable("MemorySizeCalculator", 3))
    {
      paramContext = new StringBuilder();
      paramContext.append("Calculated memory cache size: ");
      paramContext.append(a(this.b));
      paramContext.append(" pool size: ");
      paramContext.append(a(this.a));
      paramContext.append(" memory class limited? ");
      boolean bool;
      if (k > i) {
        bool = true;
      } else {
        bool = false;
      }
      paramContext.append(bool);
      paramContext.append(" max size: ");
      paramContext.append(a(i));
      paramContext.append(" memoryClass: ");
      paramContext.append(paramActivityManager.getMemoryClass());
      paramContext.append(" isLowMemoryDevice: ");
      paramContext.append(b(paramActivityManager));
      Log.d("MemorySizeCalculator", paramContext.toString());
    }
  }
  
  private static int a(ActivityManager paramActivityManager)
  {
    int i = paramActivityManager.getMemoryClass();
    boolean bool = b(paramActivityManager);
    float f2 = i * 1024 * 1024;
    float f1;
    if (bool) {
      f1 = 0.33F;
    } else {
      f1 = 0.4F;
    }
    return Math.round(f2 * f1);
  }
  
  private String a(int paramInt)
  {
    return Formatter.formatFileSize(this.c, paramInt);
  }
  
  @TargetApi(19)
  private static boolean b(ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramActivityManager.isLowRamDevice();
    }
    return Build.VERSION.SDK_INT < 11;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  private static class a
    implements i.b
  {
    private final DisplayMetrics a;
    
    public a(DisplayMetrics paramDisplayMetrics)
    {
      this.a = paramDisplayMetrics;
    }
    
    public int a()
    {
      return this.a.widthPixels;
    }
    
    public int b()
    {
      return this.a.heightPixels;
    }
  }
  
  static abstract interface b
  {
    public abstract int a();
    
    public abstract int b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */