package com.google.zxing.client.result;

public final class SMSParsedResult
  extends ParsedResult
{
  private final String body;
  private final String[] numbers;
  private final String subject;
  private final String[] vias;
  
  public SMSParsedResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(ParsedResultType.SMS);
    this.numbers = new String[] { paramString1 };
    this.vias = new String[] { paramString2 };
    this.subject = paramString3;
    this.body = paramString4;
  }
  
  public SMSParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2)
  {
    super(ParsedResultType.SMS);
    this.numbers = paramArrayOfString1;
    this.vias = paramArrayOfString2;
    this.subject = paramString1;
    this.body = paramString2;
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.numbers, localStringBuilder);
    maybeAppend(this.subject, localStringBuilder);
    maybeAppend(this.body, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String[] getNumbers()
  {
    return this.numbers;
  }
  
  public String getSMSURI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sms:");
    int k = 0;
    int i = 0;
    int j = 1;
    while (i < this.numbers.length)
    {
      if (j != 0) {
        j = 0;
      } else {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(this.numbers[i]);
      if ((this.vias != null) && (this.vias[i] != null))
      {
        localStringBuilder.append(";via=");
        localStringBuilder.append(this.vias[i]);
      }
      i += 1;
    }
    if (this.body != null) {
      i = 1;
    } else {
      i = 0;
    }
    j = k;
    if (this.subject != null) {
      j = 1;
    }
    if ((i != 0) || (j != 0))
    {
      localStringBuilder.append('?');
      if (i != 0)
      {
        localStringBuilder.append("body=");
        localStringBuilder.append(this.body);
      }
      if (j != 0)
      {
        if (i != 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append("subject=");
        localStringBuilder.append(this.subject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String[] getVias()
  {
    return this.vias;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\SMSParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */