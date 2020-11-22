package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension2Support
{
  private final int[] decodeMiddleCounters = new int[4];
  private final StringBuilder decodeRowStringBuffer = new StringBuilder();
  
  private static Map<ResultMetadataType, Object> parseExtensionString(String paramString)
  {
    if (paramString.length() != 2) {
      return null;
    }
    EnumMap localEnumMap = new EnumMap(ResultMetadataType.class);
    localEnumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(paramString));
    return localEnumMap;
  }
  
  int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws NotFoundException
  {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = paramBitArray.getSize();
    int i = paramArrayOfInt[1];
    int j = 0;
    int m;
    for (int k = 0; (j < 2) && (i < n); k = m)
    {
      int i1 = UPCEANReader.decodeDigit(paramBitArray, arrayOfInt, i, UPCEANReader.L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      m = 0;
      while (m < i2)
      {
        i += arrayOfInt[m];
        m += 1;
      }
      m = k;
      if (i1 >= 10) {
        m = 1 << 1 - j | k;
      }
      if (j != 1) {
        i = paramBitArray.getNextUnset(paramBitArray.getNextSet(i));
      }
      j += 1;
    }
    if (paramStringBuilder.length() == 2)
    {
      if (Integer.parseInt(paramStringBuilder.toString()) % 4 == k) {
        return i;
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt)
    throws NotFoundException
  {
    Object localObject = this.decodeRowStringBuffer;
    ((StringBuilder)localObject).setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfInt, (StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    paramBitArray = parseExtensionString((String)localObject);
    float f1 = (paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F;
    float f2 = paramInt;
    paramArrayOfInt = new ResultPoint(f1, f2);
    ResultPoint localResultPoint = new ResultPoint(i, f2);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
    paramArrayOfInt = new Result((String)localObject, null, new ResultPoint[] { paramArrayOfInt, localResultPoint }, localBarcodeFormat);
    if (paramBitArray != null) {
      paramArrayOfInt.putAllMetadata(paramBitArray);
    }
    return paramArrayOfInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\UPCEANExtension2Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */