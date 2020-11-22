package com.autonavi.base.ae.gmap.maploader;

import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public class ProcessingTile
{
  private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool(30);
  public long mCreateTime = 0L;
  public String mKeyName;
  
  public ProcessingTile(String paramString)
  {
    setParams(paramString);
  }
  
  public static ProcessingTile obtain(String paramString)
  {
    ProcessingTile localProcessingTile = (ProcessingTile)M_POOL.acquire();
    if (localProcessingTile != null)
    {
      localProcessingTile.setParams(paramString);
      return localProcessingTile;
    }
    return new ProcessingTile(paramString);
  }
  
  private void setParams(String paramString)
  {
    this.mKeyName = paramString;
    this.mCreateTime = (System.currentTimeMillis() / 1000L);
  }
  
  public void recycle()
  {
    this.mKeyName = null;
    this.mCreateTime = 0L;
    M_POOL.release(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\maploader\ProcessingTile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */