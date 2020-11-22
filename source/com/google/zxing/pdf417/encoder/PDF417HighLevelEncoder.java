package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

final class PDF417HighLevelEncoder
{
  private static final int BYTE_COMPACTION = 1;
  private static final Charset DEFAULT_ENCODING;
  private static final int ECI_CHARSET = 927;
  private static final int ECI_GENERAL_PURPOSE = 926;
  private static final int ECI_USER_DEFINED = 925;
  private static final int LATCH_TO_BYTE = 924;
  private static final int LATCH_TO_BYTE_PADDED = 901;
  private static final int LATCH_TO_NUMERIC = 902;
  private static final int LATCH_TO_TEXT = 900;
  private static final byte[] MIXED;
  private static final int NUMERIC_COMPACTION = 2;
  private static final byte[] PUNCTUATION;
  private static final int SHIFT_TO_BYTE = 913;
  private static final int SUBMODE_ALPHA = 0;
  private static final int SUBMODE_LOWER = 1;
  private static final int SUBMODE_MIXED = 2;
  private static final int SUBMODE_PUNCTUATION = 3;
  private static final int TEXT_COMPACTION = 0;
  private static final byte[] TEXT_MIXED_RAW = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
  private static final byte[] TEXT_PUNCTUATION_RAW = { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
  
  static
  {
    MIXED = new byte[''];
    PUNCTUATION = new byte[''];
    DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    Arrays.fill(MIXED, (byte)-1);
    int j = 0;
    int k;
    for (int i = 0; i < TEXT_MIXED_RAW.length; i = (byte)(i + 1))
    {
      k = TEXT_MIXED_RAW[i];
      if (k > 0) {
        MIXED[k] = i;
      }
    }
    Arrays.fill(PUNCTUATION, (byte)-1);
    for (i = j; i < TEXT_PUNCTUATION_RAW.length; i = (byte)(i + 1))
    {
      k = TEXT_PUNCTUATION_RAW[i];
      if (k > 0) {
        PUNCTUATION[k] = i;
      }
    }
  }
  
  private static int determineConsecutiveBinaryCount(String paramString, int paramInt, Charset paramCharset)
    throws WriterException
  {
    paramCharset = paramCharset.newEncoder();
    int m = paramString.length();
    int j = paramInt;
    while (j < m)
    {
      char c = paramString.charAt(j);
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (i >= 13) {
          break;
        }
        k = i;
        if (!isDigit(c)) {
          break;
        }
        i += 1;
        k = j + i;
        if (k >= m)
        {
          k = i;
          break;
        }
        c = paramString.charAt(k);
      }
      if (k >= 13) {
        return j - paramInt;
      }
      c = paramString.charAt(j);
      if (paramCharset.canEncode(c))
      {
        j += 1;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("Non-encodable character detected: ");
        paramString.append(c);
        paramString.append(" (Unicode: ");
        paramString.append(c);
        paramString.append(')');
        throw new WriterException(paramString.toString());
      }
    }
    return j - paramInt;
  }
  
  private static int determineConsecutiveDigitCount(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int j = 0;
    int k = 0;
    if (paramInt < m)
    {
      char c = paramCharSequence.charAt(paramInt);
      int i = paramInt;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if (!isDigit(c)) {
          break;
        }
        j = paramInt;
        if (i >= m) {
          break;
        }
        j = paramInt + 1;
        k = i + 1;
        paramInt = j;
        i = k;
        if (k < m)
        {
          c = paramCharSequence.charAt(k);
          paramInt = j;
          i = k;
        }
      }
    }
    return j;
  }
  
  private static int determineConsecutiveTextCount(CharSequence paramCharSequence, int paramInt)
  {
    int n = paramCharSequence.length();
    int i = paramInt;
    int j;
    for (;;)
    {
      j = i;
      if (i >= n) {
        break;
      }
      char c = paramCharSequence.charAt(i);
      j = 0;
      while ((j < 13) && (isDigit(c)) && (i < n))
      {
        int k = j + 1;
        int m = i + 1;
        i = m;
        j = k;
        if (m < n)
        {
          c = paramCharSequence.charAt(m);
          i = m;
          j = k;
        }
      }
      if (j >= 13) {
        return i - paramInt - j;
      }
      if (j <= 0)
      {
        if (!isText(paramCharSequence.charAt(i)))
        {
          j = i;
          break;
        }
        i += 1;
      }
    }
    return j - paramInt;
  }
  
  private static void encodeBinary(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    if ((paramInt2 == 1) && (paramInt3 == 0))
    {
      paramStringBuilder.append('Α');
    }
    else
    {
      if (paramInt2 % 6 == 0) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if (paramInt3 != 0) {
        paramStringBuilder.append('Μ');
      } else {
        paramStringBuilder.append('΅');
      }
    }
    if (paramInt2 >= 6)
    {
      char[] arrayOfChar = new char[5];
      paramInt3 = paramInt1;
      for (;;)
      {
        i = paramInt3;
        if (paramInt1 + paramInt2 - paramInt3 < 6) {
          break;
        }
        long l = 0L;
        i = 0;
        while (i < 6)
        {
          l = (l << 8) + (paramArrayOfByte[(paramInt3 + i)] & 0xFF);
          i += 1;
        }
        i = 0;
        while (i < 5)
        {
          arrayOfChar[i] = ((char)(int)(l % 900L));
          l /= 900L;
          i += 1;
        }
        i = arrayOfChar.length - 1;
        while (i >= 0)
        {
          paramStringBuilder.append(arrayOfChar[i]);
          i -= 1;
        }
        paramInt3 += 6;
      }
    }
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      paramStringBuilder.append((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
  }
  
  static String encodeHighLevel(String paramString, Compaction paramCompaction, Charset paramCharset)
    throws WriterException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Charset localCharset;
    if (paramCharset == null)
    {
      localCharset = DEFAULT_ENCODING;
    }
    else
    {
      localCharset = paramCharset;
      if (!DEFAULT_ENCODING.equals(paramCharset))
      {
        CharacterSetECI localCharacterSetECI = CharacterSetECI.getCharacterSetECIByName(paramCharset.name());
        localCharset = paramCharset;
        if (localCharacterSetECI != null)
        {
          encodingECI(localCharacterSetECI.getValue(), localStringBuilder);
          localCharset = paramCharset;
        }
      }
    }
    int i1 = paramString.length();
    if (paramCompaction == Compaction.TEXT)
    {
      encodeText(paramString, 0, i1, localStringBuilder, 0);
    }
    else if (paramCompaction == Compaction.BYTE)
    {
      paramString = paramString.getBytes(localCharset);
      encodeBinary(paramString, 0, paramString.length, 1, localStringBuilder);
    }
    else if (paramCompaction == Compaction.NUMERIC)
    {
      localStringBuilder.append('Ά');
      encodeNumeric(paramString, 0, i1, localStringBuilder);
    }
    else
    {
      int j = 0;
      int k = 0;
      int i = 0;
      for (;;)
      {
        if (j >= i1) {
          break label374;
        }
        int m = determineConsecutiveDigitCount(paramString, j);
        if (m >= 13)
        {
          localStringBuilder.append('Ά');
          k = 2;
          encodeNumeric(paramString, j, m, localStringBuilder);
          j += m;
          break;
        }
        int n = determineConsecutiveTextCount(paramString, j);
        if ((n < 5) && (m != i1))
        {
          n = determineConsecutiveBinaryCount(paramString, j, localCharset);
          m = n;
          if (n == 0) {
            m = 1;
          }
          m += j;
          paramCompaction = paramString.substring(j, m).getBytes(localCharset);
          if ((paramCompaction.length == 1) && (k == 0))
          {
            encodeBinary(paramCompaction, 0, 1, 0, localStringBuilder);
          }
          else
          {
            encodeBinary(paramCompaction, 0, paramCompaction.length, k, localStringBuilder);
            k = 1;
            i = 0;
          }
          j = m;
        }
        else
        {
          m = k;
          if (k != 0)
          {
            localStringBuilder.append('΄');
            m = 0;
            i = 0;
          }
          i = encodeText(paramString, j, n, localStringBuilder, i);
          j += n;
          k = m;
        }
      }
    }
    label374:
    return localStringBuilder.toString();
  }
  
  private static void encodeNumeric(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2 / 3 + 1);
    BigInteger localBigInteger2 = BigInteger.valueOf(900L);
    BigInteger localBigInteger3 = BigInteger.valueOf(0L);
    int i = 0;
    while (i < paramInt2)
    {
      localStringBuilder.setLength(0);
      int k = Math.min(44, paramInt2 - i);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append('1');
      int j = paramInt1 + i;
      ((StringBuilder)localObject).append(paramString.substring(j, j + k));
      localObject = new BigInteger(((StringBuilder)localObject).toString());
      BigInteger localBigInteger1;
      do
      {
        localStringBuilder.append((char)((BigInteger)localObject).mod(localBigInteger2).intValue());
        localBigInteger1 = ((BigInteger)localObject).divide(localBigInteger2);
        localObject = localBigInteger1;
      } while (!localBigInteger1.equals(localBigInteger3));
      j = localStringBuilder.length() - 1;
      while (j >= 0)
      {
        paramStringBuilder.append(localStringBuilder.charAt(j));
        j -= 1;
      }
      i += k;
    }
  }
  
  private static int encodeText(CharSequence paramCharSequence, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2);
    int j = 0;
    for (;;)
    {
      int k = paramInt1 + j;
      int i = paramCharSequence.charAt(k);
      switch (paramInt3)
      {
      default: 
        if (isPunctuation(i)) {
          localStringBuilder.append((char)PUNCTUATION[i]);
        }
        break;
      case 2: 
        if (isMixed(i))
        {
          localStringBuilder.append((char)MIXED[i]);
        }
        else
        {
          if (isAlphaUpper(i))
          {
            localStringBuilder.append('\034');
            break label552;
          }
          if (isAlphaLower(i))
          {
            localStringBuilder.append('\033');
          }
          else
          {
            k += 1;
            if ((k < paramInt2) && (isPunctuation(paramCharSequence.charAt(k))))
            {
              paramInt3 = 3;
              localStringBuilder.append('\031');
              continue;
            }
            localStringBuilder.append('\035');
            localStringBuilder.append((char)PUNCTUATION[i]);
          }
        }
        break;
      case 1: 
        if (isAlphaLower(i))
        {
          if (i == 32) {
            localStringBuilder.append('\032');
          } else {
            localStringBuilder.append((char)(i - 97));
          }
        }
        else if (isAlphaUpper(i))
        {
          localStringBuilder.append('\033');
          localStringBuilder.append((char)(i - 65));
        }
        else if (isMixed(i))
        {
          localStringBuilder.append('\034');
        }
        else
        {
          localStringBuilder.append('\035');
          localStringBuilder.append((char)PUNCTUATION[i]);
        }
        break;
      case 0: 
        if (isAlphaUpper(i))
        {
          if (i == 32) {
            localStringBuilder.append('\032');
          } else {
            localStringBuilder.append((char)(i - 65));
          }
        }
        else
        {
          if (isAlphaLower(i))
          {
            localStringBuilder.append('\033');
            paramInt3 = 1;
            continue;
          }
          if (isMixed(i))
          {
            localStringBuilder.append('\034');
            paramInt3 = 2;
            continue;
          }
          localStringBuilder.append('\035');
          localStringBuilder.append((char)PUNCTUATION[i]);
        }
        k = j + 1;
        j = k;
        if (k >= paramInt2)
        {
          k = localStringBuilder.length();
          paramInt1 = 0;
          paramInt2 = 0;
          while (paramInt1 < k)
          {
            if (paramInt1 % 2 != 0) {
              j = 1;
            } else {
              j = 0;
            }
            if (j != 0)
            {
              i = (char)(paramInt2 * 30 + localStringBuilder.charAt(paramInt1));
              paramStringBuilder.append(i);
              paramInt2 = i;
            }
            else
            {
              paramInt2 = localStringBuilder.charAt(paramInt1);
            }
            paramInt1 += 1;
          }
          if (k % 2 != 0) {
            paramStringBuilder.append((char)(paramInt2 * 30 + 29));
          }
          return paramInt3;
          localStringBuilder.append('\035');
          label552:
          paramInt3 = 0;
        }
        break;
      }
    }
  }
  
  private static void encodingECI(int paramInt, StringBuilder paramStringBuilder)
    throws WriterException
  {
    if ((paramInt >= 0) && (paramInt < 900))
    {
      paramStringBuilder.append('Ο');
      paramStringBuilder.append((char)paramInt);
      return;
    }
    if (paramInt < 810900)
    {
      paramStringBuilder.append('Ξ');
      paramStringBuilder.append((char)(paramInt / 900 - 1));
      paramStringBuilder.append((char)(paramInt % 900));
      return;
    }
    if (paramInt < 811800)
    {
      paramStringBuilder.append('Ν');
      paramStringBuilder.append((char)(810900 - paramInt));
      return;
    }
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append("ECI number not in valid range from 0..811799, but was ");
    paramStringBuilder.append(paramInt);
    throw new WriterException(paramStringBuilder.toString());
  }
  
  private static boolean isAlphaLower(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  private static boolean isAlphaUpper(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean isMixed(char paramChar)
  {
    return MIXED[paramChar] != -1;
  }
  
  private static boolean isPunctuation(char paramChar)
  {
    return PUNCTUATION[paramChar] != -1;
  }
  
  private static boolean isText(char paramChar)
  {
    return (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= '~'));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\encoder\PDF417HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */