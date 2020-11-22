package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

abstract class DataMask
{
  private static final DataMask[] DATA_MASKS = { new DataMask000(null), new DataMask001(null), new DataMask010(null), new DataMask011(null), new DataMask100(null), new DataMask101(null), new DataMask110(null), new DataMask111(null) };
  
  static DataMask forReference(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 7)) {
      return DATA_MASKS[paramInt];
    }
    throw new IllegalArgumentException();
  }
  
  abstract boolean isMasked(int paramInt1, int paramInt2);
  
  final void unmaskBitMatrix(BitMatrix paramBitMatrix, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        if (isMasked(i, j)) {
          paramBitMatrix.flip(j, i);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static final class DataMask000
    extends DataMask
  {
    private DataMask000()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return (paramInt1 + paramInt2 & 0x1) == 0;
    }
  }
  
  private static final class DataMask001
    extends DataMask
  {
    private DataMask001()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return (paramInt1 & 0x1) == 0;
    }
  }
  
  private static final class DataMask010
    extends DataMask
  {
    private DataMask010()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return paramInt2 % 3 == 0;
    }
  }
  
  private static final class DataMask011
    extends DataMask
  {
    private DataMask011()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return (paramInt1 + paramInt2) % 3 == 0;
    }
  }
  
  private static final class DataMask100
    extends DataMask
  {
    private DataMask100()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return (paramInt1 / 2 + paramInt2 / 3 & 0x1) == 0;
    }
  }
  
  private static final class DataMask101
    extends DataMask
  {
    private DataMask101()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      paramInt1 *= paramInt2;
      return (paramInt1 & 0x1) + paramInt1 % 3 == 0;
    }
  }
  
  private static final class DataMask110
    extends DataMask
  {
    private DataMask110()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      paramInt1 *= paramInt2;
      return ((paramInt1 & 0x1) + paramInt1 % 3 & 0x1) == 0;
    }
  }
  
  private static final class DataMask111
    extends DataMask
  {
    private DataMask111()
    {
      super();
    }
    
    boolean isMasked(int paramInt1, int paramInt2)
    {
      return ((paramInt1 + paramInt2 & 0x1) + paramInt1 * paramInt2 % 3 & 0x1) == 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */