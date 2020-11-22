package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly
{
  private final int[] coefficients;
  private final ModulusGF field;
  
  ModulusPoly(ModulusGF paramModulusGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length != 0)
    {
      this.field = paramModulusGF;
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
  
  ModulusPoly add(ModulusPoly paramModulusPoly)
  {
    if (this.field.equals(paramModulusPoly.field))
    {
      if (isZero()) {
        return paramModulusPoly;
      }
      if (paramModulusPoly.isZero()) {
        return this;
      }
      int[] arrayOfInt1 = this.coefficients;
      int[] arrayOfInt3 = paramModulusPoly.coefficients;
      int[] arrayOfInt2 = arrayOfInt1;
      paramModulusPoly = arrayOfInt3;
      if (arrayOfInt1.length > arrayOfInt3.length)
      {
        arrayOfInt2 = arrayOfInt3;
        paramModulusPoly = arrayOfInt1;
      }
      arrayOfInt1 = new int[paramModulusPoly.length];
      int j = paramModulusPoly.length - arrayOfInt2.length;
      System.arraycopy(paramModulusPoly, 0, arrayOfInt1, 0, j);
      int i = j;
      while (i < paramModulusPoly.length)
      {
        arrayOfInt1[i] = this.field.add(arrayOfInt2[(i - j)], paramModulusPoly[i]);
        i += 1;
      }
      return new ModulusPoly(this.field, arrayOfInt1);
    }
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
  }
  
  ModulusPoly[] divide(ModulusPoly paramModulusPoly)
  {
    if (this.field.equals(paramModulusPoly.field))
    {
      if (!paramModulusPoly.isZero())
      {
        ModulusPoly localModulusPoly2 = this.field.getZero();
        int i = paramModulusPoly.getCoefficient(paramModulusPoly.getDegree());
        i = this.field.inverse(i);
        ModulusPoly localModulusPoly3;
        for (ModulusPoly localModulusPoly1 = this; (localModulusPoly1.getDegree() >= paramModulusPoly.getDegree()) && (!localModulusPoly1.isZero()); localModulusPoly1 = localModulusPoly1.subtract(localModulusPoly3))
        {
          int j = localModulusPoly1.getDegree() - paramModulusPoly.getDegree();
          int k = this.field.multiply(localModulusPoly1.getCoefficient(localModulusPoly1.getDegree()), i);
          localModulusPoly3 = paramModulusPoly.multiplyByMonomial(j, k);
          localModulusPoly2 = localModulusPoly2.add(this.field.buildMonomial(j, k));
        }
        return new ModulusPoly[] { localModulusPoly2, localModulusPoly1 };
      }
      throw new IllegalArgumentException("Divide by 0");
    }
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
        j = arrayOfInt[paramInt];
        i = this.field.add(i, j);
        paramInt += 1;
      }
      return i;
    }
    j = this.coefficients[0];
    while (i < k)
    {
      j = this.field.add(this.field.multiply(paramInt, j), this.coefficients[i]);
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
  
  ModulusPoly multiply(int paramInt)
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
    return new ModulusPoly(this.field, arrayOfInt);
  }
  
  ModulusPoly multiply(ModulusPoly paramModulusPoly)
  {
    if (this.field.equals(paramModulusPoly.field))
    {
      if ((!isZero()) && (!paramModulusPoly.isZero()))
      {
        int[] arrayOfInt1 = this.coefficients;
        int k = arrayOfInt1.length;
        paramModulusPoly = paramModulusPoly.coefficients;
        int m = paramModulusPoly.length;
        int[] arrayOfInt2 = new int[k + m - 1];
        int i = 0;
        while (i < k)
        {
          int n = arrayOfInt1[i];
          int j = 0;
          while (j < m)
          {
            int i1 = i + j;
            arrayOfInt2[i1] = this.field.add(arrayOfInt2[i1], this.field.multiply(n, paramModulusPoly[j]));
            j += 1;
          }
          i += 1;
        }
        return new ModulusPoly(this.field, arrayOfInt2);
      }
      return this.field.getZero();
    }
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
  }
  
  ModulusPoly multiplyByMonomial(int paramInt1, int paramInt2)
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
      return new ModulusPoly(this.field, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  ModulusPoly negative()
  {
    int j = this.coefficients.length;
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = this.field.subtract(0, this.coefficients[i]);
      i += 1;
    }
    return new ModulusPoly(this.field, arrayOfInt);
  }
  
  ModulusPoly subtract(ModulusPoly paramModulusPoly)
  {
    if (this.field.equals(paramModulusPoly.field))
    {
      if (paramModulusPoly.isZero()) {
        return this;
      }
      return add(paramModulusPoly.negative());
    }
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
        if ((i == 0) || (j != 1)) {
          localStringBuilder.append(j);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ModulusPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */