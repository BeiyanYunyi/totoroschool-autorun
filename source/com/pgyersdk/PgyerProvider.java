package com.pgyersdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.pgyersdk.f.f;
import com.pgyersdk.f.l;

public class PgyerProvider
  extends ContentProvider
{
  @SuppressLint({"StaticFieldLeak"})
  public static Context a;
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        if (paramContext.metaData == null) {
          return null;
        }
        paramContext = paramContext.metaData.getString(com.pgyersdk.c.a.m);
        return paramContext;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private void b(Context paramContext)
  {
    if ((paramContext instanceof Application))
    {
      PgyerActivityManager.a((Application)paramContext);
      return;
    }
    throw new Error("PGYER SDK init activity manager throw a Error");
  }
  
  private void c(Context paramContext)
  {
    String str = a(paramContext);
    if (com.pgyersdk.c.a.l.equals("")) {
      com.pgyersdk.c.a.l = l.c(str);
    }
    if (l.c(com.pgyersdk.c.a.l) == null) {
      f.d("PgyerSDK", "Please config AppId on Manifest.xml or use Pgyer.setAppId().");
    }
    com.pgyersdk.c.a.c(paramContext);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    a = getContext();
    f.a("PgyerSDK", " PgyerProvider onCreate");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" context is ");
    localStringBuilder.append(a.toString());
    f.a("PgyerSDK", localStringBuilder.toString());
    c(a);
    com.pgyersdk.a.a.a(a);
    b(a);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\PgyerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */