package com.totoro.school.entity;

import java.util.List;

public class RunDataUploadRequestModel
{
  private List<DataListModel> dataList;
  
  public RunDataUploadRequestModel(List<DataListModel> paramList)
  {
    this.dataList = paramList;
  }
  
  public List<DataListModel> getDataList()
  {
    return this.dataList;
  }
  
  public void setDataList(List<DataListModel> paramList)
  {
    this.dataList = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RunDataUploadRequestModel{dataList=");
    localStringBuilder.append(this.dataList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\RunDataUploadRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */