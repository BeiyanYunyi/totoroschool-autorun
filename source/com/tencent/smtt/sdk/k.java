package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

final class k
  extends Thread
{
  k(Context paramContext, Handler paramHandler) {}
  
  public void run()
  {
    int i = am.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QbSdk preinit ver is ");
    ((StringBuilder)localObject).append(i);
    TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
    if (i == 0) {
      am.a().c(this.a, true);
    }
    if (("com.tencent.mm".equals(QbSdk.getCurrentProcessName(this.a))) && (!QbSdk.c()) && (!WebView.mWebViewCreated))
    {
      TbsLog.i("QbSdk", "preInit -- prepare initAndNotLoadSo");
      am.a().b(this.a, true);
      o.a(true).a(this.a, false, false);
      localObject = bt.a();
      i = am.a().j(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbSdk preinit coreversion is ");
      localStringBuilder.append(i);
      TbsLog.i("QbSdk", localStringBuilder.toString());
      if (i > 0) {
        ((bt)localObject).b(this.a);
      }
    }
    else
    {
      TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
      o.a(true).b(this.a, false, false);
      localObject = bt.a();
      ((bt)localObject).a(this.a);
      boolean bool = ((bt)localObject).b();
      this.b.sendEmptyMessage(3);
      if (!bool)
      {
        this.b.sendEmptyMessage(2);
        return;
      }
      this.b.sendEmptyMessage(1);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */