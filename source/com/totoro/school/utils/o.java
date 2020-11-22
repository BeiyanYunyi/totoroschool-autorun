package com.totoro.school.utils;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat"})
public class o
{
  public static String a(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return "--";
    }
    int i = (int)paramDouble;
    int j = i / 60;
    if (j >= 100) {
      return "--";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("'");
    localStringBuilder.append(i % 60);
    localStringBuilder.append("''");
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    long l1 = paramLong / 3600L;
    if (l1 < 10L)
    {
      l2 = paramLong % 3600L / 60L;
      if (l2 < 10L)
      {
        paramLong %= 60L;
        if (paramLong < 10L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append(l1);
          localStringBuilder.append(":0");
          localStringBuilder.append(l2);
          localStringBuilder.append(":0");
          localStringBuilder.append(paramLong);
          return localStringBuilder.toString();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(l1);
        localStringBuilder.append(":0");
        localStringBuilder.append(l2);
        localStringBuilder.append(":");
        localStringBuilder.append(paramLong);
        return localStringBuilder.toString();
      }
      paramLong %= 60L;
      if (paramLong < 10L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(l1);
        localStringBuilder.append(":");
        localStringBuilder.append(l2);
        localStringBuilder.append(":0");
        localStringBuilder.append(paramLong);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(l1);
      localStringBuilder.append(":");
      localStringBuilder.append(l2);
      localStringBuilder.append(":");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    long l2 = paramLong % 3600L / 60L;
    if (l2 < 10L)
    {
      paramLong %= 60L;
      if (paramLong < 10L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l1);
        localStringBuilder.append(":0");
        localStringBuilder.append(l2);
        localStringBuilder.append(":0");
        localStringBuilder.append(paramLong);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l1);
      localStringBuilder.append(":0");
      localStringBuilder.append(l2);
      localStringBuilder.append(":");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    paramLong %= 60L;
    if (paramLong < 10L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l1);
      localStringBuilder.append(":");
      localStringBuilder.append(l2);
      localStringBuilder.append(":0");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l1);
    localStringBuilder.append(":");
    localStringBuilder.append(l2);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    paramString = new SimpleDateFormat(paramString);
    Date localDate = new Date();
    localDate.setTime(System.currentTimeMillis());
    return paramString.format(localDate);
  }
  
  public static String b(String paramString)
  {
    Object localObject = paramString.split(":");
    paramString = localObject[0];
    String str = localObject[1];
    localObject = localObject[2];
    long l = Integer.parseInt(paramString) * 60 * 60 + Integer.parseInt(str) * 60 + Integer.parseInt((String)localObject);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(l);
    return paramString.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */