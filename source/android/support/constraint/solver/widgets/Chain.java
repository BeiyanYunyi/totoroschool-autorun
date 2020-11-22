package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

class Chain
{
  private static final boolean DEBUG = false;
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt)
  {
    int k = 0;
    int j;
    ChainHead[] arrayOfChainHead;
    int i;
    if (paramInt == 0)
    {
      j = paramConstraintWidgetContainer.mHorizontalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mHorizontalChainsArray;
      i = 0;
    }
    else
    {
      i = 2;
      j = paramConstraintWidgetContainer.mVerticalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mVerticalChainsArray;
    }
    while (k < j)
    {
      ChainHead localChainHead = arrayOfChainHead[k];
      localChainHead.define();
      if (paramConstraintWidgetContainer.optimizeFor(4))
      {
        if (!Optimizer.applyChainOptimized(paramConstraintWidgetContainer, paramLinearSystem, paramInt, i, localChainHead)) {
          applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, i, localChainHead);
        }
      }
      else {
        applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, i, localChainHead);
      }
      k += 1;
    }
  }
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    Object localObject4 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLast;
    ConstraintWidget localConstraintWidget1 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mLastVisibleWidget;
    Object localObject2 = paramChainHead.mHead;
    float f1 = paramChainHead.mTotalWeight;
    Object localObject1 = paramChainHead.mFirstMatchConstraintWidget;
    localObject1 = paramChainHead.mLastMatchConstraintWidget;
    int i1;
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i;
    int j;
    int k;
    int m;
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
      k = j;
      m = i;
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle != 2) {}
    }
    int n;
    Object localObject3;
    for (;;)
    {
      k = 1;
      m = j;
      n = i;
      do
      {
        i = 0;
        n = m;
        m = k;
        k = i;
        localObject3 = localObject4;
        i = 0;
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
        k = j;
        m = i;
      } while (((ConstraintWidget)localObject2).mVerticalChainStyle != 2);
    }
    Object localObject5;
    int i2;
    Object localObject6;
    for (;;)
    {
      localObject5 = null;
      if (i != 0) {
        break;
      }
      localObject1 = localObject3.mListAnchors[paramInt2];
      if ((i1 == 0) && (k == 0)) {
        j = 4;
      } else {
        j = 1;
      }
      int i3 = ((ConstraintAnchor)localObject1).getMargin();
      i2 = i3;
      if (((ConstraintAnchor)localObject1).mTarget != null)
      {
        i2 = i3;
        if (localObject3 != localObject4) {
          i2 = i3 + ((ConstraintAnchor)localObject1).mTarget.getMargin();
        }
      }
      if ((k != 0) && (localObject3 != localObject4) && (localObject3 != localConstraintWidget1)) {
        j = 6;
      } else if ((n != 0) && (i1 != 0)) {
        j = 4;
      }
      if (((ConstraintAnchor)localObject1).mTarget != null)
      {
        if (localObject3 == localConstraintWidget1) {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, 5);
        } else {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, 6);
        }
        paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, j);
      }
      if (i1 != 0)
      {
        if ((((ConstraintWidget)localObject3).getVisibility() != 8) && (localObject3.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
          paramLinearSystem.addGreaterThan(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 5);
        }
        paramLinearSystem.addGreaterThan(localObject3.mListAnchors[paramInt2].mSolverVariable, paramConstraintWidgetContainer.mListAnchors[paramInt2].mSolverVariable, 0, 6);
      }
      localObject6 = localObject3.mListAnchors[(paramInt2 + 1)].mTarget;
      localObject1 = localObject5;
      if (localObject6 != null)
      {
        localObject6 = ((ConstraintAnchor)localObject6).mOwner;
        localObject1 = localObject5;
        if (localObject6.mListAnchors[paramInt2].mTarget != null) {
          if (localObject6.mListAnchors[paramInt2].mTarget.mOwner != localObject3) {
            localObject1 = localObject5;
          } else {
            localObject1 = localObject6;
          }
        }
      }
      if (localObject1 != null) {
        localObject3 = localObject1;
      } else {
        i = 1;
      }
    }
    if (localConstraintWidget3 != null)
    {
      localObject1 = localConstraintWidget2.mListAnchors;
      i = paramInt2 + 1;
      if (localObject1[i].mTarget != null)
      {
        localObject1 = localConstraintWidget3.mListAnchors[i];
        paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject1).mSolverVariable, localConstraintWidget2.mListAnchors[i].mTarget.mSolverVariable, -((ConstraintAnchor)localObject1).getMargin(), 5);
      }
    }
    if (i1 != 0)
    {
      paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListAnchors;
      i = paramInt2 + 1;
      paramLinearSystem.addGreaterThan(paramConstraintWidgetContainer[i].mSolverVariable, localConstraintWidget2.mListAnchors[i].mSolverVariable, localConstraintWidget2.mListAnchors[i].getMargin(), 6);
    }
    paramConstraintWidgetContainer = paramChainHead.mWeightedMatchConstraintsWidgets;
    label915:
    SolverVariable localSolverVariable;
    Object localObject7;
    if (paramConstraintWidgetContainer != null)
    {
      j = paramConstraintWidgetContainer.size();
      if (j > 1)
      {
        float f2 = f1;
        if (paramChainHead.mHasUndefinedWeights)
        {
          f2 = f1;
          if (!paramChainHead.mHasComplexMatchWeights) {
            f2 = paramChainHead.mWidgetsMatchCount;
          }
        }
        localObject1 = null;
        i = 0;
        for (float f3 = 0.0F; i < j; f3 = f1)
        {
          localObject3 = (ConstraintWidget)paramConstraintWidgetContainer.get(i);
          f1 = localObject3.mWeight[paramInt1];
          if (f1 < 0.0F)
          {
            if (paramChainHead.mHasComplexMatchWeights)
            {
              paramLinearSystem.addEquality(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 4);
              break label915;
            }
            f1 = 1.0F;
          }
          if (f1 == 0.0F)
          {
            paramLinearSystem.addEquality(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 6);
            f1 = f3;
          }
          else
          {
            if (localObject1 != null)
            {
              localObject5 = localObject1.mListAnchors[paramInt2].mSolverVariable;
              localObject1 = ((ConstraintWidget)localObject1).mListAnchors;
              i1 = paramInt2 + 1;
              localObject1 = localObject1[i1].mSolverVariable;
              localObject6 = localObject3.mListAnchors[paramInt2].mSolverVariable;
              localSolverVariable = localObject3.mListAnchors[i1].mSolverVariable;
              localObject7 = paramLinearSystem.createRow();
              ((ArrayRow)localObject7).createRowEqualMatchDimensions(f3, f2, f1, (SolverVariable)localObject5, (SolverVariable)localObject1, (SolverVariable)localObject6, localSolverVariable);
              paramLinearSystem.addConstraint((ArrayRow)localObject7);
            }
            localObject1 = localObject3;
          }
          i += 1;
        }
      }
    }
    if ((localConstraintWidget1 != null) && ((localConstraintWidget1 == localConstraintWidget3) || (k != 0)))
    {
      localObject1 = localObject4.mListAnchors[paramInt2];
      paramConstraintWidgetContainer = localConstraintWidget2.mListAnchors;
      i = paramInt2 + 1;
      localObject3 = paramConstraintWidgetContainer[i];
      if (localObject4.mListAnchors[paramInt2].mTarget != null) {
        paramConstraintWidgetContainer = localObject4.mListAnchors[paramInt2].mTarget.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (localConstraintWidget2.mListAnchors[i].mTarget != null) {
        paramChainHead = localConstraintWidget2.mListAnchors[i].mTarget.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      if (localConstraintWidget1 == localConstraintWidget3)
      {
        localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
        localObject3 = localConstraintWidget1.mListAnchors[i];
      }
      if ((paramConstraintWidgetContainer != null) && (paramChainHead != null))
      {
        if (paramInt1 == 0) {}
        for (f1 = ((ConstraintWidget)localObject2).mHorizontalBiasPercent;; f1 = ((ConstraintWidget)localObject2).mVerticalBiasPercent) {
          break;
        }
        paramInt1 = ((ConstraintAnchor)localObject1).getMargin();
        i = ((ConstraintAnchor)localObject3).getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramConstraintWidgetContainer, paramInt1, f1, paramChainHead, ((ConstraintAnchor)localObject3).mSolverVariable, i, 5);
      }
    }
    else
    {
      if ((n != 0) && (localConstraintWidget1 != null))
      {
        if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {
          k = 1;
        } else {
          k = 0;
        }
        localObject1 = localConstraintWidget1;
        localObject2 = localObject1;
      }
      while (localObject2 != null)
      {
        for (paramConstraintWidgetContainer = localObject2.mNextChainWidget[paramInt1]; (paramConstraintWidgetContainer != null) && (paramConstraintWidgetContainer.getVisibility() == 8); paramConstraintWidgetContainer = paramConstraintWidgetContainer.mNextChainWidget[paramInt1]) {}
        if ((paramConstraintWidgetContainer == null) && (localObject2 != localConstraintWidget3)) {}
        for (;;)
        {
          break;
          localObject5 = localObject2.mListAnchors[paramInt2];
          localSolverVariable = ((ConstraintAnchor)localObject5).mSolverVariable;
          if (((ConstraintAnchor)localObject5).mTarget != null) {
            localObject3 = ((ConstraintAnchor)localObject5).mTarget.mSolverVariable;
          } else {
            localObject3 = null;
          }
          if (localObject1 != localObject2)
          {
            paramChainHead = localObject1.mListAnchors[(paramInt2 + 1)].mSolverVariable;
          }
          else
          {
            paramChainHead = (ChainHead)localObject3;
            if (localObject2 == localConstraintWidget1)
            {
              paramChainHead = (ChainHead)localObject3;
              if (localObject1 == localObject2) {
                if (localObject4.mListAnchors[paramInt2].mTarget != null) {
                  paramChainHead = localObject4.mListAnchors[paramInt2].mTarget.mSolverVariable;
                } else {
                  paramChainHead = null;
                }
              }
            }
          }
          j = ((ConstraintAnchor)localObject5).getMargin();
          localObject3 = ((ConstraintWidget)localObject2).mListAnchors;
          i2 = paramInt2 + 1;
          i1 = localObject3[i2].getMargin();
          if (paramConstraintWidgetContainer != null)
          {
            localObject6 = paramConstraintWidgetContainer.mListAnchors[paramInt2];
            localObject3 = ((ConstraintAnchor)localObject6).mSolverVariable;
          }
          for (localObject5 = localObject2.mListAnchors[i2].mSolverVariable;; localObject5 = localObject2.mListAnchors[i2].mSolverVariable)
          {
            break;
            localObject6 = localConstraintWidget2.mListAnchors[i2].mTarget;
            if (localObject6 != null) {
              localObject3 = ((ConstraintAnchor)localObject6).mSolverVariable;
            } else {
              localObject3 = null;
            }
          }
          i = i1;
          if (localObject6 != null) {
            i = i1 + ((ConstraintAnchor)localObject6).getMargin();
          }
          if (localObject1 != null) {
            j += localObject1.mListAnchors[i2].getMargin();
          }
          if ((localSolverVariable != null) && (paramChainHead != null) && (localObject3 != null) && (localObject5 != null))
          {
            if (localObject2 == localConstraintWidget1) {
              j = localConstraintWidget1.mListAnchors[paramInt2].getMargin();
            }
            if (localObject2 == localConstraintWidget3) {
              i = localConstraintWidget3.mListAnchors[i2].getMargin();
            }
            if (k != 0) {
              i1 = 6;
            } else {
              i1 = 4;
            }
            paramLinearSystem.addCentering(localSolverVariable, paramChainHead, j, 0.5F, (SolverVariable)localObject3, (SolverVariable)localObject5, i, i1);
            break;
          }
        }
        if (((ConstraintWidget)localObject2).getVisibility() != 8) {
          localObject1 = localObject2;
        }
        localObject2 = paramConstraintWidgetContainer;
        continue;
        if ((m != 0) && (localConstraintWidget1 != null))
        {
          if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {
            i = 1;
          } else {
            i = 0;
          }
          paramChainHead = localConstraintWidget1;
          paramConstraintWidgetContainer = paramChainHead;
          for (;;)
          {
            localObject2 = paramConstraintWidgetContainer;
            if (localObject2 == null) {
              break;
            }
            for (paramConstraintWidgetContainer = localObject2.mNextChainWidget[paramInt1]; (paramConstraintWidgetContainer != null) && (paramConstraintWidgetContainer.getVisibility() == 8); paramConstraintWidgetContainer = paramConstraintWidgetContainer.mNextChainWidget[paramInt1]) {}
            if ((localObject2 != localConstraintWidget1) && (localObject2 != localConstraintWidget3) && (paramConstraintWidgetContainer != null))
            {
              if (paramConstraintWidgetContainer == localConstraintWidget3) {
                paramConstraintWidgetContainer = null;
              }
              localObject1 = localObject2.mListAnchors[paramInt2];
              localSolverVariable = ((ConstraintAnchor)localObject1).mSolverVariable;
              if (((ConstraintAnchor)localObject1).mTarget != null) {
                localObject3 = ((ConstraintAnchor)localObject1).mTarget.mSolverVariable;
              }
              localObject3 = paramChainHead.mListAnchors;
              i2 = paramInt2 + 1;
              localObject7 = localObject3[i2].mSolverVariable;
              i1 = ((ConstraintAnchor)localObject1).getMargin();
              k = localObject2.mListAnchors[i2].getMargin();
              if (paramConstraintWidgetContainer != null)
              {
                localObject3 = paramConstraintWidgetContainer.mListAnchors[paramInt2];
                localObject5 = ((ConstraintAnchor)localObject3).mSolverVariable;
                if (((ConstraintAnchor)localObject3).mTarget != null) {
                  localObject1 = ((ConstraintAnchor)localObject3).mTarget.mSolverVariable;
                } else {
                  localObject1 = null;
                }
                localObject6 = localObject1;
              }
              else
              {
                localObject3 = localObject2.mListAnchors[i2].mTarget;
                if (localObject3 != null) {
                  localObject1 = ((ConstraintAnchor)localObject3).mSolverVariable;
                } else {
                  localObject1 = null;
                }
                localObject6 = localObject2.mListAnchors[i2].mSolverVariable;
                localObject5 = localObject1;
              }
              j = k;
              if (localObject3 != null) {
                j = k + ((ConstraintAnchor)localObject3).getMargin();
              }
              k = i1;
              if (paramChainHead != null) {
                k = i1 + paramChainHead.mListAnchors[i2].getMargin();
              }
              if (i != 0) {
                i1 = 6;
              } else {
                i1 = 4;
              }
              if ((localSolverVariable != null) && (localObject7 != null) && (localObject5 != null) && (localObject6 != null)) {
                paramLinearSystem.addCentering(localSolverVariable, (SolverVariable)localObject7, k, 0.5F, (SolverVariable)localObject5, (SolverVariable)localObject6, j, i1);
              }
            }
            if (((ConstraintWidget)localObject2).getVisibility() != 8) {
              paramChainHead = (ChainHead)localObject2;
            }
          }
          paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors[paramInt2];
          localObject3 = localObject4.mListAnchors[paramInt2].mTarget;
          paramChainHead = localConstraintWidget3.mListAnchors;
          paramInt1 = paramInt2 + 1;
          paramChainHead = paramChainHead[paramInt1];
          localObject1 = localConstraintWidget2.mListAnchors[paramInt1].mTarget;
          if (localObject3 != null)
          {
            if (localConstraintWidget1 != localConstraintWidget3) {
              paramLinearSystem.addEquality(paramConstraintWidgetContainer.mSolverVariable, ((ConstraintAnchor)localObject3).mSolverVariable, paramConstraintWidgetContainer.getMargin(), 5);
            }
            while (localObject1 == null)
            {
              paramConstraintWidgetContainer = paramLinearSystem;
              break;
            }
            localObject2 = paramConstraintWidgetContainer.mSolverVariable;
            localObject3 = ((ConstraintAnchor)localObject3).mSolverVariable;
            paramInt1 = paramConstraintWidgetContainer.getMargin();
            localObject4 = paramChainHead.mSolverVariable;
            localObject5 = ((ConstraintAnchor)localObject1).mSolverVariable;
            i = paramChainHead.getMargin();
            paramConstraintWidgetContainer = paramLinearSystem;
            paramLinearSystem.addCentering((SolverVariable)localObject2, (SolverVariable)localObject3, paramInt1, 0.5F, (SolverVariable)localObject4, (SolverVariable)localObject5, i, 5);
          }
          else
          {
            paramConstraintWidgetContainer = paramLinearSystem;
          }
          if ((localObject1 != null) && (localConstraintWidget1 != localConstraintWidget3)) {
            paramConstraintWidgetContainer.addEquality(paramChainHead.mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, -paramChainHead.getMargin(), 5);
          }
        }
      }
    }
    if (((n != 0) || (m != 0)) && (localConstraintWidget1 != null))
    {
      localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
      paramConstraintWidgetContainer = localConstraintWidget3.mListAnchors;
      paramInt1 = paramInt2 + 1;
      localObject2 = paramConstraintWidgetContainer[paramInt1];
      if (((ConstraintAnchor)localObject1).mTarget != null) {
        paramChainHead = ((ConstraintAnchor)localObject1).mTarget.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      if (((ConstraintAnchor)localObject2).mTarget != null) {
        paramConstraintWidgetContainer = ((ConstraintAnchor)localObject2).mTarget.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (localConstraintWidget2 != localConstraintWidget3)
      {
        paramConstraintWidgetContainer = localConstraintWidget2.mListAnchors[paramInt1];
        if (paramConstraintWidgetContainer.mTarget != null) {
          paramConstraintWidgetContainer = paramConstraintWidgetContainer.mTarget.mSolverVariable;
        } else {
          paramConstraintWidgetContainer = null;
        }
      }
      if (localConstraintWidget1 == localConstraintWidget3)
      {
        localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
        localObject2 = localConstraintWidget1.mListAnchors[paramInt1];
      }
      if ((paramChainHead != null) && (paramConstraintWidgetContainer != null))
      {
        paramInt2 = ((ConstraintAnchor)localObject1).getMargin();
        if (localConstraintWidget3 == null) {
          localObject3 = localConstraintWidget2;
        } else {
          localObject3 = localConstraintWidget3;
        }
        paramInt1 = localObject3.mListAnchors[paramInt1].getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramChainHead, paramInt2, 0.5F, paramConstraintWidgetContainer, ((ConstraintAnchor)localObject2).mSolverVariable, paramInt1, 5);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Chain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */