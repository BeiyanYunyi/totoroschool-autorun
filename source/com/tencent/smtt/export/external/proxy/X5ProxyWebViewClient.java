package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public abstract class X5ProxyWebViewClient
  extends ProxyWebViewClient
{
  public X5ProxyWebViewClient(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebViewClient = ((IX5WebViewClient)paramWebViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClient"));
  }
  
  public X5ProxyWebViewClient(IX5WebViewClient paramIX5WebViewClient)
  {
    this.mWebViewClient = paramIX5WebViewClient;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\proxy\X5ProxyWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */