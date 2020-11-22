package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric
  extends DecodedObject
{
  static final int FNC1 = 10;
  private final int firstDigit;
  private final int secondDigit;
  
  DecodedNumeric(int paramInt1, int paramInt2, int paramInt3)
    throws FormatException
  {
    super(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 <= 10) && (paramInt3 >= 0) && (paramInt3 <= 10))
    {
      this.firstDigit = paramInt2;
      this.secondDigit = paramInt3;
      return;
    }
    throw FormatException.getFormatInstance();
  }
  
  int getFirstDigit()
  {
    return this.firstDigit;
  }
  
  int getSecondDigit()
  {
    return this.secondDigit;
  }
  
  int getValue()
  {
    return this.firstDigit * 10 + this.secondDigit;
  }
  
  boolean isAnyFNC1()
  {
    return (this.firstDigit == 10) || (this.secondDigit == 10);
  }
  
  boolean isFirstDigitFNC1()
  {
    return this.firstDigit == 10;
  }
  
  boolean isSecondDigitFNC1()
  {
    return this.secondDigit == 10;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedNumeric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */