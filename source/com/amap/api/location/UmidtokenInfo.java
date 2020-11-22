package com.amap.api.location;

import android.os.Handler;
import com.loc.dg;

public class UmidtokenInfo
{
  static Handler a = new Handler();
  static String b = null;
  static boolean c = true;
  private static AMapLocationClient d;
  private static long e = 30000L;
  
  public static String getUmidtoken()
  {
    return b;
  }
  
  public static void setLocAble(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  /* Error */
  public static void setUmidtoken(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: putstatic 29	com/amap/api/location/UmidtokenInfo:b	Ljava/lang/String;
    //   7: aload_1
    //   8: invokestatic 53	com/loc/p:a	(Ljava/lang/String;)V
    //   11: getstatic 40	com/amap/api/location/UmidtokenInfo:d	Lcom/amap/api/location/AMapLocationClient;
    //   14: ifnonnull +85 -> 99
    //   17: getstatic 35	com/amap/api/location/UmidtokenInfo:c	Z
    //   20: ifeq +79 -> 99
    //   23: new 8	com/amap/api/location/UmidtokenInfo$a
    //   26: dup
    //   27: invokespecial 54	com/amap/api/location/UmidtokenInfo$a:<init>	()V
    //   30: astore_1
    //   31: new 56	com/amap/api/location/AMapLocationClient
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 59	com/amap/api/location/AMapLocationClient:<init>	(Landroid/content/Context;)V
    //   39: putstatic 40	com/amap/api/location/UmidtokenInfo:d	Lcom/amap/api/location/AMapLocationClient;
    //   42: new 61	com/amap/api/location/AMapLocationClientOption
    //   45: dup
    //   46: invokespecial 62	com/amap/api/location/AMapLocationClientOption:<init>	()V
    //   49: astore_0
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual 66	com/amap/api/location/AMapLocationClientOption:setOnceLocation	(Z)Lcom/amap/api/location/AMapLocationClientOption;
    //   55: pop
    //   56: aload_0
    //   57: iconst_0
    //   58: invokevirtual 69	com/amap/api/location/AMapLocationClientOption:setNeedAddress	(Z)Lcom/amap/api/location/AMapLocationClientOption;
    //   61: pop
    //   62: getstatic 40	com/amap/api/location/UmidtokenInfo:d	Lcom/amap/api/location/AMapLocationClient;
    //   65: aload_0
    //   66: invokevirtual 73	com/amap/api/location/AMapLocationClient:setLocationOption	(Lcom/amap/api/location/AMapLocationClientOption;)V
    //   69: getstatic 40	com/amap/api/location/UmidtokenInfo:d	Lcom/amap/api/location/AMapLocationClient;
    //   72: aload_1
    //   73: invokevirtual 77	com/amap/api/location/AMapLocationClient:setLocationListener	(Lcom/amap/api/location/AMapLocationListener;)V
    //   76: getstatic 40	com/amap/api/location/UmidtokenInfo:d	Lcom/amap/api/location/AMapLocationClient;
    //   79: invokevirtual 80	com/amap/api/location/AMapLocationClient:startLocation	()V
    //   82: getstatic 27	com/amap/api/location/UmidtokenInfo:a	Landroid/os/Handler;
    //   85: new 6	com/amap/api/location/UmidtokenInfo$1
    //   88: dup
    //   89: invokespecial 81	com/amap/api/location/UmidtokenInfo$1:<init>	()V
    //   92: ldc2_w 30
    //   95: invokevirtual 85	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   98: pop
    //   99: ldc 2
    //   101: monitorexit
    //   102: return
    //   103: astore_0
    //   104: goto +16 -> 120
    //   107: astore_0
    //   108: aload_0
    //   109: ldc 87
    //   111: ldc 88
    //   113: invokestatic 93	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   116: ldc 2
    //   118: monitorexit
    //   119: return
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContext	android.content.Context
    //   0	125	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	99	103	finally
    //   108	116	103	finally
    //   3	99	107	java/lang/Throwable
  }
  
  static final class a
    implements AMapLocationListener
  {
    public final void onLocationChanged(AMapLocation paramAMapLocation)
    {
      try
      {
        if (UmidtokenInfo.a() != null)
        {
          UmidtokenInfo.a.removeCallbacksAndMessages(null);
          UmidtokenInfo.a().onDestroy();
        }
        return;
      }
      catch (Throwable paramAMapLocation)
      {
        dg.a(paramAMapLocation, "UmidListener", "onLocationChanged");
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\UmidtokenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */