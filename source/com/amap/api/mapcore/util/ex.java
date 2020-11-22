package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ex
  extends ev<List<TraceLocation>, List<LatLng>>
  implements Runnable
{
  private List<TraceLocation> h;
  private Handler i = null;
  private int j = 0;
  private int k = 0;
  private String l;
  
  public ex(Context paramContext, Handler paramHandler, List<TraceLocation> paramList, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramContext, paramList);
    this.h = paramList;
    this.i = paramHandler;
    this.k = paramInt2;
    this.j = paramInt3;
    this.l = paramString;
  }
  
  protected List<LatLng> a(String paramString)
    throws et
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("data")) {
          return localArrayList;
        }
        paramString = paramString.optJSONObject("data").optJSONArray("points");
        if (paramString != null)
        {
          if (paramString.length() != 0) {
            break label125;
          }
          return localArrayList;
          if (m < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(m);
            localArrayList.add(new LatLng(Double.parseDouble(localJSONObject.optString("y")), Double.parseDouble(localJSONObject.optString("x"))));
            m += 1;
            continue;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return localArrayList;
      label125:
      int m = 0;
    }
  }
  
  protected String e()
  {
    JSONArray localJSONArray = new JSONArray();
    int m = 0;
    long l2 = 0L;
    TraceLocation localTraceLocation;
    Object localObject;
    long l1;
    if (m < this.h.size())
    {
      localTraceLocation = (TraceLocation)this.h.get(m);
      localObject = new JSONObject();
      l1 = l2;
    }
    for (;;)
    {
      long l4;
      long l3;
      try
      {
        ((JSONObject)localObject).put("x", localTraceLocation.getLongitude());
        l1 = l2;
        ((JSONObject)localObject).put("y", localTraceLocation.getLatitude());
        l1 = l2;
        ((JSONObject)localObject).put("ag", (int)localTraceLocation.getBearing());
        l1 = l2;
        l4 = localTraceLocation.getTime();
        if (m != 0) {
          break label306;
        }
        l3 = l4;
        if (l4 == 0L)
        {
          l1 = l2;
          l3 = (System.currentTimeMillis() - 10000L) / 1000L;
        }
        l1 = l2;
        ((JSONObject)localObject).put("tm", l3 / 1000L);
        l2 = l3;
        continue;
        l1 = l2;
        ((JSONObject)localObject).put("tm", l3 / 1000L);
        l2 = l4;
        continue;
        l1 = l2;
        ((JSONObject)localObject).put("tm", 1);
        l2 = l4;
        l1 = l2;
        ((JSONObject)localObject).put("sp", (int)localTraceLocation.getSpeed());
        l1 = l2;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localJSONArray.put(localObject);
      m += 1;
      l2 = l1;
      break;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getURL());
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(localJSONArray.toString());
      this.g = ((StringBuilder)localObject).toString();
      return localJSONArray.toString();
      label306:
      if (l4 != 0L)
      {
        l3 = l4 - l2;
        if (l3 >= 1000L) {}
      }
    }
  }
  
  public String getURL()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key=");
    ((StringBuilder)localObject1).append(fk.f(this.f));
    localObject1 = ((StringBuilder)localObject1).toString();
    String str = fn.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&ts=");
    ((StringBuilder)localObject2).append(str);
    localObject2 = ((StringBuilder)localObject2).toString();
    str = fn.a(this.f, str, (String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&scode=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://restapi.amap.com/v4/grasproad/driving?");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    new ArrayList();
    try
    {
      List localList = (List)a();
      fe.a().a(this.l, this.j, localList);
      fe.a().a(this.l).a(this.i);
      return;
    }
    catch (et localet)
    {
      fe.a().a(this.i, this.k, localet.a());
      return;
      localet.printStackTrace();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */