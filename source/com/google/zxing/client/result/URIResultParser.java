package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser
  extends ResultParser
{
  private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
  private static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
  
  static boolean isBasicallyValidURI(String paramString)
  {
    boolean bool1 = paramString.contains(" ");
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Matcher localMatcher = URL_WITH_PROTOCOL_PATTERN.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.start() == 0)) {
      return true;
    }
    paramString = URL_WITHOUT_PROTOCOL_PATTERN.matcher(paramString);
    bool1 = bool2;
    if (paramString.find())
    {
      bool1 = bool2;
      if (paramString.start() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public URIParsedResult parse(Result paramResult)
  {
    paramResult = getMassagedText(paramResult);
    if ((!paramResult.startsWith("URL:")) && (!paramResult.startsWith("URI:")))
    {
      paramResult = paramResult.trim();
      if (isBasicallyValidURI(paramResult)) {
        return new URIParsedResult(paramResult, null);
      }
      return null;
    }
    return new URIParsedResult(paramResult.substring(4).trim(), null);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\URIResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */