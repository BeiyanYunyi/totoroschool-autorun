package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;

public class Optimizer
{
  static final int FLAG_CHAIN_DANGLING = 1;
  static final int FLAG_RECOMPUTE_BOUNDS = 2;
  static final int FLAG_USE_OPTIMIZE = 0;
  public static final int OPTIMIZATION_BARRIER = 2;
  public static final int OPTIMIZATION_CHAIN = 4;
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  public static final int OPTIMIZATION_DIRECT = 1;
  public static final int OPTIMIZATION_GROUPS = 32;
  public static final int OPTIMIZATION_NONE = 0;
  public static final int OPTIMIZATION_RATIO = 16;
  public static final int OPTIMIZATION_STANDARD = 7;
  static boolean[] flags = new boolean[3];
  
  static void analyze(int paramInt, ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.updateResolutionNodes();
    ResolutionAnchor localResolutionAnchor1 = paramConstraintWidget.mLeft.getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = paramConstraintWidget.mTop.getResolutionNode();
    ResolutionAnchor localResolutionAnchor3 = paramConstraintWidget.mRight.getResolutionNode();
    ResolutionAnchor localResolutionAnchor4 = paramConstraintWidget.mBottom.getResolutionNode();
    if ((paramInt & 0x8) == 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    if ((paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (optimizableMatchConstraint(paramConstraintWidget, 0))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localResolutionAnchor1.type != 4) && (localResolutionAnchor3.type != 4)) {
      if ((paramConstraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8)))
      {
        if (i != 0)
        {
          i = paramConstraintWidget.getWidth();
          localResolutionAnchor1.setType(1);
          localResolutionAnchor3.setType(1);
          if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null))
          {
            if (paramInt != 0) {
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
            } else {
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, i);
            }
          }
          else if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget == null))
          {
            if (paramInt != 0) {
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
            } else {
              localResolutionAnchor3.dependsOn(localResolutionAnchor1, i);
            }
          }
          else if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget != null))
          {
            if (paramInt != 0) {
              localResolutionAnchor1.dependsOn(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
            } else {
              localResolutionAnchor1.dependsOn(localResolutionAnchor3, -i);
            }
          }
          else if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
          {
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor1);
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor3);
            }
            if (paramConstraintWidget.mDimensionRatio == 0.0F)
            {
              localResolutionAnchor1.setType(3);
              localResolutionAnchor3.setType(3);
              localResolutionAnchor1.setOpposite(localResolutionAnchor3, 0.0F);
              localResolutionAnchor3.setOpposite(localResolutionAnchor1, 0.0F);
            }
            else
            {
              localResolutionAnchor1.setType(2);
              localResolutionAnchor3.setType(2);
              localResolutionAnchor1.setOpposite(localResolutionAnchor3, -i);
              localResolutionAnchor3.setOpposite(localResolutionAnchor1, i);
              paramConstraintWidget.setWidth(i);
            }
          }
        }
      }
      else if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget == null))
      {
        localResolutionAnchor1.setType(1);
        localResolutionAnchor3.setType(1);
        if (paramInt != 0) {
          localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
        } else {
          localResolutionAnchor3.dependsOn(localResolutionAnchor1, paramConstraintWidget.getWidth());
        }
      }
      else if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget == null))
      {
        localResolutionAnchor1.setType(1);
        localResolutionAnchor3.setType(1);
        if (paramInt != 0) {
          localResolutionAnchor3.dependsOn(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
        } else {
          localResolutionAnchor3.dependsOn(localResolutionAnchor1, paramConstraintWidget.getWidth());
        }
      }
      else if ((paramConstraintWidget.mLeft.mTarget == null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        localResolutionAnchor1.setType(1);
        localResolutionAnchor3.setType(1);
        localResolutionAnchor1.dependsOn(localResolutionAnchor3, -paramConstraintWidget.getWidth());
        if (paramInt != 0) {
          localResolutionAnchor1.dependsOn(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
        } else {
          localResolutionAnchor1.dependsOn(localResolutionAnchor3, -paramConstraintWidget.getWidth());
        }
      }
      else if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mRight.mTarget != null))
      {
        localResolutionAnchor1.setType(2);
        localResolutionAnchor3.setType(2);
        if (paramInt != 0)
        {
          paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor1);
          paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor3);
          localResolutionAnchor1.setOpposite(localResolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
          localResolutionAnchor3.setOpposite(localResolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
        }
        else
        {
          localResolutionAnchor1.setOpposite(localResolutionAnchor3, -paramConstraintWidget.getWidth());
          localResolutionAnchor3.setOpposite(localResolutionAnchor1, paramConstraintWidget.getWidth());
        }
      }
    }
    if ((paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (optimizableMatchConstraint(paramConstraintWidget, 1))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localResolutionAnchor2.type != 4) && (localResolutionAnchor4.type != 4)) {
      if ((paramConstraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED) && ((i == 0) || (paramConstraintWidget.getVisibility() != 8)))
      {
        if (i != 0)
        {
          i = paramConstraintWidget.getHeight();
          localResolutionAnchor2.setType(1);
          localResolutionAnchor4.setType(1);
          if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null))
          {
            if (paramInt != 0)
            {
              localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
              return;
            }
            localResolutionAnchor4.dependsOn(localResolutionAnchor2, i);
            return;
          }
          if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget == null))
          {
            if (paramInt != 0)
            {
              localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
              return;
            }
            localResolutionAnchor4.dependsOn(localResolutionAnchor2, i);
            return;
          }
          if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget != null))
          {
            if (paramInt != 0)
            {
              localResolutionAnchor2.dependsOn(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
              return;
            }
            localResolutionAnchor2.dependsOn(localResolutionAnchor4, -i);
            return;
          }
          if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
          {
            if (paramInt != 0)
            {
              paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor2);
              paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor4);
            }
            if (paramConstraintWidget.mDimensionRatio == 0.0F)
            {
              localResolutionAnchor2.setType(3);
              localResolutionAnchor4.setType(3);
              localResolutionAnchor2.setOpposite(localResolutionAnchor4, 0.0F);
              localResolutionAnchor4.setOpposite(localResolutionAnchor2, 0.0F);
              return;
            }
            localResolutionAnchor2.setType(2);
            localResolutionAnchor4.setType(2);
            localResolutionAnchor2.setOpposite(localResolutionAnchor4, -i);
            localResolutionAnchor4.setOpposite(localResolutionAnchor2, i);
            paramConstraintWidget.setHeight(i);
            if (paramConstraintWidget.mBaselineDistance > 0) {
              paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
            }
          }
        }
      }
      else if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget == null))
      {
        localResolutionAnchor2.setType(1);
        localResolutionAnchor4.setType(1);
        if (paramInt != 0) {
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
        } else {
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, paramConstraintWidget.getHeight());
        }
        if (paramConstraintWidget.mBaseline.mTarget != null)
        {
          paramConstraintWidget.mBaseline.getResolutionNode().setType(1);
          localResolutionAnchor2.dependsOn(1, paramConstraintWidget.mBaseline.getResolutionNode(), -paramConstraintWidget.mBaselineDistance);
        }
      }
      else if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget == null))
      {
        localResolutionAnchor2.setType(1);
        localResolutionAnchor4.setType(1);
        if (paramInt != 0) {
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
        } else {
          localResolutionAnchor4.dependsOn(localResolutionAnchor2, paramConstraintWidget.getHeight());
        }
        if (paramConstraintWidget.mBaselineDistance > 0) {
          paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
        }
      }
      else if ((paramConstraintWidget.mTop.mTarget == null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        localResolutionAnchor2.setType(1);
        localResolutionAnchor4.setType(1);
        if (paramInt != 0) {
          localResolutionAnchor2.dependsOn(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
        } else {
          localResolutionAnchor2.dependsOn(localResolutionAnchor4, -paramConstraintWidget.getHeight());
        }
        if (paramConstraintWidget.mBaselineDistance > 0) {
          paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
        }
      }
      else if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mBottom.mTarget != null))
      {
        localResolutionAnchor2.setType(2);
        localResolutionAnchor4.setType(2);
        if (paramInt != 0)
        {
          localResolutionAnchor2.setOpposite(localResolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
          localResolutionAnchor4.setOpposite(localResolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          paramConstraintWidget.getResolutionHeight().addDependent(localResolutionAnchor2);
          paramConstraintWidget.getResolutionWidth().addDependent(localResolutionAnchor4);
        }
        else
        {
          localResolutionAnchor2.setOpposite(localResolutionAnchor4, -paramConstraintWidget.getHeight());
          localResolutionAnchor4.setOpposite(localResolutionAnchor2, paramConstraintWidget.getHeight());
        }
        if (paramConstraintWidget.mBaselineDistance > 0) {
          paramConstraintWidget.mBaseline.getResolutionNode().dependsOn(1, localResolutionAnchor2, paramConstraintWidget.mBaselineDistance);
        }
      }
    }
  }
  
  static boolean applyChainOptimized(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    Object localObject1 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget1 = paramChainHead.mLast;
    Object localObject3 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLastVisibleWidget;
    Object localObject2 = paramChainHead.mHead;
    float f6 = paramChainHead.mTotalWeight;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mFirstMatchConstraintWidget;
    paramChainHead = paramChainHead.mLastMatchConstraintWidget;
    paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1];
    paramConstraintWidgetContainer = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    int i;
    int j;
    int k;
    if (paramInt1 == 0)
    {
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle == 1) {
        j = 1;
      } else {
        j = 0;
      }
      m = i;
      k = j;
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle == 2)
      {
        k = j;
        m = i;
      }
    }
    for (;;)
    {
      i = 1;
      j = m;
      break;
      do
      {
        i = 0;
        j = m;
        break;
        if (((ConstraintWidget)localObject2).mVerticalChainStyle == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (((ConstraintWidget)localObject2).mVerticalChainStyle == 1) {
          j = 1;
        } else {
          j = 0;
        }
        m = i;
        k = j;
      } while (((ConstraintWidget)localObject2).mVerticalChainStyle != 2);
      m = i;
      k = j;
    }
    paramChainHead = (ChainHead)localObject1;
    int i1 = 0;
    int n = 0;
    int m = 0;
    float f5 = 0.0F;
    float f3 = 0.0F;
    float f1;
    float f2;
    while (m == 0)
    {
      int i2 = n;
      f1 = f5;
      f2 = f3;
      if (paramChainHead.getVisibility() != 8)
      {
        i2 = n + 1;
        if (paramInt1 == 0) {
          f1 = f5 + paramChainHead.getWidth();
        } else {
          f1 = f5 + paramChainHead.getHeight();
        }
        f2 = f1;
        if (paramChainHead != localObject3) {
          f2 = f1 + paramChainHead.mListAnchors[paramInt2].getMargin();
        }
        f1 = f2;
        if (paramChainHead != localConstraintWidget2) {
          f1 = f2 + paramChainHead.mListAnchors[(paramInt2 + 1)].getMargin();
        }
        f2 = f3 + paramChainHead.mListAnchors[paramInt2].getMargin() + paramChainHead.mListAnchors[(paramInt2 + 1)].getMargin();
      }
      paramConstraintWidgetContainer = paramChainHead.mListAnchors[paramInt2];
      n = i1;
      if (paramChainHead.getVisibility() != 8)
      {
        n = i1;
        if (paramChainHead.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          n = i1 + 1;
          if (paramInt1 == 0)
          {
            if (paramChainHead.mMatchConstraintDefaultWidth != 0) {
              return false;
            }
            if ((paramChainHead.mMatchConstraintMinWidth != 0) || (paramChainHead.mMatchConstraintMaxWidth != 0)) {
              return false;
            }
          }
          else
          {
            if (paramChainHead.mMatchConstraintDefaultHeight != 0) {
              return false;
            }
            if (paramChainHead.mMatchConstraintMinHeight != 0) {
              break label498;
            }
            if (paramChainHead.mMatchConstraintMaxHeight != 0) {
              return false;
            }
          }
          if (paramChainHead.mDimensionRatio != 0.0F)
          {
            return false;
            label498:
            return false;
          }
        }
      }
      paramConstraintWidgetContainer = paramChainHead.mListAnchors[(paramInt2 + 1)].mTarget;
      if (paramConstraintWidgetContainer != null)
      {
        paramConstraintWidgetContainer = paramConstraintWidgetContainer.mOwner;
        if ((paramConstraintWidgetContainer.mListAnchors[paramInt2].mTarget != null) && (paramConstraintWidgetContainer.mListAnchors[paramInt2].mTarget.mOwner == paramChainHead)) {
          break label559;
        }
      }
      paramConstraintWidgetContainer = null;
      label559:
      if (paramConstraintWidgetContainer != null)
      {
        i1 = n;
        n = i2;
        paramChainHead = paramConstraintWidgetContainer;
        f5 = f1;
        f3 = f2;
      }
      else
      {
        m = 1;
        i1 = n;
        n = i2;
        f5 = f1;
        f3 = f2;
      }
    }
    localObject2 = localObject1.mListAnchors[paramInt2].getResolutionNode();
    paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors;
    m = paramInt2 + 1;
    paramConstraintWidgetContainer = paramConstraintWidgetContainer[m].getResolutionNode();
    if ((((ResolutionAnchor)localObject2).target != null) && (paramConstraintWidgetContainer.target != null))
    {
      if ((((ResolutionAnchor)localObject2).target.state == 1) && (paramConstraintWidgetContainer.target.state == 1))
      {
        if ((i1 > 0) && (i1 != n)) {
          return false;
        }
        if ((i == 0) && (j == 0) && (k == 0))
        {
          f1 = 0.0F;
        }
        else
        {
          if (localObject3 != null) {
            f2 = localObject3.mListAnchors[paramInt2].getMargin();
          } else {
            f2 = 0.0F;
          }
          f1 = f2;
          if (localConstraintWidget2 != null) {
            f1 = f2 + localConstraintWidget2.mListAnchors[m].getMargin();
          }
        }
        float f4 = ((ResolutionAnchor)localObject2).target.resolvedOffset;
        f2 = paramConstraintWidgetContainer.target.resolvedOffset;
        if (f4 < f2) {
          f2 = f2 - f4 - f5;
        } else {
          f2 = f4 - f2 - f5;
        }
        if ((i1 > 0) && (i1 == n))
        {
          if ((paramChainHead.getParent() != null) && (paramChainHead.getParent().mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
            return false;
          }
          f2 = f2 + f5 - f3;
          for (paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1; paramConstraintWidgetContainer != null; paramConstraintWidgetContainer = paramChainHead)
          {
            if (LinearSystem.sMetrics != null)
            {
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.nonresolvedWidgets -= 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.resolvedWidgets += 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.chainConnectionResolved += 1L;
            }
            paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
            if ((paramChainHead == null) && (paramConstraintWidgetContainer != localConstraintWidget1)) {
              continue;
            }
            f1 = f2 / i1;
            if (f6 > 0.0F) {
              if (paramConstraintWidgetContainer.mWeight[paramInt1] == -1.0F) {
                f1 = 0.0F;
              } else {
                f1 = paramConstraintWidgetContainer.mWeight[paramInt1] * f2 / f6;
              }
            }
            if (paramConstraintWidgetContainer.getVisibility() == 8) {
              f1 = 0.0F;
            }
            f3 = f4 + paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
            paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f3);
            localObject1 = paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode();
            localObject3 = ((ResolutionAnchor)localObject2).resolvedTarget;
            f1 = f3 + f1;
            ((ResolutionAnchor)localObject1).resolve((ResolutionAnchor)localObject3, f1);
            paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
            paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode().addResolvedValue(paramLinearSystem);
            f4 = f1 + paramConstraintWidgetContainer.mListAnchors[m].getMargin();
          }
          return true;
        }
        if (f2 < 0.0F)
        {
          i = 1;
          j = 0;
          k = 0;
        }
        if (i != 0)
        {
          paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
          for (f1 = f4 + (f2 - f1) * paramConstraintWidgetContainer.getBiasPercent(paramInt1); paramConstraintWidgetContainer != null; f1 = f2)
          {
            if (LinearSystem.sMetrics != null)
            {
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.nonresolvedWidgets -= 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.resolvedWidgets += 1L;
              paramChainHead = LinearSystem.sMetrics;
              paramChainHead.chainConnectionResolved += 1L;
            }
            paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
            if (paramChainHead == null)
            {
              f2 = f1;
              if (paramConstraintWidgetContainer != localConstraintWidget1) {}
            }
            else
            {
              if (paramInt1 == 0) {
                f2 = paramConstraintWidgetContainer.getWidth();
              } else {
                f2 = paramConstraintWidgetContainer.getHeight();
              }
              f1 += paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f1);
              localObject1 = paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode();
              localObject3 = ((ResolutionAnchor)localObject2).resolvedTarget;
              f1 += f2;
              ((ResolutionAnchor)localObject1).resolve((ResolutionAnchor)localObject3, f1);
              paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
              paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode().addResolvedValue(paramLinearSystem);
              f2 = f1 + paramConstraintWidgetContainer.mListAnchors[m].getMargin();
            }
            paramConstraintWidgetContainer = paramChainHead;
          }
        }
        for (;;)
        {
          return true;
          if ((j != 0) || (k != 0))
          {
            if (j != 0)
            {
              f3 = f2 - f1;
            }
            else
            {
              f3 = f2;
              if (k != 0) {
                f3 = f2 - f1;
              }
            }
            f2 = f3 / (n + 1);
            if (k != 0) {
              if (n > 1) {
                f2 = f3 / (n - 1);
              } else {
                f2 = f3 / 2.0F;
              }
            }
            if (((ConstraintWidget)localObject1).getVisibility() != 8) {
              f1 = f4 + f2;
            } else {
              f1 = f4;
            }
            f3 = f1;
            if (k != 0)
            {
              f3 = f1;
              if (n > 1) {
                f3 = localObject3.mListAnchors[paramInt2].getMargin() + f4;
              }
            }
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
            f1 = f3;
            if (j != 0)
            {
              paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1;
              f1 = f3;
              if (localObject3 != null) {
                f1 = f3 + localObject3.mListAnchors[paramInt2].getMargin();
              }
            }
            for (paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject1; paramConstraintWidgetContainer != null; paramConstraintWidgetContainer = paramChainHead)
            {
              if (LinearSystem.sMetrics != null)
              {
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.nonresolvedWidgets -= 1L;
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.resolvedWidgets += 1L;
                paramChainHead = LinearSystem.sMetrics;
                paramChainHead.chainConnectionResolved += 1L;
              }
              paramChainHead = paramConstraintWidgetContainer.mNextChainWidget[paramInt1];
              if (paramChainHead == null)
              {
                f3 = f1;
                if (paramConstraintWidgetContainer == localConstraintWidget1) {}
              }
              do
              {
                f1 = f3;
                break;
                if (paramInt1 == 0) {
                  f3 = paramConstraintWidgetContainer.getWidth();
                } else {
                  f3 = paramConstraintWidgetContainer.getHeight();
                }
                f4 = f1;
                if (paramConstraintWidgetContainer != localObject3) {
                  f4 = f1 + paramConstraintWidgetContainer.mListAnchors[paramInt2].getMargin();
                }
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f4);
                paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode().resolve(((ResolutionAnchor)localObject2).resolvedTarget, f4 + f3);
                paramConstraintWidgetContainer.mListAnchors[paramInt2].getResolutionNode().addResolvedValue(paramLinearSystem);
                paramConstraintWidgetContainer.mListAnchors[m].getResolutionNode().addResolvedValue(paramLinearSystem);
                f4 += f3 + paramConstraintWidgetContainer.mListAnchors[m].getMargin();
                f3 = f4;
              } while (paramChainHead == null);
              f1 = f4;
              if (paramChainHead.getVisibility() != 8) {
                f1 = f4 + f2;
              }
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  static void checkMatchParent(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    int i;
    int j;
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mLeft.mMargin;
      j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.mRight.mMargin;
      paramConstraintWidget.mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mLeft);
      paramConstraintWidget.mRight.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mRight);
      paramLinearSystem.addEquality(paramConstraintWidget.mLeft.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mRight.mSolverVariable, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    }
    if ((paramConstraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (paramConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT))
    {
      i = paramConstraintWidget.mTop.mMargin;
      j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.mBottom.mMargin;
      paramConstraintWidget.mTop.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mTop);
      paramConstraintWidget.mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBottom);
      paramLinearSystem.addEquality(paramConstraintWidget.mTop.mSolverVariable, i);
      paramLinearSystem.addEquality(paramConstraintWidget.mBottom.mSolverVariable, j);
      if ((paramConstraintWidget.mBaselineDistance > 0) || (paramConstraintWidget.getVisibility() == 8))
      {
        paramConstraintWidget.mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(paramConstraintWidget.mBaseline);
        paramLinearSystem.addEquality(paramConstraintWidget.mBaseline.mSolverVariable, paramConstraintWidget.mBaselineDistance + i);
      }
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
    }
  }
  
  private static boolean optimizableMatchConstraint(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramConstraintWidget.mListDimensionBehaviors[paramInt] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      return false;
    }
    float f = paramConstraintWidget.mDimensionRatio;
    int i = 1;
    if (f != 0.0F)
    {
      paramConstraintWidget = paramConstraintWidget.mListDimensionBehaviors;
      if (paramInt == 0) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      return paramConstraintWidget[paramInt] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    }
    if (paramInt == 0)
    {
      if (paramConstraintWidget.mMatchConstraintDefaultWidth != 0) {
        return false;
      }
      if ((paramConstraintWidget.mMatchConstraintMinWidth != 0) || (paramConstraintWidget.mMatchConstraintMaxWidth != 0)) {
        return false;
      }
    }
    else
    {
      if (paramConstraintWidget.mMatchConstraintDefaultHeight != 0) {
        return false;
      }
      if (paramConstraintWidget.mMatchConstraintMinHeight != 0) {
        break label112;
      }
      if (paramConstraintWidget.mMatchConstraintMaxHeight != 0) {
        return false;
      }
    }
    return true;
    label112:
    return false;
  }
  
  static void setOptimizedWidget(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * 2;
    int j = i + 1;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedTarget = paramConstraintWidget.getParent().mLeft.getResolutionNode();
    paramConstraintWidget.mListAnchors[i].getResolutionNode().resolvedOffset = paramInt2;
    paramConstraintWidget.mListAnchors[i].getResolutionNode().state = 1;
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedTarget = paramConstraintWidget.mListAnchors[i].getResolutionNode();
    paramConstraintWidget.mListAnchors[j].getResolutionNode().resolvedOffset = paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.mListAnchors[j].getResolutionNode().state = 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */