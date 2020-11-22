package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cu
{
  private static final int[] d = { 1 };
  List<cq> a = null;
  private int b = 0;
  private int c = -1;
  
  public cu(Context paramContext) {}
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Object localObject = paramString;
    try
    {
      if (!paramString.startsWith("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      int i = Color.parseColor((String)localObject);
      return i;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static cr a(byte[] paramArrayOfByte)
  {
    int j;
    int k;
    int i;
    try
    {
      localObject = new cr();
      try
      {
        arrayOfByte1 = "l".getBytes("utf-8");
        j = paramArrayOfByte.length;
        k = arrayOfByte1.length;
        i = 0;
      }
      catch (Throwable localThrowable2)
      {
        byte[] arrayOfByte1;
        byte[] arrayOfByte2;
        paramArrayOfByte = (byte[])localObject;
        localObject = localThrowable2;
        break label127;
      }
      ((cr)localObject).a(Convert.getString(paramArrayOfByte, 0, 4));
      ((cr)localObject).b(Convert.getString(paramArrayOfByte, 4, 32));
      ((cr)localObject).c(Convert.getString(paramArrayOfByte, 36, 10));
      arrayOfByte1 = Convert.getSubBytes(paramArrayOfByte, 46, 16);
      arrayOfByte2 = Convert.getSubBytes(paramArrayOfByte, 62, 16);
      ((cr)localObject).d(a(Convert.getSubBytes(paramArrayOfByte, 78, j - 78), arrayOfByte1, arrayOfByte2));
      return (cr)localObject;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      paramArrayOfByte = null;
    }
    label127:
    localThrowable1.printStackTrace();
    return paramArrayOfByte;
    while (i < j)
    {
      int m = paramArrayOfByte[i];
      paramArrayOfByte[i] = ((byte)(localThrowable2[(i % k)] ^ m));
      i += 1;
    }
  }
  
  private StyleElement a(Map<Integer, StyleItem> paramMap, int paramInt1, int paramInt2, cq paramcq)
  {
    StyleItem localStyleItem2 = (StyleItem)paramMap.get(Integer.valueOf(paramInt1));
    StyleItem localStyleItem1 = localStyleItem2;
    if (localStyleItem2 == null)
    {
      localStyleItem1 = new StyleItem(paramcq.c);
      localStyleItem1.mainKey = paramcq.a;
      localStyleItem1.subKey = paramcq.b;
      paramMap.put(Integer.valueOf(paramInt1), localStyleItem1);
    }
    paramcq = localStyleItem1.get(paramInt2);
    paramMap = paramcq;
    if (paramcq == null)
    {
      paramMap = new StyleElement();
      paramMap.styleElementType = paramInt2;
      localStyleItem1.put(paramInt2, paramMap);
    }
    return paramMap;
  }
  
  public static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      paramArrayOfByte3 = new IvParameterSpec(paramArrayOfByte3);
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/NoPadding");
      localCipher.init(2, paramArrayOfByte2, paramArrayOfByte3);
      paramArrayOfByte1 = new String(localCipher.doFinal(paramArrayOfByte1), "utf-8");
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return null;
  }
  
  private List<cq> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      cq localcq = (cq)localIterator.next();
      if (localcq != null) {
        if ((localcq.e != null) && (localcq.e.equals(paramString2))) {
          localArrayList.add(localcq);
        } else if ((localcq.e != null) && (localcq.e.equals(paramString1)) && (localcq.f != null) && (localcq.f.contains(paramString2))) {
          localArrayList.add(localcq);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(cv paramcv, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.a() != null)) {
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.a());
        JSONArray localJSONArray = paramArrayOfByte.names();
        int i = 0;
        while (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          if ((str == null) || (!str.trim().equals("sdkTextures")))
          {
            Object localObject;
            if ((str != null) && (str.trim().equals("background")))
            {
              str = paramArrayOfByte.optString("background");
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("#");
              ((StringBuilder)localObject).append(str);
              this.b = a(((StringBuilder)localObject).toString());
            }
            else
            {
              localObject = paramArrayOfByte.optJSONObject(str);
              if (localObject != null) {
                a(str, paramcv.a(), (JSONObject)localObject, paramBoolean);
              }
            }
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramcv)
      {
        paramcv.printStackTrace();
      }
    }
  }
  
  private void a(String paramString1, String paramString2, Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.a == null) {
      this.a = b();
    }
    paramString1 = a(paramString1, paramString2);
    paramString2 = paramString1.iterator();
    while (paramString2.hasNext())
    {
      Object localObject = (cq)paramString2.next();
      if (localObject != null)
      {
        if (((cq)localObject).c == 64536) {
          return;
        }
        int i = ((cq)localObject).d;
        if (!paramJSONObject.optBoolean("visible", true))
        {
          localObject = a(paramMap, i, cs.a("visible"), (cq)localObject);
          ((StyleElement)localObject).textureId = -1;
          ((StyleElement)localObject).visible = 0;
        }
        else
        {
          if (!paramJSONObject.optBoolean("showIcon", true)) {
            a(paramMap, i, cs.a("textFillColor"), (cq)localObject).textureId = -1;
          }
          if (!paramJSONObject.optBoolean("showLabel", true))
          {
            a(paramMap, i, cs.a("textFillColor"), (cq)localObject).opacity = 0.0F;
            StyleElement localStyleElement = a(paramMap, i, cs.a("textStrokeColor"), (cq)localObject);
            localStyleElement.opacity = 0.0F;
            localStyleElement.visible = 0;
            localStyleElement.textureId = -1;
          }
          a(paramMap, paramJSONObject, "color", "opacity", i, (cq)localObject);
          a(paramMap, paramJSONObject, "fillColor", "fillOpacity", i, (cq)localObject);
          a(paramMap, paramJSONObject, "strokeColor", "strokeOpacity", i, (cq)localObject);
          a(paramMap, paramJSONObject, "textFillColor", "textFillOpacity", i, (cq)localObject);
          a(paramMap, paramJSONObject, "textStrokeColor", "textStrokeOpacity", i, (cq)localObject);
          a(paramMap, paramJSONObject, "backgroundColor", "backgroundOpacity", i, (cq)localObject);
          if (paramBoolean) {
            a(paramMap, paramJSONObject, "textureName", i, (cq)localObject);
          }
        }
      }
      else
      {
        return;
      }
    }
    paramString1.clear();
  }
  
  private void a(String paramString, Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return;
    }
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("subType");
    if (localJSONObject1 == null)
    {
      a(paramString, paramString, paramMap, paramJSONObject, paramBoolean);
      return;
    }
    paramJSONObject = localJSONObject1.names();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject1 = paramJSONObject.optString(i);
      Object localObject2 = localJSONObject1.optJSONObject((String)localObject1);
      if (((JSONObject)localObject2).has("detailedType"))
      {
        localObject1 = ((JSONObject)localObject2).optJSONObject("detailedType");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).names();
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            String str = ((JSONArray)localObject2).optString(j);
            JSONObject localJSONObject2 = ((JSONObject)localObject1).optJSONObject(str);
            if (localJSONObject2 != null) {
              a(paramString, str, paramMap, localJSONObject2, paramBoolean);
            }
            j += 1;
          }
        }
      }
      else
      {
        a(paramString, (String)localObject1, paramMap, (JSONObject)localObject2, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, int paramInt1, int paramInt2, cq paramcq)
    throws JSONException
  {
    StyleElement localStyleElement = a(paramMap, paramInt1, paramInt2, paramcq);
    paramJSONObject = paramJSONObject.optJSONObject("stylers");
    if (paramJSONObject != null)
    {
      int i = a(paramJSONObject.optString("color"));
      if (i == 0) {
        return;
      }
      localStyleElement.value = i;
      localStyleElement.textureId = paramJSONObject.optInt("textureName", 0);
      localStyleElement.lineWidth = paramJSONObject.optInt("lineWidth", 0);
      if ((paramInt1 >= 30) && (paramInt1 <= 38))
      {
        a(paramMap, paramInt1, 4, paramcq).opacity = 0.1F;
        return;
      }
      if ((paramcq.e != null) && (paramcq.e.equals("water")) && (paramInt2 == 3)) {
        a(paramMap, paramInt1, 2, paramcq).value = i;
      }
    }
  }
  
  private void a(Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, String paramString, int paramInt, cq paramcq)
  {
    try
    {
      int i = paramJSONObject.optInt(paramString, 0);
      if (i == 0) {
        return;
      }
      a(paramMap, paramInt, cs.a(paramString), paramcq).textureId = i;
      return;
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  private void a(Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, String paramString1, String paramString2, int paramInt, cq paramcq)
  {
    float f;
    int i;
    do
    {
      try
      {
        String str = paramJSONObject.optString(paramString1, null);
        f = 1.0F;
        i = 0;
        if (TextUtils.isEmpty(str))
        {
          f = (float)paramJSONObject.optDouble(paramString2, 1.0D);
        }
        else
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("#");
          paramJSONObject.append(str);
          i = a(paramJSONObject.toString());
        }
      }
      catch (Throwable paramMap)
      {
        int j;
        paramMap.printStackTrace();
      }
      j = cs.a(paramString1);
      paramJSONObject = a(paramMap, paramInt, j, paramcq);
      paramJSONObject.value = i;
      paramJSONObject.opacity = f;
      if ((paramcq.f != null) && (paramcq.f.equals("China")))
      {
        a(paramMap, paramInt, j, paramcq).opacity = 0.0F;
        return;
      }
      if ((paramcq.e != null) && (paramcq.e.equals("water")) && (j == 3))
      {
        paramMap = a(paramMap, paramInt, 2, paramcq);
        paramMap.value = i;
        paramMap.opacity = f;
        return;
      }
      return;
    } while ((i != 0) || (f != 1.0D));
  }
  
  private void a(Map<Integer, StyleItem> paramMap, JSONObject paramJSONObject, String paramString, String[] paramArrayOfString, int paramInt)
    throws JSONException
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      Object localObject = paramArrayOfString[i];
      if (this.a == null) {
        this.a = b();
      }
      localObject = a(paramString, (String)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cq localcq = (cq)((Iterator)localObject).next();
        a(paramMap, paramJSONObject, localcq.d, paramInt, localcq);
      }
      i += 1;
    }
  }
  
  private void a(JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3, List<cq> paramList)
  {
    if (paramJSONArray == null) {
      return;
    }
    int k = paramJSONArray.length();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null)
      {
        int m = ((JSONObject)localObject).optInt("mainkey");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("subkey");
        if (localJSONArray != null)
        {
          int n = localJSONArray.length();
          localObject = new int[n];
          int j = 0;
          while (j < n)
          {
            localObject[j] = localJSONArray.optInt(j);
            j += 1;
          }
        }
        else
        {
          localObject = new int[0];
        }
        paramList.add(new cq(m, (int[])localObject, paramString1, paramString2, paramString3));
      }
      i += 1;
    }
  }
  
  private boolean a(Map<Integer, StyleItem> paramMap, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JSONArray(new String(paramArrayOfByte, "UTF-8"));
      int i = 0;
      while (i < paramArrayOfByte.length())
      {
        JSONObject localJSONObject = paramArrayOfByte.optJSONObject(i);
        Object localObject = localJSONObject.optString("featureType");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          int j;
          if ("background".equals(localObject))
          {
            localJSONObject = localJSONObject.optJSONObject("stylers");
            if (localJSONObject != null)
            {
              j = a(localJSONObject.optString("color"));
              if (j != 0) {
                this.b = j;
              }
            }
          }
          else
          {
            String str1 = ct.b((String)localObject);
            if (str1 != null)
            {
              localObject = ct.a((String)localObject);
              if ((localObject != null) && (localObject.length != 0))
              {
                String str2 = localJSONObject.optString("elementType");
                if (!TextUtils.isEmpty(str2))
                {
                  j = cs.a(str2);
                  if (j != -1) {
                    a(paramMap, localJSONObject, str1, (String[])localObject, j);
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
      return false;
    }
    catch (JSONException paramMap) {}
    return false;
  }
  
  private List<cq> b()
  {
    this.a = new ArrayList();
    for (;;)
    {
      Object localObject3;
      int k;
      int n;
      try
      {
        Object localObject1 = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
        if (((JSONArray)localObject1).length() == 0) {
          return this.a;
        }
        localObject1 = ((JSONArray)localObject1).optJSONObject(0);
        if (localObject1 == null) {
          return this.a;
        }
        JSONArray localJSONArray1 = ((JSONObject)localObject1).names();
        int i1 = localJSONArray1.length();
        int i = 0;
        if (i < i1)
        {
          String str2 = localJSONArray1.optString(i);
          Object localObject4 = ((JSONObject)localObject1).optJSONObject(str2);
          if (localObject4 != null)
          {
            String str3 = ((JSONObject)localObject4).optString("name");
            if (((JSONObject)localObject4).has("styleMap"))
            {
              a(((JSONObject)localObject4).optJSONArray("styleMap"), str2, null, str3, this.a);
              localObject3 = localObject1;
            }
            else
            {
              localObject3 = localObject1;
              if (((JSONObject)localObject4).has("subType"))
              {
                JSONObject localJSONObject2 = ((JSONObject)localObject4).optJSONObject("subType");
                if (localJSONObject2 == null) {
                  break label616;
                }
                JSONArray localJSONArray2 = localJSONObject2.names();
                int j = localJSONArray2.length();
                k = 0;
                localObject3 = localObject1;
                if (k < j)
                {
                  String str1 = localJSONArray2.optString(k);
                  Object localObject5 = localJSONObject2.optJSONObject(str1);
                  if (localObject5 == null) {
                    break label632;
                  }
                  localObject4 = ((JSONObject)localObject5).optString("name");
                  if (((JSONObject)localObject5).has("styleMap"))
                  {
                    localObject3 = ((JSONObject)localObject5).optJSONArray("styleMap");
                    localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append(str3);
                    ((StringBuilder)localObject5).append("-");
                    ((StringBuilder)localObject5).append((String)localObject4);
                    a((JSONArray)localObject3, str2, str1, ((StringBuilder)localObject5).toString(), this.a);
                    localObject3 = localObject1;
                    break label628;
                  }
                  localObject3 = localObject1;
                  if (!((JSONObject)localObject5).has("subType")) {
                    break label628;
                  }
                  JSONObject localJSONObject1 = ((JSONObject)localObject5).optJSONObject("subType");
                  if (localJSONObject1 == null)
                  {
                    localObject3 = localObject1;
                    break label628;
                  }
                  localObject5 = localJSONObject1.names();
                  int m = ((JSONArray)localObject5).length();
                  n = 0;
                  localObject3 = localObject1;
                  if (n >= m) {
                    break label628;
                  }
                  String str4 = ((JSONArray)localObject5).optString(n);
                  Object localObject6 = localJSONObject1.optJSONObject(str4);
                  if (localObject6 == null) {
                    break label619;
                  }
                  localObject3 = ((JSONObject)localObject6).optString("name");
                  if (!((JSONObject)localObject6).has("styleMap")) {
                    break label619;
                  }
                  localObject6 = ((JSONObject)localObject6).optJSONArray("styleMap");
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(str1);
                  localStringBuilder.append("-");
                  localStringBuilder.append(str4);
                  str4 = localStringBuilder.toString();
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(str3);
                  localStringBuilder.append("-");
                  localStringBuilder.append((String)localObject4);
                  localStringBuilder.append("-");
                  localStringBuilder.append((String)localObject3);
                  a((JSONArray)localObject6, str2, str4, localStringBuilder.toString(), this.a);
                  break label619;
                }
              }
            }
            localObject1 = localObject3;
            localObject3 = new cq(20021, d, "roads", "trafficRoadBackgroundColor", null);
            this.a.add(localObject3);
            i += 1;
          }
        }
        else
        {
          return this.a;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      label616:
      continue;
      label619:
      n += 1;
      continue;
      label628:
      Object localObject2 = localObject3;
      label632:
      k += 1;
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public cv a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      return b(paramString, paramBoolean);
    }
    return null;
  }
  
  public cv a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return b(paramArrayOfByte, paramBoolean);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  protected void a(cv paramcv)
  {
    if (this.c != -1)
    {
      paramcv = paramcv.a();
      Iterator localIterator = a("roads", "trafficRoadBackgroundColor").iterator();
      while (localIterator.hasNext())
      {
        cq localcq = (cq)localIterator.next();
        a(paramcv, localcq.d, cs.a("fillColor"), localcq).value = this.c;
        a(paramcv, localcq.d, cs.a("strokeColor"), localcq).value = this.c;
      }
    }
  }
  
  public cv b(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = b(FileUtil.readFileContents(paramString), paramBoolean);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public cv b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    cv localcv = new cv();
    try
    {
      if (!a(localcv.a(), paramArrayOfByte)) {
        a(localcv, paramArrayOfByte, paramBoolean);
      }
      a(localcv);
      localcv.b();
      return localcv;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localcv;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */