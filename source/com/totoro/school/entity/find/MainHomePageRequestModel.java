package com.totoro.school.entity.find;

import java.io.Serializable;

public class MainHomePageRequestModel
  implements Serializable
{
  private String pageNumber;
  private String rowNumber;
  
  public MainHomePageRequestModel(String paramString1, String paramString2)
  {
    this.rowNumber = paramString1;
    this.pageNumber = paramString2;
  }
  
  public String getPageNumber()
  {
    return this.pageNumber;
  }
  
  public String getRowNumber()
  {
    return this.rowNumber;
  }
  
  public void setPageNumber(String paramString)
  {
    this.pageNumber = paramString;
  }
  
  public void setRowNumber(String paramString)
  {
    this.rowNumber = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\find\MainHomePageRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */