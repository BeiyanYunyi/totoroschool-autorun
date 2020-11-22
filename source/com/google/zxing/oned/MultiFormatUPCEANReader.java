package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader
  extends OneDReader
{
  private final UPCEANReader[] readers;
  
  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap == null) {
      paramMap = null;
    } else {
      paramMap = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramMap != null)
    {
      if (paramMap.contains(BarcodeFormat.EAN_13)) {
        localArrayList.add(new EAN13Reader());
      } else if (paramMap.contains(BarcodeFormat.UPC_A)) {
        localArrayList.add(new UPCAReader());
      }
      if (paramMap.contains(BarcodeFormat.EAN_8)) {
        localArrayList.add(new EAN8Reader());
      }
      if (paramMap.contains(BarcodeFormat.UPC_E)) {
        localArrayList.add(new UPCEReader());
      }
    }
    if (localArrayList.isEmpty())
    {
      localArrayList.add(new EAN13Reader());
      localArrayList.add(new EAN8Reader());
      localArrayList.add(new UPCEReader());
    }
    this.readers = ((UPCEANReader[])localArrayList.toArray(new UPCEANReader[localArrayList.size()]));
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    int[] arrayOfInt = UPCEANReader.findStartGuardPattern(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int k = arrayOfUPCEANReader.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      Object localObject = arrayOfUPCEANReader[i];
      try
      {
        localObject = ((UPCEANReader)localObject).decodeRow(paramInt, paramBitArray, arrayOfInt, paramMap);
        if ((((Result)localObject).getBarcodeFormat() == BarcodeFormat.EAN_13) && (((Result)localObject).getText().charAt(0) == '0')) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramMap == null) {
          paramBitArray = null;
        } else {
          paramBitArray = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        if (paramBitArray != null)
        {
          i = j;
          if (!paramBitArray.contains(BarcodeFormat.UPC_A)) {}
        }
        else
        {
          i = 1;
        }
        if ((paramInt != 0) && (i != 0))
        {
          paramBitArray = new Result(((Result)localObject).getText().substring(1), ((Result)localObject).getRawBytes(), ((Result)localObject).getResultPoints(), BarcodeFormat.UPC_A);
          paramBitArray.putAllMetadata(((Result)localObject).getResultMetadata());
          return paramBitArray;
        }
        return (Result)localObject;
      }
      catch (ReaderException localReaderException)
      {
        for (;;) {}
      }
      i += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset()
  {
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int j = arrayOfUPCEANReader.length;
    int i = 0;
    while (i < j)
    {
      arrayOfUPCEANReader[i].reset();
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\MultiFormatUPCEANReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */