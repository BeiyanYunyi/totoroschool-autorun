package com.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@ao(a="a")
public class v
{
  @ap(a="a1", b=6)
  private String a;
  @ap(a="a2", b=6)
  private String b;
  @ap(a="a6", b=2)
  private int c = 1;
  @ap(a="a3", b=6)
  private String d;
  @ap(a="a4", b=6)
  private String e;
  @ap(a="a5", b=6)
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String[] l = null;
  
  private v() {}
  
  private v(a parama) {}
  
  public static String a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("a1", w.b(paramString));
    return an.a(localHashMap);
  }
  
  private static String a(String[] paramArrayOfString)
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
  
  private static String[] b(String paramString)
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
  
  public static String g()
  {
    return "a6=1";
  }
  
  public final String a()
  {
    if ((TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.a))) {
      this.j = w.c(this.a);
    }
    return this.j;
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String b()
  {
    return this.g;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.b))) {
      this.h = w.c(this.b);
    }
    return this.h;
  }
  
  public final String d()
  {
    if ((TextUtils.isEmpty(this.k)) && (!TextUtils.isEmpty(this.f))) {
      this.k = w.c(this.f);
    }
    if (TextUtils.isEmpty(this.k)) {
      this.k = "standard";
    }
    return this.k;
  }
  
  public final boolean e()
  {
    return this.c == 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (v)paramObject;
    return hashCode() == ((v)paramObject).hashCode();
  }
  
  public final String[] f()
  {
    if (((this.l == null) || (this.l.length == 0)) && (!TextUtils.isEmpty(this.e))) {
      this.l = b(w.c(this.e));
    }
    return (String[])this.l.clone();
  }
  
  public int hashCode()
  {
    ae localae = new ae();
    localae.a(this.j).a(this.g).a(this.h).a(this.l);
    return localae.a();
  }
  
  public static final class a
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
    
    public final a a(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public final a a(String[] paramArrayOfString)
    {
      if (paramArrayOfString != null) {
        this.g = ((String[])paramArrayOfString.clone());
      }
      return this;
    }
    
    public final v a()
      throws k
    {
      if (this.g != null) {
        return new v(this, (byte)0);
      }
      throw new k("sdk packages is null");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */