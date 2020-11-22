package net.sqlcipher.database;

public abstract class SQLiteClosable
{
  private Object mLock = new Object();
  private int mReferenceCount = 1;
  
  private String getObjInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" (");
    if ((this instanceof SQLiteDatabase))
    {
      localStringBuilder.append("database = ");
      localStringBuilder.append(((SQLiteDatabase)this).getPath());
    }
    else if (((this instanceof SQLiteProgram)) || ((this instanceof SQLiteStatement)) || ((this instanceof SQLiteQuery)))
    {
      localStringBuilder.append("mSql = ");
      localStringBuilder.append(((SQLiteProgram)this).mSql);
    }
    localStringBuilder.append(") ");
    return localStringBuilder.toString();
  }
  
  public void acquireReference()
  {
    synchronized (this.mLock)
    {
      if (this.mReferenceCount > 0)
      {
        this.mReferenceCount += 1;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attempt to re-open an already-closed object: ");
      localStringBuilder.append(getObjInfo());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  protected abstract void onAllReferencesReleased();
  
  protected void onAllReferencesReleasedFromContainer() {}
  
  public void releaseReference()
  {
    synchronized (this.mLock)
    {
      this.mReferenceCount -= 1;
      if (this.mReferenceCount == 0) {
        onAllReferencesReleased();
      }
      return;
    }
  }
  
  public void releaseReferenceFromContainer()
  {
    synchronized (this.mLock)
    {
      this.mReferenceCount -= 1;
      if (this.mReferenceCount == 0) {
        onAllReferencesReleasedFromContainer();
      }
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteClosable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */