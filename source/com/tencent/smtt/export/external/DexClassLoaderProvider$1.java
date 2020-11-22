package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.TimerTask;

final class DexClassLoaderProvider$1
  extends TimerTask
{
  DexClassLoaderProvider$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(4);
      localArrayList.add(0, this.val$dexName);
      localArrayList.add(1, this.val$dexPath);
      localArrayList.add(2, this.val$optimizedDirectory);
      localArrayList.add(3, this.val$libraryPath);
      localObject = new Intent(DexClassLoaderProvider.access$000(), DexClassLoaderProviderService.class);
      ((Intent)localObject).putStringArrayListExtra("dex2oat", localArrayList);
      DexClassLoaderProvider.access$000().startService((Intent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("after shouldUseDexLoaderService exception: ");
      ((StringBuilder)localObject).append(localThrowable);
      Log.e("dexloader", ((StringBuilder)localObject).toString());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("dexloader", "start DexLoaderService exception", localSecurityException);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\DexClassLoaderProvider$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */