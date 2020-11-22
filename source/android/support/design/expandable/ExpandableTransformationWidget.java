package android.support.design.expandable;

import android.support.annotation.IdRes;

public abstract interface ExpandableTransformationWidget
  extends ExpandableWidget
{
  @IdRes
  public abstract int getExpandedComponentIdHint();
  
  public abstract void setExpandedComponentIdHint(@IdRes int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\expandable\ExpandableTransformationWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */