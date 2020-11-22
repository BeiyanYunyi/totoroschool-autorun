package com.pgyersdk.feedback;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.c.b;

class j
  extends Handler
{
  j(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 20001)
    {
      if (i == 20002) {
        Toast.makeText(PgyerProvider.a, b.a(1059), 0).show();
      }
    }
    else
    {
      k.b(this.a);
      Toast.makeText(PgyerProvider.a, b.a(1058), 0).show();
    }
    this.a.c();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */