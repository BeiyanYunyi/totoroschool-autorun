package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder
  implements Encoder
{
  private static void encodeChar(char paramChar, StringBuilder paramStringBuilder)
  {
    if ((paramChar >= ' ') && (paramChar <= '?'))
    {
      paramStringBuilder.append(paramChar);
      return;
    }
    if ((paramChar >= '@') && (paramChar <= '^'))
    {
      paramStringBuilder.append((char)(paramChar - '@'));
      return;
    }
    HighLevelEncoder.illegalCharacter(paramChar);
  }
  
  private static String encodeToCodewords(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length() - paramInt;
    if (m != 0)
    {
      int n = paramCharSequence.charAt(paramInt);
      int k = 0;
      int i;
      if (m >= 2) {
        i = paramCharSequence.charAt(paramInt + 1);
      } else {
        i = 0;
      }
      int j;
      if (m >= 3) {
        j = paramCharSequence.charAt(paramInt + 2);
      } else {
        j = 0;
      }
      if (m >= 4) {
        k = paramCharSequence.charAt(paramInt + 3);
      }
      paramInt = (n << 18) + (i << 12) + (j << 6) + k;
      char c1 = (char)(paramInt >> 16 & 0xFF);
      char c2 = (char)(paramInt >> 8 & 0xFF);
      char c3 = (char)(paramInt & 0xFF);
      paramCharSequence = new StringBuilder(3);
      paramCharSequence.append(c1);
      if (m >= 2) {
        paramCharSequence.append(c2);
      }
      if (m >= 3) {
        paramCharSequence.append(c3);
      }
      return paramCharSequence.toString();
    }
    throw new IllegalStateException("StringBuilder must not be empty");
  }
  
  private static void handleEOD(EncoderContext paramEncoderContext, CharSequence paramCharSequence)
  {
    for (;;)
    {
      try
      {
        int j = paramCharSequence.length();
        if (j == 0) {
          return;
        }
        i = 1;
        int k;
        if (j == 1)
        {
          paramEncoderContext.updateSymbolInfo();
          k = paramEncoderContext.getSymbolInfo().getDataCapacity();
          int m = paramEncoderContext.getCodewordCount();
          int n = paramEncoderContext.getRemainingCharacters();
          if ((n == 0) && (k - m <= 2)) {
            return;
          }
        }
        if (j <= 4)
        {
          k = j - 1;
          paramCharSequence = encodeToCodewords(paramCharSequence, 0);
          if (((paramEncoderContext.hasMoreCharacters() ^ true)) && (k <= 2))
          {
            j = i;
            if (k <= 2)
            {
              paramEncoderContext.updateSymbolInfo(paramEncoderContext.getCodewordCount() + k);
              j = i;
              if (paramEncoderContext.getSymbolInfo().getDataCapacity() - paramEncoderContext.getCodewordCount() >= 3)
              {
                paramEncoderContext.updateSymbolInfo(paramEncoderContext.getCodewordCount() + paramCharSequence.length());
                j = 0;
              }
            }
            if (j != 0)
            {
              paramEncoderContext.resetSymbolInfo();
              paramEncoderContext.pos -= k;
            }
            else
            {
              paramEncoderContext.writeCodewords(paramCharSequence);
            }
          }
        }
        else
        {
          throw new IllegalStateException("Count must not exceed 4");
        }
      }
      finally
      {
        paramEncoderContext.signalEncoderChange(0);
      }
      int i = 0;
    }
  }
  
  public void encode(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramEncoderContext.hasMoreCharacters())
    {
      encodeChar(paramEncoderContext.getCurrentChar(), localStringBuilder);
      paramEncoderContext.pos += 1;
      if (localStringBuilder.length() >= 4)
      {
        paramEncoderContext.writeCodewords(encodeToCodewords(localStringBuilder, 0));
        localStringBuilder.delete(0, 4);
        if (HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode()) != getEncodingMode()) {
          paramEncoderContext.signalEncoderChange(0);
        }
      }
    }
    localStringBuilder.append('\037');
    handleEOD(paramEncoderContext, localStringBuilder);
  }
  
  public int getEncodingMode()
  {
    return 4;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\EdifactEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */