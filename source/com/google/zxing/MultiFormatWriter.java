package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter
  implements Writer
{
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
    throws WriterException
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    Object localObject;
    switch (paramBarcodeFormat)
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("No encoder available for format ");
      paramString.append(paramBarcodeFormat);
      throw new IllegalArgumentException(paramString.toString());
    case ???: 
      localObject = new AztecWriter();
      break;
    case ???: 
      localObject = new DataMatrixWriter();
      break;
    case ???: 
      localObject = new CodaBarWriter();
      break;
    case ???: 
      localObject = new PDF417Writer();
      break;
    case ???: 
      localObject = new ITFWriter();
      break;
    case ???: 
      localObject = new Code128Writer();
      break;
    case ???: 
      localObject = new Code39Writer();
      break;
    case ???: 
      localObject = new QRCodeWriter();
      break;
    case ???: 
      localObject = new UPCAWriter();
      break;
    case ???: 
      localObject = new EAN13Writer();
      break;
    case ???: 
      localObject = new EAN8Writer();
    }
    return ((Writer)localObject).encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\MultiFormatWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */