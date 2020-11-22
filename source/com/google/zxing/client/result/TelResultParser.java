package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser
  extends ResultParser
{
  public TelParsedResult parse(Result paramResult)
  {
    String str = getMassagedText(paramResult);
    if ((!str.startsWith("tel:")) && (!str.startsWith("TEL:"))) {
      return null;
    }
    if (str.startsWith("TEL:"))
    {
      paramResult = new StringBuilder();
      paramResult.append("tel:");
      paramResult.append(str.substring(4));
      paramResult = paramResult.toString();
    }
    else
    {
      paramResult = str;
    }
    int i = str.indexOf('?', 4);
    if (i < 0) {
      str = str.substring(4);
    } else {
      str = str.substring(4, i);
    }
    return new TelParsedResult(str, paramResult, null);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\TelResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */