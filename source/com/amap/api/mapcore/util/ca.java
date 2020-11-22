package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ca
  extends BaseOverlayImp
  implements IMarkerAction, IMarkerDelegate, IAnimation
{
  private static int i;
  private float A = 1.0F;
  private float B = 1.0F;
  private float C = 1.0F;
  private MarkerOptions D;
  private boolean E = false;
  private boolean F = true;
  private int G = 5;
  private boolean H = true;
  private boolean I = true;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private boolean M = true;
  private FPoint N = FPoint.obtain();
  private Point O = new Point();
  private float P;
  private float Q;
  private int R = 0;
  private int S = 0;
  private lu T;
  private lu[] U = null;
  private boolean V = false;
  private String W;
  private LatLng X;
  private LatLng Y;
  private String Z;
  float[] a;
  private String aa;
  private float ab = 0.5F;
  private float ac = 1.0F;
  private boolean ad = false;
  private boolean ae = true;
  private lr af;
  private Object ag;
  private boolean ah = false;
  private List<BitmapDescriptor> ai = new CopyOnWriteArrayList();
  private boolean aj = false;
  private boolean ak = false;
  private boolean al = false;
  private boolean am = true;
  private int an = 0;
  private int ao = 20;
  private boolean ap = false;
  private int aq;
  private int ar;
  private long as = 0L;
  private float at = Float.MAX_VALUE;
  private float au = Float.MIN_VALUE;
  private float av = Float.MIN_VALUE;
  private float aw = Float.MAX_VALUE;
  float[] b;
  Rect c = new Rect(0, 0, 0, 0);
  GLTransformation d = null;
  GLTransformation e = null;
  GLAnimation f;
  GLAnimation g;
  Object h = new Object();
  private boolean j;
  private float k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private float o = 0.0F;
  private float p = 0.0F;
  private boolean q = false;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v;
  private int w;
  private FPoint x = FPoint.obtain();
  private float[] y = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float z = 0.0F;
  
  public ca(MarkerOptions paramMarkerOptions, lr paramlr)
  {
    this.af = paramlr;
    setMarkerOptions(paramMarkerOptions);
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    if (paramBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
      return paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
    return paramBitmap;
  }
  
  private static String a(String paramString)
  {
    i += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    if (this.ap)
    {
      IPoint localIPoint = IPoint.obtain();
      this.af.c().getPixel2Geo((int)paramDouble1, (int)paramDouble2, localIPoint);
      a(localIPoint.x, localIPoint.y);
      localIPoint.recycle();
      this.ap = true;
      return;
    }
    a((int)paramDouble1, (int)paramDouble2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
    DPoint localDPoint = DPoint.obtain();
    GLMapState.geo2LonLat(this.v, this.w, localDPoint);
    this.X = new LatLng(localDPoint.y, localDPoint.x, false);
    if ((this.af != null) && (this.af.c() != null))
    {
      this.x.x = (this.v - (int)this.af.c().getMapConfig().getSX());
      this.x.y = (this.w - (int)this.af.c().getMapConfig().getSY());
    }
    localDPoint.recycle();
    c();
  }
  
  private void a(GLAnimation paramGLAnimation)
  {
    if ((paramGLAnimation instanceof GLTranslateAnimation))
    {
      if (this.ap)
      {
        this.X = getPosition();
        setPosition(this.X);
        this.ap = true;
      }
      if (this.ap)
      {
        paramGLAnimation = (GLTranslateAnimation)paramGLAnimation;
        paramGLAnimation.mFromXDelta = this.aq;
        paramGLAnimation.mFromYDelta = this.ar;
        localIPoint = IPoint.obtain();
        this.af.c().getLatLng2Pixel(paramGLAnimation.mToYDelta, paramGLAnimation.mToXDelta, localIPoint);
        paramGLAnimation.mToXDelta = localIPoint.x;
        paramGLAnimation.mToYDelta = localIPoint.y;
        localIPoint.recycle();
        return;
      }
      paramGLAnimation = (GLTranslateAnimation)paramGLAnimation;
      paramGLAnimation.mFromXDelta = this.v;
      paramGLAnimation.mFromYDelta = this.w;
      IPoint localIPoint = IPoint.obtain();
      GLMapState.lonlat2Geo(paramGLAnimation.mToXDelta, paramGLAnimation.mToYDelta, localIPoint);
      paramGLAnimation.mToXDelta = localIPoint.x;
      paramGLAnimation.mToYDelta = localIPoint.y;
      localIPoint.recycle();
    }
  }
  
  private void a(IAMapDelegate paramIAMapDelegate, float paramFloat, int paramInt1, int paramInt2)
    throws RemoteException
  {
    paramInt1 = (int)(this.A * paramInt1);
    paramInt2 = (int)(this.B * paramInt2);
    float f4 = paramInt1 * paramFloat;
    float f5 = paramInt2 * paramFloat;
    float f6 = this.x.x;
    float f7 = this.x.y;
    float f2 = paramIAMapDelegate.getMapConfig().getSC();
    float f1 = this.o;
    paramFloat = f1;
    if (this.ai != null)
    {
      paramFloat = f1;
      if (this.ai.size() > 0) {
        if (this.j)
        {
          paramInt2 = this.U.length;
          paramInt1 = (int)(this.o / this.k);
          if (paramInt1 > paramInt2)
          {
            paramInt1 = 0;
            paramFloat = f1;
          }
          else
          {
            paramFloat = this.o % this.k;
          }
          this.T = this.U[((paramInt1 + paramInt2) % paramInt2)];
        }
        else
        {
          this.an += 1;
          paramInt1 = this.ao;
          paramInt2 = this.ai.size();
          if (this.an >= paramInt1 * paramInt2) {
            this.an = 0;
          }
          if (this.ao == 0) {
            this.ao = 1;
          }
          paramInt1 = this.an / this.ao;
          this.T = this.U[paramInt1];
          paramFloat = f1;
          if (!this.am)
          {
            c();
            paramFloat = f1;
          }
        }
      }
    }
    f1 = paramFloat;
    if (this.q)
    {
      f1 = paramFloat - paramIAMapDelegate.getMapConfig().getSR();
      f2 = 0.0F;
    }
    float f3 = this.C;
    paramFloat = f3;
    if (f3 < 0.0F) {
      paramFloat = 0.0F;
    }
    f3 = paramFloat;
    if (paramFloat > 1.0F) {
      f3 = 1.0F;
    }
    this.y[0] = (f6 - this.ab * f4);
    this.y[1] = ((1.0F - this.ac) * f5 + f7);
    this.y[2] = f6;
    this.y[3] = f7;
    this.y[6] = f1;
    this.y[7] = f2;
    this.y[8] = f3;
    this.y[9] = ((1.0F - this.ab) * f4 + f6);
    this.y[10] = ((1.0F - this.ac) * f5 + f7);
    this.y[11] = f6;
    this.y[12] = f7;
    this.y[15] = f1;
    this.y[16] = f2;
    this.y[17] = f3;
    this.y[18] = ((1.0F - this.ab) * f4 + f6);
    this.y[19] = (f7 - this.ac * f5);
    this.y[20] = f6;
    this.y[21] = f7;
    this.y[24] = f1;
    this.y[25] = f2;
    this.y[26] = f3;
    this.y[27] = (f6 - f4 * this.ab);
    this.y[28] = (f7 - f5 * this.ac);
    this.y[29] = f6;
    this.y[30] = f7;
    this.y[33] = f1;
    this.y[34] = f2;
    this.y[35] = f3;
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt)
  {
    if ((this.U != null) && (this.U.length > 0)) {
      System.arraycopy(this.y, 0, paramArrayOfFloat, paramInt, this.y.length);
    }
  }
  
  private void c()
  {
    if (this.af.c() != null) {
      this.af.c().setRunLowFrame(false);
    }
  }
  
  private void d()
  {
    try
    {
      if (this.T.a())
      {
        this.y[4] = this.T.d();
        this.y[5] = this.T.c();
        this.y[13] = this.T.b();
        this.y[14] = this.T.c();
        this.y[22] = this.T.b();
        this.y[23] = this.T.e();
        this.y[31] = this.T.d();
        this.y[32] = this.T.e();
        return;
      }
      this.y[4] = this.T.g();
      this.y[5] = this.T.i();
      this.y[13] = this.T.h();
      this.y[14] = this.T.i();
      this.y[22] = this.T.h();
      this.y[23] = this.T.f();
      this.y[31] = this.T.g();
      this.y[32] = this.T.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void e()
  {
    if ((!this.M) && (this.f != null) && (!this.f.hasEnded()))
    {
      c();
      synchronized (this.h)
      {
        if ((this.e == null) || (this.al))
        {
          this.e = new GLTransformation();
          this.e.scaleX = this.A;
          this.e.scaleY = this.B;
          this.e.rotate = this.o;
          this.e.y = this.w;
          this.e.x = this.v;
          this.e.alpha = this.C;
          this.al = false;
        }
        if (this.d == null) {
          this.d = new GLTransformation();
        }
        this.d.clear();
        this.f.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.d);
        if (this.d != null)
        {
          if ((!Double.isNaN(this.d.scaleX)) && (!Double.isNaN(this.d.scaleY)))
          {
            this.A = ((float)this.d.scaleX);
            this.B = ((float)this.d.scaleY);
          }
          if (!Double.isNaN(this.d.rotate)) {
            setRotateAngle((float)this.d.rotate);
          }
          if ((!Double.isNaN(this.d.x)) && (!Double.isNaN(this.d.y))) {
            a(this.d.x, this.d.y);
          }
          if (!Double.isNaN(this.d.alpha)) {
            this.C = ((float)this.d.alpha);
          }
        }
        this.n = true;
        this.am = false;
        return;
      }
    }
    if ((this.f != null) && ((this.d != null) || (this.e != null)))
    {
      if ((this.d != null) && (!Double.isNaN(this.d.scaleX)) && (!Double.isNaN(this.d.scaleY)))
      {
        this.A = ((float)this.d.scaleX);
        this.B = ((float)this.d.scaleY);
      }
      else if ((this.e != null) && (!Double.isNaN(this.e.scaleX)) && (!Double.isNaN(this.e.scaleY)) && ((this.A != this.e.scaleX) || (this.B != this.e.scaleY)))
      {
        this.A = ((float)this.e.scaleX);
        this.B = ((float)this.e.scaleY);
      }
      if ((this.d != null) && (!Double.isNaN(this.d.rotate))) {
        setRotateAngle((float)this.d.rotate);
      } else if ((this.e != null) && (!Double.isNaN(this.e.rotate)) && (this.o != this.e.rotate)) {
        setRotateAngle((float)this.e.rotate);
      }
      if ((this.d != null) && (!Double.isNaN(this.d.x)) && (!Double.isNaN(this.d.y))) {
        a(this.d.x, this.d.y);
      } else if ((this.e != null) && (!Double.isNaN(this.e.x)) && (!Double.isNaN(this.e.y)) && ((this.v != this.e.x) || (this.w != this.e.y))) {
        a(this.e.x, this.e.y);
      }
      if ((this.d != null) && (!Double.isNaN(this.d.alpha))) {
        this.C = ((float)this.d.alpha);
      } else if ((this.e != null) && (!Double.isNaN(this.e.alpha)) && (this.C != this.e.alpha)) {
        this.C = ((float)this.e.alpha);
      }
    }
    this.M = true;
    this.d = null;
    this.e = null;
    if ((this.ai != null) && (this.ai.size() == 1)) {
      this.am = true;
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
    if ((this.af.c() != null) && (this.af.c().getMapConfig() != null))
    {
      this.P = (this.af.c().getMapConfig().getMapPerPixelUnitLength() * getWidth());
      this.Q = (this.af.c().getMapConfig().getMapPerPixelUnitLength() * getHeight());
    }
  }
  
  void a()
  {
    try
    {
      if (this.ai != null) {
        this.ai.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(ArrayList<BitmapDescriptor> paramArrayList)
  {
    try
    {
      a();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)paramArrayList.next();
          if (localBitmapDescriptor != null) {
            this.ai.add(localBitmapDescriptor);
          }
        }
      }
      if (this.ai.size() == 0) {
        this.ai.add(BitmapDescriptorFactory.defaultMarker());
      }
      if (this.ai.size() > 0)
      {
        paramArrayList = (BitmapDescriptor)this.ai.get(0);
        if (paramArrayList != null)
        {
          this.R = paramArrayList.getWidth();
          this.S = paramArrayList.getHeight();
        }
      }
      return;
    }
    finally {}
  }
  
  public FPoint anchorUVoff()
  {
    FPoint localFPoint = FPoint.obtain();
    if ((this.ai != null) && (this.ai.size() != 0))
    {
      localFPoint.x = (getWidth() * this.ab);
      localFPoint.y = (getHeight() * this.ac);
    }
    return localFPoint;
  }
  
  public IPoint b()
  {
    if ((this.X == null) && (!this.ap)) {
      return null;
    }
    FPoint localFPoint = FPoint.obtain();
    this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, localFPoint);
    return IPoint.obtain((int)localFPoint.x, (int)localFPoint.y);
  }
  
  public boolean calFPoint()
  {
    try
    {
      if ((this.af != null) && (this.af.c() != null))
      {
        if (this.af.c().getMapProjection() == null) {
          return false;
        }
        if (this.x == null) {
          this.x = FPoint.obtain();
        }
        if (this.ap)
        {
          IPoint localIPoint = IPoint.obtain();
          this.af.c().getPixel2Geo(this.aq, this.ar, localIPoint);
          this.v = localIPoint.x;
          this.w = localIPoint.y;
          localIPoint.recycle();
          this.af.c().geo2Map(this.v, this.w, this.x);
        }
        else
        {
          this.af.c().geo2Map(this.v, this.w, this.x);
        }
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean checkInBounds()
  {
    if (this.ap) {
      return true;
    }
    try
    {
      if (this.x != null)
      {
        if (!this.M) {
          return true;
        }
        this.O.x = this.v;
        this.O.y = this.w;
        Rectangle localRectangle = this.af.c().getMapConfig().getGeoRectangle();
        if (localRectangle.contains(this.v, this.w)) {
          return true;
        }
        g();
        int i1 = (int)(this.A * this.P);
        int i2 = (int)(this.B * this.Q);
        int i3 = (int)(this.v - i1 * this.ab);
        int i4 = (int)(this.w - i2 * this.ac);
        if (localRectangle.contains(i3, i4)) {
          return true;
        }
        boolean bool = localRectangle.isOverlap(i3, i4, i1, i2);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MarkerDelegateImp", "checkInBounds");
    }
    return false;
  }
  
  public void destroy()
  {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      try
      {
        this.V = true;
        if (paramBoolean) {
          remove();
        }
        Object localObject = this.af;
        int i3 = 0;
        int i2 = i3;
        if (localObject != null)
        {
          i1 = 0;
          i2 = i3;
          if (this.U != null)
          {
            i2 = i3;
            if (i1 < this.U.length)
            {
              localObject = this.U[i1];
              if (localObject == null) {
                break label185;
              }
              this.af.a((lu)localObject);
              this.af.c().removeTextureItem(((lu)localObject).o());
              break label185;
            }
          }
        }
        if ((this.ai != null) && (i2 < this.ai.size()))
        {
          ((BitmapDescriptor)this.ai.get(i2)).recycle();
          i2 += 1;
          continue;
        }
        this.X = null;
        this.ag = null;
        this.U = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "MarkerDelegateImp", "destroy");
        localThrowable.printStackTrace();
        Log.d("destroy erro", "MarkerDelegateImp destroy");
        return;
      }
      label185:
      i1 += 1;
    }
  }
  
  public void drawMarker(IAMapDelegate paramIAMapDelegate) {}
  
  public void drawMarker(IAMapDelegate paramIAMapDelegate, float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    int i1;
    if ((!this.V) && ((this.X != null) || (this.ap)) && (this.ai != null)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return;
    }
    try
    {
      if (!this.l)
      {
        this.as = System.currentTimeMillis();
        this.l = true;
      }
      Object localObject;
      if ((this.ap) && (this.I))
      {
        localObject = IPoint.obtain();
        paramIAMapDelegate.getPixel2Geo(this.aq, this.ar, (IPoint)localObject);
        this.v = ((IPoint)localObject).x;
        this.w = ((IPoint)localObject).y;
        ((IPoint)localObject).recycle();
      }
      this.x.x = (this.v - (int)paramIAMapDelegate.getMapConfig().getSX());
      if (this.x.x > 1.34217728E8F)
      {
        localObject = this.x;
        ((FPoint)localObject).x -= 2.68435456E8F;
      }
      else if (this.x.x < -1.34217728E8F)
      {
        localObject = this.x;
        ((FPoint)localObject).x += 2.68435456E8F;
      }
      this.x.y = (this.w - (int)paramIAMapDelegate.getMapConfig().getSY());
      i1 = getWidth();
      int i2 = getHeight();
      e();
      a(paramIAMapDelegate, paramFloat, i1, i2);
      if ((!this.J) || (!this.am))
      {
        d();
        this.J = true;
      }
      a(paramArrayOfFloat, paramInt);
      if ((this.n) && (isInfoWindowShown()))
      {
        this.af.c().redrawInfoWindow();
        if (System.currentTimeMillis() - this.as > 'Ϩ')
        {
          this.n = false;
          return;
        }
      }
    }
    catch (Throwable paramIAMapDelegate)
    {
      gk.c(paramIAMapDelegate, "MarkerDelegateImp", "drawMarker");
    }
  }
  
  public boolean equalsRemote(IOverlayImage paramIOverlayImage)
    throws RemoteException
  {
    return (equals(paramIOverlayImage)) || (paramIOverlayImage.getId().equals(getId()));
  }
  
  public float getAlpha()
  {
    return this.C;
  }
  
  public IPoint getAnchor()
  {
    IPoint localIPoint = b();
    if (localIPoint == null) {
      return null;
    }
    return localIPoint;
  }
  
  public float getAnchorU()
  {
    return this.ab;
  }
  
  public float getAnchorV()
  {
    return this.ac;
  }
  
  /* Error */
  public BitmapDescriptor getBitmapDescriptor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   19: invokeinterface 397 1 0
    //   24: ifne +23 -> 47
    //   27: aload_0
    //   28: invokevirtual 516	com/amap/api/mapcore/util/ca:a	()V
    //   31: aload_0
    //   32: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   35: invokestatic 543	com/amap/api/maps/model/BitmapDescriptorFactory:defaultMarker	()Lcom/amap/api/maps/model/BitmapDescriptor;
    //   38: invokeinterface 537 2 0
    //   43: pop
    //   44: goto +34 -> 78
    //   47: aload_0
    //   48: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   51: iconst_0
    //   52: invokeinterface 547 2 0
    //   57: ifnonnull +21 -> 78
    //   60: aload_0
    //   61: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   64: invokeinterface 513 1 0
    //   69: aload_0
    //   70: invokevirtual 669	com/amap/api/mapcore/util/ca:getBitmapDescriptor	()Lcom/amap/api/maps/model/BitmapDescriptor;
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: areturn
    //   78: aload_0
    //   79: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   82: iconst_0
    //   83: invokeinterface 547 2 0
    //   88: checkcast 533	com/amap/api/maps/model/BitmapDescriptor
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: astore_1
    //   97: goto +22 -> 119
    //   100: astore_1
    //   101: aload_1
    //   102: ldc_w 588
    //   105: ldc_w 670
    //   108: invokestatic 594	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokevirtual 444	java/lang/Throwable:printStackTrace	()V
    //   115: aload_0
    //   116: monitorexit
    //   117: aconst_null
    //   118: areturn
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	ca
    //   6	89	1	localObject1	Object
    //   96	1	1	localObject2	Object
    //   100	22	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	96	finally
    //   15	44	96	finally
    //   47	74	96	finally
    //   78	92	96	finally
    //   101	115	96	finally
    //   2	7	100	java/lang/Throwable
    //   15	44	100	java/lang/Throwable
    //   47	74	100	java/lang/Throwable
    //   78	92	100	java/lang/Throwable
  }
  
  public int getDisplayLevel()
  {
    return this.G;
  }
  
  public IPoint getGeoPoint()
  {
    IPoint localIPoint = IPoint.obtain();
    if (this.ap)
    {
      this.af.c().getPixel2Geo(this.aq, this.ar, localIPoint);
      return localIPoint;
    }
    localIPoint.set(this.v, this.w);
    return localIPoint;
  }
  
  public int getHeight()
  {
    try
    {
      int i1 = this.S;
      return i1;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public IAnimation getIAnimation()
  {
    return this;
  }
  
  public IMarkerAction getIMarkerAction()
  {
    return this;
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    try
    {
      if ((this.ai != null) && (this.ai.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.ai.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((BitmapDescriptor)localIterator.next());
        }
        return localArrayList;
      }
      return null;
    }
    finally {}
  }
  
  public String getId()
  {
    if (this.W == null) {
      this.W = a("Marker");
    }
    return this.W;
  }
  
  public int getInfoWindowOffsetX()
  {
    return this.r;
  }
  
  public int getInfoWindowOffsetY()
  {
    return this.s;
  }
  
  public FPoint getMapPosition()
  {
    return this.x;
  }
  
  public Object getObject()
  {
    return this.ag;
  }
  
  public MarkerOptions getOptions()
  {
    return this.D;
  }
  
  public int getPeriod()
  {
    return this.ao;
  }
  
  public LatLng getPosition()
  {
    if ((this.ap) && (this.x != null))
    {
      DPoint localDPoint = DPoint.obtain();
      IPoint localIPoint = IPoint.obtain();
      calFPoint();
      if (this.af.c() == null) {
        return this.X;
      }
      this.af.c().map2Geo(this.x.x, this.x.y, localIPoint);
      GLMapState.geo2LonLat(localIPoint.x, localIPoint.y, localDPoint);
      LatLng localLatLng = new LatLng(localDPoint.y, localDPoint.x);
      localIPoint.recycle();
      localDPoint.recycle();
      return localLatLng;
    }
    return this.X;
  }
  
  public int getRealInfoWindowOffsetX()
  {
    return this.t;
  }
  
  public int getRealInfoWindowOffsetY()
  {
    return this.u;
  }
  
  public LatLng getRealPosition()
  {
    try
    {
      if (this.ap)
      {
        localObject = DPoint.obtain();
        this.af.c().getPixel2LatLng(this.aq, this.ar, (DPoint)localObject);
        LatLng localLatLng = new LatLng(((DPoint)localObject).y, ((DPoint)localObject).y);
        ((DPoint)localObject).recycle();
        return localLatLng;
      }
      if (this.aj) {
        return this.Y;
      }
      Object localObject = this.X;
      return (LatLng)localObject;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MarkerDelegateImp", "getRealPosition");
    }
    return null;
  }
  
  public Rect getRect()
  {
    if (this.y == null)
    {
      this.c.set(0, 0, 0, 0);
      return this.c;
    }
    try
    {
      Object localObject2 = this.af.c().getMapProjection();
      if (localObject2 == null) {
        return new Rect(0, 0, 0, 0);
      }
      int i1 = getWidth();
      int i2 = getHeight();
      Object localObject1 = FPoint.obtain();
      if (this.ap)
      {
        ((FPoint)localObject1).x = this.aq;
        ((FPoint)localObject1).y = this.ar;
      }
      else
      {
        ((GLMapState)localObject2).p20ToScreenPoint(this.v, this.w, (FPoint)localObject1);
      }
      Matrix.setIdentityM(this.a, 0);
      Matrix.rotateM(this.a, 0, -this.o, 0.0F, 0.0F, 1.0F);
      if (this.q)
      {
        Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSC(), 1.0F, 0.0F, 0.0F);
        Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSR(), 0.0F, 0.0F, 1.0F);
      }
      localObject2 = new float[4];
      float[] arrayOfFloat = this.b;
      float f1 = -i1;
      arrayOfFloat[0] = (this.ab * f1);
      arrayOfFloat = this.b;
      float f2 = i2;
      arrayOfFloat[1] = (this.ac * f2);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.set((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]), (int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      arrayOfFloat = this.b;
      float f3 = i1;
      arrayOfFloat[0] = ((1.0F - this.ab) * f3);
      this.b[1] = (f2 * this.ac);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.b[0] = (f3 * (1.0F - this.ab));
      arrayOfFloat = this.b;
      f2 = -i2;
      arrayOfFloat[1] = ((1.0F - this.ac) * f2);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.b[0] = (f1 * this.ab);
      this.b[1] = (f2 * (1.0F - this.ac));
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.t = ((int)(this.c.centerX() - ((FPoint)localObject1).x));
      this.u = ((int)(this.c.top - ((FPoint)localObject1).y));
      ((FPoint)localObject1).recycle();
      localObject1 = this.c;
      return (Rect)localObject1;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MarkerDelegateImp", "getRect");
      localThrowable.printStackTrace();
    }
    return new Rect(0, 0, 0, 0);
  }
  
  public float getRotateAngle()
  {
    c();
    return this.p;
  }
  
  public String getSnippet()
  {
    return this.aa;
  }
  
  public int getTextureId()
  {
    try
    {
      if (this.ai != null)
      {
        if (this.ai.size() <= 0) {
          return 0;
        }
        int i1 = this.T.k();
        return i1;
      }
      return 0;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public String getTitle()
  {
    return this.Z;
  }
  
  public int getWidth()
  {
    try
    {
      int i1 = this.R;
      return i1;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public float getZIndex()
  {
    return this.z;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public void hideInfoWindow()
  {
    if (isInfoWindowShown())
    {
      this.af.b(this);
      c();
      this.m = false;
    }
    this.n = false;
  }
  
  public boolean isAllowLow()
  {
    return this.am;
  }
  
  public boolean isBelowMaskLayer()
  {
    return this.K;
  }
  
  public boolean isClickable()
  {
    return this.H;
  }
  
  public boolean isContains()
  {
    return this.af.c(this);
  }
  
  public boolean isDestory()
  {
    return this.V;
  }
  
  public boolean isDraggable()
  {
    return this.ad;
  }
  
  public boolean isFlat()
  {
    return this.q;
  }
  
  public boolean isInfoWindowAutoOverturn()
  {
    return this.E;
  }
  
  public boolean isInfoWindowEnable()
  {
    return this.F;
  }
  
  public boolean isInfoWindowShown()
  {
    return this.m;
  }
  
  public boolean isOnTap()
  {
    return this.L;
  }
  
  public boolean isPerspective()
  {
    return this.ah;
  }
  
  public boolean isRemoved()
  {
    try
    {
      boolean bool = this.af.c(this);
      return bool ^ true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isViewMode()
  {
    return this.ap;
  }
  
  public boolean isVisible()
  {
    return this.ae;
  }
  
  public void loadTexture(IAMapDelegate paramIAMapDelegate)
  {
    if (!this.ak) {}
    try
    {
      if (this.U == null) {
        break label56;
      }
      localObject1 = this.U;
      i2 = localObject1.length;
      i1 = 0;
    }
    catch (Throwable paramIAMapDelegate)
    {
      for (;;)
      {
        int i2;
        Object localObject2;
        label56:
        Iterator localIterator;
        gk.c(paramIAMapDelegate, "MarkerDelegateImp", "loadtexture");
        return;
        throw paramIAMapDelegate;
        return;
        i1 += 1;
        continue;
        int i1 = 0;
      }
      Object localObject1 = null;
      int i3 = 0;
    }
    finally
    {
      for (;;) {}
    }
    if (i1 < i2)
    {
      localObject2 = localObject1[i1];
      if (localObject2 != null) {
        this.af.a((lu)localObject2);
      }
    }
    else
    {
      this.U = null;
      if (this.ai != null)
      {
        this.U = new lu[this.ai.size()];
        if (Build.VERSION.SDK_INT < 12) {
          break label470;
        }
        i1 = 1;
        localIterator = this.ai.iterator();
        i2 = 0;
        while (localIterator.hasNext())
        {
          BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)localIterator.next();
          if (i1 == 0) {
            break label475;
          }
          localObject2 = paramIAMapDelegate.getTextureItem(localBitmapDescriptor);
          localObject1 = localObject2;
          if (localObject2 == null) {
            break label478;
          }
          i3 = ((lu)localObject2).k();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new lu(localBitmapDescriptor, i3);
          }
          if (i3 == 0)
          {
            localObject1 = localBitmapDescriptor.getBitmap();
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              this.R = ((Bitmap)localObject1).getWidth();
              this.S = ((Bitmap)localObject1).getHeight();
              i3 = this.af.c().getBaseOverlayTextureID();
              if (i3 == 0)
              {
                i3 = f();
                ((lu)localObject2).a(i3);
                if (i1 != 0) {
                  paramIAMapDelegate.addTextureItem((lu)localObject2);
                }
                dx.b(i3, (Bitmap)localObject1, false);
              }
              else
              {
                if (this.af.a((Bitmap)localObject1, (lu)localObject2))
                {
                  dx.a(i3, a((Bitmap)localObject1), (int)(((lu)localObject2).g() * 512.0F), (int)(((lu)localObject2).f() * 1024.0F));
                  ((lu)localObject2).a(i3);
                }
                else
                {
                  i3 = f();
                  dx.b(i3, (Bitmap)localObject1, false);
                  ((lu)localObject2).a(i3);
                }
                if (i1 != 0) {
                  paramIAMapDelegate.addTextureItem((lu)localObject2);
                }
              }
            }
          }
          ((lu)localObject2).l();
          this.U[i2] = localObject2;
          i2 += 1;
        }
        if (this.ai.size() == 1) {
          this.am = true;
        } else {
          this.am = false;
        }
        this.J = false;
        this.ak = true;
      }
      calFPoint();
      return;
    }
  }
  
  public void reLoadTexture()
  {
    try
    {
      this.ak = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean remove()
  {
    c();
    boolean bool = false;
    this.ae = false;
    if (this.af != null) {
      bool = this.af.a(this);
    }
    return bool;
  }
  
  public void set2Top()
  {
    this.af.a(this);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.C = paramFloat;
    this.D.alpha(paramFloat);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if ((this.ab == paramFloat1) && (this.ac == paramFloat2)) {
      return;
    }
    this.D.anchor(paramFloat1, paramFloat2);
    this.ab = paramFloat1;
    this.ac = paramFloat2;
    this.n = true;
    c();
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    IAnimation localIAnimation = getIAnimation();
    if (localIAnimation != null)
    {
      if (paramAnimation == null) {
        paramAnimation = null;
      } else {
        paramAnimation = paramAnimation.glAnimation;
      }
      localIAnimation.setAnimation(paramAnimation);
    }
  }
  
  public void setAnimation(GLAnimation paramGLAnimation)
  {
    if (paramGLAnimation == null) {
      return;
    }
    this.g = paramGLAnimation;
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    if (this.g != null) {
      this.g.setAnimationListener(paramAnimationListener);
    }
  }
  
  public void setAutoOverturnInfoWindow(boolean paramBoolean)
  {
    this.E = paramBoolean;
    this.D.autoOverturnInfoWindow(paramBoolean);
  }
  
  public void setBelowMaskLayer(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void setDisplayLevel(int paramInt)
  {
    this.G = paramInt;
    this.D.displayLevel(paramInt);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.ad = paramBoolean;
    this.D.draggable(paramBoolean);
    c();
  }
  
  public void setFixingPointEnable(boolean paramBoolean)
  {
    this.I = paramBoolean;
    if (!paramBoolean)
    {
      paramBoolean = this.ap;
      this.X = getPosition();
      setPosition(this.X);
      if (paramBoolean) {
        this.ap = true;
      }
    }
    else if ((this.ap) && (this.X != null))
    {
      FPoint localFPoint = FPoint.obtain();
      this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, localFPoint);
      this.aq = ((int)localFPoint.x);
      this.ar = ((int)localFPoint.y);
      localFPoint.recycle();
    }
  }
  
  public void setFlat(boolean paramBoolean)
    throws RemoteException
  {
    this.q = paramBoolean;
    c();
    this.D.setFlat(paramBoolean);
  }
  
  public void setGeoPoint(IPoint paramIPoint)
  {
    this.ap = false;
    a(paramIPoint.x, paramIPoint.y);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null) {
      try
      {
        if (this.ai == null) {
          return;
        }
        try
        {
          this.j = false;
          this.ai.clear();
          this.ai.add(paramBitmapDescriptor);
          this.J = false;
          this.ak = false;
          this.l = false;
          c();
          this.n = true;
          this.R = paramBitmapDescriptor.getWidth();
          this.S = paramBitmapDescriptor.getHeight();
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramBitmapDescriptor)
      {
        gk.c(paramBitmapDescriptor, "MarkerDelegateImp", "setIcon");
        paramBitmapDescriptor.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  public void setIcons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +76 -> 79
    //   6: aload_0
    //   7: getfield 202	com/amap/api/mapcore/util/ca:ai	Ljava/util/List;
    //   10: ifnonnull +6 -> 16
    //   13: goto +66 -> 79
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 399	com/amap/api/mapcore/util/ca:j	Z
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 901	com/amap/api/mapcore/util/ca:a	(Ljava/util/ArrayList;)V
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 206	com/amap/api/mapcore/util/ca:ak	Z
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 109	com/amap/api/mapcore/util/ca:l	Z
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 158	com/amap/api/mapcore/util/ca:J	Z
    //   41: aload_0
    //   42: invokespecial 350	com/amap/api/mapcore/util/ca:c	()V
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 113	com/amap/api/mapcore/util/ca:n	Z
    //   50: goto +22 -> 72
    //   53: astore_1
    //   54: goto +21 -> 75
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 588
    //   62: ldc_w 902
    //   65: invokestatic 594	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 444	java/lang/Throwable:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ca
    //   0	82	1	paramArrayList	ArrayList<BitmapDescriptor>
    // Exception table:
    //   from	to	target	type
    //   6	13	53	finally
    //   16	50	53	finally
    //   58	72	53	finally
    //   6	13	57	java/lang/Throwable
    //   16	50	57	java/lang/Throwable
  }
  
  public void setInfoWindowEnable(boolean paramBoolean)
  {
    this.F = paramBoolean;
    if (!paramBoolean) {
      hideInfoWindow();
    }
    this.D.infoWindowEnable(paramBoolean);
  }
  
  public void setInfoWindowOffset(int paramInt1, int paramInt2)
    throws RemoteException
  {
    this.r = paramInt1;
    this.s = paramInt2;
  }
  
  public void setInfoWindowShown(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.n = true;
  }
  
  public void setMarkerOptions(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {
      return;
    }
    this.D = paramMarkerOptions;
    this.X = this.D.getPosition();
    paramMarkerOptions = IPoint.obtain();
    this.aj = this.D.isGps();
    if (this.D.getPosition() != null) {
      if (this.aj) {
        try
        {
          double[] arrayOfDouble = ki.a(this.D.getPosition().longitude, this.D.getPosition().latitude);
          this.Y = new LatLng(arrayOfDouble[1], arrayOfDouble[0]);
          GLMapState.lonlat2Geo(arrayOfDouble[0], arrayOfDouble[1], paramMarkerOptions);
        }
        catch (Throwable localThrowable)
        {
          gk.c(localThrowable, "MarkerDelegateImp", "create");
          this.Y = this.D.getPosition();
        }
      } else {
        GLMapState.lonlat2Geo(this.X.longitude, this.X.latitude, paramMarkerOptions);
      }
    }
    this.v = paramMarkerOptions.x;
    this.w = paramMarkerOptions.y;
    this.ab = this.D.getAnchorU();
    this.ac = this.D.getAnchorV();
    this.r = this.D.getInfoWindowOffsetX();
    this.s = this.D.getInfoWindowOffsetY();
    this.ao = this.D.getPeriod();
    this.z = this.D.getZIndex();
    this.K = this.D.isBelowMaskLayer();
    calFPoint();
    setIcons(this.D.getIcons());
    this.j = this.D.isRotatingMode();
    this.k = this.D.getAngleOffset();
    this.ae = this.D.isVisible();
    this.aa = this.D.getSnippet();
    this.Z = this.D.getTitle();
    this.ad = this.D.isDraggable();
    this.W = getId();
    this.ah = this.D.isPerspective();
    this.q = this.D.isFlat();
    this.K = this.D.isBelowMaskLayer();
    this.C = this.D.getAlpha();
    setRotateAngle(this.D.getRotateAngle());
    this.G = this.D.getDisplayLevel();
    this.E = this.D.isInfoWindowAutoOverturn();
    this.F = this.D.isInfoWindowEnable();
    this.a = new float[16];
    this.b = new float[4];
    paramMarkerOptions.recycle();
    dh.a().a(this.X, this.Z, this.aa);
  }
  
  public void setObject(Object paramObject)
  {
    this.ag = paramObject;
  }
  
  public void setOnTap(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public void setPeriod(int paramInt)
  {
    if (paramInt <= 1)
    {
      this.ao = 1;
      return;
    }
    this.ao = paramInt;
  }
  
  public void setPerspective(boolean paramBoolean)
  {
    this.ah = paramBoolean;
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng == null)
    {
      gk.c(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
      return;
    }
    this.X = paramLatLng;
    IPoint localIPoint = IPoint.obtain();
    if (this.aj) {}
    try
    {
      double[] arrayOfDouble = ki.a(paramLatLng.longitude, paramLatLng.latitude);
      this.Y = new LatLng(arrayOfDouble[1], arrayOfDouble[0]);
      GLMapState.lonlat2Geo(arrayOfDouble[0], arrayOfDouble[1], localIPoint);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    this.Y = paramLatLng;
    break label102;
    GLMapState.lonlat2Geo(paramLatLng.longitude, paramLatLng.latitude, localIPoint);
    label102:
    this.v = localIPoint.x;
    this.w = localIPoint.y;
    this.ap = false;
    calFPoint();
    c();
    this.n = true;
    localIPoint.recycle();
  }
  
  public void setPositionByPixels(int paramInt1, int paramInt2)
  {
    this.aq = paramInt1;
    this.ar = paramInt2;
    this.ap = true;
    calFPoint();
    c();
    this.n = true;
  }
  
  public void setPositionNotUpdate(LatLng paramLatLng)
  {
    setPosition(paramLatLng);
  }
  
  public void setRotateAngle(float paramFloat)
  {
    this.D.rotateAngle(paramFloat);
    this.p = paramFloat;
    this.o = ((-paramFloat % 360.0F + 360.0F) % 360.0F);
    this.n = true;
    c();
  }
  
  public void setRotateAngleNotUpdate(float paramFloat) {}
  
  public void setSnippet(String paramString)
  {
    this.aa = paramString;
    c();
    this.D.snippet(paramString);
  }
  
  public void setTitle(String paramString)
  {
    this.Z = paramString;
    c();
    this.D.title(paramString);
    dh.a().a(this.X, this.Z, this.aa);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.ae == paramBoolean) {
      return;
    }
    this.D.visible(paramBoolean);
    this.ae = paramBoolean;
    if (!paramBoolean)
    {
      this.L = false;
      if (isInfoWindowShown()) {
        this.af.b(this);
      }
    }
    c();
  }
  
  public void setZIndex(float paramFloat)
  {
    this.z = paramFloat;
    this.D.zIndex(paramFloat);
    if (this.L == true)
    {
      this.L = false;
      this.af.a();
    }
    this.af.f();
  }
  
  public void showInfoWindow()
  {
    if (!this.ae) {
      return;
    }
    if (!isContains()) {
      return;
    }
    if (isRemoved()) {
      return;
    }
    if (!isInfoWindowEnable()) {
      return;
    }
    this.af.a(this);
    c();
  }
  
  public boolean startAnimation()
  {
    if (this.g != null) {
      synchronized (this.h)
      {
        if ((this.g instanceof GLAnimationSet))
        {
          GLAnimationSet localGLAnimationSet = (GLAnimationSet)this.g;
          Iterator localIterator = localGLAnimationSet.getAnimations().iterator();
          while (localIterator.hasNext())
          {
            GLAnimation localGLAnimation = (GLAnimation)localIterator.next();
            a(localGLAnimation);
            localGLAnimation.setDuration(localGLAnimationSet.getDuration());
          }
        }
        a(this.g);
        this.M = false;
        this.f = this.g;
        this.al = true;
        this.f.start();
        c();
        return false;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */