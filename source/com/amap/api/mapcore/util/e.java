package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

public class e
  extends GLSurfaceView
  implements IGLSurfaceView
{
  protected boolean a = false;
  private IAMapDelegate b = null;
  private GLMapRender c = null;
  
  public e(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    df.a(this, 5, 6, 5, 0, 16, 8);
    this.b = new bf(this, paramContext, paramAttributeSet);
  }
  
  public IAMapDelegate a()
  {
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      if (this.c != null) {
        this.c.onAttachedToWindow();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    onResume();
  }
  
  protected void onDetachedFromWindow() {}
  
  public void onDetachedGLThread()
  {
    onPause();
    try
    {
      if (this.c != null) {
        this.c.onDetachedFromWindow();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    int i;
    if (!this.c.mSurfacedestoryed)
    {
      queueEvent(new Runnable()
      {
        public void run()
        {
          if (e.a(e.this) != null) {
            try
            {
              e.a(e.this).onSurfaceDestory();
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      });
      i = 0;
    }
    for (;;)
    {
      if ((!this.c.mSurfacedestoryed) && (i < 20)) {}
      try
      {
        Thread.sleep(50L);
        i += 1;
        continue;
        super.onPause();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    try
    {
      boolean bool = this.b.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if ((paramInt == 8) || (paramInt == 4) || (paramInt == 0))
    {
      try
      {
        if (this.c == null) {
          return;
        }
        this.c.renderResume();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (this.c != null)
      {
        this.c.renderPause();
        this.a = false;
        return;
      }
    }
  }
  
  public void setEGLConfigChooser(dd paramdd)
  {
    super.setEGLConfigChooser(paramdd);
  }
  
  public void setEGLContextFactory(de paramde)
  {
    super.setEGLContextFactory(paramde);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    this.c = ((GLMapRender)paramRenderer);
    super.setRenderer(paramRenderer);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */