package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class dn
{
  public static Long a(Context paramContext, String paramString1, String paramString2, Long paramLong)
  {
    paramContext = b(paramContext, paramString1, paramString2, paramLong);
    if (paramContext != null) {
      return (Long)paramContext;
    }
    return paramLong;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = b(paramContext, paramString1, paramString2, paramString3);
    if (paramContext != null) {
      return (String)paramContext;
    }
    return paramString3;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramObject instanceof String)) {
      paramContext.putString(paramString2, (String)paramObject);
    } else if ((paramObject instanceof Integer)) {
      paramContext.putInt(paramString2, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof Boolean)) {
      paramContext.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
    } else if ((paramObject instanceof Float)) {
      paramContext.putFloat(paramString2, ((Float)paramObject).floatValue());
    } else if ((paramObject instanceof Long)) {
      paramContext.putLong(paramString2, ((Long)paramObject).longValue());
    } else {
      paramContext.putString(paramString2, paramObject.toString());
    }
    paramContext.apply();
  }
  
  private static Object b(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0);
    if ((paramObject instanceof String)) {
      return paramContext.getString(paramString2, (String)paramObject);
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(paramContext.getInt(paramString2, ((Integer)paramObject).intValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(paramContext.getBoolean(paramString2, ((Boolean)paramObject).booleanValue()));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(paramContext.getFloat(paramString2, ((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(paramContext.getLong(paramString2, ((Long)paramObject).longValue()));
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */