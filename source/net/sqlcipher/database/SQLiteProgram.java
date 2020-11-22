package net.sqlcipher.database;

import android.util.Log;
import androidx.a.a.c;
import java.util.Map;

public abstract class SQLiteProgram
  extends SQLiteClosable
  implements c
{
  private static final String TAG = "SQLiteProgram";
  boolean mClosed = false;
  private SQLiteCompiledSql mCompiledSql;
  @Deprecated
  protected SQLiteDatabase mDatabase;
  final String mSql;
  @Deprecated
  protected long nHandle = 0L;
  @Deprecated
  protected long nStatement = 0L;
  
  SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    paramSQLiteDatabase.acquireReference();
    paramSQLiteDatabase.addSQLiteClosable(this);
    this.nHandle = paramSQLiteDatabase.mNativeHandle;
    String str;
    if (this.mSql.length() >= 6) {
      str = this.mSql.substring(0, 6);
    } else {
      str = this.mSql;
    }
    if ((!str.equalsIgnoreCase("INSERT")) && (!str.equalsIgnoreCase("UPDATE")) && (!str.equalsIgnoreCase("REPLAC")) && (!str.equalsIgnoreCase("DELETE")) && (!str.equalsIgnoreCase("SELECT")))
    {
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.nStatement = this.mCompiledSql.nStatement;
      return;
    }
    this.mCompiledSql = paramSQLiteDatabase.getCompiledStatementForSql(paramString);
    if (this.mCompiledSql == null)
    {
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.mCompiledSql.acquire();
      paramSQLiteDatabase.addToCompiledQueries(paramString, this.mCompiledSql);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = new StringBuilder();
        paramSQLiteDatabase.append("Created DbObj (id#");
        paramSQLiteDatabase.append(this.mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") for sql: ");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    else if (!this.mCompiledSql.acquire())
    {
      long l = this.mCompiledSql.nStatement;
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = new StringBuilder();
        paramSQLiteDatabase.append("** possible bug ** Created NEW DbObj (id#");
        paramSQLiteDatabase.append(this.mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") because the previously created DbObj (id#");
        paramSQLiteDatabase.append(l);
        paramSQLiteDatabase.append(") was not released for sql:");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    this.nStatement = this.mCompiledSql.nStatement;
  }
  
  private final native void native_clear_bindings();
  
  private void releaseCompiledSqlIfNotInCache()
  {
    if (this.mCompiledSql == null) {
      return;
    }
    synchronized (this.mDatabase.mCompiledQueries)
    {
      if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql))
      {
        this.mCompiledSql.releaseSqlStatement();
        this.mCompiledSql = null;
        this.nStatement = 0L;
      }
      else
      {
        this.mCompiledSql.release();
      }
      return;
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!this.mClosed)
      {
        if (this.mDatabase.isOpen())
        {
          acquireReference();
          try
          {
            native_bind_blob(paramInt, paramArrayOfByte);
            return;
          }
          finally
          {
            releaseReference();
          }
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("database ");
        paramArrayOfByte.append(this.mDatabase.getPath());
        paramArrayOfByte.append(" already closed");
        throw new IllegalStateException(paramArrayOfByte.toString());
      }
      throw new IllegalStateException("program already closed");
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("the bind value at index ");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" is null");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    if (!this.mClosed)
    {
      if (this.mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_double(paramInt, paramDouble);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("database ");
      localStringBuilder.append(this.mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    if (!this.mClosed)
    {
      if (this.mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_long(paramInt, paramLong);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("database ");
      localStringBuilder.append(this.mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindNull(int paramInt)
  {
    if (!this.mClosed)
    {
      if (this.mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_null(paramInt);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("database ");
      localStringBuilder.append(this.mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindString(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (!this.mClosed)
      {
        if (this.mDatabase.isOpen())
        {
          acquireReference();
          try
          {
            native_bind_string(paramInt, paramString);
            return;
          }
          finally
          {
            releaseReference();
          }
        }
        paramString = new StringBuilder();
        paramString.append("database ");
        paramString.append(this.mDatabase.getPath());
        paramString.append(" already closed");
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException("program already closed");
    }
    paramString = new StringBuilder();
    paramString.append("the bind value at index ");
    paramString.append(paramInt);
    paramString.append(" is null");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public void clearBindings()
  {
    if (!this.mClosed)
    {
      if (this.mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_clear_bindings();
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("database ");
      localStringBuilder.append(this.mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void close()
  {
    if (this.mClosed) {
      return;
    }
    if (!this.mDatabase.isOpen()) {
      return;
    }
    this.mDatabase.lock();
    try
    {
      releaseReference();
      this.mDatabase.unlock();
      this.mClosed = true;
      return;
    }
    finally
    {
      this.mDatabase.unlock();
    }
  }
  
  @Deprecated
  protected void compile(String paramString, boolean paramBoolean) {}
  
  String getSqlString()
  {
    return this.mSql;
  }
  
  public final long getUniqueId()
  {
    return this.nStatement;
  }
  
  protected final native void native_bind_blob(int paramInt, byte[] paramArrayOfByte);
  
  protected final native void native_bind_double(int paramInt, double paramDouble);
  
  protected final native void native_bind_long(int paramInt, long paramLong);
  
  protected final native void native_bind_null(int paramInt);
  
  protected final native void native_bind_string(int paramInt, String paramString);
  
  @Deprecated
  protected final native void native_compile(String paramString);
  
  @Deprecated
  protected final native void native_finalize();
  
  protected void onAllReferencesReleased()
  {
    releaseCompiledSqlIfNotInCache();
    this.mDatabase.releaseReference();
    this.mDatabase.removeSQLiteClosable(this);
  }
  
  protected void onAllReferencesReleasedFromContainer()
  {
    releaseCompiledSqlIfNotInCache();
    this.mDatabase.releaseReference();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */