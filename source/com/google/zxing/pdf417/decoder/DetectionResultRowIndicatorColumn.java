package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn
  extends DetectionResultColumn
{
  private final boolean isLeft;
  
  DetectionResultRowIndicatorColumn(BoundingBox paramBoundingBox, boolean paramBoolean)
  {
    super(paramBoundingBox);
    this.isLeft = paramBoolean;
  }
  
  private void removeIncorrectCodewords(Codeword[] paramArrayOfCodeword, BarcodeMetadata paramBarcodeMetadata)
  {
    int i = 0;
    while (i < paramArrayOfCodeword.length)
    {
      Codeword localCodeword = paramArrayOfCodeword[i];
      if (paramArrayOfCodeword[i] != null)
      {
        int m = localCodeword.getValue() % 30;
        int k = localCodeword.getRowNumber();
        if (k > paramBarcodeMetadata.getRowCount())
        {
          paramArrayOfCodeword[i] = null;
        }
        else
        {
          int j = k;
          if (!this.isLeft) {
            j = k + 2;
          }
          switch (j % 3)
          {
          default: 
            break;
          case 2: 
            if (m + 1 != paramBarcodeMetadata.getColumnCount()) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          case 1: 
            if ((m / 3 != paramBarcodeMetadata.getErrorCorrectionLevel()) || (m % 3 != paramBarcodeMetadata.getRowCountLowerPart())) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          case 0: 
            if (m * 3 + 1 != paramBarcodeMetadata.getRowCountUpperPart()) {
              paramArrayOfCodeword[i] = null;
            }
            break;
          }
        }
      }
      i += 1;
    }
  }
  
  int adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata paramBarcodeMetadata)
  {
    Codeword[] arrayOfCodeword = getCodewords();
    setRowNumbers();
    removeIncorrectCodewords(arrayOfCodeword, paramBarcodeMetadata);
    Object localObject2 = getBoundingBox();
    Object localObject1;
    if (this.isLeft) {
      localObject1 = ((BoundingBox)localObject2).getTopLeft();
    } else {
      localObject1 = ((BoundingBox)localObject2).getTopRight();
    }
    if (this.isLeft) {
      localObject2 = ((BoundingBox)localObject2).getBottomLeft();
    } else {
      localObject2 = ((BoundingBox)localObject2).getBottomRight();
    }
    int k = imageRowToCodewordIndex((int)((ResultPoint)localObject1).getY());
    int i3 = imageRowToCodewordIndex((int)((ResultPoint)localObject2).getY());
    float f = (i3 - k) / paramBarcodeMetadata.getRowCount();
    int m = -1;
    int n = 0;
    int i = 1;
    while (k < i3)
    {
      int j;
      if (arrayOfCodeword[k] == null)
      {
        j = n;
      }
      else
      {
        localObject1 = arrayOfCodeword[k];
        j = ((Codeword)localObject1).getRowNumber() - m;
        if (j == 0)
        {
          j = n + 1;
        }
        else
        {
          if (j == 1) {
            i = Math.max(i, n);
          }
          for (j = ((Codeword)localObject1).getRowNumber();; j = ((Codeword)localObject1).getRowNumber())
          {
            n = 1;
            m = j;
            j = n;
            break label351;
            if ((j < 0) || (((Codeword)localObject1).getRowNumber() >= paramBarcodeMetadata.getRowCount()) || (j > k)) {
              break;
            }
            int i1 = j;
            if (i > 2) {
              i1 = j * (i - 2);
            }
            if (i1 >= k) {
              j = 1;
            } else {
              j = 0;
            }
            int i2 = 1;
            while ((i2 <= i1) && (j == 0))
            {
              if (arrayOfCodeword[(k - i2)] != null) {
                j = 1;
              } else {
                j = 0;
              }
              i2 += 1;
            }
            if (j != 0)
            {
              arrayOfCodeword[k] = null;
              j = n;
              break label351;
            }
          }
          arrayOfCodeword[k] = null;
          j = n;
        }
      }
      label351:
      k += 1;
      n = j;
    }
    double d = f;
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  int adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata paramBarcodeMetadata)
  {
    Object localObject2 = getBoundingBox();
    if (this.isLeft) {
      localObject1 = ((BoundingBox)localObject2).getTopLeft();
    } else {
      localObject1 = ((BoundingBox)localObject2).getTopRight();
    }
    if (this.isLeft) {
      localObject2 = ((BoundingBox)localObject2).getBottomLeft();
    } else {
      localObject2 = ((BoundingBox)localObject2).getBottomRight();
    }
    int k = imageRowToCodewordIndex((int)((ResultPoint)localObject1).getY());
    int i1 = imageRowToCodewordIndex((int)((ResultPoint)localObject2).getY());
    float f = (i1 - k) / paramBarcodeMetadata.getRowCount();
    Object localObject1 = getCodewords();
    int m = -1;
    int j = 0;
    int i = 1;
    while (k < i1)
    {
      if (localObject1[k] != null)
      {
        localObject2 = localObject1[k];
        ((Codeword)localObject2).setRowNumberAsRowIndicatorColumn();
        int n = ((Codeword)localObject2).getRowNumber() - m;
        if (n == 0)
        {
          j += 1;
        }
        else
        {
          if (n == 1) {
            i = Math.max(i, j);
          }
          for (j = ((Codeword)localObject2).getRowNumber();; j = ((Codeword)localObject2).getRowNumber())
          {
            n = 1;
            m = j;
            j = n;
            break;
            if (((Codeword)localObject2).getRowNumber() >= paramBarcodeMetadata.getRowCount())
            {
              localObject1[k] = null;
              break;
            }
          }
        }
      }
      k += 1;
    }
    double d = f;
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  BarcodeMetadata getBarcodeMetadata()
  {
    Codeword[] arrayOfCodeword = getCodewords();
    Object localObject = new BarcodeValue();
    BarcodeValue localBarcodeValue1 = new BarcodeValue();
    BarcodeValue localBarcodeValue2 = new BarcodeValue();
    BarcodeValue localBarcodeValue3 = new BarcodeValue();
    int m = arrayOfCodeword.length;
    int i = 0;
    while (i < m)
    {
      Codeword localCodeword = arrayOfCodeword[i];
      if (localCodeword != null)
      {
        localCodeword.setRowNumberAsRowIndicatorColumn();
        int n = localCodeword.getValue() % 30;
        int k = localCodeword.getRowNumber();
        int j = k;
        if (!this.isLeft) {
          j = k + 2;
        }
        switch (j % 3)
        {
        default: 
          break;
        case 2: 
          ((BarcodeValue)localObject).setValue(n + 1);
          break;
        case 1: 
          localBarcodeValue3.setValue(n / 3);
          localBarcodeValue2.setValue(n % 3);
          break;
        case 0: 
          localBarcodeValue1.setValue(n * 3 + 1);
        }
      }
      i += 1;
    }
    if ((((BarcodeValue)localObject).getValue().length != 0) && (localBarcodeValue1.getValue().length != 0) && (localBarcodeValue2.getValue().length != 0) && (localBarcodeValue3.getValue().length != 0) && (localObject.getValue()[0] >= 1) && (localBarcodeValue1.getValue()[0] + localBarcodeValue2.getValue()[0] >= 3) && (localBarcodeValue1.getValue()[0] + localBarcodeValue2.getValue()[0] <= 90))
    {
      localObject = new BarcodeMetadata(localObject.getValue()[0], localBarcodeValue1.getValue()[0], localBarcodeValue2.getValue()[0], localBarcodeValue3.getValue()[0]);
      removeIncorrectCodewords(arrayOfCodeword, (BarcodeMetadata)localObject);
      return (BarcodeMetadata)localObject;
    }
    return null;
  }
  
  int[] getRowHeights()
    throws FormatException
  {
    Object localObject = getBarcodeMetadata();
    if (localObject == null) {
      return null;
    }
    adjustIncompleteIndicatorColumnRowNumbers((BarcodeMetadata)localObject);
    localObject = new int[((BarcodeMetadata)localObject).getRowCount()];
    Codeword[] arrayOfCodeword = getCodewords();
    int j = arrayOfCodeword.length;
    int i = 0;
    while (i < j)
    {
      Codeword localCodeword = arrayOfCodeword[i];
      if (localCodeword != null)
      {
        int k = localCodeword.getRowNumber();
        if (k < localObject.length) {
          localObject[k] += 1;
        } else {
          throw FormatException.getFormatInstance();
        }
      }
      i += 1;
    }
    return (int[])localObject;
  }
  
  boolean isLeft()
  {
    return this.isLeft;
  }
  
  void setRowNumbers()
  {
    Codeword[] arrayOfCodeword = getCodewords();
    int j = arrayOfCodeword.length;
    int i = 0;
    while (i < j)
    {
      Codeword localCodeword = arrayOfCodeword[i];
      if (localCodeword != null) {
        localCodeword.setRowNumberAsRowIndicatorColumn();
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IsLeft: ");
    localStringBuilder.append(this.isLeft);
    localStringBuilder.append('\n');
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResultRowIndicatorColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */