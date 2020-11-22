package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;

public class lp
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private Bitmap e = null;
  private Bitmap f = null;
  private Bitmap g = null;
  
  public int a()
  {
    return this.a;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.b;
    }
    if (paramInt == 1) {
      return this.c;
    }
    return -1;
  }
  
  public void a(Context paramContext)
  {
    if ((this.e == null) || (this.e.isRecycled())) {
      this.e = dx.a(paramContext, "amap_sdk_lineTexture.png");
    }
    if ((this.f == null) || (this.f.isRecycled())) {
      this.f = dx.a(paramContext, "amap_sdk_lineDashTexture_square.png");
    }
    if ((this.g == null) || (this.g.isRecycled())) {
      this.g = dx.a(paramContext, "amap_sdk_lineDashTexture_circle.png");
    }
    this.a = dx.a(this.e);
    this.b = dx.a(this.f, true);
    this.c = dx.a(this.g, true);
    this.d = dx.a(512, 1024);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void c()
  {
    GLES20.glDeleteTextures(4, new int[] { this.a, this.b, this.c, this.d }, 0);
  }
  
  public void d()
  {
    if ((this.f != null) && (!this.f.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
    if ((this.g != null) && (!this.g.isRecycled()))
    {
      this.g.recycle();
      this.g = null;
    }
    if ((this.e != null) && (!this.e.isRecycled()))
    {
      this.e.recycle();
      this.e = null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\lp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */