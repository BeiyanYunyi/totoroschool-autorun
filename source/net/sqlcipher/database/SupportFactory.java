package net.sqlcipher.database;

import androidx.a.a.b;
import androidx.a.a.b.b;

public class SupportFactory
{
  private final boolean clearPassphrase;
  private final SQLiteDatabaseHook hook;
  private final byte[] passphrase;
  
  public SupportFactory(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, (SQLiteDatabaseHook)null);
  }
  
  public SupportFactory(byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramArrayOfByte, paramSQLiteDatabaseHook, true);
  }
  
  public SupportFactory(byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook, boolean paramBoolean)
  {
    this.passphrase = paramArrayOfByte;
    this.hook = paramSQLiteDatabaseHook;
    this.clearPassphrase = paramBoolean;
  }
  
  public b create(b.b paramb)
  {
    return new SupportHelper(paramb, this.passphrase, this.hook, this.clearPassphrase);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SupportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */