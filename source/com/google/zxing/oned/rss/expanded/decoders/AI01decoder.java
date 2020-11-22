package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder
  extends AbstractExpandedDecoder
{
  protected static final int GTIN_SIZE = 40;
  
  AI01decoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  private static void appendCheckDigit(StringBuilder paramStringBuilder, int paramInt)
  {
    int m = 0;
    int i = 0;
    int j = 0;
    while (i < 13)
    {
      int n = paramStringBuilder.charAt(i + paramInt) - '0';
      int k = n;
      if ((i & 0x1) == 0) {
        k = n * 3;
      }
      j += k;
      i += 1;
    }
    paramInt = 10 - j % 10;
    if (paramInt == 10) {
      paramInt = m;
    }
    paramStringBuilder.append(paramInt);
  }
  
  protected final void encodeCompressedGtin(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("(01)");
    int i = paramStringBuilder.length();
    paramStringBuilder.append('9');
    encodeCompressedGtinWithoutAI(paramStringBuilder, paramInt, i);
  }
  
  protected final void encodeCompressedGtinWithoutAI(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < 4)
    {
      int j = getGeneralDecoder().extractNumericValueFromBitArray(i * 10 + paramInt1, 10);
      if (j / 100 == 0) {
        paramStringBuilder.append('0');
      }
      if (j / 10 == 0) {
        paramStringBuilder.append('0');
      }
      paramStringBuilder.append(j);
      i += 1;
    }
    appendCheckDigit(paramStringBuilder, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */