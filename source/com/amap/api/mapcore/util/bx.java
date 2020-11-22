package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IglModel;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.util.Iterator;
import java.util.List;

public class bx
  extends BaseOverlayImp
  implements IglModel
{
  private boolean A;
  private boolean B;
  private FPoint C;
  private int D;
  private int E;
  private float F;
  private float G;
  private String H;
  private String I;
  private float J;
  float[] a;
  float[] b;
  Rect c;
  float d;
  private boolean e;
  private String f;
  private float[] g;
  private ln h;
  private BitmapDescriptor i;
  private IAMapDelegate j;
  private int k;
  private int l;
  private LatLng m;
  private GLAnimation n;
  private boolean o;
  private boolean p;
  private Bitmap q;
  private cl.b r;
  private float s;
  private Object t;
  private float u;
  private float v;
  private float w;
  private boolean x;
  private ll y;
  private int z;
  
  public bx(ll paramll, GL3DModelOptions paramGL3DModelOptions, IAMapDelegate paramIAMapDelegate)
  {
    int i2 = 1;
    this.e = true;
    this.g = new float[16];
    this.o = true;
    this.p = true;
    this.u = 18.0F;
    this.v = -1.0F;
    this.w = 0.0F;
    this.x = false;
    this.A = false;
    this.B = false;
    this.C = FPoint.obtain();
    this.a = new float[16];
    this.b = new float[16];
    this.c = new Rect(0, 0, 0, 0);
    this.D = 0;
    this.E = 0;
    this.F = 0.5F;
    this.G = 0.5F;
    this.d = 1.0F;
    this.J = -1.0F;
    if (paramGL3DModelOptions != null)
    {
      if (paramIAMapDelegate == null) {
        return;
      }
      this.y = paramll;
      this.j = paramIAMapDelegate;
      this.i = paramGL3DModelOptions.getBitmapDescriptor();
      paramll = paramGL3DModelOptions.getTextrue();
      paramIAMapDelegate = paramGL3DModelOptions.getVertext();
      this.m = paramGL3DModelOptions.getLatLng();
      this.s = paramGL3DModelOptions.getAngle();
      setModelFixedLength(paramGL3DModelOptions.getModelFixedLength());
      if (this.m != null)
      {
        paramGL3DModelOptions = IPoint.obtain();
        GLMapState.lonlat2Geo(this.m.longitude, this.m.latitude, paramGL3DModelOptions);
        this.k = paramGL3DModelOptions.x;
        this.l = paramGL3DModelOptions.y;
      }
      if ((paramll != null) && (paramll.size() > 0) && (paramIAMapDelegate != null))
      {
        int i1;
        if (paramIAMapDelegate.size() > 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (this.i == null) {
          i2 = 0;
        }
        if ((i1 & i2) != 0)
        {
          this.h = new ln(paramIAMapDelegate, paramll);
          this.h.a(this.s);
        }
      }
      this.a = new float[16];
      this.b = new float[4];
      return;
    }
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.q = paramBitmap;
    }
    paramBitmap = new int[1];
    GLES20.glGenTextures(1, paramBitmap, 0);
    GLES20.glBindTexture(3553, paramBitmap[0]);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLUtils.texImage2D(3553, 0, this.q, 0);
    return paramBitmap[0];
  }
  
  private void a(GLAnimation paramGLAnimation)
  {
    if ((paramGLAnimation instanceof GLTranslateAnimation))
    {
      paramGLAnimation = (GLTranslateAnimation)paramGLAnimation;
      paramGLAnimation.mFromXDelta = this.k;
      paramGLAnimation.mFromYDelta = this.l;
      IPoint localIPoint = IPoint.obtain();
      GLMapState.lonlat2Geo(paramGLAnimation.mToXDelta, paramGLAnimation.mToYDelta, localIPoint);
      paramGLAnimation.mToXDelta = localIPoint.x;
      paramGLAnimation.mToYDelta = localIPoint.y;
      localIPoint.recycle();
    }
  }
  
  private float b()
  {
    float f1 = this.j.getMapConfig().getMapPerPixelUnitLength();
    if (this.j.getMapConfig().getSZ() >= this.u)
    {
      this.J = f1;
      return f1 / this.J;
    }
    return f1 / this.v;
  }
  
  private float c()
  {
    float f1 = this.w;
    return this.j.getMapConfig().getMapPerPixelUnitLength() * f1 / this.h.a();
  }
  
  private void d()
  {
    if ((!this.o) && (this.n != null) && (!this.n.hasEnded()))
    {
      e();
      GLTransformation localGLTransformation = new GLTransformation();
      this.n.getTransformation(AnimationUtils.currentAnimationTimeMillis(), localGLTransformation);
      if ((!Double.isNaN(localGLTransformation.x)) && (!Double.isNaN(localGLTransformation.y)))
      {
        double d1 = localGLTransformation.x;
        double d2 = localGLTransformation.y;
        this.k = ((int)d1);
        this.l = ((int)d2);
      }
    }
    else
    {
      this.o = true;
    }
  }
  
  private void e()
  {
    if (this.j != null) {
      this.j.setRunLowFrame(false);
    }
  }
  
  public void a()
  {
    try
    {
      if (this.h != null)
      {
        if (this.r == null) {
          this.r = ((cl.b)this.j.getGLShader(5));
        }
        if (this.v == -1.0F) {
          this.v = this.j.getUnitLengthByZoom((int)this.u);
        }
        if (this.e)
        {
          this.z = a(this.i.getBitmap());
          this.h.a(this.z);
          this.e = false;
        }
        d();
        int i1 = this.k;
        int i2 = (int)this.j.getMapConfig().getSX();
        FPoint localFPoint = this.C;
        float f1 = i1 - i2;
        localFPoint.x = f1;
        i1 = this.l;
        i2 = (int)this.j.getMapConfig().getSY();
        localFPoint = this.C;
        float f2 = i1 - i2;
        localFPoint.y = f2;
        Matrix.setIdentityM(this.g, 0);
        Matrix.multiplyMM(this.g, 0, this.j.getProjectionMatrix(), 0, this.j.getViewMatrix(), 0);
        Matrix.translateM(this.g, 0, f1, f2, 0.0F);
        if (this.x) {
          this.d = c();
        } else {
          this.d = b();
        }
        Matrix.scaleM(this.g, 0, this.d, this.d, this.d);
        this.h.a(this.r, this.g);
        if (this.B)
        {
          this.j.redrawInfoWindow();
          this.B = false;
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean checkInBounds()
  {
    return this.j.getMapConfig().getGeoRectangle().contains(this.k, this.l);
  }
  
  public void destroy()
  {
    if (this.q != null) {
      this.q.recycle();
    }
    this.y.a(this.z);
    this.h.c();
  }
  
  public IPoint getAnchor()
  {
    return null;
  }
  
  public BitmapDescriptor getBitmapDescriptor()
  {
    return this.i;
  }
  
  public int getHeight()
  {
    float f1 = this.j.getMapConfig().getMapPerPixelUnitLength();
    return (int)(this.h.a() * this.d / f1);
  }
  
  public String getId()
  {
    return this.f;
  }
  
  public int getInfoWindowOffsetX()
  {
    return 0;
  }
  
  public int getInfoWindowOffsetY()
  {
    return 0;
  }
  
  public FPoint getMapPosition()
  {
    return this.C;
  }
  
  public Object getObject()
  {
    return this.t;
  }
  
  public LatLng getPosition()
  {
    return this.m;
  }
  
  public int getRealInfoWindowOffsetX()
  {
    return this.D;
  }
  
  public int getRealInfoWindowOffsetY()
  {
    return this.E;
  }
  
  public LatLng getRealPosition()
  {
    return null;
  }
  
  public Rect getRect()
  {
    try
    {
      Object localObject2 = this.j.getMapProjection();
      int i1 = getWidth();
      int i2 = getHeight();
      Object localObject1 = FPoint.obtain();
      ((GLMapState)localObject2).p20ToScreenPoint(this.k, this.l, (FPoint)localObject1);
      Matrix.setIdentityM(this.a, 0);
      Matrix.rotateM(this.a, 0, -this.s, 0.0F, 0.0F, 1.0F);
      Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSC(), 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSR(), 0.0F, 0.0F, 1.0F);
      localObject2 = new float[4];
      float[] arrayOfFloat = this.b;
      float f1 = -i1;
      arrayOfFloat[0] = (this.F * f1);
      arrayOfFloat = this.b;
      float f2 = i2;
      arrayOfFloat[1] = (this.G * f2);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.set((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]), (int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      arrayOfFloat = this.b;
      float f3 = i1;
      arrayOfFloat[0] = ((1.0F - this.F) * f3);
      this.b[1] = (f2 * this.G);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.b[0] = (f3 * (1.0F - this.F));
      arrayOfFloat = this.b;
      f2 = -i2;
      arrayOfFloat[1] = ((1.0F - this.G) * f2);
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.b[0] = (f1 * this.F);
      this.b[1] = (f2 * (1.0F - this.G));
      this.b[2] = 0.0F;
      this.b[3] = 1.0F;
      Matrix.multiplyMV((float[])localObject2, 0, this.a, 0, this.b, 0);
      this.c.union((int)(((FPoint)localObject1).x + localObject2[0]), (int)(((FPoint)localObject1).y - localObject2[1]));
      this.D = (this.c.centerX() - (int)((FPoint)localObject1).x);
      this.E = (this.c.top - (int)((FPoint)localObject1).y);
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
    return 0.0F;
  }
  
  public String getSnippet()
  {
    return this.H;
  }
  
  public String getTitle()
  {
    return this.I;
  }
  
  public int getWidth()
  {
    float f1 = this.j.getMapConfig().getMapPerPixelUnitLength();
    return (int)(this.h.b() * this.d / f1);
  }
  
  public boolean isContains()
  {
    return this.y.a(this);
  }
  
  public boolean isDestory()
  {
    return false;
  }
  
  public boolean isInfoWindowEnable()
  {
    return true;
  }
  
  public boolean isViewMode()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return this.p;
  }
  
  public boolean remove()
  {
    if (this.j != null) {
      this.j.removeGLModel(this.f);
    }
    return true;
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    if (paramAnimation == null) {
      return;
    }
    this.n = paramAnimation.glAnimation;
  }
  
  public void setGeoPoint(IPoint paramIPoint)
  {
    if (paramIPoint != null)
    {
      this.k = paramIPoint.x;
      this.l = paramIPoint.y;
      paramIPoint = DPoint.obtain();
      GLMapState.geo2LonLat(this.k, this.l, paramIPoint);
      this.m = new LatLng(paramIPoint.y, paramIPoint.x, false);
      paramIPoint.recycle();
    }
    this.j.setRunLowFrame(false);
  }
  
  public void setInfoWindowOffset(int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void setInfoWindowShown(boolean paramBoolean)
  {
    this.A = paramBoolean;
    this.B = true;
  }
  
  public void setModelFixedLength(int paramInt)
  {
    if (paramInt > 0)
    {
      this.w = paramInt;
      this.x = true;
      return;
    }
    this.w = 0.0F;
    this.x = false;
  }
  
  public void setObject(Object paramObject)
  {
    this.t = paramObject;
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.m = paramLatLng;
      IPoint localIPoint = IPoint.obtain();
      GLMapState.lonlat2Geo(paramLatLng.longitude, paramLatLng.latitude, localIPoint);
      this.k = localIPoint.x;
      this.l = localIPoint.y;
      localIPoint.recycle();
    }
    this.B = true;
    this.j.setRunLowFrame(false);
  }
  
  public void setRotateAngle(float paramFloat)
  {
    this.s = paramFloat;
    if (this.h != null)
    {
      paramFloat = this.j.getMapConfig().getSR();
      this.h.a(this.s - paramFloat);
    }
    this.B = true;
  }
  
  public void setSnippet(String paramString)
  {
    this.H = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.I = paramString;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setZoomLimit(float paramFloat)
  {
    this.u = paramFloat;
    this.v = this.j.getUnitLengthByZoom((int)this.u);
  }
  
  public void showInfoWindow()
  {
    try
    {
      this.j.showInfoWindow(this);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public boolean startAnimation()
  {
    if (this.n != null)
    {
      if ((this.n instanceof GLAnimationSet))
      {
        GLAnimationSet localGLAnimationSet = (GLAnimationSet)this.n;
        Iterator localIterator = localGLAnimationSet.getAnimations().iterator();
        while (localIterator.hasNext())
        {
          GLAnimation localGLAnimation = (GLAnimation)localIterator.next();
          a(localGLAnimation);
          localGLAnimation.setDuration(localGLAnimationSet.getDuration());
        }
      }
      a(this.n);
      this.o = false;
      this.n.start();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */