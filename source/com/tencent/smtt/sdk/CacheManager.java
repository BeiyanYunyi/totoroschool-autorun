package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.r;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    Object localObject = bt.a();
    if ((localObject != null) && (((bt)localObject).b())) {
      return ((Boolean)((bt)localObject).c().c()).booleanValue();
    }
    localObject = r.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().a(paramString, paramBoolean);
    }
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().g();
    }
    try
    {
      paramString = r.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    Object localObject = bt.a();
    if ((localObject != null) && (((bt)localObject).b())) {}
    for (localObject = ((bt)localObject).c().g();; localObject = r.a("android.webkit.CacheManager", "getCacheFileBaseDir")) {
      return (File)localObject;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */