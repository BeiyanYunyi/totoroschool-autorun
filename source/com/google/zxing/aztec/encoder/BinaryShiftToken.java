package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken
  extends Token
{
  private final short binaryShiftByteCount;
  private final short binaryShiftStart;
  
  BinaryShiftToken(Token paramToken, int paramInt1, int paramInt2)
  {
    super(paramToken);
    this.binaryShiftStart = ((short)paramInt1);
    this.binaryShiftByteCount = ((short)paramInt2);
  }
  
  public void appendTo(BitArray paramBitArray, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < this.binaryShiftByteCount)
    {
      if ((i == 0) || ((i == 31) && (this.binaryShiftByteCount <= 62)))
      {
        paramBitArray.appendBits(31, 5);
        if (this.binaryShiftByteCount > 62) {
          paramBitArray.appendBits(this.binaryShiftByteCount - 31, 16);
        } else if (i == 0) {
          paramBitArray.appendBits(Math.min(this.binaryShiftByteCount, 31), 5);
        } else {
          paramBitArray.appendBits(this.binaryShiftByteCount - 31, 5);
        }
      }
      paramBitArray.appendBits(paramArrayOfByte[(this.binaryShiftStart + i)], 8);
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(this.binaryShiftStart);
    localStringBuilder.append("::");
    localStringBuilder.append(this.binaryShiftStart + this.binaryShiftByteCount - 1);
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\encoder\BinaryShiftToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */