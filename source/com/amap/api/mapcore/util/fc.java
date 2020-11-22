package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class fc
  extends LinearLayout
{
  Bitmap a;
  Bitmap b;
  Bitmap c;
  Bitmap d;
  Bitmap e;
  Bitmap f;
  ImageView g;
  IAMapDelegate h;
  boolean i = false;
  
  @SuppressLint({"ClickableViewAccessibility"})
  public fc(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    super(paramContext);
    this.h = paramIAMapDelegate;
    try
    {
      this.d = dx.a(paramContext, "location_selected.png");
      this.a = dx.a(this.d, lk.a);
      this.e = dx.a(paramContext, "location_pressed.png");
      this.b = dx.a(this.e, lk.a);
      this.f = dx.a(paramContext, "location_unselected.png");
      this.c = dx.a(this.f, lk.a);
      this.g = new ImageView(paramContext);
      this.g.setImageBitmap(this.a);
      this.g.setClickable(true);
      this.g.setPadding(0, 20, 20, 0);
      this.g.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (!fc.this.i) {
            return false;
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            fc.this.g.setImageBitmap(fc.this.b);
            return false;
          }
          if (paramAnonymousMotionEvent.getAction() == 1) {
            try
            {
              fc.this.g.setImageBitmap(fc.this.a);
              fc.this.h.setMyLocationEnabled(true);
              paramAnonymousView = fc.this.h.getMyLocation();
              if (paramAnonymousView == null) {
                return false;
              }
              paramAnonymousMotionEvent = new LatLng(paramAnonymousView.getLatitude(), paramAnonymousView.getLongitude());
              fc.this.h.showMyLocationOverlay(paramAnonymousView);
              fc.this.h.moveCamera(k.a(paramAnonymousMotionEvent, fc.this.h.getZoomLevel()));
              return false;
            }
            catch (Throwable paramAnonymousView)
            {
              gk.c(paramAnonymousView, "LocationView", "onTouch");
              paramAnonymousView.printStackTrace();
            }
          }
          return false;
        }
      });
      addView(this.g);
      return;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "LocationView", "create");
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    try
    {
      removeAllViews();
      if (this.a != null) {
        this.a.recycle();
      }
      if (this.b != null) {
        this.b.recycle();
      }
      if (this.b != null) {
        this.c.recycle();
      }
      this.a = null;
      this.b = null;
      this.c = null;
      if (this.d != null)
      {
        this.d.recycle();
        this.d = null;
      }
      if (this.e != null)
      {
        this.e.recycle();
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.recycle();
        this.f = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "LocationView", "destroy");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (paramBoolean) {}
    try
    {
      this.g.setImageBitmap(this.a);
      break label34;
      this.g.setImageBitmap(this.c);
      label34:
      this.g.invalidate();
      return;
    }
    catch (Throwable localThrowable2)
    {
      Throwable localThrowable1;
      for (;;) {}
    }
    gk.c(localThrowable1, "LocationView", "showSelect");
    localThrowable1.printStackTrace();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */