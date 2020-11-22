package net.sqlcipher;

public class DefaultCursorWindowAllocation
  implements CursorWindowAllocation
{
  private long WindowAllocationUnbounded = 0L;
  private long initialAllocationSize = 1048576L;
  
  public long getGrowthPaddingSize()
  {
    return this.initialAllocationSize;
  }
  
  public long getInitialAllocationSize()
  {
    return this.initialAllocationSize;
  }
  
  public long getMaxAllocationSize()
  {
    return this.WindowAllocationUnbounded;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\DefaultCursorWindowAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */