package com.pgyersdk.update;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g
  implements DialogInterface.OnClickListener
{
  g(i parami, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      PgyUpdateManager.downLoadApk(this.a);
      i.a().dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */