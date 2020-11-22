package com.pgyersdk.b.c;

import java.nio.IntBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

final class d
  implements Runnable
{
  d(int paramInt1, int paramInt2, IntBuffer paramIntBuffer, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    Object localObject = (EGL10)EGLContext.getEGL();
    ((EGL10)localObject).eglWaitGL();
    localObject = (GL10)((EGL10)localObject).eglGetCurrentContext().getGL();
    ((GL10)localObject).glFinish();
    try
    {
      Thread.sleep(200L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    ((GL10)localObject).glReadPixels(0, 0, this.a, this.b + 0, 6408, 5121, this.c);
    this.d.countDown();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */