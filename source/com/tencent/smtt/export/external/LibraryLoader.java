package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader
{
  private static String[] sLibrarySearchPaths;
  
  public static String[] getLibrarySearchPaths(Context paramContext)
  {
    if (sLibrarySearchPaths != null) {
      return sLibrarySearchPaths;
    }
    if (paramContext == null) {
      return new String[] { "/system/lib" };
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNativeLibraryDir(paramContext));
    localArrayList.add("/system/lib");
    paramContext = new String[localArrayList.size()];
    localArrayList.toArray(paramContext);
    sLibrarySearchPaths = paramContext;
    return sLibrarySearchPaths;
  }
  
  public static String getNativeLibraryDir(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 9) {
      return paramContext.getApplicationInfo().nativeLibraryDir;
    }
    if (i >= 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationInfo().dataDir);
      localStringBuilder.append("/lib");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/lib");
    return localStringBuilder.toString();
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    paramContext = getLibrarySearchPaths(paramContext);
    String str1 = System.mapLibraryName(paramString);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramContext[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append("/");
      localStringBuilder.append(str1);
      str2 = localStringBuilder.toString();
      if (!new File(str2).exists()) {
        i += 1;
      } else {
        try
        {
          System.load(str2);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
    }
    try
    {
      System.loadLibrary(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\LibraryLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */