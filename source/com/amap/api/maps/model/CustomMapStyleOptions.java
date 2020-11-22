package com.amap.api.maps.model;

public class CustomMapStyleOptions
{
  private boolean enable = true;
  private byte[] styleData = null;
  private String styleDataPath = null;
  private byte[] styleExtraData = null;
  private String styleExtraPath = null;
  private String styleId = null;
  private byte[] styleTextureData = null;
  private String styleTexturePath = null;
  
  public byte[] getStyleData()
  {
    return this.styleData;
  }
  
  public String getStyleDataPath()
  {
    return this.styleDataPath;
  }
  
  public byte[] getStyleExtraData()
  {
    return this.styleExtraData;
  }
  
  public String getStyleExtraPath()
  {
    return this.styleExtraPath;
  }
  
  public String getStyleId()
  {
    return this.styleId;
  }
  
  public byte[] getStyleTextureData()
  {
    return this.styleTextureData;
  }
  
  public String getStyleTexturePath()
  {
    return this.styleTexturePath;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public CustomMapStyleOptions setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
    return this;
  }
  
  public CustomMapStyleOptions setStyleData(byte[] paramArrayOfByte)
  {
    this.styleData = paramArrayOfByte;
    return this;
  }
  
  public CustomMapStyleOptions setStyleDataPath(String paramString)
  {
    this.styleDataPath = paramString;
    return this;
  }
  
  public CustomMapStyleOptions setStyleExtraData(byte[] paramArrayOfByte)
  {
    this.styleExtraData = paramArrayOfByte;
    return this;
  }
  
  public CustomMapStyleOptions setStyleExtraPath(String paramString)
  {
    this.styleExtraPath = paramString;
    return this;
  }
  
  public CustomMapStyleOptions setStyleId(String paramString)
  {
    this.styleId = paramString;
    return this;
  }
  
  public CustomMapStyleOptions setStyleTextureData(byte[] paramArrayOfByte)
  {
    this.styleTextureData = paramArrayOfByte;
    return this;
  }
  
  public CustomMapStyleOptions setStyleTexturePath(String paramString)
  {
    this.styleTexturePath = paramString;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\CustomMapStyleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */