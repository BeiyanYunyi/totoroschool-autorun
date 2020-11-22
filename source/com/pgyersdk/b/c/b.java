package com.pgyersdk.b.c;

import android.view.View;
import android.view.WindowManager.LayoutParams;

public class b
{
  private final View a;
  private final WindowManager.LayoutParams b;
  private final int c;
  private final int d;
  
  public b(View paramView, WindowManager.LayoutParams paramLayoutParams)
  {
    this.a = paramView;
    this.b = paramLayoutParams;
    paramLayoutParams = new int[2];
    paramView.getLocationOnScreen(paramLayoutParams);
    this.c = paramLayoutParams[0];
    this.d = paramLayoutParams[1];
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public View d()
  {
    return this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */