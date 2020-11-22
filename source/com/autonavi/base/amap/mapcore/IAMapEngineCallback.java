package com.autonavi.base.amap.mapcore;

public abstract interface IAMapEngineCallback
{
  public abstract void OnIndoorBuildingActivity(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void cancelRequireMapData(Object paramObject);
  
  public abstract int generateRequestId();
  
  public abstract void onMapRender(int paramInt1, int paramInt2);
  
  public abstract void reloadMapResource(int paramInt1, String paramString, int paramInt2);
  
  public abstract byte[] requireCharBitmap(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte[] requireCharsWidths(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  @Deprecated
  public abstract void requireMapData(int paramInt, byte[] paramArrayOfByte);
  
  public abstract int requireMapDataAsyn(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void requireMapRender(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte[] requireMapResource(int paramInt, String paramString);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\IAMapEngineCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */