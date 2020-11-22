package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

class eh
  extends LinearLayout
{
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  private Bitmap e;
  private Bitmap f;
  private Bitmap g;
  private Bitmap h;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private Bitmap l;
  private ImageView m;
  private ImageView n;
  private IAMapDelegate o;
  
  public eh(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    super(paramContext);
    this.o = paramIAMapDelegate;
    try
    {
      this.g = dx.a(paramContext, "zoomin_selected.png");
      this.a = dx.a(this.g, lk.a);
      this.h = dx.a(paramContext, "zoomin_unselected.png");
      this.b = dx.a(this.h, lk.a);
      this.i = dx.a(paramContext, "zoomout_selected.png");
      this.c = dx.a(this.i, lk.a);
      this.j = dx.a(paramContext, "zoomout_unselected.png");
      this.d = dx.a(this.j, lk.a);
      this.k = dx.a(paramContext, "zoomin_pressed.png");
      this.e = dx.a(this.k, lk.a);
      this.l = dx.a(paramContext, "zoomout_pressed.png");
      this.f = dx.a(this.l, lk.a);
      this.m = new ImageView(paramContext);
      this.m.setImageBitmap(this.a);
      this.m.setClickable(true);
      this.n = new ImageView(paramContext);
      this.n.setImageBitmap(this.c);
      this.n.setClickable(true);
      this.m.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          try
          {
            if (eh.a(eh.this).getZoomLevel() < eh.a(eh.this).getMaxZoomLevel())
            {
              if (!eh.a(eh.this).isMaploaded()) {
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                eh.c(eh.this).setImageBitmap(eh.b(eh.this));
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() != 1) {
                break label135;
              }
              eh.c(eh.this).setImageBitmap(eh.d(eh.this));
              try
              {
                eh.a(eh.this).animateCamera(k.a());
                return false;
              }
              catch (RemoteException paramAnonymousView)
              {
                gk.c(paramAnonymousView, "ZoomControllerView", "zoomin ontouch");
                paramAnonymousView.printStackTrace();
                return false;
              }
            }
            return false;
          }
          catch (Throwable paramAnonymousView)
          {
            paramAnonymousView.printStackTrace();
          }
          label135:
          return false;
        }
      });
      this.n.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          try
          {
            if (eh.a(eh.this).getZoomLevel() > eh.a(eh.this).getMinZoomLevel())
            {
              if (!eh.a(eh.this).isMaploaded()) {
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                eh.f(eh.this).setImageBitmap(eh.e(eh.this));
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() == 1)
              {
                eh.f(eh.this).setImageBitmap(eh.g(eh.this));
                eh.a(eh.this).animateCamera(k.b());
                return false;
              }
            }
            else
            {
              return false;
            }
          }
          catch (Throwable paramAnonymousView)
          {
            gk.c(paramAnonymousView, "ZoomControllerView", "zoomout ontouch");
            paramAnonymousView.printStackTrace();
          }
          return false;
        }
      });
      this.m.setPadding(0, 0, 20, -2);
      this.n.setPadding(0, 0, 20, 20);
      setOrientation(1);
      addView(this.m);
      addView(this.n);
      return;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "ZoomControllerView", "create");
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    try
    {
      removeAllViews();
      this.a.recycle();
      this.b.recycle();
      this.c.recycle();
      this.d.recycle();
      this.e.recycle();
      this.f.recycle();
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      if (this.g != null)
      {
        this.g.recycle();
        this.g = null;
      }
      if (this.h != null)
      {
        this.h.recycle();
        this.h = null;
      }
      if (this.i != null)
      {
        this.i.recycle();
        this.i = null;
      }
      if (this.j != null)
      {
        this.j.recycle();
        this.g = null;
      }
      if (this.k != null)
      {
        this.k.recycle();
        this.k = null;
      }
      if (this.l != null)
      {
        this.l.recycle();
        this.l = null;
      }
      this.m = null;
      this.n = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ZoomControllerView", "destory");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(float paramFloat)
  {
    try
    {
      if ((paramFloat < this.o.getMaxZoomLevel()) && (paramFloat > this.o.getMinZoomLevel()))
      {
        this.m.setImageBitmap(this.a);
        this.n.setImageBitmap(this.c);
        return;
      }
      if (paramFloat == this.o.getMinZoomLevel())
      {
        this.n.setImageBitmap(this.d);
        this.m.setImageBitmap(this.a);
        return;
      }
      if (paramFloat == this.o.getMaxZoomLevel())
      {
        this.m.setImageBitmap(this.b);
        this.n.setImageBitmap(this.c);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ZoomControllerView", "setZoomBitmap");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      fd.a locala = (fd.a)getLayoutParams();
      if (paramInt == 1) {
        locala.d = 16;
      } else if (paramInt == 2) {
        locala.d = 80;
      }
      setLayoutParams(locala);
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "ZoomControllerView", "setZoomPosition");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */