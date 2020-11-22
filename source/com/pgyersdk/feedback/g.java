package com.pgyersdk.feedback;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import com.pgyersdk.feedback.a.m;

class g
  implements DialogInterface.OnClickListener
{
  g(k paramk, m paramm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    k.a(this.a.q);
    this.b.a(this.a.d().getText().toString(), this.a.c().getText().toString(), k.a(), k.b(), Boolean.valueOf(this.a.b().isChecked()));
    paramDialogInterface.dismiss();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */