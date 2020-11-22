package com.tencent.smtt.sdk;

class ae
  implements Runnable
{
  ae(ad paramad) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(ad.a(this.a).getContext())) && (TbsDownloader.needDownload(ad.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(ad.a(this.a).getContext());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */