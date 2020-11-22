package com.totoro.school.entity.common.verificationcode;

public class VerificationCodeRequestModel
{
  private String flag = "Y";
  private String phoneNumber;
  private String sendMsgHead;
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getSendMsgHead()
  {
    return this.sendMsgHead;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
  
  public void setSendMsgHead(String paramString)
  {
    this.sendMsgHead = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\common\verificationcode\VerificationCodeRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */