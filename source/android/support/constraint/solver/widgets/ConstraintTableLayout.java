package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout
  extends ConstraintWidgetContainer
{
  public static final int ALIGN_CENTER = 0;
  private static final int ALIGN_FULL = 3;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList();
  private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList();
  private int mNumCols = 0;
  private int mNumRows = 0;
  private int mPadding = 8;
  private boolean mVerticalGrowth = true;
  private ArrayList<Guideline> mVerticalGuidelines = new ArrayList();
  private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList();
  private LinearSystem system = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setChildrenConnections()
  {
    int k = this.mChildren.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(i);
      j += localConstraintWidget1.getContainerItemSkip();
      int m = this.mNumCols;
      int n = j / this.mNumCols;
      Object localObject = (HorizontalSlice)this.mHorizontalSlices.get(n);
      VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(j % m);
      ConstraintWidget localConstraintWidget2 = localVerticalSlice.left;
      ConstraintWidget localConstraintWidget3 = localVerticalSlice.right;
      ConstraintWidget localConstraintWidget4 = ((HorizontalSlice)localObject).top;
      localObject = ((HorizontalSlice)localObject).bottom;
      localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).connect(localConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
      if ((localConstraintWidget3 instanceof Guideline)) {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
      } else {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mPadding);
      }
      switch (localVerticalSlice.alignment)
      {
      default: 
        break;
      case 3: 
        localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        break;
      case 2: 
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        break;
      case 1: 
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
      }
      localConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).connect(localConstraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
      if ((localObject instanceof Guideline)) {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
      } else {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
      }
      j += 1;
      i += 1;
    }
  }
  
  private void setHorizontalSlices()
  {
    this.mHorizontalSlices.clear();
    float f2 = 100.0F / this.mNumRows;
    Object localObject = this;
    float f1 = f2;
    int i = 0;
    while (i < this.mNumRows)
    {
      HorizontalSlice localHorizontalSlice = new HorizontalSlice();
      localHorizontalSlice.top = ((ConstraintWidget)localObject);
      if (i < this.mNumRows - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(0);
        ((Guideline)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f1);
        f1 += f2;
        localHorizontalSlice.bottom = ((ConstraintWidget)localObject);
        this.mHorizontalGuidelines.add(localObject);
      }
      else
      {
        localHorizontalSlice.bottom = this;
      }
      localObject = localHorizontalSlice.bottom;
      this.mHorizontalSlices.add(localHorizontalSlice);
      i += 1;
    }
    updateDebugSolverNames();
  }
  
  private void setVerticalSlices()
  {
    this.mVerticalSlices.clear();
    float f2 = 100.0F / this.mNumCols;
    int i = 0;
    Object localObject = this;
    float f1 = f2;
    while (i < this.mNumCols)
    {
      VerticalSlice localVerticalSlice = new VerticalSlice();
      localVerticalSlice.left = ((ConstraintWidget)localObject);
      if (i < this.mNumCols - 1)
      {
        localObject = new Guideline();
        ((Guideline)localObject).setOrientation(1);
        ((Guideline)localObject).setParent(this);
        ((Guideline)localObject).setGuidePercent((int)f1);
        f1 += f2;
        localVerticalSlice.right = ((ConstraintWidget)localObject);
        this.mVerticalGuidelines.add(localObject);
      }
      else
      {
        localVerticalSlice.right = this;
      }
      localObject = localVerticalSlice.right;
      this.mVerticalSlices.add(localVerticalSlice);
      i += 1;
    }
    updateDebugSolverNames();
  }
  
  private void updateDebugSolverNames()
  {
    if (this.system == null) {
      return;
    }
    int k = this.mVerticalGuidelines.size();
    int j = 0;
    int i = 0;
    Guideline localGuideline;
    LinearSystem localLinearSystem;
    StringBuilder localStringBuilder;
    while (i < k)
    {
      localGuideline = (Guideline)this.mVerticalGuidelines.get(i);
      localLinearSystem = this.system;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getDebugName());
      localStringBuilder.append(".VG");
      localStringBuilder.append(i);
      localGuideline.setDebugSolverName(localLinearSystem, localStringBuilder.toString());
      i += 1;
    }
    k = this.mHorizontalGuidelines.size();
    i = j;
    while (i < k)
    {
      localGuideline = (Guideline)this.mHorizontalGuidelines.get(i);
      localLinearSystem = this.system;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getDebugName());
      localStringBuilder.append(".HG");
      localStringBuilder.append(i);
      localGuideline.setDebugSolverName(localLinearSystem, localStringBuilder.toString());
      i += 1;
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    super.addToSolver(paramLinearSystem);
    int m = this.mChildren.size();
    if (m == 0) {
      return;
    }
    setTableDimensions();
    if (paramLinearSystem == this.mSystem)
    {
      int j = this.mVerticalGuidelines.size();
      int k = 0;
      int i = 0;
      boolean bool;
      Guideline localGuideline;
      for (;;)
      {
        bool = true;
        if (i >= j) {
          break;
        }
        localGuideline = (Guideline)this.mVerticalGuidelines.get(i);
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = false;
        }
        localGuideline.setPositionRelaxed(bool);
        localGuideline.addToSolver(paramLinearSystem);
        i += 1;
      }
      int n = this.mHorizontalGuidelines.size();
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= n) {
          break;
        }
        localGuideline = (Guideline)this.mHorizontalGuidelines.get(i);
        if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = true;
        } else {
          bool = false;
        }
        localGuideline.setPositionRelaxed(bool);
        localGuideline.addToSolver(paramLinearSystem);
        i += 1;
      }
      while (j < m)
      {
        ((ConstraintWidget)this.mChildren.get(j)).addToSolver(paramLinearSystem);
        j += 1;
      }
    }
  }
  
  public void computeGuidelinesPercentPositions()
  {
    int k = this.mVerticalGuidelines.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ((Guideline)this.mVerticalGuidelines.get(i)).inferRelativePercentPosition();
      i += 1;
    }
    k = this.mHorizontalGuidelines.size();
    i = j;
    while (i < k)
    {
      ((Guideline)this.mHorizontalGuidelines.get(i)).inferRelativePercentPosition();
      i += 1;
    }
  }
  
  public void cycleColumnAlignment(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(paramInt);
    switch (localVerticalSlice.alignment)
    {
    default: 
      break;
    case 2: 
      localVerticalSlice.alignment = 1;
      break;
    case 1: 
      localVerticalSlice.alignment = 0;
      break;
    case 0: 
      localVerticalSlice.alignment = 2;
    }
    setChildrenConnections();
  }
  
  public String getColumnAlignmentRepresentation(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(paramInt);
    if (localVerticalSlice.alignment == 1) {
      return "L";
    }
    if (localVerticalSlice.alignment == 0) {
      return "C";
    }
    if (localVerticalSlice.alignment == 3) {
      return "F";
    }
    if (localVerticalSlice.alignment == 2) {
      return "R";
    }
    return "!";
  }
  
  public String getColumnsAlignmentRepresentation()
  {
    int j = this.mVerticalSlices.size();
    Object localObject2 = "";
    int i = 0;
    while (i < j)
    {
      VerticalSlice localVerticalSlice = (VerticalSlice)this.mVerticalSlices.get(i);
      Object localObject1;
      if (localVerticalSlice.alignment == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("L");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (localVerticalSlice.alignment == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("C");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if (localVerticalSlice.alignment == 3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("F");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = localObject2;
        if (localVerticalSlice.alignment == 2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("R");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    return (String)localObject2;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    return this.mHorizontalGuidelines;
  }
  
  public int getNumCols()
  {
    return this.mNumCols;
  }
  
  public int getNumRows()
  {
    return this.mNumRows;
  }
  
  public int getPadding()
  {
    return this.mPadding;
  }
  
  public String getType()
  {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    return this.mVerticalGuidelines;
  }
  
  public boolean handlesInternalConstraints()
  {
    return true;
  }
  
  public boolean isVerticalGrowth()
  {
    return this.mVerticalGrowth;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.mVerticalSlices.size())
    {
      ((VerticalSlice)this.mVerticalSlices.get(paramInt1)).alignment = paramInt2;
      setChildrenConnections();
    }
  }
  
  public void setColumnAlignment(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (k == 76) {
        setColumnAlignment(i, 1);
      } else if (k == 67) {
        setColumnAlignment(i, 0);
      } else if (k == 70) {
        setColumnAlignment(i, 3);
      } else if (k == 82) {
        setColumnAlignment(i, 2);
      } else {
        setColumnAlignment(i, 0);
      }
      i += 1;
    }
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    this.system = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    updateDebugSolverNames();
  }
  
  public void setNumCols(int paramInt)
  {
    if ((this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumCols = paramInt;
      setVerticalSlices();
      setTableDimensions();
    }
  }
  
  public void setNumRows(int paramInt)
  {
    if ((!this.mVerticalGrowth) && (this.mNumCols != paramInt))
    {
      this.mNumRows = paramInt;
      setHorizontalSlices();
      setTableDimensions();
    }
  }
  
  public void setPadding(int paramInt)
  {
    if (paramInt > 1) {
      this.mPadding = paramInt;
    }
  }
  
  public void setTableDimensions()
  {
    int k = this.mChildren.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((ConstraintWidget)this.mChildren.get(i)).getContainerItemSkip();
      i += 1;
    }
    k += j;
    if (this.mVerticalGrowth)
    {
      if (this.mNumCols == 0) {
        setNumCols(1);
      }
      j = k / this.mNumCols;
      i = j;
      if (this.mNumCols * j < k) {
        i = j + 1;
      }
      if ((this.mNumRows == i) && (this.mVerticalGuidelines.size() == this.mNumCols - 1)) {
        return;
      }
      this.mNumRows = i;
      setHorizontalSlices();
    }
    else
    {
      if (this.mNumRows == 0) {
        setNumRows(1);
      }
      j = k / this.mNumRows;
      i = j;
      if (this.mNumRows * j < k) {
        i = j + 1;
      }
      if ((this.mNumCols == i) && (this.mHorizontalGuidelines.size() == this.mNumRows - 1)) {
        return;
      }
      this.mNumCols = i;
      setVerticalSlices();
    }
    setChildrenConnections();
  }
  
  public void setVerticalGrowth(boolean paramBoolean)
  {
    this.mVerticalGrowth = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    super.updateFromSolver(paramLinearSystem);
    if (paramLinearSystem == this.mSystem)
    {
      int k = this.mVerticalGuidelines.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ((Guideline)this.mVerticalGuidelines.get(i)).updateFromSolver(paramLinearSystem);
        i += 1;
      }
      k = this.mHorizontalGuidelines.size();
      i = j;
      while (i < k)
      {
        ((Guideline)this.mHorizontalGuidelines.get(i)).updateFromSolver(paramLinearSystem);
        i += 1;
      }
    }
  }
  
  class HorizontalSlice
  {
    ConstraintWidget bottom;
    int padding;
    ConstraintWidget top;
    
    HorizontalSlice() {}
  }
  
  class VerticalSlice
  {
    int alignment = 1;
    ConstraintWidget left;
    int padding;
    ConstraintWidget right;
    
    VerticalSlice() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintTableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */