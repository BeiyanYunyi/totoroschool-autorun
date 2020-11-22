package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector
{
  private final BitMatrix image;
  private ResultPointCallback resultPointCallback;
  
  public Detector(BitMatrix paramBitMatrix)
  {
    this.image = paramBitMatrix;
  }
  
  private float calculateModuleSizeOneWay(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    float f1 = sizeOfBlackWhiteBlackRunBothWays((int)paramResultPoint1.getX(), (int)paramResultPoint1.getY(), (int)paramResultPoint2.getX(), (int)paramResultPoint2.getY());
    float f2 = sizeOfBlackWhiteBlackRunBothWays((int)paramResultPoint2.getX(), (int)paramResultPoint2.getY(), (int)paramResultPoint1.getX(), (int)paramResultPoint1.getY());
    if (Float.isNaN(f1)) {
      return f2 / 7.0F;
    }
    if (Float.isNaN(f2)) {
      return f1 / 7.0F;
    }
    return (f1 + f2) / 14.0F;
  }
  
  private static int computeDimension(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat)
    throws NotFoundException
  {
    int i = (MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint2) / paramFloat) + MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint3) / paramFloat)) / 2 + 7;
    int j = i & 0x3;
    if (j != 0)
    {
      switch (j)
      {
      default: 
        return i;
      case 3: 
        throw NotFoundException.getNotFoundInstance();
      }
      return i - 1;
    }
    return i + 1;
  }
  
  private static PerspectiveTransform createTransform(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f4 = paramInt - 3.5F;
    float f2;
    float f3;
    float f1;
    if (paramResultPoint4 != null)
    {
      f2 = paramResultPoint4.getX();
      f3 = paramResultPoint4.getY();
      f1 = f4 - 3.0F;
    }
    else
    {
      f2 = paramResultPoint2.getX();
      float f6 = paramResultPoint1.getX();
      float f7 = paramResultPoint3.getX();
      f1 = paramResultPoint2.getY();
      f3 = paramResultPoint1.getY();
      float f5 = paramResultPoint3.getY();
      f2 = f2 - f6 + f7;
      f3 = f1 - f3 + f5;
      f1 = f4;
    }
    return PerspectiveTransform.quadrilateralToQuadrilateral(3.5F, 3.5F, f4, 3.5F, f1, f1, 3.5F, f4, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY(), f2, f3, paramResultPoint3.getX(), paramResultPoint3.getY());
  }
  
  private static BitMatrix sampleGrid(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt)
    throws NotFoundException
  {
    return GridSampler.getInstance().sampleGrid(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }
  
  private float sizeOfBlackWhiteBlackRun(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1)) {
      i = 1;
    } else {
      i = 0;
    }
    int m;
    if (i != 0)
    {
      j = paramInt1;
      m = paramInt3;
      paramInt1 = paramInt4;
      paramInt3 = paramInt2;
      paramInt4 = j;
    }
    else
    {
      j = paramInt1;
      paramInt1 = paramInt3;
      m = paramInt4;
      paramInt4 = paramInt2;
      paramInt3 = j;
    }
    int i6 = Math.abs(paramInt1 - paramInt3);
    int i7 = Math.abs(m - paramInt4);
    int k = -i6 / 2;
    int i1 = -1;
    int n;
    if (paramInt3 < paramInt1) {
      n = 1;
    } else {
      n = -1;
    }
    if (paramInt4 < m) {
      i1 = 1;
    }
    int i2 = paramInt1 + n;
    paramInt2 = paramInt4;
    int j = 0;
    paramInt1 = paramInt3;
    int i3 = i;
    while (paramInt1 != i2)
    {
      if (i3 != 0) {
        i4 = paramInt2;
      } else {
        i4 = paramInt1;
      }
      int i5;
      if (i3 != 0) {
        i5 = paramInt1;
      } else {
        i5 = paramInt2;
      }
      int i8;
      if (j == 1) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      i = j;
      if (i8 == this.image.get(i4, i5))
      {
        if (j == 2) {
          return MathUtils.distance(paramInt1, paramInt2, paramInt3, paramInt4);
        }
        i = j + 1;
      }
      int i4 = k + i7;
      j = paramInt2;
      k = i4;
      if (i4 > 0)
      {
        if (paramInt2 == m) {
          break label283;
        }
        j = paramInt2 + i1;
        k = i4 - i6;
      }
      paramInt1 += n;
      paramInt2 = j;
      j = i;
    }
    int i = j;
    label283:
    if (i == 2) {
      return MathUtils.distance(i2, m, paramInt3, paramInt4);
    }
    return NaN.0F;
  }
  
  private float sizeOfBlackWhiteBlackRunBothWays(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = sizeOfBlackWhiteBlackRun(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = paramInt1 - (paramInt3 - paramInt1);
    int i = 0;
    float f1;
    if (paramInt3 < 0)
    {
      f1 = paramInt1 / (paramInt1 - paramInt3);
      paramInt3 = 0;
    }
    else if (paramInt3 >= this.image.getWidth())
    {
      f1 = (this.image.getWidth() - 1 - paramInt1) / (paramInt3 - paramInt1);
      paramInt3 = this.image.getWidth() - 1;
    }
    else
    {
      f1 = 1.0F;
    }
    float f3 = paramInt2;
    paramInt4 = (int)(f3 - (paramInt4 - paramInt2) * f1);
    if (paramInt4 < 0)
    {
      f1 = f3 / (paramInt2 - paramInt4);
      paramInt4 = i;
    }
    else if (paramInt4 >= this.image.getHeight())
    {
      f1 = (this.image.getHeight() - 1 - paramInt2) / (paramInt4 - paramInt2);
      paramInt4 = this.image.getHeight() - 1;
    }
    else
    {
      f1 = 1.0F;
    }
    return f2 + sizeOfBlackWhiteBlackRun(paramInt1, paramInt2, (int)(paramInt1 + (paramInt3 - paramInt1) * f1), paramInt4) - 1.0F;
  }
  
  protected final float calculateModuleSize(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    return (calculateModuleSizeOneWay(paramResultPoint1, paramResultPoint2) + calculateModuleSizeOneWay(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }
  
  public DetectorResult detect()
    throws NotFoundException, FormatException
  {
    return detect(null);
  }
  
  public final DetectorResult detect(Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException
  {
    ResultPointCallback localResultPointCallback;
    if (paramMap == null) {
      localResultPointCallback = null;
    } else {
      localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
    }
    this.resultPointCallback = localResultPointCallback;
    return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(paramMap));
  }
  
  protected final AlignmentPattern findAlignmentInRegion(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
    throws NotFoundException
  {
    int j = (int)(paramFloat2 * paramFloat1);
    int i = Math.max(0, paramInt1 - j);
    paramInt1 = Math.min(this.image.getWidth() - 1, paramInt1 + j) - i;
    paramFloat2 = paramInt1;
    float f = 3.0F * paramFloat1;
    if (paramFloat2 >= f)
    {
      int k = Math.max(0, paramInt2 - j);
      paramInt2 = Math.min(this.image.getHeight() - 1, paramInt2 + j) - k;
      if (paramInt2 >= f) {
        return new AlignmentPatternFinder(this.image, i, k, paramInt1, paramInt2, paramFloat1, this.resultPointCallback).find();
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected final BitMatrix getImage()
  {
    return this.image;
  }
  
  protected final ResultPointCallback getResultPointCallback()
  {
    return this.resultPointCallback;
  }
  
  protected final DetectorResult processFinderPatternInfo(FinderPatternInfo paramFinderPatternInfo)
    throws NotFoundException, FormatException
  {
    FinderPattern localFinderPattern1 = paramFinderPatternInfo.getTopLeft();
    FinderPattern localFinderPattern2 = paramFinderPatternInfo.getTopRight();
    FinderPattern localFinderPattern3 = paramFinderPatternInfo.getBottomLeft();
    float f1 = calculateModuleSize(localFinderPattern1, localFinderPattern2, localFinderPattern3);
    if (f1 >= 1.0F)
    {
      int j = computeDimension(localFinderPattern1, localFinderPattern2, localFinderPattern3, f1);
      Version localVersion = Version.getProvisionalVersionForDimension(j);
      int i = localVersion.getDimensionForVersion();
      Object localObject = null;
      paramFinderPatternInfo = (FinderPatternInfo)localObject;
      if (localVersion.getAlignmentPatternCenters().length > 0)
      {
        float f2 = localFinderPattern2.getX();
        float f3 = localFinderPattern1.getX();
        float f4 = localFinderPattern3.getX();
        float f5 = localFinderPattern2.getY();
        float f6 = localFinderPattern1.getY();
        float f7 = localFinderPattern3.getY();
        float f8 = 1.0F - 3.0F / (i - 7);
        int k = (int)(localFinderPattern1.getX() + (f2 - f3 + f4 - localFinderPattern1.getX()) * f8);
        int m = (int)(localFinderPattern1.getY() + f8 * (f5 - f6 + f7 - localFinderPattern1.getY()));
        i = 4;
        for (;;)
        {
          paramFinderPatternInfo = (FinderPatternInfo)localObject;
          if (i > 16) {
            break;
          }
          f2 = i;
          try
          {
            paramFinderPatternInfo = findAlignmentInRegion(f1, k, m, f2);
          }
          catch (NotFoundException paramFinderPatternInfo)
          {
            for (;;) {}
          }
          i <<= 1;
        }
      }
      localObject = createTransform(localFinderPattern1, localFinderPattern2, localFinderPattern3, paramFinderPatternInfo, j);
      localObject = sampleGrid(this.image, (PerspectiveTransform)localObject, j);
      if (paramFinderPatternInfo == null)
      {
        paramFinderPatternInfo = new ResultPoint[3];
        paramFinderPatternInfo[0] = localFinderPattern3;
        paramFinderPatternInfo[1] = localFinderPattern1;
        paramFinderPatternInfo[2] = localFinderPattern2;
      }
      else
      {
        paramFinderPatternInfo = new ResultPoint[] { localFinderPattern3, localFinderPattern1, localFinderPattern2, paramFinderPatternInfo };
      }
      return new DetectorResult((BitMatrix)localObject, paramFinderPatternInfo);
    }
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */