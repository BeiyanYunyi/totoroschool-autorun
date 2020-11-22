package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class kc
{
  private volatile kb a = null;
  
  public final void a(Context paramContext, List<fv> paramList)
  {
    if (paramContext != null) {
      if (paramList == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        this.a = kb.a(jg.a(paramContext, "36a9719e2b54d2a5bebe02b32d36416b", "i"));
        i = 0;
        if (i < paramList.size())
        {
          fv localfv = (fv)paramList.get(i);
          if (localfv == null) {
            break label92;
          }
          this.a.a(localfv.a(), localfv.c());
          break label92;
        }
        jg.a(paramContext, "36a9719e2b54d2a5bebe02b32d36416b", "i", this.a.b());
        return;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      return;
      label92:
      i += 1;
    }
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (this.a == null) {
      this.a = kb.a(jg.a(paramContext, "36a9719e2b54d2a5bebe02b32d36416b", "i"));
    }
    paramContext = this.a;
    if ((paramContext != null) && (paramContext.a() != null))
    {
      if (paramContext.a().size() == 0) {
        return false;
      }
      paramContext = paramContext.a().iterator();
      while (paramContext.hasNext())
      {
        kb.a locala = (kb.a)paramContext.next();
        String str = locala.a();
        boolean bool;
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str))) {
          bool = paramString1.trim().equalsIgnoreCase(str.trim());
        } else {
          bool = false;
        }
        if ((bool) && (jh.b(paramString2, locala.b()))) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */