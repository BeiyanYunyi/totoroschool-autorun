package com.pgyersdk.f;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.c.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l
{
  private static final Pattern a = Pattern.compile("[0-9a-f]+", 2);
  
  public static boolean a()
  {
    if (c(a.l) == null)
    {
      f.b("PgyerSDK", "Please configuration param correctly,otherwise PGYER SDK can not work");
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = PgyerProvider.a;
    boolean bool = false;
    if (localObject == null)
    {
      f.d("PgyerSDK", "Init sdk failed, context is  null.\n");
      return false;
    }
    if (((Context)localObject).getPackageManager().checkPermission(paramString, PgyerProvider.a.getPackageName()) == 0) {
      bool = true;
    }
    if (!bool)
    {
      if (!paramString.equals("android.permission.READ_PHONE_STATE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("There is no ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\n");
        f.d("PgyerSDK", ((StringBuilder)localObject).toString());
        f.d("PgyerSDK", "Please grant  permission if you use Pgyer SDK feature. ");
      }
      d(paramString);
    }
    return bool;
  }
  
  public static boolean b()
  {
    return a("android.permission.INTERNET");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = paramString.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})$");
    if (!bool) {
      f.a("PgyerSDK", "please check setting color format is correct");
    }
    return bool;
  }
  
  public static String c(String paramString)
  {
    if (!k.a(paramString))
    {
      paramString = paramString.trim();
      Matcher localMatcher = a.matcher(paramString);
      if ((paramString.length() != 32) || (!localMatcher.matches())) {
        paramString = null;
      }
      return paramString;
    }
    return null;
  }
  
  public static boolean c()
  {
    return a("android.permission.READ_PHONE_STATE");
  }
  
  private static void d(String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (PgyerActivityManager.isSuccessSetInstance()) && ((PgyerActivityManager.getInstance().getCurrentActivity() instanceof Activity))) {
      PgyerActivityManager.getInstance().getCurrentActivity().requestPermissions(new String[] { paramString }, 111111110);
    }
  }
  
  public static boolean d()
  {
    return a("android.permission.RECORD_AUDIO");
  }
  
  public static boolean e()
  {
    return a("android.permission.WRITE_EXTERNAL_STORAGE");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */