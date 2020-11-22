package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bw
  implements ICircleDelegate
{
  private static int A = 256;
  private static int B = 20;
  private static double C = 1.0E10D;
  private static Object v = new Object();
  private static float z = 4.0075016E7F;
  float a = 0.0F;
  private LatLng b = null;
  private double c = 0.0D;
  private float d = 10.0F;
  private int e = -16777216;
  private int f = 0;
  private float g = 0.0F;
  private boolean h = true;
  private String i;
  private IAMapDelegate j;
  private FloatBuffer k;
  private int l = 0;
  private boolean m = false;
  private IPoint n = IPoint.obtain();
  private FPoint o = FPoint.obtain();
  private List<BaseHoleOptions> p;
  private List<BaseHoleOptions> q;
  private int r;
  private int s;
  private FloatBuffer t;
  private FloatBuffer u;
  private int w = -1;
  private boolean x = false;
  private cl.e y;
  
  public bw(IAMapDelegate paramIAMapDelegate)
  {
    this.j = paramIAMapDelegate;
    try
    {
      this.i = getId();
      return;
    }
    catch (RemoteException paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "CircleDelegateImp", "create");
      paramIAMapDelegate.printStackTrace();
    }
  }
  
  private float a(double paramDouble)
  {
    paramDouble = Math.cos(paramDouble * 3.141592653589793D / 180.0D);
    double d1 = z;
    Double.isNaN(d1);
    double d2 = A << B;
    Double.isNaN(d2);
    return (float)(paramDouble * d1 / d2);
  }
  
  private List<IPoint> a(List<LatLng> paramList)
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
          this.j.latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramList);
          localArrayList.add(paramList);
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
      if (C == 1.0E10D) {
        C = 1.0E8D;
      } else {
        C = 1.0E10D;
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
    this.r = arrayOfIPoint.length;
    this.s = paramList.length;
    this.t = dx.a(arrayOfFloat);
    this.u = dx.a((float[])localObject1);
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
        bool1 = contains((LatLng)paramPolygonHoleOptions.get(i1));
        if (!bool1) {
          return bool1;
        }
        i1 += 1;
      }
      return bool3;
    }
    catch (Throwable paramPolygonHoleOptions)
    {
      gk.c(paramPolygonHoleOptions, "CircleDelegateImp", "isPolygonInCircle");
      paramPolygonHoleOptions.printStackTrace();
      bool3 = bool2;
    }
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
      double d2 = C;
      Double.isNaN(d1);
      arrayOfDouble[i4] = (d1 * d2);
      d1 = paramArrayOfIPoint[i1].y;
      d2 = C;
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
      arrayOfIPoint[i1].x = ((int)(arrayOfDouble[(paramArrayOfIPoint.a(i1) * 2)] / C));
      arrayOfIPoint[i1].y = ((int)(arrayOfDouble[(paramArrayOfIPoint.a(i1) * 2 + 1)] / C));
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
  
  private void b()
  {
    if (this.j != null) {
      this.y = ((cl.e)this.j.getGLShader(3));
    }
  }
  
  private boolean b(CircleHoleOptions paramCircleHoleOptions)
  {
    try
    {
      double d1 = AMapUtils.calculateLineDistance(paramCircleHoleOptions.getCenter(), getCenter());
      double d2 = getRadius();
      double d3 = paramCircleHoleOptions.getRadius();
      return d1 <= d2 - d3;
    }
    catch (Throwable paramCircleHoleOptions)
    {
      gk.c(paramCircleHoleOptions, "CircleDelegateImp", "isCircleInCircle");
      paramCircleHoleOptions.printStackTrace();
    }
    return true;
  }
  
  private void c()
    throws RemoteException
  {
    MapConfig localMapConfig = this.j.getMapConfig();
    if ((this.p != null) && (this.p.size() > 0))
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
      while (i1 < this.p.size())
      {
        BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)this.p.get(i1);
        boolean bool = localBaseHoleOptions instanceof PolygonHoleOptions;
        if (bool)
        {
          a(a(((PolygonHoleOptions)localBaseHoleOptions).getPoints()), (int)localMapConfig.getSX(), (int)localMapConfig.getSY());
        }
        else if ((localBaseHoleOptions instanceof CircleHoleOptions))
        {
          CircleHoleOptions localCircleHoleOptions = (CircleHoleOptions)localBaseHoleOptions;
          this.j.changeGLOverlayIndex();
          a(localCircleHoleOptions);
        }
        if ((this.t != null) && (this.r > 0))
        {
          if ((this.y == null) || (this.y.c())) {
            b();
          }
          if (bool) {
            df.a(this.y, -1, this.f, this.t, getStrokeWidth(), this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), localMapConfig.getMapPerPixelUnitLength(), 3, 0, this.x, false);
          } else if ((localBaseHoleOptions instanceof CircleHoleOptions)) {
            df.a(this.y, -1, -1, this.t, 10.0F, this.r, this.j.getFinalMatrix(), localMapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.x, false);
          }
        }
        i1 += 1;
      }
      GLES20.glColorMask(true, true, true, true);
      GLES20.glStencilFunc(517, 1, 255);
      GLES20.glStencilMask(0);
    }
  }
  
  private void d()
    throws RemoteException
  {
    int i1 = 0;
    GLES20.glClearStencil(0);
    GLES20.glClear(1024);
    GLES20.glDisable(2960);
    MapConfig localMapConfig = this.j.getMapConfig();
    if ((this.p != null) && (this.p.size() > 0)) {
      while (i1 < this.p.size())
      {
        BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)this.p.get(i1);
        boolean bool = localBaseHoleOptions instanceof PolygonHoleOptions;
        if (bool)
        {
          a(a(((PolygonHoleOptions)localBaseHoleOptions).getPoints()), (int)localMapConfig.getSX(), (int)localMapConfig.getSY());
        }
        else if ((localBaseHoleOptions instanceof CircleHoleOptions))
        {
          CircleHoleOptions localCircleHoleOptions = (CircleHoleOptions)localBaseHoleOptions;
          this.j.changeGLOverlayIndex();
          a(localCircleHoleOptions);
        }
        if ((this.t != null) && (this.r > 0))
        {
          if ((this.y == null) || (this.y.c())) {
            b();
          }
          if (bool) {
            df.a(this.y, 0, this.e, this.t, this.d, this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), localMapConfig.getMapPerPixelUnitLength(), 3, 0, this.x);
          } else if ((localBaseHoleOptions instanceof CircleHoleOptions)) {
            df.a(this.y, 0, this.e, this.t, this.d, this.r, this.j.getFinalMatrix(), localMapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.x);
          }
        }
        i1 += 1;
      }
    }
  }
  
  void a()
  {
    this.l = 0;
    if (this.k != null) {
      this.k.clear();
    }
    this.j.setRunLowFrame(false);
    setHoleOptions(this.q);
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
      localFPoint.x = (localIPoint.x - (int)this.j.getMapConfig().getSX());
      localFPoint.y = (localIPoint.y - (int)this.j.getMapConfig().getSY());
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
        int i2 = (int)(d4 + d2 * d1);
        d2 = localIPoint.y;
        Double.isNaN(d2);
        int i3 = (int)(d2 + d3 * d1);
        localFPoint.x = (i2 - (int)this.j.getMapConfig().getSX());
        localFPoint.y = (i3 - (int)this.j.getMapConfig().getSY());
        i1 += 1;
        i2 = i1 * 3;
        arrayOfFloat[i2] = localFPoint.x;
        arrayOfFloat[(i2 + 1)] = localFPoint.y;
        arrayOfFloat[(i2 + 2)] = 0.0F;
      }
      this.r = (arrayOfFloat.length / 3);
      this.t = dx.a(arrayOfFloat);
      localIPoint.recycle();
      localFPoint.recycle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    Object localObject1 = v;
    int i1 = 0;
    try
    {
      this.m = false;
      if (this.b != null)
      {
        float[] arrayOfFloat = new float['о'];
        double d1 = b(this.b.latitude) * this.c;
        this.j.getMapProjection();
        this.o.x = (this.n.x - (int)this.j.getMapConfig().getSX());
        this.o.y = (this.n.y - (int)this.j.getMapConfig().getSY());
        arrayOfFloat[0] = this.o.x;
        arrayOfFloat[1] = this.o.y;
        arrayOfFloat[2] = 0.0F;
        while (i1 < 361)
        {
          double d2 = i1;
          Double.isNaN(d2);
          double d3 = d2 * 3.141592653589793D / 180.0D;
          d2 = Math.sin(d3);
          d3 = Math.cos(d3);
          int i2 = this.n.x;
          double d4 = i2;
          Double.isNaN(d4);
          i2 = (int)(d4 + d2 * d1);
          int i3 = this.n.y;
          d2 = i3;
          Double.isNaN(d2);
          i3 = (int)(d2 + d3 * d1);
          this.o.x = (i2 - (int)this.j.getMapConfig().getSX());
          this.o.y = (i3 - (int)this.j.getMapConfig().getSY());
          i1 += 1;
          i2 = i1 * 3;
          arrayOfFloat[i2] = this.o.x;
          arrayOfFloat[(i2 + 1)] = this.o.y;
          arrayOfFloat[(i2 + 2)] = 0.0F;
        }
        this.l = (arrayOfFloat.length / 3);
        this.k = dx.a(arrayOfFloat);
      }
      return true;
    }
    finally {}
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public boolean contains(LatLng paramLatLng)
    throws RemoteException
  {
    if ((this.p != null) && (this.p.size() > 0))
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        if (dx.a((BaseHoleOptions)localIterator.next(), paramLatLng)) {
          return false;
        }
      }
    }
    return this.c >= AMapUtils.calculateLineDistance(this.b, paramLatLng);
  }
  
  public void destroy()
  {
    try
    {
      this.b = null;
      if (this.k != null)
      {
        this.k.clear();
        this.k = null;
      }
      if (this.t != null)
      {
        this.t.clear();
        this.t = null;
      }
      if (this.u != null)
      {
        this.u.clear();
        this.u = null;
      }
      if (this.p != null) {
        this.p.clear();
      }
      if (this.q != null) {
        this.q.clear();
      }
      this.p = null;
      this.q = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "CircleDelegateImp", "destroy");
      localThrowable.printStackTrace();
      Log.d("destroy erro", "CircleDelegateImp destroy");
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if ((this.b != null) && (this.c > 0.0D))
    {
      if (!this.h) {
        return;
      }
      calMapFPoint();
      c();
      if ((this.k != null) && (this.l > 0))
      {
        if ((this.y == null) || (this.y.c())) {
          b();
        }
        this.a = this.j.getMapConfig().getMapPerPixelUnitLength();
        int i2 = this.j.getDottedLineTextureID(this.w);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.j.getLineTextureID();
        }
        if (this.w != -1) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        paramMapConfig = this.y;
        int i3 = this.f;
        int i4 = this.e;
        FloatBuffer localFloatBuffer = this.k;
        float f1 = this.d;
        int i5 = this.l;
        float[] arrayOfFloat = this.j.getFinalMatrix();
        float f2 = this.a;
        boolean bool;
        if ((!this.x) && (i2 == 0)) {
          bool = false;
        } else {
          bool = true;
        }
        df.a(paramMapConfig, i3, i4, localFloatBuffer, f1, i5, arrayOfFloat, f2, i1, bool, true);
      }
      d();
      this.m = true;
      return;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public LatLng getCenter()
    throws RemoteException
  {
    return this.b;
  }
  
  public int getDottedLineType()
  {
    return this.w;
  }
  
  public int getFillColor()
    throws RemoteException
  {
    return this.f;
  }
  
  public List<BaseHoleOptions> getHoleOptions()
    throws RemoteException
  {
    return this.p;
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.i == null) {
      this.i = this.j.createId("Circle");
    }
    return this.i;
  }
  
  public double getRadius()
    throws RemoteException
  {
    return this.c;
  }
  
  public int getStrokeColor()
    throws RemoteException
  {
    return this.e;
  }
  
  public float getStrokeWidth()
    throws RemoteException
  {
    return this.d;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.g;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return 0;
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return this.m;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.h;
  }
  
  public void remove()
    throws RemoteException
  {
    this.j.removeGLOverlay(getId());
    this.j.setRunLowFrame(false);
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setCenter(LatLng paramLatLng)
    throws RemoteException
  {
    Object localObject = v;
    if (paramLatLng != null) {}
    try
    {
      this.b = paramLatLng;
      GLMapState.lonlat2Geo(paramLatLng.longitude, paramLatLng.latitude, this.n);
      a();
      return;
    }
    finally
    {
      for (;;) {}
    }
    throw paramLatLng;
  }
  
  public void setDottedLineType(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setFillColor(int paramInt)
    throws RemoteException
  {
    this.f = paramInt;
    this.j.setRunLowFrame(false);
  }
  
  public void setHoleOptions(List<BaseHoleOptions> paramList)
  {
    for (;;)
    {
      int i1;
      try
      {
        this.q = paramList;
        if (this.p == null) {
          this.p = new ArrayList();
        } else {
          this.p.clear();
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
          if ((a((PolygonHoleOptions)localObject)) && (!dx.a(this.p, (PolygonHoleOptions)localObject))) {
            this.p.add(localObject);
          }
        }
        else if ((localObject instanceof CircleHoleOptions))
        {
          localObject = (CircleHoleOptions)localObject;
          if ((b((CircleHoleOptions)localObject)) && (!dx.a(this.p, (CircleHoleOptions)localObject))) {
            this.p.add(localObject);
          }
        }
        i1 += 1;
      }
      else
      {
        do
        {
          return;
        } while (paramList == null);
        i1 = 0;
      }
    }
  }
  
  public void setRadius(double paramDouble)
    throws RemoteException
  {
    this.c = paramDouble;
    a();
  }
  
  public void setStrokeColor(int paramInt)
    throws RemoteException
  {
    this.e = paramInt;
    this.j.setRunLowFrame(false);
  }
  
  public void setStrokeWidth(float paramFloat)
    throws RemoteException
  {
    this.d = paramFloat;
    this.j.setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.h = paramBoolean;
    this.j.setRunLowFrame(false);
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.g = paramFloat;
    this.j.changeGLOverlayIndex();
    this.j.setRunLowFrame(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */