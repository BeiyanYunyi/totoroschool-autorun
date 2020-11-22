package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint({"NewApi"})
public final class cl
{
  static int D = -1;
  public static boolean H = true;
  private static boolean M = false;
  private static int O = -1;
  int A = 12;
  cp B = null;
  boolean C = false;
  cn E = null;
  String F = null;
  ct G = null;
  IntentFilter I = null;
  LocationManager J = null;
  private int K = 0;
  private String L = null;
  private String N = null;
  private boolean P = true;
  private String Q;
  Context a = null;
  ConnectivityManager b = null;
  cu c = null;
  cs d = null;
  cw e = null;
  cm f = null;
  dd g = null;
  ArrayList<ScanResult> h = new ArrayList();
  a i = null;
  AMapLocationClientOption j = new AMapLocationClientOption();
  co k = null;
  long l = 0L;
  de m = null;
  boolean n = false;
  db o = null;
  StringBuilder p = new StringBuilder();
  boolean q = true;
  boolean r = true;
  AMapLocationClientOption.GeoLanguage s = AMapLocationClientOption.GeoLanguage.DEFAULT;
  boolean t = true;
  boolean u = false;
  WifiInfo v = null;
  boolean w = true;
  StringBuilder x = null;
  boolean y = false;
  public boolean z = false;
  
  private static co a(int paramInt, String paramString)
  {
    co localco = new co("");
    localco.setErrorCode(paramInt);
    localco.setLocationDetail(paramString);
    if (paramInt == 15) {
      dk.a(null, 2151);
    }
    return localco;
  }
  
  private co a(co paramco, bo parambo, d paramd)
  {
    if (parambo != null) {}
    try
    {
      if ((parambo.a != null) && (parambo.a.length != 0))
      {
        localObject = new dd();
        String str = new String(parambo.a, "UTF-8");
        if (str.contains("\"status\":\"0\""))
        {
          localObject = ((dd)localObject).a(str, this.a, parambo, paramd);
          try
          {
            ((co)localObject).h(this.x.toString());
            return (co)localObject;
          }
          catch (Throwable parambo)
          {
            paramco = (co)localObject;
          }
        }
        else
        {
          if (!str.contains("</body></html>")) {
            break label332;
          }
          paramco.setErrorCode(5);
          if ((this.c != null) && (this.c.a(this.b)))
          {
            paramd.e("#0501");
            this.p.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
            dk.a(null, 2051);
          }
          else
          {
            paramd.e("#0502");
            this.p.append("请求可能被劫持了#0502");
            dk.a(null, 2052);
          }
          paramco.setLocationDetail(this.p.toString());
          return paramco;
        }
      }
      else
      {
        paramco.setErrorCode(4);
        this.p.append("网络异常,请求异常#0403");
        paramd.e("#0403");
        paramco.h(this.x.toString());
        paramco.setLocationDetail(this.p.toString());
        if (parambo != null) {
          dk.a(parambo.d, 2041);
        }
        return paramco;
      }
    }
    catch (Throwable parambo)
    {
      Object localObject;
      for (;;) {}
    }
    paramco.setErrorCode(4);
    dg.a(parambo, "Aps", "checkResponseEntity");
    paramd.e("#0403");
    paramd = this.p;
    localObject = new StringBuilder("check response exception ex is");
    ((StringBuilder)localObject).append(parambo.getMessage());
    ((StringBuilder)localObject).append("#0403");
    paramd.append(((StringBuilder)localObject).toString());
    paramco.setLocationDetail(this.p.toString());
    return paramco;
    label332:
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private co a(boolean paramBoolean1, boolean paramBoolean2, d paramd)
  {
    try
    {
      if (TextUtils.isEmpty(this.Q))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(p.b(this.a));
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(p.i(this.a));
        this.Q = w.b(((StringBuilder)localObject1).toString());
      }
      localObject1 = this.p;
      ((StringBuilder)localObject1).append("#id:");
      ((StringBuilder)localObject1).append(this.Q);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject1;
        co localco;
        Object localObject3;
        label451:
        continue;
        label1376:
        Object localObject2 = null;
      }
    }
    localco = new co("");
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (this.m == null) {
          this.m = new de();
        }
        if (this.j == null) {
          this.j = new AMapLocationClientOption();
        }
        if (this.G == null) {
          break label1376;
        }
        localObject1 = this.G.c();
        this.m.a(this.a, this.j.isNeedAddress(), this.j.isOffset(), this.d, this.c, this.b, (String)localObject1, this.F);
        localObject1 = this.m.a();
        this.l = dn.b();
        paramd.a(this.l);
      }
      catch (Throwable localThrowable1)
      {
        Object localObject4;
        String str;
        long l1;
        paramd.e("#0301");
        paramd = this.p;
        localStringBuilder = new StringBuilder("get parames error:");
        localStringBuilder.append(localThrowable1.getMessage());
        localStringBuilder.append("#0301");
        paramd.append(localStringBuilder.toString());
        dk.a(null, 2031);
        int i1 = 3;
        continue;
      }
      try
      {
        dg.c(this.a);
        localObject4 = this.o.a(this.a, (byte[])localObject1, dg.a(), paramBoolean2);
        str = ((dc)localObject4).c();
        localObject1 = localObject3;
        if (df.B()) {
          localObject1 = cz.a(this.a).a((dc)localObject4);
        }
        paramBoolean2 = TextUtils.isEmpty((CharSequence)localObject1);
        if (paramBoolean2) {}
      }
      catch (Throwable localThrowable3)
      {
        dn.b();
        paramd.c("FAIL");
        cz.a(this.a).a(false);
        dg.a(localThrowable3, "Aps", "getApsLoc req");
        dk.a("/mobile/binary", localThrowable3);
        if (!dn.d(this.a))
        {
          paramd.e("#0401");
          paramd = this.p;
          localObject1 = "网络异常，未连接到网络，请连接网络#0401";
          paramd.append((String)localObject1);
        }
        else
        {
          if ((localThrowable3 instanceof k))
          {
            localObject1 = (k)localThrowable3;
            if (((k)localObject1).a().contains("网络异常状态码"))
            {
              paramd.e("#0404");
              paramd = this.p;
              paramd.append("网络异常，状态码错误#0404");
              paramd.append(((k)localObject1).f());
              continue;
            }
            if ((((k)localObject1).f() != 23) && (Math.abs(dn.b() - this.l - this.j.getHttpTimeOut()) >= 500L))
            {
              localObject1 = new StringBuilder("#0403,");
            }
            else
            {
              paramd.e("#0402");
              paramd = this.p;
              localObject1 = "网络异常，连接超时#0402";
            }
          }
          else
          {
            localObject1 = new StringBuilder("#0403,");
          }
          ((StringBuilder)localObject1).append(localThrowable3.getMessage());
          paramd.e(((StringBuilder)localObject1).toString());
          paramd = this.p;
          localObject1 = "网络异常,请求异常#0403";
          continue;
        }
        i1 = 4;
        paramd = a(i1, this.p.toString());
        paramd.h(this.x.toString());
        return paramd;
      }
      try
      {
        localObject3 = this.o.a((dc)localObject4);
        l1 = dn.b();
        paramd.b("SUCCESS");
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable4)
      {
        StringBuilder localStringBuilder;
      }
    }
    paramd.a((String)localObject1);
    paramd.b("FAIL");
    cz.a(this.a).a(false);
    ((dc)localObject4).a(str);
    if (this.o.a() > df.C())
    {
      ((dc)localObject4).a(df.C() * 1000);
      ((dc)localObject4).b(df.C() * 1000);
    }
    localObject1 = this.o.a((dc)localObject4);
    l1 = dn.b();
    paramd.c("SUCCESS");
    cz.a(this.a).a();
    break label451;
    localObject1 = this.o.a((dc)localObject4);
    l1 = dn.b();
    paramd.c("SUCCESS");
    cz.a(this.a).a(true);
    paramd.b(l1);
    localObject3 = "";
    if (localObject1 != null)
    {
      if (!TextUtils.isEmpty(((bo)localObject1).c))
      {
        localObject3 = this.p;
        localObject4 = new StringBuilder("#csid:");
        ((StringBuilder)localObject4).append(((bo)localObject1).c);
        ((StringBuilder)localObject3).append(((StringBuilder)localObject4).toString());
      }
      localObject3 = ((bo)localObject1).d;
      localco.h(this.x.toString());
    }
    localObject4 = localco;
    if (!paramBoolean1)
    {
      localObject4 = a(localco, (bo)localObject1, paramd);
      if (localObject4 != null) {
        return (co)localObject4;
      }
      localObject1 = cv.a(((bo)localObject1).a);
      if (localObject1 == null)
      {
        localco.setErrorCode(5);
        paramd.e("#0503");
        this.p.append("解密数据失败#0503");
        localco.setLocationDetail(this.p.toString());
        dk.a((String)localObject3, 2053);
        return localco;
      }
      localObject4 = this.g.a(localco, (byte[])localObject1, paramd);
      if (!dn.a((co)localObject4))
      {
        this.L = ((co)localObject4).b();
        if (!TextUtils.isEmpty(this.L)) {}
        for (i1 = 2062;; i1 = 2061)
        {
          dk.a((String)localObject3, i1);
          break;
        }
        ((co)localObject4).setErrorCode(6);
        paramd.e("#0601");
        localObject1 = this.p;
        localObject3 = new StringBuilder("location faile retype:");
        ((StringBuilder)localObject3).append(((co)localObject4).d());
        ((StringBuilder)localObject3).append(" rdesc:");
        if (TextUtils.isEmpty(this.L)) {
          paramd = "";
        } else {
          paramd = this.L;
        }
        ((StringBuilder)localObject3).append(paramd);
        ((StringBuilder)localObject3).append("#0601");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        ((co)localObject4).h(this.x.toString());
        ((co)localObject4).setLocationDetail(this.p.toString());
        return (co)localObject4;
      }
      if ((((co)localObject4).getErrorCode() == 0) && (((co)localObject4).getLocationType() == 0)) {
        if ((!"-5".equals(((co)localObject4).d())) && (!"1".equals(((co)localObject4).d())) && (!"2".equals(((co)localObject4).d())) && (!"14".equals(((co)localObject4).d())) && (!"24".equals(((co)localObject4).d())) && (!"-1".equals(((co)localObject4).d()))) {
          ((co)localObject4).setLocationType(6);
        } else {
          ((co)localObject4).setLocationType(5);
        }
      }
      ((co)localObject4).setOffset(this.r);
      ((co)localObject4).a(this.q);
      ((co)localObject4).f(String.valueOf(this.s));
    }
    ((co)localObject4).e("new");
    ((co)localObject4).setLocationDetail(this.p.toString());
    this.F = ((co)localObject4).a();
    return (co)localObject4;
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder == null) {
      paramStringBuilder = new StringBuilder(700);
    } else {
      paramStringBuilder.delete(0, paramStringBuilder.length());
    }
    paramStringBuilder.append(this.d.l());
    paramStringBuilder.append(this.c.i());
    return paramStringBuilder;
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if ((O == -1) || (df.e(paramContext)))
      {
        O = 1;
        df.a(paramContext);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Aps", "initAuth");
    }
  }
  
  private String c(d paramd)
  {
    Object localObject1 = "";
    int i2 = this.d.f();
    Object localObject2 = this.d.c();
    int i1;
    if ((this.h != null) && (!this.h.isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((localObject2 == null) && (i1 != 0))
    {
      if (this.b == null) {
        this.b = ((ConnectivityManager)dn.a(this.a, "connectivity"));
      }
      if ((dn.a(this.a)) && (!this.c.p))
      {
        this.A = 18;
        this.p.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
        dk.a(null, 2132);
        paramd.e("#1801");
        return "";
      }
      if (dn.c() >= 28)
      {
        if (this.J == null) {
          this.J = ((LocationManager)this.a.getApplicationContext().getSystemService("location"));
        }
        if (!((Boolean)dj.a(this.J, "isLocationEnabled", new Object[0])).booleanValue())
        {
          this.A = 12;
          this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
          paramd.e("#1206");
          dk.a(null, 2121);
          return "";
        }
      }
      if (!dn.f(this.a))
      {
        this.A = 12;
        this.p.append("定位权限被禁用,请授予应用定位权限#1201");
        paramd.e("#1201");
        dk.a(null, 2121);
        return "";
      }
      if ((dn.c() >= 24) && (dn.c() < 28) && (Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) == 0))
      {
        this.A = 12;
        paramd.e("#1206");
        this.p.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        dk.a(null, 2121);
        return "";
      }
      localObject1 = this.d.j();
      localObject2 = this.c.b();
      if ((this.c.a(this.b)) && (localObject2 != null))
      {
        this.A = 12;
        paramd.e("#1202");
        this.p.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
        dk.a(null, 2121);
        return "";
      }
      if (localObject1 != null)
      {
        this.A = 12;
        if (!this.c.p)
        {
          paramd.e("#1204");
          localObject1 = this.p;
        }
        for (paramd = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";; paramd = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205")
        {
          ((StringBuilder)localObject1).append(paramd);
          break;
          paramd.e("#1205");
          localObject1 = this.p;
        }
        dk.a(null, 2121);
        return "";
      }
      if ((!this.c.p) && (!this.d.m()))
      {
        this.A = 19;
        paramd.e("#1901");
        this.p.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
        dk.a(null, 2133);
        return "";
      }
      if (!dn.g(this.a))
      {
        this.A = 12;
        paramd.e("#1207");
        this.p.append("后台定位服务没有开启，请在设置中打开后台定位服务开关#1207");
        dk.a(null, 2121);
        return "";
      }
      if (!this.c.p)
      {
        paramd.e("#1301");
        localObject1 = this.p;
      }
      for (paramd = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";; paramd = "获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302")
      {
        ((StringBuilder)localObject1).append(paramd);
        break;
        paramd.e("#1302");
        localObject1 = this.p;
      }
      this.A = 13;
      dk.a(null, 2131);
      return "";
    }
    this.v = this.c.g();
    this.w = cu.a(this.v);
    switch (i2)
    {
    default: 
      this.A = 11;
      dk.a(null, 2111);
      paramd.e("#1101");
      this.p.append("get cgi failure#1101");
      break;
    case 2: 
      if (localObject2 == null) {
        break label1403;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((cr)localObject2).a);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(((cr)localObject2).b);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(((cr)localObject2).g);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(((cr)localObject2).h);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(((cr)localObject2).i);
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append("network");
      ((StringBuilder)localObject1).append("#");
      paramd = (d)localObject1;
      if (this.h.isEmpty())
      {
        paramd = (d)localObject1;
        if (this.w) {
          paramd = (d)localObject1;
        } else {
          localObject1 = "cgi";
        }
      }
      break;
    case 1: 
      for (;;)
      {
        localObject1 = "cgiwifi";
        break label1060;
        if (localObject2 == null) {
          break label1403;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((cr)localObject2).a);
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append(((cr)localObject2).b);
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append(((cr)localObject2).c);
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append(((cr)localObject2).d);
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append("network");
        ((StringBuilder)localObject1).append("#");
        paramd = (d)localObject1;
        if (this.h.isEmpty())
        {
          paramd = (d)localObject1;
          if (!this.w) {
            break;
          }
          paramd = (d)localObject1;
        }
      }
    }
    for (;;)
    {
      label1060:
      paramd.append((String)localObject1);
      localObject1 = paramd.toString();
      break label1403;
      if ((this.h.isEmpty()) && (!this.w)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if ((this.w) && (this.h.isEmpty()))
      {
        this.A = 2;
        paramd.e("#0201");
        this.p.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
        dk.a(null, 2021);
        return "";
      }
      if (this.h.size() == 1)
      {
        this.A = 2;
        if (!this.w)
        {
          paramd.e("#0202");
          this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
          dk.a(null, 2022);
          return "";
        }
        localObject1 = ((ScanResult)this.h.get(0)).BSSID;
        if (this.c.g().getBSSID().equals(localObject1))
        {
          paramd.e("#0202");
          this.p.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
          dk.a(null, 2021);
          return "";
        }
      }
      localObject1 = String.format(Locale.US, "#%s#", new Object[] { "network" });
      if (i1 == 0) {
        break;
      }
      paramd = new StringBuilder();
      paramd.append((String)localObject1);
      localObject1 = "wifi";
    }
    if ("network".equals("network"))
    {
      localObject2 = "";
      this.A = 2;
      if (!this.c.p)
      {
        paramd.e("#0203");
        localObject1 = this.p;
      }
      for (paramd = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";; paramd = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204")
      {
        ((StringBuilder)localObject1).append(paramd);
        break;
        paramd.e("#0204");
        localObject1 = this.p;
      }
      dk.a(null, 2022);
      localObject1 = localObject2;
    }
    label1403:
    paramd = (d)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramd = (d)localObject1;
      if (!((String)localObject1).startsWith("#"))
      {
        paramd = new StringBuilder();
        paramd.append("#");
        paramd.append((String)localObject1);
        paramd = paramd.toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(dn.e());
      ((StringBuilder)localObject1).append(paramd);
      paramd = ((StringBuilder)localObject1).toString();
    }
    return paramd;
  }
  
  private void c(co paramco)
  {
    if (paramco != null) {
      this.k = paramco;
    }
  }
  
  private void i()
  {
    if (this.o != null) {}
    for (;;)
    {
      int i2;
      try
      {
        if (this.j == null) {
          this.j = new AMapLocationClientOption();
        }
        AMapLocationClientOption.GeoLanguage localGeoLanguage = this.j.getGeoLanguage();
        i2 = 0;
        i1 = i2;
        if (localGeoLanguage != null) {
          i1 = i2;
        }
        switch (1.a[this.j.getGeoLanguage().ordinal()])
        {
        case 1: 
          this.o.a(this.j.getHttpTimeOut(), this.j.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), i1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      int i1 = i2;
      continue;
      i1 = 2;
      continue;
      i1 = 1;
    }
  }
  
  private void j()
  {
    try
    {
      if (this.i == null) {
        this.i = new a();
      }
      if (this.I == null)
      {
        this.I = new IntentFilter();
        this.I.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.I.addAction("android.net.wifi.SCAN_RESULTS");
      }
      this.a.registerReceiver(this.i, this.I);
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "Aps", "initBroadcastListener");
    }
  }
  
  private boolean k()
  {
    this.h = this.c.c();
    return (this.h == null) || (this.h.size() <= 0);
  }
  
  public final co a(double paramDouble1, double paramDouble2)
  {
    try
    {
      Object localObject = this.o.a(this.a, paramDouble1, paramDouble2);
      if (((String)localObject).contains("\"status\":\"1\""))
      {
        localObject = this.g.a((String)localObject);
        ((co)localObject).setLatitude(paramDouble1);
        ((co)localObject).setLongitude(paramDouble2);
        return (co)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final co a(co paramVarArgs)
  {
    this.E.a(this.t);
    return this.E.a(paramVarArgs);
  }
  
  public final co a(d paramd)
    throws Throwable
  {
    c();
    paramd.d("conitue");
    if (this.a == null)
    {
      paramd.e("#0101");
      this.p.append("context is null#0101");
      return a(1, this.p.toString());
    }
    this.K += 1;
    if ((this.K == 1) && (this.c != null)) {
      this.c.a(this.n);
    }
    long l1 = this.l;
    if (!this.P) {
      this.P = true;
    }
    do
    {
      do
      {
        i1 = 0;
        break;
      } while (dn.b() - l1 >= 800L);
      if (dn.a(this.k)) {
        l1 = dn.a() - this.k.getTime();
      } else {
        l1 = 0L;
      }
    } while (l1 > 10000L);
    int i1 = 1;
    if ((i1 != 0) && (dn.a(this.k)))
    {
      if ((this.t) && (df.b(this.k.getTime()))) {
        this.k.setLocationType(2);
      }
      return this.k;
    }
    if (this.B != null) {
      if (this.C) {
        this.B.a();
      } else {
        this.B.b();
      }
    }
    for (;;)
    {
      try
      {
        if (this.j.isOnceLocationLatest()) {
          break label956;
        }
        if (this.j.isOnceLocation()) {
          break label950;
        }
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "Aps", "getLocation getScanResultsParam");
      }
      this.c.b(bool);
      this.h = this.c.c();
      try
      {
        this.d.a(false, k());
      }
      catch (Throwable localThrowable2)
      {
        dg.a(localThrowable2, "Aps", "getLocation getCgiListParam");
      }
      this.N = c(paramd);
      if (TextUtils.isEmpty(this.N)) {
        return a(this.A, this.p.toString());
      }
      this.x = a(this.x);
      if (this.c.h())
      {
        localObject = a(15, "networkLocation has been mocked!#1502");
        paramd.e("#1502");
        ((co)localObject).setMock(true);
        ((co)localObject).setTrustedLevel(4);
        return (co)localObject;
      }
      if (this.l == 0L) {}
      while (dn.b() - this.l > 20000L)
      {
        bool = true;
        break;
      }
      boolean bool = false;
      Object localObject = this.e.a(this.d, bool, this.k, this.c, this.x, this.N, this.a, false);
      co localco1;
      if (dn.a((co)localObject))
      {
        ((co)localObject).setTrustedLevel(2);
        c((co)localObject);
      }
      else
      {
        localco1 = a(false, true, paramd);
        if (dn.a(localco1))
        {
          localco1.e("new");
          this.e.a(this.x.toString());
          this.e.a(this.d.c());
          c(localco1);
          localObject = localco1;
          if (this.G != null)
          {
            this.G.c(this.d, this.h, localco1);
            localObject = localco1;
          }
        }
        else
        {
          co localco2 = this.e.a(this.d, false, this.k, this.c, this.x, this.N, this.a, true);
          localObject = localco1;
          if (dn.a(localco2))
          {
            paramd.e("#0001");
            localco2.setTrustedLevel(2);
            c(localco2);
            localObject = localco2;
          }
        }
      }
      try
      {
        if ((this.c != null) && (localObject != null))
        {
          l1 = cu.a();
          if (l1 <= 15L) {
            ((co)localObject).setTrustedLevel(1);
          } else if (l1 <= 120L) {
            ((co)localObject).setTrustedLevel(2);
          } else if (l1 <= 600L) {
            ((co)localObject).setTrustedLevel(3);
          } else {
            ((co)localObject).setTrustedLevel(4);
          }
        }
      }
      catch (Throwable paramd)
      {
        float f1;
        for (;;) {}
      }
      if (this.G != null) {
        this.G.b(this.d, this.h, (co)localObject);
      }
      this.e.a(this.N, this.x, (co)localObject, this.a, true);
      paramd = (d)localObject;
      if (!dn.a((co)localObject))
      {
        paramd = (d)localObject;
        if (this.G != null)
        {
          localco1 = this.G.a(this.d, this.h, this.k);
          paramd = (d)localObject;
          if (localco1 != null) {
            paramd = localco1;
          }
        }
      }
      this.x.delete(0, this.x.length());
      if (paramd != null)
      {
        if ((this.C) && (this.B != null))
        {
          paramd.setAltitude(this.B.f);
          paramd.setBearing(this.B.c());
          f1 = (float)this.B.d();
        }
        else
        {
          paramd.setAltitude(0.0D);
          f1 = 0.0F;
          paramd.setBearing(0.0F);
        }
        paramd.setSpeed(f1);
      }
      c(paramd);
      return this.k;
      label950:
      bool = false;
      continue;
      label956:
      bool = true;
    }
  }
  
  public final co a(boolean paramBoolean, d paramd)
  {
    if (paramBoolean) {}
    for (String str = "statics";; str = "first")
    {
      paramd.d(str);
      break;
    }
    if (this.a == null)
    {
      paramd.e("#0101");
      this.p.append("context is null#0101");
      dk.a(null, 2011);
    }
    for (int i1 = 1;; i1 = this.A)
    {
      for (paramd = this.p.toString();; paramd = "networkLocation has been mocked!#1502")
      {
        return a(i1, paramd);
        if (!this.c.h()) {
          break;
        }
        paramd.e("#1502");
        i1 = 15;
      }
      a();
      if (!TextUtils.isEmpty(this.N)) {
        break;
      }
    }
    paramd = a(false, paramBoolean, paramd);
    if (dn.a(paramd))
    {
      this.e.a(this.x.toString());
      this.e.a(this.d.c());
      c(paramd);
    }
    return paramd;
  }
  
  public final void a()
  {
    this.o = db.a(this.a);
    i();
    if (this.b == null) {
      this.b = ((ConnectivityManager)dn.a(this.a, "connectivity"));
    }
    if (this.m == null) {
      this.m = new de();
    }
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (this.a != null) {
        return;
      }
      this.E = new cn();
      this.a = paramContext.getApplicationContext();
      df.c(this.a);
      dn.b(this.a);
      if (this.c == null)
      {
        paramContext = (WifiManager)dn.a(this.a, "wifi");
        this.c = new cu(this.a, paramContext);
      }
      if (this.d == null) {
        this.d = new cs(this.a);
      }
      if (this.e == null) {
        this.e = new cw();
      }
      if (this.g == null) {
        this.g = new dd();
      }
      if (this.G == null) {
        this.G = new ct(this.a);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Aps", "initBase");
    }
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    this.j = paramAMapLocationClientOption;
    if (this.j == null) {
      this.j = new AMapLocationClientOption();
    }
    if (this.c != null)
    {
      localObject = this.c;
      this.j.isWifiActiveScan();
      ((cu)localObject).a(this.j.isWifiScan(), this.j.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), paramAMapLocationClientOption.getScanWifiInterval());
    }
    i();
    if (this.e != null) {
      this.e.a(this.j);
    }
    if (this.g != null) {
      this.g.a(this.j);
    }
    Object localObject = AMapLocationClientOption.GeoLanguage.DEFAULT;
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      boolean bool6;
      boolean bool5;
      boolean bool4;
      boolean bool3;
      try
      {
        paramAMapLocationClientOption = this.j.getGeoLanguage();
      }
      catch (Throwable paramAMapLocationClientOption)
      {
        AMapLocationClientOption localAMapLocationClientOption1;
        continue;
      }
      try
      {
        bool1 = this.j.isNeedAddress();
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      try
      {
        bool2 = this.j.isOffset();
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      try
      {
        bool6 = this.j.isLocationCacheEnable();
      }
      catch (Throwable localThrowable4)
      {
        continue;
      }
      try
      {
        this.u = this.j.isOnceLocationLatest();
        this.C = this.j.isSensorEnable();
        if ((bool2 == this.r) && (bool1 == this.q) && (bool6 == this.t))
        {
          AMapLocationClientOption.GeoLanguage localGeoLanguage = this.s;
          localObject = paramAMapLocationClientOption;
          bool5 = bool2;
          bool4 = bool6;
          bool3 = bool1;
          if (paramAMapLocationClientOption == localGeoLanguage) {}
        }
        else
        {
          try
          {
            if (this.e != null) {
              this.e.a();
            }
            c(null);
            this.P = false;
            localObject = paramAMapLocationClientOption;
            bool5 = bool2;
            bool4 = bool6;
            bool3 = bool1;
            if (this.E == null) {
              continue;
            }
            this.E.a();
            localObject = paramAMapLocationClientOption;
            bool5 = bool2;
            bool4 = bool6;
            bool3 = bool1;
          }
          catch (Throwable localThrowable1)
          {
            dg.a(localThrowable1, "Aps", "cleanCache");
            localAMapLocationClientOption1 = paramAMapLocationClientOption;
            bool5 = bool2;
            bool4 = bool6;
            bool3 = bool1;
          }
          paramAMapLocationClientOption = localAMapLocationClientOption1;
          bool1 = true;
          bool2 = true;
          bool4 = true;
          bool3 = bool1;
          bool5 = bool2;
          localAMapLocationClientOption1 = paramAMapLocationClientOption;
        }
      }
      catch (Throwable localThrowable5)
      {
        AMapLocationClientOption localAMapLocationClientOption2 = paramAMapLocationClientOption;
        bool5 = bool2;
        bool4 = bool6;
        bool3 = bool1;
      }
    }
    this.r = bool5;
    this.q = bool3;
    this.t = bool4;
    this.s = localAMapLocationClientOption1;
  }
  
  public final void b()
  {
    if (this.B == null) {
      this.B = new cp(this.a);
    }
    if (this.f == null) {
      this.f = new cm(this.a);
    }
    j();
    this.c.b(false);
    this.h = this.c.c();
    this.d.a(false, k());
    this.e.a(this.a);
    this.f.b();
    Context localContext = this.a;
    try
    {
      if (localContext.checkCallingOrSelfPermission(w.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
        this.n = true;
      }
      this.z = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final void b(co paramco)
  {
    if (dn.a(paramco)) {
      this.e.a(this.N, this.x, paramco, this.a, true);
    }
  }
  
  public final void b(d paramd)
  {
    try
    {
      if (this.y) {
        return;
      }
      if (this.N != null) {
        this.N = null;
      }
      if (this.x != null) {
        this.x.delete(0, this.x.length());
      }
      if (this.u) {
        j();
      }
      this.c.b(this.u);
      this.h = this.c.c();
      this.d.a(true, k());
      this.N = c(paramd);
      if (!TextUtils.isEmpty(this.N)) {
        this.x = a(this.x);
      }
    }
    catch (Throwable paramd)
    {
      dg.a(paramd, "Aps", "initFirstLocateParam");
    }
    this.y = true;
  }
  
  public final void c()
  {
    if (this.p.length() > 0) {
      this.p.delete(0, this.p.length());
    }
  }
  
  public final void d()
  {
    try
    {
      a(this.a);
      a(this.j);
      d locald = new d();
      b(locald);
      b(a(true, true, locald));
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "Aps", "doFusionLocation");
    }
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 171	com/loc/cl:F	Ljava/lang/String;
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 157	com/loc/cl:y	Z
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 159	com/loc/cl:z	Z
    //   15: aload_0
    //   16: getfield 173	com/loc/cl:G	Lcom/loc/ct;
    //   19: ifnull +10 -> 29
    //   22: aload_0
    //   23: getfield 173	com/loc/cl:G	Lcom/loc/ct;
    //   26: invokevirtual 993	com/loc/ct:d	()V
    //   29: aload_0
    //   30: getfield 99	com/loc/cl:f	Lcom/loc/cm;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 99	com/loc/cl:f	Lcom/loc/cm;
    //   40: invokevirtual 994	com/loc/cm:a	()V
    //   43: aload_0
    //   44: getfield 97	com/loc/cl:e	Lcom/loc/cw;
    //   47: ifnull +14 -> 61
    //   50: aload_0
    //   51: getfield 97	com/loc/cl:e	Lcom/loc/cw;
    //   54: aload_0
    //   55: getfield 89	com/loc/cl:a	Landroid/content/Context;
    //   58: invokevirtual 996	com/loc/cw:b	(Landroid/content/Context;)V
    //   61: aload_0
    //   62: getfield 169	com/loc/cl:E	Lcom/loc/cn;
    //   65: ifnull +10 -> 75
    //   68: aload_0
    //   69: getfield 169	com/loc/cl:E	Lcom/loc/cn;
    //   72: invokevirtual 960	com/loc/cn:a	()V
    //   75: aload_0
    //   76: getfield 101	com/loc/cl:g	Lcom/loc/dd;
    //   79: ifnull +8 -> 87
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 101	com/loc/cl:g	Lcom/loc/dd;
    //   87: aload_0
    //   88: getfield 89	com/loc/cl:a	Landroid/content/Context;
    //   91: ifnull +21 -> 112
    //   94: aload_0
    //   95: getfield 108	com/loc/cl:i	Lcom/loc/cl$a;
    //   98: ifnull +14 -> 112
    //   101: aload_0
    //   102: getfield 89	com/loc/cl:a	Landroid/content/Context;
    //   105: aload_0
    //   106: getfield 108	com/loc/cl:i	Lcom/loc/cl$a;
    //   109: invokevirtual 1000	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 108	com/loc/cl:i	Lcom/loc/cl$a;
    //   117: goto +21 -> 138
    //   120: astore_1
    //   121: goto +94 -> 215
    //   124: astore_1
    //   125: aload_1
    //   126: ldc_w 261
    //   129: ldc_w 1002
    //   132: invokestatic 268	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -23 -> 112
    //   138: aload_0
    //   139: getfield 95	com/loc/cl:d	Lcom/loc/cs;
    //   142: ifnull +10 -> 152
    //   145: aload_0
    //   146: getfield 95	com/loc/cl:d	Lcom/loc/cs;
    //   149: invokevirtual 1004	com/loc/cs:h	()V
    //   152: aload_0
    //   153: getfield 93	com/loc/cl:c	Lcom/loc/cu;
    //   156: ifnull +10 -> 166
    //   159: aload_0
    //   160: getfield 93	com/loc/cl:c	Lcom/loc/cu;
    //   163: invokevirtual 1005	com/loc/cu:j	()V
    //   166: aload_0
    //   167: getfield 106	com/loc/cl:h	Ljava/util/ArrayList;
    //   170: ifnull +10 -> 180
    //   173: aload_0
    //   174: getfield 106	com/loc/cl:h	Ljava/util/ArrayList;
    //   177: invokevirtual 1008	java/util/ArrayList:clear	()V
    //   180: aload_0
    //   181: getfield 165	com/loc/cl:B	Lcom/loc/cp;
    //   184: ifnull +10 -> 194
    //   187: aload_0
    //   188: getfield 165	com/loc/cl:B	Lcom/loc/cp;
    //   191: invokevirtual 1010	com/loc/cp:e	()V
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 115	com/loc/cl:k	Lcom/loc/co;
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield 89	com/loc/cl:a	Landroid/content/Context;
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 155	com/loc/cl:x	Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 177	com/loc/cl:J	Landroid/location/LocationManager;
    //   214: return
    //   215: aload_0
    //   216: aconst_null
    //   217: putfield 108	com/loc/cl:i	Lcom/loc/cl$a;
    //   220: aload_1
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	cl
    //   120	1	1	localObject	Object
    //   124	97	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   87	112	120	finally
    //   125	135	120	finally
    //   87	112	124	java/lang/Throwable
  }
  
  public final void f()
  {
    try
    {
      if (this.f != null) {
        this.f.c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      dg.a(localThrowable, "Aps", "bindAMapService");
    }
  }
  
  public final co g()
  {
    int i1;
    if (this.c.h()) {
      i1 = 15;
    }
    for (Object localObject = "networkLocation has been mocked!#1502";; localObject = this.p.toString())
    {
      return a(i1, (String)localObject);
      if (!TextUtils.isEmpty(this.N)) {
        break;
      }
      i1 = this.A;
    }
    localObject = this.e.a(this.a, this.N, this.x, true);
    if (dn.a((co)localObject)) {
      c((co)localObject);
    }
    return (co)localObject;
  }
  
  public final void h()
  {
    if (this.G != null) {
      this.G.b();
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext != null)
      {
        if (paramIntent == null) {
          return;
        }
        try
        {
          paramContext = paramIntent.getAction();
          if (TextUtils.isEmpty(paramContext)) {
            return;
          }
          if (paramContext.equals("android.net.wifi.SCAN_RESULTS"))
          {
            if (cl.this.c != null) {
              cl.this.c.e();
            }
          }
          else if ((paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")) && (cl.this.c != null)) {
            cl.this.c.f();
          }
          return;
        }
        catch (Throwable paramContext)
        {
          dg.a(paramContext, "Aps", "onReceive");
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */