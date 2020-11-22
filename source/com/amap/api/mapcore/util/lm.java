package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

public class lm
{
  IAMapDelegate a;
  Context b;
  GestureDetector c;
  public AMapGestureListener d;
  private s e;
  private q f;
  private p g;
  private t h;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private boolean o = false;
  private boolean p = false;
  private boolean q = true;
  private Handler r = new Handler(Looper.getMainLooper());
  
  public lm(IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramIAMapDelegate.getContext();
    this.a = paramIAMapDelegate;
    paramIAMapDelegate = new a(null);
    this.c = new GestureDetector(this.b, paramIAMapDelegate, this.r);
    this.c.setOnDoubleTapListener(paramIAMapDelegate);
    this.e = new s(this.b, new d(null));
    this.f = new q(this.b, new c(null));
    this.g = new p(this.b, new b(null));
    this.h = new t(this.b, new e(null));
  }
  
  public void a()
  {
    this.j = 0;
    this.l = 0;
    this.k = 0;
    this.m = 0;
    this.n = 0;
  }
  
  public void a(AMapGestureListener paramAMapGestureListener)
  {
    this.d = paramAMapGestureListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.n < paramMotionEvent.getPointerCount()) {
      this.n = paramMotionEvent.getPointerCount();
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.p = false;
      this.q = false;
    }
    if ((paramMotionEvent.getAction() == 6) && (paramMotionEvent.getPointerCount() > 0)) {
      this.p = true;
    }
    if ((this.o) && (this.n >= 2)) {
      this.o = false;
    }
    try
    {
      int[] arrayOfInt = new int[2];
      int[] tmp88_86 = arrayOfInt;
      tmp88_86[0] = 0;
      int[] tmp92_88 = tmp88_86;
      tmp92_88[1] = 0;
      tmp92_88;
      if ((this.a != null) && (this.a.getGLMapView() != null)) {
        this.a.getGLMapView().getLocationOnScreen(arrayOfInt);
      }
      if (this.d != null) {
        if (paramMotionEvent.getAction() == 0) {
          this.d.onDown(paramMotionEvent.getX(), paramMotionEvent.getY());
        } else if (paramMotionEvent.getAction() == 1) {
          this.d.onUp(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      this.c.onTouchEvent(paramMotionEvent);
      boolean bool2 = this.g.d(paramMotionEvent, arrayOfInt[0], arrayOfInt[1]);
      boolean bool1;
      if (this.i)
      {
        bool1 = bool2;
        if (this.m > 0) {}
      }
      else
      {
        this.h.d(paramMotionEvent, arrayOfInt[0], arrayOfInt[1]);
        bool1 = bool2;
        if (!this.o)
        {
          this.e.a(paramMotionEvent);
          bool1 = this.f.d(paramMotionEvent, arrayOfInt[0], arrayOfInt[1]);
        }
      }
      return bool1;
    }
    catch (Throwable paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    if (this.r != null)
    {
      this.r.removeCallbacks(null);
      this.r = null;
    }
  }
  
  private class a
    implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
  {
    float a = 0.0F;
    long b = 0L;
    private int d = 0;
    private EAMapPlatformGestureInfo e = new EAMapPlatformGestureInfo();
    
    private a() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      lm.this.c.setIsLongpressEnabled(false);
      this.d = paramMotionEvent.getPointerCount();
      if (lm.this.d != null) {
        lm.this.d.onDoubleTap(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      return false;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      if (this.d < paramMotionEvent.getPointerCount()) {
        this.d = paramMotionEvent.getPointerCount();
      }
      int i = paramMotionEvent.getAction() & 0xFF;
      int j = this.d;
      boolean bool1 = true;
      if (j == 1) {
        try
        {
          boolean bool2 = lm.this.a.getUiSettings().isZoomGesturesEnabled();
          if (!bool2) {
            return false;
          }
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "GLMapGestrureDetector", "onDoubleTapEvent");
          localThrowable.printStackTrace();
          if (i == 0)
          {
            this.e.mGestureState = 1;
            this.e.mGestureType = 9;
            this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
            i = lm.this.a.getEngineIDWithGestureInfo(this.e);
            this.a = paramMotionEvent.getY();
            lm.this.a.addGestureMapMessage(i, ScaleGestureMapMessage.obtain(100, 1.0F, 0, 0));
            this.b = SystemClock.uptimeMillis();
            return true;
          }
          if (i == 2)
          {
            lm.a(lm.this, true);
            float f1 = this.a - paramMotionEvent.getY();
            if (Math.abs(f1) < 20) {
              break label557;
            }
            this.e.mGestureState = 2;
            this.e.mGestureType = 9;
            this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
            i = lm.this.a.getEngineIDWithGestureInfo(this.e);
            float f2 = 4.0F * f1 / lm.this.a.getMapHeight();
            if (f1 > 0.0F) {
              lm.this.a.addGestureMapMessage(i, ScaleGestureMapMessage.obtain(101, f2, 0, 0));
            } else {
              lm.this.a.addGestureMapMessage(i, ScaleGestureMapMessage.obtain(101, f2, 0, 0));
            }
            this.a = paramMotionEvent.getY();
            return true;
          }
          this.e.mGestureState = 3;
          this.e.mGestureType = 9;
          this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
          j = lm.this.a.getEngineIDWithGestureInfo(this.e);
          lm.this.c.setIsLongpressEnabled(true);
          lm.this.a.addGestureMapMessage(j, ScaleGestureMapMessage.obtain(102, 1.0F, 0, 0));
          if (i == 1)
          {
            lm.this.a.setGestureStatus(j, 3);
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.b;
            if ((lm.f(lm.this)) && (l1 - l2 >= 'È'))
            {
              lm.a(lm.this, false);
              return true;
            }
            return lm.this.a.onDoubleTap(j, paramMotionEvent);
          }
          lm.a(lm.this, false);
          return true;
        }
      }
      bool1 = false;
      label557:
      return bool1;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      lm.a(lm.this, false);
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (lm.this.d != null) {
        lm.this.d.onFling(paramFloat1, paramFloat2);
      }
      try
      {
        boolean bool = lm.this.a.getUiSettings().isScrollGesturesEnabled();
        if (!bool) {
          return true;
        }
        if ((lm.a(lm.this) <= 0) && (lm.b(lm.this) <= 0) && (lm.c(lm.this) == 0) && (!lm.d(lm.this)))
        {
          this.e.mGestureState = 3;
          this.e.mGestureType = 3;
          this.e.mLocation = new float[] { paramMotionEvent2.getX(), paramMotionEvent2.getY() };
          int i = lm.this.a.getEngineIDWithGestureInfo(this.e);
          lm.this.a.onFling();
          lm.this.a.getGLMapEngine().startMapSlidAnim(i, new Point((int)paramMotionEvent2.getX(), (int)paramMotionEvent2.getY()), paramFloat1, paramFloat2);
        }
        return true;
      }
      catch (Throwable paramMotionEvent1)
      {
        gk.c(paramMotionEvent1, "GLMapGestrureDetector", "onFling");
        paramMotionEvent1.printStackTrace();
      }
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (lm.e(lm.this) == 1)
      {
        this.e.mGestureState = 3;
        this.e.mGestureType = 7;
        this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
        int i = lm.this.a.getEngineIDWithGestureInfo(this.e);
        lm.this.a.onLongPress(i, paramMotionEvent);
        if (lm.this.d != null) {
          lm.this.d.onLongPress(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (lm.this.d != null) {
        lm.this.d.onScroll(paramFloat1, paramFloat2);
      }
      return false;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      try
      {
        this.e.mGestureState = 3;
        this.e.mGestureType = 7;
        this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
        int i = lm.this.a.getEngineIDWithGestureInfo(this.e);
        lm.this.a.getGLMapEngine().clearAnimations(i, false);
        return;
      }
      catch (Throwable paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (lm.e(lm.this) == 1)
      {
        this.e.mGestureState = 3;
        this.e.mGestureType = 8;
        this.e.mLocation = new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() };
        int i = lm.this.a.getEngineIDWithGestureInfo(this.e);
        if (lm.this.d != null) {
          try
          {
            lm.this.d.onSingleTap(paramMotionEvent.getX(), paramMotionEvent.getY());
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        return lm.this.a.onSingleTapConfirmed(i, paramMotionEvent);
      }
      return false;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  private class b
    implements p.a
  {
    private EAMapPlatformGestureInfo b = new EAMapPlatformGestureInfo();
    
    private b() {}
    
    public boolean a(p paramp)
    {
      this.b.mGestureState = 2;
      this.b.mGestureType = 6;
      Object localObject = this.b;
      float f1 = paramp.c().getX();
      int j = 0;
      ((EAMapPlatformGestureInfo)localObject).mLocation = new float[] { f1, paramp.c().getY() };
      try
      {
        boolean bool = lm.this.a.getUiSettings().isTiltGesturesEnabled();
        if (!bool) {
          return true;
        }
        int k = lm.this.a.getEngineIDWithGestureInfo(this.b);
        if (lm.this.a.isLockMapCameraDegree(k)) {
          return false;
        }
        if (lm.c(lm.this) > 3) {
          return false;
        }
        f1 = paramp.d().x;
        float f2 = paramp.d().y;
        if (!lm.i(lm.this))
        {
          localObject = paramp.a(0);
          paramp = paramp.a(1);
          int i;
          if ((((PointF)localObject).y <= 10.0F) || (paramp.y <= 10.0F))
          {
            i = j;
            if (((PointF)localObject).y < -10.0F)
            {
              i = j;
              if (paramp.y >= -10.0F) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            float f3 = Math.abs(f2);
            float f4 = 10;
            if ((f3 > f4) && (Math.abs(f1) < f4)) {
              lm.b(lm.this, true);
            }
          }
        }
        if (lm.i(lm.this))
        {
          lm.b(lm.this, true);
          f1 = f2 / 6.0F;
          if (Math.abs(f1) > 1.0F)
          {
            lm.this.a.addGestureMapMessage(k, HoverGestureMapMessage.obtain(101, f1));
            lm.m(lm.this);
            return true;
          }
        }
        return true;
      }
      catch (Throwable paramp)
      {
        gk.c(paramp, "GLMapGestrureDetector", "onHove");
        paramp.printStackTrace();
      }
      return true;
    }
    
    public boolean b(p paramp)
    {
      this.b.mGestureState = 1;
      this.b.mGestureType = 6;
      this.b.mLocation = new float[] { paramp.c().getX(), paramp.c().getY() };
      try
      {
        boolean bool = lm.this.a.getUiSettings().isTiltGesturesEnabled();
        if (!bool) {
          return true;
        }
        int i = lm.this.a.getEngineIDWithGestureInfo(this.b);
        if (lm.this.a.isLockMapCameraDegree(i)) {
          return false;
        }
        lm.this.a.addGestureMapMessage(i, HoverGestureMapMessage.obtain(100, lm.this.a.getCameraDegree(i)));
        return true;
      }
      catch (Throwable paramp)
      {
        gk.c(paramp, "GLMapGestrureDetector", "onHoveBegin");
        paramp.printStackTrace();
      }
      return true;
    }
    
    public void c(p paramp)
    {
      this.b.mGestureState = 3;
      this.b.mGestureType = 6;
      this.b.mLocation = new float[] { paramp.c().getX(), paramp.c().getY() };
      try
      {
        boolean bool = lm.this.a.getUiSettings().isTiltGesturesEnabled();
        if (!bool) {
          return;
        }
        int i = lm.this.a.getEngineIDWithGestureInfo(this.b);
        if (lm.this.a.isLockMapCameraDegree(i)) {
          return;
        }
        if ((lm.this.a.getCameraDegree(i) >= 0.0F) && (lm.a(lm.this) > 0)) {
          lm.this.a.setGestureStatus(i, 7);
        }
        lm.b(lm.this, false);
        lm.this.a.addGestureMapMessage(i, HoverGestureMapMessage.obtain(102, lm.this.a.getCameraDegree(i)));
        return;
      }
      catch (Throwable paramp)
      {
        gk.c(paramp, "GLMapGestrureDetector", "onHoveEnd");
        paramp.printStackTrace();
      }
    }
  }
  
  private class c
    implements q.a
  {
    private EAMapPlatformGestureInfo b = new EAMapPlatformGestureInfo();
    
    private c() {}
    
    public boolean a(q paramq)
    {
      if (lm.i(lm.this)) {
        return true;
      }
      try
      {
        if (lm.this.a.getUiSettings().isScrollGesturesEnabled())
        {
          boolean bool = lm.j(lm.this);
          if (bool) {
            return true;
          }
          this.b.mGestureState = 2;
          this.b.mGestureType = 3;
          this.b.mLocation = new float[] { paramq.c().getX(), paramq.c().getY() };
          int i = lm.this.a.getEngineIDWithGestureInfo(this.b);
          paramq = paramq.d();
          float f = 1.0F;
          if (lm.k(lm.this) == 0) {
            f = 4.0F;
          }
          if ((Math.abs(paramq.x) <= f) && (Math.abs(paramq.y) <= f)) {
            return false;
          }
          if (lm.k(lm.this) == 0) {
            lm.this.a.getGLMapEngine().clearAnimations(i, false);
          }
          lm.this.a.addGestureMapMessage(i, MoveGestureMapMessage.obtain(101, paramq.x, paramq.y));
          lm.l(lm.this);
          return true;
        }
        return true;
      }
      catch (Throwable paramq)
      {
        gk.c(paramq, "GLMapGestrureDetector", "onMove");
        paramq.printStackTrace();
      }
      return true;
    }
    
    public boolean b(q paramq)
    {
      try
      {
        boolean bool = lm.this.a.getUiSettings().isScrollGesturesEnabled();
        if (!bool) {
          return true;
        }
        this.b.mGestureState = 1;
        this.b.mGestureType = 3;
        this.b.mLocation = new float[] { paramq.c().getX(), paramq.c().getY() };
        int i = lm.this.a.getEngineIDWithGestureInfo(this.b);
        lm.this.a.addGestureMapMessage(i, MoveGestureMapMessage.obtain(100, 0.0F, 0.0F));
        return true;
      }
      catch (Throwable paramq)
      {
        gk.c(paramq, "GLMapGestrureDetector", "onMoveBegin");
        paramq.printStackTrace();
      }
      return true;
    }
    
    public void c(q paramq)
    {
      try
      {
        boolean bool = lm.this.a.getUiSettings().isScrollGesturesEnabled();
        if (!bool) {
          return;
        }
        this.b.mGestureState = 3;
        this.b.mGestureType = 3;
        this.b.mLocation = new float[] { paramq.c().getX(), paramq.c().getY() };
        int i = lm.this.a.getEngineIDWithGestureInfo(this.b);
        if (lm.k(lm.this) > 0) {
          lm.this.a.setGestureStatus(i, 5);
        }
        lm.this.a.addGestureMapMessage(i, MoveGestureMapMessage.obtain(102, 0.0F, 0.0F));
        return;
      }
      catch (Throwable paramq)
      {
        gk.c(paramq, "GLMapGestrureDetector", "onMoveEnd");
        paramq.printStackTrace();
      }
    }
  }
  
  private class d
    extends s.a
  {
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private Point e = new Point();
    private float[] f = new float[10];
    private float g = 0.0F;
    private float[] h = new float[10];
    private float i = 0.0F;
    private EAMapPlatformGestureInfo j = new EAMapPlatformGestureInfo();
    
    private d() {}
    
    public boolean a(s params)
    {
      this.j.mGestureState = 2;
      this.j.mGestureType = 4;
      EAMapPlatformGestureInfo localEAMapPlatformGestureInfo = this.j;
      float f1 = params.a().getX();
      boolean bool1 = false;
      localEAMapPlatformGestureInfo.mLocation = new float[] { f1, params.a().getY() };
      int m = lm.this.a.getEngineIDWithGestureInfo(this.j);
      float f4 = params.j();
      f1 = (float)params.k();
      int n = (int)params.b();
      int i1 = (int)params.c();
      float f2 = Math.abs(n - this.e.x);
      float f3 = Math.abs(i1 - this.e.y);
      this.e.x = n;
      this.e.y = i1;
      f4 = (float)Math.log(f4);
      if ((lm.b(lm.this) <= 0) && (Math.abs(f4) > 0.2F)) {
        this.d = true;
      }
      int k;
      try
      {
        if (lm.this.a.getUiSettings().isZoomGesturesEnabled())
        {
          bool2 = this.b;
          if (!bool2) {
            try
            {
              if (0.06F < Math.abs(f4)) {
                this.b = true;
              }
            }
            catch (Throwable localThrowable1)
            {
              break label428;
            }
          }
          if (this.b)
          {
            float f5 = Math.abs(f4);
            if (0.01F < f5)
            {
              if ((f2 <= 2.0F) && (f3 <= 2.0F)) {
                break label693;
              }
              try
              {
                if (Math.abs(f4) >= 0.02F) {
                  break label693;
                }
                k = 1;
              }
              catch (Throwable localThrowable2)
              {
                bool1 = true;
                break label428;
              }
              if (f1 > 0.0F)
              {
                this.g = (f4 / f1);
                f5 = Math.abs(this.g);
                this.f[(lm.b(lm.this) % 10)] = f5;
                lm.g(lm.this);
                lm.this.a.addGestureMapMessage(m, ScaleGestureMapMessage.obtain(101, f4, n, i1));
                if (f4 > 0.0F) {
                  lm.this.a.setGestureStatus(m, 1);
                } else {
                  lm.this.a.setGestureStatus(m, 2);
                }
              }
              label403:
              bool1 = true;
              break label420;
            }
          }
        }
        bool1 = false;
      }
      catch (Throwable localThrowable3)
      {
        label420:
        bool1 = false;
        label428:
        gk.c(localThrowable3, "GLMapGestrureDetector", "onScaleRotate");
        localThrowable3.printStackTrace();
      }
      boolean bool2 = bool1;
      label690:
      label693:
      label704:
      do
      {
        try
        {
          if (!lm.this.a.getUiSettings().isRotateGesturesEnabled()) {
            break label690;
          }
          bool2 = bool1;
          if (lm.this.a.isLockMapAngle(m)) {
            break label690;
          }
          bool2 = bool1;
          if (this.d) {
            break label690;
          }
          f4 = params.l();
          if ((!this.c) && (Math.abs(f4) >= 4.0F)) {
            this.c = true;
          }
          bool2 = bool1;
          if (!this.c) {
            break label690;
          }
          bool2 = bool1;
          if (1.0F >= Math.abs(f4)) {
            break label690;
          }
          if (((f2 <= 4.0F) && (f3 <= 4.0F)) || (Math.abs(f4) >= 2.0F)) {
            break label704;
          }
          k = 1;
        }
        catch (Throwable params) {}
        this.i = (f4 / f1);
        f1 = Math.abs(this.i);
        this.h[(lm.c(lm.this) % 10)] = f1;
        lm.h(lm.this);
        lm.this.a.addGestureMapMessage(m, RotateGestureMapMessage.obtain(101, f4, n, i1));
        try
        {
          lm.this.a.setGestureStatus(m, 6);
          return true;
        }
        catch (Throwable params)
        {
          bool1 = true;
        }
        gk.c(params, "GLMapGestrureDetector", "onScaleRotate");
        params.printStackTrace();
        bool2 = bool1;
        return bool2;
        k = 0;
        if (k == 0) {
          break;
        }
        break label403;
        k = 0;
      } while (k == 0);
      return bool1;
    }
    
    public boolean b(s params)
    {
      this.j.mGestureState = 1;
      this.j.mGestureType = 4;
      this.j.mLocation = new float[] { params.a().getX(), params.a().getY() };
      int k = lm.this.a.getEngineIDWithGestureInfo(this.j);
      int m = (int)params.b();
      int n = (int)params.c();
      this.d = false;
      this.e.x = m;
      this.e.y = n;
      this.b = false;
      this.c = false;
      lm.this.a.addGestureMapMessage(k, ScaleGestureMapMessage.obtain(100, 1.0F, m, n));
      try
      {
        if ((lm.this.a.getUiSettings().isRotateGesturesEnabled()) && (!lm.this.a.isLockMapAngle(k)))
        {
          lm.this.a.addGestureMapMessage(k, RotateGestureMapMessage.obtain(100, lm.this.a.getMapAngle(k), m, n));
          return true;
        }
      }
      catch (Throwable params)
      {
        gk.c(params, "GLMapGestrureDetector", "onScaleRotateBegin");
        params.printStackTrace();
      }
      return true;
    }
    
    public void c(s params)
    {
      this.j.mGestureState = 3;
      this.j.mGestureType = 4;
      EAMapPlatformGestureInfo localEAMapPlatformGestureInfo = this.j;
      float f1 = params.a().getX();
      float f2 = params.a().getY();
      int n = 1;
      localEAMapPlatformGestureInfo.mLocation = new float[] { f1, f2 };
      int i1 = lm.this.a.getEngineIDWithGestureInfo(this.j);
      this.d = false;
      lm.this.a.addGestureMapMessage(i1, ScaleGestureMapMessage.obtain(102, 1.0F, 0, 0));
      int m;
      if (lm.b(lm.this) > 0)
      {
        if (lm.b(lm.this) > 10) {
          k = 10;
        } else {
          k = lm.b(lm.this);
        }
        m = 0;
        f1 = 0.0F;
        while (m < 10)
        {
          f1 += this.f[m];
          this.f[m] = 0.0F;
          m += 1;
        }
        f1 /= k;
        if (0.004F <= f1)
        {
          f1 *= 300.0F;
          f2 = 1.5F;
          if (f1 >= 1.5F) {
            f1 = f2;
          }
          f2 = f1;
          if (this.g < 0.0F) {
            f2 = -f1;
          }
          f1 = f2 + lm.this.a.getPreciseLevel(i1);
        }
        else
        {
          f1 = -9999.0F;
        }
        this.g = 0.0F;
        f2 = f1;
      }
      else
      {
        f2 = -9999.0F;
      }
      if (!lm.this.a.isLockMapAngle(i1))
      {
        try
        {
          if (lm.this.a.getUiSettings().isRotateGesturesEnabled()) {
            lm.this.a.addGestureMapMessage(i1, RotateGestureMapMessage.obtain(102, lm.this.a.getMapAngle(i1), 0, 0));
          }
        }
        catch (Throwable params)
        {
          gk.c(params, "GLMapGestrureDetector", "onScaleRotateEnd");
          params.printStackTrace();
        }
        if (lm.c(lm.this) > 0)
        {
          lm.this.a.setGestureStatus(i1, 6);
          if (lm.c(lm.this) > 10) {
            k = 10;
          } else {
            k = lm.c(lm.this);
          }
          m = 0;
          f1 = 0.0F;
          while (m < 10)
          {
            f1 += this.h[m];
            this.h[m] = 0.0F;
            m += 1;
          }
          f1 /= k;
          if (0.1F <= f1)
          {
            f1 *= 200.0F;
            k = (int)lm.this.a.getMapAngle(i1);
            float f3 = 60.0F;
            if (f1 >= 60.0F) {
              f1 = f3;
            }
            f3 = f1;
            if (this.i < 0.0F) {
              f3 = -f1;
            }
            f1 = (int)(k % 360 + f3) % 360;
            break label534;
          }
        }
        f1 = -9999.0F;
        label534:
        this.g = 0.0F;
      }
      else
      {
        f1 = -9999.0F;
      }
      int k = n;
      if (f2 == -9999.0F) {
        if (f1 != -9999.0F) {
          k = n;
        } else {
          k = 0;
        }
      }
      if (k != 0) {
        lm.this.a.getGLMapEngine().startPivotZoomRotateAnim(i1, this.e, f2, (int)f1, 500);
      }
    }
  }
  
  private class e
    extends t.b
  {
    EAMapPlatformGestureInfo a = new EAMapPlatformGestureInfo();
    
    private e() {}
    
    public void b(t paramt)
    {
      try
      {
        boolean bool = lm.this.a.getUiSettings().isZoomGesturesEnabled();
        if (!bool) {
          return;
        }
        float f1 = Math.abs(paramt.d());
        float f2 = 10;
        if ((f1 <= f2) && (Math.abs(paramt.e()) <= f2) && (paramt.b() < 200L))
        {
          lm.c(lm.this, true);
          this.a.mGestureState = 2;
          this.a.mGestureType = 2;
          this.a.mLocation = new float[] { paramt.c().getX(), paramt.c().getY() };
          int i = lm.this.a.getEngineIDWithGestureInfo(this.a);
          lm.this.a.setGestureStatus(i, 4);
          lm.this.a.zoomOut(i);
        }
        return;
      }
      catch (Throwable paramt)
      {
        gk.c(paramt, "GLMapGestrureDetector", "onZoomOut");
        paramt.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */