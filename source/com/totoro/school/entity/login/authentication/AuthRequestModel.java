package com.totoro.school.entity.login.authentication;

public class AuthRequestModel
{
  private String campusCode;
  private String idNumber;
  private String schoolCode;
  private String snCode;
  private String stuName;
  
  public AuthRequestModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.snCode = paramString1;
    this.stuName = paramString2;
    this.idNumber = paramString3;
    this.schoolCode = paramString4;
    this.campusCode = paramString5;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\login\authentication\AuthRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */