package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public final class ka
{
  public final void a(final Context paramContext, final fv paramfv)
  {
    if (paramContext != null)
    {
      if (paramfv == null) {
        return;
      }
      final jn localjn = new jn(paramContext, paramfv);
      final jk localjk = new jk(paramContext, paramfv);
      final jm localjm = new jm(paramContext, paramfv);
      hb.b().a().submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            ka.a(ka.this, paramContext, paramfv, localjm, localjn, localjk);
            return;
          }
          catch (Throwable localThrowable)
          {
            ho.a(localThrowable, "cfa");
          }
        }
      });
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */