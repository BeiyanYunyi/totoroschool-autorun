package com.pgyersdk.feedback;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.pgyersdk.feedback.a.m;

class i
  implements DialogInterface.OnDismissListener
{
  i(k paramk, m paramm) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.b.c();
    k.a(this.b, this.a);
    paramDialogInterface.dismiss();
    this.a.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */