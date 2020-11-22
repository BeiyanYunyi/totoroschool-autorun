package com.pgyersdk.f;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class b
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F) + 0.5F);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */