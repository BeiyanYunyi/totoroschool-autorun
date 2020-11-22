package net.sqlcipher.database;

import android.content.Context;
import androidx.a.a.a;
import androidx.a.a.b;
import androidx.a.a.b.a;
import androidx.a.a.b.b;

public class SupportHelper
  implements b
{
  private final boolean clearPassphrase;
  private byte[] passphrase;
  private SQLiteOpenHelper standardHelper;
  
  SupportHelper(final b.b paramb, byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook, boolean paramBoolean)
  {
    SQLiteDatabase.loadLibs(paramb.a);
    this.passphrase = paramArrayOfByte;
    this.clearPassphrase = paramBoolean;
    this.standardHelper = new SQLiteOpenHelper(paramb.a, paramb.b, null, paramb.c.a, paramSQLiteDatabaseHook)
    {
      public void onConfigure(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramb.c.a(paramAnonymousSQLiteDatabase);
      }
      
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramb.c.b(paramAnonymousSQLiteDatabase);
      }
      
      public void onDowngrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramb.c.b(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public void onOpen(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramb.c.c(paramAnonymousSQLiteDatabase);
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramb.c.a(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public void close()
  {
    this.standardHelper.close();
  }
  
  public String getDatabaseName()
  {
    return this.standardHelper.getDatabaseName();
  }
  
  public a getReadableDatabase()
  {
    return getWritableDatabase();
  }
  
  public a getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.standardHelper.getWritableDatabase(this.passphrase);
      if ((this.clearPassphrase) && (this.passphrase != null))
      {
        i = 0;
        while (i < this.passphrase.length)
        {
          this.passphrase[i] = 0;
          i += 1;
        }
      }
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      int i;
      if (this.passphrase != null)
      {
        byte[] arrayOfByte = this.passphrase;
        int k = arrayOfByte.length;
        int j = 0;
        i = 1;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if ((i != 0) && (m == 0)) {
            i = 1;
          } else {
            i = 0;
          }
          j += 1;
        }
        if (i != 0) {
          throw new IllegalStateException("The passphrase appears to be cleared. This happens bydefault the first time you use the factory to open a database, so we can remove thecleartext passphrase from memory. If you close the database yourself, please use afresh SupportFactory to reopen it. If something else (e.g., Room) closed thedatabase, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", localSQLiteException);
        }
      }
      throw localSQLiteException;
    }
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    this.standardHelper.setWriteAheadLoggingEnabled(paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SupportHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */