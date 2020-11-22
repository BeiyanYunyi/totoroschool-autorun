package com.loc;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static long a;
  
  public static int a(String paramString, List<GeoFence> paramList, Bundle paramBundle)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("status", 0);
      int k = paramString.optInt("infocode", 0);
      i = k;
      if (j != 1) {
        break label432;
      }
      paramString = paramString.optJSONArray("pois");
      i = k;
      if (paramString == null) {
        break label432;
      }
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramString.length()) {
          break;
        }
        GeoFence localGeoFence = new GeoFence();
        Object localObject1 = new PoiItem();
        JSONObject localJSONObject = paramString.getJSONObject(j);
        ((PoiItem)localObject1).setPoiId(localJSONObject.optString("id"));
        ((PoiItem)localObject1).setPoiName(localJSONObject.optString("name"));
        ((PoiItem)localObject1).setPoiType(localJSONObject.optString("type"));
        ((PoiItem)localObject1).setTypeCode(localJSONObject.optString("typecode"));
        ((PoiItem)localObject1).setAddress(localJSONObject.optString("address"));
        Object localObject2 = localJSONObject.optString("location");
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split(",");
          ((PoiItem)localObject1).setLongitude(Double.parseDouble(localObject2[0]));
          ((PoiItem)localObject1).setLatitude(Double.parseDouble(localObject2[1]));
          localObject2 = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          DPoint localDPoint = new DPoint(((PoiItem)localObject1).getLatitude(), ((PoiItem)localObject1).getLongitude());
          localArrayList.add(localDPoint);
          ((List)localObject2).add(localArrayList);
          localGeoFence.setPointList((List)localObject2);
          localGeoFence.setCenter(localDPoint);
        }
        ((PoiItem)localObject1).setTel(localJSONObject.optString("tel"));
        ((PoiItem)localObject1).setProvince(localJSONObject.optString("pname"));
        ((PoiItem)localObject1).setCity(localJSONObject.optString("cityname"));
        ((PoiItem)localObject1).setAdname(localJSONObject.optString("adname"));
        localGeoFence.setPoiItem((PoiItem)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a());
        localGeoFence.setFenceId(((StringBuilder)localObject1).toString());
        localGeoFence.setCustomId(paramBundle.getString("customId"));
        localGeoFence.setPendingIntentAction(paramBundle.getString("pendingIntentAction"));
        localGeoFence.setType(2);
        localGeoFence.setRadius(paramBundle.getFloat("fenceRadius"));
        localGeoFence.setExpiration(paramBundle.getLong("expiration"));
        localGeoFence.setActivatesAction(paramBundle.getInt("activatesAction", 1));
        paramList.add(localGeoFence);
        j += 1;
      }
    }
    catch (Throwable paramString)
    {
      int i;
      label432:
      for (;;) {}
    }
    i = 5;
    return i;
  }
  
  public static long a()
  {
    try
    {
      long l = dn.b();
      if (l > a) {
        a = l;
      } else {
        a += 1L;
      }
      l = a;
      return l;
    }
    finally {}
  }
  
  private List<DPoint> a(List<DPoint> paramList, float paramFloat)
  {
    Object localObject2 = paramList;
    if (localObject2 == null) {
      return null;
    }
    if (paramList.size() <= 2) {
      return (List<DPoint>)localObject2;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (DPoint)((List)localObject2).get(0);
    localObject2 = (DPoint)((List)localObject2).get(paramList.size() - 1);
    double d3 = 0.0D;
    int i = 1;
    int j = 0;
    while (i < paramList.size() - 1)
    {
      DPoint localDPoint = (DPoint)paramList.get(i);
      double d4 = localDPoint.getLongitude();
      double d5 = ((DPoint)localObject1).getLongitude();
      double d6 = localDPoint.getLatitude();
      double d7 = ((DPoint)localObject1).getLatitude();
      double d2 = ((DPoint)localObject2).getLongitude() - ((DPoint)localObject1).getLongitude();
      double d1 = ((DPoint)localObject2).getLatitude() - ((DPoint)localObject1).getLatitude();
      d4 = ((d4 - d5) * d2 + (d6 - d7) * d1) / (d2 * d2 + d1 * d1);
      int k;
      if ((((DPoint)localObject1).getLongitude() == ((DPoint)localObject2).getLongitude()) && (((DPoint)localObject1).getLatitude() == ((DPoint)localObject2).getLatitude())) {
        k = 1;
      } else {
        k = 0;
      }
      if ((d4 >= 0.0D) && (k == 0))
      {
        if (d4 > 1.0D)
        {
          d2 = ((DPoint)localObject2).getLongitude();
          d1 = ((DPoint)localObject2).getLatitude();
        }
        else
        {
          d5 = ((DPoint)localObject1).getLongitude();
          d1 = ((DPoint)localObject1).getLatitude() + d4 * d1;
          d2 = d5 + d2 * d4;
        }
      }
      else
      {
        d2 = ((DPoint)localObject1).getLongitude();
        d1 = ((DPoint)localObject1).getLatitude();
      }
      d2 = dn.a(new DPoint(localDPoint.getLatitude(), localDPoint.getLongitude()), new DPoint(d1, d2));
      d1 = d3;
      if (d2 > d3)
      {
        d1 = d2;
        j = i;
      }
      i += 1;
      d3 = d1;
    }
    if (d3 < paramFloat)
    {
      localArrayList.add(localObject1);
      localArrayList.add(localObject2);
      return localArrayList;
    }
    localObject1 = a(paramList.subList(0, j + 1), paramFloat);
    paramList = a(paramList.subList(j, paramList.size()), paramFloat);
    localArrayList.addAll((Collection)localObject1);
    localArrayList.remove(localArrayList.size() - 1);
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public final int b(String paramString, List<GeoFence> paramList, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        k = ((JSONObject)localObject2).optInt("status", 0);
        int j = ((JSONObject)localObject2).optInt("infocode", 0);
        paramString = paramBundle.getString("customId");
        localObject1 = paramBundle.getString("pendingIntentAction");
        f1 = paramBundle.getFloat("fenceRadius");
        l = paramBundle.getLong("expiration");
        i = paramBundle.getInt("activatesAction", 1);
        m = j;
        if (k != 1) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).optJSONArray("districts");
        m = j;
        if (localObject2 == null) {
          continue;
        }
        k = 0;
        paramBundle = (Bundle)localObject1;
        m = j;
        if (k >= ((JSONArray)localObject2).length()) {
          continue;
        }
        localArrayList1 = new ArrayList();
        localArrayList3 = new ArrayList();
        localObject1 = new GeoFence();
        localObject4 = ((JSONArray)localObject2).getJSONObject(k);
        str2 = ((JSONObject)localObject4).optString("citycode");
        str1 = ((JSONObject)localObject4).optString("adcode");
        localObject3 = ((JSONObject)localObject4).optString("name");
        localObject5 = ((JSONObject)localObject4).getString("center");
        localDPoint = new DPoint();
        if (localObject5 == null) {
          continue;
        }
        localObject5 = ((String)localObject5).split(",");
        localDPoint.setLatitude(Double.parseDouble(localObject5[1]));
        localDPoint.setLongitude(Double.parseDouble(localObject5[0]));
        ((GeoFence)localObject1).setCenter(localDPoint);
      }
      catch (Throwable paramString)
      {
        int k;
        Object localObject1;
        float f1;
        long l;
        int i;
        int m;
        ArrayList localArrayList1;
        ArrayList localArrayList3;
        Object localObject4;
        String str2;
        String str1;
        Object localObject3;
        DPoint localDPoint;
        int i1;
        float f3;
        float f2;
        DistrictItem localDistrictItem;
        ArrayList localArrayList2;
        int n;
        Object localObject6;
        String str3;
        continue;
        continue;
        n += 1;
        continue;
        Object localObject5 = localArrayList2;
        continue;
      }
      ((GeoFence)localObject1).setCustomId(paramString);
      ((GeoFence)localObject1).setPendingIntentAction(paramBundle);
      ((GeoFence)localObject1).setType(3);
      ((GeoFence)localObject1).setRadius(f1);
      ((GeoFence)localObject1).setExpiration(l);
      ((GeoFence)localObject1).setActivatesAction(i);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(a());
      ((GeoFence)localObject1).setFenceId(((StringBuilder)localObject5).toString());
      localObject4 = ((JSONObject)localObject4).optString("polyline");
      if (localObject4 != null)
      {
        localObject4 = ((String)localObject4).split("\\|");
        i1 = localObject4.length;
        m = 0;
        f3 = Float.MIN_VALUE;
        f2 = Float.MAX_VALUE;
        if (m < i1)
        {
          localObject5 = localObject4[m];
          localDistrictItem = new DistrictItem();
          localArrayList2 = new ArrayList();
          localDistrictItem.setCitycode(str2);
          localDistrictItem.setAdcode(str1);
          localDistrictItem.setDistrictName((String)localObject3);
          localObject5 = ((String)localObject5).split(";");
          n = 0;
          if (n < localObject5.length)
          {
            localObject6 = localObject5[n].split(",");
            if (localObject6.length <= 1) {
              continue;
            }
            str3 = localObject6[1];
            localObject6 = localObject6[0];
            localArrayList2.add(new DPoint(Double.parseDouble(str3), Double.parseDouble((String)localObject6)));
            continue;
          }
          n = localArrayList2.size();
          if (n <= 100.0F) {
            continue;
          }
        }
      }
      try
      {
        localObject5 = a(localArrayList2, 100.0F);
        localArrayList3.add(localObject5);
        localDistrictItem.setPolyline((List)localObject5);
        localArrayList1.add(localDistrictItem);
        f3 = Math.max(f3, a.b(localDPoint, (List)localObject5));
        f2 = Math.min(f2, a.a(localDPoint, (List)localObject5));
        m += 1;
      }
      catch (Throwable paramString)
      {
        continue;
      }
      localObject3 = paramBundle;
      ((GeoFence)localObject1).setMaxDis2Center(f3);
      ((GeoFence)localObject1).setMinDis2Center(f2);
      ((GeoFence)localObject1).setDistrictItemList(localArrayList1);
      ((GeoFence)localObject1).setPointList(localArrayList3);
      paramList.add(localObject1);
      paramBundle = paramString;
      paramString = (String)localObject3;
      continue;
      localObject1 = paramString;
      paramString = paramBundle;
      paramBundle = (Bundle)localObject1;
      k += 1;
      localObject1 = paramString;
      paramString = paramBundle;
      paramBundle = (Bundle)localObject1;
    }
    return m;
    return 5;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */