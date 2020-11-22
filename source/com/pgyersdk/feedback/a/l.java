package com.pgyersdk.feedback.a;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class l
  extends TimerTask
{
  int a = 0;
  
  l(m paramm) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 20003;
    localMessage.obj = Integer.valueOf(this.a);
    m.f(this.b).sendMessage(localMessage);
    this.a += 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */