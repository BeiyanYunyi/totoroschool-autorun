package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

public final class QRCodeDecoderMetaData
{
  private final boolean mirrored;
  
  QRCodeDecoderMetaData(boolean paramBoolean)
  {
    this.mirrored = paramBoolean;
  }
  
  public void applyMirroredCorrection(ResultPoint[] paramArrayOfResultPoint)
  {
    if ((this.mirrored) && (paramArrayOfResultPoint != null))
    {
      if (paramArrayOfResultPoint.length < 3) {
        return;
      }
      ResultPoint localResultPoint = paramArrayOfResultPoint[0];
      paramArrayOfResultPoint[0] = paramArrayOfResultPoint[2];
      paramArrayOfResultPoint[2] = localResultPoint;
      return;
    }
  }
  
  public boolean isMirrored()
  {
    return this.mirrored;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\QRCodeDecoderMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */