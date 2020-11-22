package com.totoro.school.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class j
{
  private static String a()
  {
    try
    {
      String str = new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return "02:00:00:00:00:00";
  }
  
  public static String a(Context paramContext)
  {
    String str = "02:00:00:00:00:00";
    if (Build.VERSION.SDK_INT < 23) {
      return b(paramContext);
    }
    if (Build.VERSION.SDK_INT < 24) {
      return a();
    }
    paramContext = str;
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = b();
    }
    return paramContext;
  }
  
  private static String b()
  {
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return (String)localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "02:00:00:00:00:00";
    }
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext == null) {
      return "02:00:00:00:00:00";
    }
    try
    {
      paramContext = paramContext.getConnectionInfo();
    }
    catch (Exception paramContext)
    {
      String str;
      for (;;) {}
    }
    paramContext = null;
    if (paramContext == null) {
      return null;
    }
    str = paramContext.getMacAddress();
    paramContext = str;
    if (!TextUtils.isEmpty(str)) {
      paramContext = str.toUpperCase(Locale.ENGLISH);
    }
    return paramContext;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */