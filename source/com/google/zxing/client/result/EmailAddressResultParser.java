package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser
  extends ResultParser
{
  private static final Pattern COMMA = Pattern.compile(",");
  
  public EmailAddressParsedResult parse(Result paramResult)
  {
    Object localObject3 = getMassagedText(paramResult);
    boolean bool = ((String)localObject3).startsWith("mailto:");
    Object localObject2 = null;
    if ((!bool) && (!((String)localObject3).startsWith("MAILTO:")))
    {
      if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress((String)localObject3)) {
        return null;
      }
      return new EmailAddressParsedResult((String)localObject3);
    }
    Object localObject1 = ((String)localObject3).substring(7);
    int i = ((String)localObject1).indexOf('?');
    paramResult = (Result)localObject1;
    if (i >= 0) {
      paramResult = ((String)localObject1).substring(0, i);
    }
    paramResult = urlDecode(paramResult);
    if (!paramResult.isEmpty()) {
      paramResult = COMMA.split(paramResult);
    } else {
      paramResult = null;
    }
    localObject3 = parseNameValuePairs((String)localObject3);
    Object localObject4;
    Object localObject5;
    if (localObject3 != null)
    {
      localObject1 = paramResult;
      if (paramResult == null)
      {
        localObject4 = (String)((Map)localObject3).get("to");
        localObject1 = paramResult;
        if (localObject4 != null) {
          localObject1 = COMMA.split((CharSequence)localObject4);
        }
      }
      paramResult = (String)((Map)localObject3).get("cc");
      if (paramResult != null) {
        paramResult = COMMA.split(paramResult);
      } else {
        paramResult = null;
      }
      localObject4 = (String)((Map)localObject3).get("bcc");
      if (localObject4 != null) {
        localObject2 = COMMA.split((CharSequence)localObject4);
      }
      localObject4 = (String)((Map)localObject3).get("subject");
      localObject5 = (String)((Map)localObject3).get("body");
      localObject3 = paramResult;
      paramResult = (Result)localObject1;
      localObject1 = localObject3;
      localObject3 = localObject2;
    }
    else
    {
      localObject2 = paramResult;
      Object localObject6 = null;
      paramResult = (Result)localObject6;
      localObject1 = paramResult;
      localObject5 = localObject1;
      localObject4 = localObject1;
      localObject3 = paramResult;
      localObject1 = localObject6;
      paramResult = (Result)localObject2;
    }
    return new EmailAddressParsedResult(paramResult, (String[])localObject1, (String[])localObject3, (String)localObject4, (String)localObject5);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\EmailAddressResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */