package com.totoro.school.entity.upload;

import java.io.Serializable;

public class UploadImageBodyModel
  implements Serializable
{
  private String customerId;
  
  public String getCustomerId()
  {
    return this.customerId;
  }
  
  public void setCustomerId(String paramString)
  {
    this.customerId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadImageBodyModel{customerId='");
    localStringBuilder.append(this.customerId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\upload\UploadImageBodyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */