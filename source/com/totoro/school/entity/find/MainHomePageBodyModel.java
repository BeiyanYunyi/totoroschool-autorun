package com.totoro.school.entity.find;

import java.io.Serializable;
import java.util.List;

public class MainHomePageBodyModel
  implements Serializable
{
  private List<HomeActivityListModel> activityList;
  private List<HomeFocusListModel> advList;
  private String isRead;
  private String isSign;
  private List<JdRandGoodsListModel> jdRandGoodsList;
  private List<HomeNoticeListModel> noticeList;
  private String signPicUrl;
  
  public List<HomeActivityListModel> getActivityList()
  {
    return this.activityList;
  }
  
  public List<HomeFocusListModel> getAdvList()
  {
    return this.advList;
  }
  
  public String getIsRead()
  {
    return this.isRead;
  }
  
  public String getIsSign()
  {
    return this.isSign;
  }
  
  public List<JdRandGoodsListModel> getJdRandGoodsList()
  {
    return this.jdRandGoodsList;
  }
  
  public List<HomeNoticeListModel> getNoticeList()
  {
    return this.noticeList;
  }
  
  public String getSignPicUrl()
  {
    return this.signPicUrl;
  }
  
  public void setActivityList(List<HomeActivityListModel> paramList)
  {
    this.activityList = paramList;
  }
  
  public void setAdvList(List<HomeFocusListModel> paramList)
  {
    this.advList = paramList;
  }
  
  public void setIsRead(String paramString)
  {
    this.isRead = paramString;
  }
  
  public void setIsSign(String paramString)
  {
    this.isSign = paramString;
  }
  
  public void setJdRandGoodsList(List<JdRandGoodsListModel> paramList)
  {
    this.jdRandGoodsList = paramList;
  }
  
  public void setNoticeList(List<HomeNoticeListModel> paramList)
  {
    this.noticeList = paramList;
  }
  
  public void setSignPicUrl(String paramString)
  {
    this.signPicUrl = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\find\MainHomePageBodyModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */