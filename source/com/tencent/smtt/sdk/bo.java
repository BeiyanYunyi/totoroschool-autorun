package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.smtt.sdk.a.d;

class bo
  implements android.webkit.DownloadListener
{
  bo(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (this.a == null)
    {
      if (WebView.a(this.b) == null) {
        paramString2 = null;
      } else {
        paramString2 = WebView.a(this.b).getApplicationInfo();
      }
      if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
        d.a(WebView.a(this.b), paramString1, null, null);
      }
    }
    else
    {
      this.a.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */