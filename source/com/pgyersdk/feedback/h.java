package com.pgyersdk.feedback;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.b.e;
import com.pgyersdk.c.b;
import com.pgyersdk.feedback.a.m;

class h
  implements DialogInterface.OnClickListener
{
  h(k paramk, m paramm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    k.a(this.a.q);
    if ((!com.pgyersdk.f.k.a(this.a.c().getText().toString())) || (k.b() != null) || (!com.pgyersdk.f.k.a(this.a.d().getText().toString().trim()))) {
      Toast.makeText(PgyerProvider.a, b.a(1056), 0).show();
    }
    if (k.a() != null) {
      e.a(k.a());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */