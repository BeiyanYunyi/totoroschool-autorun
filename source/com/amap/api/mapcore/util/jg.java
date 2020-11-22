package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class jg
{
  private jn a;
  private jp b;
  private fv c;
  private List<jo> d = new ArrayList();
  
  public jg(Context paramContext, fv paramfv, jp paramjp)
  {
    this.c = paramfv;
    this.b = paramjp;
    this.a = new jn(paramContext, paramfv);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString2))) {
      return fw.a(fi.b(fw.e(paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, ""))));
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      paramString3 = fw.g(fi.a(fw.a(paramString3)));
      paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
      paramContext.putString(paramString2, paramString3);
      paramContext.commit();
      return;
    }
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!paramString.startsWith("lib"))
    {
      localStringBuilder = new StringBuilder("lib");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    if (paramString.endsWith(".so")) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  private boolean d(String paramString)
  {
    try
    {
      boolean bool = b(paramString);
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label18:
      for (;;) {}
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      break label18;
    }
    return false;
  }
  
  private int e(String paramString)
  {
    Object localObject1 = c(paramString);
    Object localObject2 = this.a;
    if ((localObject2 != null) && (!TextUtils.isEmpty(paramString))) {
      paramString = ((jn)localObject2).b(c(paramString));
    } else {
      paramString = "";
    }
    localObject1 = this.b.a((String)localObject1);
    localObject2 = new File(paramString);
    int i;
    if ((((File)localObject2).exists()) && (!((File)localObject2).isDirectory())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 1001;
    }
    this.d.add(localObject1);
    try
    {
      System.load(paramString);
      return 1000;
    }
    catch (Throwable paramString) {}
    return 1001;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.c == null) {
        return false;
      }
      boolean bool = d(paramString);
      return bool;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public boolean b(String paramString)
  {
    return e(paramString) == 1000;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */