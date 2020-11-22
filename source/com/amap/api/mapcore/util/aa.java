package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.Matrix;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class aa
  implements z
{
  private static int E;
  int A = -1;
  private String B;
  private float[] C = { -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F, -0.5F, 0.0F, 0.0F, 1.0F, 0.0F };
  private boolean D = true;
  private ExecutorService F = null;
  private List<String> G = new ArrayList();
  private float[] H = new float[x.a * 3];
  BitmapDescriptor a = BitmapDescriptorFactory.defaultMarker();
  BitmapDescriptor b = null;
  float c = 0.0F;
  float d = 0.0F;
  float e = 0.0F;
  float f = 0.5F;
  float g = 0.5F;
  List<MultiPointItem> h;
  ac i = null;
  y j = null;
  y k = new y(0, 1, 0, 1);
  List<MultiPointItem> l = new ArrayList();
  IPoint m;
  ab n;
  List<x> o = new ArrayList();
  float[] p = new float[16];
  float[] q = new float[4];
  float[] r = new float[4];
  Rect s = new Rect();
  y t = null;
  y u = null;
  int v = 0;
  int w = 0;
  float[] x = new float[12];
  String y = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
  String z = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(0,0,1,1.0);\n}";
  
  public aa(MultiPointOverlayOptions paramMultiPointOverlayOptions, ab paramab)
  {
    this.n = paramab;
    a(paramMultiPointOverlayOptions);
    paramMultiPointOverlayOptions = new x(a(), this);
    paramMultiPointOverlayOptions.a(paramab.a());
    paramMultiPointOverlayOptions.a(this.b);
    this.o.add(paramMultiPointOverlayOptions);
  }
  
  private static String a(String paramString)
  {
    E += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(E);
    return localStringBuilder.toString();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.k == null) {
      this.k = new y(0, 1, 0, 1);
    }
    this.s.set(0, 0, 0, 0);
    IPoint localIPoint = new IPoint();
    float f1 = this.f;
    paramFloat4 = this.g;
    Matrix.setIdentityM(this.p, 0);
    Matrix.rotateM(this.p, 0, -paramFloat3, 0.0F, 0.0F, 1.0F);
    this.r[0] = 0.0F;
    this.r[1] = 0.0F;
    this.r[2] = 0.0F;
    this.r[3] = 0.0F;
    float[] arrayOfFloat = this.q;
    paramFloat3 = -paramFloat1 * f1;
    arrayOfFloat[0] = paramFloat3;
    arrayOfFloat = this.q;
    float f2 = paramFloat2 * paramFloat4;
    arrayOfFloat[1] = f2;
    this.q[2] = 0.0F;
    this.q[3] = 1.0F;
    Matrix.multiplyMV(this.r, 0, this.p, 0, this.q, 0);
    this.s.set((int)(localIPoint.x + this.r[0]), (int)(localIPoint.y - this.r[1]), (int)(localIPoint.x + this.r[0]), (int)(localIPoint.y - this.r[1]));
    arrayOfFloat = this.q;
    paramFloat1 *= (1.0F - f1);
    arrayOfFloat[0] = paramFloat1;
    this.q[1] = f2;
    this.q[2] = 0.0F;
    this.q[3] = 1.0F;
    Matrix.multiplyMV(this.r, 0, this.p, 0, this.q, 0);
    this.s.union((int)(localIPoint.x + this.r[0]), (int)(localIPoint.y - this.r[1]));
    this.q[0] = paramFloat1;
    arrayOfFloat = this.q;
    paramFloat1 = -paramFloat2 * (1.0F - paramFloat4);
    arrayOfFloat[1] = paramFloat1;
    this.q[2] = 0.0F;
    this.q[3] = 1.0F;
    Matrix.multiplyMV(this.r, 0, this.p, 0, this.q, 0);
    this.s.union((int)(localIPoint.x + this.r[0]), (int)(localIPoint.y - this.r[1]));
    this.q[0] = paramFloat3;
    this.q[1] = paramFloat1;
    this.q[2] = 0.0F;
    this.q[3] = 1.0F;
    Matrix.multiplyMV(this.r, 0, this.p, 0, this.q, 0);
    this.s.union((int)(localIPoint.x + this.r[0]), (int)(localIPoint.y - this.r[1]));
    this.k.a(this.s.left, this.s.right, this.s.top, this.s.bottom);
  }
  
  private void a(MultiPointOverlayOptions paramMultiPointOverlayOptions)
  {
    if (paramMultiPointOverlayOptions != null)
    {
      if ((paramMultiPointOverlayOptions.getIcon() != null) && (paramMultiPointOverlayOptions.getIcon().getBitmap() != null) && (!paramMultiPointOverlayOptions.getIcon().getBitmap().isRecycled())) {
        this.b = paramMultiPointOverlayOptions.getIcon();
      } else {
        this.b = this.a;
      }
      this.f = paramMultiPointOverlayOptions.getAnchorU();
      this.g = paramMultiPointOverlayOptions.getAnchorV();
    }
  }
  
  private void a(MapConfig paramMapConfig)
  {
    if (paramMapConfig != null)
    {
      paramMapConfig = paramMapConfig.getGeoRectangle().getRect();
      if (this.j == null)
      {
        this.j = new y(paramMapConfig.left, paramMapConfig.right, paramMapConfig.top, paramMapConfig.bottom);
        return;
      }
      this.j.a(paramMapConfig.left, paramMapConfig.right, paramMapConfig.top, paramMapConfig.bottom);
    }
  }
  
  private float[] a()
  {
    if (this.C == null) {
      return null;
    }
    float[] arrayOfFloat = (float[])this.C.clone();
    float f1 = this.f - 0.5F;
    float f2 = this.g - 0.5F;
    arrayOfFloat[0] += f1;
    arrayOfFloat[1] -= f2;
    arrayOfFloat[6] += f1;
    arrayOfFloat[7] -= f2;
    arrayOfFloat[12] += f1;
    arrayOfFloat[13] -= f2;
    arrayOfFloat[18] += f1;
    arrayOfFloat[19] -= f2;
    return arrayOfFloat;
  }
  
  private y b()
  {
    if ((this.h != null) && (this.h.size() != 0))
    {
      Iterator localIterator = this.h.iterator();
      MultiPointItem localMultiPointItem = (MultiPointItem)localIterator.next();
      int i7 = localMultiPointItem.getIPoint().x;
      int i3 = localMultiPointItem.getIPoint().x;
      int i1 = localMultiPointItem.getIPoint().y;
      int i2 = localMultiPointItem.getIPoint().y;
      while (localIterator.hasNext())
      {
        localMultiPointItem = (MultiPointItem)localIterator.next();
        int i8 = localMultiPointItem.getIPoint().x;
        int i4 = localMultiPointItem.getIPoint().y;
        int i5 = i7;
        if (i8 < i7) {
          i5 = i8;
        }
        int i6 = i3;
        if (i8 > i3) {
          i6 = i8;
        }
        i8 = i1;
        if (i4 < i1) {
          i8 = i4;
        }
        i7 = i5;
        i3 = i6;
        i1 = i8;
        if (i4 > i2)
        {
          i2 = i4;
          i7 = i5;
          i3 = i6;
          i1 = i8;
        }
      }
      return new y(i7, i3, i1, i2);
    }
    return null;
  }
  
  private void c()
  {
    final Object localObject2;
    final Object localObject3;
    if (this.F == null)
    {
      localObject1 = new LinkedBlockingQueue();
      localObject2 = TimeUnit.SECONDS;
      localObject3 = new dk("MultiPointOverlay");
      this.F = new ThreadPoolExecutor(1, 2, 1, (TimeUnit)localObject2, (BlockingQueue)localObject1, (ThreadFactory)localObject3, new ThreadPoolExecutor.AbortPolicy());
    }
    Object localObject1 = this.o.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (x)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!((x)localObject2).b()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject2.hashCode());
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        if (!this.G.contains(localObject3))
        {
          this.G.add(localObject3);
          this.F.execute(new Runnable()
          {
            public void run()
            {
              if (localObject2.b()) {
                return;
              }
              localObject2.a();
              aa.a(aa.this).remove(localObject3);
            }
          });
        }
      }
    }
  }
  
  private void d()
  {
    if (this.n != null) {
      this.n.d();
    }
  }
  
  public void a(MapConfig arg1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    try
    {
      if (!this.D) {
        return;
      }
      c();
      if (this.o.size() < 1) {
        return;
      }
      if (this.i != null) {
        break label530;
      }
      return;
    }
    catch (Throwable ???)
    {
      float f1;
      float f2;
      gk.c(???, "MultiPointOverlayDelegate", "draw");
    }
    f1 = ???.getSR();
    f2 = ???.getSC();
    if ((???.getChangeRatio() != 1.0D) || (this.l.size() == 0)) {}
    for (;;)
    {
      synchronized (this.l)
      {
        a(???);
        this.l.clear();
        this.c = ???.getMapPerPixelUnitLength();
        this.d = (this.c * this.b.getWidth());
        this.e = (this.c * this.b.getHeight());
        double d1 = this.d * this.e * 16.0F;
        a(this.d, this.e, f1, f2);
        this.i.a(this.j, this.l, d1);
        if (this.m == null) {
          this.m = new IPoint();
        }
        if ((this.m != null) && (??? != null))
        {
          this.m.x = ((int)???.getSX());
          this.m.y = ((int)???.getSY());
        }
        ??? = (x)this.o.get(0);
        synchronized (this.l)
        {
          Iterator localIterator = this.l.iterator();
          break label535;
          if (localIterator.hasNext())
          {
            Object localObject2 = ((MultiPointItem)localIterator.next()).getIPoint();
            if (localObject2 == null) {
              continue;
            }
            int i2 = ((IPoint)localObject2).x;
            int i3 = this.m.x;
            int i4 = ((IPoint)localObject2).y;
            int i5 = this.m.y;
            if ((??? == null) || (!((x)???).b())) {
              continue;
            }
            if ((!((x)???).d()) && (this.n != null)) {
              ((x)???).a(this.n.a());
            }
            localObject2 = this.H;
            int i6 = i1 * 3;
            localObject2[(i6 + 0)] = (i2 - i3);
            this.H[(i6 + 1)] = (i4 - i5);
            this.H[(i6 + 2)] = 0.0F;
            i2 = i1 + 1;
            i1 = i2;
            if (i2 < x.a) {
              continue;
            }
            ((x)???).a(paramArrayOfFloat1, paramArrayOfFloat2, this.H, this.d, this.e, f1, f2, i2);
            break label535;
          }
          if (i1 > 0)
          {
            ((x)???).a(paramArrayOfFloat1, paramArrayOfFloat2, this.H, this.d, this.e, f1, f2, i1);
            return;
          }
        }
      }
      return;
      label530:
      if (??? != null) {
        break;
      }
      return;
      label535:
      int i1 = 0;
    }
  }
  
  public void addItem(MultiPointItem paramMultiPointItem)
  {
    d();
  }
  
  public void addItems(List<MultiPointItem> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i1;
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        try
        {
          if (this.h == null) {
            this.h = new ArrayList();
          }
          this.h.clear();
          this.h.addAll(paramList);
          int i3 = this.h.size();
          int i2 = 0;
          i1 = 0;
          if (i1 < i3)
          {
            if (this.h == null) {
              return;
            }
            paramList = (MultiPointItem)this.h.get(i1);
            if ((paramList == null) || (paramList.getLatLng() == null) || (paramList.getIPoint() != null)) {
              break label276;
            }
            IPoint localIPoint = new IPoint();
            MapProjection.lonlat2Geo(paramList.getLatLng().longitude, paramList.getLatLng().latitude, localIPoint);
            paramList.setIPoint(localIPoint);
            break label276;
          }
          if (this.i == null)
          {
            paramList = b();
            if (paramList != null) {
              this.i = new ac(paramList);
            }
          }
          if (this.h != null)
          {
            i3 = this.h.size();
            i1 = i2;
            if (i1 < i3)
            {
              paramList = (MultiPointItem)this.h.get(i1);
              if ((paramList == null) || (paramList.getIPoint() == null) || (this.i == null)) {
                break label283;
              }
              this.i.a(paramList);
              break label283;
            }
          }
          d();
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramList)
      {
        gk.c(paramList, "MultiPointOverlayDelegate", "addItems");
        return;
      }
      label276:
      i1 += 1;
      continue;
      label283:
      i1 += 1;
    }
  }
  
  public void destroy(boolean paramBoolean)
  {
    remove(paramBoolean);
    if (this.b != null) {
      this.b.recycle();
    }
  }
  
  public String getId()
    throws RemoteException
  {
    if (this.B == null) {
      this.B = a("MultiPointOverlay");
    }
    return this.B;
  }
  
  public MultiPointItem onClick(IPoint arg1)
  {
    int i1;
    if (this.D)
    {
      if (this.i == null) {
        return null;
      }
      if (this.t == null) {
        this.t = new y(0, 1, 0, 1);
      }
      i1 = (int)(this.c * 8.0F);
      this.t.a(???.x - i1, ???.x + i1, ???.y - i1, ???.y + i1);
    }
    for (;;)
    {
      synchronized (this.l)
      {
        i1 = this.l.size() - 1;
        if (i1 >= 0)
        {
          MultiPointItem localMultiPointItem = (MultiPointItem)this.l.get(i1);
          IPoint localIPoint = localMultiPointItem.getIPoint();
          if (localIPoint == null) {
            break label251;
          }
          if (this.k == null) {
            return null;
          }
          if (this.u == null) {
            this.u = new y(0, 1, 0, 1);
          }
          this.u.a(localIPoint.x + this.k.a, localIPoint.x + this.k.c, localIPoint.y + this.k.b, localIPoint.y + this.k.d);
          if (!this.u.a(this.t)) {
            break label251;
          }
          return localMultiPointItem;
        }
        return null;
      }
      return null;
      label251:
      i1 -= 1;
    }
  }
  
  public void remove(boolean paramBoolean)
  {
    this.D = false;
    this.v = 0;
    this.w = 0;
    if (this.a != null) {
      this.a.recycle();
    }
    try
    {
      if (this.h != null)
      {
        this.h.clear();
        this.h = null;
      }
      if (this.i != null)
      {
        this.i.a();
        this.i = null;
      }
      if (this.l != null) {
        this.l.clear();
      }
      if (this.F != null)
      {
        this.F.shutdownNow();
        this.F = null;
      }
      if (this.G != null) {
        this.G.clear();
      }
      if (this.o != null)
      {
        Iterator localIterator = this.o.iterator();
        while (localIterator.hasNext())
        {
          x localx = (x)localIterator.next();
          if (localx != null) {
            localx.c();
          }
        }
        this.o.clear();
      }
      if ((paramBoolean) && (this.n != null))
      {
        this.n.a(this);
        this.n.d();
      }
      this.n = null;
      this.C = null;
      return;
    }
    finally {}
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    this.f = paramFloat1;
    this.g = paramFloat2;
    d();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.D != paramBoolean) {
      d();
    }
    this.D = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */