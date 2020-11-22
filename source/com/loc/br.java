package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public class br
{
  static WeakReference<bp> a;
  
  public static void a(Context paramContext)
  {
    aj.d().submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          bp localbp = bw.a(br.a);
          bw.a(this.a, localbp, ah.j, 50, 102400, "10");
          if (localbp.g == null)
          {
            String str = br.b(this.a);
            localbp.g = new ca(new bz(this.a, new ce(), new z(new ad(new ab())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", new Object[] { l.b(this.a), l.c(this.a), str }));
          }
          localbp.h = 14400000;
          if (TextUtils.isEmpty(localbp.i)) {
            localbp.i = "eKey";
          }
          if (localbp.f == null) {
            localbp.f = new ci(this.a, localbp.h, localbp.i, new cf(5, localbp.a, new ck(this.a)));
          }
          bq.a(localbp);
          return;
        }
        finally {}
      }
    });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */