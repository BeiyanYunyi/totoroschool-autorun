package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class AddressBookDoCoMoResultParser
  extends AbstractDoCoMoResultParser
{
  private static String parseName(String paramString)
  {
    int i = paramString.indexOf(',');
    if (i >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(i + 1));
      localStringBuilder.append(' ');
      localStringBuilder.append(paramString.substring(0, i));
      return localStringBuilder.toString();
    }
    return paramString;
  }
  
  public AddressBookParsedResult parse(Result paramResult)
  {
    String str1 = getMassagedText(paramResult);
    if (!str1.startsWith("MECARD:")) {
      return null;
    }
    paramResult = matchDoCoMoPrefixedField("N:", str1, true);
    if (paramResult == null) {
      return null;
    }
    String str2 = parseName(paramResult[0]);
    String str3 = matchSingleDoCoMoPrefixedField("SOUND:", str1, true);
    String[] arrayOfString1 = matchDoCoMoPrefixedField("TEL:", str1, true);
    String[] arrayOfString2 = matchDoCoMoPrefixedField("EMAIL:", str1, true);
    String str4 = matchSingleDoCoMoPrefixedField("NOTE:", str1, false);
    String[] arrayOfString3 = matchDoCoMoPrefixedField("ADR:", str1, true);
    paramResult = matchSingleDoCoMoPrefixedField("BDAY:", str1, true);
    if (!isStringOfDigits(paramResult, 8)) {
      paramResult = null;
    }
    String[] arrayOfString4 = matchDoCoMoPrefixedField("URL:", str1, true);
    str1 = matchSingleDoCoMoPrefixedField("ORG:", str1, true);
    return new AddressBookParsedResult(maybeWrap(str2), null, str3, arrayOfString1, null, arrayOfString2, null, null, str4, arrayOfString3, null, str1, paramResult, null, arrayOfString4, null);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\AddressBookDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */