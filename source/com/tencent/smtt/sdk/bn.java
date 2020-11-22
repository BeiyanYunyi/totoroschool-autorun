package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

class bn
  implements WebView.FindListener
{
  bn(WebView paramWebView, IX5WebViewBase.FindListener paramFindListener) {}
  
  public void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */