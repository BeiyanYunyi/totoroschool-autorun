package com.google.zxing;

public final class Dimension
{
  private final int height;
  private final int width;
  
  public Dimension(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      this.width = paramInt1;
      this.height = paramInt2;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Dimension;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (Dimension)paramObject;
      bool1 = bool2;
      if (this.width == ((Dimension)paramObject).width)
      {
        bool1 = bool2;
        if (this.height == ((Dimension)paramObject).height) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return this.width * 32713 + this.height;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.width);
    localStringBuilder.append("x");
    localStringBuilder.append(this.height);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */