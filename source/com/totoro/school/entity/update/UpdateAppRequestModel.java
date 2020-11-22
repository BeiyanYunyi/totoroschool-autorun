package com.totoro.school.entity.update;

import java.io.Serializable;

public class UpdateAppRequestModel
  implements Serializable
{
  private String type;
  
  public UpdateAppRequestModel(String paramString)
  {
    this.type = paramString;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\update\UpdateAppRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */