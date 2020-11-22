package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapPara.LineCapType;
import com.amap.api.maps.model.AMapPara.LineJoinType;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ce
  implements IPolygonDelegate
{
  private static float A = 4.0075016E7F;
  private static int B = 256;
  private static int C = 20;
  private static double H = 1.0E10D;
  private int D;
  private int E;
  private FloatBuffer F;
  private FloatBuffer G;
  Rect a = null;
  private IAMapDelegate b;
  private float c = 0.0F;
  private boolean d = true;
  private boolean e;
  private String f;
  private float g;
  private int h;
  private int i;
  private List<LatLng> j;
  private List<LatLng> k;
  private List<IPoint> l = new Vector();
  private List<BaseHoleOptions> m = new Vector();
  private List<BaseHoleOptions> n;
  private FloatBuffer o;
  private FloatBuffer p;
  private int q = 0;
  private int r = 0;
  private boolean s = false;
  private float t = 0.0F;
  private Object u = new Object();
  private boolean v = false;
  private AMapPara.LineJoinType w = AMapPara.LineJoinType.LineJoinBevel;
  private AMapPara.LineCapType x = AMapPara.LineCapType.LineCapRound;
  private float y = 0.0F;
  private cl.e z;
  
  public ce(IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramIAMapDelegate;
    try
    {
      this.f = getId();
      return;
    }
    catch (RemoteException paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "PolygonDelegateImp", "create");
      paramIAMapDelegate.printStackTrace();
    }
  }
  
  private float a(double paramDouble)
  {
    paramDouble = Math.cos(paramDouble * 3.141592653589793D / 180.0D);
    double d1 = A;
    Double.isNaN(d1);
    double d2 = B << C;
    Double.isNaN(d2);
    return (float)(paramDouble * d1 / d2);
  }
  
  private void a()
  {
    if (this.b != null) {
      this.z = ((cl.e)this.b.getGLShader(3));
    }
  }
  
  private void a(List<LatLng> paramList)
    throws RemoteException
  {
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    if (this.a == null) {
      this.a = new Rect();
    }
    dx.a(this.a);
    this.l.clear();
    if (paramList != null)
    {
      Object localObject = null;
      Iterator localIterator = paramList.iterator();
      paramList = (List<LatLng>)localObject;
      while (localIterator.hasNext())
      {
        localObject = (LatLng)localIterator.next();
        if (!((LatLng)localObject).equals(paramList))
        {
          paramList = IPoint.obtain();
          this.b.latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramList);
          this.l.add(paramList);
          dx.b(this.a, paramList.x, paramList.y);
          localBuilder.include((LatLng)localObject);
          paramList = (List<LatLng>)localObject;
        }
      }
      int i1 = this.l.size();
      if (i1 > 1)
      {
        paramList = (IPoint)this.l.get(0);
        localObject = this.l;
        i1 -= 1;
        localObject = (IPoint)((List)localObject).get(i1);
        if ((paramList.x == ((IPoint)localObject).x) && (paramList.y == ((IPoint)localObject).y)) {
          this.l.remove(i1);
        }
      }
    }
    this.a.sort();
    if (this.o != null) {
      this.o.clear();
    }
    if (this.p != null) {
      this.p.clear();
    }
    if (dx.a(this.l, 0, this.l.size())) {
      Collections.reverse(this.l);
    }
    this.q = 0;
    this.r = 0;
    this.b.setRunLowFrame(false);
  }
  
  private void a(List<IPoint> paramList, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (paramList.size() < 2) {
      return;
    }
    float[] arrayOfFloat = new float[paramList.size() * 3];
    IPoint[] arrayOfIPoint = new IPoint[paramList.size()];
    paramList = paramList.iterator();
    int i3 = 0;
    int i1 = 0;
    while (paramList.hasNext())
    {
      localObject1 = (IPoint)paramList.next();
      i2 = i1 * 3;
      arrayOfFloat[i2] = (((IPoint)localObject1).x - paramInt1);
      arrayOfFloat[(i2 + 1)] = (((IPoint)localObject1).y - paramInt2);
      arrayOfFloat[(i2 + 2)] = 0.0F;
      arrayOfIPoint[i1] = localObject1;
      i1 += 1;
    }
    Object localObject1 = a(arrayOfIPoint);
    paramList = (List<IPoint>)localObject1;
    if (localObject1.length == 0)
    {
      if (H == 1.0E10D) {
        H = 1.0E8D;
      } else {
        H = 1.0E10D;
      }
      paramList = a(arrayOfIPoint);
    }
    localObject1 = new float[paramList.length * 3];
    int i4 = paramList.length;
    int i2 = 0;
    i1 = i3;
    while (i1 < i4)
    {
      Object localObject2 = paramList[i1];
      i3 = i2 * 3;
      localObject1[i3] = (((IPoint)localObject2).x - paramInt1);
      localObject1[(i3 + 1)] = (((IPoint)localObject2).y - paramInt2);
      localObject1[(i3 + 2)] = 0.0F;
      i2 += 1;
      i1 += 1;
    }
    this.D = arrayOfIPoint.length;
    this.E = paramList.length;
    this.F = dx.a(arrayOfFloat);
    this.G = dx.a((float[])localObject1);
  }
  
  private boolean a(PolygonHoleOptions paramPolygonHoleOptions)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    try
    {
      paramPolygonHoleOptions = paramPolygonHoleOptions.getPoints();
      int i1 = 0;
      boolean bool3;
      for (;;)
      {
        bool2 = bool1;
        bool3 = bool1;
        if (i1 >= paramPolygonHoleOptions.size()) {
          break;
        }
        bool2 = bool1;
        bool1 = dx.a((LatLng)paramPolygonHoleOptions.get(i1), getPoints());
        if (!bool1) {
          return bool1;
        }
        i1 += 1;
      }
      return bool3;
    }
    catch (Throwable paramPolygonHoleOptions)
    {
      gk.c(paramPolygonHoleOptions, "PolygonDelegateImp", "isPolygonInPolygon");
      paramPolygonHoleOptions.printStackTrace();
      bool3 = bool2;
    }
  }
  
  private boolean a(IPoint paramIPoint1, IPoint paramIPoint2)
  {
    return (paramIPoint2.x - paramIPoint1.x >= this.t) || (paramIPoint2.x - paramIPoint1.x <= -this.t) || (paramIPoint2.y - paramIPoint1.y >= this.t) || (paramIPoint2.y - paramIPoint1.y <= -this.t);
  }
  
  private boolean a(Rectangle paramRectangle)
  {
    this.y = this.b.getZoomLevel();
    d();
    if (this.y <= 10) {
      return false;
    }
    if (paramRectangle != null) {}
    try
    {
      boolean bool = paramRectangle.contains(this.a);
      return !bool;
    }
    catch (Throwable paramRectangle) {}
    return false;
    return false;
  }
  
  static IPoint[] a(IPoint[] paramArrayOfIPoint)
  {
    int i3 = paramArrayOfIPoint.length;
    double[] arrayOfDouble = new double[i3 * 2];
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      int i4 = i1 * 2;
      double d1 = paramArrayOfIPoint[i1].x;
      double d2 = H;
      Double.isNaN(d1);
      arrayOfDouble[i4] = (d1 * d2);
      d1 = paramArrayOfIPoint[i1].y;
      d2 = H;
      Double.isNaN(d1);
      arrayOfDouble[(i4 + 1)] = (d1 * d2);
      i1 += 1;
    }
    paramArrayOfIPoint = new dc().a(arrayOfDouble);
    i3 = paramArrayOfIPoint.b;
    IPoint[] arrayOfIPoint = new IPoint[i3];
    i1 = i2;
    while (i1 < i3)
    {
      arrayOfIPoint[i1] = new IPoint();
      arrayOfIPoint[i1].x = ((int)(arrayOfDouble[(paramArrayOfIPoint.a(i1) * 2)] / H));
      arrayOfIPoint[i1].y = ((int)(arrayOfDouble[(paramArrayOfIPoint.a(i1) * 2 + 1)] / H));
      i1 += 1;
    }
    return arrayOfIPoint;
  }
  
  private double b(double paramDouble)
  {
    paramDouble = a(paramDouble);
    Double.isNaN(paramDouble);
    return 1.0D / paramDouble;
  }
  
  private List<IPoint> b(List<LatLng> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Object localObject = null;
      Iterator localIterator = paramList.iterator();
      paramList = (List<LatLng>)localObject;
      while (localIterator.hasNext())
      {
        localObject = (LatLng)localIterator.next();
        if (!((LatLng)localObject).equals(paramList))
        {
          paramList = IPoint.obtain();
          this.b.latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramList);
          localArrayList.add(paramList);
          dx.b(this.a, paramList.x, paramList.y);
          paramList = (List<LatLng>)localObject;
        }
      }
      int i1 = localArrayList.size();
      if (i1 > 1)
      {
        paramList = (IPoint)localArrayList.get(0);
        i1 -= 1;
        localObject = (IPoint)localArrayList.get(i1);
        if ((paramList.x == ((IPoint)localObject).x) && (paramList.y == ((IPoint)localObject).y)) {
          localArrayList.remove(i1);
        }
      }
    }
    if (dx.a(localArrayList, 0, localArrayList.size())) {
      Collections.reverse(localArrayList);
    }
    return localArrayList;
  }
  
  private void b()
    throws RemoteException
  {
    MapConfig localMapConfig = this.b.getMapConfig();
    if ((this.m != null) && (this.m.size() > 0))
    {
      GLES20.glClearStencil(0);
      GLES20.glStencilMask(255);
      GLES20.glClear(1024);
      GLES20.glFlush();
      GLES20.glEnable(2960);
      GLES20.glColorMask(false, false, false, false);
      GLES20.glStencilFunc(512, 1, 255);
      GLES20.glStencilOp(7681, 7680, 7680);
      int i1 = 0;
      while (i1 < this.m.size())
      {
        BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)this.m.get(i1);
        boolean bool = localBaseHoleOptions instanceof PolygonHoleOptions;
        if (bool)
        {
          a(b(((PolygonHoleOptions)localBaseHoleOptions).getPoints()), (int)localMapConfig.getSX(), (int)localMapConfig.getSY());
        }
        else if ((localBaseHoleOptions instanceof CircleHoleOptions))
        {
          CircleHoleOptions localCircleHoleOptions = (CircleHoleOptions)localBaseHoleOptions;
          this.b.changeGLOverlayIndex();
          a(localCircleHoleOptions);
        }
        if ((this.F != null) && (this.D > 0))
        {
          if ((this.z == null) || (this.z.c())) {
            a();
          }
          if (bool) {
            df.a(this.z, -1, -16777216, this.F, this.g, this.G, this.D, this.E, this.b.getFinalMatrix(), this.b.getLineTextureID(), localMapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v, false);
          } else if ((localBaseHoleOptions instanceof CircleHoleOptions)) {
            df.a(this.z, Color.argb(200, 80, 1, 1), Color.argb(200, 1, 1, 1), this.F, 5.0F, this.D, this.b.getFinalMatrix(), localMapConfig.getMapPerPixelUnitLength(), this.b.getLineTextureID(), this.v, false);
          }
        }
        i1 += 1;
      }
      GLES20.glColorMask(true, true, true, true);
      GLES20.glStencilFunc(517, 1, 255);
      GLES20.glStencilMask(0);
    }
  }
  
  private void b(List<IPoint> paramList, int paramInt1, int paramInt2)
    throws RemoteException
  {
    d();
    ArrayList localArrayList = new ArrayList();
    int i2 = paramList.size();
    if (i2 < 2) {
      return;
    }
    int i3 = 0;
    Object localObject1 = (IPoint)paramList.get(0);
    localArrayList.add(localObject1);
    int i1 = 1;
    for (;;)
    {
      i4 = i2 - 1;
      if (i1 >= i4) {
        break;
      }
      localObject3 = (IPoint)paramList.get(i1);
      localObject2 = localObject1;
      if (a((IPoint)localObject1, (IPoint)localObject3))
      {
        localArrayList.add(localObject3);
        localObject2 = localObject3;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    localArrayList.add(paramList.get(i4));
    Object localObject2 = new float[localArrayList.size() * 3];
    Object localObject3 = new IPoint[localArrayList.size()];
    paramList = localArrayList.iterator();
    i1 = 0;
    while (paramList.hasNext())
    {
      localObject1 = (IPoint)paramList.next();
      i2 = i1 * 3;
      localObject2[i2] = (((IPoint)localObject1).x - paramInt1);
      localObject2[(i2 + 1)] = (((IPoint)localObject1).y - paramInt2);
      localObject2[(i2 + 2)] = 0.0F;
      localObject3[i1] = localObject1;
      i1 += 1;
    }
    localObject1 = a((IPoint[])localObject3);
    paramList = (List<IPoint>)localObject1;
    if (localObject1.length == 0)
    {
      if (H == 1.0E10D) {
        H = 1.0E8D;
      } else {
        H = 1.0E10D;
      }
      paramList = a((IPoint[])localObject3);
    }
    localObject1 = new float[paramList.length * 3];
    int i4 = paramList.length;
    i2 = 0;
    i1 = i3;
    while (i1 < i4)
    {
      localArrayList = paramList[i1];
      i3 = i2 * 3;
      localObject1[i3] = (localArrayList.x - paramInt1);
      localObject1[(i3 + 1)] = (localArrayList.y - paramInt2);
      localObject1[(i3 + 2)] = 0.0F;
      i2 += 1;
      i1 += 1;
    }
    this.q = localObject3.length;
    this.r = paramList.length;
    this.o = dx.a((float[])localObject2);
    this.p = dx.a((float[])localObject1);
  }
  
  private boolean b(CircleHoleOptions paramCircleHoleOptions)
  {
    try
    {
      if (!dx.b(getPoints(), paramCircleHoleOptions))
      {
        boolean bool = contains(paramCircleHoleOptions.getCenter());
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramCircleHoleOptions)
    {
      gk.c(paramCircleHoleOptions, "PolygonDelegateImp", "isCircleInPolygon");
      paramCircleHoleOptions.printStackTrace();
    }
    return false;
  }
  
  private void c()
    throws RemoteException
  {
    int i1 = 0;
    GLES20.glClearStencil(0);
    GLES20.glClear(1024);
    GLES20.glDisable(2960);
    MapConfig localMapConfig = this.b.getMapConfig();
    if ((this.m != null) && (this.m.size() > 0)) {
      while (i1 < this.m.size())
      {
        BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)this.m.get(i1);
        boolean bool = localBaseHoleOptions instanceof PolygonHoleOptions;
        if (bool)
        {
          a(b(((PolygonHoleOptions)localBaseHoleOptions).getPoints()), (int)localMapConfig.getSX(), (int)localMapConfig.getSY());
        }
        else if ((localBaseHoleOptions instanceof CircleHoleOptions))
        {
          CircleHoleOptions localCircleHoleOptions = (CircleHoleOptions)localBaseHoleOptions;
          this.b.changeGLOverlayIndex();
          a(localCircleHoleOptions);
        }
        if ((this.F != null) && (this.D > 0))
        {
          if ((this.z == null) || (this.z.c())) {
            a();
          }
          if (bool) {
            df.a(this.z, 0, this.i, this.F, this.g, this.G, this.D, this.E, localMapConfig.getMvpMatrix(), this.b.getLineTextureID(), localMapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v);
          } else if ((localBaseHoleOptions instanceof CircleHoleOptions)) {
            df.a(this.z, 0, this.i, this.F, this.g, this.D, this.b.getFinalMatrix(), localMapConfig.getMapPerPixelUnitLength(), this.b.getLineTextureID(), this.v);
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void d()
  {
    float f1 = this.b.getZoomLevel();
    if (this.l.size() > 5000)
    {
      if (f1 <= 12)
      {
        float f2 = this.g / 2.0F + f1 / 2.0F;
        f1 = 200.0F;
        if (f2 <= 200.0F) {
          f1 = f2;
        }
        this.t = this.b.getMapProjection().getMapLenWithWin((int)f1);
        return;
      }
      this.t = this.b.getMapProjection().getMapLenWithWin(10);
      return;
    }
    this.t = this.b.getMapProjection().getMapLenWithWin(2);
  }
  
  public void a(AMapPara.LineJoinType paramLineJoinType)
  {
    this.w = paramLineJoinType;
  }
  
  public void a(CircleHoleOptions paramCircleHoleOptions)
    throws RemoteException
  {
    if (paramCircleHoleOptions.getCenter() != null)
    {
      IPoint localIPoint = IPoint.obtain();
      FPoint localFPoint = FPoint.obtain();
      GLMapState.lonlat2Geo(paramCircleHoleOptions.getCenter().longitude, paramCircleHoleOptions.getCenter().latitude, localIPoint);
      float[] arrayOfFloat = new float['о'];
      double d1 = b(paramCircleHoleOptions.getCenter().latitude) * paramCircleHoleOptions.getRadius();
      int i2 = (int)this.b.getMapConfig().getSX();
      int i3 = (int)this.b.getMapConfig().getSY();
      localFPoint.x = (localIPoint.x - i2);
      localFPoint.y = (localIPoint.y - i3);
      float f1 = localFPoint.x;
      int i1 = 0;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = localFPoint.y;
      arrayOfFloat[2] = 0.0F;
      while (i1 < 361)
      {
        double d2 = i1;
        Double.isNaN(d2);
        double d3 = d2 * 3.141592653589793D / 180.0D;
        d2 = Math.sin(d3);
        d3 = Math.cos(d3);
        double d4 = localIPoint.x;
        Double.isNaN(d4);
        int i4 = (int)(d4 + d2 * d1);
        d2 = localIPoint.y;
        Double.isNaN(d2);
        int i5 = (int)(d2 + d3 * d1);
        localFPoint.x = (i4 - i2);
        localFPoint.y = (i5 - i3);
        localFPoint.x = (i4 - (int)this.b.getMapConfig().getSX());
        localFPoint.y = (i5 - (int)this.b.getMapConfig().getSY());
        i1 += 1;
        i4 = i1 * 3;
        arrayOfFloat[i4] = localFPoint.x;
        arrayOfFloat[(i4 + 1)] = localFPoint.y;
        arrayOfFloat[(i4 + 2)] = 0.0F;
      }
      this.D = (arrayOfFloat.length / 3);
      this.F = dx.a(arrayOfFloat);
      localIPoint.recycle();
      localFPoint.recycle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    return false;
  }
  
  public boolean checkInBounds()
  {
    return this.b.getMapConfig().getGeoRectangle().isOverlap(this.a);
  }
  
  public boolean contains(LatLng paramLatLng)
    throws RemoteException
  {
    if (paramLatLng == null) {
      return false;
    }
    try
    {
      if ((this.m != null) && (this.m.size() > 0))
      {
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext()) {
          if (dx.a((BaseHoleOptions)localIterator.next(), paramLatLng)) {
            return false;
          }
        }
      }
      boolean bool = dx.a(paramLatLng, getPoints());
      return bool;
    }
    catch (Throwable paramLatLng)
    {
      gk.c(paramLatLng, "PolygonDelegateImp", "contains");
      paramLatLng.printStackTrace();
    }
    return false;
  }
  
  public void destroy()
  {
    try
    {
      if (this.o != null)
      {
        this.o.clear();
        this.o = null;
      }
      if (this.p != null) {
        this.p = null;
      }
      if (this.F != null)
      {
        this.F.clear();
        this.F = null;
      }
      if (this.G != null)
      {
        this.G.clear();
        this.G = null;
      }
      if (this.m != null) {
        this.m.clear();
      }
      if (this.n != null) {
        this.n.clear();
      }
      this.m = null;
      this.n = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "PolygonDelegateImp", "destroy");
      localThrowable.printStackTrace();
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if (this.l != null)
    {
      if (this.l.size() == 0) {
        return;
      }
      Rectangle localRectangle = paramMapConfig.getGeoRectangle();
      localRectangle.getClipRect();
      List localList = this.l;
      a(localRectangle);
      b();
      if (localList.size() > 2)
      {
        b(localList, (int)paramMapConfig.getSX(), (int)paramMapConfig.getSY());
        if ((this.o != null) && (this.p != null) && (this.q > 0) && (this.r > 0))
        {
          if ((this.z == null) || (this.z.c())) {
            a();
          }
          df.a(this.z, this.h, this.i, this.o, this.g, this.p, this.q, this.r, this.b.getFinalMatrix(), this.b.getLineTextureID(), paramMapConfig.getMapPerPixelUnitLength(), this.x.getTypeValue(), this.w.getTypeValue(), this.v, true);
        }
      }
      c();
      this.s = true;
      return;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public int getFillColor()
    throws RemoteException
  {
    return this.h;
  }
  
  public List<BaseHoleOptions> getHoleOptions()
  {
    return this.m;
  }
  
  public List<LatLng> getHoles()
  {
    return this.j;
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.f == null) {
      this.f = this.b.createId("Polygon");
    }
    return this.f;
  }
  
  public List<LatLng> getPoints()
    throws RemoteException
  {
    return this.k;
  }
  
  public int getStrokeColor()
    throws RemoteException
  {
    return this.i;
  }
  
  public float getStrokeWidth()
    throws RemoteException
  {
    return this.g;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.c;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return super.hashCode();
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return this.s;
  }
  
  public boolean isGeodesic()
  {
    return this.e;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.d;
  }
  
  public void remove()
    throws RemoteException
  {
    this.b.removeGLOverlay(getId());
    this.b.setRunLowFrame(false);
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setFillColor(int paramInt)
    throws RemoteException
  {
    this.h = paramInt;
    this.b.setRunLowFrame(false);
  }
  
  public void setGeodesic(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.b.setRunLowFrame(false);
  }
  
  public void setHoleOptions(List<BaseHoleOptions> paramList)
  {
    for (;;)
    {
      int i1;
      try
      {
        this.n = paramList;
        if (this.m == null) {
          this.m = new ArrayList();
        } else {
          this.m.clear();
        }
      }
      catch (Throwable paramList)
      {
        Object localObject;
        gk.c(paramList, "PolygonDelegateImp", "setHoleOptions");
        paramList.printStackTrace();
      }
      if (i1 < paramList.size())
      {
        localObject = (BaseHoleOptions)paramList.get(i1);
        if ((localObject instanceof PolygonHoleOptions))
        {
          localObject = (PolygonHoleOptions)localObject;
          if ((!a((PolygonHoleOptions)localObject)) || (dx.a(this.m, (PolygonHoleOptions)localObject))) {
            break label195;
          }
          this.m.add(localObject);
          break label195;
        }
        if (!(localObject instanceof CircleHoleOptions)) {
          break label195;
        }
        localObject = (CircleHoleOptions)localObject;
        if ((!b((CircleHoleOptions)localObject)) || (dx.a(this.m, (CircleHoleOptions)localObject))) {
          break label195;
        }
        this.m.add(localObject);
        break label195;
        this.m.clear();
      }
      this.b.setRunLowFrame(false);
      return;
      if (paramList != null)
      {
        i1 = 0;
        continue;
        label195:
        i1 += 1;
      }
    }
  }
  
  public void setHoles(List<LatLng> paramList)
    throws RemoteException
  {
    this.j = paramList;
    this.b.setRunLowFrame(false);
  }
  
  public void setPoints(List<LatLng> paramList)
    throws RemoteException
  {
    synchronized (this.u)
    {
      this.k = paramList;
      a(paramList);
      this.b.setRunLowFrame(false);
      setHoleOptions(this.n);
      return;
    }
  }
  
  public void setStrokeColor(int paramInt)
    throws RemoteException
  {
    this.i = paramInt;
    this.b.setRunLowFrame(false);
  }
  
  public void setStrokeWidth(float paramFloat)
    throws RemoteException
  {
    this.g = paramFloat;
    this.b.setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.d = paramBoolean;
    this.b.setRunLowFrame(false);
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.c = paramFloat;
    this.b.changeGLOverlayIndex();
    this.b.setRunLowFrame(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */