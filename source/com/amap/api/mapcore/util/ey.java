package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ey
  implements LocationSource.OnLocationChangedListener, LBSTraceBase
{
  private static final TimeUnit s = TimeUnit.SECONDS;
  int a = Runtime.getRuntime().availableProcessors();
  private Context b;
  private CoordinateConverter c;
  private ExecutorService d;
  private ExecutorService e;
  private long f = 2000L;
  private int g = 5;
  private TraceStatusListener h;
  private w i;
  private List<TraceLocation> j = new ArrayList();
  private int k = 0;
  private int l = 0;
  private long m = 0L;
  private c n;
  private TraceLocation o = null;
  private List<LatLng> p = new ArrayList();
  private List<LatLng> q = new ArrayList();
  private List<LatLng> r = new ArrayList();
  private BlockingQueue<Runnable> t = new LinkedBlockingQueue();
  private BlockingQueue<Runnable> u = new LinkedBlockingQueue();
  
  public ey(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new CoordinateConverter(this.b);
    this.n = new c(Looper.getMainLooper());
    fr.a().a(this.b);
    this.d = new ThreadPoolExecutor(1, this.a * 2, 1L, s, this.t, new dk("AMapTraceManagerProcess"), new ThreadPoolExecutor.AbortPolicy());
    this.e = new ThreadPoolExecutor(1, this.a * 2, 1L, s, this.u, new dk("AMapTraceManagerRequest"), new ThreadPoolExecutor.AbortPolicy());
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (paramDouble1 > paramDouble3) {
      paramDouble1 -= paramDouble3;
    } else {
      paramDouble1 = paramDouble3 - paramDouble1;
    }
    if (paramDouble2 > paramDouble4) {
      paramDouble2 -= paramDouble4;
    } else {
      paramDouble2 = paramDouble4 - paramDouble2;
    }
    return Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
  }
  
  private void a()
  {
    int i1 = this.j.size();
    if (i1 < this.g) {
      return;
    }
    if (i1 <= 50)
    {
      localArrayList = new ArrayList(this.j);
      queryProcessedTrace(0, localArrayList, 1, new b(localArrayList));
      return;
    }
    int i2 = i1 - 50;
    if (i2 < 0) {
      return;
    }
    a(new ArrayList(this.j.subList(i2 - this.g, i2)));
    ArrayList localArrayList = new ArrayList(this.j.subList(i2, i1));
    queryProcessedTrace(i2, localArrayList, 1, new b(localArrayList));
  }
  
  private void a(List<TraceLocation> paramList)
  {
    List localList = this.r;
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if (paramList.size() >= 1)
        {
          if (this.r.size() < 1) {
            return;
          }
          Iterator localIterator = paramList.iterator();
          localLatLng = null;
          double d2 = 0.0D;
          paramList = null;
          d1 = 0.0D;
          if (localIterator.hasNext())
          {
            localObject = (TraceLocation)localIterator.next();
            if (localObject != null) {
              continue;
            }
            continue;
            d3 = a(paramList.getLatitude(), paramList.getLongitude(), ((TraceLocation)localObject).getLatitude(), ((TraceLocation)localObject).getLongitude());
            if (d3 <= 100.0D) {
              continue;
            }
            continue;
          }
          localObject = this.r.iterator();
          paramList = localLatLng;
          if (((Iterator)localObject).hasNext())
          {
            localLatLng = (LatLng)((Iterator)localObject).next();
            if (localLatLng == null)
            {
              ((Iterator)localObject).remove();
              continue;
            }
            if (paramList == null)
            {
              this.p.add(localLatLng);
              ((Iterator)localObject).remove();
              continue;
            }
            d2 += a(paramList.latitude, paramList.longitude, localLatLng.latitude, localLatLng.longitude);
            if (d2 < d1)
            {
              this.p.add(localLatLng);
              ((Iterator)localObject).remove();
              continue;
            }
          }
          return;
        }
        return;
      }
      finally
      {
        LatLng localLatLng;
        double d1;
        Object localObject;
        double d3;
        continue;
      }
      throw paramList;
      if (paramList == null)
      {
        continue;
        d1 += d3;
        paramList = (List<TraceLocation>)localObject;
        continue;
        paramList = localLatLng;
      }
    }
  }
  
  private boolean a(TraceLocation paramTraceLocation1, TraceLocation paramTraceLocation2)
  {
    if (paramTraceLocation1 != null)
    {
      if (paramTraceLocation2 == null) {
        return false;
      }
      return (paramTraceLocation1.getLatitude() == paramTraceLocation2.getLatitude()) && (paramTraceLocation1.getLongitude() == paramTraceLocation2.getLongitude());
    }
    return false;
  }
  
  private void b()
  {
    if (this.i != null)
    {
      this.i.deactivate();
      this.i = null;
    }
  }
  
  private void c()
  {
    this.t.clear();
    this.u.clear();
    if (this.j != null) {
      synchronized (this.j)
      {
        if (this.j != null) {
          this.j.clear();
        }
        this.l = 0;
        this.k = 0;
        this.m = 0L;
        this.o = null;
        return;
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      stopTrace();
      if ((this.d != null) && (!this.d.isShutdown()))
      {
        this.d.shutdownNow();
        this.d = null;
      }
      if ((this.e != null) && (!this.e.isShutdown()))
      {
        this.e.shutdownNow();
        this.e = null;
      }
      this.j = null;
      this.h = null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.b = null;
    this.c = null;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (this.h != null) {
      try
      {
        if ((System.currentTimeMillis() - this.m >= 30000L) && (this.h != null)) {
          this.h.onTraceStatus(null, null, "定位超时");
        }
        this.m = System.currentTimeMillis();
        ??? = paramLocation.getExtras();
        int i1 = ((Bundle)???).getInt("errorCode");
        if (i1 != 0)
        {
          paramLocation = new StringBuilder();
          paramLocation.append("Locate failed [errorCode:\"");
          paramLocation.append(i1);
          paramLocation.append("\"  errorInfo:");
          paramLocation.append(((Bundle)???).getString("errorInfo"));
          paramLocation.append("\"]");
          Log.w("LBSTraceClient", paramLocation.toString());
          return;
        }
        synchronized (this.j)
        {
          paramLocation = new TraceLocation(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getSpeed(), paramLocation.getBearing(), paramLocation.getTime());
          if (a(this.o, paramLocation)) {
            return;
          }
          this.j.add(paramLocation);
          this.o = paramLocation;
          this.k += 1;
          if (this.k == this.g)
          {
            this.l += this.k;
            a();
            this.k = 0;
          }
          return;
        }
        return;
      }
      catch (Throwable paramLocation)
      {
        paramLocation.printStackTrace();
      }
    }
  }
  
  public void queryProcessedTrace(int paramInt1, List<TraceLocation> paramList, int paramInt2, TraceListener paramTraceListener)
  {
    try
    {
      paramList = new a(paramInt1, paramList, paramInt2, paramTraceListener);
      this.d.execute(paramList);
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void setLocationInterval(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void setTraceStatusInterval(int paramInt)
  {
    this.g = Math.max(paramInt, 2);
  }
  
  public void startTrace(TraceStatusListener paramTraceStatusListener)
  {
    if (this.b == null)
    {
      Log.w("LBSTraceClient", "Context need to be initialized");
      return;
    }
    this.m = System.currentTimeMillis();
    this.h = paramTraceStatusListener;
    if (this.i == null)
    {
      this.i = new w(this.b);
      this.i.a(this.f);
      this.i.activate(this);
    }
  }
  
  public void stopTrace()
  {
    b();
    c();
  }
  
  class a
    implements Runnable
  {
    private List<TraceLocation> b = new ArrayList();
    private int c;
    private int d;
    private List<TraceLocation> e;
    private String f;
    private TraceListener g;
    
    public a(List<TraceLocation> paramList, int paramInt, TraceListener paramTraceListener)
    {
      this.c = paramTraceListener;
      this.d = paramList;
      this.e = paramInt;
      this.f = dp.a();
      TraceListener localTraceListener;
      this.g = localTraceListener;
    }
    
    private int a()
    {
      Object localObject = this.e;
      int i = 0;
      if (localObject != null)
      {
        if (this.e.size() == 0) {
          return 0;
        }
        localObject = new ArrayList();
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          TraceLocation localTraceLocation = (TraceLocation)localIterator.next();
          if (localTraceLocation != null) {
            if (localTraceLocation.getSpeed() < 0.01D)
            {
              ((List)localObject).add(localTraceLocation);
            }
            else
            {
              i += a((List)localObject);
              ((List)localObject).clear();
            }
          }
        }
        return i;
      }
      return 0;
    }
    
    private int a(List<TraceLocation> paramList)
    {
      int i = paramList.size();
      int j = 0;
      if (i <= 1) {
        return 0;
      }
      TraceLocation localTraceLocation = (TraceLocation)paramList.get(0);
      paramList = (TraceLocation)paramList.get(i - 1);
      if (localTraceLocation != null)
      {
        if (paramList == null) {
          return 0;
        }
        i = j;
        if (localTraceLocation != null)
        {
          i = j;
          if (paramList != null) {
            i = (int)((paramList.getTime() - localTraceLocation.getTime()) / 1000L);
          }
        }
        return i;
      }
      return 0;
    }
    
    public void run()
    {
      for (;;)
      {
        int k;
        try
        {
          ey.g(ey.this).a(this.g);
          int i = a();
          if ((this.e != null) && (this.e.size() >= 2))
          {
            Object localObject = this.e.iterator();
            TraceLocation localTraceLocation;
            if (((Iterator)localObject).hasNext())
            {
              localTraceLocation = ((TraceLocation)((Iterator)localObject).next()).copy();
              if ((localTraceLocation == null) || (localTraceLocation.getLatitude() <= 0.0D) || (localTraceLocation.getLongitude() <= 0.0D)) {
                continue;
              }
              this.b.add(localTraceLocation);
              continue;
            }
            int m = (this.b.size() - 2) / 500;
            fe.a().a(this.f, this.d, m, i);
            i = 500;
            j = 0;
            if (j <= m)
            {
              if (j == m) {
                i = this.b.size();
              }
              localObject = new ArrayList();
              k = 0;
              if (k < i)
              {
                localTraceLocation = (TraceLocation)this.b.remove(0);
                if (localTraceLocation == null) {
                  break label490;
                }
                if (this.c != 1)
                {
                  if (this.c == 3) {
                    ey.h(ey.this).from(CoordinateConverter.CoordType.BAIDU);
                  } else if (this.c == 2) {
                    ey.h(ey.this).from(CoordinateConverter.CoordType.GPS);
                  }
                  LatLng localLatLng = new LatLng(localTraceLocation.getLatitude(), localTraceLocation.getLongitude());
                  ey.h(ey.this).coord(localLatLng);
                  localLatLng = ey.h(ey.this).convert();
                  if (localLatLng != null)
                  {
                    localTraceLocation.setLatitude(localLatLng.latitude);
                    localTraceLocation.setLongitude(localLatLng.longitude);
                  }
                }
                ((List)localObject).add(localTraceLocation);
                break label490;
              }
              k = j;
              if (((List)localObject).size() < 2) {
                break label497;
              }
              if (((List)localObject).size() > 500)
              {
                k = j;
                break label497;
              }
              localObject = new ex(ey.i(ey.this), ey.g(ey.this), (List)localObject, this.c, this.f, this.d, j);
              ey.j(ey.this).execute((Runnable)localObject);
              k = j + 1;
              try
              {
                Thread.sleep(50L);
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
          else
          {
            fe.a().a(ey.g(ey.this), this.d, "轨迹点太少或距离太近,轨迹纠偏失败");
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        return;
        label490:
        k += 1;
        continue;
        label497:
        int j = k;
      }
    }
  }
  
  class b
    implements TraceListener
  {
    private final List<TraceLocation> b;
    
    public b()
    {
      List localList;
      this.b = localList;
    }
    
    private void a(int paramInt, List<LatLng> paramList)
    {
      try
      {
        synchronized (ey.a(ey.this))
        {
          ey.a(ey.this).clear();
          ey.a(ey.this).addAll(paramList);
          ey.c(ey.this).clear();
          if (paramInt == 0)
          {
            ey.c(ey.this).addAll(ey.a(ey.this));
          }
          else
          {
            ey.c(ey.this).addAll(ey.d(ey.this));
            ey.c(ey.this).addAll(ey.a(ey.this));
          }
          ey.f(ey.this).onTraceStatus(ey.e(ey.this), ey.c(ey.this), "纠偏成功");
          return;
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
    
    public void onFinished(int paramInt1, List<LatLng> paramList, int paramInt2, int paramInt3)
    {
      a(paramInt1, paramList);
    }
    
    public void onRequestFailed(int paramInt, String paramString)
    {
      paramString = new ArrayList();
      if (ey.a(ey.this) != null) {
        paramString.addAll(ey.a(ey.this));
      }
      if (this.b != null)
      {
        int j = this.b.size();
        if (this.b.size() > ey.b(ey.this))
        {
          int i = j - ey.b(ey.this);
          while (i < j)
          {
            TraceLocation localTraceLocation = (TraceLocation)this.b.get(i);
            if (localTraceLocation != null) {
              paramString.add(new LatLng(localTraceLocation.getLatitude(), localTraceLocation.getLongitude()));
            }
            i += 1;
          }
        }
      }
      a(paramInt, paramString);
    }
    
    public void onTraceProcessing(int paramInt1, int paramInt2, List<LatLng> paramList) {}
  }
  
  static class c
    extends Handler
  {
    private TraceListener a;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void a(TraceListener paramTraceListener)
    {
      this.a = paramTraceListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      try
      {
        if (this.a == null) {
          return;
        }
        localObject = paramMessage.getData();
        if (localObject == null) {
          return;
        }
        i = ((Bundle)localObject).getInt("lineID");
        switch (paramMessage.what)
        {
        case 102: 
          paramMessage = (String)paramMessage.obj;
          this.a.onRequestFailed(i, paramMessage);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Object localObject;
        int i;
        paramMessage.printStackTrace();
        return;
      }
      localObject = (List)paramMessage.obj;
      this.a.onFinished(i, (List)localObject, paramMessage.arg1, paramMessage.arg2);
      return;
      localObject = (List)paramMessage.obj;
      this.a.onTraceProcessing(i, paramMessage.arg1, (List)localObject);
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */