package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection
{
  private final ModulusGF field = ModulusGF.PDF417_GF;
  
  private int[] findErrorLocations(ModulusPoly paramModulusPoly)
    throws ChecksumException
  {
    int m = paramModulusPoly.getDegree();
    int[] arrayOfInt = new int[m];
    int i = 1;
    int k;
    for (int j = 0; (i < this.field.getSize()) && (j < m); j = k)
    {
      k = j;
      if (paramModulusPoly.evaluateAt(i) == 0)
      {
        arrayOfInt[j] = this.field.inverse(i);
        k = j + 1;
      }
      i += 1;
    }
    if (j == m) {
      return arrayOfInt;
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  private int[] findErrorMagnitudes(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int[] paramArrayOfInt)
  {
    int j = paramModulusPoly2.getDegree();
    int[] arrayOfInt = new int[j];
    int i = 1;
    while (i <= j)
    {
      arrayOfInt[(j - i)] = this.field.multiply(i, paramModulusPoly2.getCoefficient(i));
      i += 1;
    }
    paramModulusPoly2 = new ModulusPoly(this.field, arrayOfInt);
    j = paramArrayOfInt.length;
    arrayOfInt = new int[j];
    i = 0;
    while (i < j)
    {
      int m = this.field.inverse(paramArrayOfInt[i]);
      int k = this.field.subtract(0, paramModulusPoly1.evaluateAt(m));
      m = this.field.inverse(paramModulusPoly2.evaluateAt(m));
      arrayOfInt[i] = this.field.multiply(k, m);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int paramInt)
    throws ChecksumException
  {
    Object localObject2 = paramModulusPoly1;
    Object localObject1 = paramModulusPoly2;
    if (paramModulusPoly1.getDegree() < paramModulusPoly2.getDegree())
    {
      localObject1 = paramModulusPoly1;
      localObject2 = paramModulusPoly2;
    }
    ModulusPoly localModulusPoly1 = this.field.getZero();
    ModulusPoly localModulusPoly2 = this.field.getOne();
    paramModulusPoly2 = (ModulusPoly)localObject2;
    paramModulusPoly1 = (ModulusPoly)localObject1;
    localObject1 = localModulusPoly2;
    localObject2 = localModulusPoly1;
    while (paramModulusPoly1.getDegree() >= paramInt / 2) {
      if (!paramModulusPoly1.isZero())
      {
        localModulusPoly1 = this.field.getZero();
        int i = paramModulusPoly1.getCoefficient(paramModulusPoly1.getDegree());
        i = this.field.inverse(i);
        while ((paramModulusPoly2.getDegree() >= paramModulusPoly1.getDegree()) && (!paramModulusPoly2.isZero()))
        {
          int j = paramModulusPoly2.getDegree() - paramModulusPoly1.getDegree();
          int k = this.field.multiply(paramModulusPoly2.getCoefficient(paramModulusPoly2.getDegree()), i);
          localModulusPoly1 = localModulusPoly1.add(this.field.buildMonomial(j, k));
          paramModulusPoly2 = paramModulusPoly2.subtract(paramModulusPoly1.multiplyByMonomial(j, k));
        }
        localObject2 = localModulusPoly1.multiply((ModulusPoly)localObject1).subtract((ModulusPoly)localObject2).negative();
        localModulusPoly1 = paramModulusPoly1;
        paramModulusPoly1 = paramModulusPoly2;
        paramModulusPoly2 = (ModulusPoly)localObject2;
        localObject2 = localObject1;
        localObject1 = paramModulusPoly2;
        paramModulusPoly2 = localModulusPoly1;
      }
      else
      {
        throw ChecksumException.getChecksumInstance();
      }
    }
    paramInt = ((ModulusPoly)localObject1).getCoefficient(0);
    if (paramInt != 0)
    {
      paramInt = this.field.inverse(paramInt);
      return new ModulusPoly[] { ((ModulusPoly)localObject1).multiply(paramInt), paramModulusPoly1.multiply(paramInt) };
    }
    throw ChecksumException.getChecksumInstance();
  }
  
  public int decode(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
    throws ChecksumException
  {
    Object localObject = new ModulusPoly(this.field, paramArrayOfInt1);
    int[] arrayOfInt = new int[paramInt];
    int k = 0;
    int i = paramInt;
    int j = 0;
    int m;
    while (i > 0)
    {
      m = ((ModulusPoly)localObject).evaluateAt(this.field.exp(i));
      arrayOfInt[(paramInt - i)] = m;
      if (m != 0) {
        j = 1;
      }
      i -= 1;
    }
    if (j == 0) {
      return 0;
    }
    localObject = this.field.getOne();
    if (paramArrayOfInt2 != null)
    {
      j = paramArrayOfInt2.length;
      i = 0;
      while (i < j)
      {
        m = paramArrayOfInt2[i];
        m = this.field.exp(paramArrayOfInt1.length - 1 - m);
        localObject = ((ModulusPoly)localObject).multiply(new ModulusPoly(this.field, new int[] { this.field.subtract(0, m), 1 }));
        i += 1;
      }
    }
    paramArrayOfInt2 = new ModulusPoly(this.field, arrayOfInt);
    localObject = runEuclideanAlgorithm(this.field.buildMonomial(paramInt, 1), paramArrayOfInt2, paramInt);
    paramArrayOfInt2 = localObject[0];
    arrayOfInt = localObject[1];
    localObject = findErrorLocations(paramArrayOfInt2);
    paramArrayOfInt2 = findErrorMagnitudes(arrayOfInt, paramArrayOfInt2, (int[])localObject);
    paramInt = k;
    while (paramInt < localObject.length)
    {
      i = paramArrayOfInt1.length - 1 - this.field.log(localObject[paramInt]);
      if (i >= 0)
      {
        paramArrayOfInt1[i] = this.field.subtract(paramArrayOfInt1[i], paramArrayOfInt2[paramInt]);
        paramInt += 1;
      }
      else
      {
        throw ChecksumException.getChecksumInstance();
      }
    }
    return localObject.length;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */