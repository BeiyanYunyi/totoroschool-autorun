package com.pgyersdk.feedback.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.c.b;
import com.pgyersdk.f.h;
import com.pgyersdk.f.l;
import java.io.File;
import java.util.Date;

class i
  implements View.OnTouchListener
{
  i(m paramm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!l.d())
    {
      Toast.makeText(PgyerProvider.a, b.a(1074), 0).show();
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 1: 
    case 3: 
      m.b(this.a, new Date().getTime());
      m.i(this.a).setText(b.a(1072));
      m.h(this.a);
      if (m.c(this.a) - m.b(this.a) < 1000L)
      {
        Toast.makeText(PgyerProvider.a, b.a(1075), 0).show();
        paramMotionEvent = this.a;
        paramMotionEvent.q = null;
        m.i(paramMotionEvent).setVisibility(0);
        m.j(this.a).setVisibility(8);
      }
      else
      {
        m.i(this.a).setVisibility(8);
        m.j(this.a).setVisibility(0);
        paramMotionEvent = this.a.q;
        if (paramMotionEvent != null)
        {
          h.a("voicefile", paramMotionEvent.getAbsolutePath());
          h.a("voiceTime", this.a.j.getText().toString());
        }
      }
      m.a(this.a, paramView);
      return false;
    case 0: 
      m.k(this.a);
      m.i(this.a).setText(b.a(1073));
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */