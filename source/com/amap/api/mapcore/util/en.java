package com.amap.api.mapcore.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

abstract class en
  extends Dialog
{
  public en(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  protected abstract void a();
  
  protected void b()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.requestFeature(1);
      a();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = -1;
        localLayoutParams.height = -2;
        localLayoutParams.gravity = 80;
      }
      localWindow.setAttributes(localLayoutParams);
      localWindow.setBackgroundDrawableResource(17170445);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */