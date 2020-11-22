package android.support.v7.widget;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface FitWindowsViewGroup
{
  public abstract void setOnFitSystemWindowsListener(OnFitSystemWindowsListener paramOnFitSystemWindowsListener);
  
  public static abstract interface OnFitSystemWindowsListener
  {
    public abstract void onFitSystemWindows(Rect paramRect);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\FitWindowsViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */