package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

class bf
{
  private DexLoader a = null;
  
  public bf(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public String a(Context paramContext)
  {
    if (this.a != null)
    {
      Object localObject = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null)
      {
        paramContext = this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[] { Context.class }, new Object[] { paramContext });
        if (paramContext != null) {
          return String.valueOf(paramContext);
        }
      }
    }
    return "";
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (this.a != null)
    {
      Object localObject = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null) {
        this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */