package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class lr
{
  IAMapDelegate a;
  float[] b = new float[180000];
  public cl.d c;
  int d = 0;
  int e = 0;
  private List<IOverlayImageDelegate> f = new ArrayList(500);
  private List<lu> g = new ArrayList();
  private List<IOverlayImageDelegate> h = new ArrayList();
  private a i = new a();
  private boolean j = true;
  private IPoint k;
  private BaseOverlayImp l;
  private IMarkerDelegate m;
  private ed n;
  private dl o;
  private FloatBuffer p;
  private HandlerThread q;
  private Handler r;
  private int[] s = new int[1];
  private Runnable t = new Runnable()
  {
    public void run()
    {
      synchronized (lr.a(lr.this))
      {
        lr.b(lr.this);
        return;
      }
    }
  };
  
  public lr(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.a = paramIAMapDelegate;
    this.n = new ed(512, 1024);
    this.o = new dl();
    this.q = new HandlerThread("AMapZindexSortThread");
    this.q.start();
    this.r = new Handler(this.q.getLooper());
  }
  
  private void a(int paramInt)
  {
    int i3 = paramInt;
    if (paramInt > 5000) {
      i3 = 5000;
    }
    if (this.d == 0)
    {
      Object localObject = new int[2];
      paramInt = 0;
      GLES20.glGenBuffers(2, (int[])localObject, 0);
      this.d = localObject[0];
      this.e = localObject[1];
      localObject = this.o.b(30000);
      short[] arrayOfShort = new short['田'];
      while (paramInt < 5000)
      {
        int i4 = paramInt * 6;
        int i5 = paramInt * 4;
        int i1 = (short)(i5 + 0);
        arrayOfShort[(i4 + 0)] = i1;
        arrayOfShort[(i4 + 1)] = ((short)(i5 + 1));
        int i2 = (short)(i5 + 2);
        arrayOfShort[(i4 + 2)] = i2;
        arrayOfShort[(i4 + 3)] = i1;
        arrayOfShort[(i4 + 4)] = i2;
        arrayOfShort[(i4 + 5)] = ((short)(i5 + 3));
        paramInt += 1;
      }
      ((ShortBuffer)localObject).put(arrayOfShort);
      ((ShortBuffer)localObject).flip();
      GLES20.glBindBuffer(34963, this.e);
      GLES20.glBufferData(34963, 60000, (Buffer)localObject, 35044);
    }
    GLES20.glBindBuffer(34962, this.d);
    GLES20.glBufferData(34962, i3 * 36 * 4, this.p, 35044);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      this.p = this.o.c(paramInt2 * 36);
      this.p.put(this.b, paramInt3, paramInt4);
      this.p.flip();
      a(paramInt2);
      a(paramInt1, paramInt4, paramInt2, this.p, this.a.getMapConfig());
      this.o.a();
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer, MapConfig paramMapConfig)
  {
    if ((paramInt1 != 0) && (paramFloatBuffer != null))
    {
      if (paramInt3 == 0) {
        return;
      }
      if ((this.c == null) || (this.c.c())) {
        k();
      }
      this.c.a();
      GLES20.glUniform1f(this.c.h, paramMapConfig.getSR());
      GLES20.glEnableVertexAttribArray(this.c.b);
      GLES20.glBindBuffer(34962, this.d);
      GLES20.glVertexAttribPointer(this.c.b, 4, 5126, false, 36, 0);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glEnableVertexAttribArray(this.c.c);
      GLES20.glBindBuffer(34962, this.d);
      GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 36, 16);
      GLES20.glEnableVertexAttribArray(this.c.g);
      GLES20.glBindBuffer(34962, this.d);
      GLES20.glVertexAttribPointer(this.c.g, 3, 5126, false, 36, 24);
      GLES20.glUniformMatrix4fv(this.c.a, 1, false, b(), 0);
      GLES20.glBindBuffer(34963, this.e);
      GLES20.glDrawElements(4, paramInt3 * 6, 5123, 0);
      GLES20.glBindBuffer(34962, 0);
      GLES20.glBindBuffer(34963, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glDisableVertexAttribArray(this.c.b);
      GLES20.glDisableVertexAttribArray(this.c.c);
      GLES20.glDisable(3042);
      GLES20.glUseProgram(0);
      return;
    }
  }
  
  private void d(IOverlayImageDelegate paramIOverlayImageDelegate)
  {
    try
    {
      this.f.add(paramIOverlayImageDelegate);
      f();
      return;
    }
    catch (Throwable paramIOverlayImageDelegate)
    {
      gk.c(paramIOverlayImageDelegate, "MapOverlayImageView", "addMarker");
    }
  }
  
  private void j()
  {
    try
    {
      Collections.sort(this.f, this.i);
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MapOverlayImageView", "changeOverlayIndex");
    }
  }
  
  private void k()
  {
    if ((this.c == null) && (this.a != null)) {
      this.c = ((cl.d)this.a.getGLShader(1));
    }
  }
  
  public Marker a(MarkerOptions arg1)
    throws RemoteException
  {
    if (??? == null) {
      return null;
    }
    Object localObject1 = new ca(???, this);
    synchronized (this.f)
    {
      d((IOverlayImageDelegate)localObject1);
      dh.a(this.f.size());
      localObject1 = new Marker((IMarker)localObject1);
      return (Marker)localObject1;
    }
  }
  
  public Text a(TextOptions paramTextOptions)
    throws RemoteException
  {
    if (paramTextOptions == null) {
      return null;
    }
    synchronized (this.f)
    {
      paramTextOptions = new ci(paramTextOptions, this);
      d(paramTextOptions);
      paramTextOptions = new Text(paramTextOptions);
      return paramTextOptions;
    }
  }
  
  public BaseOverlayImp a(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int i1;
      synchronized (this.f)
      {
        i1 = this.f.size() - 1;
        if (i1 >= 0)
        {
          IOverlayImageDelegate localIOverlayImageDelegate = (IOverlayImageDelegate)this.f.get(i1);
          if (((localIOverlayImageDelegate instanceof ca)) && (dx.a(localIOverlayImageDelegate.getRect(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
          {
            this.l = ((ca)localIOverlayImageDelegate);
            paramMotionEvent = this.l;
            return paramMotionEvent;
          }
        }
        else
        {
          return null;
        }
      }
      i1 -= 1;
    }
  }
  
  public IOverlayImageDelegate a(String paramString)
    throws RemoteException
  {
    for (;;)
    {
      int i1;
      synchronized (this.f)
      {
        int i2 = this.f.size();
        i1 = 0;
        if (i1 < i2)
        {
          IOverlayImageDelegate localIOverlayImageDelegate = (IOverlayImageDelegate)this.f.get(i1);
          if ((localIOverlayImageDelegate != null) && (localIOverlayImageDelegate.getId().equals(paramString))) {
            return localIOverlayImageDelegate;
          }
        }
        else
        {
          return null;
        }
      }
      i1 += 1;
    }
  }
  
  public ArrayList<Marker> a(ArrayList<MarkerOptions> paramArrayList, boolean paramBoolean)
    throws RemoteException
  {
    ArrayList localArrayList;
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramArrayList.size();
        i1 = 0;
        if (i2 == 1)
        {
          localObject = (MarkerOptions)paramArrayList.get(0);
          if (localObject != null)
          {
            localArrayList.add(a((MarkerOptions)localObject));
            if ((!paramBoolean) || (((MarkerOptions)localObject).getPosition() == null)) {
              continue;
            }
            this.a.moveCamera(k.a(((MarkerOptions)localObject).getPosition(), 18.0F));
            return localArrayList;
          }
        }
        final Object localObject = LatLngBounds.builder();
        if (i1 < paramArrayList.size())
        {
          MarkerOptions localMarkerOptions = (MarkerOptions)paramArrayList.get(i1);
          if (paramArrayList.get(i1) == null) {
            break label225;
          }
          localArrayList.add(a(localMarkerOptions));
          if (localMarkerOptions.getPosition() == null) {
            break label225;
          }
          ((LatLngBounds.Builder)localObject).include(localMarkerOptions.getPosition());
          break label225;
        }
        if ((paramBoolean) && (localArrayList.size() > 0)) {
          this.a.getMainHandler().postDelayed(new Runnable()
          {
            public void run()
            {
              try
              {
                lr.this.a.moveCamera(k.a(localObject.build(), 50));
                return;
              }
              catch (Throwable localThrowable) {}
            }
          }, 50L);
        }
        return localArrayList;
      }
      catch (Throwable paramArrayList)
      {
        gk.c(paramArrayList, "AMapDelegateImpGLSurfaceView", "addMarkers");
        paramArrayList.printStackTrace();
        return localArrayList;
      }
      return null;
      label225:
      i1 += 1;
    }
  }
  
  public void a()
  {
    this.m = null;
  }
  
  public void a(lu paramlu)
  {
    List localList = this.g;
    if (paramlu != null) {}
    try
    {
      this.g.add(paramlu);
      return;
    }
    finally
    {
      for (;;) {}
    }
    throw paramlu;
  }
  
  public void a(BaseOverlayImp paramBaseOverlayImp)
  {
    if (this.k == null) {
      this.k = IPoint.obtain();
    }
    Rect localRect = paramBaseOverlayImp.getRect();
    this.k = IPoint.obtain(localRect.left + localRect.width() / 2, localRect.top);
    this.l = paramBaseOverlayImp;
    try
    {
      this.a.showInfoWindow(this.l);
      return;
    }
    catch (Throwable paramBaseOverlayImp)
    {
      gk.c(paramBaseOverlayImp, "MapOverlayImageView", "showInfoWindow");
      paramBaseOverlayImp.printStackTrace();
    }
  }
  
  public void a(IMarkerDelegate paramIMarkerDelegate)
  {
    try
    {
      if (this.m != null)
      {
        if ((paramIMarkerDelegate != null) && (paramIMarkerDelegate.getId().equals(this.m.getId()))) {
          return;
        }
        this.m.setOnTap(false);
      }
      if (!this.f.contains(paramIMarkerDelegate)) {
        return;
      }
      if (paramIMarkerDelegate != null) {
        paramIMarkerDelegate.setOnTap(true);
      }
      this.m = paramIMarkerDelegate;
      return;
    }
    catch (Throwable paramIMarkerDelegate)
    {
      gk.c(paramIMarkerDelegate, "MapOverlayImageView", "set2Top");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.a == null) {
          return;
        }
        float f1 = this.a.getMapConfig().getMapPerPixelUnitLength();
        int i1;
        synchronized (this.f)
        {
          h();
          if (this.f.size() == 0) {
            return;
          }
          this.h.clear();
          int i2 = this.f.size();
          i1 = 0;
          if (i1 < i2)
          {
            IOverlayImageDelegate localIOverlayImageDelegate1 = (IOverlayImageDelegate)this.f.get(i1);
            if (!paramBoolean ? localIOverlayImageDelegate1.getZIndex() != 2.14748365E9F : localIOverlayImageDelegate1.getZIndex() == 2.14748365E9F) {
              if ((localIOverlayImageDelegate1.isVisible()) && (!localIOverlayImageDelegate1.isOnTap()))
              {
                this.j = localIOverlayImageDelegate1.isAllowLow();
                if (!localIOverlayImageDelegate1.checkInBounds())
                {
                  boolean bool = localIOverlayImageDelegate1.isInfoWindowShown();
                  if (!bool) {}
                }
                else
                {
                  try
                  {
                    this.h.add(localIOverlayImageDelegate1);
                  }
                  catch (Throwable localThrowable2)
                  {
                    localThrowable2.printStackTrace();
                  }
                }
              }
            }
          }
          else
          {
            if ((this.m != null) && (this.m.isVisible())) {
              this.h.add(this.m);
            }
            if (this.h.size() > 0)
            {
              int i11 = this.h.size();
              int i9 = 0;
              int i5 = 0;
              int i8 = 0;
              int i3 = 0;
              int i7 = 0;
              if (i9 < i11) {
                synchronized ((IOverlayImageDelegate)this.h.get(i9))
                {
                  ???.loadTexture(this.a);
                  if (i9 == 0)
                  {
                    i2 = ???.getTextureId();
                    i6 = i5;
                    i4 = i3;
                    i1 = i7;
                  }
                  else
                  {
                    i10 = ???.getTextureId();
                    i6 = i5;
                    i2 = i8;
                    i4 = i3;
                    i1 = i7;
                    if (i10 != i8)
                    {
                      a(i8, i5, i3, i7);
                      i2 = i10;
                      i6 = 0;
                      i4 = 0;
                      i1 = 0;
                    }
                  }
                  ???.drawMarker(this.a, this.b, i1, f1);
                  int i10 = ???.getTextureId();
                  i8 = i6;
                  i3 = i2;
                  i5 = i4;
                  i7 = i1;
                  if (i10 != i2)
                  {
                    a(i2, i6, i4, i1);
                    i3 = i10;
                    i8 = 0;
                    i7 = 0;
                    i5 = i1;
                  }
                  int i4 = i7 + 36;
                  int i6 = i8 + 1;
                  i2 = i6;
                  i1 = i5;
                  i7 = i4;
                  if (i6 == 5000)
                  {
                    a(i3, i6, i5, i4);
                    i2 = 0;
                    i1 = 0;
                    i7 = 0;
                  }
                  i9 += 1;
                  i5 = i2;
                  i8 = i3;
                  i3 = i1;
                }
              }
              if (i5 > 0) {
                a(i8, i5, i3, i7);
              }
            }
            return;
          }
        }
        i1 += 1;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
    }
  }
  
  public boolean a(Bitmap paramBitmap, lu paramlu)
  {
    try
    {
      paramBitmap = this.n.a(paramBitmap.getWidth() + 1, paramBitmap.getHeight() + 1, paramlu.o());
      if (paramBitmap != null)
      {
        paramlu.f(paramBitmap.a / this.n.a());
        paramlu.e(paramBitmap.b / this.n.b());
        paramlu.g((paramBitmap.a + paramBitmap.c - 1) / this.n.a());
        paramlu.h((paramBitmap.b + paramBitmap.d - 1) / this.n.b());
        paramlu.c((paramBitmap.a + 0.5F) / this.n.a());
        paramlu.d((paramBitmap.b + 0.5F) / this.n.b());
        paramlu.a((paramBitmap.a + paramBitmap.c - 1 - 0.5F) / this.n.a());
        paramlu.b((paramBitmap.b + paramBitmap.d - 1 - 0.5F) / this.n.b());
        paramlu.a(true);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(IOverlayImageDelegate paramIOverlayImageDelegate)
  {
    try
    {
      synchronized (this.f)
      {
        if ((this.m != null) && (this.m.getId().equals(paramIOverlayImageDelegate.getId()))) {
          this.m = null;
        }
        b(paramIOverlayImageDelegate);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      boolean bool = this.f.remove(paramIOverlayImageDelegate);
      return bool;
    }
  }
  
  public void b(IOverlayImageDelegate paramIOverlayImageDelegate)
  {
    if (paramIOverlayImageDelegate != null) {}
    try
    {
      if (paramIOverlayImageDelegate.isInfoWindowShown())
      {
        this.a.hideInfoWindow();
        this.l = null;
        return;
      }
      if ((this.l == null) || (!this.l.getId().equals(paramIOverlayImageDelegate.getId()))) {
        break label64;
      }
      this.l = null;
      return;
    }
    catch (Throwable paramIOverlayImageDelegate)
    {
      label64:
      for (;;) {}
    }
    paramIOverlayImageDelegate.printStackTrace();
  }
  
  public void b(String paramString)
  {
    int i2 = 0;
    if (paramString != null)
    {
      try
      {
        if (paramString.trim().length() != 0) {
          break label204;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject2;
        for (;;) {}
      }
      localObject2 = null;
      this.l = null;
      this.k = null;
      this.m = null;
    }
    for (;;)
    {
      synchronized (this.f)
      {
        this.h.clear();
        if (i1 != 0)
        {
          this.f.clear();
        }
        else
        {
          int i3 = this.f.size();
          i1 = i2;
          Object localObject1 = localObject2;
          if (i1 < i3)
          {
            localObject1 = (IOverlayImageDelegate)this.f.get(i1);
            if (!paramString.equals(((IOverlayImageDelegate)localObject1).getId())) {
              break label218;
            }
          }
          this.f.clear();
          if (localObject1 != null)
          {
            this.f.add(localObject1);
            if ((((IOverlayImageDelegate)localObject1).isOnTap()) && ((localObject1 instanceof IMarkerDelegate))) {
              this.m = ((IMarkerDelegate)localObject1);
            }
          }
        }
        return;
      }
      gk.c(paramString, "MapOverlayImageView", "clear");
      paramString.printStackTrace();
      return;
      label204:
      int i1 = 0;
      break;
      i1 = 1;
      break;
      label218:
      i1 += 1;
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
    throws RemoteException
  {
    List localList = this.f;
    boolean bool2 = false;
    for (;;)
    {
      int i1;
      try
      {
        i1 = this.f.size() - 1;
        boolean bool1 = bool2;
        if (i1 >= 0)
        {
          IOverlayImageDelegate localIOverlayImageDelegate = (IOverlayImageDelegate)this.f.get(i1);
          if ((!(localIOverlayImageDelegate instanceof ca)) || (!localIOverlayImageDelegate.isVisible()) || (!((ca)localIOverlayImageDelegate).isClickable())) {
            break label152;
          }
          Rect localRect = localIOverlayImageDelegate.getRect();
          bool1 = dx.a(localRect, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          if (!bool1) {
            break label152;
          }
          this.k = IPoint.obtain(localRect.left + localRect.width() / 2, localRect.top);
          this.l = ((ca)localIOverlayImageDelegate);
        }
        return bool1;
      }
      finally {}
      label152:
      i1 -= 1;
    }
  }
  
  public float[] b()
  {
    if (this.a != null) {
      return this.a.getFinalMatrix();
    }
    return new float[16];
  }
  
  public IAMapDelegate c()
  {
    return this.a;
  }
  
  public boolean c(IOverlayImageDelegate paramIOverlayImageDelegate)
  {
    synchronized (this.f)
    {
      boolean bool = this.f.contains(paramIOverlayImageDelegate);
      return bool;
    }
  }
  
  public BaseOverlayImp d()
  {
    return this.l;
  }
  
  public List<Marker> e()
  {
    synchronized (this.f)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          IOverlayImageDelegate localIOverlayImageDelegate = (IOverlayImageDelegate)localIterator.next();
          if (((localIOverlayImageDelegate instanceof ca)) && (localIOverlayImageDelegate.checkInBounds())) {
            localArrayList.add(new Marker((IMarker)localIOverlayImageDelegate));
          }
        }
        localObject = finally;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "MapOverlayImageView", "getMapScreenMarkers");
        localThrowable.printStackTrace();
        return localArrayList;
      }
    }
  }
  
  public void f()
  {
    if (this.r != null)
    {
      this.r.removeCallbacks(this.t);
      this.r.postDelayed(this.t, 10L);
    }
  }
  
  protected int g()
  {
    synchronized (this.f)
    {
      int i1 = this.f.size();
      return i1;
    }
  }
  
  public void h()
  {
    for (;;)
    {
      int i1;
      synchronized (this.g)
      {
        int i2 = this.a.getBaseOverlayTextureID();
        i1 = 0;
        if (i1 < this.g.size())
        {
          lu locallu = (lu)this.g.get(i1);
          if (locallu != null)
          {
            locallu.m();
            if (locallu.n() <= 0)
            {
              if (locallu.k() == i2)
              {
                this.n.a(locallu.o());
              }
              else
              {
                this.s[0] = locallu.k();
                GLES20.glDeleteTextures(1, this.s, 0);
                locallu.a(0);
              }
              if (this.a != null) {
                this.a.removeTextureItem(locallu.o());
              }
            }
          }
        }
        else
        {
          this.g.clear();
          return;
        }
      }
      i1 += 1;
    }
  }
  
  public void i()
  {
    try
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        localObject = (IOverlayImageDelegate)localIterator.next();
        if (localObject != null) {
          ((IOverlayImageDelegate)localObject).destroy(false);
        }
      }
      b(null);
      if (this.q != null) {
        this.q.quit();
      }
      this.r = null;
      this.a = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MapOverlayImageView", "destroy");
      localThrowable.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MapOverlayImageView clear erro");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      Log.d("amapApi", ((StringBuilder)localObject).toString());
    }
  }
  
  static class a
    implements Serializable, Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (IOverlayImageDelegate)paramObject1;
      paramObject2 = (IOverlayImageDelegate)paramObject2;
      if ((paramObject1 != null) && (paramObject2 != null)) {
        try
        {
          int i = Float.compare(((IOverlayImageDelegate)paramObject1).getZIndex(), ((IOverlayImageDelegate)paramObject2).getZIndex());
          return i;
        }
        catch (Throwable paramObject1)
        {
          gk.c((Throwable)paramObject1, "MapOverlayImageView", "compare");
          ((Throwable)paramObject1).printStackTrace();
        }
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */