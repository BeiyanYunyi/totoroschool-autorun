package com.totoro.school.entity.login.password.change;

public class ChangePasswordRequestModel
{
  private String flag;
  private String newPwd;
  private String oldPwd;
  private String phoneNumber;
  private String schoolName;
  private String snCode;
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getNewPwd()
  {
    return this.newPwd;
  }
  
  public String getOldPwd()
  {
    return this.oldPwd;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getSchoolName()
  {
    return this.schoolName;
  }
  
  public String getSnCode()
  {
    return this.snCode;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public void setNewPwd(String paramString)
  {
    this.newPwd = paramString;
  }
  
  public void setOldPwd(String paramString)
  {
    this.oldPwd = paramString;
  }
  
  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\login\password\change\ChangePasswordRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */