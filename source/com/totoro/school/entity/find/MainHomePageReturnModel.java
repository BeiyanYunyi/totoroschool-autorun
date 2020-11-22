package com.totoro.school.entity.find;

import com.totoro.school.entity.HeaderModel;
import java.io.Serializable;

public class MainHomePageReturnModel
  implements Serializable
{
  private MainHomePageBodyModel body;
  private HeaderModel header;
  
  public MainHomePageBodyModel getBody()
  {
    return this.body;
  }
  
  public HeaderModel getHeader()
  {
    return this.header;
  }
  
  public void setBody(MainHomePageBodyModel paramMainHomePageBodyModel)
  {
    this.body = paramMainHomePageBodyModel;
  }
  
  public void setHeader(HeaderModel paramHeaderModel)
  {
    this.header = paramHeaderModel;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\find\MainHomePageReturnModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */