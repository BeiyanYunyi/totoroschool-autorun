package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.mapcore.util.dx;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpatialRelationUtil
{
  public static final int A_CIRCLE_DEGREE = 360;
  public static final int A_HALF_CIRCLE_DEGREE = 180;
  public static final int MIN_OFFSET_DEGREE = 50;
  public static final int MIN_POLYLINE_POINT_SIZE = 2;
  
  public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> paramList, LatLng paramLatLng)
  {
    if ((paramList != null) && (paramLatLng != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramList.size() == 0) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          LatLng localLatLng = (LatLng)paramList.next();
          localArrayList.add(DPoint.obtain(localLatLng.latitude, localLatLng.longitude));
          if (!localLatLng.equals(paramLatLng)) {
            break label168;
          }
          return new Pair(Integer.valueOf(i), paramLatLng);
        }
        paramList = calShortestDistancePoint(localArrayList, DPoint.obtain(paramLatLng.latitude, paramLatLng.longitude));
        if (paramList != null)
        {
          paramList = new Pair(paramList.first, new LatLng(((DPoint)paramList.second).x, ((DPoint)paramList.second).y));
          return paramList;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return null;
      return null;
      label168:
      i += 1;
    }
  }
  
  public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> paramList, LatLng paramLatLng, float paramFloat, double paramDouble)
  {
    if ((paramList != null) && (paramLatLng != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramList.size() == 0) {
          return null;
        }
        Object localObject = new ArrayList();
        i = 0;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          LatLng localLatLng = (LatLng)paramList.next();
          ((List)localObject).add(DPoint.obtain(localLatLng.latitude, localLatLng.longitude));
          if (!localLatLng.equals(paramLatLng)) {
            break label210;
          }
          return new Pair(Integer.valueOf(i), paramLatLng);
        }
        paramList = calShortestDistancePoint((List)localObject, DPoint.obtain(paramLatLng.latitude, paramLatLng.longitude), paramFloat);
        if (paramList != null)
        {
          localObject = (DPoint)paramList.second;
          if (AMapUtils.calculateLineDistance(new LatLng(((DPoint)localObject).x, ((DPoint)localObject).y), paramLatLng) < paramDouble)
          {
            paramList = new Pair(paramList.first, new LatLng(((DPoint)paramList.second).x, ((DPoint)paramList.second).y));
            return paramList;
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return null;
      return null;
      label210:
      i += 1;
    }
  }
  
  public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> paramList, DPoint paramDPoint)
  {
    return calShortestDistancePoint(paramList, paramDPoint, -1.0F);
  }
  
  public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> paramList, DPoint paramDPoint, float paramFloat)
  {
    Object localObject1 = paramList;
    if ((localObject1 != null) && (paramDPoint != null))
    {
      if (paramList.size() == 0) {
        return null;
      }
      if (paramList.size() < 2) {
        return null;
      }
      Object localObject2 = (DPoint)((List)localObject1).get(0);
      int k = paramList.size();
      double d1 = 0.0D;
      localObject1 = null;
      int i = 1;
      for (;;)
      {
        DPoint localDPoint2 = paramDPoint;
        int j = k - 1;
        if (i > j) {
          break;
        }
        DPoint localDPoint1 = (DPoint)paramList.get(i);
        if ((i == j) && (localDPoint1.equals(localDPoint2))) {
          return new Pair(Integer.valueOf(i), localDPoint2);
        }
        if (checkRotateIsMatch((DPoint)localObject2, localDPoint1, paramFloat))
        {
          if (localObject2.equals(localDPoint2)) {
            return new Pair(Integer.valueOf(i - 1), localDPoint2);
          }
          double d2 = localDPoint2.x;
          double d3 = localDPoint2.y;
          double d4 = ((DPoint)localObject2).x;
          double d5 = ((DPoint)localObject2).y;
          double d6 = localDPoint1.x;
          j = i;
          localObject2 = pointToSegDist(d2, d3, d4, d5, d6, localDPoint1.y);
          if (localObject1 == null)
          {
            d1 = ((Double)((Pair)localObject2).first).doubleValue();
            localObject1 = new Pair(Integer.valueOf(j - 1), ((Pair)localObject2).second);
          }
          else if (d1 > ((Double)((Pair)localObject2).first).doubleValue())
          {
            d1 = ((Double)((Pair)localObject2).first).doubleValue();
            localObject1 = new Pair(Integer.valueOf(j - 1), ((Pair)localObject2).second);
          }
        }
        i += 1;
        localObject2 = localDPoint1;
      }
      return (Pair<Integer, DPoint>)localObject1;
    }
    return null;
  }
  
  private static boolean checkRotateIsMatch(DPoint paramDPoint1, DPoint paramDPoint2, float paramFloat)
  {
    if (paramFloat == -1.0F) {
      return true;
    }
    if (paramDPoint1 != null)
    {
      if (paramDPoint2 == null) {
        return false;
      }
      float f = Math.abs(dx.a(paramDPoint1, paramDPoint2) + 360.0F - paramFloat) % 360.0F;
      paramFloat = f;
      if (f > 180.0F) {
        paramFloat = 360.0F - f;
      }
      return paramFloat < 50.0F;
    }
    return false;
  }
  
  private static Pair<Double, DPoint> pointToSegDist(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d2 = paramDouble5 - paramDouble3;
    double d4 = paramDouble1 - paramDouble3;
    double d1 = paramDouble6 - paramDouble4;
    double d5 = paramDouble2 - paramDouble4;
    double d3 = d2 * d4 + d1 * d5;
    if (d3 <= 0.0D) {
      return new Pair(Double.valueOf(Math.sqrt(d4 * d4 + d5 * d5)), new DPoint(paramDouble3, paramDouble4));
    }
    d4 = d2 * d2 + d1 * d1;
    if (d3 >= d4)
    {
      paramDouble1 -= paramDouble5;
      paramDouble2 -= paramDouble6;
      return new Pair(Double.valueOf(Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2)), new DPoint(paramDouble5, paramDouble6));
    }
    paramDouble5 = d3 / d4;
    paramDouble3 += d2 * paramDouble5;
    paramDouble4 += d1 * paramDouble5;
    paramDouble1 -= paramDouble3;
    paramDouble2 = paramDouble4 - paramDouble2;
    return new Pair(Double.valueOf(Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2)), new DPoint(paramDouble3, paramDouble4));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\utils\SpatialRelationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */