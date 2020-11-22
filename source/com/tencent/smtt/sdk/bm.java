package com.tencent.smtt.sdk;

class bm
  extends Thread
{
  bm(WebView paramWebView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    this.a.tbsWebviewDestroy(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */