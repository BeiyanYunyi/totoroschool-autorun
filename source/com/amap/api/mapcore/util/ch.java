package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.nio.FloatBuffer;

public class ch
  implements IInfoWindowManager, IInfoWindowAction, IOverlayDelegate
{
  private boolean A = true;
  private Bitmap B = null;
  private Bitmap C = null;
  private Bitmap D = null;
  private Bitmap E = null;
  private boolean F = false;
  private boolean G = false;
  private GLAnimation H;
  private GLAnimation I;
  private boolean J = false;
  private boolean K = true;
  IAMapDelegate a = null;
  float[] b = new float[12];
  a c;
  float[] d = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  long e = 0L;
  v f;
  private Context g;
  private BaseOverlayImp h;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private FPoint n;
  private FloatBuffer o = null;
  private String p;
  private boolean q = true;
  private FloatBuffer r;
  private float s = 0.5F;
  private float t = 1.0F;
  private boolean u;
  private Bitmap v;
  private Bitmap w;
  private Rect x = new Rect();
  private float y = 0.0F;
  private int z;
  
  public ch(IAMapDelegate paramIAMapDelegate, Context paramContext)
  {
    this.g = paramContext;
    this.a = paramIAMapDelegate;
    this.p = getId();
  }
  
  private Bitmap a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Object localObject = paramView;
    if ((paramView instanceof RelativeLayout))
    {
      localObject = paramView;
      if (this.g != null)
      {
        localObject = new LinearLayout(this.g);
        ((LinearLayout)localObject).setOrientation(1);
        ((LinearLayout)localObject).addView(paramView);
      }
    }
    ((View)localObject).setDrawingCacheEnabled(true);
    ((View)localObject).setDrawingCacheQuality(0);
    return dx.a((View)localObject);
  }
  
  private void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if ((paramFloatBuffer1 != null) && (paramFloatBuffer2 != null))
    {
      if (paramInt == 0) {
        return;
      }
      if (this.c == null) {
        d();
      }
      this.c.a();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glEnableVertexAttribArray(this.c.b);
      GLES20.glVertexAttribPointer(this.c.b, 3, 5126, false, 12, paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.c.c);
      GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 8, paramFloatBuffer2);
      GLES20.glUniformMatrix4fv(this.c.a, 1, false, this.d, 0);
      GLES20.glDrawArrays(6, 0, 4);
      GLES20.glDisableVertexAttribArray(this.c.b);
      GLES20.glDisableVertexAttribArray(this.c.c);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      GLES20.glDisable(3042);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(h());
      return;
    }
    b(i());
  }
  
  private void c(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
    finally {}
  }
  
  private void c(final boolean paramBoolean)
  {
    if (this.I != null)
    {
      this.K = false;
      this.J = true;
      this.I.startNow();
      this.I.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd()
        {
          if (ch.a(ch.this) != null)
          {
            ch.a(ch.this, true);
            ch.a(ch.this).startNow();
            ch.b(ch.this, paramBoolean);
          }
        }
        
        public void onAnimationStart() {}
      });
      return;
    }
    if (this.H != null)
    {
      this.J = true;
      this.H.startNow();
      b(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  private void d(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        c(this.C);
        this.C = paramBitmap;
      }
    }
    finally {}
  }
  
  private void e(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        c(this.D);
        this.D = paramBitmap;
      }
    }
    finally {}
  }
  
  private void f(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        c(this.E);
        this.E = paramBitmap;
      }
    }
    finally {}
  }
  
  private boolean g(Bitmap paramBitmap)
  {
    if ((this.B != null) && (paramBitmap.hashCode() == this.B.hashCode())) {
      return true;
    }
    if ((this.D != null) && (paramBitmap.hashCode() == this.D.hashCode())) {
      return true;
    }
    if ((this.C != null) && (paramBitmap.hashCode() == this.C.hashCode())) {
      return true;
    }
    return (this.E != null) && (paramBitmap.hashCode() == this.E.hashCode());
  }
  
  private Bitmap h()
  {
    try
    {
      Bitmap localBitmap = this.B;
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private Bitmap i()
  {
    try
    {
      Bitmap localBitmap = this.D;
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void j()
  {
    GLTransformation localGLTransformation;
    if ((!this.K) && (this.I != null) && (!this.I.hasEnded()))
    {
      this.J = true;
      localGLTransformation = new GLTransformation();
      this.I.getTransformation(AnimationUtils.currentAnimationTimeMillis(), localGLTransformation);
      if ((!Double.isNaN(localGLTransformation.scaleX)) && (!Double.isNaN(localGLTransformation.scaleY))) {
        this.y = ((float)localGLTransformation.scaleX);
      }
    }
    else if ((this.H != null) && (!this.H.hasEnded()))
    {
      this.K = false;
      this.J = true;
      this.j = this.l;
      this.k = this.m;
      localGLTransformation = new GLTransformation();
      this.H.getTransformation(AnimationUtils.currentAnimationTimeMillis(), localGLTransformation);
      if ((!Double.isNaN(localGLTransformation.scaleX)) && (!Double.isNaN(localGLTransformation.scaleY))) {
        this.y = ((float)localGLTransformation.scaleX);
      }
    }
    else
    {
      this.y = 1.0F;
      this.J = false;
    }
  }
  
  private int k()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  private void l()
  {
    if ((this.A) && (this.v != null)) {
      c(false);
    } else {
      b(i());
    }
    a(false);
  }
  
  private void m()
  {
    if ((!this.A) && (this.v != null)) {
      c(true);
    } else {
      b(h());
    }
    a(true);
  }
  
  private void n()
  {
    try
    {
      if (this.v != null)
      {
        Bitmap localBitmap = this.v;
        if (localBitmap != null)
        {
          localBitmap.recycle();
          this.v = null;
        }
      }
      if ((this.w != null) && (!this.w.isRecycled()))
      {
        this.w.recycle();
        this.w = null;
      }
      if ((this.B != null) && (!this.B.isRecycled())) {
        this.B.recycle();
      }
      if ((this.C != null) && (!this.C.isRecycled())) {
        this.C.recycle();
      }
      if ((this.D != null) && (!this.D.isRecycled())) {
        this.D.recycle();
      }
      if ((this.E != null) && (!this.E.isRecycled())) {
        this.E.recycle();
      }
      return;
    }
    finally {}
  }
  
  private void o() {}
  
  private Rect p()
  {
    return new Rect(this.x.left, this.x.top, this.x.right, this.x.top + r());
  }
  
  private Rect q()
  {
    return new Rect(this.x.left, this.x.top, this.x.right, this.x.top + s());
  }
  
  private int r()
  {
    if ((this.B != null) && (!this.B.isRecycled())) {
      return this.B.getHeight();
    }
    return 0;
  }
  
  private int s()
  {
    if ((this.D != null) && (!this.D.isRecycled())) {
      return this.D.getHeight();
    }
    return 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled()) {
        this.B = paramBitmap;
      }
    }
    finally {}
  }
  
  public void a(FPoint paramFPoint)
  {
    this.n = paramFPoint;
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public boolean a()
  {
    return this.A;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a.getMapProjection();
    if (this.n != null)
    {
      if (localObject == null) {
        return false;
      }
      IPoint localIPoint = IPoint.obtain();
      MapConfig localMapConfig = this.a.getMapConfig();
      if ((localMapConfig != null) && (localObject != null))
      {
        FPoint localFPoint = FPoint.obtain();
        ((GLMapState)localObject).p20ToScreenPoint((int)localMapConfig.getSX() + (int)this.n.x, (int)localMapConfig.getSY() + (int)this.n.y, localFPoint);
        localIPoint.x = ((int)localFPoint.x);
        localIPoint.y = ((int)localFPoint.y);
        localFPoint.recycle();
      }
      int i3 = b();
      int i4 = c();
      int i2 = (int)(localIPoint.x + this.j - i3 * this.s);
      int i1 = (int)(localIPoint.y + this.k + i4 * (1.0F - this.t));
      localIPoint.recycle();
      if ((i2 - i3 <= paramInt1) && (i2 >= -i3 * 2) && (i1 >= -i4 * 2))
      {
        if (i1 - i4 > paramInt2) {
          return false;
        }
        if (this.v == null) {
          return false;
        }
        i4 = this.v.getWidth();
        paramInt1 = this.v.getHeight();
        if (this.r == null) {
          this.r = dx.a(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
        }
        double d1 = 1.0F - this.y;
        Double.isNaN(d1);
        double d2 = i4;
        Double.isNaN(d2);
        i3 = (int)(d1 * 0.5D * d2);
        localObject = this.b;
        int i5 = i2 + i3;
        float f1 = i5;
        localObject[0] = f1;
        this.x.left = i5;
        localObject = this.b;
        paramInt2 -= i1;
        float f2 = paramInt2;
        localObject[1] = f2;
        this.b[2] = 0.0F;
        localObject = this.b;
        i2 += i4;
        float f3 = i2 - i3;
        localObject[3] = f3;
        this.b[4] = f2;
        this.x.top = (i1 - paramInt1);
        this.b[5] = 0.0F;
        this.b[6] = f3;
        this.x.right = i2;
        localObject = this.b;
        f2 = paramInt2 + paramInt1;
        localObject[7] = f2;
        this.x.bottom = i1;
        this.b[8] = 0.0F;
        this.b[9] = f1;
        this.b[10] = f2;
        this.b[11] = 0.0F;
        if (this.o == null)
        {
          this.o = dx.a(this.b);
          return true;
        }
        this.o = dx.a(this.b, this.o);
        return true;
      }
      return false;
    }
    return false;
  }
  
  public int b()
  {
    try
    {
      try
      {
        if ((this.v != null) && (!this.v.isRecycled()))
        {
          int i1 = this.v.getWidth();
          return i1;
        }
        return 0;
      }
      finally {}
      return 0;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.q) && (this.n != null))
    {
      if (this.v == null) {
        return;
      }
      e();
      this.v.isRecycled();
      if ((!this.G) && (!this.v.isRecycled())) {
        try
        {
          if (this.z != 0) {
            GLES20.glDeleteTextures(1, new int[] { this.z }, 0);
          } else {
            this.z = k();
          }
          try
          {
            if ((this.v != null) && (!this.v.isRecycled()))
            {
              dx.b(this.z, this.v, false);
              this.G = true;
            }
          }
          finally {}
          j();
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "PopupOverlay", "drawMarker");
          localThrowable.printStackTrace();
          return;
        }
      }
      if (a(paramInt1, paramInt2))
      {
        Matrix.setIdentityM(this.d, 0);
        Matrix.orthoM(this.d, 0, 0.0F, paramInt1, 0.0F, paramInt2, 1.0F, -1.0F);
        a(this.z, this.o, this.r);
        if (this.u)
        {
          this.u = false;
          o();
        }
      }
      return;
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      try
      {
        if (paramBitmap.isRecycled()) {
          break label146;
        }
        if (this.v != null)
        {
          int i1 = this.v.hashCode();
          int i2 = paramBitmap.hashCode();
          if (i1 == i2) {
            return;
          }
        }
        if (this.v != null) {
          if ((this.B == null) && (this.C == null) && (this.D == null) && (this.E == null))
          {
            c(this.w);
            this.w = this.v;
          }
          else if (!g(this.v))
          {
            c(this.w);
            this.w = this.v;
          }
        }
        this.G = false;
        this.v = paramBitmap;
      }
      finally {}
    }
    catch (Throwable paramBitmap)
    {
      label146:
      for (;;) {}
    }
    return;
  }
  
  public int c()
  {
    try
    {
      if ((this.v != null) && (!this.v.isRecycled()))
      {
        int i1 = this.v.getHeight();
        return i1;
      }
      return 0;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public void c(int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (this.J)
    {
      this.l = paramInt1;
      this.m = paramInt2;
      return;
    }
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt1;
    this.m = paramInt2;
  }
  
  public boolean calMapFPoint()
    throws RemoteException
  {
    return false;
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public void d()
  {
    this.c = new a("texture.glsl");
  }
  
  public void destroy()
  {
    if (this.i) {
      try
      {
        remove();
        n();
        if (this.r != null)
        {
          this.r.clear();
          this.r = null;
        }
        if (this.o != null)
        {
          this.o.clear();
          this.o = null;
        }
        this.n = null;
        this.z = 0;
        return;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "PopupOverlay", "realDestroy");
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void draw(MapConfig paramMapConfig)
    throws RemoteException
  {}
  
  protected void e()
  {
    for (;;)
    {
      long l1;
      try
      {
        Object localObject1 = this.f;
        l2 = 100L;
        if (localObject1 == null) {
          break label171;
        }
        if ((this.h instanceof ca))
        {
          localObject1 = new Marker((IMarker)this.h);
          l1 = this.f.c((BasePointOverlay)localObject1);
        }
        else
        {
          localObject1 = new GL3DModel((bx)this.h);
          l1 = this.f.c((BasePointOverlay)localObject1);
        }
      }
      finally {}
      long l2 = System.currentTimeMillis();
      if (l2 - this.e > l1)
      {
        if (this.e != 0L) {
          try
          {
            showInfoWindow(this.h);
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException.printStackTrace();
          }
        }
        this.e = l2;
      }
      return;
      if (l1 <= 0L)
      {
        l1 = Long.MAX_VALUE;
      }
      else if (l1 <= 100L)
      {
        l1 = l2;
      }
      else
      {
        continue;
        label171:
        l1 = 0L;
      }
    }
  }
  
  public boolean equalsRemote(IOverlay paramIOverlay)
    throws RemoteException
  {
    return (equals(paramIOverlay)) || (paramIOverlay.getId().equals(getId()));
  }
  
  public boolean f()
  {
    return this.J;
  }
  
  protected void g()
  {
    try
    {
      Object localObject;
      Bitmap localBitmap2;
      Bitmap localBitmap1;
      if ((this.h instanceof ca))
      {
        localObject = new Marker((IMarker)this.h);
        if (this.f != null)
        {
          localBitmap2 = a(this.f.a((BasePointOverlay)localObject));
          localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            View localView = this.f.b((BasePointOverlay)localObject);
            localBitmap1 = localBitmap2;
            if (localView != null)
            {
              if (localView.getBackground() == null) {
                localView.setBackground(this.f.g());
              }
              localBitmap1 = a(localView);
            }
          }
          a(localBitmap1);
          d(a(this.f.a((Marker)localObject)));
          e(a(this.f.b((Marker)localObject)));
          f(a(this.f.c((Marker)localObject)));
        }
      }
      else if (this.f != null)
      {
        localObject = new GL3DModel((bx)this.h);
        localBitmap2 = a(this.f.a((BasePointOverlay)localObject));
        localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          localObject = this.f.b((BasePointOverlay)localObject);
          localBitmap1 = localBitmap2;
          if (localObject != null)
          {
            if (((View)localObject).getBackground() == null) {
              ((View)localObject).setBackground(this.f.g());
            }
            localBitmap1 = a((View)localObject);
          }
        }
        a(localBitmap1);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "PopupOverlay", "getInfoWindow");
      localThrowable.printStackTrace();
    }
  }
  
  public String getId()
  {
    if (this.p == null) {
      this.p = "PopupOverlay";
    }
    return this.p;
  }
  
  public float getZIndex()
  {
    return 0.0F;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public void hideInfoWindow()
  {
    try
    {
      setVisible(false);
      n();
      this.F = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isAboveMaskLayer()
  {
    return false;
  }
  
  public boolean isDrawFinish()
  {
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return this.q;
  }
  
  public boolean onInfoWindowTap(MotionEvent paramMotionEvent)
  {
    if ((this.q) && (this.h != null))
    {
      if (!this.F) {
        return false;
      }
      return dx.a(this.x, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public void redrawInfoWindow()
  {
    for (;;)
    {
      try
      {
        try
        {
          if ((this.h != null) && (this.h.checkInBounds()))
          {
            int i3 = 1;
            setVisible(true);
            Rect localRect1 = this.h.getRect();
            int i4 = this.h.getRealInfoWindowOffsetX() + this.h.getInfoWindowOffsetX();
            int i2 = this.h.getRealInfoWindowOffsetY() + this.h.getInfoWindowOffsetY() + 2;
            if ((this.h instanceof ca))
            {
              try
              {
                if (!f()) {
                  break label497;
                }
                if (this.v != null) {
                  break label492;
                }
                if (this.B != null) {
                  break label497;
                }
                if (this.D == null) {
                  break label492;
                }
              }
              finally {}
              if (i1 != 0)
              {
                IMarkerAction localIMarkerAction = ((ca)this.h).getIMarkerAction();
                if ((localIMarkerAction != null) && (!localIMarkerAction.isInfoWindowEnable()))
                {
                  setVisible(false);
                  return;
                }
                setVisible(true);
                if ((localIMarkerAction != null) && (localIMarkerAction.isInfoWindowAutoOverturn()))
                {
                  Rect localRect2 = p();
                  Rect localRect3 = q();
                  if (a()) {
                    localRect3.offset(0, localRect1.height() + localRect2.height() + 2);
                  } else {
                    localRect2.offset(0, -(localRect1.height() + localRect2.height() + 2));
                  }
                  int i5 = this.a.checkMarkerInRect(localIMarkerAction, localRect2);
                  int i6 = this.a.checkMarkerInRect(localIMarkerAction, localRect3);
                  if (i5 <= 0) {
                    break label502;
                  }
                  i1 = i3;
                  if (i6 != 0)
                  {
                    if ((i6 <= 0) || (i5 >= i6)) {
                      break label502;
                    }
                    i1 = i3;
                  }
                  if (i1 != 0)
                  {
                    i1 = this.h.getRealInfoWindowOffsetY() + this.h.getInfoWindowOffsetY() + 2 + localRect1.height() + localRect3.height();
                    l();
                  }
                  else
                  {
                    m();
                    i1 = i2;
                  }
                  a(this.h.getMapPosition());
                  c(i4, i1);
                }
                else
                {
                  a(this.h.getMapPosition());
                  c(i4, i2);
                  m();
                }
              }
              return;
            }
            if ((!f()) || ((this.v == null) && ((this.B != null) || (this.D != null))))
            {
              if (!this.h.isInfoWindowEnable())
              {
                setVisible(false);
                return;
              }
              setVisible(true);
              a(this.h.getMapPosition());
              c(i4, i2);
              m();
            }
          }
          else
          {
            setVisible(false);
            return;
          }
        }
        finally {}
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      label492:
      int i1 = 0;
      continue;
      label497:
      i1 = 1;
      continue;
      label502:
      i1 = 0;
    }
  }
  
  public void remove()
    throws RemoteException
  {}
  
  public void setAboveMaskLayer(boolean paramBoolean) {}
  
  public void setInfoWindowAdapterManager(v paramv)
  {
    try
    {
      this.f = paramv;
      return;
    }
    finally {}
  }
  
  public void setInfoWindowAnimation(Animation paramAnimation, Animation.AnimationListener paramAnimationListener) {}
  
  public void setInfoWindowAppearAnimation(Animation paramAnimation)
  {
    if ((this.I != null) && (this.I.equals(paramAnimation.glAnimation))) {
      try
      {
        this.H = paramAnimation.glAnimation.clone();
        return;
      }
      catch (Throwable paramAnimation)
      {
        gk.c(paramAnimation, "PopupOverlay", "setInfoWindowDisappearAnimation");
        return;
      }
    }
    this.H = paramAnimation.glAnimation;
  }
  
  public void setInfoWindowBackColor(int paramInt) {}
  
  public void setInfoWindowBackEnable(boolean paramBoolean) {}
  
  public void setInfoWindowBackScale(float paramFloat1, float paramFloat2) {}
  
  public void setInfoWindowDisappearAnimation(Animation paramAnimation)
  {
    if ((this.H != null) && (this.H.equals(paramAnimation.glAnimation))) {
      try
      {
        this.I = paramAnimation.glAnimation.clone();
        return;
      }
      catch (Throwable paramAnimation)
      {
        gk.c(paramAnimation, "PopupOverlay", "setInfoWindowDisappearAnimation");
        return;
      }
    }
    this.I = paramAnimation.glAnimation;
  }
  
  public void setInfoWindowMovingAnimation(Animation paramAnimation) {}
  
  public void setVisible(boolean paramBoolean)
  {
    if ((!this.q) && (paramBoolean)) {
      this.u = true;
    }
    this.q = paramBoolean;
  }
  
  public void setZIndex(float paramFloat) {}
  
  public void showInfoWindow(BaseOverlayImp paramBaseOverlayImp)
    throws RemoteException
  {
    if (paramBaseOverlayImp == null) {
      return;
    }
    try
    {
      boolean bool = paramBaseOverlayImp.isInfoWindowEnable();
      if (!bool) {
        return;
      }
      if ((this.h != null) && (!this.h.getId().equals(paramBaseOverlayImp.getId()))) {
        hideInfoWindow();
      }
      if (this.f != null)
      {
        this.h = paramBaseOverlayImp;
        paramBaseOverlayImp.setInfoWindowShown(true);
        setVisible(true);
        g();
      }
      this.F = true;
      return;
    }
    finally {}
  }
  
  public void startAnimation() {}
  
  static class a
    extends ck
  {
    int a;
    int b;
    int c;
    
    a(String paramString)
    {
      if (!a(paramString)) {
        return;
      }
      this.a = c("aMVP");
      this.b = b("aVertex");
      this.c = b("aTextureCoord");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */