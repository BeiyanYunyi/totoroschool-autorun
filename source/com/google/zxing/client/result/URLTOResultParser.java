package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class URLTOResultParser
  extends ResultParser
{
  public URIParsedResult parse(Result paramResult)
  {
    String str = getMassagedText(paramResult);
    boolean bool = str.startsWith("urlto:");
    paramResult = null;
    if ((!bool) && (!str.startsWith("URLTO:"))) {
      return null;
    }
    int i = str.indexOf(':', 6);
    if (i < 0) {
      return null;
    }
    if (i > 6) {
      paramResult = str.substring(6, i);
    }
    return new URIParsedResult(str.substring(i + 1), paramResult);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\URLTOResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */