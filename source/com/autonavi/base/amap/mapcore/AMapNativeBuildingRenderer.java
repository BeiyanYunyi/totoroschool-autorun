package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BuildingOverlayOptions;

public class AMapNativeBuildingRenderer
{
  public static native void addBuildingOptions(long paramLong, BuildingOverlayOptions paramBuildingOverlayOptions);
  
  public static native void nativeClearBuildingOptions(long paramLong);
  
  public static native long nativeCreate();
  
  public static native void nativeDestory(long paramLong);
  
  public static native void nativeSetGLShaderManager(long paramLong1, long paramLong2);
  
  public static native void render(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt);
  
  public static native void setCurTileIDs(long paramLong, int[] paramArrayOfInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AMapNativeBuildingRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */