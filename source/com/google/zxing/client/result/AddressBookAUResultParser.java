package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

public final class AddressBookAUResultParser
  extends ResultParser
{
  private static String[] matchMultipleValuePrefix(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2;
    for (Object localObject1 = null; i <= paramInt; localObject1 = localObject2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(':');
      String str = matchSinglePrefixedField(((StringBuilder)localObject2).toString(), paramString2, '\r', paramBoolean);
      if (str == null) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList(paramInt);
      }
      ((List)localObject2).add(str);
      i += 1;
    }
    if (localObject1 == null) {
      return null;
    }
    return (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
  }
  
  public AddressBookParsedResult parse(Result paramResult)
  {
    String str4 = getMassagedText(paramResult);
    boolean bool = str4.contains("MEMORY");
    paramResult = null;
    if (bool)
    {
      if (!str4.contains("\r\n")) {
        return null;
      }
      String str1 = matchSinglePrefixedField("NAME1:", str4, '\r', true);
      String str2 = matchSinglePrefixedField("NAME2:", str4, '\r', true);
      String[] arrayOfString1 = matchMultipleValuePrefix("TEL", 3, str4, true);
      String[] arrayOfString2 = matchMultipleValuePrefix("MAIL", 3, str4, true);
      String str3 = matchSinglePrefixedField("MEMORY:", str4, '\r', false);
      str4 = matchSinglePrefixedField("ADD:", str4, '\r', true);
      if (str4 != null) {
        for (;;)
        {
          paramResult = new String[1];
          paramResult[0] = str4;
        }
      }
      return new AddressBookParsedResult(maybeWrap(str1), null, str2, arrayOfString1, null, arrayOfString2, null, null, str3, paramResult, null, null, null, null, null, null);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\AddressBookAUResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */