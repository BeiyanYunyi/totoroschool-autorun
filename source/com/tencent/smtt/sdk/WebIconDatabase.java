package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return a();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, a parama) {}
  
  public void close()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, a parama)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().a(paramString, new bj(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new bk(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
  
  @Deprecated
  public static abstract interface a
  {
    public abstract void a(String paramString, Bitmap paramBitmap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\WebIconDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */