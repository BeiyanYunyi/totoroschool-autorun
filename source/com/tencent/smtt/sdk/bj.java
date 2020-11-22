package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

class bj
  implements IconListener
{
  bj(WebIconDatabase paramWebIconDatabase, WebIconDatabase.a parama) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    this.a.a(paramString, paramBitmap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */