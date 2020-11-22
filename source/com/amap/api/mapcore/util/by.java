package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class by
  implements IGroundOverlayDelegate
{
  float[] a = null;
  cl.c b;
  private IAMapDelegate c;
  private BitmapDescriptor d;
  private LatLng e;
  private float f;
  private float g;
  private LatLngBounds h;
  private float i;
  private float j;
  private boolean k = true;
  private float l = 0.0F;
  private float m = 1.0F;
  private float n = 0.5F;
  private float o = 0.5F;
  private String p;
  private FloatBuffer q = null;
  private FloatBuffer r;
  private int s;
  private boolean t = false;
  private boolean u = false;
  private List<lu> v = new ArrayList();
  private lo w;
  
  private by(IAMapDelegate paramIAMapDelegate)
  {
    this.c = paramIAMapDelegate;
    try
    {
      this.p = getId();
      return;
    }
    catch (RemoteException paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "GroundOverlayDelegateImp", "create");
      paramIAMapDelegate.printStackTrace();
    }
  }
  
  public by(IAMapDelegate paramIAMapDelegate, lo paramlo)
  {
    this(paramIAMapDelegate);
    this.w = paramlo;
  }
  
  private int a(boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    e();
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.w.a(paramBitmapDescriptor);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        i1 = ((lu)localObject2).k();
        a((lu)localObject2);
        return i1;
      }
    }
    else
    {
      localObject1 = null;
    }
    int i2 = 0;
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
        i1 = f();
        ((lu)localObject2).a(i1);
        if (paramBoolean) {
          this.c.addTextureItem((lu)localObject2);
        }
        a((lu)localObject2);
        dx.b(i1, paramBitmapDescriptor, true);
      }
    }
    return i1;
  }
  
  private void a()
  {
    if (this.e == null) {
      return;
    }
    double d1 = this.f;
    double d2 = Math.cos(this.e.latitude * 0.01745329251994329D);
    Double.isNaN(d1);
    d1 /= d2 * 6371000.79D * 0.01745329251994329D;
    d2 = this.g;
    Double.isNaN(d2);
    d2 /= 111194.94043265979D;
    try
    {
      double d3 = this.e.latitude;
      float f1 = this.o;
      double d4 = 1.0F - f1;
      Double.isNaN(d4);
      double d5 = this.e.longitude;
      f1 = this.n;
      double d6 = f1;
      Double.isNaN(d6);
      LatLng localLatLng = new LatLng(d3 - d4 * d2, d5 - d6 * d1);
      d3 = this.e.latitude;
      f1 = this.o;
      d4 = f1;
      Double.isNaN(d4);
      d5 = this.e.longitude;
      f1 = this.n;
      d6 = 1.0F - f1;
      Double.isNaN(d6);
      this.h = new LatLngBounds(localLatLng, new LatLng(d3 + d4 * d2, d5 + d6 * d1));
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    c();
  }
  
  private void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (paramFloatBuffer1 != null)
    {
      if (paramFloatBuffer2 == null) {
        return;
      }
      if ((this.b == null) || (this.b.c())) {
        g();
      }
      this.b.a();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glBlendColor(this.m * 1.0F, this.m * 1.0F, this.m * 1.0F, this.m);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glEnableVertexAttribArray(this.b.b);
      GLES20.glVertexAttribPointer(this.b.b, 4, 5126, false, 16, paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.b.c);
      GLES20.glVertexAttribPointer(this.b.c, 2, 5126, false, 8, paramFloatBuffer2);
      GLES20.glUniform4f(this.b.g, (int)this.c.getMapConfig().getSX() / 10000, (int)this.c.getMapConfig().getSY() / 10000, (int)this.c.getMapConfig().getSX() % 10000, (int)this.c.getMapConfig().getSY() % 10000);
      GLES20.glUniform4f(this.b.h, this.m * 1.0F, this.m * 1.0F, this.m * 1.0F, this.m);
      GLES20.glUniformMatrix4fv(this.b.a, 1, false, this.c.getFinalMatrix(), 0);
      GLES20.glDrawArrays(6, 0, 4);
      GLES20.glBindTexture(3553, 0);
      GLES20.glDisableVertexAttribArray(this.b.b);
      GLES20.glDisableVertexAttribArray(this.b.c);
      GLES20.glDisable(3042);
      GLES20.glUseProgram(0);
      return;
    }
  }
  
  private void a(lu paramlu)
  {
    if (paramlu != null)
    {
      this.v.add(paramlu);
      paramlu.l();
    }
  }
  
  private void a(DPoint paramDPoint, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, IPoint paramIPoint)
  {
    double d1 = this.n;
    Double.isNaN(d1);
    paramDouble1 -= paramDouble3 * d1;
    paramDouble3 = 1.0F - this.o;
    Double.isNaN(paramDouble3);
    paramDouble2 = paramDouble4 * paramDouble3 - paramDouble2;
    paramDouble3 = -this.i;
    Double.isNaN(paramDouble3);
    paramDouble3 *= 0.01745329251994329D;
    paramIPoint.x = ((int)(paramDPoint.x + (Math.cos(paramDouble3) * paramDouble1 + Math.sin(paramDouble3) * paramDouble2)));
    paramIPoint.y = ((int)(paramDPoint.y + (paramDouble2 * Math.cos(paramDouble3) - paramDouble1 * Math.sin(paramDouble3))));
  }
  
  private void b()
  {
    try
    {
      Object localObject1 = this.h;
      if (localObject1 == null) {
        return;
      }
      localObject1 = this.h.southwest;
      LatLng localLatLng = this.h.northeast;
      double d1 = ((LatLng)localObject1).latitude;
      double d2 = 1.0F - this.o;
      double d3 = localLatLng.latitude;
      double d4 = ((LatLng)localObject1).latitude;
      Double.isNaN(d2);
      double d5 = ((LatLng)localObject1).longitude;
      double d6 = this.n;
      double d7 = localLatLng.longitude;
      double d8 = ((LatLng)localObject1).longitude;
      Double.isNaN(d6);
      this.e = new LatLng(d1 + d2 * (d3 - d4), d5 + d6 * (d7 - d8));
      this.f = ((float)(Math.cos(this.e.latitude * 0.01745329251994329D) * 6371000.79D * (localLatLng.longitude - ((LatLng)localObject1).longitude) * 0.01745329251994329D));
      this.g = ((float)((localLatLng.latitude - ((LatLng)localObject1).latitude) * 6371000.79D * 0.01745329251994329D));
      c();
      return;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      Object localObject1 = this.h;
      if (localObject1 == null) {
        return;
      }
      this.a = new float[16];
      localObject1 = IPoint.obtain();
      IPoint localIPoint1 = IPoint.obtain();
      IPoint localIPoint2 = IPoint.obtain();
      IPoint localIPoint3 = IPoint.obtain();
      GLMapState.lonlat2Geo(this.h.southwest.longitude, this.h.southwest.latitude, (IPoint)localObject1);
      GLMapState.lonlat2Geo(this.h.northeast.longitude, this.h.southwest.latitude, localIPoint1);
      GLMapState.lonlat2Geo(this.h.northeast.longitude, this.h.northeast.latitude, localIPoint2);
      GLMapState.lonlat2Geo(this.h.southwest.longitude, this.h.northeast.latitude, localIPoint3);
      if (this.i != 0.0F)
      {
        double d1 = localIPoint1.x - ((IPoint)localObject1).x;
        double d2 = localIPoint1.y - localIPoint2.y;
        DPoint localDPoint = DPoint.obtain();
        double d3 = ((IPoint)localObject1).x;
        float f1 = this.n;
        double d4 = f1;
        Double.isNaN(d1);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localDPoint.x = (d3 + d4 * d1);
        d3 = ((IPoint)localObject1).y;
        f1 = this.o;
        d4 = 1.0F - f1;
        Double.isNaN(d2);
        Double.isNaN(d4);
        Double.isNaN(d3);
        localDPoint.y = (d3 - d4 * d2);
        a(localDPoint, 0.0D, 0.0D, d1, d2, (IPoint)localObject1);
        a(localDPoint, d1, 0.0D, d1, d2, localIPoint1);
        a(localDPoint, d1, d2, d1, d2, localIPoint2);
        a(localDPoint, 0.0D, d2, d1, d2, localIPoint3);
        localDPoint.recycle();
      }
      this.a[0] = (((IPoint)localObject1).x / 10000);
      this.a[1] = (((IPoint)localObject1).y / 10000);
      this.a[2] = (((IPoint)localObject1).x % 10000);
      this.a[3] = (((IPoint)localObject1).y % 10000);
      this.a[4] = (localIPoint1.x / 10000);
      this.a[5] = (localIPoint1.y / 10000);
      this.a[6] = (localIPoint1.x % 10000);
      this.a[7] = (localIPoint1.y % 10000);
      this.a[8] = (localIPoint2.x / 10000);
      this.a[9] = (localIPoint2.y / 10000);
      this.a[10] = (localIPoint2.x % 10000);
      this.a[11] = (localIPoint2.y % 10000);
      this.a[12] = (localIPoint3.x / 10000);
      this.a[13] = (localIPoint3.y / 10000);
      this.a[14] = (localIPoint3.x % 10000);
      this.a[15] = (localIPoint3.y % 10000);
      if (this.q == null) {
        this.q = dx.a(this.a);
      } else {
        this.q = dx.a(this.a, this.q);
      }
      localIPoint3.recycle();
      ((IPoint)localObject1).recycle();
      localIPoint1.recycle();
      localIPoint2.recycle();
      return;
    }
    finally {}
  }
  
  private void d()
  {
    if ((this.d == null) && ((this.d == null) || (this.d.getBitmap() == null))) {
      return;
    }
    int i1 = this.d.getWidth();
    int i2 = this.d.getHeight();
    int i3 = this.d.getBitmap().getHeight();
    int i4 = this.d.getBitmap().getWidth();
    float f1 = i1 / i4;
    float f2 = i2 / i3;
    this.r = dx.a(new float[] { 0.0F, f2, f1, f2, f1, 0.0F, 0.0F, 0.0F });
  }
  
  private void e()
  {
    if (this.v != null)
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext())
      {
        lu locallu = (lu)localIterator.next();
        if ((locallu != null) && (this.w != null)) {
          this.w.a(locallu);
        }
      }
      this.v.clear();
    }
  }
  
  private int f()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  private void g()
  {
    if (this.c != null) {
      this.b = ((cl.c)this.c.getGLShader(2));
    }
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    try
    {
      if (this.a != null) {
        return false;
      }
      this.u = false;
      if (this.e == null) {
        b();
      } else if (this.h == null) {
        a();
      } else {
        c();
      }
      return true;
    }
    finally {}
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public void destroy()
  {
    for (;;)
    {
      try
      {
        remove();
        int i1;
        Object localObject1;
        if ((this.v != null) && (this.v.size() > 0))
        {
          i1 = 0;
          if (i1 < this.v.size())
          {
            localObject1 = (lu)this.v.get(i1);
            if (localObject1 != null)
            {
              if (this.w != null) {
                this.w.a((lu)localObject1);
              }
              if (this.c != null) {
                this.c.removeTextureItem(((lu)localObject1).o());
              }
            }
          }
          else
          {
            this.v.clear();
          }
        }
        else
        {
          if (this.d != null)
          {
            localObject1 = this.d.getBitmap();
            if (localObject1 != null)
            {
              ((Bitmap)localObject1).recycle();
              this.d = null;
            }
          }
          if (this.r != null)
          {
            this.r.clear();
            this.r = null;
          }
          try
          {
            if (this.q != null)
            {
              this.q.clear();
              this.q = null;
            }
            this.h = null;
            this.e = null;
            return;
          }
          finally {}
        }
        i1 += 1;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "GroundOverlayDelegateImp", "destroy");
        localThrowable.printStackTrace();
        return;
      }
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {
    for (;;)
    {
      boolean bool1;
      try
      {
        boolean bool2 = this.k;
        bool1 = false;
        if ((!bool2) || ((this.e == null) && (this.h == null))) {
          break label148;
        }
        if (this.d != null) {
          break label143;
        }
      }
      finally {}
      if (i1 != 0) {
        return;
      }
      calMapFPoint();
      if (!this.t)
      {
        if (Build.VERSION.SDK_INT >= 12) {
          bool1 = true;
        }
        this.s = a(bool1, this.d);
        this.t = true;
      }
      if ((this.f == 0.0F) && (this.g == 0.0F)) {
        return;
      }
      try
      {
        a(this.s, this.q, this.r);
        this.u = true;
        return;
      }
      finally {}
      label143:
      int i1 = 0;
      continue;
      label148:
      i1 = 1;
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public float getBearing()
    throws RemoteException
  {
    return this.i;
  }
  
  public LatLngBounds getBounds()
    throws RemoteException
  {
    return this.h;
  }
  
  public float getHeight()
    throws RemoteException
  {
    return this.g;
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.p == null) {
      this.p = this.c.createId("GroundOverlay");
    }
    return this.p;
  }
  
  public LatLng getPosition()
    throws RemoteException
  {
    return this.e;
  }
  
  public float getTransparency()
    throws RemoteException
  {
    return this.l;
  }
  
  public float getWidth()
    throws RemoteException
  {
    return this.f;
  }
  
  public float getZIndex()
    throws RemoteException
  {
    return this.j;
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
    return this.u;
  }
  
  public boolean isVisible()
    throws RemoteException
  {
    return this.k;
  }
  
  public void reLoadTexture()
  {
    this.t = false;
    this.s = 0;
  }
  
  public void remove()
    throws RemoteException
  {
    this.c.removeGLOverlay(getId());
    this.c.setRunLowFrame(false);
  }
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    this.n = paramFloat1;
    this.o = paramFloat2;
    this.c.setRunLowFrame(false);
  }
  
  public void setBearing(float paramFloat)
    throws RemoteException
  {
    paramFloat = (paramFloat % 360.0F + 360.0F) % 360.0F;
    if (Math.abs(this.i - paramFloat) > 1.0E-7D)
    {
      this.i = paramFloat;
      c();
    }
    this.c.setRunLowFrame(false);
  }
  
  public void setDimensions(float paramFloat)
    throws RemoteException
  {
    if (paramFloat <= 0.0F) {
      Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
    }
    if ((this.t) && (this.f != paramFloat))
    {
      this.f = paramFloat;
      this.g = paramFloat;
      a();
    }
    else
    {
      this.f = paramFloat;
      this.g = paramFloat;
    }
    this.c.setRunLowFrame(false);
  }
  
  public void setDimensions(float paramFloat1, float paramFloat2)
    throws RemoteException
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
    }
    if ((this.t) && (this.f != paramFloat1) && (this.g != paramFloat2))
    {
      this.f = paramFloat1;
      this.g = paramFloat2;
      a();
    }
    else
    {
      this.f = paramFloat1;
      this.g = paramFloat2;
    }
    this.c.setRunLowFrame(false);
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor)
    throws RemoteException
  {
    if ((paramBitmapDescriptor != null) && (paramBitmapDescriptor.getBitmap() != null))
    {
      if (paramBitmapDescriptor.getBitmap().isRecycled()) {
        return;
      }
      this.d = paramBitmapDescriptor;
      d();
      if (this.t) {
        this.t = false;
      }
      this.c.setRunLowFrame(false);
      return;
    }
  }
  
  public void setPosition(LatLng paramLatLng)
    throws RemoteException
  {
    this.e = paramLatLng;
    a();
    this.c.setRunLowFrame(false);
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
    throws RemoteException
  {
    if (paramLatLngBounds == null) {
      return;
    }
    this.h = paramLatLngBounds;
    b();
    this.c.setRunLowFrame(false);
  }
  
  public void setTransparency(float paramFloat)
    throws RemoteException
  {
    this.l = ((float)Math.min(1.0D, Math.max(0.0D, paramFloat)));
    this.m = (1.0F - paramFloat);
    this.c.setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    this.k = paramBoolean;
    this.c.setRunLowFrame(false);
  }
  
  public void setZIndex(float paramFloat)
    throws RemoteException
  {
    this.j = paramFloat;
    this.c.changeGLOverlayIndex();
    this.c.setRunLowFrame(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */