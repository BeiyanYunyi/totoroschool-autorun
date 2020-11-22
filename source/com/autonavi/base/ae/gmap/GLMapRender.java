package com.autonavi.base.ae.gmap;

import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.api.mapcore.util.gk;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLMapRender
  implements GLSurfaceView.Renderer
{
  public static final int ANIMATION_TICK_COUNT = 10;
  public static final int LONG_LONG_TICK_COUNT = 30;
  public static final int LONG_TICK_COUNT = 6;
  private static final int MAP_RENDER_MSG_RUNNABLE_ONGLTHREAD = 100;
  private static final int MAP_RENDER_MSG_SURFACE_RENDER = 10;
  public static final int NORMAL_TICK_COUNT = 2;
  public static final int RENDER_FPS_ANIMATION = 30;
  public static final int RENDER_FPS_GESTURE_ACTION = 40;
  static final int RENDER_FPS_MAX = 60;
  public static final int RENDER_FPS_NAVI = 10;
  public static final int RENDER_FPS_NORMAL = 15;
  static final long RENDER_TIMMER_DIFF_MIN = 16L;
  static final String TAG = "render";
  private volatile AtomicLong mDrawFrameTickCount = new AtomicLong(6L);
  public IAMap mGLMapView;
  private Handler mGLRenderHandler = null;
  private HandlerThread mGLRenderThread = null;
  private volatile boolean mIsRendPause = false;
  private boolean mIsTrafficMode = false;
  private long mLastFrameTime = System.currentTimeMillis();
  public volatile boolean mSurfacedestoryed = false;
  private int mTargetFrameDurationMillis = 66;
  private float mTargetRenderFPS = 15.0F;
  
  public GLMapRender(IAMap paramIAMap)
  {
    this.mGLMapView = paramIAMap;
  }
  
  private void drawSingleFrame(GL10 paramGL10)
  {
    try
    {
      this.mGLMapView.drawFrame(paramGL10);
      return;
    }
    catch (Throwable paramGL10)
    {
      paramGL10.printStackTrace();
    }
  }
  
  public boolean isRenderPause()
  {
    return this.mIsRendPause;
  }
  
  public void onAttachedToWindow()
  {
    if (this.mGLRenderThread == null)
    {
      this.mGLRenderThread = new HandlerThread(" AMapGlRenderThread");
      this.mGLRenderThread.start();
      this.mGLRenderHandler = new Handler(this.mGLRenderThread.getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          int i = paramAnonymousMessage.what;
          if (i != 10)
          {
            if (i != 100) {
              return;
            }
            ((Runnable)paramAnonymousMessage.obj).run();
            return;
          }
          if ((!GLMapRender.this.mIsRendPause) && (GLMapRender.this.mGLMapView != null) && (GLMapRender.this.mGLMapView.getRenderMode() == 0)) {
            GLMapRender.this.mGLMapView.requestRender();
          }
        }
      };
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.mGLRenderThread != null)
    {
      this.mGLRenderThread.quit();
      this.mGLRenderThread = null;
      this.mGLRenderHandler = null;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mGLMapView == null) {
      return;
    }
    for (;;)
    {
      long l1;
      long l3;
      try
      {
        this.mLastFrameTime = System.currentTimeMillis();
        drawSingleFrame(paramGL10);
        l1 = System.currentTimeMillis();
        long l2 = this.mLastFrameTime;
        this.mLastFrameTime = l1;
        l3 = this.mDrawFrameTickCount.get();
        if ((this.mGLMapView.getRenderMode() == 0) && (this.mGLRenderHandler != null) && (this.mGLRenderThread != null) && (this.mGLRenderThread.isAlive()))
        {
          paramGL10 = this.mDrawFrameTickCount;
          l3 -= 1L;
          paramGL10.set(l3);
          if (l3 <= 0L)
          {
            if (l3 <= -5) {
              break label208;
            }
            l1 = 60L;
            continue;
            if (!this.mIsTrafficMode) {
              break label240;
            }
            l1 = 10000L;
            this.mDrawFrameTickCount.set(-9L);
          }
          else
          {
            l1 = Math.max(16L, this.mTargetFrameDurationMillis - (l1 - l2));
          }
          if ((l1 > 0L) && (this.mGLRenderHandler != null))
          {
            this.mGLRenderHandler.removeMessages(10);
            this.mGLRenderHandler.sendEmptyMessageDelayed(10, l1);
            return;
          }
        }
      }
      catch (Throwable paramGL10)
      {
        gk.c(paramGL10, "GLMapRender", "onDrawFrame");
      }
      return;
      label208:
      if (l3 > -7)
      {
        l1 = 100L;
      }
      else if (l3 > -9)
      {
        l1 = 250L;
        continue;
        label240:
        l1 = 500L;
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.mSurfacedestoryed) {
      onSurfaceCreated(paramGL10, null);
    }
    this.mGLMapView.changeSurface(paramGL10, paramInt1, paramInt2);
    resetTickCount(30);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.mIsRendPause = false;
    this.mSurfacedestoryed = false;
    this.mGLMapView.createSurface(paramGL10, paramEGLConfig);
  }
  
  public void onSurfaceDestory()
  {
    this.mIsRendPause = true;
    if ((this.mGLRenderHandler != null) && (this.mGLRenderThread != null)) {
      this.mGLRenderHandler.removeCallbacksAndMessages(null);
    }
    this.mGLMapView.destroySurface(1);
    this.mSurfacedestoryed = true;
  }
  
  public void renderPause()
  {
    if ((this.mGLRenderHandler != null) && (this.mGLRenderThread != null) && (this.mGLRenderThread.isAlive())) {
      this.mGLRenderHandler.removeMessages(10);
    }
    this.mIsRendPause = true;
  }
  
  public void renderResume()
  {
    if ((this.mGLRenderHandler != null) && (this.mGLRenderThread != null) && (this.mGLRenderThread.isAlive())) {
      this.mGLRenderHandler.removeMessages(10);
    }
    this.mIsRendPause = false;
    this.mDrawFrameTickCount.set(-1L);
    resetTickCount(30);
  }
  
  public void resetTickCount(int paramInt)
  {
    long l1 = this.mDrawFrameTickCount.get();
    long l2;
    if ((!this.mIsRendPause) && (this.mGLRenderThread != null) && (this.mGLRenderHandler != null) && (this.mGLRenderThread.isAlive()))
    {
      if (l1 <= 0L)
      {
        this.mDrawFrameTickCount.set(paramInt);
        this.mGLRenderHandler.removeMessages(10);
        this.mGLRenderHandler.sendEmptyMessage(10);
        return;
      }
      l2 = paramInt;
      if (l1 < l2) {
        this.mDrawFrameTickCount.set(l2);
      }
    }
    else
    {
      l2 = paramInt;
      if (l1 < l2) {
        this.mDrawFrameTickCount.set(l2);
      }
    }
  }
  
  public void sendToRenderEvent(Runnable paramRunnable)
  {
    if ((this.mGLRenderHandler != null) && (this.mGLRenderThread != null) && (this.mGLRenderThread.isAlive())) {
      this.mGLRenderHandler.post(paramRunnable);
    }
  }
  
  public void setRenderFps(float paramFloat)
  {
    if ((this.mTargetRenderFPS != paramFloat) && (paramFloat > 0.0F))
    {
      this.mTargetFrameDurationMillis = ((int)(1.0F / paramFloat * 1000.0F));
      this.mTargetRenderFPS = paramFloat;
    }
  }
  
  public void setTrafficMode(boolean paramBoolean)
  {
    this.mIsTrafficMode = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\GLMapRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */