package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class Apn
{
  public static final int APN_2G = 1;
  public static final int APN_3G = 2;
  public static final int APN_4G = 4;
  public static final int APN_UNKNOWN = 0;
  public static final int APN_WIFI = 3;
  
  public static String getApnInfo(Context paramContext)
  {
    String str = "unknown";
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    paramContext = str;
    if (localNetworkInfo != null)
    {
      paramContext = str;
      if (localNetworkInfo.isConnectedOrConnecting())
      {
        switch (localNetworkInfo.getType())
        {
        default: 
          return "unknown";
        case 1: 
          return "wifi";
        }
        paramContext = localNetworkInfo.getExtraInfo();
      }
    }
    return paramContext;
  }
  
  public static int getApnType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int j = 0;
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.isConnectedOrConnecting())
      {
        switch (paramContext.getType())
        {
        default: 
          return 0;
        case 1: 
          return 3;
        }
        switch (paramContext.getSubtype())
        {
        default: 
          return 0;
        case 13: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 2;
        }
        i = 1;
      }
    }
    return i;
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    Object localObject = null;
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      paramContext = (Context)localObject;
      if (localWifiInfo != null) {
        paramContext = localWifiInfo.getBSSID();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return (paramContext.isConnected()) || (paramContext.isAvailable());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\Apn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */