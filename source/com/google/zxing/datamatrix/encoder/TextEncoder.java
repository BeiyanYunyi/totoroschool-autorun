package com.google.zxing.datamatrix.encoder;

final class TextEncoder
  extends C40Encoder
{
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
    if ((paramChar >= 'a') && (paramChar <= 'z'))
    {
      paramStringBuilder.append((char)(paramChar - 'a' + 14));
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
    if (paramChar == '`')
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      return 2;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 'A' + 1));
      return 2;
    }
    if ((paramChar >= '{') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '{' + 27));
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      return encodeChar((char)(paramChar - ''), paramStringBuilder) + 2;
    }
    HighLevelEncoder.illegalCharacter(paramChar);
    return -1;
  }
  
  public int getEncodingMode()
  {
    return 2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\TextEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */