package com.bumptech.glide.manager;

import android.content.Context;

public class d
{
  public c a(Context paramContext, c.a parama)
  {
    int i;
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new e(paramContext, parama);
    }
    return new i();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\manager\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */