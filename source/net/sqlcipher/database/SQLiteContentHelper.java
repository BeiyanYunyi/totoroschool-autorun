package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class SQLiteContentHelper
{
  public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
    throws FileNotFoundException
  {
    try
    {
      paramString = simpleQueryForBlobMemoryFile(paramSQLiteDatabase, paramString, paramArrayOfString);
      if (paramString != null)
      {
        paramSQLiteDatabase = paramString.getClass();
        try
        {
          paramSQLiteDatabase = paramSQLiteDatabase.getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase = (ParcelFileDescriptor)paramSQLiteDatabase.invoke(paramString, new Object[0]);
        }
        catch (Exception paramSQLiteDatabase)
        {
          for (;;)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("SQLiteCursor.java: ");
            paramArrayOfString.append(paramSQLiteDatabase);
            Log.i("SQLiteContentHelper", paramArrayOfString.toString());
            paramSQLiteDatabase = null;
          }
        }
        return new AssetFileDescriptor(paramSQLiteDatabase, 0L, paramString.length());
      }
      throw new FileNotFoundException("No results.");
    }
    catch (IOException paramSQLiteDatabase)
    {
      throw new FileNotFoundException(paramSQLiteDatabase.toString());
    }
  }
  
  private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
    throws IOException
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
    if (paramSQLiteDatabase == null) {
      return null;
    }
    try
    {
      boolean bool = paramSQLiteDatabase.moveToFirst();
      if (!bool) {
        return null;
      }
      paramString = paramSQLiteDatabase.getBlob(0);
      if (paramString == null) {
        return null;
      }
      paramArrayOfString = new MemoryFile(null, paramString.length);
      paramArrayOfString.writeBytes(paramString, 0, 0, paramString.length);
      return paramArrayOfString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteContentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */