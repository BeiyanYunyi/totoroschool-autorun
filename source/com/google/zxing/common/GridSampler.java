package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler
{
  private static GridSampler gridSampler = new DefaultGridSampler();
  
  protected static void checkAndNudgePoints(BitMatrix paramBitMatrix, float[] paramArrayOfFloat)
    throws NotFoundException
  {
    int k = paramBitMatrix.getWidth();
    int m = paramBitMatrix.getHeight();
    int j = 0;
    int i = 1;
    int n;
    int i1;
    while ((j < paramArrayOfFloat.length) && (i != 0))
    {
      i = (int)paramArrayOfFloat[j];
      n = j + 1;
      i1 = (int)paramArrayOfFloat[n];
      if ((i >= -1) && (i <= k) && (i1 >= -1) && (i1 <= m))
      {
        if (i == -1) {
          paramArrayOfFloat[j] = 0.0F;
        }
        for (;;)
        {
          i = 1;
          break label100;
          if (i != k) {
            break;
          }
          paramArrayOfFloat[j] = (k - 1);
        }
        i = 0;
        label100:
        if (i1 == -1) {
          paramArrayOfFloat[n] = 0.0F;
        }
        for (;;)
        {
          i = 1;
          break;
          if (i1 != m) {
            break;
          }
          paramArrayOfFloat[n] = (m - 1);
        }
        j += 2;
      }
      else
      {
        throw NotFoundException.getNotFoundInstance();
      }
    }
    j = paramArrayOfFloat.length - 2;
    i = 1;
    while ((j >= 0) && (i != 0))
    {
      i = (int)paramArrayOfFloat[j];
      n = j + 1;
      i1 = (int)paramArrayOfFloat[n];
      if ((i >= -1) && (i <= k) && (i1 >= -1) && (i1 <= m))
      {
        if (i == -1) {
          paramArrayOfFloat[j] = 0.0F;
        }
        for (;;)
        {
          i = 1;
          break label235;
          if (i != k) {
            break;
          }
          paramArrayOfFloat[j] = (k - 1);
        }
        i = 0;
        label235:
        if (i1 == -1) {
          paramArrayOfFloat[n] = 0.0F;
        }
        for (;;)
        {
          i = 1;
          break;
          if (i1 != m) {
            break;
          }
          paramArrayOfFloat[n] = (m - 1);
        }
        j -= 2;
      }
      else
      {
        throw NotFoundException.getNotFoundInstance();
      }
    }
  }
  
  public static GridSampler getInstance()
  {
    return gridSampler;
  }
  
  public static void setGridSampler(GridSampler paramGridSampler)
  {
    gridSampler = paramGridSampler;
  }
  
  public abstract BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
    throws NotFoundException;
  
  public abstract BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform)
    throws NotFoundException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\GridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */