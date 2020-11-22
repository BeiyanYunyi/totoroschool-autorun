package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder
  extends AI01decoder
{
  AI01weightDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  protected abstract void addWeightCode(StringBuilder paramStringBuilder, int paramInt);
  
  protected abstract int checkWeight(int paramInt);
  
  protected final void encodeCompressedWeight(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramInt1 = getGeneralDecoder().extractNumericValueFromBitArray(paramInt1, paramInt2);
    addWeightCode(paramStringBuilder, paramInt1);
    int i = checkWeight(paramInt1);
    paramInt2 = 100000;
    paramInt1 = 0;
    while (paramInt1 < 5)
    {
      if (i / paramInt2 == 0) {
        paramStringBuilder.append('0');
      }
      paramInt2 /= 10;
      paramInt1 += 1;
    }
    paramStringBuilder.append(i);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01weightDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */