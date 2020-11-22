package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder
{
  private final GeneralAppIdDecoder generalDecoder;
  private final BitArray information;
  
  AbstractExpandedDecoder(BitArray paramBitArray)
  {
    this.information = paramBitArray;
    this.generalDecoder = new GeneralAppIdDecoder(paramBitArray);
  }
  
  public static AbstractExpandedDecoder createDecoder(BitArray paramBitArray)
  {
    if (paramBitArray.get(1)) {
      return new AI01AndOtherAIs(paramBitArray);
    }
    if (!paramBitArray.get(2)) {
      return new AnyAIDecoder(paramBitArray);
    }
    switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 4))
    {
    default: 
      switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 5))
      {
      default: 
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 7))
        {
        default: 
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown decoder: ");
          localStringBuilder.append(paramBitArray);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        break;
      }
    case 5: 
      return new AI01320xDecoder(paramBitArray);
    }
    return new AI013103decoder(paramBitArray);
    return new AI01393xDecoder(paramBitArray);
    return new AI01392xDecoder(paramBitArray);
    return new AI013x0x1xDecoder(paramBitArray, "320", "17");
    return new AI013x0x1xDecoder(paramBitArray, "310", "17");
    return new AI013x0x1xDecoder(paramBitArray, "320", "15");
    return new AI013x0x1xDecoder(paramBitArray, "310", "15");
    return new AI013x0x1xDecoder(paramBitArray, "320", "13");
    return new AI013x0x1xDecoder(paramBitArray, "310", "13");
    return new AI013x0x1xDecoder(paramBitArray, "320", "11");
    return new AI013x0x1xDecoder(paramBitArray, "310", "11");
  }
  
  protected final GeneralAppIdDecoder getGeneralDecoder()
  {
    return this.generalDecoder;
  }
  
  protected final BitArray getInformation()
  {
    return this.information;
  }
  
  public abstract String parseInformation()
    throws NotFoundException, FormatException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AbstractExpandedDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */