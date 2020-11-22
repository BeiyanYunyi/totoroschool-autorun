package com.google.zxing.qrcode.encoder;

final class MaskUtil
{
  private static final int N1 = 3;
  private static final int N2 = 3;
  private static final int N3 = 40;
  private static final int N4 = 10;
  
  static int applyMaskPenaltyRule1(ByteMatrix paramByteMatrix)
  {
    return applyMaskPenaltyRule1Internal(paramByteMatrix, true) + applyMaskPenaltyRule1Internal(paramByteMatrix, false);
  }
  
  private static int applyMaskPenaltyRule1Internal(ByteMatrix paramByteMatrix, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = paramByteMatrix.getHeight();
    } else {
      m = paramByteMatrix.getWidth();
    }
    int n;
    if (paramBoolean) {
      n = paramByteMatrix.getWidth();
    } else {
      n = paramByteMatrix.getHeight();
    }
    paramByteMatrix = paramByteMatrix.getArray();
    int i1 = 0;
    int i = 0;
    while (i1 < m)
    {
      int i2 = 0;
      int i3 = 0;
      int i4;
      for (int k = -1; i2 < n; k = i4)
      {
        if (paramBoolean) {
          j = paramByteMatrix[i1][i2];
        } else {
          j = paramByteMatrix[i2][i1];
        }
        if (j == k)
        {
          j = i3 + 1;
          i4 = k;
        }
        else
        {
          k = i;
          if (i3 >= 5) {
            k = i + (i3 - 5 + 3);
          }
          i3 = 1;
          i4 = j;
          i = k;
          j = i3;
        }
        i2 += 1;
        i3 = j;
      }
      int j = i;
      if (i3 >= 5) {
        j = i + (i3 - 5 + 3);
      }
      i = j;
      i1 += 1;
    }
    return i;
  }
  
  static int applyMaskPenaltyRule2(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i1 = paramByteMatrix.getWidth();
    int i2 = paramByteMatrix.getHeight();
    int j = 0;
    int i = 0;
    while (j < i2 - 1)
    {
      int m = 0;
      while (m < i1 - 1)
      {
        int i3 = arrayOfByte[j][m];
        paramByteMatrix = arrayOfByte[j];
        int n = m + 1;
        int k = i;
        if (i3 == paramByteMatrix[n])
        {
          int i4 = j + 1;
          k = i;
          if (i3 == arrayOfByte[i4][m])
          {
            k = i;
            if (i3 == arrayOfByte[i4][n]) {
              k = i + 1;
            }
          }
        }
        m = n;
        i = k;
      }
      j += 1;
    }
    return i * 3;
  }
  
  static int applyMaskPenaltyRule3(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int n = paramByteMatrix.getWidth();
    int i1 = paramByteMatrix.getHeight();
    int k = 0;
    int i = 0;
    while (k < i1)
    {
      int m = 0;
      while (m < n)
      {
        paramByteMatrix = arrayOfByte[k];
        int i2 = m + 6;
        int j = i;
        if (i2 < n)
        {
          j = i;
          if (paramByteMatrix[m] == 1)
          {
            j = i;
            if (paramByteMatrix[(m + 1)] == 0)
            {
              j = i;
              if (paramByteMatrix[(m + 2)] == 1)
              {
                j = i;
                if (paramByteMatrix[(m + 3)] == 1)
                {
                  j = i;
                  if (paramByteMatrix[(m + 4)] == 1)
                  {
                    j = i;
                    if (paramByteMatrix[(m + 5)] == 0)
                    {
                      j = i;
                      if (paramByteMatrix[i2] == 1) {
                        if (!isWhiteHorizontal(paramByteMatrix, m - 4, m))
                        {
                          j = i;
                          if (!isWhiteHorizontal(paramByteMatrix, m + 7, m + 11)) {}
                        }
                        else
                        {
                          j = i + 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i2 = k + 6;
        i = j;
        if (i2 < i1)
        {
          i = j;
          if (arrayOfByte[k][m] == 1)
          {
            i = j;
            if (arrayOfByte[(k + 1)][m] == 0)
            {
              i = j;
              if (arrayOfByte[(k + 2)][m] == 1)
              {
                i = j;
                if (arrayOfByte[(k + 3)][m] == 1)
                {
                  i = j;
                  if (arrayOfByte[(k + 4)][m] == 1)
                  {
                    i = j;
                    if (arrayOfByte[(k + 5)][m] == 0)
                    {
                      i = j;
                      if (arrayOfByte[i2][m] == 1) {
                        if (!isWhiteVertical(arrayOfByte, m, k - 4, k))
                        {
                          i = j;
                          if (!isWhiteVertical(arrayOfByte, m, k + 7, k + 11)) {}
                        }
                        else
                        {
                          i = j + 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        m += 1;
      }
      k += 1;
    }
    return i * 40;
  }
  
  static int applyMaskPenaltyRule4(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int n = paramByteMatrix.getWidth();
    int i1 = paramByteMatrix.getHeight();
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      byte[] arrayOfByte1 = arrayOfByte[j];
      int k = 0;
      while (k < n)
      {
        int m = i;
        if (arrayOfByte1[k] == 1) {
          m = i + 1;
        }
        k += 1;
        i = m;
      }
      j += 1;
    }
    j = paramByteMatrix.getHeight() * paramByteMatrix.getWidth();
    return Math.abs(i * 2 - j) * 10 / j * 10;
  }
  
  static boolean getDataMaskBit(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mask pattern: ");
      localStringBuilder.append(paramInt1);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 7: 
      paramInt1 = paramInt3 * paramInt2 % 3 + (paramInt3 + paramInt2 & 0x1) & 0x1;
      break;
    case 6: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3 & 0x1;
      break;
    case 5: 
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
      break;
    case 4: 
      paramInt1 = paramInt3 / 2 + paramInt2 / 3 & 0x1;
      break;
    case 3: 
      paramInt1 = (paramInt3 + paramInt2) % 3;
      break;
    case 2: 
      paramInt1 = paramInt2 % 3;
      break;
    case 1: 
      paramInt1 = paramInt3 & 0x1;
      break;
    case 0: 
      paramInt1 = paramInt3 + paramInt2 & 0x1;
    }
    return paramInt1 == 0;
  }
  
  private static boolean isWhiteHorizontal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if ((paramInt1 >= 0) && (paramInt1 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt1] == 1)) {
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean isWhiteVertical(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt2 < paramInt3)
    {
      if ((paramInt2 >= 0) && (paramInt2 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt2][paramInt1] == 1)) {
        return false;
      }
      paramInt2 += 1;
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\encoder\MaskUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */