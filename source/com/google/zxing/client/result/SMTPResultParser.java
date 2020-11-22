package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser
  extends ResultParser
{
  public EmailAddressParsedResult parse(Result paramResult)
  {
    paramResult = getMassagedText(paramResult);
    if ((!paramResult.startsWith("smtp:")) && (!paramResult.startsWith("SMTP:"))) {
      return null;
    }
    String str = paramResult.substring(5);
    int i = str.indexOf(':');
    Object localObject;
    if (i >= 0)
    {
      paramResult = str.substring(i + 1);
      str = str.substring(0, i);
      i = paramResult.indexOf(':');
      if (i >= 0)
      {
        localObject = paramResult.substring(i + 1);
        paramResult = paramResult.substring(0, i);
      }
      else
      {
        localObject = null;
      }
    }
    else
    {
      paramResult = null;
      localObject = paramResult;
    }
    return new EmailAddressParsedResult(new String[] { str }, null, null, paramResult, (String)localObject);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\SMTPResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */