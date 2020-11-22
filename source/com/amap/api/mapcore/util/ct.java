package com.amap.api.mapcore.util;

import android.text.TextUtils;

public class ct
{
  public static final int[][] a;
  public static final String[] b;
  public static final String[][] c;
  public static final String[] d = { "regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels" };
  
  static
  {
    Object localObject1 = { 1 };
    Object localObject2 = { 13 };
    Object localObject3 = { 39, 40, 41 };
    Object localObject4 = { 29, 30, 31 };
    a = new int[][] { { 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, { 12 }, localObject1, localObject2, { 14 }, { 15, 16 }, { 17, 18, 19, 20, 21, 26, 27, 28 }, { 22, 23 }, { 24, 25 }, localObject3, localObject4, { 32, 33, 34, 35, 36, 37, 38 } };
    b = new String[] { "land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable" };
    localObject1 = new String[] { "water" };
    localObject2 = new String[] { "green" };
    localObject3 = new String[] { "ringRoad", "nationalRoad" };
    localObject4 = new String[] { "China", "foreign", "provincial" };
    String[] arrayOfString1 = { "guideBoards", "pois", "aois" };
    String[] arrayOfString2 = { "continent", "country", "province", "city", "district", "town", "village" };
    c = new String[][] { { "land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway" }, localObject1, localObject2, { "buildings" }, { "highWay" }, localObject3, { "provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other" }, { "railway", "highSpeedRailway" }, { "subwayline", "subwayBeingBuilt" }, localObject4, arrayOfString1, arrayOfString2 };
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= b.length) {
        break;
      }
      if (b[i].equals(paramString))
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0) {
      return c[j];
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= b.length) {
        break;
      }
      if (b[i].equals(paramString))
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0) {
      return d[j];
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */