package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF AZTEC_DATA_10;
  public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
  public static final GenericGF AZTEC_DATA_6;
  public static final GenericGF AZTEC_DATA_8 = DATA_MATRIX_FIELD_256;
  public static final GenericGF AZTEC_PARAM;
  public static final GenericGF DATA_MATRIX_FIELD_256;
  public static final GenericGF MAXICODE_FIELD_64 = AZTEC_DATA_6;
  public static final GenericGF QR_CODE_FIELD_256;
  private final int[] expTable;
  private final int generatorBase;
  private final int[] logTable;
  private final GenericGFPoly one;
  private final int primitive;
  private final int size;
  private final GenericGFPoly zero;
  
  static
  {
    AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
    AZTEC_DATA_6 = new GenericGF(67, 64, 1);
    AZTEC_PARAM = new GenericGF(19, 16, 1);
    QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
    DATA_MATRIX_FIELD_256 = new GenericGF(301, 256, 1);
  }
  
  public GenericGF(int paramInt1, int paramInt2, int paramInt3)
  {
    this.primitive = paramInt1;
    this.size = paramInt2;
    this.generatorBase = paramInt3;
    this.expTable = new int[paramInt2];
    this.logTable = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.expTable[i] = paramInt3;
      int j = paramInt3 * 2;
      paramInt3 = j;
      if (j >= paramInt2) {
        paramInt3 = (j ^ paramInt1) & paramInt2 - 1;
      }
      i += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - 1)
    {
      this.logTable[this.expTable[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.zero = new GenericGFPoly(this, new int[] { 0 });
    this.one = new GenericGFPoly(this, new int[] { 1 });
  }
  
  static int addOrSubtract(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  GenericGFPoly buildMonomial(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.zero;
      }
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new GenericGFPoly(this, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  int exp(int paramInt)
  {
    return this.expTable[paramInt];
  }
  
  public int getGeneratorBase()
  {
    return this.generatorBase;
  }
  
  GenericGFPoly getOne()
  {
    return this.one;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  GenericGFPoly getZero()
  {
    return this.zero;
  }
  
  int inverse(int paramInt)
  {
    if (paramInt != 0) {
      return this.expTable[(this.size - this.logTable[paramInt] - 1)];
    }
    throw new ArithmeticException();
  }
  
  int log(int paramInt)
  {
    if (paramInt != 0) {
      return this.logTable[paramInt];
    }
    throw new IllegalArgumentException();
  }
  
  int multiply(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      return this.expTable[((this.logTable[paramInt1] + this.logTable[paramInt2]) % (this.size - 1))];
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GF(0x");
    localStringBuilder.append(Integer.toHexString(this.primitive));
    localStringBuilder.append(',');
    localStringBuilder.append(this.size);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */