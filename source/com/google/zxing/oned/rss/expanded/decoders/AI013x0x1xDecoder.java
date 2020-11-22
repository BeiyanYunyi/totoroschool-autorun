package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder
  extends AI01weightDecoder
{
  private static final int DATE_SIZE = 16;
  private static final int HEADER_SIZE = 8;
  private static final int WEIGHT_SIZE = 20;
  private final String dateCode;
  private final String firstAIdigits;
  
  AI013x0x1xDecoder(BitArray paramBitArray, String paramString1, String paramString2)
  {
    super(paramBitArray);
    this.dateCode = paramString2;
    this.firstAIdigits = paramString1;
  }
  
  private void encodeCompressedDate(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = getGeneralDecoder().extractNumericValueFromBitArray(paramInt, 16);
    if (i == 38400) {
      return;
    }
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.dateCode);
    paramStringBuilder.append(')');
    paramInt = i % 32;
    int j = i / 32;
    i = j % 12 + 1;
    j /= 12;
    if (j / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(j);
    if (i / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(i);
    if (paramInt / 10 == 0) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(paramInt);
  }
  
  protected void addWeightCode(StringBuilder paramStringBuilder, int paramInt)
  {
    paramInt /= 100000;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.firstAIdigits);
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(')');
  }
  
  protected int checkWeight(int paramInt)
  {
    return paramInt % 100000;
  }
  
  public String parseInformation()
    throws NotFoundException
  {
    if (getInformation().getSize() == 84)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      encodeCompressedGtin(localStringBuilder, 8);
      encodeCompressedWeight(localStringBuilder, 48, 20);
      encodeCompressedDate(localStringBuilder, 68);
      return localStringBuilder.toString();
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013x0x1xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */