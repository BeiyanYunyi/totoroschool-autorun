package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

public class cg
  implements IGLSurfaceView
{
  protected boolean a = false;
  private IAMapDelegate b = null;
  
  public cg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public cg(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = new bf(this, paramContext, paramAttributeSet);
  }
  
  public IAMapDelegate a()
  {
    return this.b;
  }
  
  public int getHeight()
  {
    return 0;
  }
  
  public SurfaceHolder getHolder()
  {
    return null;
  }
  
  public ViewParent getParent()
  {
    return null;
  }
  
  public int getRenderMode()
  {
    return 0;
  }
  
  public int getWidth()
  {
    return 0;
  }
  
  public boolean isEnabled()
  {
    return this.b != null;
  }
  
  public void onDetachedGLThread() {}
  
  public boolean post(Runnable paramRunnable)
  {
    return false;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return false;
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void requestRender() {}
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setEGLConfigChooser(dd paramdd) {}
  
  public void setEGLContextFactory(de paramde) {}
  
  public void setRenderMode(int paramInt) {}
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer) {}
  
  public void setVisibility(int paramInt) {}
  
  public void setZOrderOnTop(boolean paramBoolean) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */