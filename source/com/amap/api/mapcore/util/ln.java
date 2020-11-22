package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ln
{
  List<Float> a = new ArrayList();
  List<Float> b = new ArrayList();
  private FloatBuffer c;
  private FloatBuffer d;
  private int e = 0;
  private float f;
  private float g = 0.0F;
  private float h = 0.0F;
  
  public ln(List<Float> paramList1, List<Float> paramList2)
  {
    this.a = paramList1;
    this.b = paramList2;
    Object localObject;
    if (this.c == null)
    {
      localObject = ByteBuffer.allocateDirect(paramList1.size() * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.c = ((ByteBuffer)localObject).asFloatBuffer();
    }
    this.c.clear();
    int j = 1;
    int i = 1;
    float f9 = 0.0F;
    float f6 = 1000000.0F;
    float f3 = 0.0F;
    float f2 = 1000000.0F;
    float f10;
    for (float f1 = 0.0F; j < paramList1.size() + 1; f1 = f10)
    {
      localObject = (Float)paramList1.get(j - 1);
      this.c.put(((Float)localObject).floatValue());
      float f5 = f9;
      float f4 = f6;
      if (i == 1)
      {
        f5 = Math.max(((Float)localObject).floatValue(), f9);
        f4 = Math.min(((Float)localObject).floatValue(), f6);
      }
      float f8 = f3;
      float f7 = f2;
      if (i == 2)
      {
        f8 = Math.max(((Float)localObject).floatValue(), f3);
        f7 = Math.min(((Float)localObject).floatValue(), f2);
      }
      int k = i;
      f10 = f1;
      if (i == 3)
      {
        f10 = Math.max(f1, ((Float)localObject).floatValue());
        k = 0;
      }
      i = k + 1;
      j += 1;
      f9 = f5;
      f6 = f4;
      f3 = f8;
      f2 = f7;
    }
    f1 = Math.abs(f9 - f6);
    f2 = Math.abs(f3 - f2);
    if (f1 > f2) {
      f3 = f1;
    } else {
      f3 = f2;
    }
    this.g = f3;
    f3 = f1;
    if (f1 > f2) {
      f3 = f2;
    }
    this.h = f3;
    this.c.position(0);
    if (this.d == null)
    {
      paramList1 = ByteBuffer.allocateDirect(paramList2.size() * 4);
      paramList1.order(ByteOrder.nativeOrder());
      this.d = paramList1.asFloatBuffer();
    }
    this.d.clear();
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (Float)paramList1.next();
      this.d.put(paramList2.floatValue());
    }
    this.d.position(0);
  }
  
  public float a()
  {
    return this.g;
  }
  
  public void a(float paramFloat)
  {
    this.f = (-paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(cl.b paramb, float[] paramArrayOfFloat)
  {
    Matrix.rotateM(paramArrayOfFloat, 0, this.f, 0.0F, 0.0F, 1.0F);
    GLES20.glUseProgram(paramb.d);
    GLES20.glClear(256);
    GLES20.glEnable(2929);
    GLES20.glDepthMask(true);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glBindTexture(3553, this.e);
    GLES20.glEnableVertexAttribArray(paramb.h);
    GLES20.glVertexAttribPointer(paramb.h, 2, 5126, false, 8, this.d);
    GLES20.glEnableVertexAttribArray(paramb.c);
    GLES20.glVertexAttribPointer(paramb.c, 3, 5126, false, 12, this.c);
    GLES20.glUniformMatrix4fv(paramb.g, 1, false, paramArrayOfFloat, 0);
    GLES20.glDrawArrays(4, 0, this.a.size() / 3);
    GLES20.glBindTexture(3553, 0);
    GLES20.glDisable(2929);
    GLES20.glDisableVertexAttribArray(paramb.c);
    GLES20.glDisableVertexAttribArray(paramb.h);
    GLES20.glUseProgram(0);
  }
  
  public float b()
  {
    return this.h;
  }
  
  public void c()
  {
    this.a.clear();
    this.d.clear();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */