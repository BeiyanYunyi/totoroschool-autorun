package com.totoro.school.entity.upload;

public class UploadImageReturnModel
{
  private UploadImageBodyModel body;
  private UploadImageHeadModel header;
  
  public UploadImageBodyModel getBody()
  {
    return this.body;
  }
  
  public UploadImageHeadModel getHeader()
  {
    return this.header;
  }
  
  public void setBody(UploadImageBodyModel paramUploadImageBodyModel)
  {
    this.body = paramUploadImageBodyModel;
  }
  
  public void setHeader(UploadImageHeadModel paramUploadImageHeadModel)
  {
    this.header = paramUploadImageHeadModel;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadImageReturnModel{body=");
    localStringBuilder.append(this.body);
    localStringBuilder.append(", header=");
    localStringBuilder.append(this.header);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\upload\UploadImageReturnModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */