package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.fl;
import com.amap.api.mapcore.util.fr;
import com.amap.api.mapcore.util.lq;

public final class MapsInitializer
{
  public static final int HTTP = 1;
  public static final int HTTPS = 2;
  private static boolean a = true;
  private static boolean b = true;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = true;
  private static int f = 1;
  public static String sdcardDir = "";
  
  public static void closeTileOverlay(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static boolean getNetWorkEnable()
  {
    return a;
  }
  
  public static int getProtocol()
  {
    return f;
  }
  
  public static boolean getTextureViewDestorySync()
  {
    return e;
  }
  
  public static String getVersion()
  {
    return "7.1.0";
  }
  
  public static void initialize(Context paramContext)
    throws RemoteException
  {
    if (paramContext != null)
    {
      lq.a = paramContext.getApplicationContext();
      return;
    }
    Log.w("MapsInitializer", "the context is null");
  }
  
  public static boolean isDownloadCoordinateConvertLibrary()
  {
    return b;
  }
  
  public static boolean isLoadWorldGridMap()
  {
    return c;
  }
  
  public static boolean isTileOverlayClosed()
  {
    return d;
  }
  
  public static void loadWorldGridMap(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static void setApiKey(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      fl.a(lq.a, paramString);
    }
  }
  
  public static void setBuildingHeight(int paramInt) {}
  
  public static void setDownloadCoordinateConvertLibrary(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void setHost(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.amap.api.mapcore.util.hx.a = -1;
      com.amap.api.mapcore.util.hx.b = "";
      return;
    }
    com.amap.api.mapcore.util.hx.a = 1;
    com.amap.api.mapcore.util.hx.b = paramString;
  }
  
  public static void setNetWorkEnable(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void setProtocol(int paramInt)
  {
    f = paramInt;
    fr localfr = fr.a();
    boolean bool;
    if (f == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localfr.a(bool);
  }
  
  public static void setTextureViewDestorySync(boolean paramBoolean)
  {
    e = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */