package com.amap.api.mapcore.util;

import java.util.Calendar;
import java.util.Date;

public final class lg
{
  private static long a(long paramLong)
  {
    return paramLong - b(paramLong);
  }
  
  public static long a(long paramLong1, long paramLong2)
  {
    try
    {
      if (Math.abs(paramLong1 - paramLong2) > 31536000000L)
      {
        paramLong2 = b(paramLong1, paramLong2);
        return paramLong2;
      }
      return paramLong1;
    }
    catch (Throwable localThrowable) {}
    return paramLong1;
  }
  
  private static long b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramLong));
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static long b(long paramLong1, long paramLong2)
  {
    paramLong1 = a(paramLong1);
    long l1 = b(paramLong2) + paramLong1;
    long l2 = Math.abs(l1 - paramLong2);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l1));
    int i = localCalendar.get(11);
    paramLong1 = l1;
    if (i == 23)
    {
      paramLong1 = l1;
      if (l2 >= 82800000L) {
        paramLong1 = l1 - 86400000L;
      }
    }
    paramLong2 = paramLong1;
    if (i == 0)
    {
      paramLong2 = paramLong1;
      if (l2 >= 82800000L) {
        paramLong2 = paramLong1 + 86400000L;
      }
    }
    return paramLong2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */