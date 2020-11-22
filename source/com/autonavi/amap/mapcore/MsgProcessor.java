package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.mapcore.util.hm;

public class MsgProcessor
{
  private static hm mDelegate = new hm();
  
  public static native int nativeInit(Context paramContext);
  
  public static void nativeInitInfo(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    mDelegate.a(paramContext, paramBoolean, paramString1, paramString2, paramString3, paramArrayOfString);
    nativeInit(paramContext);
  }
  
  public static void nativeMsgProcessor(String paramString1, String paramString2)
  {
    mDelegate.a(paramString1, paramString2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\MsgProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */