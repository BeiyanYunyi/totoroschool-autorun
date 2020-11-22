package net.sqlcipher;

import android.util.Log;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  private final String TAG = getClass().getSimpleName();
  
  private void deleteDatabaseFile(String paramString)
  {
    if (!paramString.equalsIgnoreCase(":memory:"))
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleting the database file: ");
      localStringBuilder.append(paramString);
      Log.e(str, localStringBuilder.toString());
      try
      {
        new File(paramString).delete();
        return;
      }
      catch (Exception paramString)
      {
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete failed: ");
        localStringBuilder.append(paramString.getMessage());
        Log.w(str, localStringBuilder.toString());
        return;
      }
    }
  }
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Corruption reported by sqlite on database, deleting: ");
    localStringBuilder.append(paramSQLiteDatabase.getPath());
    Log.e(str, localStringBuilder.toString());
    if (paramSQLiteDatabase.isOpen())
    {
      Log.e(this.TAG, "Database object for corrupted database is already open, closing");
      try
      {
        paramSQLiteDatabase.close();
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "Exception closing Database object for corrupted database, ignored", localException);
      }
    }
    deleteDatabaseFile(paramSQLiteDatabase.getPath());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\DefaultDatabaseErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */