package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.compat.R.id;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat
{
  public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
  public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
  
  public static int getLayoutMode(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramViewGroup.getLayoutMode();
    }
    return 0;
  }
  
  public static int getNestedScrollAxes(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramViewGroup.getNestedScrollAxes();
    }
    if ((paramViewGroup instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewGroup).getNestedScrollAxes();
    }
    return 0;
  }
  
  public static boolean isTransitionGroup(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramViewGroup.isTransitionGroup();
    }
    Boolean localBoolean = (Boolean)paramViewGroup.getTag(R.id.tag_transition_group);
    return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (ViewCompat.getTransitionName(paramViewGroup) != null);
  }
  
  @Deprecated
  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewGroup.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void setLayoutMode(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramViewGroup.setLayoutMode(paramInt);
    }
  }
  
  @Deprecated
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup.setMotionEventSplittingEnabled(paramBoolean);
  }
  
  public static void setTransitionGroup(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramViewGroup.setTransitionGroup(paramBoolean);
      return;
    }
    paramViewGroup.setTag(R.id.tag_transition_group, Boolean.valueOf(paramBoolean));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\ViewGroupCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */