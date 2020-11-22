package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public final class jn
  extends jj
{
  private static jn c;
  
  public jn(Context paramContext, fv paramfv)
  {
    super(paramContext, paramfv);
  }
  
  public static jn a(Context paramContext, fv paramfv)
  {
    if (c == null) {
      c = new jn(paramContext, paramfv);
    }
    return c;
  }
  
  private static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(fp.w(paramContext));
    return ho.a(paramContext, localStringBuilder.toString());
  }
  
  protected final String a()
  {
    return "j";
  }
  
  public final String a(String paramString)
    throws kd
  {
    paramString = a(this.a, paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return this.b.a(h()).b(paramString).a();
    }
    throw new kd("Wrong so file name");
  }
  
  public final String b(String paramString)
  {
    paramString = a(this.a, paramString);
    return this.b.a(i()).b(paramString).a();
  }
  
  public final String c(String paramString)
  {
    paramString = a(this.a, paramString);
    return this.b.a(h()).b(paramString).a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */