package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;

class bk
  implements WebIconDatabase.IconListener
{
  bk(WebIconDatabase paramWebIconDatabase, WebIconDatabase.a parama) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    this.a.a(paramString, paramBitmap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */