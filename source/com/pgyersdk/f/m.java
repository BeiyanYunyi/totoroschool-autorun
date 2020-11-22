package com.pgyersdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;
import com.pgyersdk.PgyerProvider;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  private static String a = "Utils";
  private static m b;
  
  public static m a()
  {
    if (b == null) {
      b = new m();
    }
    return b;
  }
  
  public static StringBuffer a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.getBuffer();
  }
  
  public static void a(StringBuffer paramStringBuffer, String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      paramStringBuffer.append(paramString);
      paramStringBuffer.append("\n");
    }
    localBufferedReader.close();
    localFileInputStream.close();
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches();
  }
  
  public static boolean b()
  {
    Object localObject = (ConnectivityManager)PgyerProvider.a.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    f.d("PgyerSDK", "Please check your device net can work.");
    return false;
  }
  
  public String a(long paramLong)
  {
    String str = "B";
    float f2;
    if (paramLong >= 1000L)
    {
      str = "KB";
      f2 = (float)(paramLong / 1000L);
      float f1 = f2;
      if (f2 >= 1000.0F)
      {
        str = "MB";
        f1 = f2 / 1000.0F;
      }
      f2 = f1;
      if (f1 >= 1000.0F)
      {
        str = "GB";
        f2 = f1 / 1000.0F;
      }
    }
    else
    {
      f2 = (float)paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder(new DecimalFormat("#0.0").format(f2));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void a(String paramString, Exception paramException)
  {
    f.b(paramString, Log.getStackTraceString(paramException));
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      a().a(a, paramContext);
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */