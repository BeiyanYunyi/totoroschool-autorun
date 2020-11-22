package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token
{
  static final Token EMPTY = new SimpleToken(null, 0, 0);
  private final Token previous;
  
  Token(Token paramToken)
  {
    this.previous = paramToken;
  }
  
  final Token add(int paramInt1, int paramInt2)
  {
    return new SimpleToken(this, paramInt1, paramInt2);
  }
  
  final Token addBinaryShift(int paramInt1, int paramInt2)
  {
    return new BinaryShiftToken(this, paramInt1, paramInt2);
  }
  
  abstract void appendTo(BitArray paramBitArray, byte[] paramArrayOfByte);
  
  final Token getPrevious()
  {
    return this.previous;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\encoder\Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */