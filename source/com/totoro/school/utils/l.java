package com.totoro.school.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;

public class l
{
  public static Bitmap a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    int i;
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return null;
      }
      try
      {
        Hashtable localHashtable = new Hashtable();
        if (!TextUtils.isEmpty(paramString2)) {
          localHashtable.put(EncodeHintType.CHARACTER_SET, paramString2);
        }
        localHashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        localHashtable.put(EncodeHintType.MARGIN, Integer.valueOf(paramInt3));
        paramString2 = new QRCodeWriter().encode(paramString1, BarcodeFormat.QR_CODE, paramInt1, paramInt2, localHashtable);
        paramString1 = new int[paramInt1 * paramInt2];
        paramInt3 = 0;
      }
      catch (WriterException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      if (i >= paramInt1) {
        break label196;
      }
      if (!paramString2.get(i, paramInt3)) {
        break label176;
      }
      paramString1[(paramInt3 * paramInt1 + i)] = paramInt4;
      break label187;
    }
    label176:
    label187:
    label196:
    label203:
    for (;;)
    {
      paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramString2.setPixels(paramString1, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      return paramString2;
      return null;
      for (;;)
      {
        if (paramInt3 >= paramInt2) {
          break label203;
        }
        i = 0;
        break;
        paramString1[(paramInt3 * paramInt1 + i)] = paramInt5;
        i += 1;
        break;
        paramInt3 += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */