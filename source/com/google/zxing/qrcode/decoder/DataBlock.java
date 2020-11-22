package com.google.zxing.qrcode.decoder;

final class DataBlock
{
  private final byte[] codewords;
  private final int numDataCodewords;
  
  private DataBlock(int paramInt, byte[] paramArrayOfByte)
  {
    this.numDataCodewords = paramInt;
    this.codewords = paramArrayOfByte;
  }
  
  static DataBlock[] getDataBlocks(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    if (paramArrayOfByte.length == paramVersion.getTotalCodewords())
    {
      paramVersion = paramVersion.getECBlocksForLevel(paramErrorCorrectionLevel);
      paramErrorCorrectionLevel = paramVersion.getECBlocks();
      int k = paramErrorCorrectionLevel.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += paramErrorCorrectionLevel[i].getCount();
        i += 1;
      }
      DataBlock[] arrayOfDataBlock = new DataBlock[j];
      int m = paramErrorCorrectionLevel.length;
      k = 0;
      for (j = 0; k < m; j = i)
      {
        Object localObject = paramErrorCorrectionLevel[k];
        i = j;
        j = 0;
        while (j < ((Version.ECB)localObject).getCount())
        {
          n = ((Version.ECB)localObject).getDataCodewords();
          arrayOfDataBlock[i] = new DataBlock(n, new byte[paramVersion.getECCodewordsPerBlock() + n]);
          j += 1;
          i += 1;
        }
        k += 1;
      }
      k = arrayOfDataBlock[0].codewords.length;
      i = arrayOfDataBlock.length - 1;
      while ((i >= 0) && (arrayOfDataBlock[i].codewords.length != k)) {
        i -= 1;
      }
      int i1 = i + 1;
      int n = k - paramVersion.getECCodewordsPerBlock();
      k = 0;
      i = 0;
      while (k < n)
      {
        m = 0;
        while (m < j)
        {
          arrayOfDataBlock[m].codewords[k] = paramArrayOfByte[i];
          m += 1;
          i += 1;
        }
        k += 1;
      }
      m = i1;
      k = i;
      while (m < j)
      {
        arrayOfDataBlock[m].codewords[n] = paramArrayOfByte[k];
        m += 1;
        k += 1;
      }
      int i2 = arrayOfDataBlock[0].codewords.length;
      i = n;
      while (i < i2)
      {
        m = 0;
        while (m < j)
        {
          if (m < i1) {
            n = i;
          } else {
            n = i + 1;
          }
          arrayOfDataBlock[m].codewords[n] = paramArrayOfByte[k];
          m += 1;
          k += 1;
        }
        i += 1;
      }
      return arrayOfDataBlock;
    }
    throw new IllegalArgumentException();
  }
  
  byte[] getCodewords()
  {
    return this.codewords;
  }
  
  int getNumDataCodewords()
  {
    return this.numDataCodewords;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */