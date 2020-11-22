package com.bumptech.glide.load.b;

public enum b
{
  private final boolean cacheResult;
  private final boolean cacheSource;
  
  private b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cacheSource = paramBoolean1;
    this.cacheResult = paramBoolean2;
  }
  
  public boolean cacheResult()
  {
    return this.cacheResult;
  }
  
  public boolean cacheSource()
  {
    return this.cacheSource;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */