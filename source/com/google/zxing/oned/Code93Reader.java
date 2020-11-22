package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code93Reader
  extends OneDReader
{
  private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  private static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
  private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
  private static final int[] CHARACTER_ENCODINGS = { 276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350 };
  private final int[] counters = new int[6];
  private final StringBuilder decodeRowResult = new StringBuilder(20);
  
  private static void checkChecksums(CharSequence paramCharSequence)
    throws ChecksumException
  {
    int i = paramCharSequence.length();
    checkOneChecksum(paramCharSequence, i - 2, 20);
    checkOneChecksum(paramCharSequence, i - 1, 15);
  }
  
  private static void checkOneChecksum(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws ChecksumException
  {
    int j = paramInt1 - 1;
    int k = 0;
    int i = 1;
    while (j >= 0)
    {
      k += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(j)) * i;
      int m = i + 1;
      i = m;
      if (m > paramInt2) {
        i = 1;
      }
      j -= 1;
    }
    if (paramCharSequence.charAt(paramInt1) == ALPHABET[(k % 47)]) {
      return;
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  private static String decodeExtended(CharSequence paramCharSequence)
    throws FormatException
  {
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      if ((c >= 'a') && (c <= 'd'))
      {
        if (i < j - 1)
        {
          i += 1;
          int k = paramCharSequence.charAt(i);
          switch (c)
          {
          default: 
            c = '\000';
            break;
          case 'd': 
            if ((k >= 65) && (k <= 90)) {
              c = (char)(k + 32);
            } else {
              throw FormatException.getFormatInstance();
            }
            break;
          case 'c': 
            if ((k >= 65) && (k <= 79)) {
              c = (char)(k - 32);
            } else if (k == 90) {
              c = ':';
            } else {
              throw FormatException.getFormatInstance();
            }
            break;
          case 'b': 
            if ((k >= 65) && (k <= 69)) {
              c = (char)(k - 38);
            } else if ((k >= 70) && (k <= 74)) {
              c = (char)(k - 11);
            } else if ((k >= 75) && (k <= 79)) {
              c = (char)(k + 16);
            } else if ((k >= 80) && (k <= 83)) {
              c = (char)(k + 43);
            } else if ((k >= 84) && (k <= 90)) {
              c = '';
            } else {
              throw FormatException.getFormatInstance();
            }
            break;
          case 'a': 
            if ((k >= 65) && (k <= 90)) {
              c = (char)(k - 64);
            } else {
              throw FormatException.getFormatInstance();
            }
            break;
          }
          localStringBuilder.append(c);
        }
        else
        {
          throw FormatException.getFormatInstance();
        }
      }
      else {
        localStringBuilder.append(c);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private int[] findAsteriskPattern(BitArray paramBitArray)
    throws NotFoundException
  {
    int i1 = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    Arrays.fill(this.counters, 0);
    int[] arrayOfInt = this.counters;
    int i2 = arrayOfInt.length;
    int i = k;
    int m = 0;
    int j = 0;
    while (k < i1)
    {
      int n;
      if ((paramBitArray.get(k) ^ m))
      {
        arrayOfInt[j] += 1;
        n = i;
      }
      else
      {
        int i3 = i2 - 1;
        if (j == i3)
        {
          if (toPattern(arrayOfInt) == ASTERISK_ENCODING) {
            return new int[] { i, k };
          }
          n = i + (arrayOfInt[0] + arrayOfInt[1]);
          i = i2 - 2;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[i3] = 0;
          i = j - 1;
          j = n;
        }
        else
        {
          n = j + 1;
          j = i;
          i = n;
        }
        arrayOfInt[i] = 1;
        m ^= 0x1;
        n = j;
        j = i;
      }
      k += 1;
      i = n;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static char patternToChar(int paramInt)
    throws NotFoundException
  {
    int i = 0;
    while (i < CHARACTER_ENCODINGS.length)
    {
      if (CHARACTER_ENCODINGS[i] == paramInt) {
        return ALPHABET[i];
      }
      i += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int toPattern(int[] paramArrayOfInt)
  {
    int n = paramArrayOfInt.length;
    int k = paramArrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    k = 0;
    i = 0;
    while (k < n)
    {
      int i1 = Math.round(paramArrayOfInt[k] * 9.0F / j);
      if ((i1 >= 1) && (i1 <= 4))
      {
        if ((k & 0x1) == 0)
        {
          int m = 0;
          while (m < i1)
          {
            i = i << 1 | 0x1;
            m += 1;
          }
        }
        else
        {
          i <<= i1;
        }
        k += 1;
      }
      else
      {
        return -1;
      }
    }
    return i;
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, ChecksumException, FormatException
  {
    paramMap = findAsteriskPattern(paramBitArray);
    int i = paramBitArray.getNextSet(paramMap[1]);
    int n = paramBitArray.getSize();
    Object localObject1 = this.counters;
    Arrays.fill((int[])localObject1, 0);
    Object localObject2 = this.decodeRowResult;
    ((StringBuilder)localObject2).setLength(0);
    for (;;)
    {
      recordPattern(paramBitArray, i, (int[])localObject1);
      int j = toPattern((int[])localObject1);
      if (j < 0) {
        break;
      }
      char c = patternToChar(j);
      ((StringBuilder)localObject2).append(c);
      int m = localObject1.length;
      int k = i;
      j = 0;
      while (j < m)
      {
        k += localObject1[j];
        j += 1;
      }
      m = paramBitArray.getNextSet(k);
      if (c == '*')
      {
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        int i1 = localObject1.length;
        j = 0;
        k = 0;
        while (j < i1)
        {
          k += localObject1[j];
          j += 1;
        }
        if ((m != n) && (paramBitArray.get(m)))
        {
          if (((StringBuilder)localObject2).length() >= 2)
          {
            checkChecksums((CharSequence)localObject2);
            ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 2);
            paramBitArray = decodeExtended((CharSequence)localObject2);
            float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
            float f2 = i;
            float f3 = k / 2.0F;
            float f4 = paramInt;
            paramMap = new ResultPoint(f1, f4);
            localObject1 = new ResultPoint(f2 + f3, f4);
            localObject2 = BarcodeFormat.CODE_93;
            return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
          }
          throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
      }
      i = m;
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\Code93Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */