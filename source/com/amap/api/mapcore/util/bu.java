package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

public class bu
  implements IArcDelegate
{
  float a;
  float b;
  float c;
  float d;
  private LatLng e;
  private LatLng f;
  private LatLng g;
  private float h = 10.0F;
  private int i = -16777216;
  private float j = 0.0F;
  private boolean k = true;
  private String l;
  private IAMapDelegate m;
  private float[] n;
  private int o = 0;
  private boolean p = false;
  private double q = 0.0D;
  private double r = 0.0D;
  private double s = 0.0D;
  private double t = 0.0D;
  private double u = 0.0D;
  
  public bu(IAMapDelegate paramIAMapDelegate)
  {
    this.m = paramIAMapDelegate;
    try
    {
      this.l = getId();
      return;
    }
    catch (RemoteException paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "ArcDelegateImp", "create");
      paramIAMapDelegate.printStackTrace();
    }
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble4 = (paramDouble2 - paramDouble4) / this.q;
    paramDouble2 = paramDouble4;
    if (Math.abs(paramDouble4) > 1.0D) {
      paramDouble2 = Math.signum(paramDouble4);
    }
    paramDouble4 = Math.asin(paramDouble2);
    if (paramDouble4 >= 0.0D)
    {
      paramDouble2 = paramDouble4;
      if (paramDouble3 < paramDouble1) {
        return 3.141592653589793D - Math.abs(paramDouble4);
      }
    }
    else
    {
      if (paramDouble3 < paramDouble1) {
        return 3.141592653589793D - paramDouble4;
      }
      paramDouble2 = paramDouble4 + 6.283185307179586D;
    }
    return paramDouble2;
  }
  
  private FPoint a(GLMapState paramGLMapState, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d1 = Math.cos(paramDouble1);
    double d2 = this.q;
    paramDouble1 = -Math.sin(paramDouble1);
    double d3 = this.q;
    int i1 = (int)(paramDouble2 + d1 * d2);
    int i2 = (int)(paramDouble3 + paramDouble1 * d3);
    paramGLMapState = FPoint.obtain();
    MapConfig localMapConfig = this.m.getMapConfig();
    if (localMapConfig != null)
    {
      paramGLMapState.x = (i1 - (int)localMapConfig.getSX());
      paramGLMapState.y = (i2 - (int)localMapConfig.getSY());
    }
    return paramGLMapState;
  }
  
  private boolean a()
  {
    IPoint localIPoint1 = IPoint.obtain();
    this.m.latlon2Geo(this.e.latitude, this.e.longitude, localIPoint1);
    IPoint localIPoint2 = IPoint.obtain();
    this.m.latlon2Geo(this.f.latitude, this.f.longitude, localIPoint2);
    IPoint localIPoint3 = IPoint.obtain();
    this.m.latlon2Geo(this.g.latitude, this.g.longitude, localIPoint3);
    double d3 = localIPoint1.x;
    double d4 = localIPoint1.y;
    double d5 = localIPoint2.x;
    double d6 = localIPoint2.y;
    double d1 = localIPoint3.x;
    double d2 = localIPoint3.y;
    Double.isNaN(d5);
    Double.isNaN(d3);
    double d7 = d5 - d3;
    Double.isNaN(d2);
    Double.isNaN(d4);
    double d8 = d2 - d4;
    Double.isNaN(d1);
    Double.isNaN(d3);
    double d9 = d1 - d3;
    Double.isNaN(d6);
    Double.isNaN(d4);
    double d10 = d6 - d4;
    double d11 = d7 * 2.0D * d8 - d9 * 2.0D * d10;
    double d12 = d10 * 2.0D * d9 - 2.0D * d8 * d7;
    if ((d11 != 0.0D) && (d12 != 0.0D))
    {
      Double.isNaN(d6);
      Double.isNaN(d6);
      double d13 = d6 * d6;
      Double.isNaN(d4);
      Double.isNaN(d4);
      double d14 = d4 * d4;
      Double.isNaN(d5);
      Double.isNaN(d5);
      double d15 = d5 * d5;
      Double.isNaN(d3);
      Double.isNaN(d3);
      double d16 = d3 * d3;
      Double.isNaN(d2);
      Double.isNaN(d2);
      double d17 = d2 * d2;
      Double.isNaN(d1);
      Double.isNaN(d1);
      double d18 = d1 * d1;
      this.t = ((d8 * (d13 - d14 + d15 - d16) + d10 * (d14 - d17 + d16 - d18)) / d11);
      this.u = ((d9 * (d15 - d16 + d13 - d14) + d7 * (d16 - d18 + d14 - d17)) / d12);
      if ((!Double.isNaN(this.t)) && (!Double.isNaN(this.u)) && (!Double.isInfinite(this.t)) && (!Double.isInfinite(this.u)))
      {
        d7 = this.t;
        Double.isNaN(d3);
        d8 = this.t;
        Double.isNaN(d3);
        d9 = this.u;
        Double.isNaN(d4);
        d10 = this.u;
        Double.isNaN(d4);
        this.q = Math.sqrt((d3 - d7) * (d3 - d8) + (d4 - d9) * (d4 - d10));
        this.r = a(this.t, this.u, d3, d4);
        d3 = a(this.t, this.u, d5, d6);
        this.s = a(this.t, this.u, d1, d2);
        if (this.r < this.s)
        {
          if ((d3 <= this.r) || (d3 >= this.s)) {
            this.s -= 6.283185307179586D;
          }
        }
        else if ((d3 <= this.s) || (d3 >= this.r)) {
          this.s += 6.283185307179586D;
        }
        localIPoint1.recycle();
        localIPoint2.recycle();
        localIPoint3.recycle();
        return true;
      }
      return false;
    }
    return false;
  }
  
  private void b()
  {
    FPoint[] arrayOfFPoint = new FPoint[3];
    this.n = new float[arrayOfFPoint.length * 3];
    Object localObject = FPoint.obtain();
    this.m.getLatLng2Map(this.e.latitude, this.e.longitude, (FPoint)localObject);
    int i1 = 0;
    arrayOfFPoint[0] = localObject;
    localObject = FPoint.obtain();
    this.m.getLatLng2Map(this.f.latitude, this.f.longitude, (FPoint)localObject);
    arrayOfFPoint[1] = localObject;
    localObject = FPoint.obtain();
    this.m.getLatLng2Map(this.g.latitude, this.g.longitude, (FPoint)localObject);
    arrayOfFPoint[2] = localObject;
    while (i1 < 3)
    {
      localObject = this.n;
      int i2 = i1 * 3;
      localObject[i2] = arrayOfFPoint[i1].x;
      this.n[(i2 + 1)] = arrayOfFPoint[i1].y;
      this.n[(i2 + 2)] = 0.0F;
      i1 += 1;
    }
    this.o = arrayOfFPoint.length;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    if ((this.e != null) && (this.f != null) && (this.g != null) && (this.k)) {
      try
      {
        this.p = false;
        GLMapState localGLMapState = this.m.getMapProjection();
        if (!a())
        {
          b();
          return true;
        }
        DPoint localDPoint = DPoint.obtain(this.t, this.u);
        int i2 = (int)(Math.abs(this.s - this.r) * 180.0D / 3.141592653589793D);
        if (i2 == 0)
        {
          b();
          return true;
        }
        double d1 = this.s;
        double d2 = this.r;
        double d3 = i2;
        Double.isNaN(d3);
        d1 = (d1 - d2) / d3;
        FPoint[] arrayOfFPoint = new FPoint[i2 + 1];
        this.n = new float[arrayOfFPoint.length * 3];
        int i1 = 0;
        while (i1 <= i2)
        {
          if (i1 == i2)
          {
            localObject = FPoint.obtain();
            this.m.getLatLng2Map(this.g.latitude, this.g.longitude, (FPoint)localObject);
            arrayOfFPoint[i1] = localObject;
          }
          else
          {
            d2 = this.r;
            d3 = i1;
            Double.isNaN(d3);
            arrayOfFPoint[i1] = a(localGLMapState, d3 * d1 + d2, localDPoint.x, localDPoint.y);
          }
          d2 = this.r;
          d3 = i1;
          Double.isNaN(d3);
          arrayOfFPoint[i1] = a(localGLMapState, d3 * d1 + d2, localDPoint.x, localDPoint.y);
          Object localObject = this.n;
          int i3 = i1 * 3;
          localObject[i3] = arrayOfFPoint[i1].x;
          this.n[(i3 + 1)] = arrayOfFPoint[i1].y;
          this.n[(i3 + 2)] = 0.0F;
          i1 += 1;
        }
        localDPoint.recycle();
        this.o = arrayOfFPoint.length;
        return true;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "ArcDelegateImp", "calMapFPoint");
        localThrowable.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public void destroy()
  {
    try
    {
      this.e = null;
      this.f = null;
      this.g = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ArcDelegateImp", "destroy");
      localThrowable.printStackTrace();
      Log.d("destroy erro", "ArcDelegateImp destroy");
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if ((this.e != null) && (this.f != null) && (this.g != null))
    {
      if (!this.k) {
        return;
      }
      calMapFPoint();
      if ((this.n != null) && (this.o > 0))
      {
        float f1 = this.m.getMapProjection().getMapLenWithWin((int)this.h);
        this.m.getMapProjection().getMapLenWithWin(1);
        AMapNativeRenderer.nativeDrawLineByTextureID(this.n, this.n.length, f1, this.m.getLineTextureID(), this.b, this.c, this.d, this.a, 0.0F, false, true, false, this.m.getFinalMatrix(), 3, 0);
      }
      this.p = true;
      return;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.l == null) {
      this.l = this.m.createId("Arc");
    }
    return this.l;
  }
  
  public int getStrokeColor()
    throws RemoteException
  {
    return this.i;
  }
  
  public float getStrokeWidth()
    throws RemoteException
  {
    return this.h;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.j;
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
    return this.p;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.k;
  }
  
  public void remove()
    throws RemoteException
  {
    this.m.removeGLOverlay(getId());
    this.m.setRunLowFrame(false);
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setEnd(LatLng paramLatLng)
  {
    this.g = paramLatLng;
  }
  
  public void setPassed(LatLng paramLatLng)
  {
    this.f = paramLatLng;
  }
  
  public void setStart(LatLng paramLatLng)
  {
    this.e = paramLatLng;
  }
  
  public void setStrokeColor(int paramInt)
    throws RemoteException
  {
    this.i = paramInt;
    this.a = (Color.alpha(paramInt) / 255.0F);
    this.b = (Color.red(paramInt) / 255.0F);
    this.c = (Color.green(paramInt) / 255.0F);
    this.d = (Color.blue(paramInt) / 255.0F);
    this.m.setRunLowFrame(false);
  }
  
  public void setStrokeWidth(float paramFloat)
    throws RemoteException
  {
    this.h = paramFloat;
    this.m.setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.k = paramBoolean;
    this.m.setRunLowFrame(false);
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.j = paramFloat;
    this.m.changeGLOverlayIndex();
    this.m.setRunLowFrame(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */