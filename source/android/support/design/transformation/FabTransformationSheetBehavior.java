package android.support.design.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.design.R.animator;
import android.support.design.animation.MotionSpec;
import android.support.design.animation.Positioning;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  private Map<View, Integer> importantForAccessibilityMap;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void updateImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int k = ((CoordinatorLayout)localObject).getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      this.importantForAccessibilityMap = new HashMap(k);
    }
    int i = 0;
    while (i < k)
    {
      View localView = ((CoordinatorLayout)localObject).getChildAt(i);
      int j;
      if (((localView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior))) {
        j = 1;
      } else {
        j = 0;
      }
      if ((localView != paramView) && (j == 0)) {
        if (!paramBoolean)
        {
          if ((this.importantForAccessibilityMap != null) && (this.importantForAccessibilityMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)this.importantForAccessibilityMap.get(localView)).intValue());
          }
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 16) {
            this.importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          ViewCompat.setImportantForAccessibility(localView, 4);
        }
      }
      i += 1;
    }
    if (!paramBoolean) {
      this.importantForAccessibilityMap = null;
    }
  }
  
  protected FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    }
    FabTransformationBehavior.FabTransformationSpec localFabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
    localFabTransformationSpec.timings = MotionSpec.createFromResource(paramContext, i);
    localFabTransformationSpec.positioning = new Positioning(17, 0.0F, 0.0F);
    return localFabTransformationSpec;
  }
  
  @CallSuper
  protected boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateImportantForAccessibility(paramView2, paramBoolean1);
    return super.onExpandedStateChange(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\transformation\FabTransformationSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */