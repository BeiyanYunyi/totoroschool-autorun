package com.pgyersdk.crash;

import android.content.Context;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.f.c;
import com.pgyersdk.f.l;
import com.pgyersdk.f.m;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PgyCrashManager
{
  private static boolean a = false;
  
  private static File a(a parama)
  {
    File localFile = new File(c.a().b(PgyerProvider.a));
    try
    {
      int i = b.a[parama.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          parama = File.createTempFile("exception-", ".stacktrace", localFile);
          return parama;
        }
      }
      else
      {
        parama = File.createTempFile("crash-", ".stacktrace", localFile);
        return parama;
      }
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
    }
    return null;
  }
  
  static void a(StringBuffer paramStringBuffer, a parama)
  {
    if (!l.e()) {
      return;
    }
    Date localDate = new Date();
    try
    {
      parama = a(parama);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create Crash File  path:");
      localStringBuilder.append(parama.getAbsolutePath());
      com.pgyersdk.f.f.a("PgyerSDK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Writing unhandled exception to: ");
      localStringBuilder.append(parama.getAbsolutePath());
      com.pgyersdk.f.f.a("PgyerSDK", localStringBuilder.toString());
      parama = new BufferedWriter(new FileWriter(parama));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Package: ");
      localStringBuilder.append(com.pgyersdk.c.a.c);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Version Code: ");
      localStringBuilder.append(com.pgyersdk.c.a.b);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Version Name: ");
      localStringBuilder.append(com.pgyersdk.c.a.d);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Android: ");
      localStringBuilder.append(com.pgyersdk.c.a.e);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Manufacturer: ");
      localStringBuilder.append(com.pgyersdk.c.a.g);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Model: ");
      localStringBuilder.append(com.pgyersdk.c.a.f);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      if (com.pgyersdk.c.a.h != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("CrashReporter Key: ");
        localStringBuilder.append(com.pgyersdk.c.a.h);
        localStringBuilder.append("\n");
        parama.write(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Date: ");
      localStringBuilder.append(localDate);
      localStringBuilder.append("\n");
      parama.write(localStringBuilder.toString());
      parama.write("\n");
      parama.write(paramStringBuffer.toString());
      parama.flush();
      parama.close();
      return;
    }
    catch (Exception paramStringBuffer)
    {
      com.pgyersdk.f.f.a("PgyerSDK", "Error saving exception stacktrace!\n", paramStringBuffer);
    }
  }
  
  public static boolean isIsIgnoreDefaultHander()
  {
    return a;
  }
  
  public static void register()
  {
    if (!l.a()) {
      return;
    }
    PgyerCrashObservable.get().a();
  }
  
  @Deprecated
  public static void register(Context paramContext) {}
  
  @Deprecated
  public static void reportCaughtException(Context paramContext, Exception paramException)
  {
    reportCaughtException(paramException);
  }
  
  public static void reportCaughtException(Exception paramException)
  {
    com.pgyersdk.f.a.a(new f(m.a(paramException), true));
  }
  
  public static void setIsIgnoreDefaultHander(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void unregister() {}
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\PgyCrashManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */