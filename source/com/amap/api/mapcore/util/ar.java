package com.amap.api.mapcore.util;

@gp(a="update_item")
public class ar
{
  @gq(a="title", b=6)
  protected String a = null;
  @gq(a="url", b=6)
  protected String b = null;
  @gq(a="mAdcode", b=6)
  protected String c = null;
  @gq(a="fileName", b=6)
  protected String d = null;
  @gq(a="version", b=6)
  protected String e = "";
  @gq(a="lLocalLength", b=5)
  protected long f = 0L;
  @gq(a="lRemoteLength", b=5)
  protected long g = 0L;
  @gq(a="localPath", b=6)
  protected String h;
  @gq(a="isProvince", b=2)
  protected int i = 0;
  @gq(a="mCompleteCode", b=2)
  protected int j;
  @gq(a="mCityCode", b=6)
  protected String k = "";
  @gq(a="mState", b=2)
  public int l;
  @gq(a="mPinyin", b=6)
  public String m = "";
  
  public static String e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAdcode");
    localStringBuilder.append("='");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    return localStringBuilder.toString();
  }
  
  public static String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPinyin");
    localStringBuilder.append("='");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    return localStringBuilder.toString();
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.j;
  }
  
  public String i()
  {
    return this.m;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */