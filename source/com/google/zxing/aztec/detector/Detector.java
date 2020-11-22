package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector
{
  private static final int[] EXPECTED_CORNER_BITS = { 3808, 476, 2107, 1799 };
  private boolean compact;
  private final BitMatrix image;
  private int nbCenterLayers;
  private int nbDataBlocks;
  private int nbLayers;
  private int shift;
  
  public Detector(BitMatrix paramBitMatrix)
  {
    this.image = paramBitMatrix;
  }
  
  private static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.distance(paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }
  
  private static float distance(Point paramPoint1, Point paramPoint2)
  {
    return MathUtils.distance(paramPoint1.getX(), paramPoint1.getY(), paramPoint2.getX(), paramPoint2.getY());
  }
  
  private static ResultPoint[] expandSquare(ResultPoint[] paramArrayOfResultPoint, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2 / (paramFloat1 * 2.0F);
    float f4 = paramArrayOfResultPoint[0].getX();
    float f5 = paramArrayOfResultPoint[2].getX();
    float f2 = paramArrayOfResultPoint[0].getY();
    float f3 = paramArrayOfResultPoint[2].getY();
    paramFloat2 = (paramArrayOfResultPoint[0].getX() + paramArrayOfResultPoint[2].getX()) / 2.0F;
    float f1 = (paramArrayOfResultPoint[0].getY() + paramArrayOfResultPoint[2].getY()) / 2.0F;
    f4 = (f4 - f5) * paramFloat1;
    f2 = (f2 - f3) * paramFloat1;
    ResultPoint localResultPoint1 = new ResultPoint(paramFloat2 + f4, f1 + f2);
    ResultPoint localResultPoint2 = new ResultPoint(paramFloat2 - f4, f1 - f2);
    f4 = paramArrayOfResultPoint[1].getX();
    f5 = paramArrayOfResultPoint[3].getX();
    f2 = paramArrayOfResultPoint[1].getY();
    f3 = paramArrayOfResultPoint[3].getY();
    paramFloat2 = (paramArrayOfResultPoint[1].getX() + paramArrayOfResultPoint[3].getX()) / 2.0F;
    f1 = (paramArrayOfResultPoint[1].getY() + paramArrayOfResultPoint[3].getY()) / 2.0F;
    f4 = (f4 - f5) * paramFloat1;
    paramFloat1 *= (f2 - f3);
    return new ResultPoint[] { localResultPoint1, new ResultPoint(paramFloat2 + f4, f1 + paramFloat1), localResultPoint2, new ResultPoint(paramFloat2 - f4, f1 - paramFloat1) };
  }
  
  private void extractParameters(ResultPoint[] paramArrayOfResultPoint)
    throws NotFoundException
  {
    int i = 0;
    if ((isValid(paramArrayOfResultPoint[0])) && (isValid(paramArrayOfResultPoint[1])) && (isValid(paramArrayOfResultPoint[2])) && (isValid(paramArrayOfResultPoint[3])))
    {
      int j = this.nbCenterLayers * 2;
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = sampleLine(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1], j);
      arrayOfInt[1] = sampleLine(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2], j);
      arrayOfInt[2] = sampleLine(paramArrayOfResultPoint[2], paramArrayOfResultPoint[3], j);
      arrayOfInt[3] = sampleLine(paramArrayOfResultPoint[3], paramArrayOfResultPoint[0], j);
      this.shift = getRotation(arrayOfInt, j);
      long l = 0L;
      while (i < 4)
      {
        j = arrayOfInt[((this.shift + i) % 4)];
        if (this.compact) {
          l = (l << 7) + (j >> 1 & 0x7F);
        } else {
          l = (l << 10) + ((j >> 2 & 0x3E0) + (j >> 1 & 0x1F));
        }
        i += 1;
      }
      i = getCorrectedParameterData(l, this.compact);
      if (this.compact)
      {
        this.nbLayers = ((i >> 6) + 1);
        this.nbDataBlocks = ((i & 0x3F) + 1);
        return;
      }
      this.nbLayers = ((i >> 11) + 1);
      this.nbDataBlocks = ((i & 0x7FF) + 1);
      return;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private ResultPoint[] getBullsEyeCorners(Point paramPoint)
    throws NotFoundException
  {
    this.nbCenterLayers = 1;
    Object localObject1 = paramPoint;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    boolean bool = true;
    while (this.nbCenterLayers < 9)
    {
      Point localPoint3 = getFirstDifferent(paramPoint, bool, 1, -1);
      Point localPoint2 = getFirstDifferent((Point)localObject1, bool, 1, 1);
      Point localPoint1 = getFirstDifferent((Point)localObject2, bool, -1, 1);
      Point localPoint4 = getFirstDifferent((Point)localObject3, bool, -1, -1);
      if (this.nbCenterLayers > 2)
      {
        double d = distance(localPoint4, localPoint3) * this.nbCenterLayers / (distance((Point)localObject3, paramPoint) * (this.nbCenterLayers + 2));
        if ((d < 0.75D) || (d > 1.25D) || (!isWhiteOrBlackRectangle(localPoint3, localPoint2, localPoint1, localPoint4))) {
          break;
        }
      }
      bool ^= true;
      this.nbCenterLayers += 1;
      localObject3 = localPoint4;
      paramPoint = localPoint3;
      localObject1 = localPoint2;
      localObject2 = localPoint1;
    }
    if ((this.nbCenterLayers != 5) && (this.nbCenterLayers != 7)) {
      throw NotFoundException.getNotFoundInstance();
    }
    if (this.nbCenterLayers == 5) {
      bool = true;
    } else {
      bool = false;
    }
    this.compact = bool;
    paramPoint = new ResultPoint(paramPoint.getX() + 0.5F, paramPoint.getY() - 0.5F);
    localObject1 = new ResultPoint(((Point)localObject1).getX() + 0.5F, ((Point)localObject1).getY() + 0.5F);
    localObject2 = new ResultPoint(((Point)localObject2).getX() - 0.5F, ((Point)localObject2).getY() + 0.5F);
    localObject3 = new ResultPoint(((Point)localObject3).getX() - 0.5F, ((Point)localObject3).getY() - 0.5F);
    float f1 = this.nbCenterLayers * 2 - 3;
    float f2 = this.nbCenterLayers * 2;
    return expandSquare(new ResultPoint[] { paramPoint, localObject1, localObject2, localObject3 }, f1, f2);
  }
  
  private int getColor(Point paramPoint1, Point paramPoint2)
  {
    float f3 = distance(paramPoint1, paramPoint2);
    float f4 = (paramPoint2.getX() - paramPoint1.getX()) / f3;
    float f5 = (paramPoint2.getY() - paramPoint1.getY()) / f3;
    float f2 = paramPoint1.getX();
    float f1 = paramPoint1.getY();
    boolean bool2 = this.image.get(paramPoint1.getX(), paramPoint1.getY());
    boolean bool1 = false;
    int j = 0;
    int i = 0;
    while (i < f3)
    {
      f2 += f4;
      f1 += f5;
      int k = j;
      if (this.image.get(MathUtils.round(f2), MathUtils.round(f1)) != bool2) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    f1 = j / f3;
    if ((f1 > 0.1F) && (f1 < 0.9F)) {
      return 0;
    }
    if (f1 <= 0.1F) {
      bool1 = true;
    }
    if (bool1 == bool2) {
      return 1;
    }
    return -1;
  }
  
  private static int getCorrectedParameterData(long paramLong, boolean paramBoolean)
    throws NotFoundException
  {
    int j;
    int i;
    if (paramBoolean)
    {
      j = 7;
      i = 2;
    }
    else
    {
      j = 10;
      i = 4;
    }
    int[] arrayOfInt = new int[j];
    int k = j - 1;
    while (k >= 0)
    {
      arrayOfInt[k] = ((int)paramLong & 0xF);
      paramLong >>= 4;
      k -= 1;
    }
    try
    {
      new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(arrayOfInt, j - i);
      j = 0;
      k = 0;
      while (j < i)
      {
        k = (k << 4) + arrayOfInt[j];
        j += 1;
      }
      return k;
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      for (;;) {}
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private int getDimension()
  {
    if (this.compact) {
      return this.nbLayers * 4 + 11;
    }
    if (this.nbLayers <= 4) {
      return this.nbLayers * 4 + 15;
    }
    return this.nbLayers * 4 + ((this.nbLayers - 4) / 8 + 1) * 2 + 15;
  }
  
  private Point getFirstDifferent(Point paramPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int j = paramPoint.getX() + paramInt1;
    int i = paramPoint.getY() + paramInt2;
    while ((isValid(j, i)) && (this.image.get(j, i) == paramBoolean))
    {
      j += paramInt1;
      i += paramInt2;
    }
    int k = j - paramInt1;
    j = i - paramInt2;
    i = k;
    while ((isValid(i, j)) && (this.image.get(i, j) == paramBoolean)) {
      i += paramInt1;
    }
    i -= paramInt1;
    paramInt1 = j;
    while ((isValid(i, paramInt1)) && (this.image.get(i, paramInt1) == paramBoolean)) {
      paramInt1 += paramInt2;
    }
    return new Point(i, paramInt1 - paramInt2);
  }
  
  private Point getMatrixCenter()
  {
    try
    {
      localObject1 = new WhiteRectangleDetector(this.image).detect();
      localObject2 = localObject1[0];
      localResultPoint1 = localObject1[1];
      localResultPoint2 = localObject1[2];
      localObject1 = localObject1[3];
    }
    catch (NotFoundException localNotFoundException1)
    {
      Object localObject1;
      Object localObject2;
      ResultPoint localResultPoint1;
      ResultPoint localResultPoint2;
      int j;
      int m;
      int k;
      int i;
      ResultPoint localResultPoint3;
      for (;;) {}
    }
    j = this.image.getWidth() / 2;
    m = this.image.getHeight() / 2;
    k = j + 7;
    i = m - 7;
    localObject1 = getFirstDifferent(new Point(k, i), false, 1, -1).toResultPoint();
    m += 7;
    localResultPoint1 = getFirstDifferent(new Point(k, m), false, 1, 1).toResultPoint();
    j -= 7;
    localResultPoint2 = getFirstDifferent(new Point(j, m), false, -1, 1).toResultPoint();
    localResultPoint3 = getFirstDifferent(new Point(j, i), false, -1, -1).toResultPoint();
    localObject2 = localObject1;
    localObject1 = localResultPoint3;
    j = MathUtils.round((((ResultPoint)localObject2).getX() + ((ResultPoint)localObject1).getX() + localResultPoint1.getX() + localResultPoint2.getX()) / 4.0F);
    m = MathUtils.round((((ResultPoint)localObject2).getY() + ((ResultPoint)localObject1).getY() + localResultPoint1.getY() + localResultPoint2.getY()) / 4.0F);
    try
    {
      localObject1 = new WhiteRectangleDetector(this.image, 15, j, m).detect();
      localResultPoint1 = localObject1[0];
      localResultPoint2 = localObject1[1];
      localObject2 = localObject1[2];
      localObject1 = localObject1[3];
    }
    catch (NotFoundException localNotFoundException2)
    {
      for (;;) {}
    }
    k = j + 7;
    i = m - 7;
    localResultPoint1 = getFirstDifferent(new Point(k, i), false, 1, -1).toResultPoint();
    m += 7;
    localResultPoint2 = getFirstDifferent(new Point(k, m), false, 1, 1).toResultPoint();
    j -= 7;
    localObject2 = getFirstDifferent(new Point(j, m), false, -1, 1).toResultPoint();
    localObject1 = getFirstDifferent(new Point(j, i), false, -1, -1).toResultPoint();
    return new Point(MathUtils.round((localResultPoint1.getX() + ((ResultPoint)localObject1).getX() + localResultPoint2.getX() + ((ResultPoint)localObject2).getX()) / 4.0F), MathUtils.round((localResultPoint1.getY() + ((ResultPoint)localObject1).getY() + localResultPoint2.getY() + ((ResultPoint)localObject2).getY()) / 4.0F));
  }
  
  private ResultPoint[] getMatrixCornerPoints(ResultPoint[] paramArrayOfResultPoint)
  {
    return expandSquare(paramArrayOfResultPoint, this.nbCenterLayers * 2, getDimension());
  }
  
  private static int getRotation(int[] paramArrayOfInt, int paramInt)
    throws NotFoundException
  {
    int m = paramArrayOfInt.length;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int n = paramArrayOfInt[j];
      i = (i << 3) + ((n >> paramInt - 2 << 1) + (n & 0x1));
      j += 1;
    }
    paramInt = k;
    while (paramInt < 4)
    {
      if (Integer.bitCount(EXPECTED_CORNER_BITS[paramInt] ^ ((i & 0x1) << 11) + (i >> 1)) <= 2) {
        return paramInt;
      }
      paramInt += 1;
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private boolean isValid(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < this.image.getWidth()) && (paramInt2 > 0) && (paramInt2 < this.image.getHeight());
  }
  
  private boolean isValid(ResultPoint paramResultPoint)
  {
    return isValid(MathUtils.round(paramResultPoint.getX()), MathUtils.round(paramResultPoint.getY()));
  }
  
  private boolean isWhiteOrBlackRectangle(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    paramPoint1 = new Point(paramPoint1.getX() - 3, paramPoint1.getY() + 3);
    paramPoint2 = new Point(paramPoint2.getX() - 3, paramPoint2.getY() - 3);
    paramPoint3 = new Point(paramPoint3.getX() + 3, paramPoint3.getY() - 3);
    paramPoint4 = new Point(paramPoint4.getX() + 3, paramPoint4.getY() + 3);
    int i = getColor(paramPoint4, paramPoint1);
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    if (getColor(paramPoint1, paramPoint2) != i) {
      return false;
    }
    if (getColor(paramPoint2, paramPoint3) != i) {
      return false;
    }
    if (getColor(paramPoint3, paramPoint4) == i) {
      bool = true;
    }
    return bool;
  }
  
  private BitMatrix sampleGrid(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
    throws NotFoundException
  {
    GridSampler localGridSampler = GridSampler.getInstance();
    int i = getDimension();
    float f2 = i / 2.0F;
    float f1 = f2 - this.nbCenterLayers;
    f2 += this.nbCenterLayers;
    return localGridSampler.sampleGrid(paramBitMatrix, i, i, f1, f1, f2, f1, f2, f2, f1, f2, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint4.getX(), paramResultPoint4.getY());
  }
  
  private int sampleLine(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt)
  {
    float f4 = distance(paramResultPoint1, paramResultPoint2);
    float f5 = f4 / paramInt;
    float f1 = paramResultPoint1.getX();
    float f2 = paramResultPoint1.getY();
    float f3 = (paramResultPoint2.getX() - paramResultPoint1.getX()) * f5 / f4;
    f4 = f5 * (paramResultPoint2.getY() - paramResultPoint1.getY()) / f4;
    int i = 0;
    int k;
    for (int j = 0; i < paramInt; j = k)
    {
      paramResultPoint1 = this.image;
      f5 = i;
      k = j;
      if (paramResultPoint1.get(MathUtils.round(f5 * f3 + f1), MathUtils.round(f5 * f4 + f2))) {
        k = j | 1 << paramInt - i - 1;
      }
      i += 1;
    }
    return j;
  }
  
  public AztecDetectorResult detect()
    throws NotFoundException
  {
    return detect(false);
  }
  
  public AztecDetectorResult detect(boolean paramBoolean)
    throws NotFoundException
  {
    ResultPoint[] arrayOfResultPoint = getBullsEyeCorners(getMatrixCenter());
    if (paramBoolean)
    {
      ResultPoint localResultPoint = arrayOfResultPoint[0];
      arrayOfResultPoint[0] = arrayOfResultPoint[2];
      arrayOfResultPoint[2] = localResultPoint;
    }
    extractParameters(arrayOfResultPoint);
    return new AztecDetectorResult(sampleGrid(this.image, arrayOfResultPoint[(this.shift % 4)], arrayOfResultPoint[((this.shift + 1) % 4)], arrayOfResultPoint[((this.shift + 2) % 4)], arrayOfResultPoint[((this.shift + 3) % 4)]), getMatrixCornerPoints(arrayOfResultPoint), this.compact, this.nbDataBlocks, this.nbLayers);
  }
  
  static final class Point
  {
    private final int x;
    private final int y;
    
    Point(int paramInt1, int paramInt2)
    {
      this.x = paramInt1;
      this.y = paramInt2;
    }
    
    int getX()
    {
      return this.x;
    }
    
    int getY()
    {
      return this.y;
    }
    
    ResultPoint toResultPoint()
    {
      return new ResultPoint(getX(), getY());
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<");
      localStringBuilder.append(this.x);
      localStringBuilder.append(' ');
      localStringBuilder.append(this.y);
      localStringBuilder.append('>');
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\aztec\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */