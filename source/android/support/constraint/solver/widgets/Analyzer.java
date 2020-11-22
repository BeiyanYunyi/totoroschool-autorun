package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Analyzer
{
  public static void determineGroups(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    if ((paramConstraintWidgetContainer.getOptimizationLevel() & 0x20) != 32)
    {
      singleGroup(paramConstraintWidgetContainer);
      return;
    }
    paramConstraintWidgetContainer.mSkipSolver = true;
    paramConstraintWidgetContainer.mGroupsWrapOptimized = false;
    paramConstraintWidgetContainer.mHorizontalWrapOptimized = false;
    paramConstraintWidgetContainer.mVerticalWrapOptimized = false;
    Object localObject1 = paramConstraintWidgetContainer.mChildren;
    List localList = paramConstraintWidgetContainer.mWidgetGroups;
    int i;
    if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool;
    if ((i == 0) && (j == 0)) {
      bool = false;
    } else {
      bool = true;
    }
    localList.clear();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)((Iterator)localObject2).next();
      localConstraintWidget.mBelongingGroup = null;
      localConstraintWidget.mGroupsToSolver = false;
      localConstraintWidget.resetResolutionNodes();
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ConstraintWidget)((Iterator)localObject1).next();
      if ((((ConstraintWidget)localObject2).mBelongingGroup == null) && (!determineGroups((ConstraintWidget)localObject2, localList, bool)))
      {
        singleGroup(paramConstraintWidgetContainer);
        paramConstraintWidgetContainer.mSkipSolver = false;
        return;
      }
    }
    localObject1 = localList.iterator();
    int m = 0;
    for (int k = 0; ((Iterator)localObject1).hasNext(); k = Math.max(k, getMaxDimension((ConstraintWidgetGroup)localObject2, 1)))
    {
      localObject2 = (ConstraintWidgetGroup)((Iterator)localObject1).next();
      m = Math.max(m, getMaxDimension((ConstraintWidgetGroup)localObject2, 0));
    }
    if (i != 0)
    {
      paramConstraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setWidth(m);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mHorizontalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedWidth = m;
    }
    if (j != 0)
    {
      paramConstraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setHeight(k);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mVerticalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedHeight = k;
    }
    setPosition(localList, 0, paramConstraintWidgetContainer.getWidth());
    setPosition(localList, 1, paramConstraintWidgetContainer.getHeight());
  }
  
  private static boolean determineGroups(ConstraintWidget paramConstraintWidget, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    ConstraintWidgetGroup localConstraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
    paramList.add(localConstraintWidgetGroup);
    return traverse(paramConstraintWidget, localConstraintWidgetGroup, paramList, paramBoolean);
  }
  
  private static int getMaxDimension(ConstraintWidgetGroup paramConstraintWidgetGroup, int paramInt)
  {
    int k = paramInt * 2;
    List localList = paramConstraintWidgetGroup.getStartWidgets(paramInt);
    int m = localList.size();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)localList.get(i);
      ConstraintAnchor[] arrayOfConstraintAnchor = localConstraintWidget.mListAnchors;
      int n = k + 1;
      boolean bool;
      if ((arrayOfConstraintAnchor[n].mTarget != null) && ((localConstraintWidget.mListAnchors[k].mTarget == null) || (localConstraintWidget.mListAnchors[n].mTarget == null))) {
        bool = false;
      } else {
        bool = true;
      }
      j = Math.max(j, getMaxDimensionTraversal(localConstraintWidget, paramInt, bool, 0));
      i += 1;
    }
    paramConstraintWidgetGroup.mGroupDimensions[paramInt] = j;
    return j;
  }
  
  private static int getMaxDimensionTraversal(ConstraintWidget paramConstraintWidget, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = paramConstraintWidget.mOptimizerMeasurable;
    int i3 = 0;
    if (!bool) {
      return 0;
    }
    if ((paramConstraintWidget.mBaseline.mTarget != null) && (paramInt1 == 1)) {
      k = 1;
    } else {
      k = 0;
    }
    int j;
    int i;
    if (paramBoolean)
    {
      n = paramConstraintWidget.getBaselineDistance();
      i1 = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      j = paramInt1 * 2;
      i = j + 1;
    }
    else
    {
      n = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      i1 = paramConstraintWidget.getBaselineDistance();
      i = paramInt1 * 2;
      j = i + 1;
    }
    int m;
    if ((paramConstraintWidget.mListAnchors[i].mTarget != null) && (paramConstraintWidget.mListAnchors[j].mTarget == null))
    {
      i2 = j;
      m = -1;
      j = i;
      i = i2;
    }
    else
    {
      m = 1;
    }
    if (k != 0) {
      paramInt2 -= n;
    }
    int i5 = paramConstraintWidget.mListAnchors[j].getMargin() * m + getParentBiasOffset(paramConstraintWidget, paramInt1);
    int i2 = paramInt2 + i5;
    if (paramInt1 == 0) {
      paramInt2 = paramConstraintWidget.getWidth();
    } else {
      paramInt2 = paramConstraintWidget.getHeight();
    }
    int i6 = paramInt2 * m;
    Object localObject = paramConstraintWidget.mListAnchors[j].getResolutionNode().dependents.iterator();
    for (paramInt2 = i3; ((Iterator)localObject).hasNext(); paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject).next()).myAnchor.mOwner, paramInt1, paramBoolean, i2))) {}
    localObject = paramConstraintWidget.mListAnchors[i].getResolutionNode().dependents.iterator();
    for (i3 = 0; ((Iterator)localObject).hasNext(); i3 = Math.max(i3, getMaxDimensionTraversal(((ResolutionAnchor)((Iterator)localObject).next()).myAnchor.mOwner, paramInt1, paramBoolean, i6 + i2))) {}
    int i4;
    if (k != 0)
    {
      paramInt2 -= n;
      i4 = i3 + i1;
    }
    for (i3 = paramInt2;; i3 = paramInt2)
    {
      break;
      if (paramInt1 == 0) {
        i4 = paramConstraintWidget.getWidth();
      } else {
        i4 = paramConstraintWidget.getHeight();
      }
      i4 = i3 + i4 * m;
    }
    if (paramInt1 == 1)
    {
      localObject = paramConstraintWidget.mBaseline.getResolutionNode().dependents.iterator();
      paramInt2 = 0;
      while (((Iterator)localObject).hasNext())
      {
        ResolutionAnchor localResolutionAnchor = (ResolutionAnchor)((Iterator)localObject).next();
        if (m == 1) {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(localResolutionAnchor.myAnchor.mOwner, paramInt1, paramBoolean, n + i2));
        } else {
          paramInt2 = Math.max(paramInt2, getMaxDimensionTraversal(localResolutionAnchor.myAnchor.mOwner, paramInt1, paramBoolean, i1 * m + i2));
        }
      }
      if ((paramConstraintWidget.mBaseline.getResolutionNode().dependents.size() > 0) && (k == 0)) {
        if (m == 1) {
          paramInt2 += n;
        } else {
          paramInt2 -= i1;
        }
      }
    }
    else
    {
      paramInt2 = 0;
    }
    int i1 = Math.max(i3, Math.max(i4, paramInt2));
    int k = i2 + i6;
    int n = k;
    paramInt2 = i2;
    if (m == -1)
    {
      paramInt2 = k;
      n = i2;
    }
    if (paramBoolean)
    {
      Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, paramInt2);
      paramConstraintWidget.setFrame(paramInt2, n, paramInt1);
    }
    else
    {
      paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
      paramConstraintWidget.setRelativePositioning(paramInt2, paramInt1);
    }
    if ((paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio != 0.0F)) {
      paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
    }
    if ((paramConstraintWidget.mListAnchors[j].mTarget != null) && (paramConstraintWidget.mListAnchors[i].mTarget != null))
    {
      localObject = paramConstraintWidget.getParent();
      if ((paramConstraintWidget.mListAnchors[j].mTarget.mOwner == localObject) && (paramConstraintWidget.mListAnchors[i].mTarget.mOwner == localObject)) {
        paramConstraintWidget.mBelongingGroup.addWidgetsToSet(paramConstraintWidget, paramInt1);
      }
    }
    return i5 + i1;
  }
  
  private static int getParentBiasOffset(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    int i = paramInt * 2;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintWidget.mListAnchors[i];
    ConstraintAnchor localConstraintAnchor2 = paramConstraintWidget.mListAnchors[(i + 1)];
    if ((localConstraintAnchor1.mTarget != null) && (localConstraintAnchor1.mTarget.mOwner == paramConstraintWidget.mParent) && (localConstraintAnchor2.mTarget != null) && (localConstraintAnchor2.mTarget.mOwner == paramConstraintWidget.mParent))
    {
      i = paramConstraintWidget.mParent.getLength(paramInt);
      float f;
      if (paramInt == 0) {
        f = paramConstraintWidget.mHorizontalBiasPercent;
      } else {
        f = paramConstraintWidget.mVerticalBiasPercent;
      }
      paramInt = paramConstraintWidget.getLength(paramInt);
      return (int)((i - localConstraintAnchor1.getMargin() - localConstraintAnchor2.getMargin() - paramInt) * f);
    }
    return 0;
  }
  
  private static void invalidate(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup)
  {
    paramConstraintWidgetGroup.mSkipSolver = false;
    paramConstraintWidgetContainer.mSkipSolver = false;
    paramConstraintWidget.mOptimizerMeasurable = false;
  }
  
  private static int resolveDimensionRatio(ConstraintWidget paramConstraintWidget)
  {
    int i;
    if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (paramConstraintWidget.mDimensionRatioSide == 0) {
        i = (int)(paramConstraintWidget.getHeight() * paramConstraintWidget.mDimensionRatio);
      } else {
        i = (int)(paramConstraintWidget.getHeight() / paramConstraintWidget.mDimensionRatio);
      }
      paramConstraintWidget.setWidth(i);
      return i;
    }
    if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (paramConstraintWidget.mDimensionRatioSide == 1) {
        i = (int)(paramConstraintWidget.getWidth() * paramConstraintWidget.mDimensionRatio);
      } else {
        i = (int)(paramConstraintWidget.getWidth() / paramConstraintWidget.mDimensionRatio);
      }
      paramConstraintWidget.setHeight(i);
      return i;
    }
    return -1;
  }
  
  private static void setConnection(ConstraintAnchor paramConstraintAnchor)
  {
    ResolutionAnchor localResolutionAnchor = paramConstraintAnchor.getResolutionNode();
    if ((paramConstraintAnchor.mTarget != null) && (paramConstraintAnchor.mTarget.mTarget != paramConstraintAnchor)) {
      paramConstraintAnchor.mTarget.getResolutionNode().addDependent(localResolutionAnchor);
    }
  }
  
  public static void setPosition(List<ConstraintWidgetGroup> paramList, int paramInt1, int paramInt2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((ConstraintWidgetGroup)paramList.get(i)).getWidgetsToSet(paramInt1).iterator();
      while (localIterator.hasNext())
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)localIterator.next();
        if (localConstraintWidget.mOptimizerMeasurable) {
          updateSizeDependentWidgets(localConstraintWidget, paramInt1, paramInt2);
        }
      }
      i += 1;
    }
  }
  
  private static void singleGroup(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    paramConstraintWidgetContainer.mWidgetGroups.clear();
    paramConstraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(paramConstraintWidgetContainer.mChildren));
  }
  
  private static boolean traverse(ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup, List<ConstraintWidgetGroup> paramList, boolean paramBoolean)
  {
    if (paramConstraintWidget == null) {
      return true;
    }
    paramConstraintWidget.mOptimizerMeasured = false;
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
    if (paramConstraintWidget.mBelongingGroup == null)
    {
      paramConstraintWidget.mOptimizerMeasurable = true;
      paramConstraintWidgetGroup.mConstrainedGroup.add(paramConstraintWidget);
      paramConstraintWidget.mBelongingGroup = paramConstraintWidgetGroup;
      if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null) && (paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null) && (paramConstraintWidget.mBaseline.mTarget == null) && (paramConstraintWidget.mCenter.mTarget == null))
      {
        invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
      }
      Object localObject;
      if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        localConstraintWidgetContainer.getVerticalDimensionBehaviour();
        localObject = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mBottom.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        localConstraintWidgetContainer.getHorizontalDimensionBehaviour();
        localObject = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean)
        {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        }
        if ((paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget.getParent()) || (paramConstraintWidget.mRight.mTarget.mOwner != paramConstraintWidget.getParent())) {
          invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        }
      }
      if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        j = 1;
      } else {
        j = 0;
      }
      if (((i ^ j) != 0) && (paramConstraintWidget.mDimensionRatio != 0.0F))
      {
        resolveDimensionRatio(paramConstraintWidget);
      }
      else if ((paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
      }
      if (((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null)) || ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mRight.mTarget == null)) || ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mLeft.mTarget == null)) || ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mCenter.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper)))) {
        paramConstraintWidgetGroup.mStartHorizontalWidgets.add(paramConstraintWidget);
      }
      if (((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null)) || ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mBottom.mTarget == null)) || ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mTop.mTarget == null)) || ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mParent) && (paramConstraintWidget.mCenter.mTarget == null) && (paramConstraintWidget.mBaseline.mTarget == null) && (!(paramConstraintWidget instanceof Guideline)) && (!(paramConstraintWidget instanceof Helper)))) {
        paramConstraintWidgetGroup.mStartVerticalWidgets.add(paramConstraintWidget);
      }
      if ((paramConstraintWidget instanceof Helper))
      {
        invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean) {
          return false;
        }
        localObject = (Helper)paramConstraintWidget;
        i = 0;
        while (i < ((Helper)localObject).mWidgetsCount)
        {
          if (!traverse(localObject.mWidgets[i], paramConstraintWidgetGroup, paramList, paramBoolean)) {
            return false;
          }
          i += 1;
        }
      }
      int j = paramConstraintWidget.mListAnchors.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramConstraintWidget.mListAnchors[i];
        if ((((ConstraintAnchor)localObject).mTarget != null) && (((ConstraintAnchor)localObject).mTarget.mOwner != paramConstraintWidget.getParent()))
        {
          if (((ConstraintAnchor)localObject).mType == ConstraintAnchor.Type.CENTER)
          {
            invalidate(localConstraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
            if (paramBoolean) {
              return false;
            }
          }
          else
          {
            setConnection((ConstraintAnchor)localObject);
          }
          if (!traverse(((ConstraintAnchor)localObject).mTarget.mOwner, paramConstraintWidgetGroup, paramList, paramBoolean)) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    if (paramConstraintWidget.mBelongingGroup != paramConstraintWidgetGroup)
    {
      paramConstraintWidgetGroup.mConstrainedGroup.addAll(paramConstraintWidget.mBelongingGroup.mConstrainedGroup);
      paramConstraintWidgetGroup.mStartHorizontalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartHorizontalWidgets);
      paramConstraintWidgetGroup.mStartVerticalWidgets.addAll(paramConstraintWidget.mBelongingGroup.mStartVerticalWidgets);
      if (!paramConstraintWidget.mBelongingGroup.mSkipSolver) {
        paramConstraintWidgetGroup.mSkipSolver = false;
      }
      paramList.remove(paramConstraintWidget.mBelongingGroup);
      paramConstraintWidget = paramConstraintWidget.mBelongingGroup.mConstrainedGroup.iterator();
      while (paramConstraintWidget.hasNext()) {
        ((ConstraintWidget)paramConstraintWidget.next()).mBelongingGroup = paramConstraintWidgetGroup;
      }
    }
    return true;
  }
  
  private static void updateSizeDependentWidgets(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int j = paramInt1 * 2;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintWidget.mListAnchors[j];
    ConstraintAnchor localConstraintAnchor2 = paramConstraintWidget.mListAnchors[(j + 1)];
    if ((localConstraintAnchor1.mTarget != null) && (localConstraintAnchor2.mTarget != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, getParentBiasOffset(paramConstraintWidget, paramInt1) + localConstraintAnchor1.getMargin());
      return;
    }
    if ((paramConstraintWidget.mDimensionRatio != 0.0F) && (paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
    {
      paramInt2 = resolveDimensionRatio(paramConstraintWidget);
      i = (int)paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedOffset;
      localConstraintAnchor2.getResolutionNode().resolvedTarget = localConstraintAnchor1.getResolutionNode();
      localConstraintAnchor2.getResolutionNode().resolvedOffset = paramInt2;
      localConstraintAnchor2.getResolutionNode().state = 1;
      paramConstraintWidget.setFrame(i, i + paramInt2, paramInt1);
      return;
    }
    paramInt2 -= paramConstraintWidget.getRelativePositioning(paramInt1);
    int i = paramInt2 - paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.setFrame(i, paramInt2, paramInt1);
    Optimizer.setOptimizedWidget(paramConstraintWidget, paramInt1, i);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Analyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */