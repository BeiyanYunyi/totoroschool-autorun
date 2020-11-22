package com.google.gson.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  private static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if (i >= 48)
      {
        if (i > 57) {
          return paramInt;
        }
        paramInt += 1;
      }
      else
      {
        return paramInt;
      }
    }
    return paramString.length();
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramString.length()) && (paramInt1 <= paramInt2))
    {
      int i;
      int j;
      StringBuilder localStringBuilder;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0)
        {
          j = -j;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      else
      {
        i = paramInt1;
        j = 0;
      }
      while (i < paramInt2)
      {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0)
        {
          j = j * 10 - k;
          i += 1;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid number: ");
          localStringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(localStringBuilder.toString());
        }
      }
      return -j;
    }
    throw new NumberFormatException(paramString);
  }
  
  public static Date a(String paramString, ParsePosition paramParsePosition)
    throws ParseException
  {
    label1000:
    label1019:
    label1032:
    label1042:
    label1051:
    label1068:
    label1083:
    for (;;)
    {
      int i2;
      char c;
      Object localObject2;
      try
      {
        i = paramParsePosition.getIndex();
        j = i + 4;
        int i3 = a(paramString, i, j);
        i = j;
        if (a(paramString, j, '-')) {
          i = j + 1;
        }
        j = i + 2;
        int i4 = a(paramString, i, j);
        i = j;
        if (a(paramString, j, '-')) {
          i = j + 1;
        }
        j = i + 2;
        int i5 = a(paramString, i, j);
        boolean bool = a(paramString, j, 'T');
        Object localObject1;
        if ((!bool) && (paramString.length() <= j))
        {
          localObject1 = new GregorianCalendar(i3, i4 - 1, i5);
          paramParsePosition.setIndex(j);
          return ((Calendar)localObject1).getTime();
        }
        if (!bool) {
          break label1042;
        }
        i = j + 1;
        j = i + 2;
        n = a(paramString, i, j);
        i = j;
        if (a(paramString, j, ':')) {
          i = j + 1;
        }
        j = i + 2;
        i1 = a(paramString, i, j);
        k = j;
        if (a(paramString, j, ':')) {
          k = j + 1;
        }
        m = n;
        j = i1;
        i = k;
        if (paramString.length() <= k) {
          break label1051;
        }
        i2 = paramString.charAt(k);
        m = n;
        j = i1;
        i = k;
        if (i2 == 90) {
          break label1051;
        }
        m = n;
        j = i1;
        i = k;
        if (i2 == 43) {
          break label1051;
        }
        m = n;
        j = i1;
        i = k;
        if (i2 == 45) {
          break label1051;
        }
        i = k + 2;
        j = a(paramString, k, i);
        k = 59;
        if ((j <= 59) || (j >= 63)) {
          break label1000;
        }
        j = k;
        if (!a(paramString, i, '.')) {
          break label1032;
        }
        k = i + 1;
        i2 = a(paramString, k + 1);
        m = Math.min(i2, k + 3);
        i = a(paramString, k, m);
        switch (m - k)
        {
        default: 
          if (paramString.length() > i)
          {
            c = paramString.charAt(i);
            if (c != 'Z') {
              break label1068;
            }
            localObject1 = a;
            i += 1;
            continue;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Invalid time zone indicator '");
            ((StringBuilder)localObject1).append(c);
            ((StringBuilder)localObject1).append("'");
            throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
            localObject1 = paramString.substring(i);
            if (((String)localObject1).length() < 5)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("00");
              localObject1 = ((StringBuilder)localObject2).toString();
            }
            i += ((String)localObject1).length();
            if ((!"+0000".equals(localObject1)) && (!"+00:00".equals(localObject1)))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("GMT");
              ((StringBuilder)localObject2).append((String)localObject1);
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject1 = TimeZone.getTimeZone((String)localObject2);
              localObject3 = ((TimeZone)localObject1).getID();
              if ((((String)localObject3).equals(localObject2)) || (((String)localObject3).replace(":", "").equals(localObject2))) {
                break label1083;
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Mismatching time zone indicator: ");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append(" given, resolves to ");
              ((StringBuilder)localObject3).append(((TimeZone)localObject1).getID());
              throw new IndexOutOfBoundsException(((StringBuilder)localObject3).toString());
            }
            localObject1 = a;
            localObject1 = new GregorianCalendar((TimeZone)localObject1);
            ((Calendar)localObject1).setLenient(false);
            ((Calendar)localObject1).set(1, i3);
            ((Calendar)localObject1).set(2, i4 - 1);
            ((Calendar)localObject1).set(5, i5);
            ((Calendar)localObject1).set(11, m);
            ((Calendar)localObject1).set(12, i1);
            ((Calendar)localObject1).set(13, j);
            ((Calendar)localObject1).set(14, k);
            paramParsePosition.setIndex(i);
            return ((Calendar)localObject1).getTime();
          }
          throw new IllegalArgumentException("No time zone indicator");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (NumberFormatException localNumberFormatException) {}catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append('"');
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("'");
        paramString = ((StringBuilder)localObject2).toString();
      }
      Object localObject3 = localIndexOutOfBoundsException.getMessage();
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject3).isEmpty()) {}
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(localIndexOutOfBoundsException.getClass().getName());
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Failed to parse date [");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("]: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramString = new ParseException(((StringBuilder)localObject3).toString(), paramParsePosition.getIndex());
      paramString.initCause(localIndexOutOfBoundsException);
      throw paramString;
      continue;
      break label1019;
      i *= 10;
      break label1019;
      i *= 100;
      int m = n;
      int k = i;
      int i = i2;
      continue;
      k = 0;
      m = n;
      continue;
      i = j;
      m = 0;
      int j = 0;
      k = 0;
      int n = 0;
      int i1 = j;
      j = n;
      continue;
      if (c != '+') {
        if (c == '-') {}
      }
    }
  }
  
  private static boolean a(String paramString, int paramInt, char paramChar)
  {
    return (paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */