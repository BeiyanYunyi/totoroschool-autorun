package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder
{
  public static final int DEFAULT_AZTEC_LAYERS = 0;
  public static final int DEFAULT_EC_PERCENT = 33;
  private static final int MAX_NB_BITS = 32;
  private static final int MAX_NB_BITS_COMPACT = 4;
  private static final int[] WORD_SIZE = { 4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
  
  private static int[] bitsToWords(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int m = paramBitArray.getSize() / paramInt1;
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      int i = 0;
      int j = 0;
      while (i < paramInt1)
      {
        int k;
        if (paramBitArray.get(paramInt2 * paramInt1 + i)) {
          k = 1 << paramInt1 - i - 1;
        } else {
          k = 0;
        }
        j |= k;
        i += 1;
      }
      arrayOfInt[paramInt2] = j;
      paramInt2 += 1;
    }
    return arrayOfInt;
  }
  
  private static void drawBullsEye(BitMatrix paramBitMatrix, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int k = paramInt1 - i;
      j = k;
      for (;;)
      {
        int m = paramInt1 + i;
        if (j > m) {
          break;
        }
        paramBitMatrix.set(j, k);
        paramBitMatrix.set(j, m);
        paramBitMatrix.set(k, j);
        paramBitMatrix.set(m, j);
        j += 1;
      }
      i += 2;
    }
    i = paramInt1 - paramInt2;
    paramBitMatrix.set(i, i);
    int j = i + 1;
    paramBitMatrix.set(j, i);
    paramBitMatrix.set(i, j);
    paramInt1 += paramInt2;
    paramBitMatrix.set(paramInt1, i);
    paramBitMatrix.set(paramInt1, j);
    paramBitMatrix.set(paramInt1, paramInt1 - 1);
  }
  
  private static void drawModeMessage(BitMatrix paramBitMatrix, boolean paramBoolean, int paramInt, BitArray paramBitArray)
  {
    int j = paramInt / 2;
    paramInt = 0;
    int i = 0;
    if (paramBoolean)
    {
      paramInt = i;
      while (paramInt < 7)
      {
        i = j - 3 + paramInt;
        if (paramBitArray.get(paramInt)) {
          paramBitMatrix.set(i, j - 5);
        }
        if (paramBitArray.get(paramInt + 7)) {
          paramBitMatrix.set(j + 5, i);
        }
        if (paramBitArray.get(20 - paramInt)) {
          paramBitMatrix.set(i, j + 5);
        }
        if (paramBitArray.get(27 - paramInt)) {
          paramBitMatrix.set(j - 5, i);
        }
        paramInt += 1;
      }
    }
    while (paramInt < 10)
    {
      i = j - 5 + paramInt + paramInt / 5;
      if (paramBitArray.get(paramInt)) {
        paramBitMatrix.set(i, j - 7);
      }
      if (paramBitArray.get(paramInt + 10)) {
        paramBitMatrix.set(j + 7, i);
      }
      if (paramBitArray.get(29 - paramInt)) {
        paramBitMatrix.set(i, j + 7);
      }
      if (paramBitArray.get(39 - paramInt)) {
        paramBitMatrix.set(j - 7, i);
      }
      paramInt += 1;
    }
  }
  
  public static AztecCode encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 33, 0);
  }
  
  public static AztecCode encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitArray localBitArray = new HighLevelEncoder(paramArrayOfByte).encode();
    int n = localBitArray.getSize() * paramInt1 / 100 + 11;
    int m = localBitArray.getSize();
    paramInt1 = 32;
    boolean bool1;
    int j;
    int k;
    Object localObject;
    int i;
    boolean bool2;
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      j = Math.abs(paramInt2);
      if (bool1) {
        paramInt1 = 4;
      }
      if (j <= paramInt1)
      {
        k = totalBitsInLayer(j, bool1);
        m = WORD_SIZE[j];
        localObject = stuffBits(localBitArray, m);
        if (((BitArray)localObject).getSize() + n <= k - k % m)
        {
          i = k;
          paramArrayOfByte = (byte[])localObject;
          bool2 = bool1;
          paramInt1 = m;
          paramInt2 = j;
          if (bool1) {
            if (((BitArray)localObject).getSize() <= m * 64)
            {
              i = k;
              paramArrayOfByte = (byte[])localObject;
              bool2 = bool1;
              paramInt1 = m;
              paramInt2 = j;
            }
            else
            {
              throw new IllegalArgumentException("Data to large for user specified layer");
            }
          }
        }
        else
        {
          throw new IllegalArgumentException("Data to large for user specified layer");
        }
      }
      else
      {
        throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[] { Integer.valueOf(paramInt2) }));
      }
    }
    else
    {
      paramArrayOfByte = null;
      paramInt2 = 0;
      i = 0;
    }
    while (paramInt2 <= 32)
    {
      if (paramInt2 <= 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        j = paramInt2 + 1;
      } else {
        j = paramInt2;
      }
      k = totalBitsInLayer(j, bool1);
      if (m + n > k)
      {
        localObject = paramArrayOfByte;
      }
      else
      {
        paramInt1 = i;
        if (i != WORD_SIZE[j])
        {
          paramInt1 = WORD_SIZE[j];
          paramArrayOfByte = stuffBits(localBitArray, paramInt1);
        }
        if ((bool1) && (paramArrayOfByte.getSize() > paramInt1 * 64))
        {
          i = paramInt1;
          localObject = paramArrayOfByte;
        }
        else
        {
          i = paramInt1;
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.getSize() + n <= k - k % paramInt1)
          {
            paramInt2 = j;
            i = k;
            bool2 = bool1;
            localObject = generateCheckWords(paramArrayOfByte, i, paramInt1);
            int i2 = paramArrayOfByte.getSize() / paramInt1;
            localBitArray = generateModeMessage(bool2, paramInt2, i2);
            if (bool2) {
              paramInt1 = paramInt2 * 4 + 11;
            } else {
              paramInt1 = paramInt2 * 4 + 14;
            }
            int[] arrayOfInt = new int[paramInt1];
            if (bool2)
            {
              i = 0;
              while (i < arrayOfInt.length)
              {
                arrayOfInt[i] = i;
                i += 1;
              }
              i = paramInt1;
            }
            else
            {
              m = paramInt1 / 2;
              k = paramInt1 + 1 + (m - 1) / 15 * 2;
              n = k / 2;
              j = 0;
              for (;;)
              {
                i = k;
                if (j >= m) {
                  break;
                }
                i = j / 15 + j;
                arrayOfInt[(m - j - 1)] = (n - i - 1);
                arrayOfInt[(m + j)] = (i + n + 1);
                j += 1;
              }
            }
            paramArrayOfByte = new BitMatrix(i);
            j = 0;
            k = 0;
            int i1;
            int i3;
            while (j < paramInt2)
            {
              if (bool2) {
                m = (paramInt2 - j) * 4 + 9;
              } else {
                m = (paramInt2 - j) * 4 + 12;
              }
              n = 0;
              for (;;)
              {
                i1 = 0;
                if (n >= m) {
                  break;
                }
                i3 = n * 2;
                while (i1 < 2)
                {
                  int i4;
                  if (((BitArray)localObject).get(k + i3 + i1))
                  {
                    i4 = j * 2;
                    paramArrayOfByte.set(arrayOfInt[(i4 + i1)], arrayOfInt[(i4 + n)]);
                  }
                  if (((BitArray)localObject).get(m * 2 + k + i3 + i1))
                  {
                    i4 = j * 2;
                    paramArrayOfByte.set(arrayOfInt[(i4 + n)], arrayOfInt[(paramInt1 - 1 - i4 - i1)]);
                  }
                  if (((BitArray)localObject).get(m * 4 + k + i3 + i1))
                  {
                    i4 = paramInt1 - 1 - j * 2;
                    paramArrayOfByte.set(arrayOfInt[(i4 - i1)], arrayOfInt[(i4 - n)]);
                  }
                  if (((BitArray)localObject).get(m * 6 + k + i3 + i1))
                  {
                    i4 = j * 2;
                    paramArrayOfByte.set(arrayOfInt[(paramInt1 - 1 - i4 - n)], arrayOfInt[(i4 + i1)]);
                  }
                  i1 += 1;
                }
                n += 1;
              }
              k += m * 8;
              j += 1;
            }
            drawModeMessage(paramArrayOfByte, bool2, i, localBitArray);
            if (bool2)
            {
              drawBullsEye(paramArrayOfByte, i / 2, 5);
            }
            else
            {
              n = i / 2;
              drawBullsEye(paramArrayOfByte, n, 7);
              k = 0;
              j = 0;
              while (k < paramInt1 / 2 - 1)
              {
                m = n & 0x1;
                while (m < i)
                {
                  i1 = n - j;
                  paramArrayOfByte.set(i1, m);
                  i3 = n + j;
                  paramArrayOfByte.set(i3, m);
                  paramArrayOfByte.set(m, i1);
                  paramArrayOfByte.set(m, i3);
                  m += 2;
                }
                k += 15;
                j += 16;
              }
            }
            localObject = new AztecCode();
            ((AztecCode)localObject).setCompact(bool2);
            ((AztecCode)localObject).setSize(i);
            ((AztecCode)localObject).setLayers(paramInt2);
            ((AztecCode)localObject).setCodeWords(i2);
            ((AztecCode)localObject).setMatrix(paramArrayOfByte);
            return (AztecCode)localObject;
          }
        }
      }
      paramInt2 += 1;
      paramArrayOfByte = (byte[])localObject;
    }
    throw new IllegalArgumentException("Data too large for an Aztec code");
  }
  
  private static BitArray generateCheckWords(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int i = paramBitArray.getSize() / paramInt2;
    Object localObject = new ReedSolomonEncoder(getGF(paramInt2));
    int j = paramInt1 / paramInt2;
    paramBitArray = bitsToWords(paramBitArray, paramInt2, j);
    ((ReedSolomonEncoder)localObject).encode(paramBitArray, j - i);
    localObject = new BitArray();
    i = 0;
    ((BitArray)localObject).appendBits(0, paramInt1 % paramInt2);
    j = paramBitArray.length;
    paramInt1 = i;
    while (paramInt1 < j)
    {
      ((BitArray)localObject).appendBits(paramBitArray[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return (BitArray)localObject;
  }
  
  static BitArray generateModeMessage(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    BitArray localBitArray = new BitArray();
    if (paramBoolean)
    {
      localBitArray.appendBits(paramInt1 - 1, 2);
      localBitArray.appendBits(paramInt2 - 1, 6);
      return generateCheckWords(localBitArray, 28, 4);
    }
    localBitArray.appendBits(paramInt1 - 1, 5);
    localBitArray.appendBits(paramInt2 - 1, 11);
    return generateCheckWords(localBitArray, 40, 4);
  }
  
  private static GenericGF getGF(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8)
        {
          if (paramInt != 10)
          {
            if (paramInt == 12) {
              return GenericGF.AZTEC_DATA_12;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unsupported word size ");
            localStringBuilder.append(paramInt);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return GenericGF.AZTEC_DATA_10;
        }
        return GenericGF.AZTEC_DATA_8;
      }
      return GenericGF.AZTEC_DATA_6;
    }
    return GenericGF.AZTEC_PARAM;
  }
  
  static BitArray stuffBits(BitArray paramBitArray, int paramInt)
  {
    BitArray localBitArray = new BitArray();
    int n = paramBitArray.getSize();
    int i1 = (1 << paramInt) - 2;
    int i = 0;
    while (i < n)
    {
      int k = 0;
      int m;
      for (int j = 0; k < paramInt; j = m)
      {
        int i2 = i + k;
        if (i2 < n)
        {
          m = j;
          if (!paramBitArray.get(i2)) {}
        }
        else
        {
          m = j | 1 << paramInt - 1 - k;
        }
        k += 1;
      }
      k = j & i1;
      if (k == i1)
      {
        localBitArray.appendBits(k, paramInt);
        i -= 1;
      }
      else if (k == 0)
      {
        localBitArray.appendBits(j | 0x1, paramInt);
        i -= 1;
      }
      else
      {
        localBitArray.appendBits(j, paramInt);
      }
      i += paramInt;
    }
    return localBitArray;
  }
  
  private static int totalBitsInLayer(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 88;
    } else {
      i = 112;
    }
    return (i + paramInt * 16) * paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */