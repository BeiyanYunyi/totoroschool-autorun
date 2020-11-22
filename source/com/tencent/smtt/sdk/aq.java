package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

class aq
  extends Thread
{
  aq(am paramam, Context paramContext1, Context paramContext2) {}
  
  public void run()
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
    try
    {
      Object localObject1;
      if (this.a == null) {
        localObject1 = new File(TbsShareManager.getHostCorePathAppDefined());
      } else if (TbsShareManager.isThirdPartyApp(this.b))
      {
        if ((TbsShareManager.c(this.b) != null) && (TbsShareManager.c(this.b).contains("decouple"))) {
          localObject1 = this.c.q(this.a);
        } else {
          localObject1 = this.c;
        }
      }
      else {
        for (localObject2 = this.a;; localObject2 = this.a)
        {
          localObject1 = ((am)localObject1).r((Context)localObject2);
          break;
          localObject1 = this.c;
        }
      }
      Object localObject2 = this.c.r(this.b);
      int i = Build.VERSION.SDK_INT;
      if ((i != 19) && (i < 21)) {
        k.a((File)localObject1, (File)localObject2, new ar(this));
      }
      k.a((File)localObject1, (File)localObject2, new as(this));
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */