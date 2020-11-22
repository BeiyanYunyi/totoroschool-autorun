package net.sqlcipher.database;

public abstract interface SQLiteTransactionListener
{
  public abstract void onBegin();
  
  public abstract void onCommit();
  
  public abstract void onRollback();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteTransactionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */