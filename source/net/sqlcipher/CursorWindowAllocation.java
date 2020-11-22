package net.sqlcipher;

public abstract interface CursorWindowAllocation
{
  public abstract long getGrowthPaddingSize();
  
  public abstract long getInitialAllocationSize();
  
  public abstract long getMaxAllocationSize();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\CursorWindowAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */