package com.autonavi.amap.mapcore;

public class AbstractNativeInstance
{
  protected long nativeInstance = 0L;
  
  public void createNativeInstace() {}
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public final long getNativeInstance()
  {
    return this.nativeInstance;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\AbstractNativeInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */