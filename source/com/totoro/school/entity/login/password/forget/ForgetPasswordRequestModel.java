package com.totoro.school.entity.login.password.forget;

import java.io.Serializable;

public class ForgetPasswordRequestModel
  implements Serializable
{
  private String password;
  private String phoneNumber;
  private String snCode;
  private String vCode;
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getSnCode()
  {
    return this.snCode;
  }
  
  public String getvCode()
  {
    return this.vCode;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
  
  public void setSnCode(String paramString)
  {
    this.snCode = paramString;
  }
  
  public void setvCode(String paramString)
  {
    this.vCode = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\login\password\forget\ForgetPasswordRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */