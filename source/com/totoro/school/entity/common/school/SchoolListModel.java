package com.totoro.school.entity.common.school;

public class SchoolListModel
{
  private String id;
  private String name;
  
  public SchoolListModel(String paramString1, String paramString2)
  {
    this.id = paramString1;
    this.name = paramString2;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\common\school\SchoolListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */