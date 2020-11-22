package com.google.zxing.client.result;

public final class TelParsedResult
  extends ParsedResult
{
  private final String number;
  private final String telURI;
  private final String title;
  
  public TelParsedResult(String paramString1, String paramString2, String paramString3)
  {
    super(ParsedResultType.TEL);
    this.number = paramString1;
    this.telURI = paramString2;
    this.title = paramString3;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    maybeAppend(this.number, localStringBuilder);
    maybeAppend(this.title, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String getNumber()
  {
    return this.number;
  }
  
  public String getTelURI()
  {
    return this.telURI;
  }
  
  public String getTitle()
  {
    return this.title;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\TelParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */