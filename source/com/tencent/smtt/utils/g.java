package com.tencent.smtt.utils;

import android.widget.TextView;

class g
  implements Runnable
{
  g(e parame, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = this.b.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已下载");
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */