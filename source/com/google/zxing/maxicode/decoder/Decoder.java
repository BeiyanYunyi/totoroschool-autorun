package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder
{
  private static final int ALL = 0;
  private static final int EVEN = 1;
  private static final int ODD = 2;
  private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
  
  private void correctErrors(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws ChecksumException
  {
    int m = paramInt2 + paramInt3;
    int i;
    if (paramInt4 == 0) {
      i = 1;
    } else {
      i = 2;
    }
    int[] arrayOfInt = new int[m / i];
    int k = 0;
    int j = 0;
    while (j < m)
    {
      if ((paramInt4 == 0) || (j % 2 == paramInt4 - 1)) {
        arrayOfInt[(j / i)] = (paramArrayOfByte[(j + paramInt1)] & 0xFF);
      }
      j += 1;
    }
    try
    {
      this.rsDecoder.decode(arrayOfInt, paramInt3 / i);
      paramInt3 = k;
      while (paramInt3 < paramInt2)
      {
        if ((paramInt4 == 0) || (paramInt3 % 2 == paramInt4 - 1)) {
          paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)arrayOfInt[(paramInt3 / i)]);
        }
        paramInt3 += 1;
      }
      return;
    }
    catch (ReedSolomonException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix)
    throws ChecksumException, FormatException
  {
    return decode(paramBitMatrix, null);
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap)
    throws FormatException, ChecksumException
  {
    paramMap = new BitMatrixParser(paramBitMatrix).readCodewords();
    correctErrors(paramMap, 0, 10, 10, 0);
    int i = paramMap[0] & 0xF;
    switch (i)
    {
    default: 
      throw FormatException.getFormatInstance();
    case 5: 
      correctErrors(paramMap, 20, 68, 56, 1);
      correctErrors(paramMap, 20, 68, 56, 2);
      paramBitMatrix = new byte[78];
      break;
    case 2: 
    case 3: 
    case 4: 
      correctErrors(paramMap, 20, 84, 40, 1);
      correctErrors(paramMap, 20, 84, 40, 2);
      paramBitMatrix = new byte[94];
    }
    System.arraycopy(paramMap, 0, paramBitMatrix, 0, 10);
    System.arraycopy(paramMap, 20, paramBitMatrix, 10, paramBitMatrix.length - 10);
    return DecodedBitStreamParser.decode(paramBitMatrix, i);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\maxicode\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */