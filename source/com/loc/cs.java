package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
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
import android.telephony.TelephonyManager.CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SuppressLint({"NewApi"})
public final class cs
{
  private static boolean u = false;
  int a = 0;
  ArrayList<cr> b = new ArrayList();
  TelephonyManager c = null;
  long d = 0L;
  CellLocation e;
  boolean f = false;
  PhoneStateListener g = null;
  String h = null;
  boolean i = false;
  StringBuilder j = null;
  private Context k;
  private String l = null;
  private ArrayList<cr> m = new ArrayList();
  private int n = -113;
  private cq o = null;
  private Object p;
  private int q = 0;
  private long r = 0L;
  @SuppressLint({"NewApi"})
  private TelephonyManager.CellInfoCallback s;
  private boolean t = false;
  private boolean v = false;
  private Object w = new Object();
  
  public cs(Context paramContext)
  {
    this.k = paramContext;
    if (this.c == null) {
      this.c = ((TelephonyManager)dn.a(this.k, "phone"));
    }
    if (this.c != null) {
      try
      {
        this.a = c(this.c.getCellLocation());
      }
      catch (Throwable paramContext)
      {
        this.h = null;
        dg.a(paramContext, "CgiManager", "CgiManager");
        this.a = 0;
      }
      catch (SecurityException paramContext)
      {
        this.h = paramContext.getMessage();
      }
    }
    try
    {
      this.q = s();
      Context localContext;
      switch (this.q)
      {
      case 2: 
        localContext = this.k;
        break;
        localContext = this.k;
        paramContext = "phone2";
      case 1: 
        for (;;)
        {
          this.p = dn.a(localContext, paramContext);
          break;
          localContext = this.k;
          paramContext = "phone_msim";
          continue;
          paramContext = "phone2";
        }
        aj.d().submit(new Runnable()
        {
          public final void run()
          {
            synchronized (cs.a(cs.this))
            {
              if (!cs.b(cs.this)) {
                cs.c(cs.this);
              }
              return;
            }
          }
        });
        this.o = new cq();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
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
        paramObject = dj.a(paramObject, paramString, paramVarArgs);
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
    Object localObject5 = null;
    if (paramList != null) {}
    for (;;)
    {
      CellInfo localCellInfo;
      try
      {
        if (!paramList.isEmpty()) {
          break label226;
        }
      }
      finally {}
      Object localObject3 = localObject1;
      if (i1 < paramList.size())
      {
        localCellInfo = (CellInfo)paramList.get(i1);
        localObject3 = localObject1;
        if (localCellInfo == null) {}
      }
      try
      {
        localObject3 = a(localCellInfo);
        if (localObject3 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject4 = localObject1;
        continue;
      }
      i1 += 1;
      Object localObject1 = localObject3;
      continue;
      if (localObject3 != null) {}
      try
      {
        if (((cr)localObject3).k == 2) {
          paramList = new CdmaCellLocation();
        }
      }
      catch (Throwable paramList)
      {
        continue;
      }
      try
      {
        paramList.setCellLocationData(((cr)localObject3).i, ((cr)localObject3).e, ((cr)localObject3).f, ((cr)localObject3).g, ((cr)localObject3).h);
        localObject1 = localObject5;
      }
      catch (Throwable localThrowable1)
      {
        continue;
      }
      localObject1 = localObject5;
      continue;
      paramList = new GsmCellLocation();
      try
      {
        paramList.setLacAndCid(((cr)localObject3).c, ((cr)localObject3).d);
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        continue;
      }
      paramList = null;
      localObject1 = localObject5;
      continue;
      paramList = null;
      localObject1 = paramList;
      paramList = null;
      if (paramList == null) {
        return (CellLocation)localObject1;
      }
      return paramList;
      return null;
      label226:
      int i1 = 0;
      Object localObject2 = null;
    }
  }
  
  private static cr a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    cr localcr = new cr(paramInt1, paramBoolean);
    localcr.a = paramInt2;
    localcr.b = paramInt3;
    localcr.c = paramInt4;
    localcr.d = paramInt5;
    localcr.j = paramInt6;
    return localcr;
  }
  
  private cr a(CellInfo paramCellInfo)
  {
    boolean bool = paramCellInfo.isRegistered();
    Object localObject;
    if ((paramCellInfo instanceof CellInfoCdma))
    {
      paramCellInfo = a((CellInfoCdma)paramCellInfo, bool);
    }
    else
    {
      if (!(paramCellInfo instanceof CellInfoGsm)) {
        break label113;
      }
      paramCellInfo = (CellInfoGsm)paramCellInfo;
      if (paramCellInfo == null) {
        break label308;
      }
      if (paramCellInfo.getCellIdentity() == null) {
        return null;
      }
      localObject = paramCellInfo.getCellIdentity();
      if ((!c(((CellIdentityGsm)localObject).getLac())) || (!d(((CellIdentityGsm)localObject).getCid()))) {
        break label308;
      }
      paramCellInfo = a(1, bool, ((CellIdentityGsm)localObject).getMcc(), ((CellIdentityGsm)localObject).getMnc(), ((CellIdentityGsm)localObject).getLac(), ((CellIdentityGsm)localObject).getCid(), paramCellInfo.getCellSignalStrength().getDbm());
    }
    return paramCellInfo;
    label113:
    if ((paramCellInfo instanceof CellInfoWcdma))
    {
      paramCellInfo = (CellInfoWcdma)paramCellInfo;
      if (paramCellInfo != null)
      {
        if (paramCellInfo.getCellIdentity() == null) {
          return null;
        }
        localObject = paramCellInfo.getCellIdentity();
        if ((c(((CellIdentityWcdma)localObject).getLac())) && (d(((CellIdentityWcdma)localObject).getCid()))) {
          paramCellInfo = a(4, bool, ((CellIdentityWcdma)localObject).getMcc(), ((CellIdentityWcdma)localObject).getMnc(), ((CellIdentityWcdma)localObject).getLac(), ((CellIdentityWcdma)localObject).getCid(), paramCellInfo.getCellSignalStrength().getDbm());
        }
      }
    }
    else
    {
      for (int i1 = ((CellIdentityWcdma)localObject).getPsc();; i1 = ((CellIdentityLte)localObject).getPci())
      {
        paramCellInfo.o = i1;
        break;
        if (!(paramCellInfo instanceof CellInfoLte)) {
          break label308;
        }
        paramCellInfo = (CellInfoLte)paramCellInfo;
        if (paramCellInfo == null) {
          break label308;
        }
        if (paramCellInfo.getCellIdentity() == null) {
          return null;
        }
        localObject = paramCellInfo.getCellIdentity();
        if ((!c(((CellIdentityLte)localObject).getTac())) || (!d(((CellIdentityLte)localObject).getCi()))) {
          break label308;
        }
        paramCellInfo = a(3, bool, ((CellIdentityLte)localObject).getMcc(), ((CellIdentityLte)localObject).getMnc(), ((CellIdentityLte)localObject).getTac(), ((CellIdentityLte)localObject).getCi(), paramCellInfo.getCellSignalStrength().getDbm());
      }
    }
    label308:
    return null;
  }
  
  private cr a(CellInfoCdma paramCellInfoCdma, boolean paramBoolean)
  {
    CellIdentityCdma localCellIdentityCdma;
    String[] arrayOfString;
    if (paramCellInfoCdma != null)
    {
      if (paramCellInfoCdma.getCellIdentity() == null) {
        return null;
      }
      localCellIdentityCdma = paramCellInfoCdma.getCellIdentity();
      if ((localCellIdentityCdma.getSystemId() > 0) && (localCellIdentityCdma.getNetworkId() >= 0) && (localCellIdentityCdma.getBasestationId() >= 0))
      {
        localCellIdentityCdma = paramCellInfoCdma.getCellIdentity();
        arrayOfString = dn.a(this.c);
      }
    }
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
    return null;
  }
  
  private static cr a(NeighboringCellInfo paramNeighboringCellInfo, String[] paramArrayOfString)
  {
    try
    {
      cr localcr = new cr(1, false);
      localcr.a = Integer.parseInt(paramArrayOfString[0]);
      localcr.b = Integer.parseInt(paramArrayOfString[1]);
      localcr.c = dj.b(paramNeighboringCellInfo, "getLac", new Object[0]);
      localcr.d = paramNeighboringCellInfo.getCid();
      localcr.j = dn.a(paramNeighboringCellInfo.getRssi());
      return localcr;
    }
    catch (Throwable paramNeighboringCellInfo)
    {
      dg.a(paramNeighboringCellInfo, "CgiManager", "getGsm");
    }
    return null;
  }
  
  private void a(CellLocation paramCellLocation, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramCellLocation != null) {
      try
      {
        if (this.c != null)
        {
          this.b.clear();
          boolean bool = b(paramCellLocation);
          if (!bool) {
            return;
          }
          this.a = 1;
          Object localObject = this.b;
          paramCellLocation = (GsmCellLocation)paramCellLocation;
          cr localcr = new cr(1, true);
          localcr.a = dn.h(paramArrayOfString[0]);
          localcr.b = dn.h(paramArrayOfString[1]);
          localcr.c = paramCellLocation.getLac();
          localcr.d = paramCellLocation.getCid();
          localcr.j = this.n;
          ((ArrayList)localObject).add(localcr);
          if (paramBoolean) {
            return;
          }
          if (Build.VERSION.SDK_INT <= 28)
          {
            paramCellLocation = (List)dj.a(this.c, "getNeighboringCellInfo", new Object[0]);
            if ((paramCellLocation != null) && (!paramCellLocation.isEmpty())) {
              paramCellLocation = paramCellLocation.iterator();
            }
            while (paramCellLocation.hasNext())
            {
              localObject = (NeighboringCellInfo)paramCellLocation.next();
              if ((localObject != null) && (a(((NeighboringCellInfo)localObject).getLac(), ((NeighboringCellInfo)localObject).getCid())))
              {
                localObject = a((NeighboringCellInfo)localObject, paramArrayOfString);
                if ((localObject != null) && (!this.b.contains(localObject)))
                {
                  this.b.add(localObject);
                  continue;
                  return;
                }
              }
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      try
      {
        String[] arrayOfString = dn.a(this.c);
        switch (c(this.e))
        {
        case 2: 
          CellLocation localCellLocation = this.e;
          if (localCellLocation != null)
          {
            this.b.clear();
            try
            {
              localObject2 = this.p;
              i2 = 1;
              if (localObject2 == null) {}
            }
            catch (Throwable localThrowable1)
            {
              Object localObject2;
              int i2;
              dg.a(localThrowable1, "CgiManager", "hdlCdmaLocChange");
            }
          }
          break;
        }
      }
      finally {}
      try
      {
        localObject2 = localCellLocation.getClass().getDeclaredField("mGsmCellLoc");
        if (!((Field)localObject2).isAccessible()) {
          ((Field)localObject2).setAccessible(true);
        }
        localObject2 = (GsmCellLocation)((Field)localObject2).get(localCellLocation);
        if ((localObject2 != null) && (b((CellLocation)localObject2)))
        {
          a((CellLocation)localObject2, arrayOfString, paramBoolean);
          i1 = 1;
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
        continue;
        i1 = 0;
      }
    }
    i1 = 0;
    if (i1 != 0) {
      return;
    }
    paramBoolean = b(localCellLocation);
    if (!paramBoolean) {
      return;
    }
    this.a = 2;
    localObject2 = new cr(2, true);
    ((cr)localObject2).a = Integer.parseInt(arrayOfString[0]);
    ((cr)localObject2).b = Integer.parseInt(arrayOfString[1]);
    ((cr)localObject2).g = dj.b(localCellLocation, "getSystemId", new Object[0]);
    ((cr)localObject2).h = dj.b(localCellLocation, "getNetworkId", new Object[0]);
    ((cr)localObject2).i = dj.b(localCellLocation, "getBaseStationId", new Object[0]);
    ((cr)localObject2).j = this.n;
    ((cr)localObject2).e = dj.b(localCellLocation, "getBaseStationLatitude", new Object[0]);
    ((cr)localObject2).f = dj.b(localCellLocation, "getBaseStationLongitude", new Object[0]);
    if ((((cr)localObject2).e == ((cr)localObject2).f) && (((cr)localObject2).e > 0))
    {
      i1 = i2;
      if ((((cr)localObject2).e < 0) || (((cr)localObject2).f < 0) || (((cr)localObject2).e == Integer.MAX_VALUE) || (((cr)localObject2).f == Integer.MAX_VALUE) || (i1 != 0))
      {
        ((cr)localObject2).e = 0;
        ((cr)localObject2).f = 0;
      }
      if (!this.b.contains(localObject2)) {
        this.b.add(localObject2);
      }
      return;
      a(this.e, localThrowable1, paramBoolean);
      return;
      return;
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
  
  private void b(int paramInt)
  {
    if (paramInt == -113) {
      try
      {
        this.n = -113;
        return;
      }
      finally
      {
        break label95;
      }
    }
    this.n = paramInt;
    switch (this.a)
    {
    case 1: 
    case 2: 
      if (this.b != null)
      {
        boolean bool = this.b.isEmpty();
        if (bool) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        ((cr)this.b.get(0)).j = this.n;
        return;
      }
      catch (Throwable localThrowable)
      {
        label95:
        continue;
      }
      return;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/loc/cs:i	Z
    //   6: istore 6
    //   8: aconst_null
    //   9: astore 8
    //   11: iconst_0
    //   12: istore 4
    //   14: iload 6
    //   16: ifne +176 -> 192
    //   19: aload_0
    //   20: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   23: ifnull +169 -> 192
    //   26: getstatic 395	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 29
    //   31: if_icmplt +77 -> 108
    //   34: aload_0
    //   35: getfield 471	com/loc/cs:s	Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   38: ifnonnull +15 -> 53
    //   41: aload_0
    //   42: new 8	com/loc/cs$a
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 472	com/loc/cs$a:<init>	(Lcom/loc/cs;)V
    //   50: putfield 471	com/loc/cs:s	Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   53: aload_0
    //   54: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   57: invokestatic 144	com/loc/aj:d	()Ljava/util/concurrent/ExecutorService;
    //   60: aload_0
    //   61: getfield 471	com/loc/cs:s	Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   64: invokevirtual 476	android/telephony/TelephonyManager:requestCellInfoUpdate	(Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyManager$CellInfoCallback;)V
    //   67: iload_2
    //   68: ifne +479 -> 547
    //   71: iload_1
    //   72: ifeq +36 -> 108
    //   75: goto +472 -> 547
    //   78: aload_0
    //   79: getfield 91	com/loc/cs:t	Z
    //   82: istore 6
    //   84: iload 6
    //   86: ifne +22 -> 108
    //   89: iload_3
    //   90: bipush 20
    //   92: if_icmpge +16 -> 108
    //   95: ldc2_w 477
    //   98: invokestatic 484	java/lang/Thread:sleep	(J)V
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: istore_3
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: invokespecial 486	com/loc/cs:p	()Landroid/telephony/CellLocation;
    //   112: astore 9
    //   114: aload 9
    //   116: astore 7
    //   118: aload_0
    //   119: aload 9
    //   121: invokespecial 172	com/loc/cs:b	(Landroid/telephony/CellLocation;)Z
    //   124: ifne +9 -> 133
    //   127: aload_0
    //   128: invokespecial 488	com/loc/cs:q	()Landroid/telephony/CellLocation;
    //   131: astore 7
    //   133: aload_0
    //   134: aload 7
    //   136: invokespecial 172	com/loc/cs:b	(Landroid/telephony/CellLocation;)Z
    //   139: ifeq +19 -> 158
    //   142: aload_0
    //   143: aload 7
    //   145: putfield 426	com/loc/cs:e	Landroid/telephony/CellLocation;
    //   148: aload_0
    //   149: invokestatic 491	com/loc/dn:b	()J
    //   152: putfield 85	com/loc/cs:r	J
    //   155: goto +37 -> 192
    //   158: invokestatic 491	com/loc/dn:b	()J
    //   161: aload_0
    //   162: getfield 85	com/loc/cs:r	J
    //   165: lsub
    //   166: ldc2_w 492
    //   169: lcmp
    //   170: ifle +22 -> 192
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 426	com/loc/cs:e	Landroid/telephony/CellLocation;
    //   178: aload_0
    //   179: getfield 69	com/loc/cs:b	Ljava/util/ArrayList;
    //   182: invokevirtual 382	java/util/ArrayList:clear	()V
    //   185: aload_0
    //   186: getfield 73	com/loc/cs:m	Ljava/util/ArrayList;
    //   189: invokevirtual 382	java/util/ArrayList:clear	()V
    //   192: aload_0
    //   193: getfield 87	com/loc/cs:f	Z
    //   196: ifne +58 -> 254
    //   199: aload_0
    //   200: getfield 426	com/loc/cs:e	Landroid/telephony/CellLocation;
    //   203: astore 7
    //   205: aload 7
    //   207: ifnonnull +47 -> 254
    //   210: iload_2
    //   211: ifeq +43 -> 254
    //   214: iconst_0
    //   215: istore_3
    //   216: ldc2_w 494
    //   219: invokestatic 484	java/lang/Thread:sleep	(J)V
    //   222: goto +10 -> 232
    //   225: astore 7
    //   227: aload 7
    //   229: invokevirtual 498	java/lang/InterruptedException:printStackTrace	()V
    //   232: iload_3
    //   233: iconst_1
    //   234: iadd
    //   235: istore 5
    //   237: aload_0
    //   238: getfield 426	com/loc/cs:e	Landroid/telephony/CellLocation;
    //   241: ifnonnull +13 -> 254
    //   244: iload 5
    //   246: istore_3
    //   247: iload 5
    //   249: bipush 50
    //   251: if_icmplt -35 -> 216
    //   254: aload_0
    //   255: iconst_1
    //   256: putfield 87	com/loc/cs:f	Z
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 426	com/loc/cs:e	Landroid/telephony/CellLocation;
    //   264: invokespecial 172	com/loc/cs:b	(Landroid/telephony/CellLocation;)Z
    //   267: ifeq +8 -> 275
    //   270: aload_0
    //   271: iload_1
    //   272: invokespecial 500	com/loc/cs:a	(Z)V
    //   275: invokestatic 502	com/loc/dn:c	()I
    //   278: bipush 18
    //   280: if_icmplt +203 -> 483
    //   283: aload_0
    //   284: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   287: ifnull +196 -> 483
    //   290: aload_0
    //   291: getfield 73	com/loc/cs:m	Ljava/util/ArrayList;
    //   294: astore 10
    //   296: aload_0
    //   297: getfield 79	com/loc/cs:o	Lcom/loc/cq;
    //   300: astore 11
    //   302: aload_0
    //   303: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   306: invokevirtual 506	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   309: astore 7
    //   311: aload_0
    //   312: aconst_null
    //   313: putfield 93	com/loc/cs:h	Ljava/lang/String;
    //   316: goto +27 -> 343
    //   319: astore 8
    //   321: goto +13 -> 334
    //   324: astore 9
    //   326: aload 8
    //   328: astore 7
    //   330: aload 9
    //   332: astore 8
    //   334: aload_0
    //   335: aload 8
    //   337: invokevirtual 130	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   340: putfield 93	com/loc/cs:h	Ljava/lang/String;
    //   343: aload 7
    //   345: ifnull +108 -> 453
    //   348: aload 7
    //   350: invokeinterface 181 1 0
    //   355: istore 5
    //   357: iload 5
    //   359: ifeq +94 -> 453
    //   362: iload 4
    //   364: istore_3
    //   365: aload 10
    //   367: ifnull +11 -> 378
    //   370: aload 10
    //   372: invokevirtual 382	java/util/ArrayList:clear	()V
    //   375: iload 4
    //   377: istore_3
    //   378: iload_3
    //   379: iload 5
    //   381: if_icmpge +72 -> 453
    //   384: aload 7
    //   386: iload_3
    //   387: invokeinterface 185 2 0
    //   392: checkcast 187	android/telephony/CellInfo
    //   395: astore 8
    //   397: aload 8
    //   399: ifnull +47 -> 446
    //   402: aload_0
    //   403: aload 8
    //   405: invokespecial 190	com/loc/cs:a	(Landroid/telephony/CellInfo;)Lcom/loc/cr;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnonnull +6 -> 418
    //   415: goto +31 -> 446
    //   418: aload 8
    //   420: ldc2_w 507
    //   423: aload 11
    //   425: aload 8
    //   427: invokevirtual 511	com/loc/cq:a	(Lcom/loc/cr;)J
    //   430: invokestatic 517	java/lang/Math:min	(JJ)J
    //   433: l2i
    //   434: i2s
    //   435: putfield 520	com/loc/cr:l	S
    //   438: aload 10
    //   440: aload 8
    //   442: invokevirtual 390	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   445: pop
    //   446: iload_3
    //   447: iconst_1
    //   448: iadd
    //   449: istore_3
    //   450: goto -72 -> 378
    //   453: aload 10
    //   455: ifnull +28 -> 483
    //   458: aload 10
    //   460: invokevirtual 521	java/util/ArrayList:size	()I
    //   463: ifle +20 -> 483
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 64	com/loc/cs:a	I
    //   471: iconst_4
    //   472: ior
    //   473: putfield 64	com/loc/cs:a	I
    //   476: aload 11
    //   478: aload 10
    //   480: invokevirtual 524	com/loc/cq:a	(Ljava/util/ArrayList;)V
    //   483: aload_0
    //   484: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   487: ifnull +35 -> 522
    //   490: aload_0
    //   491: aload_0
    //   492: getfield 77	com/loc/cs:c	Landroid/telephony/TelephonyManager;
    //   495: invokevirtual 527	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   498: putfield 71	com/loc/cs:l	Ljava/lang/String;
    //   501: aload_0
    //   502: getfield 71	com/loc/cs:l	Ljava/lang/String;
    //   505: invokestatic 532	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   508: ifne +14 -> 522
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 64	com/loc/cs:a	I
    //   516: bipush 8
    //   518: ior
    //   519: putfield 64	com/loc/cs:a	I
    //   522: aload_0
    //   523: monitorexit
    //   524: return
    //   525: astore 7
    //   527: aload_0
    //   528: monitorexit
    //   529: aload 7
    //   531: athrow
    //   532: astore 7
    //   534: goto -433 -> 101
    //   537: astore 7
    //   539: goto -56 -> 483
    //   542: astore 8
    //   544: goto -98 -> 446
    //   547: iconst_0
    //   548: istore_3
    //   549: goto -471 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	cs
    //   0	552	1	paramBoolean1	boolean
    //   0	552	2	paramBoolean2	boolean
    //   89	460	3	i1	int
    //   12	364	4	i2	int
    //   235	147	5	i3	int
    //   6	79	6	bool	boolean
    //   116	90	7	localCellLocation1	CellLocation
    //   225	3	7	localInterruptedException	InterruptedException
    //   309	76	7	localObject1	Object
    //   525	5	7	localObject2	Object
    //   532	1	7	localThrowable1	Throwable
    //   537	1	7	localThrowable2	Throwable
    //   9	1	8	localObject3	Object
    //   319	8	8	localSecurityException1	SecurityException
    //   332	109	8	localObject4	Object
    //   542	1	8	localThrowable3	Throwable
    //   112	8	9	localCellLocation2	CellLocation
    //   324	7	9	localSecurityException2	SecurityException
    //   294	185	10	localArrayList	ArrayList
    //   300	177	11	localcq	cq
    // Exception table:
    //   from	to	target	type
    //   216	222	225	java/lang/InterruptedException
    //   311	316	319	java/lang/SecurityException
    //   302	311	324	java/lang/SecurityException
    //   2	8	525	finally
    //   19	53	525	finally
    //   53	67	525	finally
    //   78	84	525	finally
    //   95	101	525	finally
    //   108	114	525	finally
    //   118	133	525	finally
    //   133	155	525	finally
    //   158	192	525	finally
    //   192	205	525	finally
    //   216	222	525	finally
    //   227	232	525	finally
    //   237	244	525	finally
    //   254	275	525	finally
    //   275	302	525	finally
    //   302	311	525	finally
    //   311	316	525	finally
    //   334	343	525	finally
    //   348	357	525	finally
    //   370	375	525	finally
    //   384	397	525	finally
    //   402	410	525	finally
    //   418	446	525	finally
    //   458	483	525	finally
    //   483	522	525	finally
    //   95	101	532	java/lang/Throwable
    //   275	302	537	java/lang/Throwable
    //   302	311	537	java/lang/Throwable
    //   311	316	537	java/lang/Throwable
    //   334	343	537	java/lang/Throwable
    //   348	357	537	java/lang/Throwable
    //   370	375	537	java/lang/Throwable
    //   384	397	537	java/lang/Throwable
    //   458	483	537	java/lang/Throwable
    //   402	410	542	java/lang/Throwable
    //   418	446	542	java/lang/Throwable
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
      dg.a(paramCellLocation, "Utils", "getCellLocT");
    }
    return 0;
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt != -1) && (paramInt != 0) && (paramInt <= 65535);
  }
  
  private static boolean d(int paramInt)
  {
    return (paramInt != -1) && (paramInt != 0) && (paramInt != 65535) && (paramInt < 268435455);
  }
  
  private CellLocation n()
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
        dg.a(localThrowable, "CgiManager", "getCellLocation");
        return null;
      }
      catch (SecurityException localSecurityException)
      {
        this.h = localSecurityException.getMessage();
      }
    }
    return null;
  }
  
  private void o()
  {
    for (;;)
    {
      try
      {
        switch (this.a & 0x3)
        {
        case 2: 
          if (this.b.isEmpty()) {
            this.a = 0;
          }
          break;
        case 1: 
          if (this.b.isEmpty())
          {
            this.a = 0;
            return;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  @SuppressLint({"NewApi"})
  private CellLocation p()
  {
    TelephonyManager localTelephonyManager = this.c;
    Object localObject3 = null;
    if (localTelephonyManager == null) {
      return null;
    }
    Object localObject1 = localObject3;
    if (dn.c() >= 18) {
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
    Object localObject2 = n();
    if (b((CellLocation)localObject2)) {
      return (CellLocation)localObject2;
    }
    localObject2 = a(localTelephonyManager, "getCellLocationExt", new Object[] { Integer.valueOf(1) });
    if (localObject2 != null) {
      return (CellLocation)localObject2;
    }
    localObject2 = a(localTelephonyManager, "getCellLocationGemini", new Object[] { Integer.valueOf(1) });
    if (localObject2 != null) {}
    return (CellLocation)localObject2;
  }
  
  /* Error */
  private CellLocation q()
  {
    // Byte code:
    //   0: getstatic 572	com/loc/cs:u	Z
    //   3: ifne +19 -> 22
    //   6: invokestatic 575	com/loc/dg:b	()Lcom/loc/v;
    //   9: ldc_w 577
    //   12: ldc_w 579
    //   15: invokestatic 582	com/loc/aj:b	(Lcom/loc/v;Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_1
    //   19: putstatic 572	com/loc/cs:u	Z
    //   22: aload_0
    //   23: getfield 137	com/loc/cs:p	Ljava/lang/Object;
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_3
    //   32: aload 4
    //   34: ifnonnull +5 -> 39
    //   37: aconst_null
    //   38: areturn
    //   39: aload_3
    //   40: astore_1
    //   41: aload_0
    //   42: invokespecial 584	com/loc/cs:r	()Ljava/lang/Class;
    //   45: astore 5
    //   47: aload_3
    //   48: astore_1
    //   49: aload 5
    //   51: aload 4
    //   53: invokevirtual 587	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   56: ifeq +147 -> 203
    //   59: aload_3
    //   60: astore_1
    //   61: aload 5
    //   63: aload 4
    //   65: invokevirtual 590	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: astore 4
    //   70: aload_3
    //   71: astore_1
    //   72: aload_0
    //   73: aload 4
    //   75: ldc_w 558
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokespecial 568	com/loc/cs:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +5 -> 92
    //   90: aload_2
    //   91: areturn
    //   92: aload_0
    //   93: aload 4
    //   95: ldc_w 558
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: iconst_1
    //   105: invokestatic 566	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokespecial 568	com/loc/cs:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +5 -> 119
    //   117: aload_1
    //   118: areturn
    //   119: aload_0
    //   120: aload 4
    //   122: ldc_w 570
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 566	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: invokespecial 568	com/loc/cs:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +5 -> 146
    //   144: aload_2
    //   145: areturn
    //   146: aload_0
    //   147: aload 4
    //   149: ldc_w 591
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: iconst_1
    //   159: invokestatic 566	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokespecial 568	com/loc/cs:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    //   166: astore_1
    //   167: aload_1
    //   168: astore_2
    //   169: aload_1
    //   170: ifnull +33 -> 203
    //   173: aload_1
    //   174: areturn
    //   175: astore_3
    //   176: aload_2
    //   177: astore_1
    //   178: aload_3
    //   179: astore_2
    //   180: goto +12 -> 192
    //   183: astore_3
    //   184: aload_2
    //   185: astore_1
    //   186: aload_3
    //   187: astore_2
    //   188: goto +4 -> 192
    //   191: astore_2
    //   192: aload_2
    //   193: ldc 121
    //   195: ldc_w 593
    //   198: invokestatic 126	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_1
    //   202: astore_2
    //   203: aload_2
    //   204: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	cs
    //   40	162	1	localObject1	Object
    //   29	159	2	localObject2	Object
    //   191	2	2	localThrowable1	Throwable
    //   202	2	2	localObject3	Object
    //   31	40	3	localObject4	Object
    //   175	4	3	localThrowable2	Throwable
    //   183	4	3	localThrowable3	Throwable
    //   26	122	4	localObject5	Object
    //   45	17	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   146	167	175	java/lang/Throwable
    //   92	113	183	java/lang/Throwable
    //   41	47	191	java/lang/Throwable
    //   49	59	191	java/lang/Throwable
    //   61	70	191	java/lang/Throwable
    //   72	86	191	java/lang/Throwable
    //   119	140	191	java/lang/Throwable
  }
  
  private Class<?> r()
  {
    ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
    Object localObject;
    switch (this.q)
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
      dg.a(localThrowable, "CgiManager", "getSim2TmClass");
    }
    return null;
  }
  
  private int s()
  {
    try
    {
      Class.forName("android.telephony.MSimTelephonyManager");
      this.q = 1;
      if (this.q != 0) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Class.forName("android.telephony.TelephonyManager2");
        this.q = 2;
        return this.q;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
    }
  }
  
  public final ArrayList<cr> a()
  {
    try
    {
      ArrayList localArrayList = this.b;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 103	com/loc/cs:k	Landroid/content/Context;
    //   7: invokestatic 616	com/loc/dn:a	(Landroid/content/Context;)Z
    //   10: putfield 95	com/loc/cs:i	Z
    //   13: aload_0
    //   14: getfield 95	com/loc/cs:i	Z
    //   17: istore 4
    //   19: iconst_0
    //   20: istore_3
    //   21: iload 4
    //   23: ifeq +6 -> 29
    //   26: goto +21 -> 47
    //   29: invokestatic 491	com/loc/dn:b	()J
    //   32: aload_0
    //   33: getfield 81	com/loc/cs:d	J
    //   36: lsub
    //   37: ldc2_w 617
    //   40: lcmp
    //   41: ifge +93 -> 134
    //   44: goto +3 -> 47
    //   47: iload_3
    //   48: ifne +13 -> 61
    //   51: aload_0
    //   52: getfield 69	com/loc/cs:b	Ljava/util/ArrayList;
    //   55: invokevirtual 465	java/util/ArrayList:isEmpty	()Z
    //   58: ifeq +16 -> 74
    //   61: aload_0
    //   62: iload_1
    //   63: iload_2
    //   64: invokespecial 620	com/loc/cs:b	(ZZ)V
    //   67: aload_0
    //   68: invokestatic 491	com/loc/dn:b	()J
    //   71: putfield 81	com/loc/cs:d	J
    //   74: aload_0
    //   75: getfield 95	com/loc/cs:i	Z
    //   78: ifeq +10 -> 88
    //   81: aload_0
    //   82: invokevirtual 622	com/loc/cs:i	()V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: invokespecial 624	com/loc/cs:o	()V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore 5
    //   97: goto +32 -> 129
    //   100: astore 5
    //   102: aload 5
    //   104: ldc 121
    //   106: ldc_w 626
    //   109: invokestatic 126	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore 5
    //   117: aload_0
    //   118: aload 5
    //   120: invokevirtual 130	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   123: putfield 93	com/loc/cs:h	Ljava/lang/String;
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: aload_0
    //   130: monitorexit
    //   131: aload 5
    //   133: athrow
    //   134: iconst_1
    //   135: istore_3
    //   136: goto -89 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	cs
    //   0	139	1	paramBoolean1	boolean
    //   0	139	2	paramBoolean2	boolean
    //   20	116	3	i1	int
    //   17	5	4	bool	boolean
    //   95	1	5	localObject	Object
    //   100	3	5	localThrowable	Throwable
    //   115	17	5	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   2	19	95	finally
    //   29	44	95	finally
    //   51	61	95	finally
    //   61	74	95	finally
    //   74	85	95	finally
    //   88	92	95	finally
    //   102	112	95	finally
    //   117	126	95	finally
    //   2	19	100	java/lang/Throwable
    //   29	44	100	java/lang/Throwable
    //   51	61	100	java/lang/Throwable
    //   61	74	100	java/lang/Throwable
    //   74	85	100	java/lang/Throwable
    //   88	92	100	java/lang/Throwable
    //   2	19	115	java/lang/SecurityException
    //   29	44	115	java/lang/SecurityException
    //   51	61	115	java/lang/SecurityException
    //   61	74	115	java/lang/SecurityException
    //   74	85	115	java/lang/SecurityException
    //   88	92	115	java/lang/SecurityException
  }
  
  final boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    switch (c(paramCellLocation))
    {
    default: 
      return true;
    case 2: 
      try
      {
        if ((dj.b(paramCellLocation, "getSystemId", new Object[0]) > 0) && (dj.b(paramCellLocation, "getNetworkId", new Object[0]) >= 0))
        {
          int i1 = dj.b(paramCellLocation, "getBaseStationId", new Object[0]);
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
      dg.a(localThrowable2, "CgiManager", paramCellLocation);
    }
    return true;
  }
  
  public final ArrayList<cr> b()
  {
    return this.m;
  }
  
  public final cr c()
  {
    try
    {
      boolean bool = this.i;
      if (bool) {
        return null;
      }
      Object localObject1 = this.b;
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = (cr)((ArrayList)localObject1).get(0);
        return (cr)localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public final cr d()
  {
    try
    {
      boolean bool = this.i;
      if (bool) {
        return null;
      }
      Object localObject1 = this.m;
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = (cr)((ArrayList)localObject1).get(0);
        return (cr)localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public final int e()
  {
    return this.a;
  }
  
  public final int f()
  {
    return this.a & 0x3;
  }
  
  public final TelephonyManager g()
  {
    return this.c;
  }
  
  public final void h()
  {
    this.o.a();
    this.r = 0L;
    synchronized (this.w)
    {
      this.v = true;
      if ((this.c != null) && (this.g != null)) {
        try
        {
          this.c.listen(this.g, 0);
        }
        catch (Throwable localThrowable)
        {
          dg.a(localThrowable, "CgiManager", "destroy");
        }
      }
      this.g = null;
      this.n = -113;
      this.c = null;
      this.p = null;
      return;
    }
  }
  
  final void i()
  {
    try
    {
      this.h = null;
      this.e = null;
      this.a = 0;
      this.b.clear();
      this.m.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String j()
  {
    return this.h;
  }
  
  public final String k()
  {
    return this.l;
  }
  
  public final String l()
  {
    try
    {
      if (this.i) {
        i();
      }
      if (this.j == null) {
        this.j = new StringBuilder();
      } else {
        this.j.delete(0, this.j.length());
      }
      int i2 = this.a;
      int i1 = 1;
      if ((i2 & 0x3) == 1) {
        while (i1 < this.b.size())
        {
          localObject1 = this.j;
          ((StringBuilder)localObject1).append("#");
          ((StringBuilder)localObject1).append(((cr)this.b.get(i1)).b);
          localObject1 = this.j;
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(((cr)this.b.get(i1)).c);
          localObject1 = this.j;
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(((cr)this.b.get(i1)).d);
          i1 += 1;
        }
      }
      if (this.j.length() > 0) {
        this.j.deleteCharAt(0);
      }
      Object localObject1 = this.j.toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public final boolean m()
  {
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          if (!TextUtils.isEmpty(this.c.getSimOperator())) {
            return true;
          }
          boolean bool = TextUtils.isEmpty(this.c.getSimCountryIso());
          if (!bool) {
            return true;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int i1;
        continue;
      }
      try
      {
        i1 = dn.a(dn.c(this.k));
        if ((i1 == 0) || (i1 == 4) || (i1 == 2) || (i1 == 5) || (i1 == 3)) {
          return true;
        }
      }
      catch (Throwable localThrowable2) {}
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  final class a
    extends TelephonyManager.CellInfoCallback
  {
    a() {}
    
    public final void onCellInfo(List<CellInfo> paramList)
    {
      cs.d(cs.this);
      paramList = cs.a(cs.this, paramList);
      if (paramList != null)
      {
        cs.this.e = paramList;
        cs.this.f = true;
        cs.e(cs.this);
        cs.a(cs.this, dn.b());
      }
    }
  }
  
  final class b
    extends PhoneStateListener
  {
    b() {}
    
    public final void onCellLocationChanged(CellLocation paramCellLocation)
    {
      try
      {
        if (!cs.this.a(paramCellLocation)) {
          return;
        }
        cs.this.e = paramCellLocation;
        cs.this.f = true;
        cs.e(cs.this);
        cs.a(cs.this, dn.b());
        return;
      }
      catch (Throwable paramCellLocation) {}
    }
    
    public final void onServiceStateChanged(ServiceState paramServiceState)
    {
      try
      {
        switch (paramServiceState.getState())
        {
        case 1: 
          cs.this.i();
          return;
        }
      }
      catch (Throwable paramServiceState)
      {
        return;
      }
      cs.this.a(false, false);
      return;
    }
    
    public final void onSignalStrengthChanged(int paramInt)
    {
      int i = -113;
      for (;;)
      {
        try
        {
          switch (cs.this.a)
          {
          case 1: 
          case 2: 
            paramInt = dn.a(paramInt);
            cs.a(cs.this, paramInt);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          return;
        }
        paramInt = i;
      }
    }
    
    public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      if (paramSignalStrength == null) {
        return;
      }
      int i = -113;
      for (;;)
      {
        try
        {
          switch (cs.this.a)
          {
          case 2: 
            i = paramSignalStrength.getCdmaDbm();
            break;
          case 1: 
            i = dn.a(paramSignalStrength.getGsmSignalStrength());
            cs.a(cs.this, i);
            return;
          }
        }
        catch (Throwable paramSignalStrength)
        {
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */