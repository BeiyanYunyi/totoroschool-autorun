package net.sqlcipher.database;

import android.util.Log;

class SQLiteCompiledSql
{
  private static final String TAG = "SQLiteCompiledSql";
  SQLiteDatabase mDatabase;
  private boolean mInUse = false;
  private String mSqlStmt = null;
  private Throwable mStackTrace = null;
  long nHandle = 0L;
  long nStatement = 0L;
  
  SQLiteCompiledSql(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (paramSQLiteDatabase.isOpen())
    {
      this.mDatabase = paramSQLiteDatabase;
      this.mSqlStmt = paramString;
      this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      this.nHandle = paramSQLiteDatabase.mNativeHandle;
      compile(paramString, true);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("database ");
    paramString.append(paramSQLiteDatabase.getPath());
    paramString.append(" already closed");
    throw new IllegalStateException(paramString.toString());
  }
  
  private void compile(String paramString, boolean paramBoolean)
  {
    if (this.mDatabase.isOpen())
    {
      if (paramBoolean)
      {
        this.mDatabase.lock();
        try
        {
          native_compile(paramString);
          return;
        }
        finally
        {
          this.mDatabase.unlock();
        }
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("database ");
    paramString.append(this.mDatabase.getPath());
    paramString.append(" already closed");
    throw new IllegalStateException(paramString.toString());
  }
  
  private final native void native_compile(String paramString);
  
  private final native void native_finalize();
  
  boolean acquire()
  {
    try
    {
      boolean bool = this.mInUse;
      if (bool) {
        return false;
      }
      this.mInUse = true;
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Acquired DbObj (id#");
        localStringBuilder.append(this.nStatement);
        localStringBuilder.append(") from DB cache");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      return true;
    }
    finally {}
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      long l = this.nStatement;
      if (l == 0L) {
        return;
      }
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("** warning ** Finalized DbObj (id#");
        localStringBuilder.append(this.nStatement);
        localStringBuilder.append(")");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      int j = this.mSqlStmt.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: ");
      String str = this.mSqlStmt;
      int i = j;
      if (j > 100) {
        i = 100;
      }
      localStringBuilder.append(str.substring(0, i));
      Log.w("SQLiteCompiledSql", localStringBuilder.toString(), this.mStackTrace);
      releaseSqlStatement();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  void release()
  {
    try
    {
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Released DbObj (id#");
        localStringBuilder.append(this.nStatement);
        localStringBuilder.append(") back to DB cache");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      this.mInUse = false;
      return;
    }
    finally {}
  }
  
  void releaseSqlStatement()
  {
    if (this.nStatement != 0L)
    {
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closed and deallocated DbObj (id#");
        localStringBuilder.append(this.nStatement);
        localStringBuilder.append(")");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      try
      {
        this.mDatabase.lock();
        native_finalize();
        this.nStatement = 0L;
        return;
      }
      finally
      {
        this.mDatabase.unlock();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteCompiledSql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */