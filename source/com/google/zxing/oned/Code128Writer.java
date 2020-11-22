package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Code128Writer
  extends OneDimensionalCodeWriter
{
  private static final int CODE_CODE_B = 100;
  private static final int CODE_CODE_C = 99;
  private static final int CODE_FNC_1 = 102;
  private static final int CODE_FNC_2 = 97;
  private static final int CODE_FNC_3 = 96;
  private static final int CODE_FNC_4_B = 100;
  private static final int CODE_START_B = 104;
  private static final int CODE_START_C = 105;
  private static final int CODE_STOP = 106;
  private static final char ESCAPE_FNC_1 = 'ñ';
  private static final char ESCAPE_FNC_2 = 'ò';
  private static final char ESCAPE_FNC_3 = 'ó';
  private static final char ESCAPE_FNC_4 = 'ô';
  
  private static boolean isDigits(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt2 += paramInt1;
    int j = paramCharSequence.length();
    boolean bool;
    for (;;)
    {
      bool = false;
      if ((paramInt1 >= paramInt2) || (paramInt1 >= j)) {
        break;
      }
      int k = paramCharSequence.charAt(paramInt1);
      int i;
      if (k >= 48)
      {
        i = paramInt2;
        if (k <= 57) {}
      }
      else
      {
        if (k != 241) {
          return false;
        }
        i = paramInt2 + 1;
      }
      paramInt1 += 1;
      paramInt2 = i;
    }
    if (paramInt2 <= j) {
      bool = true;
    }
    return bool;
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (paramBarcodeFormat == BarcodeFormat.CODE_128) {
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
    }
    paramString = new StringBuilder();
    paramString.append("Can only encode CODE_128, but got ");
    paramString.append(paramBarcodeFormat);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public boolean[] encode(String paramString)
  {
    int i4 = paramString.length();
    if ((i4 >= 1) && (i4 <= 80))
    {
      int i3 = 0;
      int i = 0;
      while (i < i4)
      {
        char c = paramString.charAt(i);
        if ((c < ' ') || (c > '~')) {
          switch (c)
          {
          default: 
            paramString = new StringBuilder();
            paramString.append("Bad character in input: ");
            paramString.append(c);
            throw new IllegalArgumentException(paramString.toString());
          }
        }
        i += 1;
      }
      Object localObject = new ArrayList();
      int k = 0;
      int j = 0;
      int m = 0;
      int n = 1;
      while (k < i4)
      {
        int i1 = 99;
        if (j == 99) {
          i = 2;
        } else {
          i = 4;
        }
        boolean bool = isDigits(paramString, k, i);
        int i2 = 100;
        if (bool) {
          i = i1;
        } else {
          i = 100;
        }
        if (i == j)
        {
          i1 = k;
          i = i2;
          switch (paramString.charAt(k))
          {
          default: 
            if (j == 100)
            {
              i = paramString.charAt(k) - ' ';
              i1 = k;
            }
            break;
          case 'ó': 
            i = 96;
            i1 = k;
            break;
          case 'ò': 
            i = 97;
            i1 = k;
            break;
          case 'ñ': 
            i = 102;
            i1 = k;
            break label318;
            i = Integer.parseInt(paramString.substring(k, k + 2));
            i1 = k + 1;
          }
          label318:
          i1 += 1;
          i2 = j;
        }
        else
        {
          if (j == 0)
          {
            if (i == 100) {
              j = 104;
            } else {
              j = 105;
            }
          }
          else {
            j = i;
          }
          i2 = i;
          i = j;
          i1 = k;
        }
        ((Collection)localObject).add(Code128Reader.CODE_PATTERNS[i]);
        i = m + i * n;
        k = i1;
        j = i2;
        m = i;
        if (i1 != 0)
        {
          n += 1;
          k = i1;
          j = i2;
          m = i;
        }
      }
      ((Collection)localObject).add(Code128Reader.CODE_PATTERNS[(m % 103)]);
      ((Collection)localObject).add(Code128Reader.CODE_PATTERNS[106]);
      paramString = ((Collection)localObject).iterator();
      i = 0;
      while (paramString.hasNext())
      {
        int[] arrayOfInt = (int[])paramString.next();
        k = arrayOfInt.length;
        j = 0;
        while (j < k)
        {
          i += arrayOfInt[j];
          j += 1;
        }
      }
      paramString = new boolean[i];
      localObject = ((Collection)localObject).iterator();
      i = i3;
      while (((Iterator)localObject).hasNext()) {
        i += appendPattern(paramString, i, (int[])((Iterator)localObject).next(), true);
      }
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Contents length should be between 1 and 80 characters, but got ");
    paramString.append(i4);
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\Code128Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */