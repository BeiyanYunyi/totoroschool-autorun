package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader
  implements Reader
{
  private Map<DecodeHintType, ?> hints;
  private Reader[] readers;
  
  private Result decodeInternal(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException
  {
    if (this.readers != null)
    {
      Reader[] arrayOfReader = this.readers;
      int j = arrayOfReader.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfReader[i];
        try
        {
          localObject = ((Reader)localObject).decode(paramBinaryBitmap, this.hints);
          return (Result)localObject;
        }
        catch (ReaderException localReaderException)
        {
          for (;;) {}
        }
        i += 1;
      }
    }
    else
    {
      throw NotFoundException.getNotFoundInstance();
    }
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException
  {
    setHints(null);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    setHints(paramMap);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decodeWithState(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException
  {
    if (this.readers == null) {
      setHints(null);
    }
    return decodeInternal(paramBinaryBitmap);
  }
  
  public void reset()
  {
    if (this.readers != null)
    {
      Reader[] arrayOfReader = this.readers;
      int j = arrayOfReader.length;
      int i = 0;
      while (i < j)
      {
        arrayOfReader[i].reset();
        i += 1;
      }
    }
  }
  
  public void setHints(Map<DecodeHintType, ?> paramMap)
  {
    this.hints = paramMap;
    int k = 1;
    int i;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER))) {
      i = 1;
    } else {
      i = 0;
    }
    Collection localCollection;
    if (paramMap == null) {
      localCollection = null;
    } else {
      localCollection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    }
    ArrayList localArrayList = new ArrayList();
    if (localCollection != null)
    {
      int j = k;
      if (!localCollection.contains(BarcodeFormat.UPC_A))
      {
        j = k;
        if (!localCollection.contains(BarcodeFormat.UPC_E))
        {
          j = k;
          if (!localCollection.contains(BarcodeFormat.EAN_13))
          {
            j = k;
            if (!localCollection.contains(BarcodeFormat.EAN_8))
            {
              j = k;
              if (!localCollection.contains(BarcodeFormat.CODABAR))
              {
                j = k;
                if (!localCollection.contains(BarcodeFormat.CODE_39))
                {
                  j = k;
                  if (!localCollection.contains(BarcodeFormat.CODE_93))
                  {
                    j = k;
                    if (!localCollection.contains(BarcodeFormat.CODE_128))
                    {
                      j = k;
                      if (!localCollection.contains(BarcodeFormat.ITF))
                      {
                        j = k;
                        if (!localCollection.contains(BarcodeFormat.RSS_14)) {
                          if (localCollection.contains(BarcodeFormat.RSS_EXPANDED)) {
                            j = k;
                          } else {
                            j = 0;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((j != 0) && (i == 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      if (localCollection.contains(BarcodeFormat.QR_CODE)) {
        localArrayList.add(new QRCodeReader());
      }
      if (localCollection.contains(BarcodeFormat.DATA_MATRIX)) {
        localArrayList.add(new DataMatrixReader());
      }
      if (localCollection.contains(BarcodeFormat.AZTEC)) {
        localArrayList.add(new AztecReader());
      }
      if (localCollection.contains(BarcodeFormat.PDF_417)) {
        localArrayList.add(new PDF417Reader());
      }
      if (localCollection.contains(BarcodeFormat.MAXICODE)) {
        localArrayList.add(new MaxiCodeReader());
      }
      if ((j != 0) && (i != 0)) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
    }
    if (localArrayList.isEmpty())
    {
      if (i == 0) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
      localArrayList.add(new QRCodeReader());
      localArrayList.add(new DataMatrixReader());
      localArrayList.add(new AztecReader());
      localArrayList.add(new PDF417Reader());
      localArrayList.add(new MaxiCodeReader());
      if (i != 0) {
        localArrayList.add(new MultiFormatOneDReader(paramMap));
      }
    }
    this.readers = ((Reader[])localArrayList.toArray(new Reader[localArrayList.size()]));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\MultiFormatReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */