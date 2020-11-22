package com.pgyersdk.update;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.graphics.Color;
import android.widget.TextView;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.c.b;
import com.pgyersdk.update.javabean.AppBean;

class i
  implements UpdateManagerListener
{
  private static volatile AlertDialog a;
  private boolean b = false;
  
  i(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private Dialog a(AppBean paramAppBean)
  {
    String str1 = b.a(514);
    if (!paramAppBean.getReleaseNote().equals("")) {
      str1 = paramAppBean.getReleaseNote();
    }
    String str2 = paramAppBean.getDownloadURL();
    if (PgyerActivityManager.getInstance().getCurrentActivity() == null)
    {
      com.pgyersdk.f.f.d("PgyerSDK", "There is get current activity is null, please check your config");
      return null;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(PgyerActivityManager.getInstance().getCurrentActivity());
    localBuilder.setTitle(b.a(513));
    TextView localTextView = new TextView(PgyerActivityManager.getInstance().getCurrentActivity());
    localTextView.setText(b.a(513));
    localTextView.setTextSize(22.0F);
    localTextView.setTextColor(Color.parseColor("#56bc94"));
    boolean bool2 = false;
    localTextView.setPadding(30, 20, 0, 20);
    localTextView.setBackgroundColor(Color.parseColor("#56bc94"));
    localBuilder.setMessage(str1);
    boolean bool1 = bool2;
    if (!this.b)
    {
      bool1 = bool2;
      if (!paramAppBean.isShouldForceToUpdate()) {
        bool1 = true;
      }
    }
    if (bool1) {
      localBuilder.setNegativeButton(b.a(515), new f(this));
    }
    localBuilder.setPositiveButton(b.a(516), new g(this, str2));
    localBuilder.setCancelable(bool1);
    a = localBuilder.create();
    a.setOnDismissListener(new h(this));
    return a;
  }
  
  void b()
  {
    if (a != null)
    {
      a.dismiss();
      a = null;
    }
  }
  
  public void checkUpdateFailed(Exception paramException) {}
  
  public void onNoUpdateAvailable() {}
  
  public void onUpdateAvailable(AppBean paramAppBean)
  {
    if (a == null)
    {
      a(paramAppBean);
      if (a != null) {
        a.show();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */