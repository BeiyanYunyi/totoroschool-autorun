package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01AndOtherAIs
  extends AI01decoder
{
  private static final int HEADER_SIZE = 4;
  
  AI01AndOtherAIs(BitArray paramBitArray)
  {
    super(paramBitArray);
  }
  
  public String parseInformation()
    throws NotFoundException, FormatException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(01)");
    int i = localStringBuilder.length();
    localStringBuilder.append(getGeneralDecoder().extractNumericValueFromBitArray(4, 4));
    encodeCompressedGtinWithoutAI(localStringBuilder, 8, i);
    return getGeneralDecoder().decodeAllCodes(localStringBuilder, 48);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01AndOtherAIs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */