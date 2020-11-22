package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
public class fu
  extends Thread
  implements hz.a
{
  protected static boolean g = false;
  private static String i = "sodownload";
  private static String j = "sofail";
  protected a a;
  protected RandomAccessFile b;
  protected String c;
  protected String d;
  protected String e;
  protected Context f;
  private hz h;
  
  public fu(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.f = paramContext;
    this.e = paramString3;
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("temp.so");
    this.c = a(paramContext, paramString3.toString());
    this.d = a(paramContext, "libwgs2gcj.so");
    this.a = new a(paramString2);
    this.h = new hz(this.a);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = fw.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("libso");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(fs.b(str));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, Throwable paramThrowable)
  {
    if (((paramThrowable instanceof UnsatisfiedLinkError)) || ((paramThrowable instanceof LinkageError))) {
      g = true;
    }
    try
    {
      paramContext = new File(a(paramContext, "libwgs2gcj.so"));
      if (paramContext.exists()) {
        paramContext.delete();
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static String b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString);
  }
  
  public void a()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.getURL())) && (this.a.getURL().contains("libJni_wgs2gcj.so")))
    {
      if (!this.a.getURL().contains(fw.a(this.f))) {
        return;
      }
      if (new File(this.d).exists()) {
        return;
      }
      start();
      return;
    }
  }
  
  protected void b()
  {
    File localFile = new File(this.c);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.b == null)
      {
        File localFile1 = new File(this.c);
        File localFile2 = localFile1.getParentFile();
        if (!localFile2.exists()) {
          localFile2.mkdirs();
        }
        try
        {
          this.b = new RandomAccessFile(localFile1, "rw");
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          gk.c(localFileNotFoundException, "sdl", "oDd");
          b();
        }
      }
      RandomAccessFile localRandomAccessFile = this.b;
      if (localRandomAccessFile == null) {
        return;
      }
      try
      {
        this.b.seek(paramLong);
        this.b.write(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        b();
        gk.c(paramArrayOfByte, "sdl", "oDd");
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      b();
      gk.c(paramArrayOfByte, "sdl", "oDd");
    }
  }
  
  public void onException(Throwable paramThrowable)
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      b();
      paramThrowable = new File(b(this.f, "tempfile"));
      boolean bool = paramThrowable.exists();
      if (!bool) {
        try
        {
          File localFile = paramThrowable.getParentFile();
          if (!localFile.exists()) {
            localFile.mkdir();
          }
          paramThrowable.createNewFile();
          return;
        }
        catch (Throwable paramThrowable)
        {
          gk.c(paramThrowable, "sdl", "oe");
          return;
        }
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      gk.c(paramThrowable, "sdl", "oe");
    }
  }
  
  public void onFinish()
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      String str = fs.a(this.c);
      if ((str != null) && (str.equalsIgnoreCase(this.e)))
      {
        if (new File(this.d).exists())
        {
          b();
          return;
        }
        new File(this.c).renameTo(new File(this.d));
        return;
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      b();
      File localFile = new File(this.d);
      if (localFile.exists()) {
        localFile.delete();
      }
      gk.c(localThrowable, "sdl", "ofs");
    }
  }
  
  public void onStop()
  {
    b();
  }
  
  public void run()
  {
    try
    {
      File localFile = new File(b(this.f, "tempfile"));
      if (localFile.exists()) {
        localFile.delete();
      }
      this.h.a(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "sdl", "run");
      b();
    }
  }
  
  public static class a
    extends ic
  {
    private String d;
    
    a(String paramString)
    {
      this.d = paramString;
    }
    
    public Map<String, String> getParams()
    {
      return null;
    }
    
    public Map<String, String> getRequestHead()
    {
      return null;
    }
    
    public String getURL()
    {
      return this.d;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */