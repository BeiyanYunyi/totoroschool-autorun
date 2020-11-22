package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox
{
  private ResultPoint bottomLeft;
  private ResultPoint bottomRight;
  private BitMatrix image;
  private int maxX;
  private int maxY;
  private int minX;
  private int minY;
  private ResultPoint topLeft;
  private ResultPoint topRight;
  
  BoundingBox(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
    throws NotFoundException
  {
    if (((paramResultPoint1 == null) && (paramResultPoint3 == null)) || ((paramResultPoint2 == null) && (paramResultPoint4 == null)) || ((paramResultPoint1 != null) && (paramResultPoint2 == null)) || ((paramResultPoint3 != null) && (paramResultPoint4 == null))) {
      throw NotFoundException.getNotFoundInstance();
    }
    init(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
  }
  
  BoundingBox(BoundingBox paramBoundingBox)
  {
    init(paramBoundingBox.image, paramBoundingBox.topLeft, paramBoundingBox.bottomLeft, paramBoundingBox.topRight, paramBoundingBox.bottomRight);
  }
  
  private void calculateMinMaxValues()
  {
    if (this.topLeft == null)
    {
      this.topLeft = new ResultPoint(0.0F, this.topRight.getY());
      this.bottomLeft = new ResultPoint(0.0F, this.bottomRight.getY());
    }
    else if (this.topRight == null)
    {
      this.topRight = new ResultPoint(this.image.getWidth() - 1, this.topLeft.getY());
      this.bottomRight = new ResultPoint(this.image.getWidth() - 1, this.bottomLeft.getY());
    }
    this.minX = ((int)Math.min(this.topLeft.getX(), this.bottomLeft.getX()));
    this.maxX = ((int)Math.max(this.topRight.getX(), this.bottomRight.getX()));
    this.minY = ((int)Math.min(this.topLeft.getY(), this.topRight.getY()));
    this.maxY = ((int)Math.max(this.bottomLeft.getY(), this.bottomRight.getY()));
  }
  
  private void init(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    this.image = paramBitMatrix;
    this.topLeft = paramResultPoint1;
    this.bottomLeft = paramResultPoint2;
    this.topRight = paramResultPoint3;
    this.bottomRight = paramResultPoint4;
    calculateMinMaxValues();
  }
  
  static BoundingBox merge(BoundingBox paramBoundingBox1, BoundingBox paramBoundingBox2)
    throws NotFoundException
  {
    if (paramBoundingBox1 == null) {
      return paramBoundingBox2;
    }
    if (paramBoundingBox2 == null) {
      return paramBoundingBox1;
    }
    return new BoundingBox(paramBoundingBox1.image, paramBoundingBox1.topLeft, paramBoundingBox1.bottomLeft, paramBoundingBox2.topRight, paramBoundingBox2.bottomRight);
  }
  
  BoundingBox addMissingRows(int paramInt1, int paramInt2, boolean paramBoolean)
    throws NotFoundException
  {
    Object localObject1 = this.topLeft;
    Object localObject2 = this.bottomLeft;
    ResultPoint localResultPoint2 = this.topRight;
    Object localObject4 = this.bottomRight;
    if (paramInt1 > 0)
    {
      if (paramBoolean) {
        localObject3 = this.topLeft;
      } else {
        localObject3 = this.topRight;
      }
      int i = (int)((ResultPoint)localObject3).getY() - paramInt1;
      paramInt1 = i;
      if (i < 0) {
        paramInt1 = 0;
      }
      localResultPoint1 = new ResultPoint(((ResultPoint)localObject3).getX(), paramInt1);
      if (paramBoolean)
      {
        localObject1 = localResultPoint1;
      }
      else
      {
        localObject3 = localObject1;
        break label109;
      }
    }
    ResultPoint localResultPoint1 = localResultPoint2;
    Object localObject3 = localObject1;
    label109:
    if (paramInt2 > 0)
    {
      if (paramBoolean) {
        localObject1 = this.bottomLeft;
      } else {
        localObject1 = this.bottomRight;
      }
      paramInt2 = (int)((ResultPoint)localObject1).getY() + paramInt2;
      paramInt1 = paramInt2;
      if (paramInt2 >= this.image.getHeight()) {
        paramInt1 = this.image.getHeight() - 1;
      }
      localObject1 = new ResultPoint(((ResultPoint)localObject1).getX(), paramInt1);
      if (!paramBoolean)
      {
        localObject4 = localObject1;
        break label202;
      }
    }
    else
    {
      localObject1 = localObject2;
    }
    localObject2 = localObject1;
    label202:
    calculateMinMaxValues();
    return new BoundingBox(this.image, (ResultPoint)localObject3, (ResultPoint)localObject2, localResultPoint1, (ResultPoint)localObject4);
  }
  
  ResultPoint getBottomLeft()
  {
    return this.bottomLeft;
  }
  
  ResultPoint getBottomRight()
  {
    return this.bottomRight;
  }
  
  int getMaxX()
  {
    return this.maxX;
  }
  
  int getMaxY()
  {
    return this.maxY;
  }
  
  int getMinX()
  {
    return this.minX;
  }
  
  int getMinY()
  {
    return this.minY;
  }
  
  ResultPoint getTopLeft()
  {
    return this.topLeft;
  }
  
  ResultPoint getTopRight()
  {
    return this.topRight;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\BoundingBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */