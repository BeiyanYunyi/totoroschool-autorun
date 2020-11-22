package com.pgyersdk.feedback;

import android.net.Uri;
import com.pgyersdk.b.d.a;

class f
  implements d.a
{
  f(k paramk) {}
  
  public void a(Uri paramUri)
  {
    k.a(paramUri.getPath());
    k.a(this.a);
  }
  
  public void a(Throwable paramThrowable)
  {
    this.a.c();
    com.pgyersdk.f.f.a("PgyerSDK", "Take screen shot failed", paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */