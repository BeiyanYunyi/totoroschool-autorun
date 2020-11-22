package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.amap.api.maps.MapsInitializer;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
public class n
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final j a = new j(null);
  private final WeakReference<n> b = new WeakReference(this);
  private i c;
  private GLSurfaceView.Renderer d;
  private boolean e;
  private e f;
  private f g;
  private g h;
  private k i;
  private int j;
  private int k;
  private boolean l;
  
  public n(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setSurfaceTextureListener(this);
  }
  
  private void e()
  {
    if (this.c == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  public void a(e parame)
  {
    e();
    this.f = parame;
  }
  
  public void a(f paramf)
  {
    e();
    this.g = paramf;
  }
  
  public void b()
  {
    this.c.f();
  }
  
  public void c()
  {
    this.c.g();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.c != null) {
        this.c.h();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getRenderMode()
  {
    return this.c.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.e) && (this.d != null))
    {
      int m;
      if (this.c != null) {
        m = this.c.b();
      } else {
        m = 1;
      }
      this.c = new i(this.b);
      if (m != 1) {
        this.c.a(m);
      }
      this.c.start();
    }
    this.e = false;
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.c != null) {
      this.c.h();
    }
    this.e = true;
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onSurfaceTextureSizeChanged(getSurfaceTexture(), paramInt3 - paramInt1, paramInt4 - paramInt2);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.c.d();
    onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.c.e();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.c.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.c.a(paramRunnable);
  }
  
  public void requestRender()
  {
    this.c.c();
  }
  
  public void setRenderMode(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    e();
    if (this.f == null) {
      this.f = new m(true);
    }
    if (this.g == null) {
      this.g = new c(null);
    }
    if (this.h == null) {
      this.h = new d(null);
    }
    this.d = paramRenderer;
    this.c = new i(this.b);
    this.c.start();
  }
  
  private abstract class a
    implements n.e
  {
    protected int[] a = a(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] a(int[] paramArrayOfInt)
    {
      if ((n.a(n.this) != 2) && (n.a(n.this) != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      int j = i - 1;
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, j);
      arrayOfInt[j] = 12352;
      if (n.a(n.this) == 2) {
        arrayOfInt[i] = 4;
      } else {
        arrayOfInt[i] = 64;
      }
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
    }
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, null, 0, arrayOfInt))
      {
        int i = arrayOfInt[0];
        if (i > 0)
        {
          EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
          if (paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt))
          {
            paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
            if (paramEGL10 != null) {
              return paramEGL10;
            }
            throw new IllegalArgumentException("No config chosen");
          }
          throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("No configs match configSpec");
      }
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
  }
  
  private class b
    extends n.a
  {
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    private int[] j = new int[1];
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
      this.g = paramInt5;
      this.h = paramInt6;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.j)) {
        return this.j[0];
      }
      return paramInt2;
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int m = paramArrayOfEGLConfig.length;
      int k = 0;
      while (k < m)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((n >= this.g) && (i1 >= this.h))
        {
          n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((n == this.c) && (i1 == this.d) && (i2 == this.e) && (i3 == this.f)) {
            return localEGLConfig;
          }
        }
        k += 1;
      }
      return null;
    }
  }
  
  private class c
    implements n.f
  {
    private c() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 12440;
      arrayOfInt[1] = n.a(n.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (n.a(n.this) == 0) {
        arrayOfInt = null;
      }
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("display:");
        localStringBuilder.append(paramEGLDisplay);
        localStringBuilder.append(" context: ");
        localStringBuilder.append(paramEGLContext);
        Log.e("DefaultContextFactory", localStringBuilder.toString());
        n.h.a("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  private static class d
    implements n.g
  {
    public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        Log.e("GLSurfaceView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  private static class h
  {
    EGL10 a;
    EGLDisplay b;
    EGLSurface c;
    EGLConfig d;
    EGLContext e;
    private WeakReference<n> f;
    
    public h(WeakReference<n> paramWeakReference)
    {
      this.f = paramWeakReference;
    }
    
    private void a(String paramString)
    {
      a(paramString, this.a.eglGetError());
    }
    
    public static void a(String paramString, int paramInt)
    {
      throw new RuntimeException(b(paramString, paramInt));
    }
    
    public static void a(String paramString1, String paramString2, int paramInt)
    {
      Log.w(paramString1, b(paramString2, paramInt));
    }
    
    public static String b(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" failed: ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    
    private void g()
    {
      if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
      {
        this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        n localn = (n)this.f.get();
        if (localn != null) {
          n.d(localn).a(this.a, this.b, this.c);
        }
        this.c = null;
      }
    }
    
    public void a()
    {
      this.a = ((EGL10)EGLContext.getEGL());
      this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.b != EGL10.EGL_NO_DISPLAY)
      {
        Object localObject = new int[2];
        if (this.a.eglInitialize(this.b, (int[])localObject))
        {
          localObject = (n)this.f.get();
          if (localObject == null)
          {
            this.d = null;
            this.e = null;
          }
          else
          {
            this.d = n.b((n)localObject).chooseConfig(this.a, this.b);
            this.e = n.c((n)localObject).createContext(this.a, this.b, this.d);
          }
          if ((this.e == null) || (this.e == EGL10.EGL_NO_CONTEXT))
          {
            this.e = null;
            a("createContext");
          }
          this.c = null;
          return;
        }
        throw new RuntimeException("eglInitialize failed");
      }
      throw new RuntimeException("eglGetDisplay failed");
    }
    
    public boolean b()
    {
      if (this.a != null)
      {
        if (this.b != null)
        {
          if (this.d != null)
          {
            g();
            n localn = (n)this.f.get();
            if (localn != null) {
              this.c = n.d(localn).a(this.a, this.b, this.d, localn.getSurfaceTexture());
            } else {
              this.c = null;
            }
            if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
            {
              if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e))
              {
                a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                return false;
              }
              return true;
            }
            if (this.a.eglGetError() == 12299) {
              Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
          }
          throw new RuntimeException("mEglConfig not initialized");
        }
        throw new RuntimeException("eglDisplay not initialized");
      }
      throw new RuntimeException("egl not initialized");
    }
    
    GL c()
    {
      GL localGL2 = this.e.getGL();
      n localn = (n)this.f.get();
      Object localObject = localGL2;
      if (localn != null)
      {
        GL localGL1 = localGL2;
        if (n.e(localn) != null) {
          localGL1 = n.e(localn).a(localGL2);
        }
        localObject = localGL1;
        if ((n.f(localn) & 0x3) != 0)
        {
          int i = 0;
          localObject = null;
          if ((n.f(localn) & 0x1) != 0) {
            i = 1;
          }
          if ((n.f(localn) & 0x2) != 0) {
            localObject = new n.l();
          }
          localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        }
      }
      return (GL)localObject;
    }
    
    public int d()
    {
      if (!this.a.eglSwapBuffers(this.b, this.c)) {
        return this.a.eglGetError();
      }
      return 12288;
    }
    
    public void e()
    {
      g();
    }
    
    public void f()
    {
      if (this.e != null)
      {
        n localn = (n)this.f.get();
        if (localn != null) {
          n.c(localn).destroyContext(this.a, this.b, this.e);
        }
        this.e = null;
      }
      if (this.b != null)
      {
        this.a.eglTerminate(this.b);
        this.b = null;
      }
    }
  }
  
  static class i
    extends Thread
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p;
    private ArrayList<Runnable> q = new ArrayList();
    private boolean r = true;
    private n.h s;
    private WeakReference<n> t;
    
    i(WeakReference<n> paramWeakReference)
    {
      this.t = paramWeakReference;
    }
    
    private void j()
    {
      if (this.i)
      {
        this.i = false;
        this.s.e();
      }
    }
    
    private void k()
    {
      if (this.h)
      {
        this.s.f();
        this.h = false;
        n.d().c(this);
      }
    }
    
    /* Error */
    private void l()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 67	com/amap/api/mapcore/util/n$h
      //   4: dup
      //   5: aload_0
      //   6: getfield 55	com/amap/api/mapcore/util/n$i:t	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 87	com/amap/api/mapcore/util/n$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 71	com/amap/api/mapcore/util/n$i:h	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   25: iconst_0
      //   26: istore 6
      //   28: iconst_0
      //   29: istore 10
      //   31: iconst_0
      //   32: istore_3
      //   33: aconst_null
      //   34: astore 19
      //   36: iconst_0
      //   37: istore 9
      //   39: iconst_0
      //   40: istore 8
      //   42: aconst_null
      //   43: astore 20
      //   45: iconst_0
      //   46: istore 4
      //   48: iconst_0
      //   49: istore 5
      //   51: iconst_0
      //   52: istore_2
      //   53: iconst_0
      //   54: istore_1
      //   55: iconst_0
      //   56: istore 7
      //   58: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   61: astore 21
      //   63: aload 21
      //   65: monitorenter
      //   66: iload 7
      //   68: istore 12
      //   70: iload 4
      //   72: istore 7
      //   74: iload_3
      //   75: istore 4
      //   77: iload 10
      //   79: istore_3
      //   80: aload_0
      //   81: getfield 89	com/amap/api/mapcore/util/n$i:a	Z
      //   84: ifeq +34 -> 118
      //   87: aload 21
      //   89: monitorexit
      //   90: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   93: astore 19
      //   95: aload 19
      //   97: monitorenter
      //   98: aload_0
      //   99: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   102: aload_0
      //   103: invokespecial 93	com/amap/api/mapcore/util/n$i:k	()V
      //   106: aload 19
      //   108: monitorexit
      //   109: return
      //   110: astore 20
      //   112: aload 19
      //   114: monitorexit
      //   115: aload 20
      //   117: athrow
      //   118: aload_0
      //   119: getfield 43	com/amap/api/mapcore/util/n$i:q	Ljava/util/ArrayList;
      //   122: invokevirtual 97	java/util/ArrayList:isEmpty	()Z
      //   125: ifne +41 -> 166
      //   128: aload_0
      //   129: getfield 43	com/amap/api/mapcore/util/n$i:q	Ljava/util/ArrayList;
      //   132: iconst_0
      //   133: invokevirtual 101	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   136: checkcast 103	java/lang/Runnable
      //   139: astore 20
      //   141: iload_3
      //   142: istore 10
      //   144: iload 4
      //   146: istore_3
      //   147: iload 9
      //   149: istore 15
      //   151: iload 8
      //   153: istore 14
      //   155: iload 7
      //   157: istore 4
      //   159: iload 12
      //   161: istore 7
      //   163: goto +482 -> 645
      //   166: aload_0
      //   167: getfield 105	com/amap/api/mapcore/util/n$i:d	Z
      //   170: aload_0
      //   171: getfield 107	com/amap/api/mapcore/util/n$i:c	Z
      //   174: if_icmpeq +972 -> 1146
      //   177: aload_0
      //   178: getfield 107	com/amap/api/mapcore/util/n$i:c	Z
      //   181: istore 17
      //   183: aload_0
      //   184: aload_0
      //   185: getfield 107	com/amap/api/mapcore/util/n$i:c	Z
      //   188: putfield 105	com/amap/api/mapcore/util/n$i:d	Z
      //   191: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   194: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   197: goto +3 -> 200
      //   200: aload_0
      //   201: getfield 114	com/amap/api/mapcore/util/n$i:k	Z
      //   204: ifeq +18 -> 222
      //   207: aload_0
      //   208: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   211: aload_0
      //   212: invokespecial 93	com/amap/api/mapcore/util/n$i:k	()V
      //   215: aload_0
      //   216: iconst_0
      //   217: putfield 114	com/amap/api/mapcore/util/n$i:k	Z
      //   220: iconst_1
      //   221: istore_3
      //   222: iload 4
      //   224: istore 10
      //   226: iload 4
      //   228: ifeq +14 -> 242
      //   231: aload_0
      //   232: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   235: aload_0
      //   236: invokespecial 93	com/amap/api/mapcore/util/n$i:k	()V
      //   239: iconst_0
      //   240: istore 10
      //   242: iload 17
      //   244: ifeq +14 -> 258
      //   247: aload_0
      //   248: getfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   251: ifeq +7 -> 258
      //   254: aload_0
      //   255: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   258: iload 17
      //   260: ifeq +58 -> 318
      //   263: aload_0
      //   264: getfield 71	com/amap/api/mapcore/util/n$i:h	Z
      //   267: ifeq +51 -> 318
      //   270: aload_0
      //   271: getfield 55	com/amap/api/mapcore/util/n$i:t	Ljava/lang/ref/WeakReference;
      //   274: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   277: checkcast 6	com/amap/api/mapcore/util/n
      //   280: astore 22
      //   282: aload 22
      //   284: ifnonnull +9 -> 293
      //   287: iconst_0
      //   288: istore 18
      //   290: goto +10 -> 300
      //   293: aload 22
      //   295: invokestatic 123	com/amap/api/mapcore/util/n:g	(Lcom/amap/api/mapcore/util/n;)Z
      //   298: istore 18
      //   300: iload 18
      //   302: ifeq +12 -> 314
      //   305: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   308: invokevirtual 125	com/amap/api/mapcore/util/n$j:a	()Z
      //   311: ifeq +7 -> 318
      //   314: aload_0
      //   315: invokespecial 93	com/amap/api/mapcore/util/n$i:k	()V
      //   318: iload 17
      //   320: ifeq +19 -> 339
      //   323: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   326: invokevirtual 127	com/amap/api/mapcore/util/n$j:b	()Z
      //   329: ifeq +10 -> 339
      //   332: aload_0
      //   333: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   336: invokevirtual 73	com/amap/api/mapcore/util/n$h:f	()V
      //   339: aload_0
      //   340: getfield 129	com/amap/api/mapcore/util/n$i:e	Z
      //   343: ifne +37 -> 380
      //   346: aload_0
      //   347: getfield 131	com/amap/api/mapcore/util/n$i:g	Z
      //   350: ifne +30 -> 380
      //   353: aload_0
      //   354: getfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   357: ifeq +7 -> 364
      //   360: aload_0
      //   361: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   364: aload_0
      //   365: iconst_1
      //   366: putfield 131	com/amap/api/mapcore/util/n$i:g	Z
      //   369: aload_0
      //   370: iconst_0
      //   371: putfield 133	com/amap/api/mapcore/util/n$i:f	Z
      //   374: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   377: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   380: aload_0
      //   381: getfield 129	com/amap/api/mapcore/util/n$i:e	Z
      //   384: ifeq +21 -> 405
      //   387: aload_0
      //   388: getfield 131	com/amap/api/mapcore/util/n$i:g	Z
      //   391: ifeq +14 -> 405
      //   394: aload_0
      //   395: iconst_0
      //   396: putfield 131	com/amap/api/mapcore/util/n$i:g	Z
      //   399: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   402: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   405: iload 6
      //   407: istore 11
      //   409: iload 6
      //   411: ifeq +20 -> 431
      //   414: aload_0
      //   415: iconst_1
      //   416: putfield 135	com/amap/api/mapcore/util/n$i:p	Z
      //   419: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   422: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   425: iconst_0
      //   426: istore 11
      //   428: iconst_0
      //   429: istore 12
      //   431: iload_3
      //   432: istore 4
      //   434: iload 7
      //   436: istore 16
      //   438: iload 5
      //   440: istore 15
      //   442: iload_2
      //   443: istore 14
      //   445: iload_1
      //   446: istore 13
      //   448: aload_0
      //   449: invokespecial 137	com/amap/api/mapcore/util/n$i:m	()Z
      //   452: ifeq +620 -> 1072
      //   455: iload_3
      //   456: istore 6
      //   458: iload 7
      //   460: istore 4
      //   462: aload_0
      //   463: getfield 71	com/amap/api/mapcore/util/n$i:h	Z
      //   466: ifne +77 -> 543
      //   469: iload_3
      //   470: ifeq +13 -> 483
      //   473: iconst_0
      //   474: istore 6
      //   476: iload 7
      //   478: istore 4
      //   480: goto +63 -> 543
      //   483: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   486: aload_0
      //   487: invokevirtual 140	com/amap/api/mapcore/util/n$j:b	(Lcom/amap/api/mapcore/util/n$i;)Z
      //   490: istore 17
      //   492: iload_3
      //   493: istore 6
      //   495: iload 7
      //   497: istore 4
      //   499: iload 17
      //   501: ifeq +42 -> 543
      //   504: aload_0
      //   505: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   508: invokevirtual 142	com/amap/api/mapcore/util/n$h:a	()V
      //   511: aload_0
      //   512: iconst_1
      //   513: putfield 71	com/amap/api/mapcore/util/n$i:h	Z
      //   516: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   519: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   522: iconst_1
      //   523: istore 4
      //   525: iload_3
      //   526: istore 6
      //   528: goto +15 -> 543
      //   531: astore 19
      //   533: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   536: aload_0
      //   537: invokevirtual 81	com/amap/api/mapcore/util/n$j:c	(Lcom/amap/api/mapcore/util/n$i;)V
      //   540: aload 19
      //   542: athrow
      //   543: aload_0
      //   544: getfield 71	com/amap/api/mapcore/util/n$i:h	Z
      //   547: ifeq +605 -> 1152
      //   550: aload_0
      //   551: getfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   554: ifne +598 -> 1152
      //   557: aload_0
      //   558: iconst_1
      //   559: putfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   562: iconst_1
      //   563: istore_3
      //   564: iconst_1
      //   565: istore_2
      //   566: iconst_1
      //   567: istore_1
      //   568: goto +3 -> 571
      //   571: aload_0
      //   572: getfield 63	com/amap/api/mapcore/util/n$i:i	Z
      //   575: ifeq +480 -> 1055
      //   578: aload_0
      //   579: getfield 45	com/amap/api/mapcore/util/n$i:r	Z
      //   582: ifeq +576 -> 1158
      //   585: aload_0
      //   586: getfield 47	com/amap/api/mapcore/util/n$i:l	I
      //   589: istore 9
      //   591: aload_0
      //   592: getfield 49	com/amap/api/mapcore/util/n$i:m	I
      //   595: istore 8
      //   597: aload_0
      //   598: iconst_0
      //   599: putfield 45	com/amap/api/mapcore/util/n$i:r	Z
      //   602: iconst_1
      //   603: istore_3
      //   604: iconst_1
      //   605: istore_1
      //   606: iconst_1
      //   607: istore 7
      //   609: goto +3 -> 612
      //   612: aload_0
      //   613: iconst_0
      //   614: putfield 51	com/amap/api/mapcore/util/n$i:o	Z
      //   617: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   620: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   623: iload_3
      //   624: istore 5
      //   626: iload 8
      //   628: istore 14
      //   630: iload 9
      //   632: istore 15
      //   634: iload 10
      //   636: istore_3
      //   637: iload 6
      //   639: istore 10
      //   641: iload 11
      //   643: istore 6
      //   645: aload 21
      //   647: monitorexit
      //   648: aload 20
      //   650: ifnull +24 -> 674
      //   653: aload 20
      //   655: invokeinterface 145 1 0
      //   660: aconst_null
      //   661: astore 20
      //   663: iload 15
      //   665: istore 9
      //   667: iload 14
      //   669: istore 8
      //   671: goto -613 -> 58
      //   674: iload 5
      //   676: istore 8
      //   678: iload 5
      //   680: ifeq +98 -> 778
      //   683: aload_0
      //   684: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   687: invokevirtual 146	com/amap/api/mapcore/util/n$h:b	()Z
      //   690: ifeq +39 -> 729
      //   693: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   696: astore 21
      //   698: aload 21
      //   700: monitorenter
      //   701: aload_0
      //   702: iconst_1
      //   703: putfield 148	com/amap/api/mapcore/util/n$i:j	Z
      //   706: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   709: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   712: aload 21
      //   714: monitorexit
      //   715: iconst_0
      //   716: istore 8
      //   718: goto +60 -> 778
      //   721: astore 19
      //   723: aload 21
      //   725: monitorexit
      //   726: aload 19
      //   728: athrow
      //   729: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   732: astore 21
      //   734: aload 21
      //   736: monitorenter
      //   737: aload_0
      //   738: iconst_1
      //   739: putfield 148	com/amap/api/mapcore/util/n$i:j	Z
      //   742: aload_0
      //   743: iconst_1
      //   744: putfield 133	com/amap/api/mapcore/util/n$i:f	Z
      //   747: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   750: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   753: aload 21
      //   755: monitorexit
      //   756: aload 19
      //   758: astore 21
      //   760: iload 5
      //   762: istore 11
      //   764: iload_2
      //   765: istore 12
      //   767: goto +398 -> 1165
      //   770: astore 19
      //   772: aload 21
      //   774: monitorexit
      //   775: aload 19
      //   777: athrow
      //   778: iload_2
      //   779: istore 5
      //   781: iload_2
      //   782: ifeq +26 -> 808
      //   785: aload_0
      //   786: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   789: invokevirtual 151	com/amap/api/mapcore/util/n$h:c	()Ljavax/microedition/khronos/opengles/GL;
      //   792: checkcast 153	javax/microedition/khronos/opengles/GL10
      //   795: astore 19
      //   797: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   800: aload 19
      //   802: invokevirtual 156	com/amap/api/mapcore/util/n$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   805: iconst_0
      //   806: istore 5
      //   808: iload 4
      //   810: istore_2
      //   811: iload 4
      //   813: ifeq +42 -> 855
      //   816: aload_0
      //   817: getfield 55	com/amap/api/mapcore/util/n$i:t	Ljava/lang/ref/WeakReference;
      //   820: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   823: checkcast 6	com/amap/api/mapcore/util/n
      //   826: astore 21
      //   828: aload 21
      //   830: ifnull +357 -> 1187
      //   833: aload 21
      //   835: invokestatic 159	com/amap/api/mapcore/util/n:h	(Lcom/amap/api/mapcore/util/n;)Landroid/opengl/GLSurfaceView$Renderer;
      //   838: aload 19
      //   840: aload_0
      //   841: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   844: getfield 162	com/amap/api/mapcore/util/n$h:d	Ljavax/microedition/khronos/egl/EGLConfig;
      //   847: invokeinterface 168 3 0
      //   852: goto +335 -> 1187
      //   855: iload_1
      //   856: istore 9
      //   858: iload_1
      //   859: ifeq +39 -> 898
      //   862: aload_0
      //   863: getfield 55	com/amap/api/mapcore/util/n$i:t	Ljava/lang/ref/WeakReference;
      //   866: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   869: checkcast 6	com/amap/api/mapcore/util/n
      //   872: astore 21
      //   874: aload 21
      //   876: ifnull +316 -> 1192
      //   879: aload 21
      //   881: invokestatic 159	com/amap/api/mapcore/util/n:h	(Lcom/amap/api/mapcore/util/n;)Landroid/opengl/GLSurfaceView$Renderer;
      //   884: aload 19
      //   886: iload 15
      //   888: iload 14
      //   890: invokeinterface 172 4 0
      //   895: goto +297 -> 1192
      //   898: aload_0
      //   899: getfield 55	com/amap/api/mapcore/util/n$i:t	Ljava/lang/ref/WeakReference;
      //   902: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   905: checkcast 6	com/amap/api/mapcore/util/n
      //   908: astore 21
      //   910: aload 21
      //   912: ifnull +15 -> 927
      //   915: aload 21
      //   917: invokestatic 159	com/amap/api/mapcore/util/n:h	(Lcom/amap/api/mapcore/util/n;)Landroid/opengl/GLSurfaceView$Renderer;
      //   920: aload 19
      //   922: invokeinterface 175 2 0
      //   927: aload_0
      //   928: getfield 65	com/amap/api/mapcore/util/n$i:s	Lcom/amap/api/mapcore/util/n$h;
      //   931: invokevirtual 178	com/amap/api/mapcore/util/n$h:d	()I
      //   934: istore_1
      //   935: iload_1
      //   936: sipush 12288
      //   939: if_icmpeq +60 -> 999
      //   942: iload_1
      //   943: sipush 12302
      //   946: if_icmpeq +47 -> 993
      //   949: ldc -76
      //   951: ldc -74
      //   953: iload_1
      //   954: invokestatic 185	com/amap/api/mapcore/util/n$h:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   957: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   960: astore 21
      //   962: aload 21
      //   964: monitorenter
      //   965: aload_0
      //   966: iconst_1
      //   967: putfield 133	com/amap/api/mapcore/util/n$i:f	Z
      //   970: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   973: invokevirtual 112	java/lang/Object:notifyAll	()V
      //   976: aload 21
      //   978: monitorexit
      //   979: iload_3
      //   980: istore 13
      //   982: goto +20 -> 1002
      //   985: astore 19
      //   987: aload 21
      //   989: monitorexit
      //   990: aload 19
      //   992: athrow
      //   993: iconst_1
      //   994: istore 13
      //   996: goto +6 -> 1002
      //   999: iload_3
      //   1000: istore 13
      //   1002: iload 13
      //   1004: istore_3
      //   1005: aload 19
      //   1007: astore 21
      //   1009: iload_2
      //   1010: istore 4
      //   1012: iload 8
      //   1014: istore 11
      //   1016: iload 5
      //   1018: istore 12
      //   1020: iload 9
      //   1022: istore_1
      //   1023: iload 7
      //   1025: ifeq +140 -> 1165
      //   1028: iconst_1
      //   1029: istore 6
      //   1031: iload 13
      //   1033: istore_3
      //   1034: aload 19
      //   1036: astore 21
      //   1038: iload_2
      //   1039: istore 4
      //   1041: iload 8
      //   1043: istore 11
      //   1045: iload 5
      //   1047: istore 12
      //   1049: iload 9
      //   1051: istore_1
      //   1052: goto +113 -> 1165
      //   1055: iload_1
      //   1056: istore 13
      //   1058: iload_2
      //   1059: istore 14
      //   1061: iload_3
      //   1062: istore 15
      //   1064: iload 4
      //   1066: istore 16
      //   1068: iload 6
      //   1070: istore 4
      //   1072: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   1075: invokevirtual 188	java/lang/Object:wait	()V
      //   1078: iload 11
      //   1080: istore 6
      //   1082: iload 4
      //   1084: istore_3
      //   1085: iload 10
      //   1087: istore 4
      //   1089: iload 16
      //   1091: istore 7
      //   1093: iload 15
      //   1095: istore 5
      //   1097: iload 14
      //   1099: istore_2
      //   1100: iload 13
      //   1102: istore_1
      //   1103: goto -1023 -> 80
      //   1106: astore 19
      //   1108: aload 21
      //   1110: monitorexit
      //   1111: aload 19
      //   1113: athrow
      //   1114: astore 20
      //   1116: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   1119: astore 19
      //   1121: aload 19
      //   1123: monitorenter
      //   1124: aload_0
      //   1125: invokespecial 91	com/amap/api/mapcore/util/n$i:j	()V
      //   1128: aload_0
      //   1129: invokespecial 93	com/amap/api/mapcore/util/n$i:k	()V
      //   1132: aload 19
      //   1134: monitorexit
      //   1135: aload 20
      //   1137: athrow
      //   1138: astore 20
      //   1140: aload 19
      //   1142: monitorexit
      //   1143: aload 20
      //   1145: athrow
      //   1146: iconst_0
      //   1147: istore 17
      //   1149: goto -949 -> 200
      //   1152: iload 5
      //   1154: istore_3
      //   1155: goto -584 -> 571
      //   1158: iload 12
      //   1160: istore 7
      //   1162: goto -550 -> 612
      //   1165: aload 21
      //   1167: astore 19
      //   1169: iload 15
      //   1171: istore 9
      //   1173: iload 14
      //   1175: istore 8
      //   1177: iload 11
      //   1179: istore 5
      //   1181: iload 12
      //   1183: istore_2
      //   1184: goto -1126 -> 58
      //   1187: iconst_0
      //   1188: istore_2
      //   1189: goto -334 -> 855
      //   1192: iconst_0
      //   1193: istore 9
      //   1195: goto -297 -> 898
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1198	0	this	i
      //   54	1049	1	i1	int
      //   52	1137	2	i2	int
      //   32	1123	3	i3	int
      //   46	1042	4	i4	int
      //   49	1131	5	i5	int
      //   26	1055	6	i6	int
      //   56	1105	7	i7	int
      //   40	1136	8	i8	int
      //   37	1157	9	i9	int
      //   29	1057	10	i10	int
      //   407	771	11	i11	int
      //   68	1114	12	i12	int
      //   446	655	13	i13	int
      //   153	1021	14	i14	int
      //   149	1021	15	i15	int
      //   436	654	16	i16	int
      //   181	967	17	bool1	boolean
      //   288	13	18	bool2	boolean
      //   531	10	19	localRuntimeException	RuntimeException
      //   721	36	19	localObject1	Object
      //   770	6	19	localObject2	Object
      //   795	126	19	localGL10	GL10
      //   985	50	19	localObject3	Object
      //   1106	6	19	localObject4	Object
      //   43	1	20	localObject6	Object
      //   110	6	20	localObject7	Object
      //   139	523	20	localRunnable	Runnable
      //   1114	22	20	localObject8	Object
      //   1138	6	20	localObject9	Object
      //   280	14	22	localn	n
      // Exception table:
      //   from	to	target	type
      //   98	109	110	finally
      //   112	115	110	finally
      //   504	511	531	java/lang/RuntimeException
      //   701	715	721	finally
      //   723	726	721	finally
      //   737	756	770	finally
      //   772	775	770	finally
      //   965	979	985	finally
      //   987	990	985	finally
      //   80	90	1106	finally
      //   118	141	1106	finally
      //   166	197	1106	finally
      //   200	220	1106	finally
      //   231	239	1106	finally
      //   247	258	1106	finally
      //   263	282	1106	finally
      //   293	300	1106	finally
      //   305	314	1106	finally
      //   314	318	1106	finally
      //   323	339	1106	finally
      //   339	364	1106	finally
      //   364	380	1106	finally
      //   380	405	1106	finally
      //   414	425	1106	finally
      //   448	455	1106	finally
      //   462	469	1106	finally
      //   483	492	1106	finally
      //   504	511	1106	finally
      //   511	522	1106	finally
      //   533	543	1106	finally
      //   543	562	1106	finally
      //   571	602	1106	finally
      //   612	623	1106	finally
      //   645	648	1106	finally
      //   1072	1078	1106	finally
      //   1108	1111	1106	finally
      //   58	66	1114	finally
      //   653	660	1114	finally
      //   683	701	1114	finally
      //   726	729	1114	finally
      //   729	737	1114	finally
      //   775	778	1114	finally
      //   785	805	1114	finally
      //   816	828	1114	finally
      //   833	852	1114	finally
      //   862	874	1114	finally
      //   879	895	1114	finally
      //   898	910	1114	finally
      //   915	927	1114	finally
      //   927	935	1114	finally
      //   949	965	1114	finally
      //   990	993	1114	finally
      //   1111	1114	1114	finally
      //   1124	1135	1138	finally
      //   1140	1143	1138	finally
    }
    
    private boolean m()
    {
      boolean bool2 = this.d;
      boolean bool1 = true;
      if ((!bool2) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0))
      {
        if (this.o) {
          return bool1;
        }
        if (this.n == 1) {
          return true;
        }
      }
      bool1 = false;
      return bool1;
    }
    
    public void a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= 1)) {
        synchronized (n.d())
        {
          this.n = paramInt;
          n.d().notifyAll();
          return;
        }
      }
      throw new IllegalArgumentException("renderMode");
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        this.l = paramInt1;
        this.m = paramInt2;
        this.r = true;
        this.o = true;
        this.p = false;
        n.d().notifyAll();
        while ((!this.b) && (!this.d) && (!this.p))
        {
          boolean bool = a();
          if (!bool) {
            break;
          }
          try
          {
            n.d().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable != null) {
        synchronized (n.d())
        {
          this.q.add(paramRunnable);
          n.d().notifyAll();
          return;
        }
      }
      throw new IllegalArgumentException("r must not be null");
    }
    
    public boolean a()
    {
      return (this.h) && (this.i) && (m());
    }
    
    public int b()
    {
      synchronized ()
      {
        int i1 = this.n;
        return i1;
      }
    }
    
    public void c()
    {
      synchronized ()
      {
        this.o = true;
        n.d().notifyAll();
        return;
      }
    }
    
    public void d()
    {
      synchronized ()
      {
        this.e = true;
        this.j = false;
        n.d().notifyAll();
        while ((this.g) && (!this.j))
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            n.d().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void e()
    {
      synchronized ()
      {
        this.e = false;
        n.d().notifyAll();
        while (!this.g)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            if (MapsInitializer.getTextureViewDestorySync())
            {
              n.d().wait();
              continue;
            }
            n.d().wait(2000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void f()
    {
      synchronized ()
      {
        this.c = true;
        n.d().notifyAll();
        while (!this.b)
        {
          boolean bool = this.d;
          if (bool) {
            break;
          }
          try
          {
            if (MapsInitializer.getTextureViewDestorySync())
            {
              n.d().wait();
              continue;
            }
            n.d().wait(2000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void g()
    {
      synchronized ()
      {
        this.c = false;
        this.o = true;
        this.p = false;
        n.d().notifyAll();
        while ((!this.b) && (this.d))
        {
          boolean bool = this.p;
          if (bool) {
            break;
          }
          try
          {
            n.d().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void h()
    {
      synchronized ()
      {
        this.a = true;
        n.d().notifyAll();
        for (;;)
        {
          boolean bool = this.b;
          if (bool) {
            break;
          }
          try
          {
            n.d().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          Thread.currentThread().interrupt();
        }
        return;
      }
    }
    
    public void i()
    {
      this.k = true;
      n.d().notifyAll();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: new 225	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 226	java/lang/StringBuilder:<init>	()V
      //   7: astore_1
      //   8: aload_1
      //   9: ldc -28
      //   11: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: pop
      //   15: aload_1
      //   16: aload_0
      //   17: invokevirtual 236	com/amap/api/mapcore/util/n$i:getId	()J
      //   20: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   23: pop
      //   24: aload_0
      //   25: aload_1
      //   26: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: invokevirtual 246	com/amap/api/mapcore/util/n$i:setName	(Ljava/lang/String;)V
      //   32: aload_0
      //   33: invokespecial 248	com/amap/api/mapcore/util/n$i:l	()V
      //   36: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   39: aload_0
      //   40: invokevirtual 250	com/amap/api/mapcore/util/n$j:a	(Lcom/amap/api/mapcore/util/n$i;)V
      //   43: return
      //   44: astore_1
      //   45: invokestatic 76	com/amap/api/mapcore/util/n:d	()Lcom/amap/api/mapcore/util/n$j;
      //   48: aload_0
      //   49: invokevirtual 250	com/amap/api/mapcore/util/n$j:a	(Lcom/amap/api/mapcore/util/n$i;)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: goto -19 -> 36
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	i
      //   7	19	1	localStringBuilder	StringBuilder
      //   44	9	1	localObject	Object
      //   54	1	1	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   32	36	44	finally
      //   32	36	54	java/lang/InterruptedException
    }
  }
  
  private static class j
  {
    private static String a = "GLThreadManager";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private n.i g;
    
    private void c()
    {
      if (!this.b)
      {
        this.c = 131072;
        if (this.c >= 131072) {
          this.e = true;
        }
        this.b = true;
      }
    }
    
    public void a(n.i parami)
    {
      try
      {
        n.i.a(parami, true);
        if (this.g == parami) {
          this.g = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public void a(GL10 paramGL10)
    {
      try
      {
        if ((!this.d) && (paramGL10 != null))
        {
          c();
          paramGL10 = paramGL10.glGetString(7937);
          if (this.c < 131072)
          {
            this.e = (paramGL10.startsWith("Q3Dimension MSM7500 ") ^ true);
            notifyAll();
          }
          this.f = (this.e ^ true);
          this.d = true;
        }
        return;
      }
      finally {}
    }
    
    public boolean a()
    {
      try
      {
        boolean bool = this.f;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean b()
    {
      try
      {
        c();
        boolean bool = this.e;
        return bool ^ true;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean b(n.i parami)
    {
      if ((this.g != parami) && (this.g != null))
      {
        c();
        if (this.e) {
          return true;
        }
        if (this.g != null) {
          this.g.i();
        }
        return false;
      }
      this.g = parami;
      notifyAll();
      return true;
    }
    
    public void c(n.i parami)
    {
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
    }
  }
  
  public static abstract interface k
  {
    public abstract GL a(GL paramGL);
  }
  
  static class l
    extends Writer
  {
    private StringBuilder a = new StringBuilder();
    
    private void a()
    {
      if (this.a.length() > 0)
      {
        Log.v("GLSurfaceView", this.a.toString());
        this.a.delete(0, this.a.length());
      }
    }
    
    public void close()
    {
      a();
    }
    
    public void flush()
    {
      a();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          a();
        } else {
          this.a.append(c);
        }
        i += 1;
      }
    }
  }
  
  private class m
    extends n.b
  {
    public m(boolean paramBoolean)
    {
      super(8, 8, 8, 0, i, 0);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */