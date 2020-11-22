package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder
{
  private final GenericGF field;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.field = paramGenericGF;
  }
  
  private int[] findErrorLocations(GenericGFPoly paramGenericGFPoly)
    throws ReedSolomonException
  {
    int m = paramGenericGFPoly.getDegree();
    int j = 0;
    int i = 1;
    if (m == 1) {
      return new int[] { paramGenericGFPoly.getCoefficient(1) };
    }
    int[] arrayOfInt = new int[m];
    while ((i < this.field.getSize()) && (j < m))
    {
      int k = j;
      if (paramGenericGFPoly.evaluateAt(i) == 0)
      {
        arrayOfInt[j] = this.field.inverse(i);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j == m) {
      return arrayOfInt;
    }
    throw new ReedSolomonException("Error locator degree does not match number of roots");
  }
  
  private int[] findErrorMagnitudes(GenericGFPoly paramGenericGFPoly, int[] paramArrayOfInt)
  {
    int n = paramArrayOfInt.length;
    int[] arrayOfInt = new int[n];
    int i = 0;
    while (i < n)
    {
      int i1 = this.field.inverse(paramArrayOfInt[i]);
      int j = 0;
      int m;
      for (int k = 1; j < n; k = m)
      {
        m = k;
        if (i != j)
        {
          m = this.field.multiply(paramArrayOfInt[j], i1);
          if ((m & 0x1) == 0) {
            m |= 0x1;
          } else {
            m &= 0xFFFFFFFE;
          }
          m = this.field.multiply(k, m);
        }
        j += 1;
      }
      arrayOfInt[i] = this.field.multiply(paramGenericGFPoly.evaluateAt(i1), this.field.inverse(k));
      if (this.field.getGeneratorBase() != 0) {
        arrayOfInt[i] = this.field.multiply(arrayOfInt[i], i1);
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly paramGenericGFPoly1, GenericGFPoly paramGenericGFPoly2, int paramInt)
    throws ReedSolomonException
  {
    Object localObject2 = paramGenericGFPoly1;
    Object localObject1 = paramGenericGFPoly2;
    if (paramGenericGFPoly1.getDegree() < paramGenericGFPoly2.getDegree())
    {
      localObject1 = paramGenericGFPoly1;
      localObject2 = paramGenericGFPoly2;
    }
    GenericGFPoly localGenericGFPoly1 = this.field.getZero();
    GenericGFPoly localGenericGFPoly2 = this.field.getOne();
    paramGenericGFPoly2 = (GenericGFPoly)localObject2;
    paramGenericGFPoly1 = (GenericGFPoly)localObject1;
    localObject1 = localGenericGFPoly2;
    localObject2 = localGenericGFPoly1;
    while (paramGenericGFPoly1.getDegree() >= paramInt / 2) {
      if (!paramGenericGFPoly1.isZero())
      {
        localGenericGFPoly1 = this.field.getZero();
        int i = paramGenericGFPoly1.getCoefficient(paramGenericGFPoly1.getDegree());
        i = this.field.inverse(i);
        while ((paramGenericGFPoly2.getDegree() >= paramGenericGFPoly1.getDegree()) && (!paramGenericGFPoly2.isZero()))
        {
          int j = paramGenericGFPoly2.getDegree() - paramGenericGFPoly1.getDegree();
          int k = this.field.multiply(paramGenericGFPoly2.getCoefficient(paramGenericGFPoly2.getDegree()), i);
          localGenericGFPoly1 = localGenericGFPoly1.addOrSubtract(this.field.buildMonomial(j, k));
          paramGenericGFPoly2 = paramGenericGFPoly2.addOrSubtract(paramGenericGFPoly1.multiplyByMonomial(j, k));
        }
        localObject2 = localGenericGFPoly1.multiply((GenericGFPoly)localObject1).addOrSubtract((GenericGFPoly)localObject2);
        if (paramGenericGFPoly2.getDegree() < paramGenericGFPoly1.getDegree())
        {
          localGenericGFPoly1 = paramGenericGFPoly1;
          paramGenericGFPoly1 = paramGenericGFPoly2;
          paramGenericGFPoly2 = (GenericGFPoly)localObject2;
          localObject2 = localObject1;
          localObject1 = paramGenericGFPoly2;
          paramGenericGFPoly2 = localGenericGFPoly1;
        }
        else
        {
          throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
        }
      }
      else
      {
        throw new ReedSolomonException("r_{i-1} was zero");
      }
    }
    paramInt = ((GenericGFPoly)localObject1).getCoefficient(0);
    if (paramInt != 0)
    {
      paramInt = this.field.inverse(paramInt);
      return new GenericGFPoly[] { ((GenericGFPoly)localObject1).multiply(paramInt), paramGenericGFPoly1.multiply(paramInt) };
    }
    throw new ReedSolomonException("sigmaTilde(0) was zero");
  }
  
  public void decode(int[] paramArrayOfInt, int paramInt)
    throws ReedSolomonException
  {
    Object localObject1 = new GenericGFPoly(this.field, paramArrayOfInt);
    Object localObject2 = new int[paramInt];
    int k = 0;
    int i = 0;
    int j = 1;
    while (i < paramInt)
    {
      int m = ((GenericGFPoly)localObject1).evaluateAt(this.field.exp(this.field.getGeneratorBase() + i));
      localObject2[(localObject2.length - 1 - i)] = m;
      if (m != 0) {
        j = 0;
      }
      i += 1;
    }
    if (j != 0) {
      return;
    }
    localObject1 = new GenericGFPoly(this.field, (int[])localObject2);
    localObject2 = runEuclideanAlgorithm(this.field.buildMonomial(paramInt, 1), (GenericGFPoly)localObject1, paramInt);
    localObject1 = localObject2[0];
    localObject2 = localObject2[1];
    localObject1 = findErrorLocations((GenericGFPoly)localObject1);
    localObject2 = findErrorMagnitudes((GenericGFPoly)localObject2, (int[])localObject1);
    paramInt = k;
    while (paramInt < localObject1.length)
    {
      i = paramArrayOfInt.length - 1 - this.field.log(localObject1[paramInt]);
      if (i >= 0)
      {
        paramArrayOfInt[i] = GenericGF.addOrSubtract(paramArrayOfInt[i], localObject2[paramInt]);
        paramInt += 1;
      }
      else
      {
        throw new ReedSolomonException("Bad error location");
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\reedsolomon\ReedSolomonDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */