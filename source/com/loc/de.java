package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.CRC32;

@SuppressLint({"NewApi"})
public final class de
{
  protected static String J;
  protected static String L;
  protected String A = null;
  protected String B = null;
  protected ArrayList<cr> C = new ArrayList();
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
      dg.a(paramString, "Req", "copyContentWithByteLen");
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
      }
      catch (Throwable localThrowable)
      {
        continue;
        localObject1 = localThrowable;
        if (i1 >= 6) {
          continue;
        }
        localThrowable[i1] = "0";
        i1 += 1;
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
    localObject1 = new StringBuilder("getMacBa ");
    ((StringBuilder)localObject1).append(paramString);
    dg.a((Throwable)localObject2, "Req", ((StringBuilder)localObject1).toString());
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
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, cs paramcs, cu paramcu, ConnectivityManager paramConnectivityManager, String paramString1, String paramString2)
  {
    str3 = "0";
    str4 = l.f(paramContext);
    i3 = dn.d();
    this.K = paramString2;
    str1 = "api_serverSDK_130905";
    str2 = "S128DF1572465B890OE3F7A13167KLEI";
    if (!paramBoolean2)
    {
      str1 = "UC_nlp_20131029";
      str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    }
    localStringBuilder1 = new StringBuilder();
    i4 = paramcs.e();
    i1 = paramcs.f();
    localObject1 = paramcs.g();
    localObject3 = paramcs.a();
    localObject2 = paramcs.b();
    localArrayList = paramcu.c();
    if (i1 == 2) {
      str3 = "1";
    }
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(dg.d)) {
        try
        {
          dg.d = p.w(paramContext);
        }
        catch (Throwable paramString2)
        {
          dg.a(paramString2, "Aps", "getApsReq part4");
        }
      }
      if ((TextUtils.isEmpty(dg.d)) && (Build.VERSION.SDK_INT < 29)) {
        dg.d = "888888888888888";
      }
      if (!TextUtils.isEmpty(dg.e)) {}
    }
    try
    {
      try
      {
        dg.e = p.z(paramContext);
      }
      catch (Throwable paramString2)
      {
        dg.a(paramString2, "Aps", "getApsReq part2");
      }
    }
    catch (SecurityException paramcs)
    {
      try
      {
        StringBuilder localStringBuilder2;
        int i2;
        i1 = ((WifiInfo)localObject3).getSSID().getBytes("UTF-8").length;
        break label1087;
        i1 = 32;
        if (i1 < 32) {
          break label1099;
        }
        paramcu = "unkwn";
        ((StringBuilder)localObject2).append(paramcu.replace("*", "."));
        if ((localArrayList == null) || (this.F == null)) {
          break label1167;
        }
        this.F.clear();
        this.F.addAll(localArrayList);
        break label1167;
        paramcu.d();
        if (this.F == null) {
          break label1167;
        }
        this.F.clear();
        this.b = 0;
        if (paramBoolean1) {
          break label1187;
        }
        this.b = ((short)(this.b | 0x2));
        this.c = str1;
        this.d = str2;
        this.f = Build.MODEL;
        paramcu = new StringBuilder("android");
        paramcu.append(Build.VERSION.RELEASE);
        this.g = paramcu.toString();
        this.h = dn.b(paramContext);
        this.i = str3;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = str4;
        this.p = dg.d;
        this.q = dg.e;
        this.s = String.valueOf(i3);
        this.t = dn.j(paramContext);
        this.v = "4.8.0";
        this.w = paramString1;
        this.u = "";
        this.x = ((String)localObject1);
        this.y = paramString2;
        this.z = i4;
        this.A = paramConnectivityManager;
        this.B = localStringBuilder1.toString();
        this.D = paramcs.k();
        this.G = cu.k();
        this.E = ((StringBuilder)localObject2).toString();
      }
      catch (Exception paramcs)
      {
        try
        {
          if (!TextUtils.isEmpty(J)) {
            break label1411;
          }
          J = p.i(paramContext);
        }
        catch (Throwable paramcs)
        {
          try
          {
            if (!TextUtils.isEmpty(L)) {
              break label1427;
            }
            L = p.b(paramContext);
          }
          catch (Throwable paramcs)
          {
            try
            {
              for (;;)
              {
                if (TextUtils.isEmpty(this.N)) {
                  this.N = p.j(paramContext);
                }
                localStringBuilder1.delete(0, localStringBuilder1.length());
                ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
                return;
                paramString2 = paramString2;
                continue;
                localException = localException;
                continue;
                paramcs = paramcs;
                continue;
                paramcs = paramcs;
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
    if ((TextUtils.isEmpty(dg.e)) && (Build.VERSION.SDK_INT < 29)) {
      dg.e = "888888888888888";
    }
    try
    {
      paramString2 = paramConnectivityManager.getActiveNetworkInfo();
    }
    catch (Throwable paramString2)
    {
      dg.a(paramString2, "Aps", "getApsReq part");
      paramString2 = null;
    }
    paramBoolean2 = paramcu.a(paramConnectivityManager);
    if (dn.a(paramString2) != -1)
    {
      localObject1 = dn.b((TelephonyManager)localObject1);
      if (paramBoolean2) {
        paramString2 = "2";
      } else {
        paramString2 = "1";
      }
    }
    else
    {
      localObject1 = "";
      paramString2 = "";
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
        paramConnectivityManager = (cr)((ArrayList)localObject3).get(0);
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
        paramConnectivityManager = (cr)((ArrayList)localObject3).get(0);
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
          cr localcr = (cr)((ArrayList)localObject3).get(i1);
          localStringBuilder1.append(localcr.c);
          localStringBuilder1.append(",");
          localStringBuilder1.append(localcr.d);
          localStringBuilder1.append(",");
          localStringBuilder1.append(localcr.j);
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
    if (paramcu.p) {
      if (paramBoolean2)
      {
        localObject3 = paramcu.g();
        if (cu.a((WifiInfo)localObject3))
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
          paramcu = ((WifiInfo)localObject3).getSSID();
        }
      }
    }
  }
  
  public final byte[] a()
  {
    localObject1 = new String[28];
    localObject1[0] = this.a;
    localObject1[1] = this.c;
    localObject1[2] = this.d;
    localObject1[3] = this.e;
    localObject1[4] = this.f;
    localObject1[5] = this.g;
    localObject1[6] = this.h;
    localObject1[7] = this.i;
    localObject1[8] = this.l;
    localObject1[9] = this.m;
    localObject1[10] = this.n;
    localObject1[11] = this.o;
    localObject1[12] = this.p;
    localObject1[13] = this.q;
    localObject1[14] = this.r;
    localObject1[15] = this.s;
    localObject1[16] = this.t;
    localObject1[17] = this.u;
    localObject1[18] = this.v;
    localObject1[19] = this.w;
    localObject1[20] = this.x;
    localObject1[21] = this.A;
    localObject1[22] = this.B;
    localObject1[23] = this.E;
    localObject1[24] = this.G;
    localObject1[25] = this.H;
    localObject1[26] = J;
    localObject1[27] = this.N;
    i3 = 0;
    while (i3 < 28)
    {
      if (TextUtils.isEmpty(localObject1[i3])) {
        localObject1[i3] = "";
      }
      i3 += 1;
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
    if (TextUtils.isEmpty(this.y)) {}
    while ((!"1".equals(this.y)) && (!"2".equals(this.y)))
    {
      this.y = "0";
      break;
    }
    if (!cs.a(this.z)) {
      this.z = 0;
    }
    if (this.I == null) {
      this.I = new byte[0];
    }
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
    localObject1[0] = dn.j(this.a);
    byte[] arrayOfByte1 = dn.a(this.b, null);
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
      dg.a(localThrowable7, "Req", "buildV4Dot219");
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
      localObject4 = dn.b(b("mcc"));
      System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
      i4 += localObject4.length;
      if (i6 == 1)
      {
        localObject4 = dn.b(b("mnc"));
        System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
        i3 = i4 + localObject4.length;
        localObject4 = dn.b(b("lac"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = dn.c(b("cellid"));
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
        localObject4 = dn.b(b("sid"));
        System.arraycopy(localObject4, 0, localObject1, i4, localObject4.length);
        i3 = i4 + localObject4.length;
        localObject4 = dn.b(b("nid"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = dn.b(b("bid"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = dn.c(b("lon"));
        System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
        i3 += localObject4.length;
        localObject4 = dn.c(b("lat"));
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
      localObject4 = dn.a(0, arrayOfByte2);
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
          localObject4 = dn.b(a("lac", i4));
          System.arraycopy(localObject4, 0, localObject1, i3, localObject4.length);
          i3 += localObject4.length;
          localObject4 = dn.c(a("cellid", i4));
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
          i3 = i6 + i7;
          continue;
          localObject1[i3] = 0;
          i3 += 1;
          i7 = ((ScanResult)localObject5).level;
          if (i7 > 127)
          {
            i6 = 0;
          }
          else
          {
            i6 = i7;
            if (i7 < -128) {
              continue;
            }
          }
          localObject1[i3] = Byte.parseByte(String.valueOf(i6));
          i7 = i3 + 1;
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
          i6 = i3;
          if (i3 > 65535) {
            i6 = 65535;
          }
          localObject6 = dn.a(i6, arrayOfByte2);
          System.arraycopy(localObject6, 0, localObject1, i7, localObject6.length);
          i3 = i7 + localObject6.length;
          localObject5 = dn.a(((ScanResult)localObject5).frequency, arrayOfByte2);
          System.arraycopy(localObject5, 0, localObject1, i3, localObject5.length);
          i3 += localObject5.length;
          i5 += 1;
          continue;
          localObject3 = dn.a(Integer.parseInt(this.G), arrayOfByte2);
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
              break label3520;
            }
            localObject3 = null;
            break label3520;
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
            Object tmp3116_3114 = localObject3;
            tmp3116_3114[0] = 0;
            Object tmp3122_3116 = tmp3116_3114;
            tmp3122_3116[1] = 0;
            tmp3122_3116;
          }
          catch (Throwable localThrowable5)
          {
            try
            {
              boolean bool = TextUtils.isEmpty(this.K);
              if (!bool) {
                localObject3 = dn.a(this.K.length(), arrayOfByte2);
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
                  System.arraycopy(dn.a(0, arrayOfByte2), 0, localObject1, i3, 2);
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
                    Object localObject3 = dn.a(i4, null);
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
                    localObject1 = dn.a(((CRC32)localObject1).getValue());
                    Object localObject5 = new byte[i4 + 8];
                    System.arraycopy(localObject3, 0, localObject5, 0, i4);
                    System.arraycopy(localObject1, 0, localObject5, i4, 8);
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
      if (!((cr)((ArrayList)localObject4).get(0)).p) {
        i5 = i4 - 1;
      }
      localObject1[i3] = ((byte)i5);
      i3 += 1;
      i6 = 0;
      while (i6 < i5)
      {
        localObject6 = (cr)((ArrayList)localObject4).get(i6);
        i4 = i3;
        if (((cr)localObject6).p)
        {
          int i2;
          int i1;
          if ((((cr)localObject6).k != 1) && (((cr)localObject6).k != 3) && (((cr)localObject6).k != 4))
          {
            i4 = i3;
            if (((cr)localObject6).k != 2) {
              break label2104;
            }
            i2 = (byte)((cr)localObject6).k;
            i1 = i2;
            if (((cr)localObject6).n) {
              i1 = (byte)(i2 | 0x8);
            }
            localObject1[i3] = i1;
            i3 += 1;
            arrayOfByte3 = dn.a(((cr)localObject6).a, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.a(((cr)localObject6).g, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.a(((cr)localObject6).h, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.a(((cr)localObject6).i, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.b(((cr)localObject6).f, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i4 = i3 + arrayOfByte3.length;
            arrayOfByte3 = dn.b(((cr)localObject6).e, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i4, arrayOfByte3.length);
            i3 = arrayOfByte3.length;
          }
          else
          {
            i2 = (byte)((cr)localObject6).k;
            i1 = i2;
            if (((cr)localObject6).n) {
              i1 = (byte)(i2 | 0x8);
            }
            localObject1[i3] = i1;
            i3 += 1;
            arrayOfByte3 = dn.a(((cr)localObject6).a, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.a(((cr)localObject6).b, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i3 += arrayOfByte3.length;
            arrayOfByte3 = dn.a(((cr)localObject6).c, arrayOfByte2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
            i4 = i3 + arrayOfByte3.length;
            arrayOfByte3 = dn.b(((cr)localObject6).d, (byte[])localObject2);
            System.arraycopy(arrayOfByte3, 0, localObject1, i4, arrayOfByte3.length);
            i3 = arrayOfByte3.length;
          }
          i4 += i3;
          label2104:
          i3 = ((cr)localObject6).j;
          i7 = 99;
          if (i3 > 127) {
            i3 = i7;
          } else if (i3 < -128) {
            i3 = i7;
          }
          localObject1[i4] = ((byte)i3);
          i3 = i4 + 1;
          byte[] arrayOfByte3 = dn.a(((cr)localObject6).l, arrayOfByte2);
          System.arraycopy(arrayOfByte3, 0, localObject1, i3, arrayOfByte3.length);
          i7 = i3 + arrayOfByte3.length;
          i4 = i7;
          if (Double.valueOf("5.1").doubleValue() >= 5.0D)
          {
            if (((cr)localObject6).k != 3)
            {
              i3 = i7;
              if (((cr)localObject6).k != 4) {
                break label2291;
              }
            }
            i4 = ((cr)localObject6).o;
            i3 = i4;
            if (i4 > 32767) {
              i3 = 32767;
            }
            i4 = i3;
            if (i3 < 0) {
              i4 = 32767;
            }
            localObject6 = dn.a(i4, arrayOfByte2);
            System.arraycopy(localObject6, 0, localObject1, i7, localObject6.length);
            i3 = i7 + localObject6.length;
            break label2291;
          }
        }
        i3 = i4;
        label2291:
        i6 += 1;
      }
    }
    else
    {
      localObject1[i3] = 0;
      i3 += 1;
    }
    if (this.E.length() == 0) {
      localObject1[i3] = 0;
    }
    for (;;)
    {
      i3 += 1;
      break;
      localObject1[i3] = 1;
      i3 += 1;
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
          dg.a(localThrowable8, "Req", "buildV4Dot214");
          localObject1[i3] = 0;
          i3 += 1;
        }
        i4 = i3;
        i6 = Integer.parseInt(localObject2[1]);
        if (i6 <= 127) {
          break label3506;
        }
      }
      catch (Throwable localThrowable1)
      {
        dg.a(localThrowable1, "Req", "buildV4Dot216");
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
      if (dn.c() >= 17) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      l1 = 0L;
      if (i4 != 0) {
        l1 = dn.b() / 1000L;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */