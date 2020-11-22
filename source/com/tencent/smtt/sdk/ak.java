package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;
import java.util.Map;

final class ak
  implements n.a
{
  ak(TbsDownloadConfig paramTbsDownloadConfig, boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[TbsDownloader.sendRequest] httpResponseCode=");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramInt == 200))
    {
      this.a.a.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
      this.a.a.put("request_fail", Long.valueOf(0L));
      this.a.a.put("count_request_fail_in_24hours", Long.valueOf(0L));
      this.a.commit();
    }
    if (paramInt >= 300)
    {
      if (this.b) {
        localObject = this.a;
      }
      for (paramInt = -107;; paramInt = 65329)
      {
        ((TbsDownloadConfig)localObject).setDownloadInterruptCode(paramInt);
        return;
        localObject = this.a;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */