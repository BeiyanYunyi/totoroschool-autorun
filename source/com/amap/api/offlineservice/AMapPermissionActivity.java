package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AMapPermissionActivity
  extends Activity
{
  private boolean a = true;
  protected String[] needPermissions = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  
  private int a(String paramString)
  {
    try
    {
      int i = ((Integer)getClass().getMethod("checkSelfPermission", new Class[] { String.class }).invoke(this, new Object[] { paramString })).intValue();
      return i;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return -1;
  }
  
  private void a()
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("提示");
      localBuilder.setMessage("当前应用缺少必要权限。\\n\\n请点击\\\"设置\\\"-\\\"权限\\\"-打开所需权限");
      localBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            AMapPermissionActivity.this.finish();
            return;
          }
          catch (Throwable paramAnonymousDialogInterface)
          {
            paramAnonymousDialogInterface.printStackTrace();
          }
        }
      });
      localBuilder.setPositiveButton("设置", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            AMapPermissionActivity.a(AMapPermissionActivity.this);
            return;
          }
          catch (Throwable paramAnonymousDialogInterface)
          {
            paramAnonymousDialogInterface.printStackTrace();
          }
        }
      });
      localBuilder.setCancelable(false);
      localBuilder.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  @TargetApi(23)
  private void a(String... paramVarArgs)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) && (getApplicationInfo().targetSdkVersion >= 23))
      {
        paramVarArgs = b(paramVarArgs);
        if (paramVarArgs != null)
        {
          int i = paramVarArgs.size();
          if (i <= 0) {}
        }
      }
      return;
    }
    catch (Throwable paramVarArgs)
    {
      try
      {
        paramVarArgs = (String[])paramVarArgs.toArray(new String[paramVarArgs.size()]);
        getClass().getMethod("requestPermissions", new Class[] { String[].class, Integer.TYPE }).invoke(this, new Object[] { paramVarArgs, Integer.valueOf(0) });
        return;
      }
      catch (Throwable paramVarArgs) {}
      paramVarArgs = paramVarArgs;
      paramVarArgs.printStackTrace();
    }
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    try
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (k != 0) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  @TargetApi(23)
  private List<String> b(String[] paramArrayOfString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if ((Build.VERSION.SDK_INT >= 23) && (getApplicationInfo().targetSdkVersion >= 23))
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          if ((a(str) != 0) || (b(str))) {
            localArrayList.add(str);
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    try
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("package:");
      localStringBuilder.append(getPackageName());
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean b(String paramString)
  {
    try
    {
      boolean bool = ((Boolean)getClass().getMethod("shouldShowRequestPermissionRationale", new Class[] { String.class }).invoke(this, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) && (paramInt == 0) && (!a(paramArrayOfInt)))
      {
        a();
        this.a = false;
        return;
      }
    }
    catch (Throwable paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
  
  protected void onResume()
  {
    try
    {
      super.onResume();
      if ((Build.VERSION.SDK_INT >= 23) && (this.a))
      {
        a(this.needPermissions);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\offlineservice\AMapPermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */