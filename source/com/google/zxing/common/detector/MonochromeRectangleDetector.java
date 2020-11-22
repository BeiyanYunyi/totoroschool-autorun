package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector
{
  private static final int MAX_MODULES = 32;
  private final BitMatrix image;
  
  public MonochromeRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.image = paramBitMatrix;
  }
  
  private int[] blackWhiteRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = (paramInt3 + paramInt4) / 2;
    int i = j;
    while (i >= paramInt3) {
      if (paramBoolean ? this.image.get(i, paramInt1) : this.image.get(paramInt1, i))
      {
        i -= 1;
      }
      else
      {
        k = i;
        int m;
        do
        {
          do
          {
            m = k - 1;
            if (m < paramInt3) {
              break label119;
            }
            if (!paramBoolean) {
              break;
            }
            k = m;
          } while (!this.image.get(m, paramInt1));
          break;
          k = m;
        } while (!this.image.get(paramInt1, m));
        label119:
        if ((m < paramInt3) || (i - m > paramInt2)) {
          break;
        }
        i = m;
      }
    }
    int k = i + 1;
    paramInt3 = j;
    while (paramInt3 < paramInt4) {
      if (paramBoolean ? this.image.get(paramInt3, paramInt1) : this.image.get(paramInt1, paramInt3))
      {
        paramInt3 += 1;
      }
      else
      {
        i = paramInt3;
        do
        {
          do
          {
            j = i + 1;
            if (j >= paramInt4) {
              break label256;
            }
            if (!paramBoolean) {
              break;
            }
            i = j;
          } while (!this.image.get(j, paramInt1));
          break;
          i = j;
        } while (!this.image.get(paramInt1, j));
        label256:
        if ((j >= paramInt4) || (j - paramInt3 > paramInt2)) {
          break;
        }
        paramInt3 = j;
      }
    }
    paramInt1 = paramInt3 - 1;
    if (paramInt1 > k) {
      return new int[] { k, paramInt1 };
    }
    return null;
  }
  
  private ResultPoint findCornerFromCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    throws NotFoundException
  {
    int i = paramInt1;
    int j = paramInt5;
    int[] arrayOfInt;
    for (Object localObject = null; (j < paramInt8) && (j >= paramInt7) && (i < paramInt4) && (i >= paramInt3); localObject = arrayOfInt)
    {
      if (paramInt2 == 0) {
        arrayOfInt = blackWhiteRange(j, paramInt9, paramInt3, paramInt4, true);
      } else {
        arrayOfInt = blackWhiteRange(i, paramInt9, paramInt7, paramInt8, false);
      }
      if (arrayOfInt == null)
      {
        if (localObject != null)
        {
          float f1;
          if (paramInt2 == 0)
          {
            paramInt2 = j - paramInt6;
            if (localObject[0] < paramInt1)
            {
              if (localObject[1] > paramInt1)
              {
                if (paramInt6 > 0) {}
                for (paramInt1 = localObject[0];; paramInt1 = localObject[1])
                {
                  f1 = paramInt1;
                  break;
                }
                return new ResultPoint(f1, paramInt2);
              }
              return new ResultPoint(localObject[0], paramInt2);
            }
            return new ResultPoint(localObject[1], paramInt2);
          }
          paramInt1 = i - paramInt2;
          if (localObject[0] < paramInt5)
          {
            if (localObject[1] > paramInt5)
            {
              f1 = paramInt1;
              if (paramInt2 < 0) {}
              float f2;
              for (paramInt1 = localObject[0];; paramInt1 = localObject[1])
              {
                f2 = paramInt1;
                break;
              }
              return new ResultPoint(f1, f2);
            }
            return new ResultPoint(paramInt1, localObject[0]);
          }
          return new ResultPoint(paramInt1, localObject[1]);
        }
        throw NotFoundException.getNotFoundInstance();
      }
      j += paramInt6;
      i += paramInt2;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  public ResultPoint[] detect()
    throws NotFoundException
  {
    int i = this.image.getHeight();
    int i3 = this.image.getWidth();
    int j = i / 2;
    int k = i3 / 2;
    int m = Math.max(1, i / 256);
    int i4 = Math.max(1, i3 / 256);
    int n = -m;
    int i1 = k / 2;
    int i2 = (int)findCornerFromCenter(k, 0, 0, i3, j, n, 0, i, i1).getY() - 1;
    int i6 = -i4;
    int i5 = j / 2;
    ResultPoint localResultPoint1 = findCornerFromCenter(k, i6, 0, i3, j, 0, i2, i, i5);
    i6 = (int)localResultPoint1.getX() - 1;
    ResultPoint localResultPoint2 = findCornerFromCenter(k, i4, i6, i3, j, 0, i2, i, i5);
    i3 = (int)localResultPoint2.getX() + 1;
    ResultPoint localResultPoint3 = findCornerFromCenter(k, 0, i6, i3, j, m, i2, i, i1);
    return new ResultPoint[] { findCornerFromCenter(k, 0, i6, i3, j, n, i2, (int)localResultPoint3.getY() + 1, k / 4), localResultPoint1, localResultPoint2, localResultPoint3 };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\detector\MonochromeRectangleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */