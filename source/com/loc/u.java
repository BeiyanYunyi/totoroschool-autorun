package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
public class u
  extends Thread
  implements bl.a
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
  private bl h;
  
  public u(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.f = paramContext;
    this.e = paramString3;
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("temp.so");
    this.c = a(paramContext, paramString3.toString());
    this.d = a(paramContext, "libwgs2gcj.so");
    this.a = new a(paramString2);
    this.h = new bl(this.a);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = w.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("libso");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(s.b(str));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.c())) && (this.a.c().contains("libJni_wgs2gcj.so")))
    {
      if (!this.a.c().contains(w.a(this.f))) {
        return;
      }
      if (new File(this.d).exists()) {
        return;
      }
      start();
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong)
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
          aj.b(localFileNotFoundException, "sdl", "oDd");
          e();
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
        e();
        aj.b(paramArrayOfByte, "sdl", "oDd");
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      e();
      aj.b(paramArrayOfByte, "sdl", "oDd");
    }
  }
  
  public void b()
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      String str = s.a(this.c);
      if ((str != null) && (str.equalsIgnoreCase(this.e)))
      {
        if (new File(this.d).exists())
        {
          e();
          return;
        }
        new File(this.c).renameTo(new File(this.d));
        return;
      }
      e();
      return;
    }
    catch (Throwable localThrowable)
    {
      e();
      File localFile = new File(this.d);
      if (localFile.exists()) {
        localFile.delete();
      }
      aj.b(localThrowable, "sdl", "ofs");
    }
  }
  
  public final void c()
  {
    e();
  }
  
  public final void d()
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      e();
      File localFile1 = new File(a(this.f, "tempfile"));
      boolean bool = localFile1.exists();
      if (!bool) {
        try
        {
          File localFile2 = localFile1.getParentFile();
          if (!localFile2.exists()) {
            localFile2.mkdir();
          }
          localFile1.createNewFile();
          return;
        }
        catch (Throwable localThrowable1)
        {
          aj.b(localThrowable1, "sdl", "oe");
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      aj.b(localThrowable2, "sdl", "oe");
    }
  }
  
  protected final void e()
  {
    File localFile = new File(this.c);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public void run()
  {
    try
    {
      File localFile = new File(a(this.f, "tempfile"));
      if (localFile.exists()) {
        localFile.delete();
      }
      this.h.a(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      aj.b(localThrowable, "sdl", "run");
      e();
    }
  }
  
  public static final class a
    extends bn
  {
    private String a;
    
    a(String paramString)
    {
      this.a = paramString;
    }
    
    public final Map<String, String> b()
    {
      return null;
    }
    
    public final Map<String, String> b_()
    {
      return null;
    }
    
    public final String c()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */