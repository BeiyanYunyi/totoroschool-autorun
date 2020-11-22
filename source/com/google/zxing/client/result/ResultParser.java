package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ResultParser
{
  private static final Pattern AMPERSAND = Pattern.compile("&");
  private static final String BYTE_ORDER_MARK = "﻿";
  private static final Pattern DIGITS;
  private static final Pattern EQUALS = Pattern.compile("=");
  private static final ResultParser[] PARSERS = { new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser() };
  
  static
  {
    DIGITS = Pattern.compile("\\d+");
  }
  
  private static void appendKeyValue(CharSequence paramCharSequence, Map<String, String> paramMap)
  {
    Object localObject = EQUALS.split(paramCharSequence, 2);
    if (localObject.length == 2)
    {
      paramCharSequence = localObject[0];
      localObject = localObject[1];
    }
    try
    {
      paramMap.put(paramCharSequence, urlDecode((String)localObject));
      return;
    }
    catch (IllegalArgumentException paramCharSequence) {}
  }
  
  private static int countPrecedingBackslashes(CharSequence paramCharSequence, int paramInt)
  {
    paramInt -= 1;
    int i = 0;
    while ((paramInt >= 0) && (paramCharSequence.charAt(paramInt) == '\\'))
    {
      i += 1;
      paramInt -= 1;
    }
    return i;
  }
  
  protected static String getMassagedText(Result paramResult)
  {
    String str = paramResult.getText();
    paramResult = str;
    if (str.startsWith("﻿")) {
      paramResult = str.substring(1);
    }
    return paramResult;
  }
  
  protected static boolean isStringOfDigits(CharSequence paramCharSequence, int paramInt)
  {
    return (paramCharSequence != null) && (paramInt > 0) && (paramInt == paramCharSequence.length()) && (DIGITS.matcher(paramCharSequence).matches());
  }
  
  protected static boolean isSubstringOfDigits(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (paramCharSequence != null)
    {
      if (paramInt2 <= 0) {
        return false;
      }
      paramInt2 += paramInt1;
      boolean bool1 = bool2;
      if (paramCharSequence.length() >= paramInt2)
      {
        bool1 = bool2;
        if (DIGITS.matcher(paramCharSequence.subSequence(paramInt1, paramInt2)).matches()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  static String[] matchPrefixedField(String paramString1, String paramString2, char paramChar, boolean paramBoolean)
  {
    int m = paramString2.length();
    Object localObject1 = null;
    int i = 0;
    while (i < m)
    {
      i = paramString2.indexOf(paramString1, i);
      if (i < 0) {
        break;
      }
      int k = i + paramString1.length();
      int j = 1;
      i = k;
      if (j != 0)
      {
        i = paramString2.indexOf(paramChar, i);
        if (i < 0) {
          i = paramString2.length();
        }
        for (;;)
        {
          j = 0;
          break;
          if (countPrecedingBackslashes(paramString2, i) % 2 != 0)
          {
            i += 1;
            break;
          }
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList(3);
          }
          String str = unescapeBackslash(paramString2.substring(k, i));
          localObject1 = str;
          if (paramBoolean) {
            localObject1 = str.trim();
          }
          if (!((String)localObject1).isEmpty()) {
            ((List)localObject2).add(localObject1);
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      return (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
    }
    return null;
  }
  
  static String matchSinglePrefixedField(String paramString1, String paramString2, char paramChar, boolean paramBoolean)
  {
    paramString1 = matchPrefixedField(paramString1, paramString2, paramChar, paramBoolean);
    if (paramString1 == null) {
      return null;
    }
    return paramString1[0];
  }
  
  protected static void maybeAppend(String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString != null)
    {
      paramStringBuilder.append('\n');
      paramStringBuilder.append(paramString);
    }
  }
  
  protected static void maybeAppend(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        paramStringBuilder.append('\n');
        paramStringBuilder.append(str);
        i += 1;
      }
    }
  }
  
  protected static String[] maybeWrap(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new String[] { paramString };
  }
  
  protected static int parseHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  static Map<String, String> parseNameValuePairs(String paramString)
  {
    int i = paramString.indexOf('?');
    if (i < 0) {
      return null;
    }
    HashMap localHashMap = new HashMap(3);
    paramString = AMPERSAND.split(paramString.substring(i + 1));
    int j = paramString.length;
    i = 0;
    while (i < j)
    {
      appendKeyValue(paramString[i], localHashMap);
      i += 1;
    }
    return localHashMap;
  }
  
  public static ParsedResult parseResult(Result paramResult)
  {
    ResultParser[] arrayOfResultParser = PARSERS;
    int j = arrayOfResultParser.length;
    int i = 0;
    while (i < j)
    {
      ParsedResult localParsedResult = arrayOfResultParser[i].parse(paramResult);
      if (localParsedResult != null) {
        return localParsedResult;
      }
      i += 1;
    }
    return new TextParsedResult(paramResult.getText(), null);
  }
  
  protected static String unescapeBackslash(String paramString)
  {
    int j = paramString.indexOf('\\');
    if (j < 0) {
      return paramString;
    }
    int k = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(k - 1);
    localStringBuilder.append(paramString.toCharArray(), 0, j);
    int i = 0;
    while (j < k)
    {
      char c = paramString.charAt(j);
      if ((i == 0) && (c == '\\'))
      {
        i = 1;
      }
      else
      {
        localStringBuilder.append(c);
        i = 0;
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  static String urlDecode(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public abstract ParsedResult parse(Result paramResult);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\ResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */