package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

public class ag
  extends bd<String, af>
{
  public ag(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected af a(JSONObject paramJSONObject)
    throws AMapException
  {
    af localaf = new af();
    try
    {
      String str = paramJSONObject.optString("update", "");
      if (str.equals("0")) {
        localaf.a(false);
      } else if (str.equals("1")) {
        localaf.a(true);
      }
      localaf.a(paramJSONObject.optString("version", ""));
      return localaf;
    }
    catch (Throwable paramJSONObject)
    {
      gk.c(paramJSONObject, "OfflineInitHandlerAbstract", "loadData parseJson");
    }
    return localaf;
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("016");
    return localStringBuilder.toString();
  }
  
  protected JSONObject a(fl.a parama)
  {
    if ((parama != null) && (parama.w != null)) {
      return parama.w.optJSONObject("016");
    }
    return null;
  }
  
  protected Map<String, String> b()
  {
    Hashtable localHashtable = new Hashtable(16);
    localHashtable.put("mapver", this.a);
    return localHashtable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */