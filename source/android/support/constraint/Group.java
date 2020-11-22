package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.util.AttributeSet;
import android.view.View;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext)
  {
    super(paramContext);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mUseViewMeasure = false;
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout)
  {
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    paramConstraintLayout.widget.setWidth(0);
    paramConstraintLayout.widget.setHeight(0);
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    int j = getVisibility();
    float f;
    if (Build.VERSION.SDK_INT >= 21) {
      f = getElevation();
    } else {
      f = 0.0F;
    }
    int i = 0;
    while (i < this.mCount)
    {
      View localView = paramConstraintLayout.getViewById(this.mIds[i]);
      if (localView != null)
      {
        localView.setVisibility(j);
        if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
          localView.setElevation(f);
        }
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */