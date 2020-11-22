package com.amap.api.mapcore.util;

import android.content.Context;

public final class jk
  extends jj
{
  public jk(Context paramContext, fv paramfv)
  {
    super(paramContext, paramfv);
  }
  
  protected final String a()
  {
    return "h";
  }
  
  public final String b()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder("dex");
    localStringBuilder.append(fp.w((Context)localObject));
    localStringBuilder.append(c());
    localObject = fs.b(localStringBuilder.toString());
    return this.b.a(e()).b((String)localObject).a();
  }
  
  public final String l()
  {
    kf localkf = this.b.a(e());
    StringBuilder localStringBuilder = new StringBuilder("workopt");
    localStringBuilder.append(fp.w(this.a));
    return localkf.b(fs.b(localStringBuilder.toString())).a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */