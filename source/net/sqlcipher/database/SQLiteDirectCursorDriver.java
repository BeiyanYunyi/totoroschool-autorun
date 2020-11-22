package net.sqlcipher.database;

public class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private net.sqlcipher.Cursor mCursor;
  private SQLiteDatabase mDatabase;
  private String mEditTable;
  private SQLiteQuery mQuery;
  private String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mEditTable = paramString2;
    this.mSql = paramString1;
  }
  
  public void cursorClosed()
  {
    this.mCursor = null;
  }
  
  public void cursorDeactivated() {}
  
  public void cursorRequeried(android.database.Cursor paramCursor) {}
  
  public net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject)
  {
    SQLiteQuery localSQLiteQuery2 = new SQLiteQuery(this.mDatabase, this.mSql, 0, paramArrayOfObject);
    SQLiteQuery localSQLiteQuery1 = localSQLiteQuery2;
    try
    {
      localSQLiteQuery2.bindArguments(paramArrayOfObject);
      if (paramCursorFactory == null)
      {
        localSQLiteQuery1 = localSQLiteQuery2;
        this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, localSQLiteQuery2);
      }
      else
      {
        localSQLiteQuery1 = localSQLiteQuery2;
        this.mCursor = paramCursorFactory.newCursor(this.mDatabase, this, this.mEditTable, localSQLiteQuery2);
      }
      localSQLiteQuery1 = localSQLiteQuery2;
      this.mQuery = localSQLiteQuery2;
      localSQLiteQuery1 = null;
      paramCursorFactory = this.mCursor;
      return paramCursorFactory;
    }
    finally
    {
      if (localSQLiteQuery1 != null) {
        localSQLiteQuery1.close();
      }
    }
  }
  
  public net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    Object localObject1 = this.mDatabase;
    Object localObject2 = this.mSql;
    int j = 0;
    localObject2 = new SQLiteQuery((SQLiteDatabase)localObject1, (String)localObject2, 0, paramArrayOfString);
    int i;
    if (paramArrayOfString == null) {
      i = 0;
    } else {
      localObject1 = localObject2;
    }
    try
    {
      i = paramArrayOfString.length;
      while (j < i)
      {
        int k = j + 1;
        localObject1 = localObject2;
        ((SQLiteQuery)localObject2).bindString(k, paramArrayOfString[j]);
        j = k;
      }
      if (paramCursorFactory == null)
      {
        localObject1 = localObject2;
        this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, (SQLiteQuery)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        this.mCursor = paramCursorFactory.newCursor(this.mDatabase, this, this.mEditTable, (SQLiteQuery)localObject2);
      }
      localObject1 = localObject2;
      this.mQuery = ((SQLiteQuery)localObject2);
      localObject1 = null;
      paramCursorFactory = this.mCursor;
      return paramCursorFactory;
    }
    finally
    {
      if (localObject1 != null) {
        ((SQLiteQuery)localObject1).close();
      }
    }
  }
  
  public void setBindArguments(String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int j;
    for (int i = 0; i < k; i = j)
    {
      SQLiteQuery localSQLiteQuery = this.mQuery;
      j = i + 1;
      localSQLiteQuery.bindString(j, paramArrayOfString[i]);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteDirectCursorDriver: ");
    localStringBuilder.append(this.mSql);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteDirectCursorDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */