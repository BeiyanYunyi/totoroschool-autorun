package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder
  extends AI01decoder
{
  private static final int HEADER_SIZE = 8;
  private static final int LAST_DIGIT_SIZE = 2;
  
  AI01392xDecoder(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String parseInformation()
    throws NotFoundException, FormatException
  {
    if (getInformation().getSize() >= 48)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      encodeCompressedGtin(localStringBuilder, 8);
      int i = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
      localStringBuilder.append("(392");
      localStringBuilder.append(i);
      localStringBuilder.append(')');
      localStringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
      return localStringBuilder.toString();
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01392xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */