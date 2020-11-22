package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor
  implements CrossProcessCursor, Cursor
{
  private static final String TAG = "Cursor";
  protected boolean mClosed = false;
  ContentObservable mContentObservable = new ContentObservable();
  protected ContentResolver mContentResolver;
  protected Long mCurrentRowID = null;
  DataSetObservable mDataSetObservable = new DataSetObservable();
  private Bundle mExtras = Bundle.EMPTY;
  private Uri mNotifyUri;
  protected int mPos = -1;
  protected int mRowIdColumnIndex = -1;
  private ContentObserver mSelfObserver;
  private final Object mSelfObserverLock = new Object();
  private boolean mSelfObserverRegistered;
  protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();
  
  public void abortUpdates()
  {
    synchronized (this.mUpdatedRows)
    {
      this.mUpdatedRows.clear();
      return;
    }
  }
  
  protected void checkPosition()
  {
    if ((-1 != this.mPos) && (getCount() != this.mPos)) {
      return;
    }
    throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
  }
  
  public void close()
  {
    this.mClosed = true;
    this.mContentObservable.unregisterAll();
    deactivateInternal();
  }
  
  public boolean commitUpdates()
  {
    return commitUpdates(null);
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    return false;
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    String str = getString(paramInt);
    if (str != null)
    {
      char[] arrayOfChar = paramCharArrayBuffer.data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= str.length())) {
        str.getChars(0, str.length(), arrayOfChar, 0);
      } else {
        paramCharArrayBuffer.data = str.toCharArray();
      }
      paramCharArrayBuffer.sizeCopied = str.length();
      return;
    }
    paramCharArrayBuffer.sizeCopied = 0;
  }
  
  public void deactivate()
  {
    deactivateInternal();
  }
  
  public void deactivateInternal()
  {
    if (this.mSelfObserver != null)
    {
      this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
      this.mSelfObserverRegistered = false;
    }
    this.mDataSetObservable.notifyInvalidated();
  }
  
  public boolean deleteRow()
  {
    return false;
  }
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    DatabaseUtils.cursorFillWindow(this, paramInt, paramCursorWindow);
  }
  
  protected void finalize()
  {
    if ((this.mSelfObserver != null) && (this.mSelfObserverRegistered == true)) {
      this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }
  
  public int getColumnCount()
  {
    return getColumnNames().length;
  }
  
  public int getColumnIndex(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requesting column name with table name -- ");
      localStringBuilder.append(paramString);
      Log.e("Cursor", localStringBuilder.toString(), (Throwable)localObject);
      localObject = paramString.substring(i + 1);
    }
    paramString = getColumnNames();
    int j = paramString.length;
    i = 0;
    while (i < j)
    {
      if (paramString[i].equalsIgnoreCase((String)localObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int i = getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("column '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  protected DataSetObservable getDataSetObservable()
  {
    return this.mDataSetObservable;
  }
  
  public abstract double getDouble(int paramInt);
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public abstract float getFloat(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return this.mNotifyUri;
  }
  
  public final int getPosition()
  {
    return this.mPos;
  }
  
  public abstract short getShort(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract int getType(int paramInt);
  
  protected Object getUpdatedField(int paramInt)
  {
    return ((Map)this.mUpdatedRows.get(this.mCurrentRowID)).get(getColumnNames()[paramInt]);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean hasUpdates()
  {
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (this.mUpdatedRows.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean isAfterLast()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.mPos == getCount();
  }
  
  public final boolean isBeforeFirst()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.mPos == -1;
  }
  
  public boolean isClosed()
  {
    return this.mClosed;
  }
  
  protected boolean isFieldUpdated(int paramInt)
  {
    if ((this.mRowIdColumnIndex != -1) && (this.mUpdatedRows.size() > 0))
    {
      Map localMap = (Map)this.mUpdatedRows.get(this.mCurrentRowID);
      if ((localMap != null) && (localMap.containsKey(getColumnNames()[paramInt]))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isFirst()
  {
    return (this.mPos == 0) && (getCount() != 0);
  }
  
  public final boolean isLast()
  {
    int i = getCount();
    return (this.mPos == i - 1) && (i != 0);
  }
  
  public abstract boolean isNull(int paramInt);
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(this.mPos + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public final boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public final boolean moveToNext()
  {
    return moveToPosition(this.mPos + 1);
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    int i = getCount();
    if (paramInt >= i)
    {
      this.mPos = i;
      return false;
    }
    if (paramInt < 0)
    {
      this.mPos = -1;
      return false;
    }
    if (paramInt == this.mPos) {
      return true;
    }
    boolean bool = onMove(this.mPos, paramInt);
    if (!bool)
    {
      this.mPos = -1;
      return bool;
    }
    this.mPos = paramInt;
    if (this.mRowIdColumnIndex != -1) {
      this.mCurrentRowID = Long.valueOf(getLong(this.mRowIdColumnIndex));
    }
    return bool;
  }
  
  public final boolean moveToPrevious()
  {
    return moveToPosition(this.mPos - 1);
  }
  
  protected void notifyDataSetChange()
  {
    this.mDataSetObservable.notifyChanged();
  }
  
  protected void onChange(boolean paramBoolean)
  {
    synchronized (this.mSelfObserverLock)
    {
      this.mContentObservable.dispatchChange(paramBoolean);
      if ((this.mNotifyUri != null) && (paramBoolean)) {
        this.mContentResolver.notifyChange(this.mNotifyUri, this.mSelfObserver);
      }
      return;
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.mContentObservable.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    if ((this.mSelfObserver != null) && (!this.mSelfObserverRegistered))
    {
      this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
      this.mSelfObserverRegistered = true;
    }
    this.mDataSetObservable.notifyChanged();
    return true;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = Bundle.EMPTY;
    }
    this.mExtras = localBundle;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    synchronized (this.mSelfObserverLock)
    {
      this.mNotifyUri = paramUri;
      this.mContentResolver = paramContentResolver;
      if (this.mSelfObserver != null) {
        this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
      }
      this.mSelfObserver = new SelfContentObserver(this);
      this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
      this.mSelfObserverRegistered = true;
      return;
    }
  }
  
  public boolean supportsUpdates()
  {
    return this.mRowIdColumnIndex != -1;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!this.mClosed) {
      this.mContentObservable.unregisterObserver(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public boolean update(int paramInt, Object paramObject)
  {
    if (!supportsUpdates()) {
      return false;
    }
    Long localLong = Long.valueOf(getLong(this.mRowIdColumnIndex));
    if (localLong != null) {
      synchronized (this.mUpdatedRows)
      {
        Map localMap = (Map)this.mUpdatedRows.get(localLong);
        Object localObject = localMap;
        if (localMap == null)
        {
          localObject = new HashMap();
          this.mUpdatedRows.put(localLong, localObject);
        }
        ((Map)localObject).put(getColumnNames()[paramInt], paramObject);
        return true;
      }
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("null rowid. mRowIdColumnIndex = ");
    ((StringBuilder)paramObject).append(this.mRowIdColumnIndex);
    throw new IllegalStateException(((StringBuilder)paramObject).toString());
  }
  
  public boolean updateBlob(int paramInt, byte[] paramArrayOfByte)
  {
    return update(paramInt, paramArrayOfByte);
  }
  
  public boolean updateDouble(int paramInt, double paramDouble)
  {
    return update(paramInt, Double.valueOf(paramDouble));
  }
  
  public boolean updateFloat(int paramInt, float paramFloat)
  {
    return update(paramInt, Float.valueOf(paramFloat));
  }
  
  public boolean updateInt(int paramInt1, int paramInt2)
  {
    return update(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public boolean updateLong(int paramInt, long paramLong)
  {
    return update(paramInt, Long.valueOf(paramLong));
  }
  
  public boolean updateShort(int paramInt, short paramShort)
  {
    return update(paramInt, Short.valueOf(paramShort));
  }
  
  public boolean updateString(int paramInt, String paramString)
  {
    return update(paramInt, paramString);
  }
  
  public boolean updateToNull(int paramInt)
  {
    return update(paramInt, null);
  }
  
  protected static class SelfContentObserver
    extends ContentObserver
  {
    WeakReference<AbstractCursor> mCursor;
    
    public SelfContentObserver(AbstractCursor paramAbstractCursor)
    {
      super();
      this.mCursor = new WeakReference(paramAbstractCursor);
    }
    
    public boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public void onChange(boolean paramBoolean)
    {
      AbstractCursor localAbstractCursor = (AbstractCursor)this.mCursor.get();
      if (localAbstractCursor != null) {
        localAbstractCursor.onChange(false);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\AbstractCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */