package com.totoro.school.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadProgressDialog
  extends Activity
{
  private static DownloadProgressDialog b = new DownloadProgressDialog();
  private Context a;
  private Dialog c;
  private TextView d;
  private TextView e;
  private ProgressBar f;
  
  public static DownloadProgressDialog a()
  {
    return b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (this.c.isShowing()))
    {
      TextView localTextView = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      int i = paramInt1 * 100 / paramInt2;
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
      this.f.setProgress(i);
      localTextView = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("KB/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("KB)");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    this.c = new Dialog(this.a, 2131755511);
    this.c.setContentView(2131493000);
    this.c.setCancelable(false);
    this.d = ((TextView)this.c.findViewById(2131296522));
    this.e = ((TextView)this.c.findViewById(2131296520));
    this.f = ((ProgressBar)this.c.findViewById(2131296518));
    if ((this.c != null) && (!this.c.isShowing())) {
      this.c.show();
    }
  }
  
  public void c()
  {
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(new LinearLayout(this));
    b = this;
    this.a = this;
    b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\DownloadProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */