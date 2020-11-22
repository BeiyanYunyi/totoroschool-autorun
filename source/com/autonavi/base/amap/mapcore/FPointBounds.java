package com.autonavi.base.amap.mapcore;

public class FPointBounds
{
  private final int mVersionCode;
  public final FPoint northeast;
  public final FPoint southwest;
  
  FPointBounds(int paramInt, FPoint paramFPoint1, FPoint paramFPoint2)
  {
    this.mVersionCode = paramInt;
    this.southwest = paramFPoint1;
    this.northeast = paramFPoint2;
  }
  
  public FPointBounds(FPoint paramFPoint1, FPoint paramFPoint2)
  {
    this(1, paramFPoint1, paramFPoint2);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private boolean containsx(double paramDouble)
  {
    float f1 = this.southwest.x;
    float f2 = this.northeast.x;
    boolean bool = true;
    if (f1 <= f2) {
      return (this.southwest.x <= paramDouble) && (paramDouble <= this.northeast.x);
    }
    if (this.southwest.x > paramDouble)
    {
      if (paramDouble <= this.northeast.x) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean containsy(double paramDouble)
  {
    return (this.southwest.y <= paramDouble) && (paramDouble <= this.northeast.y);
  }
  
  private boolean intersect(FPointBounds paramFPointBounds)
  {
    boolean bool2 = false;
    if ((paramFPointBounds != null) && (paramFPointBounds.northeast != null) && (paramFPointBounds.southwest != null) && (this.northeast != null))
    {
      if (this.southwest == null) {
        return false;
      }
      double d1 = paramFPointBounds.northeast.x + paramFPointBounds.southwest.x - this.northeast.x - this.southwest.x;
      double d2 = this.northeast.x - this.southwest.x + paramFPointBounds.northeast.x - this.southwest.x;
      double d3 = paramFPointBounds.northeast.y + paramFPointBounds.southwest.y - this.northeast.y - this.southwest.y;
      double d4 = this.northeast.y - this.southwest.y + paramFPointBounds.northeast.y - paramFPointBounds.southwest.y;
      boolean bool1 = bool2;
      if (Math.abs(d1) < d2)
      {
        bool1 = bool2;
        if (Math.abs(d3) < d4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public boolean contains(FPoint paramFPoint)
  {
    return (containsy(paramFPoint.y)) && (containsx(paramFPoint.x));
  }
  
  public boolean contains(FPointBounds paramFPointBounds)
  {
    boolean bool2 = false;
    if (paramFPointBounds == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (contains(paramFPointBounds.southwest))
    {
      bool1 = bool2;
      if (contains(paramFPointBounds.northeast)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FPointBounds)) {
      return false;
    }
    paramObject = (FPointBounds)paramObject;
    return (this.southwest.equals(((FPointBounds)paramObject).southwest)) && (this.northeast.equals(((FPointBounds)paramObject).northeast));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean intersects(FPointBounds paramFPointBounds)
  {
    boolean bool = false;
    if (paramFPointBounds == null) {
      return false;
    }
    if ((intersect(paramFPointBounds)) || (paramFPointBounds.intersect(this))) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("southwest = (");
    localStringBuilder.append(this.southwest.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.southwest.y);
    localStringBuilder.append(") northeast = (");
    localStringBuilder.append(this.northeast.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.northeast.y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private float mEast = Float.NEGATIVE_INFINITY;
    private float mNorth = Float.NEGATIVE_INFINITY;
    private float mSouth = Float.POSITIVE_INFINITY;
    private float mWest = Float.POSITIVE_INFINITY;
    
    private boolean containsx(double paramDouble)
    {
      float f1 = this.mWest;
      float f2 = this.mEast;
      boolean bool = true;
      if (f1 <= f2) {
        return (this.mWest <= paramDouble) && (paramDouble <= this.mEast);
      }
      if (this.mWest > paramDouble)
      {
        if (paramDouble <= this.mEast) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    
    public FPointBounds build()
    {
      return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
    }
    
    public Builder include(FPoint paramFPoint)
    {
      this.mSouth = Math.min(this.mSouth, paramFPoint.y);
      this.mNorth = Math.max(this.mNorth, paramFPoint.y);
      this.mWest = Math.min(this.mWest, paramFPoint.x);
      this.mEast = Math.max(this.mEast, paramFPoint.x);
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\FPointBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */