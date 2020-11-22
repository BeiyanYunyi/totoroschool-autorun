package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class al
  extends bd<String, List<OfflineMapProvince>>
{
  private Context d;
  
  public al(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("015");
    return localStringBuilder.toString();
  }
  
  protected List<OfflineMapProvince> a(JSONObject paramJSONObject)
    throws AMapException
  {
    try
    {
      if (this.d != null) {
        bc.c(paramJSONObject.toString(), this.d);
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
      localThrowable.printStackTrace();
    }
    try
    {
      if (this.d != null)
      {
        paramJSONObject = bc.a(paramJSONObject, this.d);
        return paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      gk.c(paramJSONObject, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  protected JSONObject a(fl.a parama)
  {
    if ((parama != null) && (parama.w != null))
    {
      parama = parama.w.optJSONObject("015");
      if (!parama.has("result"))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("result", new JSONObject().put("offlinemap_with_province_vfour", parama));
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return parama;
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
  }
  
  protected Map<String, String> b()
  {
    Hashtable localHashtable = new Hashtable(16);
    localHashtable.put("mapver", this.a);
    return localHashtable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */