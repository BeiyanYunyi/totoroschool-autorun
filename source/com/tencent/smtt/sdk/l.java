package com.tencent.smtt.sdk;

import android.content.Context;

final class l
  implements TbsListener
{
  l(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onDownloadFinish(int paramInt) {}
  
  public void onDownloadProgress(int paramInt) {}
  
  public void onInstallFinish(int paramInt)
  {
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */