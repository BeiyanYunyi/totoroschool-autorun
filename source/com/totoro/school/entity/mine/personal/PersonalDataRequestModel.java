package com.totoro.school.entity.mine.personal;

public class PersonalDataRequestModel
{
  private String schoolName;
  private String snCode;
  
  public PersonalDataRequestModel(String paramString1, String paramString2)
  {
    this.schoolName = paramString1;
    this.snCode = paramString2;
  }
  
  public String getSchoolName()
  {
    return this.schoolName;
  }
  
  public String getSnCode()
  {
    return this.snCode;
  }
  
  public void setSchoolName(String paramString)
  {
    this.schoolName = paramString;
  }
  
  public void setSnCode(String paramString)
  {
    this.snCode = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\mine\personal\PersonalDataRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */