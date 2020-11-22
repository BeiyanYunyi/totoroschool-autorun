package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

public final class HighLevelEncoder
{
  static final int ASCII_ENCODATION = 0;
  static final int BASE256_ENCODATION = 5;
  static final int C40_ENCODATION = 1;
  static final char C40_UNLATCH = 'þ';
  static final int EDIFACT_ENCODATION = 4;
  static final char LATCH_TO_ANSIX12 = 'î';
  static final char LATCH_TO_BASE256 = 'ç';
  static final char LATCH_TO_C40 = 'æ';
  static final char LATCH_TO_EDIFACT = 'ð';
  static final char LATCH_TO_TEXT = 'ï';
  private static final char MACRO_05 = 'ì';
  private static final String MACRO_05_HEADER = "[)>\03605\035";
  private static final char MACRO_06 = 'í';
  private static final String MACRO_06_HEADER = "[)>\03606\035";
  private static final String MACRO_TRAILER = "\036\004";
  private static final char PAD = '';
  static final int TEXT_ENCODATION = 2;
  static final char UPPER_SHIFT = 'ë';
  static final int X12_ENCODATION = 3;
  static final char X12_UNLATCH = 'þ';
  
  public static int determineConsecutiveDigitCount(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int j = 0;
    int k = 0;
    if (paramInt < m)
    {
      char c = paramCharSequence.charAt(paramInt);
      int i = paramInt;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if (!isDigit(c)) {
          break;
        }
        j = paramInt;
        if (i >= m) {
          break;
        }
        j = paramInt + 1;
        k = i + 1;
        paramInt = j;
        i = k;
        if (k < m)
        {
          c = paramCharSequence.charAt(k);
          paramInt = j;
          i = k;
        }
      }
    }
    return j;
  }
  
  public static String encodeHighLevel(String paramString)
  {
    return encodeHighLevel(paramString, SymbolShapeHint.FORCE_NONE, null, null);
  }
  
  public static String encodeHighLevel(String paramString, SymbolShapeHint paramSymbolShapeHint, Dimension paramDimension1, Dimension paramDimension2)
  {
    ASCIIEncoder localASCIIEncoder = new ASCIIEncoder();
    int j = 0;
    C40Encoder localC40Encoder = new C40Encoder();
    TextEncoder localTextEncoder = new TextEncoder();
    X12Encoder localX12Encoder = new X12Encoder();
    EdifactEncoder localEdifactEncoder = new EdifactEncoder();
    Base256Encoder localBase256Encoder = new Base256Encoder();
    EncoderContext localEncoderContext = new EncoderContext(paramString);
    localEncoderContext.setSymbolShape(paramSymbolShapeHint);
    localEncoderContext.setSizeConstraints(paramDimension1, paramDimension2);
    int i;
    if ((paramString.startsWith("[)>\03605\035")) && (paramString.endsWith("\036\004")))
    {
      localEncoderContext.writeCodeword('ì');
      localEncoderContext.setSkipAtEnd(2);
      localEncoderContext.pos += "[)>\03605\035".length();
      i = j;
    }
    else
    {
      i = j;
      if (paramString.startsWith("[)>\03606\035"))
      {
        i = j;
        if (paramString.endsWith("\036\004"))
        {
          localEncoderContext.writeCodeword('í');
          localEncoderContext.setSkipAtEnd(2);
          localEncoderContext.pos += "[)>\03606\035".length();
          i = j;
        }
      }
    }
    while (localEncoderContext.hasMoreCharacters())
    {
      new Encoder[] { localASCIIEncoder, localC40Encoder, localTextEncoder, localX12Encoder, localEdifactEncoder, localBase256Encoder }[i].encode(localEncoderContext);
      if (localEncoderContext.getNewEncoding() >= 0)
      {
        i = localEncoderContext.getNewEncoding();
        localEncoderContext.resetEncoderSignal();
      }
    }
    j = localEncoderContext.getCodewordCount();
    localEncoderContext.updateSymbolInfo();
    int k = localEncoderContext.getSymbolInfo().getDataCapacity();
    if ((j < k) && (i != 0) && (i != 5)) {
      localEncoderContext.writeCodeword('þ');
    }
    paramString = localEncoderContext.getCodewords();
    if (paramString.length() < k) {
      paramString.append('');
    }
    while (paramString.length() < k) {
      paramString.append(randomize253State('', paramString.length() + 1));
    }
    return localEncoderContext.getCodewords().toString();
  }
  
  private static int findMinimums(float[] paramArrayOfFloat, int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    Arrays.fill(paramArrayOfByte, (byte)0);
    int i = paramInt;
    paramInt = 0;
    while (paramInt < 6)
    {
      paramArrayOfInt[paramInt] = ((int)Math.ceil(paramArrayOfFloat[paramInt]));
      int k = paramArrayOfInt[paramInt];
      int j = i;
      if (i > k)
      {
        Arrays.fill(paramArrayOfByte, (byte)0);
        j = k;
      }
      if (j == k) {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfByte[paramInt] + 1));
      }
      paramInt += 1;
      i = j;
    }
    return i;
  }
  
  private static int getMinimumCount(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 6)
    {
      j += paramArrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  static void illegalCharacter(char paramChar)
  {
    String str = Integer.toHexString(paramChar);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0000".substring(0, 4 - str.length()));
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal character: ");
    localStringBuilder.append(paramChar);
    localStringBuilder.append(" (0x");
    localStringBuilder.append(str);
    localStringBuilder.append(')');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  static boolean isExtendedASCII(char paramChar)
  {
    return (paramChar >= '') && (paramChar <= 'ÿ');
  }
  
  private static boolean isNativeC40(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean isNativeEDIFACT(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar <= '^');
  }
  
  private static boolean isNativeText(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  private static boolean isNativeX12(char paramChar)
  {
    return (isX12TermSep(paramChar)) || (paramChar == ' ') || ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean isSpecialB256(char paramChar)
  {
    return false;
  }
  
  private static boolean isX12TermSep(char paramChar)
  {
    return (paramChar == '\r') || (paramChar == '*') || (paramChar == '>');
  }
  
  static int lookAheadTest(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramCharSequence.length()) {
      return paramInt2;
    }
    float[] arrayOfFloat;
    if (paramInt2 == 0)
    {
      arrayOfFloat = new float[6];
      float[] tmp24_22 = arrayOfFloat;
      tmp24_22[0] = 0.0F;
      float[] tmp28_24 = tmp24_22;
      tmp28_24[1] = 1.0F;
      float[] tmp32_28 = tmp28_24;
      tmp32_28[2] = 1.0F;
      float[] tmp36_32 = tmp32_28;
      tmp36_32[3] = 1.0F;
      float[] tmp40_36 = tmp36_32;
      tmp40_36[4] = 1.0F;
      float[] tmp44_40 = tmp40_36;
      tmp44_40[5] = 1.25F;
      tmp44_40;
    }
    else
    {
      arrayOfFloat = new float[6];
      float[] tmp61_59 = arrayOfFloat;
      tmp61_59[0] = 1.0F;
      float[] tmp65_61 = tmp61_59;
      tmp65_61[1] = 2.0F;
      float[] tmp69_65 = tmp65_61;
      tmp69_65[2] = 2.0F;
      float[] tmp73_69 = tmp69_65;
      tmp73_69[3] = 2.0F;
      float[] tmp77_73 = tmp73_69;
      tmp77_73[4] = 2.0F;
      float[] tmp81_77 = tmp77_73;
      tmp81_77[5] = 2.25F;
      tmp81_77;
      arrayOfFloat[paramInt2] = 0.0F;
    }
    paramInt2 = 0;
    int i;
    int[] arrayOfInt;
    char c;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                i = paramInt1 + paramInt2;
                if (i == paramCharSequence.length())
                {
                  paramCharSequence = new byte[6];
                  arrayOfInt = new int[6];
                  paramInt1 = findMinimums(arrayOfFloat, arrayOfInt, Integer.MAX_VALUE, paramCharSequence);
                  paramInt2 = getMinimumCount(paramCharSequence);
                  if (arrayOfInt[0] == paramInt1) {
                    return 0;
                  }
                  if ((paramInt2 == 1) && (paramCharSequence[5] > 0)) {
                    return 5;
                  }
                  if ((paramInt2 == 1) && (paramCharSequence[4] > 0)) {
                    return 4;
                  }
                  if ((paramInt2 == 1) && (paramCharSequence[2] > 0)) {
                    return 2;
                  }
                  if ((paramInt2 == 1) && (paramCharSequence[3] > 0)) {
                    return 3;
                  }
                  return 1;
                }
                c = paramCharSequence.charAt(i);
                i = paramInt2 + 1;
                if (isDigit(c))
                {
                  double d = arrayOfFloat[0];
                  Double.isNaN(d);
                  arrayOfFloat[0] = ((float)(d + 0.5D));
                }
                else if (isExtendedASCII(c))
                {
                  arrayOfFloat[0] = ((int)Math.ceil(arrayOfFloat[0]));
                  arrayOfFloat[0] += 2.0F;
                }
                else
                {
                  arrayOfFloat[0] = ((int)Math.ceil(arrayOfFloat[0]));
                  arrayOfFloat[0] += 1.0F;
                }
                if (isNativeC40(c)) {
                  arrayOfFloat[1] += 0.6666667F;
                } else if (isExtendedASCII(c)) {
                  arrayOfFloat[1] += 2.6666667F;
                } else {
                  arrayOfFloat[1] += 1.3333334F;
                }
                if (isNativeText(c)) {
                  arrayOfFloat[2] += 0.6666667F;
                } else if (isExtendedASCII(c)) {
                  arrayOfFloat[2] += 2.6666667F;
                } else {
                  arrayOfFloat[2] += 1.3333334F;
                }
                if (isNativeX12(c)) {
                  arrayOfFloat[3] += 0.6666667F;
                } else if (isExtendedASCII(c)) {
                  arrayOfFloat[3] += 4.3333335F;
                } else {
                  arrayOfFloat[3] += 3.3333333F;
                }
                if (isNativeEDIFACT(c)) {
                  arrayOfFloat[4] += 0.75F;
                } else if (isExtendedASCII(c)) {
                  arrayOfFloat[4] += 4.25F;
                } else {
                  arrayOfFloat[4] += 3.25F;
                }
                if (isSpecialB256(c)) {
                  arrayOfFloat[5] += 4.0F;
                } else {
                  arrayOfFloat[5] += 1.0F;
                }
                paramInt2 = i;
              } while (i < 4);
              arrayOfInt = new int[6];
              byte[] arrayOfByte = new byte[6];
              findMinimums(arrayOfFloat, arrayOfInt, Integer.MAX_VALUE, arrayOfByte);
              paramInt2 = getMinimumCount(arrayOfByte);
              if ((arrayOfInt[0] < arrayOfInt[5]) && (arrayOfInt[0] < arrayOfInt[1]) && (arrayOfInt[0] < arrayOfInt[2]) && (arrayOfInt[0] < arrayOfInt[3]) && (arrayOfInt[0] < arrayOfInt[4])) {
                return 0;
              }
              if ((arrayOfInt[5] < arrayOfInt[0]) || (arrayOfByte[1] + arrayOfByte[2] + arrayOfByte[3] + arrayOfByte[4] == 0)) {
                break;
              }
              if ((paramInt2 == 1) && (arrayOfByte[4] > 0)) {
                return 4;
              }
              if ((paramInt2 == 1) && (arrayOfByte[2] > 0)) {
                return 2;
              }
              if ((paramInt2 == 1) && (arrayOfByte[3] > 0)) {
                return 3;
              }
              paramInt2 = i;
            } while (arrayOfInt[1] + 1 >= arrayOfInt[0]);
            paramInt2 = i;
          } while (arrayOfInt[1] + 1 >= arrayOfInt[5]);
          paramInt2 = i;
        } while (arrayOfInt[1] + 1 >= arrayOfInt[4]);
        paramInt2 = i;
      } while (arrayOfInt[1] + 1 >= arrayOfInt[2]);
      if (arrayOfInt[1] < arrayOfInt[3]) {
        return 1;
      }
      paramInt2 = i;
    } while (arrayOfInt[1] != arrayOfInt[3]);
    paramInt1 = paramInt1 + i + 1;
    while (paramInt1 < paramCharSequence.length())
    {
      c = paramCharSequence.charAt(paramInt1);
      if (isX12TermSep(c)) {
        return 3;
      }
      if (!isNativeX12(c)) {
        return 1;
      }
      paramInt1 += 1;
    }
    return 1;
    return 5;
  }
  
  private static char randomize253State(char paramChar, int paramInt)
  {
    paramChar += paramInt * 149 % 253 + 1;
    if (paramChar <= 'þ') {}
    for (;;)
    {
      return (char)paramChar;
      paramChar -= 'þ';
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */