package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class GeneralAppIdDecoder
{
  private final StringBuilder buffer = new StringBuilder();
  private final CurrentParsingState current = new CurrentParsingState();
  private final BitArray information;
  
  GeneralAppIdDecoder(BitArray paramBitArray)
  {
    this.information = paramBitArray;
  }
  
  private DecodedChar decodeAlphanumeric(int paramInt)
  {
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i == 15) {
      return new DecodedChar(paramInt + 5, '$');
    }
    if ((i >= 5) && (i < 15)) {
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5));
    }
    i = extractNumericValueFromBitArray(paramInt, 6);
    if ((i >= 32) && (i < 58)) {
      return new DecodedChar(paramInt + 6, (char)(i + 33));
    }
    char c;
    switch (i)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Decoding invalid alphanumeric value: ");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString());
    case 62: 
      c = '/';
      break;
    case 61: 
      c = '.';
      break;
    case 60: 
      c = '-';
      break;
    case 59: 
      c = ',';
      break;
    case 58: 
      c = '*';
    }
    return new DecodedChar(paramInt + 6, c);
  }
  
  private DecodedChar decodeIsoIec646(int paramInt)
    throws FormatException
  {
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i == 15) {
      return new DecodedChar(paramInt + 5, '$');
    }
    if ((i >= 5) && (i < 15)) {
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5));
    }
    i = extractNumericValueFromBitArray(paramInt, 7);
    if ((i >= 64) && (i < 90)) {
      return new DecodedChar(paramInt + 7, (char)(i + 1));
    }
    if ((i >= 90) && (i < 116)) {
      return new DecodedChar(paramInt + 7, (char)(i + 7));
    }
    char c;
    switch (extractNumericValueFromBitArray(paramInt, 8))
    {
    default: 
      throw FormatException.getFormatInstance();
    case 252: 
      c = ' ';
      break;
    case 251: 
      c = '_';
      break;
    case 250: 
      c = '?';
      break;
    case 249: 
      c = '>';
      break;
    case 248: 
      c = '=';
      break;
    case 247: 
      c = '<';
      break;
    case 246: 
      c = ';';
      break;
    case 245: 
      c = ':';
      break;
    case 244: 
      c = '/';
      break;
    case 243: 
      c = '.';
      break;
    case 242: 
      c = '-';
      break;
    case 241: 
      c = ',';
      break;
    case 240: 
      c = '+';
      break;
    case 239: 
      c = '*';
      break;
    case 238: 
      c = ')';
      break;
    case 237: 
      c = '(';
      break;
    case 236: 
      c = '\'';
      break;
    case 235: 
      c = '&';
      break;
    case 234: 
      c = '%';
      break;
    case 233: 
      c = '"';
      break;
    case 232: 
      c = '!';
    }
    return new DecodedChar(paramInt + 8, c);
  }
  
  private DecodedNumeric decodeNumeric(int paramInt)
    throws FormatException
  {
    int i = paramInt + 7;
    if (i > this.information.getSize())
    {
      paramInt = extractNumericValueFromBitArray(paramInt, 4);
      if (paramInt == 0) {
        return new DecodedNumeric(this.information.getSize(), 10, 10);
      }
      return new DecodedNumeric(this.information.getSize(), paramInt - 1, 10);
    }
    paramInt = extractNumericValueFromBitArray(paramInt, 7) - 8;
    return new DecodedNumeric(i, paramInt / 11, paramInt % 11);
  }
  
  static int extractNumericValueFromBitArray(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramInt2; j = k)
    {
      k = j;
      if (paramBitArray.get(paramInt1 + i)) {
        k = j | 1 << paramInt2 - i - 1;
      }
      i += 1;
    }
    return j;
  }
  
  private boolean isAlphaOr646ToNumericLatch(int paramInt)
  {
    int i = paramInt + 3;
    if (i > this.information.getSize()) {
      return false;
    }
    while (paramInt < i)
    {
      if (this.information.get(paramInt)) {
        return false;
      }
      paramInt += 1;
    }
    return true;
  }
  
  private boolean isAlphaTo646ToAlphaLatch(int paramInt)
  {
    if (paramInt + 1 > this.information.getSize()) {
      return false;
    }
    int i = 0;
    while (i < 5)
    {
      int j = i + paramInt;
      if (j >= this.information.getSize()) {
        break;
      }
      if (i == 2)
      {
        if (!this.information.get(paramInt + 2)) {
          return false;
        }
      }
      else if (this.information.get(j)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isNumericToAlphaNumericLatch(int paramInt)
  {
    if (paramInt + 1 > this.information.getSize()) {
      return false;
    }
    int i = 0;
    while (i < 4)
    {
      int j = i + paramInt;
      if (j >= this.information.getSize()) {
        break;
      }
      if (this.information.get(j)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isStillAlpha(int paramInt)
  {
    int i = this.information.getSize();
    boolean bool2 = false;
    if (paramInt + 5 > i) {
      return false;
    }
    i = extractNumericValueFromBitArray(paramInt, 5);
    if ((i >= 5) && (i < 16)) {
      return true;
    }
    if (paramInt + 6 > this.information.getSize()) {
      return false;
    }
    paramInt = extractNumericValueFromBitArray(paramInt, 6);
    boolean bool1 = bool2;
    if (paramInt >= 16)
    {
      bool1 = bool2;
      if (paramInt < 63) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isStillIsoIec646(int paramInt)
  {
    int i = this.information.getSize();
    boolean bool2 = false;
    if (paramInt + 5 > i) {
      return false;
    }
    i = extractNumericValueFromBitArray(paramInt, 5);
    if ((i >= 5) && (i < 16)) {
      return true;
    }
    if (paramInt + 7 > this.information.getSize()) {
      return false;
    }
    i = extractNumericValueFromBitArray(paramInt, 7);
    if ((i >= 64) && (i < 116)) {
      return true;
    }
    if (paramInt + 8 > this.information.getSize()) {
      return false;
    }
    paramInt = extractNumericValueFromBitArray(paramInt, 8);
    boolean bool1 = bool2;
    if (paramInt >= 232)
    {
      bool1 = bool2;
      if (paramInt < 253) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isStillNumeric(int paramInt)
  {
    if (paramInt + 7 > this.information.getSize()) {
      return paramInt + 4 <= this.information.getSize();
    }
    int i = paramInt;
    int j;
    for (;;)
    {
      j = paramInt + 3;
      if (i >= j) {
        break;
      }
      if (this.information.get(i)) {
        return true;
      }
      i += 1;
    }
    return this.information.get(j);
  }
  
  private BlockParsedResult parseAlphaBlock()
  {
    while (isStillAlpha(this.current.getPosition()))
    {
      DecodedChar localDecodedChar = decodeAlphanumeric(this.current.getPosition());
      this.current.setPosition(localDecodedChar.getNewPosition());
      if (localDecodedChar.isFNC1()) {
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
      }
      this.buffer.append(localDecodedChar.getValue());
    }
    if (isAlphaOr646ToNumericLatch(this.current.getPosition()))
    {
      this.current.incrementPosition(3);
      this.current.setNumeric();
    }
    else if (isAlphaTo646ToAlphaLatch(this.current.getPosition()))
    {
      if (this.current.getPosition() + 5 < this.information.getSize()) {
        this.current.incrementPosition(5);
      } else {
        this.current.setPosition(this.information.getSize());
      }
      this.current.setIsoIec646();
    }
    return new BlockParsedResult(false);
  }
  
  private DecodedInformation parseBlocks()
    throws FormatException
  {
    int i;
    BlockParsedResult localBlockParsedResult;
    boolean bool;
    do
    {
      i = this.current.getPosition();
      if (this.current.isAlpha())
      {
        localBlockParsedResult = parseAlphaBlock();
        bool = localBlockParsedResult.isFinished();
      }
      else if (this.current.isIsoIec646())
      {
        localBlockParsedResult = parseIsoIec646Block();
        bool = localBlockParsedResult.isFinished();
      }
      else
      {
        localBlockParsedResult = parseNumericBlock();
        bool = localBlockParsedResult.isFinished();
      }
      if (i != this.current.getPosition()) {
        i = 1;
      } else {
        i = 0;
      }
    } while (((i != 0) || (bool)) && (!bool));
    return localBlockParsedResult.getDecodedInformation();
  }
  
  private BlockParsedResult parseIsoIec646Block()
    throws FormatException
  {
    while (isStillIsoIec646(this.current.getPosition()))
    {
      DecodedChar localDecodedChar = decodeIsoIec646(this.current.getPosition());
      this.current.setPosition(localDecodedChar.getNewPosition());
      if (localDecodedChar.isFNC1()) {
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
      }
      this.buffer.append(localDecodedChar.getValue());
    }
    if (isAlphaOr646ToNumericLatch(this.current.getPosition()))
    {
      this.current.incrementPosition(3);
      this.current.setNumeric();
    }
    else if (isAlphaTo646ToAlphaLatch(this.current.getPosition()))
    {
      if (this.current.getPosition() + 5 < this.information.getSize()) {
        this.current.incrementPosition(5);
      } else {
        this.current.setPosition(this.information.getSize());
      }
      this.current.setAlpha();
    }
    return new BlockParsedResult(false);
  }
  
  private BlockParsedResult parseNumericBlock()
    throws FormatException
  {
    while (isStillNumeric(this.current.getPosition()))
    {
      Object localObject = decodeNumeric(this.current.getPosition());
      this.current.setPosition(((DecodedNumeric)localObject).getNewPosition());
      if (((DecodedNumeric)localObject).isFirstDigitFNC1())
      {
        if (((DecodedNumeric)localObject).isSecondDigitFNC1()) {
          localObject = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        } else {
          localObject = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), ((DecodedNumeric)localObject).getSecondDigit());
        }
        return new BlockParsedResult((DecodedInformation)localObject, true);
      }
      this.buffer.append(((DecodedNumeric)localObject).getFirstDigit());
      if (((DecodedNumeric)localObject).isSecondDigitFNC1()) {
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
      }
      this.buffer.append(((DecodedNumeric)localObject).getSecondDigit());
    }
    if (isNumericToAlphaNumericLatch(this.current.getPosition()))
    {
      this.current.setAlpha();
      this.current.incrementPosition(4);
    }
    return new BlockParsedResult(false);
  }
  
  String decodeAllCodes(StringBuilder paramStringBuilder, int paramInt)
    throws NotFoundException, FormatException
  {
    String str = null;
    for (;;)
    {
      DecodedInformation localDecodedInformation = decodeGeneralPurposeField(paramInt, str);
      str = FieldParser.parseFieldsInGeneralPurpose(localDecodedInformation.getNewString());
      if (str != null) {
        paramStringBuilder.append(str);
      }
      if (localDecodedInformation.isRemaining()) {
        str = String.valueOf(localDecodedInformation.getRemainingValue());
      } else {
        str = null;
      }
      if (paramInt == localDecodedInformation.getNewPosition()) {
        return paramStringBuilder.toString();
      }
      paramInt = localDecodedInformation.getNewPosition();
    }
  }
  
  DecodedInformation decodeGeneralPurposeField(int paramInt, String paramString)
    throws FormatException
  {
    this.buffer.setLength(0);
    if (paramString != null) {
      this.buffer.append(paramString);
    }
    this.current.setPosition(paramInt);
    paramString = parseBlocks();
    if ((paramString != null) && (paramString.isRemaining())) {
      return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), paramString.getRemainingValue());
    }
    return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
  }
  
  int extractNumericValueFromBitArray(int paramInt1, int paramInt2)
  {
    return extractNumericValueFromBitArray(this.information, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\GeneralAppIdDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */