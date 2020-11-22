package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder
  extends AI01weightDecoder
{
  private static final int HEADER_SIZE = 5;
  private static final int WEIGHT_SIZE = 15;
  
  AI013x0xDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String parseInformation()
    throws NotFoundException
  {
    if (getInformation().getSize() == 60)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      encodeCompressedGtin(localStringBuilder, 5);
      encodeCompressedWeight(localStringBuilder, 45, 15);
      return localStringBuilder.toString();
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013x0xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */