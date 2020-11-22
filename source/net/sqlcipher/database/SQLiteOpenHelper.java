package net.sqlcipher.database;

import android.content.Context;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;

public abstract class SQLiteOpenHelper
{
  private static final String TAG = "SQLiteOpenHelper";
  private final Context mContext;
  private SQLiteDatabase mDatabase = null;
  private boolean mDeferSetWriteAheadLoggingEnabled;
  private boolean mEnableWriteAheadLogging;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private final SQLiteDatabaseHook mHook;
  private boolean mIsInitializing = false;
  private final String mName;
  private final int mNewVersion;
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt >= 1)
    {
      if (paramDatabaseErrorHandler != null)
      {
        this.mContext = paramContext;
        this.mName = paramString;
        this.mFactory = paramCursorFactory;
        this.mNewVersion = paramInt;
        this.mHook = paramSQLiteDatabaseHook;
        this.mErrorHandler = paramDatabaseErrorHandler;
        return;
      }
      throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
    }
    paramContext = new StringBuilder();
    paramContext.append("Version must be >= 1, was ");
    paramContext.append(paramInt);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public void close()
  {
    try
    {
      if (!this.mIsInitializing)
      {
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
        {
          this.mDatabase.close();
          this.mDatabase = null;
        }
        return;
      }
      throw new IllegalStateException("Closed during initialization");
    }
    finally {}
  }
  
  public String getDatabaseName()
  {
    return this.mName;
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getReadableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public SQLiteDatabase getReadableDatabase(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 85	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   16: ifeq +12 -> 28
    //   19: aload_0
    //   20: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +440 -> 474
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 110	net/sqlcipher/database/SQLiteOpenHelper:getWritableDatabase	([B)Lnet/sqlcipher/database/SQLiteDatabase;
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: areturn
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   52: ifnull +420 -> 472
    //   55: getstatic 112	net/sqlcipher/database/SQLiteOpenHelper:TAG	Ljava/lang/String;
    //   58: astore 4
    //   60: new 64	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   67: astore 5
    //   69: aload 5
    //   71: ldc 114
    //   73: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: aload_0
    //   80: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   83: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: ldc 116
    //   91: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload_3
    //   103: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: aconst_null
    //   108: astore 5
    //   110: aconst_null
    //   111: astore 4
    //   113: aload 5
    //   115: astore_3
    //   116: aload_0
    //   117: iconst_1
    //   118: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   121: aload 5
    //   123: astore_3
    //   124: aload_0
    //   125: getfield 45	net/sqlcipher/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   128: aload_0
    //   129: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   132: invokevirtual 128	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   135: invokevirtual 133	java/io/File:getPath	()Ljava/lang/String;
    //   138: astore 6
    //   140: aload 5
    //   142: astore_3
    //   143: new 130	java/io/File
    //   146: dup
    //   147: aload 6
    //   149: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore 7
    //   154: aload 5
    //   156: astore_3
    //   157: new 130	java/io/File
    //   160: dup
    //   161: aload_0
    //   162: getfield 45	net/sqlcipher/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   165: aload_0
    //   166: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   169: invokevirtual 128	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   172: invokevirtual 137	java/io/File:getParent	()Ljava/lang/String;
    //   175: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 8
    //   180: aload 5
    //   182: astore_3
    //   183: aload 8
    //   185: invokevirtual 140	java/io/File:exists	()Z
    //   188: ifne +12 -> 200
    //   191: aload 5
    //   193: astore_3
    //   194: aload 8
    //   196: invokevirtual 143	java/io/File:mkdirs	()Z
    //   199: pop
    //   200: aload 5
    //   202: astore_3
    //   203: aload 7
    //   205: invokevirtual 140	java/io/File:exists	()Z
    //   208: ifne +41 -> 249
    //   211: aload 5
    //   213: astore_3
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   219: aload 5
    //   221: astore_3
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual 110	net/sqlcipher/database/SQLiteOpenHelper:getWritableDatabase	([B)Lnet/sqlcipher/database/SQLiteDatabase;
    //   227: astore 4
    //   229: aload_0
    //   230: iconst_1
    //   231: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   234: aload 4
    //   236: invokevirtual 87	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   239: goto +10 -> 249
    //   242: astore_1
    //   243: aload 4
    //   245: astore_3
    //   246: goto +203 -> 449
    //   249: aload 4
    //   251: astore_3
    //   252: aload 6
    //   254: aload_1
    //   255: aload_0
    //   256: getfield 49	net/sqlcipher/database/SQLiteOpenHelper:mFactory	Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
    //   259: iconst_1
    //   260: aload_0
    //   261: getfield 53	net/sqlcipher/database/SQLiteOpenHelper:mHook	Lnet/sqlcipher/database/SQLiteDatabaseHook;
    //   264: aload_0
    //   265: getfield 55	net/sqlcipher/database/SQLiteOpenHelper:mErrorHandler	Lnet/sqlcipher/DatabaseErrorHandler;
    //   268: invokestatic 147	net/sqlcipher/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/database/SQLiteDatabaseHook;Lnet/sqlcipher/DatabaseErrorHandler;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   271: astore 4
    //   273: aload 4
    //   275: invokevirtual 151	net/sqlcipher/database/SQLiteDatabase:getVersion	()I
    //   278: aload_0
    //   279: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   282: if_icmpne +92 -> 374
    //   285: aload_0
    //   286: aload 4
    //   288: invokevirtual 155	net/sqlcipher/database/SQLiteOpenHelper:onOpen	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   291: getstatic 112	net/sqlcipher/database/SQLiteOpenHelper:TAG	Ljava/lang/String;
    //   294: astore_1
    //   295: new 64	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   302: astore_3
    //   303: aload_3
    //   304: ldc -99
    //   306: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_3
    //   311: aload_0
    //   312: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   315: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: ldc -97
    //   322: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_1
    //   327: aload_3
    //   328: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 163	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   334: pop
    //   335: aload_0
    //   336: aload 4
    //   338: putfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   341: aload_0
    //   342: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   345: astore_1
    //   346: aload_0
    //   347: iconst_0
    //   348: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   351: aload 4
    //   353: ifnull +17 -> 370
    //   356: aload 4
    //   358: aload_0
    //   359: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   362: if_acmpeq +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 87	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   370: aload_0
    //   371: monitorexit
    //   372: aload_1
    //   373: areturn
    //   374: new 64	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   381: astore_1
    //   382: aload_1
    //   383: ldc -91
    //   385: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_1
    //   390: aload 4
    //   392: invokevirtual 151	net/sqlcipher/database/SQLiteDatabase:getVersion	()I
    //   395: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_1
    //   400: ldc -89
    //   402: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: aload_0
    //   408: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   411: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_1
    //   416: ldc -87
    //   418: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_1
    //   423: aload 6
    //   425: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: new 107	net/sqlcipher/database/SQLiteException
    //   432: dup
    //   433: aload_1
    //   434: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokespecial 170	net/sqlcipher/database/SQLiteException:<init>	(Ljava/lang/String;)V
    //   440: athrow
    //   441: astore_1
    //   442: aload 4
    //   444: astore_3
    //   445: goto +4 -> 449
    //   448: astore_1
    //   449: aload_0
    //   450: iconst_0
    //   451: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   454: aload_3
    //   455: ifnull +15 -> 470
    //   458: aload_3
    //   459: aload_0
    //   460: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   463: if_acmpeq +7 -> 470
    //   466: aload_3
    //   467: invokevirtual 87	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   470: aload_1
    //   471: athrow
    //   472: aload_3
    //   473: athrow
    //   474: new 89	java/lang/IllegalStateException
    //   477: dup
    //   478: ldc -84
    //   480: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   483: athrow
    //   484: astore_1
    //   485: aload_0
    //   486: monitorexit
    //   487: aload_1
    //   488: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	SQLiteOpenHelper
    //   0	489	1	paramArrayOfByte	byte[]
    //   32	2	2	bool	boolean
    //   42	4	3	localSQLiteDatabase	SQLiteDatabase
    //   47	56	3	localSQLiteException	SQLiteException
    //   115	358	3	localObject1	Object
    //   58	385	4	localObject2	Object
    //   67	153	5	localStringBuilder	StringBuilder
    //   138	286	6	str	String
    //   152	52	7	localFile1	java.io.File
    //   178	17	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   37	43	47	net/sqlcipher/database/SQLiteException
    //   229	239	242	finally
    //   273	346	441	finally
    //   374	441	441	finally
    //   116	121	448	finally
    //   124	140	448	finally
    //   143	154	448	finally
    //   157	180	448	finally
    //   183	191	448	finally
    //   194	200	448	finally
    //   203	211	448	finally
    //   214	219	448	finally
    //   222	229	448	finally
    //   252	273	448	finally
    //   2	24	484	finally
    //   28	33	484	finally
    //   37	43	484	finally
    //   48	107	484	finally
    //   346	351	484	finally
    //   356	370	484	finally
    //   449	454	484	finally
    //   458	470	484	finally
    //   470	472	484	finally
    //   472	474	484	finally
    //   474	484	484	finally
  }
  
  public SQLiteDatabase getReadableDatabase(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      paramArrayOfChar = null;
    }
    try
    {
      paramArrayOfChar = SQLiteDatabase.getBytes(paramArrayOfChar);
      paramArrayOfChar = getReadableDatabase(paramArrayOfChar);
      return paramArrayOfChar;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getWritableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 85	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   23: invokevirtual 185	net/sqlcipher/database/SQLiteDatabase:isReadOnly	()Z
    //   26: ifne +12 -> 38
    //   29: aload_0
    //   30: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: aload_0
    //   39: getfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   42: ifne +330 -> 372
    //   45: aload_0
    //   46: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   56: invokevirtual 188	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   59: aconst_null
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   70: aload 4
    //   72: astore_3
    //   73: aload_0
    //   74: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   77: ifnonnull +16 -> 93
    //   80: aload 4
    //   82: astore_3
    //   83: aconst_null
    //   84: ldc -66
    //   86: invokestatic 194	net/sqlcipher/database/SQLiteDatabase:create	(Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   89: astore_1
    //   90: goto +301 -> 391
    //   93: aload 4
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 45	net/sqlcipher/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   100: aload_0
    //   101: getfield 47	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   104: invokevirtual 128	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   107: invokevirtual 133	java/io/File:getPath	()Ljava/lang/String;
    //   110: astore 5
    //   112: aload 4
    //   114: astore_3
    //   115: new 130	java/io/File
    //   118: dup
    //   119: aload 5
    //   121: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore 6
    //   126: aload 4
    //   128: astore_3
    //   129: aload 6
    //   131: invokevirtual 140	java/io/File:exists	()Z
    //   134: ifne +15 -> 149
    //   137: aload 4
    //   139: astore_3
    //   140: aload 6
    //   142: invokevirtual 198	java/io/File:getParentFile	()Ljava/io/File;
    //   145: invokevirtual 143	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload 5
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 49	net/sqlcipher/database/SQLiteOpenHelper:mFactory	Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
    //   159: aload_0
    //   160: getfield 53	net/sqlcipher/database/SQLiteOpenHelper:mHook	Lnet/sqlcipher/database/SQLiteDatabaseHook;
    //   163: aload_0
    //   164: getfield 55	net/sqlcipher/database/SQLiteOpenHelper:mErrorHandler	Lnet/sqlcipher/DatabaseErrorHandler;
    //   167: invokestatic 202	net/sqlcipher/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;[BLnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Lnet/sqlcipher/database/SQLiteDatabaseHook;Lnet/sqlcipher/DatabaseErrorHandler;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   170: astore_1
    //   171: goto +220 -> 391
    //   174: aload_1
    //   175: astore_3
    //   176: aload_0
    //   177: getfield 204	net/sqlcipher/database/SQLiteOpenHelper:mDeferSetWriteAheadLoggingEnabled	Z
    //   180: ifeq +13 -> 193
    //   183: aload_1
    //   184: astore_3
    //   185: aload_0
    //   186: aload_1
    //   187: invokevirtual 207	net/sqlcipher/database/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   190: putfield 209	net/sqlcipher/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   193: aload_1
    //   194: astore_3
    //   195: aload_0
    //   196: aload_1
    //   197: invokevirtual 212	net/sqlcipher/database/SQLiteOpenHelper:onConfigure	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   200: aload_1
    //   201: astore_3
    //   202: aload_1
    //   203: invokevirtual 151	net/sqlcipher/database/SQLiteDatabase:getVersion	()I
    //   206: istore_2
    //   207: aload_1
    //   208: astore_3
    //   209: iload_2
    //   210: aload_0
    //   211: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   214: if_icmpeq +84 -> 298
    //   217: aload_1
    //   218: astore_3
    //   219: aload_1
    //   220: invokevirtual 215	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   223: iload_2
    //   224: ifne +11 -> 235
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual 218	net/sqlcipher/database/SQLiteOpenHelper:onCreate	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   232: goto +34 -> 266
    //   235: iload_2
    //   236: aload_0
    //   237: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   240: if_icmple +16 -> 256
    //   243: aload_0
    //   244: aload_1
    //   245: iload_2
    //   246: aload_0
    //   247: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   250: invokevirtual 222	net/sqlcipher/database/SQLiteOpenHelper:onDowngrade	(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    //   253: goto +13 -> 266
    //   256: aload_0
    //   257: aload_1
    //   258: iload_2
    //   259: aload_0
    //   260: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   263: invokevirtual 225	net/sqlcipher/database/SQLiteOpenHelper:onUpgrade	(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    //   266: aload_1
    //   267: aload_0
    //   268: getfield 51	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   271: invokevirtual 229	net/sqlcipher/database/SQLiteDatabase:setVersion	(I)V
    //   274: aload_1
    //   275: invokevirtual 232	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   278: aload_1
    //   279: astore_3
    //   280: aload_1
    //   281: invokevirtual 235	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   284: goto +14 -> 298
    //   287: aload_1
    //   288: astore_3
    //   289: aload_1
    //   290: invokevirtual 235	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   293: aload_1
    //   294: astore_3
    //   295: aload 4
    //   297: athrow
    //   298: aload_1
    //   299: astore_3
    //   300: aload_0
    //   301: aload_1
    //   302: invokevirtual 155	net/sqlcipher/database/SQLiteOpenHelper:onOpen	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   305: aload_0
    //   306: iconst_0
    //   307: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   310: aload_0
    //   311: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   314: astore_3
    //   315: aload_3
    //   316: ifnull +17 -> 333
    //   319: aload_0
    //   320: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   323: invokevirtual 87	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   326: aload_0
    //   327: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   330: invokevirtual 238	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   333: aload_0
    //   334: aload_1
    //   335: putfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: aload_0
    //   344: iconst_0
    //   345: putfield 43	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   348: aload_0
    //   349: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   352: ifnull +10 -> 362
    //   355: aload_0
    //   356: getfield 41	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   359: invokevirtual 238	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   362: aload_3
    //   363: ifnull +7 -> 370
    //   366: aload_3
    //   367: invokevirtual 87	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   370: aload_1
    //   371: athrow
    //   372: new 89	java/lang/IllegalStateException
    //   375: dup
    //   376: ldc -16
    //   378: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   381: athrow
    //   382: astore_1
    //   383: aload_0
    //   384: monitorexit
    //   385: aload_1
    //   386: athrow
    //   387: astore_3
    //   388: goto -62 -> 326
    //   391: goto -217 -> 174
    //   394: astore 4
    //   396: goto -109 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	SQLiteOpenHelper
    //   0	399	1	paramArrayOfByte	byte[]
    //   206	53	2	i	int
    //   64	303	3	localObject1	Object
    //   387	1	3	localException	Exception
    //   60	236	4	localObject2	Object
    //   394	1	4	localObject3	Object
    //   110	43	5	str	String
    //   124	17	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   65	70	342	finally
    //   73	80	342	finally
    //   83	90	342	finally
    //   96	112	342	finally
    //   115	126	342	finally
    //   129	137	342	finally
    //   140	149	342	finally
    //   152	171	342	finally
    //   176	183	342	finally
    //   185	193	342	finally
    //   195	200	342	finally
    //   202	207	342	finally
    //   209	217	342	finally
    //   219	223	342	finally
    //   280	284	342	finally
    //   289	293	342	finally
    //   295	298	342	finally
    //   300	305	342	finally
    //   2	34	382	finally
    //   38	59	382	finally
    //   305	315	382	finally
    //   319	326	382	finally
    //   326	333	382	finally
    //   333	338	382	finally
    //   343	362	382	finally
    //   366	370	382	finally
    //   370	372	382	finally
    //   372	382	382	finally
    //   319	326	387	java/lang/Exception
    //   227	232	394	finally
    //   235	253	394	finally
    //   256	266	394	finally
    //   266	278	394	finally
  }
  
  public SQLiteDatabase getWritableDatabase(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      paramArrayOfChar = null;
    }
    try
    {
      paramArrayOfChar = SQLiteDatabase.getBytes(paramArrayOfChar);
      paramArrayOfChar = getWritableDatabase(paramArrayOfChar);
      return paramArrayOfChar;
    }
    finally {}
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Can't downgrade database from version ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    throw new SQLiteException(paramSQLiteDatabase.toString());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    try
    {
      if (this.mEnableWriteAheadLogging != paramBoolean) {
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()) && (!this.mDatabase.isReadOnly()))
        {
          if (paramBoolean) {
            this.mDatabase.enableWriteAheadLogging();
          } else {
            this.mDatabase.disableWriteAheadLogging();
          }
          this.mEnableWriteAheadLogging = paramBoolean;
        }
        else
        {
          this.mDeferSetWriteAheadLoggingEnabled = paramBoolean;
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */