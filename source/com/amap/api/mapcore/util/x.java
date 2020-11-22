package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class x
{
  public static int a = 200;
  float[] b = null;
  int c = 0;
  int d = 0;
  private boolean e = false;
  private boolean f = false;
  private BitmapDescriptor g;
  private FloatBuffer h;
  private ShortBuffer i;
  private int j = 0;
  private cl.a k;
  private cl l;
  
  public x(float[] paramArrayOfFloat, aa paramaa)
  {
    this.b = paramArrayOfFloat;
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.j == 0)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.j = arrayOfInt[0];
    }
    if (this.j == 0) {
      return;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.j);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    if (this.j != 0) {
      this.f = true;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      int m = GLES20.glGetError();
      if (m == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(m);
      Log.e("amap", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(m);
      throw new RuntimeException(localStringBuilder.toString());
    }
    finally {}
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return;
    }
    if (this.h == null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * a * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.h = localByteBuffer.asFloatBuffer();
    }
    this.h.clear();
    int i4 = 0;
    int i1 = 0;
    int i2;
    int i3;
    while (i1 < a)
    {
      int i5 = paramArrayOfFloat.length;
      i2 = 0;
      i3 = 0;
      while (i2 < i5)
      {
        float f1 = paramArrayOfFloat[i2];
        if (i3 % 6 == 3) {
          this.h.put(i1);
        } else {
          this.h.put(f1);
        }
        i3 += 1;
        i2 += 1;
      }
      i1 += 1;
    }
    this.h.position(0);
    if (this.i == null)
    {
      paramArrayOfFloat = ByteBuffer.allocateDirect(a * 6 * 2);
      paramArrayOfFloat.order(ByteOrder.nativeOrder());
      this.i = paramArrayOfFloat.asShortBuffer();
      paramArrayOfFloat = new short[a * 6];
      i1 = i4;
      while (i1 < a)
      {
        i2 = i1 * 6;
        i3 = i1 * 4;
        int m = (short)(i3 + 0);
        paramArrayOfFloat[(i2 + 0)] = m;
        paramArrayOfFloat[(i2 + 1)] = ((short)(i3 + 1));
        int n = (short)(i3 + 2);
        paramArrayOfFloat[(i2 + 2)] = n;
        paramArrayOfFloat[(i2 + 3)] = m;
        paramArrayOfFloat[(i2 + 4)] = n;
        paramArrayOfFloat[(i2 + 5)] = ((short)(i3 + 3));
        i1 += 1;
      }
      this.i.put(paramArrayOfFloat);
      this.i.flip();
    }
    this.e = true;
  }
  
  private void e()
  {
    if (this.c == 0)
    {
      int[] arrayOfInt = new int[2];
      GLES20.glGenBuffers(2, arrayOfInt, 0);
      this.c = arrayOfInt[0];
      this.d = arrayOfInt[1];
      GLES20.glBindBuffer(34962, this.c);
      GLES20.glBufferData(34962, this.h.limit() * 4, this.h, 35044);
      GLES20.glBindBuffer(34963, this.d);
      GLES20.glBufferData(34963, a * 6 * 2, this.i, 35044);
      a("bindVbo");
      this.h.clear();
      this.h = null;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.l == null) {
        break label49;
      }
      this.k = ((cl.a)this.l.a(4));
      return;
    }
    catch (Throwable localThrowable)
    {
      label49:
      for (;;) {}
    }
    a = 1;
    if (this.l != null) {
      this.k = ((cl.a)this.l.a(4));
    }
  }
  
  public void a()
  {
    if ((this.b != null) && (!this.e)) {
      a(this.b);
    }
  }
  
  public void a(cl paramcl)
  {
    this.l = paramcl;
  }
  
  public void a(BitmapDescriptor paramBitmapDescriptor)
  {
    this.g = paramBitmapDescriptor;
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if ((!this.f) && (this.g != null)) {
      a(this.g.getBitmap());
    }
    if (this.j == 0) {
      return;
    }
    if ((this.k == null) || (this.k.c())) {
      f();
    }
    e();
    GLES20.glUseProgram(this.k.d);
    GLES20.glUniform4f(this.k.j, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    GLES20.glUniform3fv(this.k.i, paramInt, paramArrayOfFloat3, 0);
    GLES20.glDisable(2929);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.j);
    GLES20.glEnableVertexAttribArray(this.k.c);
    GLES20.glBindBuffer(34962, this.c);
    GLES20.glVertexAttribPointer(this.k.c, 4, 5126, false, 24, 0);
    GLES20.glEnableVertexAttribArray(this.k.h);
    GLES20.glVertexAttribPointer(this.k.h, 2, 5126, false, 24, 16);
    GLES20.glUniformMatrix4fv(this.k.g, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(this.k.k, 1, false, paramArrayOfFloat2, 0);
    GLES20.glBindBuffer(34963, this.d);
    GLES20.glDrawElements(4, paramInt * 6, 5123, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindBuffer(34962, 0);
    GLES20.glDisableVertexAttribArray(this.k.c);
    GLES20.glDisableVertexAttribArray(this.k.h);
    GLES20.glUseProgram(0);
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (this.h != null) {
      this.h.clear();
    }
    if (this.i != null) {
      this.i.clear();
    }
    if (this.g != null) {
      this.g = null;
    }
    GLES20.glDeleteBuffers(2, new int[] { this.c, this.d }, 0);
    if (this.j != 0) {
      GLES20.glDeleteTextures(1, new int[] { this.j }, 0);
    }
    this.c = 0;
    this.d = 0;
    this.b = null;
    this.e = false;
    this.f = false;
    this.c = 0;
    this.d = 0;
    this.l = null;
  }
  
  public boolean d()
  {
    return this.l != null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */