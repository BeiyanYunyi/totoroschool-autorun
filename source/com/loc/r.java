package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class r
{
  private volatile b a = new b((byte)0);
  private al b = new al("HttpsDecisionUtil");
  
  public static r a()
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
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT == 19;
  }
  
  public final void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new b((byte)0);
    }
    this.a.a(this.b.a(paramContext, "isTargetRequired"));
    this.a.a(paramContext);
  }
  
  final void a(Context paramContext, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new b((byte)0);
    }
    this.b.a(paramContext, "isTargetRequired", paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new b((byte)0);
    }
    this.a.b(paramBoolean);
  }
  
  public final void b(Context paramContext)
  {
    this.b.a(paramContext, "isTargetRequired", true);
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (b()) {
      return false;
    }
    if (!paramBoolean)
    {
      if (this.a == null) {
        this.a = new b((byte)0);
      }
      if (!this.a.a()) {
        return false;
      }
    }
    return true;
  }
  
  private static final class a
  {
    static r a = new r();
  }
  
  private static final class b
  {
    protected boolean a = true;
    private int b = 0;
    private final boolean c = true;
    private boolean d = false;
    
    public final void a(Context paramContext)
    {
      if (paramContext == null) {
        return;
      }
      if ((this.b <= 0) && (Build.VERSION.SDK_INT >= 4)) {
        this.b = paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion;
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public final boolean a()
    {
      if (!this.d)
      {
        int i;
        if (Build.VERSION.SDK_INT >= 28) {
          i = 1;
        } else {
          i = 0;
        }
        if (this.a)
        {
          if (this.b <= 0) {
            j = 28;
          } else {
            j = this.b;
          }
          if (j >= 28) {
            j = 1;
          } else {
            j = 0;
          }
          if (j == 0)
          {
            j = 0;
            break label74;
          }
        }
        int j = 1;
        label74:
        if ((i != 0) && (j != 0)) {
          i = 1;
        } else {
          i = 0;
        }
        return i != 0;
      }
      return true;
    }
    
    public final void b(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */