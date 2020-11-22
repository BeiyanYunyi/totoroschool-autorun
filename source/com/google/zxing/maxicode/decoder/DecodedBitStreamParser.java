package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
import java.text.NumberFormat;

final class DecodedBitStreamParser
{
  private static final char ECI = '￺';
  private static final char FS = '\034';
  private static final char GS = '\035';
  private static final char LATCHA = '￷';
  private static final char LATCHB = '￸';
  private static final char LOCK = '￹';
  private static final NumberFormat NINE_DIGITS = new DecimalFormat("000000000");
  private static final char NS = '￻';
  private static final char PAD = '￼';
  private static final char RS = '\036';
  private static final String[] SETS = { "\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\034\035\036￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\034\035\036￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\034\035\036ÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\034\035\036￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032￺￼￼\033￻\034\035\036\037 ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?" };
  private static final char SHIFTA = '￰';
  private static final char SHIFTB = '￱';
  private static final char SHIFTC = '￲';
  private static final char SHIFTD = '￳';
  private static final char SHIFTE = '￴';
  private static final char THREESHIFTA = '￶';
  private static final NumberFormat THREE_DIGITS = new DecimalFormat("000");
  private static final char TWOSHIFTA = '￵';
  
  static DecoderResult decode(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(144);
    switch (paramInt)
    {
    default: 
      break;
    case 5: 
      localStringBuilder1.append(getMessage(paramArrayOfByte, 1, 77));
      break;
    case 4: 
      localStringBuilder1.append(getMessage(paramArrayOfByte, 1, 93));
      break;
    case 2: 
    case 3: 
      String str1;
      if (paramInt == 2)
      {
        int i = getPostCode2(paramArrayOfByte);
        str1 = new DecimalFormat("0000000000".substring(0, getPostCode2Length(paramArrayOfByte))).format(i);
      }
      else
      {
        str1 = getPostCode3(paramArrayOfByte);
      }
      String str2 = THREE_DIGITS.format(getCountry(paramArrayOfByte));
      String str3 = THREE_DIGITS.format(getServiceClass(paramArrayOfByte));
      localStringBuilder1.append(getMessage(paramArrayOfByte, 10, 84));
      StringBuilder localStringBuilder2;
      if (localStringBuilder1.toString().startsWith("[)>\03601\035"))
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str1);
        localStringBuilder2.append('\035');
        localStringBuilder2.append(str2);
        localStringBuilder2.append('\035');
        localStringBuilder2.append(str3);
        localStringBuilder2.append('\035');
        localStringBuilder1.insert(9, localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str1);
        localStringBuilder2.append('\035');
        localStringBuilder2.append(str2);
        localStringBuilder2.append('\035');
        localStringBuilder2.append(str3);
        localStringBuilder2.append('\035');
        localStringBuilder1.insert(0, localStringBuilder2.toString());
      }
      break;
    }
    return new DecoderResult(paramArrayOfByte, localStringBuilder1.toString(), null, String.valueOf(paramInt));
  }
  
  private static int getBit(int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramInt - 1;
    int j = paramArrayOfByte[(i / 6)];
    paramInt = 1;
    if ((1 << 5 - i % 6 & j) == 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private static int getCountry(byte[] paramArrayOfByte)
  {
    return getInt(paramArrayOfByte, new byte[] { 53, 54, 43, 44, 45, 46, 47, 48, 37, 38 });
  }
  
  private static int getInt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2.length != 0)
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayOfByte2.length)
      {
        j += (getBit(paramArrayOfByte2[i], paramArrayOfByte1) << paramArrayOfByte2.length - i - 1);
        i += 1;
      }
      return j;
    }
    throw new IllegalArgumentException();
  }
  
  private static String getMessage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramInt1;
    int j = 0;
    int m = -1;
    int k;
    for (int i1 = 0; n < paramInt1 + paramInt2; i1 = k)
    {
      int i = SETS[j].charAt(paramArrayOfByte[n]);
      k = j;
      switch (i)
      {
      case 65530: 
      default: 
        localStringBuilder.append(i);
        k = i1;
        break;
      case 65531: 
        n += 1;
        k = paramArrayOfByte[n];
        n += 1;
        int i2 = paramArrayOfByte[n];
        n += 1;
        int i3 = paramArrayOfByte[n];
        n += 1;
        int i4 = paramArrayOfByte[n];
        n += 1;
        int i5 = paramArrayOfByte[n];
        localStringBuilder.append(NINE_DIGITS.format((k << 24) + (i2 << 18) + (i3 << 12) + (i4 << 6) + i5));
        k = i1;
        break;
      case 65528: 
        k = 1;
        break;
      case 65527: 
        k = 0;
      case 65529: 
        m = -1;
        j = k;
        k = i1;
        break;
      case 65526: 
        m = 3;
        break;
      case 65525: 
        m = 2;
        k = j;
        j = 0;
        break;
      }
      i1 = i - 65520;
      m = 1;
      k = j;
      j = i1;
      if (m == 0) {
        j = k;
      }
      n += 1;
      m -= 1;
    }
    while ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == 65532)) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  private static int getPostCode2(byte[] paramArrayOfByte)
  {
    return getInt(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2 });
  }
  
  private static int getPostCode2Length(byte[] paramArrayOfByte)
  {
    return getInt(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 });
  }
  
  private static String getPostCode3(byte[] paramArrayOfByte)
  {
    return String.valueOf(new char[] { SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 })), SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26 })), SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 27, 28, 29, 30, 19, 20 })), SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 21, 22, 23, 24, 13, 14 })), SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 15, 16, 17, 18, 7, 8 })), SETS[0].charAt(getInt(paramArrayOfByte, new byte[] { 9, 10, 11, 12, 1, 2 })) });
  }
  
  private static int getServiceClass(byte[] paramArrayOfByte)
  {
    return getInt(paramArrayOfByte, new byte[] { 55, 56, 57, 58, 59, 60, 49, 50, 51, 52 });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\maxicode\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */