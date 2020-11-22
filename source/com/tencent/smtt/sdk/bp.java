package com.tencent.smtt.sdk;

import android.graphics.Picture;

class bp
  implements android.webkit.WebView.PictureListener
{
  bp(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    this.b.a(paramWebView);
    this.a.onNewPicture(this.b, paramPicture);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */