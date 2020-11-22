package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bs
  extends Thread
{
  public void run()
  {
    if (WebView.g() == null)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
      return;
    }
    o localo = o.a(true);
    if (o.a)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
      return;
    }
    ai localai = ai.a(WebView.g());
    int i = localai.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebView.updateNeeeRebootStatus--installStatus = ");
    localStringBuilder.append(i);
    TbsLog.d("TbsNeedReboot", localStringBuilder.toString());
    if (i == 2)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
      localo.a(String.valueOf(localai.b()));
      localo.b(true);
      return;
    }
    int j = localai.b("copy_status");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebView.updateNeeeRebootStatus--copyStatus = ");
    localStringBuilder.append(j);
    TbsLog.d("TbsNeedReboot", localStringBuilder.toString());
    if (j == 1)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
      localo.a(String.valueOf(localai.c("copy_core_ver")));
      localo.b(true);
      return;
    }
    if ((!bt.a().b()) && ((i == 3) || (j == 3)))
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
      localo.a(String.valueOf(o.e()));
      localo.b(true);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */