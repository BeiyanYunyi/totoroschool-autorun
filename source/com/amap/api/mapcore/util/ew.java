package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ew
{
  private static String[] a = { "com.amap.api.trace", "com.amap.api.trace.core" };
  
  public static int a(List<LatLng> paramList)
  {
    int j = 0;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 0;
      }
      int i = 0;
      while (j < paramList.size() - 1)
      {
        LatLng localLatLng1 = (LatLng)paramList.get(j);
        j += 1;
        LatLng localLatLng2 = (LatLng)paramList.get(j);
        if (localLatLng1 != null)
        {
          if (localLatLng2 == null) {
            return i;
          }
          i = (int)(i + AMapUtils.calculateLineDistance(localLatLng1, localLatLng2));
        }
        else
        {
          return i;
        }
      }
      return i;
    }
    return 0;
  }
  
  protected static void a(int paramInt, String paramString1, String paramString2)
    throws et
  {
    if (paramInt != 0) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            throw new et(paramString1);
          case 30003: 
            throw new et("读取服务结果超时");
          case 30002: 
            throw new et("服务端请求链接超时");
          case 30001: 
            throw new et("引擎返回数据异常");
          }
          throw new et("请求服务响应错误");
        case 20003: 
          throw new et("其他未知错误");
        case 20002: 
          throw new et("请求协议非法");
        case 20001: 
          throw new et("缺少必填参数");
        }
        throw new et("请求参数非法");
      case 10013: 
        throw new et("开发者删除了key，key被删除后无法正常使用");
      case 10012: 
        throw new et("权限不足，服务请求被拒绝");
      case 10011: 
        throw new et("服务不支持https请求");
      case 10010: 
        throw new et("IP访问超限");
      case 10009: 
        throw new et("请求key与绑定平台不符");
      case 10008: 
        throw new et("用户MD5安全码未通过");
      case 10007: 
        throw new et("用户签名未通过");
      case 10006: 
        throw new et("用户域名无效");
      case 10005: 
        throw new et("用户IP无效");
      case 10004: 
        throw new et("用户访问过于频繁");
      case 10003: 
        throw new et("访问已超出日访问量");
      case 10002: 
        throw new et("请求服务不存在");
      case 10001: 
        throw new et("用户key不正确或过期");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
    throws et
  {
    try
    {
      Object localObject = new JSONObject(paramString1);
      if (((JSONObject)localObject).has("errcode"))
      {
        a(((JSONObject)localObject).getInt("errcode"), ((JSONObject)localObject).getString("errmsg"), paramString2);
        return;
      }
      if (((JSONObject)localObject).has("status"))
      {
        if (!((JSONObject)localObject).has("infocode")) {
          return;
        }
        paramString1 = ((JSONObject)localObject).getString("status");
        int i = ((JSONObject)localObject).getInt("infocode");
        if ("1".equals(paramString1)) {
          return;
        }
        localObject = ((JSONObject)localObject).getString("info");
        if ("0".equals(paramString1))
        {
          a(i, (String)localObject, paramString2);
          return;
        }
        return;
      }
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    throw new et("协议解析错误 - ProtocolException");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */