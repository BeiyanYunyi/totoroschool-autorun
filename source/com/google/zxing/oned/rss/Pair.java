package com.google.zxing.oned.rss;

final class Pair
  extends DataCharacter
{
  private int count;
  private final FinderPattern finderPattern;
  
  Pair(int paramInt1, int paramInt2, FinderPattern paramFinderPattern)
  {
    super(paramInt1, paramInt2);
    this.finderPattern = paramFinderPattern;
  }
  
  int getCount()
  {
    return this.count;
  }
  
  FinderPattern getFinderPattern()
  {
    return this.finderPattern;
  }
  
  void incrementCount()
  {
    this.count += 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */