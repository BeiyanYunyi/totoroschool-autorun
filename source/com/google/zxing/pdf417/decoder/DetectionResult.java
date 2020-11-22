package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

final class DetectionResult
{
  private static final int ADJUST_ROW_NUMBER_SKIP = 2;
  private final int barcodeColumnCount;
  private final BarcodeMetadata barcodeMetadata;
  private BoundingBox boundingBox;
  private final DetectionResultColumn[] detectionResultColumns;
  
  DetectionResult(BarcodeMetadata paramBarcodeMetadata, BoundingBox paramBoundingBox)
  {
    this.barcodeMetadata = paramBarcodeMetadata;
    this.barcodeColumnCount = paramBarcodeMetadata.getColumnCount();
    this.boundingBox = paramBoundingBox;
    this.detectionResultColumns = new DetectionResultColumn[this.barcodeColumnCount + 2];
  }
  
  private void adjustIndicatorColumnRowNumbers(DetectionResultColumn paramDetectionResultColumn)
  {
    if (paramDetectionResultColumn != null) {
      ((DetectionResultRowIndicatorColumn)paramDetectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
    }
  }
  
  private static boolean adjustRowNumber(Codeword paramCodeword1, Codeword paramCodeword2)
  {
    if (paramCodeword2 == null) {
      return false;
    }
    if ((paramCodeword2.hasValidRowNumber()) && (paramCodeword2.getBucket() == paramCodeword1.getBucket()))
    {
      paramCodeword1.setRowNumber(paramCodeword2.getRowNumber());
      return true;
    }
    return false;
  }
  
  private static int adjustRowNumberIfValid(int paramInt1, int paramInt2, Codeword paramCodeword)
  {
    if (paramCodeword == null) {
      return paramInt2;
    }
    int i = paramInt2;
    if (!paramCodeword.hasValidRowNumber())
    {
      if (paramCodeword.isValidRowNumber(paramInt1))
      {
        paramCodeword.setRowNumber(paramInt1);
        return 0;
      }
      i = paramInt2 + 1;
    }
    return i;
  }
  
  private int adjustRowNumbers()
  {
    int k = adjustRowNumbersByRow();
    if (k == 0) {
      return 0;
    }
    int i = 1;
    while (i < this.barcodeColumnCount + 1)
    {
      Codeword[] arrayOfCodeword = this.detectionResultColumns[i].getCodewords();
      int j = 0;
      while (j < arrayOfCodeword.length)
      {
        if ((arrayOfCodeword[j] != null) && (!arrayOfCodeword[j].hasValidRowNumber())) {
          adjustRowNumbers(i, j, arrayOfCodeword);
        }
        j += 1;
      }
      i += 1;
    }
    return k;
  }
  
  private void adjustRowNumbers(int paramInt1, int paramInt2, Codeword[] paramArrayOfCodeword)
  {
    Codeword localCodeword = paramArrayOfCodeword[paramInt2];
    Codeword[] arrayOfCodeword1 = this.detectionResultColumns[(paramInt1 - 1)].getCodewords();
    Object localObject = this.detectionResultColumns;
    paramInt1 += 1;
    if (localObject[paramInt1] != null) {
      localObject = this.detectionResultColumns[paramInt1].getCodewords();
    } else {
      localObject = arrayOfCodeword1;
    }
    Codeword[] arrayOfCodeword2 = new Codeword[14];
    arrayOfCodeword2[2] = arrayOfCodeword1[paramInt2];
    arrayOfCodeword2[3] = localObject[paramInt2];
    paramInt1 = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      arrayOfCodeword2[0] = paramArrayOfCodeword[i];
      arrayOfCodeword2[4] = arrayOfCodeword1[i];
      arrayOfCodeword2[5] = localObject[i];
    }
    if (paramInt2 > 1)
    {
      i = paramInt2 - 2;
      arrayOfCodeword2[8] = paramArrayOfCodeword[i];
      arrayOfCodeword2[10] = arrayOfCodeword1[i];
      arrayOfCodeword2[11] = localObject[i];
    }
    if (paramInt2 < paramArrayOfCodeword.length - 1)
    {
      i = paramInt2 + 1;
      arrayOfCodeword2[1] = paramArrayOfCodeword[i];
      arrayOfCodeword2[6] = arrayOfCodeword1[i];
      arrayOfCodeword2[7] = localObject[i];
    }
    if (paramInt2 < paramArrayOfCodeword.length - 2)
    {
      paramInt2 += 2;
      arrayOfCodeword2[9] = paramArrayOfCodeword[paramInt2];
      arrayOfCodeword2[12] = arrayOfCodeword1[paramInt2];
      arrayOfCodeword2[13] = localObject[paramInt2];
    }
    paramInt2 = arrayOfCodeword2.length;
    while (paramInt1 < paramInt2)
    {
      if (adjustRowNumber(localCodeword, arrayOfCodeword2[paramInt1])) {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  private int adjustRowNumbersByRow()
  {
    adjustRowNumbersFromBothRI();
    return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
  }
  
  private void adjustRowNumbersFromBothRI()
  {
    Object localObject = this.detectionResultColumns;
    int i = 0;
    if (localObject[0] != null)
    {
      if (this.detectionResultColumns[(this.barcodeColumnCount + 1)] == null) {
        return;
      }
      localObject = this.detectionResultColumns[0].getCodewords();
      Codeword[] arrayOfCodeword = this.detectionResultColumns[(this.barcodeColumnCount + 1)].getCodewords();
      while (i < localObject.length)
      {
        if ((localObject[i] != null) && (arrayOfCodeword[i] != null) && (localObject[i].getRowNumber() == arrayOfCodeword[i].getRowNumber()))
        {
          int j = 1;
          while (j <= this.barcodeColumnCount)
          {
            Codeword localCodeword = this.detectionResultColumns[j].getCodewords()[i];
            if (localCodeword != null)
            {
              localCodeword.setRowNumber(localObject[i].getRowNumber());
              if (!localCodeword.hasValidRowNumber()) {
                this.detectionResultColumns[j].getCodewords()[i] = null;
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      return;
    }
  }
  
  private int adjustRowNumbersFromLRI()
  {
    if (this.detectionResultColumns[0] == null) {
      return 0;
    }
    Codeword[] arrayOfCodeword = this.detectionResultColumns[0].getCodewords();
    int j = 0;
    int i = 0;
    while (j < arrayOfCodeword.length)
    {
      if (arrayOfCodeword[j] != null)
      {
        int i2 = arrayOfCodeword[j].getRowNumber();
        int k = 1;
        int i1 = 0;
        while ((k < this.barcodeColumnCount + 1) && (i1 < 2))
        {
          Codeword localCodeword = this.detectionResultColumns[k].getCodewords()[j];
          int m = i1;
          int n = i;
          if (localCodeword != null)
          {
            i1 = adjustRowNumberIfValid(i2, i1, localCodeword);
            m = i1;
            n = i;
            if (!localCodeword.hasValidRowNumber())
            {
              n = i + 1;
              m = i1;
            }
          }
          k += 1;
          i1 = m;
          i = n;
        }
      }
      j += 1;
    }
    return i;
  }
  
  private int adjustRowNumbersFromRRI()
  {
    if (this.detectionResultColumns[(this.barcodeColumnCount + 1)] == null) {
      return 0;
    }
    Codeword[] arrayOfCodeword = this.detectionResultColumns[(this.barcodeColumnCount + 1)].getCodewords();
    int j = 0;
    int i = 0;
    while (j < arrayOfCodeword.length)
    {
      if (arrayOfCodeword[j] != null)
      {
        int i2 = arrayOfCodeword[j].getRowNumber();
        int k = this.barcodeColumnCount + 1;
        int i1 = 0;
        while ((k > 0) && (i1 < 2))
        {
          Codeword localCodeword = this.detectionResultColumns[k].getCodewords()[j];
          int m = i1;
          int n = i;
          if (localCodeword != null)
          {
            i1 = adjustRowNumberIfValid(i2, i1, localCodeword);
            m = i1;
            n = i;
            if (!localCodeword.hasValidRowNumber())
            {
              n = i + 1;
              m = i1;
            }
          }
          k -= 1;
          i1 = m;
          i = n;
        }
      }
      j += 1;
    }
    return i;
  }
  
  int getBarcodeColumnCount()
  {
    return this.barcodeColumnCount;
  }
  
  int getBarcodeECLevel()
  {
    return this.barcodeMetadata.getErrorCorrectionLevel();
  }
  
  int getBarcodeRowCount()
  {
    return this.barcodeMetadata.getRowCount();
  }
  
  BoundingBox getBoundingBox()
  {
    return this.boundingBox;
  }
  
  DetectionResultColumn getDetectionResultColumn(int paramInt)
  {
    return this.detectionResultColumns[paramInt];
  }
  
  DetectionResultColumn[] getDetectionResultColumns()
  {
    adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
    adjustIndicatorColumnRowNumbers(this.detectionResultColumns[(this.barcodeColumnCount + 1)]);
    int j;
    for (int i = 928;; i = j)
    {
      j = adjustRowNumbers();
      if ((j <= 0) || (j >= i)) {
        break;
      }
    }
    return this.detectionResultColumns;
  }
  
  public void setBoundingBox(BoundingBox paramBoundingBox)
  {
    this.boundingBox = paramBoundingBox;
  }
  
  void setDetectionResultColumn(int paramInt, DetectionResultColumn paramDetectionResultColumn)
  {
    this.detectionResultColumns[paramInt] = paramDetectionResultColumn;
  }
  
  public String toString()
  {
    Object localObject2 = this.detectionResultColumns[0];
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.detectionResultColumns[(this.barcodeColumnCount + 1)];
    }
    localObject2 = new Formatter();
    int i = 0;
    while (i < ((DetectionResultColumn)localObject1).getCodewords().length)
    {
      ((Formatter)localObject2).format("CW %3d:", new Object[] { Integer.valueOf(i) });
      int j = 0;
      while (j < this.barcodeColumnCount + 2)
      {
        if (this.detectionResultColumns[j] == null)
        {
          ((Formatter)localObject2).format("    |   ", new Object[0]);
        }
        else
        {
          Codeword localCodeword = this.detectionResultColumns[j].getCodewords()[i];
          if (localCodeword == null) {
            ((Formatter)localObject2).format("    |   ", new Object[0]);
          } else {
            ((Formatter)localObject2).format(" %3d|%3d", new Object[] { Integer.valueOf(localCodeword.getRowNumber()), Integer.valueOf(localCodeword.getValue()) });
          }
        }
        j += 1;
      }
      ((Formatter)localObject2).format("%n", new Object[0]);
      i += 1;
    }
    localObject1 = ((Formatter)localObject2).toString();
    ((Formatter)localObject2).close();
    return (String)localObject1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */