package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

public class t
{
  public static boolean a(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return true;
      }
      paramContext = b(paramContext);
      if (paramContext == null) {
        return true;
      }
      paramContext = paramContext.listFiles(new u());
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramContext[i];
        if ((localFile.isFile()) && (localFile.exists()) && (a(localFile)))
        {
          localFile.delete();
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static boolean a(File paramFile)
  {
    try
    {
      boolean bool = j.b(paramFile);
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isOatFileBroken exception: ");
      localStringBuilder.append(paramFile);
      Log.e("TbsCheckUtils", localStringBuilder.toString());
    }
    return false;
  }
  
  private static File b(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_share");
    if ((paramContext.isDirectory()) && (paramContext.exists())) {
      return paramContext;
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */