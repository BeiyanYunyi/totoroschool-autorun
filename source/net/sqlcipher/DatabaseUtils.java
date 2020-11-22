package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.CursorWindow;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final char[] HEX_DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final boolean LOCAL_LOGV = false;
  private static final String TAG = "DatabaseUtils";
  private static final String[] countProjection = { "count(*)" };
  private static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
        i += 1;
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("NULL");
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        paramStringBuilder.append('1');
        return;
      }
      paramStringBuilder.append('0');
      return;
    }
    appendEscapedSQLString(paramStringBuilder, paramObject.toString());
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      paramSQLiteProgram.bindNull(paramInt);
      return;
    }
    if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float)))
    {
      if ((paramObject instanceof Number))
      {
        paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          paramSQLiteProgram.bindLong(paramInt, 1L);
          return;
        }
        paramSQLiteProgram.bindLong(paramInt, 0L);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
        return;
      }
      paramSQLiteProgram.bindString(paramInt, paramObject.toString());
      return;
    }
    paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(") AND (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
      return;
    }
    paramContentValues.put(paramString2, (Double)null);
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= paramCursor.getCount()) {
        return;
      }
      int j = paramCursor.getPosition();
      int k = paramCursor.getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(k);
      if (paramCursor.moveToPosition(paramInt)) {
        do
        {
          if (!paramCursorWindow.allocRow()) {
            break;
          }
          int i = 0;
          while (i < k)
          {
            int m = paramCursor.getType(i);
            Object localObject;
            boolean bool;
            if (m != 4)
            {
              switch (m)
              {
              default: 
                localObject = paramCursor.getString(i);
                if (localObject != null) {
                  bool = paramCursorWindow.putString((String)localObject, paramInt, i);
                } else {
                  bool = paramCursorWindow.putNull(paramInt, i);
                }
                break;
              case 2: 
                bool = paramCursorWindow.putDouble(paramCursor.getDouble(i), paramInt, i);
                break;
              case 1: 
                bool = paramCursorWindow.putLong(paramCursor.getLong(i), paramInt, i);
                break;
              case 0: 
                bool = paramCursorWindow.putNull(paramInt, i);
                break;
              }
            }
            else
            {
              localObject = paramCursor.getBlob(i);
              if (localObject != null) {
                bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);
              } else {
                bool = paramCursorWindow.putNull(paramInt, i);
              }
            }
            if (!bool)
            {
              paramCursorWindow.freeLastRow();
              break;
            }
            i += 1;
          }
          paramInt += 1;
        } while (paramCursor.moveToNext());
      }
      paramCursor.moveToPosition(j);
      return;
    }
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
      return;
    }
    paramContentValues.put(paramString2, (Integer)null);
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
      return;
    }
    paramContentValues.put(paramString2, (Long)null);
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AbstractWindowedCursor localAbstractWindowedCursor;
    if ((paramCursor instanceof AbstractWindowedCursor)) {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
    } else {
      localAbstractWindowedCursor = null;
    }
    String[] arrayOfString = paramCursor.getColumnNames();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ((localAbstractWindowedCursor != null) && (localAbstractWindowedCursor.isBlob(i))) {
        paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
      } else {
        paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
      }
      i += 1;
    }
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    dumpCurrentRow(paramCursor, System.out);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {");
    paramPrintStream.println(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      paramPrintStream.println(localStringBuilder.toString());
      i += 1;
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {\n");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      paramStringBuilder.append(localStringBuilder.toString());
      i += 1;
    }
    paramStringBuilder.append("}\n");
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    dumpCursor(paramCursor, System.out);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    paramPrintStream.println(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    localStringBuilder.append("\n");
    paramStringBuilder.append(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static char[] encodeHex(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String getCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new String(paramString, 0, getKeyLen(paramString), "ISO8859_1");
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return "";
  }
  
  private static byte[] getCollationKeyInBytes(String paramString)
  {
    if (mColl == null)
    {
      mColl = Collator.getInstance();
      mColl.setStrength(0);
    }
    return mColl.getCollationKey(paramString).toByteArray();
  }
  
  public static String getHexCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    return new String(encodeHex(paramString, HEX_DIGITS_LOWER), 0, getKeyLen(paramString) * 2);
  }
  
  private static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {
      return paramArrayOfByte.length;
    }
    return paramArrayOfByte.length - 1;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer))) {
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int k = paramArrayOfString.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = i + 1;
        bindObjectToProgram(paramSQLiteStatement, j, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForLong();
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query(paramString, countProjection, null, null, null, null, null);
    try
    {
      paramSQLiteDatabase.moveToFirst();
      long l = paramSQLiteDatabase.getLong(0);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
  }
  
  private static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 9: 
      throw new SQLiteException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
    throws FileNotFoundException
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 1)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new FileNotFoundException(str);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
    throws OperationApplicationException
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 10)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new OperationApplicationException(str);
  }
  
  public static String sqlEscapeString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int k = paramArrayOfString.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = i + 1;
        bindObjectToProgram(paramSQLiteStatement, j, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForString();
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    boolean bool = paramException instanceof FileNotFoundException;
    int j = 1;
    int i;
    if (bool)
    {
      i = 1;
      j = 0;
    }
    else if ((paramException instanceof IllegalArgumentException))
    {
      i = 2;
    }
    else if ((paramException instanceof UnsupportedOperationException))
    {
      i = 3;
    }
    else if ((paramException instanceof SQLiteAbortException))
    {
      i = 4;
    }
    else if ((paramException instanceof SQLiteConstraintException))
    {
      i = 5;
    }
    else if ((paramException instanceof SQLiteDatabaseCorruptException))
    {
      i = 6;
    }
    else if ((paramException instanceof SQLiteFullException))
    {
      i = 7;
    }
    else if ((paramException instanceof SQLiteDiskIOException))
    {
      i = 8;
    }
    else if ((paramException instanceof SQLiteException))
    {
      i = 9;
    }
    else
    {
      if (!(paramException instanceof OperationApplicationException)) {
        break label158;
      }
      i = 10;
    }
    paramParcel.writeInt(i);
    paramParcel.writeString(paramException.getMessage());
    if (j != 0) {
      Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
    }
    return;
    label158:
    paramParcel.writeException(paramException);
    Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
  }
  
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    private HashMap<String, Integer> mColumns;
    private final SQLiteDatabase mDb;
    private String mInsertSQL = null;
    private SQLiteStatement mInsertStatement = null;
    private SQLiteStatement mPreparedStatement = null;
    private SQLiteStatement mReplaceStatement = null;
    private final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      this.mDb = paramSQLiteDatabase;
      this.mTableName = paramString;
    }
    
    /* Error */
    private void buildSQL()
      throws SQLException
    {
      // Byte code:
      //   0: new 47	java/lang/StringBuilder
      //   3: dup
      //   4: sipush 128
      //   7: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
      //   10: astore 4
      //   12: aload 4
      //   14: ldc 52
      //   16: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   19: pop
      //   20: aload 4
      //   22: aload_0
      //   23: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   26: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   29: pop
      //   30: aload 4
      //   32: ldc 58
      //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: pop
      //   38: new 47	java/lang/StringBuilder
      //   41: dup
      //   42: sipush 128
      //   45: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
      //   48: astore 5
      //   50: aload 5
      //   52: ldc 60
      //   54: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: pop
      //   58: aload_0
      //   59: getfield 39	net/sqlcipher/DatabaseUtils$InsertHelper:mDb	Lnet/sqlcipher/database/SQLiteDatabase;
      //   62: astore_2
      //   63: new 47	java/lang/StringBuilder
      //   66: dup
      //   67: invokespecial 61	java/lang/StringBuilder:<init>	()V
      //   70: astore_3
      //   71: aload_3
      //   72: ldc 63
      //   74: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: pop
      //   78: aload_3
      //   79: aload_0
      //   80: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   83: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: pop
      //   87: aload_3
      //   88: ldc 65
      //   90: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: pop
      //   94: aload_2
      //   95: aload_3
      //   96: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   99: aconst_null
      //   100: invokevirtual 75	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      //   103: astore_3
      //   104: aload_0
      //   105: new 77	java/util/HashMap
      //   108: dup
      //   109: aload_3
      //   110: invokeinterface 83 1 0
      //   115: invokespecial 84	java/util/HashMap:<init>	(I)V
      //   118: putfield 86	net/sqlcipher/DatabaseUtils$InsertHelper:mColumns	Ljava/util/HashMap;
      //   121: iconst_1
      //   122: istore_1
      //   123: aload_3
      //   124: invokeinterface 90 1 0
      //   129: ifeq +149 -> 278
      //   132: aload_3
      //   133: iconst_1
      //   134: invokeinterface 94 2 0
      //   139: astore_2
      //   140: aload_3
      //   141: iconst_4
      //   142: invokeinterface 94 2 0
      //   147: astore 6
      //   149: aload_0
      //   150: getfield 86	net/sqlcipher/DatabaseUtils$InsertHelper:mColumns	Ljava/util/HashMap;
      //   153: aload_2
      //   154: iload_1
      //   155: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   158: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   161: pop
      //   162: aload 4
      //   164: ldc 106
      //   166: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: pop
      //   170: aload 4
      //   172: aload_2
      //   173: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   176: pop
      //   177: aload 4
      //   179: ldc 106
      //   181: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   184: pop
      //   185: aload 6
      //   187: ifnonnull +14 -> 201
      //   190: aload 5
      //   192: ldc 108
      //   194: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   197: pop
      //   198: goto +27 -> 225
      //   201: aload 5
      //   203: ldc 110
      //   205: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   208: pop
      //   209: aload 5
      //   211: aload 6
      //   213: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: pop
      //   217: aload 5
      //   219: ldc 65
      //   221: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   224: pop
      //   225: iload_1
      //   226: aload_3
      //   227: invokeinterface 83 1 0
      //   232: if_icmpne +93 -> 325
      //   235: ldc 112
      //   237: astore_2
      //   238: goto +3 -> 241
      //   241: aload 4
      //   243: aload_2
      //   244: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   247: pop
      //   248: iload_1
      //   249: aload_3
      //   250: invokeinterface 83 1 0
      //   255: if_icmpne +76 -> 331
      //   258: ldc 114
      //   260: astore_2
      //   261: goto +3 -> 264
      //   264: aload 5
      //   266: aload_2
      //   267: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: pop
      //   271: iload_1
      //   272: iconst_1
      //   273: iadd
      //   274: istore_1
      //   275: goto -152 -> 123
      //   278: aload_3
      //   279: ifnull +9 -> 288
      //   282: aload_3
      //   283: invokeinterface 117 1 0
      //   288: aload 4
      //   290: aload 5
      //   292: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
      //   295: pop
      //   296: aload_0
      //   297: aload 4
      //   299: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   302: putfield 31	net/sqlcipher/DatabaseUtils$InsertHelper:mInsertSQL	Ljava/lang/String;
      //   305: return
      //   306: astore_2
      //   307: goto +6 -> 313
      //   310: astore_2
      //   311: aconst_null
      //   312: astore_3
      //   313: aload_3
      //   314: ifnull +9 -> 323
      //   317: aload_3
      //   318: invokeinterface 117 1 0
      //   323: aload_2
      //   324: athrow
      //   325: ldc 122
      //   327: astore_2
      //   328: goto -87 -> 241
      //   331: ldc 122
      //   333: astore_2
      //   334: goto -70 -> 264
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	337	0	this	InsertHelper
      //   122	153	1	i	int
      //   62	205	2	localObject1	Object
      //   306	1	2	localObject2	Object
      //   310	14	2	localObject3	Object
      //   327	7	2	str1	String
      //   70	248	3	localObject4	Object
      //   10	288	4	localStringBuilder1	StringBuilder
      //   48	243	5	localStringBuilder2	StringBuilder
      //   147	65	6	str2	String
      // Exception table:
      //   from	to	target	type
      //   104	121	306	finally
      //   123	185	306	finally
      //   190	198	306	finally
      //   201	225	306	finally
      //   225	235	306	finally
      //   241	258	306	finally
      //   264	271	306	finally
      //   58	104	310	finally
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
      throws SQLException
    {
      if (paramBoolean)
      {
        if (this.mReplaceStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("INSERT OR REPLACE");
          ((StringBuilder)localObject).append(this.mInsertSQL.substring(6));
          localObject = ((StringBuilder)localObject).toString();
          this.mReplaceStatement = this.mDb.compileStatement((String)localObject);
        }
        return this.mReplaceStatement;
      }
      if (this.mInsertStatement == null)
      {
        if (this.mInsertSQL == null) {
          buildSQL();
        }
        this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
      }
      return this.mInsertStatement;
    }
    
    /* Error */
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_2
      //   4: invokespecial 142	net/sqlcipher/DatabaseUtils$InsertHelper:getStatement	(Z)Lnet/sqlcipher/database/SQLiteStatement;
      //   7: astore 5
      //   9: aload 5
      //   11: invokevirtual 147	net/sqlcipher/database/SQLiteStatement:clearBindings	()V
      //   14: aload_1
      //   15: invokevirtual 153	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   18: invokeinterface 159 1 0
      //   23: astore 6
      //   25: aload 6
      //   27: invokeinterface 164 1 0
      //   32: ifeq +44 -> 76
      //   35: aload 6
      //   37: invokeinterface 168 1 0
      //   42: checkcast 170	java/util/Map$Entry
      //   45: astore 7
      //   47: aload 5
      //   49: aload_0
      //   50: aload 7
      //   52: invokeinterface 173 1 0
      //   57: checkcast 131	java/lang/String
      //   60: invokevirtual 177	net/sqlcipher/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   63: aload 7
      //   65: invokeinterface 180 1 0
      //   70: invokestatic 184	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      //   73: goto -48 -> 25
      //   76: aload 5
      //   78: invokevirtual 188	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
      //   81: lstore_3
      //   82: aload_0
      //   83: monitorexit
      //   84: lload_3
      //   85: lreturn
      //   86: astore_1
      //   87: goto +66 -> 153
      //   90: astore 5
      //   92: new 47	java/lang/StringBuilder
      //   95: dup
      //   96: invokespecial 61	java/lang/StringBuilder:<init>	()V
      //   99: astore 6
      //   101: aload 6
      //   103: ldc -66
      //   105: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   108: pop
      //   109: aload 6
      //   111: aload_1
      //   112: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   115: pop
      //   116: aload 6
      //   118: ldc -61
      //   120: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: aload 6
      //   126: aload_0
      //   127: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   130: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   133: pop
      //   134: ldc -59
      //   136: aload 6
      //   138: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   141: aload 5
      //   143: invokestatic 203	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   146: pop
      //   147: aload_0
      //   148: monitorexit
      //   149: ldc2_w 204
      //   152: lreturn
      //   153: aload_0
      //   154: monitorexit
      //   155: aload_1
      //   156: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	InsertHelper
      //   0	157	1	paramContentValues	ContentValues
      //   0	157	2	paramBoolean	boolean
      //   81	4	3	l	long
      //   7	70	5	localSQLiteStatement	SQLiteStatement
      //   90	52	5	localSQLException	SQLException
      //   23	114	6	localObject	Object
      //   45	19	7	localEntry	java.util.Map.Entry
      // Exception table:
      //   from	to	target	type
      //   2	25	86	finally
      //   25	73	86	finally
      //   76	82	86	finally
      //   92	147	86	finally
      //   2	25	90	net/sqlcipher/SQLException
      //   25	73	90	net/sqlcipher/SQLException
      //   76	82	90	net/sqlcipher/SQLException
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramDouble);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramFloat);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      this.mPreparedStatement.bindLong(paramInt1, paramInt2);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      this.mPreparedStatement.bindLong(paramInt, paramLong);
    }
    
    public void bind(int paramInt, String paramString)
    {
      if (paramString == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        return;
      }
      this.mPreparedStatement.bindString(paramInt, paramString);
    }
    
    public void bind(int paramInt, boolean paramBoolean)
    {
      SQLiteStatement localSQLiteStatement = this.mPreparedStatement;
      long l;
      if (paramBoolean) {
        l = 1L;
      } else {
        l = 0L;
      }
      localSQLiteStatement.bindLong(paramInt, l);
    }
    
    public void bind(int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        return;
      }
      this.mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
    }
    
    public void bindNull(int paramInt)
    {
      this.mPreparedStatement.bindNull(paramInt);
    }
    
    public void close()
    {
      if (this.mInsertStatement != null)
      {
        this.mInsertStatement.close();
        this.mInsertStatement = null;
      }
      if (this.mReplaceStatement != null)
      {
        this.mReplaceStatement.close();
        this.mReplaceStatement = null;
      }
      this.mInsertSQL = null;
      this.mColumns = null;
    }
    
    /* Error */
    public long execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   4: ifnull +78 -> 82
      //   7: aload_0
      //   8: getfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   11: invokevirtual 188	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
      //   14: lstore_1
      //   15: aload_0
      //   16: aconst_null
      //   17: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   20: lload_1
      //   21: lreturn
      //   22: astore_3
      //   23: goto +52 -> 75
      //   26: astore_3
      //   27: new 47	java/lang/StringBuilder
      //   30: dup
      //   31: invokespecial 61	java/lang/StringBuilder:<init>	()V
      //   34: astore 4
      //   36: aload 4
      //   38: ldc -24
      //   40: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: pop
      //   44: aload 4
      //   46: aload_0
      //   47: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   50: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: pop
      //   54: ldc -59
      //   56: aload 4
      //   58: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: aload_3
      //   62: invokestatic 203	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   65: pop
      //   66: aload_0
      //   67: aconst_null
      //   68: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   71: ldc2_w 204
      //   74: lreturn
      //   75: aload_0
      //   76: aconst_null
      //   77: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   80: aload_3
      //   81: athrow
      //   82: new 234	java/lang/IllegalStateException
      //   85: dup
      //   86: ldc -20
      //   88: invokespecial 239	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   91: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	InsertHelper
      //   14	7	1	l	long
      //   22	1	3	localObject	Object
      //   26	55	3	localSQLException	SQLException
      //   34	23	4	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   7	15	22	finally
      //   27	66	22	finally
      //   7	15	26	net/sqlcipher/SQLException
    }
    
    public int getColumnIndex(String paramString)
    {
      getStatement(false);
      Object localObject = (Integer)this.mColumns.get(paramString);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("column '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("' is invalid");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public long insert(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, false);
    }
    
    public void prepareForInsert()
    {
      this.mPreparedStatement = getStatement(false);
      this.mPreparedStatement.clearBindings();
    }
    
    public void prepareForReplace()
    {
      this.mPreparedStatement = getStatement(true);
      this.mPreparedStatement.clearBindings();
    }
    
    public long replace(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, true);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\DatabaseUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */