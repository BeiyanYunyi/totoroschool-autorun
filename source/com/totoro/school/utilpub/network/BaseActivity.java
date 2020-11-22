package com.totoro.school.utilpub.network;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

public class BaseActivity
  extends AppCompatActivity
  implements c
{
  private ProgressDialog a;
  
  public void a(String paramString, Object paramObject) {}
  
  public void a(String paramString, Throwable paramThrowable) {}
  
  public void a_(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (isFinishing()) {
        return;
      }
      b(paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.a == null) {
      this.a = new ProgressDialog(this);
    }
    this.a.setMessage(paramString);
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  public void d_()
  {
    g();
  }
  
  public void g()
  {
    if (this.a != null)
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */