package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

public abstract interface MultipleBarcodeReader
{
  public abstract Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException;
  
  public abstract Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\multi\MultipleBarcodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */