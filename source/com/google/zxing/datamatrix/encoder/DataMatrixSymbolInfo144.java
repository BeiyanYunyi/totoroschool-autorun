package com.google.zxing.datamatrix.encoder;

final class DataMatrixSymbolInfo144
  extends SymbolInfo
{
  DataMatrixSymbolInfo144()
  {
    super(false, 1558, 620, 22, 22, 36, -1, 62);
  }
  
  public int getDataLengthForInterleavedBlock(int paramInt)
  {
    if (paramInt <= 8) {
      return 156;
    }
    return 155;
  }
  
  public int getInterleavedBlockCount()
  {
    return 10;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\DataMatrixSymbolInfo144.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */