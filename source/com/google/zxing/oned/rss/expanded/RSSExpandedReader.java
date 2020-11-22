package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader
  extends AbstractRSSReader
{
  private static final int[] EVEN_TOTAL_SUBSET;
  private static final int[][] FINDER_PATTERNS;
  private static final int[][] FINDER_PATTERN_SEQUENCES;
  private static final int FINDER_PAT_A = 0;
  private static final int FINDER_PAT_B = 1;
  private static final int FINDER_PAT_C = 2;
  private static final int FINDER_PAT_D = 3;
  private static final int FINDER_PAT_E = 4;
  private static final int FINDER_PAT_F = 5;
  private static final int[] GSUM;
  private static final int MAX_PAIRS = 11;
  private static final int[] SYMBOL_WIDEST = { 7, 5, 4, 3, 1 };
  private static final int[][] WEIGHTS;
  private final List<ExpandedPair> pairs = new ArrayList(11);
  private final List<ExpandedRow> rows = new ArrayList();
  private final int[] startEnd = new int[2];
  private boolean startFromEven;
  
  static
  {
    EVEN_TOTAL_SUBSET = new int[] { 4, 20, 52, 104, 204 };
    GSUM = new int[] { 0, 348, 1388, 2948, 3988 };
    int[] arrayOfInt1 = { 3, 4, 6, 1 };
    int[] arrayOfInt2 = { 3, 2, 8, 1 };
    int[] arrayOfInt3 = { 2, 6, 5, 1 };
    int[] arrayOfInt4 = { 2, 2, 9, 1 };
    FINDER_PATTERNS = new int[][] { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4 };
    arrayOfInt1 = new int[] { 1, 3, 9, 27, 81, 32, 96, 77 };
    arrayOfInt2 = new int[] { 20, 60, 180, 118, 143, 7, 21, 63 };
    arrayOfInt3 = new int[] { 193, 157, 49, 147, 19, 57, 171, 91 };
    arrayOfInt4 = new int[] { 62, 186, 136, 197, 169, 85, 44, 132 };
    int[] arrayOfInt5 = { 185, 133, 188, 142, 4, 12, 36, 108 };
    int[] arrayOfInt6 = { 113, 128, 173, 97, 80, 29, 87, 50 };
    int[] arrayOfInt7 = { 150, 28, 84, 41, 123, 158, 52, 156 };
    int[] arrayOfInt8 = { 46, 138, 203, 187, 139, 206, 196, 166 };
    int[] arrayOfInt9 = { 76, 17, 51, 153, 37, 111, 122, 155 };
    int[] arrayOfInt10 = { 43, 129, 176, 106, 107, 110, 119, 146 };
    int[] arrayOfInt11 = { 16, 48, 144, 10, 30, 90, 59, 177 };
    int[] arrayOfInt12 = { 109, 116, 137, 200, 178, 112, 125, 164 };
    int[] arrayOfInt13 = { 70, 210, 208, 202, 184, 130, 179, 115 };
    int[] arrayOfInt14 = { 134, 191, 151, 31, 93, 68, 204, 190 };
    int[] arrayOfInt15 = { 148, 22, 66, 198, 172, 94, 71, 2 };
    int[] arrayOfInt16 = { 6, 18, 54, 162, 64, 192, 154, 40 };
    int[] arrayOfInt17 = { 103, 98, 83, 38, 114, 131, 182, 124 };
    int[] arrayOfInt18 = { 161, 61, 183, 127, 170, 88, 53, 159 };
    int[] arrayOfInt19 = { 55, 165, 73, 8, 24, 72, 5, 15 };
    int[] arrayOfInt20 = { 45, 135, 194, 160, 58, 174, 100, 89 };
    WEIGHTS = new int[][] { arrayOfInt1, arrayOfInt2, { 189, 145, 13, 39, 117, 140, 209, 205 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, { 120, 149, 25, 75, 14, 42, 126, 167 }, { 79, 26, 78, 23, 69, 207, 199, 175 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20 };
    arrayOfInt1 = new int[] { 0, 0 };
    arrayOfInt2 = new int[] { 0, 1, 1 };
    arrayOfInt3 = new int[] { 0, 2, 1, 3 };
    arrayOfInt4 = new int[] { 0, 4, 1, 3, 2 };
    arrayOfInt5 = new int[] { 0, 0, 1, 1, 2, 2, 3, 3 };
    arrayOfInt6 = new int[] { 0, 0, 1, 1, 2, 2, 3, 4, 4 };
    arrayOfInt7 = new int[] { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 };
    arrayOfInt8 = new int[] { 0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5 };
    FINDER_PATTERN_SEQUENCES = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 0, 4, 1, 3, 3, 5 }, { 0, 4, 1, 3, 4, 5, 5 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8 };
  }
  
  private void adjustOddEvenCounts(int paramInt)
    throws NotFoundException
  {
    int i1 = count(getOddCounts());
    int i2 = count(getEvenCounts());
    int i3 = i1 + i2 - paramInt;
    paramInt = 0;
    int i = 0;
    int m;
    if ((i1 & 0x1) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((i2 & 0x1) == 0) {
      n = 1;
    } else {
      n = 0;
    }
    int j;
    int k;
    if (i1 > 13)
    {
      j = 0;
      k = 1;
    }
    else
    {
      if (i1 < 4) {
        j = 1;
      } else {
        j = 0;
      }
      k = 0;
    }
    if (i2 > 13)
    {
      i = 1;
    }
    else
    {
      paramInt = i;
      if (i2 < 4) {
        paramInt = 1;
      }
      i = 0;
    }
    if (i3 == 1) {
      if (m != 0) {
        if (n != 0) {}
      }
    }
    for (;;)
    {
      k = 1;
      break label239;
      throw NotFoundException.getNotFoundInstance();
      if (n != 0)
      {
        i = 1;
        break label239;
      }
      throw NotFoundException.getNotFoundInstance();
      if (i3 == -1) {
        if (m != 0) {
          if (n != 0) {}
        }
      }
      for (;;)
      {
        j = 1;
        break label239;
        throw NotFoundException.getNotFoundInstance();
        if (n != 0)
        {
          paramInt = 1;
          break label239;
        }
        throw NotFoundException.getNotFoundInstance();
        if (i3 != 0) {
          break label328;
        }
        if (m == 0) {
          break label234;
        }
        if (n == 0) {
          break label230;
        }
        if (i1 >= i2) {
          break;
        }
        i = 1;
      }
      paramInt = 1;
    }
    label230:
    throw NotFoundException.getNotFoundInstance();
    label234:
    if (n == 0)
    {
      label239:
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
    label328:
    throw NotFoundException.getNotFoundInstance();
  }
  
  private boolean checkChecksum()
  {
    Object localObject1 = this.pairs;
    boolean bool = false;
    Object localObject2 = (ExpandedPair)((List)localObject1).get(0);
    localObject1 = ((ExpandedPair)localObject2).getLeftChar();
    localObject2 = ((ExpandedPair)localObject2).getRightChar();
    if (localObject2 == null) {
      return false;
    }
    int j = ((DataCharacter)localObject2).getChecksumPortion();
    int k = 1;
    int i = 2;
    while (k < this.pairs.size())
    {
      localObject2 = (ExpandedPair)this.pairs.get(k);
      int m = j + ((ExpandedPair)localObject2).getLeftChar().getChecksumPortion();
      int n = i + 1;
      localObject2 = ((ExpandedPair)localObject2).getRightChar();
      j = m;
      i = n;
      if (localObject2 != null)
      {
        j = m + ((DataCharacter)localObject2).getChecksumPortion();
        i = n + 1;
      }
      k += 1;
    }
    if ((i - 4) * 211 + j % 211 == ((DataCharacter)localObject1).getValue()) {
      bool = true;
    }
    return bool;
  }
  
  private List<ExpandedPair> checkRows(List<ExpandedRow> paramList, int paramInt)
    throws NotFoundException
  {
    while (paramInt < this.rows.size())
    {
      Object localObject = (ExpandedRow)this.rows.get(paramInt);
      this.pairs.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.pairs.addAll(((ExpandedRow)paramList.get(i)).getPairs());
        i += 1;
      }
      this.pairs.addAll(((ExpandedRow)localObject).getPairs());
      ArrayList localArrayList;
      if (isValidSequence(this.pairs))
      {
        if (checkChecksum()) {
          return this.pairs;
        }
        localArrayList = new ArrayList();
        localArrayList.addAll(paramList);
        localArrayList.add(localObject);
      }
      try
      {
        localObject = checkRows(localArrayList, paramInt + 1);
        return (List<ExpandedPair>)localObject;
      }
      catch (NotFoundException localNotFoundException)
      {
        for (;;) {}
      }
      paramInt += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private List<ExpandedPair> checkRows(boolean paramBoolean)
  {
    if (this.rows.size() > 25)
    {
      this.rows.clear();
      return null;
    }
    this.pairs.clear();
    if (paramBoolean) {
      Collections.reverse(this.rows);
    }
    try
    {
      localList = checkRows(new ArrayList(), 0);
    }
    catch (NotFoundException localNotFoundException)
    {
      List localList;
      for (;;) {}
    }
    localList = null;
    if (paramBoolean) {
      Collections.reverse(this.rows);
    }
    return localList;
  }
  
  static Result constructResult(List<ExpandedPair> paramList)
    throws NotFoundException, FormatException
  {
    String str = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(paramList)).parseInformation();
    Object localObject1 = ((ExpandedPair)paramList.get(0)).getFinderPattern().getResultPoints();
    Object localObject3 = ((ExpandedPair)paramList.get(paramList.size() - 1)).getFinderPattern().getResultPoints();
    paramList = localObject1[0];
    localObject1 = localObject1[1];
    Object localObject2 = localObject3[0];
    localObject3 = localObject3[1];
    BarcodeFormat localBarcodeFormat = BarcodeFormat.RSS_EXPANDED;
    return new Result(str, null, new ResultPoint[] { paramList, localObject1, localObject2, localObject3 }, localBarcodeFormat);
  }
  
  private void findNextPair(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt)
    throws NotFoundException
  {
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i1 = paramBitArray.getSize();
    if (paramInt < 0) {
      if (paramList.isEmpty()) {
        paramInt = 0;
      } else {
        paramInt = ((ExpandedPair)paramList.get(paramList.size() - 1)).getFinderPattern().getStartEnd()[1];
      }
    }
    if (paramList.size() % 2 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = i;
    if (this.startFromEven) {
      bool = i ^ 0x1;
    }
    int i = 0;
    while (paramInt < i1)
    {
      i = paramBitArray.get(paramInt) ^ true;
      if (i == 0) {
        break;
      }
      paramInt += 1;
    }
    int k = paramInt;
    int n = 0;
    int m = paramInt;
    paramInt = k;
    k = i;
    while (m < i1)
    {
      int j;
      if ((paramBitArray.get(m) ^ k))
      {
        arrayOfInt[n] += 1;
        j = paramInt;
      }
      else
      {
        if (n == 3)
        {
          if (bool) {
            reverseCounters(arrayOfInt);
          }
          if (isFinderPattern(arrayOfInt))
          {
            this.startEnd[0] = paramInt;
            this.startEnd[1] = m;
            return;
          }
          if (bool) {
            reverseCounters(arrayOfInt);
          }
          j = paramInt + (arrayOfInt[0] + arrayOfInt[1]);
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          paramInt = n - 1;
        }
        else
        {
          n += 1;
          j = paramInt;
          paramInt = n;
        }
        arrayOfInt[paramInt] = 1;
        if (k == 0)
        {
          k = 1;
          n = paramInt;
        }
        else
        {
          k = 0;
          n = paramInt;
        }
      }
      m += 1;
      paramInt = j;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int getNextSecondBar(BitArray paramBitArray, int paramInt)
  {
    if (paramBitArray.get(paramInt)) {
      return paramBitArray.getNextSet(paramBitArray.getNextUnset(paramInt));
    }
    return paramBitArray.getNextUnset(paramBitArray.getNextSet(paramInt));
  }
  
  private static boolean isNotA1left(FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramFinderPattern.getValue() != 0) || (!paramBoolean1) || (!paramBoolean2);
  }
  
  private static boolean isPartialRow(Iterable<ExpandedPair> paramIterable, Iterable<ExpandedRow> paramIterable1)
  {
    paramIterable1 = paramIterable1.iterator();
    int i;
    label110:
    label121:
    do
    {
      boolean bool = paramIterable1.hasNext();
      int j = 0;
      if (!bool) {
        break;
      }
      ExpandedRow localExpandedRow = (ExpandedRow)paramIterable1.next();
      Iterator localIterator1 = paramIterable.iterator();
      while (localIterator1.hasNext())
      {
        ExpandedPair localExpandedPair = (ExpandedPair)localIterator1.next();
        Iterator localIterator2 = localExpandedRow.getPairs().iterator();
        while (localIterator2.hasNext()) {
          if (localExpandedPair.equals((ExpandedPair)localIterator2.next()))
          {
            i = 1;
            break label110;
          }
        }
        i = 0;
        if (i == 0)
        {
          i = j;
          break label121;
        }
      }
      i = 1;
    } while (i == 0);
    return true;
    return false;
  }
  
  private static boolean isValidSequence(List<ExpandedPair> paramList)
  {
    int[][] arrayOfInt = FINDER_PATTERN_SEQUENCES;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int[] arrayOfInt1 = arrayOfInt[i];
      if (paramList.size() <= arrayOfInt1.length)
      {
        int j = 0;
        while (j < paramList.size())
        {
          if (((ExpandedPair)paramList.get(j)).getFinderPattern().getValue() != arrayOfInt1[j])
          {
            j = 0;
            break label86;
          }
          j += 1;
        }
        j = 1;
        label86:
        if (j != 0) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private FinderPattern parseFoundFinderPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      i = this.startEnd[0] - 1;
      while ((i >= 0) && (!paramBitArray.get(i))) {
        i -= 1;
      }
      j = i + 1;
      k = this.startEnd[0] - j;
      i = this.startEnd[1];
    }
    else
    {
      j = this.startEnd[0];
      i = paramBitArray.getNextUnset(this.startEnd[1] + 1);
      k = i - this.startEnd[1];
    }
    paramBitArray = getDecodeFinderCounters();
    System.arraycopy(paramBitArray, 0, paramBitArray, 1, paramBitArray.length - 1);
    paramBitArray[0] = k;
    try
    {
      k = parseFinderValue(paramBitArray, FINDER_PATTERNS);
      return new FinderPattern(k, new int[] { j, i }, j, i, paramInt);
    }
    catch (NotFoundException paramBitArray)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static void removePartialRows(List<ExpandedPair> paramList, List<ExpandedRow> paramList1)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (ExpandedRow)paramList1.next();
      if (((ExpandedRow)localObject).getPairs().size() != paramList.size())
      {
        localObject = ((ExpandedRow)localObject).getPairs().iterator();
        int j;
        label132:
        do
        {
          boolean bool = ((Iterator)localObject).hasNext();
          j = 0;
          i = 1;
          if (!bool) {
            break;
          }
          ExpandedPair localExpandedPair = (ExpandedPair)((Iterator)localObject).next();
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext()) {
            if (localExpandedPair.equals((ExpandedPair)localIterator.next())) {
              break label132;
            }
          }
          i = 0;
        } while (i != 0);
        int i = j;
        break label143;
        i = 1;
        label143:
        if (i != 0) {
          paramList1.remove();
        }
      }
    }
  }
  
  private static void reverseCounters(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j / 2)
    {
      int k = paramArrayOfInt[i];
      int m = j - i - 1;
      paramArrayOfInt[i] = paramArrayOfInt[m];
      paramArrayOfInt[m] = k;
      i += 1;
    }
  }
  
  private void storeRow(int paramInt, boolean paramBoolean)
  {
    boolean bool3 = false;
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = bool3;
      if (i >= this.rows.size()) {
        break;
      }
      ExpandedRow localExpandedRow = (ExpandedRow)this.rows.get(i);
      if (localExpandedRow.getRowNumber() > paramInt)
      {
        bool2 = localExpandedRow.isEquivalent(this.pairs);
        break;
      }
      bool1 = localExpandedRow.isEquivalent(this.pairs);
      i += 1;
    }
    if (!bool2)
    {
      if (bool1) {
        return;
      }
      if (isPartialRow(this.pairs, this.rows)) {
        return;
      }
      this.rows.add(i, new ExpandedRow(this.pairs, paramInt, paramBoolean));
      removePartialRows(this.pairs, this.rows);
      return;
    }
  }
  
  DataCharacter decodeDataCharacter(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
    throws NotFoundException
  {
    int[] arrayOfInt1 = getDataCharacterCounters();
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    arrayOfInt1[4] = 0;
    arrayOfInt1[5] = 0;
    arrayOfInt1[6] = 0;
    arrayOfInt1[7] = 0;
    int i;
    int j;
    int k;
    if (paramBoolean2)
    {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt1);
    }
    else
    {
      recordPattern(paramBitArray, paramFinderPattern.getStartEnd()[1], arrayOfInt1);
      i = arrayOfInt1.length - 1;
      j = 0;
      while (j < i)
      {
        k = arrayOfInt1[j];
        arrayOfInt1[j] = arrayOfInt1[i];
        arrayOfInt1[i] = k;
        j += 1;
        i -= 1;
      }
    }
    float f1 = count(arrayOfInt1) / 17;
    float f2 = (paramFinderPattern.getStartEnd()[1] - paramFinderPattern.getStartEnd()[0]) / 15.0F;
    if (Math.abs(f1 - f2) / f2 <= 0.3F)
    {
      paramBitArray = getOddCounts();
      int[] arrayOfInt2 = getEvenCounts();
      float[] arrayOfFloat1 = getOddRoundingErrors();
      float[] arrayOfFloat2 = getEvenRoundingErrors();
      j = 0;
      while (j < arrayOfInt1.length)
      {
        f2 = arrayOfInt1[j] * 1.0F / f1;
        k = (int)(0.5F + f2);
        if (k < 1)
        {
          if (f2 >= 0.3F) {
            i = 1;
          } else {
            throw NotFoundException.getNotFoundInstance();
          }
        }
        else
        {
          i = k;
          if (k > 8) {
            if (f2 <= 8.7F) {
              i = 8;
            } else {
              throw NotFoundException.getNotFoundInstance();
            }
          }
        }
        k = j / 2;
        if ((j & 0x1) == 0)
        {
          paramBitArray[k] = i;
          arrayOfFloat1[k] = (f2 - i);
        }
        else
        {
          arrayOfInt2[k] = i;
          arrayOfFloat2[k] = (f2 - i);
        }
        j += 1;
      }
      adjustOddEvenCounts(17);
      j = paramFinderPattern.getValue();
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 2;
      }
      int i1 = j * 4 + i + (paramBoolean2 ^ true) - 1;
      k = paramBitArray.length - 1;
      i = 0;
      j = 0;
      while (k >= 0)
      {
        m = i;
        if (isNotA1left(paramFinderPattern, paramBoolean1, paramBoolean2))
        {
          m = WEIGHTS[i1][(k * 2)];
          m = i + paramBitArray[k] * m;
        }
        j += paramBitArray[k];
        k -= 1;
        i = m;
      }
      int m = arrayOfInt2.length - 1;
      int n;
      for (k = 0; m >= 0; k = n)
      {
        n = k;
        if (isNotA1left(paramFinderPattern, paramBoolean1, paramBoolean2))
        {
          n = WEIGHTS[i1][(m * 2 + 1)];
          n = k + arrayOfInt2[m] * n;
        }
        m -= 1;
      }
      if (((j & 0x1) == 0) && (j <= 13) && (j >= 4))
      {
        j = (13 - j) / 2;
        n = SYMBOL_WIDEST[j];
        m = RSSUtils.getRSSvalue(paramBitArray, n, true);
        n = RSSUtils.getRSSvalue(arrayOfInt2, 9 - n, false);
        return new DataCharacter(m * EVEN_TOTAL_SUBSET[j] + n + GSUM[j], i + k);
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException
  {
    this.pairs.clear();
    this.startFromEven = false;
    try
    {
      paramMap = constructResult(decodeRow2pairs(paramInt, paramBitArray));
      return paramMap;
    }
    catch (NotFoundException paramMap)
    {
      for (;;) {}
    }
    this.pairs.clear();
    this.startFromEven = true;
    return constructResult(decodeRow2pairs(paramInt, paramBitArray));
  }
  
  /* Error */
  List<ExpandedPair> decodeRow2pairs(int paramInt, BitArray paramBitArray)
    throws NotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: aload_0
    //   3: getfield 61	com/google/zxing/oned/rss/expanded/RSSExpandedReader:pairs	Ljava/util/List;
    //   6: iload_1
    //   7: invokevirtual 361	com/google/zxing/oned/rss/expanded/RSSExpandedReader:retrieveNextPair	(Lcom/google/zxing/common/BitArray;Ljava/util/List;I)Lcom/google/zxing/oned/rss/expanded/ExpandedPair;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 61	com/google/zxing/oned/rss/expanded/RSSExpandedReader:pairs	Ljava/util/List;
    //   16: aload 4
    //   18: invokeinterface 153 2 0
    //   23: pop
    //   24: goto -24 -> 0
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 61	com/google/zxing/oned/rss/expanded/RSSExpandedReader:pairs	Ljava/util/List;
    //   32: invokeinterface 222 1 0
    //   37: ifne +65 -> 102
    //   40: aload_0
    //   41: invokespecial 149	com/google/zxing/oned/rss/expanded/RSSExpandedReader:checkChecksum	()Z
    //   44: ifeq +8 -> 52
    //   47: aload_0
    //   48: getfield 61	com/google/zxing/oned/rss/expanded/RSSExpandedReader:pairs	Ljava/util/List;
    //   51: areturn
    //   52: aload_0
    //   53: getfield 64	com/google/zxing/oned/rss/expanded/RSSExpandedReader:rows	Ljava/util/List;
    //   56: invokeinterface 222 1 0
    //   61: istore_3
    //   62: aload_0
    //   63: iload_1
    //   64: iconst_0
    //   65: invokespecial 363	com/google/zxing/oned/rss/expanded/RSSExpandedReader:storeRow	(IZ)V
    //   68: iload_3
    //   69: iconst_1
    //   70: ixor
    //   71: ifeq +27 -> 98
    //   74: aload_0
    //   75: iconst_0
    //   76: invokespecial 365	com/google/zxing/oned/rss/expanded/RSSExpandedReader:checkRows	(Z)Ljava/util/List;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +5 -> 86
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: iconst_1
    //   88: invokespecial 365	com/google/zxing/oned/rss/expanded/RSSExpandedReader:checkRows	(Z)Ljava/util/List;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +5 -> 98
    //   96: aload_2
    //   97: areturn
    //   98: invokestatic 84	com/google/zxing/NotFoundException:getNotFoundInstance	()Lcom/google/zxing/NotFoundException;
    //   101: athrow
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	RSSExpandedReader
    //   0	104	1	paramInt	int
    //   0	104	2	paramBitArray	BitArray
    //   61	10	3	bool	boolean
    //   10	7	4	localExpandedPair	ExpandedPair
    // Exception table:
    //   from	to	target	type
    //   0	24	27	com/google/zxing/NotFoundException
  }
  
  List<ExpandedRow> getRows()
  {
    return this.rows;
  }
  
  public void reset()
  {
    this.pairs.clear();
    this.rows.clear();
  }
  
  ExpandedPair retrieveNextPair(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt)
    throws NotFoundException
  {
    boolean bool1;
    if (paramList.size() % 2 == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (this.startFromEven) {
      bool2 = bool1 ^ true;
    }
    int j = -1;
    int i = 1;
    FinderPattern localFinderPattern;
    int k;
    do
    {
      findNextPair(paramBitArray, paramList, j);
      localFinderPattern = parseFoundFinderPattern(paramBitArray, paramInt, bool2);
      if (localFinderPattern == null)
      {
        j = getNextSecondBar(paramBitArray, this.startEnd[0]);
        k = i;
      }
      else
      {
        k = 0;
      }
      i = k;
    } while (k != 0);
    DataCharacter localDataCharacter = decodeDataCharacter(paramBitArray, localFinderPattern, bool2, true);
    if ((!paramList.isEmpty()) && (((ExpandedPair)paramList.get(paramList.size() - 1)).mustBeLast())) {
      throw NotFoundException.getNotFoundInstance();
    }
    try
    {
      paramBitArray = decodeDataCharacter(paramBitArray, localFinderPattern, bool2, false);
    }
    catch (NotFoundException paramBitArray)
    {
      for (;;) {}
    }
    paramBitArray = null;
    return new ExpandedPair(localDataCharacter, paramBitArray, localFinderPattern, true);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\RSSExpandedReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */