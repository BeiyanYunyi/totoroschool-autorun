package com.google.zxing.datamatrix.encoder;

class C40Encoder
  implements Encoder
{
  private int backtrackOneCharacter(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    int i = paramStringBuilder1.length();
    paramStringBuilder1.delete(i - paramInt, i);
    paramEncoderContext.pos -= 1;
    paramInt = encodeChar(paramEncoderContext.getCurrentChar(), paramStringBuilder2);
    paramEncoderContext.resetSymbolInfo();
    return paramInt;
  }
  
  private static String encodeToCodewords(CharSequence paramCharSequence, int paramInt)
  {
    paramInt = paramCharSequence.charAt(paramInt) * 'ـ' + paramCharSequence.charAt(paramInt + 1) * '(' + paramCharSequence.charAt(paramInt + 2) + 1;
    return new String(new char[] { (char)(paramInt / 256), (char)(paramInt % 256) });
  }
  
  static void writeNextTriplet(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder)
  {
    paramEncoderContext.writeCodewords(encodeToCodewords(paramStringBuilder, 0));
    paramStringBuilder.delete(0, 3);
  }
  
  public void encode(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    while (paramEncoderContext.hasMoreCharacters())
    {
      char c = paramEncoderContext.getCurrentChar();
      paramEncoderContext.pos += 1;
      int j = encodeChar(c, localStringBuilder1);
      int i = localStringBuilder1.length() / 3;
      i = paramEncoderContext.getCodewordCount() + i * 2;
      paramEncoderContext.updateSymbolInfo(i);
      int k = paramEncoderContext.getSymbolInfo().getDataCapacity() - i;
      if (!paramEncoderContext.hasMoreCharacters())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        i = j;
        if (localStringBuilder1.length() % 3 == 2) {
          if (k >= 2)
          {
            i = j;
            if (k <= 2) {
              break label130;
            }
          }
        }
        label130:
        for (i = backtrackOneCharacter(paramEncoderContext, localStringBuilder1, localStringBuilder2, j); (localStringBuilder1.length() % 3 == 1) && (((i <= 3) && (k != 1)) || (i > 3)); i = backtrackOneCharacter(paramEncoderContext, localStringBuilder1, localStringBuilder2, i)) {}
      }
      if (localStringBuilder1.length() % 3 == 0)
      {
        i = HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode());
        if (i != getEncodingMode()) {
          paramEncoderContext.signalEncoderChange(i);
        }
      }
    }
    handleEOD(paramEncoderContext, localStringBuilder1);
  }
  
  int encodeChar(char paramChar, StringBuilder paramStringBuilder)
  {
    if (paramChar == ' ')
    {
      paramStringBuilder.append('\003');
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramStringBuilder.append((char)(paramChar - '0' + 4));
      return 1;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append((char)(paramChar - 'A' + 14));
      return 1;
    }
    if ((paramChar >= 0) && (paramChar <= '\037'))
    {
      paramStringBuilder.append('\000');
      paramStringBuilder.append(paramChar);
      return 2;
    }
    if ((paramChar >= '!') && (paramChar <= '/'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '!'));
      return 2;
    }
    if ((paramChar >= ':') && (paramChar <= '@'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - ':' + 15));
      return 2;
    }
    if ((paramChar >= '[') && (paramChar <= '_'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '[' + 22));
      return 2;
    }
    if ((paramChar >= '`') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      return encodeChar((char)(paramChar - ''), paramStringBuilder) + 2;
    }
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append("Illegal character: ");
    paramStringBuilder.append(paramChar);
    throw new IllegalArgumentException(paramStringBuilder.toString());
  }
  
  public int getEncodingMode()
  {
    return 1;
  }
  
  void handleEOD(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder)
  {
    int j = paramStringBuilder.length() / 3;
    int i = paramStringBuilder.length() % 3;
    j = paramEncoderContext.getCodewordCount() + j * 2;
    paramEncoderContext.updateSymbolInfo(j);
    j = paramEncoderContext.getSymbolInfo().getDataCapacity() - j;
    if (i == 2)
    {
      paramStringBuilder.append('\000');
      while (paramStringBuilder.length() >= 3) {
        writeNextTriplet(paramEncoderContext, paramStringBuilder);
      }
      if (paramEncoderContext.hasMoreCharacters()) {
        paramEncoderContext.writeCodeword('þ');
      }
    }
    else if ((j == 1) && (i == 1))
    {
      while (paramStringBuilder.length() >= 3) {
        writeNextTriplet(paramEncoderContext, paramStringBuilder);
      }
      if (paramEncoderContext.hasMoreCharacters()) {
        paramEncoderContext.writeCodeword('þ');
      }
      paramEncoderContext.pos -= 1;
    }
    else
    {
      if (i != 0) {
        break label187;
      }
      while (paramStringBuilder.length() >= 3) {
        writeNextTriplet(paramEncoderContext, paramStringBuilder);
      }
      if ((j > 0) || (paramEncoderContext.hasMoreCharacters())) {
        paramEncoderContext.writeCodeword('þ');
      }
    }
    paramEncoderContext.signalEncoderChange(0);
    return;
    label187:
    throw new IllegalStateException("Unexpected case. Please report!");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\C40Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */