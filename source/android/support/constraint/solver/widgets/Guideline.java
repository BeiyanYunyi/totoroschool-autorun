package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class Guideline
  extends ConstraintWidget
{
  public static final int HORIZONTAL = 0;
  public static final int RELATIVE_BEGIN = 1;
  public static final int RELATIVE_END = 2;
  public static final int RELATIVE_PERCENT = 0;
  public static final int RELATIVE_UNKNWON = -1;
  public static final int VERTICAL = 1;
  private ConstraintAnchor mAnchor = this.mTop;
  private Rectangle mHead;
  private int mHeadSize;
  private boolean mIsPositionRelaxed;
  private int mMinimumPosition;
  private int mOrientation;
  protected int mRelativeBegin = -1;
  protected int mRelativeEnd = -1;
  protected float mRelativePercent = -1.0F;
  
  public Guideline()
  {
    int i = 0;
    this.mOrientation = 0;
    this.mIsPositionRelaxed = false;
    this.mMinimumPosition = 0;
    this.mHead = new Rectangle();
    this.mHeadSize = 8;
    this.mAnchors.clear();
    this.mAnchors.add(this.mAnchor);
    int j = this.mListAnchors.length;
    while (i < j)
    {
      this.mListAnchors[i] = this.mAnchor;
      i += 1;
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    Object localObject2 = (ConstraintWidgetContainer)getParent();
    if (localObject2 == null) {
      return;
    }
    ConstraintAnchor localConstraintAnchor = ((ConstraintWidgetContainer)localObject2).getAnchor(ConstraintAnchor.Type.LEFT);
    Object localObject1 = ((ConstraintWidgetContainer)localObject2).getAnchor(ConstraintAnchor.Type.RIGHT);
    int i;
    if ((this.mParent != null) && (this.mParent.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mOrientation == 0)
    {
      localConstraintAnchor = ((ConstraintWidgetContainer)localObject2).getAnchor(ConstraintAnchor.Type.TOP);
      localObject1 = ((ConstraintWidgetContainer)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM);
      if ((this.mParent != null) && (this.mParent.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if (this.mRelativeBegin != -1)
    {
      localObject2 = paramLinearSystem.createObjectVariable(this.mAnchor);
      paramLinearSystem.addEquality((SolverVariable)localObject2, paramLinearSystem.createObjectVariable(localConstraintAnchor), this.mRelativeBegin, 6);
      if (i != 0) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(localObject1), (SolverVariable)localObject2, 0, 5);
      }
    }
    else if (this.mRelativeEnd != -1)
    {
      localObject2 = paramLinearSystem.createObjectVariable(this.mAnchor);
      localObject1 = paramLinearSystem.createObjectVariable(localObject1);
      paramLinearSystem.addEquality((SolverVariable)localObject2, (SolverVariable)localObject1, -this.mRelativeEnd, 6);
      if (i != 0)
      {
        paramLinearSystem.addGreaterThan((SolverVariable)localObject2, paramLinearSystem.createObjectVariable(localConstraintAnchor), 0, 5);
        paramLinearSystem.addGreaterThan((SolverVariable)localObject1, (SolverVariable)localObject2, 0, 5);
      }
    }
    else if (this.mRelativePercent != -1.0F)
    {
      paramLinearSystem.addConstraint(LinearSystem.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor), paramLinearSystem.createObjectVariable(localObject1), this.mRelativePercent, this.mIsPositionRelaxed));
    }
  }
  
  public boolean allowedInBarrier()
  {
    return true;
  }
  
  public void analyze(int paramInt)
  {
    ConstraintWidget localConstraintWidget = getParent();
    if (localConstraintWidget == null) {
      return;
    }
    if (getOrientation() == 1)
    {
      this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), 0);
      this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), 0);
      if (this.mRelativeBegin != -1)
      {
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), this.mRelativeBegin);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), this.mRelativeBegin);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mRight.getResolutionNode(), -this.mRelativeEnd);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mRight.getResolutionNode(), -this.mRelativeEnd);
        return;
      }
      if ((this.mRelativePercent != -1.0F) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
      {
        paramInt = (int)(localConstraintWidget.mWidth * this.mRelativePercent);
        this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), paramInt);
        this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), paramInt);
      }
    }
    else
    {
      this.mLeft.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), 0);
      this.mRight.getResolutionNode().dependsOn(1, localConstraintWidget.mLeft.getResolutionNode(), 0);
      if (this.mRelativeBegin != -1)
      {
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), this.mRelativeBegin);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), this.mRelativeBegin);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mBottom.getResolutionNode(), -this.mRelativeEnd);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mBottom.getResolutionNode(), -this.mRelativeEnd);
        return;
      }
      if ((this.mRelativePercent != -1.0F) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED))
      {
        paramInt = (int)(localConstraintWidget.mHeight * this.mRelativePercent);
        this.mTop.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), paramInt);
        this.mBottom.getResolutionNode().dependsOn(1, localConstraintWidget.mTop.getResolutionNode(), paramInt);
      }
    }
  }
  
  public void cyclePosition()
  {
    if (this.mRelativeBegin != -1)
    {
      inferRelativePercentPosition();
      return;
    }
    if (this.mRelativePercent != -1.0F)
    {
      inferRelativeEndPosition();
      return;
    }
    if (this.mRelativeEnd != -1) {
      inferRelativeBeginPosition();
    }
  }
  
  public ConstraintAnchor getAnchor()
  {
    return this.mAnchor;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (paramType)
    {
    default: 
      break;
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      return null;
    case ???: 
    case ???: 
      if (this.mOrientation == 0) {
        return this.mAnchor;
      }
      break;
    case ???: 
    case ???: 
      if (this.mOrientation == 1) {
        return this.mAnchor;
      }
      break;
    }
    throw new AssertionError(paramType.name());
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public Rectangle getHead()
  {
    this.mHead.setBounds(getDrawX() - this.mHeadSize, getDrawY() - this.mHeadSize * 2, this.mHeadSize * 2, this.mHeadSize * 2);
    if (getOrientation() == 0) {
      this.mHead.setBounds(getDrawX() - this.mHeadSize * 2, getDrawY() - this.mHeadSize, this.mHeadSize * 2, this.mHeadSize * 2);
    }
    return this.mHead;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRelativeBegin()
  {
    return this.mRelativeBegin;
  }
  
  public int getRelativeBehaviour()
  {
    if (this.mRelativePercent != -1.0F) {
      return 0;
    }
    if (this.mRelativeBegin != -1) {
      return 1;
    }
    if (this.mRelativeEnd != -1) {
      return 2;
    }
    return -1;
  }
  
  public int getRelativeEnd()
  {
    return this.mRelativeEnd;
  }
  
  public float getRelativePercent()
  {
    return this.mRelativePercent;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  void inferRelativeBeginPosition()
  {
    int i = getX();
    if (this.mOrientation == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void inferRelativeEndPosition()
  {
    int i = getParent().getWidth() - getX();
    if (this.mOrientation == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  void inferRelativePercentPosition()
  {
    float f = getX() / getParent().getWidth();
    if (this.mOrientation == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      paramInt1 -= this.mOffsetX;
      if (this.mRelativeBegin != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getWidth() - paramInt1);
        return;
      }
      if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getWidth());
      }
    }
    else
    {
      paramInt1 = paramInt2 - this.mOffsetY;
      if (this.mRelativeBegin != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getHeight() - paramInt1);
        return;
      }
      if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getHeight());
      }
    }
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = paramInt;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.mRelativePercent = paramFloat;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    this.mMinimumPosition = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation == paramInt) {
      return;
    }
    this.mOrientation = paramInt;
    this.mAnchors.clear();
    if (this.mOrientation == 1) {
      this.mAnchor = this.mLeft;
    } else {
      this.mAnchor = this.mTop;
    }
    this.mAnchors.add(this.mAnchor);
    int i = this.mListAnchors.length;
    paramInt = 0;
    while (paramInt < i)
    {
      this.mListAnchors[paramInt] = this.mAnchor;
      paramInt += 1;
    }
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (this.mIsPositionRelaxed == paramBoolean) {
      return;
    }
    this.mIsPositionRelaxed = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    if (getParent() == null) {
      return;
    }
    int i = paramLinearSystem.getObjectVariableValue(this.mAnchor);
    if (this.mOrientation == 1)
    {
      setX(i);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    }
    setX(0);
    setY(i);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Guideline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */