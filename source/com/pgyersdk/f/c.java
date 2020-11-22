package com.pgyersdk.f;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class c
{
  private static c a;
  private String b = null;
  private String c = "pgySdk";
  private String d = "feedback";
  private String e = "crash";
  private String f = "downloadApk";
  public final String g = ".jpg";
  public final String h = ".log";
  public final String i = ".txt";
  public final String j = ".zip";
  public final String k = "bug.properties";
  
  public static c a()
  {
    if (a == null) {
      a = new c();
    }
    return a;
  }
  
  public static File a(Context paramContext, String paramString)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      Object localObject2;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = paramContext.getExternalCacheDir();
      } else {
        localObject2 = paramContext.getExternalFilesDir(paramString);
      }
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Environment.getExternalStorageDirectory();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Android/data/");
        ((StringBuilder)localObject2).append(paramContext.getPackageName());
        ((StringBuilder)localObject2).append("/cache/");
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 == null)
      {
        Log.e("PgyerSDK", "getExternalDirectory fail ,the reason is sdCard unknown exception !");
        return (File)localObject1;
      }
      paramContext = (Context)localObject1;
      if (!((File)localObject1).exists())
      {
        paramContext = (Context)localObject1;
        if (!((File)localObject1).mkdirs())
        {
          Log.e("PgyerSDK", "getExternalDirectory fail ,the reason is make directory fail !");
          return (File)localObject1;
        }
      }
    }
    else
    {
      Log.e("PgyerSDK", "getExternalDirectory fail ,the reason is sdCard nonexistence or sdCard mount fail !");
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean b(File paramFile)
  {
    if (paramFile != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getParent());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      localObject = new File(((StringBuilder)localObject).toString());
      paramFile.renameTo((File)localObject);
      return ((File)localObject).delete();
    }
    return false;
  }
  
  public static File c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramContext = paramContext.getCacheDir();
    } else {
      paramContext = new File(paramContext.getFilesDir(), paramString);
    }
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      Log.e("PgyerSDK", "getInternalDirectory fail ,the reason is make directory fail !");
    }
    return paramContext;
  }
  
  public String a(Context paramContext)
  {
    File localFile2 = a(paramContext, this.c);
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = c(paramContext, this.c);
    }
    if (localFile1 == null) {
      Log.e("PgyerSDK", "getCacheDirectory fail ,the reason is mobile phone unknown exception !");
    } else if ((!localFile1.exists()) && (!localFile1.mkdirs())) {
      Log.e("PgyerSDK", "getCacheDirectory fail ,the reason is make directory fail !");
    }
    return localFile1.getAbsolutePath();
  }
  
  public void a(File paramFile)
  {
    if (paramFile.isFile())
    {
      b(paramFile);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int m = 0;
        while (m < arrayOfFile.length)
        {
          a(arrayOfFile[m]);
          m += 1;
        }
        b(paramFile);
        return;
      }
      b(paramFile);
    }
  }
  
  public String b(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a(paramContext));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.e);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public String b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()));
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d(paramContext));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String c(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a(paramContext));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.f);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public String d(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a(paramContext));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.d);
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public String e(Context paramContext)
  {
    return b(paramContext, ".jpg");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */