package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Log;
import android.view.SurfaceHolder;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class df
{
  private static float[] a = new float['Ѐ'];
  
  private static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    if (parame == null) {
      return;
    }
    parame.a();
    GLES20.glEnable(3042);
    GLES20.glDisable(2929);
    GLES20.glBlendFunc(770, 771);
    float f1 = Color.alpha(paramInt2) / 255.0F;
    float f2 = Color.red(paramInt2) / 255.0F;
    float f3 = Color.green(paramInt2) / 255.0F;
    float f4 = Color.blue(paramInt2) / 255.0F;
    GLES20.glLineWidth(paramFloat);
    GLES20.glEnableVertexAttribArray(parame.b);
    GLES20.glVertexAttribPointer(parame.b, 3, 5126, false, 0, paramFloatBuffer);
    GLES20.glUniform4fv(parame.c, 1, new float[] { f2, f3, f4, f1 }, 0);
    GLES20.glUniformMatrix4fv(parame.a, 1, false, paramArrayOfFloat, 0);
    GLES20.glDrawArrays(paramInt1, paramInt3, paramInt4);
    GLES20.glDisableVertexAttribArray(parame.b);
    GLES20.glDisable(3042);
    GLES20.glUseProgram(0);
  }
  
  private static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat, int paramInt3, float[] paramArrayOfFloat)
  {
    a(parame, 2, paramInt2, paramFloatBuffer, paramFloat, 1, paramInt3 - 1, paramArrayOfFloat);
  }
  
  public static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat1, int paramInt3, float[] paramArrayOfFloat, float paramFloat2, int paramInt4, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt4 != -1))
    {
      a(parame, paramInt1, paramInt2, paramFloatBuffer, paramFloat1 * paramFloat2, paramInt3, paramArrayOfFloat, paramInt4);
      return;
    }
    a(parame, paramInt1, paramInt2, paramFloatBuffer, paramFloat1, paramInt3, paramArrayOfFloat);
  }
  
  public static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat1, int paramInt3, float[] paramArrayOfFloat, float paramFloat2, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(parame, 6, paramInt1, paramFloatBuffer, 1.0F, paramInt3, paramArrayOfFloat);
    if (paramBoolean2) {
      a(parame, paramInt1, paramInt2, paramFloatBuffer, paramFloat1, paramInt3, paramArrayOfFloat, paramFloat2, paramInt4, paramBoolean1);
    }
  }
  
  private static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat, int paramInt3, float[] paramArrayOfFloat, int paramInt4)
  {
    for (;;)
    {
      try
      {
        float f1 = Color.alpha(paramInt2) / 255.0F;
        float f2 = Color.red(paramInt2) / 255.0F;
        float f3 = Color.green(paramInt2) / 255.0F;
        float f4 = Color.blue(paramInt2) / 255.0F;
        if (paramInt3 < 3) {
          return;
        }
        paramInt2 = (paramInt3 - 1) * 3;
        if (paramFloatBuffer != null)
        {
          if (paramFloatBuffer.limit() < paramInt2 + 3) {
            return;
          }
          if ((a == null) || (a.length < paramInt2))
          {
            a = new float[paramInt2];
            break label156;
            if (paramInt1 < paramInt2)
            {
              a[paramInt1] = paramFloatBuffer.get(paramInt1 + 3);
              paramInt1 += 1;
              continue;
            }
            AMapNativeRenderer.nativeDrawLineByTextureID(a, paramInt2, paramFloat, paramInt4, f2, f3, f4, f1, 0.0F, true, true, false, paramArrayOfFloat, 3, 0, true);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable parame)
      {
        gk.c(parame, "GlesUtility", "drawCircleLine");
        return;
      }
      label156:
      paramInt1 = 0;
    }
  }
  
  public static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, float paramFloat1, FloatBuffer paramFloatBuffer2, int paramInt3, int paramInt4, float[] paramArrayOfFloat, int paramInt5, float paramFloat2, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt5 != -1)) {}
    try
    {
      float f1 = Color.alpha(paramInt2) / 255.0F;
      float f2 = Color.red(paramInt2) / 255.0F;
      float f3 = Color.green(paramInt2) / 255.0F;
      float f4 = Color.blue(paramInt2) / 255.0F;
      if (paramInt3 < 3) {
        return;
      }
      paramInt1 = paramInt3 * 3;
      if (paramFloatBuffer1 != null)
      {
        if (paramFloatBuffer1.limit() < paramInt1) {
          return;
        }
        if ((a == null) || (a.length < paramInt1)) {
          a = new float[paramInt1];
        }
        paramFloatBuffer1.get(a, 0, paramInt1);
        AMapNativeRenderer.nativeDrawLineByTextureID(a, paramInt1, paramFloat2 * paramFloat1, paramInt5, f2, f3, f4, f1, 0.0F, false, true, false, paramArrayOfFloat, paramInt6, paramInt7, true);
        return;
      }
      return;
    }
    catch (Throwable paramFloatBuffer2)
    {
      for (;;) {}
    }
    b(parame, 2, paramInt2, paramFloatBuffer1, paramFloat1, paramInt3, paramArrayOfFloat);
    return;
    b(parame, 2, paramInt2, paramFloatBuffer1, paramFloat1, paramInt3, paramArrayOfFloat);
  }
  
  public static void a(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, float paramFloat1, FloatBuffer paramFloatBuffer2, int paramInt3, int paramInt4, float[] paramArrayOfFloat, int paramInt5, float paramFloat2, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(parame, 4, paramInt1, paramFloatBuffer2, 1.0F, paramInt4, paramArrayOfFloat);
    if (paramBoolean2) {
      a(parame, paramInt1, paramInt2, paramFloatBuffer1, paramFloat1, paramFloatBuffer2, paramInt3, paramInt4, paramArrayOfFloat, paramInt5, paramFloat2, paramInt6, paramInt7, paramBoolean1);
    }
  }
  
  public static void a(IGLSurfaceView paramIGLSurfaceView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt4 > 0)
    {
      SurfaceHolder localSurfaceHolder = paramIGLSurfaceView.getHolder();
      if (localSurfaceHolder != null) {
        localSurfaceHolder.setFormat(-3);
      }
    }
    paramIGLSurfaceView.setEGLContextFactory(new b());
    paramIGLSurfaceView.setEGLConfigChooser(new a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(i);
    Log.e("amap", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(i);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private static void b(cl.e parame, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, float paramFloat, int paramInt3, float[] paramArrayOfFloat)
  {
    a(parame, paramInt1, paramInt2, paramFloatBuffer, paramFloat, 0, paramInt3, paramArrayOfFloat);
  }
  
  public static class a
    extends dd
  {
    private static int g = 4;
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    private int[] h = new int[1];
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.h)) {
        return this.h[0];
      }
      return paramInt2;
    }
    
    private df.c a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      df.c localc = new df.c(null);
      localc.a = a(2, true);
      paramEGL10.eglChooseConfig(paramEGLDisplay, localc.a, null, 0, localc.b);
      if (localc.b[0] <= 0)
      {
        localc.a = a(2, false);
        paramEGL10.eglChooseConfig(paramEGLDisplay, localc.a, null, 0, localc.b);
        if (localc.b[0] <= 0) {
          return null;
        }
      }
      return localc;
    }
    
    private int[] a(int paramInt, boolean paramBoolean)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= this.e) && (m >= this.f))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == this.a) && (m == this.b) && (n == this.c) && (i1 == this.d)) {
            return localEGLConfig;
          }
        }
        i += 1;
      }
      return null;
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      Object localObject1 = a(paramEGL10, paramEGLDisplay);
      if ((localObject1 != null) && (((df.c)localObject1).a != null))
      {
        Object localObject2 = new EGLConfig[localObject1.b[0]];
        paramEGL10.eglChooseConfig(paramEGLDisplay, ((df.c)localObject1).a, (EGLConfig[])localObject2, localObject1.b[0], ((df.c)localObject1).b);
        localObject2 = a(paramEGL10, paramEGLDisplay, (EGLConfig[])localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          this.a = 8;
          this.b = 8;
          this.c = 8;
          df.c localc = a(paramEGL10, paramEGLDisplay);
          localObject1 = localObject2;
          if (localc != null)
          {
            localObject1 = localObject2;
            if (localc.a != null)
            {
              localObject1 = new EGLConfig[localc.b[0]];
              paramEGL10.eglChooseConfig(paramEGLDisplay, localc.a, (EGLConfig[])localObject1, localc.b[0], localc.b);
              localObject1 = a(paramEGL10, paramEGLDisplay, (EGLConfig[])localObject1);
            }
          }
        }
        return (EGLConfig)localObject1;
      }
      return null;
    }
  }
  
  public static class b
    extends de
  {
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        return paramEGL10;
      }
      catch (Throwable paramEGL10)
      {
        paramEGL10.printStackTrace();
      }
      return null;
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    }
  }
  
  private static class c
  {
    public int[] a = null;
    public int[] b = new int[1];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */