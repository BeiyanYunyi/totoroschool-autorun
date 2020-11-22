package com.totoro.school.entity.login.login;

public class LoginRequestModel
{
  private String Mac;
  private String login_way;
  private String loginid;
  private String password;
  
  public String getLogin_way()
  {
    return this.login_way;
  }
  
  public String getLoginid()
  {
    return this.loginid;
  }
  
  public String getMac()
  {
    return this.Mac;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setLogin_way(String paramString)
  {
    this.login_way = paramString;
  }
  
  public void setLoginid(String paramString)
  {
    this.loginid = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.Mac = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\login\login\LoginRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */