package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AnyAIDecoder
  extends AbstractExpandedDecoder
{
  private static final int HEADER_SIZE = 5;
  
  AnyAIDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String parseInformation()
    throws NotFoundException, FormatException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    return getGeneralDecoder().decodeAllCodes(localStringBuilder, 5);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AnyAIDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */