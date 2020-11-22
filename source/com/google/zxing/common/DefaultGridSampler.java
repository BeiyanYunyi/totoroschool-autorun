package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler
  extends GridSampler
{
  public BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
    throws NotFoundException
  {
    return sampleGrid(paramBitMatrix, paramInt1, paramInt2, PerspectiveTransform.quadrilateralToQuadrilateral(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16));
  }
  
  public BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform)
    throws NotFoundException
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      BitMatrix localBitMatrix = new BitMatrix(paramInt1, paramInt2);
      float[] arrayOfFloat = new float[paramInt1 * 2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int j = arrayOfFloat.length;
        float f = paramInt1;
        int i = 0;
        while (i < j)
        {
          arrayOfFloat[i] = (i / 2 + 0.5F);
          arrayOfFloat[(i + 1)] = (f + 0.5F);
          i += 2;
        }
        paramPerspectiveTransform.transformPoints(arrayOfFloat);
        checkAndNudgePoints(paramBitMatrix, arrayOfFloat);
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label153;
          }
          try
          {
            if (paramBitMatrix.get((int)arrayOfFloat[i], (int)arrayOfFloat[(i + 1)])) {
              localBitMatrix.set(i / 2, paramInt1);
            }
            i += 2;
          }
          catch (ArrayIndexOutOfBoundsException paramBitMatrix)
          {
            label153:
            for (;;) {}
          }
        }
        throw NotFoundException.getNotFoundInstance();
        paramInt1 += 1;
      }
      return localBitMatrix;
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\DefaultGridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */