package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public final class kx
{
  int a = 0;
  ArrayList<kw> b = new ArrayList();
  TelephonyManager c = null;
  long d = 0L;
  CellLocation e;
  boolean f = false;
  PhoneStateListener g = null;
  String h = null;
  boolean i = false;
  StringBuilder j = null;
  HandlerThread k = null;
  private Context l;
  private String m = null;
  private ArrayList<kw> n = new ArrayList();
  private int o = -113;
  private kv p = null;
  private Object q;
  private int r = 0;
  private long s = 0L;
  private boolean t = false;
  private Object u = new Object();
  
  public kx(Context paramContext)
  {
    this.l = paramContext;
    if (this.c == null) {
      this.c = ((TelephonyManager)lj.a(this.l, "phone"));
    }
    j();
    this.p = new kv();
  }
  
  private CellLocation a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramObject = lh.a(paramObject, paramString, paramVarArgs);
        if (paramObject != null)
        {
          paramObject = (CellLocation)paramObject;
          boolean bool = b((CellLocation)paramObject);
          if (bool) {
            return (CellLocation)paramObject;
          }
          return null;
        }
      }
      catch (Throwable paramObject)
      {
        return null;
      }
      paramObject = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  private CellLocation a(List<CellInfo> paramList)
  {
    List<CellInfo> localList = null;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localObject = (CellInfo)paramList.get(i1);
        if (localObject != null) {}
        try
        {
          boolean bool = ((CellInfo)localObject).isRegistered();
          if ((localObject instanceof CellInfoCdma))
          {
            localObject = (CellInfoCdma)localObject;
            if (a(((CellInfoCdma)localObject).getCellIdentity()))
            {
              localObject = a((CellInfoCdma)localObject, bool);
              paramList = (List<CellInfo>)localObject;
              break label235;
            }
          }
          else if ((localObject instanceof CellInfoGsm))
          {
            localObject = (CellInfoGsm)localObject;
            if (a(((CellInfoGsm)localObject).getCellIdentity()))
            {
              localObject = a((CellInfoGsm)localObject, bool);
              paramList = (List<CellInfo>)localObject;
              break label235;
            }
          }
          else if ((localObject instanceof CellInfoWcdma))
          {
            localObject = (CellInfoWcdma)localObject;
            if (a(((CellInfoWcdma)localObject).getCellIdentity()))
            {
              localObject = a((CellInfoWcdma)localObject, bool);
              paramList = (List<CellInfo>)localObject;
              break label235;
            }
          }
          else
          {
            if (!(localObject instanceof CellInfoLte)) {
              break;
            }
            localObject = (CellInfoLte)localObject;
            if (a(((CellInfoLte)localObject).getCellIdentity()))
            {
              localObject = a((CellInfoLte)localObject, bool);
              paramList = (List<CellInfo>)localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
        i1 += 1;
      }
      paramList = null;
      label235:
      if (paramList == null) {}
    }
    for (;;)
    {
      try
      {
        if (paramList.k == 2) {
          localObject = new CdmaCellLocation();
        }
      }
      catch (Throwable paramList)
      {
        continue;
      }
      try
      {
        ((CdmaCellLocation)localObject).setCellLocationData(paramList.i, paramList.e, paramList.f, paramList.g, paramList.h);
        paramList = (List<CellInfo>)localObject;
      }
      catch (Throwable paramList) {}
    }
    paramList = (List<CellInfo>)localObject;
    break label333;
    Object localObject = new GsmCellLocation();
    try
    {
      ((GsmCellLocation)localObject).setLacAndCid(paramList.c, paramList.d);
      paramList = (List<CellInfo>)localObject;
    }
    catch (Throwable paramList)
    {
      for (;;)
      {
        paramList = localThrowable;
      }
    }
    paramList = null;
    break label333;
    paramList = null;
    localList = paramList;
    paramList = null;
    label333:
    if (paramList == null) {
      return localList;
    }
    return paramList;
    return null;
  }
  
  private static kw a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    kw localkw = new kw(paramInt1, paramBoolean);
    localkw.a = paramInt2;
    localkw.b = paramInt3;
    localkw.c = paramInt4;
    localkw.d = paramInt5;
    localkw.j = paramInt6;
    return localkw;
  }
  
  @SuppressLint({"NewApi"})
  private kw a(CellInfoCdma paramCellInfoCdma, boolean paramBoolean)
  {
    CellIdentityCdma localCellIdentityCdma = paramCellInfoCdma.getCellIdentity();
    String[] arrayOfString = lj.a(this.c);
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        i2 = Integer.parseInt(arrayOfString[0]);
      }
      catch (Throwable localThrowable1)
      {
        int i3;
        continue;
      }
      try
      {
        i1 = Integer.parseInt(arrayOfString[1]);
        i3 = i1;
      }
      catch (Throwable localThrowable2)
      {
        i1 = i2;
      }
    }
    i1 = 0;
    i3 = 0;
    i2 = i1;
    paramCellInfoCdma = a(2, paramBoolean, i2, i3, 0, 0, paramCellInfoCdma.getCellSignalStrength().getCdmaDbm());
    paramCellInfoCdma.g = localCellIdentityCdma.getSystemId();
    paramCellInfoCdma.h = localCellIdentityCdma.getNetworkId();
    paramCellInfoCdma.i = localCellIdentityCdma.getBasestationId();
    paramCellInfoCdma.e = localCellIdentityCdma.getLatitude();
    paramCellInfoCdma.f = localCellIdentityCdma.getLongitude();
    return paramCellInfoCdma;
  }
  
  @SuppressLint({"NewApi"})
  private static kw a(CellInfoGsm paramCellInfoGsm, boolean paramBoolean)
  {
    CellIdentityGsm localCellIdentityGsm = paramCellInfoGsm.getCellIdentity();
    return a(1, paramBoolean, localCellIdentityGsm.getMcc(), localCellIdentityGsm.getMnc(), localCellIdentityGsm.getLac(), localCellIdentityGsm.getCid(), paramCellInfoGsm.getCellSignalStrength().getDbm());
  }
  
  @SuppressLint({"NewApi"})
  private static kw a(CellInfoLte paramCellInfoLte, boolean paramBoolean)
  {
    CellIdentityLte localCellIdentityLte = paramCellInfoLte.getCellIdentity();
    paramCellInfoLte = a(3, paramBoolean, localCellIdentityLte.getMcc(), localCellIdentityLte.getMnc(), localCellIdentityLte.getTac(), localCellIdentityLte.getCi(), paramCellInfoLte.getCellSignalStrength().getDbm());
    paramCellInfoLte.o = localCellIdentityLte.getPci();
    return paramCellInfoLte;
  }
  
  @SuppressLint({"NewApi"})
  private static kw a(CellInfoWcdma paramCellInfoWcdma, boolean paramBoolean)
  {
    CellIdentityWcdma localCellIdentityWcdma = paramCellInfoWcdma.getCellIdentity();
    paramCellInfoWcdma = a(4, paramBoolean, localCellIdentityWcdma.getMcc(), localCellIdentityWcdma.getMnc(), localCellIdentityWcdma.getLac(), localCellIdentityWcdma.getCid(), paramCellInfoWcdma.getCellSignalStrength().getDbm());
    paramCellInfoWcdma.o = localCellIdentityWcdma.getPsc();
    return paramCellInfoWcdma;
  }
  
  private static kw a(NeighboringCellInfo paramNeighboringCellInfo, String[] paramArrayOfString)
  {
    try
    {
      kw localkw = new kw(1, false);
      localkw.a = Integer.parseInt(paramArrayOfString[0]);
      localkw.b = Integer.parseInt(paramArrayOfString[1]);
      localkw.c = lh.b(paramNeighboringCellInfo, "getLac", new Object[0]);
      localkw.d = paramNeighboringCellInfo.getCid();
      localkw.j = lj.a(paramNeighboringCellInfo.getRssi());
      return localkw;
    }
    catch (Throwable paramNeighboringCellInfo)
    {
      lf.a(paramNeighboringCellInfo, "CgiManager", "getGsm");
    }
    return null;
  }
  
  private void a(CellLocation paramCellLocation, String[] paramArrayOfString)
  {
    if (paramCellLocation != null)
    {
      if (this.c == null) {
        return;
      }
      this.b.clear();
      if (!b(paramCellLocation)) {
        return;
      }
      this.a = 1;
      Object localObject = null;
      this.b.add(c(paramCellLocation, paramArrayOfString));
      paramCellLocation = (CellLocation)localObject;
      if (Build.VERSION.SDK_INT <= 28) {
        paramCellLocation = (List)lh.a(this.c, "getNeighboringCellInfo", new Object[0]);
      }
      if (paramCellLocation != null)
      {
        if (paramCellLocation.isEmpty()) {
          return;
        }
        paramCellLocation = paramCellLocation.iterator();
        while (paramCellLocation.hasNext())
        {
          localObject = (NeighboringCellInfo)paramCellLocation.next();
          if ((localObject != null) && (a(((NeighboringCellInfo)localObject).getLac(), ((NeighboringCellInfo)localObject).getCid())))
          {
            localObject = a((NeighboringCellInfo)localObject, paramArrayOfString);
            if ((localObject != null) && (!this.b.contains(localObject))) {
              this.b.add(localObject);
            }
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 15);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != -1) && (paramInt1 != 0) && (paramInt1 <= 65535) && (paramInt2 != -1) && (paramInt2 != 0) && (paramInt2 != 65535) && (paramInt2 < 268435455);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(CellIdentityCdma paramCellIdentityCdma)
  {
    if (paramCellIdentityCdma == null) {
      return false;
    }
    return (paramCellIdentityCdma.getSystemId() > 0) && (paramCellIdentityCdma.getNetworkId() >= 0) && (paramCellIdentityCdma.getBasestationId() >= 0);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(CellIdentityGsm paramCellIdentityGsm)
  {
    if (paramCellIdentityGsm == null) {
      return false;
    }
    return (c(paramCellIdentityGsm.getLac())) && (d(paramCellIdentityGsm.getCid()));
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(CellIdentityLte paramCellIdentityLte)
  {
    if (paramCellIdentityLte == null) {
      return false;
    }
    return (c(paramCellIdentityLte.getTac())) && (d(paramCellIdentityLte.getCi()));
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(CellIdentityWcdma paramCellIdentityWcdma)
  {
    if (paramCellIdentityWcdma == null) {
      return false;
    }
    return (c(paramCellIdentityWcdma.getLac())) && (d(paramCellIdentityWcdma.getCid()));
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -113)
    {
      this.o = -113;
      return;
    }
    this.o = paramInt;
    switch (this.a)
    {
    default: 
      return;
    }
    if ((this.b != null) && (!this.b.isEmpty())) {}
    try
    {
      ((kw)this.b.get(0)).j = this.o;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void b(CellLocation paramCellLocation, String[] paramArrayOfString)
  {
    if (paramCellLocation == null) {
      return;
    }
    this.b.clear();
    if (lj.c() < 5) {
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject = this.q;
        i2 = 1;
        if (localObject == null) {}
      }
      catch (Throwable paramCellLocation)
      {
        Object localObject;
        int i2;
        lf.a(paramCellLocation, "CgiManager", "hdlCdmaLocChange");
        return;
      }
      try
      {
        localObject = paramCellLocation.getClass().getDeclaredField("mGsmCellLoc");
        if (!((Field)localObject).isAccessible()) {
          ((Field)localObject).setAccessible(true);
        }
        localObject = (GsmCellLocation)((Field)localObject).get(paramCellLocation);
        if ((localObject != null) && (b((CellLocation)localObject)))
        {
          a((CellLocation)localObject, paramArrayOfString);
          i1 = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
        i1 = 0;
      }
    }
    i1 = 0;
    if (i1 != 0) {
      return;
    }
    if (!b(paramCellLocation)) {
      return;
    }
    this.a = 2;
    localObject = new kw(2, true);
    ((kw)localObject).a = Integer.parseInt(paramArrayOfString[0]);
    ((kw)localObject).b = Integer.parseInt(paramArrayOfString[1]);
    ((kw)localObject).g = lh.b(paramCellLocation, "getSystemId", new Object[0]);
    ((kw)localObject).h = lh.b(paramCellLocation, "getNetworkId", new Object[0]);
    ((kw)localObject).i = lh.b(paramCellLocation, "getBaseStationId", new Object[0]);
    ((kw)localObject).j = this.o;
    ((kw)localObject).e = lh.b(paramCellLocation, "getBaseStationLatitude", new Object[0]);
    ((kw)localObject).f = lh.b(paramCellLocation, "getBaseStationLongitude", new Object[0]);
    if ((((kw)localObject).e == ((kw)localObject).f) && (((kw)localObject).e > 0))
    {
      i1 = i2;
      if ((((kw)localObject).e < 0) || (((kw)localObject).f < 0) || (((kw)localObject).e == Integer.MAX_VALUE) || (((kw)localObject).f == Integer.MAX_VALUE) || (i1 != 0))
      {
        ((kw)localObject).e = 0;
        ((kw)localObject).f = 0;
      }
      if (!this.b.contains(localObject)) {
        this.b.add(localObject);
      }
      return;
    }
  }
  
  private boolean b(CellLocation paramCellLocation)
  {
    boolean bool = a(paramCellLocation);
    if (!bool) {
      this.a = 0;
    }
    return bool;
  }
  
  private int c(CellLocation paramCellLocation)
  {
    if (this.i) {
      return 0;
    }
    if (paramCellLocation == null) {
      return 0;
    }
    if ((paramCellLocation instanceof GsmCellLocation)) {
      return 1;
    }
    try
    {
      Class.forName("android.telephony.cdma.CdmaCellLocation");
      return 2;
    }
    catch (Throwable paramCellLocation)
    {
      lf.a(paramCellLocation, "Utils", "getCellLocT");
    }
    return 0;
  }
  
  private kw c(CellLocation paramCellLocation, String[] paramArrayOfString)
  {
    paramCellLocation = (GsmCellLocation)paramCellLocation;
    kw localkw = new kw(1, true);
    localkw.a = lj.d(paramArrayOfString[0]);
    localkw.b = lj.d(paramArrayOfString[1]);
    localkw.c = paramCellLocation.getLac();
    localkw.d = paramCellLocation.getCid();
    localkw.j = this.o;
    return localkw;
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt != -1) && (paramInt != 0) && (paramInt <= 65535);
  }
  
  private static boolean d(int paramInt)
  {
    return (paramInt != -1) && (paramInt != 0) && (paramInt != 65535) && (paramInt < 268435455);
  }
  
  private void j()
  {
    if (this.c == null) {
      return;
    }
    try
    {
      CellLocation localCellLocation = this.c.getCellLocation();
      Context localContext = this.l;
      this.a = c(localCellLocation);
    }
    catch (Throwable localThrowable1)
    {
      this.h = null;
      lf.a(localThrowable1, "CgiManager", "CgiManager");
      this.a = 0;
    }
    catch (SecurityException localSecurityException)
    {
      this.h = localSecurityException.getMessage();
    }
    try
    {
      this.r = u();
      Object localObject;
      switch (this.r)
      {
      case 2: 
        localObject = this.l;
        break;
        localObject = lj.a(this.l, "phone2");
      case 1: 
        for (;;)
        {
          this.q = localObject;
          break;
          localObject = lj.a(this.l, "phone_msim");
          continue;
          localObject = lj.a((Context)localObject, "phone2");
        }
        if (this.k == null)
        {
          this.k = new a("listenerPhoneStateThread");
          this.k.start();
        }
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 6	com/amap/api/mapcore/util/kx$1
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 493	com/amap/api/mapcore/util/kx$1:<init>	(Lcom/amap/api/mapcore/util/kx;)V
    //   9: putfield 78	com/amap/api/mapcore/util/kx:g	Landroid/telephony/PhoneStateListener;
    //   12: invokestatic 403	com/amap/api/mapcore/util/lj:c	()I
    //   15: bipush 7
    //   17: if_icmpge +18 -> 35
    //   20: ldc_w 495
    //   23: astore_2
    //   24: ldc_w 497
    //   27: aload_2
    //   28: invokestatic 500	com/amap/api/mapcore/util/lh:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: istore_1
    //   32: goto +12 -> 44
    //   35: ldc_w 502
    //   38: astore_2
    //   39: goto -15 -> 24
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: ifne +17 -> 62
    //   48: aload_0
    //   49: getfield 66	com/amap/api/mapcore/util/kx:c	Landroid/telephony/TelephonyManager;
    //   52: aload_0
    //   53: getfield 78	com/amap/api/mapcore/util/kx:g	Landroid/telephony/PhoneStateListener;
    //   56: bipush 16
    //   58: invokevirtual 506	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 66	com/amap/api/mapcore/util/kx:c	Landroid/telephony/TelephonyManager;
    //   66: aload_0
    //   67: getfield 78	com/amap/api/mapcore/util/kx:g	Landroid/telephony/PhoneStateListener;
    //   70: iload_1
    //   71: bipush 16
    //   73: ior
    //   74: invokevirtual 506	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   77: return
    //   78: astore_2
    //   79: goto -37 -> 42
    //   82: astore_2
    //   83: return
    //   84: astore_2
    //   85: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	kx
    //   31	43	1	i1	int
    //   23	16	2	str	String
    //   78	1	2	localThrowable1	Throwable
    //   82	1	2	localThrowable2	Throwable
    //   84	1	2	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	78	java/lang/Throwable
    //   48	61	82	java/lang/Throwable
    //   62	77	84	java/lang/Throwable
  }
  
  private CellLocation l()
  {
    if (this.c != null) {
      try
      {
        CellLocation localCellLocation = this.c.getCellLocation();
        this.h = null;
        if (b(localCellLocation))
        {
          this.e = localCellLocation;
          return localCellLocation;
        }
      }
      catch (Throwable localThrowable)
      {
        this.h = null;
        lf.a(localThrowable, "CgiManager", "getCellLocation");
        return null;
      }
      catch (SecurityException localSecurityException)
      {
        this.h = localSecurityException.getMessage();
      }
    }
    return null;
  }
  
  private boolean m()
  {
    if (this.i) {
      return false;
    }
    return lj.b() - this.d >= 10000L;
  }
  
  private void n()
  {
    h();
  }
  
  private void o()
  {
    switch (d())
    {
    default: 
      
    case 2: 
      if (this.b.isEmpty())
      {
        this.a = 0;
        return;
      }
      break;
    case 1: 
      if (this.b.isEmpty()) {
        this.a = 0;
      }
      break;
    }
  }
  
  private void p()
  {
    CellLocation localCellLocation;
    Object localObject;
    if ((!this.i) && (this.c != null))
    {
      localCellLocation = q();
      localObject = localCellLocation;
      if (!b(localCellLocation)) {
        localObject = r();
      }
      if (b((CellLocation)localObject))
      {
        this.e = ((CellLocation)localObject);
        this.s = lj.b();
      }
      else if (lj.b() - this.s > 60000L)
      {
        this.e = null;
        this.b.clear();
        this.n.clear();
      }
    }
    if (!this.f) {
      localObject = this.e;
    }
    this.f = true;
    if (b(this.e))
    {
      localObject = lj.a(this.c);
      localCellLocation = this.e;
      Context localContext = this.l;
      switch (c(localCellLocation))
      {
      default: 
        break;
      case 2: 
        b(this.e, (String[])localObject);
        break;
      case 1: 
        a(this.e, (String[])localObject);
      }
    }
    try
    {
      if (lj.c() >= 18) {
        t();
      }
      if (this.c != null)
      {
        this.m = this.c.getNetworkOperator();
        if (!TextUtils.isEmpty(this.m)) {
          this.a |= 0x8;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  private CellLocation q()
  {
    TelephonyManager localTelephonyManager = this.c;
    Object localObject3 = null;
    if (localTelephonyManager == null) {
      return null;
    }
    Object localObject1 = l();
    if (b((CellLocation)localObject1)) {
      return (CellLocation)localObject1;
    }
    localObject1 = localObject3;
    if (lj.c() >= 18) {
      try
      {
        localObject1 = a(localTelephonyManager.getAllCellInfo());
      }
      catch (SecurityException localSecurityException)
      {
        this.h = localSecurityException.getMessage();
        localObject2 = localObject3;
      }
    }
    if (localObject2 != null) {
      return (CellLocation)localObject2;
    }
    Object localObject2 = a(localTelephonyManager, "getCellLocationExt", new Object[] { Integer.valueOf(1) });
    if (localObject2 != null) {
      return (CellLocation)localObject2;
    }
    localObject2 = a(localTelephonyManager, "getCellLocationGemini", new Object[] { Integer.valueOf(1) });
    if (localObject2 != null) {}
    return (CellLocation)localObject2;
  }
  
  /* Error */
  private CellLocation r()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 405	com/amap/api/mapcore/util/kx:q	Ljava/lang/Object;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_3
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: invokespecial 556	com/amap/api/mapcore/util/kx:s	()Ljava/lang/Class;
    //   19: astore 4
    //   21: aload 4
    //   23: aload_3
    //   24: invokevirtual 559	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   27: ifeq +136 -> 163
    //   30: aload 4
    //   32: aload_3
    //   33: invokevirtual 562	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore_3
    //   37: aload_0
    //   38: aload_3
    //   39: ldc_w 509
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokespecial 552	com/amap/api/mapcore/util/kx:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +5 -> 56
    //   54: aload_1
    //   55: areturn
    //   56: aload_0
    //   57: aload_3
    //   58: ldc_w 509
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: iconst_1
    //   68: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: invokespecial 552	com/amap/api/mapcore/util/kx:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +5 -> 82
    //   80: aload_2
    //   81: areturn
    //   82: aload_0
    //   83: aload_3
    //   84: ldc_w 554
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: iconst_1
    //   94: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokespecial 552	com/amap/api/mapcore/util/kx:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +5 -> 108
    //   106: aload_1
    //   107: areturn
    //   108: aload_0
    //   109: aload_3
    //   110: ldc_w 563
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: iconst_1
    //   120: invokestatic 550	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: invokespecial 552	com/amap/api/mapcore/util/kx:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: aload_2
    //   131: ifnull +32 -> 163
    //   134: aload_2
    //   135: areturn
    //   136: astore_3
    //   137: aload_2
    //   138: astore_1
    //   139: aload_3
    //   140: astore_2
    //   141: goto +12 -> 153
    //   144: astore_2
    //   145: goto +8 -> 153
    //   148: astore_3
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: aload_2
    //   154: ldc_w 340
    //   157: ldc_w 565
    //   160: invokestatic 347	com/amap/api/mapcore/util/lf:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_1
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	kx
    //   6	158	1	localObject1	Object
    //   8	133	2	localObject2	Object
    //   144	6	2	localThrowable1	Throwable
    //   152	2	2	localThrowable2	Throwable
    //   4	106	3	localObject3	Object
    //   136	4	3	localThrowable3	Throwable
    //   148	4	3	localThrowable4	Throwable
    //   19	12	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   82	102	136	java/lang/Throwable
    //   56	76	144	java/lang/Throwable
    //   108	128	144	java/lang/Throwable
    //   15	21	148	java/lang/Throwable
    //   21	50	148	java/lang/Throwable
  }
  
  private Class<?> s()
  {
    ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
    Object localObject;
    switch (this.r)
    {
    default: 
      localObject = null;
      break;
    case 2: 
      localObject = "android.telephony.TelephonyManager2";
      break;
    case 1: 
      localObject = "android.telephony.MSimTelephonyManager";
      break;
    case 0: 
      localObject = "android.telephony.TelephonyManager";
    }
    try
    {
      localObject = localClassLoader.loadClass((String)localObject);
      return (Class<?>)localObject;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "CgiManager", "getSim2TmClass");
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private void t()
  {
    if (this.c == null) {
      return;
    }
    ArrayList localArrayList = this.n;
    kv localkv = this.p;
    Object localObject4 = null;
    Object localObject1;
    try
    {
      localObject1 = this.c.getAllCellInfo();
      try
      {
        this.h = null;
        Object localObject2 = localObject1;
      }
      catch (SecurityException localSecurityException1) {}
      this.h = localSecurityException2.getMessage();
    }
    catch (SecurityException localSecurityException2)
    {
      localObject1 = localObject4;
    }
    Object localObject3 = localObject1;
    if (localObject3 != null)
    {
      int i2 = ((List)localObject3).size();
      if (i2 != 0)
      {
        if (localArrayList != null) {
          localArrayList.clear();
        }
        int i1 = 0;
        while (i1 < i2)
        {
          localObject1 = (CellInfo)((List)localObject3).get(i1);
          if (localObject1 != null) {}
          try
          {
            boolean bool = ((CellInfo)localObject1).isRegistered();
            long l1;
            if ((localObject1 instanceof CellInfoCdma))
            {
              localObject1 = (CellInfoCdma)localObject1;
              if (a(((CellInfoCdma)localObject1).getCellIdentity()))
              {
                localObject1 = a((CellInfoCdma)localObject1, bool);
                l1 = Math.min(65535L, localkv.a((kw)localObject1));
              }
            }
            else
            {
              for (;;)
              {
                ((kw)localObject1).l = ((short)(int)l1);
                localArrayList.add(localObject1);
                break;
                if ((localObject1 instanceof CellInfoGsm))
                {
                  localObject1 = (CellInfoGsm)localObject1;
                  if (!a(((CellInfoGsm)localObject1).getCellIdentity())) {
                    break;
                  }
                  localObject1 = a((CellInfoGsm)localObject1, bool);
                  l1 = Math.min(65535L, localkv.a((kw)localObject1));
                }
                else if ((localObject1 instanceof CellInfoWcdma))
                {
                  localObject1 = (CellInfoWcdma)localObject1;
                  if (!a(((CellInfoWcdma)localObject1).getCellIdentity())) {
                    break;
                  }
                  localObject1 = a((CellInfoWcdma)localObject1, bool);
                  l1 = Math.min(65535L, localkv.a((kw)localObject1));
                }
                else
                {
                  if (!(localObject1 instanceof CellInfoLte)) {
                    break;
                  }
                  localObject1 = (CellInfoLte)localObject1;
                  if (!a(((CellInfoLte)localObject1).getCellIdentity())) {
                    break;
                  }
                  localObject1 = a((CellInfoLte)localObject1, bool);
                  l1 = Math.min(65535L, localkv.a((kw)localObject1));
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
          i1 += 1;
        }
      }
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.a |= 0x4;
      localkv.a(localArrayList);
    }
  }
  
  private int u()
  {
    try
    {
      Class.forName("android.telephony.MSimTelephonyManager");
      this.r = 1;
      if (this.r != 0) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Class.forName("android.telephony.TelephonyManager2");
        this.r = 2;
        return this.r;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  public final ArrayList<kw> a()
  {
    return this.b;
  }
  
  final boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    Context localContext = this.l;
    switch (c(paramCellLocation))
    {
    default: 
      return true;
    case 2: 
      try
      {
        if ((lh.b(paramCellLocation, "getSystemId", new Object[0]) > 0) && (lh.b(paramCellLocation, "getNetworkId", new Object[0]) >= 0))
        {
          int i1 = lh.b(paramCellLocation, "getBaseStationId", new Object[0]);
          if (i1 >= 0) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable localThrowable1)
      {
        paramCellLocation = "cgiUseful Cgi.I_CDMA_T";
      }
    case 1: 
      try
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        boolean bool = a(paramCellLocation.getLac(), paramCellLocation.getCid());
        return bool;
      }
      catch (Throwable localThrowable2)
      {
        paramCellLocation = "cgiUseful Cgi.I_GSM_T";
      }
      lf.a(localThrowable2, "CgiManager", paramCellLocation);
    }
    return true;
  }
  
  public final ArrayList<kw> b()
  {
    return this.n;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final int d()
  {
    return this.a & 0x3;
  }
  
  public final TelephonyManager e()
  {
    return this.c;
  }
  
  public final void f()
  {
    try
    {
      this.i = lj.a(this.l);
      if ((m()) || (this.b.isEmpty()))
      {
        p();
        this.d = lj.b();
      }
      if (this.i)
      {
        n();
        return;
      }
      o();
      return;
    }
    catch (Throwable localThrowable)
    {
      lf.a(localThrowable, "CgiManager", "refresh");
      return;
    }
    catch (SecurityException localSecurityException)
    {
      this.h = localSecurityException.getMessage();
    }
  }
  
  public final void g()
  {
    this.p.a();
    this.s = 0L;
    synchronized (this.u)
    {
      this.t = true;
      if ((this.c != null) && (this.g != null)) {
        try
        {
          this.c.listen(this.g, 0);
        }
        catch (Throwable localThrowable)
        {
          lf.a(localThrowable, "CgiManager", "destroy");
        }
      }
      this.g = null;
      if (this.k != null)
      {
        this.k.quit();
        this.k = null;
      }
      this.o = -113;
      this.c = null;
      this.q = null;
      return;
    }
  }
  
  final void h()
  {
    this.h = null;
    this.e = null;
    this.a = 0;
    this.b.clear();
    this.n.clear();
  }
  
  public final String i()
  {
    return this.m;
  }
  
  final class a
    extends HandlerThread
  {
    public a(String paramString)
    {
      super();
    }
    
    protected final void onLooperPrepared()
    {
      try
      {
        super.onLooperPrepared();
        synchronized (kx.a(kx.this))
        {
          if (!kx.b(kx.this)) {
            kx.c(kx.this);
          }
          return;
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    public final void run()
    {
      try
      {
        super.run();
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            kx.this.c.listen(kx.this.g, 0);
            kx.this.g = null;
            quit();
            return;
          }
          catch (Throwable localThrowable2) {}
          localThrowable1 = localThrowable1;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */