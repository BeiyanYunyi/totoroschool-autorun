package com.amap.api.mapcore.util;

@gp(a="update_item_download_info")
class ap
{
  @gq(a="mAdcode", b=6)
  private String a = "";
  @gq(a="fileLength", b=5)
  private long b = 0L;
  @gq(a="splitter", b=2)
  private int c = 0;
  @gq(a="startPos", b=5)
  private long d = 0L;
  @gq(a="endPos", b=5)
  private long e = 0L;
  
  public ap() {}
  
  public ap(String paramString, long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramInt;
    this.d = paramLong2;
    this.e = paramLong3;
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
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */