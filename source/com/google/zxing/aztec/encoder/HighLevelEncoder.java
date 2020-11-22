package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class HighLevelEncoder
{
  private static final int[][] CHAR_MAP;
  static final int[][] LATCH_TABLE;
  static final int MODE_DIGIT = 2;
  static final int MODE_LOWER = 1;
  static final int MODE_MIXED = 3;
  static final String[] MODE_NAMES = { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
  static final int MODE_PUNCT = 4;
  static final int MODE_UPPER = 0;
  static final int[][] SHIFT_TABLE;
  private final byte[] text;
  
  static
  {
    LATCH_TABLE = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, { 327711, 656380, 656382, 656381, 0 } };
    CHAR_MAP = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 256 });
    CHAR_MAP[0][32] = 1;
    int i = 65;
    while (i <= 90)
    {
      CHAR_MAP[0][i] = (i - 65 + 2);
      i += 1;
    }
    CHAR_MAP[1][32] = 1;
    i = 97;
    while (i <= 122)
    {
      CHAR_MAP[1][i] = (i - 97 + 2);
      i += 1;
    }
    CHAR_MAP[2][32] = 1;
    i = 48;
    while (i <= 57)
    {
      CHAR_MAP[2][i] = (i - 48 + 2);
      i += 1;
    }
    CHAR_MAP[2][44] = 12;
    CHAR_MAP[2][46] = 13;
    Object localObject = new int[28];
    Object tmp354_353 = localObject;
    tmp354_353[0] = 0;
    Object tmp358_354 = tmp354_353;
    tmp358_354[1] = 32;
    Object tmp363_358 = tmp358_354;
    tmp363_358[2] = 1;
    Object tmp367_363 = tmp363_358;
    tmp367_363[3] = 2;
    Object tmp371_367 = tmp367_363;
    tmp371_367[4] = 3;
    Object tmp375_371 = tmp371_367;
    tmp375_371[5] = 4;
    Object tmp379_375 = tmp375_371;
    tmp379_375[6] = 5;
    Object tmp384_379 = tmp379_375;
    tmp384_379[7] = 6;
    Object tmp390_384 = tmp384_379;
    tmp390_384[8] = 7;
    Object tmp396_390 = tmp390_384;
    tmp396_390[9] = 8;
    Object tmp402_396 = tmp396_390;
    tmp402_396[10] = 9;
    Object tmp408_402 = tmp402_396;
    tmp408_402[11] = 10;
    Object tmp414_408 = tmp408_402;
    tmp414_408[12] = 11;
    Object tmp420_414 = tmp414_408;
    tmp420_414[13] = 12;
    Object tmp426_420 = tmp420_414;
    tmp426_420[14] = 13;
    Object tmp432_426 = tmp426_420;
    tmp432_426[15] = 27;
    Object tmp438_432 = tmp432_426;
    tmp438_432[16] = 28;
    Object tmp444_438 = tmp438_432;
    tmp444_438[17] = 29;
    Object tmp450_444 = tmp444_438;
    tmp450_444[18] = 30;
    Object tmp456_450 = tmp450_444;
    tmp456_450[19] = 31;
    Object tmp462_456 = tmp456_450;
    tmp462_456[20] = 64;
    Object tmp468_462 = tmp462_456;
    tmp468_462[21] = 92;
    Object tmp474_468 = tmp468_462;
    tmp474_468[22] = 94;
    Object tmp480_474 = tmp474_468;
    tmp480_474[23] = 95;
    Object tmp486_480 = tmp480_474;
    tmp486_480[24] = 96;
    Object tmp492_486 = tmp486_480;
    tmp492_486[25] = 124;
    Object tmp498_492 = tmp492_486;
    tmp498_492[26] = 126;
    Object tmp504_498 = tmp498_492;
    tmp504_498[27] = 127;
    tmp504_498;
    i = 0;
    while (i < localObject.length)
    {
      CHAR_MAP[3][localObject[i]] = i;
      i += 1;
    }
    localObject = new int[31];
    Object tmp542_541 = localObject;
    tmp542_541[0] = 0;
    Object tmp546_542 = tmp542_541;
    tmp546_542[1] = 13;
    Object tmp551_546 = tmp546_542;
    tmp551_546[2] = 0;
    Object tmp555_551 = tmp551_546;
    tmp555_551[3] = 0;
    Object tmp559_555 = tmp555_551;
    tmp559_555[4] = 0;
    Object tmp563_559 = tmp559_555;
    tmp563_559[5] = 0;
    Object tmp567_563 = tmp563_559;
    tmp567_563[6] = 33;
    Object tmp573_567 = tmp567_563;
    tmp573_567[7] = 39;
    Object tmp579_573 = tmp573_567;
    tmp579_573[8] = 35;
    Object tmp585_579 = tmp579_573;
    tmp585_579[9] = 36;
    Object tmp591_585 = tmp585_579;
    tmp591_585[10] = 37;
    Object tmp597_591 = tmp591_585;
    tmp597_591[11] = 38;
    Object tmp603_597 = tmp597_591;
    tmp603_597[12] = 39;
    Object tmp609_603 = tmp603_597;
    tmp609_603[13] = 40;
    Object tmp615_609 = tmp609_603;
    tmp615_609[14] = 41;
    Object tmp621_615 = tmp615_609;
    tmp621_615[15] = 42;
    Object tmp627_621 = tmp621_615;
    tmp627_621[16] = 43;
    Object tmp633_627 = tmp627_621;
    tmp633_627[17] = 44;
    Object tmp639_633 = tmp633_627;
    tmp639_633[18] = 45;
    Object tmp645_639 = tmp639_633;
    tmp645_639[19] = 46;
    Object tmp651_645 = tmp645_639;
    tmp651_645[20] = 47;
    Object tmp657_651 = tmp651_645;
    tmp657_651[21] = 58;
    Object tmp663_657 = tmp657_651;
    tmp663_657[22] = 59;
    Object tmp669_663 = tmp663_657;
    tmp669_663[23] = 60;
    Object tmp675_669 = tmp669_663;
    tmp675_669[24] = 61;
    Object tmp681_675 = tmp675_669;
    tmp681_675[25] = 62;
    Object tmp687_681 = tmp681_675;
    tmp687_681[26] = 63;
    Object tmp693_687 = tmp687_681;
    tmp693_687[27] = 91;
    Object tmp699_693 = tmp693_687;
    tmp699_693[28] = 93;
    Object tmp705_699 = tmp699_693;
    tmp705_699[29] = 123;
    Object tmp711_705 = tmp705_699;
    tmp711_705[30] = 125;
    tmp711_705;
    i = 0;
    while (i < localObject.length)
    {
      if (localObject[i] > 0) {
        CHAR_MAP[4][localObject[i]] = i;
      }
      i += 1;
    }
    SHIFT_TABLE = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 6 });
    localObject = SHIFT_TABLE;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      Arrays.fill(localObject[i], -1);
      i += 1;
    }
    SHIFT_TABLE[0][4] = 0;
    SHIFT_TABLE[1][4] = 0;
    SHIFT_TABLE[1][0] = 28;
    SHIFT_TABLE[3][4] = 0;
    SHIFT_TABLE[2][4] = 0;
    SHIFT_TABLE[2][0] = 15;
  }
  
  public HighLevelEncoder(byte[] paramArrayOfByte)
  {
    this.text = paramArrayOfByte;
  }
  
  private static Collection<State> simplifyStates(Iterable<State> paramIterable)
  {
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      State localState1 = (State)paramIterable.next();
      int j = 1;
      Iterator localIterator = localLinkedList.iterator();
      int i;
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        State localState2 = (State)localIterator.next();
        if (localState2.isBetterThanOrEqualTo(localState1))
        {
          i = 0;
          break;
        }
        if (localState1.isBetterThanOrEqualTo(localState2)) {
          localIterator.remove();
        }
      }
      if (i != 0) {
        localLinkedList.add(localState1);
      }
    }
    return localLinkedList;
  }
  
  private void updateStateForChar(State paramState, int paramInt, Collection<State> paramCollection)
  {
    int k = (char)(this.text[paramInt] & 0xFF);
    int i = CHAR_MAP[paramState.getMode()][k];
    int j = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject3;
    for (Object localObject1 = null; j <= 4; localObject1 = localObject3)
    {
      int m = CHAR_MAP[j][k];
      localObject3 = localObject1;
      if (m > 0)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramState.endBinaryShift(paramInt);
        }
        if ((i == 0) || (j == paramState.getMode()) || (j == 2)) {
          paramCollection.add(((State)localObject2).latchAndAppend(j, m));
        }
        localObject3 = localObject2;
        if (i == 0)
        {
          localObject3 = localObject2;
          if (SHIFT_TABLE[paramState.getMode()][j] >= 0)
          {
            paramCollection.add(((State)localObject2).shiftAndAppend(j, m));
            localObject3 = localObject2;
          }
        }
      }
      j += 1;
    }
    if ((paramState.getBinaryShiftByteCount() > 0) || (CHAR_MAP[paramState.getMode()][k] == 0)) {
      paramCollection.add(paramState.addBinaryShiftChar(paramInt));
    }
  }
  
  private static void updateStateForPair(State paramState, int paramInt1, int paramInt2, Collection<State> paramCollection)
  {
    State localState = paramState.endBinaryShift(paramInt1);
    paramCollection.add(localState.latchAndAppend(4, paramInt2));
    if (paramState.getMode() != 4) {
      paramCollection.add(localState.shiftAndAppend(4, paramInt2));
    }
    if ((paramInt2 == 3) || (paramInt2 == 4)) {
      paramCollection.add(localState.latchAndAppend(2, 16 - paramInt2).latchAndAppend(2, 1));
    }
    if (paramState.getBinaryShiftByteCount() > 0) {
      paramCollection.add(paramState.addBinaryShiftChar(paramInt1).addBinaryShiftChar(paramInt1 + 1));
    }
  }
  
  private Collection<State> updateStateListForChar(Iterable<State> paramIterable, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      updateStateForChar((State)paramIterable.next(), paramInt, localLinkedList);
    }
    return simplifyStates(localLinkedList);
  }
  
  private static Collection<State> updateStateListForPair(Iterable<State> paramIterable, int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      updateStateForPair((State)paramIterable.next(), paramInt1, paramInt2, localLinkedList);
    }
    return simplifyStates(localLinkedList);
  }
  
  public BitArray encode()
  {
    Object localObject = Collections.singletonList(State.INITIAL_STATE);
    int i;
    for (int j = 0; j < this.text.length; j = i + 1)
    {
      int k = j + 1;
      if (k < this.text.length) {
        i = this.text[k];
      } else {
        i = 0;
      }
      int m = this.text[j];
      if (m != 13) {
        if (m != 44) {
          if (m != 46) {
            if (m == 58) {}
          }
        }
      }
      while (i != 10)
      {
        do
        {
          do
          {
            do
            {
              i = 0;
              break;
            } while (i != 32);
            i = 5;
            break;
          } while (i != 32);
          i = 3;
          break;
        } while (i != 32);
        i = 4;
        break;
      }
      i = 2;
      if (i > 0)
      {
        localObject = updateStateListForPair((Iterable)localObject, j, i);
        i = k;
      }
      else
      {
        localObject = updateStateListForChar((Iterable)localObject, j);
        i = j;
      }
    }
    ((State)Collections.min((Collection)localObject, new Comparator()
    {
      public int compare(State paramAnonymousState1, State paramAnonymousState2)
      {
        return paramAnonymousState1.getBitCount() - paramAnonymousState2.getBitCount();
      }
    })).toBitArray(this.text);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\encoder\HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */