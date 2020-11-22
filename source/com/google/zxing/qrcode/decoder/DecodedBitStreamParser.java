package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class DecodedBitStreamParser
{
  private static final char[] ALPHANUMERIC_CHARS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };
  private static final int GB2312_SUBSET = 1;
  
  static DecoderResult decode(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap)
    throws FormatException
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    ArrayList localArrayList = new ArrayList(1);
    localObject1 = null;
    bool = false;
    j = -1;
    i = -1;
    for (;;)
    {
      try
      {
        if (localBitSource.available() < 4) {
          localMode = Mode.TERMINATOR;
        } else {
          localMode = Mode.forBits(localBitSource.readBits(4));
        }
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        Mode localMode;
        Object localObject2;
        int k;
        int m;
        int n;
        int i1;
        continue;
        continue;
        localObject1 = localObject2;
        j = k;
        i = m;
        continue;
        bool = true;
        continue;
      }
      localObject2 = localObject1;
      k = j;
      m = i;
      if (localMode == Mode.TERMINATOR) {
        continue;
      }
      if ((localMode == Mode.FNC1_FIRST_POSITION) || (localMode == Mode.FNC1_SECOND_POSITION)) {
        continue;
      }
      if (localMode == Mode.STRUCTURED_APPEND)
      {
        if (localBitSource.available() >= 16)
        {
          k = localBitSource.readBits(8);
          m = localBitSource.readBits(8);
          localObject2 = localObject1;
          continue;
        }
        throw FormatException.getFormatInstance();
      }
      if (localMode == Mode.ECI)
      {
        localObject2 = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(localBitSource));
        if (localObject2 != null)
        {
          k = j;
          m = i;
          continue;
        }
        throw FormatException.getFormatInstance();
      }
      if (localMode == Mode.HANZI)
      {
        n = localBitSource.readBits(4);
        i1 = localBitSource.readBits(localMode.getCharacterCountBits(paramVersion));
        localObject2 = localObject1;
        k = j;
        m = i;
        if (n != 1) {
          continue;
        }
        decodeHanziSegment(localBitSource, localStringBuilder, i1);
        localObject2 = localObject1;
        k = j;
        m = i;
        continue;
      }
      k = localBitSource.readBits(localMode.getCharacterCountBits(paramVersion));
      if (localMode == Mode.NUMERIC)
      {
        decodeNumericSegment(localBitSource, localStringBuilder, k);
        localObject2 = localObject1;
        k = j;
        m = i;
        continue;
      }
      if (localMode == Mode.ALPHANUMERIC)
      {
        decodeAlphanumericSegment(localBitSource, localStringBuilder, k, bool);
        localObject2 = localObject1;
        k = j;
        m = i;
        continue;
      }
      if (localMode == Mode.BYTE) {
        decodeByteSegment(localBitSource, localStringBuilder, k, (CharacterSetECI)localObject1, localArrayList, paramMap);
      } else if (localMode == Mode.KANJI) {
        decodeKanjiSegment(localBitSource, localStringBuilder, k);
      } else {
        throw FormatException.getFormatInstance();
      }
      localObject2 = Mode.TERMINATOR;
      if (localMode == localObject2)
      {
        paramMap = localStringBuilder.toString();
        if (localArrayList.isEmpty()) {
          paramVersion = null;
        } else {
          paramVersion = localArrayList;
        }
        if (paramErrorCorrectionLevel == null) {
          paramErrorCorrectionLevel = null;
        } else {
          paramErrorCorrectionLevel = paramErrorCorrectionLevel.toString();
        }
        return new DecoderResult(paramArrayOfByte, paramMap, paramVersion, paramErrorCorrectionLevel, j, i);
      }
    }
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeAlphanumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
    throws FormatException
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1) {
      if (paramBitSource.available() >= 11)
      {
        int j = paramBitSource.readBits(11);
        paramStringBuilder.append(toAlphaNumericChar(j / 45));
        paramStringBuilder.append(toAlphaNumericChar(j % 45));
        paramInt -= 2;
      }
      else
      {
        throw FormatException.getFormatInstance();
      }
    }
    if (paramInt == 1) {
      if (paramBitSource.available() >= 6) {
        paramStringBuilder.append(toAlphaNumericChar(paramBitSource.readBits(6)));
      } else {
        throw FormatException.getFormatInstance();
      }
    }
    if (paramBoolean)
    {
      paramInt = i;
      while (paramInt < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(paramInt) == '%')
        {
          if (paramInt < paramStringBuilder.length() - 1)
          {
            i = paramInt + 1;
            if (paramStringBuilder.charAt(i) == '%')
            {
              paramStringBuilder.deleteCharAt(i);
              break label168;
            }
          }
          paramStringBuilder.setCharAt(paramInt, '\035');
        }
        label168:
        paramInt += 1;
      }
    }
  }
  
  private static void decodeByteSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap)
    throws FormatException
  {
    byte[] arrayOfByte;
    if (paramInt * 8 <= paramBitSource.available())
    {
      arrayOfByte = new byte[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfByte[i] = ((byte)paramBitSource.readBits(8));
        i += 1;
      }
      if (paramCharacterSetECI == null) {
        paramBitSource = StringUtils.guessEncoding(arrayOfByte, paramMap);
      } else {
        paramBitSource = paramCharacterSetECI.name();
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, paramBitSource));
      paramCollection.add(arrayOfByte);
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      for (;;) {}
    }
    throw FormatException.getFormatInstance();
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeHanziSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    byte[] arrayOfByte;
    if (paramInt * 13 <= paramBitSource.available())
    {
      arrayOfByte = new byte[paramInt * 2];
      int i = 0;
      while (paramInt > 0)
      {
        int j = paramBitSource.readBits(13);
        j = j % 96 | j / 96 << 8;
        if (j < 959) {
          j += 41377;
        } else {
          j += 42657;
        }
        arrayOfByte[i] = ((byte)(j >> 8 & 0xFF));
        arrayOfByte[(i + 1)] = ((byte)(j & 0xFF));
        i += 2;
        paramInt -= 1;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      for (;;) {}
    }
    throw FormatException.getFormatInstance();
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeKanjiSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    byte[] arrayOfByte;
    if (paramInt * 13 <= paramBitSource.available())
    {
      arrayOfByte = new byte[paramInt * 2];
      int i = 0;
      while (paramInt > 0)
      {
        int j = paramBitSource.readBits(13);
        j = j % 192 | j / 192 << 8;
        if (j < 7936) {
          j += 33088;
        } else {
          j += 49472;
        }
        arrayOfByte[i] = ((byte)(j >> 8));
        arrayOfByte[(i + 1)] = ((byte)j);
        i += 2;
        paramInt -= 1;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException paramBitSource)
    {
      for (;;) {}
    }
    throw FormatException.getFormatInstance();
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeNumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
    throws FormatException
  {
    while (paramInt >= 3) {
      if (paramBitSource.available() >= 10)
      {
        int i = paramBitSource.readBits(10);
        if (i < 1000)
        {
          paramStringBuilder.append(toAlphaNumericChar(i / 100));
          paramStringBuilder.append(toAlphaNumericChar(i / 10 % 10));
          paramStringBuilder.append(toAlphaNumericChar(i % 10));
          paramInt -= 3;
        }
        else
        {
          throw FormatException.getFormatInstance();
        }
      }
      else
      {
        throw FormatException.getFormatInstance();
      }
    }
    if (paramInt == 2)
    {
      if (paramBitSource.available() >= 7)
      {
        paramInt = paramBitSource.readBits(7);
        if (paramInt < 100)
        {
          paramStringBuilder.append(toAlphaNumericChar(paramInt / 10));
          paramStringBuilder.append(toAlphaNumericChar(paramInt % 10));
          return;
        }
        throw FormatException.getFormatInstance();
      }
      throw FormatException.getFormatInstance();
    }
    if (paramInt == 1)
    {
      if (paramBitSource.available() >= 4)
      {
        paramInt = paramBitSource.readBits(4);
        if (paramInt < 10)
        {
          paramStringBuilder.append(toAlphaNumericChar(paramInt));
          return;
        }
        throw FormatException.getFormatInstance();
      }
      throw FormatException.getFormatInstance();
    }
  }
  
  private static int parseECIValue(BitSource paramBitSource)
    throws FormatException
  {
    int i = paramBitSource.readBits(8);
    if ((i & 0x80) == 0) {
      return i & 0x7F;
    }
    if ((i & 0xC0) == 128) {
      return paramBitSource.readBits(8) | (i & 0x3F) << 8;
    }
    if ((i & 0xE0) == 192) {
      return paramBitSource.readBits(16) | (i & 0x1F) << 16;
    }
    throw FormatException.getFormatInstance();
  }
  
  private static char toAlphaNumericChar(int paramInt)
    throws FormatException
  {
    if (paramInt < ALPHANUMERIC_CHARS.length) {
      return ALPHANUMERIC_CHARS[paramInt];
    }
    throw FormatException.getFormatInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */