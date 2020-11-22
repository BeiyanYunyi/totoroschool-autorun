package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup
{
  public List<ConstraintWidget> mConstrainedGroup;
  public final int[] mGroupDimensions = { this.mGroupWidth, this.mGroupHeight };
  int mGroupHeight = -1;
  int mGroupWidth = -1;
  public boolean mSkipSolver = false;
  List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
  List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
  List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
  HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet();
  HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet();
  List<ConstraintWidget> mWidgetsToSolve = new ArrayList();
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList)
  {
    this.mConstrainedGroup = paramList;
  }
  
  ConstraintWidgetGroup(List<ConstraintWidget> paramList, boolean paramBoolean)
  {
    this.mConstrainedGroup = paramList;
    this.mSkipSolver = paramBoolean;
  }
  
  private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> paramArrayList, ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mGroupsToSolver) {
      return;
    }
    paramArrayList.add(paramConstraintWidget);
    paramConstraintWidget.mGroupsToSolver = true;
    if (paramConstraintWidget.isFullyResolved()) {
      return;
    }
    boolean bool = paramConstraintWidget instanceof Helper;
    int j = 0;
    Object localObject;
    if (bool)
    {
      localObject = (Helper)paramConstraintWidget;
      k = ((Helper)localObject).mWidgetsCount;
      i = 0;
      while (i < k)
      {
        getWidgetsToSolveTraversal(paramArrayList, localObject.mWidgets[i]);
        i += 1;
      }
    }
    int k = paramConstraintWidget.mListAnchors.length;
    int i = j;
    while (i < k)
    {
      localObject = paramConstraintWidget.mListAnchors[i].mTarget;
      if (localObject != null)
      {
        ConstraintWidget localConstraintWidget = ((ConstraintAnchor)localObject).mOwner;
        if ((localObject != null) && (localConstraintWidget != paramConstraintWidget.getParent())) {
          getWidgetsToSolveTraversal(paramArrayList, localConstraintWidget);
        }
      }
      i += 1;
    }
  }
  
  private void updateResolvedDimension(ConstraintWidget paramConstraintWidget)
  {
    if (paramConstraintWidget.mOptimizerMeasurable)
    {
      if (paramConstraintWidget.isFullyResolved()) {
        return;
      }
      ConstraintAnchor localConstraintAnchor = paramConstraintWidget.mRight.mTarget;
      int k = 0;
      if (localConstraintAnchor != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        localConstraintAnchor = paramConstraintWidget.mRight.mTarget;
      } else {
        localConstraintAnchor = paramConstraintWidget.mLeft.mTarget;
      }
      if (localConstraintAnchor != null)
      {
        if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
          updateResolvedDimension(localConstraintAnchor.mOwner);
        }
        if (localConstraintAnchor.mType == ConstraintAnchor.Type.RIGHT)
        {
          i = localConstraintAnchor.mOwner.mX;
          i = localConstraintAnchor.mOwner.getWidth() + i;
          break label148;
        }
        if (localConstraintAnchor.mType == ConstraintAnchor.Type.LEFT)
        {
          i = localConstraintAnchor.mOwner.mX;
          break label148;
        }
      }
      int i = 0;
      label148:
      if (j != 0) {
        i -= paramConstraintWidget.mRight.getMargin();
      } else {
        i += paramConstraintWidget.mLeft.getMargin() + paramConstraintWidget.getWidth();
      }
      paramConstraintWidget.setHorizontalDimension(i - paramConstraintWidget.getWidth(), i);
      if (paramConstraintWidget.mBaseline.mTarget != null)
      {
        localConstraintAnchor = paramConstraintWidget.mBaseline.mTarget;
        if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
          updateResolvedDimension(localConstraintAnchor.mOwner);
        }
        i = localConstraintAnchor.mOwner.mY + localConstraintAnchor.mOwner.mBaselineDistance - paramConstraintWidget.mBaselineDistance;
        paramConstraintWidget.setVerticalDimension(i, paramConstraintWidget.mHeight + i);
        paramConstraintWidget.mOptimizerMeasured = true;
        return;
      }
      if (paramConstraintWidget.mBottom.mTarget != null) {
        k = 1;
      }
      if (k != 0) {
        localConstraintAnchor = paramConstraintWidget.mBottom.mTarget;
      } else {
        localConstraintAnchor = paramConstraintWidget.mTop.mTarget;
      }
      int j = i;
      if (localConstraintAnchor != null)
      {
        if (!localConstraintAnchor.mOwner.mOptimizerMeasured) {
          updateResolvedDimension(localConstraintAnchor.mOwner);
        }
        if (localConstraintAnchor.mType == ConstraintAnchor.Type.BOTTOM)
        {
          j = localConstraintAnchor.mOwner.mY + localConstraintAnchor.mOwner.getHeight();
        }
        else
        {
          j = i;
          if (localConstraintAnchor.mType == ConstraintAnchor.Type.TOP) {
            j = localConstraintAnchor.mOwner.mY;
          }
        }
      }
      if (k != 0) {
        i = j - paramConstraintWidget.mBottom.getMargin();
      } else {
        i = j + (paramConstraintWidget.mTop.getMargin() + paramConstraintWidget.getHeight());
      }
      paramConstraintWidget.setVerticalDimension(i - paramConstraintWidget.getHeight(), i);
      paramConstraintWidget.mOptimizerMeasured = true;
    }
  }
  
  void addWidgetsToSet(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      this.mWidgetsToSetHorizontal.add(paramConstraintWidget);
      return;
    }
    if (paramInt == 1) {
      this.mWidgetsToSetVertical.add(paramConstraintWidget);
    }
  }
  
  public List<ConstraintWidget> getStartWidgets(int paramInt)
  {
    if (paramInt == 0) {
      return this.mStartHorizontalWidgets;
    }
    if (paramInt == 1) {
      return this.mStartVerticalWidgets;
    }
    return null;
  }
  
  Set<ConstraintWidget> getWidgetsToSet(int paramInt)
  {
    if (paramInt == 0) {
      return this.mWidgetsToSetHorizontal;
    }
    if (paramInt == 1) {
      return this.mWidgetsToSetVertical;
    }
    return null;
  }
  
  List<ConstraintWidget> getWidgetsToSolve()
  {
    if (!this.mWidgetsToSolve.isEmpty()) {
      return this.mWidgetsToSolve;
    }
    int j = this.mConstrainedGroup.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mConstrainedGroup.get(i);
      if (!localConstraintWidget.mOptimizerMeasurable) {
        getWidgetsToSolveTraversal((ArrayList)this.mWidgetsToSolve, localConstraintWidget);
      }
      i += 1;
    }
    this.mUnresolvedWidgets.clear();
    this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
    this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
    return this.mWidgetsToSolve;
  }
  
  void updateUnresolvedWidgets()
  {
    int j = this.mUnresolvedWidgets.size();
    int i = 0;
    while (i < j)
    {
      updateResolvedDimension((ConstraintWidget)this.mUnresolvedWidgets.get(i));
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidgetGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */