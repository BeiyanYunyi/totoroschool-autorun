package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

public class hm
{
  private Context a;
  private fv b;
  private boolean c = true;
  private String d = "40C27E38DCAD404B5465362914090908";
  private kh e = new kh(this.d);
  
  public void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    try
    {
      paramString1 = new fv.a(paramString1, paramString2, paramString1).a(paramArrayOfString).a(paramString3).a();
      if (paramContext != null)
      {
        if (paramString1 == null) {
          return;
        }
        hn.a().a(paramContext, paramString1);
        this.a = paramContext.getApplicationContext();
        this.b = paramString1;
        this.c = paramBoolean;
        this.e.a(this.a, paramString1);
        return;
      }
      return;
    }
    catch (fj paramContext) {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    hn.a().a(paramString1);
    List localList = this.e.a(this.a);
    ho.a.a.a(this.a, paramString1, paramString2, localList, this.c, this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */