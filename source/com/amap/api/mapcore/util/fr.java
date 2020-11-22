package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class fr
{
  private volatile b a = new b(null);
  private hr b = new hr("HttpsDecisionUtil");
  
  public static fr a()
  {
    return a.a;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https")) {
        return paramString;
      }
    }
    try
    {
      Object localObject = Uri.parse(paramString).buildUpon();
      ((Uri.Builder)localObject).scheme("https");
      localObject = ((Uri.Builder)localObject).build().toString();
      return (String)localObject;
    }
    catch (Throwable localThrowable) {}
    return paramString;
    return paramString;
  }
  
  private void b(Context paramContext, boolean paramBoolean)
  {
    this.b.a(paramContext, "isTargetRequired", paramBoolean);
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT == 19;
  }
  
  private boolean c(Context paramContext)
  {
    return this.b.b(paramContext, "isTargetRequired", true);
  }
  
  private void d(Context paramContext)
  {
    this.b.a(paramContext, "isTargetRequired", true);
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new b(null);
    }
    this.a.a(c(paramContext));
    this.a.a(paramContext);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new b(null);
    }
    b(paramContext, paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new b(null);
    }
    this.a.b(paramBoolean);
  }
  
  public void b(Context paramContext)
  {
    d(paramContext);
  }
  
  public boolean b()
  {
    if (this.a == null) {
      this.a = new b(null);
    }
    return this.a.a();
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool2 = c();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramBoolean)
    {
      paramBoolean = bool1;
      if (!b()) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static class a
  {
    static fr a = new fr();
  }
  
  private static class b
  {
    protected boolean a = true;
    private int b = 0;
    private final boolean c = true;
    private boolean d = false;
    
    private int b()
    {
      if (this.b <= 0) {
        return 28;
      }
      return this.b;
    }
    
    private boolean c()
    {
      return b() >= 28;
    }
    
    private boolean d()
    {
      return Build.VERSION.SDK_INT >= 28;
    }
    
    private boolean e()
    {
      boolean bool3 = d();
      boolean bool1 = this.a;
      boolean bool2 = false;
      int i;
      if ((bool1) && (!c())) {
        i = 0;
      } else {
        i = 1;
      }
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public void a(Context paramContext)
    {
      if (paramContext == null) {
        return;
      }
      if ((this.b <= 0) && (Build.VERSION.SDK_INT >= 4)) {
        this.b = paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion;
      }
    }
    
    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public boolean a()
    {
      return (this.d) || (e());
    }
    
    public void b(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */