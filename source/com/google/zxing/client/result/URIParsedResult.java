package com.google.zxing.client.result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIParsedResult
  extends ParsedResult
{
  private static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
  private final String title;
  private final String uri;
  
  public URIParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.URI);
    this.uri = massageURI(paramString1);
    this.title = paramString2;
  }
  
  private static boolean isColonFollowedByPortNumber(String paramString, int paramInt)
  {
    int j = paramInt + 1;
    int i = paramString.indexOf('/', j);
    paramInt = i;
    if (i < 0) {
      paramInt = paramString.length();
    }
    return ResultParser.isSubstringOfDigits(paramString, j, paramInt - j);
  }
  
  private static String massageURI(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf(':');
    if (i >= 0)
    {
      paramString = str;
      if (!isColonFollowedByPortNumber(str, i)) {}
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("http://");
      paramString.append(str);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    maybeAppend(this.title, localStringBuilder);
    maybeAppend(this.uri, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getURI()
  {
    return this.uri;
  }
  
  public boolean isPossiblyMaliciousURI()
  {
    return USER_IN_HOST.matcher(this.uri).find();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\URIParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */