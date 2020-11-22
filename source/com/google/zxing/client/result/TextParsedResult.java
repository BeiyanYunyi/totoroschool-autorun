package com.google.zxing.client.result;

public final class TextParsedResult
  extends ParsedResult
{
  private final String language;
  private final String text;
  
  public TextParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.TEXT);
    this.text = paramString1;
    this.language = paramString2;
  }
  
  public String getDisplayResult()
  {
    return this.text;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getText()
  {
    return this.text;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\TextParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */