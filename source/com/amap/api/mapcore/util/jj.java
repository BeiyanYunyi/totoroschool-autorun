package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public abstract class jj
{
  protected Context a;
  protected kf b;
  private String c;
  private fv d;
  private String e = null;
  private String f;
  private String g;
  private String h = null;
  private String i;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  
  public jj(Context paramContext, fv paramfv)
  {
    this.a = paramContext;
    this.d = paramfv;
    this.b = new kf();
  }
  
  private String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      this.c = a();
    }
    return this.c;
  }
  
  protected abstract String a();
  
  protected final String c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return this.e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.a());
    localStringBuilder.append(this.d.b());
    this.e = fs.b(localStringBuilder.toString());
    return this.e;
  }
  
  protected final String d()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return this.f;
    }
    if (this.a == null) {
      return "";
    }
    File localFile = Environment.getExternalStorageDirectory();
    this.f = this.b.a(localFile).b(b()).b(c()).a();
    return this.f;
  }
  
  protected final String e()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    if (this.a == null) {
      return "";
    }
    String str = this.a.getFilesDir().getAbsolutePath();
    this.g = this.b.a(str).b(b()).b(c()).a();
    return this.g;
  }
  
  public final String f()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    if (this.a == null) {
      return "";
    }
    Context localContext = this.a;
    StringBuilder localStringBuilder = new StringBuilder("png");
    localStringBuilder.append(c());
    this.h = ho.a(localContext, fs.b(localStringBuilder.toString()));
    return this.h;
  }
  
  public final String g()
  {
    if (!TextUtils.isEmpty(this.i)) {
      return this.i;
    }
    this.i = this.b.a(d()).b("h").a();
    return this.i;
  }
  
  public final String h()
  {
    if (!TextUtils.isEmpty(this.j)) {
      return this.j;
    }
    this.j = this.b.a(d()).b("m").a();
    return this.j;
  }
  
  public final String i()
  {
    if (!TextUtils.isEmpty(this.k)) {
      return this.k;
    }
    this.k = this.b.a(e()).b("i").a();
    return this.k;
  }
  
  public final String j()
  {
    if (!TextUtils.isEmpty(this.l)) {
      return this.l;
    }
    this.l = this.b.a(g()).b(f()).a();
    return this.l;
  }
  
  public final String k()
  {
    if (!TextUtils.isEmpty(this.m)) {
      return this.m;
    }
    this.m = this.b.a(h()).b(f()).a();
    return this.m;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */