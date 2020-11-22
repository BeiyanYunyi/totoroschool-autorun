package com.google.zxing.datamatrix.encoder;

final class Base256Encoder
  implements Encoder
{
  private static char randomize255State(char paramChar, int paramInt)
  {
    paramChar += paramInt * 149 % 255 + 1;
    if (paramChar <= 'ÿ') {
      return (char)paramChar;
    }
    return (char)(paramChar - 'Ā');
  }
  
  public void encode(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    localStringBuilder.append('\000');
    while (paramEncoderContext.hasMoreCharacters())
    {
      localStringBuilder.append(paramEncoderContext.getCurrentChar());
      paramEncoderContext.pos += 1;
      i = HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode());
      if (i != getEncodingMode()) {
        paramEncoderContext.signalEncoderChange(i);
      }
    }
    int k = localStringBuilder.length() - 1;
    int i = paramEncoderContext.getCodewordCount() + k + 1;
    paramEncoderContext.updateSymbolInfo(i);
    if (paramEncoderContext.getSymbolInfo().getDataCapacity() - i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramEncoderContext.hasMoreCharacters()) || (i != 0)) {
      if (k <= 249)
      {
        localStringBuilder.setCharAt(0, (char)k);
      }
      else
      {
        if ((k <= 249) || (k > 1555)) {
          break label237;
        }
        localStringBuilder.setCharAt(0, (char)(k / 250 + 249));
        localStringBuilder.insert(1, (char)(k % 250));
      }
    }
    k = localStringBuilder.length();
    i = j;
    while (i < k)
    {
      paramEncoderContext.writeCodeword(randomize255State(localStringBuilder.charAt(i), paramEncoderContext.getCodewordCount() + 1));
      i += 1;
    }
    return;
    label237:
    paramEncoderContext = new StringBuilder();
    paramEncoderContext.append("Message length not in valid ranges: ");
    paramEncoderContext.append(k);
    throw new IllegalStateException(paramEncoderContext.toString());
  }
  
  public int getEncodingMode()
  {
    return 5;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\Base256Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */