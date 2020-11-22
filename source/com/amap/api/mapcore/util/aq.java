package com.amap.api.mapcore.util;

@gp(a="update_item_file")
class aq
{
  @gq(a="mAdcode", b=6)
  private String a = "";
  @gq(a="file", b=6)
  private String b = "";
  
  public aq() {}
  
  public aq(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAdcode");
    localStringBuilder.append("='");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */