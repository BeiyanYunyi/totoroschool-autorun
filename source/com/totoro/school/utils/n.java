package com.totoro.school.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class n
{
  public static void a(Context paramContext, String paramString, Object paramObject)
  {
    paramContext = paramContext.getSharedPreferences("totoro_school_share_data", 0).edit();
    if ((paramObject instanceof String)) {
      paramContext.putString(paramString, (String)paramObject);
    } else if ((paramObject instanceof Integer)) {
      paramContext.putInt(paramString, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof Boolean)) {
      paramContext.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    } else if ((paramObject instanceof Float)) {
      paramContext.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if ((paramObject instanceof Long)) {
      paramContext.putLong(paramString, ((Long)paramObject).longValue());
    } else {
      paramContext.putString(paramString, paramObject.toString());
    }
    a.a(paramContext);
  }
  
  public static Object b(Context paramContext, String paramString, Object paramObject)
  {
    paramContext = paramContext.getSharedPreferences("totoro_school_share_data", 0);
    if ((paramObject instanceof String)) {
      return paramContext.getString(paramString, (String)paramObject);
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(paramContext.getInt(paramString, ((Integer)paramObject).intValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(paramContext.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(paramContext.getFloat(paramString, ((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(paramContext.getLong(paramString, ((Long)paramObject).longValue()));
    }
    return null;
  }
  
  private static class a
  {
    private static final Method a = ;
    
    private static Method a()
    {
      try
      {
        Method localMethod = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public static void a(SharedPreferences.Editor paramEditor)
    {
      try
      {
        if (a != null)
        {
          a.invoke(paramEditor, new Object[0]);
          return;
        }
      }
      catch (IllegalArgumentException|IllegalAccessException|InvocationTargetException localIllegalArgumentException)
      {
        for (;;) {}
      }
      paramEditor.commit();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */