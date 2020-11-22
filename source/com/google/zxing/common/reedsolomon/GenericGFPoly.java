package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
  private final int[] coefficients;
  private final GenericGF field;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.field = paramGenericGF;
      int j = paramArrayOfInt.length;
      if ((j > 1) && (paramArrayOfInt[0] == 0))
      {
        int i = 1;
        while ((i < j) && (paramArrayOfInt[i] == 0)) {
          i += 1;
        }
        if (i == j)
        {
          this.coefficients = new int[] { 0 };
          return;
        }
        this.coefficients = new int[j - i];
        System.arraycopy(paramArrayOfInt, i, this.coefficients, 0, this.coefficients.length);
        return;
      }
      this.coefficients = paramArrayOfInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  GenericGFPoly addOrSubtract(GenericGFPoly paramGenericGFPoly)
  {
    if (this.field.equals(paramGenericGFPoly.field))
    {
      if (isZero()) {
        return paramGenericGFPoly;
      }
      if (paramGenericGFPoly.isZero()) {
        return this;
      }
      int[] arrayOfInt1 = this.coefficients;
      int[] arrayOfInt3 = paramGenericGFPoly.coefficients;
      int[] arrayOfInt2 = arrayOfInt1;
      paramGenericGFPoly = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        paramGenericGFPoly = arrayOfInt1;
      }
      arrayOfInt1 = new int[paramGenericGFPoly.length];
      int j = paramGenericGFPoly.length - arrayOfInt2.length;
      System.arraycopy(paramGenericGFPoly, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < paramGenericGFPoly.length)
      {
        arrayOfInt1[i] = GenericGF.addOrSubtract(arrayOfInt2[(i - j)], paramGenericGFPoly[i]);
        i += 1;
      }
      return new GenericGFPoly(this.field, arrayOfInt1);
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  GenericGFPoly[] divide(GenericGFPoly paramGenericGFPoly)
  {
    if (this.field.equals(paramGenericGFPoly.field))
    {
      if (!paramGenericGFPoly.isZero())
      {
        GenericGFPoly localGenericGFPoly2 = this.field.getZero();
        int i = paramGenericGFPoly.getCoefficient(paramGenericGFPoly.getDegree());
        i = this.field.inverse(i);
        GenericGFPoly localGenericGFPoly3;
        for (GenericGFPoly localGenericGFPoly1 = this; (localGenericGFPoly1.getDegree() >= paramGenericGFPoly.getDegree()) && (!localGenericGFPoly1.isZero()); localGenericGFPoly1 = localGenericGFPoly1.addOrSubtract(localGenericGFPoly3))
        {
          int j = localGenericGFPoly1.getDegree() - paramGenericGFPoly.getDegree();
          int k = this.field.multiply(localGenericGFPoly1.getCoefficient(localGenericGFPoly1.getDegree()), i);
          localGenericGFPoly3 = paramGenericGFPoly.multiplyByMonomial(j, k);
          localGenericGFPoly2 = localGenericGFPoly2.addOrSubtract(this.field.buildMonomial(j, k));
        }
        return new GenericGFPoly[] { localGenericGFPoly2, localGenericGFPoly1 };
      }
      throw new IllegalArgumentException("Divide by 0");
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  int evaluateAt(int paramInt)
  {
    int j = 0;
    if (paramInt == 0) {
      return getCoefficient(0);
    }
    int k = this.coefficients.length;
    int i = 1;
    if (paramInt == 1)
    {
      int[] arrayOfInt = this.coefficients;
      k = arrayOfInt.length;
      i = 0;
      paramInt = j;
      while (paramInt < k)
      {
        i = GenericGF.addOrSubtract(i, arrayOfInt[paramInt]);
        paramInt += 1;
      }
      return i;
    }
    j = this.coefficients[0];
    while (i < k)
    {
      j = GenericGF.addOrSubtract(this.field.multiply(paramInt, j), this.coefficients[i]);
      i += 1;
    }
    return j;
  }
  
  int getCoefficient(int paramInt)
  {
    return this.coefficients[(this.coefficients.length - 1 - paramInt)];
  }
  
  int[] getCoefficients()
  {
    return this.coefficients;
  }
  
  int getDegree()
  {
    return this.coefficients.length - 1;
  }
  
  boolean isZero()
  {
    int[] arrayOfInt = this.coefficients;
    boolean bool = false;
    if (arrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  GenericGFPoly multiply(int paramInt)
  {
    if (paramInt == 0) {
      return this.field.getZero();
    }
    if (paramInt == 1) {
      return this;
    }
    int j = this.coefficients.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = this.field.multiply(this.coefficients[i], paramInt);
      i += 1;
    }
    return new GenericGFPoly(this.field, arrayOfInt);
  }
  
  GenericGFPoly multiply(GenericGFPoly paramGenericGFPoly)
  {
    if (this.field.equals(paramGenericGFPoly.field))
    {
      if ((!isZero()) && (!paramGenericGFPoly.isZero()))
      {
        int[] arrayOfInt1 = this.coefficients;
        int k = arrayOfInt1.length;
        paramGenericGFPoly = paramGenericGFPoly.coefficients;
        int m = paramGenericGFPoly.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = GenericGF.addOrSubtract(arrayOfInt2[i1], this.field.multiply(n, paramGenericGFPoly[j]));
            j += 1;
          }
          i += 1;
        }
        return new GenericGFPoly(this.field, arrayOfInt2);
      }
      return this.field.getZero();
    }
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  GenericGFPoly multiplyByMonomial(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.field.getZero();
      }
      int i = this.coefficients.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfInt[paramInt1] = this.field.multiply(this.coefficients[paramInt1], paramInt2);
        paramInt1 += 1;
      }
      return new GenericGFPoly(this.field, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getDegree() * 8);
    int i = getDegree();
    while (i >= 0)
    {
      int k = getCoefficient(i);
      if (k != 0)
      {
        int j;
        if (k < 0)
        {
          localStringBuilder.append(" - ");
          j = -k;
        }
        else
        {
          j = k;
          if (localStringBuilder.length() > 0)
          {
            localStringBuilder.append(" + ");
            j = k;
          }
        }
        if ((i == 0) || (j != 1))
        {
          j = this.field.log(j);
          if (j == 0)
          {
            localStringBuilder.append('1');
          }
          else if (j == 1)
          {
            localStringBuilder.append('a');
          }
          else
          {
            localStringBuilder.append("a^");
            localStringBuilder.append(j);
          }
        }
        if (i != 0) {
          if (i == 1)
          {
            localStringBuilder.append('x');
          }
          else
          {
            localStringBuilder.append("x^");
            localStringBuilder.append(i);
          }
        }
      }
      i -= 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGFPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */