package com.amap.api.maps.utils.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmoothMoveMarker
{
  public static final float MIN_OFFSET_DISTANCE = 5.0F;
  private BitmapDescriptor descriptor;
  private long duration = 10000L;
  private LinkedList<Double> eachDistance = new LinkedList();
  AtomicBoolean exitFlag = new AtomicBoolean(false);
  private int index = 0;
  private AMap mAMap;
  private long mAnimationBeginTime = System.currentTimeMillis();
  private Object mLock = new Object();
  private long mStepDuration = 20L;
  private ExecutorService mThreadPools;
  private Marker marker = null;
  private MoveListener moveListener;
  private a moveStatus = a.a;
  private long pauseMillis;
  private LinkedList<LatLng> points = new LinkedList();
  private double remainDistance = 0.0D;
  private double totalDistance = 0.0D;
  private boolean useDefaultDescriptor = false;
  
  public SmoothMoveMarker(AMap paramAMap)
  {
    this.mAMap = paramAMap;
    this.mThreadPools = new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new b(null));
  }
  
  private void checkMarkerIcon()
  {
    if (this.useDefaultDescriptor)
    {
      if (this.descriptor == null)
      {
        this.useDefaultDescriptor = true;
        return;
      }
      this.marker.setIcon(this.descriptor);
      this.useDefaultDescriptor = false;
    }
  }
  
  private IPoint getCurPosition(long paramLong)
  {
    if (paramLong > this.duration)
    {
      this.exitFlag.set(true);
      localIPoint1 = new IPoint();
      this.index = (this.points.size() - 1);
      localObject = (LatLng)this.points.get(this.index);
      this.index -= 1;
      this.index = Math.max(this.index, 0);
      this.remainDistance = 0.0D;
      MapProjection.lonlat2Geo(((LatLng)localObject).longitude, ((LatLng)localObject).latitude, localIPoint1);
      if (this.moveListener != null) {
        this.moveListener.move(this.remainDistance);
      }
      return localIPoint1;
    }
    double d1 = paramLong;
    double d2 = this.totalDistance;
    Double.isNaN(d1);
    double d3 = this.duration;
    Double.isNaN(d3);
    d2 = d1 * d2 / d3;
    this.remainDistance = (this.totalDistance - d2);
    d1 = 1.0D;
    int i = 0;
    while (i < this.eachDistance.size())
    {
      d3 = ((Double)this.eachDistance.get(i)).doubleValue();
      if (d2 > d3)
      {
        d2 -= d3;
        i += 1;
      }
      else
      {
        j = i;
        if (d3 <= 0.0D) {
          break label252;
        }
        d1 = d2 / d3;
        j = i;
        break label252;
      }
    }
    int j = 0;
    label252:
    if ((j != this.index) && (this.moveListener != null)) {
      this.moveListener.move(this.remainDistance);
    }
    this.index = j;
    Object localObject = (LatLng)this.points.get(j);
    LatLng localLatLng = (LatLng)this.points.get(j + 1);
    IPoint localIPoint1 = new IPoint();
    MapProjection.lonlat2Geo(((LatLng)localObject).longitude, ((LatLng)localObject).latitude, localIPoint1);
    IPoint localIPoint2 = new IPoint();
    MapProjection.lonlat2Geo(localLatLng.longitude, localLatLng.latitude, localIPoint2);
    int k = localIPoint2.x;
    int m = localIPoint1.x;
    i = localIPoint2.y;
    j = localIPoint1.y;
    if (AMapUtils.calculateLineDistance((LatLng)localObject, localLatLng) > 5.0F)
    {
      float f = getRotate(localIPoint1, localIPoint2);
      if (this.mAMap != null)
      {
        localObject = this.mAMap.getCameraPosition();
        if (localObject != null) {
          this.marker.setRotateAngle(360.0F - f + ((CameraPosition)localObject).bearing);
        }
      }
    }
    d2 = localIPoint1.x;
    d3 = k - m;
    Double.isNaN(d3);
    Double.isNaN(d2);
    k = (int)(d2 + d3 * d1);
    d2 = localIPoint1.y;
    d3 = i - j;
    Double.isNaN(d3);
    Double.isNaN(d2);
    return new IPoint(k, (int)(d2 + d3 * d1));
  }
  
  private float getRotate(IPoint paramIPoint1, IPoint paramIPoint2)
  {
    if ((paramIPoint1 != null) && (paramIPoint2 != null))
    {
      double d1 = paramIPoint2.y;
      double d2 = paramIPoint1.y;
      double d3 = paramIPoint1.x;
      double d4 = paramIPoint2.x;
      Double.isNaN(d4);
      Double.isNaN(d3);
      Double.isNaN(d2);
      Double.isNaN(d1);
      return (float)(Math.atan2(d4 - d3, d2 - d1) / 3.141592653589793D * 180.0D);
    }
    return 0.0F;
  }
  
  private void reset()
  {
    try
    {
      if ((this.moveStatus == a.c) || (this.moveStatus == a.d))
      {
        this.exitFlag.set(true);
        this.mThreadPools.awaitTermination(this.mStepDuration + 20L, TimeUnit.MILLISECONDS);
        if (this.marker != null) {
          this.marker.setAnimation(null);
        }
        this.moveStatus = a.a;
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public void destroy()
  {
    try
    {
      reset();
      this.mThreadPools.shutdownNow();
      if (this.descriptor != null) {
        this.descriptor.recycle();
      }
      if (this.marker != null)
      {
        this.marker.destroy();
        this.marker = null;
      }
      synchronized (this.mLock)
      {
        this.points.clear();
        this.eachDistance.clear();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public Marker getMarker()
  {
    return this.marker;
  }
  
  public LatLng getPosition()
  {
    if (this.marker == null) {
      return null;
    }
    return this.marker.getPosition();
  }
  
  public void removeMarker()
  {
    if (this.marker != null)
    {
      this.marker.remove();
      this.marker = null;
    }
    this.points.clear();
    this.eachDistance.clear();
  }
  
  public void resetIndex()
  {
    this.index = 0;
  }
  
  public void setDescriptor(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.descriptor != null) {
      this.descriptor.recycle();
    }
    this.descriptor = paramBitmapDescriptor;
    if (this.marker != null) {
      this.marker.setIcon(paramBitmapDescriptor);
    }
  }
  
  public void setMoveListener(MoveListener paramMoveListener)
  {
    this.moveListener = paramMoveListener;
  }
  
  /* Error */
  public void setPoints(java.util.List<LatLng> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/amap/api/maps/utils/overlay/SmoothMoveMarker:mLock	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +298 -> 308
    //   13: aload_1
    //   14: invokeinterface 318 1 0
    //   19: iconst_2
    //   20: if_icmpge +6 -> 26
    //   23: goto +285 -> 308
    //   26: aload_0
    //   27: invokevirtual 321	com/amap/api/maps/utils/overlay/SmoothMoveMarker:stopMove	()V
    //   30: aload_0
    //   31: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   34: invokevirtual 297	java/util/LinkedList:clear	()V
    //   37: aload_1
    //   38: invokeinterface 325 1 0
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface 331 1 0
    //   50: ifeq +32 -> 82
    //   53: aload_1
    //   54: invokeinterface 335 1 0
    //   59: checkcast 177	com/amap/api/maps/model/LatLng
    //   62: astore 8
    //   64: aload 8
    //   66: ifnull -22 -> 44
    //   69: aload_0
    //   70: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   73: aload 8
    //   75: invokevirtual 339	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -35 -> 44
    //   82: aload_0
    //   83: getfield 74	com/amap/api/maps/utils/overlay/SmoothMoveMarker:eachDistance	Ljava/util/LinkedList;
    //   86: invokevirtual 297	java/util/LinkedList:clear	()V
    //   89: aload_0
    //   90: dconst_0
    //   91: putfield 76	com/amap/api/maps/utils/overlay/SmoothMoveMarker:totalDistance	D
    //   94: iconst_0
    //   95: istore 6
    //   97: iload 6
    //   99: aload_0
    //   100: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   103: invokevirtual 171	java/util/LinkedList:size	()I
    //   106: iconst_1
    //   107: isub
    //   108: if_icmpge +78 -> 186
    //   111: aload_0
    //   112: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   115: iload 6
    //   117: invokevirtual 175	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   120: checkcast 177	com/amap/api/maps/model/LatLng
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   128: astore 8
    //   130: iload 6
    //   132: iconst_1
    //   133: iadd
    //   134: istore 6
    //   136: aload_1
    //   137: aload 8
    //   139: iload 6
    //   141: invokevirtual 175	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   144: checkcast 177	com/amap/api/maps/model/LatLng
    //   147: invokestatic 223	com/amap/api/maps/AMapUtils:calculateLineDistance	(Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;)F
    //   150: f2d
    //   151: dstore_2
    //   152: aload_0
    //   153: getfield 74	com/amap/api/maps/utils/overlay/SmoothMoveMarker:eachDistance	Ljava/util/LinkedList;
    //   156: dload_2
    //   157: invokestatic 343	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   160: invokevirtual 339	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload_0
    //   165: getfield 76	com/amap/api/maps/utils/overlay/SmoothMoveMarker:totalDistance	D
    //   168: dstore 4
    //   170: dload_2
    //   171: invokestatic 207	java/lang/Double:isNaN	(D)Z
    //   174: pop
    //   175: aload_0
    //   176: dload 4
    //   178: dload_2
    //   179: dadd
    //   180: putfield 76	com/amap/api/maps/utils/overlay/SmoothMoveMarker:totalDistance	D
    //   183: goto -86 -> 97
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 76	com/amap/api/maps/utils/overlay/SmoothMoveMarker:totalDistance	D
    //   191: putfield 78	com/amap/api/maps/utils/overlay/SmoothMoveMarker:remainDistance	D
    //   194: aload_0
    //   195: getfield 72	com/amap/api/maps/utils/overlay/SmoothMoveMarker:points	Ljava/util/LinkedList;
    //   198: iconst_0
    //   199: invokevirtual 175	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   202: checkcast 177	com/amap/api/maps/model/LatLng
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 82	com/amap/api/maps/utils/overlay/SmoothMoveMarker:marker	Lcom/amap/api/maps/model/Marker;
    //   210: ifnull +18 -> 228
    //   213: aload_0
    //   214: getfield 82	com/amap/api/maps/utils/overlay/SmoothMoveMarker:marker	Lcom/amap/api/maps/model/Marker;
    //   217: aload_1
    //   218: invokevirtual 347	com/amap/api/maps/model/Marker:setPosition	(Lcom/amap/api/maps/model/LatLng;)V
    //   221: aload_0
    //   222: invokespecial 349	com/amap/api/maps/utils/overlay/SmoothMoveMarker:checkMarkerIcon	()V
    //   225: goto +63 -> 288
    //   228: aload_0
    //   229: getfield 155	com/amap/api/maps/utils/overlay/SmoothMoveMarker:descriptor	Lcom/amap/api/maps/model/BitmapDescriptor;
    //   232: ifnonnull +8 -> 240
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield 86	com/amap/api/maps/utils/overlay/SmoothMoveMarker:useDefaultDescriptor	Z
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 107	com/amap/api/maps/utils/overlay/SmoothMoveMarker:mAMap	Lcom/amap/api/maps/AMap;
    //   245: new 351	com/amap/api/maps/model/MarkerOptions
    //   248: dup
    //   249: invokespecial 352	com/amap/api/maps/model/MarkerOptions:<init>	()V
    //   252: iconst_1
    //   253: invokevirtual 356	com/amap/api/maps/model/MarkerOptions:belowMaskLayer	(Z)Lcom/amap/api/maps/model/MarkerOptions;
    //   256: aload_1
    //   257: invokevirtual 360	com/amap/api/maps/model/MarkerOptions:position	(Lcom/amap/api/maps/model/LatLng;)Lcom/amap/api/maps/model/MarkerOptions;
    //   260: aload_0
    //   261: getfield 155	com/amap/api/maps/utils/overlay/SmoothMoveMarker:descriptor	Lcom/amap/api/maps/model/BitmapDescriptor;
    //   264: invokevirtual 364	com/amap/api/maps/model/MarkerOptions:icon	(Lcom/amap/api/maps/model/BitmapDescriptor;)Lcom/amap/api/maps/model/MarkerOptions;
    //   267: ldc_w 366
    //   270: invokevirtual 370	com/amap/api/maps/model/MarkerOptions:title	(Ljava/lang/String;)Lcom/amap/api/maps/model/MarkerOptions;
    //   273: ldc_w 371
    //   276: ldc_w 371
    //   279: invokevirtual 375	com/amap/api/maps/model/MarkerOptions:anchor	(FF)Lcom/amap/api/maps/model/MarkerOptions;
    //   282: invokevirtual 379	com/amap/api/maps/AMap:addMarker	(Lcom/amap/api/maps/model/MarkerOptions;)Lcom/amap/api/maps/model/Marker;
    //   285: putfield 82	com/amap/api/maps/utils/overlay/SmoothMoveMarker:marker	Lcom/amap/api/maps/model/Marker;
    //   288: aload_0
    //   289: invokespecial 283	com/amap/api/maps/utils/overlay/SmoothMoveMarker:reset	()V
    //   292: goto +12 -> 304
    //   295: astore_1
    //   296: goto +16 -> 312
    //   299: astore_1
    //   300: aload_1
    //   301: invokevirtual 298	java/lang/Throwable:printStackTrace	()V
    //   304: aload 7
    //   306: monitorexit
    //   307: return
    //   308: aload 7
    //   310: monitorexit
    //   311: return
    //   312: aload 7
    //   314: monitorexit
    //   315: aload_1
    //   316: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	SmoothMoveMarker
    //   0	317	1	paramList	java.util.List<LatLng>
    //   151	28	2	d1	double
    //   168	9	4	d2	double
    //   95	45	6	i	int
    //   4	309	7	localObject1	Object
    //   62	76	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	23	295	finally
    //   26	44	295	finally
    //   44	64	295	finally
    //   69	79	295	finally
    //   82	94	295	finally
    //   97	130	295	finally
    //   136	170	295	finally
    //   175	183	295	finally
    //   186	225	295	finally
    //   228	240	295	finally
    //   240	288	295	finally
    //   288	292	295	finally
    //   300	304	295	finally
    //   304	307	295	finally
    //   308	311	295	finally
    //   312	315	295	finally
    //   13	23	299	java/lang/Throwable
    //   26	44	299	java/lang/Throwable
    //   44	64	299	java/lang/Throwable
    //   69	79	299	java/lang/Throwable
    //   82	94	299	java/lang/Throwable
    //   97	130	299	java/lang/Throwable
    //   136	170	299	java/lang/Throwable
    //   175	183	299	java/lang/Throwable
    //   186	225	299	java/lang/Throwable
    //   228	240	299	java/lang/Throwable
    //   240	288	299	java/lang/Throwable
    //   288	292	299	java/lang/Throwable
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (this.marker != null)
    {
      this.marker.setPosition(paramLatLng);
      checkMarkerIcon();
      return;
    }
    if (this.descriptor == null) {
      this.useDefaultDescriptor = true;
    }
    this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(paramLatLng).icon(this.descriptor).title("").anchor(0.5F, 0.5F));
  }
  
  public void setRotate(float paramFloat)
  {
    if ((this.marker != null) && (this.mAMap != null) && (this.mAMap != null))
    {
      CameraPosition localCameraPosition = this.mAMap.getCameraPosition();
      if (localCameraPosition != null) {
        this.marker.setRotateAngle(360.0F - paramFloat + localCameraPosition.bearing);
      }
    }
  }
  
  public void setTotalDuration(int paramInt)
  {
    this.duration = (paramInt * 1000);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.marker != null) {
      this.marker.setVisible(paramBoolean);
    }
  }
  
  public void startSmoothMove()
  {
    if (this.moveStatus == a.d)
    {
      this.moveStatus = a.c;
      long l1 = System.currentTimeMillis();
      long l2 = this.pauseMillis;
      this.mAnimationBeginTime += l1 - l2;
      return;
    }
    if ((this.moveStatus == a.a) || (this.moveStatus == a.e))
    {
      if (this.points.size() < 1) {
        return;
      }
      this.index = 0;
      try
      {
        this.mThreadPools.execute(new c(null));
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void stopMove()
  {
    if (this.moveStatus == a.c)
    {
      this.moveStatus = a.d;
      this.pauseMillis = System.currentTimeMillis();
    }
  }
  
  public static abstract interface MoveListener
  {
    public abstract void move(double paramDouble);
  }
  
  private static enum a
  {
    private a() {}
  }
  
  private static class b
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      return new Thread(paramRunnable, "MoveSmoothThread");
    }
  }
  
  private class c
    implements Runnable
  {
    private c() {}
    
    public void run()
    {
      try
      {
        SmoothMoveMarker.access$202(SmoothMoveMarker.this, System.currentTimeMillis());
        SmoothMoveMarker.access$302(SmoothMoveMarker.this, SmoothMoveMarker.a.b);
        SmoothMoveMarker.this.exitFlag.set(false);
        while ((!SmoothMoveMarker.this.exitFlag.get()) && (SmoothMoveMarker.this.index <= SmoothMoveMarker.this.points.size() - 1)) {
          synchronized (SmoothMoveMarker.this.mLock)
          {
            if (SmoothMoveMarker.this.exitFlag.get()) {
              return;
            }
            if (SmoothMoveMarker.this.moveStatus != SmoothMoveMarker.a.d)
            {
              long l1 = System.currentTimeMillis();
              long l2 = SmoothMoveMarker.this.mAnimationBeginTime;
              IPoint localIPoint = SmoothMoveMarker.this.getCurPosition(l1 - l2);
              if (SmoothMoveMarker.this.marker != null) {
                SmoothMoveMarker.this.marker.setGeoPoint(localIPoint);
              }
              SmoothMoveMarker.access$302(SmoothMoveMarker.this, SmoothMoveMarker.a.c);
            }
            Thread.sleep(SmoothMoveMarker.this.mStepDuration);
          }
        }
        SmoothMoveMarker.access$302(SmoothMoveMarker.this, SmoothMoveMarker.a.e);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\utils\overlay\SmoothMoveMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */