package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder
  extends AI01decoder
{
  private static final int FIRST_THREE_DIGITS_SIZE = 10;
  private static final int HEADER_SIZE = 8;
  private static final int LAST_DIGIT_SIZE = 2;
  
  AI01393xDecoder(BitArray paramBitArray)
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
      localStringBuilder.append("(393");
      localStringBuilder.append(i);
      localStringBuilder.append(')');
      i = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
      if (i / 100 == 0) {
        localStringBuilder.append('0');
      }
      if (i / 10 == 0) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(i);
      localStringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
      return localStringBuilder.toString();
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01393xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */