package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final List<GenericGFPoly> cachedGenerators;
  private final GenericGF field;
  
  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    this.field = paramGenericGF;
    this.cachedGenerators = new ArrayList();
    this.cachedGenerators.add(new GenericGFPoly(paramGenericGF, new int[] { 1 }));
  }
  
  private GenericGFPoly buildGenerator(int paramInt)
  {
    if (paramInt >= this.cachedGenerators.size())
    {
      GenericGFPoly localGenericGFPoly = (GenericGFPoly)this.cachedGenerators.get(this.cachedGenerators.size() - 1);
      int i = this.cachedGenerators.size();
      while (i <= paramInt)
      {
        localGenericGFPoly = localGenericGFPoly.multiply(new GenericGFPoly(this.field, new int[] { 1, this.field.exp(i - 1 + this.field.getGeneratorBase()) }));
        this.cachedGenerators.add(localGenericGFPoly);
        i += 1;
      }
    }
    return (GenericGFPoly)this.cachedGenerators.get(paramInt);
  }
  
  public void encode(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = paramArrayOfInt.length - paramInt;
      if (i > 0)
      {
        Object localObject = buildGenerator(paramInt);
        int[] arrayOfInt = new int[i];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
        localObject = new GenericGFPoly(this.field, arrayOfInt).multiplyByMonomial(paramInt, 1).divide(localObject)[1].getCoefficients();
        int j = paramInt - localObject.length;
        paramInt = 0;
        while (paramInt < j)
        {
          paramArrayOfInt[(i + paramInt)] = 0;
          paramInt += 1;
        }
        System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
        return;
      }
      throw new IllegalArgumentException("No data bytes provided");
    }
    throw new IllegalArgumentException("No error correction bytes");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\reedsolomon\ReedSolomonEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */