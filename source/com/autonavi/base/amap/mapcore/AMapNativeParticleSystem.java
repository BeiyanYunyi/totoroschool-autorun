package com.autonavi.base.amap.mapcore;

public class AMapNativeParticleSystem
{
  public static native int getCurrentParticleNum(long paramLong);
  
  public static native long nativeCreate();
  
  public static native long nativeCreateConstantRotationOverLife(float paramFloat);
  
  public static native long nativeCreateCurveSizeOverLife(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native long nativeCreateParticleEmissionModule(int paramInt1, int paramInt2);
  
  public static native long nativeCreateParticleOverLifeModule();
  
  public static native long nativeCreateRandomColorBetWeenTwoConstants(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
  
  public static native long nativeCreateRandomVelocityBetweenTwoConstants(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  public static native long nativeCreateRectParticleShape(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean);
  
  public static native long nativeCreateSinglePointParticleShape(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public static native long nativeDestroy(long paramLong);
  
  public static native void nativeReleaseColorGenerate(long paramLong);
  
  public static native void nativeReleaseParticleEmissonModule(long paramLong);
  
  public static native void nativeReleaseParticleOverLifeModule(long paramLong);
  
  public static native void nativeReleaseParticleShapeModule(long paramLong);
  
  public static native void nativeReleaseRotationOverLife(long paramLong);
  
  public static native void nativeReleaseSizeOverLife(long paramLong);
  
  public static native void nativeReleaseVelocityOverLife(long paramLong);
  
  public static native void nativeRender(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void nativeSetGLShaderManager(long paramLong1, long paramLong2);
  
  public static native void nativeSetOverLifeItem(long paramLong1, long paramLong2, int paramInt);
  
  public static native void nativeSetTextureId(long paramLong, int paramInt);
  
  public static native void setDuration(long paramLong1, long paramLong2);
  
  public static native void setLoop(long paramLong, boolean paramBoolean);
  
  public static native void setMaxParticles(long paramLong, int paramInt);
  
  public static native void setParticleEmission(long paramLong1, long paramLong2);
  
  public static native void setParticleLifeTime(long paramLong1, long paramLong2);
  
  public static native void setParticleOverLifeModule(long paramLong1, long paramLong2);
  
  public static native void setParticleShapeModule(long paramLong1, long paramLong2);
  
  public static native void setParticleStartSpeed(long paramLong1, long paramLong2);
  
  public static native void setPreWram(long paramLong, boolean paramBoolean);
  
  public static native void setStartColor(long paramLong1, long paramLong2);
  
  public static native void setStartParticleSize(long paramLong, float paramFloat1, float paramFloat2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AMapNativeParticleSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */