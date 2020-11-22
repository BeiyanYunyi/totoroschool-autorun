package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public final class cu
{
  static long c;
  static long d;
  static long e;
  static long f;
  static long g;
  public static HashMap<String, Long> q = new HashMap(36);
  public static long r = 0L;
  static int s = 0;
  WifiManager a;
  ArrayList<ScanResult> b = new ArrayList();
  Context h;
  boolean i = false;
  StringBuilder j = null;
  boolean k = true;
  boolean l = true;
  boolean m = true;
  String n = null;
  TreeMap<Integer, ScanResult> o = null;
  public boolean p = true;
  ConnectivityManager t = null;
  volatile boolean u = false;
  private volatile WifiInfo v = null;
  private long w = 30000L;
  
  public cu(Context paramContext, WifiManager paramWifiManager)
  {
    this.a = paramWifiManager;
    this.h = paramContext;
  }
  
  public static long a()
  {
    return (dn.b() - r) / 1000L + 1L;
  }
  
  private static boolean a(int paramInt)
  {
    try
    {
      paramInt = WifiManager.calculateSignalLevel(paramInt, 20);
    }
    catch (ArithmeticException localArithmeticException)
    {
      dg.a(localArithmeticException, "Aps", "wifiSigFine");
      paramInt = 20;
    }
    return paramInt > 0;
  }
  
  public static boolean a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramWifiInfo.getSSID())) {
      return false;
    }
    return dn.a(paramWifiInfo.getBSSID());
  }
  
  public static String k()
  {
    return String.valueOf(dn.b() - f);
  }
  
  private List<ScanResult> l()
  {
    if (this.a != null) {
      try
      {
        List localList = this.a.getScanResults();
        if (Build.VERSION.SDK_INT >= 17)
        {
          HashMap localHashMap = new HashMap(36);
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            ScanResult localScanResult = (ScanResult)localIterator.next();
            localHashMap.put(localScanResult.BSSID, Long.valueOf(localScanResult.timestamp));
          }
          if ((q.isEmpty()) || (!q.equals(localHashMap))) {
            q = localHashMap;
          }
        }
        else
        {
          for (long l1 = dn.b();; l1 = dn.b())
          {
            r = l1;
            break;
          }
        }
        this.n = null;
        return localList;
      }
      catch (Throwable localThrowable)
      {
        this.n = null;
        dg.a(localThrowable, "WifiManagerWrapper", "getScanResults");
        return null;
      }
      catch (SecurityException localSecurityException)
      {
        this.n = localSecurityException.getMessage();
      }
    }
    return null;
  }
  
  private WifiInfo m()
  {
    try
    {
      if (this.a != null)
      {
        WifiInfo localWifiInfo = this.a.getConnectionInfo();
        return localWifiInfo;
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "WifiManagerWrapper", "getConnectionInfo");
    }
    return null;
  }
  
  private void n()
  {
    if (o()) {}
    for (;;)
    {
      try
      {
        long l2 = dn.b() - c;
        if (l2 < 4900L) {
          break label191;
        }
        if (this.t == null) {
          this.t = ((ConnectivityManager)dn.a(this.h, "connectivity"));
        }
        if ((a(this.t)) && (l2 < 9900L)) {
          break label191;
        }
        if (s > 1)
        {
          long l3 = this.w;
          long l1 = 30000L;
          if (l3 != 30000L) {
            l1 = this.w;
          } else if (df.z() != -1L) {
            l1 = df.z();
          }
          if ((Build.VERSION.SDK_INT >= 28) && (l2 < l1)) {
            break label191;
          }
        }
        if (this.a == null) {
          break label191;
        }
        c = dn.b();
        if (s < 2) {
          s += 1;
        }
        bool = this.a.startScan();
        if (bool) {
          e = dn.b();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        dg.a(localThrowable, "WifiManager", "wifiScan");
      }
      return;
      label191:
      boolean bool = false;
    }
  }
  
  private boolean o()
  {
    boolean bool;
    if (this.a == null) {
      bool = false;
    } else {
      bool = dn.h(this.h);
    }
    this.p = bool;
    if (!this.p) {
      return false;
    }
    if (!this.k) {
      return false;
    }
    if (e == 0L) {}
    for (;;)
    {
      return true;
      if (dn.b() - e < 4900L) {
        return false;
      }
      if (dn.b() - f < 1500L) {
        return false;
      }
      dn.b();
      long l1 = f;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.h;
    if (df.y())
    {
      if (!this.m) {
        return;
      }
      if ((this.a != null) && (localObject != null))
      {
        if (!paramBoolean) {
          return;
        }
        if (dn.c() <= 17) {
          return;
        }
        localObject = ((Context)localObject).getContentResolver();
        try
        {
          if (((Integer)dj.a("android.provider.Settings$Global", "getInt", new Object[] { localObject, "wifi_scan_always_enabled" }, new Class[] { ContentResolver.class, String.class })).intValue() == 0)
          {
            Class localClass = Integer.TYPE;
            dj.a("android.provider.Settings$Global", "putInt", new Object[] { localObject, "wifi_scan_always_enabled", Integer.valueOf(1) }, new Class[] { ContentResolver.class, String.class, localClass });
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          dg.a(localThrowable, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramBoolean3;
    if (paramLong < 10000L)
    {
      this.w = 10000L;
      return;
    }
    this.w = paramLong;
  }
  
  public final boolean a(ConnectivityManager paramConnectivityManager)
  {
    WifiManager localWifiManager = this.a;
    if (localWifiManager == null) {
      return false;
    }
    try
    {
      if (dn.a(paramConnectivityManager.getActiveNetworkInfo()) == 1)
      {
        boolean bool = a(localWifiManager.getConnectionInfo());
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramConnectivityManager)
    {
      dg.a(paramConnectivityManager, "WifiManagerWrapper", "wifiAccess");
    }
    return false;
  }
  
  public final String b()
  {
    return this.n;
  }
  
  public final void b(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      if (!o()) {
        break label93;
      }
      long l1 = dn.b();
      if (l1 - d >= 10000L)
      {
        this.b.clear();
        g = f;
      }
      n();
      if (l1 - d < 10000L) {
        break label93;
      }
      i1 = 20;
    }
    for (;;)
    {
      if ((i1 > 0) && (f == g)) {}
      try
      {
        Thread.sleep(150L);
        i1 -= 1;
        continue;
        n();
        label93:
        paramBoolean = this.u;
        i1 = 0;
        if (paramBoolean)
        {
          this.u = false;
          d();
        }
        Object localObject;
        if (g != f)
        {
          localObject = null;
          try
          {
            List localList = l();
            localObject = localList;
          }
          catch (Throwable localThrowable2)
          {
            dg.a(localThrowable2, "WifiManager", "updateScanResult");
          }
          g = f;
          if (localObject != null)
          {
            this.b.clear();
            this.b.addAll((Collection)localObject);
          }
          else
          {
            this.b.clear();
          }
        }
        if (dn.b() - f > 20000L) {
          this.b.clear();
        }
        d = dn.b();
        if (this.b.isEmpty())
        {
          f = dn.b();
          localObject = l();
          if (localObject != null) {
            this.b.addAll((Collection)localObject);
          }
        }
        if (this.b != null)
        {
          if (this.b.isEmpty()) {
            return;
          }
          if (dn.b() - f > 3600000L) {
            d();
          }
          if (this.o == null) {
            this.o = new TreeMap(Collections.reverseOrder());
          }
          this.o.clear();
          int i2 = this.b.size();
          ScanResult localScanResult;
          while (i1 < i2)
          {
            localScanResult = (ScanResult)this.b.get(i1);
            if (localScanResult != null) {
              localObject = localScanResult.BSSID;
            } else {
              localObject = "";
            }
            if ((dn.a((String)localObject)) && ((i2 <= 20) || (a(localScanResult.level))))
            {
              if (!TextUtils.isEmpty(localScanResult.SSID))
              {
                if ("<unknown ssid>".equals(localScanResult.SSID)) {
                  break label434;
                }
                localObject = String.valueOf(i1);
              }
              else
              {
                localObject = "unkwn";
              }
              localScanResult.SSID = ((String)localObject);
              label434:
              this.o.put(Integer.valueOf(localScanResult.level * 25 + i1), localScanResult);
            }
            i1 += 1;
          }
          this.b.clear();
          localObject = this.o.values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localScanResult = (ScanResult)((Iterator)localObject).next();
            this.b.add(localScanResult);
          }
          this.o.clear();
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
    }
  }
  
  public final ArrayList<ScanResult> c()
  {
    if (this.b == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (!this.b.isEmpty()) {
      localArrayList.addAll(this.b);
    }
    return localArrayList;
  }
  
  public final void d()
  {
    this.v = null;
    this.b.clear();
  }
  
  public final void e()
  {
    if (this.a == null) {
      return;
    }
    if (dn.b() - f > 4900L) {
      f = dn.b();
    }
  }
  
  public final void f()
  {
    if (this.a == null) {
      return;
    }
    int i1;
    try
    {
      if (this.a != null) {
        i1 = this.a.getWifiState();
      }
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "Aps", "onReceive part");
      i1 = 4;
    }
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if (i1 != 4) {
      switch (i1)
      {
      default: 
        return;
      }
    }
    this.u = true;
  }
  
  public final WifiInfo g()
  {
    this.v = m();
    return this.v;
  }
  
  public final boolean h()
  {
    return this.i;
  }
  
  public final String i()
  {
    if (this.j == null) {
      this.j = new StringBuilder(700);
    } else {
      this.j.delete(0, this.j.length());
    }
    this.i = false;
    String str1 = "";
    this.v = g();
    if (a(this.v)) {
      str1 = this.v.getBSSID();
    }
    int i5 = this.b.size();
    int i3 = 0;
    int i1 = 0;
    int i2 = 0;
    Object localObject;
    while (i3 < i5)
    {
      String str2 = ((ScanResult)this.b.get(i3)).BSSID;
      int i4 = i1;
      if (!this.l)
      {
        i4 = i1;
        if (!"<unknown ssid>".equals(((ScanResult)this.b.get(i3)).SSID)) {
          i4 = 1;
        }
      }
      localObject = "nb";
      if (str1.equals(str2))
      {
        localObject = "access";
        i2 = 1;
      }
      this.j.append(String.format(Locale.US, "#%s,%s", new Object[] { str2, localObject }));
      i3 += 1;
      i1 = i4;
    }
    if (this.b.size() == 0) {
      i1 = 1;
    }
    if ((!this.l) && (i1 == 0)) {
      this.i = true;
    }
    if ((i2 == 0) && (!TextUtils.isEmpty(str1)))
    {
      localObject = this.j;
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(str1);
      this.j.append(",access");
    }
    return this.j.toString();
  }
  
  public final void j()
  {
    d();
    this.b.clear();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */