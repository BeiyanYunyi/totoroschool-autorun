package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;

public class dr
{
  private static boolean a = new File("/system/framework/amap.jar").exists();
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static AssetManager a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getAssets();
    if (a) {
      try
      {
        paramContext.getClass().getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(paramContext, new Object[] { "/system/framework/amap.jar" });
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "ResourcesUtil", "getSelfAssets");
      }
    }
    return paramContext;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */