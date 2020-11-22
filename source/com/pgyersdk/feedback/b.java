package com.pgyersdk.feedback;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.LinearLayout;

class b
  implements View.OnClickListener
{
  b(d paramd) {}
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject1 = (d.a)paramView.getTag();
    this.a.g.setColor(((d.a)localObject1).a);
    localObject1 = this.a;
    Object localObject2 = ((d)localObject1).t;
    if (localObject2 != null)
    {
      ((ObjectAnimator)localObject2).start();
    }
    else
    {
      localObject2 = ((d)localObject1).v;
      if (localObject2 != null) {
        ((d)localObject1).h.startAnimation((Animation)localObject2);
      }
    }
    d.a(this.a, false);
    d.a(this.a, paramView);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */