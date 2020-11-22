package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class ae
{
  public static String a = "";
  public static boolean b = false;
  public static String d = "";
  private static volatile ae k;
  List<az> c = new Vector();
  b e = null;
  public ai f;
  ak g;
  ah h = null;
  private Context i;
  private boolean j = true;
  private a l;
  private an m;
  private at n;
  private ExecutorService o = null;
  private ExecutorService p = null;
  private ExecutorService q = null;
  private boolean r = true;
  
  private ae(Context paramContext)
  {
    this.i = paramContext;
  }
  
  public static ae a(Context paramContext)
  {
    if (k == null) {
      try
      {
        if ((k == null) && (!b)) {
          k = new ae(paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return k;
  }
  
  private void a(final az paramaz, final boolean paramBoolean)
  {
    if (this.g == null) {
      this.g = new ak(this.i);
    }
    if (this.p == null)
    {
      LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      this.p = new ThreadPoolExecutor(1, 2, 1, localTimeUnit, localLinkedBlockingQueue, new dk("AMapOfflineRemove"), new ThreadPoolExecutor.AbortPolicy());
    }
    try
    {
      this.p.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            if (paramaz.c().equals(paramaz.a))
            {
              if (ae.d(ae.this) == null) {
                return;
              }
              ae.d(ae.this).c(paramaz);
              return;
            }
            if ((paramaz.getState() != 7) && (paramaz.getState() != -1))
            {
              ae.this.g.a(paramaz);
              if (ae.d(ae.this) != null) {
                ae.d(ae.this).c(paramaz);
              }
            }
            else
            {
              ae.this.g.a(paramaz);
              if ((paramBoolean) && (ae.d(ae.this) != null))
              {
                ae.d(ae.this).c(paramaz);
                return;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            gk.c(localThrowable, "requestDelete", "removeExcecRunnable");
          }
          return;
        }
      });
      return;
    }
    catch (Throwable paramaz)
    {
      gk.c(paramaz, "requestDelete", "removeExcecRunnable");
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    int i1 = 0;
    try
    {
      while (i1 < paramString2.length())
      {
        if (paramString1.charAt(i1) > paramString2.charAt(i1)) {
          return true;
        }
        int i2 = paramString1.charAt(i1);
        int i3 = paramString2.charAt(i1);
        if (i2 < i3) {
          return false;
        }
        i1 += 1;
      }
      return false;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static void f()
  {
    k = null;
    b = true;
  }
  
  private void f(final az paramaz)
    throws AMapException
  {
    k();
    if (paramaz != null)
    {
      if (this.q == null)
      {
        LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
        TimeUnit localTimeUnit = TimeUnit.SECONDS;
        this.q = new ThreadPoolExecutor(1, 2, 1, localTimeUnit, localLinkedBlockingQueue, new dk("AMapOfflineDownload"), new ThreadPoolExecutor.AbortPolicy());
      }
      try
      {
        this.q.execute(new Runnable()
        {
          public void run()
          {
            try
            {
              if (ae.e(ae.this))
              {
                ae.b(ae.this);
                af localaf = (af)new ag(ae.c(ae.this), ae.d).c();
                if (localaf != null)
                {
                  ae.a(ae.this, false);
                  if (localaf.a()) {
                    ae.this.b();
                  }
                }
              }
              paramaz.setVersion(ae.d);
              paramaz.f();
              return;
            }
            catch (Throwable localThrowable)
            {
              gk.c(localThrowable, "OfflineDownloadManager", "startDownloadRunnable");
              return;
            }
            catch (AMapException localAMapException)
            {
              localAMapException.printStackTrace();
            }
          }
        });
        return;
      }
      catch (Throwable paramaz)
      {
        gk.c(paramaz, "startDownload", "downloadExcecRunnable");
        return;
      }
    }
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public static void g(String paramString)
  {
    a = paramString;
  }
  
  private void h()
  {
    try
    {
      ao localao = this.n.a("000001");
      if (localao != null)
      {
        this.n.c("000001");
        localao.c("100000");
        this.n.a(localao);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "OfflineDownloadManager", "changeBadCase");
    }
  }
  
  private void h(String paramString)
    throws JSONException
  {
    paramString = bc.a(paramString, this.i.getApplicationContext());
    if (paramString != null)
    {
      if (paramString.size() == 0) {
        return;
      }
      if (this.f != null) {
        this.f.a(paramString);
      }
      return;
    }
  }
  
  private az i(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 1) {
        return null;
      }
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          az localaz = (az)localIterator.next();
          if ((paramString.equals(localaz.getCity())) || (paramString.equals(localaz.getPinyin()))) {
            return localaz;
          }
        }
        return null;
      }
    }
    return null;
  }
  
  private void i()
  {
    if ("".equals(dx.c(this.i))) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dx.c(this.i));
    ((StringBuilder)localObject).append("offlinemapv4.png");
    File localFile = new File(((StringBuilder)localObject).toString());
    if (!localFile.exists()) {
      localObject = bc.a(this.i, "offlinemapv4.png");
    } else {
      localObject = bc.c(localFile);
    }
    if (localObject != null) {
      try
      {
        h((String)localObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        gk.c(localJSONException, "MapDownloadManager", "paseJson io");
        localJSONException.printStackTrace();
      }
    }
  }
  
  private az j(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 1) {
        return null;
      }
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          az localaz = (az)localIterator.next();
          if (paramString.equals(localaz.getCode())) {
            return localaz;
          }
        }
        return null;
      }
    }
    return null;
  }
  
  private void j()
  {
    Iterator localIterator = this.n.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (ao)localIterator.next();
      if ((localObject1 != null) && (((ao)localObject1).d() != null) && (((ao)localObject1).f().length() >= 1))
      {
        if ((((ao)localObject1).l != 4) && (((ao)localObject1).l != 7) && (((ao)localObject1).l >= 0)) {
          ((ao)localObject1).l = 3;
        }
        az localaz = i(((ao)localObject1).d());
        if (localaz != null)
        {
          Object localObject2 = ((ao)localObject1).e();
          if ((localObject2 != null) && (a(d, (String)localObject2)))
          {
            localaz.a(7);
          }
          else
          {
            localaz.a(((ao)localObject1).l);
            localaz.setCompleteCode(((ao)localObject1).h());
          }
          if (((ao)localObject1).e().length() > 0) {
            localaz.setVersion(((ao)localObject1).e());
          }
          localObject2 = this.n.b(((ao)localObject1).f());
          localObject1 = new StringBuffer();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ((StringBuffer)localObject1).append((String)((Iterator)localObject2).next());
            ((StringBuffer)localObject1).append(";");
          }
          localaz.a(((StringBuffer)localObject1).toString());
          if (this.f != null) {
            this.f.a(localaz);
          }
        }
      }
    }
  }
  
  private void k()
    throws AMapException
  {
    if (dx.d(this.i)) {
      return;
    }
    throw new AMapException("http连接失败 - ConnectionException");
  }
  
  public void a()
  {
    this.n = at.a(this.i.getApplicationContext());
    h();
    this.e = new b(this.i.getMainLooper());
    this.f = new ai(this.i, this.e);
    this.m = an.a(1);
    g(dx.c(this.i));
    try
    {
      i();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    synchronized (this.c)
    {
      Iterator localIterator1 = this.f.a().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((OfflineMapProvince)localIterator1.next()).getCityList().iterator();
        while (localIterator2.hasNext())
        {
          OfflineMapCity localOfflineMapCity = (OfflineMapCity)localIterator2.next();
          if (localOfflineMapCity != null) {
            this.c.add(new az(this.i, localOfflineMapCity));
          }
        }
      }
      this.h = new ah(this.i);
      this.h.start();
      return;
    }
  }
  
  public void a(a parama)
  {
    this.l = parama;
  }
  
  public void a(az paramaz)
  {
    a(paramaz, false);
  }
  
  public void a(final String paramString)
  {
    if (paramString == null) {}
    try
    {
      if (this.l == null) {
        break label104;
      }
      this.l.b(null);
      return;
    }
    catch (Throwable paramString)
    {
      LinkedBlockingQueue localLinkedBlockingQueue;
      TimeUnit localTimeUnit;
      for (;;) {}
    }
    if (this.o == null)
    {
      localLinkedBlockingQueue = new LinkedBlockingQueue();
      localTimeUnit = TimeUnit.SECONDS;
      this.o = new ThreadPoolExecutor(1, 2, 1, localTimeUnit, localLinkedBlockingQueue, new dk("AMapOfflineCheckUpdate"), new ThreadPoolExecutor.AbortPolicy());
    }
    this.o.execute(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   4: aload_0
        //   5: getfield 20	com/amap/api/mapcore/util/ae$1:a	Ljava/lang/String;
        //   8: invokestatic 32	com/amap/api/mapcore/util/ae:a	(Lcom/amap/api/mapcore/util/ae;Ljava/lang/String;)Lcom/amap/api/mapcore/util/az;
        //   11: astore_3
        //   12: aload_3
        //   13: ifnull +161 -> 174
        //   16: aload_3
        //   17: invokevirtual 38	com/amap/api/mapcore/util/az:c	()Lcom/amap/api/mapcore/util/bj;
        //   20: aload_3
        //   21: getfield 41	com/amap/api/mapcore/util/az:c	Lcom/amap/api/mapcore/util/bj;
        //   24: invokevirtual 45	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   27: ifne +89 -> 116
        //   30: aload_3
        //   31: invokevirtual 38	com/amap/api/mapcore/util/az:c	()Lcom/amap/api/mapcore/util/bj;
        //   34: aload_3
        //   35: getfield 48	com/amap/api/mapcore/util/az:e	Lcom/amap/api/mapcore/util/bj;
        //   38: invokevirtual 45	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   41: ifeq +6 -> 47
        //   44: goto +72 -> 116
        //   47: aload_3
        //   48: invokevirtual 52	com/amap/api/mapcore/util/az:getPinyin	()Ljava/lang/String;
        //   51: astore_1
        //   52: aload_1
        //   53: invokevirtual 58	java/lang/String:length	()I
        //   56: ifle +118 -> 174
        //   59: aload_0
        //   60: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   63: invokestatic 61	com/amap/api/mapcore/util/ae:a	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/at;
        //   66: aload_1
        //   67: invokevirtual 67	com/amap/api/mapcore/util/at:d	(Ljava/lang/String;)Ljava/lang/String;
        //   70: astore_2
        //   71: aload_2
        //   72: astore_1
        //   73: aload_2
        //   74: ifnonnull +8 -> 82
        //   77: aload_3
        //   78: invokevirtual 70	com/amap/api/mapcore/util/az:getVersion	()Ljava/lang/String;
        //   81: astore_1
        //   82: getstatic 72	com/amap/api/mapcore/util/ae:d	Ljava/lang/String;
        //   85: invokevirtual 58	java/lang/String:length	()I
        //   88: ifle +86 -> 174
        //   91: aload_1
        //   92: ifnull +82 -> 174
        //   95: aload_0
        //   96: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   99: getstatic 72	com/amap/api/mapcore/util/ae:d	Ljava/lang/String;
        //   102: aload_1
        //   103: invokestatic 75	com/amap/api/mapcore/util/ae:a	(Lcom/amap/api/mapcore/util/ae;Ljava/lang/String;Ljava/lang/String;)Z
        //   106: ifeq +68 -> 174
        //   109: aload_3
        //   110: invokevirtual 78	com/amap/api/mapcore/util/az:j	()V
        //   113: goto +61 -> 174
        //   116: aload_0
        //   117: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   120: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   123: ifnull +46 -> 169
        //   126: aload_0
        //   127: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   130: astore_1
        //   131: aload_1
        //   132: monitorenter
        //   133: aload_0
        //   134: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   137: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   140: aload_3
        //   141: invokeinterface 86 2 0
        //   146: goto +16 -> 162
        //   149: astore_2
        //   150: goto +15 -> 165
        //   153: astore_2
        //   154: aload_2
        //   155: ldc 88
        //   157: ldc 90
        //   159: invokestatic 95	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   162: aload_1
        //   163: monitorexit
        //   164: return
        //   165: aload_1
        //   166: monitorexit
        //   167: aload_2
        //   168: athrow
        //   169: return
        //   170: astore_2
        //   171: goto +171 -> 342
        //   174: aload_0
        //   175: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   178: invokestatic 98	com/amap/api/mapcore/util/ae:b	(Lcom/amap/api/mapcore/util/ae;)V
        //   181: new 100	com/amap/api/mapcore/util/ag
        //   184: dup
        //   185: aload_0
        //   186: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   189: invokestatic 103	com/amap/api/mapcore/util/ae:c	(Lcom/amap/api/mapcore/util/ae;)Landroid/content/Context;
        //   192: getstatic 72	com/amap/api/mapcore/util/ae:d	Ljava/lang/String;
        //   195: invokespecial 106	com/amap/api/mapcore/util/ag:<init>	(Landroid/content/Context;Ljava/lang/String;)V
        //   198: invokevirtual 109	com/amap/api/mapcore/util/ag:c	()Ljava/lang/Object;
        //   201: checkcast 111	com/amap/api/mapcore/util/af
        //   204: astore_1
        //   205: aload_0
        //   206: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   209: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   212: astore_2
        //   213: aload_2
        //   214: ifnull +75 -> 289
        //   217: aload_1
        //   218: ifnonnull +57 -> 275
        //   221: aload_0
        //   222: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   225: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   228: ifnull +46 -> 274
        //   231: aload_0
        //   232: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   235: astore_1
        //   236: aload_1
        //   237: monitorenter
        //   238: aload_0
        //   239: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   242: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   245: aload_3
        //   246: invokeinterface 86 2 0
        //   251: goto +16 -> 267
        //   254: astore_2
        //   255: goto +15 -> 270
        //   258: astore_2
        //   259: aload_2
        //   260: ldc 88
        //   262: ldc 90
        //   264: invokestatic 95	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   267: aload_1
        //   268: monitorexit
        //   269: return
        //   270: aload_1
        //   271: monitorexit
        //   272: aload_2
        //   273: athrow
        //   274: return
        //   275: aload_1
        //   276: invokevirtual 114	com/amap/api/mapcore/util/af:a	()Z
        //   279: ifeq +10 -> 289
        //   282: aload_0
        //   283: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   286: invokevirtual 116	com/amap/api/mapcore/util/ae:b	()V
        //   289: aload_0
        //   290: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   293: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   296: ifnull +156 -> 452
        //   299: aload_0
        //   300: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   303: astore_1
        //   304: aload_1
        //   305: monitorenter
        //   306: aload_0
        //   307: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   310: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   313: aload_3
        //   314: invokeinterface 86 2 0
        //   319: goto +16 -> 335
        //   322: astore_2
        //   323: goto +15 -> 338
        //   326: astore_2
        //   327: aload_2
        //   328: ldc 88
        //   330: ldc 90
        //   332: invokestatic 95	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   335: aload_1
        //   336: monitorexit
        //   337: return
        //   338: aload_1
        //   339: monitorexit
        //   340: aload_2
        //   341: athrow
        //   342: aload_0
        //   343: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   346: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   349: ifnull +48 -> 397
        //   352: aload_0
        //   353: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   356: astore_1
        //   357: aload_1
        //   358: monitorenter
        //   359: aload_0
        //   360: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   363: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   366: aload_3
        //   367: invokeinterface 86 2 0
        //   372: goto +16 -> 388
        //   375: astore_2
        //   376: goto +17 -> 393
        //   379: astore_3
        //   380: aload_3
        //   381: ldc 88
        //   383: ldc 90
        //   385: invokestatic 95	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   388: aload_1
        //   389: monitorexit
        //   390: goto +7 -> 397
        //   393: aload_1
        //   394: monitorexit
        //   395: aload_2
        //   396: athrow
        //   397: aload_2
        //   398: athrow
        //   399: aload_0
        //   400: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   403: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   406: ifnull +46 -> 452
        //   409: aload_0
        //   410: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   413: astore_1
        //   414: aload_1
        //   415: monitorenter
        //   416: aload_0
        //   417: getfield 18	com/amap/api/mapcore/util/ae$1:b	Lcom/amap/api/mapcore/util/ae;
        //   420: invokestatic 81	com/amap/api/mapcore/util/ae:d	(Lcom/amap/api/mapcore/util/ae;)Lcom/amap/api/mapcore/util/ae$a;
        //   423: aload_3
        //   424: invokeinterface 86 2 0
        //   429: goto +16 -> 445
        //   432: astore_2
        //   433: goto +15 -> 448
        //   436: astore_2
        //   437: aload_2
        //   438: ldc 88
        //   440: ldc 90
        //   442: invokestatic 95	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   445: aload_1
        //   446: monitorexit
        //   447: return
        //   448: aload_1
        //   449: monitorexit
        //   450: aload_2
        //   451: athrow
        //   452: return
        //   453: astore_1
        //   454: goto -55 -> 399
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	457	0	this	1
        //   453	1	1	localException	Exception
        //   70	4	2	str	String
        //   149	1	2	localObject2	Object
        //   153	15	2	localThrowable1	Throwable
        //   170	1	2	localObject3	Object
        //   212	2	2	locala	ae.a
        //   254	1	2	localObject4	Object
        //   258	15	2	localThrowable2	Throwable
        //   322	1	2	localObject5	Object
        //   326	15	2	localThrowable3	Throwable
        //   375	23	2	localObject6	Object
        //   432	1	2	localObject7	Object
        //   436	15	2	localThrowable4	Throwable
        //   11	356	3	localaz	az
        //   379	45	3	localThrowable5	Throwable
        // Exception table:
        //   from	to	target	type
        //   133	146	149	finally
        //   154	162	149	finally
        //   162	164	149	finally
        //   165	167	149	finally
        //   133	146	153	java/lang/Throwable
        //   16	44	170	finally
        //   47	71	170	finally
        //   77	82	170	finally
        //   82	91	170	finally
        //   95	113	170	finally
        //   174	213	170	finally
        //   275	289	170	finally
        //   238	251	254	finally
        //   259	267	254	finally
        //   267	269	254	finally
        //   270	272	254	finally
        //   238	251	258	java/lang/Throwable
        //   306	319	322	finally
        //   327	335	322	finally
        //   335	337	322	finally
        //   338	340	322	finally
        //   306	319	326	java/lang/Throwable
        //   359	372	375	finally
        //   380	388	375	finally
        //   388	390	375	finally
        //   393	395	375	finally
        //   359	372	379	java/lang/Throwable
        //   416	429	432	finally
        //   437	445	432	finally
        //   445	447	432	finally
        //   448	450	432	finally
        //   416	429	436	java/lang/Throwable
        //   16	44	453	java/lang/Exception
        //   47	71	453	java/lang/Exception
        //   77	82	453	java/lang/Exception
        //   82	91	453	java/lang/Exception
        //   95	113	453	java/lang/Exception
        //   174	213	453	java/lang/Exception
        //   275	289	453	java/lang/Exception
      }
    });
    return;
    gk.c(paramString, "OfflineDownloadManager", "checkUpdate");
    return;
    label104:
  }
  
  public void a(ArrayList<ao> paramArrayList)
  {
    j();
    if (this.l != null) {
      try
      {
        this.l.a();
        return;
      }
      catch (Throwable paramArrayList)
      {
        gk.c(paramArrayList, "OfflineDownloadManager", "verifyCallBack");
      }
    }
  }
  
  protected void b()
    throws AMapException
  {
    if (this.f == null) {
      return;
    }
    ??? = new al(this.i, "");
    ((al)???).a(this.i);
    ??? = (List)((al)???).c();
    if (this.c != null) {
      this.f.a((List)???);
    }
    if (this.c != null) {
      synchronized (this.c)
      {
        Iterator localIterator1 = this.f.a().iterator();
        if (localIterator1.hasNext())
        {
          Iterator localIterator2 = ((OfflineMapProvince)localIterator1.next()).getCityList().iterator();
          while (localIterator2.hasNext())
          {
            OfflineMapCity localOfflineMapCity = (OfflineMapCity)localIterator2.next();
            Iterator localIterator3 = this.c.iterator();
            while (localIterator3.hasNext())
            {
              az localaz = (az)localIterator3.next();
              if (localOfflineMapCity.getPinyin().equals(localaz.getPinyin()))
              {
                String str = localaz.getVersion();
                if ((localaz.getState() == 4) && (d.length() > 0) && (a(d, str)))
                {
                  localaz.j();
                  localaz.setUrl(localOfflineMapCity.getUrl());
                  localaz.t();
                }
                else
                {
                  localaz.setCity(localOfflineMapCity.getCity());
                  localaz.setUrl(localOfflineMapCity.getUrl());
                  localaz.t();
                  localaz.setAdcode(localOfflineMapCity.getAdcode());
                  localaz.setVersion(localOfflineMapCity.getVersion());
                  localaz.setSize(localOfflineMapCity.getSize());
                  localaz.setCode(localOfflineMapCity.getCode());
                  localaz.setJianpin(localOfflineMapCity.getJianpin());
                  localaz.setPinyin(localOfflineMapCity.getPinyin());
                }
              }
            }
          }
        }
        return;
      }
    }
  }
  
  public void b(az paramaz)
  {
    try
    {
      if (this.m != null)
      {
        this.m.a(paramaz, this.i, null);
        return;
      }
    }
    catch (fj paramaz)
    {
      paramaz.printStackTrace();
    }
  }
  
  public boolean b(String paramString)
  {
    return i(paramString) != null;
  }
  
  public void c()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        if ((localaz.c().equals(localaz.c)) || (localaz.c().equals(localaz.b)))
        {
          d(localaz);
          localaz.g();
        }
      }
      return;
    }
  }
  
  public void c(az paramaz)
  {
    if (this.f != null) {
      this.f.a(paramaz);
    }
    if (this.e != null)
    {
      Message localMessage = this.e.obtainMessage();
      localMessage.obj = paramaz;
      this.e.sendMessage(localMessage);
    }
  }
  
  public void c(String paramString)
  {
    paramString = i(paramString);
    if (paramString == null)
    {
      if (this.l != null) {
        try
        {
          this.l.c(paramString);
          return;
        }
        catch (Throwable paramString)
        {
          gk.c(paramString, "OfflineDownloadManager", "remove");
        }
      }
      return;
    }
    d(paramString);
    a(paramString, true);
  }
  
  public void d()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        if (localaz.c().equals(localaz.c)) {
          localaz.g();
        }
      }
      return;
    }
  }
  
  public void d(az paramaz)
  {
    if (this.m != null) {
      this.m.a(paramaz);
    }
  }
  
  public void d(String paramString)
    throws AMapException
  {
    az localaz = i(paramString);
    if ((paramString != null) && (paramString.length() >= 1) && (localaz != null))
    {
      f(localaz);
      return;
    }
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public void e()
  {
    if ((this.o != null) && (!this.o.isShutdown())) {
      this.o.shutdownNow();
    }
    if ((this.q != null) && (!this.q.isShutdown())) {
      this.q.shutdownNow();
    }
    if (this.h != null)
    {
      if (this.h.isAlive()) {
        this.h.interrupt();
      }
      this.h = null;
    }
    if (this.e != null)
    {
      this.e.removeCallbacksAndMessages(null);
      this.e = null;
    }
    if (this.m != null) {
      this.m.b();
    }
    if (this.f != null) {
      this.f.g();
    }
    f();
    this.j = true;
    g();
  }
  
  public void e(az paramaz)
  {
    if (this.m != null) {
      this.m.b(paramaz);
    }
  }
  
  public void e(String paramString)
    throws AMapException
  {
    paramString = j(paramString);
    if (paramString != null)
    {
      f(paramString);
      return;
    }
    throw new AMapException("无效的参数 - IllegalArgumentException");
  }
  
  public String f(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = i(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.getAdcode();
  }
  
  public void g()
  {
    try
    {
      this.l = null;
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(az paramaz);
    
    public abstract void b(az paramaz);
    
    public abstract void c(az paramaz);
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      try
      {
        paramMessage.getData();
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof az))
        {
          paramMessage = (az)paramMessage;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("OfflineMapHandler handleMessage CitObj  name: ");
          localStringBuilder.append(paramMessage.getCity());
          localStringBuilder.append(" complete: ");
          localStringBuilder.append(paramMessage.getcompleteCode());
          localStringBuilder.append(" status: ");
          localStringBuilder.append(paramMessage.getState());
          bc.a(localStringBuilder.toString());
          if (ae.d(ae.this) != null) {
            ae.d(ae.this).a(paramMessage);
          }
        }
        else
        {
          bc.a("Do not callback by CityObject! ");
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */