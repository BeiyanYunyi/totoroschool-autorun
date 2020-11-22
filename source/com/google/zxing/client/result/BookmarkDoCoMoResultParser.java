package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class BookmarkDoCoMoResultParser
  extends AbstractDoCoMoResultParser
{
  public URIParsedResult parse(Result paramResult)
  {
    Object localObject = paramResult.getText();
    boolean bool = ((String)localObject).startsWith("MEBKM:");
    paramResult = null;
    if (!bool) {
      return null;
    }
    String str = matchSingleDoCoMoPrefixedField("TITLE:", (String)localObject, true);
    localObject = matchDoCoMoPrefixedField("URL:", (String)localObject, true);
    if (localObject == null) {
      return null;
    }
    localObject = localObject[0];
    if (URIResultParser.isBasicallyValidURI((String)localObject)) {
      paramResult = new URIParsedResult((String)localObject, str);
    }
    return paramResult;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\BookmarkDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */