package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.SQLException;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "Cursor";
  private boolean fillWindowForwardOnly;
  private Map<String, Integer> mColumnNameMap;
  private String[] mColumns;
  private int mCount = -1;
  private int mCursorState;
  private int mCursorWindowCapacity;
  private SQLiteDatabase mDatabase;
  private SQLiteCursorDriver mDriver;
  private String mEditTable;
  private int mInitialRead;
  private ReentrantLock mLock;
  private int mMaxRead;
  protected MainThreadNotificationHandler mNotificationHandler;
  private boolean mPendingData;
  private SQLiteQuery mQuery;
  private Throwable mStackTrace;
  
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    int i = 0;
    this.mCursorWindowCapacity = 0;
    this.fillWindowForwardOnly = false;
    this.mMaxRead = Integer.MAX_VALUE;
    this.mInitialRead = Integer.MAX_VALUE;
    this.mCursorState = 0;
    this.mLock = null;
    this.mPendingData = false;
    this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    this.mDatabase = paramSQLiteDatabase;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    try
    {
      paramSQLiteDatabase.lock();
      int j = this.mQuery.columnCountLocked();
      this.mColumns = new String[j];
      while (i < j)
      {
        paramSQLiteCursorDriver = this.mQuery.columnNameLocked(i);
        this.mColumns[i] = paramSQLiteCursorDriver;
        if ("_id".equals(paramSQLiteCursorDriver)) {
          this.mRowIdColumnIndex = i;
        }
        i += 1;
      }
      return;
    }
    finally
    {
      paramSQLiteDatabase.unlock();
    }
  }
  
  private void deactivateCommon()
  {
    this.mCursorState = 0;
    if (this.mWindow != null)
    {
      this.mWindow.close();
      this.mWindow = null;
    }
  }
  
  private void fillWindow(int paramInt)
  {
    if (this.mWindow == null)
    {
      this.mWindow = new net.sqlcipher.CursorWindow(true);
    }
    else
    {
      this.mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      this.mWindow.clear();
      queryThreadUnlock();
      int i;
      if (this.fillWindowForwardOnly) {
        i = paramInt;
      } else if (this.mCount == -1) {
        i = cursorPickFillWindowStartPosition(paramInt, 0);
      } else {
        i = cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      }
      this.mWindow.setStartPosition(i);
      this.mWindow.setRequiredPosition(paramInt);
      this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
      if (this.mCursorWindowCapacity == 0) {
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
      }
      if (this.mCount == -1)
      {
        this.mCount = (i + this.mInitialRead);
        new Thread(new QueryThread(this.mCursorState), "query thread").start();
      }
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  private void queryThreadLock()
  {
    if (this.mLock != null) {
      this.mLock.lock();
    }
  }
  
  private void queryThreadUnlock()
  {
    if (this.mLock != null) {
      this.mLock.unlock();
    }
  }
  
  public void close()
  {
    super.close();
    deactivateCommon();
    this.mQuery.close();
    this.mDriver.cursorClosed();
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    if (!supportsUpdates()) {
      return false;
    }
    HashMap localHashMap = this.mUpdatedRows;
    if (paramMap != null) {}
    for (;;)
    {
      try
      {
        this.mUpdatedRows.putAll(paramMap);
        if (this.mUpdatedRows.size() == 0) {
          return true;
        }
        this.mDatabase.beginTransaction();
      }
      finally
      {
        Iterator localIterator;
        int i;
        continue;
        i += 1;
        continue;
      }
      try
      {
        paramMap = new StringBuilder(128);
        localIterator = this.mUpdatedRows.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Object localObject1 = (Map)((Map.Entry)localObject2).getValue();
          localObject2 = (Long)((Map.Entry)localObject2).getKey();
          if ((localObject2 != null) && (localObject1 != null))
          {
            if (((Map)localObject1).size() != 0)
            {
              long l = ((Long)localObject2).longValue();
              localObject2 = ((Map)localObject1).entrySet().iterator();
              paramMap.setLength(0);
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("UPDATE ");
              ((StringBuilder)localObject3).append(this.mEditTable);
              ((StringBuilder)localObject3).append(" SET ");
              paramMap.append(((StringBuilder)localObject3).toString());
              localObject1 = new Object[((Map)localObject1).size()];
              i = 0;
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject2).next();
                paramMap.append((String)((Map.Entry)localObject3).getKey());
                paramMap.append("=?");
                localObject1[i] = ((Map.Entry)localObject3).getValue();
                if (!((Iterator)localObject2).hasNext()) {
                  continue;
                }
                paramMap.append(", ");
                continue;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(" WHERE ");
              ((StringBuilder)localObject2).append(this.mColumns[this.mRowIdColumnIndex]);
              ((StringBuilder)localObject2).append('=');
              ((StringBuilder)localObject2).append(l);
              paramMap.append(((StringBuilder)localObject2).toString());
              paramMap.append(';');
              this.mDatabase.execSQL(paramMap.toString(), (Object[])localObject1);
              this.mDatabase.rowUpdated(this.mEditTable, l);
            }
          }
          else
          {
            paramMap = new StringBuilder();
            paramMap.append("null rowId or values found! rowId = ");
            paramMap.append(localObject2);
            paramMap.append(", values = ");
            paramMap.append(localObject1);
            throw new IllegalStateException(paramMap.toString());
          }
        }
        else
        {
          this.mDatabase.setTransactionSuccessful();
          this.mDatabase.endTransaction();
          this.mUpdatedRows.clear();
          onChange(true);
          return true;
        }
      }
      finally
      {
        this.mDatabase.endTransaction();
      }
    }
    throw paramMap;
  }
  
  public int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public void deactivate()
  {
    super.deactivate();
    deactivateCommon();
    this.mDriver.cursorDeactivated();
  }
  
  public boolean deleteRow()
  {
    checkPosition();
    if (this.mRowIdColumnIndex != -1)
    {
      if (this.mCurrentRowID == null) {
        return false;
      }
      this.mDatabase.lock();
    }
    try
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String str = this.mEditTable;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mColumns[this.mRowIdColumnIndex]);
        localStringBuilder.append("=?");
        localSQLiteDatabase.delete(str, localStringBuilder.toString(), new String[] { this.mCurrentRowID.toString() });
        i = 1;
      }
      finally
      {
        break label145;
      }
    }
    catch (SQLException localSQLException)
    {
      int i;
      int j;
      for (;;) {}
    }
    i = 0;
    j = this.mPos;
    requery();
    moveToPosition(j);
    this.mDatabase.unlock();
    if (i != 0)
    {
      onChange(true);
      return true;
    }
    return false;
    label145:
    this.mDatabase.unlock();
    throw ((Throwable)localObject);
    return false;
  }
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    if (this.mWindow == null)
    {
      this.mWindow = new net.sqlcipher.CursorWindow(true);
    }
    else
    {
      this.mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      this.mWindow.clear();
      queryThreadUnlock();
      int i;
      if (this.fillWindowForwardOnly) {
        i = paramInt;
      } else if (this.mCount == -1) {
        i = cursorPickFillWindowStartPosition(paramInt, 0);
      } else {
        i = cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      }
      this.mWindow.setStartPosition(i);
      this.mWindow.setRequiredPosition(paramInt);
      this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
      if (this.mCursorWindowCapacity == 0) {
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
      }
      if (this.mCount == -1)
      {
        this.mCount = (i + this.mInitialRead);
        new Thread(new QueryThread(this.mCursorState), "query thread").start();
      }
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mWindow != null)
      {
        this.mQuery.mSql.length();
        close();
        SQLiteDebug.notifyActiveCursorFinalized();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    if (this.mColumnNameMap == null)
    {
      String[] arrayOfString = this.mColumns;
      int j = arrayOfString.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      int i = 0;
      while (i < j)
      {
        localHashMap.put(arrayOfString[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = localHashMap;
    }
    if (paramString.lastIndexOf('.') != -1) {
      new Exception();
    }
    paramString = (Integer)this.mColumnNameMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount == -1) {
      fillWindow(0);
    }
    return this.mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerDataSetObserver(paramDataSetObserver);
    if (((Integer.MAX_VALUE != this.mMaxRead) || (Integer.MAX_VALUE != this.mInitialRead)) && (this.mNotificationHandler == null))
    {
      queryThreadLock();
      try
      {
        this.mNotificationHandler = new MainThreadNotificationHandler(this);
        if (this.mPendingData)
        {
          notifyDataSetChange();
          this.mPendingData = false;
        }
        return;
      }
      finally
      {
        queryThreadUnlock();
      }
    }
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 432	net/sqlcipher/database/SQLiteCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 76	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 89	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   16: aload_0
    //   17: getfield 124	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   20: ifnull +10 -> 30
    //   23: aload_0
    //   24: getfield 124	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   27: invokevirtual 158	net/sqlcipher/CursorWindow:clear	()V
    //   30: aload_0
    //   31: iconst_m1
    //   32: putfield 357	net/sqlcipher/database/SQLiteCursor:mPos	I
    //   35: aload_0
    //   36: getfield 78	net/sqlcipher/database/SQLiteCursor:mDriver	Lnet/sqlcipher/database/SQLiteCursorDriver;
    //   39: aload_0
    //   40: invokeinterface 436 2 0
    //   45: aload_0
    //   46: iconst_m1
    //   47: putfield 50	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 61	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   55: iconst_1
    //   56: iadd
    //   57: putfield 61	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   60: aload_0
    //   61: invokespecial 155	net/sqlcipher/database/SQLiteCursor:queryThreadLock	()V
    //   64: aload_0
    //   65: getfield 84	net/sqlcipher/database/SQLiteCursor:mQuery	Lnet/sqlcipher/database/SQLiteQuery;
    //   68: invokevirtual 438	net/sqlcipher/database/SQLiteQuery:requery	()V
    //   71: aload_0
    //   72: invokespecial 161	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   75: aload_0
    //   76: getfield 76	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   79: invokevirtual 115	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   82: aload_0
    //   83: invokespecial 439	net/sqlcipher/AbstractWindowedCursor:requery	()Z
    //   86: ireturn
    //   87: astore_1
    //   88: aload_0
    //   89: invokespecial 161	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 76	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   99: invokevirtual 115	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	SQLiteCursor
    //   87	6	1	localObject1	Object
    //   94	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   64	71	87	finally
    //   16	30	94	finally
    //   30	64	94	finally
    //   71	75	94	finally
    //   88	94	94	finally
  }
  
  public void setFillWindowForwardOnly(boolean paramBoolean)
  {
    this.fillWindowForwardOnly = paramBoolean;
  }
  
  public void setLoadStyle(int paramInt1, int paramInt2)
  {
    this.mMaxRead = paramInt2;
    this.mInitialRead = paramInt1;
    this.mLock = new ReentrantLock(true);
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }
  
  public void setWindow(net.sqlcipher.CursorWindow paramCursorWindow)
  {
    if (this.mWindow != null)
    {
      this.mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      this.mWindow.close();
      queryThreadUnlock();
      this.mCount = -1;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  public boolean supportsUpdates()
  {
    return TextUtils.isEmpty(this.mEditTable) ^ true;
  }
  
  protected static class MainThreadNotificationHandler
    extends Handler
  {
    private final WeakReference<SQLiteCursor> wrappedCursor;
    
    MainThreadNotificationHandler(SQLiteCursor paramSQLiteCursor)
    {
      this.wrappedCursor = new WeakReference(paramSQLiteCursor);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (SQLiteCursor)this.wrappedCursor.get();
      if (paramMessage != null) {
        paramMessage.notifyDataSetChange();
      }
    }
  }
  
  private final class QueryThread
    implements Runnable
  {
    private final int mThreadState;
    
    QueryThread(int paramInt)
    {
      this.mThreadState = paramInt;
    }
    
    private void sendMessage()
    {
      if (SQLiteCursor.this.mNotificationHandler != null)
      {
        SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
        SQLiteCursor.access$002(SQLiteCursor.this, false);
        return;
      }
      SQLiteCursor.access$002(SQLiteCursor.this, true);
    }
    
    public void run()
    {
      net.sqlcipher.CursorWindow localCursorWindow = SQLiteCursor.this.mWindow;
      Process.setThreadPriority(Process.myTid(), 10);
      for (;;)
      {
        if (SQLiteCursor.this.mLock == null) {
          SQLiteCursor.access$202(SQLiteCursor.this, new ReentrantLock(true));
        }
        SQLiteCursor.this.mLock.lock();
        if (SQLiteCursor.this.mCursorState != this.mThreadState)
        {
          SQLiteCursor.this.mLock.unlock();
          return;
        }
        try
        {
          try
          {
            int i = SQLiteCursor.this.mQuery.fillWindow(localCursorWindow, SQLiteCursor.this.mMaxRead, SQLiteCursor.this.mCount);
            if (i != 0)
            {
              if (i == -1)
              {
                SQLiteCursor.access$502(SQLiteCursor.this, SQLiteCursor.this.mCount + SQLiteCursor.this.mMaxRead);
                sendMessage();
                SQLiteCursor.this.mLock.unlock();
                continue;
              }
              SQLiteCursor.access$502(SQLiteCursor.this, i);
              sendMessage();
            }
          }
          finally
          {
            SQLiteCursor.this.mLock.unlock();
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
      SQLiteCursor.this.mLock.unlock();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */