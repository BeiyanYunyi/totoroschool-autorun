package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code39Writer
  extends OneDimensionalCodeWriter
{
  private static void toIntArray(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 9)
    {
      int j = 1;
      if ((1 << 8 - i & paramInt) != 0) {
        j = 2;
      }
      paramArrayOfInt[i] = j;
      i += 1;
    }
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramBarcodeFormat == BarcodeFormat.CODE_39) {
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
    }
    paramString = new StringBuilder();
    paramString.append("Can only encode CODE_39, but got ");
    paramString.append(paramBarcodeFormat);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public boolean[] encode(String paramString)
  {
    int m = paramString.length();
    if (m <= 80)
    {
      Object localObject = new int[9];
      int i = m + 25;
      int j = 0;
      int k;
      while (j < m)
      {
        k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(j));
        if (k >= 0)
        {
          toIntArray(Code39Reader.CHARACTER_ENCODINGS[k], (int[])localObject);
          int n = localObject.length;
          k = 0;
          while (k < n)
          {
            i += localObject[k];
            k += 1;
          }
          j += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad contents: ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      boolean[] arrayOfBoolean = new boolean[i];
      toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], (int[])localObject);
      i = appendPattern(arrayOfBoolean, 0, (int[])localObject, true);
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 1;
      j = i + appendPattern(arrayOfBoolean, i, arrayOfInt, false);
      i = 0;
      while (i < m)
      {
        k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i));
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[k], (int[])localObject);
        j += appendPattern(arrayOfBoolean, j, (int[])localObject, true);
        j += appendPattern(arrayOfBoolean, j, arrayOfInt, false);
        i += 1;
      }
      toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], (int[])localObject);
      appendPattern(arrayOfBoolean, j, (int[])localObject, true);
      return arrayOfBoolean;
    }
    paramString = new StringBuilder();
    paramString.append("Requested contents should be less than 80 digits long, but got ");
    paramString.append(m);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\Code39Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */