package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@gp(a="a")
public class fv
{
  @gq(a="a1", b=6)
  private String a;
  @gq(a="a2", b=6)
  private String b;
  @gq(a="a6", b=2)
  private int c = 1;
  @gq(a="a3", b=6)
  private String d;
  @gq(a="a4", b=6)
  private String e;
  @gq(a="a5", b=6)
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String[] l = null;
  
  private fv() {}
  
  private fv(a parama) {}
  
  public static String a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("a1", fw.b(paramString));
    return go.a(localHashMap);
  }
  
  private String a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int n = paramArrayOfString.length;
      int m = 0;
      while (m < n)
      {
        localStringBuilder.append(paramArrayOfString[m]);
        localStringBuilder.append(";");
        m += 1;
      }
      paramArrayOfString = localStringBuilder.toString();
      return paramArrayOfString;
    }
    catch (Throwable paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return null;
  }
  
  private String[] b(String paramString)
  {
    try
    {
      paramString = paramString.split(";");
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String h()
  {
    return "a6=1";
  }
  
  public String a()
  {
    if ((TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.a))) {
      this.j = fw.c(this.a);
    }
    return this.j;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    if ((TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.b))) {
      this.h = fw.c(this.b);
    }
    return this.h;
  }
  
  public String d()
  {
    if ((TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.d))) {
      this.i = fw.c(this.d);
    }
    return this.i;
  }
  
  public String e()
  {
    if ((TextUtils.isEmpty(this.k)) && (!TextUtils.isEmpty(this.f))) {
      this.k = fw.c(this.f);
    }
    if (TextUtils.isEmpty(this.k)) {
      this.k = "standard";
    }
    return this.k;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (fv)paramObject;
    if (hashCode() == ((fv)paramObject).hashCode()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return this.c == 1;
  }
  
  public String[] g()
  {
    if (((this.l == null) || (this.l.length == 0)) && (!TextUtils.isEmpty(this.e))) {
      this.l = b(fw.c(this.e));
    }
    return (String[])this.l.clone();
  }
  
  public int hashCode()
  {
    gf localgf = new gf();
    localgf.a(this.j).a(this.g).a(this.h).a(this.l);
    return localgf.a();
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e = true;
    private String f = "standard";
    private String[] g = null;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString2;
      this.b = paramString2;
      this.d = paramString3;
      this.c = paramString1;
    }
    
    public a a(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a a(String[] paramArrayOfString)
    {
      if (paramArrayOfString != null) {
        this.g = ((String[])paramArrayOfString.clone());
      }
      return this;
    }
    
    public fv a()
      throws fj
    {
      if (this.g != null) {
        return new fv(this, null);
      }
      throw new fj("sdk packages is null");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */