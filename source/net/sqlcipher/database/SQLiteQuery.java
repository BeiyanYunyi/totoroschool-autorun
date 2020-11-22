package net.sqlcipher.database;

import net.sqlcipher.CursorWindow;

public class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "Cursor";
  private String[] mBindArgs;
  private Object[] mObjectBindArgs;
  private int mOffsetIndex;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString);
    this.mOffsetIndex = paramInt;
    this.mObjectBindArgs = paramArrayOfObject;
    if (this.mObjectBindArgs != null) {
      paramInt = this.mObjectBindArgs.length;
    } else {
      paramInt = 0;
    }
    this.mBindArgs = new String[paramInt];
  }
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, String[] paramArrayOfString)
  {
    super(paramSQLiteDatabase, paramString);
    this.mOffsetIndex = paramInt;
    this.mBindArgs = paramArrayOfString;
  }
  
  private final native int native_column_count();
  
  private final native String native_column_name(int paramInt);
  
  private final native int native_fill_window(CursorWindow paramCursorWindow, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public void bindArguments(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        Object localObject = paramArrayOfObject[i];
        if (localObject == null)
        {
          bindNull(i + 1);
        }
        else if ((localObject instanceof Double))
        {
          bindDouble(i + 1, ((Double)localObject).doubleValue());
        }
        else if ((localObject instanceof Float))
        {
          bindDouble(i + 1, Double.valueOf(((Number)localObject).floatValue()).doubleValue());
        }
        else if ((localObject instanceof Long))
        {
          bindLong(i + 1, ((Long)localObject).longValue());
        }
        else if ((localObject instanceof Integer))
        {
          bindLong(i + 1, Long.valueOf(((Number)localObject).intValue()).longValue());
        }
        else if ((localObject instanceof Boolean))
        {
          long l;
          if (((Boolean)localObject).booleanValue()) {
            l = 1L;
          } else {
            l = 0L;
          }
          bindLong(i + 1, l);
        }
        else if ((localObject instanceof byte[]))
        {
          bindBlob(i + 1, (byte[])localObject);
        }
        else
        {
          bindString(i + 1, localObject.toString());
        }
        i += 1;
      }
    }
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    this.mBindArgs[(paramInt - 1)] = Double.toString(paramDouble);
    if (!this.mClosed) {
      super.bindDouble(paramInt, paramDouble);
    }
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    this.mBindArgs[(paramInt - 1)] = Long.toString(paramLong);
    if (!this.mClosed) {
      super.bindLong(paramInt, paramLong);
    }
  }
  
  public void bindNull(int paramInt)
  {
    this.mBindArgs[(paramInt - 1)] = null;
    if (!this.mClosed) {
      super.bindNull(paramInt);
    }
  }
  
  public void bindString(int paramInt, String paramString)
  {
    this.mBindArgs[(paramInt - 1)] = paramString;
    if (!this.mClosed) {
      super.bindString(paramInt, paramString);
    }
  }
  
  int columnCountLocked()
  {
    acquireReference();
    try
    {
      int i = native_column_count();
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  String columnNameLocked(int paramInt)
  {
    acquireReference();
    try
    {
      String str = native_column_name(paramInt);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  /* Error */
  int fillWindow(CursorWindow paramCursorWindow, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 141	android/os/SystemClock:uptimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getfield 145	net/sqlcipher/database/SQLiteQuery:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   8: invokevirtual 150	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   11: aload_0
    //   12: invokevirtual 122	net/sqlcipher/database/SQLiteQuery:acquireReference	()V
    //   15: aload_1
    //   16: invokevirtual 153	net/sqlcipher/CursorWindow:acquireReference	()V
    //   19: aload_0
    //   20: aload_1
    //   21: aload_1
    //   22: invokevirtual 156	net/sqlcipher/CursorWindow:getStartPosition	()I
    //   25: aload_1
    //   26: invokevirtual 159	net/sqlcipher/CursorWindow:getRequiredPosition	()I
    //   29: aload_0
    //   30: getfield 21	net/sqlcipher/database/SQLiteQuery:mOffsetIndex	I
    //   33: iload_2
    //   34: iload_3
    //   35: invokespecial 161	net/sqlcipher/database/SQLiteQuery:native_fill_window	(Lnet/sqlcipher/CursorWindow;IIIII)I
    //   38: istore_2
    //   39: getstatic 166	net/sqlcipher/database/SQLiteDebug:DEBUG_SQL_STATEMENTS	Z
    //   42: ifeq +41 -> 83
    //   45: new 168	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc -84
    //   58: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: aload_0
    //   65: getfield 179	net/sqlcipher/database/SQLiteQuery:mSql	Ljava/lang/String;
    //   68: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 8
    //   74: aload 4
    //   76: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 186	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_1
    //   84: invokevirtual 187	net/sqlcipher/CursorWindow:releaseReference	()V
    //   87: aload_0
    //   88: invokevirtual 127	net/sqlcipher/database/SQLiteQuery:releaseReference	()V
    //   91: aload_0
    //   92: getfield 145	net/sqlcipher/database/SQLiteQuery:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   95: invokevirtual 190	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   98: iload_2
    //   99: ireturn
    //   100: astore 4
    //   102: goto +15 -> 117
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 145	net/sqlcipher/database/SQLiteQuery:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   111: invokevirtual 193	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   114: aload 4
    //   116: athrow
    //   117: aload_1
    //   118: invokevirtual 187	net/sqlcipher/CursorWindow:releaseReference	()V
    //   121: aload 4
    //   123: athrow
    //   124: aload_1
    //   125: invokevirtual 187	net/sqlcipher/CursorWindow:releaseReference	()V
    //   128: aload_0
    //   129: invokevirtual 127	net/sqlcipher/database/SQLiteQuery:releaseReference	()V
    //   132: aload_0
    //   133: getfield 145	net/sqlcipher/database/SQLiteQuery:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   136: invokevirtual 190	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload_0
    //   143: invokevirtual 127	net/sqlcipher/database/SQLiteQuery:releaseReference	()V
    //   146: aload_0
    //   147: getfield 145	net/sqlcipher/database/SQLiteQuery:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   150: invokevirtual 190	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore 4
    //   157: goto -33 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	SQLiteQuery
    //   0	160	1	paramCursorWindow	CursorWindow
    //   0	160	2	paramInt1	int
    //   0	160	3	paramInt2	int
    //   52	23	4	localStringBuilder	StringBuilder
    //   100	1	4	localObject	Object
    //   105	17	4	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   155	1	4	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   15	83	100	finally
    //   107	117	100	finally
    //   15	83	105	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   11	15	141	finally
    //   83	87	141	finally
    //   117	124	141	finally
    //   124	128	141	finally
    //   15	83	155	java/lang/IllegalStateException
  }
  
  void requery()
  {
    int m;
    int j;
    if (this.mBindArgs != null)
    {
      m = this.mBindArgs.length;
      j = 0;
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.mObjectBindArgs == null) {
          break label160;
        }
        bindArguments(this.mObjectBindArgs);
        return;
      }
      catch (SQLiteMisuseException localSQLiteMisuseException)
      {
        int k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mSql ");
        localStringBuilder.append(this.mSql);
        localStringBuilder = new StringBuilder(localStringBuilder.toString());
        i = j;
        if (i >= m) {
          continue;
        }
        localStringBuilder.append(" ");
        localStringBuilder.append(this.mBindArgs[i]);
        i += 1;
        continue;
        localStringBuilder.append(" ");
        throw new IllegalStateException(localStringBuilder.toString(), localSQLiteMisuseException);
      }
      if (i < m)
      {
        k = i + 1;
        super.bindString(k, this.mBindArgs[i]);
        i = k;
      }
      else
      {
        return;
        label160:
        i = 0;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteQuery: ");
    localStringBuilder.append(this.mSql);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */