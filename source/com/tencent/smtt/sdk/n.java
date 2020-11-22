package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class n
  implements TbsListener
{
  public void onDownloadFinish(int paramInt)
  {
    if (TbsDownloader.needDownloadDecoupleCore())
    {
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
      TbsDownloader.a = true;
      return;
    }
    TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
    TbsDownloader.a = false;
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadFinish(paramInt);
    }
    if (QbSdk.e() != null) {
      QbSdk.e().onDownloadFinish(paramInt);
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QbSdk.e() != null) {
      QbSdk.e().onDownloadProgress(paramInt);
    }
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadProgress(paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt != 200) {}
    boolean bool = false;
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.a = false;
    if (TbsDownloader.startDecoupleCoreIfNeeded()) {
      bool = true;
    }
    TbsDownloader.a = bool;
    if (QbSdk.d() != null) {
      QbSdk.d().onInstallFinish(paramInt);
    }
    if (QbSdk.e() != null) {
      QbSdk.e().onInstallFinish(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */