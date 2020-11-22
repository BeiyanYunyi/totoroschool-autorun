package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.nio.FloatBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class lv
{
  float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  float[] b = { -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F };
  private final IAMapDelegate c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private BlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private ExecutorService h = null;
  private boolean i = false;
  private boolean j = false;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private boolean n = false;
  private volatile EGLContext o;
  private volatile EGLConfig p;
  private EGLDisplay q = EGL14.EGL_NO_DISPLAY;
  private EGLContext r = EGL14.EGL_NO_CONTEXT;
  private EGLSurface s = EGL14.EGL_NO_SURFACE;
  private cl.f t;
  private FloatBuffer u;
  private FloatBuffer v;
  private a w;
  private CrossOverlay.GenerateCrossImageListener x;
  
  public lv(IAMapDelegate paramIAMapDelegate)
  {
    this.c = paramIAMapDelegate;
    this.j = false;
    int i1 = Runtime.getRuntime().availableProcessors();
    paramIAMapDelegate = TimeUnit.SECONDS;
    this.h = new ThreadPoolExecutor(1, i1 * 2, 1, paramIAMapDelegate, this.g, new dk("AMapPboRenderThread"), new ThreadPoolExecutor.AbortPolicy());
  }
  
  private void a(String paramString) {}
  
  private void d()
  {
    this.q = EGL14.eglGetDisplay(0);
    if (this.q == EGL14.EGL_NO_DISPLAY)
    {
      a("eglGetDisplay failed");
      return;
    }
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(this.q, arrayOfInt, 0, arrayOfInt, 1))
    {
      this.q = null;
      a("eglInitialize failed");
      return;
    }
    this.r = EGL14.eglCreateContext(this.q, this.p, this.o, new int[] { 12440, 2, 12344 }, 0);
    if (this.r == EGL14.EGL_NO_CONTEXT)
    {
      a("eglCreateContext failed");
      return;
    }
    int i1 = this.e;
    int i2 = this.f;
    this.s = EGL14.eglCreatePbufferSurface(this.q, this.p, new int[] { 12375, i1, 12374, i2, 12344 }, 0);
    if (this.s == EGL14.EGL_NO_SURFACE)
    {
      a("eglCreatePbufferSurface failed");
      return;
    }
    if (!EGL14.eglMakeCurrent(this.q, this.s, this.s, this.r))
    {
      a("eglMakeCurrent failed");
      return;
    }
    GLES20.glFlush();
    a("initOpenGL complete");
    this.i = true;
  }
  
  private void e()
  {
    if (this.c != null) {
      this.t = ((cl.f)this.c.getGLShader(0));
    }
  }
  
  private void f()
  {
    try
    {
      if (this.j) {
        return;
      }
      if (this.w == null)
      {
        a("renderTextureAndReadPixel failed textureHelper is null");
        return;
      }
      if (this.w != null) {
        this.d = this.w.getTextureID();
      }
      if (this.d <= 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("renderTextureAndReadPixel failed mTextureID is <= 0 mTextureID ");
        localStringBuilder.append(this.d);
        a(localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderTextureAndReadPixel  mTextureID is  mTextureID ");
      localStringBuilder.append(this.d);
      a(localStringBuilder.toString());
      if ((this.t == null) || (this.t.c())) {
        e();
      }
      if (this.u == null) {
        this.u = dx.a(this.b);
      }
      if (this.v == null) {
        this.v = dx.a(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      }
      this.t.a();
      GLES20.glDisable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.d);
      GLES20.glEnableVertexAttribArray(this.t.b);
      GLES20.glVertexAttribPointer(this.t.b, 3, 5126, false, 12, this.u);
      GLES20.glEnableVertexAttribArray(this.t.c);
      GLES20.glVertexAttribPointer(this.t.c, 2, 5126, false, 8, this.v);
      Matrix.setIdentityM(this.a, 0);
      Matrix.scaleM(this.a, 0, 1.0F, 1.0F, 1.0F);
      GLES20.glUniformMatrix4fv(this.t.a, 1, false, this.a, 0);
      GLES20.glDrawArrays(6, 0, 4);
      GLES20.glDisableVertexAttribArray(this.t.b);
      GLES20.glDisableVertexAttribArray(this.t.c);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      GLES20.glDisable(3042);
      df.a("drawTexure");
      GLES20.glFinish();
      this.k += 1;
      if (this.k != 50) {
        break label441;
      }
      g();
      return;
    }
    catch (Throwable localThrowable)
    {
      label441:
      for (;;) {}
    }
    if (this.x != null) {
      this.x.onGenerateComplete(null, -1);
    }
  }
  
  private void g()
  {
    if (this.x != null)
    {
      if (this.l == 0) {
        this.l = this.e;
      }
      if (this.m == 0) {
        this.m = this.f;
      }
      int i2 = this.f;
      int i3 = this.m;
      int i4 = this.l;
      int i5 = this.m;
      int i1 = 0;
      Bitmap localBitmap = dx.a(0, i2 - i3, i4, i5);
      CrossOverlay.GenerateCrossImageListener localGenerateCrossImageListener = this.x;
      if (!this.i) {
        i1 = -1;
      }
      localGenerateCrossImageListener.onGenerateComplete(localBitmap, i1);
      this.n = true;
    }
  }
  
  public void a()
  {
    if ((this.h != null) && (!this.h.isShutdown())) {
      this.h.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            lv.a(lv.this, false);
            boolean bool = lv.b(lv.this);
            if (bool) {
              return;
            }
            lv.a(lv.this, 0);
            int i = 0;
            while (!lv.b(lv.this))
            {
              int j = lv.c(lv.this);
              if ((j >= 5) || (i >= 50)) {
                break;
              }
              i += 1;
              try
              {
                Thread.sleep(16L);
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
              if (!lv.d(lv.this))
              {
                if (lv.e(lv.this) != null) {
                  lv.e(lv.this).onGenerateComplete(null, -1);
                }
                return;
              }
              GLES20.glViewport(0, 0, lv.f(lv.this), lv.g(lv.this));
              GLES20.glClear(16640);
              lv.h(lv.this);
            }
            return;
          }
          finally
          {
            if (!lv.i(lv.this))
            {
              lv.a(lv.this, true);
              if (lv.e(lv.this) != null) {
                lv.e(lv.this).onGenerateComplete(null, -1);
              }
            }
            if (lv.j(lv.this) != EGL14.EGL_NO_CONTEXT)
            {
              EGL14.eglDestroyContext(lv.k(lv.this), lv.j(lv.this));
              EGL14.eglDestroySurface(lv.k(lv.this), lv.l(lv.this));
              lv.a(lv.this, null);
            }
            if (lv.k(lv.this) != EGL14.EGL_NO_DISPLAY)
            {
              EGL14.eglTerminate(lv.k(lv.this));
              lv.a(lv.this, null);
            }
            lv.a(lv.this, EGL14.EGL_NO_CONTEXT);
            lv.a(lv.this, EGL14.EGL_NO_DISPLAY);
          }
        }
      });
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.o = EGL14.eglGetCurrentContext();
    if (this.o == EGL14.EGL_NO_CONTEXT)
    {
      a("eglGetCurrentContext failed");
      return;
    }
    EGLDisplay localEGLDisplay = EGL14.eglGetCurrentDisplay();
    if (localEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      a("sharedEglDisplay failed");
      return;
    }
    int[] arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!EGL14.eglGetConfigs(localEGLDisplay, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt, 0))
    {
      a("eglGetConfigs failed");
      return;
    }
    this.p = arrayOfEGLConfig[0];
    if ((this.h != null) && (!this.h.isShutdown())) {
      this.h.execute(new Runnable()
      {
        public void run()
        {
          lv.a(lv.this);
        }
      });
    }
  }
  
  public void a(a parama)
  {
    this.w = parama;
  }
  
  public void a(CrossOverlay.GenerateCrossImageListener paramGenerateCrossImageListener)
  {
    this.x = paramGenerateCrossImageListener;
  }
  
  public void b()
  {
    this.j = true;
    if (this.v != null)
    {
      this.v.clear();
      this.v = null;
    }
    if (this.u != null)
    {
      this.u.clear();
      this.u = null;
    }
    this.w = null;
    this.h.shutdownNow();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public static abstract interface a
  {
    public abstract int getTextureID();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */