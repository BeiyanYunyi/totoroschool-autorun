package com.tencent.smtt.sdk;

public final class URLUtil
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().a(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().a(paramArrayOfByte);
    }
    return android.webkit.URLUtil.decode(paramArrayOfByte);
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().b(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
  }
  
  public static String guessUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().m(paramString);
    }
    return android.webkit.URLUtil.guessUrl(paramString);
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().q(paramString);
    }
    return android.webkit.URLUtil.isAboutUrl(paramString);
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().n(paramString);
    }
    return android.webkit.URLUtil.isAssetUrl(paramString);
  }
  
  public static boolean isContentUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().w(paramString);
    }
    return android.webkit.URLUtil.isContentUrl(paramString);
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().o(paramString);
    }
    return android.webkit.URLUtil.isCookielessProxyUrl(paramString);
  }
  
  public static boolean isDataUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().r(paramString);
    }
    return android.webkit.URLUtil.isDataUrl(paramString);
  }
  
  public static boolean isFileUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().p(paramString);
    }
    return android.webkit.URLUtil.isFileUrl(paramString);
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().t(paramString);
    }
    return android.webkit.URLUtil.isHttpUrl(paramString);
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().u(paramString);
    }
    return android.webkit.URLUtil.isHttpsUrl(paramString);
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().s(paramString);
    }
    return android.webkit.URLUtil.isJavaScriptUrl(paramString);
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().v(paramString);
    }
    return android.webkit.URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isValidUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().x(paramString);
    }
    return android.webkit.URLUtil.isValidUrl(paramString);
  }
  
  public static String stripAnchor(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().y(paramString);
    }
    return android.webkit.URLUtil.stripAnchor(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\URLUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */