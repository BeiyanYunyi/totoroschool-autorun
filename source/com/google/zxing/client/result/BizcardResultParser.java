package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

public final class BizcardResultParser
  extends AbstractDoCoMoResultParser
{
  private static String buildName(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    if (paramString2 == null) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String[] buildPhoneNumbers(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(3);
    if (paramString1 != null) {
      localArrayList.add(paramString1);
    }
    if (paramString2 != null) {
      localArrayList.add(paramString2);
    }
    if (paramString3 != null) {
      localArrayList.add(paramString3);
    }
    int i = localArrayList.size();
    if (i == 0) {
      return null;
    }
    return (String[])localArrayList.toArray(new String[i]);
  }
  
  public AddressBookParsedResult parse(Result paramResult)
  {
    String str6 = getMassagedText(paramResult);
    if (!str6.startsWith("BIZCARD:")) {
      return null;
    }
    paramResult = buildName(matchSingleDoCoMoPrefixedField("N:", str6, true), matchSingleDoCoMoPrefixedField("X:", str6, true));
    String str1 = matchSingleDoCoMoPrefixedField("T:", str6, true);
    String str2 = matchSingleDoCoMoPrefixedField("C:", str6, true);
    String[] arrayOfString = matchDoCoMoPrefixedField("A:", str6, true);
    String str3 = matchSingleDoCoMoPrefixedField("B:", str6, true);
    String str4 = matchSingleDoCoMoPrefixedField("M:", str6, true);
    String str5 = matchSingleDoCoMoPrefixedField("F:", str6, true);
    str6 = matchSingleDoCoMoPrefixedField("E:", str6, true);
    return new AddressBookParsedResult(maybeWrap(paramResult), null, null, buildPhoneNumbers(str3, str4, str5), null, maybeWrap(str6), null, null, null, arrayOfString, null, str2, null, str1, null, null);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\BizcardResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */