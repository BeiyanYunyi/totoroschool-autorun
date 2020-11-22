package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay.EAMapOverlayTpye;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class cc
  implements INavigateArrowDelegate
{
  private boolean A = true;
  int[] a = null;
  int[] b = null;
  float c;
  float d;
  float e;
  float f;
  Rect g = null;
  boolean h = false;
  float[] i;
  int j = 0;
  private IAMapDelegate k;
  private float l = 10.0F;
  private int m = -16777216;
  private int n = -16777216;
  private float o = 0.0F;
  private boolean p = true;
  private String q;
  private List<IPoint> r = new Vector();
  private int s = 0;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private Object x = new Object();
  private String y = null;
  private final int z = Color.argb(0, 0, 0, 0);
  
  public cc(IAMapDelegate paramIAMapDelegate)
  {
    this.k = paramIAMapDelegate;
    try
    {
      this.q = getId();
    }
    catch (RemoteException paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "NavigateArrowDelegateImp", "create");
      paramIAMapDelegate.printStackTrace();
    }
    this.h = false;
  }
  
  private List<LatLng> a()
    throws RemoteException
  {
    if (this.r != null) {
      synchronized (this.x)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.r.iterator();
        while (localIterator.hasNext())
        {
          IPoint localIPoint = (IPoint)localIterator.next();
          if (localIPoint != null)
          {
            DPoint localDPoint = DPoint.obtain();
            this.k.geo2Latlng(localIPoint.x, localIPoint.y, localDPoint);
            localArrayList.add(new LatLng(localDPoint.y, localDPoint.x));
            localDPoint.recycle();
          }
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  void a(List<LatLng> paramList)
    throws RemoteException
  {
    synchronized (this.x)
    {
      this.r.clear();
      if (this.g == null) {
        this.g = new Rect();
      }
      dx.a(this.g);
      Object localObject1;
      if (paramList != null)
      {
        localObject1 = null;
        Iterator localIterator = paramList.iterator();
        for (paramList = (List<LatLng>)localObject1; localIterator.hasNext(); paramList = (List<LatLng>)localObject1)
        {
          label59:
          localObject1 = (LatLng)localIterator.next();
          if ((localObject1 == null) || (((LatLng)localObject1).equals(paramList))) {
            break label59;
          }
          paramList = IPoint.obtain();
          this.k.latlon2Geo(((LatLng)localObject1).latitude, ((LatLng)localObject1).longitude, paramList);
          this.r.add(paramList);
          dx.b(this.g, paramList.x, paramList.y);
        }
      }
      this.s = 0;
      this.g.sort();
      int i1 = this.r.size();
      this.a = new int[i1];
      this.b = new int[i1];
      paramList = this.r.iterator();
      i1 = 0;
      while (paramList.hasNext())
      {
        localObject1 = (IPoint)paramList.next();
        this.a[i1] = ((IPoint)localObject1).x;
        this.b[i1] = ((IPoint)localObject1).y;
        i1 += 1;
      }
      this.k.setRunLowFrame(false);
      return;
    }
  }
  
  public boolean a(MapConfig paramMapConfig)
    throws RemoteException
  {
    synchronized (this.x)
    {
      int i2 = (int)paramMapConfig.getSX();
      int i3 = (int)paramMapConfig.getSY();
      int i1 = 0;
      this.t = false;
      int i4 = this.r.size();
      if ((this.i == null) || (this.i.length < i4 * 3)) {
        this.i = new float[i4 * 3];
      }
      this.j = (i4 * 3);
      paramMapConfig = this.r.iterator();
      while (paramMapConfig.hasNext())
      {
        IPoint localIPoint = (IPoint)paramMapConfig.next();
        float[] arrayOfFloat = this.i;
        i4 = i1 * 3;
        arrayOfFloat[i4] = (localIPoint.x - i2);
        this.i[(i4 + 1)] = (localIPoint.y - i3);
        this.i[(i4 + 2)] = 0.0F;
        i1 += 1;
      }
      this.s = this.r.size();
      return true;
    }
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    return true;
  }
  
  public boolean checkInBounds()
  {
    if (this.g != null)
    {
      Rectangle localRectangle = this.k.getMapConfig().getGeoRectangle();
      return (localRectangle != null) && (localRectangle.isOverlap(this.g));
    }
    return false;
  }
  
  public void destroy()
  {
    try
    {
      remove();
      if (this.i != null)
      {
        this.i = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "NavigateArrowDelegateImp", "destroy");
      localThrowable.printStackTrace();
      Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    if (this.h) {
      return;
    }
    if ((this.r != null) && (this.r.size() != 0))
    {
      if (this.l <= 0.0F) {
        return;
      }
      if (!this.u)
      {
        if ((this.y != null) && (this.v))
        {
          this.k.getGLMapEngine().updateNativeArrowOverlay(1, this.y, this.a, this.b, this.m, this.n, this.z, this.l, 111, 222, 333, false);
          this.A = false;
        }
        a(this.k.getMapConfig());
        if ((this.i != null) && (this.s > 0))
        {
          float f1 = this.k.getMapProjection().getMapLenWithWin((int)this.l);
          AMapNativeRenderer.nativeDrawLineByTextureID(this.i, this.j, f1, this.k.getLineTextureID(), this.d, this.e, this.f, this.c, 0.0F, false, true, true, this.k.getFinalMatrix(), 2, 0);
          this.v = false;
          this.w = false;
        }
      }
      else if ((this.k != null) && (this.k.getGLMapEngine() != null))
      {
        if (this.y == null) {
          this.y = this.k.getGLMapEngine().addNativeOverlay(1, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_ARROW.ordinal(), hashCode());
        }
        if ((this.y != null) && (this.A))
        {
          this.k.getGLMapEngine().updateNativeArrowOverlay(1, this.y, this.a, this.b, this.m, this.n, this.z, this.l, 111, 222, 333, this.p);
          this.v = true;
          this.w = this.p;
          this.A = false;
        }
      }
      this.t = true;
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
    if (this.q == null) {
      this.q = this.k.createId("NavigateArrow");
    }
    return this.q;
  }
  
  public List<LatLng> getPoints()
    throws RemoteException
  {
    return a();
  }
  
  public int getSideColor()
    throws RemoteException
  {
    return this.n;
  }
  
  public int getTopColor()
    throws RemoteException
  {
    return this.m;
  }
  
  public float getWidth()
    throws RemoteException
  {
    return this.l;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.o;
  }
  
  public int hashCodeRemote()
    throws RemoteException
  {
    return super.hashCode();
  }
  
  public boolean is3DModel()
  {
    return this.u;
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return this.t;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    if (this.u) {
      return (this.p) || (this.w);
    }
    return this.p;
  }
  
  public void remove()
    throws RemoteException
  {
    if (this.h) {
      return;
    }
    if ((this.k != null) && (this.k.getGLMapEngine() != null) && (this.y != null)) {
      this.k.queueEvent(new Runnable()
      {
        public void run()
        {
          if ((cc.a(cc.this) != null) && (cc.a(cc.this).getGLMapEngine() != null))
          {
            if (cc.b(cc.this) != null) {
              cc.a(cc.this).getGLMapEngine().removeNativeOverlay(1, cc.b(cc.this));
            }
            cc.a(cc.this, null);
          }
        }
      });
    }
    this.k.removeGLOverlay(getId());
    this.k.setRunLowFrame(false);
    this.h = true;
  }
  
  public void set3DModel(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.w = this.p;
    this.A = true;
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setPoints(List<LatLng> paramList)
    throws RemoteException
  {
    a(paramList);
    this.A = true;
  }
  
  public void setSideColor(int paramInt)
    throws RemoteException
  {
    this.n = paramInt;
    this.k.setRunLowFrame(false);
    this.A = true;
  }
  
  public void setTopColor(int paramInt)
    throws RemoteException
  {
    this.m = paramInt;
    this.c = (Color.alpha(paramInt) / 255.0F);
    this.d = (Color.red(paramInt) / 255.0F);
    this.e = (Color.green(paramInt) / 255.0F);
    this.f = (Color.blue(paramInt) / 255.0F);
    this.k.setRunLowFrame(false);
    this.A = true;
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.p = paramBoolean;
    this.k.setRunLowFrame(false);
    this.A = true;
  }
  
  public void setWidth(float paramFloat)
    throws RemoteException
  {
    this.l = paramFloat;
    this.k.setRunLowFrame(false);
    this.A = true;
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.o = paramFloat;
    this.k.changeGLOverlayIndex();
    this.k.setRunLowFrame(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */