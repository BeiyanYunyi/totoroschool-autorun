package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.mapcore.util.dd;
import com.amap.api.mapcore.util.de;

public abstract interface IGLSurfaceView
{
  public abstract int getHeight();
  
  public abstract SurfaceHolder getHolder();
  
  public abstract ViewParent getParent();
  
  public abstract int getRenderMode();
  
  public abstract int getWidth();
  
  public abstract boolean isEnabled();
  
  public abstract void onDetachedGLThread();
  
  public abstract boolean post(Runnable paramRunnable);
  
  public abstract boolean postDelayed(Runnable paramRunnable, long paramLong);
  
  public abstract void queueEvent(Runnable paramRunnable);
  
  public abstract void requestRender();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setEGLConfigChooser(dd paramdd);
  
  public abstract void setEGLContextFactory(de paramde);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setRenderer(GLSurfaceView.Renderer paramRenderer);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void setZOrderOnTop(boolean paramBoolean);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\IGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */