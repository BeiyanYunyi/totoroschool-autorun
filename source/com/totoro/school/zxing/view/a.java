package com.totoro.school.zxing.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

public final class a
  implements ResultPointCallback
{
  private final ViewfinderView a;
  
  public a(ViewfinderView paramViewfinderView)
  {
    this.a = paramViewfinderView;
  }
  
  public void foundPossibleResultPoint(ResultPoint paramResultPoint)
  {
    this.a.a(paramResultPoint);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */