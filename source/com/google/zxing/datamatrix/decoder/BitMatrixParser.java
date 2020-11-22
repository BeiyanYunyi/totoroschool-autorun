package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix mappingBitMatrix;
  private final BitMatrix readMappingMatrix;
  private final Version version;
  
  BitMatrixParser(BitMatrix paramBitMatrix)
    throws FormatException
  {
    int i = paramBitMatrix.getHeight();
    if ((i >= 8) && (i <= 144) && ((i & 0x1) == 0))
    {
      this.version = readVersion(paramBitMatrix);
      this.mappingBitMatrix = extractDataRegion(paramBitMatrix);
      this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
      return;
    }
    throw FormatException.getFormatInstance();
  }
  
  private static Version readVersion(BitMatrix paramBitMatrix)
    throws FormatException
  {
    return Version.getVersionForDimensions(paramBitMatrix.getHeight(), paramBitMatrix.getWidth());
  }
  
  BitMatrix extractDataRegion(BitMatrix paramBitMatrix)
  {
    int j = this.version.getSymbolSizeRows();
    int i = this.version.getSymbolSizeColumns();
    if (paramBitMatrix.getHeight() == j)
    {
      int n = this.version.getDataRegionSizeRows();
      int i1 = this.version.getDataRegionSizeColumns();
      int i2 = j / n;
      int i3 = i / i1;
      BitMatrix localBitMatrix = new BitMatrix(i3 * i1, i2 * n);
      i = 0;
      while (i < i2)
      {
        j = 0;
        while (j < i3)
        {
          int k = 0;
          while (k < n)
          {
            int m = 0;
            while (m < i1)
            {
              if (paramBitMatrix.get((i1 + 2) * j + 1 + m, (n + 2) * i + 1 + k)) {
                localBitMatrix.set(j * i1 + m, i * n + k);
              }
              m += 1;
            }
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
      return localBitMatrix;
    }
    throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
  }
  
  Version getVersion()
  {
    return this.version;
  }
  
  byte[] readCodewords()
    throws FormatException
  {
    byte[] arrayOfByte = new byte[this.version.getTotalCodewords()];
    int i10 = this.mappingBitMatrix.getHeight();
    int i11 = this.mappingBitMatrix.getWidth();
    int i1 = 4;
    int n = 0;
    int i5 = 0;
    int m = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    int j;
    int k;
    label586:
    do
    {
      int i;
      int i6;
      int i7;
      int i8;
      int i9;
      do
      {
        if ((i1 == i10) && (n == 0) && (i5 == 0))
        {
          arrayOfByte[m] = ((byte)readCorner1(i10, i11));
          i = i1 - 2;
          j = n + 2;
          k = m + 1;
          i6 = 1;
          i7 = i4;
          i8 = i3;
          i9 = i2;
        }
        else
        {
          i = i10 - 2;
          if ((i1 == i) && (n == 0) && ((i11 & 0x3) != 0) && (i4 == 0))
          {
            arrayOfByte[m] = ((byte)readCorner2(i10, i11));
            i = i1 - 2;
            j = n + 2;
            k = m + 1;
            i7 = 1;
            i6 = i5;
            i8 = i3;
            i9 = i2;
          }
          else if ((i1 == i10 + 4) && (n == 2) && ((i11 & 0x7) == 0) && (i3 == 0))
          {
            arrayOfByte[m] = ((byte)readCorner3(i10, i11));
            i = i1 - 2;
            j = n + 2;
            k = m + 1;
            i8 = 1;
            i6 = i5;
            i7 = i4;
            i9 = i2;
          }
          else
          {
            j = i1;
            k = n;
            i6 = m;
            if (i1 == i)
            {
              j = i1;
              k = n;
              i6 = m;
              if (n == 0)
              {
                j = i1;
                k = n;
                i6 = m;
                if ((i11 & 0x7) == 4)
                {
                  j = i1;
                  k = n;
                  i6 = m;
                  if (i2 == 0)
                  {
                    arrayOfByte[m] = ((byte)readCorner4(i10, i11));
                    i = i1 - 2;
                    j = n + 2;
                    k = m + 1;
                    i9 = 1;
                    i6 = i5;
                    i7 = i4;
                    i8 = i3;
                    break label586;
                  }
                }
              }
            }
            do
            {
              i = i6;
              if (j < i10)
              {
                i = i6;
                if (k >= 0)
                {
                  i = i6;
                  if (!this.readMappingMatrix.get(k, j))
                  {
                    arrayOfByte[i6] = ((byte)readUtah(j, k, i10, i11));
                    i = i6 + 1;
                  }
                }
              }
              n = j - 2;
              m = k + 2;
              if (n < 0) {
                break;
              }
              j = n;
              k = m;
              i6 = i;
            } while (m < i11);
            k = n + 1;
            m += 3;
            j = i;
            i = m;
            m = k;
            do
            {
              k = j;
              if (m >= 0)
              {
                k = j;
                if (i < i11)
                {
                  k = j;
                  if (!this.readMappingMatrix.get(i, m))
                  {
                    arrayOfByte[j] = ((byte)readUtah(m, i, i10, i11));
                    k = j + 1;
                  }
                }
              }
              i1 = m + 2;
              n = i - 2;
              if (i1 >= i10) {
                break;
              }
              m = i1;
              i = n;
              j = k;
            } while (n >= 0);
            i = i1 + 3;
            j = n + 1;
            i9 = i2;
            i8 = i3;
            i7 = i4;
            i6 = i5;
          }
        }
        i1 = i;
        n = j;
        i5 = i6;
        m = k;
        i4 = i7;
        i3 = i8;
        i2 = i9;
      } while (i < i10);
      i1 = i;
      n = j;
      i5 = i6;
      m = k;
      i4 = i7;
      i3 = i8;
      i2 = i9;
    } while (j < i11);
    if (k == this.version.getTotalCodewords()) {
      return arrayOfByte;
    }
    throw FormatException.getFormatInstance();
  }
  
  int readCorner1(int paramInt1, int paramInt2)
  {
    int k = paramInt1 - 1;
    if (readModule(k, 0, paramInt1, paramInt2)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i << 1;
    int i = j;
    if (readModule(k, 1, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(k, 2, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    k = paramInt2 - 1;
    i = j;
    if (readModule(0, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(2, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(3, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    return i;
  }
  
  int readCorner2(int paramInt1, int paramInt2)
  {
    if (readModule(paramInt1 - 3, 0, paramInt1, paramInt2)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i << 1;
    int i = j;
    if (readModule(paramInt1 - 2, 0, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(paramInt1 - 1, 0, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, paramInt2 - 4, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, paramInt2 - 3, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    int k = paramInt2 - 1;
    i = j;
    if (readModule(0, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    return i;
  }
  
  int readCorner3(int paramInt1, int paramInt2)
  {
    int m = paramInt1 - 1;
    if (readModule(m, 0, paramInt1, paramInt2)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i << 1;
    int k = paramInt2 - 1;
    int i = j;
    if (readModule(m, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    m = paramInt2 - 3;
    i = j;
    if (readModule(0, m, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    int n = paramInt2 - 2;
    i = j;
    if (readModule(0, n, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, m, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, n, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    return i;
  }
  
  int readCorner4(int paramInt1, int paramInt2)
  {
    if (readModule(paramInt1 - 3, 0, paramInt1, paramInt2)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i << 1;
    int i = j;
    if (readModule(paramInt1 - 2, 0, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(paramInt1 - 1, 0, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    int k = paramInt2 - 1;
    i = j;
    if (readModule(0, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(1, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(2, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(3, k, paramInt1, paramInt2)) {
      i = j | 0x1;
    }
    return i;
  }
  
  boolean readModule(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      i = paramInt1 + paramInt3;
      j = paramInt2 + (4 - (paramInt3 + 4 & 0x7));
    }
    paramInt2 = i;
    paramInt1 = j;
    if (j < 0)
    {
      paramInt1 = j + paramInt4;
      paramInt2 = i + (4 - (paramInt4 + 4 & 0x7));
    }
    this.readMappingMatrix.set(paramInt1, paramInt2);
    return this.mappingBitMatrix.get(paramInt1, paramInt2);
  }
  
  int readUtah(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = paramInt1 - 2;
    int k = paramInt2 - 2;
    if (readModule(n, k, paramInt3, paramInt4)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i << 1;
    int m = paramInt2 - 1;
    int i = j;
    if (readModule(n, m, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    n = paramInt1 - 1;
    i = j;
    if (readModule(n, k, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(n, m, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(n, paramInt2, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(paramInt1, k, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(paramInt1, m, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    j = i << 1;
    i = j;
    if (readModule(paramInt1, paramInt2, paramInt3, paramInt4)) {
      i = j | 0x1;
    }
    return i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\decoder\BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */