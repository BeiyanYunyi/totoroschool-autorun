package com.pgyersdk;

import com.pgyersdk.f.f;
import com.pgyersdk.f.l;

public class Pgyer
{
  public static void setAppId(String paramString)
  {
    com.pgyersdk.c.a.l = l.c(paramString);
    if (!l.a()) {
      f.b("PgyerSDK", "Please config correct AppId");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\Pgyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */