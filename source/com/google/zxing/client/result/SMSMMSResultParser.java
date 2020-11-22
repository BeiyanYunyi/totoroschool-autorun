package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class SMSMMSResultParser
  extends ResultParser
{
  private static void addNumberVia(Collection<String> paramCollection1, Collection<String> paramCollection2, String paramString)
  {
    int i = paramString.indexOf(';');
    Object localObject = null;
    if (i < 0)
    {
      paramCollection1.add(paramString);
      paramCollection2.add(null);
      return;
    }
    paramCollection1.add(paramString.substring(0, i));
    paramString = paramString.substring(i + 1);
    paramCollection1 = (Collection<String>)localObject;
    if (paramString.startsWith("via=")) {
      paramCollection1 = paramString.substring(4);
    }
    paramCollection2.add(paramCollection1);
  }
  
  public SMSParsedResult parse(Result paramResult)
  {
    String str2 = getMassagedText(paramResult);
    boolean bool = str2.startsWith("sms:");
    String str1 = null;
    if ((!bool) && (!str2.startsWith("SMS:")) && (!str2.startsWith("mms:")) && (!str2.startsWith("MMS:"))) {
      return null;
    }
    paramResult = parseNameValuePairs(str2);
    int i = 0;
    if ((paramResult != null) && (!paramResult.isEmpty()))
    {
      str1 = (String)paramResult.get("subject");
      paramResult = (String)paramResult.get("body");
      i = 1;
    }
    else
    {
      paramResult = null;
    }
    int j = str2.indexOf('?', 4);
    if ((j >= 0) && (i != 0)) {
      str2 = str2.substring(4, j);
    } else {
      str2 = str2.substring(4);
    }
    i = -1;
    ArrayList localArrayList1 = new ArrayList(1);
    ArrayList localArrayList2 = new ArrayList(1);
    int k;
    for (;;)
    {
      k = i + 1;
      j = str2.indexOf(',', k);
      if (j <= i) {
        break;
      }
      addNumberVia(localArrayList1, localArrayList2, str2.substring(k, j));
      i = j;
    }
    addNumberVia(localArrayList1, localArrayList2, str2.substring(k));
    return new SMSParsedResult((String[])localArrayList1.toArray(new String[localArrayList1.size()]), (String[])localArrayList2.toArray(new String[localArrayList2.size()]), str1, paramResult);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\SMSMMSResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */