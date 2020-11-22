package com.loc;

import java.util.Calendar;
import java.util.Date;

public final class dh
{
  private static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramLong));
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(long paramLong1, long paramLong2, int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      if (Math.abs(paramLong1 - paramLong2) > paramInt * 31536000000L)
      {
        long l1 = a(paramLong1);
        l1 = a(paramLong2) + (paramLong1 - l1);
        long l2 = Math.abs(l1 - paramLong2);
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(new Date(l1));
        paramInt = localCalendar.get(11);
        paramLong1 = l1;
        if (paramInt == 23)
        {
          paramLong1 = l1;
          if (l2 >= 82800000L) {
            paramLong1 = l1 - 86400000L;
          }
        }
        paramLong2 = paramLong1;
        if (paramInt == 0)
        {
          paramLong2 = paramLong1;
          if (l2 >= 82800000L) {
            paramLong2 = paramLong1 + 86400000L;
          }
        }
        return paramLong2;
      }
      return paramLong1;
    }
    catch (Throwable localThrowable) {}
    return paramLong1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */