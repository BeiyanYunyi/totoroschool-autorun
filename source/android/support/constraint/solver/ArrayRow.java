package android.support.constraint.solver;

public class ArrayRow
  implements LinearSystem.Row
{
  private static final boolean DEBUG = false;
  private static final float epsilon = 0.001F;
  float constantValue = 0.0F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  public final ArrayLinkedVariables variables;
  
  public ArrayRow(Cache paramCache)
  {
    this.variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  public ArrayRow addError(LinearSystem paramLinearSystem, int paramInt)
  {
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "ep"), 1.0F);
    this.variables.put(paramLinearSystem.createErrorVariable(paramInt, "em"), -1.0F);
    return this;
  }
  
  public void addError(SolverVariable paramSolverVariable)
  {
    int i = paramSolverVariable.strength;
    float f = 1.0F;
    if (i != 1) {
      if (paramSolverVariable.strength == 2) {
        f = 1000.0F;
      } else if (paramSolverVariable.strength == 3) {
        f = 1000000.0F;
      } else if (paramSolverVariable.strength == 4) {
        f = 1.0E9F;
      } else if (paramSolverVariable.strength == 5) {
        f = 1.0E12F;
      }
    }
    this.variables.put(paramSolverVariable, f);
  }
  
  ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variables.put(paramSolverVariable, paramInt);
    return this;
  }
  
  boolean chooseSubject(LinearSystem paramLinearSystem)
  {
    paramLinearSystem = this.variables.chooseSubject(paramLinearSystem);
    boolean bool;
    if (paramLinearSystem == null)
    {
      bool = true;
    }
    else
    {
      pivot(paramLinearSystem);
      bool = false;
    }
    if (this.variables.currentSize == 0) {
      this.isSimpleDefinition = true;
    }
    return bool;
  }
  
  public void clear()
  {
    this.variables.clear();
    this.variable = null;
    this.constantValue = 0.0F;
  }
  
  ArrayRow createRowCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      this.variables.put(paramSolverVariable2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      this.variables.put(paramSolverVariable4, 1.0F);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        this.constantValue = (-paramInt1 + paramInt2);
        return this;
      }
    }
    else
    {
      if (paramFloat <= 0.0F)
      {
        this.variables.put(paramSolverVariable1, -1.0F);
        this.variables.put(paramSolverVariable2, 1.0F);
        this.constantValue = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.variables.put(paramSolverVariable3, -1.0F);
        this.variables.put(paramSolverVariable4, 1.0F);
        this.constantValue = paramInt2;
        return this;
      }
      ArrayLinkedVariables localArrayLinkedVariables = this.variables;
      float f = 1.0F - paramFloat;
      localArrayLinkedVariables.put(paramSolverVariable1, f * 1.0F);
      this.variables.put(paramSolverVariable2, f * -1.0F);
      this.variables.put(paramSolverVariable3, -1.0F * paramFloat);
      this.variables.put(paramSolverVariable4, 1.0F * paramFloat);
      if ((paramInt1 > 0) || (paramInt2 > 0)) {
        this.constantValue = (-paramInt1 * f + paramInt2 * paramFloat);
      }
    }
    return this;
  }
  
  ArrayRow createRowDefinition(SolverVariable paramSolverVariable, int paramInt)
  {
    this.variable = paramSolverVariable;
    float f = paramInt;
    paramSolverVariable.computedValue = f;
    this.constantValue = f;
    this.isSimpleDefinition = true;
    return this;
  }
  
  ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F - paramFloat);
    this.variables.put(paramSolverVariable3, paramFloat);
    return this;
  }
  
  public ArrayRow createRowDimensionRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable1, -1.0F);
    this.variables.put(paramSolverVariable2, 1.0F);
    this.variables.put(paramSolverVariable3, paramFloat);
    this.variables.put(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  public ArrayRow createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, int paramInt1, SolverVariable paramSolverVariable2, int paramInt2, SolverVariable paramSolverVariable3, int paramInt3, SolverVariable paramSolverVariable4, int paramInt4)
  {
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      this.constantValue = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, paramFloat1);
      this.variables.put(paramSolverVariable3, -paramFloat1);
      return this;
    }
    this.constantValue = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, 1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEqualMatchDimensions(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4)
  {
    this.constantValue = 0.0F;
    if ((paramFloat2 != 0.0F) && (paramFloat1 != paramFloat3))
    {
      if (paramFloat1 == 0.0F)
      {
        this.variables.put(paramSolverVariable1, 1.0F);
        this.variables.put(paramSolverVariable2, -1.0F);
        return this;
      }
      if (paramFloat3 == 0.0F)
      {
        this.variables.put(paramSolverVariable3, 1.0F);
        this.variables.put(paramSolverVariable4, -1.0F);
        return this;
      }
      paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
      this.variables.put(paramSolverVariable1, 1.0F);
      this.variables.put(paramSolverVariable2, -1.0F);
      this.variables.put(paramSolverVariable4, paramFloat1);
      this.variables.put(paramSolverVariable3, -paramFloat1);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable4, 1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      this.constantValue = (paramInt * -1);
      this.variables.put(paramSolverVariable, 1.0F);
      return this;
    }
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, int paramInt, SolverVariable paramSolverVariable2)
  {
    this.constantValue = paramInt;
    this.variables.put(paramSolverVariable1, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, 1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.constantValue = j;
    }
    if (i == 0)
    {
      this.variables.put(paramSolverVariable1, -1.0F);
      this.variables.put(paramSolverVariable2, 1.0F);
      this.variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    this.variables.put(paramSolverVariable1, 1.0F);
    this.variables.put(paramSolverVariable2, -1.0F);
    this.variables.put(paramSolverVariable3, 1.0F);
    return this;
  }
  
  public ArrayRow createRowWithAngle(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    this.variables.put(paramSolverVariable3, 0.5F);
    this.variables.put(paramSolverVariable4, 0.5F);
    this.variables.put(paramSolverVariable1, -0.5F);
    this.variables.put(paramSolverVariable2, -0.5F);
    this.constantValue = (-paramFloat);
    return this;
  }
  
  void ensurePositiveConstant()
  {
    if (this.constantValue < 0.0F)
    {
      this.constantValue *= -1.0F;
      this.variables.invert();
    }
  }
  
  public SolverVariable getKey()
  {
    return this.variable;
  }
  
  public SolverVariable getPivotCandidate(LinearSystem paramLinearSystem, boolean[] paramArrayOfBoolean)
  {
    return this.variables.getPivotCandidate(paramArrayOfBoolean, null);
  }
  
  boolean hasKeyVariable()
  {
    return (this.variable != null) && ((this.variable.mType == SolverVariable.Type.UNRESTRICTED) || (this.constantValue >= 0.0F));
  }
  
  boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return this.variables.containsKey(paramSolverVariable);
  }
  
  public void initFromRow(LinearSystem.Row paramRow)
  {
    if ((paramRow instanceof ArrayRow))
    {
      paramRow = (ArrayRow)paramRow;
      this.variable = null;
      this.variables.clear();
      int i = 0;
      while (i < paramRow.variables.currentSize)
      {
        SolverVariable localSolverVariable = paramRow.variables.getVariable(i);
        float f = paramRow.variables.getVariableValue(i);
        this.variables.add(localSolverVariable, f, true);
        i += 1;
      }
    }
  }
  
  public boolean isEmpty()
  {
    return (this.variable == null) && (this.constantValue == 0.0F) && (this.variables.currentSize == 0);
  }
  
  SolverVariable pickPivot(SolverVariable paramSolverVariable)
  {
    return this.variables.getPivotCandidate(null, paramSolverVariable);
  }
  
  void pivot(SolverVariable paramSolverVariable)
  {
    if (this.variable != null)
    {
      this.variables.put(this.variable, -1.0F);
      this.variable = null;
    }
    float f = this.variables.remove(paramSolverVariable, true) * -1.0F;
    this.variable = paramSolverVariable;
    if (f == 1.0F) {
      return;
    }
    this.constantValue /= f;
    this.variables.divideByAmount(f);
  }
  
  public void reset()
  {
    this.variable = null;
    this.variables.clear();
    this.constantValue = 0.0F;
    this.isSimpleDefinition = false;
  }
  
  int sizeInBytes()
  {
    int i;
    if (this.variable != null) {
      i = 4;
    } else {
      i = 0;
    }
    return i + 4 + 4 + this.variables.sizeInBytes();
  }
  
  String toReadableString()
  {
    if (this.variable == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("0");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.variable);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" = ");
    Object localObject1 = ((StringBuilder)localObject2).toString();
    float f1 = this.constantValue;
    int j = 0;
    int i;
    if (f1 != 0.0F)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.constantValue);
      localObject1 = ((StringBuilder)localObject2).toString();
      i = 1;
    }
    else
    {
      i = 0;
    }
    int k = this.variables.currentSize;
    while (j < k)
    {
      localObject2 = this.variables.getVariable(j);
      if (localObject2 != null)
      {
        float f2 = this.variables.getVariableValue(j);
        if (f2 != 0.0F)
        {
          String str = ((SolverVariable)localObject2).toString();
          if (i == 0)
          {
            localObject2 = localObject1;
            f1 = f2;
            if (f2 < 0.0F)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("- ");
              localObject2 = ((StringBuilder)localObject2).toString();
              f1 = f2 * -1.0F;
            }
          }
          else if (f2 > 0.0F)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" + ");
            localObject2 = ((StringBuilder)localObject2).toString();
            f1 = f2;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" - ");
            localObject2 = ((StringBuilder)localObject2).toString();
            f1 = f2 * -1.0F;
          }
          if (f1 == 1.0F)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(f1);
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          i = 1;
        }
      }
      j += 1;
    }
    localObject2 = localObject1;
    if (i == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0.0");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    return toReadableString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\ArrayRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */