package com.totoro.school.entity.update;

import com.totoro.school.entity.base.BaseModel;

public class UpdateAppReturnModel
  extends BaseModel
{
  private UpdateAppBodyModel body;
  
  public UpdateAppBodyModel getBody()
  {
    return this.body;
  }
  
  public void setBody(UpdateAppBodyModel paramUpdateAppBodyModel)
  {
    this.body = paramUpdateAppBodyModel;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\update\UpdateAppReturnModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */