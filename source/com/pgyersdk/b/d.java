package com.pgyersdk.b;

import android.app.Activity;
import android.net.Uri;
import java.lang.ref.WeakReference;

public class d
{
  public static void a(Activity paramActivity, a parama)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        WeakReference localWeakReference = new WeakReference(paramActivity);
        g.a((Activity)localWeakReference.get()).a(new c(paramActivity, parama, localWeakReference)).a();
      }
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(Uri paramUri);
    
    public abstract void a(Throwable paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */