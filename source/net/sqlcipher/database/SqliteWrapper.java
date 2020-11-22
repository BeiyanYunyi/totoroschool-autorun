package net.sqlcipher.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public final class SqliteWrapper
{
  private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
  private static final String TAG = "SqliteWrapper";
  
  public static void checkSQLiteException(Context paramContext, SQLiteException paramSQLiteException)
  {
    if (isLowMemory(paramSQLiteException))
    {
      Toast.makeText(paramContext, paramSQLiteException.getMessage(), 0).show();
      return;
    }
    throw paramSQLiteException;
  }
  
  public static int delete(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = paramContentResolver.delete(paramUri, paramString, paramArrayOfString);
      return i;
    }
    catch (SQLiteException paramContentResolver)
    {
      Log.e("SqliteWrapper", "Catch a SQLiteException when delete: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return -1;
  }
  
  public static Uri insert(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues)
  {
    try
    {
      paramContentResolver = paramContentResolver.insert(paramUri, paramContentValues);
      return paramContentResolver;
    }
    catch (SQLiteException paramContentResolver)
    {
      Log.e("SqliteWrapper", "Catch a SQLiteException when insert: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return null;
  }
  
  private static boolean isLowMemory(SQLiteException paramSQLiteException)
  {
    return paramSQLiteException.getMessage().equals("unable to open database file");
  }
  
  public static net.sqlcipher.Cursor query(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      paramContentResolver = (net.sqlcipher.Cursor)paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramContentResolver;
    }
    catch (SQLiteException paramContentResolver)
    {
      Log.e("SqliteWrapper", "Catch a SQLiteException when query: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return null;
  }
  
  public static boolean requery(Context paramContext, android.database.Cursor paramCursor)
  {
    try
    {
      boolean bool = paramCursor.requery();
      return bool;
    }
    catch (SQLiteException paramCursor)
    {
      Log.e("SqliteWrapper", "Catch a SQLiteException when requery: ", paramCursor);
      checkSQLiteException(paramContext, paramCursor);
    }
    return false;
  }
  
  public static int update(Context paramContext, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      int i = paramContentResolver.update(paramUri, paramContentValues, paramString, paramArrayOfString);
      return i;
    }
    catch (SQLiteException paramContentResolver)
    {
      Log.e("SqliteWrapper", "Catch a SQLiteException when update: ", paramContentResolver);
      checkSQLiteException(paramContext, paramContentResolver);
    }
    return -1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SqliteWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */