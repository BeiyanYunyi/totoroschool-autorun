package com.google.zxing.datamatrix.encoder;

public final class ErrorCorrection
{
  private static final int[] ALOG;
  private static final int[][] FACTORS;
  private static final int[] FACTOR_SETS = { 5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68 };
  private static final int[] LOG;
  private static final int MODULO_VALUE = 301;
  
  static
  {
    int j = 0;
    int i = 1;
    int[] arrayOfInt1 = { 15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172 };
    int[] arrayOfInt2 = { 211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255 };
    int[] arrayOfInt3 = { 220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186 };
    FACTORS = new int[][] { { 228, 48, 15, 111, 62 }, { 23, 68, 144, 134, 240, 92, 254 }, { 28, 24, 185, 166, 223, 248, 116, 255, 110, 61 }, { 175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120 }, { 41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242 }, { 156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185 }, { 83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188 }, arrayOfInt1, { 52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193 }, arrayOfInt2, { 245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112 }, { 77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5 }, { 245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19 }, { 175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46 }, { 242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204 }, arrayOfInt3 };
    LOG = new int['Ā'];
    ALOG = new int['ÿ'];
    while (j < 255)
    {
      ALOG[j] = i;
      LOG[i] = j;
      int k = i * 2;
      i = k;
      if (k >= 256) {
        i = k ^ 0x12D;
      }
      j += 1;
    }
  }
  
  private static String createECCBlock(CharSequence paramCharSequence, int paramInt)
  {
    return createECCBlock(paramCharSequence, 0, paramCharSequence.length(), paramInt);
  }
  
  private static String createECCBlock(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int i = 0;
    while (i < FACTOR_SETS.length)
    {
      if (FACTOR_SETS[i] == paramInt3) {
        break label40;
      }
      i += 1;
    }
    i = -1;
    label40:
    if (i >= 0)
    {
      int[] arrayOfInt = FACTORS[i];
      char[] arrayOfChar = new char[paramInt3];
      i = 0;
      while (i < paramInt3)
      {
        arrayOfChar[i] = '\000';
        i += 1;
      }
      i = paramInt1;
      while (i < paramInt1 + paramInt2)
      {
        int j = paramInt3 - 1;
        int m = arrayOfChar[j] ^ paramCharSequence.charAt(i);
        while (j > 0)
        {
          if ((m != 0) && (arrayOfInt[j] != 0)) {
            arrayOfChar[j] = ((char)(arrayOfChar[(j - 1)] ^ ALOG[((LOG[m] + LOG[arrayOfInt[j]]) % 255)]));
          } else {
            arrayOfChar[j] = arrayOfChar[(j - 1)];
          }
          j -= 1;
        }
        if ((m != 0) && (arrayOfInt[0] != 0)) {
          arrayOfChar[0] = ((char)ALOG[((LOG[m] + LOG[arrayOfInt[0]]) % 255)]);
        } else {
          arrayOfChar[0] = '\000';
        }
        i += 1;
      }
      paramCharSequence = new char[paramInt3];
      paramInt1 = k;
      while (paramInt1 < paramInt3)
      {
        paramCharSequence[paramInt1] = arrayOfChar[(paramInt3 - paramInt1 - 1)];
        paramInt1 += 1;
      }
      return String.valueOf(paramCharSequence);
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Illegal number of error correction codewords specified: ");
    paramCharSequence.append(paramInt3);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  public static String encodeECC200(String paramString, SymbolInfo paramSymbolInfo)
  {
    if (paramString.length() == paramSymbolInfo.getDataCapacity())
    {
      StringBuilder localStringBuilder = new StringBuilder(paramSymbolInfo.getDataCapacity() + paramSymbolInfo.getErrorCodewords());
      localStringBuilder.append(paramString);
      int m = paramSymbolInfo.getInterleavedBlockCount();
      if (m == 1)
      {
        localStringBuilder.append(createECCBlock(paramString, paramSymbolInfo.getErrorCodewords()));
      }
      else
      {
        localStringBuilder.setLength(localStringBuilder.capacity());
        int[] arrayOfInt1 = new int[m];
        int[] arrayOfInt2 = new int[m];
        Object localObject = new int[m];
        int j;
        for (int i = 0; i < m; i = j)
        {
          j = i + 1;
          arrayOfInt1[i] = paramSymbolInfo.getDataLengthForInterleavedBlock(j);
          arrayOfInt2[i] = paramSymbolInfo.getErrorLengthForInterleavedBlock(j);
          localObject[i] = 0;
          if (i > 0) {
            localObject[i] = (localObject[(i - 1)] + arrayOfInt1[i]);
          }
        }
        i = 0;
        while (i < m)
        {
          localObject = new StringBuilder(arrayOfInt1[i]);
          j = i;
          while (j < paramSymbolInfo.getDataCapacity())
          {
            ((StringBuilder)localObject).append(paramString.charAt(j));
            j += m;
          }
          localObject = createECCBlock(((StringBuilder)localObject).toString(), arrayOfInt2[i]);
          int k = i;
          j = 0;
          while (k < arrayOfInt2[i] * m)
          {
            localStringBuilder.setCharAt(paramSymbolInfo.getDataCapacity() + k, ((String)localObject).charAt(j));
            k += m;
            j += 1;
          }
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */