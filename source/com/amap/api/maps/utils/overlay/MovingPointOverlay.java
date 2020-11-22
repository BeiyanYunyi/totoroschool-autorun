package com.amap.api.maps.utils.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MovingPointOverlay
{
  private a STATUS = a.a;
  private BasePointOverlay baseOverlay = null;
  private long duration = 10000L;
  private LinkedList<Double> eachDistance = new LinkedList();
  AtomicBoolean exitFlag = new AtomicBoolean(false);
  private int index = 0;
  private AMap mAMap;
  private long mAnimationBeginTime = System.currentTimeMillis();
  private Object mLock = new Object();
  private long mStepDuration = 20L;
  private ExecutorService mThreadPools;
  private MoveListener moveListener;
  private long pauseMillis;
  private LinkedList<LatLng> points = new LinkedList();
  private double remainDistance = 0.0D;
  private double totalDistance = 0.0D;
  private boolean useDefaultDescriptor = false;
  
  public MovingPointOverlay(AMap paramAMap, BasePointOverlay paramBasePointOverlay)
  {
    if (paramAMap != null)
    {
      if (paramBasePointOverlay == null) {
        return;
      }
      this.mAMap = paramAMap;
      this.mThreadPools = new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new b(null));
      this.baseOverlay = paramBasePointOverlay;
      return;
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
    if (AMapUtils.calculateLineDistance((LatLng)localObject, localLatLng) > 1.0F)
    {
      float f = getRotate(localIPoint1, localIPoint2);
      if (this.mAMap != null)
      {
        localObject = this.mAMap.getCameraPosition();
        if (localObject != null) {
          this.baseOverlay.setRotateAngle(360.0F - f + ((CameraPosition)localObject).bearing);
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
      if ((this.STATUS == a.c) || (this.STATUS == a.d))
      {
        this.exitFlag.set(true);
        this.mThreadPools.awaitTermination(this.mStepDuration + 20L, TimeUnit.MILLISECONDS);
        this.baseOverlay.setAnimation(null);
        this.STATUS = a.a;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void destroy()
  {
    try
    {
      removeMarker();
      this.mThreadPools.shutdownNow();
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
  
  public BasePointOverlay getObject()
  {
    return this.baseOverlay;
  }
  
  public LatLng getPosition()
  {
    if (this.baseOverlay != null) {
      return this.baseOverlay.getPosition();
    }
    return null;
  }
  
  public void removeMarker()
  {
    try
    {
      reset();
      if (this.baseOverlay != null)
      {
        this.baseOverlay.remove();
        this.baseOverlay = null;
      }
      this.points.clear();
      this.eachDistance.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void resetIndex()
  {
    this.index = 0;
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
    //   1: getfield 75	com/amap/api/maps/utils/overlay/MovingPointOverlay:mLock	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +224 -> 234
    //   13: aload_1
    //   14: invokeinterface 301 1 0
    //   19: iconst_2
    //   20: if_icmpge +6 -> 26
    //   23: goto +211 -> 234
    //   26: aload_0
    //   27: invokevirtual 304	com/amap/api/maps/utils/overlay/MovingPointOverlay:stopMove	()V
    //   30: aload_0
    //   31: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   34: invokevirtual 280	java/util/LinkedList:clear	()V
    //   37: aload_1
    //   38: invokeinterface 308 1 0
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface 314 1 0
    //   50: ifeq +32 -> 82
    //   53: aload_1
    //   54: invokeinterface 318 1 0
    //   59: checkcast 163	com/amap/api/maps/model/LatLng
    //   62: astore 8
    //   64: aload 8
    //   66: ifnull -22 -> 44
    //   69: aload_0
    //   70: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   73: aload 8
    //   75: invokevirtual 322	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -35 -> 44
    //   82: aload_0
    //   83: getfield 69	com/amap/api/maps/utils/overlay/MovingPointOverlay:eachDistance	Ljava/util/LinkedList;
    //   86: invokevirtual 280	java/util/LinkedList:clear	()V
    //   89: aload_0
    //   90: dconst_0
    //   91: putfield 71	com/amap/api/maps/utils/overlay/MovingPointOverlay:totalDistance	D
    //   94: iconst_0
    //   95: istore 6
    //   97: iload 6
    //   99: aload_0
    //   100: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   103: invokevirtual 157	java/util/LinkedList:size	()I
    //   106: iconst_1
    //   107: isub
    //   108: if_icmpge +78 -> 186
    //   111: aload_0
    //   112: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   115: iload 6
    //   117: invokevirtual 161	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   120: checkcast 163	com/amap/api/maps/model/LatLng
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   128: astore 8
    //   130: iload 6
    //   132: iconst_1
    //   133: iadd
    //   134: istore 6
    //   136: aload_1
    //   137: aload 8
    //   139: iload 6
    //   141: invokevirtual 161	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   144: checkcast 163	com/amap/api/maps/model/LatLng
    //   147: invokestatic 209	com/amap/api/maps/AMapUtils:calculateLineDistance	(Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;)F
    //   150: f2d
    //   151: dstore_2
    //   152: aload_0
    //   153: getfield 69	com/amap/api/maps/utils/overlay/MovingPointOverlay:eachDistance	Ljava/util/LinkedList;
    //   156: dload_2
    //   157: invokestatic 326	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   160: invokevirtual 322	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload_0
    //   165: getfield 71	com/amap/api/maps/utils/overlay/MovingPointOverlay:totalDistance	D
    //   168: dstore 4
    //   170: dload_2
    //   171: invokestatic 193	java/lang/Double:isNaN	(D)Z
    //   174: pop
    //   175: aload_0
    //   176: dload 4
    //   178: dload_2
    //   179: dadd
    //   180: putfield 71	com/amap/api/maps/utils/overlay/MovingPointOverlay:totalDistance	D
    //   183: goto -86 -> 97
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 71	com/amap/api/maps/utils/overlay/MovingPointOverlay:totalDistance	D
    //   191: putfield 73	com/amap/api/maps/utils/overlay/MovingPointOverlay:remainDistance	D
    //   194: aload_0
    //   195: getfield 67	com/amap/api/maps/utils/overlay/MovingPointOverlay:points	Ljava/util/LinkedList;
    //   198: iconst_0
    //   199: invokevirtual 161	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   202: checkcast 163	com/amap/api/maps/model/LatLng
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 77	com/amap/api/maps/utils/overlay/MovingPointOverlay:baseOverlay	Lcom/amap/api/maps/model/BasePointOverlay;
    //   210: aload_1
    //   211: invokevirtual 330	com/amap/api/maps/model/BasePointOverlay:setPosition	(Lcom/amap/api/maps/model/LatLng;)V
    //   214: aload_0
    //   215: invokespecial 290	com/amap/api/maps/utils/overlay/MovingPointOverlay:reset	()V
    //   218: goto +12 -> 230
    //   221: astore_1
    //   222: goto +16 -> 238
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 281	java/lang/Throwable:printStackTrace	()V
    //   230: aload 7
    //   232: monitorexit
    //   233: return
    //   234: aload 7
    //   236: monitorexit
    //   237: return
    //   238: aload 7
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	MovingPointOverlay
    //   0	243	1	paramList	java.util.List<LatLng>
    //   151	28	2	d1	double
    //   168	9	4	d2	double
    //   95	45	6	i	int
    //   4	235	7	localObject1	Object
    //   62	76	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	23	221	finally
    //   26	44	221	finally
    //   44	64	221	finally
    //   69	79	221	finally
    //   82	94	221	finally
    //   97	130	221	finally
    //   136	170	221	finally
    //   175	183	221	finally
    //   186	218	221	finally
    //   226	230	221	finally
    //   230	233	221	finally
    //   234	237	221	finally
    //   238	241	221	finally
    //   13	23	225	java/lang/Throwable
    //   26	44	225	java/lang/Throwable
    //   44	64	225	java/lang/Throwable
    //   69	79	225	java/lang/Throwable
    //   82	94	225	java/lang/Throwable
    //   97	130	225	java/lang/Throwable
    //   136	170	225	java/lang/Throwable
    //   175	183	225	java/lang/Throwable
    //   186	218	225	java/lang/Throwable
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      if (this.baseOverlay != null)
      {
        this.baseOverlay.setPosition(paramLatLng);
        return;
      }
    }
    catch (Exception paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setRotate(float paramFloat)
  {
    try
    {
      if ((this.baseOverlay != null) && (this.mAMap != null))
      {
        CameraPosition localCameraPosition = this.mAMap.getCameraPosition();
        if (localCameraPosition != null)
        {
          this.baseOverlay.setRotateAngle(360.0F - paramFloat + localCameraPosition.bearing);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setTotalDuration(int paramInt)
  {
    this.duration = (paramInt * 1000);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      if (this.baseOverlay != null)
      {
        this.baseOverlay.setVisible(paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startSmoothMove()
  {
    if (this.STATUS == a.d)
    {
      this.STATUS = a.c;
      long l1 = System.currentTimeMillis();
      long l2 = this.pauseMillis;
      this.mAnimationBeginTime += l1 - l2;
      return;
    }
    if ((this.STATUS == a.a) || (this.STATUS == a.e))
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
    if (this.STATUS == a.c)
    {
      this.STATUS = a.d;
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
  
  private class b
    implements ThreadFactory
  {
    private b() {}
    
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
        MovingPointOverlay.access$202(MovingPointOverlay.this, System.currentTimeMillis());
        MovingPointOverlay.access$302(MovingPointOverlay.this, MovingPointOverlay.a.b);
        MovingPointOverlay.this.exitFlag.set(false);
        while ((!MovingPointOverlay.this.exitFlag.get()) && (MovingPointOverlay.this.index <= MovingPointOverlay.this.points.size() - 1)) {
          synchronized (MovingPointOverlay.this.mLock)
          {
            if (MovingPointOverlay.this.exitFlag.get()) {
              return;
            }
            if (MovingPointOverlay.this.STATUS != MovingPointOverlay.a.d)
            {
              long l1 = System.currentTimeMillis();
              long l2 = MovingPointOverlay.this.mAnimationBeginTime;
              IPoint localIPoint = MovingPointOverlay.this.getCurPosition(l1 - l2);
              MovingPointOverlay.this.baseOverlay.setGeoPoint(localIPoint);
              MovingPointOverlay.access$302(MovingPointOverlay.this, MovingPointOverlay.a.c);
            }
            Thread.sleep(MovingPointOverlay.this.mStepDuration);
          }
        }
        MovingPointOverlay.access$302(MovingPointOverlay.this, MovingPointOverlay.a.e);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\utils\overlay\MovingPointOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */