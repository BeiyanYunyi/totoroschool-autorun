package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITextDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ci
  implements ITextDelegate
{
  private static int a;
  private int A;
  private boolean B = false;
  private List<lu> C = new ArrayList();
  private boolean D = false;
  private boolean E = false;
  private float[] F = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private float b = 0.0F;
  private float c = 0.0F;
  private int d = 4;
  private int e = 32;
  private FPoint f = FPoint.obtain();
  private int g;
  private BitmapDescriptor h;
  private int i;
  private int j;
  private String k;
  private LatLng l;
  private float m = 0.5F;
  private float n = 1.0F;
  private boolean o = true;
  private lr p;
  private Object q;
  private String r;
  private int s;
  private int t;
  private int u;
  private Typeface v;
  private float w;
  private Rect x = new Rect();
  private Paint y = new Paint();
  private int z;
  
  public ci(TextOptions paramTextOptions, lr paramlr)
    throws RemoteException
  {
    this.p = paramlr;
    if (paramTextOptions.getPosition() != null) {
      this.l = paramTextOptions.getPosition();
    }
    setAlign(paramTextOptions.getAlignX(), paramTextOptions.getAlignY());
    this.o = paramTextOptions.isVisible();
    this.r = paramTextOptions.getText();
    this.s = paramTextOptions.getBackgroundColor();
    this.t = paramTextOptions.getFontColor();
    this.u = paramTextOptions.getFontSize();
    this.q = paramTextOptions.getObject();
    this.w = paramTextOptions.getZIndex();
    this.v = paramTextOptions.getTypeface();
    this.k = getId();
    setRotateAngle(paramTextOptions.getRotate());
    a();
    calFPoint();
  }
  
  private int a(boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    c();
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.p.c().getTextureItem(paramBitmapDescriptor);
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
        i1 = d();
        ((lu)localObject2).a(i1);
        if (paramBoolean) {
          this.p.c().addTextureItem((lu)localObject2);
        }
        a((lu)localObject2);
        dx.b(i1, paramBitmapDescriptor, true);
      }
    }
    return i1;
  }
  
  private static String a(String paramString)
  {
    a += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(a);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.r != null)
    {
      if (this.r.trim().length() <= 0) {
        return;
      }
      try
      {
        this.y.setTypeface(this.v);
        this.y.setSubpixelText(true);
        this.y.setAntiAlias(true);
        this.y.setStrokeWidth(5.0F);
        this.y.setStrokeCap(Paint.Cap.ROUND);
        this.y.setTextSize(this.u);
        this.y.setTextAlign(Paint.Align.CENTER);
        this.y.setColor(this.t);
        Object localObject = this.y.getFontMetrics();
        int i1 = (int)(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
        int i2 = (int)((i1 - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
        this.y.getTextBounds(this.r, 0, this.r.length(), this.x);
        localObject = Bitmap.createBitmap(this.x.width() + 6, i1, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        localCanvas.drawColor(this.s);
        localCanvas.drawText(this.r, this.x.centerX() + 3, i2, this.y);
        this.h = BitmapDescriptorFactory.fromBitmap((Bitmap)localObject);
        this.i = this.h.getWidth();
        this.j = this.h.getHeight();
        return;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "TextDelegateImp", "initBitmap");
        return;
      }
    }
  }
  
  private void a(lu paramlu)
  {
    if (paramlu != null)
    {
      this.C.add(paramlu);
      paramlu.l();
    }
  }
  
  private void a(IAMapDelegate paramIAMapDelegate, float[] paramArrayOfFloat, int paramInt, float paramFloat)
    throws RemoteException
  {
    float f1 = this.i * paramFloat;
    paramFloat *= this.j;
    float f2 = this.f.x;
    float f3 = this.f.y;
    float f4 = paramIAMapDelegate.getMapConfig().getSC();
    this.F[0] = (f2 - this.m * f1);
    this.F[1] = ((1.0F - this.n) * paramFloat + f3);
    this.F[2] = f2;
    this.F[3] = f3;
    this.F[6] = this.b;
    this.F[7] = f4;
    this.F[9] = ((1.0F - this.m) * f1 + f2);
    this.F[10] = ((1.0F - this.n) * paramFloat + f3);
    this.F[11] = f2;
    this.F[12] = f3;
    this.F[15] = this.b;
    this.F[16] = f4;
    this.F[18] = ((1.0F - this.m) * f1 + f2);
    this.F[19] = (f3 - this.n * paramFloat);
    this.F[20] = f2;
    this.F[21] = f3;
    this.F[24] = this.b;
    this.F[25] = f4;
    this.F[27] = (f2 - f1 * this.m);
    this.F[28] = (f3 - paramFloat * this.n);
    this.F[29] = f2;
    this.F[30] = f3;
    this.F[33] = this.b;
    this.F[34] = f4;
    System.arraycopy(this.F, 0, paramArrayOfFloat, paramInt, this.F.length);
  }
  
  private void b()
  {
    if (this.p.c() != null) {
      this.p.c().setRunLowFrame(false);
    }
  }
  
  private void c()
  {
    if (this.C != null)
    {
      Iterator localIterator = this.C.iterator();
      while (localIterator.hasNext())
      {
        lu locallu = (lu)localIterator.next();
        if ((locallu != null) && (this.p != null)) {
          this.p.a(locallu);
        }
      }
      this.C.clear();
    }
  }
  
  private int d()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  private void e()
  {
    try
    {
      a();
      this.E = false;
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean calFPoint()
  {
    if (this.l == null) {
      return false;
    }
    IPoint localIPoint = IPoint.obtain();
    GLMapState.lonlat2Geo(this.l.longitude, this.l.latitude, localIPoint);
    this.z = localIPoint.x;
    this.A = localIPoint.y;
    this.p.c().getLatLng2Map(this.l.latitude, this.l.longitude, this.f);
    localIPoint.recycle();
    return true;
  }
  
  public boolean checkInBounds()
  {
    Rectangle localRectangle = this.p.c().getMapConfig().getGeoRectangle();
    return (localRectangle != null) && (localRectangle.contains(this.z, this.A));
  }
  
  public void destroy(boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      try
      {
        this.D = true;
        if (paramBoolean) {
          remove();
        }
        if ((this.C != null) && (this.C.size() > 0))
        {
          i1 = 0;
          if (i1 < this.C.size())
          {
            lu locallu = (lu)this.C.get(i1);
            if ((locallu != null) && (this.p != null))
            {
              this.p.a(locallu);
              if (this.p.c() != null) {
                this.p.c().removeTextureItem(locallu.o());
              }
            }
          }
          else
          {
            this.C.clear();
          }
        }
        else
        {
          if (this.h != null)
          {
            this.h.recycle();
            this.h = null;
          }
          this.l = null;
          this.q = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "TextDelegateImp", "destroy");
        localThrowable.printStackTrace();
        Log.d("destroy erro", "TextDelegateImp destroy");
        return;
      }
      i1 += 1;
    }
  }
  
  public void drawMarker(IAMapDelegate paramIAMapDelegate) {}
  
  public void drawMarker(IAMapDelegate paramIAMapDelegate, float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    if ((this.o) && (!this.D) && (this.l != null))
    {
      if (this.h == null) {
        return;
      }
      this.f.x = (this.z - (int)paramIAMapDelegate.getMapConfig().getSX());
      this.f.y = (this.A - (int)paramIAMapDelegate.getMapConfig().getSY());
      try
      {
        a(paramIAMapDelegate, paramArrayOfFloat, paramInt, paramFloat);
        return;
      }
      catch (Throwable paramIAMapDelegate)
      {
        gk.c(paramIAMapDelegate, "TextDelegateImp", "drawMarker");
        return;
      }
    }
  }
  
  public boolean equalsRemote(IOverlayImage paramIOverlayImage)
    throws RemoteException
  {
    return (equals(paramIOverlayImage)) || (paramIOverlayImage.getId().equals(getId()));
  }
  
  public int getAlignX()
    throws RemoteException
  {
    return this.d;
  }
  
  public int getAlignY()
  {
    return this.e;
  }
  
  public float getAnchorU()
  {
    return this.m;
  }
  
  public float getAnchorV()
  {
    return this.n;
  }
  
  public int getBackgroundColor()
    throws RemoteException
  {
    return this.s;
  }
  
  public int getFontColor()
    throws RemoteException
  {
    return this.t;
  }
  
  public int getFontSize()
    throws RemoteException
  {
    return this.u;
  }
  
  public IAnimation getIAnimation()
  {
    return null;
  }
  
  public IMarkerAction getIMarkerAction()
  {
    return null;
  }
  
  public String getId()
  {
    if (this.k == null) {
      this.k = a("Text");
    }
    return this.k;
  }
  
  public Object getObject()
  {
    return this.q;
  }
  
  public LatLng getPosition()
  {
    return this.l;
  }
  
  public Rect getRect()
  {
    return null;
  }
  
  public float getRotateAngle()
  {
    return this.c;
  }
  
  public String getText()
    throws RemoteException
  {
    return this.r;
  }
  
  public int getTextureId()
  {
    try
    {
      int i1 = this.g;
      return i1;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public Typeface getTypeface()
    throws RemoteException
  {
    return this.v;
  }
  
  public float getZIndex()
  {
    return this.w;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public boolean isAllowLow()
  {
    return true;
  }
  
  public boolean isBelowMaskLayer()
  {
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    return false;
  }
  
  public boolean isOnTap()
  {
    return this.B;
  }
  
  public boolean isVisible()
  {
    return this.o;
  }
  
  public void loadTexture(IAMapDelegate paramIAMapDelegate)
  {
    if (!this.E) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 12) {
          break label56;
        }
        bool = true;
        this.g = a(bool, this.h);
        this.E = true;
        return;
      }
      catch (Throwable paramIAMapDelegate)
      {
        gk.c(paramIAMapDelegate, "TextDelegateImp", "loadtexture");
        paramIAMapDelegate.printStackTrace();
        return;
      }
      return;
      label56:
      boolean bool = false;
    }
  }
  
  public void reLoadTexture()
  {
    this.E = false;
    this.g = 0;
    a();
  }
  
  public boolean remove()
  {
    try
    {
      b();
      this.o = false;
      boolean bool = this.p.a(this);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setAlign(int paramInt1, int paramInt2)
    throws RemoteException
  {
    this.d = paramInt1;
    if (paramInt1 != 4) {
      switch (paramInt1)
      {
      default: 
        this.m = 0.5F;
        break;
      case 2: 
        this.m = 1.0F;
        break;
      case 1: 
        this.m = 0.0F;
        break;
      }
    } else {
      this.m = 0.5F;
    }
    this.e = paramInt2;
    if (paramInt2 != 8)
    {
      if (paramInt2 != 16)
      {
        if (paramInt2 != 32) {
          this.n = 0.5F;
        } else {
          this.n = 0.5F;
        }
      }
      else {
        this.n = 1.0F;
      }
    }
    else {
      this.n = 0.0F;
    }
    b();
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2) {}
  
  public void setBackgroundColor(int paramInt)
    throws RemoteException
  {
    this.s = paramInt;
    e();
  }
  
  public void setFontColor(int paramInt)
    throws RemoteException
  {
    this.t = paramInt;
    e();
  }
  
  public void setFontSize(int paramInt)
    throws RemoteException
  {
    this.u = paramInt;
    e();
  }
  
  public void setObject(Object paramObject)
  {
    this.q = paramObject;
  }
  
  public void setOnTap(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    this.l = paramLatLng;
    calFPoint();
    b();
  }
  
  public void setRotateAngle(float paramFloat)
  {
    this.c = paramFloat;
    this.b = ((-paramFloat % 360.0F + 360.0F) % 360.0F);
    b();
  }
  
  public void setText(String paramString)
    throws RemoteException
  {
    this.r = paramString;
    e();
  }
  
  public void setTypeface(Typeface paramTypeface)
    throws RemoteException
  {
    this.v = paramTypeface;
    e();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.o == paramBoolean) {
      return;
    }
    this.o = paramBoolean;
    b();
  }
  
  public void setZIndex(float paramFloat)
  {
    this.w = paramFloat;
    this.p.f();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */