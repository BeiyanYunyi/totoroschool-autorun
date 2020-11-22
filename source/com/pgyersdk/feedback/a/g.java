package com.pgyersdk.feedback.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Date;

class g
  extends Handler
{
  g(m paramm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 20004: 
    default: 
      return;
    case 20006: 
      m.a(this.a, new Date().getTime());
      i = (int)(m.e(this.a) - (m.a(this.a) - m.b(this.a))) / 1000;
      if (i <= 0)
      {
        m.h(this.a);
        m.i(this.a).setVisibility(8);
        m.j(this.a).setVisibility(0);
        paramMessage = this.a;
        m.a(paramMessage, m.i(paramMessage));
      }
      else
      {
        m.f(this.a).sendEmptyMessageDelayed(20006, 1000L);
      }
      this.a.w.a(-1, i);
      return;
    case 20005: 
      i = Integer.valueOf(paramMessage.obj.toString()).intValue();
      m.a(this.a, new Date().getTime());
      paramMessage = new StringBuilder();
      paramMessage.append((m.a(this.a) - m.b(this.a)) / 1000L);
      paramMessage.append(" ");
      paramMessage.append((m.e(this.a) - 10000) / 1000);
      Log.i("duration", paramMessage.toString());
      if ((m.a(this.a) - m.b(this.a)) / 1000L >= (m.e(this.a) - 10000) / 1000)
      {
        paramMessage = this.a;
        paramMessage.w.a(-1, (int)(m.e(paramMessage) - (m.a(this.a) - m.b(this.a))) / 1000);
        m.f(this.a).removeMessages(20005);
        m.f(this.a).sendEmptyMessageDelayed(20006, 1000L);
        return;
      }
      this.a.w.a(i, -1);
      m.g(this.a);
      return;
    }
    int i = Integer.valueOf(paramMessage.obj.toString()).intValue();
    this.a.j.a(i % 3 + 1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */