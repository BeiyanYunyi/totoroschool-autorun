package com.google.zxing.qrcode.encoder;

final class BlockPair
{
  private final byte[] dataBytes;
  private final byte[] errorCorrectionBytes;
  
  BlockPair(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.dataBytes = paramArrayOfByte1;
    this.errorCorrectionBytes = paramArrayOfByte2;
  }
  
  public byte[] getDataBytes()
  {
    return this.dataBytes;
  }
  
  public byte[] getErrorCorrectionBytes()
  {
    return this.errorCorrectionBytes;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\encoder\BlockPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */