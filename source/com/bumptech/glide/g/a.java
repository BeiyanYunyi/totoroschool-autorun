package com.bumptech.glide.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static final ConcurrentHashMap<String, com.bumptech.glide.load.c> a = new ConcurrentHashMap();
  
  public static com.bumptech.glide.load.c a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    com.bumptech.glide.load.c localc2 = (com.bumptech.glide.load.c)a.get(str);
    com.bumptech.glide.load.c localc1 = localc2;
    if (localc2 == null)
    {
      paramContext = b(paramContext);
      localc1 = (com.bumptech.glide.load.c)a.putIfAbsent(str, paramContext);
      if (localc1 == null) {
        return paramContext;
      }
    }
    return localc1;
  }
  
  private static com.bumptech.glide.load.c b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    if (paramContext != null) {
      paramContext = String.valueOf(paramContext.versionCode);
    } else {
      paramContext = UUID.randomUUID().toString();
    }
    return new c(paramContext);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */