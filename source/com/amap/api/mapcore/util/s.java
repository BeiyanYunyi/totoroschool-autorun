package com.amap.api.mapcore.util;

import android.content.Context;

public class s
  extends r
{
  public s(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public float l()
  {
    return (float)((Math.atan2(i(), h()) - Math.atan2(f(), e())) * 180.0D / 3.141592653589793D);
  }
  
  public static abstract class a
    implements r.a
  {
    public boolean a(r paramr)
    {
      return a((s)paramr);
    }
    
    public abstract boolean a(s params);
    
    public boolean b(r paramr)
    {
      return b((s)paramr);
    }
    
    public abstract boolean b(s params);
    
    public void c(r paramr)
    {
      c((s)paramr);
    }
    
    public abstract void c(s params);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */