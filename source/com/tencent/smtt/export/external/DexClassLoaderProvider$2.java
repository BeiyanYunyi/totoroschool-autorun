package com.tencent.smtt.export.external;

import android.app.Service;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.TimerTask;

final class DexClassLoaderProvider$2
  extends TimerTask
{
  DexClassLoaderProvider$2(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String paramString4) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new File(this.val$dexPath.replace(".jar", ".dex"));
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() == 0L)) {
          break label307;
        }
        bool1 = true;
        localObject1 = new File(this.val$optimizedDirectory);
        localObject2 = new File(this.val$dexPath);
        boolean bool2 = ((File)localObject1).exists();
        boolean bool3 = ((File)localObject1).isDirectory();
        boolean bool4 = ((File)localObject2).exists();
        if ((bool2) && (bool3) && (bool4))
        {
          long l = System.currentTimeMillis();
          new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
          String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool1) });
          if ((DexClassLoaderProvider.access$100()) && ("tbs_jars_fusion_dex.jar".equals(this.val$dexName)) && (DexClassLoaderProvider.mService != null)) {
            DexClassLoaderProvider.mService.stopSelf();
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("dex loading exception(");
          ((StringBuilder)localObject1).append(bool2);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(bool3);
          ((StringBuilder)localObject1).append(", ");
          ((StringBuilder)localObject1).append(bool4);
          ((StringBuilder)localObject1).append(")");
          Log.d("dexloader", ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@AsyncDexLoad task exception: ");
        ((StringBuilder)localObject2).append(localThrowable);
        Log.e("dexloader", ((StringBuilder)localObject2).toString());
      }
      return;
      label307:
      boolean bool1 = false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\DexClassLoaderProvider$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */