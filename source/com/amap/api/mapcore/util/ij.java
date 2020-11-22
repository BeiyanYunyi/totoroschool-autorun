package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class ij
{
  static WeakReference<ih> a;
  
  public static void a(Context paramContext)
  {
    gk.d().submit(new Runnable()
    {
      public void run()
      {
        try
        {
          ih localih = ip.a(ij.a);
          ip.a(this.a, localih, gh.i, 50, 102400, "10");
          if (localih.g == null)
          {
            String str = ij.b(this.a);
            localih.g = new it(new is(this.a, new ix(), new fz(new gd(new gb())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", new Object[] { fk.b(this.a), fk.c(this.a), str }));
          }
          localih.h = 14400000;
          if (TextUtils.isEmpty(localih.i)) {
            localih.i = "eKey";
          }
          if (localih.f == null) {
            localih.f = new jb(this.a, localih.h, localih.i, new iy(5, localih.a, new jd(this.a, false)));
          }
          ii.a(localih);
          return;
        }
        finally {}
      }
    });
  }
  
  public static void a(String paramString, final Context paramContext)
  {
    gk.d().submit(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: ldc 8
        //   2: monitorenter
        //   3: aload_0
        //   4: getfield 17	com/amap/api/mapcore/util/ij$1:a	Ljava/lang/String;
        //   7: invokestatic 31	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
        //   10: invokestatic 36	com/amap/api/mapcore/util/fs:a	([B)Ljava/lang/String;
        //   13: astore_1
        //   14: getstatic 39	com/amap/api/mapcore/util/ij:a	Ljava/lang/ref/WeakReference;
        //   17: invokestatic 44	com/amap/api/mapcore/util/ip:a	(Ljava/lang/ref/WeakReference;)Lcom/amap/api/mapcore/util/ih;
        //   20: astore_2
        //   21: aload_0
        //   22: getfield 19	com/amap/api/mapcore/util/ij$1:b	Landroid/content/Context;
        //   25: aload_2
        //   26: getstatic 49	com/amap/api/mapcore/util/gh:i	Ljava/lang/String;
        //   29: bipush 50
        //   31: ldc 50
        //   33: ldc 52
        //   35: invokestatic 55	com/amap/api/mapcore/util/ip:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/ih;Ljava/lang/String;IILjava/lang/String;)V
        //   38: aload_2
        //   39: getfield 61	com/amap/api/mapcore/util/ih:e	Lcom/amap/api/mapcore/util/ga;
        //   42: ifnonnull +28 -> 70
        //   45: aload_2
        //   46: new 63	com/amap/api/mapcore/util/fz
        //   49: dup
        //   50: new 65	com/amap/api/mapcore/util/gd
        //   53: dup
        //   54: new 67	com/amap/api/mapcore/util/gb
        //   57: dup
        //   58: invokespecial 68	com/amap/api/mapcore/util/gb:<init>	()V
        //   61: invokespecial 71	com/amap/api/mapcore/util/gd:<init>	(Lcom/amap/api/mapcore/util/ga;)V
        //   64: invokespecial 72	com/amap/api/mapcore/util/fz:<init>	(Lcom/amap/api/mapcore/util/ga;)V
        //   67: putfield 61	com/amap/api/mapcore/util/ih:e	Lcom/amap/api/mapcore/util/ga;
        //   70: invokestatic 78	java/lang/System:currentTimeMillis	()J
        //   73: ldc 80
        //   75: invokestatic 83	com/amap/api/mapcore/util/fw:a	(JLjava/lang/String;)Ljava/lang/String;
        //   78: astore_3
        //   79: new 85	java/lang/StringBuilder
        //   82: dup
        //   83: invokespecial 86	java/lang/StringBuilder:<init>	()V
        //   86: astore 4
        //   88: aload 4
        //   90: ldc 88
        //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   95: pop
        //   96: aload 4
        //   98: aload_3
        //   99: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: pop
        //   103: aload 4
        //   105: ldc 94
        //   107: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: pop
        //   111: aload 4
        //   113: aload_0
        //   114: getfield 17	com/amap/api/mapcore/util/ij$1:a	Ljava/lang/String;
        //   117: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: pop
        //   121: aload_1
        //   122: aload 4
        //   124: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   127: invokestatic 31	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
        //   130: aload_2
        //   131: invokestatic 103	com/amap/api/mapcore/util/ii:a	(Ljava/lang/String;[BLcom/amap/api/mapcore/util/ih;)V
        //   134: goto +16 -> 150
        //   137: astore_1
        //   138: goto +16 -> 154
        //   141: astore_1
        //   142: aload_1
        //   143: ldc 105
        //   145: ldc 107
        //   147: invokestatic 113	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   150: ldc 8
        //   152: monitorexit
        //   153: return
        //   154: ldc 8
        //   156: monitorexit
        //   157: aload_1
        //   158: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	159	0	this	1
        //   13	109	1	str1	String
        //   137	1	1	localObject	Object
        //   141	17	1	localThrowable	Throwable
        //   20	111	2	localih	ih
        //   78	21	3	str2	String
        //   86	37	4	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   3	70	137	finally
        //   70	134	137	finally
        //   142	150	137	finally
        //   150	153	137	finally
        //   154	157	137	finally
        //   3	70	141	java/lang/Throwable
        //   70	134	141	java/lang/Throwable
      }
    });
  }
  
  private static String c(Context paramContext)
  {
    String str = fp.w(paramContext);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = fp.i(paramContext);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = fp.n(paramContext);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return fp.b(paramContext);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */