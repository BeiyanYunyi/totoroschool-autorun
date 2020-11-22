package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class ay
  implements n.a
{
  ay(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:");
    localStringBuilder.append(paramInt);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (paramInt < 300) {
      TbsLogReport.b(this.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */