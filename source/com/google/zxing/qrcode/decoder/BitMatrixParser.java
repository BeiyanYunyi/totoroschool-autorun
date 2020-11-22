package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix bitMatrix;
  private boolean mirror;
  private FormatInformation parsedFormatInfo;
  private Version parsedVersion;
  
  BitMatrixParser(BitMatrix paramBitMatrix)
    throws FormatException
  {
    int i = paramBitMatrix.getHeight();
    if ((i >= 21) && ((i & 0x3) == 1))
    {
      this.bitMatrix = paramBitMatrix;
      return;
    }
    throw FormatException.getFormatInstance();
  }
  
  private int copyBit(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.mirror) {
      bool = this.bitMatrix.get(paramInt2, paramInt1);
    } else {
      bool = this.bitMatrix.get(paramInt1, paramInt2);
    }
    if (bool) {
      return paramInt3 << 1 | 0x1;
    }
    return paramInt3 << 1;
  }
  
  void mirror()
  {
    int j;
    for (int i = 0; i < this.bitMatrix.getWidth(); i = j)
    {
      j = i + 1;
      int k = j;
      while (k < this.bitMatrix.getHeight())
      {
        if (this.bitMatrix.get(i, k) != this.bitMatrix.get(k, i))
        {
          this.bitMatrix.flip(k, i);
          this.bitMatrix.flip(i, k);
        }
        k += 1;
      }
    }
  }
  
  byte[] readCodewords()
    throws FormatException
  {
    Object localObject = readFormatInformation();
    Version localVersion = readVersion();
    localObject = DataMask.forReference(((FormatInformation)localObject).getDataMask());
    int i8 = this.bitMatrix.getHeight();
    ((DataMask)localObject).unmaskBitMatrix(this.bitMatrix, i8);
    localObject = localVersion.buildFunctionPattern();
    byte[] arrayOfByte = new byte[localVersion.getTotalCodewords()];
    int i7 = i8 - 1;
    int m = i7;
    int i = 0;
    int i1 = 1;
    int j = 0;
    int k = 0;
    while (m > 0)
    {
      int i2 = m;
      if (m == 6) {
        i2 = m - 1;
      }
      int n = 0;
      m = k;
      k = n;
      while (k < i8)
      {
        int i3;
        if (i1 != 0) {
          i3 = i7 - k;
        } else {
          i3 = k;
        }
        int i4 = 0;
        int i5 = m;
        while (i4 < 2)
        {
          int i9 = i2 - i4;
          int i6 = i;
          m = i5;
          n = j;
          if (!((BitMatrix)localObject).get(i9, i3))
          {
            m = i5 + 1;
            j <<= 1;
            if (this.bitMatrix.get(i9, i3)) {
              j |= 0x1;
            }
            if (m == 8)
            {
              arrayOfByte[i] = ((byte)j);
              i6 = i + 1;
              m = 0;
              n = 0;
            }
            else
            {
              n = j;
              i6 = i;
            }
          }
          i4 += 1;
          i = i6;
          i5 = m;
          j = n;
        }
        k += 1;
        m = i5;
      }
      i1 ^= 0x1;
      n = i2 - 2;
      k = m;
      m = n;
    }
    if (i == localVersion.getTotalCodewords()) {
      return arrayOfByte;
    }
    throw FormatException.getFormatInstance();
  }
  
  FormatInformation readFormatInformation()
    throws FormatException
  {
    if (this.parsedFormatInfo != null) {
      return this.parsedFormatInfo;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    while (i < 6)
    {
      j = copyBit(i, 8, j);
      i += 1;
    }
    j = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, j)));
    i = 5;
    while (i >= 0)
    {
      j = copyBit(8, i, j);
      i -= 1;
    }
    int n = this.bitMatrix.getHeight();
    int k = n - 1;
    i = m;
    while (k >= n - 7)
    {
      i = copyBit(8, k, i);
      k -= 1;
    }
    k = n - 8;
    while (k < n)
    {
      i = copyBit(k, 8, i);
      k += 1;
    }
    this.parsedFormatInfo = FormatInformation.decodeFormatInformation(j, i);
    if (this.parsedFormatInfo != null) {
      return this.parsedFormatInfo;
    }
    throw FormatException.getFormatInstance();
  }
  
  Version readVersion()
    throws FormatException
  {
    if (this.parsedVersion != null) {
      return this.parsedVersion;
    }
    int i1 = this.bitMatrix.getHeight();
    int i = (i1 - 17) / 4;
    if (i <= 6) {
      return Version.getVersionForNumber(i);
    }
    int i2 = i1 - 11;
    int m = 5;
    int n = 0;
    i = 5;
    int j = 0;
    int k;
    while (i >= 0)
    {
      k = i1 - 9;
      while (k >= i2)
      {
        j = copyBit(k, i, j);
        k -= 1;
      }
      i -= 1;
    }
    Version localVersion = Version.decodeVersionInformation(j);
    i = m;
    j = n;
    if (localVersion != null)
    {
      i = m;
      j = n;
      if (localVersion.getDimensionForVersion() == i1)
      {
        this.parsedVersion = localVersion;
        return localVersion;
      }
    }
    while (i >= 0)
    {
      k = i1 - 9;
      while (k >= i2)
      {
        j = copyBit(i, k, j);
        k -= 1;
      }
      i -= 1;
    }
    localVersion = Version.decodeVersionInformation(j);
    if ((localVersion != null) && (localVersion.getDimensionForVersion() == i1))
    {
      this.parsedVersion = localVersion;
      return localVersion;
    }
    throw FormatException.getFormatInstance();
  }
  
  void remask()
  {
    if (this.parsedFormatInfo == null) {
      return;
    }
    DataMask localDataMask = DataMask.forReference(this.parsedFormatInfo.getDataMask());
    int i = this.bitMatrix.getHeight();
    localDataMask.unmaskBitMatrix(this.bitMatrix, i);
  }
  
  void setMirror(boolean paramBoolean)
  {
    this.parsedVersion = null;
    this.parsedFormatInfo = null;
    this.mirror = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */