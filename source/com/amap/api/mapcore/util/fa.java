package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class fa
  extends LinearLayout
{
  Bitmap a;
  Bitmap b;
  Bitmap c;
  ImageView d;
  IAMapDelegate e;
  Matrix f = new Matrix();
  
  public fa(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    super(paramContext);
    this.e = paramIAMapDelegate;
    try
    {
      this.c = dx.a(paramContext, "maps_dav_compass_needle_large.png");
      this.b = dx.a(this.c, lk.a * 0.8F);
      this.c = dx.a(this.c, lk.a * 0.7F);
      if (this.b != null)
      {
        if (this.c == null) {
          return;
        }
        this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
        paramIAMapDelegate = new Canvas(this.a);
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setFilterBitmap(true);
        paramIAMapDelegate.drawBitmap(this.c, (this.b.getWidth() - this.c.getWidth()) / 2.0F, (this.b.getHeight() - this.c.getHeight()) / 2.0F, localPaint);
        this.d = new ImageView(paramContext);
        this.d.setScaleType(ImageView.ScaleType.MATRIX);
        this.d.setImageBitmap(this.a);
        this.d.setClickable(true);
        b();
        this.d.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            try
            {
              if (!fa.this.e.isMaploaded()) {
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                fa.this.d.setImageBitmap(fa.this.b);
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() == 1)
              {
                fa.this.d.setImageBitmap(fa.this.a);
                paramAnonymousView = fa.this.e.getCameraPosition();
                fa.this.e.animateCamera(k.a(new CameraPosition(paramAnonymousView.target, paramAnonymousView.zoom, 0.0F, 0.0F)));
                return false;
              }
            }
            catch (Throwable paramAnonymousView)
            {
              gk.c(paramAnonymousView, "CompassView", "onTouch");
              paramAnonymousView.printStackTrace();
            }
            return false;
          }
        });
        addView(this.d);
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "CompassView", "create");
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
      if (this.c != null) {
        this.c.recycle();
      }
      if (this.f != null)
      {
        this.f.reset();
        this.f = null;
      }
      this.c = null;
      this.a = null;
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "CompassView", "destroy");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      b();
      return;
    }
    setVisibility(8);
  }
  
  public void b()
  {
    try
    {
      if ((this.e != null) && (this.d != null))
      {
        float f1 = this.e.getCameraDegree(1);
        float f2 = this.e.getMapAngle(1);
        if (this.f == null) {
          this.f = new Matrix();
        }
        this.f.reset();
        this.f.postRotate(-f2, this.d.getDrawable().getBounds().width() / 2.0F, this.d.getDrawable().getBounds().height() / 2.0F);
        Matrix localMatrix = this.f;
        double d1 = f1;
        Double.isNaN(d1);
        d1 = d1 * 3.141592653589793D / 180.0D;
        localMatrix.postScale(1.0F, (float)Math.cos(d1), this.d.getDrawable().getBounds().width() / 2.0F, this.d.getDrawable().getBounds().height() / 2.0F);
        this.d.setImageMatrix(this.f);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "CompassView", "invalidateAngle");
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */