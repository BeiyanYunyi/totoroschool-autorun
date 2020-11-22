package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GlMapUtil
{
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1 = 2;
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1_EAGLE_EYE = 3;
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2 = 4;
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2_EAGLE_EYE = 5;
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3 = 6;
  public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3_EAGLE_EYE = 7;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1 = 3;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1_EAGLE_EYE = 4;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2 = 5;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2_EAGLE_EYE = 6;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3 = 7;
  public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3_EAGLE_EYE = 8;
  public static final int AN_ENGINE_ID_EAGLE_EYE = 2;
  public static final int AN_ENGINE_ID_INVALID = -1;
  public static final int AN_ENGINE_ID_MAIN = 1;
  public static final int DEVICE_DISPLAY_DPI_HIGH = 320;
  public static final int DEVICE_DISPLAY_DPI_LOW = 120;
  public static final int DEVICE_DISPLAY_DPI_MEDIAN = 240;
  public static final int DEVICE_DISPLAY_DPI_NORMAL = 160;
  public static final int DEVICE_DISPLAY_DPI_XHIGH = 480;
  public static final int DEVICE_DISPLAY_DPI_XXHIGH = 640;
  
  public static byte[] decodeAssetResData(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(paramString);
      paramString = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramContext.read(arrayOfByte);
        if (i <= -1) {
          break;
        }
        paramString.write(arrayOfByte, 0, i);
      }
      arrayOfByte = paramString.toByteArray();
      paramString.close();
      paramContext.close();
      return arrayOfByte;
    }
    catch (IOException paramContext)
    {
      return null;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  public static int dipToPixel(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return paramInt;
    }
    float f = paramInt;
    try
    {
      f = TypedValue.applyDimension(1, f, paramContext.getResources().getDisplayMetrics());
      return (int)f;
    }
    catch (Exception paramContext) {}
    return paramInt;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static String getString(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getString(paramInt);
  }
  
  public static boolean isAssic(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length) {
      if (paramString[i] < 'Ā')
      {
        if (paramString[i] <= 0) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public static int spToPixel(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(2, paramInt, paramContext.getResources().getDisplayMetrics());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\tools\GlMapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */