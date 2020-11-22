package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class du
{
  public static void a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    String str = paramObject.getClass().getSimpleName();
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ("String".equals(str)) {
      paramContext.putString(paramString2, (String)paramObject);
    } else if ("Integer".equals(str)) {
      paramContext.putInt(paramString2, ((Integer)paramObject).intValue());
    } else if ("Boolean".equals(str)) {
      paramContext.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
    } else if ("Float".equals(str)) {
      paramContext.putFloat(paramString2, ((Float)paramObject).floatValue());
    } else if ("Long".equals(str)) {
      paramContext.putLong(paramString2, ((Long)paramObject).longValue());
    }
    paramContext.commit();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */