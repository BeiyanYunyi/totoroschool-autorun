package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.CRC32;

@SuppressLint({"NewApi"})
public final class lc
{
  protected static String J;
  protected static String L;
  protected String A = null;
  protected String B = null;
  protected ArrayList<kw> C = new ArrayList();
  protected String D = null;
  protected String E = null;
  protected ArrayList<ScanResult> F = new ArrayList();
  protected String G = null;
  protected String H = null;
  protected byte[] I = null;
  protected String K = null;
  protected String M = null;
  protected String N = null;
  private byte[] O = null;
  private int P = 0;
  public String a = "1";
  protected short b = 0;
  protected String c = null;
  protected String d = null;
  protected String e = null;
  protected String f = null;
  protected String g = null;
  public String h = null;
  public String i = null;
  protected String j = null;
  protected String k = null;
  protected String l = null;
  protected String m = null;
  protected String n = null;
  protected String o = null;
  protected String p = null;
  protected String q = null;
  protected String r = null;
  protected String s = null;
  protected String t = null;
  protected String u = null;
  protected String v = null;
  protected String w = null;
  protected String x = null;
  protected String y = null;
  protected int z = 0;
  
  private static int a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramInt;
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramArrayOfByte[paramInt] = 0;
      }
      else
      {
        i1 = paramInt;
        paramString = paramString.getBytes("GBK");
        i1 = paramInt;
        int i3 = paramString.length;
        int i2 = i3;
        if (i3 > 127) {
          i2 = 127;
        }
        paramArrayOfByte[paramInt] = ((byte)i2);
        paramInt += 1;
        i1 = paramInt;
        System.arraycopy(paramString, 0, paramArrayOfByte, paramInt, i2);
        return paramInt + i2;
      }
    }
    catch (Throwable paramString)
    {
      lf.a(paramString, "Req", "copyContentWithByteLen");
      paramArrayOfByte[i1] = 0;
      paramInt = i1;
    }
    return paramInt + 1;
  }
  
  private String a(String paramString, int paramInt)
  {
    String[] arrayOfString = this.B.split("\\*")[paramInt].split(",");
    if ("lac".equals(paramString)) {
      return arrayOfString[0];
    }
    if ("cellid".equals(paramString)) {
      return arrayOfString[1];
    }
    if ("signal".equals(paramString)) {
      return arrayOfString[2];
    }
    return null;
  }
  
  private byte[] a(String paramString)
  {
    Object localObject2 = paramString.split(":");
    byte[] arrayOfByte = new byte[6];
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (localObject2.length == 6) {
          continue;
        }
        localObject2 = new String[6];
        i1 = 0;
        localObject1 = localObject2;
        if (i1 >= localObject2.length) {
          continue;
        }
        localObject2[i1] = "0";
        i1 += 1;
        continue;
      }
      catch (Throwable localThrowable)
      {
        continue;
        int i1 = 0;
        continue;
      }
      localObject2 = arrayOfByte;
      if (i1 >= localObject1.length) {
        continue;
      }
      if (localObject1[i1].length() > 2) {
        localObject1[i1] = localObject1[i1].substring(0, 2);
      }
      arrayOfByte[i1] = ((byte)Integer.parseInt(localObject1[i1], 16));
      i1 += 1;
    }
    Object localObject1 = new StringBuilder("getMacBa ");
    ((StringBuilder)localObject1).append(paramString);
    lf.a((Throwable)localObject2, "Req", ((StringBuilder)localObject1).toString());
    localObject2 = a("00:00:00:00:00:00");
    return (byte[])localObject2;
  }
  
  private String b(String paramString)
  {
    String str = this.A;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(">");
    if (!str.contains(localStringBuilder.toString())) {
      return "0";
    }
    str = this.A;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(">");
    int i1 = str.indexOf(localStringBuilder.toString());
    str = this.A;
    localStringBuilder = new StringBuilder("</");
    localStringBuilder.append(paramString);
    int i2 = str.indexOf(localStringBuilder.toString());
    return this.A.substring(i1 + paramString.length() + 1, i2);
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = "";
    }
    if (TextUtils.isEmpty(this.c)) {
      this.c = "";
    }
    if (TextUtils.isEmpty(this.d)) {
      this.d = "";
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = "";
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = "";
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = "";
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = "";
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = "";
    }
    if (TextUtils.isEmpty(this.j)) {}
    while ((!"0".equals(this.j)) && (!"2".equals(this.j)))
    {
      this.j = "0";
      break;
    }
    if (TextUtils.isEmpty(this.k)) {}
    while ((!"0".equals(this.k)) && (!"1".equals(this.k)))
    {
      this.k = "0";
      break;
    }
    if (TextUtils.isEmpty(this.l)) {
      this.l = "";
    }
    if (TextUtils.isEmpty(this.m)) {
      this.m = "";
    }
    if (TextUtils.isEmpty(this.n)) {
      this.n = "";
    }
    if (TextUtils.isEmpty(this.o)) {
      this.o = "";
    }
    if (TextUtils.isEmpty(this.p)) {
      this.p = "";
    }
    if (TextUtils.isEmpty(this.q)) {
      this.q = "";
    }
    if (TextUtils.isEmpty(this.r)) {
      this.r = "";
    }
    if (TextUtils.isEmpty(this.s)) {
      this.s = "";
    }
    if (TextUtils.isEmpty(this.t)) {
      this.t = "";
    }
    if (TextUtils.isEmpty(this.u)) {
      this.u = "";
    }
    if (TextUtils.isEmpty(this.v)) {
      this.v = "";
    }
    if (TextUtils.isEmpty(this.w)) {
      this.w = "";
    }
    if (TextUtils.isEmpty(this.x)) {
      this.x = "";
    }
    if (TextUtils.isEmpty(this.y)) {}
    while ((!"1".equals(this.y)) && (!"2".equals(this.y)))
    {
      this.y = "0";
      break;
    }
    if (!kx.a(this.z)) {
      this.z = 0;
    }
    if (TextUtils.isEmpty(this.A)) {
      this.A = "";
    }
    if (TextUtils.isEmpty(this.B)) {
      this.B = "";
    }
    if (TextUtils.isEmpty(this.E)) {
      this.E = "";
    }
    if (TextUtils.isEmpty(this.G)) {
      this.G = "";
    }
    if (TextUtils.isEmpty(this.H)) {
      this.H = "";
    }
    if (TextUtils.isEmpty(J)) {
      J = "";
    }
    if (this.I == null) {
      this.I = new byte[0];
    }
    if (TextUtils.isEmpty(this.N)) {
      this.N = "";
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, kx paramkx, ky paramky, ConnectivityManager paramConnectivityManager, String paramString)
  {
    str3 = "0";
    str4 = fk.f(paramContext);
    i3 = lj.f();
    this.K = paramString;
    str1 = "api_serverSDK_130905";
    str2 = "S128DF1572465B890OE3F7A13167KLEI";
    if (!paramBoolean2)
    {
      str1 = "UC_nlp_20131029";
      str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    }
    localStringBuilder1 = new StringBuilder();
    i4 = paramkx.c();
    i1 = paramkx.d();
    localObject1 = paramkx.e();
    localObject3 = paramkx.a();
    localObject2 = paramkx.b();
    localArrayList = paramky.a();
    if (i1 == 2) {
      str3 = "1";
    }
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(lf.d)) {
        try
        {
          lf.d = fp.w(paramContext);
        }
        catch (Throwable paramString)
        {
          lf.a(paramString, "Aps", "getApsReq part4");
        }
      }
      if ((TextUtils.isEmpty(lf.d)) && (Build.VERSION.SDK_INT < 29)) {
        lf.d = "888888888888888";
      }
      if (!TextUtils.isEmpty(lf.e)) {}
    }
    try
    {
      try
      {
        lf.e = ((TelephonyManager)localObject1).getSubscriberId();
      }
      catch (Throwable paramString)
      {
        lf.a(paramString, "Aps", "getApsReq part2");
      }
    }
    catch (SecurityException paramkx)
    {
      try
      {
        StringBuilder localStringBuilder2;
        int i2;
        i1 = ((WifiInfo)localObject3).getSSID().getBytes("UTF-8").length;
        break label1081;
        i1 = 32;
        if (i1 < 32) {
          break label1093;
        }
        paramky = "unkwn";
        ((StringBuilder)localObject2).append(paramky.replace("*", "."));
        if ((localArrayList == null) || (this.F == null)) {
          break label1161;
        }
        this.F.clear();
        this.F.addAll(localArrayList);
        break label1161;
        paramky.b();
        if (this.F == null) {
          break label1161;
        }
        this.F.clear();
        this.b = 0;
        if (paramBoolean1) {
          break label1181;
        }
        this.b = ((short)(this.b | 0x2));
        this.c = str1;
        this.d = str2;
        this.f = lj.d();
        paramky = new StringBuilder("android");
        paramky.append(lj.e());
        this.g = paramky.toString();
        this.h = lj.b(paramContext);
        this.i = str3;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = str4;
        this.p = lf.d;
        this.q = lf.e;
        this.s = String.valueOf(i3);
        this.t = lj.d(paramContext);
        this.v = "4.7.0";
        this.w = null;
        this.u = "";
        this.x = ((String)localObject1);
        this.y = paramString;
        this.z = i4;
        this.A = paramConnectivityManager;
        this.B = localStringBuilder1.toString();
        this.D = paramkx.i();
        this.G = ky.i();
        this.E = ((StringBuilder)localObject2).toString();
      }
      catch (Exception paramkx)
      {
        try
        {
          if (!TextUtils.isEmpty(J)) {
            break label1403;
          }
          J = fp.i(paramContext);
        }
        catch (Throwable paramkx)
        {
          try
          {
            if (!TextUtils.isEmpty(L)) {
              break label1419;
            }
            L = fp.b(paramContext);
          }
          catch (Throwable paramkx)
          {
            try
            {
              for (;;)
              {
                if (TextUtils.isEmpty(this.N)) {
                  this.N = fp.j(paramContext);
                }
                localStringBuilder1.delete(0, localStringBuilder1.length());
                ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
                return;
                paramString = paramString;
                continue;
                localException = localException;
                continue;
                paramkx = paramkx;
                continue;
                paramkx = paramkx;
              }
            }
            catch (Throwable paramContext)
            {
              for (;;) {}
            }
          }
        }
      }
    }
    if ((TextUtils.isEmpty(lf.e)) && (Build.VERSION.SDK_INT < 29)) {
      lf.e = "888888888888888";
    }
    try
    {
      paramString = paramConnectivityManager.getActiveNetworkInfo();
    }
    catch (Throwable paramString)
    {
      lf.a(paramString, "Aps", "getApsReq part");
      paramString = null;
    }
    paramBoolean2 = paramky.a(paramConnectivityManager);
    if (lj.a(paramString) != -1)
    {
      localObject1 = lj.b((TelephonyManager)localObject1);
      if (paramBoolean2) {
        paramString = "2";
      } else {
        paramString = "1";
      }
    }
    else
    {
      localObject1 = "";
      paramString = "";
    }
    if (!((ArrayList)localObject3).isEmpty())
    {
      localStringBuilder2 = new StringBuilder();
      switch (i1)
      {
      default: 
        paramConnectivityManager = "";
        break;
      case 2: 
        paramConnectivityManager = (kw)((ArrayList)localObject3).get(0);
        localStringBuilder2.delete(0, localStringBuilder2.length());
        localStringBuilder2.append("<mcc>");
        localStringBuilder2.append(paramConnectivityManager.a);
        localStringBuilder2.append("</mcc>");
        localStringBuilder2.append("<sid>");
        localStringBuilder2.append(paramConnectivityManager.g);
        localStringBuilder2.append("</sid>");
        localStringBuilder2.append("<nid>");
        localStringBuilder2.append(paramConnectivityManager.h);
        localStringBuilder2.append("</nid>");
        localStringBuilder2.append("<bid>");
        localStringBuilder2.append(paramConnectivityManager.i);
        localStringBuilder2.append("</bid>");
        if ((paramConnectivityManager.f > 0) && (paramConnectivityManager.e > 0))
        {
          localStringBuilder2.append("<lon>");
          localStringBuilder2.append(paramConnectivityManager.f);
          localStringBuilder2.append("</lon>");
          localStringBuilder2.append("<lat>");
          localStringBuilder2.append(paramConnectivityManager.e);
          localStringBuilder2.append("</lat>");
        }
        localStringBuilder2.append("<signal>");
        localStringBuilder2.append(paramConnectivityManager.j);
        localStringBuilder2.append("</signal>");
        paramConnectivityManager = localStringBuilder2.toString();
        break;
      case 1: 
        paramConnectivityManager = (kw)((ArrayList)localObject3).get(0);
        localStringBuilder2.delete(0, localStringBuilder2.length());
        localStringBuilder2.append("<mcc>");
        localStringBuilder2.append(paramConnectivityManager.a);
        localStringBuilder2.append("</mcc>");
        localStringBuilder2.append("<mnc>");
        localStringBuilder2.append(paramConnectivityManager.b);
        localStringBuilder2.append("</mnc>");
        localStringBuilder2.append("<lac>");
        localStringBuilder2.append(paramConnectivityManager.c);
        localStringBuilder2.append("</lac>");
        localStringBuilder2.append("<cellid>");
        localStringBuilder2.append(paramConnectivityManager.d);
        localStringBuilder2.append("</cellid>");
        localStringBuilder2.append("<signal>");
        localStringBuilder2.append(paramConnectivityManager.j);
        localStringBuilder2.append("</signal>");
        paramConnectivityManager = localStringBuilder2.toString();
        i1 = 1;
        while (i1 < ((ArrayList)localObject3).size())
        {
          kw localkw = (kw)((ArrayList)localObject3).get(i1);
          localStringBuilder1.append(localkw.c);
          localStringBuilder1.append(",");
          localStringBuilder1.append(localkw.d);
          localStringBuilder1.append(",");
          localStringBuilder1.append(localkw.j);
          if (i1 < ((ArrayList)localObject3).size() - 1) {
            localStringBuilder1.append("*");
          }
          i1 += 1;
        }
      }
      localStringBuilder2.delete(0, localStringBuilder2.length());
    }
    else
    {
      paramConnectivityManager = "";
    }
    if (((i4 & 0x4) == 4) && (!((ArrayList)localObject2).isEmpty()))
    {
      this.C.clear();
      this.C.addAll((Collection)localObject2);
    }
    else
    {
      this.C.clear();
    }
    localObject2 = new StringBuilder();
    if (paramky.e()) {
      if (paramBoolean2)
      {
        localObject3 = paramky.f();
        if (ky.a((WifiInfo)localObject3))
        {
          ((StringBuilder)localObject2).append(((WifiInfo)localObject3).getBSSID());
          ((StringBuilder)localObject2).append(",");
          i2 = ((WifiInfo)localObject3).getRssi();
          if (i2 < -128) {}
          do
          {
            i1 = 0;
            break;
            i1 = i2;
          } while (i2 > 127);
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(",");
          paramky = ((WifiInfo)localObject3).getSSID();
        }
      }
    }
  }
  
  public final byte[] a()
  {
    b();
    arrayOfByte2 = new byte[2];
    Object localObject2 = new byte[4];
    localObject1 = this.I;
    i3 = 4096;
    if (localObject1 != null) {
      i3 = 4096 + (this.I.length + 1);
    }
    if ((this.O != null) && (i3 <= this.P))
    {
      localObject1 = this.O;
    }
    else
    {
      localObject1 = new byte[i3];
      this.O = ((byte[])localObject1);
      this.P = i3;
    }
    localObject1[0] = lj.e(this.a);
    byte[] arrayOfByte1 = lj.a(this.b, null);
    System.arraycopy(arrayOfByte1, 0, localObject1, 1, arrayOfByte1.length);
    i3 = arrayOfByte1.length;
    i3 = a(this.c, (byte[])localObject1, i3 + 1);
    i3 = a(this.d, (byte[])localObject1, i3);
    i3 = a(this.o, (byte[])localObject1, i3);
    i3 = a(this.e, (byte[])localObject1, i3);
    i3 = a(this.f, (byte[])localObject1, i3);
    i3 = a(this.g, (byte[])localObject1, i3);
    i3 = a(this.u, (byte[])localObject1, i3);
    i3 = a(this.h, (byte[])localObject1, i3);
    i3 = a(this.p, (byte[])localObject1, i3);
    i4 = a(this.q, (byte[])localObject1, i3);
    i3 = i4;
    try
    {
      if (TextUtils.isEmpty(this.t))
      {
        localObject1[i4] = 0;
        i3 = i4;
      }
      else
      {
        i3 = i4;
        arrayOfByte1 = a(this.t);
        i3 = i4;
        localObject1[i4] = ((byte)arrayOfByte1.length);
        i4 += 1;
        i3 = i4;
        System.arraycopy(arrayOfByte1, 0, localObject1, i4, arrayOfByte1.length);
        i3 = i4;
        i5 = arrayOfByte1.length;
        i3 = i4 + i5;
      }
    }
    catch (Throwable localThrowable7)
    {
      lf.a(localThrowable7, "Req", "buildV4Dot219");
      localObject1[i3] = 0;
      i3 += 1;
    }
    i3 = a(this.v, (byte[])localObject1, i3);
    i3 = a(this.w, (byte[])localObject1, i3);
    i3 = a(J, (byte[])localObject1, i3);
    i3 = a(L, (byte[])localObject1, i3);
    i3 = a(this.x, (byte[])localObject1, i3);
    localObject1[i3] = Byte.parseByte(this.y);
    i3 += 1;
    localObject1[i3] = Byte.parseByte(this.j);
    i3 += 1;
    i6 = this.z & 0x3;
    localObject1[i3] = ((byte)this.z);
    i4 = i3 + 1;
    if (i6 != 1)
    {
      i3 = i4;
      if (i6 != 2) {}
    }
    else
    {
      localObject4 = lj.b(b("mcc"));
      System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
      i4 += localObject4.length;
      if (i6 == 1)
      {
        localObject4 = lj.b(b("mnc"));
        System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
        i3 = i4 + localObject4.length;
        localObject4 = lj.b(b("lac"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = lj.c(b("cellid"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
      }
      for (i4 = localObject4.length;; i4 = localObject4.length)
      {
        i3 += i4;
        break;
        i3 = i4;
        if (i6 != 2) {
          break;
        }
        localObject4 = lj.b(b("sid"));
        System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
        i3 = i4 + localObject4.length;
        localObject4 = lj.b(b("nid"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = lj.b(b("bid"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = lj.c(b("lon"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = lj.c(b("lat"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
      }
      i5 = Integer.parseInt(b("signal"));
      if (i5 > 127) {}
      do
      {
        i4 = 0;
        break;
        i4 = i5;
      } while (i5 < -128);
      localObject1[i3] = ((byte)i4);
      i3 += 1;
      localObject4 = lj.a(0, arrayOfByte2);
      System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
      i4 = i3 + 2;
      if (i6 == 1) {
        if (TextUtils.isEmpty(this.B)) {
          localObject1[i4] = 0;
        }
      }
      for (;;)
      {
        i3 = i4 + 1;
        break;
        i6 = this.B.split("\\*").length;
        localObject1[i4] = ((byte)i6);
        i3 = i4 + 1;
        i4 = 0;
        while (i4 < i6)
        {
          localObject4 = lj.b(a("lac", i4));
          System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
          i3 += localObject4.length;
          localObject4 = lj.c(a("cellid", i4));
          System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
          i7 = i3 + localObject4.length;
          i5 = Integer.parseInt(a("signal", i4));
          if (i5 > 127) {}
          do
          {
            i3 = 0;
            break;
            i3 = i5;
          } while (i5 < -128);
          localObject1[i7] = ((byte)i3);
          i3 = i7 + 1;
          i4 += 1;
        }
        break;
        i3 = i4;
        if (i6 != 2) {
          break;
        }
        localObject1[i4] = 0;
      }
    }
    Object localObject4 = this.D;
    i4 = i3;
    if (localObject4 != null)
    {
      i4 = i3;
      if ((this.z & 0x8) == 8) {
        i4 = i3;
      }
    }
    try
    {
      localObject4 = ((String)localObject4).getBytes("GBK");
      i4 = i3;
      i5 = Math.min(localObject4.length, 60);
      localObject1[i3] = ((byte)i5);
      i3 += 1;
      i4 = i3;
      System.arraycopy(localObject4, 0, localObject1, i3, i5);
      i3 += i5;
    }
    catch (Exception localThrowable5)
    {
      for (;;)
      {
        try
        {
          int i8;
          long l1;
          Object localObject6 = ((ScanResult)localObject5).SSID.getBytes("GBK");
          i3 = i6;
          localObject1[i6] = ((byte)localObject6.length);
          i6 += 1;
          i3 = i6;
          System.arraycopy(localObject6, 0, localObject1, i6, localObject6.length);
          i3 = i6;
          i7 = localObject6.length;
          i6 += i7;
          continue;
          localObject1[i3] = 0;
          i6 = i3 + 1;
          i7 = ((ScanResult)localObject5).level;
          if (i7 > 127)
          {
            i3 = 0;
          }
          else
          {
            i3 = i7;
            if (i7 < -128) {
              i3 = 0;
            }
          }
          localObject1[i6] = Byte.parseByte(String.valueOf(i3));
          i7 = i6 + 1;
          if (i4 != 0)
          {
            i6 = (int)(l1 - (((ScanResult)localObject5).timestamp / 1000000L + 1L));
            i3 = i6;
            if (i6 >= 0) {}
          }
          else
          {
            i3 = 0;
          }
          i6 = 65535;
          if (i3 > 65535) {
            i3 = i6;
          }
          localObject6 = lj.a(i3, arrayOfByte2);
          System.arraycopy(localObject6, 0, localObject1, i7, localObject6.length);
          i3 = i7 + localObject6.length;
          localObject5 = lj.a(((ScanResult)localObject5).frequency, arrayOfByte2);
          System.arraycopy(localObject5, 0, localObject1, i3, localObject5.length);
          i3 += localObject5.length;
          i5 += 1;
          continue;
          localObject3 = lj.a(Integer.parseInt(this.G), arrayOfByte2);
          System.arraycopy(localObject3, 0, localObject1, i3, localObject3.length);
          i3 += localObject3.length;
          localObject1[i3] = 0;
          i4 = i3 + 1;
          i3 = i4;
        }
        catch (Exception localThrowable5)
        {
          try
          {
            localObject5 = this.H.getBytes("GBK");
            i3 = i4;
            localObject3 = localObject5;
            if (localObject5.length <= 127) {
              break label3080;
            }
            localObject3 = null;
            break label3080;
            i3 = i4;
            localObject1[i4] = ((byte)localObject3.length);
            i4 += 1;
            i3 = i4;
            System.arraycopy(localObject3, 0, localObject1, i4, localObject3.length);
            i3 = i4;
            i5 = localObject3.length;
            i3 = i4 + i5;
            continue;
            localObject1[i3] = 0;
            i3 += 1;
            localObject3 = new byte[2];
            Object tmp2674_2672 = localObject3;
            tmp2674_2672[0] = 0;
            Object tmp2680_2674 = tmp2674_2672;
            tmp2680_2674[1] = 0;
            tmp2680_2674;
          }
          catch (Throwable localThrowable5)
          {
            try
            {
              boolean bool = TextUtils.isEmpty(this.K);
              if (!bool) {
                localObject3 = lj.a(this.K.length(), arrayOfByte2);
              }
              System.arraycopy(localObject3, 0, localObject1, i3, 2);
              i4 = i3 + 2;
              i3 = i4;
              if (bool) {}
            }
            catch (Throwable localThrowable5)
            {
              try
              {
                localObject3 = this.K.getBytes("GBK");
                System.arraycopy(localObject3, 0, localObject1, i4, localObject3.length);
                i3 = localObject3.length;
                i3 = i4 + i3;
                continue;
                i3 += 2;
              }
              catch (Throwable localThrowable5)
              {
                try
                {
                  System.arraycopy(lj.a(0, arrayOfByte2), 0, localObject1, i3, 2);
                  i3 += 2;
                }
                catch (Throwable localThrowable5)
                {
                  try
                  {
                    System.arraycopy(new byte[] { 0, 0 }, 0, localObject1, i3, 2);
                    i3 += 2;
                    if (this.I != null) {
                      i4 = this.I.length;
                    } else {
                      i4 = 0;
                    }
                    Object localObject3 = lj.a(i4, null);
                    System.arraycopy(localObject3, 0, localObject1, i3, localObject3.length);
                    i5 = i3 + localObject3.length;
                    i3 = i5;
                    if (i4 > 0)
                    {
                      System.arraycopy(this.I, 0, localObject1, i5, this.I.length);
                      i3 = i5 + this.I.length;
                    }
                    i4 = i3;
                    if (Double.valueOf("5.1").doubleValue() >= 5.0D)
                    {
                      localObject1[i3] = 0;
                      i4 = a(this.N, (byte[])localObject1, i3 + 1);
                    }
                    localObject3 = new byte[i4];
                    System.arraycopy(localObject1, 0, localObject3, 0, i4);
                    localObject1 = new CRC32();
                    ((CRC32)localObject1).update((byte[])localObject3);
                    localObject1 = lj.a(((CRC32)localObject1).getValue());
                    Object localObject5 = new byte[localObject1.length + i4];
                    System.arraycopy(localObject3, 0, localObject5, 0, i4);
                    System.arraycopy(localObject1, 0, localObject5, i4, localObject1.length);
                    return (byte[])localObject5;
                    localException1 = localException1;
                    continue;
                    localException2 = localException2;
                    continue;
                    localThrowable2 = localThrowable2;
                    continue;
                    localThrowable3 = localThrowable3;
                    continue;
                    localThrowable4 = localThrowable4;
                    i3 = i4;
                    continue;
                    localThrowable5 = localThrowable5;
                  }
                  catch (Throwable localThrowable6)
                  {
                    continue;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          i5 = 0;
          break;
          i5 = i6;
          if (i6 >= -128) {
            break;
          }
        }
        if (localThrowable6 == null)
        {
          localObject1[i4] = 0;
          i3 = i4;
        }
      }
    }
    localObject1[i4] = 0;
    i3 = i4 + 1;
    localObject4 = this.C;
    i4 = ((ArrayList)localObject4).size();
    if (((this.z & 0x4) == 4) && (i4 > 0))
    {
      i5 = i4;
      if (!((kw)((ArrayList)localObject4).get(0)).p) {
        i5 = i4 - 1;
      }
      localObject1[i3] = ((byte)i5);
      i3 += 1;
      i6 = 0;
      for (;;)
      {
        i4 = i3;
        if (i6 >= i5) {
          break;
        }
        localObject6 = (kw)((ArrayList)localObject4).get(i6);
        i4 = i3;
        if (((kw)localObject6).p)
        {
          int i2;
          int i1;
          if ((((kw)localObject6).k != 1) && (((kw)localObject6).k != 3) && (((kw)localObject6).k != 4))
          {
            i4 = i3;
            if (((kw)localObject6).k != 2) {
              break label1658;
            }
            i2 = (byte)((kw)localObject6).k;
            i1 = i2;
            if (((kw)localObject6).n) {
              i1 = (byte)(i2 | 0x8);
            }
            localObject1[i3] = i1;
            i3 += 1;
            arrayOfByte3 = lj.a(((kw)localObject6).a, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.a(((kw)localObject6).g, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.a(((kw)localObject6).h, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.a(((kw)localObject6).i, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.b(((kw)localObject6).f, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i4 = i3 + arrayOfByte3.length;
            arrayOfByte3 = lj.b(((kw)localObject6).e, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i4, arrayOfByte3.length);
            i3 = arrayOfByte3.length;
          }
          else
          {
            i2 = (byte)((kw)localObject6).k;
            i1 = i2;
            if (((kw)localObject6).n) {
              i1 = (byte)(i2 | 0x8);
            }
            localObject1[i3] = i1;
            i3 += 1;
            arrayOfByte3 = lj.a(((kw)localObject6).a, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.a(((kw)localObject6).b, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = lj.a(((kw)localObject6).c, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i4 = i3 + arrayOfByte3.length;
            arrayOfByte3 = lj.b(((kw)localObject6).d, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i4, arrayOfByte3.length);
            i3 = arrayOfByte3.length;
          }
          i4 += i3;
          label1658:
          i7 = ((kw)localObject6).j;
          if (i7 > 127) {}
          do
          {
            i3 = 99;
            break;
            i3 = i7;
          } while (i7 < -128);
          localObject1[i4] = ((byte)i3);
          i3 = i4 + 1;
          byte[] arrayOfByte3 = lj.a(((kw)localObject6).l, arrayOfByte2);
          System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
          i7 = i3 + arrayOfByte3.length;
          i4 = i7;
          if (Double.valueOf("5.1").doubleValue() >= 5.0D) {
            if (((kw)localObject6).k != 3)
            {
              i4 = i7;
              if (((kw)localObject6).k != 4) {}
            }
            else
            {
              i4 = ((kw)localObject6).o;
              i3 = i4;
              if (i4 > 32767) {
                i3 = 32767;
              }
              i4 = i3;
              if (i3 < 0) {
                i4 = 32767;
              }
              localObject6 = lj.a(i4, arrayOfByte2);
              System.arraycopy(localObject6, 0, localObject1, i7, localObject6.length);
              i4 = i7 + localObject6.length;
            }
          }
        }
        i6 += 1;
        i3 = i4;
      }
    }
    localObject1[i3] = 0;
    i4 = i3 + 1;
    if (this.E.length() == 0)
    {
      localObject1[i4] = 0;
      i3 = i4;
    }
    for (;;)
    {
      i3 += 1;
      break;
      localObject1[i4] = 1;
      i3 = i4 + 1;
      i4 = i3;
      try
      {
        localObject2 = this.E.split(",");
        i4 = i3;
        localObject4 = a(localObject2[0]);
        i4 = i3;
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i4 = i3;
        i5 = localObject4.length;
        i5 = i3 + i5;
        i3 = i5;
        try
        {
          localObject4 = localObject2[2].getBytes("GBK");
          i3 = i5;
          i6 = localObject4.length;
          i4 = i6;
          if (i6 > 127) {
            i4 = 127;
          }
          localObject1[i5] = ((byte)i4);
          i5 += 1;
          i3 = i5;
          System.arraycopy(localObject4, 0, localObject1, i5, i4);
          i3 = i5 + i4;
        }
        catch (Throwable localThrowable8)
        {
          i4 = i3;
          lf.a(localThrowable8, "Req", "buildV4Dot214");
          localObject1[i3] = 0;
          i3 += 1;
        }
        i4 = i3;
        i6 = Integer.parseInt(localObject2[1]);
        if (i6 <= 127) {
          break label3066;
        }
      }
      catch (Throwable localThrowable1)
      {
        lf.a(localThrowable1, "Req", "buildV4Dot216");
        localObject3 = a("00:00:00:00:00:00");
        System.arraycopy(localObject3, 0, localObject1, i4, localObject3.length);
        i3 = i4 + localObject3.length;
        localObject1[i3] = 0;
        i3 += 1;
        localObject1[i3] = Byte.parseByte("0");
      }
      i4 = i3;
      localObject1[i3] = Byte.parseByte(String.valueOf(i5));
    }
    localObject3 = this.F;
    i8 = Math.min(((ArrayList)localObject3).size(), 25);
    if (i8 == 0)
    {
      localObject1[i3] = 0;
      i3 += 1;
    }
    else
    {
      localObject1[i3] = ((byte)i8);
      i3 += 1;
      if (lj.c() >= 17) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      l1 = 0L;
      if (i4 != 0) {
        l1 = lj.b() / 1000L;
      }
      i5 = 0;
      if (i5 < i8)
      {
        localObject5 = (ScanResult)((ArrayList)localObject3).get(i5);
        localObject6 = a(((ScanResult)localObject5).BSSID);
        System.arraycopy(localObject6, 0, localObject1, i3, localObject6.length);
        i6 = i3 + localObject6.length;
        i3 = i6;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */