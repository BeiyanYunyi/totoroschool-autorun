package com.amap.api.mapcore.util;

import android.content.Context;

public final class ji
  extends jj
{
  private static ji c;
  
  public ji(Context paramContext, fv paramfv)
  {
    super(paramContext, paramfv);
  }
  
  public static ji a(Context paramContext, fv paramfv)
  {
    if (c == null) {
      c = new ji(paramContext, paramfv);
    }
    return c;
  }
  
  protected final String a()
  {
    return "q";
  }
  
  public final String b()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder("assets");
    localStringBuilder.append(fp.w((Context)localObject));
    localStringBuilder.append(c());
    localObject = fs.b(localStringBuilder.toString());
    return this.b.a(e()).b((String)localObject).a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */