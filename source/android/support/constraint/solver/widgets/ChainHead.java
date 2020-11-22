package android.support.constraint.solver.widgets;

import java.util.ArrayList;

public class ChainHead
{
  private boolean mDefined;
  protected ConstraintWidget mFirst;
  protected ConstraintWidget mFirstMatchConstraintWidget;
  protected ConstraintWidget mFirstVisibleWidget;
  protected boolean mHasComplexMatchWeights;
  protected boolean mHasDefinedWeights;
  protected boolean mHasUndefinedWeights;
  protected ConstraintWidget mHead;
  private boolean mIsRtl = false;
  protected ConstraintWidget mLast;
  protected ConstraintWidget mLastMatchConstraintWidget;
  protected ConstraintWidget mLastVisibleWidget;
  private int mOrientation;
  protected float mTotalWeight = 0.0F;
  protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
  protected int mWidgetsCount;
  protected int mWidgetsMatchCount;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    this.mFirst = paramConstraintWidget;
    this.mOrientation = paramInt;
    this.mIsRtl = paramBoolean;
  }
  
  private void defineChainProperties()
  {
    int j = this.mOrientation * 2;
    Object localObject2 = this.mFirst;
    Object localObject1 = this.mFirst;
    Object localObject3 = this.mFirst;
    boolean bool2 = false;
    int i = 0;
    while (i == 0)
    {
      this.mWidgetsCount += 1;
      Object localObject4 = ((ConstraintWidget)localObject1).mNextChainWidget;
      int k = this.mOrientation;
      localObject3 = null;
      localObject4[k] = null;
      ((ConstraintWidget)localObject1).mListNextMatchConstraintsWidget[this.mOrientation] = null;
      if (((ConstraintWidget)localObject1).getVisibility() != 8)
      {
        if (this.mFirstVisibleWidget == null) {
          this.mFirstVisibleWidget = ((ConstraintWidget)localObject1);
        }
        this.mLastVisibleWidget = ((ConstraintWidget)localObject1);
        if ((localObject1.mListDimensionBehaviors[this.mOrientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 0) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 3) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 2)))
        {
          this.mWidgetsMatchCount += 1;
          float f = localObject1.mWeight[this.mOrientation];
          if (f > 0.0F) {
            this.mTotalWeight += localObject1.mWeight[this.mOrientation];
          }
          if (isMatchConstraintEqualityCandidate((ConstraintWidget)localObject1, this.mOrientation))
          {
            if (f < 0.0F) {
              this.mHasUndefinedWeights = true;
            } else {
              this.mHasDefinedWeights = true;
            }
            if (this.mWeightedMatchConstraintsWidgets == null) {
              this.mWeightedMatchConstraintsWidgets = new ArrayList();
            }
            this.mWeightedMatchConstraintsWidgets.add(localObject1);
          }
          if (this.mFirstMatchConstraintWidget == null) {
            this.mFirstMatchConstraintWidget = ((ConstraintWidget)localObject1);
          }
          if (this.mLastMatchConstraintWidget != null) {
            this.mLastMatchConstraintWidget.mListNextMatchConstraintsWidget[this.mOrientation] = localObject1;
          }
          this.mLastMatchConstraintWidget = ((ConstraintWidget)localObject1);
        }
      }
      if (localObject2 != localObject1) {
        ((ConstraintWidget)localObject2).mNextChainWidget[this.mOrientation] = localObject1;
      }
      localObject4 = localObject1.mListAnchors[(j + 1)].mTarget;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((ConstraintAnchor)localObject4).mOwner;
        localObject2 = localObject3;
        if (localObject4.mListAnchors[j].mTarget != null) {
          if (localObject4.mListAnchors[j].mTarget.mOwner != localObject1) {
            localObject2 = localObject3;
          } else {
            localObject2 = localObject4;
          }
        }
      }
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        i = 1;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    this.mLast = ((ConstraintWidget)localObject1);
    if ((this.mOrientation == 0) && (this.mIsRtl)) {
      this.mHead = this.mLast;
    } else {
      this.mHead = this.mFirst;
    }
    boolean bool1 = bool2;
    if (this.mHasDefinedWeights)
    {
      bool1 = bool2;
      if (this.mHasUndefinedWeights) {
        bool1 = true;
      }
    }
    this.mHasComplexMatchWeights = bool1;
  }
  
  private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    return (paramConstraintWidget.getVisibility() != 8) && (paramConstraintWidget.mListDimensionBehaviors[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 0) || (paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 3));
  }
  
  public void define()
  {
    if (!this.mDefined) {
      defineChainProperties();
    }
    this.mDefined = true;
  }
  
  public ConstraintWidget getFirst()
  {
    return this.mFirst;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget()
  {
    return this.mFirstMatchConstraintWidget;
  }
  
  public ConstraintWidget getFirstVisibleWidget()
  {
    return this.mFirstVisibleWidget;
  }
  
  public ConstraintWidget getHead()
  {
    return this.mHead;
  }
  
  public ConstraintWidget getLast()
  {
    return this.mLast;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget()
  {
    return this.mLastMatchConstraintWidget;
  }
  
  public ConstraintWidget getLastVisibleWidget()
  {
    return this.mLastVisibleWidget;
  }
  
  public float getTotalWeight()
  {
    return this.mTotalWeight;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ChainHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */