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

public final class Code39Reader
  extends OneDReader
{
  private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
  private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];
  static final int[] CHARACTER_ENCODINGS = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42 };
  private final int[] counters;
  private final StringBuilder decodeRowResult;
  private final boolean extendedMode;
  private final boolean usingCheckDigit;
  
  public Code39Reader()
  {
    this(false);
  }
  
  public Code39Reader(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }
  
  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.usingCheckDigit = paramBoolean1;
    this.extendedMode = paramBoolean2;
    this.decodeRowResult = new StringBuilder(20);
    this.counters = new int[9];
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
      if ((c != '+') && (c != '$') && (c != '%') && (c != '/'))
      {
        localStringBuilder.append(c);
      }
      else
      {
        i += 1;
        int k = paramCharSequence.charAt(i);
        if (c != '+')
        {
          if (c != '/') {
            switch (c)
            {
            default: 
              c = '\000';
              break;
            case '%': 
              if ((k >= 65) && (k <= 69))
              {
                c = (char)(k - 38);
                break;
              }
              if ((k >= 70) && (k <= 87))
              {
                c = (char)(k - 11);
                break;
              }
              throw FormatException.getFormatInstance();
            case '$': 
              if ((k >= 65) && (k <= 90))
              {
                c = (char)(k - 64);
                break;
              }
              throw FormatException.getFormatInstance();
            }
          } else if ((k >= 65) && (k <= 79)) {
            c = (char)(k - 32);
          } else if (k == 90) {
            c = ':';
          } else {
            throw FormatException.getFormatInstance();
          }
        }
        else
        {
          if ((k < 65) || (k > 90)) {
            break label277;
          }
          c = (char)(k + 32);
        }
        localStringBuilder.append(c);
      }
      i += 1;
      continue;
      label277:
      throw FormatException.getFormatInstance();
    }
    return localStringBuilder.toString();
  }
  
  private static int[] findAsteriskPattern(BitArray paramBitArray, int[] paramArrayOfInt)
    throws NotFoundException
  {
    int i1 = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    int i2 = paramArrayOfInt.length;
    int i = k;
    int m = 0;
    int j = 0;
    while (k < i1)
    {
      int n;
      if ((paramBitArray.get(k) ^ m))
      {
        paramArrayOfInt[j] += 1;
        n = i;
      }
      else
      {
        int i3 = i2 - 1;
        if (j == i3)
        {
          if ((toNarrowWidePattern(paramArrayOfInt) == ASTERISK_ENCODING) && (paramBitArray.isRange(Math.max(0, i - (k - i) / 2), i, false))) {
            return new int[] { i, k };
          }
          n = i + (paramArrayOfInt[0] + paramArrayOfInt[1]);
          i = i2 - 2;
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, i);
          paramArrayOfInt[i] = 0;
          paramArrayOfInt[i3] = 0;
          i = j - 1;
          j = n;
        }
        else
        {
          n = j + 1;
          j = i;
          i = n;
        }
        paramArrayOfInt[i] = 1;
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
  
  private static int toNarrowWidePattern(int[] paramArrayOfInt)
  {
    int i5 = paramArrayOfInt.length;
    int i4 = 0;
    int i;
    for (int j = 0;; j = i)
    {
      int i1 = paramArrayOfInt.length;
      int k = 0;
      for (i = Integer.MAX_VALUE; k < i1; i = m)
      {
        n = paramArrayOfInt[k];
        m = i;
        if (n < i)
        {
          m = i;
          if (n > j) {
            m = n;
          }
        }
        k += 1;
      }
      int n = 0;
      j = 0;
      int m = 0;
      int i2;
      for (k = 0; n < i5; k = i1)
      {
        int i6 = paramArrayOfInt[n];
        int i3 = j;
        i2 = m;
        i1 = k;
        if (i6 > i)
        {
          i2 = m | 1 << i5 - 1 - n;
          i3 = j + 1;
          i1 = k + i6;
        }
        n += 1;
        j = i3;
        m = i2;
      }
      if (j == 3)
      {
        n = j;
        j = i4;
        while ((j < i5) && (n > 0))
        {
          i2 = paramArrayOfInt[j];
          i1 = n;
          if (i2 > i)
          {
            i1 = n - 1;
            if (i2 * 2 >= k) {
              return -1;
            }
          }
          j += 1;
          n = i1;
        }
        return m;
      }
      if (j <= 3) {
        return -1;
      }
    }
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, ChecksumException, FormatException
  {
    Object localObject1 = this.counters;
    Arrays.fill((int[])localObject1, 0);
    Object localObject2 = this.decodeRowResult;
    ((StringBuilder)localObject2).setLength(0);
    paramMap = findAsteriskPattern(paramBitArray, (int[])localObject1);
    int i = paramBitArray.getNextSet(paramMap[1]);
    int n = paramBitArray.getSize();
    for (;;)
    {
      recordPattern(paramBitArray, i, (int[])localObject1);
      int j = toNarrowWidePattern((int[])localObject1);
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
        ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 1);
        int i1 = localObject1.length;
        k = 0;
        j = 0;
        while (k < i1)
        {
          j += localObject1[k];
          k += 1;
        }
        if ((m != n) && ((m - i - j) * 2 < j)) {
          throw NotFoundException.getNotFoundInstance();
        }
        if (this.usingCheckDigit)
        {
          n = ((StringBuilder)localObject2).length() - 1;
          k = 0;
          m = 0;
          while (k < n)
          {
            m += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.decodeRowResult.charAt(k));
            k += 1;
          }
          if (((StringBuilder)localObject2).charAt(n) == ALPHABET[(m % 43)]) {
            ((StringBuilder)localObject2).setLength(n);
          } else {
            throw ChecksumException.getChecksumInstance();
          }
        }
        if (((StringBuilder)localObject2).length() != 0)
        {
          if (this.extendedMode) {
            paramBitArray = decodeExtended((CharSequence)localObject2);
          } else {
            paramBitArray = ((StringBuilder)localObject2).toString();
          }
          float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
          float f2 = i;
          float f3 = j / 2.0F;
          float f4 = paramInt;
          paramMap = new ResultPoint(f1, f4);
          localObject1 = new ResultPoint(f2 + f3, f4);
          localObject2 = BarcodeFormat.CODE_39;
          return new Result(paramBitArray, null, new ResultPoint[] { paramMap, localObject1 }, (BarcodeFormat)localObject2);
        }
        throw NotFoundException.getNotFoundInstance();
      }
      i = m;
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\Code39Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */