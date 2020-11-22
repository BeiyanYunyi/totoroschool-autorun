package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase
{
  private static WebViewDatabase a;
  private Context b;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static WebViewDatabase a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new WebViewDatabase(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    return a(paramContext);
  }
  
  public void clearFormData()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().g(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().e(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().c(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
  }
  
  public boolean hasFormData()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().f(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().d(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return localbt.c().b(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\WebViewDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */