package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  private static final boolean DEBUG = false;
  static final boolean DEBUG_GRAPH = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final int MAX_ITERATIONS = 8;
  private static final boolean USE_SNAPSHOT = true;
  int mDebugSolverPassCount = 0;
  public boolean mGroupsWrapOptimized = false;
  private boolean mHeightMeasuredTooSmall = false;
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  int mHorizontalChainsSize = 0;
  public boolean mHorizontalWrapOptimized = false;
  private boolean mIsRtl = false;
  private int mOptimizationLevel = 7;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  public boolean mSkipSolver = false;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  int mVerticalChainsSize = 0;
  public boolean mVerticalWrapOptimized = false;
  public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
  private boolean mWidthMeasuredTooSmall = false;
  public int mWrapFixedHeight = 0;
  public int mWrapFixedWidth = 0;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
      this.mHorizontalChainsArray = ((ChainHead[])Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2));
    }
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.mHorizontalChainsSize += 1;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
      this.mVerticalChainsArray = ((ChainHead[])Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2));
    }
    this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.mVerticalChainsSize += 1;
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      addHorizontalChain(paramConstraintWidget);
      return;
    }
    if (paramInt == 1) {
      addVerticalChain(paramConstraintWidget);
    }
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem)
  {
    addToSolver(paramLinearSystem);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = localConstraintWidget.mListDimensionBehaviors[1];
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      else
      {
        Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        localConstraintWidget.addToSolver(paramLinearSystem);
      }
      i += 1;
    }
    if (this.mHorizontalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 0);
    }
    if (this.mVerticalChainsSize > 0) {
      Chain.applyChainConstraints(this, paramLinearSystem, 1);
    }
    return true;
  }
  
  public void analyze(int paramInt)
  {
    super.analyze(paramInt);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).analyze(paramInt);
      i += 1;
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mSystem.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getOptimizationLevel()
  {
    return this.mOptimizationLevel;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<ConstraintWidgetGroup> getWidgetGroups()
  {
    return this.mWidgetGroups;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isRtl()
  {
    return this.mIsRtl;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout()
  {
    int i5 = this.mX;
    int i6 = this.mY;
    int i7 = Math.max(0, getWidth());
    int i8 = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    if (this.mParent != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      setX(this.mPaddingLeft);
      setY(this.mPaddingTop);
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    }
    else
    {
      this.mX = 0;
      this.mY = 0;
    }
    if (this.mOptimizationLevel != 0)
    {
      if (!optimizeFor(8)) {
        optimizeReset();
      }
      if (!optimizeFor(32)) {
        optimize();
      }
      this.mSystem.graphOptimizer = true;
    }
    else
    {
      this.mSystem.graphOptimizer = false;
    }
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = this.mListDimensionBehaviors[1];
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = this.mListDimensionBehaviors[0];
    resetChains();
    if (this.mWidgetGroups.size() == 0)
    {
      this.mWidgetGroups.clear();
      this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
    }
    int i = this.mWidgetGroups.size();
    ArrayList localArrayList = this.mChildren;
    int i1;
    if ((getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int j = 0;
    int i2 = 0;
    int k;
    while ((i2 < i) && (!this.mSkipSolver))
    {
      if (!((ConstraintWidgetGroup)this.mWidgetGroups.get(i2)).mSkipSolver)
      {
        if (optimizeFor(32)) {
          if ((getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) && (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED)) {
            this.mChildren = ((ArrayList)((ConstraintWidgetGroup)this.mWidgetGroups.get(i2)).getWidgetsToSolve());
          } else {
            this.mChildren = ((ArrayList)((ConstraintWidgetGroup)this.mWidgetGroups.get(i2)).mConstrainedGroup);
          }
        }
        resetChains();
        int i9 = this.mChildren.size();
        k = 0;
        ConstraintWidget localConstraintWidget1;
        while (k < i9)
        {
          localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(k);
          if ((localConstraintWidget1 instanceof WidgetContainer)) {
            ((WidgetContainer)localConstraintWidget1).layout();
          }
          k += 1;
        }
        k = j;
        int m = 0;
        boolean bool1 = true;
        j = i;
        i = k;
        k = m;
        label610:
        label779:
        label1253:
        while (bool1)
        {
          m = k + 1;
          k = i;
          boolean bool2;
          try
          {
            this.mSystem.reset();
            k = i;
            resetChains();
            k = i;
            createObjectVariables(this.mSystem);
            n = 0;
            for (;;)
            {
              if (n < i9)
              {
                k = i;
                localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(n);
              }
              try
              {
                localConstraintWidget1.createObjectVariables(this.mSystem);
                n += 1;
              }
              catch (Exception localException2)
              {
                break label610;
              }
            }
            k = i;
            bool2 = addChildrenToSolver(this.mSystem);
            if (bool2) {
              try
              {
                this.mSystem.minimize();
              }
              catch (Exception localException1)
              {
                bool1 = bool2;
                i = k;
                break label610;
              }
            }
            i = k;
            bool1 = bool2;
          }
          catch (Exception localException3)
          {
            i = k;
          }
          localException3.printStackTrace();
          PrintStream localPrintStream = System.out;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("EXCEPTION : ");
          localStringBuilder.append(localException3);
          localPrintStream.println(localStringBuilder.toString());
          if (bool1) {
            updateChildrenFromSolver(this.mSystem, Optimizer.flags);
          }
          ConstraintWidget localConstraintWidget2;
          for (;;)
          {
            break;
            updateFromSolver(this.mSystem);
            k = 0;
            for (;;)
            {
              if (k >= i9) {
                break label779;
              }
              localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(k);
              if ((localConstraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getWidth() < localConstraintWidget2.getWrapWidth()))
              {
                Optimizer.flags[2] = true;
                break;
              }
              if ((localConstraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getHeight() < localConstraintWidget2.getWrapHeight()))
              {
                Optimizer.flags[2] = true;
                break;
              }
              k += 1;
            }
          }
          if ((i1 != 0) && (m < 8) && (Optimizer.flags[2] != 0))
          {
            int i4 = 0;
            int i3 = 0;
            n = 0;
            k = m;
            m = i4;
            while (m < i9)
            {
              localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(m);
              i3 = Math.max(i3, localConstraintWidget2.mX + localConstraintWidget2.getWidth());
              n = Math.max(n, localConstraintWidget2.mY + localConstraintWidget2.getHeight());
              m += 1;
            }
            i3 = Math.max(this.mMinWidth, i3);
            m = Math.max(this.mMinHeight, n);
            if ((localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getWidth() < i3))
            {
              setWidth(i3);
              this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
              bool1 = true;
              i = 1;
            }
            else
            {
              bool1 = false;
            }
            if ((localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getHeight() < m))
            {
              setHeight(m);
              this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
              bool1 = true;
              i = 1;
            }
          }
          else
          {
            k = m;
            bool1 = false;
          }
          m = Math.max(this.mMinWidth, getWidth());
          if (m > getWidth())
          {
            setWidth(m);
            this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            i = 1;
          }
          m = Math.max(this.mMinHeight, getHeight());
          if (m > getHeight())
          {
            setHeight(m);
            this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            i = 1;
          }
          boolean bool3 = bool1;
          int n = i;
          if (i == 0)
          {
            bool2 = bool1;
            m = i;
            if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
            {
              bool2 = bool1;
              m = i;
              if (i7 > 0)
              {
                bool2 = bool1;
                m = i;
                if (getWidth() > i7)
                {
                  this.mWidthMeasuredTooSmall = true;
                  this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setWidth(i7);
                  bool2 = true;
                  m = 1;
                }
              }
            }
            bool3 = bool2;
            n = m;
            if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
            {
              bool3 = bool2;
              n = m;
              if (i8 > 0)
              {
                bool3 = bool2;
                n = m;
                if (getHeight() > i8)
                {
                  this.mHeightMeasuredTooSmall = true;
                  this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setHeight(i8);
                  bool1 = true;
                  i = 1;
                  break label1253;
                }
              }
            }
          }
          bool1 = bool3;
          i = n;
        }
        ((ConstraintWidgetGroup)this.mWidgetGroups.get(i2)).updateUnresolvedWidgets();
        k = i;
        i = j;
        j = k;
      }
      i2 += 1;
    }
    this.mChildren = ((ArrayList)localArrayList);
    if (this.mParent != null)
    {
      i = Math.max(this.mMinWidth, getWidth());
      k = Math.max(this.mMinHeight, getHeight());
      this.mSnapshot.applyTo(this);
      setWidth(i + this.mPaddingLeft + this.mPaddingRight);
      setHeight(k + this.mPaddingTop + this.mPaddingBottom);
    }
    else
    {
      this.mX = i5;
      this.mY = i6;
    }
    if (j != 0)
    {
      this.mListDimensionBehaviors[0] = localDimensionBehaviour2;
      this.mListDimensionBehaviors[1] = localDimensionBehaviour1;
    }
    resetSolverVariables(this.mSystem.getCache());
    if (this == getRootConstraintContainer()) {
      updateDrawPosition();
    }
  }
  
  public void optimize()
  {
    if (!optimizeFor(8)) {
      analyze(this.mOptimizationLevel);
    }
    solveGraph();
  }
  
  public boolean optimizeFor(int paramInt)
  {
    return (this.mOptimizationLevel & paramInt) == paramInt;
  }
  
  public void optimizeForDimensions(int paramInt1, int paramInt2)
  {
    if ((this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (this.mResolutionWidth != null)) {
      this.mResolutionWidth.resolve(paramInt1);
    }
    if ((this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (this.mResolutionHeight != null)) {
      this.mResolutionHeight.resolve(paramInt2);
    }
  }
  
  public void optimizeReset()
  {
    int j = this.mChildren.size();
    resetResolutionNodes();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetResolutionNodes();
      i += 1;
    }
  }
  
  public void preOptimize()
  {
    optimizeReset();
    analyze(this.mOptimizationLevel);
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    this.mWidgetGroups.clear();
    this.mSkipSolver = false;
    super.reset();
  }
  
  public void resetGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.invalidateAnchors();
    localResolutionAnchor2.invalidateAnchors();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean)
  {
    this.mIsRtl = paramBoolean;
  }
  
  public void solveGraph()
  {
    ResolutionAnchor localResolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor localResolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    localResolutionAnchor1.resolve(null, 0.0F);
    localResolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[2] = false;
    updateFromSolver(paramLinearSystem);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.updateFromSolver(paramLinearSystem);
      if ((localConstraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getWidth() < localConstraintWidget.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localConstraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getHeight() < localConstraintWidget.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */