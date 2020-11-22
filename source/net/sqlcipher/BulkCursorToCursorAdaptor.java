package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private static final String TAG = "BulkCursor";
  private IBulkCursor mBulkCursor;
  private String[] mColumns;
  private int mCount;
  private AbstractCursor.SelfContentObserver mObserverBridge;
  private boolean mWantsAllOnMoveCalls;
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void close()
  {
    super.close();
    try
    {
      this.mBulkCursor.close();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.w("BulkCursor", "Remote process exception when closing");
    this.mWindow = null;
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    if (!supportsUpdates())
    {
      Log.e("BulkCursor", "commitUpdates not supported on this cursor, did you include the _id column?");
      return false;
    }
    HashMap localHashMap = this.mUpdatedRows;
    if (paramMap != null) {}
    for (;;)
    {
      try
      {
        this.mUpdatedRows.putAll(paramMap);
        if (this.mUpdatedRows.size() <= 0) {
          return false;
        }
      }
      finally
      {
        boolean bool;
        continue;
      }
      try
      {
        bool = this.mBulkCursor.updateRows(this.mUpdatedRows);
        if (bool == true)
        {
          this.mUpdatedRows.clear();
          onChange(true);
        }
        return bool;
      }
      catch (RemoteException paramMap) {}
    }
    Log.e("BulkCursor", "Unable to commit updates because the remote process is dead");
    return false;
    throw paramMap;
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    try
    {
      this.mBulkCursor.deactivate();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.w("BulkCursor", "Remote process exception when deactivating");
    this.mWindow = null;
  }
  
  public boolean deleteRow()
  {
    try
    {
      boolean bool = this.mBulkCursor.deleteRow(this.mPos);
      if (bool)
      {
        this.mWindow = null;
        this.mCount = this.mBulkCursor.count();
        if (this.mPos < this.mCount)
        {
          int i = this.mPos;
          this.mPos = -1;
          moveToPosition(i);
        }
        else
        {
          this.mPos = this.mCount;
        }
        onChange(true);
      }
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
    return false;
  }
  
  public String[] getColumnNames()
  {
    if (this.mColumns == null) {}
    try
    {
      this.mColumns = this.mBulkCursor.getColumnNames();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.e("BulkCursor", "Unable to fetch column names because the remote process is dead");
    return null;
    return this.mColumns;
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = this.mBulkCursor.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public IContentObserver getObserver()
  {
    try
    {
      if (this.mObserverBridge == null) {
        this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.mWindow != null)
      {
        if ((paramInt2 >= this.mWindow.getStartPosition()) && (paramInt2 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()))
        {
          if (this.mWantsAllOnMoveCalls) {
            this.mBulkCursor.onMove(paramInt2);
          }
        }
        else {
          this.mWindow = this.mBulkCursor.getWindow(paramInt2);
        }
      }
      else {
        this.mWindow = this.mBulkCursor.getWindow(paramInt2);
      }
      return this.mWindow != null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.e("BulkCursor", "Unable to get window because the remote process is dead");
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    try
    {
      int i = this.mCount;
      this.mCount = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));
      if (this.mCount != -1)
      {
        this.mPos = -1;
        this.mWindow = null;
        super.requery();
        return true;
      }
      deactivate();
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to requery because the remote process exception ");
      localStringBuilder.append(localException.getMessage());
      Log.e("BulkCursor", localStringBuilder.toString());
      deactivate();
    }
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    try
    {
      paramBundle = this.mBulkCursor.respond(paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", paramBundle);
    }
    return Bundle.EMPTY;
  }
  
  public void set(IBulkCursor paramIBulkCursor)
  {
    this.mBulkCursor = paramIBulkCursor;
    try
    {
      this.mCount = this.mBulkCursor.count();
      this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
      this.mColumns = this.mBulkCursor.getColumnNames();
      this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
      return;
    }
    catch (RemoteException paramIBulkCursor)
    {
      for (;;) {}
    }
    Log.e("BulkCursor", "Setup failed because the remote process is dead");
  }
  
  public void set(IBulkCursor paramIBulkCursor, int paramInt1, int paramInt2)
  {
    this.mBulkCursor = paramIBulkCursor;
    this.mColumns = null;
    this.mCount = paramInt1;
    this.mRowIdColumnIndex = paramInt2;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\BulkCursorToCursorAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */