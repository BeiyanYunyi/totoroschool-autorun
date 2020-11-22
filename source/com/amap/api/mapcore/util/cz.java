package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;

public class cz
{
  static String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 80)
    {
      localStringBuilder.append("=");
      i += 1;
    }
    a = localStringBuilder.toString();
  }
  
  public static void a()
  {
    b(a);
    b("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
    b(a);
  }
  
  public static void a(Context paramContext)
  {
    b(a);
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key:");
      localStringBuilder.append(fk.f(paramContext));
      a(localStringBuilder.toString());
    }
    b("鉴权失败，当前key没有自定义纹理和在线拉去样式的使用权限，自定义纹理和在线拉去样式相关内容，将不会呈现！");
    b(a);
  }
  
  static void a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (j < 78)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      while (i < 78 - paramString.length())
      {
        ((StringBuilder)localObject).append(" ");
        i += 1;
      }
      ((StringBuilder)localObject).append("|");
      b(((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramString.substring(0, 78);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    b(localStringBuilder.toString());
    a(paramString.substring(78));
  }
  
  private static void b(String paramString)
  {
    Log.i("authErrLog", paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */