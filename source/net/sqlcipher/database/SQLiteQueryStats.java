package net.sqlcipher.database;

public class SQLiteQueryStats
{
  long largestIndividualRowSize = 0L;
  long totalQueryResultSize = 0L;
  
  public SQLiteQueryStats(long paramLong1, long paramLong2)
  {
    this.totalQueryResultSize = paramLong1;
    this.largestIndividualRowSize = paramLong2;
  }
  
  public long getLargestIndividualRowSize()
  {
    return this.largestIndividualRowSize;
  }
  
  public long getTotalQueryResultSize()
  {
    return this.totalQueryResultSize;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\SQLiteQueryStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */