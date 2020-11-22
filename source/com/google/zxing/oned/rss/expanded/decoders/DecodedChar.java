package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar
  extends DecodedObject
{
  static final char FNC1 = '$';
  private final char value;
  
  DecodedChar(int paramInt, char paramChar)
  {
    super(paramInt);
    this.value = paramChar;
  }
  
  char getValue()
  {
    return this.value;
  }
  
  boolean isFNC1()
  {
    return this.value == '$';
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */