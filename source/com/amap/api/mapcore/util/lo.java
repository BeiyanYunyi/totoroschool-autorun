package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class lo
  implements IGlOverlayLayer
{
  IAMapDelegate a;
  a b = new a();
  private cl c;
  private int d = 0;
  private List<IOverlayDelegate> e = new Vector(500);
  private List<lu> f = new ArrayList();
  private int[] g = new int[1];
  private volatile boolean h = false;
  private Handler i = new Handler(Looper.getMainLooper());
  private Runnable j = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 14	com/amap/api/mapcore/util/lo$1:a	Lcom/amap/api/mapcore/util/lo;
      //   6: astore_1
      //   7: aload_1
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 14	com/amap/api/mapcore/util/lo$1:a	Lcom/amap/api/mapcore/util/lo;
      //   13: invokestatic 24	com/amap/api/mapcore/util/lo:a	(Lcom/amap/api/mapcore/util/lo;)Ljava/util/List;
      //   16: ifnull +35 -> 51
      //   19: aload_0
      //   20: getfield 14	com/amap/api/mapcore/util/lo$1:a	Lcom/amap/api/mapcore/util/lo;
      //   23: invokestatic 24	com/amap/api/mapcore/util/lo:a	(Lcom/amap/api/mapcore/util/lo;)Ljava/util/List;
      //   26: invokeinterface 30 1 0
      //   31: ifle +20 -> 51
      //   34: aload_0
      //   35: getfield 14	com/amap/api/mapcore/util/lo$1:a	Lcom/amap/api/mapcore/util/lo;
      //   38: invokestatic 24	com/amap/api/mapcore/util/lo:a	(Lcom/amap/api/mapcore/util/lo;)Ljava/util/List;
      //   41: aload_0
      //   42: getfield 14	com/amap/api/mapcore/util/lo$1:a	Lcom/amap/api/mapcore/util/lo;
      //   45: getfield 34	com/amap/api/mapcore/util/lo:b	Lcom/amap/api/mapcore/util/lo$a;
      //   48: invokestatic 40	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   51: aload_1
      //   52: monitorexit
      //   53: goto +21 -> 74
      //   56: astore_2
      //   57: aload_1
      //   58: monitorexit
      //   59: aload_2
      //   60: athrow
      //   61: astore_1
      //   62: goto +15 -> 77
      //   65: astore_1
      //   66: aload_1
      //   67: ldc 42
      //   69: ldc 44
      //   71: invokestatic 50	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   74: aload_0
      //   75: monitorexit
      //   76: return
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	1
      //   61	1	1	localObject1	Object
      //   65	15	1	localThrowable	Throwable
      //   56	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   9	51	56	finally
      //   51	53	56	finally
      //   57	59	56	finally
      //   2	9	61	finally
      //   59	61	61	finally
      //   66	74	61	finally
      //   2	9	65	java/lang/Throwable
      //   59	61	65	java/lang/Throwable
    }
  };
  
  public lo(IAMapDelegate paramIAMapDelegate)
  {
    this.a = paramIAMapDelegate;
  }
  
  private void a(IOverlayDelegate paramIOverlayDelegate)
    throws RemoteException
  {
    this.e.add(paramIOverlayDelegate);
    e();
  }
  
  private void i()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      IOverlayDelegate localIOverlayDelegate = (IOverlayDelegate)localIterator.next();
      if ((localIOverlayDelegate != null) && (((localIOverlayDelegate instanceof bv)) || ((localIOverlayDelegate instanceof bz)))) {
        localIOverlayDelegate.destroy();
      }
    }
  }
  
  public boolean IsCircleContainPoint(CircleOptions paramCircleOptions, LatLng paramLatLng)
  {
    return false;
  }
  
  public boolean IsPolygonContainsPoint(PolygonOptions paramPolygonOptions, LatLng paramLatLng)
  {
    return false;
  }
  
  public lu a(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.a != null) {
      return this.a.getTextureItem(paramBitmapDescriptor, true);
    }
    return null;
  }
  
  public IBuildingDelegate a()
    throws RemoteException
  {
    try
    {
      bv localbv = new bv(this);
      localbv.a(this.c);
      a(localbv);
      return localbv;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public IParticleLatyer a(ParticleOverlayOptions paramParticleOverlayOptions)
    throws RemoteException
  {
    if (paramParticleOverlayOptions == null) {
      return null;
    }
    try
    {
      cd localcd = new cd(this);
      localcd.a(paramParticleOverlayOptions);
      a(localcd);
      return localcd;
    }
    finally
    {
      paramParticleOverlayOptions = finally;
      throw paramParticleOverlayOptions;
    }
  }
  
  public IHeatMapLayer a(HeatMapLayerOptions paramHeatMapLayerOptions)
    throws RemoteException
  {
    try
    {
      bz localbz = new bz(this);
      localbz.a(this.c);
      localbz.setOptions(paramHeatMapLayerOptions);
      a(localbz);
      return localbz;
    }
    finally
    {
      paramHeatMapLayerOptions = finally;
      throw paramHeatMapLayerOptions;
    }
  }
  
  public IArcDelegate a(ArcOptions paramArcOptions)
    throws RemoteException
  {
    if (paramArcOptions == null) {
      return null;
    }
    try
    {
      bu localbu = new bu(this.a);
      localbu.setStrokeColor(paramArcOptions.getStrokeColor());
      localbu.setStart(paramArcOptions.getStart());
      localbu.setPassed(paramArcOptions.getPassed());
      localbu.setEnd(paramArcOptions.getEnd());
      localbu.setVisible(paramArcOptions.isVisible());
      localbu.setStrokeWidth(paramArcOptions.getStrokeWidth());
      localbu.setZIndex(paramArcOptions.getZIndex());
      a(localbu);
      return localbu;
    }
    finally
    {
      paramArcOptions = finally;
      throw paramArcOptions;
    }
  }
  
  public ICircleDelegate a(CircleOptions paramCircleOptions)
    throws RemoteException
  {
    if (paramCircleOptions == null) {
      return null;
    }
    try
    {
      bw localbw = new bw(this.a);
      localbw.setFillColor(paramCircleOptions.getFillColor());
      localbw.setCenter(paramCircleOptions.getCenter());
      localbw.setVisible(paramCircleOptions.isVisible());
      localbw.setHoleOptions(paramCircleOptions.getHoleOptions());
      localbw.setStrokeWidth(paramCircleOptions.getStrokeWidth());
      localbw.setZIndex(paramCircleOptions.getZIndex());
      localbw.setStrokeColor(paramCircleOptions.getStrokeColor());
      localbw.setRadius(paramCircleOptions.getRadius());
      localbw.setDottedLineType(paramCircleOptions.getStrokeDottedLineType());
      localbw.a(paramCircleOptions.isUsePolylineStroke());
      a(localbw);
      return localbw;
    }
    finally
    {
      paramCircleOptions = finally;
      throw paramCircleOptions;
    }
  }
  
  public IGroundOverlayDelegate a(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException
  {
    if (paramGroundOverlayOptions == null) {
      return null;
    }
    try
    {
      by localby = new by(this.a, this);
      localby.setAnchor(paramGroundOverlayOptions.getAnchorU(), paramGroundOverlayOptions.getAnchorV());
      localby.setDimensions(paramGroundOverlayOptions.getWidth(), paramGroundOverlayOptions.getHeight());
      localby.setImage(paramGroundOverlayOptions.getImage());
      localby.setPosition(paramGroundOverlayOptions.getLocation());
      localby.setPositionFromBounds(paramGroundOverlayOptions.getBounds());
      localby.setBearing(paramGroundOverlayOptions.getBearing());
      localby.setTransparency(paramGroundOverlayOptions.getTransparency());
      localby.setVisible(paramGroundOverlayOptions.isVisible());
      localby.setZIndex(paramGroundOverlayOptions.getZIndex());
      a(localby);
      return localby;
    }
    finally
    {
      paramGroundOverlayOptions = finally;
      throw paramGroundOverlayOptions;
    }
  }
  
  public INavigateArrowDelegate a(NavigateArrowOptions paramNavigateArrowOptions)
    throws RemoteException
  {
    if (paramNavigateArrowOptions == null) {
      return null;
    }
    try
    {
      cc localcc = new cc(this.a);
      localcc.setTopColor(paramNavigateArrowOptions.getTopColor());
      localcc.setSideColor(paramNavigateArrowOptions.getSideColor());
      localcc.setPoints(paramNavigateArrowOptions.getPoints());
      localcc.setVisible(paramNavigateArrowOptions.isVisible());
      localcc.setWidth(paramNavigateArrowOptions.getWidth());
      localcc.setZIndex(paramNavigateArrowOptions.getZIndex());
      localcc.set3DModel(paramNavigateArrowOptions.is3DModel());
      a(localcc);
      return localcc;
    }
    finally
    {
      paramNavigateArrowOptions = finally;
      throw paramNavigateArrowOptions;
    }
  }
  
  public IOverlayDelegate a(LatLng paramLatLng)
  {
    try
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        IOverlayDelegate localIOverlayDelegate = (IOverlayDelegate)localIterator.next();
        if ((localIOverlayDelegate != null) && (localIOverlayDelegate.isDrawFinish()) && ((localIOverlayDelegate instanceof IPolylineDelegate)))
        {
          boolean bool = ((IPolylineDelegate)localIOverlayDelegate).contains(paramLatLng);
          if (bool) {
            return localIOverlayDelegate;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public IPolygonDelegate a(PolygonOptions paramPolygonOptions)
    throws RemoteException
  {
    if (paramPolygonOptions == null) {
      return null;
    }
    try
    {
      ce localce = new ce(this.a);
      localce.setFillColor(paramPolygonOptions.getFillColor());
      localce.setPoints(paramPolygonOptions.getPoints());
      localce.setHoleOptions(paramPolygonOptions.getHoleOptions());
      localce.setVisible(paramPolygonOptions.isVisible());
      localce.setStrokeWidth(paramPolygonOptions.getStrokeWidth());
      localce.setStrokeColor(paramPolygonOptions.getStrokeColor());
      localce.setZIndex(paramPolygonOptions.getZIndex());
      localce.a(paramPolygonOptions.getLineJoinType());
      localce.a(paramPolygonOptions.isUsePolylineStroke());
      a(localce);
      return localce;
    }
    finally
    {
      paramPolygonOptions = finally;
      throw paramPolygonOptions;
    }
  }
  
  public IPolylineDelegate a(PolylineOptions paramPolylineOptions)
    throws RemoteException
  {
    if (paramPolylineOptions == null) {
      return null;
    }
    try
    {
      paramPolylineOptions = new cf(this, paramPolylineOptions);
      if (this.c != null) {
        paramPolylineOptions.a(this.c);
      }
      a(paramPolylineOptions);
      return paramPolylineOptions;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    try
    {
      this.d += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(this.d);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(cl paramcl)
  {
    this.c = paramcl;
  }
  
  public void a(lu paramlu)
  {
    List localList = this.f;
    if (paramlu != null) {}
    try
    {
      this.f.add(paramlu);
      return;
    }
    finally
    {
      for (;;) {}
    }
    throw paramlu;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setRunLowFrame(paramBoolean);
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 429	com/amap/api/mapcore/util/lo:f	()V
    //   6: aload_0
    //   7: getfield 77	com/amap/api/mapcore/util/lo:a	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   10: invokeinterface 433 1 0
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 54	com/amap/api/mapcore/util/lo:h	Z
    //   29: ifeq +17 -> 46
    //   32: aload_0
    //   33: getfield 72	com/amap/api/mapcore/util/lo:j	Ljava/lang/Runnable;
    //   36: invokeinterface 438 1 0
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 54	com/amap/api/mapcore/util/lo:h	Z
    //   46: aload_0
    //   47: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   50: invokeinterface 441 1 0
    //   55: istore_3
    //   56: aload_0
    //   57: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   60: invokeinterface 95 1 0
    //   65: astore 5
    //   67: aload 5
    //   69: invokeinterface 101 1 0
    //   74: ifeq +167 -> 241
    //   77: aload 5
    //   79: invokeinterface 105 1 0
    //   84: checkcast 107	com/autonavi/base/amap/api/mapcore/overlays/IOverlayDelegate
    //   87: astore 6
    //   89: aload 6
    //   91: invokeinterface 442 1 0
    //   96: ifeq -29 -> 67
    //   99: iload_3
    //   100: bipush 20
    //   102: if_icmple +67 -> 169
    //   105: aload 6
    //   107: invokeinterface 445 1 0
    //   112: ifeq -45 -> 67
    //   115: iload_1
    //   116: ifeq +28 -> 144
    //   119: aload 6
    //   121: invokeinterface 446 1 0
    //   126: iload_2
    //   127: i2f
    //   128: fcmpg
    //   129: ifgt -62 -> 67
    //   132: aload 6
    //   134: aload 4
    //   136: invokeinterface 450 2 0
    //   141: goto -74 -> 67
    //   144: aload 6
    //   146: invokeinterface 446 1 0
    //   151: iload_2
    //   152: i2f
    //   153: fcmpl
    //   154: ifle -87 -> 67
    //   157: aload 6
    //   159: aload 4
    //   161: invokeinterface 450 2 0
    //   166: goto -99 -> 67
    //   169: iload_1
    //   170: ifeq +28 -> 198
    //   173: aload 6
    //   175: invokeinterface 446 1 0
    //   180: iload_2
    //   181: i2f
    //   182: fcmpg
    //   183: ifgt -116 -> 67
    //   186: aload 6
    //   188: aload 4
    //   190: invokeinterface 450 2 0
    //   195: goto -128 -> 67
    //   198: aload 6
    //   200: invokeinterface 446 1 0
    //   205: iload_2
    //   206: i2f
    //   207: fcmpl
    //   208: ifle -141 -> 67
    //   211: aload 6
    //   213: aload 4
    //   215: invokeinterface 450 2 0
    //   220: goto -153 -> 67
    //   223: astore 4
    //   225: goto +19 -> 244
    //   228: astore 4
    //   230: aload 4
    //   232: ldc_w 452
    //   235: ldc_w 453
    //   238: invokestatic 458	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: monitorexit
    //   243: return
    //   244: aload_0
    //   245: monitorexit
    //   246: aload 4
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	lo
    //   0	249	1	paramBoolean	boolean
    //   0	249	2	paramInt	int
    //   55	48	3	k	int
    //   15	199	4	localMapConfig	com.autonavi.base.amap.mapcore.MapConfig
    //   223	1	4	localObject	Object
    //   228	19	4	localThrowable	Throwable
    //   65	13	5	localIterator	Iterator
    //   87	125	6	localIOverlayDelegate	IOverlayDelegate
    // Exception table:
    //   from	to	target	type
    //   2	17	223	finally
    //   25	46	223	finally
    //   46	67	223	finally
    //   67	99	223	finally
    //   105	115	223	finally
    //   119	141	223	finally
    //   144	166	223	finally
    //   173	195	223	finally
    //   198	220	223	finally
    //   230	241	223	finally
    //   2	17	228	java/lang/Throwable
    //   25	46	228	java/lang/Throwable
    //   46	67	228	java/lang/Throwable
    //   67	99	228	java/lang/Throwable
    //   105	115	228	java/lang/Throwable
    //   119	141	228	java/lang/Throwable
    //   144	166	228	java/lang/Throwable
    //   173	195	228	java/lang/Throwable
    //   198	220	228	java/lang/Throwable
  }
  
  public boolean a(String paramString, boolean paramBoolean)
    throws RemoteException
  {
    try
    {
      paramString = c(paramString);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramString.destroy();
        }
        paramBoolean = this.e.remove(paramString);
        return paramBoolean;
      }
      return false;
    }
    finally {}
  }
  
  public cl b()
  {
    return this.c;
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 469	com/amap/api/mapcore/util/lo:i	()V
    //   6: aload_1
    //   7: ifnull +92 -> 99
    //   10: aload_1
    //   11: invokevirtual 474	java/lang/String:trim	()Ljava/lang/String;
    //   14: invokevirtual 477	java/lang/String:length	()I
    //   17: ifne +6 -> 23
    //   20: goto +79 -> 99
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_0
    //   26: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   29: invokeinterface 95 1 0
    //   34: astore 4
    //   36: aload_3
    //   37: astore_2
    //   38: aload 4
    //   40: invokeinterface 101 1 0
    //   45: ifeq +27 -> 72
    //   48: aload 4
    //   50: invokeinterface 105 1 0
    //   55: checkcast 107	com/autonavi/base/amap/api/mapcore/overlays/IOverlayDelegate
    //   58: astore_2
    //   59: aload_1
    //   60: aload_2
    //   61: invokeinterface 480 1 0
    //   66: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq -33 -> 36
    //   72: aload_0
    //   73: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   76: invokeinterface 486 1 0
    //   81: aload_2
    //   82: ifnull +52 -> 134
    //   85: aload_0
    //   86: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   89: aload_2
    //   90: invokeinterface 88 2 0
    //   95: pop
    //   96: goto +38 -> 134
    //   99: aload_0
    //   100: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   103: invokeinterface 486 1 0
    //   108: aload_0
    //   109: invokevirtual 488	com/amap/api/mapcore/util/lo:c	()V
    //   112: goto +22 -> 134
    //   115: astore_1
    //   116: goto +21 -> 137
    //   119: astore_1
    //   120: aload_1
    //   121: ldc_w 452
    //   124: ldc_w 489
    //   127: invokestatic 458	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 492	java/lang/Throwable:printStackTrace	()V
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	lo
    //   0	141	1	paramString	String
    //   37	53	2	localObject1	Object
    //   24	13	3	localObject2	Object
    //   34	15	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	6	115	finally
    //   10	20	115	finally
    //   25	36	115	finally
    //   38	72	115	finally
    //   72	81	115	finally
    //   85	96	115	finally
    //   99	112	115	finally
    //   120	134	115	finally
    //   2	6	119	java/lang/Throwable
    //   10	20	119	java/lang/Throwable
    //   25	36	119	java/lang/Throwable
    //   38	72	119	java/lang/Throwable
    //   72	81	119	java/lang/Throwable
    //   85	96	119	java/lang/Throwable
    //   99	112	119	java/lang/Throwable
  }
  
  IOverlayDelegate c(String paramString)
    throws RemoteException
  {
    try
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        IOverlayDelegate localIOverlayDelegate = (IOverlayDelegate)localIterator.next();
        if (localIOverlayDelegate != null)
        {
          boolean bool = localIOverlayDelegate.getId().equals(paramString);
          if (bool) {
            return localIOverlayDelegate;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      this.d = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/amap/api/mapcore/util/lo:e	Ljava/util/List;
    //   6: invokeinterface 95 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 101 1 0
    //   18: ifeq +20 -> 38
    //   21: aload_1
    //   22: invokeinterface 105 1 0
    //   27: checkcast 107	com/autonavi/base/amap/api/mapcore/overlays/IOverlayDelegate
    //   30: invokeinterface 114 1 0
    //   35: goto -23 -> 12
    //   38: aload_0
    //   39: aconst_null
    //   40: invokevirtual 494	com/amap/api/mapcore/util/lo:b	(Ljava/lang/String;)V
    //   43: goto +22 -> 65
    //   46: astore_1
    //   47: goto +21 -> 68
    //   50: astore_1
    //   51: aload_1
    //   52: ldc_w 452
    //   55: ldc_w 496
    //   58: invokestatic 458	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_1
    //   62: invokevirtual 492	java/lang/Throwable:printStackTrace	()V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	lo
    //   11	11	1	localIterator	Iterator
    //   46	1	1	localObject	Object
    //   50	21	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	12	46	finally
    //   12	35	46	finally
    //   38	43	46	finally
    //   51	65	46	finally
    //   2	12	50	java/lang/Throwable
    //   12	35	50	java/lang/Throwable
    //   38	43	50	java/lang/Throwable
  }
  
  public void e()
  {
    try
    {
      this.h = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void f()
  {
    List localList = this.f;
    int k = 0;
    for (;;)
    {
      try
      {
        if (k < this.f.size())
        {
          lu locallu = (lu)this.f.get(k);
          if (locallu != null)
          {
            locallu.m();
            if (locallu.n() <= 0)
            {
              this.g[0] = locallu.k();
              GLES20.glDeleteTextures(1, this.g, 0);
              locallu.a(0);
              if (this.a != null) {
                this.a.removeTextureItem(locallu.o());
              }
            }
          }
        }
        else
        {
          this.f.clear();
          return;
        }
      }
      finally {}
      k += 1;
    }
  }
  
  public IAMapDelegate g()
  {
    return this.a;
  }
  
  public int getCurrentParticleNum(String paramString)
  {
    return 0;
  }
  
  public LatLng getNearestLatLng(PolylineOptions paramPolylineOptions, LatLng paramLatLng)
  {
    return null;
  }
  
  public float[] h()
  {
    if (this.a != null) {
      return this.a.getFinalMatrix();
    }
    return new float[16];
  }
  
  public void prepareIcon(Object paramObject) {}
  
  public void processCircleHoleOption(CircleOptions paramCircleOptions) {}
  
  public void processPolygonHoleOption(PolygonOptions paramPolygonOptions) {}
  
  public boolean removeOverlay(String paramString)
    throws RemoteException
  {
    return a(paramString, false);
  }
  
  public void updateOption(String paramString, Object paramObject) {}
  
  static class a
    implements Serializable, Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (IOverlayDelegate)paramObject1;
      paramObject2 = (IOverlayDelegate)paramObject2;
      if ((paramObject1 != null) && (paramObject2 != null)) {
        try
        {
          if (((IOverlayDelegate)paramObject1).getZIndex() > ((IOverlayDelegate)paramObject2).getZIndex()) {
            return 1;
          }
          float f1 = ((IOverlayDelegate)paramObject1).getZIndex();
          float f2 = ((IOverlayDelegate)paramObject2).getZIndex();
          if (f1 < f2) {
            return -1;
          }
        }
        catch (Throwable paramObject1)
        {
          gk.c((Throwable)paramObject1, "GlOverlayLayer", "compare");
          ((Throwable)paramObject1).printStackTrace();
        }
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */