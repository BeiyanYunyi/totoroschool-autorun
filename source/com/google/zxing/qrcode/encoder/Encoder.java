package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Encoder
{
  private static final int[] ALPHANUMERIC_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";
  
  static void append8BitBytes(String paramString1, BitArray paramBitArray, String paramString2)
    throws WriterException
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramBitArray.appendBits(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new WriterException(paramString1);
    }
  }
  
  static void appendAlphanumericBytes(CharSequence paramCharSequence, BitArray paramBitArray)
    throws WriterException
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = getAlphanumericCode(paramCharSequence.charAt(i));
      if (m != -1)
      {
        int j = i + 1;
        if (j < k)
        {
          j = getAlphanumericCode(paramCharSequence.charAt(j));
          if (j != -1)
          {
            paramBitArray.appendBits(m * 45 + j, 11);
            i += 2;
          }
          else
          {
            throw new WriterException();
          }
        }
        else
        {
          paramBitArray.appendBits(m, 6);
          i = j;
        }
      }
      else
      {
        throw new WriterException();
      }
    }
  }
  
  static void appendBytes(String paramString1, Mode paramMode, BitArray paramBitArray, String paramString2)
    throws WriterException
  {
    switch (paramMode)
    {
    default: 
      paramString1 = new StringBuilder();
      paramString1.append("Invalid mode: ");
      paramString1.append(paramMode);
      throw new WriterException(paramString1.toString());
    case ???: 
      appendKanjiBytes(paramString1, paramBitArray);
      return;
    case ???: 
      append8BitBytes(paramString1, paramBitArray, paramString2);
      return;
    case ???: 
      appendAlphanumericBytes(paramString1, paramBitArray);
      return;
    }
    appendNumericBytes(paramString1, paramBitArray);
  }
  
  private static void appendECI(CharacterSetECI paramCharacterSetECI, BitArray paramBitArray)
  {
    paramBitArray.appendBits(Mode.ECI.getBits(), 4);
    paramBitArray.appendBits(paramCharacterSetECI.getValue(), 8);
  }
  
  static void appendKanjiBytes(String paramString, BitArray paramBitArray)
    throws WriterException
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int k = paramString.length;
      int j = 0;
      while (j < k)
      {
        int i = (paramString[j] & 0xFF) << 8 | paramString[(j + 1)] & 0xFF;
        if ((i >= 33088) && (i <= 40956)) {
          i -= 33088;
        } else if ((i >= 57408) && (i <= 60351)) {
          i -= 49472;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          paramBitArray.appendBits((i >> 8) * 192 + (i & 0xFF), 13);
          j += 2;
        }
        else
        {
          throw new WriterException("Invalid byte sequence");
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new WriterException(paramString);
    }
  }
  
  static void appendLengthInfo(int paramInt, Version paramVersion, Mode paramMode, BitArray paramBitArray)
    throws WriterException
  {
    int i = paramMode.getCharacterCountBits(paramVersion);
    int j = 1 << i;
    if (paramInt < j)
    {
      paramBitArray.appendBits(paramInt, i);
      return;
    }
    paramVersion = new StringBuilder();
    paramVersion.append(paramInt);
    paramVersion.append(" is bigger than ");
    paramVersion.append(j - 1);
    throw new WriterException(paramVersion.toString());
  }
  
  static void appendModeInfo(Mode paramMode, BitArray paramBitArray)
  {
    paramBitArray.appendBits(paramMode.getBits(), 4);
  }
  
  static void appendNumericBytes(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = paramCharSequence.charAt(i) - '0';
      int j = i + 2;
      if (j < k)
      {
        paramBitArray.appendBits(m * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(j) - '0'), 10);
        i += 3;
      }
      else
      {
        i += 1;
        if (i < k)
        {
          paramBitArray.appendBits(m * 10 + (paramCharSequence.charAt(i) - '0'), 7);
          i = j;
        }
        else
        {
          paramBitArray.appendBits(m, 4);
        }
      }
    }
  }
  
  private static int calculateMaskPenalty(ByteMatrix paramByteMatrix)
  {
    return MaskUtil.applyMaskPenaltyRule1(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule2(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule3(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule4(paramByteMatrix);
  }
  
  private static int chooseMaskPattern(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int j = Integer.MAX_VALUE;
    int k = -1;
    int i = 0;
    while (i < 8)
    {
      MatrixUtil.buildMatrix(paramBitArray, paramErrorCorrectionLevel, paramVersion, i, paramByteMatrix);
      int n = calculateMaskPenalty(paramByteMatrix);
      int m = j;
      if (n < j)
      {
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  public static Mode chooseMode(String paramString)
  {
    return chooseMode(paramString, null);
  }
  
  private static Mode chooseMode(String paramString1, String paramString2)
  {
    if ("Shift_JIS".equals(paramString2))
    {
      if (isOnlyDoubleByteKanji(paramString1)) {
        return Mode.KANJI;
      }
      return Mode.BYTE;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57))
      {
        k = 1;
      }
      else
      {
        if (getAlphanumericCode(m) == -1) {
          break label84;
        }
        j = 1;
      }
      i += 1;
      continue;
      label84:
      return Mode.BYTE;
    }
    if (j != 0) {
      return Mode.ALPHANUMERIC;
    }
    if (k != 0) {
      return Mode.NUMERIC;
    }
    return Mode.BYTE;
  }
  
  private static Version chooseVersion(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel)
    throws WriterException
  {
    int i = 1;
    while (i <= 40)
    {
      Version localVersion = Version.getVersionForNumber(i);
      if (localVersion.getTotalCodewords() - localVersion.getECBlocksForLevel(paramErrorCorrectionLevel).getTotalECCodewords() >= (paramInt + 7) / 8) {
        return localVersion;
      }
      i += 1;
    }
    throw new WriterException("Data too big");
  }
  
  public static QRCode encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel)
    throws WriterException
  {
    return encode(paramString, paramErrorCorrectionLevel, null);
  }
  
  public static QRCode encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramMap == null) {
      paramMap = null;
    } else {
      paramMap = (String)paramMap.get(EncodeHintType.CHARACTER_SET);
    }
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = "ISO-8859-1";
    }
    paramMap = chooseMode(paramString, (String)localObject1);
    Object localObject2 = new BitArray();
    if ((paramMap == Mode.BYTE) && (!"ISO-8859-1".equals(localObject1)))
    {
      localObject3 = CharacterSetECI.getCharacterSetECIByName((String)localObject1);
      if (localObject3 != null) {
        appendECI((CharacterSetECI)localObject3, (BitArray)localObject2);
      }
    }
    appendModeInfo(paramMap, (BitArray)localObject2);
    Object localObject3 = new BitArray();
    appendBytes(paramString, paramMap, (BitArray)localObject3, (String)localObject1);
    localObject1 = chooseVersion(((BitArray)localObject2).getSize() + paramMap.getCharacterCountBits(Version.getVersionForNumber(1)) + ((BitArray)localObject3).getSize(), paramErrorCorrectionLevel);
    localObject1 = chooseVersion(((BitArray)localObject2).getSize() + paramMap.getCharacterCountBits((Version)localObject1) + ((BitArray)localObject3).getSize(), paramErrorCorrectionLevel);
    BitArray localBitArray = new BitArray();
    localBitArray.appendBitArray((BitArray)localObject2);
    if (paramMap == Mode.BYTE) {
      i = ((BitArray)localObject3).getSizeInBytes();
    } else {
      i = paramString.length();
    }
    appendLengthInfo(i, (Version)localObject1, paramMap, localBitArray);
    localBitArray.appendBitArray((BitArray)localObject3);
    paramString = ((Version)localObject1).getECBlocksForLevel(paramErrorCorrectionLevel);
    int i = ((Version)localObject1).getTotalCodewords() - paramString.getTotalECCodewords();
    terminateBits(i, localBitArray);
    paramString = interleaveWithECBytes(localBitArray, ((Version)localObject1).getTotalCodewords(), i, paramString.getNumBlocks());
    localObject2 = new QRCode();
    ((QRCode)localObject2).setECLevel(paramErrorCorrectionLevel);
    ((QRCode)localObject2).setMode(paramMap);
    ((QRCode)localObject2).setVersion((Version)localObject1);
    i = ((Version)localObject1).getDimensionForVersion();
    paramMap = new ByteMatrix(i, i);
    i = chooseMaskPattern(paramString, paramErrorCorrectionLevel, (Version)localObject1, paramMap);
    ((QRCode)localObject2).setMaskPattern(i);
    MatrixUtil.buildMatrix(paramString, paramErrorCorrectionLevel, (Version)localObject1, i, paramMap);
    ((QRCode)localObject2).setMatrix(paramMap);
    return (QRCode)localObject2;
  }
  
  static byte[] generateECBytes(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static int getAlphanumericCode(int paramInt)
  {
    if (paramInt < ALPHANUMERIC_TABLE.length) {
      return ALPHANUMERIC_TABLE[paramInt];
    }
    return -1;
  }
  
  static void getNumDataBytesAndNumECBytesForBlockID(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws WriterException
  {
    if (paramInt4 < paramInt3)
    {
      int i = paramInt1 % paramInt3;
      int j = paramInt3 - i;
      int k = paramInt1 / paramInt3;
      paramInt2 /= paramInt3;
      int m = paramInt2 + 1;
      int n = k - paramInt2;
      k = k + 1 - m;
      if (n == k)
      {
        if (paramInt3 == j + i)
        {
          if (paramInt1 == (paramInt2 + n) * j + (m + k) * i)
          {
            if (paramInt4 < j)
            {
              paramArrayOfInt1[0] = paramInt2;
              paramArrayOfInt2[0] = n;
              return;
            }
            paramArrayOfInt1[0] = m;
            paramArrayOfInt2[0] = k;
            return;
          }
          throw new WriterException("Total bytes mismatch");
        }
        throw new WriterException("RS blocks mismatch");
      }
      throw new WriterException("EC bytes mismatch");
    }
    throw new WriterException("Block ID too large");
  }
  
  static BitArray interleaveWithECBytes(BitArray paramBitArray, int paramInt1, int paramInt2, int paramInt3)
    throws WriterException
  {
    if (paramBitArray.getSizeInBytes() == paramInt2)
    {
      Object localObject1 = new ArrayList(paramInt3);
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      int i = 0;
      Object localObject2;
      byte[] arrayOfByte;
      while (k < paramInt3)
      {
        localObject2 = new int[1];
        Object localObject3 = new int[1];
        getNumDataBytesAndNumECBytesForBlockID(paramInt1, paramInt2, paramInt3, k, (int[])localObject2, (int[])localObject3);
        int i1 = localObject2[0];
        arrayOfByte = new byte[i1];
        paramBitArray.toBytes(m * 8, arrayOfByte, 0, i1);
        localObject3 = generateECBytes(arrayOfByte, localObject3[0]);
        ((Collection)localObject1).add(new BlockPair(arrayOfByte, (byte[])localObject3));
        j = Math.max(j, i1);
        i = Math.max(i, localObject3.length);
        m += localObject2[0];
        k += 1;
      }
      if (paramInt2 == m)
      {
        paramBitArray = new BitArray();
        paramInt2 = 0;
        for (;;)
        {
          paramInt3 = n;
          if (paramInt2 >= j) {
            break;
          }
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((BlockPair)((Iterator)localObject2).next()).getDataBytes();
            if (paramInt2 < arrayOfByte.length) {
              paramBitArray.appendBits(arrayOfByte[paramInt2], 8);
            }
          }
          paramInt2 += 1;
        }
        while (paramInt3 < i)
        {
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((BlockPair)((Iterator)localObject2).next()).getErrorCorrectionBytes();
            if (paramInt3 < arrayOfByte.length) {
              paramBitArray.appendBits(arrayOfByte[paramInt3], 8);
            }
          }
          paramInt3 += 1;
        }
        if (paramInt1 == paramBitArray.getSizeInBytes()) {
          return paramBitArray;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Interleaving error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append(paramBitArray.getSizeInBytes());
        ((StringBuilder)localObject1).append(" differ.");
        throw new WriterException(((StringBuilder)localObject1).toString());
      }
      throw new WriterException("Data bytes does not match offset");
    }
    throw new WriterException("Number of bits and data bytes does not match");
  }
  
  private static boolean isOnlyDoubleByteKanji(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        int k = paramString[i] & 0xFF;
        if ((k < 129) || (k > 159))
        {
          if (k < 224) {
            break label70;
          }
          if (k > 235) {
            return false;
          }
        }
        i += 2;
        continue;
        label70:
        return false;
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  static void terminateBits(int paramInt, BitArray paramBitArray)
    throws WriterException
  {
    int k = paramInt * 8;
    if (paramBitArray.getSize() <= k)
    {
      int j = 0;
      int i = 0;
      while ((i < 4) && (paramBitArray.getSize() < k))
      {
        paramBitArray.appendBit(false);
        i += 1;
      }
      i = paramBitArray.getSize() & 0x7;
      if (i > 0) {
        while (i < 8)
        {
          paramBitArray.appendBit(false);
          i += 1;
        }
      }
      int m = paramBitArray.getSizeInBytes();
      i = j;
      while (i < paramInt - m)
      {
        if ((i & 0x1) == 0) {
          j = 236;
        } else {
          j = 17;
        }
        paramBitArray.appendBits(j, 8);
        i += 1;
      }
      if (paramBitArray.getSize() == k) {
        return;
      }
      throw new WriterException("Bits size does not equal capacity");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data bits cannot fit in the QR Code");
    localStringBuilder.append(paramBitArray.getSize());
    localStringBuilder.append(" > ");
    localStringBuilder.append(k);
    throw new WriterException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */