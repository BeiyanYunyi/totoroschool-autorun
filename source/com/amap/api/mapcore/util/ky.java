package com.amap.api.mapcore.util;

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
import java.util.TreeMap;

public final class ky
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
  
  public ky(Context paramContext, WifiManager paramWifiManager)
  {
    this.a = paramWifiManager;
    this.h = paramContext;
  }
  
  private static boolean a(int paramInt)
  {
    try
    {
      paramInt = WifiManager.calculateSignalLevel(paramInt, 20);
    }
    catch (ArithmeticException localArithmeticException)
    {
      lf.a(localArithmeticException, "Aps", "wifiSigFine");
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
    return lj.a(paramWifiInfo.getBSSID());
  }
  
  private void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.l = true;
    this.m = true;
    this.w = 30000L;
  }
  
  public static String i()
  {
    return String.valueOf(lj.b() - f);
  }
  
  private List<ScanResult> j()
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
          for (long l1 = lj.b();; l1 = lj.b())
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
        lf.a(localThrowable, "WifiManagerWrapper", "getScanResults");
        return null;
      }
      catch (SecurityException localSecurityException)
      {
        this.n = localSecurityException.getMessage();
      }
    }
    return null;
  }
  
  private WifiInfo k()
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
      lf.a(localThrowable, "WifiManagerWrapper", "getConnectionInfo");
    }
    return null;
  }
  
  private int l()
  {
    if (this.a != null) {
      return this.a.getWifiState();
    }
    return 4;
  }
  
  private boolean m()
  {
    long l2 = lj.b() - c;
    if (l2 < 4900L) {
      return false;
    }
    if ((n()) && (l2 < 9900L)) {
      return false;
    }
    if (s > 1)
    {
      long l3 = this.w;
      long l1 = 30000L;
      if (l3 != 30000L) {
        l1 = this.w;
      } else if (ld.b() != -1L) {
        l1 = ld.b();
      }
      if ((Build.VERSION.SDK_INT >= 28) && (l2 < l1)) {
        return false;
      }
    }
    if (this.a != null)
    {
      c = lj.b();
      if (s < 2) {
        s += 1;
      }
      return this.a.startScan();
    }
    return false;
  }
  
  private boolean n()
  {
    if (this.t == null) {
      this.t = ((ConnectivityManager)lj.a(this.h, "connectivity"));
    }
    return a(this.t);
  }
  
  private boolean o()
  {
    if (this.a == null) {
      return false;
    }
    return lj.c(this.h);
  }
  
  private void p()
  {
    if (this.b != null)
    {
      if (this.b.isEmpty()) {
        return;
      }
      if (lj.b() - f > 3600000L) {
        b();
      }
      if (this.o == null) {
        this.o = new TreeMap(Collections.reverseOrder());
      }
      this.o.clear();
      int i2 = this.b.size();
      int i1 = 0;
      ScanResult localScanResult;
      while (i1 < i2)
      {
        localScanResult = (ScanResult)this.b.get(i1);
        if (localScanResult != null) {
          localObject = localScanResult.BSSID;
        } else {
          localObject = "";
        }
        if ((lj.a((String)localObject)) && ((i2 <= 20) || (a(localScanResult.level))))
        {
          if (!TextUtils.isEmpty(localScanResult.SSID))
          {
            if ("<unknown ssid>".equals(localScanResult.SSID)) {
              break label177;
            }
            localObject = String.valueOf(i1);
          }
          else
          {
            localObject = "unkwn";
          }
          localScanResult.SSID = ((String)localObject);
          label177:
          this.o.put(Integer.valueOf(localScanResult.level * 25 + i1), localScanResult);
        }
        i1 += 1;
      }
      this.b.clear();
      Object localObject = this.o.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localScanResult = (ScanResult)((Iterator)localObject).next();
        this.b.add(localScanResult);
      }
      this.o.clear();
    }
  }
  
  private void q()
  {
    long l1;
    int i1;
    if (t())
    {
      l1 = lj.b();
      i1 = 20;
      if (l1 - d >= 10000L)
      {
        this.b.clear();
        g = f;
      }
      r();
    }
    for (;;)
    {
      if ((l1 - d >= 10000L) && (i1 > 0) && (f == g)) {}
      try
      {
        Thread.sleep(150L);
        i1 -= 1;
        continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  private void r()
  {
    if (t()) {
      try
      {
        if (m()) {
          e = lj.b();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        lf.a(localThrowable, "WifiManager", "wifiScan");
      }
    }
  }
  
  private void s()
  {
    if (g != f)
    {
      Object localObject = null;
      try
      {
        List localList = j();
        localObject = localList;
      }
      catch (Throwable localThrowable)
      {
        lf.a(localThrowable, "WifiManager", "updateScanResult");
      }
      g = f;
      if (localObject != null)
      {
        this.b.clear();
        this.b.addAll((Collection)localObject);
        return;
      }
      this.b.clear();
    }
  }
  
  private boolean t()
  {
    this.p = o();
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
      if (lj.b() - e < 4900L) {
        return false;
      }
      if (lj.b() - f < 1500L) {
        return false;
      }
      lj.b();
      long l1 = f;
    }
  }
  
  public final ArrayList<ScanResult> a()
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
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.h;
    if (ld.a())
    {
      if (!this.m) {
        return;
      }
      if ((this.a != null) && (localObject != null))
      {
        if (!paramBoolean) {
          return;
        }
        if (lj.c() <= 17) {
          return;
        }
        localObject = ((Context)localObject).getContentResolver();
        try
        {
          if (((Integer)lh.a("android.provider.Settings$Global", "getInt", new Object[] { localObject, "wifi_scan_always_enabled" }, new Class[] { ContentResolver.class, String.class })).intValue() == 0)
          {
            Class localClass = Integer.TYPE;
            lh.a("android.provider.Settings$Global", "putInt", new Object[] { localObject, "wifi_scan_always_enabled", Integer.valueOf(1) }, new Class[] { ContentResolver.class, String.class, localClass });
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          lf.a(localThrowable, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
      }
    }
  }
  
  public final boolean a(ConnectivityManager paramConnectivityManager)
  {
    WifiManager localWifiManager = this.a;
    if (localWifiManager == null) {
      return false;
    }
    try
    {
      if (lj.a(paramConnectivityManager.getActiveNetworkInfo()) == 1)
      {
        boolean bool = a(localWifiManager.getConnectionInfo());
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramConnectivityManager)
    {
      lf.a(paramConnectivityManager, "WifiManagerWrapper", "wifiAccess");
    }
    return false;
  }
  
  public final void b()
  {
    this.v = null;
    this.b.clear();
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      q();
    } else {
      r();
    }
    if (this.u)
    {
      this.u = false;
      b();
    }
    s();
    if (lj.b() - f > 20000L) {
      this.b.clear();
    }
    d = lj.b();
    if (this.b.isEmpty())
    {
      f = lj.b();
      List localList = j();
      if (localList != null) {
        this.b.addAll(localList);
      }
    }
    p();
  }
  
  public final void c()
  {
    if (this.a == null) {
      return;
    }
    if (lj.b() - f > 4900L) {
      f = lj.b();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    d(paramBoolean);
  }
  
  public final void d()
  {
    if (this.a == null) {
      return;
    }
    int i1;
    try
    {
      i1 = l();
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "Aps", "onReceive part");
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
  
  public final boolean e()
  {
    return this.p;
  }
  
  public final WifiInfo f()
  {
    this.v = k();
    return this.v;
  }
  
  public final boolean g()
  {
    return this.i;
  }
  
  public final void h()
  {
    b();
    this.b.clear();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */