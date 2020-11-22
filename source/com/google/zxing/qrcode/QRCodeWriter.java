package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter
  implements Writer
{
  private static final int QUIET_ZONE_SIZE = 4;
  
  private static BitMatrix renderResult(QRCode paramQRCode, int paramInt1, int paramInt2, int paramInt3)
  {
    paramQRCode = paramQRCode.getMatrix();
    if (paramQRCode != null)
    {
      int k = paramQRCode.getWidth();
      int m = paramQRCode.getHeight();
      paramInt3 *= 2;
      int i = k + paramInt3;
      int j = paramInt3 + m;
      paramInt3 = Math.max(paramInt1, i);
      paramInt2 = Math.max(paramInt2, j);
      int n = Math.min(paramInt3 / i, paramInt2 / j);
      j = (paramInt3 - k * n) / 2;
      paramInt1 = (paramInt2 - m * n) / 2;
      BitMatrix localBitMatrix = new BitMatrix(paramInt3, paramInt2);
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        paramInt3 = j;
        i = 0;
        while (i < k)
        {
          if (paramQRCode.get(i, paramInt2) == 1) {
            localBitMatrix.setRegion(paramInt3, paramInt1, n, n);
          }
          i += 1;
          paramInt3 += n;
        }
        paramInt2 += 1;
        paramInt1 += n;
      }
      return localBitMatrix;
    }
    throw new IllegalStateException();
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
    throws WriterException
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    if (!paramString.isEmpty())
    {
      if (paramBarcodeFormat == BarcodeFormat.QR_CODE)
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0))
        {
          paramBarcodeFormat = ErrorCorrectionLevel.L;
          int j = 4;
          int i = j;
          Object localObject = paramBarcodeFormat;
          if (paramMap != null)
          {
            localObject = (ErrorCorrectionLevel)paramMap.get(EncodeHintType.ERROR_CORRECTION);
            if (localObject != null) {
              paramBarcodeFormat = (BarcodeFormat)localObject;
            }
            Integer localInteger = (Integer)paramMap.get(EncodeHintType.MARGIN);
            i = j;
            localObject = paramBarcodeFormat;
            if (localInteger != null)
            {
              i = localInteger.intValue();
              localObject = paramBarcodeFormat;
            }
          }
          return renderResult(Encoder.encode(paramString, (ErrorCorrectionLevel)localObject, paramMap), paramInt1, paramInt2, i);
        }
        paramString = new StringBuilder();
        paramString.append("Requested dimensions are too small: ");
        paramString.append(paramInt1);
        paramString.append('x');
        paramString.append(paramInt2);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("Can only encode QR_CODE, but got ");
      paramString.append(paramBarcodeFormat);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\QRCodeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */