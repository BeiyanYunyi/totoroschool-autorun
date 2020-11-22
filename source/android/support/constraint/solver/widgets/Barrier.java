package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class Barrier
  extends Helper
{
  public static final int BOTTOM = 3;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int TOP = 2;
  private boolean mAllowsGoneWidget = true;
  private int mBarrierType = 0;
  private ArrayList<ResolutionAnchor> mNodes = new ArrayList(4);
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    this.mListAnchors[0] = this.mLeft;
    this.mListAnchors[2] = this.mTop;
    this.mListAnchors[1] = this.mRight;
    this.mListAnchors[3] = this.mBottom;
    int i = 0;
    while (i < this.mListAnchors.length)
    {
      this.mListAnchors[i].mSolverVariable = paramLinearSystem.createObjectVariable(this.mListAnchors[i]);
      i += 1;
    }
    if ((this.mBarrierType >= 0) && (this.mBarrierType < 4))
    {
      ConstraintAnchor localConstraintAnchor = this.mListAnchors[this.mBarrierType];
      i = 0;
      ConstraintWidget localConstraintWidget;
      while (i < this.mWidgetsCount)
      {
        localConstraintWidget = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier()))
        {
          if (((this.mBarrierType == 0) || (this.mBarrierType == 1)) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {}
          while (((this.mBarrierType == 2) || (this.mBarrierType == 3)) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
          {
            bool = true;
            break;
          }
        }
        i += 1;
      }
      boolean bool = false;
      if ((this.mBarrierType != 0) && (this.mBarrierType != 1) ? getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool = false;
      }
      i = 0;
      while (i < this.mWidgetsCount)
      {
        localConstraintWidget = this.mWidgets[i];
        if ((this.mAllowsGoneWidget) || (localConstraintWidget.allowedInBarrier()))
        {
          SolverVariable localSolverVariable = paramLinearSystem.createObjectVariable(localConstraintWidget.mListAnchors[this.mBarrierType]);
          localConstraintWidget.mListAnchors[this.mBarrierType].mSolverVariable = localSolverVariable;
          if ((this.mBarrierType != 0) && (this.mBarrierType != 2)) {
            paramLinearSystem.addGreaterBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, bool);
          } else {
            paramLinearSystem.addLowerBarrier(localConstraintAnchor.mSolverVariable, localSolverVariable, bool);
          }
        }
        i += 1;
      }
      if (this.mBarrierType == 0)
      {
        paramLinearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5);
        }
      }
      else if (this.mBarrierType == 1)
      {
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5);
        }
      }
      else if (this.mBarrierType == 2)
      {
        paramLinearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5);
        }
      }
      else if (this.mBarrierType == 3)
      {
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
        if (!bool) {
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
        }
      }
      return;
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mAllowsGoneWidget;
  }
  
  public void analyze(int paramInt)
  {
    if (this.mParent == null) {
      return;
    }
    if (!((ConstraintWidgetContainer)this.mParent).optimizeFor(2)) {
      return;
    }
    ResolutionAnchor localResolutionAnchor;
    switch (this.mBarrierType)
    {
    default: 
      return;
    case 3: 
      localResolutionAnchor = this.mBottom.getResolutionNode();
      break;
    case 2: 
      localResolutionAnchor = this.mTop.getResolutionNode();
      break;
    case 1: 
      localResolutionAnchor = this.mRight.getResolutionNode();
      break;
    case 0: 
      localResolutionAnchor = this.mLeft.getResolutionNode();
    }
    localResolutionAnchor.setType(5);
    if ((this.mBarrierType != 0) && (this.mBarrierType != 1))
    {
      this.mLeft.getResolutionNode().resolve(null, 0.0F);
      this.mRight.getResolutionNode().resolve(null, 0.0F);
    }
    else
    {
      this.mTop.getResolutionNode().resolve(null, 0.0F);
      this.mBottom.getResolutionNode().resolve(null, 0.0F);
    }
    this.mNodes.clear();
    paramInt = 0;
    while (paramInt < this.mWidgetsCount)
    {
      Object localObject = this.mWidgets[paramInt];
      if ((this.mAllowsGoneWidget) || (((ConstraintWidget)localObject).allowedInBarrier()))
      {
        switch (this.mBarrierType)
        {
        default: 
          localObject = null;
          break;
        case 3: 
          localObject = ((ConstraintWidget)localObject).mBottom.getResolutionNode();
          break;
        case 2: 
          localObject = ((ConstraintWidget)localObject).mTop.getResolutionNode();
          break;
        case 1: 
          localObject = ((ConstraintWidget)localObject).mRight.getResolutionNode();
          break;
        case 0: 
          localObject = ((ConstraintWidget)localObject).mLeft.getResolutionNode();
        }
        if (localObject != null)
        {
          this.mNodes.add(localObject);
          ((ResolutionAnchor)localObject).addDependent(localResolutionAnchor);
        }
      }
      paramInt += 1;
    }
  }
  
  public void resetResolutionNodes()
  {
    super.resetResolutionNodes();
    this.mNodes.clear();
  }
  
  public void resolve()
  {
    int i = this.mBarrierType;
    float f1 = Float.MAX_VALUE;
    switch (i)
    {
    default: 
      return;
    case 3: 
      localResolutionAnchor1 = this.mBottom.getResolutionNode();
      break;
    case 2: 
      localResolutionAnchor1 = this.mTop.getResolutionNode();
      break;
    case 1: 
      localResolutionAnchor1 = this.mRight.getResolutionNode();
      f1 = 0.0F;
      break;
    }
    ResolutionAnchor localResolutionAnchor1 = this.mLeft.getResolutionNode();
    int j = this.mNodes.size();
    ResolutionAnchor localResolutionAnchor2 = null;
    i = 0;
    Object localObject;
    for (float f2 = f1; i < j; f2 = f1)
    {
      localObject = (ResolutionAnchor)this.mNodes.get(i);
      if (((ResolutionAnchor)localObject).state != 1) {
        return;
      }
      if ((this.mBarrierType != 0) && (this.mBarrierType != 2))
      {
        f1 = f2;
        if (((ResolutionAnchor)localObject).resolvedOffset > f2)
        {
          f1 = ((ResolutionAnchor)localObject).resolvedOffset;
          localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
        }
      }
      else
      {
        f1 = f2;
        if (((ResolutionAnchor)localObject).resolvedOffset < f2)
        {
          f1 = ((ResolutionAnchor)localObject).resolvedOffset;
          localResolutionAnchor2 = ((ResolutionAnchor)localObject).resolvedTarget;
        }
      }
      i += 1;
    }
    if (LinearSystem.getMetrics() != null)
    {
      localObject = LinearSystem.getMetrics();
      ((Metrics)localObject).barrierConnectionResolved += 1L;
    }
    localResolutionAnchor1.resolvedTarget = localResolutionAnchor2;
    localResolutionAnchor1.resolvedOffset = f2;
    localResolutionAnchor1.didResolve();
    switch (this.mBarrierType)
    {
    default: 
      return;
    case 3: 
      this.mTop.getResolutionNode().resolve(localResolutionAnchor2, f2);
      return;
    case 2: 
      this.mBottom.getResolutionNode().resolve(localResolutionAnchor2, f2);
      return;
    case 1: 
      this.mLeft.getResolutionNode().resolve(localResolutionAnchor2, f2);
      return;
    }
    this.mRight.getResolutionNode().resolve(localResolutionAnchor2, f2);
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mAllowsGoneWidget = paramBoolean;
  }
  
  public void setBarrierType(int paramInt)
  {
    this.mBarrierType = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */