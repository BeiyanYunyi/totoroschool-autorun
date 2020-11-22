package com.google.zxing.oned;

public final class CodaBarWriter
  extends OneDimensionalCodeWriter
{
  private static final char[] ALT_START_END_CHARS = { 84, 78, 42, 69 };
  private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = { 47, 58, 43, 46 };
  private static final char DEFAULT_GUARD = START_END_CHARS[0];
  private static final char[] START_END_CHARS = { 65, 66, 67, 68 };
  
  public boolean[] encode(String paramString)
  {
    boolean bool1;
    if (paramString.length() < 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(DEFAULT_GUARD);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(DEFAULT_GUARD);
      paramString = ((StringBuilder)localObject).toString();
    }
    else
    {
      char c1 = Character.toUpperCase(paramString.charAt(0));
      char c2 = Character.toUpperCase(paramString.charAt(paramString.length() - 1));
      bool1 = CodaBarReader.arrayContains(START_END_CHARS, c1);
      boolean bool2 = CodaBarReader.arrayContains(START_END_CHARS, c2);
      boolean bool3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, c1);
      boolean bool4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, c2);
      if (bool1)
      {
        if (!bool2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid start/end guards: ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else if (bool3)
      {
        if (!bool4)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid start/end guards: ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if ((bool2) || (bool4)) {
          break label689;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(DEFAULT_GUARD);
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(DEFAULT_GUARD);
        paramString = ((StringBuilder)localObject).toString();
      }
    }
    int j = 1;
    int i = 20;
    while (j < paramString.length() - 1)
    {
      if ((!Character.isDigit(paramString.charAt(j))) && (paramString.charAt(j) != '-') && (paramString.charAt(j) != '$'))
      {
        if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, paramString.charAt(j)))
        {
          i += 10;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Cannot encode : '");
          ((StringBuilder)localObject).append(paramString.charAt(j));
          ((StringBuilder)localObject).append('\'');
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        i += 9;
      }
      j += 1;
    }
    Object localObject = new boolean[i + (paramString.length() - 1)];
    int k = 0;
    j = 0;
    while (k < paramString.length())
    {
      int m = Character.toUpperCase(paramString.charAt(k));
      if (k != 0)
      {
        i = m;
        if (k != paramString.length() - 1) {}
      }
      else if (m != 42)
      {
        if (m != 69)
        {
          if (m != 78)
          {
            if (m != 84) {
              i = m;
            } else {
              i = 65;
            }
          }
          else {
            i = 66;
          }
        }
        else {
          i = 68;
        }
      }
      else
      {
        i = 67;
      }
      m = 0;
      while (m < CodaBarReader.ALPHABET.length)
      {
        if (i == CodaBarReader.ALPHABET[m])
        {
          m = CodaBarReader.CHARACTER_ENCODINGS[m];
          break label571;
        }
        m += 1;
      }
      m = 0;
      label571:
      i = j;
      j = 0;
      bool1 = true;
      for (;;)
      {
        int n = 0;
        for (;;)
        {
          if (j >= 7) {
            break label650;
          }
          localObject[i] = bool1;
          i += 1;
          if (((m >> 6 - j & 0x1) == 0) || (n == 1)) {
            break;
          }
          n += 1;
        }
        bool1 ^= true;
        j += 1;
      }
      label650:
      j = i;
      if (k < paramString.length() - 1)
      {
        localObject[i] = 0;
        j = i + 1;
      }
      k += 1;
    }
    return (boolean[])localObject;
    label689:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid start/end guards: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\CodaBarWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */