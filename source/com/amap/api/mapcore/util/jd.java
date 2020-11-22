package com.amap.api.mapcore.util;

import android.content.Context;

public class jd
  extends jc
{
  private Context b;
  private boolean c = false;
  
  public jd(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = paramBoolean;
  }
  
  protected boolean a()
  {
    int i = fp.s(this.b);
    boolean bool = true;
    if (i != 1)
    {
      if (this.c) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */