package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Code128Reader
  extends OneDReader
{
  private static final int CODE_CODE_A = 101;
  private static final int CODE_CODE_B = 100;
  private static final int CODE_CODE_C = 99;
  private static final int CODE_FNC_1 = 102;
  private static final int CODE_FNC_2 = 97;
  private static final int CODE_FNC_3 = 96;
  private static final int CODE_FNC_4_A = 101;
  private static final int CODE_FNC_4_B = 100;
  static final int[][] CODE_PATTERNS;
  private static final int CODE_SHIFT = 98;
  private static final int CODE_START_A = 103;
  private static final int CODE_START_B = 104;
  private static final int CODE_START_C = 105;
  private static final int CODE_STOP = 106;
  private static final float MAX_AVG_VARIANCE = 0.25F;
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.7F;
  
  static
  {
    int[] arrayOfInt1 = { 1, 2, 2, 2, 1, 3 };
    int[] arrayOfInt2 = { 1, 2, 2, 3, 1, 2 };
    int[] arrayOfInt3 = { 1, 3, 2, 2, 1, 2 };
    int[] arrayOfInt4 = { 2, 2, 1, 2, 1, 3 };
    int[] arrayOfInt5 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt6 = { 2, 2, 3, 1, 1, 2 };
    int[] arrayOfInt7 = { 3, 1, 1, 2, 2, 2 };
    int[] arrayOfInt8 = { 2, 1, 2, 1, 2, 3 };
    int[] arrayOfInt9 = { 1, 3, 2, 3, 1, 1 };
    int[] arrayOfInt10 = { 2, 1, 1, 3, 1, 3 };
    int[] arrayOfInt11 = { 1, 1, 2, 1, 3, 3 };
    int[] arrayOfInt12 = { 1, 1, 2, 3, 3, 1 };
    int[] arrayOfInt13 = { 1, 3, 2, 1, 3, 1 };
    int[] arrayOfInt14 = { 3, 1, 3, 1, 2, 1 };
    int[] arrayOfInt15 = { 2, 1, 1, 3, 3, 1 };
    int[] arrayOfInt16 = { 2, 1, 3, 1, 1, 3 };
    int[] arrayOfInt17 = { 2, 1, 3, 1, 3, 1 };
    int[] arrayOfInt18 = { 3, 1, 2, 1, 1, 3 };
    int[] arrayOfInt19 = { 3, 1, 2, 3, 1, 1 };
    int[] arrayOfInt20 = { 2, 2, 1, 4, 1, 1 };
    int[] arrayOfInt21 = { 1, 1, 1, 4, 2, 2 };
    int[] arrayOfInt22 = { 1, 2, 1, 4, 2, 1 };
    int[] arrayOfInt23 = { 1, 1, 2, 4, 1, 2 };
    int[] arrayOfInt24 = { 1, 2, 2, 1, 1, 4 };
    int[] arrayOfInt25 = { 1, 4, 2, 2, 1, 1 };
    int[] arrayOfInt26 = { 1, 2, 1, 1, 4, 2 };
    int[] arrayOfInt27 = { 1, 2, 4, 1, 1, 2 };
    int[] arrayOfInt28 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt29 = { 2, 1, 2, 1, 4, 1 };
    int[] arrayOfInt30 = { 1, 1, 4, 1, 1, 3 };
    int[] arrayOfInt31 = { 4, 1, 1, 1, 1, 3 };
    int[] arrayOfInt32 = { 1, 1, 3, 1, 4, 1 };
    int[] arrayOfInt33 = { 1, 1, 4, 1, 3, 1 };
    int[] arrayOfInt34 = { 2, 1, 1, 2, 3, 2 };
    CODE_PATTERNS = new int[][] { { 2, 1, 2, 2, 2, 2 }, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, { 1, 2, 1, 2, 2, 3 }, { 1, 2, 1, 3, 2, 2 }, { 1, 3, 1, 2, 2, 2 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 2, 2, 1, 3, 1, 2 }, { 2, 3, 1, 2, 1, 2 }, arrayOfInt5, { 1, 2, 2, 1, 3, 2 }, { 1, 2, 2, 2, 3, 1 }, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, { 2, 2, 3, 2, 1, 1 }, { 2, 2, 1, 1, 3, 2 }, { 2, 2, 1, 2, 3, 1 }, { 2, 1, 3, 2, 1, 2 }, arrayOfInt6, { 3, 1, 2, 1, 3, 1 }, arrayOfInt7, { 3, 2, 1, 1, 2, 2 }, { 3, 2, 1, 2, 2, 1 }, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, arrayOfInt8, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, { 1, 1, 1, 3, 2, 3 }, { 1, 3, 1, 1, 2, 3 }, { 1, 3, 1, 3, 2, 1 }, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, arrayOfInt9, arrayOfInt10, { 2, 3, 1, 1, 1, 3 }, { 2, 3, 1, 3, 1, 1 }, arrayOfInt11, arrayOfInt12, arrayOfInt13, { 1, 1, 3, 1, 2, 3 }, { 1, 1, 3, 3, 2, 1 }, { 1, 3, 3, 1, 2, 1 }, arrayOfInt14, arrayOfInt15, { 2, 3, 1, 1, 3, 1 }, arrayOfInt16, { 2, 1, 3, 3, 1, 1 }, arrayOfInt17, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, arrayOfInt18, arrayOfInt19, { 3, 3, 2, 1, 1, 1 }, { 3, 1, 4, 1, 1, 1 }, arrayOfInt20, { 4, 3, 1, 1, 1, 1 }, { 1, 1, 1, 2, 2, 4 }, arrayOfInt21, { 1, 2, 1, 1, 2, 4 }, arrayOfInt22, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, { 1, 1, 2, 2, 1, 4 }, arrayOfInt23, arrayOfInt24, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, arrayOfInt25, { 2, 4, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 4 }, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, { 1, 1, 1, 2, 4, 2 }, arrayOfInt26, { 1, 2, 1, 2, 4, 1 }, { 1, 1, 4, 2, 1, 2 }, arrayOfInt27, arrayOfInt28, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, { 4, 2, 1, 2, 1, 1 }, arrayOfInt29, { 2, 1, 4, 1, 2, 1 }, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, { 1, 3, 1, 1, 4, 1 }, arrayOfInt30, { 1, 1, 4, 3, 1, 1 }, arrayOfInt31, { 4, 1, 1, 3, 1, 1 }, arrayOfInt32, arrayOfInt33, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, { 2, 1, 1, 4, 1, 2 }, { 2, 1, 1, 2, 1, 4 }, arrayOfInt34, { 2, 3, 3, 1, 1, 1, 2 } };
  }
  
  private static int decodeCode(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt)
    throws NotFoundException
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    float f1 = 0.25F;
    int i = -1;
    paramInt = 0;
    while (paramInt < CODE_PATTERNS.length)
    {
      float f3 = patternMatchVariance(paramArrayOfInt, CODE_PATTERNS[paramInt], 0.7F);
      float f2 = f1;
      if (f3 < f1)
      {
        i = paramInt;
        f2 = f3;
      }
      paramInt += 1;
      f1 = f2;
    }
    if (i >= 0) {
      return i;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int[] findStartPattern(BitArray paramBitArray)
    throws NotFoundException
  {
    int i2 = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int i3 = arrayOfInt.length;
    int i = k;
    int m = 0;
    int n = 0;
    while (k < i2)
    {
      int j;
      if ((paramBitArray.get(k) ^ m))
      {
        arrayOfInt[n] += 1;
        j = i;
      }
      else
      {
        int i4 = i3 - 1;
        if (n == i4)
        {
          float f1 = 0.25F;
          j = 103;
          int i1 = -1;
          while (j <= 105)
          {
            float f3 = patternMatchVariance(arrayOfInt, CODE_PATTERNS[j], 0.7F);
            float f2 = f1;
            if (f3 < f1)
            {
              i1 = j;
              f2 = f3;
            }
            j += 1;
            f1 = f2;
          }
          if ((i1 >= 0) && (paramBitArray.isRange(Math.max(0, i - (k - i) / 2), i, false))) {
            return new int[] { i, k, i1 };
          }
          j = i + (arrayOfInt[0] + arrayOfInt[1]);
          i = i3 - 2;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i);
          arrayOfInt[i] = 0;
          arrayOfInt[i4] = 0;
          i = n - 1;
        }
        else
        {
          n += 1;
          j = i;
          i = n;
        }
        arrayOfInt[i] = 1;
        m ^= 0x1;
        n = i;
      }
      k += 1;
      i = j;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException, ChecksumException
  {
    int i7;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.ASSUME_GS1))) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    Object localObject2 = findStartPattern(paramBitArray);
    int i2 = localObject2[2];
    paramMap = new ArrayList(20);
    paramMap.add(Byte.valueOf((byte)i2));
    int i;
    switch (i2)
    {
    default: 
      throw FormatException.getFormatInstance();
    case 105: 
      i = 99;
      break;
    case 104: 
      i = 100;
      break;
    case 103: 
      i = 101;
    }
    Object localObject1 = new StringBuilder(20);
    int i6 = localObject2[0];
    int n = localObject2[1];
    Object localObject3 = new int[6];
    int m = 0;
    int j = 0;
    int i8 = 0;
    int i5 = 0;
    int i1 = 0;
    int i3 = 0;
    int i4 = 0;
    int k = 1;
    while (j == 0)
    {
      int i11 = decodeCode(paramBitArray, (int[])localObject3, n);
      paramMap.add(Byte.valueOf((byte)i11));
      if (i11 != 106) {
        k = 1;
      }
      int i10 = i2;
      int i9 = i4;
      if (i11 != 106)
      {
        i9 = i4 + 1;
        i10 = i2 + i9 * i11;
      }
      i5 = localObject3.length;
      i4 = n;
      i2 = 0;
      while (i2 < i5)
      {
        i4 += localObject3[i2];
        i2 += 1;
      }
      switch (i11)
      {
      default: 
        switch (i)
        {
        default: 
          i2 = k;
        }
        break;
      case 103: 
      case 104: 
      case 105: 
        throw FormatException.getFormatInstance();
        if (i11 < 64)
        {
          if (m == i1) {
            ((StringBuilder)localObject1).append((char)(i11 + 32));
          } else {
            ((StringBuilder)localObject1).append((char)(i11 + 32 + 128));
          }
        }
        else if (i11 < 96)
        {
          if (m == i1) {
            ((StringBuilder)localObject1).append((char)(i11 - 64));
          } else {
            ((StringBuilder)localObject1).append((char)(i11 + 64));
          }
        }
        else
        {
          if (i11 != 106) {
            k = 0;
          }
          i2 = k;
          if (i11 == 106) {
            break label991;
          }
          i5 = k;
          i6 = k;
        }
        switch (i11)
        {
        default: 
          i6 = k;
          break;
        case 102: 
          i6 = k;
          if (i7 != 0) {
            if (((StringBuilder)localObject1).length() == 0)
            {
              ((StringBuilder)localObject1).append("]C1");
              i6 = k;
            }
            else
            {
              ((StringBuilder)localObject1).append('\035');
              i6 = k;
            }
          }
          break;
        case 101: 
          if ((i1 != 0) || (m == 0))
          {
            i5 = k;
            if (i1 == 0) {
              break label904;
            }
            i5 = k;
            if (m == 0) {
              break label904;
            }
          }
          break;
        case 100: 
          i = 0;
          break;
        case 98: 
          i = 1;
          i5 = 100;
          i2 = j;
          j = i5;
          break label1013;
          if (i11 < 96)
          {
            if (m == i1) {
              ((StringBuilder)localObject1).append((char)(i11 + 32));
            } else {
              ((StringBuilder)localObject1).append((char)(i11 + 32 + 128));
            }
            i5 = 0;
            m = 0;
            i2 = j;
          }
          break;
        }
        for (;;)
        {
          j = i;
          i = i5;
          i5 = i2;
          break;
          if (i11 != 106) {
            k = 0;
          }
          i2 = k;
          if (i11 != 106)
          {
            i5 = k;
            i6 = k;
            switch (i11)
            {
            default: 
              i6 = k;
              break;
            case 102: 
              i6 = k;
              if (i7 != 0) {
                if (((StringBuilder)localObject1).length() == 0)
                {
                  ((StringBuilder)localObject1).append("]C1");
                  i6 = k;
                }
                else
                {
                  ((StringBuilder)localObject1).append('\035');
                  i6 = k;
                }
              }
              break;
            case 101: 
              i = 0;
              break;
            case 100: 
              if ((i1 == 0) && (m != 0))
              {
                i1 = i;
                i = 0;
                m = 0;
                i5 = 1;
                i2 = j;
                j = i1;
                i1 = i5;
              }
              else
              {
                i5 = k;
                if (i1 != 0)
                {
                  i5 = k;
                  if (m != 0)
                  {
                    i1 = i;
                    i = 0;
                    m = 0;
                    i5 = 0;
                    i2 = j;
                    j = i1;
                    i1 = i5;
                    break label1013;
                  }
                }
                k = i;
                i = 0;
                m = 1;
                i2 = j;
                j = k;
                k = i5;
              }
              break;
            case 99: 
              i = 0;
              k = 99;
              i2 = j;
              j = k;
              k = i5;
              break;
            case 98: 
              label904:
              i = 1;
              i5 = 101;
              i2 = j;
              j = i5;
              break;
            }
            k = i;
            i = 0;
            i2 = j;
            j = k;
            k = i6;
          }
          else
          {
            label991:
            i5 = 0;
            i6 = 1;
            k = i2;
            j = i;
            i2 = i6;
            i = i5;
          }
          label1013:
          i5 = i;
          i = j;
        }
        if (i11 < 100)
        {
          if (i11 < 10) {
            ((StringBuilder)localObject1).append('0');
          }
          ((StringBuilder)localObject1).append(i11);
          i2 = k;
        }
        else
        {
          if (i11 != 106) {
            k = 0;
          }
          if (i11 != 106)
          {
            switch (i11)
            {
            default: 
              i2 = k;
              break;
            case 102: 
              i2 = k;
              if (i7 == 0) {
                break;
              }
              if (((StringBuilder)localObject1).length() == 0)
              {
                ((StringBuilder)localObject1).append("]C1");
                i2 = k;
              }
              else
              {
                ((StringBuilder)localObject1).append('\035');
                i2 = k;
              }
              break;
            case 101: 
              i2 = 101;
              break;
            case 100: 
              i2 = 100;
              break;
            }
          }
          else
          {
            i2 = 0;
            i5 = 1;
            j = i;
            i = i2;
          }
        }
        break;
      }
      k = i2;
      i2 = i;
      i = 0;
      i5 = j;
      j = i2;
      if (i8 != 0) {
        if (j == 101) {
          j = 100;
        } else {
          j = 101;
        }
      }
      i8 = i;
      i2 = i3;
      i3 = i11;
      i6 = n;
      n = i4;
      i = j;
      j = i5;
      i5 = i2;
      i2 = i10;
      i4 = i9;
    }
    j = paramBitArray.getNextUnset(n);
    if (paramBitArray.isRange(j, Math.min(paramBitArray.getSize(), (j - i6) / 2 + j), false))
    {
      if ((i2 - i4 * i5) % 103 == i5)
      {
        j = ((StringBuilder)localObject1).length();
        if (j != 0)
        {
          if ((j > 0) && (k != 0)) {
            if (i == 99) {
              ((StringBuilder)localObject1).delete(j - 2, j);
            } else {
              ((StringBuilder)localObject1).delete(j - 1, j);
            }
          }
          float f1 = (localObject2[1] + localObject2[0]) / 2.0F;
          float f2 = i6;
          float f3 = (n - i6) / 2.0F;
          j = paramMap.size();
          paramBitArray = new byte[j];
          i = 0;
          while (i < j)
          {
            paramBitArray[i] = ((Byte)paramMap.get(i)).byteValue();
            i += 1;
          }
          paramMap = ((StringBuilder)localObject1).toString();
          float f4 = paramInt;
          localObject1 = new ResultPoint(f1, f4);
          localObject2 = new ResultPoint(f2 + f3, f4);
          localObject3 = BarcodeFormat.CODE_128;
          return new Result(paramMap, paramBitArray, new ResultPoint[] { localObject1, localObject2 }, (BarcodeFormat)localObject3);
        }
        throw NotFoundException.getNotFoundInstance();
      }
      throw ChecksumException.getChecksumInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\Code128Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */