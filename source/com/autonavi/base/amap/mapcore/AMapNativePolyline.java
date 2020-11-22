package com.autonavi.base.amap.mapcore;

public class AMapNativePolyline
{
  public static native long nativeCreate();
  
  public static native long nativeDestroy(long paramLong);
  
  public static native void nativeDrawLineByTextureID(long paramLong, float[] paramArrayOfFloat1, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat2, int paramInt3, int paramInt4);
  
  public static native void nativeSetGLShaderManager(long paramLong1, long paramLong2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AMapNativePolyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */