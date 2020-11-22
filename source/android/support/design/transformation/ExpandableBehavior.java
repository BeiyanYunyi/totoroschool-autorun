package android.support.design.transformation;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.design.expandable.ExpandableWidget;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

public abstract class ExpandableBehavior
  extends CoordinatorLayout.Behavior<View>
{
  private static final int STATE_COLLAPSED = 2;
  private static final int STATE_EXPANDED = 1;
  private static final int STATE_UNINITIALIZED = 0;
  private int currentState = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean didStateChange(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      if (this.currentState != 0)
      {
        paramBoolean = bool1;
        if (this.currentState != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramBoolean = bool2;
    if (this.currentState == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static <T extends ExpandableBehavior> T from(View paramView, Class<T> paramClass)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.LayoutParams))
    {
      paramView = ((CoordinatorLayout.LayoutParams)paramView).getBehavior();
      if ((paramView instanceof ExpandableBehavior)) {
        return (ExpandableBehavior)paramClass.cast(paramView);
      }
      throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  @Nullable
  protected ExpandableWidget findExpandableWidget(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramView);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if (layoutDependsOn(paramCoordinatorLayout, paramView, localView)) {
        return (ExpandableWidget)localView;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  @CallSuper
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (ExpandableWidget)paramView2;
    if (didStateChange(paramCoordinatorLayout.isExpanded()))
    {
      int i;
      if (paramCoordinatorLayout.isExpanded()) {
        i = 1;
      } else {
        i = 2;
      }
      this.currentState = i;
      return onExpandedStateChange((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.isExpanded(), true);
    }
    return false;
  }
  
  protected abstract boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  @CallSuper
  public boolean onLayoutChild(final CoordinatorLayout paramCoordinatorLayout, final View paramView, final int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView))
    {
      paramCoordinatorLayout = findExpandableWidget(paramCoordinatorLayout, paramView);
      if ((paramCoordinatorLayout != null) && (didStateChange(paramCoordinatorLayout.isExpanded())))
      {
        if (paramCoordinatorLayout.isExpanded()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        this.currentState = paramInt;
        paramInt = this.currentState;
        paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            paramView.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.currentState == paramInt) {
              ExpandableBehavior.this.onExpandedStateChange((View)paramCoordinatorLayout, paramView, paramCoordinatorLayout.isExpanded(), false);
            }
            return false;
          }
        });
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\transformation\ExpandableBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */