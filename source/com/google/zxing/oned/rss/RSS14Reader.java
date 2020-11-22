package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader
  extends AbstractRSSReader
{
  private static final int[][] FINDER_PATTERNS = { { 3, 8, 2, 1 }, { 3, 5, 5, 1 }, { 3, 3, 7, 1 }, { 3, 1, 9, 1 }, { 2, 7, 4, 1 }, { 2, 5, 6, 1 }, { 2, 3, 8, 1 }, { 1, 5, 7, 1 }, { 1, 3, 9, 1 } };
  private static final int[] INSIDE_GSUM;
  private static final int[] INSIDE_ODD_TOTAL_SUBSET;
  private static final int[] INSIDE_ODD_WIDEST;
  private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = { 1, 10, 34, 70, 126 };
  private static final int[] OUTSIDE_GSUM;
  private static final int[] OUTSIDE_ODD_WIDEST;
  private final List<Pair> possibleLeftPairs = new ArrayList();
  private final List<Pair> possibleRightPairs = new ArrayList();
  
  static
  {
    INSIDE_ODD_TOTAL_SUBSET = new int[] { 4, 20, 48, 81 };
    OUTSIDE_GSUM = new int[] { 0, 161, 961, 2015, 2715 };
    INSIDE_GSUM = new int[] { 0, 336, 1036, 1516 };
    OUTSIDE_ODD_WIDEST = new int[] { 8, 6, 4, 3, 1 };
    INSIDE_ODD_WIDEST = new int[] { 2, 4, 6, 8 };
  }
  
  private static void addOrTally(Collection<Pair> paramCollection, Pair paramPair)
  {
    if (paramPair == null) {
      return;
    }
    int j = 0;
    Iterator localIterator = paramCollection.iterator();
    Pair localPair;
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      localPair = (Pair)localIterator.next();
    } while (localPair.getValue() != paramPair.getValue());
    localPair.incrementCount();
    int i = 1;
    if (i == 0) {
      paramCollection.add(paramPair);
    }
  }
  
  private void adjustOddEvenCounts(boolean paramBoolean, int paramInt)
    throws NotFoundException
  {
    int i3 = count(getOddCounts());
    int i4 = count(getEvenCounts());
    int i5 = i3 + i4 - paramInt;
    int m = 0;
    int i2 = 0;
    int n;
    if ((i3 & 0x1) == paramBoolean) {
      n = 1;
    } else {
      n = 0;
    }
    int i1;
    if ((i4 & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      if (i3 > 12)
      {
        i = 0;
        paramInt = 1;
      }
      else
      {
        if (i3 < 4) {
          i = 1;
        } else {
          i = 0;
        }
        paramInt = 0;
      }
      if (i4 > 12)
      {
        j = i;
        k = paramInt;
        i = 1;
        paramInt = m;
        break label229;
      }
      if (i4 < 4)
      {
        j = paramInt;
        paramInt = i;
        i = j;
      }
    }
    for (;;)
    {
      m = 1;
      k = i;
      j = paramInt;
      break label157;
      j = i;
      k = paramInt;
      m = i2;
      label157:
      do
      {
        i = 0;
        paramInt = m;
        break label229;
        if (i3 > 11)
        {
          paramInt = 0;
          i = 1;
        }
        else
        {
          if (i3 < 5) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          i = 0;
        }
        if (i4 > 10)
        {
          k = i;
          j = paramInt;
          break;
        }
        m = i2;
        k = i;
        j = paramInt;
      } while (i4 >= 4);
    }
    label229:
    if (i5 == 1) {
      if (n != 0) {
        if (i1 != 0) {}
      }
    }
    for (;;)
    {
      k = 1;
      break label351;
      throw NotFoundException.getNotFoundInstance();
      if (i1 != 0) {}
      for (;;)
      {
        i = 1;
        break label351;
        throw NotFoundException.getNotFoundInstance();
        if (i5 == -1)
        {
          if (n != 0)
          {
            if (i1 == 0)
            {
              j = 1;
              break label351;
            }
            throw NotFoundException.getNotFoundInstance();
          }
          if (i1 != 0)
          {
            paramInt = 1;
            break label351;
          }
          throw NotFoundException.getNotFoundInstance();
        }
        if (i5 != 0) {
          break label441;
        }
        if (n == 0) {
          break label346;
        }
        if (i1 == 0) {
          break label342;
        }
        if (i3 >= i4) {
          break;
        }
        j = 1;
      }
      paramInt = 1;
    }
    label342:
    throw NotFoundException.getNotFoundInstance();
    label346:
    if (i1 == 0)
    {
      label351:
      if (j != 0) {
        if (k == 0) {
          increment(getOddCounts(), getOddRoundingErrors());
        } else {
          throw NotFoundException.getNotFoundInstance();
        }
      }
      if (k != 0) {
        decrement(getOddCounts(), getOddRoundingErrors());
      }
      if (paramInt != 0) {
        if (i == 0) {
          increment(getEvenCounts(), getOddRoundingErrors());
        } else {
          throw NotFoundException.getNotFoundInstance();
        }
      }
      if (i != 0) {
        decrement(getEvenCounts(), getEvenRoundingErrors());
      }
      return;
    }
    throw NotFoundException.getNotFoundInstance();
    label441:
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static boolean checkChecksum(Pair paramPair1, Pair paramPair2)
  {
    int k = paramPair1.getChecksumPortion();
    int m = paramPair2.getChecksumPortion();
    int j = paramPair1.getFinderPattern().getValue() * 9 + paramPair2.getFinderPattern().getValue();
    int i = j;
    if (j > 72) {
      i = j - 1;
    }
    j = i;
    if (i > 8) {
      j = i - 1;
    }
    return (k + m * 16) % 79 == j;
  }
  
  private static Result constructResult(Pair paramPair1, Pair paramPair2)
  {
    Object localObject = String.valueOf(paramPair1.getValue() * 4537077L + paramPair2.getValue());
    StringBuilder localStringBuilder = new StringBuilder(14);
    int i = 13 - ((String)localObject).length();
    while (i > 0)
    {
      localStringBuilder.append('0');
      i -= 1;
    }
    localStringBuilder.append((String)localObject);
    i = 0;
    int j = 0;
    while (i < 13)
    {
      int m = localStringBuilder.charAt(i) - '0';
      int k = m;
      if ((i & 0x1) == 0) {
        k = m * 3;
      }
      j += k;
      i += 1;
    }
    j = 10 - j % 10;
    i = j;
    if (j == 10) {
      i = 0;
    }
    localStringBuilder.append(i);
    ResultPoint[] arrayOfResultPoint = paramPair1.getFinderPattern().getResultPoints();
    localObject = paramPair2.getFinderPattern().getResultPoints();
    paramPair1 = String.valueOf(localStringBuilder.toString());
    paramPair2 = arrayOfResultPoint[0];
    localStringBuilder = arrayOfResultPoint[1];
    arrayOfResultPoint = localObject[0];
    localObject = localObject[1];
    BarcodeFormat localBarcodeFormat = BarcodeFormat.RSS_14;
    return new Result(paramPair1, null, new ResultPoint[] { paramPair2, localStringBuilder, arrayOfResultPoint, localObject }, localBarcodeFormat);
  }
  
  private DataCharacter decodeDataCharacter(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean)
    throws NotFoundException
  {
    int[] arrayOfInt = getDataCharacterCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    arrayOfInt[4] = 0;
    arrayOfInt[5] = 0;
    arrayOfInt[6] = 0;
    arrayOfInt[7] = 0;
    if (paramBoolean)
    {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt);
    }
    else
    {
      recordPattern(paramBitArray, paramFinderPattern.getStartEnd()[1] + 1, arrayOfInt);
      i = arrayOfInt.length - 1;
      j = 0;
      while (j < i)
      {
        k = arrayOfInt[j];
        arrayOfInt[j] = arrayOfInt[i];
        arrayOfInt[i] = k;
        j += 1;
        i -= 1;
      }
    }
    if (paramBoolean) {
      j = 16;
    } else {
      j = 15;
    }
    float f1 = count(arrayOfInt) / j;
    paramBitArray = getOddCounts();
    paramFinderPattern = getEvenCounts();
    float[] arrayOfFloat1 = getOddRoundingErrors();
    float[] arrayOfFloat2 = getEvenRoundingErrors();
    int k = 0;
    while (k < arrayOfInt.length)
    {
      float f2 = arrayOfInt[k] / f1;
      m = (int)(0.5F + f2);
      if (m < 1)
      {
        i = 1;
      }
      else
      {
        i = m;
        if (m > 8) {
          i = 8;
        }
      }
      m = k / 2;
      if ((k & 0x1) == 0)
      {
        paramBitArray[m] = i;
        arrayOfFloat1[m] = (f2 - i);
      }
      else
      {
        paramFinderPattern[m] = i;
        arrayOfFloat2[m] = (f2 - i);
      }
      k += 1;
    }
    adjustOddEvenCounts(paramBoolean, j);
    k = paramBitArray.length - 1;
    int j = 0;
    int i = 0;
    while (k >= 0)
    {
      j = j * 9 + paramBitArray[k];
      i += paramBitArray[k];
      k -= 1;
    }
    int m = paramFinderPattern.length - 1;
    int n = 0;
    k = 0;
    while (m >= 0)
    {
      n = n * 9 + paramFinderPattern[m];
      k += paramFinderPattern[m];
      m -= 1;
    }
    j += n * 3;
    if (paramBoolean)
    {
      if (((i & 0x1) == 0) && (i <= 12) && (i >= 4))
      {
        i = (12 - i) / 2;
        m = OUTSIDE_ODD_WIDEST[i];
        k = RSSUtils.getRSSvalue(paramBitArray, m, false);
        m = RSSUtils.getRSSvalue(paramFinderPattern, 9 - m, true);
        return new DataCharacter(k * OUTSIDE_EVEN_TOTAL_SUBSET[i] + m + OUTSIDE_GSUM[i], j);
      }
      throw NotFoundException.getNotFoundInstance();
    }
    if (((k & 0x1) == 0) && (k <= 10) && (k >= 4))
    {
      i = (10 - k) / 2;
      k = INSIDE_ODD_WIDEST[i];
      m = RSSUtils.getRSSvalue(paramBitArray, k, true);
      return new DataCharacter(RSSUtils.getRSSvalue(paramFinderPattern, 9 - k, false) * INSIDE_ODD_TOTAL_SUBSET[i] + m + INSIDE_GSUM[i], j);
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private Pair decodePair(BitArray paramBitArray, boolean paramBoolean, int paramInt, Map<DecodeHintType, ?> paramMap)
  {
    try
    {
      int[] arrayOfInt = findFinderPattern(paramBitArray, 0, paramBoolean);
      FinderPattern localFinderPattern = parseFoundFinderPattern(paramBitArray, paramInt, paramBoolean, arrayOfInt);
      if (paramMap == null) {
        paramMap = null;
      } else {
        paramMap = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
      }
      if (paramMap != null)
      {
        float f2 = (arrayOfInt[0] + arrayOfInt[1]) / 2.0F;
        float f1 = f2;
        if (paramBoolean) {
          f1 = paramBitArray.getSize() - 1 - f2;
        }
        paramMap.foundPossibleResultPoint(new ResultPoint(f1, paramInt));
      }
      paramMap = decodeDataCharacter(paramBitArray, localFinderPattern, true);
      paramBitArray = decodeDataCharacter(paramBitArray, localFinderPattern, false);
      paramBitArray = new Pair(paramMap.getValue() * 1597 + paramBitArray.getValue(), paramMap.getChecksumPortion() + paramBitArray.getChecksumPortion() * 4, localFinderPattern);
      return paramBitArray;
    }
    catch (NotFoundException paramBitArray) {}
    return null;
  }
  
  private int[] findFinderPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean)
    throws NotFoundException
  {
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int m = paramBitArray.getSize();
    boolean bool = false;
    while (paramInt < m)
    {
      bool = paramBitArray.get(paramInt) ^ true;
      if (paramBoolean == bool) {
        break;
      }
      paramInt += 1;
    }
    int k = paramInt;
    int i = 0;
    int j = paramInt;
    paramInt = k;
    paramBoolean = bool;
    while (j < m)
    {
      if ((paramBitArray.get(j) ^ paramBoolean))
      {
        arrayOfInt[i] += 1;
      }
      else
      {
        if (i == 3)
        {
          if (isFinderPattern(arrayOfInt)) {
            return new int[] { paramInt, j };
          }
          paramInt += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          i -= 1;
        }
        else
        {
          i += 1;
        }
        arrayOfInt[i] = 1;
        if (!paramBoolean) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
      j += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private FinderPattern parseFoundFinderPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
    throws NotFoundException
  {
    boolean bool = paramBitArray.get(paramArrayOfInt[0]);
    int i = paramArrayOfInt[0] - 1;
    while ((i >= 0) && ((paramBitArray.get(i) ^ bool))) {
      i -= 1;
    }
    int k = i + 1;
    i = paramArrayOfInt[0];
    int[] arrayOfInt = getDecodeFinderCounters();
    System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, arrayOfInt.length - 1);
    arrayOfInt[0] = (i - k);
    int m = parseFinderValue(arrayOfInt, FINDER_PATTERNS);
    int j = paramArrayOfInt[1];
    if (paramBoolean)
    {
      i = paramBitArray.getSize();
      j = paramBitArray.getSize() - 1 - j;
      i = i - 1 - k;
    }
    else
    {
      i = k;
    }
    return new FinderPattern(m, new int[] { k, paramArrayOfInt[1] }, i, j, paramInt);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    Pair localPair = decodePair(paramBitArray, false, paramInt, paramMap);
    addOrTally(this.possibleLeftPairs, localPair);
    paramBitArray.reverse();
    paramMap = decodePair(paramBitArray, true, paramInt, paramMap);
    addOrTally(this.possibleRightPairs, paramMap);
    paramBitArray.reverse();
    int j = this.possibleLeftPairs.size();
    paramInt = 0;
    while (paramInt < j)
    {
      paramBitArray = (Pair)this.possibleLeftPairs.get(paramInt);
      if (paramBitArray.getCount() > 1)
      {
        int k = this.possibleRightPairs.size();
        int i = 0;
        while (i < k)
        {
          paramMap = (Pair)this.possibleRightPairs.get(i);
          if ((paramMap.getCount() > 1) && (checkChecksum(paramBitArray, paramMap))) {
            return constructResult(paramBitArray, paramMap);
          }
          i += 1;
        }
      }
      paramInt += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset()
  {
    this.possibleLeftPairs.clear();
    this.possibleRightPairs.clear();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\RSS14Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */