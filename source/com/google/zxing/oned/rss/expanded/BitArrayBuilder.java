package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.DataCharacter;
import java.util.List;

final class BitArrayBuilder
{
  static BitArray buildBitArray(List<ExpandedPair> paramList)
  {
    int j = paramList.size() * 2 - 1;
    int i = j;
    if (((ExpandedPair)paramList.get(paramList.size() - 1)).getRightChar() == null) {
      i = j - 1;
    }
    BitArray localBitArray = new BitArray(i * 12);
    int k = ((ExpandedPair)paramList.get(0)).getRightChar().getValue();
    j = 11;
    i = 0;
    while (j >= 0)
    {
      if ((1 << j & k) != 0) {
        localBitArray.set(i);
      }
      i += 1;
      j -= 1;
    }
    k = 1;
    while (k < paramList.size())
    {
      ExpandedPair localExpandedPair = (ExpandedPair)paramList.get(k);
      int m = localExpandedPair.getLeftChar().getValue();
      j = 11;
      while (j >= 0)
      {
        if ((1 << j & m) != 0) {
          localBitArray.set(i);
        }
        i += 1;
        j -= 1;
      }
      j = i;
      if (localExpandedPair.getRightChar() != null)
      {
        int n = localExpandedPair.getRightChar().getValue();
        m = 11;
        for (;;)
        {
          j = i;
          if (m < 0) {
            break;
          }
          if ((1 << m & n) != 0) {
            localBitArray.set(i);
          }
          i += 1;
          m -= 1;
        }
      }
      i = j;
      k += 1;
    }
    return localBitArray;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\BitArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */