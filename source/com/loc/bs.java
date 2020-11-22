package com.loc;

import android.content.Context;

public final class bs
{
  private Context a;
  private v b;
  private String c;
  
  public bs(Context paramContext, v paramv, String paramString)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramv;
    this.c = paramString;
  }
  
  private static String a(Context paramContext, v paramv, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("\"sdkversion\":\"");
      localStringBuilder.append(paramv.c());
      localStringBuilder.append("\",\"product\":\"");
      localStringBuilder.append(paramv.a());
      localStringBuilder.append("\",\"nt\":\"");
      localStringBuilder.append(p.e(paramContext));
      localStringBuilder.append("\",\"details\":");
      localStringBuilder.append(paramString);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return localStringBuilder.toString();
  }
  
  final byte[] a()
  {
    return w.a(a(this.a, this.b, this.c));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */