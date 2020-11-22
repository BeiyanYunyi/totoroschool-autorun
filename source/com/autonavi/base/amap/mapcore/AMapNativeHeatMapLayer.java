package com.autonavi.base.amap.mapcore;

public class AMapNativeHeatMapLayer
{
  public static native long nativeCreate();
  
  public static native long nativeDestroy(long paramLong);
  
  public static native Object nativeGetHeatMapItem(long paramLong, double paramDouble1, double paramDouble2);
  
  public static native void nativeRender(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, float paramFloat);
  
  public static native void nativeSetGLShaderManager(long paramLong1, long paramLong2);
  
  public static native void nativeSetOptions(long paramLong, double[] paramArrayOfDouble, int paramInt1, float paramFloat1, int[] paramArrayOfInt, float[] paramArrayOfFloat, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt2, double paramDouble);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AMapNativeHeatMapLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */