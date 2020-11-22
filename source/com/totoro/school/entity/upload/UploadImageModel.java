package com.totoro.school.entity.upload;

import java.io.Serializable;

public class UploadImageModel
  implements Serializable
{
  private String QRCodePath;
  private String allBigPath;
  private String allSmallPath;
  private String fkId;
  private String halfBigPath;
  private String halfSmallPath;
  
  public String getAllBigPath()
  {
    return this.allBigPath;
  }
  
  public String getAllSmallPath()
  {
    return this.allSmallPath;
  }
  
  public String getFkId()
  {
    return this.fkId;
  }
  
  public String getHalfBigPath()
  {
    return this.halfBigPath;
  }
  
  public String getHalfSmallPath()
  {
    return this.halfSmallPath;
  }
  
  public String getQRCodePath()
  {
    return this.QRCodePath;
  }
  
  public void setAllBigPath(String paramString)
  {
    this.allBigPath = paramString;
  }
  
  public void setAllSmallPath(String paramString)
  {
    this.allSmallPath = paramString;
  }
  
  public void setFkId(String paramString)
  {
    this.fkId = paramString;
  }
  
  public void setHalfBigPath(String paramString)
  {
    this.halfBigPath = paramString;
  }
  
  public void setHalfSmallPath(String paramString)
  {
    this.halfSmallPath = paramString;
  }
  
  public void setQRCodePath(String paramString)
  {
    this.QRCodePath = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\upload\UploadImageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */