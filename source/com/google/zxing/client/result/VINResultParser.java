package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VINResultParser
  extends ResultParser
{
  private static final Pattern AZ09 = Pattern.compile("[A-Z0-9]{17}");
  private static final Pattern IOQ = Pattern.compile("[IOQ]");
  
  private static char checkChar(int paramInt)
  {
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    if (paramInt == 10) {
      return 'X';
    }
    throw new IllegalArgumentException();
  }
  
  private static boolean checkChecksum(CharSequence paramCharSequence)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < paramCharSequence.length())
    {
      int k = i + 1;
      j += vinPositionWeight(k) * vinCharValue(paramCharSequence.charAt(i));
      i = k;
    }
    if (paramCharSequence.charAt(8) == checkChar(j % 11)) {
      bool = true;
    }
    return bool;
  }
  
  private static String countryCode(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.charAt(0);
    int j = paramCharSequence.charAt(1);
    if (i != 57)
    {
      if (i != 83)
      {
        if (i != 90) {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                break;
              case 88: 
                if ((j != 48) && ((j < 51) || (j > 57))) {
                  break;
                }
                return "RU";
              case 87: 
                return "DE";
              case 86: 
                if ((j >= 70) && (j <= 82)) {
                  return "FR";
                }
                if ((j < 83) || (j > 87)) {
                  break;
                }
                return "ES";
              }
              break;
            case 77: 
              if ((j < 65) || (j > 69)) {
                break;
              }
              return "IN";
            case 76: 
              return "CN";
            case 75: 
              if ((j < 76) || (j > 82)) {
                break;
              }
              return "KO";
            case 74: 
              if ((j < 65) || (j > 84)) {
                break;
              }
              return "JP";
            }
            break;
          case 51: 
            if ((j < 65) || (j > 87)) {
              break;
            }
            return "MX";
          case 50: 
            return "CA";
          case 49: 
          case 52: 
          case 53: 
            return "US";
          }
        } else if ((j >= 65) && (j <= 82)) {
          return "IT";
        }
      }
      else
      {
        if ((j >= 65) && (j <= 77)) {
          return "UK";
        }
        if ((j >= 78) && (j <= 84)) {
          return "DE";
        }
      }
    }
    else if (((j >= 65) && (j <= 69)) || ((j >= 51) && (j <= 57))) {
      return "BR";
    }
    return null;
  }
  
  private static int modelYear(char paramChar)
  {
    if ((paramChar >= 'E') && (paramChar <= 'H')) {
      return paramChar - 'E' + 1984;
    }
    if ((paramChar >= 'J') && (paramChar <= 'N')) {
      return paramChar - 'J' + 1988;
    }
    if (paramChar == 'P') {
      return 1993;
    }
    if ((paramChar >= 'R') && (paramChar <= 'T')) {
      return paramChar - 'R' + 1994;
    }
    if ((paramChar >= 'V') && (paramChar <= 'Y')) {
      return paramChar - 'V' + 1997;
    }
    if ((paramChar >= '1') && (paramChar <= '9')) {
      return paramChar - '1' + 2001;
    }
    if ((paramChar >= 'A') && (paramChar <= 'D')) {
      return paramChar - 'A' + 2010;
    }
    throw new IllegalArgumentException();
  }
  
  private static int vinCharValue(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'I')) {
      return paramChar - 'A' + 1;
    }
    if ((paramChar >= 'J') && (paramChar <= 'R')) {
      return paramChar - 'J' + 1;
    }
    if ((paramChar >= 'S') && (paramChar <= 'Z')) {
      return paramChar - 'S' + 2;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    throw new IllegalArgumentException();
  }
  
  private static int vinPositionWeight(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 7)) {
      return 9 - paramInt;
    }
    if (paramInt == 8) {
      return 10;
    }
    if (paramInt == 9) {
      return 0;
    }
    if ((paramInt >= 10) && (paramInt <= 17)) {
      return 19 - paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  public VINParsedResult parse(Result paramResult)
  {
    if (paramResult.getBarcodeFormat() != BarcodeFormat.CODE_39) {
      return null;
    }
    paramResult = paramResult.getText();
    paramResult = IOQ.matcher(paramResult).replaceAll("").trim();
    if (!AZ09.matcher(paramResult).matches()) {
      return null;
    }
    try
    {
      if (!checkChecksum(paramResult)) {
        return null;
      }
      String str = paramResult.substring(0, 3);
      paramResult = new VINParsedResult(paramResult, str, paramResult.substring(3, 9), paramResult.substring(9, 17), countryCode(str), paramResult.substring(3, 8), modelYear(paramResult.charAt(9)), paramResult.charAt(10), paramResult.substring(11));
      return paramResult;
    }
    catch (IllegalArgumentException paramResult) {}
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\VINResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */