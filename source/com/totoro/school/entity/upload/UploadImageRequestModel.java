package com.totoro.school.entity.upload;

import java.io.Serializable;
import java.util.List;

public class UploadImageRequestModel
  implements Serializable
{
  private List<String> picIdList;
  
  public UploadImageRequestModel(List<String> paramList)
  {
    this.picIdList = paramList;
  }
  
  public List<String> getPicIdList()
  {
    return this.picIdList;
  }
  
  public void setPicIdList(List<String> paramList)
  {
    this.picIdList = paramList;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\upload\UploadImageRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */