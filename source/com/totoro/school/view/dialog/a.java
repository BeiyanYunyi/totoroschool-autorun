package com.totoro.school.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class a
  extends Dialog
{
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    Window localWindow = getWindow();
    localWindow.setGravity(80);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.y = 0;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */