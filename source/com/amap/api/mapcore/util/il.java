package com.amap.api.mapcore.util;

import android.content.Context;

public class il
{
  private Context a;
  private fv b;
  private String c;
  
  public il(Context paramContext, fv paramfv, String paramString)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramfv;
    this.c = paramString;
  }
  
  private static String a(Context paramContext, fv paramfv, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("\"sdkversion\":\"");
      localStringBuilder.append(paramfv.c());
      localStringBuilder.append("\",\"product\":\"");
      localStringBuilder.append(paramfv.a());
      localStringBuilder.append("\",\"nt\":\"");
      localStringBuilder.append(fp.e(paramContext));
      localStringBuilder.append("\",\"details\":");
      localStringBuilder.append(paramString);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return localStringBuilder.toString();
  }
  
  byte[] a()
  {
    return fw.a(a(this.a, this.b, this.c));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */