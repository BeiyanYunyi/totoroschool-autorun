package com.totoro.school.entity.update;

import java.io.Serializable;

public class UpdateAppBodyModel
  implements Serializable
{
  private String picPath;
  private String type;
  private String url;
  private String version;
  
  public String getPicPath()
  {
    return this.picPath;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setPicPath(String paramString)
  {
    this.picPath = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\update\UpdateAppBodyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */