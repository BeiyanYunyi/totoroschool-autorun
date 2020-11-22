package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

public final class ProductResultParser
  extends ResultParser
{
  public ProductParsedResult parse(Result paramResult)
  {
    BarcodeFormat localBarcodeFormat = paramResult.getBarcodeFormat();
    if ((localBarcodeFormat != BarcodeFormat.UPC_A) && (localBarcodeFormat != BarcodeFormat.UPC_E) && (localBarcodeFormat != BarcodeFormat.EAN_8) && (localBarcodeFormat != BarcodeFormat.EAN_13)) {
      return null;
    }
    String str = getMassagedText(paramResult);
    if (!isStringOfDigits(str, str.length())) {
      return null;
    }
    if ((localBarcodeFormat == BarcodeFormat.UPC_E) && (str.length() == 8)) {
      paramResult = UPCEReader.convertUPCEtoUPCA(str);
    } else {
      paramResult = str;
    }
    return new ProductParsedResult(str, paramResult);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\ProductResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */