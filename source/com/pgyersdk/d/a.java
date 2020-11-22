package com.pgyersdk.d;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.pgyersdk.f.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static CountDownLatch a;
  private static boolean b = false;
  static String c = "";
  public static a d;
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    a = new CountDownLatch(1);
    new a().g(paramContext);
    try
    {
      a.await(5L, TimeUnit.SECONDS);
      h(paramContext);
      return c;
    }
    catch (InterruptedException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  @SuppressLint({"WrongConstant"})
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (m.a().a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      ((Map)localObject).put("wifi_permission", "true");
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      paramMap = paramContext.getConnectionInfo();
      ((Map)localObject).put("wifi_mac_address", paramMap.getMacAddress());
      if (paramContext.getWifiState() == 3)
      {
        ((Map)localObject).put("wifi_state", "true");
        ((Map)localObject).put("wifi_ip_address", a(paramMap.getIpAddress()));
        ((Map)localObject).put("wifi_ssid", paramMap.getSSID());
        ((Map)localObject).put("wifi_bssid", paramMap.getBSSID());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMap.getRssi());
        localStringBuilder.append("dB");
        ((Map)localObject).put("wifi_rssi", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMap.getLinkSpeed());
        localStringBuilder.append("Mbps");
        ((Map)localObject).put("wifi_link_speed", localStringBuilder.toString());
        paramContext = paramContext.getConfiguredNetworks();
        if (paramContext == null)
        {
          ((Map)localObject).put("wifi_state", "false");
          return (Map<String, String>)localObject;
        }
        int j = paramContext.size();
        int i = 0;
        while (i < j)
        {
          paramMap = new StringBuilder();
          paramMap.append("wifi_config_");
          paramMap.append(i);
          ((Map)localObject).put(paramMap.toString(), ((WifiConfiguration)paramContext.get(i)).toString());
          i += 1;
        }
      }
      ((Map)localObject).put("wifi_state", "false");
      return (Map<String, String>)localObject;
    }
    ((Map)localObject).put("wifi_permission", "false");
    return (Map<String, String>)localObject;
  }
  
  public static String[] a()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2;
    long l3;
    long l1;
    if (Build.VERSION.SDK_INT < 18)
    {
      l2 = localStatFs.getBlockSize();
      l3 = localStatFs.getBlockCount();
      l1 = localStatFs.getAvailableBlocks();
    }
    else
    {
      l2 = localStatFs.getBlockSizeLong();
      l3 = localStatFs.getBlockCountLong();
      l1 = localStatFs.getAvailableBlocksLong();
    }
    arrayOfString[0] = m.a().a(l3 * l2);
    arrayOfString[1] = m.a().a(l2 * l1);
    return arrayOfString;
  }
  
  public static String b(Context paramContext)
  {
    int i = Integer.valueOf(f(paramContext)[2]).intValue();
    if (i < 160) {
      return "mdpi";
    }
    if ((i >= 160) && (i <= 240)) {
      return "hdpi";
    }
    if ((i > 240) && (i <= 320)) {
      return "xhdpi";
    }
    if ((i > 320) && (i <= 480)) {
      return "xxhdpi";
    }
    return "xxxhdpi";
  }
  
  public static String[] b()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l2;
      long l3;
      long l1;
      if (Build.VERSION.SDK_INT < 18)
      {
        l2 = localStatFs.getBlockSize();
        l3 = localStatFs.getBlockCount();
        l1 = localStatFs.getAvailableBlocks();
      }
      else
      {
        l2 = localStatFs.getBlockSizeLong();
        l3 = localStatFs.getBlockCountLong();
        l1 = localStatFs.getAvailableBlocksLong();
      }
      arrayOfString[0] = m.a().a(l3 * l2);
      arrayOfString[1] = m.a().a(l2 * l1);
    }
    return arrayOfString;
  }
  
  public static DisplayMetrics c(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if ((m.a().a(paramContext, "android.permission.INTERNET")) && (m.a().a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
    {
      localHashMap.put("network_permission", "true");
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
      {
        localHashMap.put("network_state", "true");
        localHashMap.put("network_type", localNetworkInfo.getTypeName());
        if (localNetworkInfo.getType() == 0)
        {
          localHashMap.put("network_subtype", localNetworkInfo.getSubtypeName());
          localHashMap.put("network_apn", localNetworkInfo.getExtraInfo());
          return localHashMap;
        }
        if (localNetworkInfo.getType() == 1)
        {
          a(paramContext, localHashMap);
          return localHashMap;
        }
      }
      else
      {
        localHashMap.put("network_state", "false");
      }
      return localHashMap;
    }
    localHashMap.put("network_permission", "false");
    return localHashMap;
  }
  
  public static String[] e(Context paramContext)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject1).getMemoryInfo(paramContext);
    if (Build.VERSION.SDK_INT < 16)
    {
      l1 = 0L;
      long l2 = l1;
      try
      {
        localObject1 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        for (;;)
        {
          l2 = l1;
          Object localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 == null) {
            break;
          }
          if (localObject2 != null)
          {
            l2 = l1;
            boolean bool = ((String)localObject2).contains("MemTotal");
            if (bool)
            {
              l2 = l1;
              localObject2 = Pattern.compile("[^0-9]").matcher((CharSequence)localObject2);
              l2 = l1;
              l1 = 1024L * Long.parseLong(((Matcher)localObject2).replaceAll("").trim());
            }
          }
        }
        l2 = l1;
        ((BufferedReader)localObject1).close();
      }
      catch (IOException localIOException)
      {
        m.a().a("DeviceHelper", localIOException);
        l1 = l2;
      }
    }
    long l1 = paramContext.totalMem;
    return new String[] { m.a().a(l1), m.a().a(paramContext.availMem) };
  }
  
  public static String[] f(Context paramContext)
  {
    paramContext = c(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(paramContext.heightPixels);
    return new String[] { localStringBuilder.toString(), String.valueOf(paramContext.density), String.valueOf(paramContext.densityDpi) };
  }
  
  /* Error */
  public static void h(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 438	com/pgyersdk/d/a:d	Lcom/pgyersdk/d/a$a;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ifnull +16 -> 28
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 442	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   20: aconst_null
    //   21: putstatic 438	com/pgyersdk/d/a:d	Lcom/pgyersdk/d/a$a;
    //   24: iconst_0
    //   25: putstatic 444	com/pgyersdk/d/a:b	Z
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: astore_0
    //   39: goto -11 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramContext	Context
    //   6	11	1	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	7	32	finally
    //   15	28	32	finally
    //   15	28	38	java/lang/Exception
  }
  
  public void g(Context paramContext)
  {
    try
    {
      try
      {
        boolean bool = b;
        if (bool) {
          return;
        }
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        d = new a();
        paramContext.registerReceiver(d, localIntentFilter);
        b = true;
      }
      finally {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("level", 0);
        int j = paramIntent.getIntExtra("scale", 100);
        paramContext = new StringBuilder();
        paramContext.append(i * 100 / j);
        paramContext.append("%");
        a.c = paramContext.toString();
        a.a.countDown();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */