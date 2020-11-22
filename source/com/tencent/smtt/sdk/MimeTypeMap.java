package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().h(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().l(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().j(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().k(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().i(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\MimeTypeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */