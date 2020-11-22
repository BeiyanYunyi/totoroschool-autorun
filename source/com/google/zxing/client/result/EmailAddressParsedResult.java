package com.google.zxing.client.result;

public final class EmailAddressParsedResult
  extends ParsedResult
{
  private final String[] bccs;
  private final String body;
  private final String[] ccs;
  private final String subject;
  private final String[] tos;
  
  EmailAddressParsedResult(String paramString)
  {
    this(new String[] { paramString }, null, null, null, null);
  }
  
  EmailAddressParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, String paramString2)
  {
    super(ParsedResultType.EMAIL_ADDRESS);
    this.tos = paramArrayOfString1;
    this.ccs = paramArrayOfString2;
    this.bccs = paramArrayOfString3;
    this.subject = paramString1;
    this.body = paramString2;
  }
  
  public String[] getBCCs()
  {
    return this.bccs;
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public String[] getCCs()
  {
    return this.ccs;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    maybeAppend(this.tos, localStringBuilder);
    maybeAppend(this.ccs, localStringBuilder);
    maybeAppend(this.bccs, localStringBuilder);
    maybeAppend(this.subject, localStringBuilder);
    maybeAppend(this.body, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  @Deprecated
  public String getEmailAddress()
  {
    if ((this.tos != null) && (this.tos.length != 0)) {
      return this.tos[0];
    }
    return null;
  }
  
  @Deprecated
  public String getMailtoURI()
  {
    return "mailto:";
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String[] getTos()
  {
    return this.tos;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\EmailAddressParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */