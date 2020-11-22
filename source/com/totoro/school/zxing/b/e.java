package com.totoro.school.zxing.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class e
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, Runnable
{
  private final Activity a;
  
  public e(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    run();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    run();
  }
  
  public void run()
  {
    this.a.finish();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */