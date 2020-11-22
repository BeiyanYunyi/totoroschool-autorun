package net.sqlcipher.database;

import android.os.SystemClock;
import androidx.a.a.e;

public class SQLiteStatement
  extends SQLiteProgram
  implements e
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    super(paramSQLiteDatabase, paramString);
  }
  
  private final native long native_1x1_long();
  
  private final native String native_1x1_string();
  
  private final native void native_execute();
  
  public void execute()
  {
    if (this.mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        return;
      }
      finally
      {
        releaseReference();
        this.mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("database ");
    localStringBuilder.append(this.mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long executeInsert()
  {
    if (this.mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        long l;
        if (this.mDatabase.lastChangeCount() > 0) {
          l = this.mDatabase.lastInsertRow();
        } else {
          l = -1L;
        }
        return l;
      }
      finally
      {
        releaseReference();
        this.mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("database ");
    localStringBuilder.append(this.mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int executeUpdateDelete()
  {
    if (this.mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        int i = this.mDatabase.lastChangeCount();
        return i;
      }
      finally
      {
        releaseReference();
        this.mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("database ");
    localStringBuilder.append(this.mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long simpleQueryForLong()
  {
    if (this.mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      acquireReference();
      try
      {
        long l = native_1x1_long();
        return l;
      }
      finally
      {
        releaseReference();
        this.mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("database ");
    localStringBuilder.append(this.mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String simpleQueryForString()
  {
    if (this.mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      acquireReference();
      try
      {
        String str = native_1x1_string();
        return str;
      }
      finally
      {
        releaseReference();
        this.mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("database ");
    localStringBuilder.append(this.mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */