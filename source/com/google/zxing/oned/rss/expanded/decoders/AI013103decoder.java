package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder
  extends AI013x0xDecoder
{
  AI013103decoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  protected void addWeightCode(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("(3103)");
  }
  
  protected int checkWeight(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013103decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */