package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.PolylineOptions.LineCapType;
import com.amap.api.maps.model.PolylineOptions.LineJoinType;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.AMapNativePolyline;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FPoint3;
import com.autonavi.base.amap.mapcore.FPointBounds;
import com.autonavi.base.amap.mapcore.FPointBounds.Builder;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class cf
  implements IPolylineDelegate
{
  private boolean A = true;
  private int B = 0;
  private int C = 0;
  private int D = -16777216;
  private int E = 0;
  private int F = 0;
  private float G = 10.0F;
  private float H = 0.0F;
  private float I = 0.0F;
  private float J;
  private float K;
  private float L;
  private float M;
  private float N = 1.0F;
  private float O = 0.0F;
  private float[] P;
  private int[] Q;
  private int[] R;
  private boolean S = false;
  private FPointBounds T = null;
  private PolylineOptions U;
  private int V = 0;
  private PolylineOptions.LineJoinType W = PolylineOptions.LineJoinType.LineJoinBevel;
  private PolylineOptions.LineCapType X = PolylineOptions.LineCapType.LineCapRound;
  private cl Y;
  private long Z = 0L;
  Rect a = null;
  private boolean aa = false;
  private float ab = -1.0F;
  private float ac = -1.0F;
  private float ad = -1.0F;
  private int ae = -1;
  private List<IPoint> af = new ArrayList();
  private boolean ag = false;
  int b = 0;
  ArrayList<FPoint> c = new ArrayList();
  long d = 0L;
  private lo e;
  private String f;
  private List<IPoint> g = new ArrayList();
  private List<FPoint> h = new ArrayList();
  private List<LatLng> i = new ArrayList();
  private List<BitmapDescriptor> j = new ArrayList();
  private List<lu> k = new ArrayList();
  private List<Integer> l = new ArrayList();
  private List<Integer> m = new ArrayList();
  private List<Integer> n = new ArrayList();
  private List<Integer> o = new ArrayList();
  private FloatBuffer p;
  private BitmapDescriptor q = null;
  private Object r = new Object();
  private boolean s = true;
  private boolean t = true;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = true;
  private boolean y = false;
  private boolean z = false;
  
  public cf(lo paramlo, PolylineOptions paramPolylineOptions)
  {
    this.e = paramlo;
    setOptions(paramPolylineOptions);
    try
    {
      this.f = getId();
      return;
    }
    catch (RemoteException paramlo)
    {
      gk.c(paramlo, "PolylineDelegateImp", "create");
      paramlo.printStackTrace();
    }
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d2 = paramDouble5 - paramDouble3;
    double d4 = paramDouble1 - paramDouble3;
    double d1 = paramDouble6 - paramDouble4;
    double d5 = paramDouble2 - paramDouble4;
    double d3 = d2 * d4 + d1 * d5;
    if (d3 <= 0.0D) {
      return Math.sqrt(d4 * d4 + d5 * d5);
    }
    d4 = d2 * d2 + d1 * d1;
    if (d3 >= d4)
    {
      paramDouble1 -= paramDouble5;
      paramDouble2 -= paramDouble6;
      return Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
    }
    paramDouble5 = d3 / d4;
    paramDouble1 -= paramDouble3 + d2 * paramDouble5;
    paramDouble2 = paramDouble4 + d1 * paramDouble5 - paramDouble2;
    return Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
  }
  
  private double a(FPoint paramFPoint1, FPoint paramFPoint2, FPoint paramFPoint3)
  {
    return a(paramFPoint1.x, paramFPoint1.y, paramFPoint2.x, paramFPoint2.y, paramFPoint3.x, paramFPoint3.y);
  }
  
  private int a(boolean paramBoolean1, BitmapDescriptor paramBitmapDescriptor, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      b();
    }
    int i2 = 0;
    Object localObject1 = null;
    if (paramBoolean1)
    {
      localObject2 = this.e.a(paramBitmapDescriptor);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((lu)localObject2).k() > 0)
        {
          i1 = ((lu)localObject2).k();
          a((lu)localObject2);
          return i1;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new lu(paramBitmapDescriptor, 0);
    }
    paramBitmapDescriptor = paramBitmapDescriptor.getBitmap();
    int i1 = i2;
    if (paramBitmapDescriptor != null)
    {
      i1 = i2;
      if (!paramBitmapDescriptor.isRecycled())
      {
        i1 = c();
        if (paramBoolean1)
        {
          ((lu)localObject2).a(i1);
          this.e.g().addTextureItem((lu)localObject2);
        }
        a((lu)localObject2);
        dx.b(i1, paramBitmapDescriptor, true);
      }
    }
    return i1;
  }
  
  private FPoint a(LatLng paramLatLng)
  {
    IPoint localIPoint = IPoint.obtain();
    this.e.g().latlon2Geo(paramLatLng.latitude, paramLatLng.longitude, localIPoint);
    paramLatLng = FPoint.obtain();
    this.e.g().geo2Map(localIPoint.x, localIPoint.y, paramLatLng);
    localIPoint.recycle();
    return paramLatLng;
  }
  
  private void a()
  {
    float f2 = this.e.g().getMapConfig().getMapPerPixelUnitLength();
    if (this.E > 5000)
    {
      if (this.I <= 12)
      {
        float f1 = this.G / 2.0F + this.I / 2.0F;
        if (f1 > 200.0F) {
          f1 = 200.0F;
        }
        this.O = (f2 * f1);
        return;
      }
      this.O = (f2 * 10.0F);
      return;
    }
    this.O = (f2 * 2.0F);
  }
  
  private void a(float paramFloat, MapConfig arg2)
  {
    if (this.ag) {
      return;
    }
    boolean bool = this.w;
    int i3 = 0;
    int i1;
    int i2;
    if (!bool) {
      try
      {
        if (this.j != null)
        {
          this.R = new int[this.j.size()];
          if (Build.VERSION.SDK_INT < 12) {
            break label373;
          }
          bool = true;
          b();
          ??? = this.j.iterator();
          i1 = 0;
          while (((Iterator)???).hasNext())
          {
            i2 = a(bool, (BitmapDescriptor)((Iterator)???).next(), false);
            this.R[i1] = i2;
            i1 += 1;
          }
          this.w = true;
        }
      }
      catch (Throwable ???)
      {
        gk.c(???, "MarkerDelegateImp", "loadtexture");
        return;
      }
    }
    FPoint[] arrayOfFPoint = ???.getGeoRectangle().getClipMapRect();
    label373:
    label379:
    for (;;)
    {
      try
      {
        ??? = this.h;
        if (!a(arrayOfFPoint)) {
          break label379;
        }
        synchronized (this.r)
        {
          ??? = dx.b(arrayOfFPoint, this.h, false);
        }
        if (???.size() >= 2)
        {
          c(???);
          synchronized (this.n)
          {
            ??? = new int[this.n.size()];
            i1 = 0;
            if (i1 < ???.length)
            {
              int i4 = ((Integer)this.n.get(i1)).intValue();
              i2 = i4;
              if (i4 < 0) {
                i2 = 0;
              }
              ???[i1] = this.R[i2];
              i1 += 1;
              continue;
            }
            i1 = i3;
            if (this.Q != null) {
              i1 = 1;
            }
            if ((0x1 & i1) != 0)
            {
              AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.P, this.b, paramFloat, (int[])???, ???.length, this.Q, this.Q.length, 1.0F - this.N, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
              return;
            }
          }
        }
        return;
      }
      catch (Throwable ???)
      {
        ???.printStackTrace();
      }
      bool = false;
      break;
    }
  }
  
  private void a(lu paramlu)
  {
    if (paramlu != null)
    {
      this.k.add(paramlu);
      paramlu.l();
    }
  }
  
  private void a(MapConfig paramMapConfig)
  {
    float f1 = this.e.g().getMapProjection().getMapLenWithWin((int)this.G);
    switch (this.B)
    {
    default: 
      return;
    case 5: 
      if (this.A)
      {
        a(f1, paramMapConfig);
        return;
      }
      c(f1, paramMapConfig);
      return;
    case 4: 
      b(f1, paramMapConfig);
      return;
    case 3: 
      c(f1, paramMapConfig);
      return;
    case 2: 
      if (this.F == -1)
      {
        f(f1, paramMapConfig);
        return;
      }
      e(f1, paramMapConfig);
      return;
    case 1: 
      if (this.A)
      {
        d(f1, paramMapConfig);
        return;
      }
      f(f1, paramMapConfig);
      return;
    }
    f(f1, paramMapConfig);
  }
  
  private boolean a(FPoint paramFPoint1, FPoint paramFPoint2)
  {
    boolean bool2 = paramFPoint1 instanceof FPoint3;
    boolean bool1 = true;
    if ((bool2) && ((paramFPoint2 instanceof FPoint3)) && (((FPoint3)paramFPoint1).colorIndex != ((FPoint3)paramFPoint2).colorIndex)) {
      return true;
    }
    if (Math.abs(paramFPoint2.x - paramFPoint1.x) < this.O)
    {
      if (Math.abs(paramFPoint2.y - paramFPoint1.y) >= this.O) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean a(FPoint[] paramArrayOfFPoint)
  {
    this.I = this.e.g().getZoomLevel();
    a();
    int i1;
    if (this.g.size() > 10000) {
      i1 = 7;
    } else {
      i1 = 3;
    }
    if (this.I <= i1) {
      return false;
    }
    try
    {
      if (this.e.g() != null)
      {
        if (dx.a(this.T.northeast, paramArrayOfFPoint))
        {
          boolean bool = dx.a(this.T.southwest, paramArrayOfFPoint);
          if (bool) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    catch (Throwable paramArrayOfFPoint) {}
    return false;
  }
  
  private void b()
  {
    if (this.k != null)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        lu locallu = (lu)localIterator.next();
        if ((locallu != null) && (this.e != null)) {
          this.e.a(locallu);
        }
      }
      this.k.clear();
    }
  }
  
  private void b(float paramFloat, MapConfig paramMapConfig)
  {
    ??? = new int[this.m.size()];
    int i2 = 0;
    int i1 = 0;
    while (i1 < this.m.size())
    {
      ???[i1] = ((Integer)this.m.get(i1)).intValue();
      i1 += 1;
    }
    FPoint[] arrayOfFPoint = paramMapConfig.getGeoRectangle().getClipMapRect();
    label256:
    for (;;)
    {
      try
      {
        paramMapConfig = this.h;
        if (!a(arrayOfFPoint)) {
          break label256;
        }
        synchronized (this.r)
        {
          paramMapConfig = dx.b(arrayOfFPoint, this.h, false);
        }
        if (paramMapConfig.size() >= 2)
        {
          c(paramMapConfig);
          paramMapConfig = new int[this.o.size()];
          i1 = 0;
          if (i1 < paramMapConfig.length)
          {
            paramMapConfig[i1] = ((Integer)this.o.get(i1)).intValue();
            i1 += 1;
            continue;
          }
          i1 = i2;
          if (this.Q != null) {
            i1 = 1;
          }
          if ((0x1 & i1) != 0)
          {
            AMapNativeRenderer.nativeDrawGradientColorLine(this.P, this.b, paramFloat, paramMapConfig, paramMapConfig.length, this.Q, this.Q.length, this.e.g().getLineTextureID(), this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
            return;
          }
        }
      }
      catch (Throwable paramMapConfig)
      {
        paramMapConfig.printStackTrace();
      }
      return;
    }
  }
  
  private int c()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  private void c(float paramFloat, MapConfig paramMapConfig)
  {
    ??? = new int[this.m.size()];
    int i2 = 0;
    int i1 = 0;
    while (i1 < this.m.size())
    {
      ???[i1] = ((Integer)this.m.get(i1)).intValue();
      i1 += 1;
    }
    FPoint[] arrayOfFPoint = paramMapConfig.getGeoRectangle().getClipMapRect();
    label256:
    for (;;)
    {
      try
      {
        paramMapConfig = this.h;
        if (!a(arrayOfFPoint)) {
          break label256;
        }
        synchronized (this.r)
        {
          paramMapConfig = dx.b(arrayOfFPoint, this.h, false);
        }
        if (paramMapConfig.size() >= 2)
        {
          c(paramMapConfig);
          paramMapConfig = new int[this.o.size()];
          i1 = 0;
          if (i1 < paramMapConfig.length)
          {
            paramMapConfig[i1] = ((Integer)this.o.get(i1)).intValue();
            i1 += 1;
            continue;
          }
          i1 = i2;
          if (this.Q != null) {
            i1 = 1;
          }
          if ((0x1 & i1) != 0)
          {
            AMapNativeRenderer.nativeDrawLineByMultiColor(this.P, this.b, paramFloat, this.e.g().getLineTextureID(), paramMapConfig, paramMapConfig.length, this.Q, this.Q.length, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
            return;
          }
        }
      }
      catch (Throwable paramMapConfig)
      {
        paramMapConfig.printStackTrace();
      }
      return;
    }
  }
  
  private void c(List<FPoint> paramList)
    throws RemoteException
  {
    this.c.clear();
    int i3 = paramList.size();
    if (i3 < 2) {
      return;
    }
    int i2 = 0;
    Object localObject1 = (FPoint)paramList.get(0);
    this.c.add(localObject1);
    int i1 = 1;
    int i4;
    Object localObject2;
    for (;;)
    {
      i4 = i3 - 1;
      if (i1 >= i4) {
        break;
      }
      localObject2 = (FPoint)paramList.get(i1);
      if ((i1 != 1) && (!a((FPoint)localObject1, (FPoint)localObject2)))
      {
        this.c.set(this.c.size() - 1, localObject2);
      }
      else
      {
        this.c.add(localObject2);
        localObject1 = localObject2;
      }
      i1 += 1;
    }
    this.c.add(paramList.get(i4));
    int i6 = this.c.size() * 3;
    this.b = i6;
    if ((this.P == null) || (this.P.length < this.b)) {
      this.P = new float[i6];
    }
    if ((this.B != 5) && (this.B != 3) && (this.B != 4))
    {
      paramList = this.c.iterator();
      i1 = i2;
    }
    while (paramList.hasNext())
    {
      localObject1 = (FPoint)paramList.next();
      localObject2 = this.P;
      i2 = i1 * 3;
      localObject2[i2] = ((FPoint)localObject1).x;
      this.P[(i2 + 1)] = ((FPoint)localObject1).y;
      this.P[(i2 + 2)] = 0.0F;
      i1 += 1;
      continue;
      paramList = new int[this.c.size()];
      localObject1 = new ArrayList();
      i3 = 0;
      i1 = 0;
      i4 = 0;
      while (i3 < i6 / 3)
      {
        localObject2 = (FPoint3)this.c.get(i3);
        float[] arrayOfFloat = this.P;
        i2 = i3 * 3;
        arrayOfFloat[i2] = ((FPoint3)localObject2).x;
        this.P[(i2 + 1)] = ((FPoint3)localObject2).y;
        this.P[(i2 + 2)] = 0.0F;
        int i5 = ((FPoint3)localObject2).colorIndex;
        if (i3 == 0)
        {
          ((List)localObject1).add(Integer.valueOf(i5));
          i2 = i5;
        }
        else
        {
          if (i5 == i1) {
            break label471;
          }
          i2 = i5;
          if (i5 == -1) {
            i2 = i1;
          }
          ((List)localObject1).add(Integer.valueOf(i2));
        }
        paramList[i4] = i3;
        i4 += 1;
        i1 = i2;
        label471:
        i3 += 1;
      }
      this.Q = new int[((List)localObject1).size()];
      System.arraycopy(paramList, 0, this.Q, 0, this.Q.length);
      this.n = ((List)localObject1);
      this.o = ((List)localObject1);
    }
  }
  
  private ArrayList<FPoint> d()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < this.P.length; i1 = i1 + 1 + 1)
    {
      float f1 = this.P[i1];
      i1 += 1;
      localArrayList.add(FPoint.obtain(f1, this.P[i1]));
    }
    return localArrayList;
  }
  
  private void d(float paramFloat, MapConfig paramMapConfig)
  {
    if (!this.w) {}
    for (;;)
    {
      try
      {
        try
        {
          if (this.q != null)
          {
            if (Build.VERSION.SDK_INT < 12) {
              continue;
            }
            bool = true;
            this.C = a(bool, this.q, true);
            this.w = true;
          }
        }
        catch (Throwable paramMapConfig)
        {
          gk.c(paramMapConfig, "MarkerDelegateImp", "loadtexture");
          return;
        }
      }
      finally
      {
        boolean bool;
        continue;
        continue;
      }
      throw paramMapConfig;
      try
      {
        if ((paramMapConfig.getChangeRatio() == 1.0D) && (this.P != null))
        {
          this.V += 1;
          if (this.V > 2)
          {
            AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.C, this.K, this.L, this.M, this.J, 1.0F - this.N, false, false, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
            return;
          }
        }
        this.V = 0;
        FPoint[] arrayOfFPoint = paramMapConfig.getGeoRectangle().getClipMapRect();
        paramMapConfig = this.h;
        if (!a(arrayOfFPoint)) {
          continue;
        }
        synchronized (this.r)
        {
          paramMapConfig = dx.a(arrayOfFPoint, this.h, false);
        }
        if (paramMapConfig.size() >= 2)
        {
          c(paramMapConfig);
          AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.C, this.K, this.L, this.M, this.J, 1.0F - this.N, false, false, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
        }
        return;
      }
      catch (Throwable paramMapConfig)
      {
        return;
      }
      bool = false;
    }
  }
  
  private void d(List<BitmapDescriptor> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (paramList.size() > 1)
      {
        this.t = false;
        this.B = 5;
        this.j = paramList;
        this.e.g().setRunLowFrame(false);
        return;
      }
      setCustomTexture((BitmapDescriptor)paramList.get(0));
      return;
    }
  }
  
  private List<Integer> e(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    int i3 = 0;
    int i2 = 0;
    while (i1 < paramList.size())
    {
      int i4 = ((Integer)paramList.get(i1)).intValue();
      if (i1 == 0)
      {
        localArrayList.add(Integer.valueOf(i4));
      }
      else
      {
        if (i4 == i3) {
          break label107;
        }
        localArrayList.add(Integer.valueOf(i4));
      }
      arrayOfInt[i2] = i1;
      i2 += 1;
      i3 = i4;
      label107:
      i1 += 1;
    }
    this.Q = new int[localArrayList.size()];
    System.arraycopy(arrayOfInt, 0, this.Q, 0, this.Q.length);
    return localArrayList;
  }
  
  private void e(float paramFloat, MapConfig paramMapConfig)
  {
    if (!this.w) {}
    for (;;)
    {
      try
      {
        try
        {
          if (this.q != null)
          {
            if (Build.VERSION.SDK_INT < 12) {
              continue;
            }
            bool = true;
            this.C = a(bool, this.q, true);
            this.w = true;
          }
        }
        catch (Throwable paramMapConfig)
        {
          gk.c(paramMapConfig, "MarkerDelegateImp", "loadtexture");
          return;
        }
      }
      finally
      {
        boolean bool;
        continue;
      }
      throw paramMapConfig;
      try
      {
        ??? = this.h;
        if (this.e.g() == null) {
          return;
        }
        if ((paramMapConfig.getChangeRatio() == 1.0D) && (this.P != null))
        {
          this.V += 1;
          if (this.V > 2)
          {
            AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.e.g().getDottedLineTextureID(this.F), this.K, this.L, this.M, this.J, 0.0F, true, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
            return;
          }
        }
        this.V = 0;
        FPoint[] arrayOfFPoint = paramMapConfig.getGeoRectangle().getClipMapRect();
        paramMapConfig = (MapConfig)???;
        if (a(arrayOfFPoint)) {
          synchronized (this.r)
          {
            paramMapConfig = dx.a(arrayOfFPoint, this.h, false);
          }
        }
        if (paramMapConfig.size() >= 2)
        {
          c(paramMapConfig);
          AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.e.g().getDottedLineTextureID(this.F), this.K, this.L, this.M, this.J, 0.0F, true, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
        }
        return;
      }
      catch (Throwable paramMapConfig)
      {
        return;
      }
      bool = false;
    }
  }
  
  private void f(float paramFloat, MapConfig paramMapConfig)
  {
    try
    {
      ??? = this.h;
      if (this.e.g() == null) {
        return;
      }
      if ((paramMapConfig.getChangeRatio() == 1.0D) && (this.P != null))
      {
        this.V += 1;
        if (this.V > 2)
        {
          if ((this.Z != 0L) && (this.Y != null))
          {
            AMapNativePolyline.nativeDrawLineByTextureID(this.Z, this.P, this.b, paramFloat, this.e.g().getLineTextureID(), this.K, this.L, this.M, this.J, 0.0F, false, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
            return;
          }
          AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.e.g().getLineTextureID(), this.K, this.L, this.M, this.J, 0.0F, false, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
          return;
        }
      }
      this.V = 0;
      FPoint[] arrayOfFPoint = paramMapConfig.getGeoRectangle().getClipMapRect();
      paramMapConfig = (MapConfig)???;
      if (a(arrayOfFPoint)) {
        synchronized (this.r)
        {
          paramMapConfig = dx.a(arrayOfFPoint, this.h, false);
        }
      }
      if (paramMapConfig.size() >= 2)
      {
        c(paramMapConfig);
        if ((this.Z != 0L) && (this.Y != null))
        {
          AMapNativePolyline.nativeDrawLineByTextureID(this.Z, this.P, this.b, paramFloat, this.e.g().getLineTextureID(), this.K, this.L, this.M, this.J, 0.0F, false, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
          return;
        }
        AMapNativeRenderer.nativeDrawLineByTextureID(this.P, this.b, paramFloat, this.e.g().getLineTextureID(), this.K, this.L, this.M, this.J, 0.0F, false, true, false, this.e.h(), this.X.getTypeValue(), this.W.getTypeValue());
      }
      return;
    }
    catch (Throwable paramMapConfig) {}
  }
  
  IPoint a(IPoint paramIPoint1, IPoint paramIPoint2, IPoint paramIPoint3, double paramDouble, int paramInt)
  {
    IPoint localIPoint = IPoint.obtain();
    double d1 = paramIPoint2.x - paramIPoint1.x;
    double d2 = paramIPoint2.y - paramIPoint1.y;
    Double.isNaN(d2);
    Double.isNaN(d2);
    Double.isNaN(d1);
    Double.isNaN(d1);
    double d3 = d2 * d2 / (d1 * d1);
    double d4 = paramInt;
    Double.isNaN(d4);
    paramDouble = d4 * paramDouble / Math.sqrt(d3 + 1.0D);
    d3 = paramIPoint3.y;
    Double.isNaN(d3);
    localIPoint.y = ((int)(paramDouble + d3));
    paramDouble = paramIPoint3.y - localIPoint.y;
    Double.isNaN(paramDouble);
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramDouble = paramDouble * d2 / d1;
    d1 = paramIPoint3.x;
    Double.isNaN(d1);
    localIPoint.x = ((int)(paramDouble + d1));
    return localIPoint;
  }
  
  public void a(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void a(cl paramcl)
  {
    this.Y = paramcl;
  }
  
  void a(LatLng paramLatLng1, LatLng paramLatLng2, List<IPoint> paramList, LatLngBounds.Builder paramBuilder)
  {
    double d1 = Math.abs(paramLatLng1.longitude - paramLatLng2.longitude) * 3.141592653589793D / 180.0D;
    Object localObject = new LatLng((paramLatLng2.latitude + paramLatLng1.latitude) / 2.0D, (paramLatLng2.longitude + paramLatLng1.longitude) / 2.0D, false);
    paramBuilder.include(paramLatLng1).include((LatLng)localObject).include(paramLatLng2);
    int i1;
    if (((LatLng)localObject).latitude > 0.0D) {
      i1 = -1;
    } else {
      i1 = 1;
    }
    paramBuilder = IPoint.obtain();
    this.e.g().latlon2Geo(paramLatLng1.latitude, paramLatLng1.longitude, paramBuilder);
    paramLatLng1 = IPoint.obtain();
    this.e.g().latlon2Geo(paramLatLng2.latitude, paramLatLng2.longitude, paramLatLng1);
    paramLatLng2 = IPoint.obtain();
    this.e.g().latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramLatLng2);
    d1 *= 0.5D;
    double d2 = Math.cos(d1);
    paramLatLng2 = a(paramBuilder, paramLatLng1, paramLatLng2, Math.hypot(paramBuilder.x - paramLatLng1.x, paramBuilder.y - paramLatLng1.y) * 0.5D * Math.tan(d1), i1);
    localObject = new ArrayList();
    ((List)localObject).add(paramBuilder);
    ((List)localObject).add(paramLatLng2);
    ((List)localObject).add(paramLatLng1);
    a((List)localObject, paramList, d2);
    paramBuilder.recycle();
    paramLatLng2.recycle();
    paramLatLng1.recycle();
  }
  
  public void a(PolylineOptions.LineCapType paramLineCapType)
  {
    this.X = paramLineCapType;
  }
  
  public void a(PolylineOptions.LineJoinType paramLineJoinType)
  {
    this.W = paramLineJoinType;
  }
  
  void a(List<LatLng> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    LatLngBounds.Builder localBuilder = LatLngBounds.builder();
    Object localObject;
    if (paramList != null)
    {
      localObject = null;
      Iterator localIterator = paramList.iterator();
      int i1 = 0;
      paramList = (List<LatLng>)localObject;
      for (;;)
      {
        i2 = i1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (LatLng)localIterator.next();
        if (!this.u)
        {
          paramList = IPoint.obtain();
          this.e.g().latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramList);
          localArrayList.add(paramList);
          localBuilder.include((LatLng)localObject);
        }
        else if (paramList != null)
        {
          if (Math.abs(((LatLng)localObject).longitude - paramList.longitude) < 0.01D)
          {
            IPoint localIPoint = IPoint.obtain();
            this.e.g().latlon2Geo(paramList.latitude, paramList.longitude, localIPoint);
            localArrayList.add(localIPoint);
            localBuilder.include(paramList);
            paramList = IPoint.obtain();
            this.e.g().latlon2Geo(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, paramList);
            localArrayList.add(paramList);
            localBuilder.include((LatLng)localObject);
          }
          else
          {
            a(paramList, (LatLng)localObject, localArrayList, localBuilder);
          }
        }
        int i3 = i1;
        if (localObject != null)
        {
          i2 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            if (((LatLng)localObject).longitude < -180.0D)
            {
              this.aa = true;
              i2 = 1;
            }
          }
          i3 = i2;
          if (!this.aa)
          {
            i3 = i2;
            if (((LatLng)localObject).longitude > 180.0D)
            {
              this.aa = true;
              i3 = i2;
            }
          }
        }
        paramList = (List<LatLng>)localObject;
        i1 = i3;
      }
    }
    int i2 = 0;
    this.g = localArrayList;
    this.E = 0;
    if (this.a == null) {
      this.a = new Rect();
    }
    dx.a(this.a);
    paramList = this.g.iterator();
    while (paramList.hasNext())
    {
      localObject = (IPoint)paramList.next();
      if (i2 != 0) {
        ((IPoint)localObject).x += 268435456;
      }
      dx.b(this.a, ((IPoint)localObject).x, ((IPoint)localObject).y);
    }
    this.a.sort();
    this.e.g().setRunLowFrame(false);
  }
  
  void a(List<IPoint> paramList1, List<IPoint> paramList2, double paramDouble)
  {
    if (paramList1.size() != 3) {
      return;
    }
    float f1;
    for (int i1 = 0; i1 <= 10; i1 = (int)(f1 + 1.0F))
    {
      f1 = i1;
      float f2 = f1 / 10.0F;
      IPoint localIPoint = IPoint.obtain();
      double d1 = f2;
      Double.isNaN(d1);
      double d3 = 1.0D - d1;
      d1 = d3 * d3;
      double d2 = ((IPoint)paramList1.get(0)).x;
      Double.isNaN(d2);
      double d4 = 2.0F * f2;
      Double.isNaN(d4);
      d3 = d4 * d3;
      d4 = ((IPoint)paramList1.get(1)).x;
      Double.isNaN(d4);
      f2 *= f2;
      double d5 = ((IPoint)paramList1.get(2)).x * f2;
      Double.isNaN(d5);
      double d6 = ((IPoint)paramList1.get(0)).y;
      Double.isNaN(d6);
      double d7 = ((IPoint)paramList1.get(1)).y;
      Double.isNaN(d7);
      double d8 = ((IPoint)paramList1.get(2)).y * f2;
      Double.isNaN(d8);
      double d9 = f2;
      Double.isNaN(d9);
      d9 = d1 + d3 * paramDouble + d9;
      localIPoint.x = ((int)((d2 * d1 + d4 * d3 * paramDouble + d5) / d9));
      localIPoint.y = ((int)((d6 * d1 + d7 * d3 * paramDouble + d8) / d9));
      paramList2.add(localIPoint);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
    this.e.g().setRunLowFrame(false);
  }
  
  public boolean b(List<IPoint> paramList)
  {
    synchronized (this.r)
    {
      FPointBounds.Builder localBuilder = new FPointBounds.Builder();
      this.h.clear();
      int i1 = 0;
      this.z = false;
      this.P = new float[paramList.size() * 3];
      this.b = this.P.length;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ??? = (IPoint)localIterator.next();
        FPoint3 localFPoint3 = new FPoint3();
        this.e.g().geo2Map(((IPoint)???).x, ((IPoint)???).y, localFPoint3);
        ??? = this.P;
        int i2 = i1 * 3;
        ???[i2] = localFPoint3.x;
        this.P[(i2 + 1)] = localFPoint3.y;
        this.P[(i2 + 2)] = 0.0F;
        if (this.l != null) {
          synchronized (this.l)
          {
            if ((this.l != null) && (this.l.size() > i1))
            {
              if (this.ae <= 0) {
                localFPoint3.setColorIndex(((Integer)this.l.get(i1)).intValue());
              } else if (this.ae + i1 < this.l.size()) {
                localFPoint3.setColorIndex(((Integer)this.l.get(this.ae + i1)).intValue());
              }
            }
            else if ((this.m != null) && (this.m.size() > i1)) {
              if (this.ae <= 0) {
                localFPoint3.setColorIndex(((Integer)this.m.get(i1)).intValue());
              } else if (this.ae + i1 < this.m.size()) {
                localFPoint3.setColorIndex(((Integer)this.m.get(this.ae + i1)).intValue());
              }
            }
          }
        }
        this.h.add(localFPoint3);
        localBuilder.include(localFPoint3);
        i1 += 1;
      }
      this.T = localBuilder.build();
      if (!this.A) {
        this.p = dx.a(this.P);
      }
      this.E = paramList.size();
      a();
      return true;
    }
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    if ((this.ab == -1.0F) && (this.ac == -1.0F) && (this.ad == -1.0F)) {
      b(this.g);
    } else {
      b(this.af);
    }
    return true;
  }
  
  public boolean checkInBounds()
  {
    if (this.aa) {
      return true;
    }
    Rectangle localRectangle = this.e.g().getMapConfig().getGeoRectangle();
    if ((this.a != null) && (localRectangle != null)) {
      return localRectangle.isOverlap(this.a);
    }
    return true;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    Object localObject = new float[this.P.length];
    System.arraycopy(this.P, 0, localObject, 0, this.P.length);
    if (localObject.length / 3 < 2) {
      return false;
    }
    try
    {
      ArrayList localArrayList = d();
      if (localArrayList != null)
      {
        int i1 = localArrayList.size();
        if (i1 < 1) {
          return false;
        }
        double d1 = this.e.g().getMapProjection().getMapLenWithWin((int)this.G / 4);
        double d2 = this.e.g().getMapProjection().getMapLenWithWin(5);
        FPoint localFPoint = a(paramLatLng);
        paramLatLng = null;
        i1 = 0;
        while (i1 < localArrayList.size() - 1)
        {
          if (i1 == 0) {
            paramLatLng = (FPoint)localArrayList.get(i1);
          }
          i1 += 1;
          localObject = (FPoint)localArrayList.get(i1);
          double d3 = a(localFPoint, paramLatLng, (FPoint)localObject);
          Double.isNaN(d2);
          Double.isNaN(d1);
          if (d2 + d1 - d3 >= 0.0D)
          {
            localArrayList.clear();
            return true;
          }
          paramLatLng = (LatLng)localObject;
        }
        localArrayList.clear();
        return false;
      }
      return false;
    }
    catch (Exception paramLatLng) {}
    return false;
  }
  
  public void destroy()
  {
    for (;;)
    {
      int i1;
      try
      {
        remove();
        if ((this.k != null) && (this.k.size() > 0))
        {
          i1 = 0;
          if (i1 < this.k.size())
          {
            ??? = (lu)this.k.get(i1);
            if (??? != null)
            {
              this.e.a((lu)???);
              this.e.g().removeTextureItem(((lu)???).o());
            }
          }
          else
          {
            this.k.clear();
          }
        }
        else
        {
          if (this.P != null) {
            this.P = null;
          }
          if (this.p != null)
          {
            this.p.clear();
            this.p = null;
          }
          if ((this.j != null) && (this.j.size() > 0))
          {
            ??? = this.j.iterator();
            if (((Iterator)???).hasNext())
            {
              ((BitmapDescriptor)((Iterator)???).next()).recycle();
              continue;
            }
          }
          try
          {
            if (this.q != null) {
              this.q.recycle();
            }
            if (this.m != null)
            {
              this.m.clear();
              this.m = null;
            }
            if (this.l != null) {
              synchronized (this.l)
              {
                this.l.clear();
                this.l = null;
              }
            }
            if (this.i != null)
            {
              this.i.clear();
              this.i = null;
            }
            this.U = null;
            if (this.Z != 0L)
            {
              AMapNativePolyline.nativeDestroy(this.Z);
              return;
            }
          }
          finally {}
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "PolylineDelegateImp", "destroy");
        localThrowable.printStackTrace();
        Log.d("destroy erro", "PolylineDelegateImp destroy");
      }
      i1 += 1;
    }
  }
  
  public void draw(MapConfig arg1)
    throws RemoteException
  {
    if (this.ag) {
      return;
    }
    if (this.Z == 0L)
    {
      this.Z = AMapNativePolyline.nativeCreate();
      if ((this.Z != 0L) && (this.Y != null)) {
        AMapNativePolyline.nativeSetGLShaderManager(this.Z, this.Y.a());
      }
    }
    for (;;)
    {
      int i1;
      synchronized (this.r)
      {
        if ((this.ab == -1.0F) && (this.ac == -1.0F) && (this.ad == -1.0F)) {
          ??? = this.g;
        } else {
          ??? = this.af;
        }
        if ((??? != null) && (???.size() != 0) && (this.G > 0.0F))
        {
          if (this.e.g() == null) {
            return;
          }
          int i3 = (int)???.getSX();
          int i4 = (int)???.getSY();
          int i5 = ???.getGeoRectangle().getBeyond180Mode();
          i1 = this.h.size();
          int i6 = ???.size();
          Object localObject5;
          int i2;
          if (i1 == i6)
          {
            i1 = 0;
            if (i1 < i6)
            {
              ??? = (IPoint)???.get(i1);
              localObject5 = (FPoint)this.h.get(i1);
              ((FPoint)localObject5).x = (((IPoint)???).x - i3);
              ((FPoint)localObject5).y = (((IPoint)???).y - i4);
              if ((!this.aa) || ((i5 >= 0) && (???.getSX() >= 1.34217728E8D))) {
                break label815;
              }
              ((FPoint)localObject5).x -= 2.68435456E8F;
              break label815;
            }
          }
          else
          {
            this.h.clear();
            i1 = 0;
            i2 = 0;
            if (i1 < i6)
            {
              localObject5 = (IPoint)???.get(i1);
              FPoint3 localFPoint3 = new FPoint3();
              if (this.l != null) {
                synchronized (this.l)
                {
                  if (this.ae <= 0)
                  {
                    if ((this.l != null) && (this.l.size() > i2)) {
                      localFPoint3.setColorIndex(((Integer)this.l.get(i2)).intValue());
                    }
                  }
                  else if ((this.l != null) && (this.l.size() > this.ae + i2)) {
                    localFPoint3.setColorIndex(((Integer)this.l.get(this.ae + i2)).intValue());
                  }
                }
              }
              localFPoint3.x = (((IPoint)localObject5).x - i3);
              localFPoint3.y = (((IPoint)localObject5).y - i4);
              if ((!this.aa) || ((i5 >= 0) && (???.getSX() >= 1.34217728E8D))) {
                break label822;
              }
              localFPoint3.x -= 2.68435456E8F;
              this.h.add(localFPoint3);
              i2 += 1;
              i1 += 1;
              continue;
            }
          }
          if (this.x)
          {
            calMapFPoint();
            this.x = false;
          }
          else
          {
            i1 = 0;
            if (this.y) {
              synchronized (this.r)
              {
                i2 = this.h.size();
                synchronized (this.l)
                {
                  i3 = this.l.size();
                  if (i1 < i2)
                  {
                    if ((i3 > i1) && (this.ae <= 0))
                    {
                      ((FPoint3)this.h.get(i1)).setColorIndex(((Integer)this.l.get(i1)).intValue());
                      break label825;
                    }
                    if ((i3 <= this.ae + i1) || (this.ae <= 0)) {
                      break label825;
                    }
                    ((FPoint3)this.h.get(i1)).setColorIndex(((Integer)this.l.get(this.ae + i1)).intValue());
                    break label825;
                  }
                }
              }
            }
          }
          if ((this.P != null) && (this.E > 0)) {
            a(this.e.g().getMapConfig());
          }
          this.z = true;
        }
        else
        {
          return;
        }
      }
      label815:
      i1 += 1;
      continue;
      label822:
      continue;
      label825:
      i1 += 1;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public int getColor()
    throws RemoteException
  {
    return this.D;
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.f == null) {
      this.f = this.e.a("Polyline");
    }
    return this.f;
  }
  
  public LatLng getNearestLatLng(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    int i1;
    int i2;
    if (this.i != null)
    {
      if (this.i.size() == 0) {
        return null;
      }
      i1 = 0;
      i2 = 0;
    }
    float f1;
    for (float f2 = 0.0F;; f2 = f1)
    {
      try
      {
        if (i1 < this.i.size())
        {
          if (i1 == 0)
          {
            f1 = AMapUtils.calculateLineDistance(paramLatLng, (LatLng)this.i.get(i1));
            break label150;
          }
          float f3 = AMapUtils.calculateLineDistance(paramLatLng, (LatLng)this.i.get(i1));
          f1 = f2;
          if (f2 <= f3) {
            break label150;
          }
          i2 = i1;
          f1 = f3;
          break label150;
        }
        paramLatLng = (LatLng)this.i.get(i2);
        return paramLatLng;
      }
      catch (Throwable paramLatLng)
      {
        gk.c(paramLatLng, "PolylineDelegateImp", "getNearestLatLng");
        paramLatLng.printStackTrace();
        return null;
      }
      return null;
      label150:
      i1 += 1;
    }
  }
  
  public PolylineOptions getOptions()
  {
    return this.U;
  }
  
  public List<LatLng> getPoints()
    throws RemoteException
  {
    return this.i;
  }
  
  public float getShownRatio()
  {
    return this.ab;
  }
  
  public float getWidth()
    throws RemoteException
  {
    return this.G;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.H;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return super.hashCode();
  }
  
  public boolean isAboveMaskLayer()
  {
    return this.S;
  }
  
  public boolean isDottedLine()
  {
    return this.v;
  }
  
  public boolean isDrawFinish()
  {
    return this.z;
  }
  
  public boolean isGeodesic()
  {
    return this.u;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.s;
  }
  
  public void reLoadTexture()
  {
    this.w = false;
    this.C = 0;
    if (this.R != null) {
      Arrays.fill(this.R, 0);
    }
  }
  
  public void remove()
    throws RemoteException
  {
    this.ag = true;
    this.e.removeOverlay(getId());
    setVisible(false);
    this.e.g().setRunLowFrame(false);
  }
  
  public void setAboveMaskLayer(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public void setColor(int paramInt)
  {
    if ((this.B == 0) || (this.B == 2))
    {
      this.D = paramInt;
      this.J = (Color.alpha(paramInt) / 255.0F);
      this.K = (Color.red(paramInt) / 255.0F);
      this.L = (Color.green(paramInt) / 255.0F);
      this.M = (Color.blue(paramInt) / 255.0F);
      if (this.t) {
        if (this.v) {
          this.B = 2;
        } else {
          this.B = 0;
        }
      }
      this.e.g().setRunLowFrame(false);
    }
    this.U.color(paramInt);
  }
  
  public void setColorValues(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.m = paramList;
      if (paramList.size() > 1)
      {
        this.t = false;
        this.o = e(paramList);
        this.B = 3;
        this.e.g().setRunLowFrame(false);
        return;
      }
      setColor(((Integer)paramList.get(0)).intValue());
      return;
    }
  }
  
  public void setCustemTextureIndex(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      try
      {
        synchronized (this.l)
        {
          this.l.clear();
          this.l.addAll(paramList);
          this.n = e(paramList);
          this.y = true;
          return;
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
  }
  
  public void setCustomTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    long l1 = System.nanoTime();
    if (l1 - this.d < 16) {
      return;
    }
    this.d = l1;
    if (paramBitmapDescriptor == null) {
      return;
    }
    try
    {
      if (paramBitmapDescriptor.equals(this.q)) {
        return;
      }
      this.t = false;
      this.w = false;
      this.B = 1;
      this.q = paramBitmapDescriptor;
      this.e.g().setRunLowFrame(false);
      if (this.U != null) {
        this.U.setCustomTexture(paramBitmapDescriptor);
      }
      return;
    }
    finally {}
  }
  
  public void setCustomTextureList(List<BitmapDescriptor> paramList)
  {
    d(paramList);
    setCustemTextureIndex(this.U.getCustomTextureIndex());
    reLoadTexture();
  }
  
  public void setDottedLine(boolean paramBoolean)
  {
    if ((this.B == 2) || (this.B == 0))
    {
      this.v = paramBoolean;
      if ((paramBoolean) && (this.t)) {
        this.B = 2;
      } else if ((!paramBoolean) && (this.t)) {
        this.B = 0;
      }
      this.e.g().setRunLowFrame(false);
    }
  }
  
  public void setGeodesic(boolean paramBoolean)
    throws RemoteException
  {
    this.u = paramBoolean;
    this.e.g().setRunLowFrame(false);
  }
  
  public void setOptions(PolylineOptions paramPolylineOptions)
  {
    if (paramPolylineOptions == null) {
      return;
    }
    this.U = paramPolylineOptions;
    try
    {
      setColor(paramPolylineOptions.getColor());
      setGeodesic(paramPolylineOptions.isGeodesic());
      setDottedLine(paramPolylineOptions.isDottedLine());
      a(paramPolylineOptions.getDottedLineType());
      setAboveMaskLayer(paramPolylineOptions.isAboveMaskLayer());
      setVisible(paramPolylineOptions.isVisible());
      setWidth(paramPolylineOptions.getWidth());
      setZIndex(paramPolylineOptions.getZIndex());
      a(paramPolylineOptions.isUseTexture());
      setTransparency(paramPolylineOptions.getTransparency());
      a(paramPolylineOptions.getLineCapType());
      a(paramPolylineOptions.getLineJoinType());
      if (paramPolylineOptions.getColorValues() != null)
      {
        setColorValues(paramPolylineOptions.getColorValues());
        useGradient(paramPolylineOptions.isUseGradient());
      }
      if (paramPolylineOptions.getCustomTexture() != null)
      {
        setCustomTexture(paramPolylineOptions.getCustomTexture());
        reLoadTexture();
      }
      if (paramPolylineOptions.getCustomTextureList() != null)
      {
        d(paramPolylineOptions.getCustomTextureList());
        setCustemTextureIndex(paramPolylineOptions.getCustomTextureIndex());
        reLoadTexture();
      }
      setPoints(paramPolylineOptions.getPoints());
      setShownRatio(paramPolylineOptions.getShownRatio());
      setShowRange(paramPolylineOptions.getShownRangeBegin(), paramPolylineOptions.getShownRangeEnd());
      return;
    }
    catch (RemoteException paramPolylineOptions)
    {
      gk.c(paramPolylineOptions, "PolylineDelegateImp", "setOptions");
      paramPolylineOptions.printStackTrace();
    }
  }
  
  public void setPoints(List<LatLng> paramList)
    throws RemoteException
  {
    try
    {
      this.i = paramList;
      synchronized (this.r)
      {
        a(paramList);
        this.x = true;
        this.e.g().setRunLowFrame(false);
        this.U.setPoints(paramList);
        return;
      }
      return;
    }
    catch (Throwable paramList)
    {
      gk.c(paramList, "PolylineDelegateImp", "setPoints");
      this.g.clear();
      paramList.printStackTrace();
    }
  }
  
  public void setShowRange(float paramFloat1, float paramFloat2)
  {
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    this.ac = f2;
    this.ad = f1;
    for (;;)
    {
      int i1;
      int i2;
      Object localObject6;
      Object localObject4;
      synchronized (this.r)
      {
        i1 = this.g.size();
        if (i1 < 2) {
          return;
        }
        if (f2 > f1)
        {
          this.af.clear();
          Log.d("mapcore", "setShownRange return begin < end");
          return;
        }
        if (f2 < 0.0F) {
          break label906;
        }
        if (Float.isNaN(paramFloat1))
        {
          break label906;
          if ((f1 >= i1) || (Float.isNaN(paramFloat2))) {
            break label921;
          }
          f2 = paramFloat1;
          paramFloat2 = f1;
          if (this.u)
          {
            i2 = this.i.size();
            if (i2 < 2)
            {
              Log.d("mapcore", "setShownRatio return m_polylineOptions.m_latLngPoints.size() < MIN_POLYLINE_COUNT");
              return;
            }
            paramFloat2 = i2 - 1;
            f2 = paramFloat1 / paramFloat2;
            paramFloat1 = i1 - 1;
            f2 *= paramFloat1;
            paramFloat2 = f1 / paramFloat2 * paramFloat1;
          }
          this.af.clear();
          int i3 = (int)Math.floor(f2);
          int i4 = (int)Math.floor(paramFloat2);
          double d3 = f2 - i3;
          double d1 = paramFloat2 - i4;
          Object localObject5 = null;
          localObject6 = localObject5;
          i2 = i3;
          if (i2 < i1)
          {
            localObject4 = (IPoint)this.g.get(i2);
            Object localObject1;
            if (i3 >= i2)
            {
              localObject1 = localObject4;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject1 = localObject4;
              break label935;
            }
            double d2;
            if ((i3 < i2) && (i3 == i2 - 1))
            {
              localObject1 = new IPoint();
              double d4 = ((IPoint)localObject5).x;
              int i5 = ((IPoint)localObject4).x;
              int i6 = ((IPoint)localObject5).x;
              d2 = d1;
              double d5 = i5 - i6;
              Double.isNaN(d5);
              Double.isNaN(d3);
              Double.isNaN(d4);
              i5 = (int)(d4 + d5 * d3);
              ((IPoint)localObject1).x = i5;
              d4 = ((IPoint)localObject5).y;
              i5 = ((IPoint)localObject4).y;
              i6 = ((IPoint)localObject5).y;
              d5 = i5 - i6;
              Double.isNaN(d5);
              Double.isNaN(d3);
              Double.isNaN(d4);
              i5 = (int)(d4 + d5 * d3);
              ((IPoint)localObject1).y = i5;
              this.af.add(localObject1);
              if (i4 == i3)
              {
                localObject1 = new IPoint();
                d1 = ((IPoint)localObject5).x;
                i1 = ((IPoint)localObject4).x;
                i2 = ((IPoint)localObject5).x;
                d3 = i1 - i2;
                Double.isNaN(d3);
                Double.isNaN(d2);
                Double.isNaN(d1);
                i1 = (int)(d1 + d3 * d2);
                ((IPoint)localObject1).x = i1;
                d1 = ((IPoint)localObject5).y;
                i1 = ((IPoint)localObject4).y;
                i2 = ((IPoint)localObject5).y;
                d3 = i1 - i2;
                Double.isNaN(d3);
                Double.isNaN(d2);
                Double.isNaN(d1);
                i1 = (int)(d1 + d3 * d2);
                ((IPoint)localObject1).y = i1;
                this.af.add(localObject1);
              }
              else
              {
                this.af.add(localObject4);
                break label931;
              }
            }
            else
            {
              d2 = d1;
              if ((i3 < i2) && (i4 >= i2))
              {
                this.af.add(localObject4);
                break label931;
              }
              localObject1 = localObject6;
              if (i4 >= i2) {
                break label935;
              }
              localObject1 = new IPoint();
              d1 = ((IPoint)localObject6).x;
              i1 = ((IPoint)localObject4).x;
              i2 = ((IPoint)localObject6).x;
              d3 = i1 - i2;
              Double.isNaN(d3);
              Double.isNaN(d2);
              Double.isNaN(d1);
              i1 = (int)(d1 + d3 * d2);
              ((IPoint)localObject1).x = i1;
              d1 = ((IPoint)localObject6).y;
              i1 = ((IPoint)localObject4).y;
              i2 = ((IPoint)localObject6).y;
              d3 = i1 - i2;
              Double.isNaN(d3);
              Double.isNaN(d2);
              Double.isNaN(d1);
              i1 = (int)(d1 + d3 * d2);
              ((IPoint)localObject1).y = i1;
              this.af.add(localObject1);
            }
          }
          if (i3 >= 0) {
            this.ae = i3;
          }
          this.x = true;
          this.e.g().setRunLowFrame(false);
          this.U.setShownRange(this.ac, this.ad);
        }
      }
      paramFloat1 = f2;
      if (f2 >= i1)
      {
        paramFloat1 = i1 - 1;
        break label908;
        label906:
        paramFloat1 = 0.0F;
      }
      label908:
      if (f1 < 0.0F)
      {
        f1 = 0.0F;
        continue;
        label921:
        f1 = i1 - 1;
        continue;
        label931:
        Object localObject3 = localObject4;
        label935:
        i2 += 1;
        localObject6 = localObject3;
      }
    }
  }
  
  public void setShownRatio(float paramFloat)
  {
    this.ab = paramFloat;
    for (;;)
    {
      int i2;
      float f2;
      synchronized (this.r)
      {
        i2 = this.g.size();
        if (i2 < 2) {
          return;
        }
        f2 = this.ab;
        if (f2 < 0.0F)
        {
          f1 = 0.0F;
          f2 = f1;
          if (this.u)
          {
            i1 = this.i.size();
            if (i1 < 2) {
              return;
            }
            f2 = f1 / (i1 - 1) * (i2 - 1);
          }
          this.af.clear();
          int i3 = (int)Math.floor(f2);
          Object localObject1 = null;
          int i1 = 0;
          if (i1 < i2)
          {
            IPoint localIPoint1 = (IPoint)this.g.get(i1);
            if (i1 > i3)
            {
              f1 = f2 - i3;
              if ((paramFloat != 0.0F) && (localObject1 != null))
              {
                IPoint localIPoint2 = new IPoint();
                localIPoint2.x = ((int)(((IPoint)localObject1).x + (localIPoint1.x - ((IPoint)localObject1).x) * f1));
                localIPoint2.y = ((int)(((IPoint)localObject1).y + (localIPoint1.y - ((IPoint)localObject1).y) * f1));
                this.af.add(localIPoint2);
              }
            }
            else
            {
              this.af.add(localIPoint1);
              i1 += 1;
              localObject1 = localIPoint1;
              continue;
            }
          }
          this.x = true;
          this.e.g().setRunLowFrame(false);
          this.U.setShownRatio(paramFloat);
          return;
        }
      }
      float f1 = f2;
      if (f2 >= i2) {
        f1 = i2 - 1;
      }
    }
  }
  
  public void setTransparency(float paramFloat)
  {
    this.N = ((float)Math.min(1.0D, Math.max(0.0D, paramFloat)));
    this.e.g().setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.s = paramBoolean;
    this.e.g().setRunLowFrame(false);
    if (this.U != null) {
      this.U.visible(paramBoolean);
    }
  }
  
  public void setWidth(float paramFloat)
    throws RemoteException
  {
    this.G = paramFloat;
    this.e.g().setRunLowFrame(false);
    this.U.width(paramFloat);
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.H = paramFloat;
    this.e.e();
    this.e.g().setRunLowFrame(false);
    if (this.U != null) {
      this.U.zIndex(paramFloat);
    }
  }
  
  public void useGradient(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.m != null) && (this.m.size() > 1))
    {
      this.B = 4;
      this.e.g().setRunLowFrame(false);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */