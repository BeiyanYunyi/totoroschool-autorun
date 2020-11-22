package com.autonavi.base.amap.mapcore;

public class AMapNativeRenderer
{
  public static native void nativeDrawGradientColorLine(float[] paramArrayOfFloat1, int paramInt1, float paramFloat, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat2, int paramInt5, int paramInt6);
  
  public static native void nativeDrawLineByMultiColor(float[] paramArrayOfFloat1, int paramInt1, float paramFloat, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int paramInt4, float[] paramArrayOfFloat2, int paramInt5, int paramInt6);
  
  public static native void nativeDrawLineByMultiTextureID(float[] paramArrayOfFloat1, int paramInt1, float paramFloat1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, float paramFloat2, float[] paramArrayOfFloat2, int paramInt4, int paramInt5);
  
  public static void nativeDrawLineByTextureID(float[] paramArrayOfFloat1, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat2, int paramInt3, int paramInt4)
  {
    nativeDrawLineByTextureID(paramArrayOfFloat1, paramInt1, paramFloat1, paramInt2, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramArrayOfFloat2, paramInt3, paramInt4, false);
  }
  
  public static native void nativeDrawLineByTextureID(float[] paramArrayOfFloat1, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float[] paramArrayOfFloat2, int paramInt3, int paramInt4, boolean paramBoolean4);
  
  public static native void nativeDrawLineInit();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AMapNativeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */