package com.totoro.school.entity.find;

import java.io.Serializable;

public class HomeNoticeListModel
  implements Serializable
{
  private String noticeTittle;
  private String noticeUrl;
  
  public String getNoticeTittle()
  {
    return this.noticeTittle;
  }
  
  public String getNoticeUrl()
  {
    return this.noticeUrl;
  }
  
  public void setNoticeTittle(String paramString)
  {
    this.noticeTittle = paramString;
  }
  
  public void setNoticeUrl(String paramString)
  {
    this.noticeUrl = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\find\HomeNoticeListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */