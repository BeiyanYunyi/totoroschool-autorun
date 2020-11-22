package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class ls
{
  public FloatBuffer a;
  public ShortBuffer b;
  float[] c = { -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  short[] d = { 0, 1, 3, 0, 3, 2 };
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.7F;
  private GLAlphaAnimation i;
  
  public ls()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.d.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.b = localByteBuffer.asShortBuffer();
    this.b.put(this.d);
    this.b.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.c.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.a = localByteBuffer.asFloatBuffer();
    this.a.put(this.c);
    this.a.position(0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = (paramInt1 / 255.0F);
    this.f = (paramInt2 / 255.0F);
    this.g = (paramInt3 / 255.0F);
    this.h = (paramInt4 / 255.0F);
  }
  
  public void a(GLAlphaAnimation paramGLAlphaAnimation)
  {
    if ((this.i != null) && (!this.i.hasEnded())) {
      this.i.cancel();
    }
    if (paramGLAlphaAnimation == null) {
      return;
    }
    this.i = paramGLAlphaAnimation;
    this.i.start();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */