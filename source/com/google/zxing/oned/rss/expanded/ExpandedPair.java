package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair
{
  private final FinderPattern finderPattern;
  private final DataCharacter leftChar;
  private final boolean mayBeLast;
  private final DataCharacter rightChar;
  
  ExpandedPair(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean)
  {
    this.leftChar = paramDataCharacter1;
    this.rightChar = paramDataCharacter2;
    this.finderPattern = paramFinderPattern;
    this.mayBeLast = paramBoolean;
  }
  
  private static boolean equalsOrNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static int hashNotNull(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ExpandedPair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ExpandedPair)paramObject;
    bool1 = bool2;
    if (equalsOrNull(this.leftChar, ((ExpandedPair)paramObject).leftChar))
    {
      bool1 = bool2;
      if (equalsOrNull(this.rightChar, ((ExpandedPair)paramObject).rightChar))
      {
        bool1 = bool2;
        if (equalsOrNull(this.finderPattern, ((ExpandedPair)paramObject).finderPattern)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  FinderPattern getFinderPattern()
  {
    return this.finderPattern;
  }
  
  DataCharacter getLeftChar()
  {
    return this.leftChar;
  }
  
  DataCharacter getRightChar()
  {
    return this.rightChar;
  }
  
  public int hashCode()
  {
    return hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar) ^ hashNotNull(this.finderPattern);
  }
  
  boolean mayBeLast()
  {
    return this.mayBeLast;
  }
  
  public boolean mustBeLast()
  {
    return this.rightChar == null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ ");
    localStringBuilder.append(this.leftChar);
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.rightChar);
    localStringBuilder.append(" : ");
    Object localObject;
    if (this.finderPattern == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(this.finderPattern.getValue());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\ExpandedPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */