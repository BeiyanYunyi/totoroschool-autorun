package com.totoro.school.entity.find;

import java.io.Serializable;

public class HomeFocusListModel
  implements Serializable
{
  private String advImgUrl;
  private String advTittle;
  private String advUrl;
  
  public String getAdvImgUrl()
  {
    return this.advImgUrl;
  }
  
  public String getAdvTittle()
  {
    return this.advTittle;
  }
  
  public String getAdvUrl()
  {
    return this.advUrl;
  }
  
  public void setAdvImgUrl(String paramString)
  {
    this.advImgUrl = paramString;
  }
  
  public void setAdvTittle(String paramString)
  {
    this.advTittle = paramString;
  }
  
  public void setAdvUrl(String paramString)
  {
    this.advUrl = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\find\HomeFocusListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */