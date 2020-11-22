package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser
  extends ResultParser
{
  private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
  private static final Pattern COMMA = Pattern.compile(",");
  private static final Pattern CR_LF_SPACE_TAB;
  private static final Pattern EQUALS;
  private static final Pattern NEWLINE_ESCAPE;
  private static final Pattern SEMICOLON;
  private static final Pattern SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
  private static final Pattern UNESCAPED_SEMICOLONS;
  private static final Pattern VCARD_ESCAPES;
  private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
  
  static
  {
    CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    EQUALS = Pattern.compile("=");
    SEMICOLON = Pattern.compile(";");
    UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
  }
  
  private static String decodeQuotedPrintable(CharSequence paramCharSequence, String paramString)
  {
    int k = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(k);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      char c1 = paramCharSequence.charAt(i);
      j = i;
      if (c1 != '\n')
      {
        j = i;
        if (c1 != '\r') {
          if (c1 != '=')
          {
            maybeAppendFragment(localByteArrayOutputStream, paramString, localStringBuilder);
            localStringBuilder.append(c1);
            j = i;
          }
          else
          {
            j = i;
            if (i < k - 2)
            {
              c1 = paramCharSequence.charAt(i + 1);
              j = i;
              if (c1 != '\r')
              {
                j = i;
                if (c1 != '\n')
                {
                  i += 2;
                  char c2 = paramCharSequence.charAt(i);
                  int m = parseHexDigit(c1);
                  int n = parseHexDigit(c2);
                  j = i;
                  if (m >= 0)
                  {
                    j = i;
                    if (n >= 0)
                    {
                      localByteArrayOutputStream.write((m << 4) + n);
                      j = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    maybeAppendFragment(localByteArrayOutputStream, paramString, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static void formatNames(Iterable<List<String>> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        List localList = (List)paramIterable.next();
        Object localObject = (String)localList.get(0);
        String[] arrayOfString = new String[5];
        int i = 0;
        int k;
        for (int j = 0; i < arrayOfString.length - 1; j = k + 1)
        {
          k = ((String)localObject).indexOf(';', j);
          if (k < 0) {
            break;
          }
          arrayOfString[i] = ((String)localObject).substring(j, k);
          i += 1;
        }
        arrayOfString[i] = ((String)localObject).substring(j);
        localObject = new StringBuilder(100);
        maybeAppendComponent(arrayOfString, 3, (StringBuilder)localObject);
        maybeAppendComponent(arrayOfString, 1, (StringBuilder)localObject);
        maybeAppendComponent(arrayOfString, 2, (StringBuilder)localObject);
        maybeAppendComponent(arrayOfString, 0, (StringBuilder)localObject);
        maybeAppendComponent(arrayOfString, 4, (StringBuilder)localObject);
        localList.set(0, ((StringBuilder)localObject).toString().trim());
      }
    }
  }
  
  private static boolean isLikeVCardDate(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (VCARD_LIKE_DATE.matcher(paramCharSequence).matches());
  }
  
  static List<String> matchSingleVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramCharSequence = matchVCardPrefixedField(paramCharSequence, paramString, paramBoolean1, paramBoolean2);
    if ((paramCharSequence != null) && (!paramCharSequence.isEmpty())) {
      return (List)paramCharSequence.get(0);
    }
    return null;
  }
  
  static List<List<String>> matchVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = paramString.length();
    int i = 0;
    Object localObject1 = null;
    while (i < m)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("(?:^|\n)");
      ((StringBuilder)localObject2).append(paramCharSequence);
      ((StringBuilder)localObject2).append("(?:;([^:]*))?:");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString(), 2).matcher(paramString);
      int j = i;
      if (i > 0) {
        j = i - 1;
      }
      if (!((Matcher)localObject2).find(j)) {
        return (List<List<String>>)localObject1;
      }
      int n = ((Matcher)localObject2).end(0);
      localObject2 = ((Matcher)localObject2).group(1);
      int k;
      Object localObject3;
      if (localObject2 != null)
      {
        String[] arrayOfString = SEMICOLON.split((CharSequence)localObject2);
        int i1 = arrayOfString.length;
        k = 0;
        localObject3 = null;
        i = 0;
        for (localObject2 = null;; localObject2 = localObject5)
        {
          localObject4 = localObject3;
          j = i;
          localObject5 = localObject2;
          if (k >= i1) {
            break;
          }
          localObject5 = arrayOfString[k];
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = new ArrayList(1);
          }
          ((List)localObject4).add(localObject5);
          localObject3 = EQUALS.split((CharSequence)localObject5, 2);
          j = i;
          localObject5 = localObject2;
          if (localObject3.length > 1)
          {
            String str = localObject3[0];
            localObject3 = localObject3[1];
            if (("ENCODING".equalsIgnoreCase(str)) && ("QUOTED-PRINTABLE".equalsIgnoreCase((String)localObject3)))
            {
              j = 1;
              localObject5 = localObject2;
            }
            else
            {
              j = i;
              localObject5 = localObject2;
              if ("CHARSET".equalsIgnoreCase(str))
              {
                localObject5 = localObject3;
                j = i;
              }
            }
          }
          k += 1;
          localObject3 = localObject4;
          i = j;
        }
      }
      Object localObject4 = null;
      j = 0;
      Object localObject5 = null;
      i = n;
      for (;;)
      {
        k = paramString.indexOf('\n', i);
        if (k < 0) {
          break;
        }
        if (k < paramString.length() - 1)
        {
          i = k + 1;
          if ((paramString.charAt(i) == ' ') || (paramString.charAt(i) == '\t'))
          {
            i = k + 2;
            continue;
          }
        }
        if (j == 0) {
          break;
        }
        if ((k >= 1) && (paramString.charAt(k - 1) == '=')) {
          break label437;
        }
        if ((k < 2) || (paramString.charAt(k - 2) != '=')) {
          break;
        }
        label437:
        i = k + 1;
      }
      if (k < 0)
      {
        i = m;
      }
      else if (k > n)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(1);
        }
        i = k;
        if (k >= 1)
        {
          i = k;
          if (paramString.charAt(k - 1) == '\r') {
            i = k - 1;
          }
        }
        localObject3 = paramString.substring(n, i);
        localObject1 = localObject3;
        if (paramBoolean1) {
          localObject1 = ((String)localObject3).trim();
        }
        if (j != 0)
        {
          localObject3 = decodeQuotedPrintable((CharSequence)localObject1, (String)localObject5);
          localObject1 = localObject3;
          if (paramBoolean2) {
            localObject1 = UNESCAPED_SEMICOLONS.matcher((CharSequence)localObject3).replaceAll("\n").trim();
          }
        }
        else
        {
          localObject3 = localObject1;
          if (paramBoolean2) {
            localObject3 = UNESCAPED_SEMICOLONS.matcher((CharSequence)localObject1).replaceAll("\n").trim();
          }
          localObject1 = CR_LF_SPACE_TAB.matcher((CharSequence)localObject3).replaceAll("");
          localObject1 = NEWLINE_ESCAPE.matcher((CharSequence)localObject1).replaceAll("\n");
          localObject1 = VCARD_ESCAPES.matcher((CharSequence)localObject1).replaceAll("$1");
        }
        if (localObject4 == null)
        {
          localObject3 = new ArrayList(1);
          ((List)localObject3).add(localObject1);
          ((List)localObject2).add(localObject3);
        }
        else
        {
          ((List)localObject4).add(0, localObject1);
          ((List)localObject2).add(localObject4);
        }
        i += 1;
        localObject1 = localObject2;
      }
      else
      {
        i = k + 1;
      }
    }
    return (List<List<String>>)localObject1;
  }
  
  private static void maybeAppendComponent(String[] paramArrayOfString, int paramInt, StringBuilder paramStringBuilder)
  {
    if ((paramArrayOfString[paramInt] != null) && (!paramArrayOfString[paramInt].isEmpty()))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append(paramArrayOfString[paramInt]);
    }
  }
  
  private static void maybeAppendFragment(ByteArrayOutputStream paramByteArrayOutputStream, String paramString, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte;
    if (paramByteArrayOutputStream.size() > 0)
    {
      arrayOfByte = paramByteArrayOutputStream.toByteArray();
      if (paramString == null) {
        paramString = new String(arrayOfByte, Charset.forName("UTF-8"));
      }
    }
    try
    {
      paramString = new String(arrayOfByte, paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    paramString = new String(arrayOfByte, Charset.forName("UTF-8"));
    paramByteArrayOutputStream.reset();
    paramStringBuilder.append(paramString);
  }
  
  private static String toPrimaryValue(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return (String)paramList.get(0);
    }
    return null;
  }
  
  private static String[] toPrimaryValues(Collection<List<String>> paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramCollection.size());
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((List)localIterator.next()).get(0);
        if ((str != null) && (!str.isEmpty())) {
          localArrayList.add(str);
        }
      }
      return (String[])localArrayList.toArray(new String[paramCollection.size()]);
    }
    return null;
  }
  
  private static String[] toTypes(Collection<List<String>> paramCollection)
  {
    if (paramCollection != null)
    {
      if (paramCollection.isEmpty()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramCollection.size());
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        int i = 1;
        while (i < localList.size())
        {
          str = (String)localList.get(i);
          int j = str.indexOf('=');
          if (j < 0) {
            break label134;
          }
          if ("TYPE".equalsIgnoreCase(str.substring(0, j)))
          {
            str = str.substring(j + 1);
            break label134;
          }
          i += 1;
        }
        String str = null;
        label134:
        localArrayList.add(str);
      }
      return (String[])localArrayList.toArray(new String[paramCollection.size()]);
    }
    return null;
  }
  
  public AddressBookParsedResult parse(Result paramResult)
  {
    String str = getMassagedText(paramResult);
    paramResult = BEGIN_VCARD.matcher(str);
    if (paramResult.find())
    {
      if (paramResult.start() != 0) {
        return null;
      }
      paramResult = matchVCardPrefixedField("FN", str, true, false);
      Object localObject = paramResult;
      if (paramResult == null)
      {
        localObject = matchVCardPrefixedField("N", str, true, false);
        formatNames((Iterable)localObject);
      }
      paramResult = matchSingleVCardPrefixedField("NICKNAME", str, true, false);
      String[] arrayOfString;
      if (paramResult == null) {
        arrayOfString = null;
      } else {
        arrayOfString = COMMA.split((CharSequence)paramResult.get(0));
      }
      List localList2 = matchVCardPrefixedField("TEL", str, true, false);
      List localList3 = matchVCardPrefixedField("EMAIL", str, true, false);
      List localList4 = matchSingleVCardPrefixedField("NOTE", str, false, false);
      List localList5 = matchVCardPrefixedField("ADR", str, true, true);
      List localList6 = matchSingleVCardPrefixedField("ORG", str, true, true);
      List localList1 = matchSingleVCardPrefixedField("BDAY", str, true, false);
      if ((localList1 != null) && (!isLikeVCardDate((CharSequence)localList1.get(0)))) {
        localList1 = null;
      }
      List localList7 = matchSingleVCardPrefixedField("TITLE", str, true, false);
      List localList8 = matchVCardPrefixedField("URL", str, true, false);
      List localList9 = matchSingleVCardPrefixedField("IMPP", str, true, false);
      paramResult = matchSingleVCardPrefixedField("GEO", str, true, false);
      if (paramResult == null) {
        paramResult = null;
      } else {
        paramResult = SEMICOLON_OR_COMMA.split((CharSequence)paramResult.get(0));
      }
      if ((paramResult != null) && (paramResult.length != 2)) {
        paramResult = null;
      }
      return new AddressBookParsedResult(toPrimaryValues((Collection)localObject), arrayOfString, null, toPrimaryValues(localList2), toTypes(localList2), toPrimaryValues(localList3), toTypes(localList3), toPrimaryValue(localList9), toPrimaryValue(localList4), toPrimaryValues(localList5), toTypes(localList5), toPrimaryValue(localList6), toPrimaryValue(localList1), toPrimaryValue(localList7), toPrimaryValues(localList8), paramResult);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\VCardResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */