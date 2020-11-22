package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public class GLCrossVector
  extends GLOverlay
{
  public GLCrossVector(int paramInt1, IAMapDelegate paramIAMapDelegate, int paramInt2)
  {
    super(paramInt1, paramIAMapDelegate, paramInt2);
    if ((paramIAMapDelegate != null) && (paramIAMapDelegate.getGLMapEngine() != null)) {
      this.mNativeInstance = paramIAMapDelegate.getGLMapEngine().createOverlay(paramInt1, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
    }
  }
  
  private static native void nativeAddVectorCar(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeAddVectorData(long paramLong, int[] paramArrayOfInt, byte[] paramArrayOfByte);
  
  private static native int nativeGetFBOTextureId(long paramLong);
  
  private static native void nativeInitFBOTexture(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nativeSetArrowResId(long paramLong, boolean paramBoolean, int paramInt);
  
  private static native void nativeSetBackgroundResId(long paramLong, int paramInt);
  
  private static native void nativeSetCarResId(long paramLong, int paramInt);
  
  public void addVectorCar(int paramInt1, int paramInt2, int paramInt3)
  {
    nativeAddVectorCar(this.mNativeInstance, paramInt1, paramInt2, paramInt3);
  }
  
  public int addVectorItem(AVectorCrossAttr paramAVectorCrossAttr, byte[] paramArrayOfByte, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void addVectorRemainDis(int paramInt) {}
  
  public int getFBOTextureId()
  {
    return nativeGetFBOTextureId(this.mNativeInstance);
  }
  
  public void initFBOTexture(int paramInt1, int paramInt2)
  {
    nativeInitFBOTexture(this.mNativeInstance, paramInt1, paramInt2);
  }
  
  public void setArrowResId(boolean paramBoolean, int paramInt)
  {
    nativeSetArrowResId(this.mNativeInstance, paramBoolean, paramInt);
  }
  
  public void setBackgroundResId(int paramInt)
  {
    nativeSetBackgroundResId(this.mNativeInstance, paramInt);
  }
  
  public void setCarResId(int paramInt)
  {
    nativeSetCarResId(this.mNativeInstance, paramInt);
  }
  
  public void setRoadResId(boolean paramBoolean, int paramInt) {}
  
  public void setSkyResId(boolean paramBoolean, int paramInt) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\gloverlay\GLCrossVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */