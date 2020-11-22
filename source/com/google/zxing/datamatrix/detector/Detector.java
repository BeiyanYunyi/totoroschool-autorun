package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Detector
{
  private final BitMatrix image;
  private final WhiteRectangleDetector rectangleDetector;
  
  public Detector(BitMatrix paramBitMatrix)
    throws NotFoundException
  {
    this.image = paramBitMatrix;
    this.rectangleDetector = new WhiteRectangleDetector(paramBitMatrix);
  }
  
  private ResultPoint correctTopRight(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f2 = distance(paramResultPoint1, paramResultPoint2);
    float f1 = paramInt;
    f2 /= f1;
    paramInt = distance(paramResultPoint3, paramResultPoint4);
    float f4 = paramResultPoint4.getX();
    float f5 = paramResultPoint3.getX();
    float f3 = paramInt;
    f4 = (f4 - f5) / f3;
    f3 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / f3;
    ResultPoint localResultPoint = new ResultPoint(paramResultPoint4.getX() + f4 * f2, paramResultPoint4.getY() + f2 * f3);
    f1 = distance(paramResultPoint1, paramResultPoint3) / f1;
    paramInt = distance(paramResultPoint2, paramResultPoint4);
    f3 = paramResultPoint4.getX();
    f4 = paramResultPoint2.getX();
    f2 = paramInt;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / f2;
    paramResultPoint4 = new ResultPoint(paramResultPoint4.getX() + f3 * f1, paramResultPoint4.getY() + f1 * f2);
    if (!isValid(localResultPoint))
    {
      if (isValid(paramResultPoint4)) {
        return paramResultPoint4;
      }
      return null;
    }
    if (!isValid(paramResultPoint4)) {
      return localResultPoint;
    }
    paramResultPoint1 = paramResultPoint4;
    if (Math.abs(transitionsBetween(paramResultPoint3, localResultPoint).getTransitions() - transitionsBetween(paramResultPoint2, localResultPoint).getTransitions()) <= Math.abs(transitionsBetween(paramResultPoint3, paramResultPoint4).getTransitions() - transitionsBetween(paramResultPoint2, paramResultPoint4).getTransitions())) {
      paramResultPoint1 = localResultPoint;
    }
    return paramResultPoint1;
  }
  
  private ResultPoint correctTopRightRectangular(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    float f1 = distance(paramResultPoint1, paramResultPoint2) / paramInt1;
    int i = distance(paramResultPoint3, paramResultPoint4);
    float f3 = paramResultPoint4.getX();
    float f4 = paramResultPoint3.getX();
    float f2 = i;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / f2;
    ResultPoint localResultPoint = new ResultPoint(paramResultPoint4.getX() + f3 * f1, paramResultPoint4.getY() + f1 * f2);
    f1 = distance(paramResultPoint1, paramResultPoint3) / paramInt2;
    i = distance(paramResultPoint2, paramResultPoint4);
    f3 = paramResultPoint4.getX();
    f4 = paramResultPoint2.getX();
    f2 = i;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / f2;
    paramResultPoint1 = new ResultPoint(paramResultPoint4.getX() + f3 * f1, paramResultPoint4.getY() + f1 * f2);
    if (!isValid(localResultPoint))
    {
      if (isValid(paramResultPoint1)) {
        return paramResultPoint1;
      }
      return null;
    }
    if (!isValid(paramResultPoint1)) {
      return localResultPoint;
    }
    if (Math.abs(paramInt1 - transitionsBetween(paramResultPoint3, localResultPoint).getTransitions()) + Math.abs(paramInt2 - transitionsBetween(paramResultPoint2, localResultPoint).getTransitions()) <= Math.abs(paramInt1 - transitionsBetween(paramResultPoint3, paramResultPoint1).getTransitions()) + Math.abs(paramInt2 - transitionsBetween(paramResultPoint2, paramResultPoint1).getTransitions())) {
      return localResultPoint;
    }
    return paramResultPoint1;
  }
  
  private static int distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint2));
  }
  
  private static void increment(Map<ResultPoint, Integer> paramMap, ResultPoint paramResultPoint)
  {
    Integer localInteger = (Integer)paramMap.get(paramResultPoint);
    int i = 1;
    if (localInteger != null) {
      i = 1 + localInteger.intValue();
    }
    paramMap.put(paramResultPoint, Integer.valueOf(i));
  }
  
  private boolean isValid(ResultPoint paramResultPoint)
  {
    return (paramResultPoint.getX() >= 0.0F) && (paramResultPoint.getX() < this.image.getWidth()) && (paramResultPoint.getY() > 0.0F) && (paramResultPoint.getY() < this.image.getHeight());
  }
  
  private static BitMatrix sampleGrid(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
    throws NotFoundException
  {
    GridSampler localGridSampler = GridSampler.getInstance();
    float f1 = paramInt1 - 0.5F;
    float f2 = paramInt2 - 0.5F;
    return localGridSampler.sampleGrid(paramBitMatrix, paramInt1, paramInt2, 0.5F, 0.5F, f1, 0.5F, f1, f2, 0.5F, f2, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint4.getX(), paramResultPoint4.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }
  
  private ResultPointsAndTransitions transitionsBetween(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    int i4 = (int)paramResultPoint1.getX();
    int n = (int)paramResultPoint1.getY();
    int m = (int)paramResultPoint2.getX();
    int k = (int)paramResultPoint2.getY();
    int i = Math.abs(k - n);
    int j = Math.abs(m - i4);
    int i6 = 0;
    int i5 = 1;
    int i1;
    if (i > j) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    i = i4;
    j = n;
    int i3 = m;
    int i2 = k;
    if (i1 != 0)
    {
      j = i4;
      i = n;
      i2 = m;
      i3 = k;
    }
    int i7 = Math.abs(i3 - i);
    int i8 = Math.abs(i2 - j);
    n = -i7 / 2;
    if (j < i2) {
      i4 = 1;
    } else {
      i4 = -1;
    }
    if (i >= i3) {
      i5 = -1;
    }
    BitMatrix localBitMatrix = this.image;
    if (i1 != 0) {
      k = j;
    } else {
      k = i;
    }
    if (i1 != 0) {
      m = i;
    } else {
      m = j;
    }
    boolean bool1 = localBitMatrix.get(k, m);
    k = i6;
    for (;;)
    {
      m = k;
      if (i == i3) {
        break;
      }
      localBitMatrix = this.image;
      if (i1 != 0) {
        m = j;
      } else {
        m = i;
      }
      if (i1 != 0) {
        i6 = i;
      } else {
        i6 = j;
      }
      boolean bool3 = localBitMatrix.get(m, i6);
      m = k;
      boolean bool2 = bool1;
      if (bool3 != bool1)
      {
        m = k + 1;
        bool2 = bool3;
      }
      i6 = n + i8;
      k = j;
      n = i6;
      if (i6 > 0)
      {
        if (j == i2) {
          break;
        }
        k = j + i4;
        n = i6 - i7;
      }
      i += i5;
      j = k;
      k = m;
      bool1 = bool2;
    }
    return new ResultPointsAndTransitions(paramResultPoint1, paramResultPoint2, m, null);
  }
  
  public DetectorResult detect()
    throws NotFoundException
  {
    Object localObject1 = this.rectangleDetector.detect();
    ResultPoint localResultPoint1 = localObject1[0];
    ResultPoint localResultPoint2 = localObject1[1];
    ResultPoint localResultPoint3 = localObject1[2];
    ResultPoint localResultPoint4 = localObject1[3];
    Object localObject2 = new ArrayList(4);
    ((List)localObject2).add(transitionsBetween(localResultPoint1, localResultPoint2));
    ((List)localObject2).add(transitionsBetween(localResultPoint1, localResultPoint3));
    ((List)localObject2).add(transitionsBetween(localResultPoint2, localResultPoint4));
    ((List)localObject2).add(transitionsBetween(localResultPoint3, localResultPoint4));
    Object localObject3 = null;
    Collections.sort((List)localObject2, new ResultPointsAndTransitionsComparator(null));
    localObject1 = (ResultPointsAndTransitions)((List)localObject2).get(0);
    localObject2 = (ResultPointsAndTransitions)((List)localObject2).get(1);
    HashMap localHashMap = new HashMap();
    increment(localHashMap, ((ResultPointsAndTransitions)localObject1).getFrom());
    increment(localHashMap, ((ResultPointsAndTransitions)localObject1).getTo());
    increment(localHashMap, ((ResultPointsAndTransitions)localObject2).getFrom());
    increment(localHashMap, ((ResultPointsAndTransitions)localObject2).getTo());
    Iterator localIterator = localHashMap.entrySet().iterator();
    Object localObject4 = null;
    localObject2 = localObject4;
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localObject1 = (ResultPoint)localEntry.getKey();
      if (((Integer)localEntry.getValue()).intValue() == 2) {
        localObject4 = localObject1;
      } else if (localObject3 == null) {
        localObject3 = localObject1;
      } else {
        localObject2 = localObject1;
      }
    }
    if ((localObject3 != null) && (localObject4 != null) && (localObject2 != null))
    {
      localObject1 = new ResultPoint[3];
      localObject1[0] = localObject3;
      localObject1[1] = localObject4;
      localObject1[2] = localObject2;
      ResultPoint.orderBestPatterns((ResultPoint[])localObject1);
      localIterator = localObject1[0];
      localEntry = localObject1[1];
      localObject3 = localObject1[2];
      if (!localHashMap.containsKey(localResultPoint1)) {
        localObject1 = localResultPoint1;
      } else if (!localHashMap.containsKey(localResultPoint2)) {
        localObject1 = localResultPoint2;
      } else if (!localHashMap.containsKey(localResultPoint3)) {
        localObject1 = localResultPoint3;
      } else {
        localObject1 = localResultPoint4;
      }
      int k = transitionsBetween((ResultPoint)localObject3, (ResultPoint)localObject1).getTransitions();
      int j = transitionsBetween(localIterator, (ResultPoint)localObject1).getTransitions();
      int i = k;
      if ((k & 0x1) == 1) {
        i = k + 1;
      }
      k = i + 2;
      i = j;
      if ((j & 0x1) == 1) {
        i = j + 1;
      }
      i += 2;
      if ((k * 4 < i * 7) && (i * 4 < k * 7))
      {
        localObject4 = correctTopRight(localEntry, localIterator, (ResultPoint)localObject3, (ResultPoint)localObject1, Math.min(i, k));
        localObject2 = localObject4;
        if (localObject4 == null) {
          localObject2 = localObject1;
        }
        j = Math.max(transitionsBetween((ResultPoint)localObject3, (ResultPoint)localObject2).getTransitions(), transitionsBetween(localIterator, (ResultPoint)localObject2).getTransitions()) + 1;
        i = j;
        if ((j & 0x1) == 1) {
          i = j + 1;
        }
        localObject1 = sampleGrid(this.image, (ResultPoint)localObject3, localEntry, localIterator, (ResultPoint)localObject2, i, i);
      }
      else
      {
        localObject4 = localObject3;
        localResultPoint1 = correctTopRightRectangular(localEntry, localIterator, (ResultPoint)localObject3, (ResultPoint)localObject1, k, i);
        localObject2 = localResultPoint1;
        if (localResultPoint1 == null) {
          localObject2 = localObject1;
        }
        j = transitionsBetween((ResultPoint)localObject4, (ResultPoint)localObject2).getTransitions();
        k = transitionsBetween(localIterator, (ResultPoint)localObject2).getTransitions();
        i = j;
        if ((j & 0x1) == 1) {
          i = j + 1;
        }
        j = k;
        if ((k & 0x1) == 1) {
          j = k + 1;
        }
        localObject1 = sampleGrid(this.image, (ResultPoint)localObject4, localEntry, localIterator, (ResultPoint)localObject2, i, j);
      }
      return new DetectorResult((BitMatrix)localObject1, new ResultPoint[] { localObject3, localEntry, localIterator, localObject2 });
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static final class ResultPointsAndTransitions
  {
    private final ResultPoint from;
    private final ResultPoint to;
    private final int transitions;
    
    private ResultPointsAndTransitions(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt)
    {
      this.from = paramResultPoint1;
      this.to = paramResultPoint2;
      this.transitions = paramInt;
    }
    
    ResultPoint getFrom()
    {
      return this.from;
    }
    
    ResultPoint getTo()
    {
      return this.to;
    }
    
    public int getTransitions()
    {
      return this.transitions;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.from);
      localStringBuilder.append("/");
      localStringBuilder.append(this.to);
      localStringBuilder.append('/');
      localStringBuilder.append(this.transitions);
      return localStringBuilder.toString();
    }
  }
  
  private static final class ResultPointsAndTransitionsComparator
    implements Serializable, Comparator<Detector.ResultPointsAndTransitions>
  {
    public int compare(Detector.ResultPointsAndTransitions paramResultPointsAndTransitions1, Detector.ResultPointsAndTransitions paramResultPointsAndTransitions2)
    {
      return paramResultPointsAndTransitions1.getTransitions() - paramResultPointsAndTransitions2.getTransitions();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */