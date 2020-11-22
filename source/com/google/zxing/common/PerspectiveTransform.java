package com.google.zxing.common;

public final class PerspectiveTransform
{
  private final float a11;
  private final float a12;
  private final float a13;
  private final float a21;
  private final float a22;
  private final float a23;
  private final float a31;
  private final float a32;
  private final float a33;
  
  private PerspectiveTransform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.a11 = paramFloat1;
    this.a12 = paramFloat4;
    this.a13 = paramFloat7;
    this.a21 = paramFloat2;
    this.a22 = paramFloat5;
    this.a23 = paramFloat8;
    this.a31 = paramFloat3;
    this.a32 = paramFloat6;
    this.a33 = paramFloat9;
  }
  
  public static PerspectiveTransform quadrilateralToQuadrilateral(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    PerspectiveTransform localPerspectiveTransform = quadrilateralToSquare(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    return squareToQuadrilateral(paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16).times(localPerspectiveTransform);
  }
  
  public static PerspectiveTransform quadrilateralToSquare(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return squareToQuadrilateral(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8).buildAdjoint();
  }
  
  public static PerspectiveTransform squareToQuadrilateral(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = paramFloat1 - paramFloat3 + paramFloat5 - paramFloat7;
    float f2 = paramFloat2 - paramFloat4 + paramFloat6 - paramFloat8;
    if ((f1 == 0.0F) && (f2 == 0.0F)) {
      return new PerspectiveTransform(paramFloat3 - paramFloat1, paramFloat5 - paramFloat3, paramFloat1, paramFloat4 - paramFloat2, paramFloat6 - paramFloat4, paramFloat2, 0.0F, 0.0F, 1.0F);
    }
    float f3 = paramFloat3 - paramFloat5;
    float f4 = paramFloat7 - paramFloat5;
    paramFloat5 = paramFloat4 - paramFloat6;
    float f5 = paramFloat8 - paramFloat6;
    paramFloat6 = f3 * f5 - f4 * paramFloat5;
    f4 = (f5 * f1 - f4 * f2) / paramFloat6;
    paramFloat5 = (f3 * f2 - f1 * paramFloat5) / paramFloat6;
    return new PerspectiveTransform(paramFloat3 - paramFloat1 + f4 * paramFloat3, paramFloat5 * paramFloat7 + (paramFloat7 - paramFloat1), paramFloat1, paramFloat4 - paramFloat2 + f4 * paramFloat4, paramFloat8 - paramFloat2 + paramFloat5 * paramFloat8, paramFloat2, f4, paramFloat5, 1.0F);
  }
  
  PerspectiveTransform buildAdjoint()
  {
    return new PerspectiveTransform(this.a22 * this.a33 - this.a23 * this.a32, this.a23 * this.a31 - this.a21 * this.a33, this.a21 * this.a32 - this.a22 * this.a31, this.a13 * this.a32 - this.a12 * this.a33, this.a11 * this.a33 - this.a13 * this.a31, this.a12 * this.a31 - this.a11 * this.a32, this.a12 * this.a23 - this.a13 * this.a22, this.a13 * this.a21 - this.a11 * this.a23, this.a11 * this.a22 - this.a12 * this.a21);
  }
  
  PerspectiveTransform times(PerspectiveTransform paramPerspectiveTransform)
  {
    float f1 = this.a11;
    float f2 = paramPerspectiveTransform.a11;
    float f3 = this.a21;
    float f4 = paramPerspectiveTransform.a12;
    float f5 = this.a31;
    float f6 = paramPerspectiveTransform.a13;
    float f7 = this.a11;
    float f8 = paramPerspectiveTransform.a21;
    float f9 = this.a21;
    float f10 = paramPerspectiveTransform.a22;
    float f11 = this.a31;
    float f12 = paramPerspectiveTransform.a23;
    float f13 = this.a11;
    float f14 = paramPerspectiveTransform.a31;
    float f15 = this.a21;
    float f16 = paramPerspectiveTransform.a32;
    float f17 = this.a31;
    float f18 = paramPerspectiveTransform.a33;
    float f19 = this.a12;
    float f20 = paramPerspectiveTransform.a11;
    float f21 = this.a22;
    float f22 = paramPerspectiveTransform.a12;
    float f23 = this.a32;
    float f24 = paramPerspectiveTransform.a13;
    float f25 = this.a12;
    float f26 = paramPerspectiveTransform.a21;
    float f27 = this.a22;
    float f28 = paramPerspectiveTransform.a22;
    float f29 = this.a32;
    float f30 = paramPerspectiveTransform.a23;
    float f31 = this.a12;
    float f32 = paramPerspectiveTransform.a31;
    float f33 = this.a22;
    float f34 = paramPerspectiveTransform.a32;
    float f35 = this.a32;
    float f36 = paramPerspectiveTransform.a33;
    float f37 = this.a13;
    float f38 = paramPerspectiveTransform.a11;
    float f39 = this.a23;
    float f40 = paramPerspectiveTransform.a12;
    float f41 = this.a33;
    float f42 = paramPerspectiveTransform.a13;
    float f43 = this.a13;
    float f44 = paramPerspectiveTransform.a21;
    float f45 = this.a23;
    float f46 = paramPerspectiveTransform.a22;
    float f47 = this.a33;
    float f48 = paramPerspectiveTransform.a23;
    float f49 = this.a13;
    float f50 = paramPerspectiveTransform.a31;
    float f51 = this.a23;
    float f52 = paramPerspectiveTransform.a32;
    return new PerspectiveTransform(f5 * f6 + (f1 * f2 + f3 * f4), f11 * f12 + (f7 * f8 + f9 * f10), f17 * f18 + (f13 * f14 + f15 * f16), f23 * f24 + (f19 * f20 + f21 * f22), f29 * f30 + (f25 * f26 + f27 * f28), f35 * f36 + (f31 * f32 + f33 * f34), f41 * f42 + (f37 * f38 + f39 * f40), f47 * f48 + (f43 * f44 + f45 * f46), this.a33 * paramPerspectiveTransform.a33 + (f49 * f50 + f51 * f52));
  }
  
  public void transformPoints(float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    float f1 = this.a11;
    float f2 = this.a12;
    float f3 = this.a13;
    float f4 = this.a21;
    float f5 = this.a22;
    float f6 = this.a23;
    float f7 = this.a31;
    float f8 = this.a32;
    float f9 = this.a33;
    int i = 0;
    while (i < j)
    {
      float f10 = paramArrayOfFloat[i];
      int k = i + 1;
      float f11 = paramArrayOfFloat[k];
      float f12 = f3 * f10 + f6 * f11 + f9;
      paramArrayOfFloat[i] = ((f1 * f10 + f4 * f11 + f7) / f12);
      paramArrayOfFloat[k] = ((f10 * f2 + f11 * f5 + f8) / f12);
      i += 2;
    }
  }
  
  public void transformPoints(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int j = paramArrayOfFloat1.length;
    int i = 0;
    while (i < j)
    {
      float f1 = paramArrayOfFloat1[i];
      float f2 = paramArrayOfFloat2[i];
      float f3 = this.a13 * f1 + this.a23 * f2 + this.a33;
      paramArrayOfFloat1[i] = ((this.a11 * f1 + this.a21 * f2 + this.a31) / f3);
      paramArrayOfFloat2[i] = ((this.a12 * f1 + this.a22 * f2 + this.a32) / f3);
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\PerspectiveTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */