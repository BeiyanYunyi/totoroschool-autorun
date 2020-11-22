package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public final class hp
{
  private static HashMap<String, String> a = new HashMap();
  
  public static String a(Context paramContext, fv paramfv, String paramString)
  {
    if ((paramfv != null) && (!TextUtils.isEmpty(paramfv.a())))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramfv.a());
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      localObject = (String)a.get(localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return (String)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramfv.a());
      return jg.a(paramContext, "d7afbc6a38848a6801f6e449f3ec8e53", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static void a(Context paramContext, fv paramfv, String paramString1, String paramString2)
  {
    if (paramfv != null)
    {
      if (TextUtils.isEmpty(paramfv.a())) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramfv.a());
      localObject = ((StringBuilder)localObject).toString();
      HashMap localHashMap = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramfv.a());
      localStringBuilder.append(paramString1);
      localHashMap.put(localStringBuilder.toString(), paramString2);
      jg.a(paramContext, "d7afbc6a38848a6801f6e449f3ec8e53", (String)localObject, paramString2);
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */