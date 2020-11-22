package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject
{
  private final int newPosition;
  
  DecodedObject(int paramInt)
  {
    this.newPosition = paramInt;
  }
  
  final int getNewPosition()
  {
    return this.newPosition;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */