package net.sqlcipher;

public class CustomCursorWindowAllocation
  implements CursorWindowAllocation
{
  private long growthPaddingSize = 0L;
  private long initialAllocationSize = 0L;
  private long maxAllocationSize = 0L;
  
  public CustomCursorWindowAllocation(long paramLong1, long paramLong2, long paramLong3)
  {
    this.initialAllocationSize = paramLong1;
    this.growthPaddingSize = paramLong2;
    this.maxAllocationSize = paramLong3;
  }
  
  public long getGrowthPaddingSize()
  {
    return this.growthPaddingSize;
  }
  
  public long getInitialAllocationSize()
  {
    return this.initialAllocationSize;
  }
  
  public long getMaxAllocationSize()
  {
    return this.maxAllocationSize;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\CustomCursorWindowAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */