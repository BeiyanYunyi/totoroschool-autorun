package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public class jb
  extends jc
{
  private int b;
  private long c;
  private String d;
  private Context e;
  
  public jb(Context paramContext, int paramInt, String paramString, jc paramjc)
  {
    super(paramjc);
    this.b = paramInt;
    this.d = paramString;
    this.e = paramContext;
  }
  
  private long a(String paramString)
  {
    paramString = gh.a(this.e, paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return Long.parseLong(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    this.c = paramLong;
    gh.a(this.e, paramString, String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      a(this.d, System.currentTimeMillis());
    }
  }
  
  protected boolean a()
  {
    if (this.c == 0L) {
      this.c = a(this.d);
    }
    return System.currentTimeMillis() - this.c >= this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */