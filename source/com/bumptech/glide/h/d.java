package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class d
{
  private static final double a;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    double d = 1.0D;
    if (17 <= i) {
      d = 1.0D / Math.pow(10.0D, 6.0D);
    }
    a = d;
  }
  
  public static double a(long paramLong)
  {
    double d1 = a() - paramLong;
    double d2 = a;
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  @TargetApi(17)
  public static long a()
  {
    if (17 <= Build.VERSION.SDK_INT) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return System.currentTimeMillis();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */