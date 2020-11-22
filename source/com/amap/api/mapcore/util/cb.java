package com.amap.api.mapcore.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;

public class cb
{
  a a = null;
  ValueAnimator b;
  Animator.AnimatorListener c = new Animator.AnimatorListener()
  {
    public void onAnimationCancel(Animator paramAnonymousAnimator) {}
    
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      cb.a(cb.this);
    }
    
    public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
    
    public void onAnimationStart(Animator paramAnonymousAnimator) {}
  };
  ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener()
  {
    public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
    {
      try
      {
        if (cb.b(cb.this) != null)
        {
          paramAnonymousValueAnimator = (LatLng)paramAnonymousValueAnimator.getAnimatedValue();
          cb.b(cb.this).setCenter(paramAnonymousValueAnimator);
          cb.c(cb.this).setPosition(paramAnonymousValueAnimator);
          return;
        }
      }
      catch (Throwable paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator.printStackTrace();
      }
    }
  };
  private IAMapDelegate e;
  private Marker f;
  private Circle g;
  private MyLocationStyle h = new MyLocationStyle();
  private LatLng i;
  private double j;
  private Context k;
  private b l;
  private int m = 4;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  
  public cb(IAMapDelegate paramIAMapDelegate, Context paramContext)
  {
    this.k = paramContext.getApplicationContext();
    this.e = paramIAMapDelegate;
    this.l = new b(this.k, paramIAMapDelegate);
    a(4, true);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.m = paramInt;
    this.n = false;
    this.p = false;
    this.o = false;
    this.r = false;
    this.s = false;
    switch (this.m)
    {
    default: 
      break;
    case 7: 
      this.s = true;
      break;
    case 5: 
      this.r = true;
      break;
    case 4: 
      this.o = true;
      this.r = true;
      break;
    case 3: 
      this.o = true;
      this.s = true;
      break;
    case 2: 
      this.o = true;
      this.q = true;
      break;
    case 1: 
      this.o = true;
      this.p = true;
      this.q = true;
    }
    if ((!this.r) && (!this.s))
    {
      if (this.f != null) {
        this.f.setFlat(false);
      }
      i();
      h();
      g();
      return;
    }
    if (this.s)
    {
      this.l.a(true);
      if (!paramBoolean) {
        try
        {
          this.e.moveCamera(k.a(17.0F));
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      b(45.0F);
    }
    else
    {
      this.l.a(false);
    }
    this.l.a();
    if (this.f != null) {
      this.f.setFlat(true);
    }
  }
  
  private void a(LatLng paramLatLng)
  {
    LatLng localLatLng2 = this.f.getPosition();
    LatLng localLatLng1 = localLatLng2;
    if (localLatLng2 == null) {
      localLatLng1 = new LatLng(0.0D, 0.0D);
    }
    if (this.a == null) {
      this.a = new a();
    }
    if (this.b == null)
    {
      this.b = ValueAnimator.ofObject(new a(), new Object[] { localLatLng1, paramLatLng });
      this.b.addListener(this.c);
      this.b.addUpdateListener(this.d);
    }
    else
    {
      this.b.setObjectValues(new Object[] { localLatLng1, paramLatLng });
      this.b.setEvaluator(this.a);
    }
    if ((localLatLng1.latitude == 0.0D) && (localLatLng1.longitude == 0.0D)) {
      this.b.setDuration(1L);
    } else {
      this.b.setDuration(1000L);
    }
    this.b.start();
  }
  
  private void b(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    try
    {
      this.e.moveCamera(k.c(paramFloat));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    try
    {
      this.e.moveCamera(k.d(paramFloat));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void d(float paramFloat)
  {
    if (!this.q) {
      return;
    }
    float f1 = paramFloat % 360.0F;
    if (f1 > 180.0F)
    {
      paramFloat = f1 - 360.0F;
    }
    else
    {
      paramFloat = f1;
      if (f1 < -180.0F) {
        paramFloat = f1 + 360.0F;
      }
    }
    if (this.f != null) {
      this.f.setRotateAngle(-paramFloat);
    }
  }
  
  private void g()
  {
    this.l.b();
  }
  
  private void h()
  {
    b(0.0F);
  }
  
  private void i()
  {
    c(0.0F);
  }
  
  private void j()
  {
    if (this.i == null) {
      return;
    }
    if (!this.o) {
      return;
    }
    if ((this.p) && (this.n)) {
      return;
    }
    this.n = true;
    try
    {
      IPoint localIPoint = IPoint.obtain();
      GLMapState.lonlat2Geo(this.i.longitude, this.i.latitude, localIPoint);
      this.e.animateCamera(k.a(localIPoint));
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MyLocationOverlay", "moveMapToLocation");
      localThrowable.printStackTrace();
    }
  }
  
  private void k()
  {
    if (this.h == null)
    {
      this.h = new MyLocationStyle();
      this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
      m();
      return;
    }
    if ((this.h.getMyLocationIcon() == null) || (this.h.getMyLocationIcon().getBitmap() == null)) {
      this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
    }
    m();
  }
  
  private void l()
  {
    if (this.g != null)
    {
      try
      {
        this.e.removeGLOverlay(this.g.getId());
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "MyLocationOverlay", "locationIconRemove");
        localThrowable.printStackTrace();
      }
      this.g = null;
    }
    if (this.f != null)
    {
      this.f.remove();
      this.f = null;
      this.l.a(null);
    }
  }
  
  private void m()
  {
    try
    {
      if (this.g == null) {
        this.g = this.e.addCircle(new CircleOptions().zIndex(1.0F));
      }
      if (this.g != null)
      {
        if (this.g.getStrokeWidth() != this.h.getStrokeWidth()) {
          this.g.setStrokeWidth(this.h.getStrokeWidth());
        }
        if (this.g.getFillColor() != this.h.getRadiusFillColor()) {
          this.g.setFillColor(this.h.getRadiusFillColor());
        }
        if (this.g.getStrokeColor() != this.h.getStrokeColor()) {
          this.g.setStrokeColor(this.h.getStrokeColor());
        }
        if (this.i != null) {
          this.g.setCenter(this.i);
        }
        this.g.setRadius(this.j);
        this.g.setVisible(true);
      }
      if (this.f == null) {
        this.f = this.e.addMarker(new MarkerOptions().visible(false));
      }
      if (this.f != null)
      {
        if ((this.f.getAnchorU() != this.h.getAnchorU()) || (this.f.getAnchorV() != this.h.getAnchorV())) {
          this.f.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
        }
        if ((this.f.getIcons() != null) && (this.f.getIcons().size() != 0))
        {
          if ((this.h.getMyLocationIcon() != null) && (!((BitmapDescriptor)this.f.getIcons().get(0)).equals(this.h.getMyLocationIcon()))) {
            this.f.setIcon(this.h.getMyLocationIcon());
          }
        }
        else {
          this.f.setIcon(this.h.getMyLocationIcon());
        }
        if (this.i != null)
        {
          this.f.setPosition(this.i);
          this.f.setVisible(true);
        }
      }
      j();
      this.l.a(this.f);
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MyLocationOverlay", "myLocStyle");
      localThrowable.printStackTrace();
    }
  }
  
  public MyLocationStyle a()
  {
    return this.h;
  }
  
  public void a(float paramFloat)
  {
    if (this.f != null) {
      this.f.setRotateAngle(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    a(this.h.isMyLocationShowing());
    if (!this.h.isMyLocationShowing()) {
      return;
    }
    this.i = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    this.j = paramLocation.getAccuracy();
    if ((this.f == null) && (this.g == null)) {
      k();
    }
    if (this.g != null) {
      try
      {
        if (this.j != -1.0D) {
          this.g.setRadius(this.j);
        }
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "MyLocationOverlay", "setCentAndRadius");
        localThrowable.printStackTrace();
      }
    }
    d(paramLocation.getBearing());
    if (!this.i.equals(this.f.getPosition()))
    {
      a(this.i);
      return;
    }
    j();
  }
  
  public void a(MyLocationStyle paramMyLocationStyle)
  {
    try
    {
      this.h = paramMyLocationStyle;
      a(this.h.isMyLocationShowing());
      if (!this.h.isMyLocationShowing())
      {
        this.l.a(false);
        this.m = this.h.getMyLocationType();
        return;
      }
      k();
      if ((this.f == null) && (this.g == null)) {
        return;
      }
      this.l.a(this.f);
      a(this.h.getMyLocationType());
      return;
    }
    catch (Throwable paramMyLocationStyle)
    {
      gk.c(paramMyLocationStyle, "MyLocationOverlay", "setMyLocationStyle");
      paramMyLocationStyle.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.g != null) && (this.g.isVisible() != paramBoolean)) {
      this.g.setVisible(paramBoolean);
    }
    if ((this.f != null) && (this.f.isVisible() != paramBoolean)) {
      this.f.setVisible(paramBoolean);
    }
  }
  
  public void b()
  {
    if ((this.m == 3) && (this.l != null)) {
      this.l.a();
    }
  }
  
  public void c()
    throws RemoteException
  {
    l();
    if (this.l != null)
    {
      g();
      this.l = null;
    }
  }
  
  public String d()
  {
    if (this.f != null) {
      return this.f.getId();
    }
    return null;
  }
  
  public String e()
    throws RemoteException
  {
    if (this.g != null) {
      return this.g.getId();
    }
    return null;
  }
  
  public void f()
  {
    this.g = null;
    this.f = null;
  }
  
  public static class a
    implements TypeEvaluator
  {
    public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      paramObject1 = (LatLng)paramObject1;
      paramObject2 = (LatLng)paramObject2;
      double d1 = ((LatLng)paramObject1).latitude;
      double d2 = paramFloat;
      double d3 = ((LatLng)paramObject2).latitude;
      double d4 = ((LatLng)paramObject1).latitude;
      Double.isNaN(d2);
      double d5 = ((LatLng)paramObject1).longitude;
      double d6 = ((LatLng)paramObject2).longitude;
      double d7 = ((LatLng)paramObject1).longitude;
      Double.isNaN(d2);
      return new LatLng(d1 + (d3 - d4) * d2, d5 + d2 * (d6 - d7));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */