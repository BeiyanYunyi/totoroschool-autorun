package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class aj
  extends Handler
{
  aj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool3 = true;
    boolean bool1;
    Object localObject1;
    if (i != 108)
    {
      switch (i)
      {
      default: 
        return;
      case 104: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
        TbsLogReport.a(TbsDownloader.a()).c();
        return;
      case 103: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
        if (paramMessage.arg1 == 0)
        {
          am.a().a((Context)paramMessage.obj, true);
          return;
        }
        am.a().a((Context)paramMessage.obj, false);
        return;
      case 102: 
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
        if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {
          i = TbsShareManager.a(TbsDownloader.a(), false);
        } else {
          i = am.a().n(TbsDownloader.a());
        }
        paramMessage = new StringBuilder();
        paramMessage.append("[TbsDownloader.handleMessage] localTbsVersion=");
        paramMessage.append(i);
        TbsLog.i("TbsDownload", paramMessage.toString());
        TbsDownloader.b().a(i);
        TbsLogReport.a(TbsDownloader.a()).b();
        return;
      case 100: 
        if (paramMessage.arg1 == 1) {
          i = 1;
        } else {
          i = 0;
        }
        bool1 = TbsDownloader.a(true, false);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("needDownload-onNeedDownloadFinish needStartDownload=");
          ((StringBuilder)localObject1).append(bool1);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
          if ((!bool1) || (i != 0)) {
            ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
          }
        }
        if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.a())) || (!bool1)) {
          break;
        }
        TbsDownloader.startDownload(TbsDownloader.a());
        return;
      }
    }
    else
    {
      localObject1 = null;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tbs_download_lock_file");
      ((StringBuilder)localObject2).append(TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
      ((StringBuilder)localObject2).append(".txt");
      localObject2 = ((StringBuilder)localObject2).toString();
      FileOutputStream localFileOutputStream = k.b(TbsDownloader.a(), false, (String)localObject2);
      if (localFileOutputStream != null)
      {
        localObject2 = k.a(TbsDownloader.a(), localFileOutputStream);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65333);
        }
      }
      else
      {
        for (paramMessage = "MSG_START_DOWNLOAD_DECOUPLECORE return #1";; paramMessage = "MSG_START_DOWNLOAD_DECOUPLECORE return #2")
        {
          TbsLog.i("TbsDownload", paramMessage);
          return;
          if (!k.a(TbsDownloader.a())) {
            break;
          }
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65332);
        }
      }
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject2 = TbsDownloadConfig.getInstance(TbsDownloader.a());
      boolean bool2;
      if (108 == paramMessage.what) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (TbsDownloader.a(false, bool1, bool2))
      {
        if ((bool1) && (am.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0))))
        {
          QbSdk.m.onDownloadFinish(122);
          ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(65323);
          break label651;
        }
        if (((TbsDownloadConfig)localObject2).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(65321);
          localObject2 = TbsDownloader.b();
          if (108 == paramMessage.what) {
            bool2 = bool3;
          } else {
            bool2 = false;
          }
          ((ag)localObject2).b(bool1, bool2);
          break label651;
        }
      }
      QbSdk.m.onDownloadFinish(110);
      label651:
      TbsLog.i("TbsDownload", "------freeFileLock called :");
      k.a((FileLock)localObject1, localFileOutputStream);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */