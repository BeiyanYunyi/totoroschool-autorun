package com.pgyersdk.update;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class d
  implements DialogInterface.OnClickListener
{
  d(e parame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PgyUpdateManager.downLoadApk(b.a);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */