package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  public static final boolean FULL_DEBUG = false;
  private static int POOL_SIZE = 1000;
  public static Metrics sMetrics;
  private int TABLE_SIZE = 32;
  public boolean graphOptimizer = false;
  private boolean[] mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
  final Cache mCache;
  private Row mGoal;
  private int mMaxColumns = this.TABLE_SIZE;
  private int mMaxRows = this.TABLE_SIZE;
  int mNumColumns = 1;
  int mNumRows = 0;
  private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
  private int mPoolVariablesCount = 0;
  ArrayRow[] mRows = null;
  private final Row mTempGoal;
  private HashMap<String, SolverVariable> mVariables = null;
  int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
  
  public LinearSystem()
  {
    releaseRows();
    this.mCache = new Cache();
    this.mGoal = new GoalRow(this.mCache);
    this.mTempGoal = new ArrayRow(this.mCache);
  }
  
  private SolverVariable acquireSolverVariable(SolverVariable.Type paramType, String paramString)
  {
    SolverVariable localSolverVariable = (SolverVariable)this.mCache.solverVariablePool.acquire();
    if (localSolverVariable == null)
    {
      localSolverVariable = new SolverVariable(paramType, paramString);
      localSolverVariable.setType(paramType, paramString);
      paramType = localSolverVariable;
    }
    else
    {
      localSolverVariable.reset();
      localSolverVariable.setType(paramType, paramString);
      paramType = localSolverVariable;
    }
    if (this.mPoolVariablesCount >= POOL_SIZE)
    {
      POOL_SIZE *= 2;
      this.mPoolVariables = ((SolverVariable[])Arrays.copyOf(this.mPoolVariables, POOL_SIZE));
    }
    paramString = this.mPoolVariables;
    int i = this.mPoolVariablesCount;
    this.mPoolVariablesCount = (i + 1);
    paramString[i] = paramType;
    return paramType;
  }
  
  private void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(this, 0);
  }
  
  private final void addRow(ArrayRow paramArrayRow)
  {
    if (this.mRows[this.mNumRows] != null) {
      this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
    }
    this.mRows[this.mNumRows] = paramArrayRow;
    paramArrayRow.variable.definitionId = this.mNumRows;
    this.mNumRows += 1;
    paramArrayRow.variable.updateReferencesWithNewDefinition(paramArrayRow);
  }
  
  private void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    addSingleError(paramArrayRow, paramInt, 0);
  }
  
  private void computeValues()
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      ArrayRow localArrayRow = this.mRows[i];
      localArrayRow.variable.computedValue = localArrayRow.constantValue;
      i += 1;
    }
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean) {
      localArrayRow.addError(paramLinearSystem, 4);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    if (paramBoolean) {
      paramLinearSystem.addError(localArrayRow);
    }
    return localArrayRow.createRowDimensionPercent(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, 1);
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow localArrayRow = paramLinearSystem.createRow();
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt);
    if (paramBoolean) {
      paramLinearSystem.addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F));
    }
    return localArrayRow;
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.variables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramType = acquireSolverVariable(paramType, null);
    paramType.setName(paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramType.id = this.mVariablesID;
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    this.mVariables.put(paramString, paramType);
    this.mCache.mIndexedVariables[this.mVariablesID] = paramType;
    return paramType;
  }
  
  private void displayRows()
  {
    displaySolverVariables();
    String str = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mRows[i]);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.mGoal);
    localStringBuilder.append("\n");
    str = localStringBuilder.toString();
    System.out.println(str);
  }
  
  private void displaySolverVariables()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Display Rows (");
    ((StringBuilder)localObject).append(this.mNumRows);
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(this.mNumColumns);
    ((StringBuilder)localObject).append(")\n");
    localObject = ((StringBuilder)localObject).toString();
    System.out.println((String)localObject);
  }
  
  private int enforceBFS(Row paramRow)
    throws Exception
  {
    int i = 0;
    while (i < this.mNumRows)
    {
      if ((this.mRows[i].variable.mType != SolverVariable.Type.UNRESTRICTED) && (this.mRows[i].constantValue < 0.0F))
      {
        i = 1;
        break label67;
      }
      i += 1;
    }
    i = 0;
    label67:
    if (i != 0)
    {
      int m = 0;
      int i5;
      for (i = 0; m == 0; i = i5)
      {
        if (sMetrics != null)
        {
          paramRow = sMetrics;
          paramRow.bfs += 1L;
        }
        i5 = i + 1;
        int n = 0;
        i = -1;
        int j = -1;
        float f1 = Float.MAX_VALUE;
        int i4;
        Object localObject;
        for (int k = 0; n < this.mNumRows; k = i4)
        {
          paramRow = this.mRows[n];
          int i2;
          int i3;
          float f2;
          if (paramRow.variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            i2 = i;
            i3 = j;
            f2 = f1;
            i4 = k;
          }
          else if (paramRow.isSimpleDefinition)
          {
            i2 = i;
            i3 = j;
            f2 = f1;
            i4 = k;
          }
          else
          {
            i2 = i;
            i3 = j;
            f2 = f1;
            i4 = k;
            if (paramRow.constantValue < 0.0F)
            {
              int i1 = 1;
              for (;;)
              {
                i2 = i;
                i3 = j;
                f2 = f1;
                i4 = k;
                if (i1 >= this.mNumColumns) {
                  break;
                }
                localObject = this.mCache.mIndexedVariables[i1];
                float f3 = paramRow.variables.get((SolverVariable)localObject);
                if (f3 > 0.0F)
                {
                  i3 = k;
                  i4 = 0;
                  k = j;
                  i2 = i;
                  i = i4;
                  for (j = i3; i < 7; j = i3)
                  {
                    f2 = localObject.strengthVector[i] / f3;
                    if ((f2 >= f1) || (i != j))
                    {
                      i3 = j;
                      if (i <= j) {}
                    }
                    else
                    {
                      k = i1;
                      i2 = n;
                      f1 = f2;
                      i3 = i;
                    }
                    i += 1;
                  }
                  i = k;
                  k = j;
                  j = i;
                  i = i2;
                }
                i1 += 1;
              }
            }
          }
          n += 1;
          i = i2;
          j = i3;
          f1 = f2;
        }
        if (i != -1)
        {
          paramRow = this.mRows[i];
          paramRow.variable.definitionId = -1;
          if (sMetrics != null)
          {
            localObject = sMetrics;
            ((Metrics)localObject).pivots += 1L;
          }
          paramRow.pivot(this.mCache.mIndexedVariables[j]);
          paramRow.variable.definitionId = i;
          paramRow.variable.updateReferencesWithNewDefinition(paramRow);
        }
        else
        {
          m = 1;
        }
        if (i5 > this.mNumColumns / 2) {
          m = 1;
        }
      }
      return i;
    }
    return 0;
  }
  
  private String getDisplaySize(int paramInt)
  {
    paramInt *= 4;
    int i = paramInt / 1024;
    int j = i / 1024;
    if (j > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      localStringBuilder.append(" Mb");
      return localStringBuilder.toString();
    }
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localStringBuilder.append(" Kb");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes");
    return localStringBuilder.toString();
  }
  
  private String getDisplayStrength(int paramInt)
  {
    if (paramInt == 1) {
      return "LOW";
    }
    if (paramInt == 2) {
      return "MEDIUM";
    }
    if (paramInt == 3) {
      return "HIGH";
    }
    if (paramInt == 4) {
      return "HIGHEST";
    }
    if (paramInt == 5) {
      return "EQUALITY";
    }
    if (paramInt == 6) {
      return "FIXED";
    }
    return "NONE";
  }
  
  public static Metrics getMetrics()
  {
    return sMetrics;
  }
  
  private void increaseTableSize()
  {
    this.TABLE_SIZE *= 2;
    this.mRows = ((ArrayRow[])Arrays.copyOf(this.mRows, this.TABLE_SIZE));
    this.mCache.mIndexedVariables = ((SolverVariable[])Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE));
    this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
    this.mMaxColumns = this.TABLE_SIZE;
    this.mMaxRows = this.TABLE_SIZE;
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.tableSizeIncrease += 1L;
      sMetrics.maxTableSize = Math.max(sMetrics.maxTableSize, this.TABLE_SIZE);
      sMetrics.lastTableSize = sMetrics.maxTableSize;
    }
  }
  
  private final int optimize(Row paramRow, boolean paramBoolean)
  {
    Object localObject;
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).optimize += 1L;
    }
    int i = 0;
    while (i < this.mNumColumns)
    {
      this.mAlreadyTestedCandidates[i] = false;
      i += 1;
    }
    int j = 0;
    i = 0;
    while (j == 0)
    {
      if (sMetrics != null)
      {
        localObject = sMetrics;
        ((Metrics)localObject).iterations += 1L;
      }
      int n = i + 1;
      if (n >= this.mNumColumns * 2) {
        return n;
      }
      if (paramRow.getKey() != null) {
        this.mAlreadyTestedCandidates[paramRow.getKey().id] = true;
      }
      localObject = paramRow.getPivotCandidate(this, this.mAlreadyTestedCandidates);
      if (localObject != null)
      {
        if (this.mAlreadyTestedCandidates[localObject.id] != 0) {
          return n;
        }
        this.mAlreadyTestedCandidates[localObject.id] = true;
      }
      if (localObject != null)
      {
        i = 0;
        int k = -1;
        ArrayRow localArrayRow;
        float f2;
        for (float f1 = Float.MAX_VALUE; i < this.mNumRows; f1 = f2)
        {
          localArrayRow = this.mRows[i];
          int m;
          if (localArrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED)
          {
            m = k;
            f2 = f1;
          }
          else if (localArrayRow.isSimpleDefinition)
          {
            m = k;
            f2 = f1;
          }
          else
          {
            m = k;
            f2 = f1;
            if (localArrayRow.hasVariable((SolverVariable)localObject))
            {
              float f3 = localArrayRow.variables.get((SolverVariable)localObject);
              m = k;
              f2 = f1;
              if (f3 < 0.0F)
              {
                f3 = -localArrayRow.constantValue / f3;
                m = k;
                f2 = f1;
                if (f3 < f1)
                {
                  m = i;
                  f2 = f3;
                }
              }
            }
          }
          i += 1;
          k = m;
        }
        if (k > -1)
        {
          localArrayRow = this.mRows[k];
          localArrayRow.variable.definitionId = -1;
          if (sMetrics != null)
          {
            Metrics localMetrics = sMetrics;
            localMetrics.pivots += 1L;
          }
          localArrayRow.pivot((SolverVariable)localObject);
          localArrayRow.variable.definitionId = k;
          localArrayRow.variable.updateReferencesWithNewDefinition(localArrayRow);
          i = n;
          continue;
        }
      }
      j = 1;
      i = n;
    }
    return i;
  }
  
  private void releaseRows()
  {
    int i = 0;
    while (i < this.mRows.length)
    {
      ArrayRow localArrayRow = this.mRows[i];
      if (localArrayRow != null) {
        this.mCache.arrayRowPool.release(localArrayRow);
      }
      this.mRows[i] = null;
      i += 1;
    }
  }
  
  private final void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (this.mNumRows > 0)
    {
      paramArrayRow.variables.updateFromSystem(paramArrayRow, this.mRows);
      if (paramArrayRow.variables.currentSize == 0) {
        paramArrayRow.isSimpleDefinition = true;
      }
    }
  }
  
  public void addCenterPoint(ConstraintWidget paramConstraintWidget1, ConstraintWidget paramConstraintWidget2, float paramFloat, int paramInt)
  {
    SolverVariable localSolverVariable1 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable localSolverVariable3 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable localSolverVariable2 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT));
    SolverVariable localSolverVariable5 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM));
    paramConstraintWidget1 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable localSolverVariable6 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable localSolverVariable4 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
    paramConstraintWidget2 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
    ArrayRow localArrayRow = createRow();
    double d2 = paramFloat;
    double d3 = Math.sin(d2);
    double d1 = paramInt;
    Double.isNaN(d1);
    localArrayRow.createRowWithAngle(localSolverVariable3, localSolverVariable5, localSolverVariable6, paramConstraintWidget2, (float)(d3 * d1));
    addConstraint(localArrayRow);
    paramConstraintWidget2 = createRow();
    d2 = Math.cos(d2);
    Double.isNaN(d1);
    paramConstraintWidget2.createRowWithAngle(localSolverVariable1, localSolverVariable2, paramConstraintWidget1, localSolverVariable4, (float)(d2 * d1));
    addConstraint(paramConstraintWidget2);
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramInt3 != 6) {
      localArrayRow.addError(this, paramInt3);
    }
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    if (paramArrayRow == null) {
      return;
    }
    Object localObject;
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).constraints += 1L;
      if (paramArrayRow.isSimpleDefinition)
      {
        localObject = sMetrics;
        ((Metrics)localObject).simpleconstraints += 1L;
      }
    }
    if ((this.mNumRows + 1 >= this.mMaxRows) || (this.mNumColumns + 1 >= this.mMaxColumns)) {
      increaseTableSize();
    }
    int i = 0;
    int j = 0;
    if (!paramArrayRow.isSimpleDefinition)
    {
      updateRowFromVariables(paramArrayRow);
      if (paramArrayRow.isEmpty()) {
        return;
      }
      paramArrayRow.ensurePositiveConstant();
      i = j;
      if (paramArrayRow.chooseSubject(this))
      {
        localObject = createExtraVariable();
        paramArrayRow.variable = ((SolverVariable)localObject);
        addRow(paramArrayRow);
        this.mTempGoal.initFromRow(paramArrayRow);
        optimize(this.mTempGoal, true);
        if (((SolverVariable)localObject).definitionId == -1)
        {
          if (paramArrayRow.variable == localObject)
          {
            localObject = paramArrayRow.pickPivot((SolverVariable)localObject);
            if (localObject != null)
            {
              if (sMetrics != null)
              {
                Metrics localMetrics = sMetrics;
                localMetrics.pivots += 1L;
              }
              paramArrayRow.pivot((SolverVariable)localObject);
            }
          }
          if (!paramArrayRow.isSimpleDefinition) {
            paramArrayRow.variable.updateReferencesWithNewDefinition(paramArrayRow);
          }
          this.mNumRows -= 1;
        }
        i = 1;
      }
      if (!paramArrayRow.hasKeyVariable()) {
        return;
      }
    }
    if (i == 0) {
      addRow(paramArrayRow);
    }
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    if (paramInt2 != 6) {
      localArrayRow.addError(this, paramInt2);
    }
    addConstraint(localArrayRow);
    return localArrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt;
        return;
      }
      if (localArrayRow.variables.currentSize == 0)
      {
        localArrayRow.isSimpleDefinition = true;
        localArrayRow.constantValue = paramInt;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(localArrayRow);
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt1, int paramInt2)
  {
    int i = paramSolverVariable.definitionId;
    if (paramSolverVariable.definitionId != -1)
    {
      localArrayRow = this.mRows[i];
      if (localArrayRow.isSimpleDefinition)
      {
        localArrayRow.constantValue = paramInt1;
        return;
      }
      localArrayRow = createRow();
      localArrayRow.createRowEquals(paramSolverVariable, paramInt1);
      localArrayRow.addError(this, paramInt2);
      addConstraint(localArrayRow);
      return;
    }
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDefinition(paramSolverVariable, paramInt1);
    localArrayRow.addError(this, paramInt2);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable, paramInt, localSolverVariable);
    addConstraint(localArrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, 0);
    if (paramBoolean) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), 1);
    }
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    localSolverVariable.strength = 0;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    if (paramInt2 != 6) {
      addSingleError(localArrayRow, (int)(localArrayRow.variables.get(localSolverVariable) * -1.0F), paramInt2);
    }
    addConstraint(localArrayRow);
  }
  
  public void addRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat, int paramInt)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowDimensionRatio(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramSolverVariable4, paramFloat);
    if (paramInt != 6) {
      localArrayRow.addError(this, paramInt);
    }
    addConstraint(localArrayRow);
  }
  
  void addSingleError(ArrayRow paramArrayRow, int paramInt1, int paramInt2)
  {
    paramArrayRow.addSingleError(createErrorVariable(paramInt2, null), paramInt1);
  }
  
  public SolverVariable createErrorVariable(int paramInt, String paramString)
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.errors += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    paramString = acquireSolverVariable(SolverVariable.Type.ERROR, paramString);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    paramString.id = this.mVariablesID;
    paramString.strength = paramInt;
    this.mCache.mIndexedVariables[this.mVariablesID] = paramString;
    this.mGoal.addError(paramString);
    return paramString;
  }
  
  public SolverVariable createExtraVariable()
  {
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).extravariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    Object localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject;
    return (SolverVariable)localObject;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    if ((paramObject instanceof ConstraintAnchor))
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramObject;
      localObject = localConstraintAnchor.getSolverVariable();
      paramObject = localObject;
      if (localObject == null)
      {
        localConstraintAnchor.resetSolverVariable(this.mCache);
        paramObject = localConstraintAnchor.getSolverVariable();
      }
      if ((((SolverVariable)paramObject).id != -1) && (((SolverVariable)paramObject).id <= this.mVariablesID))
      {
        localObject = paramObject;
        if (this.mCache.mIndexedVariables[paramObject.id] != null) {}
      }
      else
      {
        if (((SolverVariable)paramObject).id != -1) {
          ((SolverVariable)paramObject).reset();
        }
        this.mVariablesID += 1;
        this.mNumColumns += 1;
        ((SolverVariable)paramObject).id = this.mVariablesID;
        ((SolverVariable)paramObject).mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[this.mVariablesID] = paramObject;
        localObject = paramObject;
      }
    }
    return (SolverVariable)localObject;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      localArrayRow = new ArrayRow(this.mCache);
    } else {
      localArrayRow.reset();
    }
    SolverVariable.increaseErrorId();
    return localArrayRow;
  }
  
  public SolverVariable createSlackVariable()
  {
    if (sMetrics != null)
    {
      localObject = sMetrics;
      ((Metrics)localObject).slackvariables += 1L;
    }
    if (this.mNumColumns + 1 >= this.mMaxColumns) {
      increaseTableSize();
    }
    Object localObject = acquireSolverVariable(SolverVariable.Type.SLACK, null);
    this.mVariablesID += 1;
    this.mNumColumns += 1;
    ((SolverVariable)localObject).id = this.mVariablesID;
    this.mCache.mIndexedVariables[this.mVariablesID] = localObject;
    return (SolverVariable)localObject;
  }
  
  void displayReadableRows()
  {
    displaySolverVariables();
    String str = " #  ";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mRows[i].toReadableString());
      str = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\n #  ");
      str = ((StringBuilder)localObject).toString();
      i += 1;
    }
    Object localObject = str;
    if (this.mGoal != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mGoal);
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    System.out.println((String)localObject);
  }
  
  void displaySystemInformations()
  {
    int j = 0;
    for (int i = 0; j < this.TABLE_SIZE; i = k)
    {
      k = i;
      if (this.mRows[j] != null) {
        k = i + this.mRows[j].sizeInBytes();
      }
      j += 1;
    }
    j = 0;
    int m;
    for (int k = 0; j < this.mNumRows; k = m)
    {
      m = k;
      if (this.mRows[j] != null) {
        m = k + this.mRows[j].sizeInBytes();
      }
      j += 1;
    }
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Linear System -> Table size: ");
    localStringBuilder.append(this.TABLE_SIZE);
    localStringBuilder.append(" (");
    localStringBuilder.append(getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE));
    localStringBuilder.append(") -- row sizes: ");
    localStringBuilder.append(getDisplaySize(i));
    localStringBuilder.append(", actual size: ");
    localStringBuilder.append(getDisplaySize(k));
    localStringBuilder.append(" rows: ");
    localStringBuilder.append(this.mNumRows);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxRows);
    localStringBuilder.append(" cols: ");
    localStringBuilder.append(this.mNumColumns);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mMaxColumns);
    localStringBuilder.append(" ");
    localStringBuilder.append(0);
    localStringBuilder.append(" occupied cells, ");
    localStringBuilder.append(getDisplaySize(0));
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    Object localObject1 = "";
    int i = 0;
    while (i < this.mNumRows)
    {
      localObject2 = localObject1;
      if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.mRows[i].toReadableString());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("\n");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mGoal);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    System.out.println((String)localObject1);
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    sMetrics = paramMetrics;
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  Row getGoal()
  {
    return this.mGoal;
  }
  
  public int getMemoryUsed()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mNumRows; j = k)
    {
      k = j;
      if (this.mRows[i] != null) {
        k = j + this.mRows[i].sizeInBytes();
      }
      i += 1;
    }
    return j;
  }
  
  public int getNumEquations()
  {
    return this.mNumRows;
  }
  
  public int getNumVariables()
  {
    return this.mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (paramObject != null) {
      return (int)(((SolverVariable)paramObject).computedValue + 0.5F);
    }
    return 0;
  }
  
  ArrayRow getRow(int paramInt)
  {
    return this.mRows[paramInt];
  }
  
  float getValueFor(String paramString)
  {
    paramString = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.computedValue;
  }
  
  SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (this.mVariables == null) {
      this.mVariables = new HashMap();
    }
    SolverVariable localSolverVariable2 = (SolverVariable)this.mVariables.get(paramString);
    SolverVariable localSolverVariable1 = localSolverVariable2;
    if (localSolverVariable2 == null) {
      localSolverVariable1 = createVariable(paramString, paramType);
    }
    return localSolverVariable1;
  }
  
  public void minimize()
    throws Exception
  {
    Metrics localMetrics;
    if (sMetrics != null)
    {
      localMetrics = sMetrics;
      localMetrics.minimize += 1L;
    }
    if (this.graphOptimizer)
    {
      if (sMetrics != null)
      {
        localMetrics = sMetrics;
        localMetrics.graphOptimizer += 1L;
      }
      int j = 0;
      int i = 0;
      while (i < this.mNumRows)
      {
        if (!this.mRows[i].isSimpleDefinition)
        {
          i = j;
          break label85;
        }
        i += 1;
      }
      i = 1;
      label85:
      if (i == 0)
      {
        minimizeGoal(this.mGoal);
        return;
      }
      if (sMetrics != null)
      {
        localMetrics = sMetrics;
        localMetrics.fullySolved += 1L;
      }
      computeValues();
      return;
    }
    minimizeGoal(this.mGoal);
  }
  
  void minimizeGoal(Row paramRow)
    throws Exception
  {
    if (sMetrics != null)
    {
      Metrics localMetrics = sMetrics;
      localMetrics.minimizeGoal += 1L;
      sMetrics.maxVariables = Math.max(sMetrics.maxVariables, this.mNumColumns);
      sMetrics.maxRows = Math.max(sMetrics.maxRows, this.mNumRows);
    }
    updateRowFromVariables((ArrayRow)paramRow);
    enforceBFS(paramRow);
    optimize(paramRow, false);
    computeValues();
  }
  
  public void reset()
  {
    int i = 0;
    while (i < this.mCache.mIndexedVariables.length)
    {
      SolverVariable localSolverVariable = this.mCache.mIndexedVariables[i];
      if (localSolverVariable != null) {
        localSolverVariable.reset();
      }
      i += 1;
    }
    this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
    this.mPoolVariablesCount = 0;
    Arrays.fill(this.mCache.mIndexedVariables, null);
    if (this.mVariables != null) {
      this.mVariables.clear();
    }
    this.mVariablesID = 0;
    this.mGoal.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.mNumRows)
    {
      this.mRows[i].used = false;
      i += 1;
    }
    releaseRows();
    this.mNumRows = 0;
  }
  
  static abstract interface Row
  {
    public abstract void addError(SolverVariable paramSolverVariable);
    
    public abstract void clear();
    
    public abstract SolverVariable getKey();
    
    public abstract SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean);
    
    public abstract void initFromRow(Row paramRow);
    
    public abstract boolean isEmpty();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\LinearSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */